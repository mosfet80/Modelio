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
package org.modelio.platform.search.engine.searchers.query.internal.resolver;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.search.engine.plugin.SearchEngine;
import org.modelio.platform.search.engine.searchers.query.api.IQueryResolver;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AllSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Source;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.UnionStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ExprResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.KindResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.QueryResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolutionLimits;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedEdge;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedKind;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedProperty;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedQuery;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedSource;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.ResolvedStep;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.SourceResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.StepResolutionResult;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedAndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedCompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedIsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedNotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedOrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedPropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.resolved.expr.ResolvedValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.search.engine.searchers.query.internal.resolver.diagnostics.Diagnostics;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Resolver entry point: converts public unresolved Query AST into an internal resolved query model.
 */
@objid ("4a43a4f4-89ae-4bf6-b5ca-332cb86cf048")
public final class QueryResolver implements IQueryResolver {
    @objid ("546c262d-b9d4-4a2a-baad-9010364855c6")
    private final KindResolver kindResolver;

    @objid ("7e7a663f-4808-4c7a-8415-ca2da587465d")
    private final EdgeRegistry edgeRegistry;

    @objid ("246a5e5b-7361-47de-be20-4b1ec74b2891")
    private final EdgeResolver edgeResolver;

    @objid ("399e0cbf-8f1a-4b0a-8a9b-37ac99d1bc90")
    private final PropertyKeyRegistry propertyKeyRegistry;

    @objid ("2e447a50-c4a7-4265-ac99-d9a409bde5ad")
    private final PropertyKeyResolver propertyKeyResolver;

    @objid ("5403cc19-2ff3-4ea1-8c09-c7b956ba604e")
    private final ResolverContext resolverContext;

    /**
     * Default constructor, using the provided session to access model information during resolution.
     *
     * @param session the session to use for model access during resolution
     */
    @objid ("a7c6cb1e-86fb-4e8f-b690-715ae01b25b4")
    public QueryResolver(ICoreSession session) {
        this(new DefaultResolverContext(session));
    }

    /**
     * Automatic tests constructor, using the provided resolver context to access model information during resolution.
     *
     * @param context the resolver context to use for model access during resolution.
     */
    @objid ("e93cd05e-3174-4c86-9fd1-70ab73e95969")
    public QueryResolver(ResolverContext context) {
        this.resolverContext = context;
        this.kindResolver = new KindResolver(context);
        this.edgeRegistry = new EdgeRegistry(context);
        this.edgeResolver = new EdgeResolver(this.edgeRegistry);
        this.propertyKeyRegistry = new PropertyKeyRegistry(context);
        this.propertyKeyResolver = new PropertyKeyResolver(this.propertyKeyRegistry);
    }

    /**
     * Resolves the given query using the provided session to access model information.
     *
     * @param query the query to resolve
     * @param session the session to use for model access
     * @return the resolution result, containing the resolved query and any diagnostics generated during resolution
     */
    @objid ("2c829072-4e36-41f6-a4c4-6427121f2a9b")
    public static QueryResolutionResult resolve(Query query, ICoreSession session) {
        return resolve(query, new DefaultResolverContext(session));
    }

