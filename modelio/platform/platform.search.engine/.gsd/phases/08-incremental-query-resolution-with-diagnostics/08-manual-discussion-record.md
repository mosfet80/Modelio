User: Follow instructions in [discuss-phase.prompt.md](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.github/prompts/discuss-phase.prompt.md).
8

GitHub Copilot:

 Let me load the required context files.

Read skill [discuss-phase](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.github/skills/discuss-phase/SKILL.md?vscodeLinkType%3Dskill#1-1), lines 1 to 200

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/STATE.md#1-1), lines 1 to 100

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/ROADMAP.md#1-1), lines 1 to 200

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/ROADMAP.md#200-200), lines 200 to 312

Now let me check if a CONTEXT.md already exists for phase 8, and also load the RESEARCH.md the user currently has open.

Ran terminal command:  ls /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/phases/08-*/*-CONTEXT.md 2>/dev/null; echo "---"; ls /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/phases/08-*/ 2>/dev/null

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/phases/08-incremental-query-resolution-with-diagnostics/08-RESEARCH.md#1-1), lines 1 to 200

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/phases/08-incremental-query-resolution-with-diagnostics/08-RESEARCH.md#200-200), lines 200 to 460

Good. Now let me load the CONTEXT.md template.

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/templates/context.md#1-1), lines 1 to 100

I have all the context needed. No existing CONTEXT.md for phase 8 — proceeding to analyze gray areas.

---

**Phase 8: Partial and Incremental Query Resolution with Diagnostics Mapping**

**Domain boundary:** Enrich the resolver to produce per-step resolution results (mapping each AST step to its resolved step + attributed diagnostics) so the MQL graphical editor can display real-time, per-node validation feedback during editing. Full re-resolution on every change (not incremental).

This phase delivers something the **editor uses internally** — resolved data flowing from the engine back to the UI. The gray areas are about how that data is structured, how errors behave during editing, and how the UI consumes it.

I've identified **4 phase-specific gray areas** worth discussing:

1. **Diagnostic granularity & nesting** — Should per-step diagnostics cover only top-level steps, or also expose nested sub-step diagnostics inside union branches / repeat bodies? This affects how deep the editor can drill into problems.

2. **Error resilience behavior during editing** — What should the editor show when a step is half-configured (e.g., empty filter, blank edge)? Should it show warnings immediately, wait for the user to leave the field, or suppress diagnostics for incomplete steps?

3. **Diagnostic presentation mapping** — How should per-step diagnostic results map to visual indicators in the MQL editor's GEF edit parts? (e.g., icon decorators, tooltip text, colored borders, a problem list panel)

4. **Resolver API surface expansion** — Which individual-token validation methods (resolveEdge, resolveProperty, resolveKind) should be exposed on the public `IQueryResolver` interface vs kept internal?

Asked a question (Gray areas)

All four selected. Let's dive into each one.

---

### Area 1: Diagnostic granularity & nesting

The resolver currently resolves steps recursively — union branches and repeat bodies each contain their own step lists. The RESEARCH recommends top-level-only per-step breakdown for Phase 8, with nested diagnostics rolling up into the parent. But the editor already displays union branches and repeat bodies as distinct visual nodes.

Asked 4 questions (Nesting, Parent badge, Source node, Empty steps)

Asked a question (More Q1?)

Asked 4 questions (Recursion, Union branch, Limits res, Depth limit)

Clear decisions. So a flat `List<StepResolutionResult>` covering all steps at all nesting levels, with a top-level `Map<Step, StepResolutionResult>` (or lookup method) for O(1) identity-based retrieval. Each result is self-contained — no children.

Asked a question (More Q1b?)

---

### Area 2: Error resilience during editing

The resolver was originally designed for complete queries. During editing, steps can be half-configured — empty edges, null expressions, blank kind references. The resolver needs to handle these gracefully without throwing.

Asked 4 questions (Blank flds, Failed step, Fallback, Exceptions)

`REQUIRED_FIELD_MISSING` as a specific DiagnosticCode — yes, fully agree. It gives the GUI clean filterability: the editor can suppress or dim these diagnostics during active typing while still showing them in an overview. Good separation between "the user hasn't finished yet" vs "the user made a mistake."

And the stop-on-unresolvable-output-kind rule is clean: if a TraverseStep can't resolve its edge, the output kind is unknown, so downstream steps can't be meaningfully resolved → stop. But if a FilterStep has a bad predicate, the output kind is still the input kind (filtering doesn't change type) → continue.

Asked a question (More Q2?)

Asked 4 questions (Stop signal, Null source, Expr null, Repeat body)

Asked a question (More Q2b?)

Asked 4 questions (Union fail, Kind compat, Empty union, Edge cases)

Fair enough! Edge cases are on me. Let's move on.

Asked a question (More Q2c?)

---

### Area 3: Diagnostic presentation mapping

The MQL editor uses GEF edit parts to render query steps. Each step is a visual node. This area is about how resolution diagnostics map to visual indicators on those nodes.

Asked 4 questions (Visual cue, Tooltip, Problem list, Scope)

Asked 4 questions (Icon style, Severity, Position, Multi diag)

Asked a question (More Q3?)

Asked 4 questions (Source node, Refresh, Clear diag, Val trigger)

Asked a question (More Q3b?)

Asked 4 questions (Icons, Tooltip fmt, Init state, Query exec)

Asked a question (More Q3c?)

Asked 4 questions (Warn exec, Source diag, Anim, Last Q3)

---

### Area 4: Resolver API surface expansion

This is about which methods the public `IQueryResolver` interface should expose beyond the current `resolveQuery(Query)`.

Asked 4 questions (Expose edge, Expose prop, Expose kind, API guard)

Understood — the public API surface follows the AST node hierarchy: `resolveStep()`, `resolveExpr()` / `resolveValueExpr()`, `resolveKind()`, `resolveSource()` — not internal token-level methods. Consistent pattern.

Asked 4 questions (Resolve src, Resolve expr, Return type, IQResolver)

Considered return types for resolution methods:
> The user asks for my opinion on return types for > individual resolve methods.
>
> My recommendation: Use consistent result records > for each resolution method (same pattern as > StepResolutionResult). This gives a uniform API:
>
> resolveQuery(Query) → ResolutionResult (already > exists)
> resolveStep(Step, ResolvedKind) → > StepResolutionResult
> resolveExpr(Expr, ResolvedKind) → > ExprResolutionResult
> resolveSource(Source) → SourceResolutionResult
> resolveKind(String) → KindResolutionResult
> This approach is cleaner than the current pattern > of passing mutable diagnostic lists—each result > record is self-contained and callers don't need to > manage external state. For the public API, I'd go > with result records, though the internal > implementation can still use the mutable list > pattern and just wrap it.
>
> Now I'm weighing whether to create specific result > types for each resolution level or use a generic > parameterized approach. The tradeoff is between > having many small dedicated records versus a single > flexible generic type, though I need to be careful > about naming since ResolutionResult is already used > at the query level.
>
> Specific record types make more sense here—each one > can have its own convenience methods, they're > immediately clear about what they represent, and > they work better with Java's pattern matching than > generics would.

My opinion: go with specific result records for each node type — `StepResolutionResult`, `SourceResolutionResult`, `ExprResolutionResult`, `KindResolutionResult`. Each bundles `(input, resolved, diagnostics)`.

**Why not a generic `ResolutionResult<T>`:** Each record can have type-specific conveniences (e.g., `StepResolutionResult.hasErrors()`, `KindResolutionResult.isAmbiguous()`). Records don't lend themselves well to generics for pattern matching. And specific names are self-documenting.

**Why not keeping the mutable `List<Diagnostic>` parameter pattern:** The public API is cleaner when callers receive a self-contained result. No need to pre-create a list. The internal implementation can keep the existing mutable-list pattern and wrap it at the public boundary.

This also means `resolveQuery()` returns `ResolutionResult` (which should probably be renamed `QueryResolutionResult` for consistency, but that's a breaking name change — could be done or deferred).

Asked 3 questions (Approach, Rename, More Q4?)

> The user raises a good point. Let me think about this carefully.
>
> Current resolved types:
>
> ResolvedQuery — corresponds to Query
>
> ResolvedStep (sealed: FilterStep, TraverseStep, UnionStep, RepeatStep, UnsupportedStep) — corresponds to Step
>
> ResolvedSource (sealed: AllSource, ProvidedSource) — corresponds to Source
>
> ResolvedExpr — corresponds to Expr
>
> ResolvedKind — corresponds to KindRef / kind token
>
> ResolvedEdge — corresponds to edge token
>
> ResolvedProperty — corresponds to property token
>
> So I'd wrap each of these in a result type that bundles the original AST node, its resolved form, and any diagnostics encountered > during resolution. This gives us a consistent pattern across all the different resolution operations.
>
> But that's a lot of boilerplate — each wrapper just holds three fields with a 1:1 mapping to its corresponding Resolved type. The > user's suggestion makes sense: why not just add the diagnostics directly to the ResolvedXxx types themselves?
>
> The challenge is that many of these resolved types are sealed interfaces with multiple record implementations rather than simple > records. ResolvedStep, for instance, is a sealed interface with permits for FilterStep, TraverseStep, and others. Same pattern for > ResolvedSource with AllSource and ProvidedSource. So I'd need to add the diagnostics field to the interface and ensure all > implementations carry it, which adds complexity across the hierarchy.
>
> The real tension is between convenience and separation of concerns. Adding diagnostics directly would eliminate the wrapper types > and make diagnostics immediately accessible from the resolved form, but it couples the resolved model to resolution metadata. The > executor doesn't actually need diagnostics — only the editor does — so embedding them in ResolvedXxx means the executor carries > unused data and the clean boundary between the resolved model and resolution concerns gets blurred.
>
> I think the right call is to keep them separate and use the wrapper records. We're only talking about four small result types, > which is minimal overhead, and it avoids polluting every permit in the sealed interface with diagnostic fields that most of them > won't even use.
>
> The wrapper approach also preserves the original AST reference alongside the resolved form and diagnostics, which is genuinely > useful information that a flat lookup map wouldn't provide as cleanly. If the user wants per-step diagnostics accessible directly > from the resolved model, adding them to ResolvedXxx itself is the only way to achieve that—but then we're back to the pollution > problem. The issue is that ResolvedStep is a transformed model without a reference back to the original Step, so even if I add > diagnostics to it, the editor still needs a way to map from the original Step to find those diagnostics. I'm settling on keeping > ResolvedXxx clean and instead using thin result records that pair the original, resolved, and diagnostic information together—this > gives the editor what it needs without cluttering the resolved model itself.

----

Good challenge. Let me review the tradeoff carefully.

**Option A: Add `List<Diagnostic>` to ResolvedXxx directly**
- Fewer types, simpler API
- But `ResolvedStep` is a sealed interface → every permit record (FilterStep, TraverseStep, UnionStep, RepeatStep, UnsupportedStep) must carry `diagnostics`. That's noise for the executor, which never reads diagnostics.
- ResolvedXxx becomes coupled to the resolution process. Currently, ResolvedXxx is a clean, executor-ready model. Diagnostics are metadata *about* resolution, not part of the resolved model itself.
- The editor also needs the mapping `Step → diagnostics`. ResolvedXxx doesn't carry a reference back to the original `Step`, so the editor would still need a separate lookup structure.

**Option B: Separate XxxResolutionResult wrappers**
- ~4 small records: `StepResolutionResult`, `SourceResolutionResult`, `ExprResolutionResult`, `KindResolutionResult`
- Each bundles `(original AST node, resolved form, diagnostics)` — the three things the editor needs together
- Executor path untouched — continues to use `ResolvedQuery` with clean `ResolvedStep` list
- Separation of concerns: resolution metadata vs resolved model

**My recommendation: Option B.** The overhead is 4 small records. The benefit is keeping the executor's ResolvedXxx model clean and giving the editor exactly what it needs (original reference + diagnostics + resolved form) in a self-contained object. The alternative saves a few types but pollutes every sealed permit with a field the executor ignores and still doesn't solve the `Step → result` mapping problem without additional infrastructure.

Asked 3 questions (Final call, Lookup API, Naming)

Asked a question (More Q4b?)

Asked 4 questions (Expr result, Kind result, Map scope, Source map)

Asked a question (More Q4c?)

Asked a question (Create?)

One thing I've been thinking about: the `MqlValidationService` currently does ad-hoc validation (blank checks, colon-presence heuristics). With these decisions, it becomes a thin orchestrator calling `resolveQuery()` and distributing results. That's a natural consequence of the decisions, not a new choice — just flagging it since the planner will make it a task.

No other concerns from me. All four areas are fully explored. Creating CONTEXT.md now.

Ran terminal command:  cat > /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/phases/08-incremental-query-resolution-with-diagnostics/08-CONTEXT.md << 'CONTEXT_EOF'
# Phase 8: Partial and Incremental Query Resolution with Diagnostics Mapping - Context

**Gathered:** 2026-02-25
**Status:** Ready for planning

<domain>
## Phase Boundary

Enrich the MQL resolver to produce per-step resolution results — mapping each AST step to its resolved step and attributed diagnostics — so the MQL graphical editor can display real-time, per-node validation feedback during editing. Full re-resolution on every change (resolution is <1ms, no incremental caching needed). Scope includes both the engine-side API and the editor-side UI integration (GEF decorators, tooltips).

</domain>

<decisions>
## Implementation Decisions

### Diagnostic granularity & nesting

- **Full recursive breakdown**: Every sub-step inside union branches and repeat bodies gets its own `StepResolutionResult` with attributed diagnostics, not just top-level steps.
- **Flat list with path context**: All `StepResolutionResult` entries (including nested) go into a single flat structure. No tree nesting inside results.
- **Top-level lookup map**: `QueryResolutionResult` exposes `Map<Step, StepResolutionResult>` for O(1) identity-based retrieval. Map includes ALL steps at all nesting levels.
- **No bubble-up**: Parent union/repeat nodes show only their own direct diagnostics, NOT children's worst severity.
- **Source attribution**: Source node gets its own `SourceResolutionResult` via `QueryResolutionResult.sourceResult()` (separate field, not in the step map).
- **Immediate diagnostics for empty steps**: Freshly-added unconfigured steps immediately produce a WARNING or INFO diagnostic indicating configuration is needed.
- **Depth limits**: Warning at nesting depth 10, error at depth 20. These thresholds must be named constants in a visible location.

### Error resilience during editing

- **`REQUIRED_FIELD_MISSING` diagnostic code**: A specific `DiagnosticCode` value for blank/null required fields (edge token, kind ref, etc.). Enables GUI filtering of "not finished yet" vs "real error" diagnostics. Returns safe fallback, never throws.
- **Stop on unresolvable output kind**: If a step's resolution cannot produce an output kind (e.g., unknown edge in TraverseStep), stop resolving downstream steps. Downstream steps are absent from the result map (absence = not resolved).
- **Continue when output kind is preserved**: If a step fails but its output kind equals its input kind (e.g., FilterStep with null predicate), emit `REQUIRED_FIELD_MISSING` diagnostic and continue downstream resolution using the preserved kind.
- **Never throw exceptions**: The resolver always produces diagnostics, never throws back to the editor. All resolution methods wrap internal exceptions into ERROR diagnostics.
- **Null source**: Produce ERROR diagnostic + empty source result + resolve zero steps. No exception.
- **FilterStep null expression**: Emit `REQUIRED_FIELD_MISSING`, output kind = input kind, continue.
- **RepeatStep body failure**: If any step inside a repeat body fails (unresolvable output kind), stop all resolution including outer pipeline. Fatal.
- **UnionStep partial failure**: Failed branches stop internally; other branches continue; outer pipeline continues if at least one branch succeeded. Failed-branch steps are absent from result map.
- **Union incompatible output kinds**: Silently merge without diagnostic — incompatible union branches can be a legitimate need.
- **Empty UnionStep (zero branches)**: Emit `REQUIRED_FIELD_MISSING` diagnostic.

### Diagnostic presentation mapping

- **Icon decorator**: Small overlay icon on each step/source figure in the GEF canvas (top-right corner).
- **Three severity levels**: Error (red X), Warning (yellow triangle), Info (blue i). All three get visual indicators.
- **Worst severity icon**: When multiple diagnostics exist on one node, show only the worst severity icon.
- **Tooltip with all diagnostics**: Hovering shows severity-prefixed lines (e.g., "ERROR: Unknown edge 'foo'"), one per diagnostic.
- **No problem panel**: Diagnostics shown only on nodes, no separate summary panel.
- **Source node same treatment**: Source figure gets same icon decorator + tooltip pattern as step nodes.
- **Reuse platform icons**: Use `UIImages` constants from `org.modelio.platform.ui` bundle (may require adding dependency). See `/work/modelio/alouette/work/eclipse/modelio/platform/platform.ui/src/org/modelio/platform/ui/UIImages.java`.
- **Immediate refresh**: Re-resolve on every model change event (resolution is <1ms). No debouncing.
- **Event-driven**: Hook into `MqlQueryModel` PropertyChangeSupport events. No polling.
- **Decorators clear automatically**: When diagnostics are resolved, decorator simply disappears.
- **No animation**: Instant appear/disappear.
- **Resolve on dialog open**: Immediately resolve and show diagnostics when editor opens with existing query.
- **Execute disabled on errors**: Execute action disabled when any ERROR-level diagnostic exists.
- **Execute enabled on warnings only**: Warnings are informational, don't block execution.

### Resolver API surface expansion

- **Single `IQueryResolver` interface**: New methods added to existing interface, no splitting.
- **AST-node-level public methods**: Public API follows AST node hierarchy:
  - `resolveQuery(Query)` → `QueryResolutionResult` (rename of current `ResolutionResult`)
  - `resolveStep(Step, ResolvedKind)` → `StepResolutionResult`
  - `resolveExpr(Expr, ResolvedKind)` → `ExprResolutionResult`
  - `resolveSource(Source)` → `SourceResolutionResult`
  - `resolveKind(String token)` → `KindResolutionResult`
- **No token-level public methods**: `resolveEdge()` and `resolveProperty()` stay internal — `resolveStep()` handles them.
- **Option B: XxxResolutionResult wrappers**: Separate result record per AST node type. ResolvedXxx types stay clean (no diagnostics). Resolution results pair `(original, resolved, diagnostics)`.
  - `StepResolutionResult(Step, ResolvedStep, List<Diagnostic>)`
  - `SourceResolutionResult(Source, ResolvedSource, List<Diagnostic>)`
  - `ExprResolutionResult(Expr, ResolvedExpr, List<Diagnostic>)`
  - `KindResolutionResult(String token, ResolvedKind, List<Diagnostic>)`
- **Rename**: `ResolutionResult` → `QueryResolutionResult` for naming consistency.
- **No API versioning**: API is still in active development, no `@since` annotations.

### Copilot's Discretion

- **Icon rendering approach**: Choose easiest between Eclipse overlay decoration and custom GEF figure drawing.
- **MqlValidationService rewrite**: Thin orchestrator delegating to `IQueryResolver.resolveQuery()` — implementation structure is Copilot's choice.
- **Internal diagnostic collection strategy**: How `QueryResolver` internally accumulates per-step diagnostics before wrapping into result records.
- **StepResolutionResult convenience methods**: What helpers beyond `hasErrors()` to include.

</decisions>

<specifics>
## Specific Ideas

- Use `UIImages` constants from `platform.ui` bundle for error/warning/info icons — already centralized, no custom icon creation needed.
- `REQUIRED_FIELD_MISSING` as a specific `DiagnosticCode` to differentiate "editing in progress" from "genuine error" — enables smart filtering in the UI.
- Nesting depth constants (WARNING_DEPTH = 10, ERROR_DEPTH = 20) must be named constants in an easily discoverable location.
- The existing `MqlValidationService` was written before the resolver existed — it should now delegate entirely to the resolver rather than duplicating validation logic.

</specifics>

<deferred>
## Deferred Ideas

None — discussion stayed within phase scope.

</deferred>

---

_Phase: 08-incremental-query-resolution-with-diagnostics_
_Context gathered: 2026-02-25_
CONTEXT_EOF
echo "CONTEXT.md created"

CONTEXT.md created.

**Summary of decisions captured across 4 areas:**

| Area | Key Decisions |
|------|--------------|
| **Diagnostic granularity** | Full recursive breakdown, flat list, `Map<Step, StepResolutionResult>` lookup, source attribution, immediate diagnostics, depth limits (warn@10, error@20) |
| **Error resilience** | `REQUIRED_FIELD_MISSING` code, stop on unresolvable kind, continue on preserved kind, never throw, union partial failure, repeat body fatal |
| **Diagnostic presentation** | Icon decorators (top-right), 3 severity levels, worst-severity icon + full tooltip, reuse `UIImages`, immediate event-driven refresh, execute disabled on errors |
| **Resolver API surface** | `QueryResolutionResult` (rename), per-node-type result records (Option B), `resolveStep/resolveExpr/resolveSource/resolveKind` on `IQueryResolver`, single interface |

---

**Next steps:**

1. **Research** (`/research 8`) — already done (08-RESEARCH.md exists)
2. **Plan** (`/plan-phase 8`) — break phase into executable tasks using CONTEXT.md + RESEARCH.md