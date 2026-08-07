# Milestone v1.1: Urgent fixes and evolutions

**Status:** ⚠️ IN PROGRESS (Phase 9 complete, Phase 9.1 complete, Phase 10 next)
**Phases:** 9–10 (plus 9.1 decimal insertion)
**Requirements:** 8 (REQ-1 through REQ-4)
**Deadline:** 1 day preferred + urgent refactor
**Effort:** ~9.5 hours across 7 work items + Phase 9.1 refactor

## Overview

Enhance result explainability by returning all explanation paths per result instead of just the first one. v1.0 showed one path per discovered element; v1.1 collects complete enumeration (with budget bounds and timeout safety).

## Phase Roadmap

| # | Phase | Goal | Requirements | Success Criteria | Est. |
|---|-------|------|--------------|------------------|------|
| 9 | Multi-path API & Engine | Change `NodeWithExplainOut.why` to `Collection<PathOutput>` and implement path accumulation in pipeline | REQ-1, REQ-2 | ✓ All paths collected per result ✓ LinkedHashSet dedup working | 5h | ✅ COMPLETE |
| 9.1 | Code Review-Driven Refactor | Address critical findings from post-implementation code review: fix path silencing, correct dedup logic, simplify pipeline architecture | CODE-REVIEW | ✓ Silent path drop fixed ✓ globalEmitted polluted state resolved ✓ Streaming contract restored | 2h | ✅ COMPLETE |
| 10 | Budget & Test Integration | Timeout-safe path enumeration; update all acceptance tests to verify multi-path behavior | REQ-3, REQ-4 | ✓ Q1-Q15 pass with multiple paths ✓ Jackson tests pass ✓ Timeout truncation tested | 4.5h |

---

## Phase Details

### Phase 9: Multi-path API & Engine

**Goal:** Change `NodeWithExplainOut.why` from single `PathOutput` to `Collection<PathOutput>`, and implement path accumulation in the execution pipeline.

**Depends on:** Nothing (builds on v1.0 stable)

**Requirements Covered:**
- REQ-1-01: Multi-path API change
- REQ-2-01: Accumulate paths in pipeline terminal consumer
- REQ-2-02: Deduplicate paths by sequence

**Breakdown:**
1. Update `NodeWithExplainOut` record: change `why: PathOutput` → `whyPaths: Collection<PathOutput>` (LinkedHashSet)
   - Add validation: whyPaths must be non-empty
   - Add convenience method: `getSinglePath()` for helpers

2. Override `PathOutput.equals()/hashCode()` for sequence comparison
   - Two identical path sequences coalesce into one
   - Comparison based on node traversal route

3. Refactor `StepPipelineExecutor.buildPipeline()` terminal consumer
   - Add buffer `Map<String, Set<PathOutput>>` per node-UUID
   - Accumulate paths before flushing to downstream
   - Flush when moving to next node or on completion

4. Update direct callers of `NodeWithExplainOut` constructor
   - Change from single path to collection
   - SourceEvaluator, TraverseStepExecutor remain unchanged (push same way)

5. Verify Jackson serialization works with Collection<PathOutput>
   - JSON round-trip verification

**Success Criteria:**
1. NodeWithExplainOut compiles with Collection<PathOutput> field
2. Pipeline accumulates multiple paths for cyclic/multi-route graphs
3. Path dedup: identical sequences merge into single entry
4. No regressions: single-path queries produce single-element collections

**Effort:** ~5 hours

---

### Phase 9.1: Code Review-Driven Refactor (INSERTED)

**Goal:** Address critical correctness and architecture findings from code review of Phase 9 implementation. Simplify pipeline by removing inappropriate batching, restore streaming contract, and fix path silencing and dedup logic bugs.

**Depends on:** Phase 9 (completes Phase 9 intent)

**Context:**
The code review (see `.gsd/phases/09-multi-path-api-engine/09-code-review-after-debug.md`) identified four major issues with the `StepPipelineExecutor` implementation:

1. **Critical — Silent path drop**: Only first path extracted from multi-path source items; others discarded
2. **Important — Dedup pollution**: `globalEmittedUuids` marked "emitted" before actual `pushItem()` call
3. **Documentation — Stale Javadoc**: References non-existent `pushTraversalItem` method
4. **Architecture — Incorrect layering**: Batching and grouping forced into pipeline when they belong in response layer

**Design Rationale:**
The pipeline should be a **pure stream of (node, path) pairs** with no accumulation. Path grouping belongs in response-layer consumers (`SyncQueryResponse`, `PreparedAsyncExecution`), not in the pipeline. This restores the streaming contract and eliminates complexity.

**Breakdown:**
1. Remove batching infrastructure from `StepPipelineExecutor`
   - Delete `NodeAccumulator` inner class
   - Remove `currentBatch`, `globalEmitted` sets
   - Remove 3-step clear/run/flush cycle

