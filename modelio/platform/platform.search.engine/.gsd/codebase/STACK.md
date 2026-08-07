# Technology Stack

**Analysis Date:** 2026-02-18

## Languages

**Primary:**

- Java 21 — source/target for `platform.search.engine` and `platform.search.engine.test` (`build.properties`: `javacSource = 21`, `javacTarget = 21`; MANIFEST.MF: `Bundle-RequiredExecutionEnvironment: JavaSE-21`)
- Java 17 — source/target for core dependency bundles (`core.kernel`, `core.session`, `core.utils`, `core.metamodel.api`) and the UI bundle (`app.model.search.ui`)

**Secondary:**

- Shell scripts (bash) — build and test runner scripts (`build/build.sh`, `build/run-tests.sh`)

## Runtime

**Java Version:**

- Java 21 for MQL bundles (`platform.search.engine`, `platform.search.engine.test`, `core.query`)
- Java 17 for all core bundles and the UI bundle
- Production JRE bundled in target platform: OpenJDK 17 (`dev-platform/pack-resources/openjdk-jre17`)

**Build Tool:**

- Apache Maven with Eclipse Tycho 4.0.13 (set in parent POM property `tycho-version`)
- Parent POM: `maven/modelio-parent/pom.xml` (`org.modelio:modelio-parent:6.1.2-SNAPSHOT`)
- All modules use `eclipse-plugin` packaging (Tycho builds)
- Tycho compiler plugin: `org.eclipse.tycho:tycho-compiler-plugin:4.0.13`
- Tycho Surefire plugin: `org.eclipse.tycho:tycho-surefire-plugin:4.0.13` (test module)
- Maven compiler plugin: `org.apache.maven.plugins:maven-compiler-plugin:3.8.0` (core.kernel only)

**Modelio Version:**

- `6.1.2-SNAPSHOT` (set in parent POM `modelio.version` property)

## Frameworks & Libraries

**Core:**

| Name | Version | Purpose | Config Location |
|------|---------|---------|-----------------|
| Eclipse OSGi (Equinox) | 3.19.0 | OSGi runtime framework for bundle lifecycle | `dev-platform/rcp-target/rcp-eclipse/eclipse/plugins/org.eclipse.osgi_3.19.0.v20240213-1246.jar` |
| Eclipse Core Runtime | 3.31.0 | Eclipse plugin runtime (`Require-Bundle: org.eclipse.core.runtime`) | `dev-platform/rcp-target/rcp-eclipse/eclipse/plugins/org.eclipse.core.runtime_3.31.0.v20240215-1631.jar` |
| Jackson Core | 2.18.3 | JSON parsing/generation (`com.fasterxml.jackson.core.jackson-core`) | `dev-platform/rcp-target/jackson/integ/plugins/com.fasterxml.jackson.core.jackson-core_2.18.3.jar` |
| Jackson Databind | 2.18.3 | JSON object mapping (`com.fasterxml.jackson.core.jackson-databind`) | `dev-platform/rcp-target/jackson/integ/plugins/com.fasterxml.jackson.core.jackson-databind_2.18.3.jar` |
| Jackson Annotations | 2.18.3 | JSON annotations (`com.fasterxml.jackson.core.jackson-annotations`) | `dev-platform/rcp-target/jackson/integ/plugins/com.fasterxml.jackson.core.jackson-annotations_2.18.3.jar` |
| Eclipse EMF Ecore | 2.9.0 | EMF compatibility layer (used by `core.kernel`) | `dev-platform/rcp-target/org.eclipse/emf/plugins/org.eclipse.emf.ecore_2.9.0.v20130528-0742.jar` |
| JDBM | (bundled) | Embedded database for swap/persistence (used by `core.kernel`, `core.session`) | `dev-platform/rcp-target/modelio-integ/org.jdbm/jdbm` |
| JavaDesigner Annotations | 2.2.0 | `@objid` identity annotations on all Java elements | Extra classpath element: `org.modelio:javadesigner:2.2.0` |

**UI (app.model.search.ui only):**

| Name | Version | Purpose | Config Location |
|------|---------|---------|-----------------|
| SWT | 3.125.0 | Native widget toolkit | `dev-platform/rcp-target/rcp-eclipse/eclipse/plugins/org.eclipse.swt.gtk.linux.aarch64_3.125.0.v20240227-1638.jar` |
| JFace | 3.33.0 | UI framework on top of SWT | `dev-platform/rcp-target/rcp-eclipse/eclipse/plugins/org.eclipse.jface_3.33.0.v20240214-1640.jar` |
| Eclipse GEF Classic | 3.20.0 | Graphical Editing Framework for diagram editors | `dev-platform/rcp-target/org.eclipse/gef-classic-S202409301913/plugins/org.eclipse.gef_3.20.0.202409301913.jar` |
| Eclipse Draw2d | 3.18.0 | 2D drawing framework (dependency of GEF) | `dev-platform/rcp-target/org.eclipse/gef-classic-S202409301913/plugins/org.eclipse.draw2d_3.18.0.202409301913.jar` |
| Eclipse e4 DI | various | Dependency injection framework for Eclipse 4 UI | `dev-platform/rcp-target/rcp-eclipse/eclipse/plugins/org.eclipse.e4.core.di_1.9.300.v20240207-1044.jar` |
| Jakarta Inject/Annotations | 1.0.0 / 1.1.0 | Standard DI annotations (imported by UI module) | `app.model.search.ui/META-INF/MANIFEST.MF` Import-Package |

