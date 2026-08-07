---
phase: 08
plan: "02"
subsystem: query-resolution
tags: [resolution, diagnostics, error-resilience, per-step, REQUIRED_FIELD_MISSING, union, repeat]
requires:
  - "08-01: Per-node resolution result records (StepResolutionResult, QueryResolutionResult, etc.)"
provides:
  - "Full per-step diagnostic attribution in QueryResolver (every step has its own diagnostics list)"
  - "Error-resilient resolver: never throws, exceptions become ERROR diagnostics"
  - "REQUIRED_FIELD_MISSING on null/blank required fields (edge, predicate)"
  - "Null-source handling with ERROR diagnostic"
  - "Union partial failure: failed branches stop internally, outer pipeline continues"
  - "Repeat body failure: stops outer pipeline (fatal)"
  - "Depth limits: WARNING at >= 10, ERROR at >= 20"
  - "8 new diagnostic attribution tests passing"
affects:
  - "08-03: UI diagnostic decorators can now use stepResults for per-node visual feedback"
tech-stack:
  added: []
  patterns:
    - "resolveStepsWithBreakdown: recursive descent with identity-keyed stepResults map"
    - "resolveStepSafe: try/catch wrapper per step type — exception → ERROR diagnostic"
    - "Kind-preserving steps (FilterStep): continue downstream even on partial failure"
    - "Null/blank required field → REQUIRED_FIELD_MISSING diagnostic + controlled fallback"
key-files:
  created:
    - (test module) src/org/modelio/platform/query/engine/resolver/QueryResolverDiagnosticAttributionTest.java
  modified:
    - src/org/modelio/platform/query/internal/resolver/QueryResolver.java
    - src/org/modelio/platform/query/api/model/resolved/ResolvedStep.java
    - src/org/modelio/platform/query/api/model/resolved/SourceResolutionResult.java
    - res/modelsearch.properties
    - res/modelsearch_fr.properties
decisions:
  - "ResolvedStep.FilterStep: relaxed null constraint on predicate to allow partial resolution (null predicate = kind-preserving with REQUIRED_FIELD_MISSING)"
  - "SourceResolutionResult: relaxed null constraint on original to support null-source error case"
  - "Stop when resolved==null only (not on unknown outputKind) — backward-compatible with coverage test's UnknownEdge traverse"
  - "RepeatStep body failure: add ERROR diagnostic to repeat step itself + return null (stops outer pipeline)"
  - "Union branch success detection: branch succeeded if branchResolved is non-empty OR branch was empty"
metrics:
  duration: "~35 minutes"
  completed: "2026-02-26"
---

# Phase 08 Plan 02: Error-Resilient Per-Step Diagnostic Attribution — Summary

**One-liner:** QueryResolver rewritten with full per-step diagnostic collection — every AST node gets its own diagnostics, resolver never throws, REQUIRED_FIELD_MISSING on null/blank required fields, union/repeat failure semantics implemented, 8 new diagnostic attribution tests all pass.

## Tasks Completed

| # | Task | Commit | Status |
|---|------|--------|--------|
| 1 | Implement per-step diagnostic collection + error resilience in QueryResolver | 34a8388 | ✅ |
| 2 | Add diagnostic attribution tests + run tests | 4501820 (test repo) | ✅ |

## What Was Built

### Task 1: QueryResolver Error-Resilient Rewrite

**`QueryResolver.resolveQuery()`**: Completely replaced the bridge implementation from 08-01 with real per-step collection:
- Resolves source via `resolveSource(source)` → `SourceResolutionResult`
- Calls `resolveStepsWithBreakdown()` which populates an `IdentityHashMap<Step, StepResolutionResult>`
- Collects flat diagnostics list by union of source diagnostics + all step diagnostics
- Returns `QueryResolutionResult` with fully populated `stepResults` and `sourceResult`

**`resolveStepsWithBreakdown()` (new private method)**: Recursive descent that:
- Stops early (with depth ERROR) if `depth >= ResolutionLimits.ERROR_DEPTH`
- For each step calls `resolveStepSafe()`, puts result in `stepResults`
- If `result.resolved() == null` → breaks (stops downstream resolution)
- Otherwise, updates `currentKind` if outputKind is non-null and non-unknown (kind-preserving steps keep previous kind)

**`resolveStepSafe()` (new private method)**: Error-resilient dispatcher:
- Emits WARNING diagnostic if `depth >= WARNING_DEPTH`
- `switch(step)` dispatches to specific `resolveXxxSafe` methods
- Wraps all exceptions into ERROR diagnostics — never throws back to caller

**Step-specific safe methods (4 new private methods)**:
- `resolveFilterStepSafe()`: null predicate → REQUIRED_FIELD_MISSING + `FilterStep(null, currentKind)` (non-null resolved, kind-preserving)
- `resolveTraverseStepSafe()`: null/blank edge → REQUIRED_FIELD_MISSING + returns `null` (stops downstream)
- `resolveUnionStepSafe()`: empty branches → REQUIRED_FIELD_MISSING; partial failure → other branches continue; all fail → `null`
- `resolveRepeatStepSafe()`: body failure → ERROR diagnostic on repeat step + returns `null` (stops outer pipeline)

