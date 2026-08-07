# Modelio MQL Resolution & Execution Engine

## What This Is

This project implements the MQL v1 runtime inside the existing `org.modelio.platform.search.engine` OSGi bundle: an internal resolved query model, a resolver that converts the public "unresolved" query AST into the resolved model with explicit ambiguity unions, and a bounded streaming execution engine that runs resolved queries against a live Modelio model. The engine ships with per-step diagnostic attribution, real-time validation feedback in the MQL graphical editor, a comprehensive acceptance test suite (Q1–Q15), and full i18n support for all diagnostic messages.

As of v1.0, the engine produces explainable, deduplicated results with budget enforcement (limit/timeout/maxDepth), and all 15 v1 requirements have been validated.

## Core Value

Execute MQL queries with bounded, deterministic traversal and **complete explainability** (all explanation paths per result).

## Current Milestone: v1.1 Urgent fixes and evolutions

**Goal:** Enhance result explainability by returning all explanation paths per result (not just the first), with minor fixes as needed.

**Target features:**
- Return complete explanation paths (all `why` paths) per result item
- Maintain performance and budget constraints during path enumeration
- Optional: Quick maintenance fixes (tech debt)

## Requirements

### Validated

- ✓ Public MQL AST exists (`org.modelio.platform.query.api.model.query`) — existing
- ✓ Frozen/wire query model exists (`org.modelio.platform.query.api.model.frozen`) — existing
- ✓ Result DTOs exist (`org.modelio.platform.query.api.model.result`) — existing
- ✓ Streaming response API exists (`IQueryResponse`) — existing
- ✓ Jackson helpers exist for query/result models and `MObject` refs — existing
- ✓ Internal resolved query model exists (`...engine.resolved`) — v1.0
- ✓ Resolver: unresolved query AST → resolved model with explicit ambiguity unions — v1.0
- ✓ Execution engine: resolved model → `IQueryResponse` — v1.0
- ✓ Ambiguity resolution: UNION in resolved model when name maps to multiple definitions, with diagnostics — v1.0
- ✓ Traversal semantics (filter/traverse/union/repeat) with budgets and cycle-safety — v1.0
- ✓ Results streamed internally; path explanations (`why`) per result item — v1.0
- ✓ Acceptance set Q1–Q15 covered by automated tests (Q2+Q13 @Disabled, documented) — v1.0
- ✓ Per-step diagnostic attribution + real-time MQL editor validation (Phase 8) — v1.0
- ✓ Full i18n for all diagnostic messages (SearchEngineI18N.msg()) — v1.0

### Active

- [ ] Complete explanation paths: collect all `why` paths per result, not just the first (v1.1)
- [ ] Bounded enumeration: ensure path collection respects budget constraints (v1.1)
- [ ] Optional quick fixes: tech debt, deferred issues as time permits (v1.1)

### Out of Scope

| Feature | Reason |
| --- | --- |
| Textual grammar + parser | Spec explicitly scopes v1 to AST-driven execution; v2 scope |
| Reactive streaming libraries | Use in-house API |
| Editing `core.query/.../model/runtime` backup prototype | Read-only inspiration; avoid divergence |
| Cursor pagination | Not a v1 requirement |

## Context

Shipped v1.0 with 34 plans across 15 phases (including 7 inserted decimal phases for urgent fixes).

- Platform: `org.modelio.platform.search.engine` (OSGi bundle, Java 17)
- Test module: `org.modelio.platform.search.engine.test` (Tycho fragment)
- UI: `org.modelio.app.model.search.ui` (MQL editor, GEF canvas)
- Test count: 122+ passing tests (0 failures, 2 intentional @Disabled)
- Git commits: 214 in main bundle repo
- Timeline: 2026-02-05 → 2026-02-26 (21 days)

Tech debt to watch:
- Q2 (stereotype filter) @Disabled — stereotype registry unavailable in MofMetamodel test sessions
- SearchEngine.I18N static field null risk if bundle starts before BundleActivator.start() completes
- MqlEditorDialog creates QueryEngine twice (resolver + future executor) — refactor in Phase 9

## Key Decisions

| Decision | Outcome |
| -------- | ------- |
| Implement in `org.modelio.platform.search.engine` internal packages | ✓ Good — avoided bundle churn, kept execution close to DTOs |
| Use `AsyncIterator<NodeWithExplainOut>` as primary output | ✓ Simplified to materialized collections on `IQueryResponse` after quick task #004 — cleaner public API |
| Resolver uses explicit UNION nodes to represent ambiguity | ✓ Good — matches spec, produces clear diagnostics listing alternatives |
| Dedup at pipeline terminal (LinkedHashSet) not per-union | ✓ Good — single bounded memory allocation, correct semantics |
| Unknown Step/Expr subtypes throw UnsupportedOperationException | ✓ Good — loudly surfaces resolver gaps |
| Use instanceof dispatch for expr resolution | ✓ Good — Java 17 compatible, explicit |
| Dynamic subtype discovery in resolver coverage tests | ✓ Good — tests self-update when new subtypes added |
| Single async pull contract `nextAsync()` for AsyncIterator | ✓ Good — reduced API ambiguity, strict lifecycle |
| `IQueryEngine` exposes `syncExec`/`prepareAsync`, no longer `execute(Query)` | ✓ Good — explicit sync vs async separation |
| Push-based Consumer<NodeWithExplainOut> chain eliminates intermediate List buffering | ✓ Good — true streaming, bounded memory for massive queries |
| EXECUTION_TRUNCATED replaces LIMIT_REACHED/TIMEOUT_REACHED | ✓ Good — subsumes both; old codes kept for backwards compat |
| Budget counts post-dedup unique items | ✓ Good — consistent with logical result semantics |
| Centralized `SearchEngine.LOG` (PluginLogger) for all logging | ✓ Good — bundle-aware, respects OSGi config |
| 19 MQL i18n keys via `SearchEngineI18N.msg()` with null-safe fallback | ✓ Good — Modelio convention; null-safe for test contexts |
| Per-step `StepResolutionResult`/`SourceResolutionResult` from resolver | ✓ Good — enables GEF figure decoration without coupling resolver to UI |
| Cycle detection via path check (not globalVisited) | ✓ Good — distinguishes proper cycles from convergence; CYCLE_DETECTED is WARNING |
| ProvidedSource elements supplied via engine supplier | ✓ Good — consistent with current selection at query time |
| Timeout checked first in tryAccept() | ✓ Good — deterministic: timeout takes precedence over limit |
| Stop downstream when resolved==null only | ✓ Good — backward-compatible with coverage test's UnknownEdge traverse |
| Execute button gated on ERROR diagnostics in MqlEditorDialog | ✓ Good — prevents invalid query execution, validated live |
| synchronous resolve() before GEF asyncExec(setContents) | ✓ Good — no race on lastResult population |

## Constraints

- **Code location**: Internal (non-exported) packages in `org.modelio.platform.search.engine`
- **API**: Public API changes kept minimal; resolved model/resolver/executor remain internal
- **Runtime**: Java 17 per bundle declaration
- **OSGi**: Respect exports; JSON compatibility preserved for existing query/result DTOs
- **Logging**: All log statements use `SearchEngine.LOG` (PluginLogger)
- **I18n**: All diagnostic strings via `SearchEngineI18N.msg()` with null-safe fallback

---

_Last updated: 2026-05-18 — Starting v1.1 milestone_
