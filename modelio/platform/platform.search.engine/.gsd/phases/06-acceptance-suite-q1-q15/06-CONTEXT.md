# Phase 6: Acceptance Suite (Q1–Q15) - Context

**Gathered:** 2026-02-24
**Status:** Ready for planning

<domain>
## Phase Boundary

Prove spec conformance through automated tests that execute the 15 acceptance reference queries (Q1–Q15) against a representative model and assert correct results. Additionally, add regression tests for the four cross-cutting engine behaviours: deduplication, ambiguity→union expansion, repeat semantics, and truncation.

No new engine features are in scope. This phase only adds test coverage for an already-complete engine.

</domain>

<decisions>
## Implementation Decisions

### Test Fixture Strategy

- Extend `AbstractMqlTest` as the foundation for all acceptance tests — it provides the session and utilities needed to build test models.
- Build **one rich in-memory model** shared by all acceptance query groups (not per-test local setup), so that tests can also verify queries do *not* return more elements than expected.
- The fixture is built **programmatically in Java** (not loaded from a file).
- The inheritance depth and exact fixture location (shared base class vs. self-contained) are **Copilot's discretion** — choose the approach that is easiest to maintain.

### Query Coverage Mapping

- Test methods are grouped by **semantic concept**, not 1:1 per Q-number.
- Each test method documents which Q-numbers it covers with a **Javadoc comment** (e.g. `/** Covers Q1–Q3: basic kind filter. */`).
- Assertions use **`MObject.equals()`** for identity — **never UUID string comparison**.
  - ⚠️ Note: the source of a `UUID-comparison` pattern was likely `PathOutput` / serialization models. If UUID comparisons appear in test assertions elsewhere in the test suite, they should be flagged and corrected.
- Assertion style: use the option that produces the **clearest failure message** (Copilot's discretion — consider AssertJ `containsExactlyInAnyOrder` with a descriptive message).
- If tests reveal engine gaps, **write tests first** — failures are the signal to fix; fixing is part of the plan.

### Regression Suite Shape (Plan 06-02)

- All regression tests for 06-02 live in a **single new class** (e.g. `RegressionSuiteTest`).
- **Deduplication**: cover union-level dedup only — one element reachable from two paths asserts it appears exactly once in output.
- **Ambiguity→union**: verify both the result set *and* the diagnostic (number of alternatives retained).
- **Truncation**: cover both limit-triggered and timeout-triggered truncation — but **check `BudgetExecutionTest` first** to avoid duplicating existing coverage. Only add what is missing.

### Acceptance vs Smoke Split

- Acceptance tests are split into **one class per query group**, named `XxxAcceptanceTest` (e.g. `SearchAcceptanceTest`, `NavigationAcceptanceTest`, `ImpactAcceptanceTest`, `MixedAcceptanceTest`).
- All acceptance test classes live in the **`engine/acceptance/`** sub-package of the test module.
- Test methods are **named by concept** (not by Q-number), with the corresponding Q-refs in a Javadoc comment.
- All `XxxAcceptanceTest` classes share the **same rich fixture model** via shared setup.

### Copilot's Discretion

- Exact inheritance structure for fixture sharing (dedicated base class vs. setup method in a shared helper).
- Assertion style (library method and failure message formatting).
- Exact fixture model element set — as long as it covers all Q1–Q15 requirements and allows "no extra results" verification.

</decisions>

<specifics>
## Specific Ideas

- The shared fixture should include at minimum: Classes, Packages, Associations, a stereotype, tag values, and a note — enough to drive all 15 reference queries.
- `BudgetExecutionTest` may already cover limit/timeout truncation; do a gap analysis before adding new truncation regression tests.
- The in-model identity check note: `MObject.equals()` is the correct comparator for result set assertions.

</specifics>

<deferred>
## Deferred Ideas

None — discussion stayed within phase scope.

</deferred>

---

_Phase: 06-acceptance-suite-q1-q15_
_Context gathered: 2026-02-24_
