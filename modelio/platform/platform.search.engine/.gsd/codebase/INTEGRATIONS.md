# External Integrations

**Analysis Date:** 2026-02-18

## Dependencies on Other Modelio Modules

### Direct Dependencies (declared in MANIFEST.MF `Require-Bundle`)

| Module | Bundle Symbolic Name | Purpose | Key APIs Used |
|--------|---------------------|---------|---------------|
| core.kernel | `org.modelio.core.kernel` | Modeling kernel — metamodel infrastructure | `MObject`, `MClass`, `MAttribute`, `MDependency`, `MStatus` from `org.modelio.vcore.smkernel.mapi`; `SmAttribute`, `SmObjectSmClass` from `org.modelio.vcore.smkernel` |
| core.session | `org.modelio.core.session` | Model session management | `ICoreSession` from `org.modelio.vcore.session.api`; `IModel`, `IMObjectFilter` from `org.modelio.vcore.session.api.model` |
| core.metamodel.api | `org.modelio.core.metamodel.api` | UML/BPMN/Infrastructure metamodel interfaces | `Element`, `ModelElement`, `Note`, `NoteType`, `Stereotype`, `TagType`, `Profile`, `ModuleComponent` from `org.modelio.metamodel.uml.infrastructure`; `Class`, `Generalization`, `Interface`, `InterfaceRealization`, `NameSpace` from `org.modelio.metamodel.uml.statik`; `PropertyDefinition`, `PropertyTableDefinition` from `org.modelio.metamodel.uml.infrastructure.properties`; `MetaclassReference` from `org.modelio.metamodel.uml.infrastructure` |
| platform.utils | `org.modelio.platform.utils` | Logging and i18n utilities | `PluginLogger` from `org.modelio.platform.utils.log.writers`; `BundledMessages` from `org.modelio.platform.utils.i18n` |
| Eclipse Core Runtime | `org.eclipse.core.runtime` | OSGi plugin runtime | `BundleActivator`, `BundleContext` via `org.osgi.framework` |

### Transitive Dependencies (not directly required but available via dependency chain)

| Module | Bundle Symbolic Name | Purpose |
|--------|---------------------|---------|
| core.utils | `org.modelio.core.utils` | Low-level utilities (pulled in via `platform.utils` → `core.utils`) |
| Eclipse EMF Ecore | `org.eclipse.emf.ecore` | EMF compatibility (re-exported by `core.kernel`) |
| JDBM | `jdbm` | Embedded DB for model swap (re-exported by `core.kernel`) |

### Test-Only Dependencies (declared in test fragment MANIFEST.MF)

| Module | Bundle Symbolic Name | Purpose |
|--------|---------------------|---------|
| core.metamodel.impl | `org.modelio.core.metamodel.impl` | Metamodel implementation needed to instantiate real SmMetamodel in tests |
| JUnit Jupiter API | `junit-jupiter-api` | Test framework annotations (`@Test`, `@BeforeEach`, `@AfterEach`) |
| JUnit Jupiter Engine | `junit-jupiter-engine` | Test runtime engine |
| JUnit Jupiter Params | `junit-jupiter-params` | Parameterized tests |
| AssertJ Core | `assertj-core` | Fluent assertions (`assertThat(...)`) |

### UI Module Dependencies (app.model.search.ui → search engine)

| Module | Bundle Symbolic Name | Purpose |
|--------|---------------------|---------|
| platform.search.engine | `org.modelio.platform.search.engine` | This module — query AST and legacy search APIs |
| Eclipse JFace | `org.eclipse.jface` | UI dialog framework |
| Eclipse GEF | `org.eclipse.gef` | Graphical editor for MQL visual editor |
| Eclipse e4 DI | `org.eclipse.e4.core.di` | Dependency injection |
| Eclipse e4 UI | `org.eclipse.e4.ui.di`, `org.eclipse.e4.ui.services` | UI services and lifecycle annotations |
| platform.ui | `org.modelio.platform.ui` | Modelio UI utilities |
| platform.model.ui | `org.modelio.platform.model.ui` | Model-aware UI widgets |
| core.project | `org.modelio.core.project` | Project management |
| platform.core | `org.modelio.platform.core` | Platform-level services |
| platform.project | `org.modelio.platform.project` | Project UI integration |
| platform.rcp | `org.modelio.platform.rcp` | RCP integration utilities |

## External Libraries

### Jackson (JSON Serialization) — Critical Integration

| Library | Version | Bundle Name | Purpose |
|---------|---------|-------------|---------|
| Jackson Core | 2.18.3 | `com.fasterxml.jackson.core.jackson-core` | Low-level JSON parser/generator |
| Jackson Databind | 2.18.3 | `com.fasterxml.jackson.core.jackson-databind` | Object-to-JSON mapping, polymorphic type handling |
| Jackson Annotations | 2.18.3 | `com.fasterxml.jackson.core.jackson-annotations` | `@JsonProperty`, `@JsonTypeInfo`, `@JsonSubTypes`, `@JsonCreator`, `@JsonValue`, `@JsonEnumDefaultValue`, `@JsonIgnore`, `@JsonFormat` |

**Jackson usage pattern:**
- Frozen (immutable) model classes use Jackson annotations directly for JSON serialization
- Polymorphic type discrimination via `@JsonTypeInfo` + `@JsonSubTypes`:
  - `FrozenSource` → `"kind"` property → `"all"` / `"provided"` (in `src/org/modelio/platform/query/api/model/frozen/FrozenSource.java`)
  - `FrozenStep` → `"op"` property → `"filter"` / `"traverse"` / `"union"` / `"repeat"` (in `src/org/modelio/platform/query/api/model/frozen/FrozenStep.java`)
  - `FrozenExpr` → `"type"` property → `"and"` / `"or"` / `"not"` / `"compare"` / `"is"` / `"exists"` (in `src/org/modelio/platform/query/api/model/frozen/FrozenExpr.java`)
