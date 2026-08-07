# Phase 8: Partial and Incremental Query Resolution with Diagnostics Mapping - Research

**Researched:** 2026-02-25
**Domain:** MQL query resolution — incremental resolution, diagnostic attribution, error resilience
**Confidence:** HIGH

## Summary

Phase 8 enriches the existing `QueryResolver` and its public API (`IQueryResolver`) to support per-step resolution results — mapping each `Step` to its `ResolvedStep` and associated `Diagnostic` list — so the MQL graphical editor can display real-time, per-node validation feedback.

The existing resolver already resolves steps individually via `resolveStep(Step, ResolvedKind, List<Diagnostic>)`. The primary gap is **diagnostic attribution**: diagnostics land in a flat shared list with no structured link back to the AST node that caused them. A secondary gap is **step↔resolved-step mapping**: `ResolutionResult` currently exposes a `ResolvedQuery` with a `List<ResolvedStep>` that is only positionally correlated with the input `List<Step>`.

**Primary recommendation:** Introduce a `StepResolutionResult` record pairing `(Step, ResolvedStep, List<Diagnostic>)` and enrich `ResolutionResult` with per-step breakdowns. Full re-resolution (not incremental) is the right strategy — resolution is fast (~1ms) and avoids complexity of tracking input-kind dependencies.

## Standard Stack

No new external libraries are needed. All implementation uses existing project types.

### Core Types (existing)

| Type | Location | Role |
|------|----------|------|
| `IQueryResolver` | `api/IQueryResolver.java` | Public resolver interface — to be enriched |
| `QueryResolver` | `internal/resolver/QueryResolver.java` | Implementation — to produce per-step results |
| `ResolutionResult` | `api/model/resolved/ResolutionResult.java` | Resolver output — to be enriched with per-step data |
| `Diagnostic` | `api/model/result/Diagnostic.java` | Diagnostic record — to be enriched with optional location |
| `DiagnosticLocation` | `internal/resolver/diagnostics/DiagnosticLocation.java` | Internal location — to be promoted to public API |
| `Diagnostics` | `internal/resolver/diagnostics/Diagnostics.java` | Factory — already supports location parameter |
| `ResolvedStep` | `api/model/resolved/ResolvedStep.java` | Resolved step sealed interface |
| `Step` | `api/model/query/Step.java` | Mutable AST step sealed interface |

### Consumer Types (existing, UI side)

| Type | Location | Role |
|------|----------|------|
| `MqlValidationService` | `app.model.search.ui/.../validation/MqlValidationService.java` | Draft validation — to be replaced with resolver-backed impl |
| `MqlStepNode` | `app.model.search.ui/.../elements/core/MqlStepNode.java` | Step wrapper — consumer of per-step diagnostics |
| `MqlQueryModel` | `app.model.search.ui/.../elements/core/MqlQueryModel.java` | Root model — triggers re-resolution on changes |

## Architecture Patterns

### Pattern 1: StepResolutionResult record (NEW)

**What:** A new public record that pairs a resolved step with its diagnostics and the originating AST step.

**Where:** `api/model/resolved/StepResolutionResult.java`

**Example:**
```java
package org.modelio.platform.query.api.model.resolved;

import java.util.List;
import org.modelio.platform.query.api.model.query.Step;
import org.modelio.platform.query.api.model.result.Diagnostic;

/**
 * Per-step resolution outcome: resolved form + diagnostics attributed to this step.
 *
 * @param step        the original unresolved AST step (identity reference)
 * @param resolved    the resolved step produced by the resolver
 * @param diagnostics diagnostics emitted during resolution of this specific step
 */
public record StepResolutionResult(
        Step step,
        ResolvedStep resolved,
        List<Diagnostic> diagnostics) {

    public StepResolutionResult {
        if (step == null) throw new IllegalArgumentException("step must not be null");
        if (resolved == null) throw new IllegalArgumentException("resolved must not be null");
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }

    /** True if this step has at least one ERROR-level diagnostic. */
    public boolean hasErrors() {
        return this.diagnostics.stream()
                .anyMatch(d -> d.level() == Diagnostic.Level.ERROR);
    }
}
```

