---
phase: quick-003
plan: 01
type: execute
wave: 1
depends_on: []
files_modified:
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/KindResolverTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/EdgeResolverTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverKindSmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverEdgeSmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverPropertyKeySmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
  - platform.search.engine.test/src/org/modelio/platform/query/engine/DiagnosticsSmokeTest.java
autonomous: true

must_haves:
  truths:
    - "Tests use real metamodel elements instead of mocks"
    - "Tests extend AbstractMqlTest for session and factory access"
    - "Tests run successfully with real CoreSession infrastructure"
  artifacts:
    - path: "platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java"
      provides: "PropertyKey resolver tests using real model"
      min_lines: 150
    - path: "platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/KindResolverTest.java"
      provides: "Kind resolver tests using real model"
      min_lines: 100
    - path: "platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/EdgeResolverTest.java"
      provides: "Edge resolver tests using real model"
      min_lines: 100
  key_links:
    - from: "Test classes"
      to: "AbstractMqlTest"
      via: "extends declaration"
      pattern: "extends AbstractMqlTest"
    - from: "Test classes"
      to: "TestModelFactory"
      via: "this.modelFactory usage"
      pattern: "this\\.modelFactory\\.(createElement|createMetaclass)"
---

<objective>
Refactor all resolver and smoke tests to use the new test utilities (AbstractMqlTest, TestSession, TestModelFactory) instead of mock/proxy objects.

Purpose: Improve test reliability and accuracy by testing against real metamodel and session infrastructure rather than hand-crafted mocks.

Output: All 8 test files updated to use real model elements and extend AbstractMqlTest.
</objective>

<execution_context>
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.github/skills/execute-plan/SKILL.md
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/templates/summary.md
</execution_context>

<context>
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/.gsd/STATE.md

# Test utilities provide real model infrastructure
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/testutils/AbstractMqlTest.java
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/testutils/TestSession.java
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/testutils/TestModelFactory.java

# Current tests using mocks/proxies
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/KindResolverTest.java
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/EdgeResolverTest.java
</context>

<tasks>

<task type="auto">
  <name>Refactor core resolver unit tests</name>
  <files>
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/KindResolverTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/EdgeResolverTest.java
  </files>
  <action>
For each test file (PropertyKeyResolverTest, KindResolverTest, EdgeResolverTest):

1. Make class extend AbstractMqlTest
2. Remove all Proxy.newProxyInstance() mock creation code
3. Replace custom StubResolverContext with actual session-based context:
   - For KindResolverTest and EdgeResolverTest: Create ResolverContext using real session metamodel and modules
   - For PropertyKeyResolverTest: Use session's registered metaclasses and modules
4. Use TestModelFactory to create real model elements:
   - Use modelFactory.createElement() for Package, Class, Interface, etc.
   - Use session.getMetamodel().getMClass() for MClass references
   - Use modelFactory helper methods for module components, stereotypes, tag types, note types
5. Update test setup to use setUpModel() if any test-wide model state needed
6. Remove proxy() helper methods and replace with real element creation
7. Keep test assertions unchanged - they validate behavior, not mocks

Example transformation pattern:
```java
// OLD:
private static MClass mClass(String name) {
    return (MClass) Proxy.newProxyInstance(...);
}

// NEW:
@Override
protected void setUpModel() {
    // Create real model elements needed for tests
}

// In test method:
MClass mc = this.session.getMetamodel().getMClass("Standard.Class");
```
  </action>
  <verify>
Run tests: `platform.search.engine.test/build/run-tests.sh -Dtest=PropertyKeyResolverTest,KindResolverTest,EdgeResolverTest`

Check:
- All three test files compile without errors
- All test methods pass
- No Proxy.newProxyInstance() calls remain in these files
- Tests extend AbstractMqlTest
  </verify>
  <done>
- PropertyKeyResolverTest, KindResolverTest, and EdgeResolverTest extend AbstractMqlTest
- All proxy/mock creation code removed
- Tests use real metamodel elements via session and TestModelFactory
- All tests pass successfully
  </done>
</task>

<task type="auto">
  <name>Refactor smoke tests</name>
  <files>
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverKindSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverEdgeSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverPropertyKeySmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/DiagnosticsSmokeTest.java
  </files>
  <action>
For each smoke test file:

