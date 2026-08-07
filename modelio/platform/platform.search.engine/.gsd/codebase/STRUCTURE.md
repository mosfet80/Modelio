# Project Structure

**Analysis Date:** 2026-02-18

## Directory Layout

```
platform.search.engine/                          # Main MQL + legacy search bundle
├── META-INF/
│   └── MANIFEST.MF                              # OSGi manifest (JavaSE-21, exports, deps)
├── build.properties                             # Tycho build config
├── pom.xml                                      # Maven POM (eclipse-plugin packaging)
├── AGENTS.md                                    # Agent instructions for this module
├── build/
│   ├── build.sh                                 # Build script (runs Maven in subshell)
│   └── pom.xml                                  # Maven aggregator POM for building
├── src/
│   └── org/modelio/platform/
│       ├── query/
│       │   ├── api/                             # PUBLIC API
│       │   │   ├── IQueryEngine.java            # Engine facade interface
│       │   │   ├── IQueryResolver.java          # Resolver facade interface
│       │   │   ├── Queries.java                 # Static factory (main entry point)
│       │   │   └── model/
│       │   │       ├── package-info.java         # Root model package doc
│       │   │       ├── query/                    # Mutable query AST
│       │   │       │   ├── Query.java            # Top-level query
│       │   │       │   ├── Source.java           # sealed: AllSource | ProvidedSource
│       │   │       │   ├── AllSource.java        # Source: all elements of a Kind
│       │   │       │   ├── ProvidedSource.java   # Source: explicit element list
│       │   │       │   ├── Step.java             # sealed: Filter | Traverse | Union | Repeat
│       │   │       │   ├── FilterStep.java       # Step: predicate filter
│       │   │       │   ├── TraverseStep.java     # Step: edge traversal
│       │   │       │   ├── UnionStep.java        # Step: branch union
│       │   │       │   ├── RepeatStep.java       # Step: recursive repeat
│       │   │       │   ├── Expr.java             # sealed: boolean expressions
│       │   │       │   ├── AndExpr.java          # Expr: logical AND
│       │   │       │   ├── OrExpr.java           # Expr: logical OR
│       │   │       │   ├── NotExpr.java          # Expr: logical NOT
│       │   │       │   ├── CompareExpr.java      # Expr: binary comparison
│       │   │       │   ├── IsExpr.java           # Expr: kind type check
│       │   │       │   ├── ExistsExpr.java       # Expr: path existence
│       │   │       │   ├── ValueExpr.java        # sealed: value expressions
│       │   │       │   ├── PropertyValueExpr.java# ValueExpr: property reference
│       │   │       │   ├── LiteralValueExpr.java # ValueExpr: literal constant
│       │   │       │   ├── Direction.java        # Enum: FORWARD | BACKWARD
│       │   │       │   ├── ValueType.java        # Enum: STRING | NUMBER | BOOL
│       │   │       │   ├── LimitsSpec.java       # Mutable execution limits
│       │   │       │   ├── Conversions.java      # Frozen ↔ Mutable conversions
│       │   │       │   └── package-info.java
│       │   │       ├── frozen/                   # Immutable records (JSON-serializable)
│       │   │       │   ├── FrozenQuery.java      # record: immutable query
│       │   │       │   ├── FrozenSource.java     # sealed: FrozenAllSource | FrozenProvidedSource
│       │   │       │   ├── FrozenAllSource.java
│       │   │       │   ├── FrozenProvidedSource.java
│       │   │       │   ├── FrozenStep.java       # sealed: 4 step records
│       │   │       │   ├── FrozenFilterStep.java
│       │   │       │   ├── FrozenTraverseStep.java
│       │   │       │   ├── FrozenUnionStep.java
│       │   │       │   ├── FrozenRepeatStep.java
│       │   │       │   ├── FrozenExpr.java       # sealed: 6 expr records
│       │   │       │   ├── FrozenAndExpr.java
│       │   │       │   ├── FrozenOrExpr.java
│       │   │       │   ├── FrozenNotExpr.java
│       │   │       │   ├── FrozenCompareExpr.java
│       │   │       │   ├── FrozenIsExpr.java
│       │   │       │   ├── FrozenExistsExpr.java
│       │   │       │   ├── FrozenValueExpr.java  # sealed: value expr records
│       │   │       │   ├── FrozenPropertyValueExpr.java
│       │   │       │   ├── FrozenLiteralValueExpr.java
│       │   │       │   ├── FrozenLimitsSpec.java # record: immutable limits
│       │   │       │   ├── jackson/              # Jackson custom (de)serializers
│       │   │       │   │   ├── MObjectSerializer.java
│       │   │       │   │   └── MObjectTransientDeserializer.java
│       │   │       │   └── package-info.java
│       │   │       ├── resolved/                 # Resolved (metamodel-bound) model
│       │   │       │   ├── ResolvedQuery.java    # record: resolved query
│       │   │       │   ├── ResolvedSource.java   # sealed: AllSource | ProvidedSource
│       │   │       │   ├── ResolvedStep.java     # sealed: 5 step records (inner)
│       │   │       │   ├── ResolvedKind.java     # record: ambiguity-aware kind
│       │   │       │   ├── ResolvedEdge.java     # record: ambiguity-aware edge
│       │   │       │   ├── ResolvedProperty.java # record: ambiguity-aware property
│       │   │       │   └── expr/                 # Resolved expressions
│       │   │       │       ├── ResolvedExpr.java
│       │   │       │       ├── ResolvedAndExpr.java
│       │   │       │       ├── ResolvedOrExpr.java
│       │   │       │       ├── ResolvedNotExpr.java
│       │   │       │       ├── ResolvedCompareExpr.java
│       │   │       │       ├── ResolvedIsExpr.java
│       │   │       │       ├── ResolvedExistsExpr.java
│       │   │       │       ├── ResolvedPropertyValueExpr.java
│       │   │       │       └── ResolvedValueExpr.java
│       │   │       └── result/                   # Execution result model
│       │   │           ├── IQueryResponse.java   # Response interface (async)
│       │   │           ├── AsyncIterator.java    # Async iteration interface
│       │   │           ├── NodeWithExplainOut.java # Result node + explanation path
│       │   │           ├── PathOutput.java       # Explanation path: nodes + steps
│       │   │           ├── PathStepOutput.java   # sealed: Link | MDependency step
│       │   │           ├── LinkPathStepOutput.java
│       │   │           ├── MDependencyPathStepOutput.java
│       │   │           ├── Diagnostic.java       # Leveled diagnostic message
│       │   │           └── package-info.java
│       │   └── internal/                         # INTERNAL implementation
│       │       ├── QueryEngine.java              # IQueryEngine impl (execute = WIP)
│       │       └── resolver/                     # Query resolution subsystem
│       │           ├── QueryResolver.java        # Main resolver (IQueryResolver impl)
│       │           ├── ResolverContext.java       # Metamodel access abstraction
│       │           ├── DefaultResolverContext.java # ResolverContext backed by ICoreSession
│       │           ├── KindResolver.java         # Kind token → ResolvedKind
│       │           ├── EdgeRegistry.java         # Lazy dependency name index
│       │           ├── EdgeResolver.java         # Edge token → ResolvedEdge
│       │           ├── PropertyKeyRegistry.java  # Lazy property name index
│       │           ├── PropertyKeyResolver.java  # Property token → ResolvedProperty
│       │           ├── ResolutionResult.java     # record: ResolvedQuery + diagnostics
│       │           └── diagnostics/
│       │               ├── Diagnostics.java      # Diagnostic factory helper
│       │               └── DiagnosticLocation.java # Structured location record
│       └── search/
│           └── engine/                           # Legacy search engine
│               ├── ISearchEngine.java            # Legacy search interface
│               ├── ISearchCriteria.java          # Legacy criteria interface
│               ├── DefaultSearchCriteria.java    # Default criteria impl
│               ├── plugin/
│               │   └── SearchEngine.java         # OSGi activator/plugin
│               └── searchers/
│                   ├── model/                    # Model name/type search
│                   │   ├── ModelSearchEngine.java
│                   │   └── ModelSearchCriteria.java
│                   ├── note/                     # Note content search
│                   │   ├── NoteSearchEngine.java
│                   │   └── NoteSearchCriteria.java
│                   └── inherit/                  # Inheritance search
│                       ├── InheritSearchEngine.java
│                       └── InheritSearchCriteria.java
├── src_bak/                                     # Backup of old sources (ignore)
└── .gsd/                                        # GSD project metadata
```