### Pattern 2: SourceResolutionResult record (NEW)

**What:** Same pattern for the source node.

**Where:** `api/model/resolved/SourceResolutionResult.java`

**Example:**
```java
package org.modelio.platform.query.api.model.resolved;

import java.util.List;
import org.modelio.platform.query.api.model.query.Source;
import org.modelio.platform.query.api.model.result.Diagnostic;

/**
 * Per-source resolution outcome.
 */
public record SourceResolutionResult(
        Source source,
        ResolvedSource resolved,
        List<Diagnostic> diagnostics) {

    public SourceResolutionResult {
        if (source == null) throw new IllegalArgumentException("source must not be null");
        if (resolved == null) throw new IllegalArgumentException("resolved must not be null");
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
    }
}
```

### Pattern 3: Enriched ResolutionResult

**What:** Enrich `ResolutionResult` to carry the per-step breakdown alongside the existing flat fields (backward-compatible).

**Example:**
```java
public record ResolutionResult(
        ResolvedQuery resolvedQuery,
        List<Diagnostic> diagnostics,
        SourceResolutionResult sourceResult,
        List<StepResolutionResult> stepResults) {

    // Backward-compatible canonical constructor
    public ResolutionResult(ResolvedQuery resolvedQuery, List<Diagnostic> diagnostics) {
        this(resolvedQuery, diagnostics, null, List.of());
    }

    public ResolutionResult {
        if (resolvedQuery == null) throw new IllegalArgumentException("resolvedQuery must not be null");
        diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
        stepResults = (stepResults == null) ? List.of() : List.copyOf(stepResults);
    }
}
```

### Pattern 4: Full re-resolution on every change (NOT incremental)

**What:** When the editor model changes (any step added/edited/removed), re-resolve the entire query and distribute per-step results.

**Why:** Resolution is pure computation over the metamodel (no I/O, no model scan). Timing measurements on Phase 2/6 tests show resolution completes in <1ms for typical queries (5–10 steps). Incremental resolution would require:
- Tracking input kind dependency chains (each step's resolution depends on the previous step's output kind).
- Cache invalidation when upstream steps change.
- Complexity for union/repeat steps whose branches share context.

This complexity is unjustified for a <1ms operation. Full re-resolution is simpler, correct by construction, and fast enough for keystroke-level responsiveness.

**How:** `MqlValidationService` calls `resolver.resolveQuery(query)` on each model change, then distributes `StepResolutionResult` entries to `MqlStepNode` wrappers by identity match on the `Step` reference.

### Pattern 5: Error-resilient resolution (defensive resolver)

**What:** The resolver must never throw on malformed/incomplete editor input. Every resolution method must catch and convert exceptions to ERROR diagnostics.

**Where:** `QueryResolver.resolveStep()`, `QueryResolver.resolveExpr()`, internal resolvers.

**How:** Wrap the switch expression body in try-catch and produce `UnsupportedStep` / error `Diagnostic` on any exception. The `resolveStep()` already handles all `Step` subtypes exhaustively (sealed interface), but expression resolution or edge resolution can throw on null/blank fields.

**Example guard pattern (already partially in place):**
```java
@Override
public ResolvedStep resolveStep(Step step, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
    try {
        return switch (step) {
            case FilterStep filterStep -> { /* ... */ }
            case TraverseStep traverseStep -> { /* ... */ }
            case UnionStep unionStep -> { /* ... */ }
            case RepeatStep repeatStep -> { /* ... */ }
        };
    } catch (Exception e) {
        diagnostics.add(Diagnostics.error(
                DiagnosticCode.RESOLUTION_ERROR,
                SearchEngine.I18N.getMessage("MQL.resolver.step.error", step.getClass().getSimpleName(), e.getMessage())));
        return new ResolvedStep.UnsupportedStep(
                "Resolution failed: " + e.getMessage(),
                currentKind != null ? currentKind : ResolvedKind.empty());
    }
}
```

