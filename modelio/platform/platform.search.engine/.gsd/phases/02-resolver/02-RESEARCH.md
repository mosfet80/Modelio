━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 GSD ► RESEARCHING
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

# Phase 2: Resolver (Unresolved → Resolved) — Research

**Date:** 2026-02-09

## Goal

Document concrete lookup strategies for resolving:

- **Kinds**: metaclasses + stereotypes
- **Property keys**: attributes, TagTypes, NoteTypes, and **PropertyDefinitions** (typed property tables)

…using Modelio runtime APIs (session model + metamodel).

---

## Key APIs and Entry Points

### Session access

- `ICoreSession.getModel()` returns `IModel`:
  - provides `findByName(...)`, `streamByName(...)`, `findByClass(...)`, `findById(...)`, `findByRef(...)`.
  - `findByAtt(...)` exists but is deprecated and typically very slow.

- `ICoreSession.getMetamodel()` returns `SmMetamodel`:
  - use `getMClass(String)` to resolve metaclass names (short or qualified), eg `"Standard.Class"`, `"Infrastructure.Stereotype"`.

### “Reference implementation” patterns in codebase

- The class `org.modelio.metamodel.mmextensions.standard.services.MModelServices` contains real-world lookup logic for:
  - stereotypes
  - tag types
  - note types
  - resource types

It **does not** cover typed property tables / `PropertyDefinition` resolution, but the patterns are directly reusable.

---

## Resolving a `kind` string

### 1) Try metaclass resolution first (via metamodel)

- `MClass mc = session.getMetamodel().getMClass(kindString)`
- This method supports both short names (`Class`) and qualified names (`Standard.Class`), so it can be used directly for V1 resolution without additional parsing.

The Phase-2 context currently states “trim-only” normalization (no case folding), so resolution should be case-sensitive.

### 2) Resolve stereotypes via model search (via IModel)

Stereotypes are model elements at “meta level” (not owned by regular model elements).

Practical strategies:

- Fast direct lookup:
  -`findByName(Stereotype.class, true, name)` , result count is expected small.

- Full enumeration (for building a registry once per session):
  - `session.getModel().findByClass(Stereotype.class)`
  - or `session.getModel().findByClass(session.getMetamodel().getMClass("Infrastructure.Stereotype"))`

For applicability checks:

- `Stereotype.getBaseClassName()` gives the metaclass *name* it extends.
- `MClass base = session.getMetamodel().getMClass(ste.getBaseClassName())`
- `candidateMetaclass.hasBase(base)` (or inverse depending on your conventions) can be used to validate “can apply to X”.

Inheritance:

- `Stereotype.hasBase(parentStereotype)` / or recurse via `getParent()`.

### 3) Ambiguity handling

If both a metaclass and one-or-more stereotypes match the same input `kind` token, the resolver should keep **all alternatives**.

---

## Resolving TagTypes / NoteTypes / ResourceTypes (extension types)

Modelio stores “extension types” in two places:

1) On a **MetaclassReference** (per-profile metaclass extension)
2) On a **Stereotype** (stereotype-specific extension)

Key metamodel relations:

- `Profile.getOwnedReference()` → `MetaclassReference`
- `Profile.getDefinedStereotype()` → `Stereotype`

Then:

- `MetaclassReference.getDefinedTagType()` / `.getDefinedNoteType()` / `.getDefinedResourceType()`
- `Stereotype.getDefinedTagType()` / `.getDefinedNoteType()` / `.getDefinedResourceType()`

The production code pattern (see `MModelServices.findTagTypes/findNoteTypes/findResourceTypes`) is:

- iterate `ModuleComponent` via `session.getModel().findByClass(ModuleComponent.class)`
- for each module, iterate `module.getOwnedProfile()`
- inside each profile:
  - evaluate all `MetaclassReference` entries
  - evaluate all `Stereotype` entries

Filtering used in `MModelServices`:

- resolve reference base metaclass from `MetaclassReference.getReferencedClassName()`
- resolve stereotype base metaclass from `Stereotype.getBaseClassName()`
- ensure the queried metaclass “has base” the reference/stereotype base metaclass
- optionally filter on “ownerName” (metaclass qname pattern or stereotype inheritance)

