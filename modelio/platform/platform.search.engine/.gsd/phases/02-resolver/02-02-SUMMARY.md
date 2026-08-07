# 02-02 Summary — Edge Resolution (Dependency + Link)

Date: 2026-02-09

## Outcome

Implemented Phase 2 edge resolution: traverse edge strings now resolve into explicit, ambiguity-aware `ResolvedEdgeRef` alternatives (dependency edges and/or link-object edges) while preserving traversal direction metadata and emitting diagnostics for unknown/ambiguous tokens.

## What shipped

### Resolver context support

- `ResolverContext` now exposes `getRegisteredMetaclasses()` so edge indexing can be built without hard-coding `ICoreSession` into unit tests.
- `DefaultResolverContext` implements `getRegisteredMetaclasses()` via `session.getMetamodel().getRegisteredMClasses()`.

### Edge registry/index

- `EdgeRegistry` lazily indexes all `MDependency` by `MDependency.getName()` across registered metaclasses.
- No special parsing: dots are treated as normal characters in edge tokens.

### Edge resolution + diagnostics

- `EdgeResolver` resolves `(edgeToken, direction)` into `ResolvedEdgeRef` alternatives:
  - `ResolvedEdgeRef.DependencyEdge(MDependency, direction)`
  - `ResolvedEdgeRef.LinkObjectEdge(MClass linkMetaclass, Stereotype?, direction)`
- Normalization: `trim()` only; case-sensitive.
- Diagnostics:
  - unknown edge → WARNING + empty alternatives
  - ambiguous edge → WARNING + keep all alternatives
- Deterministic ordering:
  - dependency alternatives first (sorted by source/name/target where available)
  - link alternatives next (sorted by metaclass qualified name + stereotype UUID)

### QueryResolver wiring (TraverseStep)

- `QueryResolver` converts public `TraverseStep(edge, direction, edgeFilter?)` into internal `ResolvedStep.TraverseStep(ResolvedEdgeRef edge, ResolvedExpr edgeFilter)`.
- `edgeFilter` is not evaluated in v1 for this plan; it is carried forward as an internal `UnsupportedExpr("edgeFilter")` when present.

### Tests

- `EdgeResolverTest` — locks unknown/ambiguous behavior, direction propagation, and dot-handling.
- `QueryResolverEdgeSmokeTest` — smoke coverage that `TraverseStep` is resolved and uses the dependency index.

## Verification

### Host bundle build (skip tests)

Executed:
- `cd platform.search.engine/build && ... && mvn -DskipTests=true install`

Result:
- `mvn-exit.txt` = `0`

### Test bundle (run new edge resolver tests)

Executed:
- `cd platform.search.engine.test/build && ... && mvn -DskipTests=false -Dtest='*Edge*Test' verify`

Result:
- `mvn-exit.txt` = `0`
- 5 tests run, 0 failures

---

## ▶ Next Up

**02-03: Property Key Resolution** — Resolve property keys (attributes/tag types/notes/property definitions) into explicit alternatives with ambiguity/unknown diagnostics.

`/execute-phase.md 2`

<sub>`/clear` first → fresh context window</sub>

---
