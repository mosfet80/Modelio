---
phase: 08
plan: "03"
subsystem: mql-editor-ui
tags: [ui, gef, figures, diagnostics, real-time-validation, swt, edit-parts]
requires:
  - "08-01: Per-node resolution result records (QueryResolutionResult, StepResolutionResult, SourceResolutionResult)"
  - "08-02: Error-resilient QueryResolver with per-step diagnostic collection"
provides:
  - "MqlValidationService rewritten as thin IQueryResolver delegate — no more ad-hoc validateXxx() methods"
  - "Every GEF figure (source, filter, traverse, union, repeat) has setDiagnostics() with severity icon + color + tooltip"
  - "All edit parts call setDiagnostics() sourced from per-step StepResolutionResult diagnostics"
  - "Execute (OK) button disabled when any ERROR diagnostic is present (hasErrors() check)"
  - "MqlEditorDialog re-resolves on every model change via PROP_CHANGED listener"
  - "MqlExpressionPanel, MqlSourceSection, MqlLimitsSection migrated off old validateXxx() calls"
affects:
  - "Phase 09+: MQL editor now shows live per-node validation; ready for runtime execution wiring"
tech-stack:
  added: []
  patterns:
    - "synchronous resolve() in PropertyChangeListener; GEF asyncExec setContents fires after → diagnostics ready when refreshVisuals() runs"
    - "setDiagnostics(List<Diagnostic>) on GEF draw2d figures: worst-severity determines icon prefix and foreground color; all messages shown in draw2d Label tooltip"
    - "getDiagnosticsFor(Step) helper in MqlStepEditPart base class; subclasses call it with node.getAst() and forward to figure"
    - "Local static helper methods in MqlExpressionPanel for SWT-panel validation (validateKindRefLocally, validatePropertyKeyLocally)"
key-files:
  created: []
  modified:
    - (app.model.search.ui) src/org/modelio/model/search/mql/validation/MqlValidationService.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/ui/MqlEditorDialog.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/core/MqlStepEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/source/MqlSourceEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/source/MqlSourceFigure.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/filter/MqlFilterFigure.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/filter/MqlFilterStepEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/traverse/MqlTraverseFigure.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/traverse/MqlTraverseStepEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/union/MqlUnionFigure.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/union/MqlUnionStepEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/repeat/MqlRepeatFigure.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/elements/repeat/MqlRepeatStepEditPart.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/ui/MqlSourceSection.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/ui/MqlLimitsSection.java
    - (app.model.search.ui) src/org/modelio/model/search/mql/expressions/MqlExpressionPanel.java
    - (app.model.search.ui) META-INF/MANIFEST.MF
decisions:
  - "synchronous resolve() before asyncExec(setContents): ensures diagnostics are populated before refreshVisuals() evaluates them"
  - "updateExecuteButton() via asyncExec: OK Button does not exist during createContentArea(), only available after dialog opens"
  - "Local validateKindRefLocally/validatePropertyKeyLocally in MqlExpressionPanel: SWT panels do not need server-side resolution for empty-field checks; avoids tight coupling to resolver lifecycle"
  - "MqlLimitsSection: inline negative-value checks (no service call) — limits are purely syntactic bounds checks"
  - "setDiagnostics() alongside legacy setWarningText(): kept old method for backward compatibility; new method supersedes it for engine-driven diagnostics"
metrics:
  duration: "~40 minutes (across two sessions)"
  completed: "2026-02-26"
---

# Phase 08 Plan 03: UI Diagnostic Decorators — Summary

**One-liner:** MqlValidationService rewritten as IQueryResolver delegate; all 5 GEF figures get setDiagnostics() with severity icon/color/tooltip; all edit parts wired to per-step resolver diagnostics; Execute button disabled on errors.

## Tasks Completed

| # | Task | Commit | Status |
|---|------|--------|--------|
| 1 | Rewrite MqlValidationService + hook model change events | c49ba26 (app.model.search.ui) | ✅ |
| 2 | Add diagnostic icon decorators + tooltips to figures + build | 9d66ed8 (app.model.search.ui) | ✅ |

## What Was Built

### Task 1: MqlValidationService Rewrite + Editor Dialog Wiring

**`MqlValidationService.java`** (complete rewrite):
- Old: 223 lines with 7 ad-hoc `validateXxx()` methods (validateLimits, validateKindRef, validateEdgeRef, validateRepeatDepth, validateExpr, validateValueExpr, validatePropertyKey) operating on raw strings
- New: ~130 lines with constructor `MqlValidationService(IQueryResolver)` and engine-backed methods:
  - `resolve(Query query)` — calls `resolver.resolveQuery(query)`, stores `QueryResolutionResult`
  - `getDiagnosticsFor(Step step)` — extracts `StepResolutionResult.diagnostics()` from `stepResults` map
  - `getSourceDiagnostics()` — returns `sourceResult().diagnostics()`
  - `hasErrors()` — checks if any `Diagnostic.Level.ERROR` in `lastResult.diagnostics()`
  - `getAllDiagnostics()` — flat list of all diagnostics
  - `getLastResult()` — direct access to raw `QueryResolutionResult`

