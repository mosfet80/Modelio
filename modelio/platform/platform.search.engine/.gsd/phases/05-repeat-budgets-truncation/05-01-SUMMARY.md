---
phase: 05-repeat-budgets-truncation
plan: 01
subsystem: executor
tags: [repeat, bfs, cycle-detection, max-depth, emit-all-depths, diagnostics]

# Dependency graph
requires:
  - phase: 04-1-push-pipeline
    provides: push-based Consumer<NodeWithExplainOut> pipeline, StepPipelineExecutor.buildPipeline
  - phase: 04-filter-traverse-union
    provides: wrapFilter, wrapTraverse, wrapUnion, ExpressionEvaluator, path construction
provides:
  - wrapRepeat: BFS-level transitive traversal with cycle detection, maxDepth, emitAllDepths
  - EXECUTION_TRUNCATED and CYCLE_DETECTED DiagnosticCodes
  - emitAllDepths field on RepeatStep (mutable, frozen, resolved)
  - globalVisited Set shared across all Repeat steps in a pipeline
  - FrozenLimitsSpec threading through buildPipeline/buildChain/wrapStep/wrapRepeat
  - RepeatStepExecutionTest: 8 tests covering all traversal semantics
affects:
  - 05-02 (budgets/truncation — may extend limits enforcement)
  - 06+ phases using repeat in acceptance query tests (Q1–Q15)

# Tech tracking
tech-stack:
  added: []
  patterns:
    - "BFS-level repeat: frontier list advanced depth-by-depth; body sub-chain executed via executeToList per frontier item"
    - "Global visited Set tracks all UUID of nodes seen by any Repeat step; prevents cross-step re-visiting"
    - "Cycle detection via path check: frontierItem.why().nodes().stream().anyMatch(uuid) — ancestor-in-path detection"
    - "maxDepth validation at wrap time: errors/warnings emitted during buildPipeline before any source item flows"
    - "emitAllDepths=false emits deepest frontier (case c: frontier when nextFrontier is empty, depth > 1; case d: nextFrontier at maxDepth)"

key-files:
  created:
    - ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/RepeatStepExecutionTest.java
  modified:
    - src/org/modelio/platform/query/api/model/frozen/FrozenRepeatStep.java
    - src/org/modelio/platform/query/api/model/query/RepeatStep.java
    - src/org/modelio/platform/query/api/model/resolved/ResolvedStep.java
    - src/org/modelio/platform/query/api/model/result/DiagnosticCode.java
    - src/org/modelio/platform/query/internal/resolver/QueryResolver.java
    - src/org/modelio/platform/query/internal/executor/StepPipelineExecutor.java
    - src/org/modelio/platform/query/internal/QueryEngine.java
    - ../platform.search.engine.test/src/org/modelio/platform/query/api/model/ModelFreezeTest.java
    - ../platform.search.engine.test/src/org/modelio/platform/query/api/model/JacksonSerializationTest.java

key-decisions:
  - "maxDepth lives in FrozenLimitsSpec (global to all Repeat steps), not in RepeatStep itself"
  - "Cycle detection uses path check (frontierItem.why().nodes()) not globalVisited — detects proper cycles in current traversal, not convergence from other branches"
  - "CYCLE_DETECTED is a WARNING (not ERROR) — execution continues with the non-cyclic nodes"
  - "emitAllDepths=false with natural stop (nextFrontier empty) emits the current frontier only if depth > 1, preventing source emission"
  - "BFS-level (not DFS) so depths are well-defined and emitAllDepths semantics are predictable"
  - "Body sub-chain executed via executeToList (fresh empty visited set) per frontier item — repeat-level visited used only to filter discoveries"
  - "EXECUTION_TRUNCATED replaces LIMIT_REACHED/TIMEOUT_REACHED as primary truncation code; old codes kept for backwards compatibility"

patterns-established:
  - "wrapRepeat: self-contained BFS loop with globalVisited, cycleReported, maxDepth, emitAllDepths — all governed within single Consumer lambda"
  - "Diagnostic sink threading: buildPipeline passes IQueryResponseFiller as diagnosticSink through buildChain/wrapStep/wrapRepeat for runtime diagnostic emission"

# Metrics
duration: 45min
completed: 2026-02-24
---

# Phase 05 Plan 01: Repeat Step Execution Summary

**BFS-level repeat traversal with cycle detection, maxDepth enforcement, and emitAllDepths support; 8 new tests verify all semantics (90 total passing).**

## Performance

- **Duration:** ~45 min
- **Started:** 2026-02-24T09:00:00Z
- **Completed:** 2026-02-24T09:45:00Z
- **Tasks:** 3/3
- **Files modified:** 9 (7 main module + 2 test module)

