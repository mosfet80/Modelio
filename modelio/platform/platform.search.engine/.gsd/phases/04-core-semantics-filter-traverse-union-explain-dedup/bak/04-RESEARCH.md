# Phase 4: Core Semantics (Filter/Traverse/Union + Explain + Dedup) - Research

**Researched:** 2026-02-20
**Domain:** Modelio graph execution semantics on top of resolved MQL model
**Confidence:** HIGH

<research_summary>

## Summary

This research focused on how to implement Phase 4 semantics using existing Modelio navigation patterns already proven in `core.project` (`importer` and `ramc`) and current `platform.search.engine` constraints. The current engine (`QueryEngine`) resolves queries correctly and executes source-only queries, but intentionally fails as soon as at least one step is present (`DiagnosticCode.UNSUPPORTED_STEP`).

The established pattern across Modelio code is: (1) rely on resolved metamodel objects produced by resolver phases, (2) iterate graph expansions with explicit validity filtering (`isValid()`), (3) keep deterministic traversal order and first-path retention, (4) apply filtering at node/link boundaries, not as late post-processing.

**Primary recommendation:** implement a dedicated internal execution pipeline (`ExecutionNode` + step executors) that uses already-resolved metamodel objects from previous phases, carries `PathOutput` incrementally, and enforces deterministic first-hit dedup with `MObject.equals()`.

</research_summary>

<standard_stack>

## Standard Stack

The established libraries/tools for this domain:

### Core

| Library / API | Version | Purpose | Why Standard |
| --- | --- | --- | --- |
| `org.modelio.vcore.smkernel.mapi` (`MObject`, `MClass`, `MDependency`, `MExpert`) | In-repo | Metamodel-aware navigation primitives | Canonical low-level navigation API in Modelio |
| `org.modelio.vcore.session.api.ICoreSession` / `IModel` | In-repo | Session-backed object lookup and enumeration | Already used by `SourceEvaluator` / resolver |
| `org.modelio.platform.query.api.model.resolved.*` | In-repo | Ambiguity-aware execution input (`ResolvedStep`, `ResolvedEdge`, `ResolvedProperty`) | Explicitly designed for execution layer |
| `org.modelio.platform.query.api.model.result.*` | In-repo | Output contract (`NodeWithExplainOut`, `PathOutput`, diagnostics, completion status) | Required API target for this phase |

### Supporting

| Library / API | Version | Purpose | When to Use |
| --- | --- | --- | --- |
| `CompositionGetter` (`core.kernel`) | In-repo | Iterative closure traversal over composition deps | Reference pattern for BFS-like graph expansion |
| `ModelExporter.DepWalker` (`core.project`) | In-repo | Dependency classification (composition/reference) | Useful when explicitly partitioning dependencies by nature |
| `RamcFilterBuilder` + link filters (`LinkTargetFilter`, `DependencyFilter`) | In-repo | Link-target validation and metaclass-driven link filtering | Reference pattern for traverse edge filtering |
| `Diagnostics` helper (`platform.search.engine`) | In-repo | Structured diagnostic emission | Keep behavior aligned with existing diagnostic model |

### Alternatives Considered

| Instead of | Could Use | Tradeoff |
| --- | --- | --- |
| Direct `instanceof` chains everywhere in executor | Dedicated internal visitor-like dispatcher per step/expr | Dispatcher is safer and easier to exhaustively test |
| Late dedup only at final output | Incremental dedup after each step + final guard | Incremental dedup avoids branch blow-up, keeps determinism |
| Re-filtering already resolved dependencies | Direct use of resolved `MDependency` / `ResolvedEdge` alternatives | Resolver phases already perform structural resolution work |

**Installation:** no new dependency required.

</standard_stack>

<architecture_patterns>

## Architecture Patterns

### Recommended Project Structure

```
src/org/modelio/platform/query/internal/executor/
├── ExecutionNode.java               # node + path + lightweight flags
├── ExecutionContext.java            # limits, diagnostics sink, session caches
├── StepExecutor.java                # dispatch for ResolvedStep
├── expr/
│   ├── ExprEvaluator.java           # boolean + value expression evaluation
│   └── PropertyValueResolver.java   # read MAttribute/Tag/Note/PropertyDefinition
├── traverse/
│   ├── TraverseEvaluator.java       # edge alternatives + direction handling
│   ├── LinkTraversal.java           # link-object traversal via MExpert
│   └── DependencyTraversal.java     # MDependency traversal
└── dedup/
    └── DeterministicDedupIndex.java # equals()-based first-hit retention
```

### Pattern 1: Prefer resolved edge alternatives directly

