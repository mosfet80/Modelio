# Architecture

**Analysis Date:** 2026-02-18

## Pattern Overview

**Overall:** Layered pipeline architecture with three distinct model representations (mutable AST → resolved model → frozen/serializable records) inside an OSGi plugin system.

**Key Characteristics:**

- Three-model pipeline: mutable Query AST (construction/editing) → Resolved model (execution-ready, metamodel-bound) → Frozen records (immutable, JSON-serializable)
- Sealed interface hierarchies with Java 21 records for closed type discrimination
- Clear API / internal split: public types in `api` packages, implementation in `internal` packages
- Ambiguity-aware resolution: resolvers produce lists of alternatives with diagnostic feedback
- Legacy search engine coexists alongside the new MQL subsystem

## Layers / Components

| Layer | Packages | Responsibility |
|-------|----------|---------------|
| **Public API** | `org.modelio.platform.query.api` | Entry points (`Queries`, `IQueryEngine`, `IQueryResolver`), factory methods |
| **Mutable Query AST** | `org.modelio.platform.query.api.model.query` | Mutable query construction: `Query`, `Source`, `Step`, `Expr` sealed hierarchies |
| **Frozen Model** | `org.modelio.platform.query.api.model.frozen` | Immutable record-based mirror of the AST for serialization and execution |
| **Resolved Model** | `org.modelio.platform.query.api.model.resolved` | Metamodel-bound execution shape: `ResolvedQuery`, `ResolvedStep`, `ResolvedKind`, `ResolvedEdge`, `ResolvedProperty` |
| **Resolved Expressions** | `org.modelio.platform.query.api.model.resolved.expr` | Resolved expression types: `ResolvedExpr`, `ResolvedPropertyValueExpr`, etc. |
| **Result Model** | `org.modelio.platform.query.api.model.result` | Execution output: `IQueryResponse`, `NodeWithExplainOut`, `PathOutput`, `Diagnostic`, `AsyncIterator` |
| **Jackson Serialization** | `org.modelio.platform.query.api.model.frozen.jackson` | Custom `MObjectSerializer`/`MObjectTransientDeserializer` for MObject ↔ JSON |
| **Internal Engine** | `org.modelio.platform.query.internal` | `QueryEngine` implementation (query execution — WIP/not yet implemented) |
| **Internal Resolver** | `org.modelio.platform.query.internal.resolver` | `QueryResolver` and sub-resolvers: `KindResolver`, `EdgeResolver`, `PropertyKeyResolver` |
| **Internal Resolver Registries** | `org.modelio.platform.query.internal.resolver` | `EdgeRegistry`, `PropertyKeyRegistry` — lazy-built name→definition indices |
| **Internal Diagnostics** | `org.modelio.platform.query.internal.resolver.diagnostics` | `Diagnostics` factory, `DiagnosticLocation` for structured diagnostic context |
| **Legacy Search** | `org.modelio.platform.search.engine` | `ISearchEngine` / `ISearchCriteria` API; concrete searchers for model/note/inherit |
| **MQL Editor UI** | `org.modelio.model.search.mql.*` (separate bundle) | GEF-based graphical query builder wrapping mutable Query AST via `MqlQueryModel` |

## Data Flow

### Query Lifecycle (MQL Pipeline)

```
 ┌──────────────┐    freeze()    ┌──────────────┐   Jackson    ┌──────┐
 │  Mutable AST │ ──────────────→│ Frozen Model │ ←──────────→ │ JSON │
 │  (query pkg) │                │ (frozen pkg) │              └──────┘
 └──────┬───────┘                └──────────────┘
        │
        │ resolveQuery()
        ▼
 ┌──────────────┐
 │Resolved Model│   (metamodel-bound: MClass, MDependency, Stereotype)
 │(resolved pkg)│
 └──────┬───────┘
        │
        │ execute()  [NOT YET IMPLEMENTED]
        ▼
 ┌──────────────┐
 │ Result Model │   (IQueryResponse → AsyncIterator<NodeWithExplainOut> + diagnostics)
 │ (result pkg) │
 └──────────────┘
```

1. **Construction**: The UI (`MqlEditorDialog` → `MqlQueryModel`) or API consumers build a mutable `Query` from `Source` + `Step[]` + `LimitsSpec`. The `Queries.createEmptyQuery()` factory is the simplest entry point.
2. **Freezing**: `Query.freeze()` / `Step.freeze()` produces an immutable `FrozenQuery` record tree. This frozen form is the canonical serialization shape, annotated with `@JsonTypeInfo`/`@JsonSubTypes` for polymorphic JSON via Jackson.
3. **Thawing**: `Conversions.toMutable(FrozenQuery)` / `Conversions.toMutable(FrozenStep)` converts frozen records back to mutable AST nodes.
4. **Resolution**: `QueryResolver.resolveQuery(Query)` converts the mutable AST into a `ResolvedQuery`. The resolver uses three sub-resolvers and two index registries:
   - `KindResolver` — resolves kind tokens (e.g., `"Class"`) to `ResolvedKind` alternatives (metaclass and/or stereotypes)
   - `EdgeResolver` + `EdgeRegistry` — resolves edge tokens (e.g., `"Generalization"`) to `ResolvedEdge` alternatives (MDependency and/or link-object traversals)
   - `PropertyKeyResolver` + `PropertyKeyRegistry` — resolves property key tokens to `ResolvedProperty` alternatives (MAttribute, TagType, NoteType, PropertyDefinition)