```
platform.search.engine.test/                     # Test fragment bundle
├── META-INF/
│   └── MANIFEST.MF                              # Fragment host: platform.search.engine
├── pom.xml                                      # Maven config (eclipse-test-plugin)
├── AGENTS.md                                    # Agent instructions for test module
├── build/
│   ├── run-tests.sh                             # Test runner script
│   └── pom.xml                                  # Maven aggregator for tests
├── resources/                                   # Test resources (JSON fixtures, etc.)
└── src/
    └── org/modelio/platform/query/
        ├── api/model/
        │   ├── JacksonSerializationTest.java    # JSON round-trip serialization tests
        │   └── ModelFreezeTest.java             # Mutable ↔ frozen conversion tests
        ├── engine/
        │   ├── DiagnosticsSmokeTest.java        # Diagnostic production smoke tests
        │   ├── ResolvedModelSmokeTest.java      # Resolved model construction tests
        │   └── resolver/                        # Resolver unit tests
        │       ├── EdgeResolverTest.java
        │       ├── KindResolverTest.java
        │       ├── PropertyKeyResolverTest.java
        │       ├── QueryResolverCoverageTest.java
        │       ├── QueryResolverEdgeSmokeTest.java
        │       ├── QueryResolverKindSmokeTest.java
        │       └── QueryResolverPropertyKeySmokeTest.java
        └── testutils/                           # Shared test infrastructure
            ├── AbstractMqlTest.java             # Base class: TestSession setup/teardown
            ├── TestSession.java                 # Real CoreSession + MemoryRepository
            └── TestModelFactory.java            # Factory for creating test model elements
```

