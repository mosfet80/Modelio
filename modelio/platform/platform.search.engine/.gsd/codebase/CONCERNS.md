# Codebase Concerns

**Analysis Date:** 2026-02-18

## Implementation Gaps

### Executor Not Implemented (Phases 3–5)

The core MQL execution engine does not exist yet. `QueryEngine.execute()` throws `UnsupportedOperationException`.

- **File:** `src/org/modelio/platform/query/internal/QueryEngine.java` (line 73)
- **Impact:** No query can actually run. Only resolution (AST → resolved model) works.
- **Missing functionality (Phases 3–5):**
  - `AsyncIterator`-based streaming response plumbing + cancellation/dispose (Phase 3, plan 03-01)
  - Source evaluation (`all`/`provided`) producing a streamed node sequence (Phase 3, plan 03-02)
  - Expression evaluation for filtering — predicate + value expressions (Phase 4, plan 04-01)
  - Traverse semantics (dependency + link-object) and path construction (Phase 4, plan 04-02)
  - Union execution strategy + deduplication (Phase 4, plan 04-03)
  - Repeat semantics with cycle-safety (Phase 5, plan 05-01)
  - Limits/budget enforcement with truncation/diagnostics (Phase 5, plan 05-02)
- **Priority:** Critical — this is the primary deliverable for v1.

### No Acceptance Suite (Phase 6)

The Q1–Q15 acceptance queries from the spec have no automated test coverage yet.

- **Spec:** `specs/MQL-spec-technical.md` §6 "Reference queries for acceptance set"
- **Impact:** No end-to-end validation of spec conformance.
- **Priority:** High — required to declare v1 complete.

### `AsyncIterator` Interface Defined but Never Implemented

The `AsyncIterator<T>` interface exists in the result model but no concrete implementation exists anywhere in the codebase.

- **File:** `src/org/modelio/platform/query/api/model/result/AsyncIterator.java`
- **Impact:** Phase 3 must create at least one concrete implementation for streaming results.
- **Priority:** High — blocking for executor.

### `IQueryResponse` Has No Implementation

The response interface is defined but no class implements it.

- **File:** `src/org/modelio/platform/query/api/model/result/IQueryResponse.java`
- **Impact:** Blocking for executor.

## Technical Debt

| Area | Description | Impact | Priority |
|------|------------|--------|----------|
| **API leak: `Queries` imports internal `QueryEngine`** | `Queries.java` (line 28) imports `org.modelio.platform.query.internal.QueryEngine` to construct engines. | Same as above — factory class in API package references internal implementation. | Medium (intentional factory pattern, but the dependency direction should be inverted or the factory should be in the internal package) |
| **`UnsupportedStep` / `UnsupportedExpr` placeholders** | `ResolvedStep.UnsupportedStep` and `ResolvedExpr.UnsupportedExpr` records exist as catch-all placeholders in the sealed hierarchy. | These are dead code — the resolver's switch expressions already cover all concrete subtypes exhaustively. They exist "just in case" but add noise to the sealed hierarchy. May confuse executor implementors. | Low |
| **`DefaultSearchCriteria` uses raw `Properties`** | `DefaultSearchCriteria` stores options as `Properties` with `Object` values. The `options` field has package-private visibility (no access modifier). | Type-unsafe, stringly-typed criteria. Legacy pattern. | Low (legacy code, not in active development path) |
| **No i18n for diagnostic messages** | `Diagnostics` factory in `src/org/modelio/platform/query/internal/resolver/diagnostics/Diagnostics.java` produces hardcoded English strings. | Future localization will require rework. Not critical for v1 but a known gap. | Low |

## Known Issues / Risks

### Spec Ambiguity: `Repeat` Deduplication Scope

The spec says "a node that has already been reached is not revisited" (§5.1) and Union "always implies automatic deduplication" (§3.4.4). The exact interaction between Union inside Repeat regarding dedup scope (per-iteration vs global) is not fully specified. This must be resolved during Phase 4–5 implementation.

