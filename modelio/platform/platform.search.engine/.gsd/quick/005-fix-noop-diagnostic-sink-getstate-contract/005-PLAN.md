# Quick Task 005: Fix NOOP_DIAGNOSTIC_SINK.getState() contract violation

## Description

`StepPipelineExecutor.NOOP_DIAGNOSTIC_SINK.getState()` returns `new CompletableFuture<>()` on
every call, violating the `IQueryResponseFiller` contract: "must return the same instance".
This makes `isComplete()` always return `false` for the NOOP sink.

## Tasks

### Task 1 — Add regression test
Write `NoopDiagnosticSinkContractTest` in the test module to confirm the three contract violations:
- `getState()` returns a different instance each call
- `isComplete()` returns `false`
- The state future is not done

### Task 2 — Fix the bug
Extract a static constant `NOOP_STATE = CompletableFuture.completedFuture(QueryCompletionStatus.ENDED)`
and return it from `NOOP_DIAGNOSTIC_SINK.getState()`.

## Expected outcome

- Tests fail before the fix (bug confirmed)
- Tests pass after the fix
- Full suite still green (101/101)
