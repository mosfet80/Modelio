# Phase 9: Multi-path API & Engine - Research

**Researched:** 2026-05-18
**Domain:** Java records, collection API, push-based pipeline, path deduplication
**Confidence:** HIGH (all findings from direct codebase inspection, no speculation)

---

## Summary

Phase 9 changes `NodeWithExplainOut.why: PathOutput` to `whyPaths: Collection<PathOutput>` and
accumulates multiple paths per result node in the terminal consumer.

All six specific questions below have clear answers from direct codebase inspection. No external
libraries are needed — this is pure Java API and codebase-internal refactoring.

**Key insight:** The pipeline already deduplicates by UUID at the terminal. The change moves that
dedup **and** path collection into `LinkedHashMap<String, NodeAccumulator>`. The flush is a new
step triggered by a new `complete()` hook on `IQueryResponseFiller`. The pipeline-internal items
continue to carry exactly one path each; multi-path aggregation only happens at flush time.

**Primary recommendation:** Single type (`NodeWithExplainOut`) throughout — no new types needed.
Add `getSinglePath()` for pipeline-internal access. Accumulate in terminal, flush on `complete()`.

---

## Standard Stack

No external libraries. All solutions use standard Java 21 APIs already in use in the codebase.

### Core APIs in use

| API | Version | Purpose |
|-----|---------|---------|
| `java.util.LinkedHashMap` | Java 21 | Accumulate paths per UUID, preserve insertion order |
| `java.util.LinkedHashSet` | Java 21 | Dedup paths per node (insertion-order) |
| `java.util.Collections.unmodifiableSequencedSet()` | Java 21 | Immutable view of LinkedHashSet |
| Java record `equals()/hashCode()` override | Java 16+ | UUID-based path equality |
| `SequencedCollection` / `SequencedSet` | Java 21 | Ordered collection type in API |

**Bundle Java level**: `JavaSE-21` (confirmed in `META-INF/MANIFEST.MF` line 11 — the AGENTS.md
says 17 but the manifest says 21; trust the manifest).

### Confirmed: no new dependencies

The Jackson serialization already handles `Collection<PathOutput>` transparently — it serializes
any `Collection` as a JSON array. The rename `why` → `whyPaths` changes the JSON field name;
test JSON snapshot files in `resources/` need updating.

---

## Architecture Patterns

### Pattern: Single-type with `getSinglePath()` for internal access

**What:** Keep one public record `NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths)`.
Pipeline steps (traverse, repeat, filter) that extend paths use `item.getSinglePath()` — a
convenience accessor that returns the first (and only) path in the collection for pipeline items.
The multi-path collection is built at the terminal consumer before flushing to `downstream`.

**Why this is cleanest:** Introducing a second internal type would require duplicating all
`Consumer<NodeWithExplainOut>` types in the pipeline chain. All five `new NodeWithExplainOut(...)`
constructor calls in `TraverseStepExecutor`, `ExpressionEvaluator`, and `SourceEvaluator` simply
wrap the single path in `Set.of(path)`.

**Invariant:** All `NodeWithExplainOut` items flowing through the pipeline steps contain exactly
one path. Only the flushed output items (pushed to `downstream`) may contain multiple paths.

```java
// Public record — the output type
public record NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths) {
    public NodeWithExplainOut {
        Objects.requireNonNull(node, "node must not be null");
        Objects.requireNonNull(whyPaths, "whyPaths must not be null");
        if (whyPaths.isEmpty()) throw new IllegalArgumentException("whyPaths must not be empty");
        // Defensive copy + insertion-order dedup + immutable view
        whyPaths = Collections.unmodifiableSequencedSet(new LinkedHashSet<>(whyPaths));
    }

    /**
     * Convenience accessor for pipeline-internal items that carry exactly one path.
     * DO NOT call from external consumers — use {@link #whyPaths()} instead.
     *
     * @return the single path in this pipeline item
     * @throws NoSuchElementException if whyPaths is empty (should never happen due to constructor validation)
     */
    public PathOutput getSinglePath() {
        return this.whyPaths.iterator().next();
    }
}
```