```
app.model.search.ui/                             # MQL Editor UI bundle
├── META-INF/
│   └── MANIFEST.MF                              # OSGi manifest (JavaSE-17)
├── plugin.xml                                   # Extension point contributions
├── e4model/
│   └── modelsearch.e4xmi                        # Eclipse e4 model fragment
├── res/
│   ├── modelsearch.properties                   # English i18n
│   └── modelsearch_fr.properties                # French i18n
└── src/org/modelio/model/search/
    ├── QuickSearchCombo.java                    # Trimbar quick search combo
    ├── plugin/                                  # Bundle activator
    ├── dialog/                                  # Legacy advanced search dialog
    │   ├── SearchDialog.java
    │   └── SearchController.java
    ├── handlers/                                # Eclipse e4 command handlers
    │   ├── OpenSearchDialogHandler.java
    │   └── OpenMqlEditorHandler.java
    └── mql/                                     # MQL graphical editor
        ├── ui/                                  # Dialog and property sections
        │   ├── MqlEditorDialog.java             # Main MQL editor dialog
        │   ├── MqlSourceSection.java            # Source property panel
        │   ├── MqlStepsSection.java             # Steps property panel
        │   ├── MqlTraverseSection.java          # Traverse detail panel
        │   ├── MqlLimitsSection.java            # Limits property panel
        │   └── MqlSelectionProvider.java        # Selection polling
        ├── editor/
        │   └── MqlGraphicalEditor.java          # GEF graphical editor component
        ├── elements/                            # GEF domain model + edit parts + figures
        │   ├── core/                            # Shared base: MqlQueryModel, MqlStepNode, etc.
        │   │   ├── MqlQueryModel.java           # Root editor model (wraps mutable Query)
        │   │   ├── MqlQueryEditPart.java
        │   │   ├── MqlStepNode.java
        │   │   ├── MqlStepEditPart.java
        │   │   ├── MqlExprNode.java
        │   │   ├── AbstractMqlNode.java
        │   │   ├── MqlEditPartFactory.java
        │   │   ├── MqlFigureSizing.java
        │   │   └── NodeStyles.java
        │   ├── source/                          # Source element: node + edit part + figure
        │   │   ├── MqlSourceNode.java
        │   │   ├── MqlSourceEditPart.java
        │   │   └── MqlSourceFigure.java
        │   ├── filter/
        │   │   ├── MqlFilterStepEditPart.java
        │   │   ├── MqlFilterFigure.java
        │   │   └── TrapezoidShape.java
        │   ├── traverse/
        │   │   ├── MqlTraverseStepEditPart.java
        │   │   └── MqlTraverseFigure.java
        │   ├── union/
        │   │   ├── MqlUnionStepEditPart.java
        │   │   ├── MqlUnionFigure.java
        │   │   ├── MqlUnionBranchEditPart.java
        │   │   └── MqlBranchFigure.java
        │   └── repeat/
        │       ├── MqlRepeatStepEditPart.java
        │       └── MqlRepeatFigure.java
        ├── commands/                            # GEF commands
        │   ├── MqlPipelineCommands.java
        │   └── MqlStepCommands.java
        ├── editpolicies/                        # GEF edit policies
        │   ├── MqlPipelineEditPolicy.java
        │   └── MqlRequestConstants.java
        ├── expressions/                         # Expression editing panel
        │   ├── MqlExpressionPanel.java
        │   └── MqlExpressionTreeModel.java
        ├── summary/
        │   └── MqlSummaryRenderer.java          # Pseudo-syntax summary text
        └── validation/
            └── MqlValidationService.java        # Editor-level validation
```