**`isKindPreservingStep()` (new private helper)**: Returns `true` for `FilterStep`, `false` otherwise.

**`resolveSource(Source)` (updated single-arg override)**: Handles `null` source → returns `SourceResolutionResult(null, null, [ERROR diagnostic])` without throwing.

**Record constraint relaxations**:
- `ResolvedStep.FilterStep`: removed null check on `predicate` (null allowed for partial resolution)
- `SourceResolutionResult`: removed null check on `original` (null allowed for null-source error case)

**I18n**: 9 new keys added to both `modelsearch.properties` and `modelsearch_fr.properties`:
- `MQL.resolver.depth.warning` / `MQL.resolver.depth.error`
- `MQL.resolver.step.exception`
- `MQL.resolver.field.missing`
- `MQL.resolver.source.null`
- `MQL.resolver.filter.no_predicate`
- `MQL.resolver.traverse.no_edge`
- `MQL.resolver.union.no_branches`

### Task 2: Diagnostic Attribution Tests (8 test cases)

New `QueryResolverDiagnosticAttributionTest.java` in test module:

| Test | Covers |
|------|--------|
| `testPerStepDiagnosticsAttribution` | Valid step in stepResults with empty REQUIRED_FIELD_MISSING diagnostics |
| `testTraverseBlankEdge_requiredFieldMissing` | Null edge → REQUIRED_FIELD_MISSING, resolved=null, downstream absent |
| `testFilterNullExpr_requiredFieldMissing_continuesDownstream` | Null predicate → kind-preserving, downstream continues |
| `testUnionEmptyBranches_requiredFieldMissing` | Empty union → REQUIRED_FIELD_MISSING |
| `testUnionPartialFailure_otherBranchesContinue` | Partial failure → valid branch continues, outer pipeline resumes |
| `testRepeatBodyFailure_stopsOuterPipeline` | Body failure → repeat has diagnostics, outer step absent |
| `testNullSource_errorDiagnostic` | Null source → ERROR diagnostic on SourceResolutionResult |
| `testResolverNeverThrows` | Non-existent kind → diagnostics not exception |

Tests run: 118, Failures: 0, Errors: 0, Skipped: 2.

## Decisions Made

| Decision | Rationale |
|----------|-----------|
| Stop when resolved==null only (not on unknown outputKind) | Backward-compatible with coverage test's `UnknownEdge` traverse; "stop on unresolvable" means the step itself could not be resolved (null), not that its outputKind is empty |
| RelaxedStep.FilterStep null predicate | Plan explicitly requires "return FilterStep with null predicate" for kind-preserving partial resolution |
| Relax SourceResolutionResult null original | Plan explicitly requires `new SourceResolutionResult(null, null, diags)` for null-source case |
| RepeatStep body failure adds ERROR diagnostic to repeat step | Tests can assert "repeat step has diagnostics"; makes partial diagnosis clearer without requiring callers to dig into body steps |
| Union "success" = branchResolved.isEmpty() OR branch.isEmpty() | Empty branches trivially succeed; non-empty branches producing nothing failed |

## Deviations from Plan

### Auto-fixed Issues

**1. [Rule 1 - Bug] ResolvedStep.FilterStep rejected null predicate from plan-required code**

- **Found during:** Task 1 — attempting to create `new ResolvedStep.FilterStep(null, currentKind)` per plan
- **Issue:** Compact constructor had `throw new IllegalArgumentException("predicate must not be null")`
- **Fix:** Removed null check on predicate, added comment explaining partial resolution use case
- **Files modified:** `src/org/modelio/platform/query/api/model/resolved/ResolvedStep.java`

**2. [Rule 1 - Bug] SourceResolutionResult rejected null original from plan-required code**

- **Found during:** Task 1 — attempting to return `new SourceResolutionResult(null, null, diags)` for null source
- **Issue:** Compact constructor had `throw new IllegalArgumentException("original must not be null")`
- **Fix:** Removed null check on original, updated Javadoc
- **Files modified:** `src/org/modelio/platform/query/api/model/resolved/SourceResolutionResult.java`

**3. [Rule 3 - Blocking] AllSource("") throws IAE in testResolverNeverThrows**

- **Found during:** Task 2 — test used `new AllSource("")` per plan's "extreme input" description
- **Issue:** AllSource constructor throws for blank kind name
- **Fix:** Changed test to use `"NonExistent.Kind.That.Does.Not.Exist"` (non-blank, but unresolvable kind)
- **Files modified:** `QueryResolverDiagnosticAttributionTest.java`

## Next Phase Readiness

Plan 08-03 (UI diagnostic decorators using stepResults for per-node visual feedback) can proceed:
- `QueryResolutionResult.stepResults()` fully populated with per-step `StepResolutionResult`
- `StepResolutionResult.diagnostics()` attributed specifically to each AST node
- `StepResolutionResult.resolved()` == null = stop-point for downstream resolution
- `SourceResolutionResult.diagnostics()` attributed to source node