**What:** Execute traverse from `ResolvedEdge` alternatives (already resolved in previous phases) instead of recomputing dependency sets.
**When to use:** every traverse step evaluation.
**Reference pattern:** resolver-first pipeline already in place (`QueryResolver` → `ResolvedQuery`).

```java
for (ResolvedEdge.EdgeAlternative alternative : resolvedTraverse.edge().alternatives()) {
    // use alternative directly (MDependencyEdge or LinkObjectEdge)
    // no extra metaclass dependency discovery needed here
}
```

### Pattern 2: Frontier-based deterministic expansion

**What:** process step input as an ordered frontier (`List<ExecutionNode>`), expand into next frontier, keep insertion/discovery order.
**When to use:** `traverse`, `union`, `repeat` body execution.
**Reference pattern:** iterative expansion from `DefaultCompositionGetter#getAllChildren()`.

```java
List<ExecutionNode> next = new ArrayList<>();
for (ExecutionNode current : frontier) {
    for (ExecutionNode reached : traverse(current, edgeAlternative)) {
        if (dedup.accept(reached.node())) {
            next.add(reached); // first-discovered path retained
        }
    }
}
frontier = next;
```

### Pattern 3: Link target validation before acceptance

**What:** validate edge endpoint candidates early (null/invalid/deleted/filter mismatch).
**When to use:** all link-object traversals and edge filters.
**Reference pattern:** `LinkTargetFilter#accept()` + `DependencyFilter`/`NaryLinkEndFilter` target checks.

```java
MObject target = expert.getTarget(linkObject);
if (target != null && target.isValid() && nodeFilter.accept(target)) {
    emit(target);
}
```

### Anti-Patterns to Avoid

- **Ignoring resolved edge alternatives:** recomputing navigation candidates that were already resolved adds duplication and drift risk.
- **Dedup after full branch materialization only:** can explode intermediate memory for union/traverse-heavy queries.
- **Path mutation in place across branches:** causes cross-branch contamination; always clone/append immutably.

</architecture_patterns>

<dont_hand_roll>

## Don't Hand-Roll

| Problem | Don't Build | Use Instead | Why |
| --- | --- | --- | --- |
| Metaclass navigation taxonomy | Custom reflection over generated metamodel classes | `MClass`/`MDependency` APIs + `MExpert` | Existing kernel APIs already encode traversal semantics |
| Link endpoint semantics | Ad-hoc if/else per UML link class | `MExpert` (`isLink`, target/source semantics), plus metamodel deps for structural edges | Avoid brittle per-link-class branching |
| Deep graph recursion | Recursive DFS with implicit call stack | Iterative frontier loop (BFS-style) | Safer for large models and easier to budget/cancel |
| Free-form dedup keying | Hashing full path objects | Stable identity semantics via `MObject.equals()` with ordered first-hit retention | Deterministic and aligned with phase decisions |

**Key insight:** Phase 4 should compose existing Modelio kernel navigation primitives, not invent a parallel graph model.

</dont_hand_roll>

<common_pitfalls>

## Common Pitfalls

### Pitfall 1: Direction mismatch on dependency edges

**What goes wrong:** requested edge direction cannot be honored, results become silently empty or wrong.
**Why it happens:** structural dependencies are directional but not all alternatives are valid for backward traversal.
**How to avoid:** validate direction compatibility per `ResolvedEdge` alternative before iterating; emit error diagnostic for incompatible direction as decided in 04-CONTEXT.
**Warning signs:** many empty traverse results with no diagnostics.

### Pitfall 2: Ambiguous property alternatives evaluated incorrectly

**What goes wrong:** filter excludes valid nodes because only one property alternative is checked.
**Why it happens:** `ResolvedProperty` can hold multiple alternatives (attribute/tag/note/property definition).
**How to avoid:** evaluate alternatives with explicit OR semantics (as decided), and treat missing properties as non-match.
**Warning signs:** high false negatives on stereotype/tag-driven queries.

### Pitfall 3: Non-deterministic dedup path retention

**What goes wrong:** same query returns same nodes but different `why` paths across runs.
**Why it happens:** unordered data structures (`HashSet`) used as traversal frontier or dedup retention order.
**How to avoid:** preserve insertion order in frontier and keep first-hit retention keyed by object identity semantics (`MObject.equals()`) for both nodes and traversed links.
**Warning signs:** flaky tests on explanation path assertions.

### Pitfall 4: Invalid/deleted nodes leak into outputs

**What goes wrong:** `why` paths include stale nodes; later consumers fail on invalid references.
**Why it happens:** traversal/filter code forgets `isValid()` checks outside source evaluation.
**How to avoid:** centralize `isValidNode(MObject)` guard and reuse in every step executor.
**Warning signs:** intermittent failures in large/synchronized model sessions.

</common_pitfalls>

<code_examples>

