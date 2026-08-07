# Coding Conventions

**Analysis Date:** 2026-02-18

## Naming Patterns

**Files:**
- One public type per file, named after the type: `FilterStep.java`, `FrozenQuery.java`
- Package-info files for Javadoc on every package: `package-info.java`

**Classes/Interfaces:**
- PascalCase for all types: `QueryResolver`, `ResolvedKind`, `DiagnosticLocation`
- Mutable AST types use bare names: `Query`, `FilterStep`, `CompareExpr`
- Frozen (immutable) counterparts are prefixed with `Frozen`: `FrozenQuery`, `FrozenFilterStep`
- Resolved model types are prefixed with `Resolved`: `ResolvedQuery`, `ResolvedStep`, `ResolvedKind`
- Interfaces prefixed with `I` for service APIs: `IQueryEngine`, `IQueryResolver`, `ISearchEngine`, `ISearchCriteria`
- Test classes suffixed with `Test`: `JacksonSerializationTest`, `KindResolverTest`
- Smoke tests suffixed with `SmokeTest`: `DiagnosticsSmokeTest`, `ResolvedModelSmokeTest`

**Methods/Variables:**
- camelCase: `resolveQuery()`, `kindResolver`, `outputKind()`
- Getters use `getXxx()` on mutable classes: `getWhere()`, `getEdge()`, `getKindName()`
- Record accessors use bare names (Java record convention): `where()`, `source()`, `steps()`
- Boolean accessors use `isXxx()`: `isUnknown()`, `isTruncated()`, `isDeleted()`
- Factory methods use `ofXxx()` or `createXxx()`: `ofString()`, `ofMetaclass()`, `createEmptyQuery()`

**Constants:**
- UPPER_SNAKE_CASE: `VERSION`, `V1`, `ELEMENTS_CAP`, `OUTPUT_DIR`

**Packages:**
- Root: `org.modelio.platform.query.api` for public API
- Internal: `org.modelio.platform.query.internal` for implementation details
- Legacy: `org.modelio.platform.search.engine` for the legacy search API
- Test utilities: `org.modelio.platform.query.testutils`
- Sub-package per concern: `.model.query`, `.model.frozen`, `.model.resolved`, `.model.result`

## Code Style

**Formatting:**
- Java 21 source level (`build.properties`: `javacSource = 21`, `javacTarget = 21`)
- OSGi execution environment: `JavaSE-21`
- 4-space indentation (standard Java)
- Opening braces on same line

**Type Declarations:**
- Prefer explicit types over `var`: `final ObjectMapper mapper = ...` not `final var mapper = ...`
- Always use `this.` prefix for instance field access:
  ```java
  this.where = where;
  this.kindResolver = new KindResolver(context);
  ```

**Linting:**
- No checkstyle/PMD/SpotBugs configuration detected
- Convention enforcement is manual via code review

## Import Organization

**Order:**
1. `java.*` standard library
2. Third-party (`com.fasterxml.jackson.*`, `com.modeliosoft.modelio.javadesigner.*`)
3. `org.modelio.*` project packages
4. `org.eclipse.*` Eclipse/OSGi packages

Note : Java files are reversed then regenerated with Modelio, which may cause some reordering/shuffling of imports. 

**Unused Import Policy:**
- Imports are kept clean; no unused imports observed

## Common Patterns

### Sealed Interface Hierarchies

Type-safe closed hierarchies use `sealed interface ... permits`:

```java
// src/org/modelio/platform/query/api/model/query/Step.java
public sealed interface Step permits FilterStep, TraverseStep, UnionStep, RepeatStep { ... }

// src/org/modelio/platform/query/api/model/query/Expr.java
public sealed interface Expr permits AndExpr, OrExpr, NotExpr, CompareExpr, IsExpr, ExistsExpr { ... }

// src/org/modelio/platform/query/api/model/query/Source.java
public sealed interface Source permits AllSource, ProvidedSource { ... }
```

Used in: `Step`, `Expr`, `Source`, `ValueExpr` (mutable); `FrozenStep`, `FrozenExpr`, `FrozenSource`, `FrozenValueExpr` (frozen); `ResolvedStep`, `ResolvedSource`, `ResolvedEdge.EdgeAlternative`, `ResolvedKind.KindAlternative`, `ResolvedProperty.PropertyAlternative` (resolved).

### Records for Immutable Data

Java `record` types are used for all immutable data:

```java
// src/org/modelio/platform/query/api/model/frozen/FrozenQuery.java
public final record FrozenQuery(int version, FrozenSource source, List<FrozenStep> steps, FrozenLimitsSpec limits) { ... }

// src/org/modelio/platform/query/api/model/frozen/FrozenFilterStep.java
public final record FrozenFilterStep(FrozenExpr where) implements FrozenStep { ... }

// src/org/modelio/platform/query/api/model/resolved/ResolvedQuery.java
public final record ResolvedQuery(ResolvedSource source, List<ResolvedStep> steps, FrozenLimitsSpec limits) { ... }

// src/org/modelio/platform/query/internal/resolver/ResolutionResult.java
public final record ResolutionResult(ResolvedQuery resolvedQuery, List<Diagnostic> diagnostics) { ... }

// src/org/modelio/platform/query/internal/resolver/diagnostics/DiagnosticLocation.java
public final record DiagnosticLocation(int stepIndex, List<String> path) { ... }
```

### Nested Records Inside Sealed Interfaces

Resolved model uses nested records inside sealed interfaces for compact algebraic types:

```java
// src/org/modelio/platform/query/api/model/resolved/ResolvedStep.java
public sealed interface ResolvedStep permits ... {
    ResolvedKind outputKind();

    final record FilterStep(ResolvedExpr predicate, ResolvedKind outputKind) implements ResolvedStep { ... }
    final record TraverseStep(ResolvedEdge edge, ...) implements ResolvedStep { ... }
    final record RepeatStep(List<ResolvedStep> body, ...) implements ResolvedStep { ... }
    final record UnionStep(List<List<ResolvedStep>> branches, ...) implements ResolvedStep { ... }
    final record UnsupportedStep(String reason, ...) implements ResolvedStep { ... }
}
```

Same pattern in `ResolvedSource`, `ResolvedEdge.EdgeAlternative`, `ResolvedKind.KindAlternative`, `ResolvedProperty.PropertyAlternative`.

### Mutable/Frozen/Resolved Three-Layer Model

The data model has three layers:
1. **Mutable** (`query` package): plain classes with getters/setters for UI-side query construction
2. **Frozen** (`frozen` package): immutable records with Jackson annotations for serialization
3. **Resolved** (`resolved` package): execution-ready records with metamodel-resolved references

Conversion methods:
- Mutable → Frozen: `query.freeze()`, `step.freeze()`, `expr.freeze()`
- Frozen → Mutable: constructor from frozen (e.g., `new Query(frozenQuery)`, `new FilterStep(frozenFilterStep)`)
- Frozen → Resolved: via `QueryResolver.resolve(query, session)`

### Defensive Null Checks in Constructors

Every constructor validates its arguments:

```java
// src/org/modelio/platform/query/api/model/query/Query.java
public Query(Source source, List<Step> steps, LimitsSpec limits) {
    if (source == null) throw new IllegalArgumentException("source must not be null");
    if (steps == null) throw new IllegalArgumentException("steps must not be null");
    if (limits == null) throw new IllegalArgumentException("limits must not be null");
    ...
}
```

Record compact constructors follow the same pattern:

```java
// src/org/modelio/platform/query/api/model/frozen/FrozenFilterStep.java
public FrozenFilterStep {
    if (where == null) throw new IllegalArgumentException("where must not be null");
}
```

### Defensive Copy of Collections

Lists are defensively copied on construction:

```java
// Mutable classes
this.steps = new ArrayList<>(steps);

// Records use List.copyOf()
steps = List.copyOf(steps);
diagnostics = (diagnostics == null) ? List.of() : List.copyOf(diagnostics);
```

### Deep Copy Pattern

Mutable AST types implement `deepCopy()`:

```java
// src/org/modelio/platform/query/api/model/query/Step.java
Step deepCopy();

// src/org/modelio/platform/query/api/model/query/FilterStep.java
public FilterStep(FilterStep other) {
    this.where = other.where.deepCopy();
}
```

### Constructor Overloading Convention

Mutable classes provide a standard set of constructors:
1. Primary constructor (from parameters)
2. Copy constructor (from same type)
3. Thaw constructor (from frozen counterpart)

```java
public FilterStep(Expr where) { ... }         // primary
public FilterStep(FilterStep other) { ... }   // copy
public FilterStep(FrozenFilterStep frozen) { ... } // thaw from frozen
```

### Jackson Polymorphism via @JsonTypeInfo/@JsonSubTypes

Sealed interfaces in the frozen model use Jackson annotations for polymorphic JSON:

```java
// src/org/modelio/platform/query/api/model/frozen/FrozenStep.java
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "op")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FrozenFilterStep.class, name = "filter"),
    @JsonSubTypes.Type(value = FrozenTraverseStep.class, name = "traverse"),
    @JsonSubTypes.Type(value = FrozenUnionStep.class, name = "union"),
    @JsonSubTypes.Type(value = FrozenRepeatStep.class, name = "repeat")
})
public sealed interface FrozenStep permits FrozenFilterStep, ... { }
```

