# Testing Patterns

**Analysis Date:** 2026-02-18

## Test Framework

**Runner:**
- JUnit Jupiter 5 (JUnit 5)
- OSGi bundle: `junit-jupiter-api`, `junit-jupiter-engine`, `junit-jupiter-params`
- Config: `META-INF/MANIFEST.MF` (Fragment-Host)

**Assertion Library:**
- AssertJ (`assertj-core`)
- Fluent assertion style: `assertThat(x).isEqualTo(y)`, `assertThat(list).hasSize(1)`, `assertThat(x).isInstanceOf(Foo.class)`
- Advanced: `InstanceOfAssertFactories.type(...)` for nested type-safe assertions

**Run Commands:**

```bash
# Run all tests (compact output: summary only)
platform.search.engine.test/build/run-tests.sh

# Run all tests (verbose: stream full Maven output)
platform.search.engine.test/build/run-tests.sh --verbose

# Run a specific test class
platform.search.engine.test/build/run-tests.sh -Dtest=JacksonSerializationTest
platform.search.engine.test/build/run-tests.sh --verbose -Dtest=JacksonSerializationTest

# Check exit code after run (also printed directly by the script)
cat platform.search.engine.test/build/mvn-exit.txt   # 0 = success

# Build main module (must succeed before tests)
platform.search.engine/build/build.sh
platform.search.engine/build/build.sh --verbose
```

The scripts source the Modelio toolkit (`/work/modelio/alouette/toolkit/env_toolkit.sh`) automatically. In **compact mode** (default), full Maven output goes to `mvn-build.log` and the terminal shows only a short summary (exit code, result, test pass/fail counts, filtered errors on failure). Use `--verbose` to stream full Maven output to the terminal instead. The exit code is also saved to `mvn-exit.txt`.

## Test File Organization

**Location:**
- Tests are in a separate OSGi fragment bundle: `platform.search.engine.test/`
- Fragment host: `org.modelio.platform.search.engine` (gives access to internal packages)
- Test sources: `platform.search.engine.test/src/`

**Naming:**
- Test classes: `*Test.java` (Tycho Surefire includes `**/*Test.java`)
- Smoke tests: `*SmokeTest.java`

**Package Structure:**
```
platform.search.engine.test/src/
├── org/modelio/platform/query/
│   ├── api/model/
│   │   ├── JacksonSerializationTest.java      # JSON serialization round-trips
│   │   └── ModelFreezeTest.java               # Mutable↔Frozen round-trips
│   ├── engine/
│   │   ├── DiagnosticsSmokeTest.java          # Diagnostic helper factory
│   │   ├── ResolvedModelSmokeTest.java        # Resolved model instantiation + OSGi visibility
│   │   └── resolver/
│   │       ├── EdgeResolverTest.java          # Edge token resolution
│   │       ├── KindResolverTest.java          # Kind token resolution (metaclass/stereotype)
│   │       ├── PropertyKeyResolverTest.java   # Property key resolution (attributes/tags/notes)
│   │       ├── QueryResolverCoverageTest.java # Full AST subtype coverage
│   │       ├── QueryResolverEdgeSmokeTest.java     # Edge traversal smoke
│   │       ├── QueryResolverKindSmokeTest.java     # Kind resolution smoke
│   │       └── QueryResolverPropertyKeySmokeTest.java  # Property key smoke
│   └── testutils/
│       ├── AbstractMqlTest.java               # Base class for model-aware tests
│       ├── TestModelFactory.java              # Real model element creation
│       └── TestSession.java                   # Lightweight CoreSession with MemoryRepository
```

## Test Structure

**Suite Organization:**

Tests follow one of two patterns:

### Pattern 1: Lightweight Unit Tests (no model session needed)

Used by: `JacksonSerializationTest`, `ModelFreezeTest`, `ResolvedModelSmokeTest`, `QueryResolverCoverageTest`

```java
class JacksonSerializationTest {
    @Test
    void serialize_query_ast() throws Exception {
        final ObjectMapper mapper = createObjectMapperWithMObjectDeserializer();
        // Build query objects, serialize, deserialize, assert equality
        final var query = new FrozenQuery(source, steps, limits);
        final String json = mapper.writeValueAsString(query);
        final var deserialized = mapper.readValue(json, FrozenQuery.class);
        assertThat(deserialized).isEqualTo(query);
    }
}
```

