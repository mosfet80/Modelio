# Refactoring Design — Pipeline Simplification & Layer Correction

**Context:** This document captures the design decision reached after the code review of
`StepPipelineExecutor` (see `09-code-review-after-debug.md`). It is intended as input for an agentic refactoring workflow.


---
**agentic note**

 Avoid 'xargs' and 'find ... -exec' commands , I have to approve them each. ripgrep is available instead.

---

## Problem Statement

`StepPipelineExecutor.buildPipeline()` currently performs **path grouping** (batching all
`PathOutput` instances for the same node into a `NodeAccumulator`) before forwarding to the
downstream `IQueryResponseFiller`. This is the wrong layer:

- `PreparedAsyncExecution.pushItem()` → fires `notifyItemHandlers(item)` immediately.
  It is a pure event bus, zero accumulation.
- `SyncQueryResponse.pushItem()` → `this.items.add(item)`. Pure list append.

Neither consumer requests or needs grouped results. The grouping was imposed from below
by the pipeline, adding complexity and a **batch-flush delay** that defeats the streaming
contract of `PreparedAsyncExecution`.

---

## Root Cause of Complexity

`NodeWithExplainOut` was changed (phase 09) to hold `Collection<PathOutput>` instead of a
single `PathOutput`. This forced the pipeline to group paths before emitting, because
`NodeWithExplainOut` must be non-empty. The fix belongs at the response layer, not the
pipeline.

---

## Target Design

### Principle

> The pipeline is a **pure stream of (node, path) pairs**. Grouping and deduplication are
> **response-layer concerns**.

### Data Flow

```
Source generator
  │  pushItem(NodeWithExplainOut(node, singlePath))
  ▼
StepPipelineExecutor  [budget + path dedup only]
  │  terminal: downstream.pushItem(new NodeWithExplainOut(item.node(), List.of(item.path())))
  │  one NodeWithExplainOut per (node, path) pair discovered
  ▼
IQueryResponseFiller implementation
  │
  ├── PreparedAsyncExecution  →  fires onItem handler immediately, one event per (node, path)
  │                              same node may appear multiple times with different paths
  │                              (document in IASyncExecution.onItem() Javadoc)
  │
  └── SyncQueryResponse  →  merges by node into LinkedHashMap<MObject, NodeWithExplainOut>
                             items() returns one entry per unique node with all its paths
```

---

## Changes Required

### 1. `StepPipelineExecutor` — remove batching, simplify

**Remove entirely:**
- `NodeAccumulator` inner class
- `currentBatch: LinkedHashMap<String, NodeAccumulator>`
- The 3-step clear/run/flush cycle in `pushItem()`
- `globalEmitted: Set<MObject>` (cross-batch dedup set)
- Import of `LinkedHashMap`, `Collection`, `LinkedHashSet`, `PathOutput`

**Replace `pushItem()` body with:**

```java
@Override
public void pushItem(NodeWithExplainOut item) {
    if (isComplete()) return;
    // Feed all source paths into the chain
    for (PathOutput sourcePath : item.whyPaths()) {
        if (isComplete()) break;
        chainHead.accept(new TraversalItem(item.node(), sourcePath));
    }
}
```

**Replace terminal consumer with:**

```java
// Terminal: emit immediately, one NodeWithExplainOut per (node, path) pair.
// Budget counts unique nodes; path-level dedup is handled by PathOutput.equals().
Set<String> emittedNodeUuids = new HashSet<>();

Consumer<TraversalItem> terminal = item -> {
    if (downstream.isComplete()) return;
    String uuid = item.node().getUuid();
    boolean isNewNode = emittedNodeUuids.add(uuid);
    if (isNewNode && !budget.tryAccept()) {
        if (!truncationFired[0]) {
            truncationFired[0] = true;
            downstream.setTruncated();
            downstream.pushDiagnostic(Diagnostics.info(DiagnosticCode.EXECUTION_TRUNCATED,
                    budget.getExhaustionCause()));
        }
        return;
    }
    downstream.pushItem(new NodeWithExplainOut(item.node(), List.of(item.path())));
};
```

Note: `budget.tryAccept()` is only called for new nodes (first path). Subsequent paths
for the same node are emitted without consuming budget.

**`complete()` implementation:**

```java
@Override
public void complete() {
    // Pure streaming — nothing to flush.
}
```