**Constructor calls in pipeline (all five sites):** Change from:
```java
new NodeWithExplainOut(target, extendedPath)
```
to:
```java
new NodeWithExplainOut(target, Set.of(extendedPath))
```

### Pattern: Terminal accumulator with deferred flush

**What:** Replace the current `Set<String> seen` + immediate push with a two-phase terminal:

**Phase 1 (per-item):** Accumulate paths per node UUID using `LinkedHashMap`:
```java
// In buildPipeline():
LinkedHashMap<String, NodeAccumulator> accumulated = new LinkedHashMap<>();
Consumer<NodeWithExplainOut> terminal = item -> {
    if (!downstream.isComplete()) {
        accumulated.computeIfAbsent(item.node().getUuid(),
            k -> new NodeAccumulator(item.node()))
            .addPaths(item.whyPaths());
    }
};
```

**Phase 2 (flush):** Called via `complete()` after all source items have been pushed:
```java
// Override in the anonymous IQueryResponseFiller returned by buildPipeline():
@Override
public void complete() {
    for (NodeAccumulator acc : accumulated.values()) {
        if (downstream.isComplete()) break;
        if (!budget.tryAccept()) {
            if (!truncationFired[0]) {
                truncationFired[0] = true;
                downstream.setTruncated();
                downstream.pushDiagnostic(Diagnostics.info(DiagnosticCode.EXECUTION_TRUNCATED,
                        budget.getExhaustionCause()));
            }
            break;
        }
        downstream.pushItem(new NodeWithExplainOut(acc.node(), acc.paths()));
    }
}
```

**NodeAccumulator (private inner class in `StepPipelineExecutor`):**
```java
private static final class NodeAccumulator {
    private final MObject node;
    private final LinkedHashSet<PathOutput> paths = new LinkedHashSet<>();

    NodeAccumulator(MObject node) { this.node = node; }
    void addPaths(Collection<PathOutput> newPaths) { this.paths.addAll(newPaths); }
    MObject node() { return this.node; }
    Collection<PathOutput> paths() { return this.paths; }
}
```

**Budget invariant preserved:** Budget still counts unique nodes (same as before). Budget check
moves from per-item (during accumulation) to per-unique-node (during flush). Semantics identical.

### Pattern: `IQueryResponseFiller.complete()` hook

Add `default void complete() {}` to `IQueryResponseFiller`. The pipeline filler overrides it to
flush. `QueryEngine.runQuery()` calls `pipeline.complete()` after `SourceEvaluator.evaluate()`:

```java
// In QueryEngine.runQuery() — add ONE line:
IQueryResponseFiller pipeline = StepPipelineExecutor.buildPipeline(...);
SourceEvaluator.evaluate(resolvedQuery.source(), this.session, pipeline);
pipeline.complete(); // ← NEW: trigger path-accumulation flush
responseFiller.getState().complete(QueryCompletionStatus.ENDED);
```

All existing `IQueryResponseFiller` implementors (`NOOP_DIAGNOSTIC_SINK`, `SyncQueryResponse`,
external callers) get the default no-op and need no changes.

### Pattern: PathOutput equals/hashCode by UUID sequence

**What:** Override `equals()/hashCode()` in the `PathOutput` record to compare nodes by UUID.

**Why:** REQ-2-02 requires it. The auto-generated record equals calls `List<MObject>.equals()`
which calls `SmObjectImpl.equals()` — that checks UUID **and** `liveId`. In production sessions
the same element always has the same `liveId` so dedup works. But test mocks (e.g.,
`PreparedAsyncExecutionTest.mockMObject()`) use identity-based equals (`proxy == args[0]`),
breaking dedup in those tests. UUID-based override is robust across both cases.

**Pattern for Java records — override both methods:**
```java
// In PathOutput record:
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PathOutput other)) return false;
    if (this.nodes.size() != other.nodes.size()) return false;
    for (int i = 0; i < this.nodes.size(); i++) {
        if (!Objects.equals(this.nodes.get(i).getUuid(), other.nodes.get(i).getUuid())) {
            return false;
        }
    }
    return Objects.equals(this.steps, other.steps);
}

@Override
public int hashCode() {
    int result = 1;
    for (MObject node : this.nodes) {
        result = 31 * result + (node == null ? 0 : node.getUuid().hashCode());
    }
    result = 31 * result + Objects.hashCode(this.steps);
    return result;
}
```