### Pattern 2: Model-Aware Tests (extend AbstractMqlTest)

Used by: `KindResolverTest`, `EdgeResolverTest`, `PropertyKeyResolverTest`, `DiagnosticsSmokeTest`, smoke tests

```java
class KindResolverTest extends AbstractMqlTest {
    @Test
    void case_sensitive_resolution() {
        final ResolverContext context = new DefaultResolverContext(this.session);
        final KindResolver resolver = new KindResolver(context);
        final List<Diagnostic> diags = new ArrayList<>();

        final ResolvedKind kind = resolver.resolve("class", diags);

        assertThat(kind.isUnknown()).isTrue();
        assertThat(diags).hasSize(1);
        assertThat(diags.get(0).level()).isEqualTo(Level.WARNING);
    }
}
```

### Test Naming Convention

Test methods use `snake_case` descriptive names:
- `serialize_query_ast()`
- `trim_only_normalization_is_applied()`
- `case_sensitive_resolution()`
- `ambiguity_keeps_all_alternatives_and_emits_warning()`
- `unknown_edge_token_emits_warning_and_resolves_to_empty_alternatives()`
- `resolves_traverse_step_edge_token_using_registered_dependencies()`

### Setup/Teardown (AbstractMqlTest)

```java
// platform.search.engine.test/src/org/modelio/platform/query/testutils/AbstractMqlTest.java
public abstract class AbstractMqlTest {
    protected TestSession testSession;
    protected TestModelFactory modelFactory;
    protected ICoreSession session;
    protected ITransaction transaction;

    @BeforeEach
    void setUpBase() throws IOException {
        this.testSession = TestSession.create();
        this.modelFactory = new TestModelFactory(this.testSession);
        this.session = this.testSession.getSession();
        this.transaction = this.testSession.createTransaction("Test");
        setUpModel();  // hook for subclasses
    }

    @AfterEach
    void tearDownBase() {
        if (this.transaction != null) {
            this.transaction.rollback();  // never commit test changes
            this.transaction = null;
        }
        if (this.testSession != null) {
            this.testSession.close();
            this.testSession = null;
        }
    }

    // Convenience factories
    protected MObject createClass(String name) { ... }
    protected MObject createInterface(String name) { ... }
    protected MObject createPackage(String name) { ... }
    protected MObject createGeneralization(MObject sub, MObject sup) { ... }
    protected MObject createDependency(MObject client, MObject supplier) { ... }
    protected void setOwner(MObject child, MObject owner) { ... }
}
```

## Mocking

### Pattern 1: JDK Dynamic Proxy for MObject/MClass (Lightweight Tests)

Used in `JacksonSerializationTest`, `ModelFreezeTest`, `QueryResolverCoverageTest`.
No mocking framework — uses `java.lang.reflect.Proxy` directly:

```java
// platform.search.engine.test/src/org/modelio/platform/query/api/model/JacksonSerializationTest.java
private static MObject mObject(final String mcQualifiedName, final String uuid, final String name) {
    final MClass mClass = mClass(mcQualifiedName);
    return (MObject) Proxy.newProxyInstance(
            JacksonSerializationTest.class.getClassLoader(),
            new Class<?>[] { MObject.class },
            (proxy, method, args) -> {
                return switch (method.getName()) {
                    case "getMClass" -> mClass;
                    case "getUuid" -> uuid;
                    case "getName" -> name;
                    case "toString" -> mcQualifiedName + "#" + uuid;
                    case "equals" -> { /* uuid-based equality */ }
                    case "hashCode" -> uuid.hashCode();
                    default -> defaultValue(method.getReturnType());
                };
            });
}

private static MClass mClass(final String qualifiedName) {
    return (MClass) Proxy.newProxyInstance(
            JacksonSerializationTest.class.getClassLoader(),
            new Class<?>[] { MClass.class },
            (proxy, method, args) -> {
                return switch (method.getName()) {
                    case "getQualifiedName" -> qualifiedName;
                    case "getName" -> qualifiedName;
                    case "toString" -> qualifiedName;
                    case "equals" -> { /* qualifiedName-based equality */ }
                    case "hashCode" -> qualifiedName.hashCode();
                    default -> defaultValue(method.getReturnType());
                };
            });
}
```

