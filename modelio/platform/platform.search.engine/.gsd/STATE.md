# Project State

## Project Reference

See: .gsd/PROJECT.md (updated 2026-02-26)

**Core value:** Execute MQL queries with bounded, deterministic traversal and explainable results.
**Current focus:** v1.0 SHIPPED — Ready to plan Phase 9 (MQL Editor Query Execution)

## Current Position

Phase: 10 (Budget & Test Integration) of 10
Status: Phase 09.1 complete (all 2 plans done, 14/14 must-haves verified) → Phase 10 next
Next: Phase 10 — timeout-safe path enumeration + Q1-Q15 acceptance tests
Last activity: 2026-05-19 — Phase 09.1 complete (streaming refactor verified)

## Last Activity

Last session: 2026-05-19
Milestone v1.1 — Phase 09.1 complete (all 2 plans done, 14/14 verified).
Next: Phase 10 — Budget & Test Integration.

## Roadmap Evolution

**2026-05-19 — Phase 09.1 inserted after Phase 09 (URGENT)**

Code review of Phase 09 implementation (`StepPipelineExecutor`) revealed four critical issues:
1. Silent path drop: Only first path extracted from multi-path source items
2. Dedup logic pollution: `globalEmittedUuids` marked before actual emission
3. Stale Javadoc: Method references outdated
4. Architecture: Inappropriate batching in pipeline (should be response-layer concern)

Decision: Insert Phase 09.1 to refactor and correct these issues before proceeding to Phase 10.
- Phase 09: Concept & original implementation (COMPLETE)
- Phase 09.1: Code review-driven refactor (INSERTED, to be planned)
- Phase 10: Budget & Test Integration (follows after 09.1)

Review documents: [09-code-review-after-debug.md](.gsd/phases/09-multi-path-api-engine/09-code-review-after-debug.md), [09-refactoring-design.md](.gsd/phases/09-multi-path-api-engine/09-refactoring-design.md)


## Open Blockers / Concerns for Next Milestone

- Q2 (stereotype filter): @Disabled — stereotype registry unavailable in MofMetamodel test sessions
- Q13 (cursor pagination): @Disabled — cursor pagination not yet implemented
- PreparedAsyncExecution.run() is synchronous — SWT Job wrapper required before UI wiring
- SearchEngine.I18N null risk before BundleActivator.start() — no production guard
- MqlEditorDialog creates QueryEngine twice — refactor when wiring execution in Phase 9
- UI → query execution NOT wired: OpenMqlEditorHandler discards dialog return value (Phase 9 scope)

## Quick Tasks Completed

| #   | Description | Date | Commit | Directory |
| --- | ----------- | ---- | ------ | --------- |
| 001 | Modify query resolution so each resolved step carries output kinds via ResolvedKindRef | 2026-02-11 | 9807ced | [001-modify-query-resolution-so-each-resolved](./quick/001-modify-query-resolution-so-each-resolved/) |
| 002 | Change LiteralValueExpr.valueType to ValueType enum | 2026-02-13 | 71daa33, 91ac6da | [002-change-literalvalueexpr-valuetype-to-a-n](./quick/002-change-literalvalueexpr-valuetype-to-a-n/) |
| 003 | Rework automatic tests to use test utilities | 2026-02-16 | f79abfd, ec89c23 | [003-rework-automatic-tests-to-use-testutils](./quick/003-rework-automatic-tests-to-use-testutils/) |
| 004 | Simplify query response: remove AsyncIterator API and return collections for items/diagnostics | 2026-02-20 | 8a95b7a, d2cbde9 | [004-simplify-query-response-remove-asynciter](./quick/004-simplify-query-response-remove-asynciter/) |
| 005 | Fix NOOP_DIAGNOSTIC_SINK.getState() contract violation | 2026-02-24 | f0969f1, e427f1e | [005-fix-noop-diagnostic-sink-getstate-contract](./quick/005-fix-noop-diagnostic-sink-getstate-contract/) |
| 006 | Verify accented French properties load correctly in SearchEngine.I18N | 2026-02-25 | b82de7d | [006-verify-accented-french](./quick/006-verify-accented-french/) |

## Session Continuity

Last session: 2026-02-26
Milestone v1.0 complete. Next: `/gsd-new-milestone` to define Phase 9 requirements and roadmap.
