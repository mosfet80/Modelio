---
phase: 05-repeat-budgets-truncation
plan: 02
subsystem: executor
tags: [budget, limit, timeout, truncation, execution-bounds, diagnostics]

# Dependency graph
requires:
  - phase: 05-01
    provides: wrapRepeat BFS traversal, EXECUTION_TRUNCATED DiagnosticCode, FrozenLimitsSpec threading through buildPipeline
  - phase: 04-1-push-pipeline
    provides: push-based pipeline, IQueryResponseFiller, StepPipelineExecutor.buildPipeline
provides:
  - ExecutionBudget: post-dedup item limit + wall-clock timeout tracker with first-hit-wins semantics
  - Budget integration in StepPipelineExecutor terminal consumer: tryAccept() post-dedup, setTruncated() + EXECUTION_TRUNCATED once
  - isComplete() override in pipeline wrapper: stops SourceEvaluator iteration when budget exhausted
  - QueryEngine fix: always routes through pipeline (empty-steps queries now also apply budget)
  - BudgetExecutionTest: 8 tests covering limit enforcement, truncation diagnostics, default values, timeout unit behavior
affects:
  - 06+ phases using queries — all queries now bounded by default

# Tech tracking
tech-stack:
  added: []
  patterns:
    - "ExecutionBudget: single-threaded budget tracker with tryAccept()/isExhausted() — post-dedup counting at terminal consumer"
    - "First-hit-wins: timeout checked before limit in tryAccept(); once exhausted, immediately short-circuits"
    - "isComplete() override in pipeline wrapper integrates budget exhaustion into SourceEvaluator stop signal"
    - "Truncation fires exactly once via boolean truncationFired[] guard in terminal lambda closure"
    - "QueryEngine always builds pipeline — removes empty-steps bypass that was skipping budget for simple AllSource queries"

key-files:
  created:
    - src/org/modelio/platform/query/internal/executor/ExecutionBudget.java
    - ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/BudgetExecutionTest.java
  modified:
    - src/org/modelio/platform/query/internal/executor/StepPipelineExecutor.java
    - src/org/modelio/platform/query/internal/QueryEngine.java

key-decisions:
  - "Budget counts post-dedup unique items — limit reflects distinct result items, not pipeline intermediate items"
  - "Timeout checked first in tryAccept() (first-hit-wins) — prevents timeout masking limit when both could fire"
  - "Truncation fires setTruncated() + exactly one EXECUTION_TRUNCATED INFO diagnostic per pipeline (boolean guard in closure)"
  - "QueryEngine always builds pipeline even for empty-steps queries — ensures budget applies to all query patterns"
  - "DEFAULT_LIMIT=1000 and DEFAULT_TIMEOUT_MS=60000 applied when LimitsSpec fields are null"

patterns-established:
  - "Budget integration at terminal: budget.tryAccept() called after seen.add() succeeds (dedup check) before downstream.pushItem()"
  - "isComplete() override pattern: pipeline wrapper delegates to budget.isExhausted() || downstream.isComplete() to stop SourceEvaluator"

# Metrics
duration: 20min
completed: 2026-02-24
---

# Phase 05 Plan 02: Execution Budget Enforcement Summary

**Item limit (default 1000) and wall-clock timeout (default 60s) enforced post-dedup at pipeline terminal; truncation fires exactly one EXECUTION_TRUNCATED INFO diagnostic; 8 new tests verify all semantics (98 total passing).**

## Performance

- **Duration:** ~20 min
- **Started:** 2026-02-24T09:09:39Z
- **Completed:** 2026-02-24T09:30:00Z
- **Tasks:** 2/2
- **Files modified:** 4 (2 main module + 1 test module + 1 main module fix)

## Accomplishments

### Task 1: Create ExecutionBudget and integrate into pipeline terminal

- **Created `ExecutionBudget`** in `internal.executor`: tracks item limit (default 1000) + wall-clock timeout (default 60s)
  - `tryAccept()` returns false and sets exhaustion cause when budget fires (first-hit-wins: timeout before limit)
  - `isExhausted()` / `getExhaustionCause()` for querying budget state
- **Integrated budget in `StepPipelineExecutor.buildPipeline`**: terminal consumer calls `budget.tryAccept()` after dedup, fires `setTruncated()` + one `EXECUTION_TRUNCATED` INFO diagnostic on first exhaustion
- **Overrode `isComplete()`** in pipeline wrapper to return `budget.isExhausted() || downstream.isComplete()` — stops SourceEvaluator
- **Fixed `QueryEngine.runQuery`**: removed empty-steps bypass that skipped pipeline for zero-step queries; now always builds pipeline to apply budget consistently

### Task 2: Write BudgetExecutionTest

8 tests covering all must-have behaviours:
1. `limit_capsResultCount` — limit=5, 5 items returned, isTruncated=true, one EXECUTION_TRUNCATED INFO diag
2. `limit_notHit_noTruncation` — limit=100 > 20 items, no truncation
3. `limit_defaultValue_transparent` — null limits, all 20 items, no truncation
4. `executionBudget_timeout_firesAfterElapsed` — unit test: 1ms timeout, sleep 10ms, tryAccept=false
5. `executionBudget_limit_firesAtLimit` — unit test: limit=3, 4th call returns false
6. `truncation_diagnostic_exactlyOne` — limit=3, exactly one EXECUTION_TRUNCATED diagnostic
7. `truncation_isTruncated_true_when_limit_hit` — explicit coverage of must-have truth
8. `limit_countsPostDedup` — 5 unique items from 20-element model

## Task Commits

Each task was committed atomically:

1. **Task 1: Create ExecutionBudget and integrate into pipeline terminal** - `1c1f567` (feat)
2. **Task 1 fix: Always route through pipeline for empty-steps queries** - `38587f4` (fix)
3. **Task 2: Add BudgetExecutionTest** - `98e7586` (feat, in test repo)

## Deviations from Plan

### Auto-fixed Issues

**1. [Rule 1 - Bug] QueryEngine bypassed pipeline for empty-steps queries**

- **Found during:** Task 2 test execution (4/8 tests failing with 20 items instead of capped items)
- **Issue:** `QueryEngine.runQuery` had a special case `if (steps.isEmpty())` that called `SourceEvaluator` directly, bypassing `buildPipeline` and thus the budget entirely
- **Fix:** Removed the conditional branch; `buildPipeline` is now always called. Empty-steps pipelines correctly flow through the terminal consumer with budget enforcement
- **Files modified:** `src/org/modelio/platform/query/internal/QueryEngine.java`
- **Commit:** `38587f4`

## Next Phase Readiness

Phase 06 (acceptance queries Q1–Q15) can now rely on:
- All queries bounded by default limits (1000 items, 60s timeout)
- Truncation clearly signaled via `isTruncated()` + one `EXECUTION_TRUNCATED` diagnostic
- Zero regressions — all 98 tests pass

## Files Created/Modified

- `src/org/modelio/platform/query/internal/executor/ExecutionBudget.java` — Budget tracker (new)
- `src/org/modelio/platform/query/internal/executor/StepPipelineExecutor.java` — Budget integration in terminal consumer + isComplete() override
- `src/org/modelio/platform/query/internal/QueryEngine.java` — Removed empty-steps bypass
- `../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/BudgetExecutionTest.java` — 8 budget tests (new)