The `defaultValue()` helper returns primitive zero values for unimplemented methods.

**What to mock this way:**
- `MObject` and `MClass` when only identity fields (UUID, name, qualified name) are needed
- Quick, no dependency on full modeling kernel

**What NOT to mock this way:**
- Tests needing real model navigation (composition, dependencies, attributes) — use `TestSession` + `TestModelFactory` instead

### Pattern 2: StubContext for Resolver Isolation

Used in `QueryResolverCoverageTest`:

```java
// platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverCoverageTest.java
private static final class StubContext implements ResolverContext {
    private final Map<String, MClass> metaclasses;

    @Override
    public MClass getMetaclass(String kindToken) {
        return this.metaclasses.get(kindToken);
    }

    @Override
    public Iterable<? extends MClass> getRegisteredMetaclasses() {
        return this.metaclasses.values();
    }

    @Override
    public List<Stereotype> findStereotypesByName(String name) {
        return List.of();
    }
}
```

**When to use:** Unit-testing resolver logic without needing a full `ICoreSession` or metamodel.

### Pattern 3: Real Model Session (TestSession + TestModelFactory)

Used in all tests extending `AbstractMqlTest`:

```java
// platform.search.engine.test/src/org/modelio/platform/query/testutils/TestSession.java
public static TestSession create() throws IOException {
    CoreSession session = new CoreSessionBuilder().build();
    session.getMetamodel().addMetamodelFragment(InfrastructureMetamodelFragment.getInstance());
    session.getMetamodel().addMetamodelFragment(StandardMetamodelFragment.getInstance());

    MemoryRepository repository = new MemoryRepository();
    session.getRepositorySupport().connectRepository(repository, new BasicAccessManager(), new NullProgress());
    return new TestSession(session, repository, session.getMetamodel());
}
```

```java
// platform.search.engine.test/src/org/modelio/platform/query/testutils/TestModelFactory.java
public MObject createElement(String metaclassName, String name) { ... }
public <T extends MObject> T createElement(Class<T> metaclass, String name) { ... }
public void setDependency(MObject source, String depName, MObject target) { ... }
public void setDependencies(MObject source, String depName, List<MObject> targets) { ... }
public void setAttribute(MObject obj, String attrName, Object value) { ... }
```

**When to use:** Tests that need real metamodel resolution, dependency traversal, stereotype creation, or attribute access.

## Fixtures and Test Data

**Test Data Creation:**

```java
// In test method or setUpModel() override:
final Profile profile = this.modelFactory.createElement(Profile.class, "TestProfile");
final Stereotype stereotype = this.modelFactory.createElement(Stereotype.class, "Class");
this.modelFactory.setDependency(stereotype, "Owner", profile);
stereotype.setBaseClassName("Standard.Class");
```

**Location:**
- Test utilities: `platform.search.engine.test/src/org/modelio/platform/query/testutils/`
  - `AbstractMqlTest.java` — base class with helper factories
  - `TestModelFactory.java` — element creation and relationship wiring
  - `TestSession.java` — lightweight CoreSession bootstrap

**JSON Output:**
- Serialization tests write JSON samples to `target/json-samples/` directory for manual inspection

## Jackson ObjectMapper Configuration in Tests

```java
// platform.search.engine.test/src/org/modelio/platform/query/api/model/JacksonSerializationTest.java
private static ObjectMapper createObjectMapperWithMObjectDeserializer() {
    final ObjectMapper mapper = new ObjectMapper();
    final var deserializer = new MObjectTransientDeserializer(ref ->
        mObject(ref.mc(), ref.uuid(), ref.name())
    );
    mapper.registerModule(new com.fasterxml.jackson.databind.module.SimpleModule()
        .addDeserializer(MObject.class, deserializer));
    return mapper;
}
```

The `MObjectTransientDeserializer` accepts a `Function<MObjectRef, MObject>` converter lambda that re-hydrates `MObject` references from JSON. In tests, this lambda creates Proxy-based mock objects.

## Coverage

**Requirements:** No formal coverage targets enforced.

**What IS tested:**

