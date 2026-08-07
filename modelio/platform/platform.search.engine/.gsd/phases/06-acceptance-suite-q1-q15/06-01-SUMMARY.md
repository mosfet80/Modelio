---
phase: "06"
plan: "01"
subsystem: "acceptance-tests"
tags: ["acceptance", "Q1-Q15", "mql", "fixture", "traversal", "cycle", "bugfix"]

dependency-graph:
  requires:
    - "05-1: executor engine with RepeatStep, TraverseStep, UnionStep, FilterStep"
  provides:
    - "AcceptanceFixture shared rich model for Q1-Q15"
    - "SearchAcceptanceTest Q1, Q3 (Q2 @Disabled)"
    - "NavigationAcceptanceTest Q4, Q5, Q11, Q14"
    - "ImpactAcceptanceTest Q6, Q7, Q8"
    - "MixedAcceptanceTest Q12, Q15 (Q13 @Disabled)"
  affects:
    - "06-02: regression suite, same fixture may be reused"

tech-stack:
  added: []
  patterns:
    - "AcceptanceFixture.populate(TestModelFactory) static factory pattern"
    - "ProvidedSource queries must pass selection via engine supplier, not ProvidedSource constructor"

key-files:
  created:
    - "platform.search.engine.test/src/.../acceptance/AcceptanceFixture.java"
    - "platform.search.engine.test/src/.../acceptance/SearchAcceptanceTest.java"
    - "platform.search.engine.test/src/.../acceptance/NavigationAcceptanceTest.java"
    - "platform.search.engine.test/src/.../acceptance/ImpactAcceptanceTest.java"
    - "platform.search.engine.test/src/.../acceptance/MixedAcceptanceTest.java"
  modified:
    - "platform.search.engine/src/.../resolver/EdgeResolver.java (bug fix)"

decisions:
  - "ProvidedSource queries: elements must be wired via the engine selectionProvider supplier — the QueryEngine always overwrites ProvidedSource.elements on execution"
  - "Q9/Q10 (KV filter) remain out of scope for MofMetamodel sessions"
  - "Q2 (stereotype filter) disabled — no stereotype registry in test sessions"
  - "Q13 (cursor pagination) disabled — not yet implemented in engine"
  - "EdgeResolver bug fixed: anyKind() root metaclass (SmObject, no superclass) must be treated as compatible with any MDependency to avoid filtering out all edges for ProvidedSource queries"

metrics:
  duration: "~45 minutes"
  completed: "2026-02-24"
---

# Phase 06 Plan 01: Acceptance Fixture and Q1-Q15 Tests Summary

Acceptance test suite validating MQL engine conformance against reference queries Q1–Q15.

## What Was Built

Five new files in `engine/acceptance/` package:

| File | Q-numbers |
|------|-----------|
| `AcceptanceFixture.java` | Shared model for all tests |
| `SearchAcceptanceTest.java` | Q1 ✓, Q2 @Disabled, Q3 ✓ |
| `NavigationAcceptanceTest.java` | Q4 ✓, Q5 ✓, Q11 ✓, Q14 ✓ |
| `ImpactAcceptanceTest.java` | Q6 ✓, Q7 ✓, Q8 ✓ |
| `MixedAcceptanceTest.java` | Q12 ✓, Q13 @Disabled, Q15 ✓ |

## Test Results

```
Tests run: 117, Failures: 0, Errors: 0, Skipped: 2
```

- Existing tests: 104 — all green (no regressions)
- New acceptance tests: 11 active + 2 @Disabled = 13 new
- Disabled: Q2 (stereotype registry), Q13 (pagination cursor)

## Decisions Made

1. **ProvidedSource pattern**: elements are wired via the `QueryEngine` selection supplier (`new QueryEngine(session, () -> elements)`), not the `ProvidedSource` constructor (which is always overwritten by the engine).

2. **Q2 disabled**: stereotype registry not available in MofMetamodel test sessions.

3. **Q9/Q10 disabled**: KV-based TagType/PropertyDefinition filters not modeled in AcceptanceFixture (out of scope for MofMetamodel).

4. **Q13 disabled**: cursor/pagination not yet implemented in engine.

## Deviations from Plan

### Auto-fixed Issues

**[Rule 1 - Bug] EdgeResolver.isCompatibleMetaclass — root metaclass not accepted for anyKind**

- **Found during:** Tasks 3, 4, 5 (all ProvidedSource + TraverseStep tests failing)
- **Issue:** `anyKind()` represents "any element" via `SmObject` (root metaclass). `isCompatibleMetaclass(SmObject, NameSpace)` returned false because SmObject doesn't extend NameSpace. This caused ALL MDependency edges to be filtered from alternatives for ProvidedSource queries (OwnedElement, Dependency, etc.) → unknown edge → traverse step swallowed inputs → empty results.
- **Fix:** Added special case: if `currentMetaclass.getSuper() == null` (root class), return `true` for any expected metaclass.
- **Files modified:** `platform.search.engine/src/.../resolver/EdgeResolver.java`
- **Commit:** `87b1a9b` (main repo)

## Commits

### Test module (platform.search.engine.test)

| Hash | Description |
|------|-------------|
| `0ea60f5` | feat(06-01): create AcceptanceFixture shared model builder |
| `12371f9` | feat(06-01): create SearchAcceptanceTest (Q1, Q2, Q3) |
| `4a80c24` | feat(06-01): create NavigationAcceptanceTest (Q4, Q5, Q11, Q14) |
| `ef1eb26` | feat(06-01): create ImpactAcceptanceTest (Q6, Q7, Q8) |
| `f97bdb8` | feat(06-01): create MixedAcceptanceTest (Q12, Q13, Q15) |

### Main module (platform.search.engine)

| Hash | Description |
|------|-------------|
| `87b1a9b` | fix(06-01): EdgeResolver.isCompatibleMetaclass accepts root metaclass for anyKind |

## Next Phase Readiness

- Plan 06-02 can start: regression tests for cross-cutting engine behaviors.
- AcceptanceFixture is available and can be reused or extended for 06-02.
- The EdgeResolver fix means ProvidedSource queries now work correctly for all traversal types.
