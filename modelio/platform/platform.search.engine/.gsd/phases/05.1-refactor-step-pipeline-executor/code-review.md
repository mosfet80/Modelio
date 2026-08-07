Searched for text `isComplete|interface IQueryResponseFiller` (`**/IQueryResponseFiller.java`), 2 results

Searched for text `emitAllDepths|RepeatStep|FrozenRepeatStep` (`**/*.java`), 20 results

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/src/org/modelio/platform/query/internal/executor/IQueryResponseFiller.java)

Read [](file:///work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/src/org/modelio/platform/query/api/model/resolved/ResolvedStep.java#1-1), lines 1 to 80

Searched for regex `record PathOutput|class PathOutput|PathOutput\(` (`**/*.java`), 6 results

---

## Code Review — StepPipelineExecutor.java

---

**🟡 IMPORTANT — Correctness: `emitAllDepths=false` silent empty result when body is entirely filtered by `globalVisited`**

In `wrapRepeat`, the `depth > 1` guard was designed to prevent emitting the source node as a result. However, it creates a silent failure for a legitimate case: when at `depth=1` the body produces candidates but **all are already in `globalVisited`** (filtered by a prior Repeat step in the same pipeline), `nextFrontier` is empty and `depth == 1`, so nothing is emitted — including what should be reported as "deepest reachable frontier = source excluded, no results." The behaviour is correct but diverges from what the Javadoc implies: *"emits only the deepest reachable frontier nodes."* A node that had targets globally blocked could leave the caller expecting results it never receives.

**Why this matters:**
In a pipeline with two `RepeatStep`s sharing `globalVisited`, the second step may silently yield empty results for valid sources whose entire neighbourhood was consumed by the first step. This is invisible to the caller and produces no diagnostic.

**Suggested fix:**
Either document this explicitly as an accepted trade-off in the `wrapRepeat` Javadoc, or emit a diagnostic when `nextFrontier` is empty at `depth=1` due to global filtering (detectable by comparing raw body output size vs filtered size):

```java
if (nextFrontier.isEmpty()) {
    // Source exclusion: do not emit the source node itself (depth==1 means only source was frontier).
    // Note: if body produced candidates that were all filtered by globalVisited,
    // no results are emitted. This is intentional (cross-step deduplication).
    if (!repeat.emitAllDepths() && depth > 1) {
        for (NodeWithExplainOut item : frontier) {
            downstream.accept(item);
        }
    }
    break;
}
```

---

**🟡 IMPORTANT — Code Quality: `wrapRepeat` method length far exceeds the 30-line guideline**

`wrapRepeat` is approximately 80 lines long, excluding comments. The body of the returned lambda alone is 60+ lines. The project guideline is a soft ≤ 30 lines.

**Why this matters:**
The BFS traversal logic, cycle detection, `maxDepth` enforcement, and `emitAllDepths` branching are all entangled in a single method body, making future modifications risky and unit testing harder (the method cannot be tested in isolation).

**Suggested fix:**
Extract into focused private helpers:

```java
// Suggested extracted helpers:

private static void processFrontier(
        List<NodeWithExplainOut> frontier,
        RepeatStep repeat,
        ICoreSession session,
        Set<MObject> globalVisited,
        Set<MObject> cycleReported,
        IQueryResponseFiller diagnosticSink,
        Consumer<NodeWithExplainOut> downstream,
        List<NodeWithExplainOut> nextFrontier) { ... }

private static boolean handleCycle(
        MObject discoveredEl, NodeWithExplainOut frontierItem,
        Set<MObject> cycleReported, IQueryResponseFiller diagnosticSink) { ... }
```

---

**🟡 IMPORTANT — Code Quality: `extendPathForDep` parameter named `mc` is opaque**

```java
private static PathOutput extendPathForDep(PathOutput existing, MObject newNode, MClass mc, MDependency dep) {
```

`mc` is passed as the first argument to `new MDependencyPathStepOutput(mc, dep)`. From the call site (`traverseMDependencyPush`), it is `dep.getSource()`. The parameter name `mc` does not convey this.

**Suggested fix:**
```java
private static PathOutput extendPathForDep(PathOutput existing, MObject newNode, MClass sourceClass, MDependency dep) {
```

---

**🟢 SUGGESTION — Performance: O(depth) list copying in `extendPathForDep` and `extendPathForLink`**

Both path-extension helpers copy the entire existing `nodes` and `steps` lists on every traversal step:

```java
List<MObject> newNodes = new ArrayList<>(existing.nodes()); // copies all previous nodes
newNodes.add(newNode);
// ...
return new PathOutput(List.copyOf(newNodes), List.copyOf(newSteps)); // copies again
```

For a traversal at depth N, each hop allocates two `ArrayList`s + two `List.copyOf` snapshots, yielding O(N²) total copies for a linear path.

**Why this matters:**
On large models with deep traversals (e.g., inheritance hierarchies, composition trees), this generates significant GC pressure. The path is currently append-only, which is suitable for a persistent/immutable linked-list structure.

**Suggested fix (non-blocking):**
Consider a persistent cons-list for `PathOutput` that reuses the prefix without copying:

```java
// Lightweight alternative: a cons-node referencing parent
record PathNode(MObject element, PathStepOutput step, PathNode parent) { }
```

Or, short-term, replace double-copy with a single pass:
```java
return new PathOutput(
    Stream.concat(existing.nodes().stream(), Stream.of(newNode)).toList(),
    Stream.concat(existing.steps().stream(), Stream.of(new LinkPathStepOutput(link, direction))).toList()
);
```

---

**🟢 SUGGESTION — Performance: `List.of(frontierItem)` allocated on every BFS body call**

Inside the BFS loop in `wrapRepeat`:

```java
final List<NodeWithExplainOut> bodyOutput =
        executeToList(repeat.body(), List.of(frontierItem), session);
```

`List.of(frontierItem)` is a new small allocation per frontier item per depth level. For large frontier sets this is measurable GC noise.

**Suggested fix:**
Pre-allocate a reusable single-element wrapper, or overload `executeToList` to accept a single item:

```java
static List<NodeWithExplainOut> executeToList(
        List<ResolvedStep> steps, NodeWithExplainOut singleInput, ICoreSession session) {
    List<NodeWithExplainOut> results = new ArrayList<>();
    Consumer<NodeWithExplainOut> chainHead = buildChain(steps, results::add, session, null, new HashSet<>(), NOOP_DIAGNOSTIC_SINK);
    chainHead.accept(singleInput);
    return results;
}
```

---

**🟢 SUGGESTION — Test Coverage: `emitAllDepths=false` BFS scenarios**

The combination of `emitAllDepths=false` with multiple BFS depth levels, `maxDepth` clamping, and `globalVisited` cross-filtering does not appear covered by the existing test suite (searching `*Test.java` for `emitAllDepths` returns no results in `platform.search.engine.test`).

**Why this matters:**
The correctness concern above (globally-filtered body at depth=1) and the `maxDepth` + `emitAllDepths=false` interaction are subtle enough that regressions are likely without test coverage.

**Suggested fix:**
Add tests in `platform.search.engine.test` extending `AbstractMqlTest`:
- `emitAllDepths=false` natural stop at depth=1 (no body results)
- `emitAllDepths=false` natural stop at depth=2
- `emitAllDepths=false` with `maxDepth=2` truncation
- `emitAllDepths=false` with body entirely filtered by `globalVisited`

---

**🟢 SUGGESTION — Readability: `depth > 1` guard relies on undocumented invariant**

```java
if (!repeat.emitAllDepths() && depth > 1) {
```

The comment says *"but not the initial source"* but the actual invariant is *"at depth=1, frontier contains exactly [sourceItem]"*. This is true because `frontier` is initialized with `[sourceItem]` and only updated via `frontier = nextFrontier` after the iteration. If this initialization is ever refactored, the guard could silently stop working.

**Suggested fix:**
Either name the initial frontier variable `sourceFrontier`, or add an assertion:

```java
// Invariant: at depth=1, frontier contains only sourceItem (initialised above).
// guard depth > 1 prevents emitting the source node itself.
assert depth != 1 || (frontier.size() == 1 && frontier.get(0) == sourceItem);
if (!repeat.emitAllDepths() && depth > 1) {
```

---

### Summary

| Priority | Count | Topics |
|---|---|---|
| 🔴 CRITICAL | 0 | — |
| 🟡 IMPORTANT | 3 | `emitAllDepths` edge case correctness, method length, parameter naming |
| 🟢 SUGGESTION | 4 | Path copy performance, allocation noise, test coverage, invariant documentation |

The code is generally well-structured with correct use of sealed-interface pattern matching, explicit types, GPL headers, and proper `LimitsSpec` integration. The main concern to address before merge is the `emitAllDepths=false` + `globalVisited` edge case — either fix the behaviour or document it explicitly with a diagnostic.