### Pattern 6: Resolver API enrichment for edge and property resolution

**What:** Add `resolveEdge()` and `resolveProperty()` to `IQueryResolver` public API.

**Why:** The MQL editor validates edge tokens (in `TraverseStep`) and property keys (in `CompareExpr`) independently. Currently the editor's `MqlValidationService.validateEdgeRef()` does only blank-checking because it cannot call the real edge resolver. Exposing `resolveEdge()` and `resolveProperty()` on the public API allows the editor to validate individual tokens against the metamodel with proper diagnostics.

**Example addition to `IQueryResolver`:**
```java
/**
 * Resolves an edge token into a ResolvedEdge, given the current input kind and direction.
 */
ResolvedEdge resolveEdge(String token, Direction direction, ResolvedKind currentKind, List<Diagnostic> diagnostics);

/**
 * Resolves a property key token into a ResolvedProperty, given the current input kind.
 */
ResolvedProperty resolveProperty(String token, ResolvedKind currentKind, List<Diagnostic> diagnostics);
```

These methods already exist on `QueryResolver` as private/package-private — this is about promoting them to the public interface.

### Anti-Patterns to Avoid

- **Incremental per-step resolution with cached kinds:** Adds complexity for no measurable gain. Resolution is <1ms. Always re-resolve the full query.
- **Diagnostic location as message prefix:** The existing `DiagnosticLocation` is rendered into the message string. For structured UI mapping, location must be exposed as a typed field on `Diagnostic`, not embedded in the human-readable message. Keep the message-prefix rendering for backward compat but also add the structured field.
- **Creating a separate "editor resolver" or "validation resolver":** Reuse the existing `QueryResolver` — it already does exactly what the editor needs. `MqlValidationService` should delegate to it, not duplicate validation logic.

## Don't Hand-Roll

| Problem | Don't Build | Use Instead | Why |
|---------|-------------|-------------|-----|
| Kind validation | Ad-hoc string checks in `MqlValidationService` | `IQueryResolver.resolveKind()` | Already resolves against real metamodel with proper diagnostics |
| Edge validation | Blank-string check in `MqlValidationService.validateEdgeRef()` | `IQueryResolver.resolveEdge()` (new public method) | Real metamodel-backed resolution with ambiguity detection |
| Property key validation | Colon-presence heuristic in `MqlValidationService.validatePropertyKey()` | `IQueryResolver.resolveProperty()` (new public method) | Real metamodel-backed resolution |
| Per-step diagnostic collection | Manual diagnostic list splitting by index | `StepResolutionResult` record in enriched `ResolutionResult` | Resolver collects diagnostics per-step during resolution |
| Input kind tracking for incremental resolution | Custom cache/dependency graph | Full re-resolution (1ms) | Complexity not justified for < 1ms operation |

**Key insight:** The draft `MqlValidationService` was written before the resolver existed. Now that the resolver is complete and fast, all validation should delegate to it. The service becomes a thin orchestrator that calls `resolveQuery()` and distributes results.

## Common Pitfalls

### Pitfall 1: Mutating the diagnostic list during iteration

**What goes wrong:** `QueryResolver.resolveStep()` receives a mutable `List<Diagnostic>` parameter. If per-step collection uses a separate list per step but also appends to the global list, aliasing bugs can occur.
**Why it happens:** The resolver's `diagnostics` parameter is a shared accumulator.
**How to avoid:** For per-step collection, create a fresh `ArrayList<Diagnostic>` per step, pass it to `resolveStep()`, then copy its contents into both the per-step result and the global list.
**Warning signs:** Diagnostics appearing under the wrong step in the UI.

### Pitfall 2: Step identity matching failure