- **Spec:** `specs/MQL-spec-technical.md` §3.4.4 and §5.1
- **Impact:** Could cause non-deterministic behavior or performance issues.
- **Priority:** High — must be decided before Phase 5.

### Spec Ambiguity: Edge Direction for MDependency

The spec says "Metamodel Relation (MDependency): the engine traverses using `mGet(dep)` method" (§3.4.3). But it doesn't fully specify how `direction` interacts with MDependency traversal. The resolver currently always produces `Direction.FORWARD` for `MDependencyEdge` (see `ResolvedEdge.MDependencyEdge.direction()`, line ~80 of `ResolvedEdge.java`). Backward traversal of MDependency would need to use the opposite dependency.

- **Impact:** Queries using `direction: "backward"` with MDependency edges may not work as expected.
- **Priority:** Medium — must be addressed in Phase 4.

### `ProvidedSource` Selection Provider Lifecycle

`QueryEngine` takes a `Supplier<MObject>` as selection provider. The current `IQueryResponse.items()` returns `AsyncIterator<NodeWithExplainOut>`. If the selection changes after query execution starts, the `ProvidedSource` may capture stale elements.

- **File:** `src/org/modelio/platform/query/internal/QueryEngine.java` (line 40–43)
- **Impact:** Race condition risk in interactive UI scenarios.
- **Priority:** Medium — must be resolved in Phase 3 (source evaluation).

### Diagnostic Location Not Fully Used in Resolver

`DiagnosticLocation` supports structured location tracking (`step[N]/child`), but many resolver methods emit diagnostics without location context (e.g., `KindResolver.resolve()` calls `Diagnostics.warning(message)` without a location).

- **Files:**
  - `src/org/modelio/platform/query/internal/resolver/KindResolver.java` (line ~105)
  - `src/org/modelio/platform/query/internal/resolver/diagnostics/DiagnosticLocation.java`
- **Impact:** Diagnostics for complex queries won't pinpoint which step caused the issue.
- **Priority:** Low — cosmetic, can be improved incrementally.

## Architecture Concerns

### Three Model Layers May Cause Confusion

The codebase maintains three parallel model representations:

1. **Mutable query AST** (`org.modelio.platform.query.api.model.query.*`) — 18 classes, user-facing
2. **Frozen/immutable AST** (`org.modelio.platform.query.api.model.frozen.*`) — 18 classes, for serialization
3. **Resolved model** (`org.modelio.platform.query.api.model.resolved.*`, `resolved.expr.*`) — 15 classes, for execution

Plus the `Conversions` class for mutable↔frozen, and the `QueryResolver` for mutable→resolved.

- **Impact:** High cognitive load. Any new AST node type requires changes in 3+ places (mutable class, frozen record, resolved record, Conversions, QueryResolver, and coverage tests).
- **Files:** `src/org/modelio/platform/query/api/model/query/Conversions.java` (160 lines of mechanical conversion code)
- **Priority:** Medium — accepted architectural trade-off, but keep tracking maintenance cost.

### Registries Rebuild on Every Resolver Instantiation

`EdgeRegistry` and `PropertyKeyRegistry` build full indexes (scanning all metaclasses and their dependencies) lazily on first use. `QueryResolver` is instantiated per `QueryEngine`, which is created via `Queries.createEngine()`.

- **Files:**
  - `src/org/modelio/platform/query/internal/resolver/EdgeRegistry.java` (line ~83, `buildDependenciesIndex()`)
  - `src/org/modelio/platform/query/internal/resolver/PropertyKeyRegistry.java` (455 lines — largest file)
- **Impact:** If engines are created frequently, the index rebuild cost could be significant. The lazy + volatile pattern provides thread-safety but not caching across engine instances.
- **Priority:** Low for v1 (engines likely long-lived), but monitor for Phase 4+ performance.

### `PropertyKeyRegistry` Complexity

At 455 lines, `PropertyKeyRegistry.java` is the largest file in the module. It handles resolution of property keys to 4 different alternatives (MAttribute, TagType, NoteType, PropertyDefinition) across metamodel and extension definitions.