**`isComplete()` stays as-is:**

```java
@Override
public boolean isComplete() {
    return budget.isExhausted() || downstream.isComplete();
}
```

**Net result:** `buildPipeline()` loses ~40 lines; `NodeAccumulator` class (~30 lines)
is deleted entirely. `StepPipelineExecutor` becomes straightforward.

---

### 2. `SyncQueryResponse` — add per-node merging

Replace the `List<NodeWithExplainOut> items` with a `LinkedHashMap` that merges paths
on arrival.

```java
// Field change:
private final LinkedHashMap<MObject, NodeWithExplainOut> itemsByNode = new LinkedHashMap<>();

// pushItem:
@Override
public void pushItem(NodeWithExplainOut item) {
    this.itemsByNode.merge(item.node(), item, (existing, incoming) -> {
        Set<PathOutput> merged = new LinkedHashSet<>(existing.whyPaths());
        merged.addAll(incoming.whyPaths());
        return new NodeWithExplainOut(existing.node(), merged);
    });
}

// items():
@Override
public List<NodeWithExplainOut> items() {
    return new ArrayList<>(this.itemsByNode.values());
}
```

`SyncQueryResponse` now owns the grouping responsibility. The result is one
`NodeWithExplainOut` per unique node, with all discovered paths.

---

### 3. `PreparedAsyncExecution` — document streaming semantics

No code change needed. Add Javadoc to `IASyncExecution.onItem()` (or the `onItem` method
of `PreparedAsyncExecution`) stating:

> The handler may be called multiple times for the same node if it is reachable via
> multiple paths. Each invocation carries a single-path `NodeWithExplainOut`.
> Callers that want one notification per unique node should deduplicate by `node().getUuid()`.

---

### 4. `NodeWithExplainOut` — no change

Keep `Collection<PathOutput> whyPaths` as the public API type. A single-path item
constructed with `List.of(path)` satisfies the existing `!whyPaths.isEmpty()` guard.
The multi-path form is still produced by `SyncQueryResponse` after merging.

---

### 5. `TraversalItem` — no change

Keep as-is. It remains the internal single-path pipeline token. Its type-enforced
single-path invariant is still valuable within the chain.

---

### 6. `IQueryResponseFiller.complete()` — reconsider

With no deferred flushing anywhere, `complete()` is now a no-op everywhere. Consider
whether the method is still needed on the interface, or whether it should be kept as
an extension point for future implementations that do accumulate (e.g., a future
deduplicating wrapper). If kept, ensure all implementations retain a no-op body.

---

## Issues Resolved by This Refactoring

| Issue (from code review) | Resolution |
|--------------------------|------------|
| 🔴 Silent path drop — only first `whyPaths` path used | Fixed: `pushItem()` loops over all paths |
| 🟡 `globalEmittedUuids` polluted before actual emission | Eliminated: no batch loop |
| 🟡 Class-level Javadoc contradicts implementation | Simplified: streaming javadoc, no batch wording |
| 🟢 Pipeline batching delays `PreparedAsyncExecution` | Fixed: items emitted immediately |
| 🟢 `NodeAccumulator.paths()` leaks live set | Eliminated: class removed |
| 🟢 `NodeAccumulator` constructor missing null guard | Eliminated: class removed |
| 🟢 `currentBatch.clear()` exception-safety gap | Eliminated: no `currentBatch` |
| 🟢 `boolean[] truncationFired` pattern | Kept (still needed for truncation once-flag) |

---

## Files to Touch

| File | Change |
|------|--------|
| `StepPipelineExecutor.java` | Remove `NodeAccumulator`, `currentBatch`, `globalEmitted`; simplify `buildPipeline()` |
| `SyncQueryResponse.java` | Add `LinkedHashMap`-based merging in `pushItem()` + `items()` |
| `IASyncExecution.java` | Add Javadoc on `onItem()` about same-node multi-call semantics |
| `StepPipelineExecutorTest` (test module) | Update tests for new per-path streaming behaviour |

---

## Out of Scope

- `executeToList()` — already correct (no grouping, direct accumulation of `TraversalItem`)
- `ExpressionEvaluator`, `TraverseStepExecutor`, `RepeatStepExecutor` — unchanged
- `PathOutput.equals()` — UUID-based implementation stays as-is
- `IQueryResponseFiller.complete()` — kept for future extensibility, no behaviour change