2. Fix multi-path source handling
   - Iterate all source paths (not just first)
   - Generate one `TraversalItem` per source path
   - Let dedup happen at node-UUID level (not path level)

3. Simplify terminal consumer
   - Emit one `NodeWithExplainOut` per (node, path) pair
   - Budget tracks unique nodes (UUID-based dedup)
   - PathOutput.equals() handles path-level dedup

4. Update `SyncQueryResponse.pushItem()`
   - Accumulate results into `Map<MObject, NodeWithExplainOut>`
   - Merge paths from duplicate (node, path) pairs
   - Expose via `items()` as deduplicated collection

5. Update `PreparedAsyncExecution.pushItem()`
   - Fire handler immediately (no batching)
   - Same node may appear N times with different paths
   - Document contract in IASyncExecution.onItem() Javadoc

6. Fix Javadoc
   - Correct method reference (`pushTraversalItem` → `pushItem`)
   - Update class-level description to match new architecture
   - Document that "only first" applies to **cross-batch** dedup only

**Success Criteria:**
1. All critical correctness issues resolved
2. Pipeline emits all paths (none silently dropped)
3. Dedup logic is pure (no side effects before emission)
4. Streaming contract restored: `PreparedAsyncExecution` receives one event per (node, path)
5. `SyncQueryResponse` correctly deduplicates into Map<MObject, NodeWithExplainOut>
6. Javadoc accurate and complete
7. All existing tests pass (behavior change is internal to pipeline only)

**Plans:** 2 plans

Plans:
- [x] 09.1-01-PLAN.md — StepPipelineExecutor refactor (remove batching, streaming terminal)
- [x] 09.1-02-PLAN.md — SyncQueryResponse merge logic + Javadoc + test fixes

**Effort:** ~2 hours

---

### Phase 10: Budget & Test Integration

**Goal:** Implement timeout-safe path enumeration and update acceptance tests to verify multi-path behavior across Q1–Q15.

**Depends on:** Phase 9

**Requirements Covered:**
- REQ-2-03: Enumerate paths within budget constraints
- REQ-3-01: Timeout handling during path enumeration
- REQ-4-01: Update Q1-Q15 for multiple paths
- REQ-4-02: Jackson serialization tests
- REQ-4-03: API contract tests

**Breakdown:**
1. Add timeout check API to `ExecutionBudget`
   - `checkTimeout()` method for mid-accumulation checks
   - Non-stopping variant: just boolean return

2. Update pipeline timeout handling
   - Check timeout between each path accumulation
   - On timeout: flush accumulated paths + set truncation flag
   - Partial results are OK

3. Update acceptance tests Q1–Q15
   - Change: `result.why != null` → `result.whyPaths.size() >= 1`
   - Change: `assert pathCorrect(result.why)` → iterate `result.whyPaths`
   - Add cyclic graph test: verify N paths per node for cycles

4. Update Jackson tests
   - Expected JSON now has `"whyPaths": [...]` (array)
   - Round-trip: serialize multi-path result → deserialize → paths preserved

5. Contract tests
   - whyPaths never empty (record validation)
   - Paths maintain order across serialization
   - Same query = same path set (reproducible)

6. Verify dedup test
   - Two identical path sequences from different routes = 1 path
   - Sequences with different edges = separate paths

**Success Criteria:**
1. All Q1–Q15 tests pass with multiple paths
2. Timeout during path enumeration produces partial results (no error)
3. Jackson serialization round-trip preserves all paths
4. API contract enforced: no empty whyPaths collections
5. Cyclic graph produces N distinct paths per node

**Effort:** ~4.5 hours

---

## Requirements Traceability

| Requirement | Phase | Status |
|-------------|-------|--------|
| REQ-1-01: Multi-path API | 9 | Planned |
| REQ-2-01: Accumulate paths in pipeline | 9 | Planned |
| REQ-2-02: Deduplicate paths by sequence | 9 | Planned |
| REQ-2-03: Enumerate within budget | 10 | Planned |
| REQ-3-01: Timeout handling | 10 | Planned |
| REQ-4-01: Update Q1–Q15 | 10 | Planned |
| REQ-4-02: Jackson tests | 10 | Planned |
| REQ-4-03: API contracts | 10 | Planned |

**Coverage:** 100% (8/8 requirements mapped)

---

## Risk & Mitigation

| Risk | Mitigation |
|------|-----------|
| Path dedup expensive (object comparison) | Use LinkedHashSet with equals/hashCode override; profile on large cyclic graphs |
| Timeout mid-accumulation leaves partial paths | By design: acceptable. Set truncation flag. Document in release notes. |
| Breaking API change (why → whyPaths) | Accepted. No backward-compat needed. UI/tools will update. |
| Test count explosion | Only update Q1–Q15 + new cyclic test + serialization. No new QA tests. |

---

## Dependencies & Blockers

**None.** Both phases build on v1.0 stable codebase.

**Version Control:** v1.1 is release candidate by end of Phase 10.

---

_Last updated: 2026-05-18 — Roadmap created_