## Key File Locations

| What | Path | Notes |
|------|------|-------|
| **Main API entry point** | `platform.search.engine/src/org/modelio/platform/query/api/Queries.java` | `createEmptyQuery()`, `createEngine()` |
| **Engine interface** | `platform.search.engine/src/org/modelio/platform/query/api/IQueryEngine.java` | `execute()`, `getResolver()` |
| **Resolver interface** | `platform.search.engine/src/org/modelio/platform/query/api/IQueryResolver.java` | `resolveQuery()`, `resolveSource()`, `resolveStep()`, `resolveKind()` |
| **Mutable Query AST root** | `platform.search.engine/src/org/modelio/platform/query/api/model/query/Query.java` | Source + Steps + LimitsSpec |
| **Frozen Query root** | `platform.search.engine/src/org/modelio/platform/query/api/model/frozen/FrozenQuery.java` | Immutable record for JSON serialization |
| **Resolved Query root** | `platform.search.engine/src/org/modelio/platform/query/api/model/resolved/ResolvedQuery.java` | Execution-ready form |
| **Query result interface** | `platform.search.engine/src/org/modelio/platform/query/api/model/result/IQueryResponse.java` | Async response with items + diagnostics |
| **Frozen↔Mutable conversions** | `platform.search.engine/src/org/modelio/platform/query/api/model/query/Conversions.java` | `toMutable()` / `freeze()` utilities |
| **QueryEngine impl** | `platform.search.engine/src/org/modelio/platform/query/internal/QueryEngine.java` | `execute()` = TODO, delegates to `QueryResolver` |
| **QueryResolver impl** | `platform.search.engine/src/org/modelio/platform/query/internal/resolver/QueryResolver.java` | Main resolver (440 lines), orchestrates sub-resolvers |
| **ResolverContext** | `platform.search.engine/src/org/modelio/platform/query/internal/resolver/ResolverContext.java` | Testability abstraction for metamodel access |
| **MObject JSON serializer** | `platform.search.engine/src/org/modelio/platform/query/api/model/frozen/jackson/MObjectSerializer.java` | MObject → `{mc, uuid, name}` |
| **MObject JSON deserializer** | `platform.search.engine/src/org/modelio/platform/query/api/model/frozen/jackson/MObjectTransientDeserializer.java` | JSON → MObject via converter lambda |
| **OSGi manifest** | `platform.search.engine/META-INF/MANIFEST.MF` | Exports, dependencies, JavaSE-21 |
| **Build script** | `platform.search.engine/build/build.sh` | Builds via Maven in subshell |
| **Test runner script** | `platform.search.engine.test/build/run-tests.sh` | Runs tests via Maven in subshell |
| **Test base class** | `platform.search.engine.test/src/org/modelio/platform/query/testutils/AbstractMqlTest.java` | Real session + transaction per test |
| **Test session factory** | `platform.search.engine.test/src/org/modelio/platform/query/testutils/TestSession.java` | CoreSession + MemoryRepository + Infra/Standard fragments |
| **Test model factory** | `platform.search.engine.test/src/org/modelio/platform/query/testutils/TestModelFactory.java` | Creates real MObject instances via GenericFactory |
| **UI editor dialog** | `app.model.search.ui/src/org/modelio/model/search/mql/ui/MqlEditorDialog.java` | GEF-based MQL visual editor |
| **UI query model** | `app.model.search.ui/src/org/modelio/model/search/mql/elements/core/MqlQueryModel.java` | UI domain model wrapping mutable Query AST |
| **Legacy search interface** | `platform.search.engine/src/org/modelio/platform/search/engine/ISearchEngine.java` | `search(session, criteria)` → `List<Element>` |