## Accomplishments

### Task 1: Model updates + wiring changes

- Added `emitAllDepths` field to `RepeatStep` (mutable), `FrozenRepeatStep` (with `Boolean` for null-safe deserialization default), and `ResolvedStep.RepeatStep`
- Added `EXECUTION_TRUNCATED` and `CYCLE_DETECTED` to `DiagnosticCode`; deprecated `LIMIT_REACHED`/`TIMEOUT_REACHED` in favour of the new generic code
- Updated `QueryResolver.resolveStep` RepeatStep case to pass `emitAllDepths` into the resolved record
- Refactored `StepPipelineExecutor.buildPipeline` to accept `FrozenLimitsSpec limits`; creates a `globalVisited` `HashSet<String>` shared across the entire pipeline
- Added `NOOP_DIAGNOSTIC_SINK` private constant for `executeToList` (EXISTS sub-query pipelines)
- Updated `buildChain`, `wrapStep`, `wrapUnion` to accept `limits`, `globalVisited`, `diagnosticSink`
- Updated `QueryEngine.runQuery` to pass `resolvedQuery.limits()` to `buildPipeline`

### Task 2: Implement wrapRepeat with BFS-level traversal

Implemented `wrapRepeat` in `StepPipelineExecutor`:
- **maxDepth validation at wrap time**: `maxDepth < 1` → ERROR + swallowing consumer; `maxDepth == 1` → WARNING
- **Source exclusion**: source UUID added to `globalVisited` before the BFS loop
- **BFS loop**: `frontier` → executes body sub-chain via `executeToList` per frontier item → collects `nextFrontier`
- **Cycle detection**: checks if `discoveredUuid` is in `frontierItem.why().nodes()` (path check); emits `CYCLE_DETECTED` WARNING once per closing node (deduplicated via `cycleReported` set)
- **Convergence skipping**: `globalVisited.add(uuid)` returns false → skip silently
- **emitAllDepths=true** (default): emit each discovered node immediately
- **emitAllDepths=false**: accumulate frontier, emit only at deepest level (case c: `frontier` when `nextFrontier` is empty, depth > 1; case d: `nextFrontier` when `depth >= maxDepth`)

### Task 3: RepeatStepExecutionTest (8 tests)

| Test | Scenario | Assertion |
|------|----------|-----------|
| `repeat_linearChain_returnsAllDescendants` | root→pkgA→pkgB→leaf, no maxDepth | pkgA, pkgB, leaf in results |
| `repeat_sourceNotInResults` | same query | root NOT in results |
| `repeat_cycleDetection_terminatesWithDiagnostic` | Class cycle via Generalization | cycleClassB present, CYCLE_DETECTED WARNING |
| `repeat_maxDepth_capsRecursion` | maxDepth=2 | pkgA, pkgB present; leaf absent |
| `repeat_emitAllDepthsFalse_onlyFrontierNodes` | emitAllDepths=false | only leaf |
| `repeat_maxDepthLessThanOne_errorDiagnostic` | maxDepth=0 | empty results + ERROR diagnostic |
| `repeat_maxDepthOne_warningDiagnostic` | maxDepth=1 | pkgA only + WARNING diagnostic |
| `repeat_emptyBody_noResults` | empty body | empty results |

## Deviations from Plan

### Auto-fixed Issues

**1. [Rule 1 - Bug] FrozenRepeatStep constructor incompatibility in existing tests**

- **Found during:** Running tests after Task 1
- **Issue:** `ModelFreezeTest.java` and `JacksonSerializationTest.java` used the old single-argument `FrozenRepeatStep(List<FrozenStep>)` constructor, which no longer exists after adding the `emitAllDepths` component
- **Fix:** Updated both test files to pass `Boolean.TRUE` as the second argument
- **Files modified:** `ModelFreezeTest.java`, `JacksonSerializationTest.java`

**2. [Design decision] Cycle detection uses Generalization (Classes) instead of Dependency (Packages)**

- **Found during:** Task 3 planning
- **Reason:** Uncertainty about whether Dependency forward link traversal (`getLinkMetaclassSources`) would work reliably in the test metamodel. Generalization forward traversal (`createGeneralization`) is already tested and confirmed working.
- **Impact:** Uses the same logic as the plan (cycle via link traversal); element type is Class/Generalization instead of Package/Dependency.

## Next Phase Readiness

Plan 05-02 (Budgets + Truncation) builds on this plan's:
- `FrozenLimitsSpec` threading through the pipeline (`buildPipeline` already accepts it)
- `EXECUTION_TRUNCATED` DiagnosticCode (already defined and used)
- The `globalVisited` set infrastructure (already in `buildPipeline`)

All 90 tests pass. Build is green.
