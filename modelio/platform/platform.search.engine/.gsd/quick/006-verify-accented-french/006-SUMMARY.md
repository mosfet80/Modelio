---
phase: quick-006
task: verify-accented-french
name: "Verify Accented French Properties Load Correctly"
completed: 2026-02-25
subsystem: i18n-infrastructure
type: verification
---

# Quick Task 006: Verify Accented French Properties Load Correctly

## Objective

Verify that accented French characters in `modelsearch_fr.properties` are correctly loaded by `SearchEngine.I18N.getMessage()` without mojibake or character corruption.

## Completed

**Date:** 2026-02-25

### Implementation Summary

Created `FrenchAccentsLoadingTest` class in `platform.search.engine.test` module:

- **Location:** `src/org/modelio/platform/query/i18n/FrenchAccentsLoadingTest.java`
- **Framework:** JUnit 5 + AssertJ
- **Base Class:** AbstractMqlTest

### Test Coverage

**Single test method:** `testFrenchPropertiesMatchI18N()`

For each key in `modelsearch_fr.properties`:
1. Loads the raw property value via Java Properties with UTF-8 encoding
2. Gets the value via `SearchEngine.I18N.getMessage(key)`
3. Applies `MessageFormat` to the raw property to get expected value (accounts for `''` escape processing in BundledMessages)
4. Asserts loaded value matches MessageFormat-processed expected value
5. Verifies no replacement character (U+FFFD - mojibake indicator) appears

### Result

✅ **PASS** - All French properties load correctly with accents preserved

**Representative accented strings verified:**
- "Clé de propriété ambiguë" - é, û
- "élément(s) invalide(s)/supprimé(s)" - é, ù
- "détecté lors de la traversée répétée" - é
- "nœud" - û
- "étape" - é
- "résolu" - é

### Key Finding

`BundledMessages` uses `MessageFormat` which processes escape sequences:
- Raw properties file: `''{0}''` (double quotes around placeholder)
- Processed output: `'{0}'` (single quotes - the double quotes are escaped in MessageFormat)
- This is correct behavior and properly evidenced in test assertions

### Files Modified

1. `platform.search.engine.test/src/org/modelio/platform/query/i18n/FrenchAccentsLoadingTest.java` (new)

### Commit

**Hash:** b82de7d
**Message:** `test(quick-006): verify accented French properties load correctly in SearchEngine.I18N`

### Verification Checklist

- [x] Test compiles without errors
- [x] All 1 test passes
- [x] UTF-8 encoding preserved for all accented characters
- [x] No character corruption (mojibake)
- [x] MessageFormat escape sequences handled correctly
- [x] Code committed to git

---

## Conclusion

Quick task 006 is **COMPLETE**. French localization infrastructure confirmed to handle UTF-8 encoding correctly with no data corruption. SearchEngine.I18N can safely be used throughout the codebase for multilingual message delivery.
