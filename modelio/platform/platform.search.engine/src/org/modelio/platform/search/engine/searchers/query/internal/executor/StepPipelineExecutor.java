/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.platform.search.engine.searchers.query.internal.executor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.UnionStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.UnsupportedStep;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.api.model.result.NodeWithExplainOut;
import org.modelio.platform.search.engine.searchers.query.api.model.result.QueryCompletionStatus;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Builds and executes push-based pipelines of {@link ResolvedStep resolved steps}.
 * <p>
 * Each step wraps a {@link Consumer Consumer&lt;TraversalItem&gt;} downstream, forming a
 * chain from the first step to a terminal consumer. Source items enter the chain head
 * as {@link TraversalItem} instances and flow through each step.
 * <p>
 * The pipeline is a pure stream of (node, path) pairs. The terminal consumer emits one
 * {@link NodeWithExplainOut} per {@link TraversalItem} immediately as it arrives, with
 * UUID-based budget enforcement (unique nodes count against the budget; subsequent paths
 * for an already-seen node are free). Deduplication and grouping are the responsibility
 * of the response layer (e.g. {@code SyncQueryResponse}).
 */
@objid ("1f47c5ff-771e-4f49-a6f0-2e55eb04e658")
public final class StepPipelineExecutor {
    @objid ("8f20d567-0604-4f46-b02a-395ed8eb4373")
    private static final PluginLogger LOG = SearchEngine.LOG;

    /**
     * Pre-completed state future for the NOOP diagnostic sink.
     * Cached so that {@code NOOP_DIAGNOSTIC_SINK.getState()} always returns the same instance,
     * satisfying the {@link IQueryResponseFiller} identity contract.
     */
    @objid ("55dbbaca-4a01-417f-8fb3-287edcfca4da")
    private static final CompletableFuture<QueryCompletionStatus> NOOP_STATE = CompletableFuture.completedFuture(QueryCompletionStatus.ENDED);

    /**
     * No-op diagnostic sink used for EXISTS sub-query pipelines where diagnostics are discarded.
     */
    @objid ("95804274-b65d-4018-bd81-82c21389b805")
    public static final IQueryResponseFiller NOOP_DIAGNOSTIC_SINK = new IQueryResponseFiller() {

        @Override
        public void pushItem(TraversalItem item) { /* no-op */ }

        @Override
        public void pushDiagnostic(Diagnostic diagnostic) { /* no-op */ }

        @Override
        public void setTruncated() { /* no-op */ }

        @Override
        public CompletableFuture<QueryCompletionStatus> getState() {
            return NOOP_STATE;
        }

        @Override
        public void complete() { /* no-op */ }
    };

    @objid ("b546bf62-e843-4efe-9151-b5eaa6290925")
    private StepPipelineExecutor() {
        // utility class
    }

    /**
     * Builds a push-based pipeline that processes items through the resolved steps
     * and streams results into the downstream filler.
     * <p>
     * Each step wraps a {@link Consumer Consumer&lt;TraversalItem&gt;} that processes items
     * one-by-one and pushes matching/derived items to the next step.
     * <p>
     * Returns an {@link IQueryResponseFiller} whose {@code pushItem()} iterates all source
     * paths into the chain head. The terminal consumer emits one {@link NodeWithExplainOut}
     * per (node, path) pair with UUID-based budget enforcement: unique nodes count against
     * the budget; subsequent paths for an already-seen node are emitted for free.
     *
     * @param steps the resolved steps to chain
     * @param session the core session
     * @param downstream the response filler to push results into
     * @param limits the execution limits (maxDepth, etc.) applied to Repeat steps; may be null
     * @return an {@link IQueryResponseFiller} whose {@code pushItem()} feeds the chain head
     */
    @objid ("e2ad9c6b-9788-4a19-8351-08556c8fdc0a")
    public static IQueryResponseFiller buildPipeline(List<ResolvedStep> steps, ICoreSession session, IQueryResponseFiller downstream, FrozenLimitsSpec limits) {
        // Execution budget: enforces item limit and timeout on unique (post-dedup) items
        ExecutionBudget budget = new ExecutionBudget(
                limits != null ? limits.limit() : null,
                limits != null ? limits.timeoutMs() : null);
        boolean[] truncationFired = { false };

        // UUID-based dedup: tracks nodes already emitted to downstream.
        // Only the first path for a given node counts against the budget;
        // subsequent paths for the same node are emitted for free.
        Set<String> emittedNodeUuids = new HashSet<>();

        // Global visited set shared across all Repeat steps in this pipeline
        Set<MObject> globalVisited = new HashSet<>();

        // Terminal consumer: emits one NodeWithExplainOut per (node, path) pair immediately.
        Consumer<TraversalItem> terminal = item -> {
            if (downstream.isComplete()) {
                return;
            }
            String uuid = item.node().getUuid();
            boolean isNewNode = emittedNodeUuids.add(uuid);
            if (isNewNode && !budget.tryAccept()) {
                emittedNodeUuids.remove(uuid); // rollback: node was not accepted
                if (!truncationFired[0]) {
                    truncationFired[0] = true;
                    downstream.setTruncated();
                    downstream.pushDiagnostic(Diagnostics.info(DiagnosticCode.EXECUTION_TRUNCATED,
                            budget.getExhaustionCause()));
                }
                return;
            }
            downstream.pushItem(item);
        };

        Consumer<TraversalItem> chainHead = buildChain(steps, terminal, session, limits, globalVisited, downstream);

        return new IQueryResponseFiller() {
            @Override
            public void pushItem(TraversalItem item) {
                if (isComplete()) {
                    return;
                }
                chainHead.accept(item);
            }

            @Override
            public boolean isComplete() {
                return budget.isExhausted() || downstream.isComplete();
            }

            @Override
            public void complete() {
                // Pure streaming: nothing to flush.
            }

            @Override
            public void pushDiagnostic(Diagnostic diagnostic) {
                downstream.pushDiagnostic(diagnostic);
            }

            @Override
            public void setTruncated() {
                downstream.setTruncated();
            }

            @Override
            public CompletableFuture<QueryCompletionStatus> getState() {
                return downstream.getState();
            }
        };
    }

