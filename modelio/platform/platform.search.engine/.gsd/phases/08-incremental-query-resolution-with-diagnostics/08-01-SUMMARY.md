---
phase: 08
plan: "01"
subsystem: query-resolution
tags: [resolution, diagnostics, records, api-surface, rename]
requires:
  - "07: Frozen query model and query AST finalized"
provides:
  - "Per-node resolution result records (Xnnn ResolutionResult wrappers)"
  - "QueryResolutionResult with stepResults map and sourceResult field"
  - "DiagnosticCode.REQUIRED_FIELD_MISSING"
  - "ResolutionLimits constants (WARNING_DEPTH=10, ERROR_DEPTH=20)"
  - "IQueryResolver 4 new per-node methods"
affects:
  - "08-02: error-resilient resolution uses the new API surface"
  - "08-03: UI diagnostic decorators use stepResults and sourceResult"
tech-stack:
  added: []
  patterns:
    - "Per-node resolution result records pairing (original, resolved, diagnostics)"
    - "Defensive copy in record compact constructors"
    - "Bridge implementation for incremental rollout of per-step diagnostics"
key-files:
  created:
    - src/org/modelio/platform/query/api/model/resolved/StepResolutionResult.java
    - src/org/modelio/platform/query/api/model/resolved/SourceResolutionResult.java
    - src/org/modelio/platform/query/api/model/resolved/ExprResolutionResult.java
    - src/org/modelio/platform/query/api/model/resolved/KindResolutionResult.java
    - src/org/modelio/platform/query/api/model/resolved/ResolutionLimits.java
    - src/org/modelio/platform/query/api/model/resolved/QueryResolutionResult.java
  modified:
    - src/org/modelio/platform/query/api/model/result/DiagnosticCode.java
    - src/org/modelio/platform/query/api/IQueryResolver.java
    - src/org/modelio/platform/query/internal/resolver/QueryResolver.java
    - src/org/modelio/platform/query/internal/QueryEngine.java
decisions:
  - "Bridge implementation: positional correlation of query.getSteps() with resolvedSteps for stepResults map (diagnostics will be attributed per-step in Plan 08-02)"
  - "SourceResolutionResult: separate field on QueryResolutionResult, not in the stepResults map"
  - "worstSeverity() relies on Diagnostic.Level ordinal ordering (INFO < WARNING < ERROR)"
metrics:
  duration: "~25 minutes"
  completed: "2026-02-26"
---

# Phase 08 Plan 01: Resolution Result Records and API Surface Expansion — Summary

**One-liner:** 6 new/modified Java files establish the per-node diagnostic attribution API surface (result records, renamed QueryResolutionResult with stepResults map, 4 new IQueryResolver methods, REQUIRED_FIELD_MISSING code, depth constants).

## Tasks Completed

| # | Task | Commit | Status |
|---|------|--------|--------|
| 1 | Create resolution result records + DiagnosticCode + nesting constants | b93ee4f | ✅ |
| 2 | Rename ResolutionResult → QueryResolutionResult + expand IQueryResolver + callers + build | 1301b46 | ✅ |

## What Was Built

### Task 1: Resolution Result Records

Five new Java files in `api/model/resolved/`:

- **`StepResolutionResult`** — `record(Step original, ResolvedStep resolved, List<Diagnostic> diagnostics)` with `hasErrors()`, `hasWarnings()`, `worstSeverity()` convenience methods.
- **`SourceResolutionResult`** — same pattern for `Source`/`ResolvedSource`.
- **`ExprResolutionResult`** — same pattern for `Expr`/`ResolvedExpr`.
- **`KindResolutionResult`** — same pattern for `String token`/`ResolvedKind`.
- **`ResolutionLimits`** — `WARNING_DEPTH = 10`, `ERROR_DEPTH = 20` named constants.

Plus `DiagnosticCode.REQUIRED_FIELD_MISSING("Required field is missing or blank")` added between `UNSUPPORTED_SOURCE` and `INTERRUPTED`.

### Task 2: QueryResolutionResult + IQueryResolver + Callers

- **`QueryResolutionResult`** — renamed from `ResolutionResult`, enriched with `SourceResolutionResult sourceResult` and `Map<Step, StepResolutionResult> stepResults` fields. `Map.copyOf()` used for defensive copy.
- **`IQueryResolver`** — 4 new per-node methods added: `resolveStep(Step, ResolvedKind)`, `resolveSource(Source)`, `resolveExpr(Expr, ResolvedKind)`, `resolveKind(String)`.
- **`QueryResolver`** — bridge implementation in `resolveQuery()` populates `stepResults` map by positional correlation, wraps source into `SourceResolutionResult`; 4 new delegating implementations wrapping private methods.
- **`QueryEngine`** — updated import and local variable type.
- **Test files (in test module)** — 4 resolver test files updated: import and local variable types.

## Decisions Made

| Decision | Rationale |
|----------|-----------|
| Bridge implementation (empty diagnostics in stepResults/sourceResult) | Allows compilation and existing tests to pass without full per-step diagnostic attribution (deferred to Plan 08-02) |
| Positional correlation for stepResults map | Top-level steps only for now; nested (union/repeat) coverage deferred to Plan 08-02 |
| `Map.copyOf()` for stepResults | Consistent with `List.copyOf()` pattern for defensive immutability |
| `worstSeverity()` uses `compareTo` | Relies on INFO(0) < WARNING(1) < ERROR(2) ordinal ordering in Diagnostic.Level |

## Deviations from Plan

None — plan executed exactly as written.

## Verification Results

- ✅ `grep -r "ResolutionResult" src/ --include="*.java"` returns only Xxx*ResolutionResult references
- ✅ `DiagnosticCode.REQUIRED_FIELD_MISSING` exists
- ✅ `ResolutionLimits.WARNING_DEPTH == 10`, `ERROR_DEPTH == 20`
- ✅ `IQueryResolver` has 4 new per-node methods
- ✅ `QueryResolutionResult` has `stepResults` map + `sourceResult` field
- ✅ Engine `build/build.sh` passed (exit code 0)

## Next Phase Readiness

Plan 08-02 (error-resilient resolution) can proceed immediately — the per-node public API is in place. The bridge implementation will be replaced with actual per-step/per-source diagnostic attribution.

Plan 08-03 (UI diagnostic decorators) depends on 08-02 for populated diagnostics in the stepResults map.