Discriminator property names:
- `FrozenStep`: `"op"` → `"filter"`, `"traverse"`, `"union"`, `"repeat"`
- `FrozenSource`: `"kind"` → `"all"`, `"provided"`
- `FrozenExpr`: `"op"` → `"and"`, `"or"`, `"not"`, `"compare"`, `"is"`, `"exists"`
- `FrozenValueExpr`: `"kind"` → `"property"`, `"literal"`

### Enum with @JsonValue

Enums serialize to lowercase string via `@JsonValue`:

```java
// src/org/modelio/platform/query/api/model/query/Direction.java
public enum Direction {
    FORWARD, BACKWARD;

    @JsonValue
    public String value() { return name().toLowerCase(); }
}
```

### Resolver Context Interface for Testability

The `ResolverContext` interface (`src/org/modelio/platform/query/internal/resolver/ResolverContext.java`) abstracts metamodel access so resolvers can be tested without a full `ICoreSession`. Two implementations:
- `DefaultResolverContext`: wraps real `ICoreSession`
- `StubContext` (in tests): provides a simple `Map<String, MClass>` for isolated tests

### Static Factory Methods

Utility classes use static methods:

```java
// src/org/modelio/platform/query/api/Queries.java
public static Query createEmptyQuery() { ... }
public static IQueryEngine createEngine(ICoreSession session, ...) { ... }

// src/org/modelio/platform/query/internal/resolver/diagnostics/Diagnostics.java
public static Diagnostic info(String message) { ... }
public static Diagnostic warning(DiagnosticLocation location, String message) { ... }
```

## Error Handling

**Strategy:** Fail-fast with `IllegalArgumentException` for programming errors.

**Patterns:**
- All constructors validate non-null/non-blank constraints with `IllegalArgumentException`
- Resolver produces structured `Diagnostic` records (info/warning/error) instead of throwing
- `Diagnostic.Level` enum: `INFO`, `WARNING`, `ERROR`
- `DiagnosticLocation` provides structured path context: `"step[2]/filter: Ambiguous edge 'Generalization'"`
- Unknown names (kinds, edges, property keys) produce warnings, not errors — execution continues with empty alternatives
- Ambiguous names produce warnings and union of all alternatives
- Related model elements are capped at 500 per diagnostic
- The `QueryEngine.execute()` method is not yet implemented — throws `UnsupportedOperationException`

## Documentation

**Javadoc:**
- Comprehensive Javadoc on all public API classes, interfaces, and methods
- Javadoc includes `<p>`, `<ul>/<li>`, `<b>`, `{@link}`, `{@code}`, `<pre>` formatting
- `@param`, `@return`, `@throws` tags on all public methods
- `@see` references to related types at interface level
- Record parameters documented via Javadoc on the record declaration:
  ```java
  /**
   * @param level severity level
   * @param message human-readable description
   * @param elements optional related model elements
   */
  public final record Diagnostic(Level level, String message, List<MObject> elements) { ... }
  ```

**@objid Annotations:**
- Every class, interface, method, field, enum constant is annotated with `@objid("UUID")`
- These are managed by Modelio tooling — never create or modify them manually.
- Import: `com.modeliosoft.modelio.javadesigner.annotations.objid`
- Keep them when modifying code; if in doubt, remove — Modelio will recreate

**Copyright Header:**
- Every file starts with GPLv3 license header
- Copyright: `Copyright 2013-2025 Docaposte` (main module), `Copyright 2013-2026 Docaposte` (newer test files)

**package-info.java:**
- Present in key packages with Javadoc describing package purpose:
  - `src/org/modelio/platform/query/api/model/package-info.java`
  - `src/org/modelio/platform/query/api/model/query/package-info.java`
  - `src/org/modelio/platform/query/api/model/frozen/package-info.java`
  - `src/org/modelio/platform/query/api/model/result/package-info.java`

## Module/Plugin Design

**Exports (OSGi):**
- Public API packages exported in `META-INF/MANIFEST.MF`:
  - `org.modelio.platform.query.api.model`
  - `org.modelio.platform.query.api.model.frozen`
  - `org.modelio.platform.query.api.model.frozen.jackson`
  - `org.modelio.platform.query.api.model.query`
  - `org.modelio.platform.query.api.model.result`
  - `org.modelio.platform.query.api.model.resolved.*`
  - Legacy: `org.modelio.platform.search.engine`, `.plugin`, `.searchers.*`
- Internal packages are NOT exported: `org.modelio.platform.query.internal.*` 
- Test bundle is an OSGi fragment (`Fragment-Host: org.modelio.platform.search.engine`), giving it access to internal packages

**API/Internal Boundary:**
- `api` packages = public stable API for consumers
- `internal` packages = implementation details, not exported

---

*Convention analysis: 2026-02-18*
