---
phase: "07-implement-i18n-the-modelio-way"
plan: "02"
subsystem: "i18n-migration"
tags: ["i18n", "internationalisation", "searchengineI18N", "diagnostics", "resolver", "executor"]

# Dependency graph
requires: ["07-01"]
provides: ["complete-i18n-migration", "externalized-diagnostic-messages"]
affects: []

# Tech tracking
tech-stack:
  added: []
  patterns: ["SearchEngineI18N.msg(key, args) for all user-visible diagnostics"]

# File tracking
key-files:
  created: []
  modified:
    - "src/org/modelio/platform/query/internal/resolver/KindResolver.java"
    - "src/org/modelio/platform/query/internal/resolver/EdgeResolver.java"
    - "src/org/modelio/platform/query/internal/resolver/PropertyKeyResolver.java"
    - "src/org/modelio/platform/query/internal/resolver/QueryResolver.java"
    - "src/org/modelio/platform/query/internal/executor/SourceEvaluator.java"
    - "src/org/modelio/platform/query/internal/executor/ExecutionBudget.java"
    - "src/org/modelio/platform/query/internal/executor/RepeatStepExecutor.java"
    - "../platform.search.engine.test/src/.../KindResolverTest.java"
    - "../platform.search.engine.test/src/.../PropertyKeyResolverTest.java"
    - "../platform.search.engine.test/src/.../BudgetExecutionTest.java"

# Decisions made
decisions:
  - key: "ambiguous-kind-rendering-dropped"
    choice: "Drop alternatives rendering from ambiguous diagnostic message"
    reason: "I18N pattern passes token + count only; per-alternative rendering was not in the properties key"

# Metrics
metrics:
  duration: "~15 minutes"
  completed: "2026-02-24"
---

# Phase 07 Plan 02: String Migration Summary

Migrate all hardcoded diagnostic string literals in `resolver/` and `executor/` packages to `SearchEngineI18N.msg(key, args)`.

**One-liner:** Externalized 15 diagnostic string literals across 7 source files using `SearchEngineI18N.msg()` — resolvers, executor budget, source evaluator, cycle detection fully I18N-ready.

## Tasks Completed

| # | Task | Files | Commit |
|---|------|-------|--------|
| 1 | Migrate resolver diagnostics | KindResolver, EdgeResolver, PropertyKeyResolver, QueryResolver | 6d95e31 |
| 2 | Migrate executor diagnostics | SourceEvaluator, ExecutionBudget, RepeatStepExecutor, StepPipelineExecutor (no change) | 2b68303 |
| 3 | Build verification + test assertions updated | build + KindResolverTest, PropertyKeyResolverTest, BudgetExecutionTest | d5cc663, 8228ed9 |

## Results

- **SearchEngineI18N.msg() occurrences**: 15 (requirement: ≥12) ✅
- **Build exit code**: 0 ✅
- **Test suite**: 109 run, 0 failures, 2 skipped ✅
- **Zero hardcoded diagnostic string literals** remaining in resolver/ and executor/ ✅

## Deviations from Plan

### Auto-fixed Issues

**1. [Rule 1 - Bug] Unused `Collectors` import removal in PropertyKeyResolver**

- **Found during:** Task 1
- **Issue:** After removing `Collectors.joining()` from the AMBIGUOUS_PROPERTY case, `import java.util.stream.Collectors` became unused.
- **Fix:** Removed the import to keep the file clean and avoid compiler warnings.
- **Files modified:** `src/org/modelio/platform/query/internal/resolver/PropertyKeyResolver.java`
- **Commit:** 6d95e31

**2. [Rule 2 - Missing Critical] BudgetExecutionTest also needed assertion updates**

- **Found during:** Task 3 (first test run)
- **Issue:** Plan listed 3 test files to update, but `BudgetExecutionTest.java` also contained `.contains("result limit")` assertions that now fail because `ExecutionBudget.getExhaustionCause()` returns the I18N key fallback.
- **Fix:** Updated 2 assertions in `BudgetExecutionTest` to use `.contains("MQL.executor.truncated.limit")`.
- **Files modified:** `../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/BudgetExecutionTest.java`
- **Commit:** 8228ed9

**3. [Info] Test file paths were in `engine/resolver/` not `resolver/`**

The plan referenced test file paths like `src/org/modelio/platform/query/resolver/KindResolverTest.java` but the actual paths are `src/org/modelio/platform/query/engine/resolver/KindResolverTest.java`. Located and updated the correct files.

**4. [Info] StepPipelineExecutor: no migration needed**

StepPipelineExecutor uses `budget.getExhaustionCause()` (a computed value from ExecutionBudget) rather than a direct string literal for the truncation diagnostic. No change needed, as the plan anticipated.

**5. [Info] Ambiguous kind alternatives rendering removed from I18N migration**

The old AMBIGUOUS_KIND message included rendered alternatives details (e.g., `"metaclass=Standard.Class"`). The I18N key pattern only passes `token` and `count`, dropping the per-alternative details in the message. The KindResolverTest assertions for `.contains("metaclass=Standard.Class")` and `.contains("stereotype=Class")` were removed accordingly. The kind alternatives are still available on the `ResolvedKind` object for programmatic use.

## Next Phase Readiness

Phase 7 is now complete:
- Plan 07-01: I18N infrastructure (properties files, SearchEngineI18N helper) ✅
- Plan 07-02: String migration (resolver + executor) ✅

All 15 diagnostic messages are externalized and localizable. The fallback behaviour in test context (key string returned) is consistent and tested.
