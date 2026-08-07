# 01-02 Summary — Alternatives + Diagnostics Primitives

Date: 2026-02-06

## Outcome

Added the Phase 1 ambiguity representation (explicit alternatives for resolved refs) and a small internal diagnostics helper layer that emits the public `Diagnostic` DTO with stable location prefixes and capped related elements.

## What shipped

### Ambiguity / alternatives

- `org.modelio.platform.query.engine.resolved.Alternatives<T>` — immutable container for explicit resolution alternatives (supports empty).
- Resolved reference types modeling ambiguity as `Alternatives<...>`:
  - `ResolvedKindRef` — alternatives of `MClass` and `Stereotype`
  - `ResolvedEdgeRef` — alternatives of `MDependency` or link-object edges (`MClass` + optional `Stereotype`) with a direction enum
  - `ResolvedPropertyKeyRef` — alternatives of `MAttribute`, `TagType`, `NoteType`, `PropertyDefinition`

### Diagnostics primitives

- `org.modelio.platform.query.engine.diagnostics.DiagnosticLocation` — internal structured location (`step[n]/...`) rendered into a message prefix.
- `org.modelio.platform.query.engine.diagnostics.Diagnostics` — helper factory for public `org.modelio.platform.query.api.model.result.Diagnostic`:
  - accepts level in {info, warning, error}
  - prefixes messages with rendered location when provided
  - caps related elements to 500

### Tests

- `DiagnosticsSmokeTest` validates:
  - valid levels
  - stable location formatting (`step[2]/filter: ...`)
  - capping behavior (600 input elements → 500 output elements)

## Verification

### Host bundle build (skip tests)

Executed:
- `cd platform.search.engine/build && ... && mvn -q -DskipTests=true install`

Result:
- `mvn-exit.txt` = `0`

### Test bundle (run diagnostics smoke test)

Executed:
- `cd platform.search.engine.test/build && ... && mvn -q -DskipTests=false -Dtest='*DiagnosticsSmokeTest' verify`

Result:
- `mvn-exit.txt` = `0`
- `DiagnosticsSmokeTest`: 3 tests, 0 failures

## Notes

- Public `org.modelio.platform.query.api.model.result.Diagnostic` was not modified.

User note : I modified Diagnostic.level to be an enum instead of a string.

---

## ▶ Next Up

**02-01: Kind Resolution** — Resolve kind names (metaclass + stereotype) into `ResolvedKindRef` alternatives and emit ambiguity/unknown diagnostics.

`/execute-phase.md 2`

<sub>`/clear` first → fresh context window</sub>

---
