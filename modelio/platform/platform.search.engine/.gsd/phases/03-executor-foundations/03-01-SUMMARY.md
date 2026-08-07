---
phase: 03-executor-foundations
plan: 01
status: complete
completed: 2026-02-18
---

# Summary: 03-01 — Executor Foundations Streaming Plumbing

## Goal

Create the streaming response plumbing that all MQL query execution will use: `DiagnosticCode` enum, `selectionProvider` broadening, `BufferedAsyncIterator`, `EmptyAsyncIterator`, and `StreamingQueryResponse`.

## What Was Accomplished

All tasks from the plan were implemented and all tests pass (42/42 tests green).

### Task 1: DiagnosticCode enum + Diagnostic record update + selectionProvider API change

**Commit:** `d2d41ea`

- Created `DiagnosticCode` enum with 16 codes covering resolution and execution phases:
  - Resolution codes: `UNKNOWN_KIND`, `AMBIGUOUS_KIND`, `UNKNOWN_EDGE`, `AMBIGUOUS_EDGE`, `UNKNOWN_PROPERTY`, `AMBIGUOUS_PROPERTY`, `UNSUPPORTED_STEP`, `UNSUPPORTED_EXPR`, `UNSUPPORTED_SOURCE`
  - Execution codes: `INTERRUPTED`, `INVALID_ELEMENT_SKIPPED`, `EMPTY_PROVIDED_SOURCE`, `RESOLUTION_ERROR`, `RUNTIME_ERROR`, `LIMIT_REACHED`, `TIMEOUT_REACHED`
- Updated `Diagnostic` record: added `DiagnosticCode code` as the first record component.
- Updated `Diagnostics` factory: all factory methods (`info`, `warning`, `error`, `of`) now require `DiagnosticCode` as first parameter.
- Updated all 10 resolver callers with appropriate codes (EdgeResolver, KindResolver, PropertyKeyResolver, QueryResolver).
- Changed `selectionProvider` type from `Supplier<MObject>` to `Supplier<Iterable<MObject>>` in `QueryEngine` and `Queries`.
- Updated `DiagnosticsSmokeTest` to include `DiagnosticCode` in all calls.

### Task 2: AsyncIterator implementations + StreamingQueryResponse + tests

**Commit:** `f1ebf1b`

- Created `BufferedAsyncIterator<T>`: thread-safe `AsyncIterator` backed by `LinkedBlockingQueue` with FIFO ordering, `push()`, `complete()`, `dispose()`, and async `onNext()` via `CompletableFuture`.
- Created `EmptyAsyncIterator<T>`: trivial no-element implementation with generic singleton pattern.
- Created `StreamingQueryResponse`: `IQueryResponse` with background daemon producer thread, independent items/diagnostics streams, resolution diagnostics pre-loaded upfront, dispose/truncation/error handling.
- Added `@JsonCreator static fromJson()` to `FrozenProvidedSource` to fix Jackson deserialization when `elements` are absent from JSON.
- Created `BufferedAsyncIteratorTest` (6 concurrency tests, all passing).
- Created `StreamingQueryResponseTest` (5 tests covering empty, streaming, dispose, runtime error, resolution diagnostics ordering).

### Bug Fixes

- **BufferedAsyncIterator race condition**: Removed `drainToPending()` calls from `push()` and `complete()`. The dual-path approach (pending future completion + supplyAsync take()) caused items to be lost when `complete()` added a POISON while a put-back was in-flight. Now the `supplyAsync` blocking `take()` is the sole consumer path, eliminating the race.
- **FrozenProvidedSource Jackson deserialization**: Added `@JsonCreator static fromJson()` factory to allow deserialization without `elements` in JSON (elements are transient). Removed the conflicting `@JsonProperty(required=true)` annotation.

## Key Design Decisions

| Decision | Rationale |
|----------|-----------|
| Sole consumer path: supplyAsync take() only | Eliminates race between drainToPending() and take() wake-up |
| background daemon thread in StreamingQueryResponse | Enables cancellation checking at push site; simple threading model |
| Resolution diagnostics pre-loaded before thread starts | Guarantees diagnostics() delivers resolution info immediately, even before items |
| @JsonCreator fromJson() on FrozenProvidedSource | Records with @JsonIgnore components need a no-arg creator for deserialization |
| DiagnosticCode as enum (not String) | Structured, machine-readable codes for routing and testing |

## Test Coverage Added

- `BufferedAsyncIteratorTest`: 6 tests (FIFO order, async completion, dispose, hasNext behavior)
- `StreamingQueryResponseTest`: 5 tests (empty, streaming, dispose, runtime error, resolution diagnostics upfront)
- Total test suite: 42 tests, all green

## Files Modified/Created

**platform.search.engine:**
- `api/model/result/DiagnosticCode.java` (new)
- `api/model/result/Diagnostic.java` (modified: added code field)
- `api/model/frozen/FrozenProvidedSource.java` (modified: @JsonCreator added)
- `internal/resolver/diagnostics/Diagnostics.java` (modified: DiagnosticCode parameter)
- `internal/resolver/EdgeResolver.java` (modified)
- `internal/resolver/KindResolver.java` (modified)
- `internal/resolver/PropertyKeyResolver.java` (modified)
- `internal/resolver/QueryResolver.java` (modified)
- `internal/QueryEngine.java` (modified: selectionProvider type)
- `api/Queries.java` (modified: selectionProvider type)
- `internal/executor/BufferedAsyncIterator.java` (new)
- `internal/executor/EmptyAsyncIterator.java` (new)
- `internal/executor/StreamingQueryResponse.java` (new)

**platform.search.engine.test:**
- `engine/DiagnosticsSmokeTest.java` (modified: DiagnosticCode args)
- `engine/executor/BufferedAsyncIteratorTest.java` (new)
- `engine/executor/StreamingQueryResponseTest.java` (new)