- **File:** `src/org/modelio/platform/query/internal/resolver/PropertyKeyRegistry.java`
- **Impact:** Complex resolution logic. Future changes to property key semantics will be risky.
- **Priority:** Low — well-tested via `PropertyKeyResolverTest`.

### `AllSource` Performance for Large Models

`AllSource` scans all elements of a given metaclass using `session.getModel().findByClass()`. For large models with thousands of elements, this could be expensive before any filtering is applied.

- **Spec reference:** §3.2 — `all: iterate all elements matching Kind`
- **Impact:** Phase 3 (source evaluation) must address this with streaming and early termination.
- **Priority:** Medium — deferred to Phase 3.

## Legacy Code

### Legacy Search Engine (10 Java files)

The legacy `ISearchEngine` API and its implementations coexist with the new MQL engine in the same bundle:

| File | Lines | Purpose |
|------|-------|---------|
| `src/org/modelio/platform/search/engine/ISearchEngine.java` | 34 | Legacy search interface |
| `src/org/modelio/platform/search/engine/ISearchCriteria.java` | 38 | Legacy criteria interface (stringly-typed options) |
| `src/org/modelio/platform/search/engine/DefaultSearchCriteria.java` | 43 | Default criteria using `Properties` |
| `src/org/modelio/platform/search/engine/plugin/SearchEngine.java` | 68 | OSGi `BundleActivator` for the whole bundle |
| `src/org/modelio/platform/search/engine/searchers/model/ModelSearchEngine.java` | 121 | Full-model scan + regex name match |
| `src/org/modelio/platform/search/engine/searchers/model/ModelSearchCriteria.java` | 163 | Model search criteria (metaclasses, regex, stereotype) |
| `src/org/modelio/platform/search/engine/searchers/note/NoteSearchEngine.java` | 100 | Note content search by regex |
| `src/org/modelio/platform/search/engine/searchers/note/NoteSearchCriteria.java` | ~80 | Note search criteria |
| `src/org/modelio/platform/search/engine/searchers/inherit/InheritSearchEngine.java` | 183 | Inheritance hierarchy search |
| `src/org/modelio/platform/search/engine/searchers/inherit/InheritSearchCriteria.java` | ~80 | Inheritance search criteria |

**Concerns:**

1. **All legacy packages are exported** in `MANIFEST.MF` — external bundles (e.g., the SearchDialog UI) depend on them. They CANNOT be removed without migration.
2. **No integration between legacy and MQL** — the two systems are completely independent. The legacy search UI in `app.model.search.ui` uses `ISearchEngine` not `IQueryEngine`. The MQL editor UI is WIP.
3. **`ModelSearchEngine` loads all elements into a `HashSet`** before filtering — no streaming, no budget controls, no deduplication strategy. This contrasts with MQL's streaming design.
4. **Legacy code has no Javadoc** on interfaces — `ISearchEngine` and `ISearchCriteria` have no method-level documentation.
5. **`BundleActivator` is shared** — `SearchEngine.java` (the plugin activator) serves both legacy search and MQL code, which is fine but tightly couples the lifecycle.

**Migration path:** Legacy search should eventually be expressible as MQL queries. The `ModelSearchEngine` is essentially `allOfKind("X") | filter(name matches regex)`.  `InheritSearchEngine` is `provided | repeat(traverse(Generalization) | traverse(InterfaceRealization))`.


## Spec vs Implementation Alignment

### Implemented (Aligned with Spec)

| Spec Section | Implementation | Status |
|--------------|----------------|--------|
| §3.1 Query AST | `Query.java` + all `Step`/`Expr`/`Source` classes | Complete |
| §3.3 Kind resolution (metaclass + stereotype, ambiguity → union) | `KindResolver.java` | Complete |
| §3.4.1 Edge resolution (MDependency + link metaclass + stereotype) | `EdgeResolver.java` + `EdgeRegistry.java` | Complete |
| §3.5.3 Property key resolution (MAttribute/TagType/NoteType/PropertyDef) | `PropertyKeyResolver.java` + `PropertyKeyRegistry.java` | Complete |
| §4.1–4.4 Result model (QueryResponse, NodeWithExplainOut, PathOutput, PathStepOutput) | Result model records in `api.model.result` | DTOs defined, not populated |
| §3.6 LimitsSpec | `LimitsSpec.java` | Model complete, enforcement not implemented |

