# 01-01 Summary — Resolved Model Skeleton

Date: 2026-02-06

## Outcome

Created the Phase 1 internal “resolved query model” skeleton in a non-exported package, with a minimal query/source/step pipeline shape suitable for later execution work.

## What shipped

- Internal package: `org.modelio.platform.query.engine.resolved` (not exported by the bundle)
- Core types:
  - `ResolvedQuery` — holds a resolved source, a step pipeline, and immutable limits (`FrozenLimitsSpec`)
  - `ResolvedSource` — sealed interface with `AllSource` and `ProvidedSource`
  - `ResolvedStep` — sealed interface with step category records (`FilterStep`, `TraverseStep`, `UnionStep`, `RepeatStep`) and a nested `ResolvedPipeline` for nested constructs
- Test guardrail:
  - `ResolvedModelSmokeTest` instantiates a minimal resolved query and asserts the resolved package is not listed in the host bundle `Export-Package` header.

## Verification

### Host bundle build (skip tests)

Executed:
- `cd platform.search.engine/build && ... && mvn -q -DskipTests=true install`

Result:
- `mvn-exit.txt` = `0`

### Test bundle (run smoke test)

Executed:
- `cd platform.search.engine.test/build && ... && mvn -q -DskipTests=false -Dtest='*ResolvedModelSmokeTest' verify`

Result:
- `mvn-exit.txt` = `0`
- `ResolvedModelSmokeTest`: 2 tests, 0 failures

## Notes

- While enabling the smoke test run, `JacksonSerializationTest` required a small update to match the current `MDependencyPathStepOutput(MClass, MDependency)` API so the test bundle compiles under Tycho.
- `META-INF/MANIFEST.MF` exports were not modified; the resolved model remains internal by construction.