**What goes wrong:** When matching `StepResolutionResult.step` back to `MqlStepNode.getAst()`, using `equals()` would fail because `Step` implementations are mutable classes without value-based equality.
**Why it happens:** `Step` subtypes (`FilterStep`, `TraverseStep`, etc.) are mutable classes, not records. They don't override `equals()`.
**How to avoid:** Use reference identity (`==`) to match `StepResolutionResult.step` to `MqlStepNode.getAst()`. This works because `MqlStepNode` holds a direct reference to the same `Step` instance that was passed to `resolveQuery()`.
**Warning signs:** Steps not matching, diagnostics lost.

### Pitfall 3: Null/blank edge or kind tokens crashing the resolver

**What goes wrong:** During editing, a user may have an empty `TraverseStep.edge` before typing. If the resolver throws `IllegalArgumentException` on blank input, the entire resolution crashes.
**Why it happens:** Callers of `resolveEdge()` may pass `null` or `""` edge tokens from incomplete UI state.
**How to avoid:** The resolver must emit ERROR diagnostics for blank/null tokens and return appropriate "unknown" resolved values (e.g., `ResolvedEdge.empty()`), never throw. Check existing `emitDiagnostics()` methods — `KindResolver` and `EdgeResolver` already handle blank tokens with diagnostics. Ensure `resolveExpr()` does the same for null expressions passed from incomplete filter steps.
**Warning signs:** `IllegalArgumentException` stack traces in the MQL editor.

### Pitfall 4: DiagnosticLocation coupling to positional step index

**What goes wrong:** The existing `DiagnosticLocation` uses `stepIndex` (an int) which is fragile: it only works for top-level steps, not for nested steps in union branches or repeat bodies.
**Why it happens:** `DiagnosticLocation` was designed for flat diagnostic rendering, not structured mapping.
**How to avoid:** For per-step diagnostic attribution, don't use `DiagnosticLocation` as the mapping key. Instead, use the `StepResolutionResult` pattern which binds diagnostics to the `Step` reference directly. Keep `DiagnosticLocation` for human-readable message prefixes only.
**Warning signs:** Incorrect diagnostic attribution for nested union/repeat steps.

### Pitfall 5: Forgetting to handle `resolveExpr()` null input

**What goes wrong:** `QueryResolver.resolveExpr()` currently throws `IllegalArgumentException` when `expr` is null. But during editing, a `FilterStep` may have a null `where` clause before the user configures it.
**Why it happens:** The resolver was designed for complete queries, not partial ones.
**How to avoid:** Guard `resolveStep()` to check for null expr before calling `resolveExpr()` and emit a diagnostic instead of throwing. The `TraverseStep` path already handles null edge filter gracefully.
**Warning signs:** NPE or IAE when resolving a freshly-added FilterStep in the editor.

## Code Examples

### Example 1: Per-step diagnostic collection in QueryResolver.resolveSteps()

```java
// Current implementation (flat list):
private List<ResolvedStep> resolveSteps(List<Step> steps, ResolvedKind initialKind, List<Diagnostic> diagnostics) {
    // ... all diagnostics go into shared `diagnostics` list
}

// New implementation (per-step collection):
private List<StepResolutionResult> resolveStepsWithBreakdown(
        List<Step> steps, ResolvedKind initialKind, List<Diagnostic> allDiagnostics) {
    if (steps == null || steps.isEmpty()) {
        return List.of();
    }
    final List<StepResolutionResult> results = new ArrayList<>();
    ResolvedKind currentKind = (initialKind == null) ? ResolvedKind.empty() : initialKind;
    for (Step step : steps) {
        final List<Diagnostic> stepDiagnostics = new ArrayList<>();
        final ResolvedStep resolvedStep = resolveStep(step, currentKind, stepDiagnostics);
        allDiagnostics.addAll(stepDiagnostics);
        results.add(new StepResolutionResult(step, resolvedStep, stepDiagnostics));
        currentKind = resolvedStep.outputKind();
    }
    return List.copyOf(results);
}
```

### Example 2: Enriched resolveQuery() returning step breakdown

