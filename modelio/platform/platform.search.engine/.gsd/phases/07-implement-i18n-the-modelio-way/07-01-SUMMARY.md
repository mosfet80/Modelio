---
phase: 07-implement-i18n-the-modelio-way
plan: 01
subsystem: i18n-infrastructure
tags: [i18n, properties, build, osgi, tycho]

dependency-graph:
  requires: [06-acceptance-suite-q1-q15]
  provides: [i18n-properties-files, SearchEngineI18N-helper, bundle-aware-logger]
  affects: [07-02-string-migration]

tech-stack:
  added: []
  patterns: [null-safe-i18n-fallback, MessageFormat-quoting]

key-files:
  created:
    - res/modelsearch.properties
    - res/modelsearch_fr.properties
    - src/org/modelio/platform/query/internal/SearchEngineI18N.java
  modified:
    - build.properties
    - src/org/modelio/platform/search/engine/plugin/SearchEngine.java

decisions:
  - "res/ added to both source.. and bin.includes in build.properties so Tycho packages properties into JAR"
  - "SearchEngineI18N falls back to raw key (no args) or MessageFormat.format (with args) when SearchEngine.I18N is null — safe in unit-test context"
  - "SearchEngine.LOG now uses bundle-aware getLogger(bundle, PLUGIN_ID) form instead of deprecated getLogger((String)null)"

metrics:
  duration: ~5min
  completed: 2026-02-24
---

# Phase 07 Plan 01: I18n Infrastructure Summary

**One-liner:** I18n properties files (14 keys), build.properties classpath wiring, bundle-aware PluginLogger, and null-safe SearchEngineI18N helper.

## What Was Done

### Task 1 — Create res/modelsearch.properties and res/modelsearch_fr.properties

Created the `res/` directory at the bundle root and two identical properties files with 14 message keys covering:
- KindResolver (3 keys: blank, unknown, ambiguous)
- EdgeResolver (3 keys: blank, unknown, ambiguous)
- PropertyKeyResolver (3 keys: blank, unknown, ambiguous)
- QueryResolver (1 key: unsupported source type)
- SourceEvaluator (1 key: skipped elements)
- ExecutionBudget (2 keys: timeout, limit)
- StepPipelineExecutor / RepeatStepExecutor (2 keys: pipeline truncation, cycle detection)

All MessageFormat arguments use doubled single-quote escaping (`''`).

### Task 2 — Update build.properties

Added `res/` to both `source..` and `bin.includes` so Tycho:
1. Puts properties files on the bundle classpath during compilation
2. Packages the `res/` folder into the final bundle JAR

### Task 3a — Fix SearchEngine.start() LOG constructor

Changed the deprecated `service.getLogger((String)null)` call to the bundle-aware form `service.getLogger(bundleContext.getBundle(), PLUGIN_ID)`. This associates log output with the correct bundle in Equinox.

### Task 3b — Create SearchEngineI18N.java

New utility class `org.modelio.platform.query.internal.SearchEngineI18N` with a single static method `msg(String key, Object... args)`:
- When `SearchEngine.I18N` is non-null (OSGi context): delegates to `BundledMessages.getMessage()`
- When `SearchEngine.I18N` is null (unit-test context): returns the raw key (no args) or `MessageFormat.format(key, args)` (with args)

## Verification

Build passed with exit code 0. No compilation errors.

## Commits

| Hash | Message |
|------|---------|
| c6e8a46 | feat(07-01): create i18n properties files (EN + FR) |
| d2b844d | chore(07-01): add res/ to build.properties source and bin.includes |
| 4339933 | fix(07-01): use bundle-aware PluginLogger in SearchEngine.start() |
| 621794c | feat(07-01): add SearchEngineI18N null-safe I18n helper |

## Deviations from Plan

None — plan executed exactly as written.

## Next Phase Readiness

Plan 07-02 (string migration) can proceed: `SearchEngineI18N.msg()` is available, all 14 keys are defined in `res/modelsearch.properties`.