5. **Execution**: `QueryEngine.execute(Query)` is the intended final step but is **not yet implemented** (throws `UnsupportedOperationException`). It will consume the `ResolvedQuery` and produce `IQueryResponse`.
6. **Serialization (JSON round-trip)**: The frozen model uses Jackson annotations. `MObjectSerializer` serializes `MObject` as `{mc, uuid, name}`. `MObjectTransientDeserializer` uses a pluggable `Function<MObjectRef, MObject>` converter to rehydrate references.

### Resolution Detail

```
QueryResolver
  ├── KindResolver        → ResolvedKind (List<KindAlternative>)
  │                          ├── MetaclassKind(MClass)
  │                          └── StereotypeKind(Stereotype)
  │
  ├── EdgeResolver        → ResolvedEdge (List<EdgeAlternative>)
  │   └── EdgeRegistry       ├── MDependencyEdge(MDependency)
  │                          └── LinkObjectEdge(MClass, Stereotype?, Direction)
  │
  └── PropertyKeyResolver → ResolvedProperty (List<PropertyAlternative>)
      └── PropertyKeyRegistry  ├── ResolvedMAttribute(MAttribute)
                               ├── ResolvedTagType(TagType, owner)
                               ├── ResolvedNoteType(NoteType, owner)
                               └── ResolvedPropertyDefinition(PropertyDefinition, owner)
```

Resolution is ambiguity-aware: if a token resolves to multiple alternatives, all alternatives are kept and a warning `Diagnostic` is emitted. If a token resolves to nothing, an error diagnostic is emitted.

The `ResolverContext` interface abstracts metamodel access (`getMetaclass()`, `getRegisteredMetaclasses()`, `findStereotypesByName()`, `getModules()`), with `DefaultResolverContext` backed by a real `ICoreSession` and test implementations for unit testing.

### Legacy Search

```
ISearchEngine.search(session, criteria)  →  List<Element>
```

Legacy searchers (`ModelSearchEngine`, `NoteSearchEngine`, `InheritSearchEngine`) implement `ISearchEngine` and take `ISearchCriteria`. This is independent of the MQL pipeline.

## Key Abstractions

| Abstraction | Interface/Class | Purpose |
|-------------|----------------|---------|
| **Query** | `Query` (mutable class) | Top-level AST: source + steps + limits |
| **Source** | `Source` (sealed interface) | Where query starts: `AllSource` or `ProvidedSource` |
| **Step** | `Step` (sealed interface) | Pipeline operation: `FilterStep`, `TraverseStep`, `UnionStep`, `RepeatStep` |
| **Expr** | `Expr` (sealed interface) | Boolean expressions for predicates: `AndExpr`, `OrExpr`, `NotExpr`, `CompareExpr`, `IsExpr`, `ExistsExpr` |
| **ValueExpr** | `ValueExpr` (sealed interface) | Value expressions in comparisons: `PropertyValueExpr`, `LiteralValueExpr` |
| **FrozenQuery** | `FrozenQuery` (record) | Immutable snapshot for serialization |
| **FrozenStep** | `FrozenStep` (sealed interface) | Immutable step — Jackson-polymorphic via `@JsonTypeInfo(property="op")` |
| **FrozenSource** | `FrozenSource` (sealed interface) | Immutable source — Jackson-polymorphic via `@JsonTypeInfo(property="kind")` |
| **ResolvedQuery** | `ResolvedQuery` (record) | Execution-ready query with metamodel-bound types |
| **ResolvedStep** | `ResolvedStep` (sealed interface) | Execution step with inner records: `FilterStep`, `TraverseStep`, `UnionStep`, `RepeatStep`, `UnsupportedStep` |
| **ResolvedKind** | `ResolvedKind` (record) | Ambiguity-aware kind: list of `MetaclassKind` / `StereotypeKind` alternatives |
| **ResolvedEdge** | `ResolvedEdge` (record) | Ambiguity-aware edge: list of `MDependencyEdge` / `LinkObjectEdge` alternatives |
| **ResolvedProperty** | `ResolvedProperty` (record) | Ambiguity-aware property: list of `ResolvedMAttribute` / `ResolvedTagType` / `ResolvedNoteType` / `ResolvedPropertyDefinition` alternatives |
| **IQueryResponse** | `IQueryResponse` (interface) | Async query result: `items()`, `diagnostics()`, `isTruncated()`, `dispose()` |
| **AsyncIterator\<T\>** | `AsyncIterator<T>` (interface) | Async iteration with `next()`, `hasNext()`, `onNext()` returning `CompletableFuture` |
| **Diagnostic** | `Diagnostic` (record) | Leveled message (INFO/WARNING/ERROR) with optional MObject context |
| **DiagnosticLocation** | `DiagnosticLocation` (record) | Internal structured location (step index + path segments) for diagnostic messages |
| **IQueryEngine** | `IQueryEngine` (interface) | Facade: `execute(Query)` + `getResolver()` |
| **IQueryResolver** | `IQueryResolver` (interface) | Resolver facade: `resolveQuery()`, `resolveSource()`, `resolveStep()`, `resolveKind()` |
| **ResolverContext** | `ResolverContext` (interface) | Metamodel access abstraction for testability |
| **Queries** | `Queries` (class) | Static factory: `createEmptyQuery()`, `createEngine(session, selectionProvider)` |
| **Conversions** | `Conversions` (class) | Bidirectional frozen ↔ mutable conversion utilities |
| **MqlQueryModel** | `MqlQueryModel` (UI bundle) | UI domain model wrapping mutable `Query`, fires `PropertyChangeSupport` events |
| **ISearchEngine** | `ISearchEngine` (interface) | Legacy search: `search(session, criteria)` → `List<Element>` |