## Module Dependencies

```
                 org.modelio.core.utils (JavaSE-17)
                          │
                 org.modelio.core.kernel (JavaSE-17)
                          │
                 org.modelio.core.session (JavaSE-17)
                          │
                 org.modelio.core.metamodel.api (JavaSE-17)
                          │
              ┌───────────┴───────────┐
              │                       │
   org.modelio.platform.        com.fasterxml.jackson.*
   search.engine (JavaSE-21)   (core, databind, annotations)
              │
     ┌────────┴─────────┐
     │                   │
   (fragment)         (Require-Bundle)
     │                   │
   platform.search.    org.modelio.app.
   engine.test         model.search.ui (JavaSE-17)
   (JavaSE-21)            │
                    ┌──────┼──────┐
                    │      │      │
                org.eclipse.gef  org.eclipse.e4.*  (other UI bundles)
```

**Direct bundle dependencies of `platform.search.engine`:**
- `org.modelio.core.session` — ICoreSession for query execution
- `org.modelio.core.kernel` — MObject, MClass, MMetamodel kernel APIs
- `org.modelio.core.metamodel.api` — Metamodel interfaces (Stereotype, TagType, etc.)
- `org.modelio.platform.utils` — Base utilities (Log, etc.)
- `com.fasterxml.jackson.core.*` — JSON serialization (core, databind, annotations)
- `org.eclipse.core.runtime` — Eclipse runtime

**Direct bundle dependencies of `app.model.search.ui`:**
- `org.modelio.platform.search.engine` — MQL query model + legacy search API
- `org.eclipse.gef` — GEF graphical editing framework
- `org.eclipse.e4.*` — Eclipse e4 DI, commands, UI services
- `org.modelio.core.session`, `core.kernel`, `core.metamodel.api` — Model access
- `org.modelio.platform.ui`, `platform.model.ui`, `platform.rcp` — Modelio UI infrastructure

## Package Organization

### Main Module (`platform.search.engine`)

The source tree has two top-level namespaces:

1. **`org.modelio.platform.query`** — New MQL subsystem
   - `api/` — Public API surface (exported via OSGi)
     - `IQueryEngine.java`, `IQueryResolver.java`, `Queries.java`
     - `model/query/` — Mutable AST classes (exported)
     - `model/frozen/` — Immutable records + Jackson helpers (exported)
     - `model/resolved/` — Resolved metamodel-bound model (exported)
     - `model/result/` — Execution result model (exported)
   - `internal/` — Non-exported implementation
     - `QueryEngine.java`
     - `resolver/` — Resolution subsystem (6 classes + 2 diagnostics classes)

2. **`org.modelio.platform.search.engine`** — Legacy search subsystem
   - Root: `ISearchEngine`, `ISearchCriteria`, `DefaultSearchCriteria` (exported)
   - `plugin/` — OSGi activator (exported)
   - `searchers/model/`, `searchers/note/`, `searchers/inherit/` — Concrete searchers (exported)

### Key Design Patterns