- Custom serializer: `MObjectSerializer` serializes `MObject` as `{"mc": "...", "uuid": "...", "name": "..."}` (in `src/org/modelio/platform/query/api/model/frozen/jackson/MObjectSerializer.java`)
- Custom deserializer: `MObjectTransientDeserializer` reconstitutes `MObject` from JSON reference using a converter function (in `src/org/modelio/platform/query/api/model/frozen/jackson/MObjectTransientDeserializer.java`)
- Uses Jackson `ObjectMapper` in tests (in `platform.search.engine.test/src/org/modelio/platform/query/api/model/JacksonSerializationTest.java`)

### OSGi / Eclipse Platform

| Library | Version | Purpose |
|---------|---------|---------|
| Eclipse Equinox (OSGi) | 3.19.0 | OSGi framework — bundle lifecycle, service registry |
| Eclipse Core Runtime | 3.31.0 | Plugin runtime, extension registry |
| Equinox ExtendedLogService | (part of equinox) | OSGi logging service used in `SearchEngine` plugin activator |

**OSGi usage in this module:**
- `BundleActivator` implemented in `src/org/modelio/platform/search/engine/plugin/SearchEngine.java`
- `BundleContext` for accessing `ExtendedLogService` via service reference
- Test fragment uses `FrameworkUtil.getBundle()` for runtime bundle resolution

## Runtime Platform

**OSGi Container:** Eclipse Equinox 3.19.0 (Eclipse RCP 2024-03 vintage)

**Module structure:**
- `platform.search.engine` is a regular OSGi bundle (`eclipse-plugin` packaging)
- `platform.search.engine.test` is a **Fragment** (`Fragment-Host: org.modelio.platform.search.engine`) — test code is injected into the host bundle's classloader
- `app.model.search.ui` is a regular OSGi bundle with lazy activation (`Bundle-ActivationPolicy: lazy`)

**Extension points:**
- `platform.search.engine` does NOT declare or contribute Eclipse extension points (no `plugin.xml`)
- `app.model.search.ui` contributes extensions via `plugin.xml`:
  - `org.eclipse.e4.workbench.model` fragment (`e4model/modelsearch.e4xmi`)
  - `org.modelio.app.model.search.ui.searchtool` (registers search panels and engines)

**Dependency resolution:**
- All dependencies are resolved from local p2 repositories defined in `dev-platform/rcp-target/rcp.target`
- No remote Maven/p2 repositories; fully offline build

## Serialization / Data Formats

### JSON (Primary)

- **Library:** Jackson 2.18.3
- **Usage:** MQL query AST serialization/deserialization
- **Annotated types:** All `Frozen*` record types in `src/org/modelio/platform/query/api/model/frozen/`
- **Discriminator patterns:**
  - `FrozenSource`: `{"kind": "all|provided", ...}`
  - `FrozenStep`: `{"op": "filter|traverse|union|repeat", ...}`
  - `FrozenExpr`: `{"type": "and|or|not|compare|is|exists", ...}`
  - `FrozenValueExpr`: `{"type": "literal|property", ...}`
- **Custom (de)serializers:** in `src/org/modelio/platform/query/api/model/frozen/jackson/`
- **MObject handling:** MObject is transient at runtime; serialized as a compact reference `{mc, uuid, name}` and reconstituted via a converter function

### No XML/Protobuf/Other

- The MQL module does not use XML serialization
- No REST/HTTP endpoints (pure in-process library)
- No database connections (model access is via `ICoreSession` API)

## APIs & External Services

**None.** This module is a pure in-process library with no external network calls, REST APIs, webhooks, or external service integrations.

## Data Storage

**Databases:** None directly. Model data is accessed via `ICoreSession` → `IModel` API.

**File Storage:** No direct file I/O. JSON serialization produces strings/streams; persistence is the caller's responsibility.

**Caching:** None.

## Authentication & Identity

**Not applicable.** This module has no authentication concerns. Authentication is handled at the project/connection level .

## Monitoring & Observability

**Logging:**
- Uses `PluginLogger` (from `org.modelio.platform.utils.log.writers`) backed by SLF4J → Logback
- Logger initialized in `SearchEngine` activator via OSGi `ExtendedLogService`
- Configured in `src/org/modelio/platform/search/engine/plugin/SearchEngine.java`

**Error Tracking:** None — errors are reported via `Diagnostic` objects (in `src/org/modelio/platform/query/api/model/result/Diagnostic.java`) as part of query execution results.

## Environment Configuration

**Required env vars:**
- `ECLIPSE_WS` — workspace root path (used by parent POM for p2 repository resolution)

**No secrets, no `.env` files, no runtime configuration files.**

## Backup / Related Module

The workspace also contains `core.query` (`org.modelio.core.query`), a backup/draft MQL implementation:
- Bundle: `org.modelio.core.query` v6.1.2
- Same `Require-Bundle` dependencies as `platform.search.engine` (kernel, session, metamodel.api, Jackson)
- JavaSE-21 BREE
- Contains specs under `core.query/specs/` (technical and functional MQL specifications)
- Not currently active; `platform.search.engine` is the canonical implementation

---

*Integration audit: 2026-02-18*