```java
@Override
public ResolutionResult resolveQuery(Query query) {
    final List<Diagnostic> diagnostics = new ArrayList<>();

    // Source resolution with per-source diagnostics
    final List<Diagnostic> sourceDiagnostics = new ArrayList<>();
    final ResolvedSource resolvedSource = resolveSource(query.getSource(), sourceDiagnostics);
    diagnostics.addAll(sourceDiagnostics);
    final SourceResolutionResult sourceResult =
            new SourceResolutionResult(query.getSource(), resolvedSource, sourceDiagnostics);

    // Step resolution with per-step breakdown
    final ResolvedKind initialKind = resolveInitialKind(resolvedSource);
    final List<StepResolutionResult> stepResults =
            resolveStepsWithBreakdown(query.getSteps(), initialKind, diagnostics);

    // Extract flat resolved steps for ResolvedQuery (backward compat)
    final List<ResolvedStep> resolvedSteps = stepResults.stream()
            .map(StepResolutionResult::resolved)
            .toList();

    final ResolvedQuery resolvedQuery =
            new ResolvedQuery(resolvedSource, resolvedSteps, query.getLimits().freeze());

    return new ResolutionResult(resolvedQuery, diagnostics, sourceResult, stepResults);
}
```

### Example 3: Error-resilient resolveStep() with try-catch

```java
@Override
public ResolvedStep resolveStep(Step step, ResolvedKind currentKind, List<Diagnostic> diagnostics) {
    try {
        return switch (step) {
            case FilterStep filterStep -> {
                Expr where = filterStep.getWhere();
                if (where == null) {
                    diagnostics.add(Diagnostics.error(DiagnosticCode.RESOLUTION_ERROR,
                            SearchEngine.I18N.getMessage("MQL.resolver.filter.missing.predicate")));
                    yield new ResolvedStep.FilterStep(
                            new ResolvedIsExpr(ResolvedKind.empty()), currentKind);
                }
                final ResolvedExpr predicate = resolveExpr(where, currentKind, diagnostics);
                yield new ResolvedStep.FilterStep(predicate, currentKind);
            }
            case TraverseStep traverseStep -> { /* existing code, already handles null edgeFilter */ }
            case UnionStep unionStep -> { /* existing code */ }
            case RepeatStep repeatStep -> { /* existing code */ }
        };
    } catch (Exception e) {
        diagnostics.add(Diagnostics.error(DiagnosticCode.RESOLUTION_ERROR,
                SearchEngine.I18N.getMessage("MQL.resolver.step.error",
                        step.getClass().getSimpleName(), String.valueOf(e.getMessage()))));
        return new ResolvedStep.UnsupportedStep(
                "Resolution failed: " + e.getMessage(),
                currentKind != null ? currentKind : ResolvedKind.empty());
    }
}
```

### Example 4: MqlValidationService rewrite (resolver-backed)

```java
public class MqlValidationService {
    private final IQueryResolver resolver;

    public MqlValidationService(ICoreSession session) {
        IQueryEngine engine = Queries.createEngine(session, List::of);
        this.resolver = engine.getResolver();
    }

    /**
     * Resolve the entire query and return the full result with per-step breakdowns.
     */
    public ResolutionResult resolveQuery(Query query) {
        return this.resolver.resolveQuery(query);
    }

    /**
     * Resolve a single kind token for UI feedback.
     */
    public List<Diagnostic> validateKindRef(String kindRef) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        this.resolver.resolveKind(kindRef, diagnostics);
        return diagnostics;
    }

    /**
     * Resolve a single edge token for UI feedback.
     */
    public List<Diagnostic> validateEdgeRef(String edgeRef, Direction direction, ResolvedKind inputKind) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        this.resolver.resolveEdge(edgeRef, direction, inputKind, diagnostics);
        return diagnostics;
    }
}
```

### Example 5: UI consumption — distributing per-step results to MqlStepNode