- **Sealed hierarchies**: `Source`, `Step`, `Expr`, `ValueExpr`, `FrozenSource`, `FrozenStep`, `FrozenExpr`, `ResolvedStep`, `ResolvedSource`, `PathStepOutput`, `EdgeAlternative`, `KindAlternative`, `PropertyAlternative`
- **Records for immutable data**: All frozen model types, all resolved model types, `Diagnostic`, `DiagnosticLocation`, `ResolutionResult`
- **Parallel mutable/frozen type trees**: Every mutable AST type has a frozen record counterpart; `Conversions` handles bidirectional conversion
- **Registry + Resolver pattern**: `EdgeRegistry` builds lazy index, `EdgeResolver` uses it; `PropertyKeyRegistry` builds lazy index, `PropertyKeyResolver` uses it

## Where to Add New Code

**New query AST node type:**
- Mutable: `platform.search.engine/src/org/modelio/platform/query/api/model/query/`
- Frozen: `platform.search.engine/src/org/modelio/platform/query/api/model/frozen/`
- Resolved: `platform.search.engine/src/org/modelio/platform/query/api/model/resolved/`
- Resolver handling: `platform.search.engine/src/org/modelio/platform/query/internal/resolver/QueryResolver.java`
- Conversion: `platform.search.engine/src/org/modelio/platform/query/api/model/query/Conversions.java`
- Tests: `platform.search.engine.test/src/org/modelio/platform/query/`

**New resolver (e.g., for a new resolvable token type):**
- Resolver: `platform.search.engine/src/org/modelio/platform/query/internal/resolver/`
- Registry (if needed): same directory
- Tests: `platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/`

**New result type:**
- `platform.search.engine/src/org/modelio/platform/query/api/model/result/`

**Query execution engine implementation:**
- `platform.search.engine/src/org/modelio/platform/query/internal/QueryEngine.java`
- New execution classes: `platform.search.engine/src/org/modelio/platform/query/internal/` (create subdirectories as needed)

**New MQL editor UI element:**
- Domain model: `app.model.search.ui/src/org/modelio/model/search/mql/elements/<elementtype>/`
- UI panels: `app.model.search.ui/src/org/modelio/model/search/mql/ui/`
- GEF commands: `app.model.search.ui/src/org/modelio/model/search/mql/commands/`
- Edit policies: `app.model.search.ui/src/org/modelio/model/search/mql/editpolicies/`

**New legacy searcher:**
- `platform.search.engine/src/org/modelio/platform/search/engine/searchers/<searcher>/`

**Test utilities:**
- `platform.search.engine.test/src/org/modelio/platform/query/testutils/`

## Special Directories

| Directory | Purpose | Generated | Committed |
|-----------|---------|-----------|-----------|
| `target/` | Maven build output | Yes | No |
| `bin/` | IDE build output | Yes | No |
| `.gsd/` | GSD project metadata and codebase analysis | No | Varies |
| `build/` | Build scripts and aggregator POM | No | Yes |
| `resources/` (test module) | Test fixture files (JSON, etc.) | No | Yes |

## Naming Conventions

**Files:**
- AST nodes: named after concept (`Query.java`, `FilterStep.java`, `CompareExpr.java`)
- Frozen counterparts: `Frozen` prefix (`FrozenQuery.java`, `FrozenFilterStep.java`)
- Resolved counterparts: `Resolved` prefix (`ResolvedQuery.java`, `ResolvedStep.java`)
- Resolver classes: `*Resolver.java` (`KindResolver`, `EdgeResolver`, `PropertyKeyResolver`)
- Registry classes: `*Registry.java` (`EdgeRegistry`, `PropertyKeyRegistry`)
- UI elements: `Mql` prefix (`MqlQueryModel.java`, `MqlEditorDialog.java`, `MqlFilterFigure.java`)
- Tests: `*Test.java` suffix (`KindResolverTest.java`, `JacksonSerializationTest.java`)

**Packages:**
- Public API: `org.modelio.platform.query.api.*`
- Internal impl: `org.modelio.platform.query.internal.*`
- Legacy: `org.modelio.platform.search.engine.*`
- UI: `org.modelio.model.search.mql.*`

---

_Structure analysis: 2026-02-18_
