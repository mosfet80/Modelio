---
phase: quick-006
plan: verify-accented-french
type: execute
wave: 1
depends_on: []
files_modified:
  - platform.search.engine.test/src/org/modelio/platform/query/i18n/FrenchAccentsLoadingTest.java
autonomous: true
---

<objective>
Verify that accented French characters in modelsearch_fr.properties are correctly loaded by SearchEngine.I18N.getMessage()

Purpose: Ensure java.util.Properties handles UTF-8 encoding properly for all French strings
Output: Automated test comparing loaded values with UTF-8 file content
</objective>

<execution_context>
This is a quick verification task in ~30% context.
Test module: platform.search.engine.test
</execution_context>

<context>
**Properties file under test:**
@/work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/res/modelsearch_fr.properties

**I18N helper (SearchEngine.java):**
- Method: `SearchEngine.I18N.getMessage(String key)`
- Backed by: `BundledMessages` + `ResourceBundle.getBundle("modelsearch")`
- ResourceBundle loads `modelsearch_fr.properties` for French locale

**Test base class:** AbstractMqlTest (JUnit 5)
</context>

<tasks>

<task type="auto">
  <name>Create FrenchAccentsLoadingTest</name>
  <files>
    platform.search.engine.test/src/org/modelio/platform/query/i18n/FrenchAccentsLoadingTest.java
  </files>
  <action>
Create a JUnit 5 test class extending AbstractMqlTest that:

1. Loads `ResourceBundle.getBundle("modelsearch", Locale.FRENCH)` directly (or use Locale.setDefault if needed for SearchEngine.I18N)
2. For each key in modelsearch_fr.properties, assert that:
   - `SearchEngine.I18N.getMessage(key)` returns non-null
   - Matches expected value from properties file
3. Specifically test keys containing accented characters:
   - "MQL.resolver.kind.ambiguous" (contains "résolu")
   - "MQL.resolver.edge.unknown" (contains "Relation")
   - "MQL.resolver.property.unknown" (contains "Clé")
   - "MQL.executor.element.skipped" (contains "élément(s)")
   - "MQL.executor.cycle.detected" (contains "nœud")
4. Compare loaded value character-by-character to ensure UTF-8 accents preserved
5. Use assertion: `assertEquals(expectedWithAccents, loadedViaI18N)`

Implementation note:
- Create modelsearch_fr.properties reader helper to load expected values
- Use Files.readAllLines(path, StandardCharsets.UTF_8) to parse *.properties
- Parse key=value pairs manually or use Properties.load(Reader) with InputStreamReader(UTF8)
  </action>
  <verify>
`mvn -Dtest=FrenchAccentsLoadingTest -f platform.search.engine.test/build/pom.xml test`

Output should show:
- All keys loaded successfully
- No character corruption (é remains é, ç remains ç)
- All assertions pass
  </verify>
  <done>
Test confirms SearchEngine.I18N.getMessage() returns correctly-encoded French strings with accents intact
  </done>
</task>

</tasks>

<verification>
After test passes:
1. Accented characters are preserved through ResourceBundle loading
2. No mojibake or character replacement
3. SearchEngine.I18N properly delegates to BundledMessages + ResourceBundle
</verification>

<success_criteria>
- FrenchAccentsLoadingTest runs without errors
- All accented French strings match expected UTF-8 values
- Test passes in platform.search.engine.test Maven build
</success_criteria>

<output>
Test path: `platform.search.engine.test/src/org/modelio/platform/query/i18n/FrenchAccentsLoadingTest.java`

No SUMMARY needed for quick tasks.
</output>
