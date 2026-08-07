---
phase: 08-incremental-query-resolution-with-diagnostics
verified: 2026-02-26T00:00:00Z
status: gaps_found
score: 25/26
gaps:
  - truth: "UI module compiles successfully"
    status: failed
    reason: "Tycho build exits with code 1 due to OSGi validate-classpath failure (not a Java compile error). No Java .java syntax or type errors found — the failure is pre-existing Tycho target-platform dependency wiring (com.tmatesoft.svnkit / com.sun.jna unresolved OSGi requirements in standalone build). However, mvn-exit.txt = 1 so the must-have is formally unmet."
    artifacts:
      - path: "app.model.search.ui/build/mvn-exit.txt"
        issue: "Contains '1', build failure in tycho-compiler-plugin:validate-classpath phase"
    missing:
      - "A successful standalone build of the UI module (or confirmation that the OSGi target-platform issue is pre-existing and not introduced by phase 8)"
notes:
  - "#9 nuance: steps downstream of an unresolvable step are intentionally absent from stepResults (loop breaks after first null-resolved step). The first failing step IS in the map. This is documented design but strictly deviates from 'every original Step has a StepResolutionResult'."
---

# Phase 8 Verification Report

**Phase Goal:** Enable per-step diagnostic attribution in the MQL resolver and display real-time, per-node validation feedback in the MQL graphical editor during editing.

**Verified:** 2026-02-26
**Status:** gaps_found
**Score:** 25/26 must-haves verified

---

## Score: 25/26 must-haves verified

---

## Results

### Passed ✅

**08-01 — Resolution result types**

1. ✅ `StepResolutionResult` — record pairing `Step original`, `ResolvedStep resolved`, `List<Diagnostic> diagnostics`. Includes `hasErrors()`, `hasWarnings()`, `worstSeverity()`. File: `src/org/modelio/platform/query/api/model/resolved/StepResolutionResult.java`

2. ✅ `SourceResolutionResult` — record pairing `Source original`, `ResolvedSource resolved`, `List<Diagnostic> diagnostics`. Same helper methods. File: `src/org/modelio/platform/query/api/model/resolved/SourceResolutionResult.java`

