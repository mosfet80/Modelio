---
phase: "09"
plan: "03"
subsystem: "test"
tags: ["PathOutput", "NodeWithExplainOut", "IQueryResponseFiller", "test-migration", "equality"]

dependency-graph:
  requires: ["09-01", "09-02"]
  provides: ["PathOutputTest", "migrated-test-suite"]
  affects: ["10-budget-test-integration"]

tech-stack:
  added: []
  patterns: ["JDK-Proxy-mock-with-UUID", "pre-cancel-before-run"]

key-files:
  created:
    - "../platform.search.engine.test/src/org/modelio/platform/query/api/model/result/PathOutputTest.java"
  modified:
    - "../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/PreparedAsyncExecutionTest.java"
    - "../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/QueryEngineExecutionTest.java"
    - "../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverCoverageTest.java"
    - "../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverDiagnosticAttributionTest.java"

decisions:
  - "PathOutputTest uses JDK Proxy mocks with explicit getUuid() returning unique non-null UUID strings"
  - "PathOutputTest sameNodesDifferentSteps test uses LinkPathStepOutput with distinct link proxies (identity-based record equals)"
  - "mockMObject() in PreparedAsyncExecutionTest extended with getUuid() to support PathOutput.hashCode()"
  - "cancel test redesigned: pre-cancel before run() rather than mid-run, matching buffered-pipeline architecture"
  - "QueryEngineExecutionTest ProvidedSource tests: explicit elements in ProvidedSource (selection-provider feature removed)"
  - "QueryResolverCoverageTest QUERY_PACKAGE corrected to org.modelio.platform.search.engine.searchers.query.api.model.query"
  - "QueryResolverDiagnosticAttributionTest: all imports corrected + inline cast corrected"

metrics:
  duration: "~45 minutes"
  completed: "2026-05-18"
---

# Phase 09 Plan 03: Test Migration + PathOutputTest Summary

PathOutput equality contract tests created; all test code migrated to multi-path API; full suite green.

## One-liner

PathOutputTest (UUID-based equality, 5 scenarios) + pre-existing import/mock bugs fixed; 123 tests pass, 2 skipped.

## Completed Tasks

### Task 1: Create PathOutputTest

Created `PathOutputTest.java` in the test module with 5 test scenarios:
- `sameUuidsDifferentRefs_areEqual`: different MObject proxy refs, same UUID → PathOutput equal + same hashCode
- `differentUuids_areNotEqual`: different UUIDs → PathOutput not equal
- `sameNodesDifferentSteps_areNotEqual`: same node UUIDs, different LinkPathStepOutput steps → not equal
- `equalsNull_returnsFalse`: null-safety
- `reflexive`: p.equals(p)

Uses JDK Proxy mocks returning specific UUIDs via `getUuid()`.

**Commit**: `be80e41` (test repo)

### Task 2: Migrate tests to multi-path API

The main test files (`TraverseStepExecutionTest`, `UnionStepExecutionTest`, `SourceEvaluatorTest`, `RepeatStepExecutionTest`) were already migrated in plan 09-02. This task fixed four pre-existing compilation/runtime failures caused by the `Modelio reverse` SVN commit:

1. **PreparedAsyncExecutionTest**: `mockMObject()` returned null from `getUuid()`. `NodeWithExplainOut` constructor now calls `PathOutput.hashCode()` via `LinkedHashSet` creation — NPE. Fixed: added `getUuid()` handler returning `"mock-uuid-" + identityHashCode`.

2. **QueryEngineExecutionTest**: 4 tests used a selection-provider pattern (engine configured with supplier; ProvidedSource with empty list delegating to supplier). Selection provider was removed from QueryEngine API. Fixed: tests now use ProvidedSource with explicit elements. The cancel test was redesigned to use pre-cancel (buffered pipeline doesn't stream items during source eval — only on `complete()`).

3. **QueryResolverCoverageTest**: `QUERY_PACKAGE` constant had old path `org.modelio.platform.query.api.model.query` (non-existent). Fixed: updated to real package path.

4. **QueryResolverDiagnosticAttributionTest**: All 18 imports used old `org.modelio.platform.query.*` paths + one inline cast. Fixed: all corrected to `org.modelio.platform.search.engine.searchers.query.*`.

**Commit**: `81289d9` (test repo)

## Deviations from Plan

### Auto-fixed Issues

**[Rule 1 - Bug] mockMObject() getUuid() returning null breaks NodeWithExplainOut constructor**

- **Found during**: Task 2 (first test run)
- **Issue**: `PreparedAsyncExecutionTest.mockMObject()` proxy handled only `isValid`, `isDeleted`, `equals`, `hashCode`, `toString` — `getUuid()` fell through to `return null`. `NodeWithExplainOut` constructor wraps paths in `LinkedHashSet` → `PathOutput.hashCode()` → `getUuid().hashCode()` → NPE.
- **Fix**: Added `if ("getUuid".equals(method.getName())) return "mock-uuid-" + System.identityHashCode(proxy);`

**[Rule 3 - Blocking] Pre-existing failures from Modelio reverse SVN commit**

Three additional files had wrong package paths / removed-feature dependencies:
- `QueryResolverDiagnosticAttributionTest`: wrong imports + inline cast
- `QueryResolverCoverageTest`: wrong QUERY_PACKAGE constant
- `QueryEngineExecutionTest`: selection-provider design removed from engine; cancel test incompatible with buffered pipeline

**[Rule 3 - Blocking] execute_cancel_stopsExecution redesigned for buffered pipeline**

- **Found during**: Task 2 (test still timing out after ProvidedSource fix)
- **Issue**: Test waited for first item to appear before cancelling. But `StepPipelineExecutor` accumulates all items during source evaluation and flushes on `complete()`. Items only reach `onItem` callbacks AFTER all source elements are consumed. The slow iterable caused 2.5s accumulation > 2s timeout.
- **Fix**: Redesigned to pre-cancel before `run()`. Once cancelled, `isComplete()` returns true, source evaluation loop exits immediately, state is `CANCELLED`.

## Verification Results

```
Tests run: 123, Failures: 0, Errors: 0, Skipped: 2
```

- No `.why()` calls remain in test sources
- `PathOutputTest.java` exists with 5 scenarios
- `complete()` present in `CollectingExecutionContext` (SourceEvaluatorTest)
- Exit code: 0

## Next Phase Readiness

Phase 09 plans 01-03 are complete. Phase 10 (Budget & Test Integration) can proceed.