**Steps comparison:** `PathStepOutput` implementations are records:
- `MDependencyPathStepOutput(MClass mc, MDependency dep)` — `MClass` and `MDependency` are
  metamodel singletons with proper equals. Auto-generated record equals works correctly.
- `LinkPathStepOutput(MObject link, Direction direction)` — `link` is a `SmObjectImpl` with
  UUID+liveId equals. In a session, the same traversal produces the same link object instance.
  Auto-generated equals works correctly in production.

Conclusion: The steps comparison via `Objects.equals(this.steps, other.steps)` (which delegates to
the record auto-generated equals on each step) is correct and does NOT need UUID override.

### Pattern: Cycle detection migration

Current code in `RepeatStepExecutor`:
```java
final boolean inCurrentPath = frontierItem.why().nodes().contains(discoveredEl);
```

New code — use `getSinglePath()` (frontier items always carry exactly one path):
```java
final boolean inCurrentPath = frontierItem.getSinglePath().nodes().contains(discoveredEl);
```

The logic is unchanged: checking if `discoveredEl` is an ancestor in the current traversal path.
Since frontier items are always pipeline items (single-path invariant holds throughout BFS), this
is correct. The `contains()` call uses `SmObjectImpl.equals()` (UUID + liveId) which works in
production because `frontierItem.getSinglePath().nodes()` contains the same live objects.

### Pattern: `executeToList()` — no changes needed

`StepPipelineExecutor.executeToList()` is used only for EXISTS sub-queries. It collects pipeline
items into a `List<NodeWithExplainOut>` via `results::add`. EXISTS only checks
`!results.isEmpty()` (or equivalent). The paths in those items are never inspected. Since
`executeToList()` uses `buildChain()` directly (not `buildPipeline()`), it bypasses the
accumulator and never calls `complete()`. This is correct — no changes needed.

---

## Don't Hand-Roll

| Problem | Don't Build | Use Instead | Why |
|---------|-------------|-------------|-----|
| Insertion-order dedup of `PathOutput` | Custom hash table | `LinkedHashSet<PathOutput>` | Standard collection, insertion-order preserved, dedup via `equals()/hashCode()` |
| Unmodifiable ordered set | Custom wrapper | `Collections.unmodifiableSequencedSet()` | Java 21 built-in, zero overhead |
| UUID-keyed ordered accumulator | Custom sorted structure | `LinkedHashMap<String, NodeAccumulator>` | Preserves first-arrival order, O(1) put/get |
| Stream-end signal | Null sentinel item | `IQueryResponseFiller.complete()` default method | Cleaner, type-safe, no NPE risk |
| Jackson serialization of `Collection<PathOutput>` | Custom serializer | Nothing — Jackson handles `Collection` as array | Already supported by Jackson's default behavior |

---

## Common Pitfalls

### Pitfall 1: Forgetting `pipeline.complete()` in `QueryEngine.runQuery()`

**What goes wrong:** Accumulator fills up but flush never fires. `downstream` receives zero items.
**Why it happens:** `buildPipeline()` returns an opaque `IQueryResponseFiller`. Easy to miss the
`complete()` call since the old code didn't need it.
**How to avoid:** Add the call immediately after `SourceEvaluator.evaluate()`, before the
`responseFiller.getState().complete(...)` line. Existing tests will catch this (zero results).
**Warning sign:** All acceptance tests return empty results after Phase 9 changes.

### Pitfall 2: Constructor calls using `List.of(path)` instead of `Set.of(path)`

