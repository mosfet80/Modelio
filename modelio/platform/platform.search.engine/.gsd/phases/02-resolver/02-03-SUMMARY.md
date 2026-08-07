---
phase: 02-resolver
plan: "03"
subsystem:
  api
tags: [resolver, property-keys, diagnostics, alternatives]

# Dependency graph
requires:
  - phase: 02-resolver
    provides: edge and kind resolution with diagnostics
provides:
  - property key registry for attributes, tags, notes, and typed property definitions
  - resolved property value expressions carrying ambiguity alternatives
  - resolver and smoke tests for property key wiring
affects: [executor, filter-semantics]

# Tech tracking
tech-stack:
  added: []
  patterns:
    - lazy, cached property key registry indices

key-files:
  created:
    - src/org/modelio/platform/query/engine/resolver/PropertyKeyRegistry.java
    - src/org/modelio/platform/query/engine/resolver/PropertyKeyResolver.java
    - src/org/modelio/platform/query/engine/resolved/expr/ResolvedCompareExpr.java
    - src/org/modelio/platform/query/engine/resolved/expr/ResolvedValueExpr.java
    - src/org/modelio/platform/query/engine/resolved/expr/ResolvedPropertyValueExpr.java
    - ../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java
    - ../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverPropertyKeySmokeTest.java
  modified:
    - src/org/modelio/platform/query/engine/resolved/ResolvedPropertyKeyRef.java
    - src/org/modelio/platform/query/engine/resolver/ResolverContext.java
    - src/org/modelio/platform/query/engine/resolver/DefaultResolverContext.java
    - src/org/modelio/platform/query/engine/resolver/QueryResolver.java
    - src/org/modelio/platform/query/engine/resolved/expr/ResolvedExpr.java

key-decisions:
  - "None - followed plan as specified"

patterns-established:
  - "Property key resolution keeps explicit alternatives and emits ambiguity diagnostics."
  - "Resolver indices are built lazily and cached to avoid repeated scans."

# Metrics
duration: 4m
completed: 2026-02-11
---

# Phase 2 Plan 03: Property Key Resolution Summary

**Property key resolution now emits explicit attribute/tag/note/property-definition alternatives and wires them into resolved value expressions with diagnostics.**

## Performance

- **Duration:** 4m 24s
- **Started:** 2026-02-11T17:39:35+01:00
- **Completed:** 2026-02-11T17:43:59+01:00
- **Tasks:** 5
- **Files modified:** 12

## Accomplishments

- Indexed attributes, tag types, note types, and property definitions into a cached property key registry.
- Resolved property key tokens into deterministic alternatives with ambiguity/unknown diagnostics.
- Added resolved compare/value expression support and tests that lock the new behavior.

## Task Commits

Each task was committed atomically:

1. **Task 1: Fix resolved model for PropertyDefinition to preserve owner identity** - `66d835d` (feat)
2. **Task 2: Add PropertyKeyRegistry that indexes attributes, tags, notes, and property definitions** - `4aa0130` (feat)
3. **Task 3: Implement PropertyKeyResolver and diagnostics** - `3a6f9f5` (feat)
4. **Task 4: Add resolved property expressions and wire QueryResolver** - `7829167` (feat)
5. **Task 5: Add unit tests for property-key resolution + query wiring** - `081ce62` (test, platform.search.engine.test)

**Plan metadata:** (this commit)

## Files Created/Modified

- src/org/modelio/platform/query/engine/resolver/PropertyKeyRegistry.java - Builds cached indices for property keys.
- src/org/modelio/platform/query/engine/resolver/PropertyKeyResolver.java - Resolves keys into explicit alternatives with diagnostics.
- src/org/modelio/platform/query/engine/resolved/expr/ResolvedCompareExpr.java - Carries resolved value expressions in comparisons.
- src/org/modelio/platform/query/engine/resolved/expr/ResolvedValueExpr.java - Base value expression type for resolved predicates.
- src/org/modelio/platform/query/engine/resolved/expr/ResolvedPropertyValueExpr.java - Represents resolved property lookups.
- ../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java - Exercises ambiguity, owner identity, and case rules.
- ../platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverPropertyKeySmokeTest.java - Wires property key resolution into query resolution.

## Decisions Made

None - followed plan as specified.

## Deviations from Plan

### Auto-fixed Issues

**1. [Rule 1 - Bug] Comparator mismatch in property definition sorting**

- **Found during:** Task 3 verification build
- **Issue:** Comparator attempted to sort candidates with a definition-only comparator, causing compilation failure.
- **Fix:** Updated comparator to sort by candidate definition name.
- **Files modified:** src/org/modelio/platform/query/engine/resolver/PropertyKeyResolver.java
- **Verification:** `mvn -q -DskipTests=true install` in platform.search.engine/build
- **Committed in:** bb2ec4f

---

**Total deviations:** 1 auto-fixed (Rule 1)
**Impact on plan:** Required for build correctness; no scope change.

## Issues Encountered

- Tycho build failed on an invalid comparator signature; resolved by aligning the comparator with candidate definitions.

## User Setup Required

None - no external service configuration required.

## Next Phase Readiness

- Property key resolution is explicit and diagnosable; ready for Phase 3 executor scaffolding.
- No blockers identified.

---

_Phase: 02-resolver_
_Completed: 2026-02-11_