Notes for Phase-2 resolver:

- In MQL, you probably won’t have the `moduleName`/`ownerName` “search form” parameters from `MModelServices`.
- Instead, for a resolved *candidate* `kind` alternative:
  - if it’s a `Stereotype`: only read from that stereotype (+ maybe its inheritance chain if desired)
  - if it’s a `MClass`: scan matching `MetaclassReference` across profiles whose referencedClass matches the candidate metaclass hierarchy

---

## Resolving typed property tables (PropertyDefinition)

Typed property tables are defined by:

- `PropertyTableDefinition`
  - has many `PropertyDefinition` via `PropertyTableDefinition.getOwned()`
  - provides a direct lookup helper: `PropertyTableDefinition.getOwned(String propName)`

A `PropertyTableDefinition` belongs either to:

- a `Stereotype` (`Stereotype.getDefinedTable()` / `PropertyTableDefinition.getOwnerStereotype()`)
- or a `MetaclassReference` (`MetaclassReference.getDefinedTable()` / `PropertyTableDefinition.getOwnerReference()`)

This is the missing counterpart to `MModelServices` (which resolves TagTypes/NoteTypes/ResourceTypes but not PropertyDefinitions).

### Lookup strategy for property key resolution

Given a property key string `p`:

- For a `Stereotype` candidate kind:
  - `PropertyTableDefinition table = ste.getDefinedTable()`
  - `PropertyDefinition def = (table != null) ? table.getOwned(p) : null`

- For a `MClass` candidate kind:
  - for each relevant `MetaclassReference ref` (profiles whose referencedClass matches):
    - `PropertyTableDefinition table = ref.getDefinedTable()`
    - `PropertyDefinition def = (table != null) ? table.getOwned(p) : null`

When building diagnostics / alternatives, keep the identity of the owner:

- property-definition key is not just `(name → def)`
- it’s `(owner stereotype/reference, property definition)`

This matters because runtime access uses the owner:

- property values are accessed with `ModelElement.getProperty(ownerStereotypeOrReference, propertyName)`

(See the UI implementation `StereotypeTableModel` which switches between `OwnerStereotype` and `OwnerReference` when calling `getProperty/setProperty`.)

---

## Suggested resolver data model (Phase-2)

When resolving *symbols* (not executing), it’s useful to represent each candidate as a typed alternative:

- `KindAlternative`:
  - `Metaclass(MClass)`
  - `Stereotype(Stereotype)`

- `PropertyKeyAlternative`:
  - `Attribute(MAttribute)`
  - `TagType(TagType)`
  - `NoteType(NoteType)`
  - `PropertyDefinition(owner=Stereotype|MetaclassReference, def=PropertyDefinition)`

…and emit ambiguities as “multiple alternatives”.

---

## Testing notes

There is a lightweight “real session” harness in [`core.query.tests`] , in `/work/modelio/alouette/work/eclipse/modelio/core/core.query.tests/src/org/modelio/core/query/testutils/` folder outside this VS Code workspace, notably:

- `TestSession`: constructs a `CoreSession` + `MemoryRepository` + standard metamodel fragments
- `TestModelFactory`: creates real model elements by metaclass name and sets dependencies
- `AbstractMqlTest`: JUnit base class that opens a session + transaction per test

This harness is suitable to test resolver behavior against real metamodel classes (without a full Modelio project).

---

## Pitfalls / gotchas

- `Stereotype.getExtendedElement()` is explicitly documented as potentially huge/slow; do not use it for discovery.
- `MModelServices.nameMatches()` allows both equality and regex `.matches()`; Phase-2 decisions currently say “trim-only, case-sensitive” so don’t accidentally adopt regex matching unless explicitly desired.
- Duplicated stereotype names across modules and/or metaclasses are possible → treat as ambiguity.

---

## ▶ Next Up

**Phase 2: Resolver** — turn this research into a concrete execution plan

`/plan-phase.md 2`

<sub>`/clear` first → fresh context window</sub>

---
