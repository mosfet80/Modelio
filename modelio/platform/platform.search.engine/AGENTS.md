# AGENTS.md - platform.search.engine

## Module Overview

**Bundle Name**: Search Engine
**Artifact ID**: `org.modelio.platform.search.engine`
**Bundle Symbolic Name**: `org.modelio.platform.search.engine`

This bundle provides the **Modelio Query Langage** execution platform with the AST model, an immutable form used for execution, the result model, and Jackson (de)serialization helpers.

It also contains the legacy “search engine” API (`ISearchEngine`) and legacy searchers.

Note: the *execution* of MQL queries (graph traversal, budgeting, diagnostics production) is being implemented.

## Package Structure

### Query API (Public)

| Package | Description |
|---------|-------------|
| `org.modelio.platform.query.api` | Main API interfaces (IQueryEngine, IQueryResolver, IASyncExecution) |
| `org.modelio.platform.query.api.model` | Shared model types and factories |
| `org.modelio.platform.query.api.model.query` | Query AST classes - mutable (Sources, Steps, Expressions) |
| `org.modelio.platform.query.api.model.result` | Result model (Diagnostic, PathOutput, IQueryResponse) |
| `org.modelio.platform.query.api.model.frozen` | Frozen/immutable query model for execution (records) |
| `org.modelio.platform.query.api.model.resolved` | Resolved query model (after resolution pass) |

### Query Internal Implementation (Private)

| Package | Description |
|---------|-------------|
| `org.modelio.platform.query.internal` | Query engine runtime (QueryEngine) |
| `org.modelio.platform.query.internal.executor` | Query execution engine  |
| `org.modelio.platform.query.internal.resolver` | Query resolver - resolves references to metamodel |
| `org.modelio.platform.query.internal.resolver.diagnostics` | Resolver diagnostics and error reporting |

### Search Engine (Legacy)

| Package | Description |
|---------|-------------|
| `org.modelio.platform.search.engine` | Legacy search engine core (ISearchEngine, ISearchCriteria) |
| `org.modelio.platform.search.engine.plugin` | Search engine plugin infrastructure |
| `org.modelio.platform.search.engine.searchers` | Legacy searcher implementations |
| `org.modelio.platform.search.engine.searchers.model` | Model element search |
| `org.modelio.platform.search.engine.searchers.note` | Note/comment search |
| `org.modelio.platform.search.engine.searchers.inherit` | Inheritance hierarchy search |


## Build Module

Maven cannot be invoked directly from the command line due to Tycho's requirements and VSCode terminal integration bugs.

Instead, run the build with the provided script :
[build/build.sh](build/build.sh)

The script sources the Modelio toolkit and invokes Maven. By default it runs in **compact mode**: full Maven output goes to `build/mvn-build.log`, and the terminal prints a short summary (exit code, result, filtered errors on failure). Use `--verbose` to stream full Maven output to the terminal instead:

```bash
build/build.sh           # compact: summary only
build/build.sh --verbose # verbose: stream full output
```

The exit code and result are printed at the end. `build/mvn-exit.txt` also records the exit code for scripted checks.

## Testing Instructions

The tests are located under [platform.search.engine.test](../platform.search.engine.test/) module.

## Version Control
This module has its own Git repository .
The test module has its own **separate** repository as well.

## Notes for Code Changes

- Public API surface is exported via OSGi (see `Export-Package` in `META-INF/MANIFEST.MF`): Take care to export all `org.modelio.platform.query.api.**`.
- `org.modelio.platform.query.**` is in early development, so you may freely modify MQL public API without considering backwards compatibility until milestone 1.


## Quick Code Navigation

- Query API: `org.modelio.platform.query.api.*`
- Query AST: `org.modelio.platform.query.api.model.query.*` (mutable)
- Frozen model: `org.modelio.platform.query.api.model.frozen.*` (records)
- Results: `org.modelio.platform.query.api.model.result.*`
- Legacy search API: `org.modelio.platform.search.engine.*`

## Code Style Conventions

- Prefer explicit types over `var`.
- Use `this.` for instance field access.
- Prefer records for immutable data types.
- Add Javadoc comments for public API elements.
- Use sealed interfaces for closed hierarchies .
- Use Java 21 features where appropriate (e.g., `switch` expressions, `record` types).


## File Organization

```
platform.search.engine/
├── META-INF/
│   └── MANIFEST.MF          # OSGi bundle manifest
├── build.properties         # Tycho build configuration
├── pom.xml                  # Maven configuration (not used directly)
├── build/
│   ├── build.sh             # Build script for Maven (use this to build!)
│   └── pom.xml              # Maven aggregator
├── src/
│   └── org/modelio/platform/
│       ├── query/
│       │   └── api/
│       │       └── model/
│       │           ├── query/       # Query AST classes
│       │           ├── result/      # Result model classes
│       │           └── frozen/      # Frozen/immutable query model
│       │               └── jackson/     # Jackson serialization
│       └── search/              # Legacy search engine API and searchers
│           └── engine/
│               ├── ISearchEngine.java
│               ├── ISearchCriteria.java
│               ├── DefaultSearchCriteria.java
│               ├── plugin/          # Plugin infrastructure
│               └── searchers/       # Legacy searchers
│                   ├── model/       # Model search
│                   ├── note/        # Note search
│                   └── inherit/     # Inheritance search
└── src_bak/                     # Backup of old sources, ignore
```

## Debugging Tips

### Serialization Issues

1. Check that all fields are Jackson-compatible (no transient fields except MObject)
2. Verify custom deserializers are registered
3. Use `ObjectMapper.writerWithDefaultPrettyPrinter()` for readable output

### Query Execution Issues

1. Verify source metaclass names are valid
2. Check property names in expressions
3. Validate relationship names in traverse steps


## Dependencies

### OSGi Bundle Dependencies

| Bundle | Purpose |
|--------|---------|
| `org.modelio.core.kernel` | Kernel/metamodel base APIs |
| `org.modelio.core.session` | Session management |
| `org.modelio.core.utils` | Base utilities |
| `org.modelio.core.metamodel.api` | Metamodel interfaces |
| `org.eclipse.core.runtime` | Eclipse runtime |
| `com.fasterxml.jackson.core.jackson-core` | Jackson core |
| `com.fasterxml.jackson.core.jackson-databind` | Jackson databind |
| `com.fasterxml.jackson.core.jackson-annotations` | Jackson annotations |

### Dependencies Graph

```
org.modelio.core.utils
        ↓
org.modelio.core.kernel
        ↓
org.modelio.core.session
        ↓
org.modelio.core.metamodel.api
        ↓
org.modelio.platform.search.engine (this module)
        ↓
  Used by: application modules, search UI
```
