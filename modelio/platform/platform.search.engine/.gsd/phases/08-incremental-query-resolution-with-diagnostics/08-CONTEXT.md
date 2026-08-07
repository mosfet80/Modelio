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
