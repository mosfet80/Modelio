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
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.model.frozen.FrozenLimitsSpec;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.platform.utils.log.writers.PluginLogger;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Handles BFS-level traversal for {@link org.modelio.platform.query.api.model.resolved.ResolvedStep.RepeatStep} steps.
 * Implements cycle detection, maxDepth enforcement, emitAllDepths support, and global visited tracking.
 */
@objid ("340574b4-e18d-4a3b-80c2-e526a709b60f")
final class RepeatStepExecutor {
    @objid ("8049d2ee-4565-4b71-b327-3f404ead5d06")
    private static final PluginLogger LOG = SearchEngine.LOG;

    @objid ("63a0ae55-c897-4af3-b583-7418a624c0a7")
    private RepeatStepExecutor() {
        // utility class
    }

    /**
     * Wraps a repeat step: performs BFS-level traversal from each source item,
     * using the body sub-chain at each depth level, with cycle detection and maxDepth enforcement.
     * <p>
     * Behaviour summary:
     * <ul>
     * <li>Source node is NOT emitted (source exclusion).</li>
     * <li>A global visited set prevents re-visiting any node already seen by any Repeat step.</li>
     * <li>Cycle detection emits a {@code CYCLE_DETECTED} WARNING once per closing node.</li>
     * <li>{@code emitAllDepths=true} (default): emits nodes at every depth level.</li>
     * <li>{@code emitAllDepths=false}: emits only the deepest reachable frontier nodes.</li>
     * <li>{@code maxDepth} (from {@link FrozenLimitsSpec}): caps the traversal depth.</li>
     * </ul>
     */
    @objid ("fa9c737e-423a-4aed-99cd-6f318435900e")
    static Consumer<TraversalItem> wrapRepeat(RepeatStep repeat, Consumer<TraversalItem> downstream, ICoreSession session, FrozenLimitsSpec limits, Set<MObject> globalVisited, IQueryResponseFiller diagnosticSink) {
        // maxDepth validation at wrap time
        final Integer maxDepth = (limits != null) ? limits.maxDepth() : null;
        if (maxDepth != null && maxDepth < 1) {
            diagnosticSink.pushDiagnostic(Diagnostics.error(
                    DiagnosticCode.EXECUTION_TRUNCATED,
                    SearchEngine.I18N.getMessage("MQL.executor.repeat.maxdepth.invalid", maxDepth)));
            return item -> {}; // swallowing consumer
        }
        if (maxDepth != null && maxDepth == 1) {
            diagnosticSink.pushDiagnostic(Diagnostics.warning(
                    DiagnosticCode.EXECUTION_TRUNCATED,
                    SearchEngine.I18N.getMessage("MQL.executor.repeat.maxdepth.suspicious")));
        }

        return sourceItem -> {
            final MObject sourceElement = sourceItem.node();

            // Source exclusion: mark source as visited so it won't be re-discovered
            globalVisited.add(sourceElement);

            // Per-invocation cycle tracking (deduplicated per source item)
            final Set<MObject> cycleReported = new HashSet<>();

            // BFS level-by-level traversal
            List<TraversalItem> frontier = new ArrayList<>();
            frontier.add(sourceItem);

            for (int depth = 1; ; depth++) {
                final List<TraversalItem> nextFrontier = new ArrayList<>();

                for (TraversalItem frontierItem : frontier) {
                    // Execute the body sub-chain on this frontier item and collect results
                    final List<TraversalItem> bodyOutput =
                            StepPipelineExecutor.executeToList(repeat.body(), List.of(frontierItem), session);

                    for (TraversalItem discovered : bodyOutput) {
                        final MObject discoveredEl = discovered.node();

                        // Cycle detection: check if the discovered node is already in the
                        // frontier item's traversal path (i.e., it's an ancestor)
                        final boolean inCurrentPath = frontierItem.path().nodes().contains(discoveredEl);
                        if (inCurrentPath) {
                            if (cycleReported.add(discoveredEl)) {
                                diagnosticSink.pushDiagnostic(Diagnostics.warning(
                                        DiagnosticCode.CYCLE_DETECTED,
                                        SearchEngine.I18N.getMessage("MQL.executor.cycle.detected", discovered.node().getName())));
                            }
                            continue; // skip — cycle node
                        }

                        // Convergence check: skip if already globally visited (from any branch)
                        if (!globalVisited.add(discoveredEl)) {
                            continue;
                        }

                        // New node discovered at this depth
                        if (repeat.emitAllDepths()) {
                            downstream.accept(discovered);
                        }
                        nextFrontier.add(discovered);
                    }
                }

                // NOTE (Finding 1): When emitAllDepths=false and depth==1, if nextFrontier is empty because
                // ALL body results were already in globalVisited, the depth > 1 guard prevents emission.
                // This is correct: the source node should not be emitted, and no new frontier exists.
                // A pipeline with two RepeatSteps sharing globalVisited can produce zero results for
                // the second step's source — this is accepted behaviour, not a bug.
                if (nextFrontier.isEmpty()) {
                    // Case c: natural stop — no new nodes could be discovered.
                    // frontier holds the deepest reachable nodes.
                    // If emitAllDepths=false, emit them now (but not the initial source).
                    if (!repeat.emitAllDepths() && depth > 1) { // depth > 1 excludes source: at depth==1, frontier == [sourceItem] (the initial seed)
                        for (TraversalItem item : frontier) {
                            downstream.accept(item);
                        }
                    }
                    break;
                }

                if (maxDepth != null && depth >= maxDepth) {
                    // Case d: maxDepth reached — emit nextFrontier if emitAllDepths=false
                    if (!repeat.emitAllDepths()) {
                        for (TraversalItem item : nextFrontier) {
                            downstream.accept(item);
                        }
                    }
                    break;
                }

                frontier = nextFrontier;
            }
        };
    }

}