**Testing:**

| Name | Version | Purpose | Config Location |
|------|---------|---------|-----------------|
| JUnit Jupiter (API) | 5.14.2 | Test framework | `dev-platform/rcp-target/junit/v5/plugins/junit-jupiter-api_5.14.2.jar` |
| JUnit Jupiter (Engine) | 5.14.2 | Test engine | `dev-platform/rcp-target/junit/v5/plugins/junit-jupiter-engine_5.14.2.jar` |
| JUnit Jupiter (Params) | 5.14.2 | Parameterized tests | `dev-platform/rcp-target/junit/v5/plugins/junit-jupiter-params_5.14.2.jar` |
| JUnit Platform | 1.14.2 | JUnit platform launcher/commons | `dev-platform/rcp-target/junit/v5/plugins/junit-platform-launcher_1.14.2.jar` |
| AssertJ | 3.27.6 | Fluent assertions | `dev-platform/rcp-target/junit/v5/plugins/assertj-core_3.27.6.jar` |
| ByteBuddy | 1.17.7 | Runtime code generation (used by test infrastructure) | `dev-platform/rcp-target/junit/v5/plugins/net.bytebuddy.byte-buddy_1.17.7.jar` |

**Logging (transitive via platform.utils):**

| Name | Version | Purpose |
|------|---------|---------|
| SLF4J API | 1.7.25 | Logging facade |
| Logback Classic | 1.2.7 | SLF4J logging backend |
| Logback Core | 1.2.7 | Logback core engine |

**core.utils bundled JARs:**

| Name | Version | Purpose |
|------|---------|---------|
| nimbus-jose-jwt | 10.0.1 | JWT/JWS handling |
| oauth2-oidc-sdk | 11.22.1 | OAuth2/OIDC SDK |
| json-smart | 2.5.2 | JSON parsing (OIDC dependency) |
| asm | 9.7.1 | Bytecode manipulation |
| accessors-smart | 2.5.2 | JSON accessors (json-smart dep) |
| content-type | 2.3 | Content type parsing |
| lang-tag | 1.7 | Language tag handling |

## Build System

**Tool:** Maven 3.x + Eclipse Tycho 4.0.13

**Config files:**
- Parent POM: `maven/modelio-parent/pom.xml`
- Main module POM: `platform/platform.search.engine/pom.xml`
- Build aggregator POM: `platform/platform.search.engine/build/pom.xml` (includes `rcp-target` + main module)
- Test aggregator POM: `platform/platform.search.engine.test/build/pom.xml`
- Target platform definition: `dev-platform/rcp-target/rcp.target`
- OSGi manifests: `META-INF/MANIFEST.MF` in each module
- Tycho build properties: `build.properties` in each module

**Key commands:**
- Build main module: `platform/platform.search.engine/build/build.sh`
- Run tests: `platform/platform.search.engine.test/build/run-tests.sh`
- Run specific test: `build/run-tests.sh -Dtest=JacksonSerializationTest`
- Environment setup: `source /work/modelio/alouette/toolkit/env_toolkit.sh`

**Build notes:**
- Maven MUST be run in a subshell `( mvn ... )` due to VSCode terminal integration bugs
- All dependencies are pre-provisioned as local p2 repositories; no remote dependency resolution
- The `pom.xml` in the module root does NOT work standalone; use `build/pom.xml` aggregator which includes the target platform, or better, use the provided build scripts .

## Development Tools

- Eclipse Tycho — OSGi-aware Maven build
- JavaDesigner 2.2.0 — Modelio annotation processor (`@objid` traceability annotations)
- Tycho Surefire (`providerHint: junit512`) — Test execution in OSGi container

## Configuration

| Config File | Purpose | Key Settings |
|-------------|---------|-------------|
| `platform.search.engine/META-INF/MANIFEST.MF` | Bundle metadata & dependencies | `Bundle-RequiredExecutionEnvironment: JavaSE-21`, `Require-Bundle`, `Export-Package` |
| `platform.search.engine/build.properties` | Tycho build config | `javacSource = 21`, `javacTarget = 21`, `source.. = src/` |
| `platform.search.engine/pom.xml` | Maven coordinates & parent | `maven.compiler.source=21`, `maven.compiler.target=17` (cross-compile) |
| `platform.search.engine/build/pom.xml` | Aggregator POM | Modules: `rcp-target`, `..` (main module) |
| `platform.search.engine.test/META-INF/MANIFEST.MF` | Test fragment | `Fragment-Host: org.modelio.platform.search.engine`, test deps |
| `platform.search.engine.test/build/pom.xml` | Test aggregator POM | Modules: `rcp-target`, `../../platform.search.engine`, `..` |
| `maven/modelio-parent/pom.xml` | Global build settings | `tycho-version=4.0.13`, `maven.compiler.source=17`, p2 repos |
| `dev-platform/rcp-target/rcp.target` | Eclipse target platform | All directory-based p2 repository locations |

## Platform Requirements

**Development:**
- Java 21 JDK (for MQL modules compilation)
- Maven (provided via `env_toolkit.sh`)
- Eclipse target platform provisioned locally at `dev-platform/rcp-target/`

**Production:**
- Eclipse RCP 4.31 (2024-03 based) with Equinox OSGi 3.19.0
- OpenJDK 17 JRE (bundled)
- Linux / Windows / macOS

---

*Stack analysis: 2026-02-18*