    /**
     * Resolves the given query using the provided resolver context to access model information.
     * <p>
     * This method should only be used for testing purposes, as it allows to provide a custom resolver context that can be mocked or stubbed.
     *
     * @param query the query to resolve
     * @param context the resolver context to use for model access
     * @return the resolution result, containing the resolved query and any diagnostics generated during resolution
     */
    @objid ("3cd690c7-e1ed-4e66-92a3-650bd95a2f39")
    public static QueryResolutionResult resolve(Query query, ResolverContext context) {
        if (query == null) {
            throw new IllegalArgumentException("query must not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }

        QueryResolver resolver = new QueryResolver(context);
        return resolver.resolveQuery(query);
    }

    /**
     * Resolves the given query into a {@link ResolvedQuery}, collecting per-step diagnostics and implementing error resilience.
     * <p>
     * Every AST node gets its own diagnostics list. The resolver never throws — all failures become diagnostics.
     * Null/blank required fields emit {@code REQUIRED_FIELD_MISSING}. Unresolvable output kinds stop downstream resolution.
     *
     * @param query the query to resolve
     * @return the resolution result, containing the resolved query, per-step results, and any diagnostics generated during resolution
     */
    @objid ("9e5e4d89-7ec3-40e6-8fc4-0c3df5dfafad")
    @Override
    public QueryResolutionResult resolveQuery(Query query) {
        // 1. Resolve source with dedicated diagnostics
        final SourceResolutionResult sourceResult = resolveSource(query.getSource());
        final ResolvedKind initialKind = resolveInitialKind(sourceResult.resolved());

        // 2. Resolve steps with per-step breakdown
        final Map<Step, StepResolutionResult> stepResults = new IdentityHashMap<>();
        final List<ResolvedStep> resolvedSteps = new ArrayList<>();
        resolveStepsWithBreakdown(query.getSteps(), initialKind, stepResults, resolvedSteps, 0);

        // 3. Collect flat diagnostics list (union of source + all step diagnostics)
        final List<Diagnostic> allDiagnostics = new ArrayList<>(sourceResult.diagnostics());
        for (StepResolutionResult sr : stepResults.values()) {
            allDiagnostics.addAll(sr.diagnostics());
        }

        // 4. Build result
        final ResolvedSource resolvedSource = (sourceResult.resolved() != null)
                ? sourceResult.resolved()
                : new ResolvedSource.ProvidedSource(List.of());
        final ResolvedQuery resolvedQuery = new ResolvedQuery(resolvedSource, List.copyOf(resolvedSteps), query.getLimits().freeze());

        return new QueryResolutionResult(resolvedQuery, allDiagnostics, sourceResult, stepResults);
    }

    /**
     * Resolves a list of steps with per-step diagnostic breakdown.
     * <p>
     * Populates {@code stepResults} and {@code resolvedSteps} in-place. Stops downstream resolution
     * when a step is unresolvable (i.e., its resolved is null) or when the output kind cannot be determined
     * (and the step does not preserve input kind). Remaining steps are absent from the result map.
     *
     * @param steps the list of steps to resolve
     * @param initialKind the initial input kind for the first step
     * @param stepResults accumulates per-step results (identity-keyed, mutated in-place)
     * @param resolvedSteps accumulates successfully resolved steps (mutated in-place)
     * @param depth current nesting depth (for depth-limit diagnostics)
     */
    @objid ("56a20cfd-7d85-4ad0-bba7-3267cca5bb78")
    private void resolveStepsWithBreakdown(List<Step> steps, ResolvedKind initialKind, Map<Step, StepResolutionResult> stepResults, List<ResolvedStep> resolvedSteps, int depth) {
        if (steps == null || steps.isEmpty()) {
            return;
        }

        // Hard depth limit — emit ERROR on first step and stop
        if (depth >= ResolutionLimits.ERROR_DEPTH) {
            final List<Diagnostic> depthDiag = List.of(Diagnostics.error(
                    DiagnosticCode.RESOLUTION_ERROR,
                    SearchEngine.I18N.getMessage("MQL.resolver.depth.error", depth, ResolutionLimits.ERROR_DEPTH)));
            stepResults.put(steps.get(0), new StepResolutionResult(steps.get(0), null, depthDiag));
            return;
        }

        ResolvedKind currentKind = (initialKind == null) ? ResolvedKind.any() : initialKind;

        for (Step step : steps) {
            final StepResolutionResult result = resolveStepSafe(step, currentKind, depth, stepResults);
            stepResults.put(step, result);

            if (result.resolved() == null) {
                // Unresolvable step (REQUIRED_FIELD_MISSING or exception) — stop downstream resolution
                break;
            }

            resolvedSteps.add(result.resolved());

            // Determine next input kind — continue with empty kind if output kind is unknown
            final ResolvedKind outputKind = result.resolved().outputKind();
            if (!isKindPreservingStep(step) && outputKind != null && !outputKind.isNone() /*&& !outputKind.isUnknown()*/) {
                currentKind = outputKind;
            }
            // kind-preserving step OR unknown outputKind: keep currentKind unchanged
        }
    }

    /**
     * Resolves a single step with error resilience: never throws, wraps all exceptions as ERROR diagnostics.
     *
     * @param step the step to resolve
     * @param currentKind the current input kind
     * @param depth current nesting depth for depth-limit diagnostics
     * @param stepResults the accumulator for nested step results (used by union/repeat)
     * @return the per-step resolution result for this step
     */
    @objid ("ed78321a-b80c-4fdd-9de3-a548aa395e20")
    private StepResolutionResult resolveStepSafe(Step step, ResolvedKind currentKind, int depth, Map<Step, StepResolutionResult> stepResults) {
        final List<Diagnostic> diagnostics = new ArrayList<>();

        // Soft depth warning
        if (depth >= ResolutionLimits.WARNING_DEPTH && depth < ResolutionLimits.ERROR_DEPTH) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.RESOLUTION_ERROR,
                    SearchEngine.I18N.getMessage("MQL.resolver.depth.warning", depth, ResolutionLimits.WARNING_DEPTH)));
        }

