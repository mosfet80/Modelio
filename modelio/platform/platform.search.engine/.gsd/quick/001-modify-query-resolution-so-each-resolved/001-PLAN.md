---
type: quick
id: "001"
description: "Modify query resolution so each resolved step carries output kinds via ResolvedKindRef"
autonomous: true
files_modified:
  - platform.search.engine/src/org/modelio/platform/query/engine/resolved/ResolvedStep.java
  - platform.search.engine/src/org/modelio/platform/query/engine/resolver/QueryResolver.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverKindSmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverEdgeSmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
---

<objective>
Add explicit output kind tracking to resolved steps so each step carries a ResolvedKindRef that represents the pipeline output kind after the step.

Purpose: Prepare the resolved pipeline for deterministic type-aware execution.
Output: ResolvedStep records with output kind + resolver logic to populate them + updated smoke tests.
</objective>

<context>
@.gsd/STATE.md
@.gsd/phases/02-resolver/02-CONTEXT.md
@src/org/modelio/platform/query/engine/resolved/ResolvedStep.java
@src/org/modelio/platform/query/engine/resolver/QueryResolver.java
@src/org/modelio/platform/query/engine/resolved/ResolvedKindRef.java
@src/org/modelio/platform/query/engine/resolved/ResolvedEdgeRef.java
</context>

<tasks>

<task type="auto">
  <name>Task 1: Add output kinds to resolved steps and compute them during resolution</name>
  <files>
    platform.search.engine/src/org/modelio/platform/query/engine/resolved/ResolvedStep.java
    platform.search.engine/src/org/modelio/platform/query/engine/resolver/QueryResolver.java
  </files>
  <action>
    Extend ResolvedStep records to carry a non-null `ResolvedKindRef outputKind` (add field and validation) and keep the interface minimal.

    In QueryResolver, compute a step output kind as you resolve the pipeline:
    - Start with a current kind from the source: AllSource => its kind; ProvidedSource => ResolvedKindRef.empty().
    - FilterStep output kind = current kind (filters do not change kind set).
    - TraverseStep output kind = new ResolvedKindRef with alternatives derived from the resolved edge alternatives:
      - For DependencyEdge: add MetaclassKind for dependency target MClass.
      - For LinkObjectEdge: add MetaclassKind for linkMetaclass; if stereotype is non-null, add StereotypeKind for it.
      - If no alternatives, use ResolvedKindRef.empty().
    - UnsupportedStep output kind = current kind (preserve continuity).

    After computing, update current kind to each step output kind as you walk steps. Keep diagnostics unchanged.
  </action>
  <verify>
    Host bundle builds (`platform.search.engine/build` aggregator) with skipTests.
  </verify>
  <done>
    Each resolved step includes an explicit output kind, and QueryResolver populates it deterministically based on the source and resolved edge alternatives.
  </done>
</task>

<task type="auto">
  <name>Task 2: Update resolver smoke tests for output kind propagation</name>
  <files>
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverKindSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverEdgeSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
  </files>
  <action>
    Update existing tests to assert that resolved steps now expose `outputKind()` and that it is populated:
    - Filter step output kind matches the source kind alternatives.
    - Traverse step output kind includes target metaclass alternatives derived from dependency edges.
    - ResolvedModelSmokeTest should still instantiate ResolvedQuery with empty steps; no changes beyond compilation if needed.

    Keep tests lightweight and aligned with existing stub contexts (no real session needed).
  </action>
  <verify>
    Run test bundle aggregator for the resolver smoke tests:

    `cd platform.search.engine.test/build && rm -f mvn-build.log mvn-exit.txt && (source /work/modelio/alouette/toolkit/env_toolkit.sh && mvn -q -DskipTests=false -Dtest='*QueryResolver*SmokeTest,*ResolvedModelSmokeTest' verify |& tee mvn-build.log; echo $? > mvn-exit.txt)`

    Ensure exit code is 0:

    `cat platform.search.engine.test/build/mvn-exit.txt`
  </verify>
  <done>
    Smoke tests compile and confirm output kinds are present on resolved steps.
  </done>
</task>

</tasks>

<verification>
- ResolvedStep record constructors enforce non-null output kinds.
- QueryResolver produces output kinds for filter and traverse steps using ResolvedKindRef alternatives.
</verification>

<success_criteria>
- Every ResolvedStep instance created by QueryResolver carries a non-null ResolvedKindRef output kind.
- Resolver smoke tests pass and validate output kind propagation.
</success_criteria>

<output>
After completion, update .gsd/STATE.md if needed to reflect quick task completion.
</output>