1. Make class extend AbstractMqlTest
2. Remove any mock/proxy object creation
3. Replace with real model element creation using TestModelFactory
4. Update ResolverContext instantiation to use real session metamodel
5. If tests create test data, move to setUpModel() or use helper methods
6. Leverage inherited session, modelFactory, and transaction from AbstractMqlTest
7. Keep smoke test assertions unchanged

Smoke tests are higher-level integration tests that verify resolver chains work end-to-end. Ensure:
- QueryResolverKindSmokeTest tests complete kind resolution with real metaclasses
- QueryResolverEdgeSmokeTest tests complete edge resolution with real dependencies
- QueryResolverPropertyKeySmokeTest tests complete property key resolution with real attributes
- ResolvedModelSmokeTest tests full resolved query model with real elements
- DiagnosticsSmokeTest tests diagnostic emission with real model scenarios
  </action>
  <verify>
Run tests: `platform.search.engine.test/build/run-tests.sh -Dtest=QueryResolverKindSmokeTest,QueryResolverEdgeSmokeTest,QueryResolverPropertyKeySmokeTest,ResolvedModelSmokeTest,DiagnosticsSmokeTest`

Check:
- All five test files compile without errors
- All smoke tests pass
- No mock/proxy creation code remains
- Tests extend AbstractMqlTest and use real model infrastructure
  </verify>
  <done>
- All five smoke test files extend AbstractMqlTest
- Mock/proxy code removed and replaced with real model element creation
- Tests use real CoreSession, metamodel, and TestModelFactory
- All smoke tests pass successfully
  </done>
</task>

<task type="auto">
  <name>Run full test suite and clean up imports</name>
  <files>
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/PropertyKeyResolverTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/KindResolverTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/EdgeResolverTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverKindSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverEdgeSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/resolver/QueryResolverPropertyKeySmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/ResolvedModelSmokeTest.java
    platform.search.engine.test/src/org/modelio/platform/query/engine/DiagnosticsSmokeTest.java
  </files>
  <action>
1. Clean up imports in all 8 test files:
   - Remove unused `java.lang.reflect.Proxy` imports
   - Remove unused `BasicEList`, `EList` imports if no longer needed
   - Add `org.modelio.platform.query.testutils.AbstractMqlTest` import
   - Ensure all metamodel element imports are correct (org.modelio.metamodel.*)

2. Run full test suite to verify no regressions:
   `platform.search.engine.test/build/run-tests.sh`

3. If any tests fail, investigate and fix:
   - Check that real model elements have required properties set
   - Verify ResolverContext is properly constructed with session data
   - Ensure test assertions match real metamodel behavior (not mock behavior)

4. Document any behavioral differences discovered between mocks and real model in test comments
  </action>
  <verify>
Run full test suite: `platform.search.engine.test/build/run-tests.sh`

Check:
- All tests in the modified files pass
- No compilation warnings about unused imports
- No Proxy imports remain in the 8 modified files
- Test output shows tests using real CoreSession (check logs for session initialization)
  </verify>
  <done>
- All 8 test files have clean imports
- Full test suite passes with all modified tests using real model infrastructure
- No Proxy.newProxyInstance() usage remains
- Tests use AbstractMqlTest, TestSession, and TestModelFactory exclusively
  </done>
</task>

</tasks>

<verification>
Final checks:
1. All 8 test files extend AbstractMqlTest
2. No Proxy.newProxyInstance() calls in any of the 8 files
3. All tests use real metamodel elements via session.getMetamodel() and modelFactory
4. Full test suite passes: `platform.search.engine.test/build/run-tests.sh`
5. Grep confirms no mocks: `grep -r "Proxy\.newProxyInstance" src/org/modelio/platform/query/engine/` returns no results
</verification>

<success_criteria>
- All 8 test files successfully refactored to use AbstractMqlTest
- All tests pass with real CoreSession and metamodel infrastructure
- No mock/proxy object creation code remains in resolver or engine tests
- Code is cleaner and more maintainable using shared test utilities
- Tests are more reliable by validating against actual metamodel behavior
</success_criteria>

<output>
After completion, run:
```bash
git add platform.search.engine.test/src/org/modelio/platform/query/engine/
git commit -m "test(quick-003): refactor resolver and engine tests to use real metamodel

- Extend AbstractMqlTest in all 8 test files
- Replace Proxy mocks with real model elements via TestModelFactory
- Use real CoreSession and metamodel for all tests
- Remove custom stub contexts in favor of session-based contexts
- All tests pass with improved reliability
"
```
</output>
