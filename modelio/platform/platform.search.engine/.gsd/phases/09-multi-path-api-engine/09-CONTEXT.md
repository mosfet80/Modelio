# Phase 9: Multi-path API & Engine — Context

**Gathered:** 2026-05-18
**Status:** Ready for planning

<domain>

## Phase Boundary

Phase 9 delivers:
- `NodeWithExplainOut.why: PathOutput` → `whyPaths: Collection<PathOutput>`
- Path accumulation in the execution pipeline (terminal consumer with deferred flush)
- PathOutput deduplication by path sequence
- Jackson serialization round-trip for the new collection field

Does NOT include: budget/timeout-safe path enumeration (Phase 10), test Q1–Q15 updates (Phase 10).

</domain>

<decisions>

## Implementation Decisions

### Area 1 — Pipeline item type design

**Decision: Two-type split.**

- **`TraversalItem`** — internal record `(MObject node, PathOutput path)`.
  Package-private, top-level, in `org.modelio.platform.query.internal.executor`.
  Never exported, never exposed outside that package.

- **`NodeWithExplainOut`** — public output record `(MObject node, Collection<PathOutput> whyPaths)`.
  Built at flush time only. Never used inside pipeline chains.

All pipeline chain code (`TraverseStepExecutor`, `RepeatStepExecutor`, `ExpressionEvaluator`,
`SourceEvaluator`) works with `Consumer<TraversalItem>`. The `Consumer<NodeWithExplainOut>` type
disappears from internal pipeline code entirely.

Conversion point: `StepPipelineExecutor.buildPipeline()` terminal consumer — accumulates
`TraversalItem` instances, flushes `NodeWithExplainOut` output during `complete()`.

`executeToList()` (EXISTS sub-queries): returns `List<TraversalItem>` — consistent internal type.
No flush needed; EXISTS only checks `!results.isEmpty()`.

**Rationale:** `getSinglePath()` on the output type would become a burden as soon as
`whyPaths` carries multiple elements. Type enforcement (separate `TraversalItem`) is more
future-proof than documented invariants.

### Area 2 — PathOutput equality semantics

**Decision: UUID-based comparison for nodes, record auto-equals for steps. Fully documented.**

`PathOutput.equals()/hashCode()` compares nodes by UUID (not by `MObject.equals()`), steps
by their record auto-generated equals.

- **Nodes by UUID** — dedup-stable across production objects and test mocks.
- **Steps by record auto-equals** — `MDependencyPathStepOutput`, `LinkPathStepOutput` are records
  whose auto-equals work correctly in production. No UUID override needed.

**Documentation required:**
- Full Javadoc on `PathOutput.equals()` explaining:
  - `MObject.equals()` is the spoken invariant for model objects
  - UUID comparison is a deliberate deviation for dedup stability
  - Cross-session same-UUID behavior is undefined (analogous to same-name Class from
    two ClassLoaders)
  - Migration to `MObject.equals()` deferred until test mocks are fixed
- Inline `// TODO: migrate to MObject.equals() when test mocks are fixed`

**Test coverage:** New `PathOutputTest` class (not in `JacksonSerializationTest`).
Scenarios:
- Two `PathOutput` instances with same node UUIDs, different `MObject` references → equal, same hashCode
- Two `PathOutput` instances with different node UUIDs → not equal

**Deferred:** Fix test mocks (`mockMObject()`) to implement `getUuid()` so that `MObject.equals()`
could be used for `PathOutput` comparison. Deferred to a future milestone.

### Area 3 — Accumulator flush design

**Decision: `complete()` is abstract on `IQueryResponseFiller`. Called defensively everywhere.**

`IQueryResponseFiller.complete()` is an **abstract** method (no default) — forces all implementors
to provide an explicit body, even if empty. Affected implementors: `NOOP_DIAGNOSTIC_SINK`,
`SyncQueryResponse`, all test fakes — they must add an empty `complete()` body.

`complete()` is called defensively at every pipeline exit point (not just `QueryEngine.runQuery()`),
so that future callers cannot accidentally skip the flush.

**Planner flag — budget check placement:**
The research design removes `budget.tryAccept()` from the accumulation lambda and puts it only
in `complete()`. The planner MUST verify:
1. `tryAccept()` is called exactly ONCE per unique result node (during flush only).
2. It is NOT called in the accumulation terminal lambda.
3. It is NOT called in any other place that would double-count.

If a call site is found in both places, the behavior is wrong (budget counter double-incremented).

### Area 4 — NodeWithExplainOut API surface

**Decision: No convenience accessor beyond `whyPaths()`.**

`NodeWithExplainOut` exposes only `whyPaths(): Collection<PathOutput>`. No `firstPath()`,
no `getSinglePath()`, no renamed `why()`. All callers (external and tests) migrate to `whyPaths()`
and iterate.

Return type: `Collection<PathOutput>` (general — not `SequencedCollection`, not `List`).

Constructor validation:
- `node` non-null
- `whyPaths` non-null
- `whyPaths` non-empty
- No null-element check inside the collection (trust callers)
- Defensive copy into `Collections.unmodifiableSet(new LinkedHashSet<>(whyPaths))`.

</decisions>

<specifics>

## Specific Implementation Notes

### TraversalItem record

```java
// Package-private — org.modelio.platform.query.internal.executor
record TraversalItem(MObject node, PathOutput path) {
    TraversalItem {
        Objects.requireNonNull(node, "node must not be null");
        Objects.requireNonNull(path, "path must not be null");
    }
}
```

### Call site migration (5 sites)

All `new NodeWithExplainOut(target, extendedPath)` in pipeline internals become:
```java
new TraversalItem(target, extendedPath)
```

All `new NodeWithExplainOut(source, initialPath)` in `SourceEvaluator` become:
```java
new TraversalItem(source, initialPath)
```

### Cycle detection (RepeatStepExecutor)

Before:
```java
frontierItem.why().nodes().contains(discoveredEl)
```
After (cleaner — no ambiguity):
```java
frontierItem.path().nodes().contains(discoveredEl)
```

### complete() on IQueryResponseFiller

```java
// ABSTRACT — no default
void complete();
```

Implementors that have nothing to flush provide an empty body:
```java
@Override
public void complete() { /* no accumulation */ }
```

</specifics>

<deferred>

## Deferred Ideas

- **Fix test mocks for MObject.equals()**: Update `mockMObject()` to return a stable UUID from
  `getUuid()` so that `MObject.equals()` could be used in `PathOutput` comparison. Deferred to
  a future milestone. (Discussed in Area 2 — not scope of Phase 9 or 10.)

</deferred>
