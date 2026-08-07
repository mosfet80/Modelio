# AGENTS.md - app.model.search.ui

This bundle provides the **Model Search UI** for Modelio:

- The **Quick Search** trimbar combo (name/UUID search).
- The **Advanced Search** dialog (tabbed search panels backed by legacy `ISearchEngine`).
- A **WIP MQL editor dialog** (graphical, non-technical query builder for “Modelio Query Language”).

The bundle is an Eclipse/OSGi plugin:

- **Bundle**: `org.modelio.app.model.search.ui`
- **Packaging**: `eclipse-plugin` (Tycho)
- **Java**: 17 (`Bundle-RequiredExecutionEnvironment: JavaSE-17`)
- **UI stack**: SWT/JFace + Eclipse e4 DI + GEF (classic)

## Where things are

### Legacy search UI

- `src/org/modelio/model/search` contains the legacy search UI.

### MQL editor UI (WIP)

The MQL editor is a **standalone dialog** (not a file editor) that hosts a small GEF canvas and right-side property panels.

- Entry point handler: `src/org/modelio/model/search/handlers/OpenMqlEditorHandler.java`
- Dialog shell: `src/org/modelio/model/search/mql/ui/MqlEditorDialog.java`
- Domain model: `src/org/modelio/model/search/mql/model/MqlQueryModel.java`
  - Wraps a mutable `org.modelio.platform.query.api.model.query.Query` AST.
  - Exposes UI-friendly nodes and fires `PropertyChangeSupport` events.
- Graphical editor component:
  - `src/org/modelio/model/search/mql/editor/MqlGraphicalEditor.java`
  - `src/org/modelio/model/search/mql/editparts/*` + `editpolicies/*` + `figures/*`

### i18n / resources

- Resource bundle: `res/modelsearch.properties` and `res/modelsearch_fr.properties`.
- `plugin.properties` / `plugin_fr.properties` provide Eclipse plugin string keys.

## Related modules (for cross-references)

- Query model and engine: `platform.search.engine` (`org.modelio.platform.query.api.model.*`).
- Kernel/metamodel/session APIs used by search: `core.kernel`, `core.metamodel.api`, `core.session`.

If you need to change the MQL AST types, do it in `platform.search.engine` (and add/adjust tests in `platform.search.engine.test`). Do not touch `core.metamodel.api` it is generated.

If you need to look for GEF diagram practices, see other GEF editors in the [`app.diagram.elements` project](../app.diagram.elements) .

## Setup (build)

### Prerequisites

- Java 17
- Maven + Tycho (provided via the Modelio toolkit)

## Build Module

Run the build with the provided [build/build.sh](build/build.sh) script :

```bash
build/build.sh           # compact: summary only
build/build.sh --verbose # verbose: stream full output
```

The script sources the Modelio toolkit and invokes Maven. By default it runs in compact mode: the terminal prints a short summary (exit code, result, filtered errors on failure). Use `--verbose` to stream full Maven output to the terminal .

It outputs 2 files:
- `build/mvn-build.log` contains the full Maven output .
- `build/mvn-exit.txt` records the exit code for scripted checks.

Do not try to run maven yourself.

## Testing

This bundle is a GUI bundle and does not have unit tests.


## Code style & conventions

- Java: prefer explicit types over `var`.
- Access instance fields with `this.` prefix for clarity.
- Use Java 21 coding features where appropriate (e.g., lambdas, switch expressions, records, pattern matching).
- UI: keep SWT/JFace updates on the UI thread (`Display#asyncExec` is used in several places).
- Annotations: keep existing `@objid` annotations intact (they are used by Modelio tooling).
- Never edit generated metamodel code in `core.metamodel.api`.
- GEF: group related edit parts, figures and model related to same element in the same package .

## Troubleshooting notes

- `QuickSearchCombo` disables itself on project close and hides when no project is open; test search UI with an opened project.
- The MQL editor keeps the “provided selection” source in sync via polling (`MqlEditorDialog`); if you change selection propagation, ensure it still stops polling on dialog close.
