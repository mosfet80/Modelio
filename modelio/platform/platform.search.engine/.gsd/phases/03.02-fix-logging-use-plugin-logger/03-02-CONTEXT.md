# Phase 3.02: Fix Logging to Use PluginLogger - Context

**Gathered:** 2026-02-19  
**Status:** Ready for planning

## Phase Boundary

Replace ad-hoc `System.Logger` usage in the executor path with centralized `org.modelio.platform.search.engine.plugin.SearchEngine.LOG` using `PluginLogger`. No behavior change; this is **technical API migration only**.

## Implementation Decisions

### Scope: API Migration Only

- **What this IS:** Replace `System.Logger` calls with `SearchEngine.LOG` in executor code.
- **What this is NOT:** Changing what gets logged, log levels, visibility, or behavior.
- **Constraint:** All existing logging statements remain; only the API/destination changes.

### Logger Source

- Use the centralized `SearchEngine.LOG` instance from `org.modelio.platform.search.engine.plugin.SearchEngine`.
- Logger must use `PluginLogger` (or equivalent bundle-aware logger) — not raw `System.Logger`.

### Coverage

- All executor classes that currently use `System.Logger` → migrate to `SearchEngine.LOG`.
- Maintain existing log levels (debug, trace, warning, error) — no changes to verbosity.
- No new logging is added in this phase.

## Copilot's Discretion

- Exact code locations where `System.Logger` is replaced (researcher will identify all occurrences).
- Testing strategy to verify replacement is complete and correct.
- How to ensure SearchEngine.LOG is initialized before executor runs.

---

**Next steps:** Run discovery to map all current logging calls, then create plan to migrate systematically.
