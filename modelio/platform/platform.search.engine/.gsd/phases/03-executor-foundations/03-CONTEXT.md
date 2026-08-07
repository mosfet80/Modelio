# Phase 3: Executor Foundations (Streaming Response) - Context

**Gathered:** 2026-02-18
**Status:** Ready for planning

<domain>
## Phase Boundary

Build the streaming execution scaffold around `AsyncIterator` and `IQueryResponse`. The executor must be able to run a resolved query with a `provided` or `all` source and no steps, returning a streaming response with diagnostics. This phase delivers the plumbing (EXE-02, EXE-04), not the step semantics (Phase 4+).

</domain>

<decisions>
## Implementation Decisions

### Cancellation & Dispose Behavior

- **Best-effort stop**: When `dispose()` is called, signal stop; the current item in production may finish, but no new items are emitted after that.
- **Pending futures**: Outstanding `CompletableFuture` from `onNext()` completes with `null` (consistent with normal end-of-stream).
- **Interruption diagnostic**: When disposed mid-stream, a `Diagnostic` must be added to the `diagnostics()` stream stating the process was interrupted.
- **One-shot response**: Once disposed, the response is dead — consumers must create a new one to re-run.
- **Threading model**: Likely a background producer thread pushing into a buffer, with `next()`/`onNext()` draining from it. The push operation can check for interruption. **This implementation choice should be validated during planning.**

### "All" Source Scope

- **Scope**: Entire session (all fragments), not just open/loaded ones.
- **Kind-filtered enumeration**: Resolve the kind first, then ask the session for elements of matching metaclasses. If the resolved kind is a Stereotype, navigate `Stereotype.getExtendedElement()` directly. For complex multi-alternative resolved kinds, make best-effort to be performant (complex case deserves more attention).
- **Ordering**: Session-natural order — no deterministic sort guarantee.
- **Lazy streaming**: Elements are produced lazily (not collected into a list). Known limitation: `Stereotype.getExtendedElement()` returns a fully populated `List` on first access — defer optimization post-v1.

### ProvidedSource Behavior

- **selectionProvider API change**: `QueryEngine`'s `Supplier<MObject> selectionProvider` must be changed to `Supplier<Iterable<MObject>>` (or equivalent) — the single-element API is a mistake.
- **No kind filtering on provided**: Provided elements are accepted as-is, even if the query specifies a kind constraint.
- **Empty provided = empty response + diagnostic**: If the provider returns an empty iterable, produce a valid response with zero items and a diagnostic explaining why.
- **Null provided = exception**: If the provider itself returns `null`, throw an exception (programming error).

### Error & Edge-Case Responses

- **Resolution errors stop execution**: If resolution produced error-level diagnostics, the executor refuses to run. If only warnings, execution proceeds normally.
- **Runtime errors (non-engine)**: Caught and reported as error diagnostics; execution stops gracefully. Items already streamed are kept.
- **Engine bugs propagate**: Errors that indicate programming bugs in the engine itself are not caught — they propagate as exceptions.
- **Partial results preserved**: If an error stops execution after some items were streamed, those items remain visible. `isTruncated()` becomes `true`.
- **Invalid/deleted elements**: Skipped during iteration, with a warning diagnostic emitted (aggregated by cause).
- **Empty legitimate results**: Normal response with zero items, `isTruncated()=false` — no special empty response type.

### Diagnostics Model & Delivery

- **Structured diagnostic codes**: Add a `DiagnosticCode` enum field to the existing `Diagnostic` record. The v1 API break is accepted.
- **Unified codes**: The enum covers both resolution-level and execution-level diagnostic codes.
- **Resolution diagnostics upfront**: Resolution diagnostics (from Phase 2) are available immediately when `diagnostics()` is first called, before any execution diagnostics.
- **Occurrence ordering**: All diagnostics are ordered by occurrence (first occurrence for aggregated ones).
- **Independent streams**: `diagnostics()` and `items()` are independent — consumer can poll diagnostics at any time, even before consuming items.
- **Diagnostics complete when items complete**: The diagnostics stream's `hasNext()` returns `false` only after the items stream is also complete.
- **Full async support**: Both `next()` and `onNext()` are supported on the diagnostics stream.
- **Reference resolution diagnostics**: The response references (not copies) the resolution result's diagnostics list at the start of the diagnostics stream.

### Diagnostics Aggregation & Caps

- **Deduplication by cause**: Similar diagnostics (e.g., many skipped invalid elements) are aggregated into a single diagnostic entry.
- **Elements field**: Aggregated diagnostics include the involved elements in the `elements` field (e.g., all invalid elements that were skipped).
- **Per-diagnostic element cap**: Hard cap of **500 elements** per diagnostic entry. If exceeded, a count field indicates the total.
- **Total diagnostics cap**: Fixed default cap per response (exact number TBD, e.g., 100). The last diagnostic is a summary when the cap is reached.
- **Severity priority**: When the cap is reached, errors are prioritized over warnings over info. However, errors can still be dropped if there are more errors than the cap allows.
- **English only**: Diagnostic messages are in English for v1. i18n is deferred.

### Internal Logging

- **Log tracing**: Use existing `Log` utility (`org.modelio.vbasic.log.Log`) for trace/debug-level internal logging, independently of the diagnostics stream.

</decisions>

<specifics>
## Specific Ideas

- The background-thread producer model enables cancellation checking at the push site — validate this architecture choice during planning.
- Stereotype-based "all" source enumeration is known to be eager due to `getExtendedElement()` API — acceptable for v1.
- The `DiagnosticCode` enum should be designed to be extensible as new step semantics are added in Phase 4+.
- When changing `selectionProvider` to `Iterable<MObject>`, check impact on `IQueryEngine` public API and `app.model.search.ui` consumers.

</specifics>

<deferred>
## Deferred Ideas

- **i18n for diagnostic messages** — use Modelio's `coreutils.properties` / i18n infrastructure (post-v1).
- **Optimize Stereotype.getExtendedElement() laziness** — the list is fully populated on first access; lazy iteration would improve performance on large models (post-v1).
- **Configurable diagnostics cap** — allow queries to set their own diagnostics limit via `LimitsSpec` (post-v1 if needed).

</deferred>

---

_Phase: 03-executor-foundations_
_Context gathered: 2026-02-18_