## Code Examples

Verified patterns from in-repo reference code:

### Composition closure traversal (iterative, filtered)

```java
// Source: core.kernel CompositionGetter#getAllChildren
while (!currentRoots.isEmpty()) {
    for (MObject o : currentRoots) {
        for (MDependency dep : depWalker.getCompositionDeps(o)) {
            for (MObject val : o.mGet((SmDependency) dep)) {
                directChildren.add(val);
            }
        }
    }
    currentRoots.clear();
    for (MObject child : directChildren) {
        if (!children.contains(child) && filter.accept(child)) {
            children.add(child);
            currentRoots.add(child);
        }
    }
    directChildren = new ArrayList<>();
}
```

### Metaclass-based dependency cache

```java
// Source: core.project ModelExporter.DepWalker
for (MDependency dep : srcObject.getMClass().getDependencies(true)) {
    if (predicate(dep)) {
        // classification use-case (composition/reference), not mandatory for execution
    }
}
```

### Link target filtering pattern

```java
// Source: core.project LinkTargetFilter + DependencyFilter
MObject target = expert.getTarget(link);
boolean accepted = (target == null) || targetFilter.accept(target);
```

### Current query engine gate for steps

```java
// Source: platform.search.engine QueryEngine#runQuery
if (!resolvedQuery.steps().isEmpty()) {
    responseFiller.pushDiagnostic(Diagnostics.error(
        DiagnosticCode.UNSUPPORTED_STEP,
        "Step execution is not yet implemented"));
    responseFiller.getState().complete(QueryCompletionStatus.FAILED);
    return;
}
```

</code_examples>

<sota_updates>

## State of the Art (2025-2026, project-local)

| Old Approach | Current Approach | When Changed | Impact |
| --- | --- | --- | --- |
| Streaming response internals (`StreamingQueryResponse`) | Materialized sync/async API (`SyncQueryResponse` + `PreparedAsyncExecution`) | 2026-02-20 (03.04) | Step engine should push into `IQueryResponseFiller`, not reintroduce old streaming type |
| Generic execute entrypoint | Split `syncExec` + `prepareAsync` | 2026-02-20 (03.03) | Step semantics must behave identically in both execution modes |
| `QueryResponseState` naming | `QueryCompletionStatus` | 2026-02-20 (03.04) | New tests/docs must use completion status vocabulary |

</sota_updates>

<open_questions>

## Open Questions

1. **Backward traversal semantics for each `MDependencyEdge` alternative**
   - What we know: Context decision says incompatible direction must be error.
   - What's unclear: precise compatibility test API to use uniformly for all dependencies.
   - Recommendation: codify compatibility in one helper and add focused unit tests per dependency shape.

2. **Property value normalization for compare operators**
   - What we know: resolved values can come from attribute/tag/note/property-definition.
   - What's unclear: exact coercion matrix (string/number/bool/null) for all compare operators.
   - Recommendation: freeze a conversion table in phase plan task 04-01 and assert with parameterized tests.

</open_questions>

<sources>

## Sources

### Primary (HIGH confidence)

- In-repo code: `platform.search.engine` execution/resolution contracts (`QueryEngine`, `SourceEvaluator`, resolved/result models)
- In-repo code: `core.project` navigation patterns (`importer/defaultimporter`, `ramc/core/packaging`)
- In-repo code: `core.kernel` composition traversal utility (`CompositionGetter`)
- In-repo planning context: `04-CONTEXT.md`, `ROADMAP.md`, `REQUIREMENTS.md`, `STATE.md`

### Secondary (MEDIUM confidence)

- None (no external claims needed for this phase; implementation is constrained by in-repo APIs and decisions)

### Tertiary (LOW confidence - needs validation)

- None

</sources>

<metadata>

## Metadata

**Research scope:**

- Core technology: Modelio metamodel navigation and MQL resolved execution pipeline
- Ecosystem: internal Modelio modules only (`core.kernel`, `core.project`, `platform.search.engine`)
- Patterns: resolver-first traversal, frontier traversal, link-target filtering, deterministic dedup, path retention
- Pitfalls: direction mismatch, ambiguity handling, path determinism, stale node leakage

**Confidence breakdown:**

- Standard stack: HIGH — all stack elements are current in-repo APIs
- Architecture: HIGH — patterns cross-validated in multiple internal modules
- Pitfalls: HIGH — directly mapped to current phase decisions and observed code shape
- Code examples: HIGH — extracted from repository code

**Research date:** 2026-02-20
**Valid until:** next major API change in `platform.search.engine` execution contracts

</metadata>

---

_Phase: 04-core-semantics-filter-traverse-union-explain-dedup_
_Research completed: 2026-02-20_
_Ready for planning: yes_