## Entry Points

| Entry Point | File | Description |
|------------|------|-------------|
| `Queries.createEmptyQuery()` | `src/org/modelio/platform/query/api/Queries.java` | Creates an empty mutable Query with ProvidedSource and no steps |
| `Queries.createEngine(session, selectionProvider)` | `src/org/modelio/platform/query/api/Queries.java` | Creates a `QueryEngine` instance (the main API entry point) |
| `IQueryEngine.execute(query)` | `src/org/modelio/platform/query/api/IQueryEngine.java` | Execute a query (not yet implemented) |
| `IQueryEngine.getResolver()` | `src/org/modelio/platform/query/api/IQueryEngine.java` | Access the resolver for pre-execution validation |
| `IQueryResolver.resolveQuery(query)` | `src/org/modelio/platform/query/api/IQueryResolver.java` | Resolve a raw query AST into execution-ready form |
| `QueryResolver.resolve(query, session)` | `src/org/modelio/platform/query/internal/resolver/QueryResolver.java` | Static convenience: resolve + session in one call |
| `Query.freeze()` | `src/org/modelio/platform/query/api/model/query/Query.java` | Convert mutable AST to frozen records for serialization |
| `Conversions.toMutable(frozen)` | `src/org/modelio/platform/query/api/model/query/Conversions.java` | Convert frozen records back to mutable AST |
| `MqlEditorDialog` | `app.model.search.ui: src/org/modelio/model/search/mql/ui/MqlEditorDialog.java` | UI dialog hosting the graphical MQL editor |
| `OpenMqlEditorHandler` | `app.model.search.ui: src/org/modelio/model/search/handlers/OpenMqlEditorHandler.java` | Eclipse e4 handler opening the MQL editor dialog |
| `ISearchEngine.search(session, criteria)` | `src/org/modelio/platform/search/engine/ISearchEngine.java` | Legacy search API entry point |

## Error Handling

**Strategy:** Diagnostics-based error reporting (no exceptions during resolution)

**Patterns:**

- Resolution errors are collected as `Diagnostic` records with `Level.INFO`, `Level.WARNING`, or `Level.ERROR`
- Ambiguous resolutions (multiple alternatives for a kind/edge/property) emit warnings but continue execution with all alternatives
- Unknown tokens (no alternatives found) emit errors
- `Diagnostics` factory class (`internal.resolver.diagnostics.Diagnostics`) provides standardized factory methods: `info()`, `warning()`, `error()` with optional `DiagnosticLocation` and `List<MObject>` context
- Constructor validation uses `IllegalArgumentException` for null/invalid parameters (fail-fast at AST construction time)
- `ResolutionResult` bundles `ResolvedQuery` + `List<Diagnostic>` as a single return value

## Cross-Cutting Concerns

**Logging:** Uses `org.modelio.vbasic.log.Log` from core.utils (not visible in query code — diagnostics serve as the primary reporting mechanism)

**Validation:** Constructor-level null checks in all records and classes; `MqlValidationService` in the UI bundle for editor-level validation

**Serialization:** Jackson annotations on frozen records (`@JsonProperty(required=true)`, `@JsonTypeInfo`, `@JsonSubTypes`); custom `MObjectSerializer`/`MObjectTransientDeserializer` for model element references

**Testability:** `ResolverContext` interface decouples resolvers from `ICoreSession`; test module provides `TestSession` (real CoreSession + MemoryRepository + Infrastructure/Standard metamodel fragments) and `TestModelFactory` for creating real model elements

---

_Architecture analysis: 2026-02-18_
