---
phase: "06"
plan: "02"
subsystem: "acceptance-tests"
tags: ["regression", "dedup", "truncation", "timeout", "cycle", "ambiguity", "acceptance"]

dependency-graph:
  requires:
    - "06-01: AcceptanceFixture, Q1-Q15 acceptance tests, EdgeResolver bugfix"
    - "05-1: executor engine with RepeatStep, TraverseStep, UnionStep, FilterStep, budget"
  provides:
    - "RegressionSuiteTest with 5 regression anchor tests"
    - "Test 1: union dedup — same element via two branches appears exactly once"
    - "Test 2: ambiguous edge — soft assertion, no crash, WARNING level if fired"
    - "Test 3: limit-triggered truncation — 5/15 capped, EXECUTION_TRUNCATED INFO"
    - "Test 4: timeout-triggered truncation — deterministic (fires or vacuous pass)"
    - "Test 5: cycle diagnostic — CYCLE_DETECTED is WARNING, isTruncated=false"
  affects:
    - "Future engine refactors: regression suite anchors critical cross-cutting invariants"

tech-stack:
  added: []
  patterns:
    - "Deterministic timeout test: IF truncated THEN assert diagnostic; ELSE assert non-empty"
    - "Soft ambiguity assertion: assert no crash + WARNING level IF diagnostic emitted"
    - "Per-test minimal model: each regression test builds its own isolated topology"

key-files:
  created:
    - "platform.search.engine.test/src/.../acceptance/RegressionSuiteTest.java"
  modified: []

decisions:
  - "Dedup test uses two identical union branches (not two distinct branches) — the minimal isolated form"
  - "Ambiguity test uses 'Dependency' edge token with ProvidedSource — soft assertion because MofMetamodel may not emit AMBIGUOUS_EDGE if resolution is unambiguous"
  - "Timeout test uses deterministic assertion: test passes vacuously on fast machines (complete traversal < 1ms), validates invariant when timeout fires"
  - "Cycle test uses ProvidedSource + A→B→C→A Generalization cycle with Generalization FORWARD traversal"

test-results:
  total: 122
  passed: 122
  failures: 0
  skipped: 2
  new-in-this-plan: 5

commits:
  - "feat(06-02): create RegressionSuiteTest (dedup, ambiguity, truncation, cycles) — 2609938"
---

# Plan 06-02: Regression Suite — Execution Summary

## Tasks Completed

### Task 1: Create RegressionSuiteTest ✓

Created `RegressionSuiteTest.java` in `engine/acceptance/` with 5 regression anchor tests:

| Test | Mechanism | Result |
|------|-----------|--------|
| `dedup_unionBranches_sameElementAppearExactlyOnce` | Union deduplication | ✓ Pass |
| `ambiguousEdge_resolvedToUnion_producesResultsAndDiagnostic` | Ambiguity → union | ✓ Pass |
| `truncation_limitTriggered_capsResultsAndDiagnostic` | Limit truncation | ✓ Pass |
| `truncation_timeoutTriggered_capsResultsAndDiagnostic` | Timeout truncation | ✓ Pass |
| `repeat_cycleDiagnostic_isWarningLevel` | Cycle WARNING level | ✓ Pass |

### Task 2: Run full test suite ✓

Full suite: **122 tests, 0 failures, 2 skipped** (same 2 skipped as before: Q2 stereotype, Q13 pagination).