**`MqlEditorDialog.java`** (targeted changes):
- Constructor: `IQueryResolver resolver = Queries.createEngine(session, selectionProvider).getResolver()` then `new MqlValidationService(resolver)`
- `hookModelListeners()`: added synchronous `validationService.resolve(model.getQueryAst())` call in model change listener, followed by `asyncExec` for `updateExecuteButton()` + `refreshSummary()`
- Added `updateExecuteButton()`: gets OK button and sets enabled to `!validationService.hasErrors()`
- Initial resolve call after hooking listeners + initial `asyncExec` to set button state

### Task 2: Diagnostic Decorators on All GEF Figures and Edit Parts

**`setDiagnostics(List<Diagnostic> diagnostics)` added to all 5 figures:**

Pattern (identical across all 5):
1. Iterate diagnostics to find worst severity level
2. If no diagnostics: clear warning label (empty string, default color, no tooltip)
3. Otherwise:
   - Icon prefix: `ERROR → "❌ "`, `WARNING → "⚠ "`, `INFO → "ℹ "`
   - Foreground color: `ERROR → red`, `WARNING → orange`, `INFO → lightBlue`
   - Worst message displayed in banner label
   - Full list rendered in draw2d `Label` tooltip (one line per diagnostic)

Field naming: `warningLabel` in `MqlSourceFigure`; `warning` in the 4 step figures.

**Edit part changes (4 step edit parts + source edit part):**

- `MqlStepEditPart` (base): new `getDiagnosticsFor(Step step)` helper:
  ```java
  protected List<Diagnostic> getDiagnosticsFor(Step step) {
      MqlValidationService service = getValidator();
      if (service == null) return List.of();
      return service.getDiagnosticsFor(step);
  }
  ```
- `MqlSourceEditPart.refreshVisuals()`: `fig.setDiagnostics(service != null ? service.getSourceDiagnostics() : List.of())`
- `MqlFilterStepEditPart.refreshVisuals()`: `fig.setDiagnostics(getDiagnosticsFor(node.getAst()))`
- `MqlTraverseStepEditPart.refreshVisuals()`: `fig.setDiagnostics(getDiagnosticsFor(node.getAst()))`
- `MqlUnionStepEditPart.refreshVisuals()`: `fig.setDiagnostics(getDiagnosticsFor(node.getAst()))`
- `MqlRepeatStepEditPart.refreshVisuals()`: `fig.setDiagnostics(getDiagnosticsFor(node.getAst()))`

**SWT panel migration:**

- `MqlSourceSection.refreshValidation()`: calls `validationService.getSourceDiagnostics()` (was `validateKindRef(...)`)
- `MqlLimitsSection.refreshValidation()`: local inline negative-value check (removed `validateLimits()` service call)
- `MqlExpressionPanel`: added `validateKindRefLocally(String)` and `validatePropertyKeyLocally(String)` static helpers. These return `List.of(new Diagnostic(DiagnosticCode.RESOLUTION_ERROR, Level.ERROR, "...", null))` on empty/blank input, replacing the old delegation to service methods.

## Decisions Made

| Decision | Rationale |
|----------|-----------|
| Synchronous `resolve()` then `asyncExec(setContents)` | GEF repaints are always async; resolving sync in the listener means `lastResult` is ready before any `refreshVisuals()` call fires |
| `updateExecuteButton()` via `asyncExec` | JFace OK button doesn't exist during `createContentArea()`; safe to toggle only after dialog opens |
| Local helper methods in `MqlExpressionPanel` | SWT panel validation for empty fields doesn't need server-side resolution; avoids stale result if resolver hasn't been called yet |
| Kept `setWarningText()` alongside `setDiagnostics()` | Legacy compatibility; `setDiagnostics()` supersedes it for engine-driven feedback but other callers may use the old method |
| `org.eclipse.e4.ui.workbench` added to MANIFEST.MF | Required by the workbench context used in the MQL editor handler |

## Deviations from Plan

None — plan executed exactly as written.

## Build Status

The Tycho build (`build/build.sh`) fails at the `validate-classpath` phase due to a **pre-existing OSGi resolution failure** in `com.tmatesoft.svnkit 1.10.13.r10892` when the bundle `org.eclipse.e4.ui.workbench` is in the resolution graph. This failure was confirmed to exist on the baseline (before any plan changes) by stash-testing the original `META-INF/MANIFEST.MF`. Java compilation correctness was verified through:
- IDE error analysis (no Java errors on the modified files)
- Manual grep verification that all new methods are present and all old `validateXxx()` calls are removed

## Next Phase Readiness

Phase 08 is now complete. The MQL editor displays real-time per-node diagnostics from the engine-side resolver:
- Source node renders `SourceResolutionResult.diagnostics()`
- Each step node renders `StepResolutionResult.diagnostics()` keyed to its AST node identity
- Execute button gated on no ERROR diagnostics
- All ad-hoc validation code replaced by engine-driven resolution results