```java
// In MqlQueryModel or a controller:
public void onModelChanged() {
    Query query = getQueryAst();
    ResolutionResult result = this.validationService.resolveQuery(query);

    // Distribute per-step results to step nodes by identity
    for (StepResolutionResult stepResult : result.stepResults()) {
        for (MqlStepNode node : getStepNodes()) {
            if (node.getAst() == stepResult.step()) {
                node.setResolutionResult(stepResult);
                break;
            }
        }
    }

    // Source result
    getSourceNode().setResolutionResult(result.sourceResult());
}
```

## State of the Art

| Old Approach | Current Approach | When Changed | Impact |
|---|---|---|---|
| `MqlValidationService` does ad-hoc validation | Delegate all validation to `IQueryResolver` | Phase 8 (this phase) | Eliminates duplicate logic, gives metamodel-accurate feedback |
| Flat `List<Diagnostic>` with no attribution | Per-step `StepResolutionResult` with attributed diagnostics | Phase 8 | UI can show per-node error/warning markers |
| `DiagnosticLocation` rendered into message prefix only | Keep message prefix + add optional structured `queryPart` field on Diagnostic | Phase 8 | Both human-readable and machine-readable location |
| Positional `List<ResolvedStep>` correlation with `List<Step>` | Explicit `Step` reference in `StepResolutionResult` | Phase 8 | Robust mapping that works through union/repeat nesting |

## Open Questions

1. **Should `Diagnostic` record get a new field, or should attribution stay only in `StepResolutionResult`?**
   - What we know: Adding a field to `Diagnostic` (e.g., `Object queryPart`) would be the most generic solution but changes the serialization contract. Keeping attribution only in `StepResolutionResult` is simpler and doesn't touch the `Diagnostic` record.
   - Recommendation: Keep `Diagnostic` unchanged. Attribution lives in `StepResolutionResult` / `SourceResolutionResult`. This avoids changing the serialized diagnostic format and keeps the `Diagnostic` record focused on its current role.

2. **Should nested steps (inside union branches / repeat body) get their own `StepResolutionResult`?**
   - What we know: `QueryResolver.resolveSteps()` is called recursively for union branches and repeat bodies. The same per-step collection pattern can be applied recursively.
   - Recommendation: Yes, but for Phase 8 scope, only provide per-step breakdown for top-level steps. Nested step diagnostics roll up into the parent step's diagnostic list. This can be extended later if the UI needs per-node diagnostics inside branches.

3. **Thread safety of `MqlValidationService` re-resolution from UI thread?**
   - What we know: Resolution is pure metamodel lookup, no model I/O. It completes in <1ms. `MqlQueryModel` fires `PROP_CHANGED` events on mutation. The UI can re-resolve synchronously on each change event.
   - Recommendation: Call `resolveQuery()` synchronously on the SWT UI thread inside the change listener. For <1ms operations, async dispatch adds complexity without benefit. If future queries become expensive, move to `Display.asyncExec` with debouncing.

## Sources

### Primary (HIGH confidence)
- `IQueryResolver.java` — current public interface, read directly
- `QueryResolver.java` — resolver implementation, 443 lines, read directly
- `Diagnostics.java` — factory already supports `DiagnosticLocation` parameter
- `DiagnosticLocation.java` — internal record, step-index-based path
- `ResolutionResult.java` — current record shape
- `MqlValidationService.java` — draft validation, read directly
- `MqlStepNode.java` — step wrapper with identity reference to `Step`
- `MqlQueryModel.java` — root model with change notification
- `AbstractMqlTest.java` — test infrastructure pattern

### Secondary (HIGH confidence)
- `modelsearch.properties` — existing I18N keys for resolver messages
- `SearchEngine.java` — I18N and LOG initialization, `SearchEngine.I18N.getMessage()` pattern
- Phase 2, 7 STATE.md entries — prior decisions on resolver architecture and I18N

## Metadata

**Confidence breakdown:**
- Standard stack: HIGH — all types exist and were read directly from source
- Architecture: HIGH — patterns derive directly from existing resolver flow and are verified against code
- Pitfalls: HIGH — identified from actual code paths and edge cases in existing implementation

**Research date:** 2026-02-25
**Valid until:** indefinite (internal architecture, no external dependency drift)