**What goes wrong:** The compact constructor wraps in `new LinkedHashSet<>(whyPaths)` — works fine
with both List and Set inputs since `LinkedHashSet` copies. No functional bug.
**Why it matters:** `List.of(path)` is slightly more allocations than `Set.of(path)` (extra List
allocation), but both are correct. Use `Set.of(path)` for clarity (communicates "single element
collection, no order").
**Note:** Actually, since the compact constructor ALWAYS copies into `new LinkedHashSet<>()`, the
input type (`List` vs `Set`) is irrelevant for correctness. Use whichever reads clearer.

### Pitfall 3: `PathOutput.hashCode()` inconsistent with `equals()`

**What goes wrong:** `LinkedHashSet<PathOutput>` uses both. If `hashCode()` is not overridden
when `equals()` is, two logically-equal paths hash to different buckets and are NOT deduped.
**Why it happens:** Easy to override only `equals()` (common Java mistake). Records make this
particularly subtle — the auto-generated `hashCode()` is replaced only if you explicitly override.
**How to avoid:** Always override both together. Verify with a unit test: create two `PathOutput`
instances with the same node UUIDs but different `MObject` references, assert they are equal and
have the same hash code.

### Pitfall 4: Calling `getSinglePath()` from external consumers / test assertions

**What goes wrong:** External callers that store query results (e.g., `RegressionSuiteTest`) call
`item.getSinglePath()` when the result has multiple paths → returns first path silently, loses
other paths.
**How to avoid:** `getSinglePath()` is for pipeline-internal use only. Test assertions that
previously did `item.why()` should migrate to `item.whyPaths()` and inspect the collection.
The affected test call sites:
- `TraverseStepExecutionTest.java:110` — `classItem.get().why()` → use `whyPaths()`
- `TraverseStepExecutionTest.java:197` — `animalItem.get().why()` → use `whyPaths()`
- `UnionStepExecutionTest.java:234` — `item.why()` → use `whyPaths()`
- `SourceEvaluatorTest.java:156-157` — `item.why().nodes()` → `item.whyPaths().iterator().next().nodes()`

### Pitfall 5: Accumulator holds `MObject` references (lifecycle concern)

**What goes wrong:** `NodeAccumulator` stores a live `MObject` reference. If the session is
closed mid-execution, accessing `acc.node()` at flush time could throw `DeadObjectException`.
**Why it's NOT a problem here:** The pipeline execution is synchronous. The session is open for
the entire duration of `runQuery()`. Flush happens before `runQuery()` returns.
**No action needed** — just document the invariant.

### Pitfall 6: `NodeWithExplainOut` compact constructor modifies the canonical form

**What goes wrong:** The compact constructor does `whyPaths = Collections.unmodifiableSequencedSet(new LinkedHashSet<>(whyPaths))`. This changes the canonical field value. Callers who pass a `LinkedHashSet` don't get their set back — they get a copy. This is correct behavior but can surprise callers who check the canonical form for identity.
**No action needed** — records with collection fields should always defensively copy. This is the
correct pattern per Effective Java, Item 50 ("Make defensive copies when needed").

---

## Code Examples

### `NodeWithExplainOut` — full updated record

```java
// Source: this codebase, Phase 9 target
public record NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths) {
    public NodeWithExplainOut {
        Objects.requireNonNull(node, "node must not be null");
        Objects.requireNonNull(whyPaths, "whyPaths must not be null");
        if (whyPaths.isEmpty()) {
            throw new IllegalArgumentException("whyPaths must not be empty");
        }
        whyPaths = Collections.unmodifiableSequencedSet(new LinkedHashSet<>(whyPaths));
    }

    /** For pipeline-internal use only: returns the single path in a pipeline item. */
    public PathOutput getSinglePath() {
        return this.whyPaths.iterator().next();
    }
}
```

### `PathOutput` — overridden equals/hashCode

```java
// Source: this codebase, Phase 9 target
public record PathOutput(List<MObject> nodes, List<PathStepOutput> steps) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathOutput other)) return false;
        if (this.nodes.size() != other.nodes.size()) return false;
        for (int i = 0; i < this.nodes.size(); i++) {
            if (!Objects.equals(this.nodes.get(i).getUuid(), other.nodes.get(i).getUuid())) {
                return false;
            }
        }
        return Objects.equals(this.steps, other.steps);
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (MObject node : this.nodes) {
            result = 31 * result + (node == null ? 0 : node.getUuid().hashCode());
        }
        result = 31 * result + Objects.hashCode(this.steps);
        return result;
    }
}
```

### `IQueryResponseFiller` — `complete()` hook

```java
// Add to existing interface
default void complete() {
    // Default: no-op. Override in pipeline filler to flush accumulated paths.
}
```

### `TraverseStepExecutor` — constructor call migration (example)

```java
// Before:
downstream.accept(new NodeWithExplainOut(target, extendedPath));

// After:
downstream.accept(new NodeWithExplainOut(target, Set.of(extendedPath)));
```

All 5 constructor call sites follow this same pattern (3 in `TraverseStepExecutor`, 1 in
`ExpressionEvaluator`, 1 in `SourceEvaluator`).

### `RepeatStepExecutor` — cycle detection migration

```java
// Before:
final boolean inCurrentPath = frontierItem.why().nodes().contains(discoveredEl);

// After:
final boolean inCurrentPath = frontierItem.getSinglePath().nodes().contains(discoveredEl);
```

### `TraverseStepExecutor.wrapTraverse()` — `item.why()` call sites

Two call sites at lines 81 and 83 (passing `item.why()` to `traverseMDependencyPush` and
`traverseLinkObjectPush`). The parameter type of those methods is `PathOutput currentPath`.
These become `item.getSinglePath()`.

---

## Open Questions

### OQ-1: Should `getSinglePath()` assert size == 1?

**What we know:** The method is only called internally on pipeline items, which always have size 1.
**What's unclear:** Whether a hard assertion (throw `IllegalStateException`) is worth the overhead
vs. silent "return first" with documented precondition.
**Recommendation:** Silent "return first" (no assertion). Pipeline invariant is guaranteed by
construction. If violated, the first path will be returned (wrong but won't crash); tests will
catch it through wrong-result assertions. Simpler than an assertion that fires in no real case.

### OQ-2: Jackson serialization of `NodeWithExplainOut` in test snapshots

**Resolved.** The JSON files in `platform.search.engine.test/target/json-samples/` are generated
output (not checked-in golden fixtures). The `resources/` directory contains no `.json` files.
`JacksonSerializationTest` only serializes `FrozenQuery` types, not result types.
**No golden-file updates required.** The `why` → `whyPaths` rename has no impact on existing
test JSON fixtures.

---

## Sources

### Primary (HIGH confidence — direct codebase inspection)

- `NodeWithExplainOut.java` — current record, single `PathOutput why` field
- `PathOutput.java` — no custom equals/hashCode, auto-generated record equality
- `StepPipelineExecutor.java` — terminal consumer with `Set<String> seen` + immediate push
- `TraverseStepExecutor.java` — 2 `item.why()` call sites + 3 `new NodeWithExplainOut(...)` call sites
- `RepeatStepExecutor.java` — cycle detection `frontierItem.why().nodes().contains(discoveredEl)`
- `SourceEvaluator.java` — 1 `new NodeWithExplainOut(...)` call site
- `ExpressionEvaluator.java` — 1 `new NodeWithExplainOut(...)` call site
- `SmObjectImpl.java` lines 419-443 — `equals()` uses UUID + `liveId` (NOT UUID-only)
- `SmObjectImpl.java` line 602 — `hashCode()` based on UUID
- `IQueryResponseFiller.java` — interface without `complete()` method
- `QueryEngine.java` lines 120-130 — `runQuery()` calls evaluate then completes state
- `META-INF/MANIFEST.MF` line 11 — `JavaSE-21` confirmed
- `PreparedAsyncExecutionTest.java` lines 46-66 — mock MObject uses identity-based equals
- Test `.why()` call sites: `TraverseStepExecutionTest:110,197`, `UnionStepExecutionTest:234`,
  `SourceEvaluatorTest:156-157`

### Secondary (MEDIUM confidence — inference from codebase patterns)

- `LinkPathStepOutput` record: auto-equals uses `SmObjectImpl.equals()` for `link` field — safe
  in production (same link object instance per traversal), not safe with mocks. Steps comparison
  in `PathOutput.equals()` via `Objects.equals(this.steps, other.steps)` is sufficient.
- `MDependencyPathStepOutput` record: `MClass` and `MDependency` are metamodel singletons —
  auto-generated equals correct.

---

## Metadata

**Confidence breakdown:**

| Area | Level | Reason |
|------|-------|--------|
| Record field type choice | HIGH | Inspected all call sites and Java 21 API availability |
| PathOutput equals/hashCode | HIGH | SmObjectImpl.equals() inspected directly; mock behavior confirmed |
| Pipeline item design (single type) | HIGH | All 5 constructor call sites counted; chain type is `Consumer<NodeWithExplainOut>` throughout |
| Terminal consumer redesign | HIGH | `StepPipelineExecutor.buildPipeline()` fully read; flush point in `QueryEngine.runQuery()` confirmed |
| Cycle detection migration | HIGH | `RepeatStepExecutor` code read; invariant clearly holds |
| getSinglePath() behavior | HIGH | Internal invariant established by construction |
| Jackson `whyPaths` rename impact | MEDIUM | `JacksonSerializationTest` doesn't test result types; possible golden-file tests unknown |

**Research date:** 2026-05-18
**Valid until:** N/A — findings are from codebase, not external sources. Valid until code changes.

---

## Design Decision: NodeWithExplainOut Type Strategy

### Option A: Split types

**Types:**
- `TraversalItem(MObject node, PathOutput currentPath)` — internal record, package-private, never
  exported. Lives in the `executor` package.
- `NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths)` — public output record,
  exposed via the API. Only created by the terminal flush.

**Mechanical changes required (from actual code):**

Constructor sites that become `new TraversalItem(node, path)` — **5 total:**

| File | Line | Current | Option A |
|------|------|---------|----------|
| `SourceEvaluator.java` | 159 | `new NodeWithExplainOut(element, trivialPath(element))` | `new TraversalItem(element, trivialPath(element))` |
| `TraverseStepExecutor.java` | 109 | `new NodeWithExplainOut(target, extendedPath)` | `new TraversalItem(target, extendedPath)` |
| `TraverseStepExecutor.java` | 167 | `new NodeWithExplainOut(target, extendedPath)` | `new TraversalItem(target, extendedPath)` |
| `TraverseStepExecutor.java` | 213 | `new NodeWithExplainOut(source, extendedPath)` | `new TraversalItem(source, extendedPath)` |
| `ExpressionEvaluator.java` | 152 | `new NodeWithExplainOut(element, new PathOutput(...))` | `new TraversalItem(element, new PathOutput(...))` |

Accessor sites that become `item.currentPath()` — **3 total:**

| File | Line | Current | Option A |
|------|------|---------|----------|
| `TraverseStepExecutor.java` | 81 | `item.why()` (passed to `traverseMDependencyPush`) | `item.currentPath()` |
| `TraverseStepExecutor.java` | 83 | `item.why()` (passed to `traverseLinkObjectPush`) | `item.currentPath()` |
| `RepeatStepExecutor.java` | 108 | `frontierItem.why().nodes().contains(discoveredEl)` | `frontierItem.currentPath().nodes().contains(discoveredEl)` |

All consumer chain signatures (`Consumer<NodeWithExplainOut>` throughout `StepPipelineExecutor`,
`wrapRepeat`, `wrapTraverse`) become `Consumer<TraversalItem>`.

**Is the split mechanical?** Yes. Zero semantic reasoning required. "Everything created with a
single path → `TraversalItem`; everything flushed with accumulated paths → `NodeWithExplainOut`."
The boundary is enforced by the type system.

**Cycle detection:** `frontierItem.currentPath().nodes().contains(discoveredEl)` — identical logic,
clearer name. Frontier items always carry exactly one path. The single-path invariant is enforced
at construction time (the only `TraversalItem` constructor takes a `PathOutput`, not a
`Collection`).

**Future all-cycles feature:** The split does not impede it. A future change would require
modifying the BFS algorithm (see analysis below), at which point the internal type can be
changed independently of the public API.

---

### Option B: Single type, native Collection throughout

**Claim:** `NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths)` is used
everywhere — both internal pipeline items and final output items always carry a collection.
Nothing pretends to be single-path; everything is always multi-path.

#### Path extension semantics — what actually happens

In `TraverseStepExecutor`, `item.why()` is passed as `PathOutput currentPath` to helper methods
`traverseMDependencyPush` and `traverseLinkObjectPush`. These helpers call:

```java
PathOutput extendedPath = extendPathForDep(currentPath, target, dep.getSource(), dep);
downstream.accept(new NodeWithExplainOut(target, extendedPath));
```

`extendPathForDep` takes ONE `PathOutput` and returns ONE `PathOutput`. It is a 1→1 function.

Under Option B, `item.why()` is a `Collection<PathOutput>`. Extending "a collection of paths"
requires iterating and extending each one. For a given target, the semantically correct result is:
extend EACH of the N input paths → N extended paths → push ONE `NodeWithExplainOut(target,
{p1', p2', ..., pN'})`.

However: **in the internal pipeline, N is always 1.** Sources produce items via `trivialPath()`
(single-element collection). Traverse steps receive items from sources or other traverse steps;
all of those carry 1 path. There is no mechanism in the current pipeline that merges multiple
paths INTO an internal item — that only happens at the terminal flush.

Result: "native Collection throughout" means carrying `Collection<PathOutput>` of size 1 in
every pipeline step. The collection grows to size > 1 only at the terminal accumulator — exactly
as in the original design (and Option A).

**The "native" claim is structurally hollow:** in the pipeline, you always call
`item.whyPaths().iterator().next()` to get the one path you need. That is `getSinglePath()` with
extra verbosity and zero documentation of the invariant.

#### Fan-out semantics (B1) vs merge semantics (B2)

**B1 (fan-out):** For each path P in `currentPaths`, create `extendedPath = extend(P)`, push
`new NodeWithExplainOut(target, Set.of(extendedPath))`. Items always carry 1 path. Identical
to the current architecture; wrapping in a collection adds only noise.

**B2 (merge per traverse step):** For each target, collect all N extended paths, push ONE
`NodeWithExplainOut(target, {p1', ..., pN'})`. Since N=1 in the pipeline, merge produces a
collection of size 1. Identical result with extra code.

**B2 in a theoretical multi-path world:** If frontier items could have M paths (M > 1),
and each item fans out to K children, depth-k frontier items would carry M^k paths. In a
diamond `A → B, A → C, B → D, C → D`, item D would carry path [A,B,D] and path [A,C,D].
At depth 2, D has 2 paths. If D fans out to 2 children E and F, each of E and F carries 2 paths.
At depth 3: 4 paths per node in the worst case. **Exponential** in depth for dense DAGs.

However, this scenario is prevented by the BFS `globalVisited` mechanism:

```java
// In RepeatStepExecutor, lines 112–115:
if (!globalVisited.add(discoveredEl)) {
    continue; // drops ANY item for an already-seen node
}
```

The second item for D (path [A,C,D]) is dropped before it can contribute paths to D's entry.
D's frontier entry carries only path [A,B,D]. The multi-path accumulation in BFS is
**architecturally impossible without changing `globalVisited` semantics.** Option B does not
change this.

#### Cycle detection with Collection

Currently (`RepeatStepExecutor:108`):
```java
final boolean inCurrentPath = frontierItem.why().nodes().contains(discoveredEl);
```

Under Option B:
```java
final boolean inCurrentPath = frontierItem.whyPaths().stream()
        .anyMatch(p -> p.nodes().contains(discoveredEl));
```

Since `frontierItem.whyPaths()` always has size 1 in the pipeline, this is a verbose no-op.
The semantics are unchanged.

#### Does Option B enable all-cycle reporting?

**No.** The developer's intuition is: "if cycle detection collects paths into a collection, we
could iterate over those paths to identify which ones close a cycle." This is correct — but it is
independent of the type design.

The obstacle to all-cycle detection is not the type of `why`. It is the `globalVisited` set that
drops convergence paths. Consider graph `A → B → C → A` (cycle 1) and `A → D → C` (a second
path to C that also leads to cycle `A → B → C → A`). In BFS:

1. Depth 1: discover B (path [A,B]), D (path [A,D]). Both added to `globalVisited`.
2. Depth 2: from B, discover C (path [A,B,C]). From D, discover C — **dropped**: C already in
   `globalVisited`.
3. Depth 3: from C, discover A — cycle detected: A is in path [A,B,C].

The `A → D → C → A` path is **never discovered** because C was already visited. Option B
carrying collections cannot recover this dropped path. To detect all cycles, you need a DFS with
proper back-edge tracking (e.g., Tarjan/Johnson), which is a new algorithm, not a type change.

**Option B's value on the all-cycles question: zero.** The question is orthogonal to the type
design.

---

### Recommendation

**Use Option A.**

Three decisive reasons, all grounded in the actual code:

1. **Semantic precision enforced by the type system.** The internal pipeline items are fundamentally
   single-path by construction. `TraversalItem(MObject, PathOutput)` states this as a fact the
   compiler enforces. `NodeWithExplainOut(MObject, Collection<PathOutput>)` with collections
   always of size 1 in the pipeline is semantically dishonest — it forces callers to silently
   call `.iterator().next()` on every path access, with no way to distinguish pipeline items from
   output items.

2. **All-cycle detection is independent of the type design.** Option B provides no head start
   toward this feature. Reporting all cycles requires changing the BFS algorithm (replacing
   `globalVisited`-first-wins with DFS and back-edge tracking). At that point, `TraversalItem`
   can be extended to carry a cycle annotation — a localized change that does not require
   changing the public `NodeWithExplainOut` API.

3. **Zero extra overhead.** Option A: 5 constructor sites, 3 accessor sites, 1 new 2-field
   record. Option B: every one of those sites plus wrapping every single path in `Set.of()` at
   construction and calling `.iterator().next()` at every access. Same total changes, but Option
   B adds allocation overhead and readability loss at every pipeline step for no benefit.

**What the split enables that Option B cannot:** The compiler prevents any accidental call to
`item.currentPath()` on an output `NodeWithExplainOut`. With Option B, `item.whyPaths()` exists
on both — there is no type-level indication that calling `.iterator().next()` is valid on a
pipeline item (size 1) but wrong on an output item (size potentially > 1).

**Concrete Option A design:**

```java
// Package-private internal type — executor package only
record TraversalItem(MObject node, PathOutput currentPath) {
    TraversalItem {
        Objects.requireNonNull(node);
        Objects.requireNonNull(currentPath);
    }
}

// Public output type
public record NodeWithExplainOut(MObject node, Collection<PathOutput> whyPaths) {
    public NodeWithExplainOut {
        Objects.requireNonNull(node);
        Objects.requireNonNull(whyPaths);
        if (whyPaths.isEmpty()) throw new IllegalArgumentException("whyPaths must not be empty");
        whyPaths = Collections.unmodifiableSequencedSet(new LinkedHashSet<>(whyPaths));
    }
}
```

All `Consumer<NodeWithExplainOut>` in `StepPipelineExecutor`, `wrapRepeat`, and `wrapTraverse`
become `Consumer<TraversalItem>`. The terminal accumulator receives `TraversalItem`s and emits
`NodeWithExplainOut`s. The type boundary is the terminal flush. No `getSinglePath()` method
anywhere.

---

### Impact on PathOutput.equals/hashCode

**Developer confirmed: `MObject.equals()` is a reliable invariant.**

Auto-generated record `equals()` for `PathOutput` calls `List<MObject>.equals()` which calls
`MObject.equals()` per element. Since the developer asserts this invariant holds (including in
tests), **no UUID-based override is needed.**

The original RESEARCH.md recommendation of UUID-based override was driven by a concern about test
mocks that use identity-based equals. The developer has explicitly rejected this concern.

**Decision: use auto-generated record `equals()/hashCode()` for `PathOutput` unchanged.**

One genuine edge case: `PathStepOutput` subtypes.
- `MDependencyPathStepOutput(MClass mc, MDependency dep)` — metamodel singletons, auto-equals
  correct.
- `LinkPathStepOutput(MObject link, Direction dir)` — `link` is an `MObject` in the traversal.
  Auto-equals calls `MObject.equals()` on `link`. Since the developer confirms `MObject.equals()`
  is reliable, this is correct.

No action required on `PathOutput.equals/hashCode`. Existing auto-generated record equality works.
