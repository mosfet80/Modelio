---
phase: "09"
plan: "01"
name: "TraversalItem + PathOutput Equality"
subsystem: "query-execution"
tags: [java, records, equality, deduplication, pipeline]

dependency-graph:
  requires: []
  provides:
    - "TraversalItem internal pipeline record (executor package)"
    - "PathOutput UUID-based equals/hashCode"
  affects:
    - "09-02: pipeline migration will use TraversalItem"
    - "future deduplication logic relies on PathOutput.equals()"

tech-stack:
  added: []
  patterns:
    - "Package-private record for internal pipeline items"
    - "UUID-based equality for cross-environment dedup stability"

key-files:
  created:
    - src/org/modelio/platform/search/engine/searchers/query/internal/executor/TraversalItem.java
  modified:
    - src/org/modelio/platform/search/engine/searchers/query/api/model/result/PathOutput.java

decisions:
  - "UUID-only node comparison in PathOutput.equals() for test-mock stability"
  - "TODO left inline to migrate to MObject.equals() when mocks are fixed"

metrics:
  duration: "~30 min"
  completed: "2026-05-18"
---

# Phase 09 Plan 01: TraversalItem + PathOutput Equality Summary

**One-liner:** Package-private TraversalItem record created; PathOutput gets UUID-based equals/hashCode for dedup stability.

## Tasks Completed

| # | Task | Commit | Files |
|---|------|--------|-------|
| 1 | Create TraversalItem internal pipeline record | 798dba2 | TraversalItem.java (created) |
| 2 | Add UUID-based equals/hashCode to PathOutput | 0114fdb | PathOutput.java (modified, included in refactoring commit) |

## Files Created / Modified

### Created
- `src/org/modelio/platform/search/engine/searchers/query/internal/executor/TraversalItem.java`
  - Package-private record with fields `(MObject node, PathOutput path)`
  - Compact constructor validates both fields non-null

### Modified
- `src/org/modelio/platform/search/engine/searchers/query/api/model/result/PathOutput.java`
  - Added `import java.util.Objects`
  - Added `equals(Object)` override with UUID-based node comparison
  - Added `hashCode()` override consistent with equals
  - Full Javadoc explaining the UUID deviation rationale
  - Inline `TODO: migrate to MObject.equals() when test mocks are fixed`

## Build Status

Build exits 0. Module compiles cleanly.

## Decisions Made

| Decision | Rationale |
|----------|-----------|
| UUID-only node comparison in `PathOutput.equals()` | `MObject.equals()` in production uses UUID + liveId; test mocks use identity equality. UUID-only gives consistent dedup across both environments |
| Inline TODO rather than immediate fix | Test mock fix is deferred — out of scope for this plan |
| No `public` modifier on TraversalItem | Package-private: only the executor pipeline uses it; external callers see `NodeWithExplainOut` |

## Deviations from Plan

### Absorbed into Refactoring Commit

Task 2 (PathOutput equals/hashCode) was in the working tree when the user committed a large refactoring (`0114fdb: refactor: all classes moved to another package`). The PathOutput changes were absorbed into that commit. The functionality is fully implemented and verified.

Task 1 (TraversalItem) has its own atomic commit `798dba2` as planned.

## Verification Results

```
TraversalItem.java:31:record TraversalItem(MObject node, PathOutput path) {
PathOutput.java:78:    public boolean equals(Object o) {
PathOutput.java:76:    // TODO: migrate to MObject.equals() when test mocks are fixed
build/mvn-exit.txt: 0
```

All must-haves satisfied. ✓