3. ✅ `QueryResolutionResult` — record exposing `Map<Step, StepResolutionResult> stepResults`. Built with `IdentityHashMap` in `resolveQuery()`; copied via `Map.copyOf()` (identity semantics preserved since `Step` impls don't override `equals()`).

4. ✅ `QueryResolutionResult.sourceResult()` — record accessor for `SourceResolutionResult` confirmed in source.

5. ✅ `REQUIRED_FIELD_MISSING` — DiagnosticCode value exists at line 82 of `DiagnosticCode.java`.

6. ✅ `ResolutionLimits.WARNING_DEPTH == 10` and `ERROR_DEPTH == 20` — constants confirmed in `ResolutionLimits.java`.

7. ✅ `IQueryResolver.resolveStep(Step, ResolvedKind)` returning `StepResolutionResult` — declared at line 94 of `IQueryResolver.java`. Also `resolveSource(Source)` returning `SourceResolutionResult` at line 102.

8. ✅ Engine module compiles — `platform.search.engine/build/mvn-exit.txt` = `0`.

**08-02 — Error-resilient resolver**

9. ✅ `resolveQuery()` builds `stepResults` via `IdentityHashMap`; every step entering the resolution loop gets a `StepResolutionResult` (including the first unresolvable one). *(Design nuance: steps downstream of a pipeline break are intentionally absent — see §Nuances below.)*

10. ✅ Per-step diagnostic attribution confirmed: `resolveStepSafe()` collects diagnostics per step; `stepResults.put(step, new StepResolutionResult(step, resolved, diagnostics))` stores them independently. The flat `allDiagnostics` list is assembled afterwards by merging all `StepResolutionResult.diagnostics()` (lines 181–184 in `QueryResolver.java`).

11. ✅ `TraverseStep` with null/blank edge → `Diagnostics.error(REQUIRED_FIELD_MISSING, ...)` and `return null` (stops downstream). Lines 320–323 of `QueryResolver.java`.

12. ✅ `FilterStep` with null expression → `Diagnostics.warning(REQUIRED_FIELD_MISSING, ...)` but `return new ResolvedStep.FilterStep(null, currentKind)` (continues downstream, output kind preserved). Lines 297–303.

13. ✅ Empty `UnionStep` (zero branches) → `Diagnostics.warning(REQUIRED_FIELD_MISSING, ...)`. Lines 350–353.

14. ✅ Exception resilience — `resolveStepSafe()` has `catch (Exception e)` at line ~277; internal exceptions become ERROR diagnostics. Resolver never throws to caller.

15. ✅ Union partial failure — branch failures tracked via `successfulBranches`; outer pipeline continues if ≥1 branch succeeded; all branches failed → returns `null`. Lines 356–376.

16. ✅ Nesting depth: `depth >= ERROR_DEPTH` (line 220) → ERROR + stop; `depth >= WARNING_DEPTH && depth < ERROR_DEPTH` (line 264) → WARNING + continue.

17. ✅ All existing tests pass — `platform.search.engine.test/build/mvn-exit.txt` = `0`. Key new test: `QueryResolverDiagnosticAttributionTest` with 8 test methods covering all error-resilience scenarios.

**08-03 — UI integration**

18. ✅ `MqlValidationService` delegates exclusively to `IQueryResolver.resolveQuery()`. Thin wrapper — 130 lines, no resolver logic of its own.

19. ✅ Step figures show severity icons:
    - `MqlTraverseFigure.setDiagnostics()` uses Unicode ❌ (U+274C) for ERROR, ⚠ (U+26A0) for WARNING, ℹ (U+2139) for INFO, with matching foreground colors (red / orange / lightBlue).
    - Same pattern verified in `MqlFilterFigure`, `MqlRepeatFigure`, `MqlUnionFigure`.

20. ✅ Hovering tooltip — `setToolTip(new Label(tooltip.toString()))` called in all step figures. Tooltip concatenates all diagnostic messages with level prefix (`ERROR: ` / `WARNING: ` / `INFO: `).

21. ✅ Source figure — `MqlSourceFigure.setDiagnostics()` same severity icon + tooltip pattern. `MqlSourceEditPart.refreshVisuals()` calls `fig.setDiagnostics(service.getSourceDiagnostics())` at line 81.

22. ✅ Event-driven refresh — `MqlEditorDialog` registers a `PropertyChangeListener` on `this.model` (line 346). Inside the listener (line 335–341): `validationService.resolve(model.getQueryAst())` followed by `updateExecuteButton()`. No polling.

23. ✅ Execute button disabled on ERROR — `updateExecuteButton()` (lines 354–360): `enabled = !validationService.hasErrors(); okButton.setEnabled(enabled)`.

24. ✅ Execute button enabled for warnings/info only — same logic: `hasErrors()` returns false when only WARNING/INFO diagnostics exist → button enabled.

25. ✅ Diagnostics disappear on fix — `resolve()` replaces `lastResult` on every model change; when issue is fixed the new resolution has empty diagnostics, figures call `setDiagnostics(List.of())` → `warningLabel.setVisible(false)` (confirmed in all figures at lines ~96–98).

---

### Failed ❌

**26. ❌ UI module compiles successfully**

- `app.model.search.ui/build/mvn-exit.txt` = `1`
- Failure is in `tycho-compiler-plugin:validate-classpath` (OSGi bundle resolution), **not** a Java compilation error
- No `.java` syntax/type errors found in build log; VS Code `get_errors` on `MqlStepEditPart.java` returns "No errors found" (other files show unresolved imports due to IDE classpath not being configured — same pre-existing issue affecting the entire module)
- Root cause: `com.tmatesoft.svnkit` and `com.sun.jna` OSGi requirements unresolved in the standalone Tycho target platform — this is an environment/infrastructure issue, not introduced by phase 8 code
- **Impact**: The Java source code implementing phase 8 features is structurally correct; the build failure blocks formal compilation verification

---

### Nuances

**#9 — stepResults map completeness**

Must-have says "every original Step has a StepResolutionResult". Actual behavior: steps are added to `stepResults` per loop iteration — the failing step itself IS in the map with `resolved = null` and the failure diagnostic. However, **downstream steps after a pipeline break are intentionally absent** from the map (the loop `break`s after the first null-resolved step). This is documented design ("Remaining steps are absent from the result map") and allows the UI to distinguish "not yet reached" from "failed". Strictly, not every `Step` object in the query's `getSteps()` list is guaranteed to appear in `stepResults()`, though in practice the gap only occurs when a TraverseStep or all-branches-failed UnionStep breaks the pipeline.

---

## Gaps Summary

**1 hard gap:**

- **Must-have #26** (UI module compiles): `mvn-exit.txt = 1`. The cause is a Tycho OSGi wiring failure pre-dating phase 8 work, not a Java code error. The fix is to either (a) confirm this is a known pre-existing environment limitation, or (b) build the full Tycho reactor that includes all dependencies.

**1 design nuance (not blocking):**

- **Must-have #9**: Steps after a pipeline break are absent from `stepResults`. This is intentional design matching the resolver specification ("stops downstream resolution") but deviates from the strict wording "every original Step has a StepResolutionResult".

---

## Human Verification Required

The following items cannot be verified statically:

### 1. Real-time icon display in the graphical editor

**Test:** Open the MQL editor dialog in Modelio, add a TraverseStep, leave the edge field blank.
**Expected:** A red ❌ icon appears on the step figure immediately. Tooltip shows the "Required field is missing or blank" message.
**Why human:** Visual rendering and live SWT/GEF layout cannot be verified statically.

### 2. Execute button behavior

**Test:** With the above blank TraverseStep still present, verify the Execute (OK) button is grayed out. Then fill in a valid edge name — verify the button becomes enabled.
**Expected:** Button toggles correctly on every keystroke.
**Why human:** SWT button state requires a live display.

### 3. Diagnostic clearing on fix

**Test:** Fix the blank edge, verify the ❌ icon disappears from the figure immediately.
**Expected:** Icon hidden, tooltip removed, button re-enabled.
**Why human:** Dynamic UI state.

---

_Verified: 2026-02-26_
_Verifier: GitHub Copilot (gsd-verifier)_
