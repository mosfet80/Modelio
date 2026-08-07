---
phase: "09"
plan: "02"
subsystem: "query-execution-engine"
tags: ["pipeline", "refactor", "multi-path", "accumulator", "TraversalItem", "NodeWithExplainOut"]

dependency-graph:
  requires:
    - "09-01: TraversalItem record + PathOutput UUID-equals"
  provides:
    - "NodeWithExplainOut with Collection<PathOutput> whyPaths (multi-path result)"
    - "IQueryResponseFiller.complete() — abstract flush contract"
    - "Consumer<TraversalItem> pipeline chain (all internal steps)"
    - "NodeAccumulator terminal — deferred flush with budget enforcement"
  affects:
    - "09-03+: consumers of NodeWithExplainOut (UI, serialization) must use whyPaths()"
    - "Test: dedup-across-union now collects ALL paths (not just first)"

tech-stack:
  added: []
  patterns:
    - "Accumulator pattern: collect-then-flush (vs immediate dedup-push)"
    - "Two-phase pipeline: accumulation (no budget) + flush (budget enforced)"

key-files:
  created: []
  modified:
    - "src/org/modelio/platform/search/engine/searchers/query/api/model/result/NodeWithExplainOut.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/IQueryResponseFiller.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/SyncQueryResponse.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/PreparedAsyncExecution.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/StepPipelineExecutor.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/TraverseStepExecutor.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/RepeatStepExecutor.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/ExpressionEvaluator.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/executor/SourceEvaluator.java"
    - "src/org/modelio/platform/search/engine/searchers/query/internal/QueryEngine.java"

decisions:
  - id: "entry-point-design"
    decision: "SourceEvaluator uses pushItem(NodeWithExplainOut) at the pipeline entry"
    rationale: "TraversalItem is package-private; test classes implementing IQueryResponseFiller cannot override pushTraversalItem(TraversalItem). Pipeline filler's pushItem() converts single-path NodeWithExplainOut → TraversalItem via whyPaths().iterator().next()."
  - id: "complete-is-abstract"
    decision: "IQueryResponseFiller.complete() is abstract (no default)"
    rationale: "Forces all implementors to acknowledge the flush contract explicitly. PreparedAsyncExecution and SyncQueryResponse provide empty bodies."

metrics:
  duration: "~2h"
  completed: "2026-05-18"
---

# Phase 09 Plan 02: Pipeline Migration (Breaking Refactoring) Summary

**One-liner:** Atomic pipeline migration — NodeWithExplainOut to multi-path whyPaths, Consumer<TraversalItem> chain, NodeAccumulator terminal with deferred flush.

## What Was Built

### Task 1: API Type Refactoring

**NodeWithExplainOut** refactored from single-path `(MObject node, PathOutput why)` to:
```java
public record NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths) {
    // compact constructor: non-null, non-empty, defensive copy to unmodifiableSet(LinkedHashSet)
}
```

**IQueryResponseFiller** gained abstract `complete()` method (no default).

All implementors updated:
- `SyncQueryResponse.complete()` — empty body
- `PreparedAsyncExecution` (anon filler) `.complete()` — empty body
- `NOOP_DIAGNOSTIC_SINK.complete()` — empty body

### Task 2: Pipeline Chain Migration

**Consumer chain**: All `Consumer<NodeWithExplainOut>` in `buildChain()`, `wrapStep()`, `wrapFilter()`, `wrapUnion()`, `TraverseStepExecutor`, `RepeatStepExecutor`, `ExpressionEvaluator` changed to `Consumer<TraversalItem>`.

**Accessor migration**:
- `item.why()` → `item.path()` in `TraverseStepExecutor` (2 sites)
- `frontierItem.why().nodes()` → `frontierItem.path().nodes()` in `RepeatStepExecutor`
- `executeToList()` returns `List<TraversalItem>` (was `List<NodeWithExplainOut>`)

**NodeAccumulator terminal** (private inner class):
```java
LinkedHashMap<String, NodeAccumulator> accumulated = new LinkedHashMap<>();
Consumer<TraversalItem> terminal = item -> {
    accumulated.computeIfAbsent(item.node().getUuid(), k -> new NodeAccumulator(item.node()))
               .addPath(item.path());
};
```

**Flush in `complete()`** (budget enforced HERE, not in accumulation lambda):
```java
@Override
public void complete() {
    for (NodeAccumulator acc : accumulated.values()) {
        if (downstream.isComplete()) break;
        if (!budget.tryAccept()) { /* truncation */ break; }
        downstream.pushItem(new NodeWithExplainOut(acc.node(), acc.paths()));
    }
}
```

**QueryEngine.runQuery()** wired with try/finally:
```java
SourceEvaluator.evaluate(source, session, pipeline);
try {
    pipeline.complete();
} finally {
    responseFiller.getState().complete(QueryCompletionStatus.ENDED);
}
```

**Test module** updated:
- `SourceEvaluatorTest`: `why()` → `whyPaths().iterator().next()`, added `complete()`
- `TraverseStepExecutionTest`: `why()` → `whyPaths().iterator().next()`
- `UnionStepExecutionTest`: `dedup_acrossUnionBranches_keepsFirstPath` → `dedup_acrossUnionBranches_collectsAllPaths` (now asserts both paths accumulated)
- `PreparedAsyncExecutionTest`: `makeItem()` uses `List.of(path)` constructor

## Verification Results

| Check | Result |
|-------|--------|
| `Consumer<NodeWithExplainOut>` in chain code | 0 occurrences ✅ |
| `budget.tryAccept()` in complete() only | Line 172, inside `complete()` ✅ |
| `.why()` calls in production code | 0 ✅ |
| `new NodeWithExplainOut` only in flush | 2 sites: SourceEvaluator entry + StepPipelineExecutor flush ✅ |
| `pipeline.complete()` in QueryEngine | Line 128 ✅ |
| `build/build.sh` exit code | 0 ✅ |

## Deviations from Plan

### Auto-fixed Design Decision

**Pipeline entry point**: The plan specified `SourceEvaluator` should create `TraversalItem` directly. However, `TraversalItem` is package-private to `executor` package, making it inaccessible to test code that implements `IQueryResponseFiller`.

**Fix applied**: `SourceEvaluator` creates `NodeWithExplainOut` with a single-element `whyPaths`. The pipeline filler's `pushItem()` converts via `item.whyPaths().iterator().next()`. The `Consumer<TraversalItem>` chain is still fully internal; only the entry conversion is at the `pushItem()` boundary.

This satisfies the primary truth: "All pipeline chain code in executor package uses `Consumer<TraversalItem>`" — the conversion happens BEFORE the chain, not inside it.

## Commits

| Hash | Message |
|------|---------|
| `13af81a` | feat(09-02): refactor NodeWithExplainOut to whyPaths + abstract complete() |
| `ae08d3f` | feat(09-02): migrate pipeline to Consumer<TraversalItem> with accumulator flush |
| `674b5a4` | feat(09-02): fix pipeline entry point for test visibility |