        try {
            final ResolvedStep resolved = switch (step) {
                case FilterStep filterStep -> resolveFilterStepSafe(filterStep, currentKind, diagnostics);
                case TraverseStep traverseStep -> resolveTraverseStepSafe(traverseStep, currentKind, diagnostics);
                case UnionStep unionStep -> resolveUnionStepSafe(unionStep, currentKind, diagnostics, depth, stepResults);
                case RepeatStep repeatStep -> resolveRepeatStepSafe(repeatStep, currentKind, diagnostics, depth, stepResults);
            };
            return new StepResolutionResult(step, resolved, diagnostics);
        } catch (Exception e) {
            diagnostics.add(Diagnostics.error(DiagnosticCode.RESOLUTION_ERROR,
                    SearchEngine.I18N.getMessage("MQL.resolver.step.exception", e.getMessage())));
            return new StepResolutionResult(step, null, diagnostics);
        }
    }

    /**
     * Resolves a FilterStep with error resilience.
     * <p>
     * If the filter predicate is null, emits {@code REQUIRED_FIELD_MISSING} and returns a FilterStep with
     * null predicate and output kind equal to input kind (kind-preserving). Downstream resolution continues.
     *
     * @param filterStep the filter step to resolve
     * @param currentKind the current input kind
     * @param diagnostics the diagnostics list for this step
     * @return a non-null resolved step (kind-preserving even on null predicate)
     */
    @objid ("6cffd332-60b5-4190-80a4-a5d1fc71b002")
    private ResolvedStep resolveFilterStepSafe(FilterStep filterStep, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        if (filterStep.getWhere() == null) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.REQUIRED_FIELD_MISSING,
                    SearchEngine.I18N.getMessage("MQL.resolver.filter.no_predicate")));
            return new ResolvedStep.FilterStep(null, currentKind);
        }
        final ResolvedExpr predicate = resolveExpr(filterStep.getWhere(), currentKind, diagnostics);
        return new ResolvedStep.FilterStep(predicate, currentKind);
    }

    /**
     * Resolves a TraverseStep with error resilience.
     * <p>
     * If the edge token is null or blank, emits {@code REQUIRED_FIELD_MISSING} and returns {@code null}
     * (stops downstream resolution — traverse with unknown edge cannot produce an output kind).
     *
     * @param traverseStep the traverse step to resolve
     * @param currentKind the current input kind
     * @param diagnostics the diagnostics list for this step
     * @return the resolved step, or {@code null} if the edge token is missing
     */
    @objid ("83587c7b-29f5-4a3b-a998-f3ab1a5494cd")
    private ResolvedStep resolveTraverseStepSafe(TraverseStep traverseStep, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        final String edgeToken = traverseStep.getEdge();
        if (edgeToken == null || edgeToken.isBlank()) {
            diagnostics.add(Diagnostics.error(DiagnosticCode.REQUIRED_FIELD_MISSING,
                    SearchEngine.I18N.getMessage("MQL.resolver.traverse.no_edge")));
            return null;
        }
        final ResolvedEdge edge = resolveEdge(traverseStep, currentKind, diagnostics);
        final ResolvedExpr edgeFilter = (traverseStep.getEdgeFilter() == null)
                ? null
                : resolveExpr(traverseStep.getEdgeFilter(), currentKind, diagnostics);
        final ResolvedKind outputKind = resolveTraverseOutputKind(edge);
        return new ResolvedStep.TraverseStep(edge, edgeFilter, outputKind);
    }

    /**
     * Resolves a UnionStep with error resilience.
     * <p>
     * Empty branch list emits {@code REQUIRED_FIELD_MISSING}. Branches fail independently — if one branch
     * fails, other branches continue. If at least one branch succeeded, the outer pipeline continues.
     * If ALL branches fail, returns {@code null} (stops downstream).
     *
     * @param unionStep the union step to resolve
     * @param currentKind the current input kind
     * @param diagnostics the diagnostics list for this step
     * @param depth current nesting depth
     * @param stepResults the accumulator for nested step results
     * @return the resolved step, or {@code null} if all branches failed
     */
    @objid ("adc5a349-03f4-4485-a048-8a9fbaae762e")
    private ResolvedStep resolveUnionStepSafe(UnionStep unionStep, ResolvedKind currentKind, List<Diagnostic> diagnostics, int depth, Map<Step, StepResolutionResult> stepResults) {
        final List<List<Step>> branches = unionStep.getBranches();
        if (branches == null || branches.isEmpty()) {
            diagnostics.add(Diagnostics.warning(DiagnosticCode.REQUIRED_FIELD_MISSING,
                    SearchEngine.I18N.getMessage("MQL.resolver.union.no_branches")));
            return new ResolvedStep.UnionStep(List.of(), ResolvedKind.none());
        }

        final List<List<ResolvedStep>> resolvedBranches = new ArrayList<>();
        final List<ResolvedKind> branchKinds = new ArrayList<>();
        int successfulBranches = 0;

        for (List<Step> branch : branches) {
            final List<ResolvedStep> branchResolved = new ArrayList<>();
            resolveStepsWithBreakdown(branch, currentKind, stepResults, branchResolved, depth + 1);

            if (!branchResolved.isEmpty() || branch.isEmpty()) {
                successfulBranches++;
                resolvedBranches.add(branchResolved);
                branchKinds.add(resolveOutputKind(currentKind, branchResolved));
            } else {
                // Branch failed — steps are absent from stepResults (they may have been partially added)
                // Outer pipeline can still continue if other branches succeeded
            }
        }

        if (successfulBranches == 0) {
            // All branches failed
            return null;
        }

        final ResolvedKind outputKind = mergeKinds(branchKinds);
        return new ResolvedStep.UnionStep(resolvedBranches, outputKind);
    }

    /**
     * Resolves a RepeatStep with error resilience.
     * <p>
     * If any step in the repeat body fails (unresolvable output kind), stops ALL resolution including the
     * outer pipeline by returning {@code null}.
     *
     * @param repeatStep the repeat step to resolve
     * @param currentKind the current input kind
     * @param diagnostics the diagnostics list for this step
     * @param depth current nesting depth
     * @param stepResults the accumulator for nested step results
     * @return the resolved step, or {@code null} if the body resolution failed
     */
    @objid ("c2311b83-5334-4ce3-b5b2-9d02e0322dd1")
    private ResolvedStep resolveRepeatStepSafe(RepeatStep repeatStep, ResolvedKind currentKind, List<Diagnostic> diagnostics, int depth, Map<Step, StepResolutionResult> stepResults) {
        final List<Step> body = repeatStep.getBody();
        final int expectedBodySize = (body != null) ? body.size() : 0;

        final List<ResolvedStep> resolvedBody = new ArrayList<>();
        resolveStepsWithBreakdown(body, currentKind, stepResults, resolvedBody, depth + 1);

        // If body failed (not all steps resolved), add diagnostic and stop outer pipeline
        if (expectedBodySize > 0 && resolvedBody.size() < expectedBodySize) {
            diagnostics.add(Diagnostics.error(DiagnosticCode.RESOLUTION_ERROR,
                    SearchEngine.I18N.getMessage("MQL.resolver.field.missing")));
            return null;
        }

        final ResolvedKind outputKind = resolveOutputKind(currentKind, resolvedBody);
        return new ResolvedStep.RepeatStep(repeatStep.isEmitAllDepths(), resolvedBody, outputKind);
    }

    /**
     * Returns {@code true} if this step type preserves input kind when resolution partially fails.
     * <p>
     * A kind-preserving step (e.g., FilterStep) can continue downstream resolution using the same input kind
     * even when its own resolution is incomplete (e.g., null predicate).
     *
     * @param step the step to check
     * @code true} if the step preserves input kind on failure
     */
    @objid ("c2e0942f-73de-4e42-9f0f-60f046ac87e4")
    private boolean isKindPreservingStep(Step step) {
        return step instanceof FilterStep;
    }

    /**
     * Resolves the query source into a ResolvedSource, using the kind resolver to resolve any kind tokens and collecting diagnostics along the way.
     *
     * @param source the query source to resolve
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved source, with any kind tokens resolved into explicit alternatives and any resolution issues reported in diagnostics
     */
    @objid ("3510fcd2-581e-4f43-ba5a-f16e8d2c1975")
    @Override
    public ResolvedSource resolveSource(Source source, List<Diagnostic> diagnostics) {
        if (source instanceof AllSource allSource) {
            final ResolvedKind kind = this.kindResolver.resolve(allSource.getKindName(), diagnostics);
            return new ResolvedSource.AllSource(kind);
        }
        if (source instanceof ProvidedSource providedSource) {
            return new ResolvedSource.ProvidedSource(providedSource.getElements());
        }

        diagnostics.add(Diagnostics.warning(DiagnosticCode.UNSUPPORTED_SOURCE, SearchEngine.I18N.getMessage("MQL.resolver.source.unsupported", source.getClass().getName())));
        return new ResolvedSource.ProvidedSource(List.of());
    }

    /**
     * Resolves a kind token into a ResolvedKind, collecting diagnostics along the way.
     *
     * @param token the kind token to resolve (e.g., "Standard.Class")
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved kind, containing explicit alternatives for the given token and any resolution issues reported in diagnostics
     */
    @objid ("16982f40-761c-41e3-81b3-1b799d5a026a")
    public ResolvedKind resolveKind(String token, List<Diagnostic> diagnostics) {
        return this.kindResolver.resolve(token, diagnostics);
    }

    @objid ("2a7872fa-b3c7-42cd-a839-c97429bd780a")
    private List<ResolvedStep> resolveSteps(List<Step> steps, ResolvedKind initialKind, List<Diagnostic> diagnostics) {
        if (steps == null || steps.isEmpty()) {
            return List.of();
        }
        final List<ResolvedStep> resolved = new ArrayList<>();
        ResolvedKind currentKind = (initialKind == null) ? ResolvedKind.any() : initialKind;
        for (Step step : steps) {
            final ResolvedStep resolvedStep = resolveStep(step, currentKind, diagnostics);
            resolved.add(resolvedStep);
            currentKind = resolvedStep.outputKind();
        }
        return List.copyOf(resolved);
    }

    /**
     * Gets the kind resolver used to resolve kind tokens in sources and expressions.
     *
     * @return the kind resolver used by this query resolver
     */
    @objid ("c1b7bb76-e93c-4998-8b2d-57b884260a36")
    public KindResolver getKindResolver() {
        return this.kindResolver;
    }

    /**
     * Gets the edge resolver used to resolve edge tokens in traverse steps.
     *
     * @return the edge resolver used by this query resolver
     */
    @objid ("5d0afdc9-ba33-4868-8076-c47c840beac0")
    public EdgeResolver getEdgeResolver() {
        return this.edgeResolver;
    }

    /**
     * Gets the property key resolver used to resolve property key tokens in value expressions.
     *
     * @return the property key resolver used by this query resolver
     */
    @objid ("17dba9b1-d89f-49dd-9d23-bef23bce5831")
    public PropertyKeyResolver getPropertyKeyResolver() {
        return this.propertyKeyResolver;
    }

    /**
     * Resolves a single step, using the current input kind to resolve any kind-dependent elements (e.g., edge tokens or property keys).
     *
     * @param step the step to resolve
     * @param currentKind the current input kind, used to resolve kind-dependent elements in the step (may be null or empty if no information is available)
     * @param diagnostics a list to which resolution diagnostics will be appended (may be null)
     * @return the resolved step, with its output kind computed based on the input kind and the step semantics
     */
    @objid ("7b581a4b-ff13-4e45-9830-5057e24842e1")
    @Override
    public ResolvedStep resolveStep(Step step, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        return switch (step) {
        case FilterStep filterStep -> {
            final ResolvedExpr predicate = resolveExpr(filterStep.getWhere(), currentKind, diagnostics);
            yield new ResolvedStep.FilterStep(predicate, currentKind);
        }
        case TraverseStep traverseStep -> {
            final ResolvedEdge edge = resolveEdge(traverseStep, currentKind, diagnostics);

            final ResolvedExpr edgeFilter = (traverseStep.getEdgeFilter() == null)
                    ? null
                            : resolveExpr(traverseStep.getEdgeFilter(), currentKind, diagnostics);
            final ResolvedKind outputKind = resolveTraverseOutputKind(edge);

            yield new ResolvedStep.TraverseStep(edge, edgeFilter, outputKind);
        }
        case UnionStep unionStep -> {
            final List<List<ResolvedStep>> resolvedBranches = new ArrayList<>();
            final List<ResolvedKind> branchKinds = new ArrayList<>();
            for (List<Step> branch : unionStep.getBranches()) {
                final List<ResolvedStep> resolvedBranch = resolveSteps(branch, currentKind, diagnostics);
                resolvedBranches.add(resolvedBranch);
                branchKinds.add(resolveOutputKind(currentKind, resolvedBranch));
            }
            final ResolvedKind outputKind = mergeKinds(branchKinds);

            yield new ResolvedStep.UnionStep(resolvedBranches, outputKind);
        }
        case RepeatStep repeatStep -> {
            final List<ResolvedStep> resolvedBody = resolveSteps(repeatStep.getBody(), currentKind, diagnostics);
            final ResolvedKind outputKind = resolveOutputKind(currentKind, resolvedBody);

            yield new ResolvedStep.RepeatStep(repeatStep.isEmitAllDepths(),resolvedBody,  outputKind);
        }
        };
    }

    @objid ("6b3edc93-175f-46af-ae6f-1cddbd2214ce")
    private ResolvedExpr resolveExpr(Expr expr, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        if (expr == null) {
            throw new IllegalArgumentException("expr must not be null");
        }
        return switch (expr) {
            case IsExpr isExpr -> {
                final ResolvedKind kind = this.kindResolver.resolve(isExpr.getOfQualifiedName(), diagnostics);
                yield new ResolvedIsExpr(kind);
            }
            case CompareExpr compareExpr -> {
                final ResolvedValueExpr left = resolveValueExpr(compareExpr.getLeft(), currentKind, diagnostics);
                final ResolvedValueExpr right = resolveValueExpr(compareExpr.getRight(), currentKind, diagnostics);
                yield new ResolvedCompareExpr(compareExpr.getOp(), left, right);
            }
            case AndExpr andExpr -> {
                final List<ResolvedExpr> children = new ArrayList<>();
                for (Expr child : andExpr.getExprs()) {
                    children.add(resolveExpr(child, currentKind, diagnostics));
                }
                yield new ResolvedAndExpr(children);
            }
            case OrExpr orExpr -> {
                final List<ResolvedExpr> children = new ArrayList<>();
                for (Expr child : orExpr.getExprs()) {
                    children.add(resolveExpr(child, currentKind, diagnostics));
                }
                yield new ResolvedOrExpr(children);
            }
            case NotExpr notExpr -> {
                final ResolvedExpr resolved = resolveExpr(notExpr.getExpr(), currentKind, diagnostics);
                yield new ResolvedNotExpr(resolved);
            }
            case ExistsExpr existsExpr -> {
                final List<ResolvedStep> resolvedIn = resolveSteps(existsExpr.getIn(), currentKind, diagnostics);
                final ResolvedExpr resolvedWhere = (existsExpr.getWhere() == null)
                        ? null
                        : resolveExpr(existsExpr.getWhere(), currentKind, diagnostics);
                yield new ResolvedExistsExpr(resolvedIn, resolvedWhere);
            }
        };
    }

    @objid ("35a58058-d79f-486b-9de4-dec37e2e2513")
    private ResolvedKind resolveOutputKind(ResolvedKind inputKind, List<ResolvedStep> steps) {
        if (steps == null || steps.isEmpty()) {
            return (inputKind == null) ? ResolvedKind.none() : inputKind;
        }
        return steps.get(steps.size() - 1).outputKind();
    }

    @objid ("b70a8fda-7ddd-4601-8826-4e12433403e6")
    private ResolvedKind mergeKinds(List<ResolvedKind> kinds) {
        if (kinds == null || kinds.isEmpty()) {
            return ResolvedKind.none();
        }

        final List<ResolvedKind.KindAlternative> alternatives = new ArrayList<>();
        for (ResolvedKind kind : kinds) {
            if (kind == null || kind.equals(ResolvedKind.none())) {
                continue;
            }
            if (kind.equals(ResolvedKind.any())) {
                // If any branch can be any, the result is any
                return ResolvedKind.any();
            }
            alternatives.addAll(kind.alternatives());
        }

        if (alternatives.isEmpty()) {
            return ResolvedKind.none();
        }

        return new ResolvedKind(alternatives);
    }

    @objid ("8ebf7470-6961-4c0b-9c5c-e58731e6b1dd")
    private ResolvedValueExpr resolveValueExpr(ValueExpr valueExpr, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        return switch (valueExpr) {
            case PropertyValueExpr propertyValueExpr -> {
                final ResolvedProperty key = resolvePropertyKey(propertyValueExpr.getProperty(), currentKind, diagnostics);
                yield new ResolvedPropertyValueExpr(key);
            }
            case LiteralValueExpr literalValueExpr -> new ResolvedValueExpr.LiteralValueExpr(literalValueExpr.getValueType(), literalValueExpr.getValue());
            //default -> new ResolvedValueExpr.UnsupportedValueExpr(valueExpr.getClass().getSimpleName());

        };
    }

    @objid ("72e3fc25-fb74-400a-ae27-28e0075c1f5f")
    private ResolvedKind resolveInitialKind(ResolvedSource source) {
        if (source instanceof ResolvedSource.AllSource allSource) {
            return allSource.kind();
        }
        if (source instanceof ResolvedSource.ProvidedSource) {
            return anyKind();
        }

        return ResolvedKind.none();
    }

    /**
     * Build a ResolvedKind representing any possible model element.
     * <p>
     * Used as initial kind for provided sources whose kind cannot be determined.
     *
     * @return a ResolvedKind representing any possible model element.
     */
    @objid ("835a5d44-37bc-4273-b4a1-d5b4b4f09da8")
    public ResolvedKind anyKind() {
        return ResolvedKind.any();
    }

    @objid ("1ad41dc9-f35f-4ea7-8e55-6938ea37d0bd")
    private ResolvedKind resolveTraverseOutputKind(ResolvedEdge edge) {
        if (edge == null || edge.isUnknown()) {
            return ResolvedKind.none();
        }

        final List<ResolvedKind.KindAlternative> alternatives = new ArrayList<>();
        for (ResolvedEdge.EdgeAlternative alternative : edge.alternatives()) {
            switch (alternative) {
                case ResolvedEdge.MDependencyEdge dependencyEdge -> {
                    alternatives.add(new ResolvedKind.MetaclassKind(dependencyEdge.dependency().getTarget()));
                }
                case ResolvedEdge.LinkObjectEdge linkObjectEdge -> {
                    if (linkObjectEdge.stereotype() != null) {
                        alternatives.add(new ResolvedKind.StereotypeKind(linkObjectEdge.stereotype()));
                    } else {
                        alternatives.add(new ResolvedKind.MetaclassKind(linkObjectEdge.linkMetaclass()));
                    }
                }
            }
        }

        if (alternatives.isEmpty()) {
            return ResolvedKind.none();
        }
        return new ResolvedKind(alternatives);
    }

    @objid ("bdc692cd-f4e4-43c2-97b1-0b87c557548e")
    private ResolvedEdge resolveEdge(TraverseStep traverseStep, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        final String edgeToken = traverseStep.getEdge();
        final Direction direction = traverseStep.getDirection();
        return this.edgeResolver.resolve(edgeToken, direction, currentKind, diagnostics);
    }

    @objid ("010849bf-ec78-49b1-8618-bf20456fda07")
    private ResolvedProperty resolvePropertyKey(String token, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
        return this.propertyKeyResolver.resolve(token, currentKind, diagnostics);
    }

    /**
     * Resolves a single step with per-step diagnostic attribution.
     *
     * @param step the step to resolve
     * @param currentKind the current input kind
     * @return the per-step resolution result containing the resolved step and attributed diagnostics
     */
    @objid ("d840b203-1e0b-488a-8115-bdc270e6efc5")
    @Override
    public StepResolutionResult resolveStep(Step step, ResolvedKind currentKind) {
        final List<Diagnostic> diagnostics = new ArrayList<>();
        final ResolvedStep resolved = resolveStep(step, currentKind, diagnostics);
        return new StepResolutionResult(step, resolved, diagnostics);
    }

    /**
     * Resolves the query source with per-source diagnostic attribution.
     * <p>
     * Handles null source by emitting an ERROR diagnostic and returning an empty source result.
     *
     * @param source the source to resolve (may be null)
     * @return the per-source resolution result containing the resolved source and attributed diagnostics
     */
    @objid ("9b91156e-fb55-479f-9ac2-84c07973dd8f")
    @Override
    public SourceResolutionResult resolveSource(Source source) {
        if (source == null) {
            final List<Diagnostic> diagnostics = List.of(Diagnostics.error(DiagnosticCode.RESOLUTION_ERROR,
                    SearchEngine.I18N.getMessage("MQL.resolver.source.null")));
            return new SourceResolutionResult(null, null, diagnostics);
        }
        final List<Diagnostic> diagnostics = new ArrayList<>();
        final ResolvedSource resolved = resolveSource(source, diagnostics);
        return new SourceResolutionResult(source, resolved, diagnostics);
    }

    /**
     * Resolves an expression with per-expression diagnostic attribution.
     *
     * @param expr the expression to resolve
     * @param currentKind the current input kind
     * @return the per-expression resolution result containing the resolved expression and attributed diagnostics
     */
    @objid ("a83e6840-7225-42bb-a71c-6d41e4b84e92")
    @Override
    public ExprResolutionResult resolveExpr(Expr expr, ResolvedKind currentKind) {
        final List<Diagnostic> diagnostics = new ArrayList<>();
        final ResolvedExpr resolved = resolveExpr(expr, currentKind, diagnostics);
        return new ExprResolutionResult(expr, resolved, diagnostics);
    }

    /**
     * Resolves a kind token with per-kind diagnostic attribution.
     *
     * @param token the kind token to resolve
     * @return the per-kind resolution result containing the resolved kind and attributed diagnostics
     */
    @objid ("76b250e2-2037-4870-92cf-fad0044f8f59")
    @Override
    public KindResolutionResult resolveKind(String token) {
        final List<Diagnostic> diagnostics = new ArrayList<>();
        final ResolvedKind resolved = resolveKind(token, diagnostics);
        return new KindResolutionResult(token, resolved, diagnostics);
    }

}
