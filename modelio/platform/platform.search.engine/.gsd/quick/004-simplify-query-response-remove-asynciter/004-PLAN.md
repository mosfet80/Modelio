---
phase: quick-004
plan: 01
type: execute
wave: 1
depends_on: []
files_modified:
  - src/org/modelio/platform/query/api/model/result/IQueryResponse.java
  - src/org/modelio/platform/query/internal/executor/StreamingQueryResponse.java
  - src/org/modelio/platform/query/internal/executor/PreparedAsyncExecution.java
  - src/org/modelio/platform/query/internal/QueryEngine.java
  - src/org/modelio/platform/query/api/model/result/AsyncIterator.java
  - src/org/modelio/platform/query/api/model/result/AsyncIterators.java
  - ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/StreamingQueryResponseTest.java
  - ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/PreparedAsyncExecutionTest.java
  - ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/QueryEngineExecutionTest.java
autonomous: true

must_haves:
  truths:
    - "Query responses expose materialized collections for items and diagnostics"
    - "No query-response consumer needs AsyncIterator pulls to consume results"
    - "Sync and prepared-async entry points keep the same terminal-state semantics"
  artifacts:
    - path: "src/org/modelio/platform/query/api/model/result/IQueryResponse.java"
      provides: "Collection-based response API for items/diagnostics"
      min_lines: 70
    - path: "src/org/modelio/platform/query/internal/executor/StreamingQueryResponse.java"
      provides: "Concrete response implementation that stores finalized item/diagnostic collections"
      min_lines: 140
    - path: "src/org/modelio/platform/query/internal/executor/PreparedAsyncExecution.java"
      provides: "Handler dispatch based on response collections instead of AsyncIterators"
      min_lines: 120
  key_links:
    - from: "src/org/modelio/platform/query/internal/QueryEngine.java"
      to: "src/org/modelio/platform/query/internal/executor/StreamingQueryResponse.java"
      via: "factory method returning collection-based response"
      pattern: "StreamingQueryResponse\\.(create|empty)"
    - from: "src/org/modelio/platform/query/internal/executor/PreparedAsyncExecution.java"
      to: "src/org/modelio/platform/query/api/model/result/IQueryResponse.java"
      via: "iterates response items()/diagnostics() as collections"
      pattern: "for \\(|items\\(\\)|diagnostics\\(\\)"
---

<objective>
Simplify query response consumption by removing AsyncIterator-based response streams and exposing collection-based results (`items` and `diagnostics`) directly on `IQueryResponse`.

Purpose: Reduce response API complexity, eliminate pull-loop lifecycle edge cases in consumers, and keep execution behavior easier to reason about.

Output: Collection-based response contract + adapted executor internals + updated executor tests in `platform.search.engine.test`.
</objective>

<execution_context>
@.github/skills/execute-plan/SKILL.md
@.gsd/templates/summary.md
</execution_context>

<context>
@.gsd/STATE.md
@src/org/modelio/platform/query/api/model/result/IQueryResponse.java
@src/org/modelio/platform/query/internal/executor/StreamingQueryResponse.java
@src/org/modelio/platform/query/internal/executor/PreparedAsyncExecution.java
@src/org/modelio/platform/query/internal/QueryEngine.java
@../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/StreamingQueryResponseTest.java
@../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/PreparedAsyncExecutionTest.java
@../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/QueryEngineExecutionTest.java
</context>

<tasks>

<task type="auto">
  <name>Task 1: Replace IQueryResponse AsyncIterator contract with collection accessors</name>
  <files>
    src/org/modelio/platform/query/api/model/result/IQueryResponse.java
    src/org/modelio/platform/query/api/model/result/AsyncIterator.java
    src/org/modelio/platform/query/api/model/result/AsyncIterators.java
  </files>
  <action>
Change `IQueryResponse` so `items()` and `diagnostics()` return materialized collections (`List<NodeWithExplainOut>` and `List<Diagnostic>`), not `AsyncIterator`.

Keep `state()`, `isTruncated()`, and `dispose()` in the public contract. Update Javadoc to describe finalized collections and ordering guarantees.

Remove response-level AsyncIterator utility surface from the public result API (`AsyncIterator`, `AsyncIterators`) if no remaining in-module usage after migration. If one utility remains needed outside response handling, keep it internal and out of the response contract.
  </action>
  <verify>
Run API/build compile check:

`cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine && build/build.sh`