| Area | Test Files | Coverage Level |
|------|-----------|----------------|
| JSON serialization (all AST types) | `JacksonSerializationTest` | Comprehensive (all source/step/expr/value types) |
| Mutable↔Frozen round-trip | `ModelFreezeTest` | Comprehensive (all types, nested structures, all literal types) |
| Kind resolution | `KindResolverTest` | Good (trim, case sensitivity, ambiguity, dots in names) |
| Edge resolution | `EdgeResolverTest` | Good (unknown tokens, ambiguity, direction propagation, dots) |
| Property key resolution | `PropertyKeyResolverTest` | Good (unknown keys, meta-attributes, tag types, note types, property defs) |
| Full AST subtype coverage | `QueryResolverCoverageTest` | Excellent (dynamically discovers all Step/Expr subtypes, verifies resolver handles each) |
| Query→Resolved pipeline | `QueryResolverEdgeSmokeTest`, `QueryResolverKindSmokeTest`, `QueryResolverPropertyKeySmokeTest` | Smoke-level |
| Diagnostic factory | `DiagnosticsSmokeTest` | Good (levels, location rendering, element capping) |
| Resolved model instantiation | `ResolvedModelSmokeTest` | Basic (instantiation, OSGi export verification) |

**What is NOT tested:**

| Area | Reason |
|------|--------|
| Query execution (`QueryEngine.execute()`) | Not yet implemented (`throw UnsupportedOperationException`) |
| `AsyncIterator` and `IQueryResponse` | No execution engine yet |
| Path explanation output (`PathOutput`, `PathStepOutput`, etc.) | No execution engine yet |
| Legacy search engine (`ISearchEngine`, searchers) | Pre-existing code, no tests in this test module |
| UI module (`app.model.search.ui`) | GUI bundle, no unit tests |
| `Conversions.java` (frozen→mutable helpers) | Covered indirectly via round-trip tests |
| `EdgeRegistry`, `PropertyKeyRegistry` | Covered indirectly via resolver tests |

## Test Types

**Unit Tests:**
- `KindResolverTest`, `EdgeResolverTest`, `PropertyKeyResolverTest` — test individual resolver components in isolation with real metamodel
- `QueryResolverCoverageTest` — tests full resolver pipeline with stub context (no real metamodel)

**Integration Tests:**
- `QueryResolverEdgeSmokeTest`, `QueryResolverKindSmokeTest`, `QueryResolverPropertyKeySmokeTest` — test resolver against real `CoreSession` with full UML/BPMN metamodel
- `JacksonSerializationTest` — tests full JSON round-trip with Jackson ObjectMapper

**Smoke Tests:**
- `DiagnosticsSmokeTest`, `ResolvedModelSmokeTest` — verify basic functionality without deep assertions

## Common Patterns

### Self-Verifying AST Coverage

`QueryResolverCoverageTest` dynamically discovers all concrete `Step` and `Expr` subtypes in the query package via classpath scanning, then verifies the resolver handles each one. If a new AST subtype is added without a resolver branch, the test fails:

```java
// platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverCoverageTest.java
@Test
void resolves_step_subtypes_without_unsupported_diagnostics() {
    assertFactoryCoverage(Step.class, QUERY_PACKAGE, STEP_FACTORIES);
    // ... creates query with all step types, resolves, checks no "Unsupported" diagnostics
}
```

### Round-Trip Verification

Serialization and freeze tests use round-trip equality:

```java
final FrozenQuery frozen1 = query.freeze();
final Query unfrozen = new Query(frozen1);
final FrozenQuery frozen2 = unfrozen.freeze();
assertThat(frozen2).isEqualTo(frozen1);
```

### Diagnostic Assertion Pattern

```java
assertThat(diags).hasSize(1);
assertThat(diags.get(0).level()).isEqualTo(Level.WARNING);
assertThat(diags.get(0).message()).contains("Unknown kind");
```

### OSGi Bundle Visibility Test

```java
// platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
@Test
void resolved_package_is_not_exported_by_host_bundle() {
    final Bundle bundle = FrameworkUtil.getBundle(org.modelio.platform.query.internal.resolver.KindResolver.class);
    assertThat(bundle).as("KindResolver must be loaded from an OSGi bundle").isNotNull();

    final String exportPackage = bundle.getHeaders().get("Export-Package");
    assertThat(exportPackage).isNotNull();
    assertThat(exportPackage)
        .as("internal execution packages must not be exported")
        .doesNotContain("org.modelio.platform.query.internal");
}
```

---

*Testing analysis: 2026-02-18*
