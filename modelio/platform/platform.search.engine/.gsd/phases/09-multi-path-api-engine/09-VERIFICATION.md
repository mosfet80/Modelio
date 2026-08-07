---
phase: 09-multi-path-api-engine
verified: 2026-05-18T00:00:00Z
status: passed
score: 25/25 must-haves verified
---

# Phase 9: Multi-path API & Engine — Verification Report

**Phase Goal:** Change `NodeWithExplainOut.why` from single `PathOutput` to `Collection<PathOutput>`, and implement path accumulation in the execution pipeline.
**Verified:** 2026-05-18
**Status:** ✓ PASSED
**Re-verification:** No — initial verification

---

## Goal Achievement

### Observable Truths

| # | Truth | Status | Evidence |
|---|-------|--------|----------|
| 1 | `TraversalItem` is a package-private record with `(MObject node, PathOutput path)` fields | ✓ VERIFIED | `record TraversalItem(MObject node, PathOutput path)` in `.internal.executor` |
| 2 | `TraversalItem` compact constructor validates non-null | ✓ VERIFIED | `Objects.requireNonNull` for both fields |
| 3 | `PathOutput.equals()` uses UUID comparison via `getUuid()` | ✓ VERIFIED | Loop calls `this.nodes.get(i).getUuid()` |
| 4 | `PathOutput.hashCode()` consistent with UUID-based equals | ✓ VERIFIED | Accumulates `node.getUuid().hashCode()` |
| 5 | `PathOutput.equals()` has Javadoc explaining UUID deviation + TODO | ✓ VERIFIED | Full Javadoc + `// TODO: migrate to MObject.equals() when test mocks are fixed` |
| 6 | `NodeWithExplainOut.whyPaths` is `Collection<PathOutput>`, no `why()` accessor | ✓ VERIFIED | `public record NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths)` — no `why()` method found |
| 7 | `NodeWithExplainOut` compact constructor validates non-null, non-empty, defensive copy | ✓ VERIFIED | `requireNonNull`, `isEmpty()` check, `Collections.unmodifiableSet(new LinkedHashSet<>(whyPaths))` |
| 8 | `IQueryResponseFiller.complete()` is abstract (no `default`) | ✓ VERIFIED | No `default` keyword on `complete()` in interface |
| 9 | `SyncQueryResponse` and `NOOP_DIAGNOSTIC_SINK` implement `complete()` with empty body | ✓ VERIFIED | Both have `@Override public void complete() { }` |
| 10 | Pipeline chain code uses `Consumer<TraversalItem>`, not `Consumer<NodeWithExplainOut>` | ✓ VERIFIED | All `buildChain`, `wrapStep`, `wrapFilter`, `wrapUnion` use `Consumer<TraversalItem>`; `Consumer<NodeWithExplainOut>` only in `PreparedAsyncExecution` external API handlers |
| 11 | `buildPipeline()` terminal uses `LinkedHashMap<String, NodeAccumulator>` keyed by UUID | ✓ VERIFIED | `LinkedHashMap<String, NodeAccumulator> accumulated = new LinkedHashMap<>()` with `item.node().getUuid()` key |
| 12 | `NodeAccumulator` is a `private static` inner class with `MObject node` + `LinkedHashSet<PathOutput> paths` | ✓ VERIFIED | `private static final class NodeAccumulator` with both fields |
| 13 | Flush in `complete()` creates `NodeWithExplainOut` from accumulated paths, pushes to downstream | ✓ VERIFIED | `downstream.pushItem(new NodeWithExplainOut(acc.node(), acc.paths()))` |
| 14 | `budget.tryAccept()` called ONLY in `complete()`, NOT in accumulation lambda | ✓ VERIFIED | Terminal lambda only calls `computeIfAbsent`/`addPath`; `budget.tryAccept()` only in `complete()` |
| 15 | `QueryEngine.runQuery()` calls `pipeline.complete()` after source evaluation, before state completion | ✓ VERIFIED | `pipeline.complete()` in try-block after `SourceEvaluator.evaluate()`; `getState().complete()` in finally |
| 16 | `executeToList()` returns `List<TraversalItem>` — no flush, no `complete()` | ✓ VERIFIED | Collects to `ArrayList`, no `complete()` call |
| 17 | `PathOutputTest` exists with UUID-based equality and hashCode contract tests | ✓ VERIFIED | File exists at `src/org/modelio/platform/query/api/model/result/PathOutputTest.java` |
| 18 | `PathOutputTest.sameUuidsDifferentRefs_areEqual` verifies equal + same hashCode | ✓ VERIFIED | Test present and uses different proxy refs with same UUID |
| 19 | `PathOutputTest.differentUuids_areNotEqual` verifies inequality | ✓ VERIFIED | Test present |
| 20 | No `.why()` calls remain in tests | ✓ VERIFIED | `grep -rn ".why()"` returns zero results |
| 21 | `.whyPaths()` used correctly in tests | ✓ VERIFIED | 7 call-sites in `SourceEvaluatorTest`, `TraverseStepExecutionTest`, `UnionStepExecutionTest` |
| 22 | `new NodeWithExplainOut(node, path)` calls migrated to `Collection` form | ✓ VERIFIED | Only occurrence: `new NodeWithExplainOut(obj, List.of(path))` — accepts `Collection<PathOutput>` |
| 23 | Test fakes implementing `IQueryResponseFiller` have `complete()` | ✓ VERIFIED | `CollectingExecutionContext` in `SourceEvaluatorTest` implements `complete()`; only concrete fake |
| 24 | Production build exits 0 | ✓ VERIFIED | `build/build.sh` → exit code 0 |
| 25 | All tests compile and pass | ✓ VERIFIED | 123 tests run, 0 failures, 0 errors |