Confirm:
- `IQueryResponse` compiles with list-returning accessors
- no compile references to `IQueryResponse.items().nextAsync()` / `diagnostics().nextAsync()` remain in `platform.search.engine`
  </verify>
  <done>
- `IQueryResponse` exposes collection-based `items()` and `diagnostics()`
- Response API no longer requires AsyncIterator pull semantics
- AsyncIterator response API types are removed or fully decoupled from response consumption
  </done>
</task>

<task type="auto">
  <name>Task 2: Refactor executor response implementation and async handle to collection consumption</name>
  <files>
    src/org/modelio/platform/query/internal/executor/StreamingQueryResponse.java
    src/org/modelio/platform/query/internal/executor/PreparedAsyncExecution.java
    src/org/modelio/platform/query/internal/QueryEngine.java
  </files>
  <action>
Refactor response implementation from stream/pump semantics to finalized collection storage:

1. `StreamingQueryResponse`
   - keep factory entry points (`create`, `empty`) but make them produce a response with materialized item/diagnostic lists.
   - keep terminal state semantics (`ACTIVE`→`ENDED|CANCELLED|FAILED`) and `isTruncated` behavior.
   - ensure collections exposed by `items()` / `diagnostics()` are deterministic and safe to iterate repeatedly (immutable snapshots).

2. `QueryEngine`
   - keep current resolution/error gating behavior.
   - adapt execution path to build collection results through response context/factory instead of iterator buffers.

3. `PreparedAsyncExecution`
   - replace `AsyncIterators.drain(...)` pumps with direct iteration over response collections.
   - preserve handler order and completion callback behavior, including fail-fast run lifecycle constraints and cancellation semantics.
  </action>
  <verify>
Run module build and targeted grep checks:

`cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine && build/build.sh`

`rg -n "nextAsync\(|AsyncIterators|AsyncIterator<" src/org/modelio/platform/query/internal src/org/modelio/platform/query/api/model/result || true`

Confirm no remaining response-consumer dependency on AsyncIterator in internal executor flow.
  </verify>
  <done>
- Executor returns `IQueryResponse` backed by collections
- Prepared async execution dispatches handlers from collections while preserving current lifecycle expectations
- QueryEngine behavior for diagnostics/state/truncation remains aligned with current contracts
  </done>
</task>

<task type="auto">
  <name>Task 3: Update executor tests to collection-based response assertions and run focused suites</name>
  <files>
    ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/StreamingQueryResponseTest.java
    ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/PreparedAsyncExecutionTest.java
    ../platform.search.engine.test/src/org/modelio/platform/query/engine/executor/QueryEngineExecutionTest.java
  </files>
  <action>
Migrate tests that currently pull with `nextAsync()` to direct list assertions.

- `StreamingQueryResponseTest`: replace pull loops with direct `items()`/`diagnostics()` collection assertions, while preserving checks for state/truncation/failure/cancel diagnostics.
- `PreparedAsyncExecutionTest`: keep lifecycle tests (`run` single-use, late handler registration failure, cancellation) and validate handlers receive collection elements in order.
- `QueryEngineExecutionTest`: replace helper drain methods with direct list assertions from `IQueryResponse`; preserve prepared async handler-flow coverage.

Keep scope limited to `platform.search.engine` and `platform.search.engine.test` only.
  </action>
  <verify>
Run targeted test classes:

`cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test && build/run-tests.sh -Dtest=StreamingQueryResponseTest,PreparedAsyncExecutionTest,QueryEngineExecutionTest`

Then run full test bundle sanity check:

`cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test && build/run-tests.sh`
  </verify>
  <done>
- All three executor-focused tests compile and pass using collection-based response API
- No `nextAsync()` usage remains in these response/executor tests
- Behavioral guarantees (ordering, state, diagnostics, cancellation) remain covered
  </done>
</task>

</tasks>

<verification>
- `IQueryResponse` exposes collection accessors only for items/diagnostics
- Internal executor path has no remaining AsyncIterator pull loops for response consumption
- Targeted + full `platform.search.engine.test` runs pass
</verification>

<success_criteria>
- Query response API is simplified to collection-based consumption
- AsyncIterator response API is removed from this workflow without regressions in executor behavior
- Existing sync/prepareAsync semantics remain validated by executor tests
</success_criteria>

<output>
After completion, create:
`.gsd/quick/004-simplify-query-response-remove-asynciter/004-SUMMARY.md`
</output>