### Not Yet Implemented (Spec-Defined, Not Coded)

| Spec Section | Description | Expected Phase |
|--------------|-------------|----------------|
| §5 Execution semantics | Full query execution pipeline | Phase 3–5 |
| §5.1 Repeat semantics (maxDepth, dedup, termination) | Repeat with cycle-safe bounded traversal | Phase 5 |
| §5.2 Cycle detection | Diagnostic warning on cycle detection | Phase 5 |
| §3.4.2 FilterNode execution | Evaluate predicate expressions against live model | Phase 4 |
| §3.4.3 Traverse execution | Follow edges in model graph | Phase 4 |
| §3.4.4 Union execution + dedup | Branch concatenation + first-discovered dedup | Phase 4 |
| §3.5.1 Compare operators (`=`, `!=`, `<`, `contains`, etc.) | Evaluate comparison expressions | Phase 4 |
| §4.1 Streaming response + truncation | `isTruncated()` + limit enforcement | Phase 3/5 |
| §6 Q1–Q15 acceptance tests | Automated test suite | Phase 6 |

### Potential Divergences

1. **AST field names differ from spec:** The spec uses `pipeline` (§3.1) but implementation uses `steps` in `Query.java`. The spec uses `op` for step discriminator but implementation uses Java class hierarchy (`FilterStep`, `TraverseStep`, etc.). This is an acceptable adaptation to Java's type system, not a bug.

2. **`version` field handling:** The spec says `version: 1`, and `Query.java` enforces `VERSION = 1`. The frozen model (`FrozenQuery`) preserves version. However, there is no backward-compatible deserialization strategy for future version bumps. Jackson serialization hardcodes v1.

3. **`Diagnostic.elements` vs spec:** The spec defines `elements?: MObject[]` as optional in diagnostics. The implementation uses `List<MObject> elements` which can be null (declared in the record but no null-check in constructor). This is inconsistent with the strict null-checking pattern used elsewhere.

4. **`IQueryResponse.items()` returns `AsyncIterator`:** The spec says `items: MObject[] | NodeWithExplainOut[]` (§4.1), allowing either plain elements or explained elements. The implementation commits to `AsyncIterator<NodeWithExplainOut>` only — no plain-element mode. This is a stricter (better) contract but diverges from the spec's flexibility.

5. **`PathOutput` has no constructor validation:** `PathOutput` record (line ~67 of `PathOutput.java`) has no compact constructor validating the `nodes.size() == steps.size() + 1` invariant from the spec (§4.3). This could allow inconsistent paths.

## Test Coverage Gaps

**Untested area: Executor**
- What's not tested: Everything in Phases 3–6 (execution, expression evaluation, traversal, streaming, budgets)
- Files: `src/org/modelio/platform/query/internal/QueryEngine.java` — the `execute()` method is a stub
- Risk: Core functionality has zero test coverage
- Priority: High — will be addressed phase-by-phase

**Untested area: Edge direction semantics**
- What's not tested: How backward traversal of MDependency interacts with the resolver (hardcoded `FORWARD`)
- Files: `src/org/modelio/platform/query/api/model/resolved/ResolvedEdge.java` (`MDependencyEdge.direction()` always returns `FORWARD`)
- Risk: Backward MDependency queries (spec §3.4.3) may silently produce wrong results
- Priority: Medium

**Untested area: Legacy search engines**
- What's not tested: `ModelSearchEngine`, `NoteSearchEngine`, `InheritSearchEngine` have no unit tests in the test module
- Files: `src/org/modelio/platform/search/engine/searchers/**`
- Risk: Regressions in legacy search go unnoticed. Low risk since code is stable/unchanged.
- Priority: Low

---

*Concerns audit: 2026-02-18*