**Score: 25/25 truths verified**

---

## Required Artifacts

| Artifact | Status | Details |
|----------|--------|---------|
| `TraversalItem.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | Package-private record, compact constructor with null checks |
| `PathOutput.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | UUID-based `equals`/`hashCode`, Javadoc + TODO |
| `NodeWithExplainOut.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | `Collection<PathOutput> whyPaths`, defensive copy in compact constructor |
| `IQueryResponseFiller.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | Abstract `complete()` (no default) |
| `SyncQueryResponse.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | Empty `complete()` override |
| `StepPipelineExecutor.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | `NodeAccumulator`, flush in `complete()`, `budget.tryAccept()` in flush only |
| `QueryEngine.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | `pipeline.complete()` in try-block before finally |
| `PathOutputTest.java` | ✓ EXISTS, SUBSTANTIVE, WIRED | 5 tests covering equals/hashCode contract |

---

## Key Link Verification

| From | To | Via | Status |
|------|----|-----|--------|
| `SourceEvaluator` | `StepPipelineExecutor` pipeline | `pushItem(NodeWithExplainOut)` → chain head | ✓ WIRED |
| `StepPipelineExecutor.buildPipeline()` terminal | `NodeAccumulator` | `computeIfAbsent` + `addPath` | ✓ WIRED |
| `StepPipelineExecutor.complete()` | `downstream.pushItem` | `new NodeWithExplainOut(acc.node(), acc.paths())` | ✓ WIRED |
| `QueryEngine.runQuery()` | `pipeline.complete()` | After `SourceEvaluator.evaluate()`, before `getState().complete()` | ✓ WIRED |
| `PathOutputTest` | `PathOutput.equals/hashCode` | Proxy-based UUID mocks | ✓ WIRED |

---

## Anti-Patterns Found

None. No TODOs blocking goal achievement (only the intentional `// TODO: migrate to MObject.equals()` which is documented and non-blocking).

---

## Human Verification Required

None. All must-haves are verifiable programmatically and all checks pass.

---

## Summary

Phase 9 goal is fully achieved. `NodeWithExplainOut.whyPaths` is a `Collection<PathOutput>` with proper validation and defensive copy. Path accumulation is implemented in `StepPipelineExecutor` via `NodeAccumulator` and flushed in `complete()`. `budget.tryAccept()` is correctly isolated to the flush phase. `IQueryResponseFiller.complete()` is abstract, forcing all implementations to provide it. The production module builds cleanly and all 123 tests pass.

---

_Verified: 2026-05-18_
_Verifier: Copilot (gsd-verifier)_