    /**
     * Executes the step pipeline by collecting results into a list.
     * <p>
     * Used exclusively for "EXISTS" sub-queries where input is a small scope (typically a single element).
     * No flush or {@code complete()} call is performed.
     *
     * @param steps the resolved steps to execute
     * @param input the input items
     * @param session the core session
     * @return the collected list of result items
     */
    @objid ("59a8763f-0a5d-43bf-9718-9bb1666bbf61")
    static List<TraversalItem> executeToList(List<ResolvedStep> steps, List<TraversalItem> input, ICoreSession session) {
        List<TraversalItem> results = new ArrayList<>();
        Consumer<TraversalItem> chainHead = buildChain(steps, results::add, session, null, new HashSet<>(), NOOP_DIAGNOSTIC_SINK);
        for (TraversalItem item : input) {
            chainHead.accept(item);
        }
        return results;
    }

    // -----------------------------------------------------------------------
    // Chain construction
    // -----------------------------------------------------------------------
    /**
     * Builds a consumer chain by wrapping steps in reverse order around the terminal consumer.
     *
     * @param steps the resolved steps to chain (first step = outermost wrapper)
     * @param terminal the terminal consumer at the end of the chain
     * @param session the core session
     * @param limits execution limits for Repeat steps (may be null)
     * @param globalVisited UUID set shared across all Repeat steps (may be empty but not null)
     * @param diagnosticSink sink for diagnostics emitted during execution
     * @return the chain head consumer
     */
    @objid ("4004cdb2-a7bb-4c08-a777-98be64465321")
    private static Consumer<TraversalItem> buildChain(List<ResolvedStep> steps, Consumer<TraversalItem> terminal, ICoreSession session, FrozenLimitsSpec limits, Set<MObject> globalVisited, IQueryResponseFiller diagnosticSink) {
        Consumer<TraversalItem> current = terminal;
        for (int i = steps.size() - 1; i >= 0; i--) {
            current = wrapStep(steps.get(i), current, session, limits, globalVisited, diagnosticSink);
        }
        return current;
    }

    /**
     * Dispatches a single step to its dedicated wrapper method.
     */
    @objid ("38e9b69b-b322-441c-a2ce-cdd768b9fd21")
    private static Consumer<TraversalItem> wrapStep(ResolvedStep step, Consumer<TraversalItem> downstream, ICoreSession session, FrozenLimitsSpec limits, Set<MObject> globalVisited, IQueryResponseFiller diagnosticSink) {
        return switch (step) {
            case FilterStep f -> wrapFilter(f, downstream, session);
            case TraverseStep t -> TraverseStepExecutor.wrapTraverse(t, downstream, session);
            case UnionStep u -> wrapUnion(u, downstream, session, limits, globalVisited, diagnosticSink);
            case RepeatStep r -> RepeatStepExecutor.wrapRepeat(r, downstream, session, limits, globalVisited, diagnosticSink);
            case UnsupportedStep us -> {
                LOG.warning("UnsupportedStep encountered: %s. Swallowing items.", us.description());
                yield item -> {};
            }
        };
    }

    // -----------------------------------------------------------------------
    // Filter step
    // -----------------------------------------------------------------------
    /**
     * Wraps a filter step: passes items downstream only if the predicate evaluates to true.
     */
    @objid ("ac085dc1-50c4-4020-ba7f-2084767067ee")
    private static Consumer<TraversalItem> wrapFilter(FilterStep filter, Consumer<TraversalItem> downstream, ICoreSession session) {
        return item -> {
            if (ExpressionEvaluator.evaluate(filter.predicate(), item.node(), session)) {
                downstream.accept(item);
            }
        };
    }

    // -----------------------------------------------------------------------
    // Union step
    // -----------------------------------------------------------------------
    /**
     * Wraps a union step: for each input item, feeds it to every branch sub-pipeline.
     * <p>
     * Branch head consumers are pre-built once and reused for every input item.
     * Output is interleaved per-item (branch 1 results, then branch 2 results, etc.).
     * Deduplication is NOT performed here - it happens at the pipeline terminal.
     */
    @objid ("00edb9bc-2f13-4a18-80cf-f716e6f197c4")
    private static Consumer<TraversalItem> wrapUnion(UnionStep union, Consumer<TraversalItem> downstream, ICoreSession session, FrozenLimitsSpec limits, Set<MObject> globalVisited, IQueryResponseFiller diagnosticSink) {
        List<List<ResolvedStep>> branches = union.branches();

        if (branches.isEmpty()) {
            LOG.debug("UnionStep: empty branch list, swallowing items");
            return item -> {};
        }

        // Pre-build branch head consumers
        List<Consumer<TraversalItem>> branchHeads = new ArrayList<>(branches.size());
        for (List<ResolvedStep> branch : branches) {
            branchHeads.add(buildChain(branch, downstream, session, limits, globalVisited, diagnosticSink));
        }

        LOG.debug("UnionStep: %d branch(es) pre-built", Integer.valueOf(branches.size()));

        return item -> {
            for (Consumer<TraversalItem> branchHead : branchHeads) {
                branchHead.accept(item);
            }
        };
    }

}
