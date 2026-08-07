---
quick_task: 002
type: refactoring
files_modified:
  - src/org/modelio/platform/query/api/model/query/ValueType.java
  - src/org/modelio/platform/query/api/model/query/LiteralValueExpr.java
  - src/org/modelio/platform/query/api/model/frozen/FrozenLiteralValueExpr.java
  - src/org/modelio/platform/query/engine/resolved/expr/ResolvedValueExpr.java
  - src/org/modelio/platform/query/engine/resolver/QueryResolver.java
  - src/org/modelio/model/search/mql/expressions/MqlExpressionPanel.java
  - test files
autonomous: true
---

# Quick Task 002: Change LiteralValueExpr.valueType to ValueType Enum

## Objective

Replace String-based valueType field in LiteralValueExpr with a type-safe enum.

**Purpose:** Eliminate magic strings ("string", "number", "bool") and provide compile-time type safety for literal value types.

**Output:** ValueType enum integrated across query model, frozen model, resolver, and UI.

## Context

Current implementation uses String literals throughout:
- LiteralValueExpr validates "string", "number", or "bool" at runtime
- QueryResolver passes strings to resolved expressions
- UI hardcodes string array for combo box items
- Tests use string literals in assertions

## Tasks

### Task 1: Create ValueType enum and update core model classes

<files>
- src/org/modelio/platform/query/api/model/query/ValueType.java (new)
- src/org/modelio/platform/query/api/model/query/LiteralValueExpr.java
- src/org/modelio/platform/query/api/model/frozen/FrozenLiteralValueExpr.java
</files>

<action>
1. Create `ValueType` enum in `org.modelio.platform.query.api.model.query` package:
   ```java
   public enum ValueType {
       STRING("string"),
       NUMBER("number"),
       BOOL("bool");
       
       private final String jsonValue;
       
       ValueType(String jsonValue) {
           this.jsonValue = jsonValue;
       }
       
       @JsonValue
       public String getJsonValue() {
           return this.jsonValue;
       }
       
       @JsonCreator
       public static ValueType fromString(String value) {
           for (ValueType type : values()) {
               if (type.jsonValue.equals(value)) {
                   return type;
               }
           }
           throw new IllegalArgumentException("Unknown valueType: " + value);
       }
   }
   ```

2. Update `LiteralValueExpr`:
   - Change field from `String valueType` to `ValueType valueType`
   - Update constructor to accept `ValueType` parameter
   - Remove string validation logic (enum provides type safety)
   - Update getValueType() return type to `ValueType`
   - Update setValueType() parameter to `ValueType`
   - Update static factory methods to use enum constants:
     - `ofString()` → `new LiteralValueExpr(ValueType.STRING, value)`
     - `ofNumber()` → `new LiteralValueExpr(ValueType.NUMBER, value)`
     - `ofBool()` → `new LiteralValueExpr(ValueType.BOOL, value)`
   - Update freeze() to pass enum to FrozenLiteralValueExpr

3. Update `FrozenLiteralValueExpr`:
   - Change record component from `String valueType` to `ValueType valueType`
   - Remove string validation in constructor (Jackson will deserialize to enum)
   - Update static factory methods to use enum constants
   - Update Javadoc to reference enum instead of string literals
</action>

<verify>
```bash
cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine
# Compile to verify no syntax errors
( source /work/modelio/alouette/toolkit/env_toolkit.sh && mvn -q -DskipTests=true clean compile )
```
</verify>

<done>
- ValueType enum created with STRING, NUMBER, BOOL constants
- Jackson annotations @JsonValue and @JsonCreator enable backward-compatible JSON (de)serialization
- LiteralValueExpr and FrozenLiteralValueExpr use ValueType instead of String
- All constructors and factory methods accept/return ValueType
- String validation logic removed (enum provides compile-time safety)
</done>

### Task 2: Update resolver and resolved model

<files>
- src/org/modelio/platform/query/engine/resolved/expr/ResolvedValueExpr.java
- src/org/modelio/platform/query/engine/resolver/QueryResolver.java
</files>

<action>
1. Update `ResolvedValueExpr.LiteralValueExpr` record:
   - Change `String valueType` component to `ValueType valueType`
   - Remove null/blank validation (enum can't be null/blank by design)

2. Update `QueryResolver.resolveValueExpr()`:
   - Find the pattern matching case for LiteralValueExpr
   - Change from `literalValueExpr.getValueType()` (which now returns ValueType)
   - Pass the enum directly to ResolvedValueExpr.LiteralValueExpr constructor
   - Line ~277: `new ResolvedValueExpr.LiteralValueExpr(literalValueExpr.getValueType(), literalValueExpr.getValue())`

No other changes needed - getValueType() now returns ValueType which matches the constructor signature.
</action>

<verify>
```bash
cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine
# Compile resolver package
( source /work/modelio/alouette/toolkit/env_toolkit.sh && mvn -q -DskipTests=true clean compile )
```
</verify>

<done>
- ResolvedValueExpr.LiteralValueExpr uses ValueType enum
- QueryResolver passes ValueType from query model to resolved model
- No string-to-enum conversion needed (type flows through cleanly)
</done>

### Task 3: Update UI and tests

<files>
- app.model.search.ui/src/org/modelio/model/search/mql/expressions/MqlExpressionPanel.java
- platform.search.engine.test/src/**/*Test.java (multiple test files)
</files>

<action>
1. Update `MqlExpressionPanel.renderLiteralValueExpr()` (line ~612):
   - Change hardcoded array: `new String[] { "string", "number", "bool" }`
   - To: `Arrays.stream(ValueType.values()).map(ValueType::getJsonValue).toArray(String[]::new)`
   - Add import: `import org.modelio.platform.query.api.model.query.ValueType;`
   - Add import: `import java.util.Arrays;`

2. Update type selection handler (line ~624):
   - Change: `lit.setValueType(typeCombo.getText())`
   - To: `lit.setValueType(ValueType.fromString(typeCombo.getText()))`

3. Update `renderLiteralValueEditor()` (line ~638):
   - Change: `if ("bool".equals(valueType))`
   - To: `if (ValueType.BOOL.equals(lit.getValueType()))`

4. Update `defaultValueForType()` method (line ~739+):
   - Change string parameter to ValueType parameter
   - Update switch to use enum constants

5. Search for all test files using LiteralValueExpr:
   ```bash
   grep -r "LiteralValueExpr\|FrozenLiteralValueExpr" platform.search.engine.test/src/ -l
   ```
   
6. For each test file found:
   - Tests already use static factory methods (ofString, ofNumber, ofBool)
   - No changes needed - factory methods internally use enum now
   - If any test directly accesses getValueType(), update assertion:
     - From: `assertThat(expr.getValueType()).isEqualTo("string")`
     - To: `assertThat(expr.getValueType()).isEqualTo(ValueType.STRING)`
</action>

<verify>
```bash
cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/build
# Run all tests
rm -f mvn-build.log mvn-exit.txt \
  && (source /work/modelio/alouette/toolkit/env_toolkit.sh \
      && mvn -q verify |& tee mvn-build.log; \
      echo $? > mvn-exit.txt)
cat mvn-exit.txt  # Should be 0
```
</verify>

<done>
- MqlExpressionPanel combo box populated from ValueType enum values
- Type selection converts string back to enum using fromString()
- Boolean comparison uses enum constant (ValueType.BOOL)
- All tests pass with enum-based implementation
- JSON serialization maintains backward compatibility ("string"/"number"/"bool" in JSON)
</done>

## Success Criteria

- [ ] ValueType enum defined with STRING, NUMBER, BOOL constants
- [ ] Jackson annotations enable JSON backward compatibility
- [ ] LiteralValueExpr field changed to ValueType type
- [ ] FrozenLiteralValueExpr record component changed to ValueType type
- [ ] ResolvedValueExpr.LiteralValueExpr uses ValueType
- [ ] QueryResolver passes enum through resolution
- [ ] UI combo box dynamically populated from enum values
- [ ] All tests pass (mvn verify exit code 0)
- [ ] No hardcoded "string"/"number"/"bool" strings in Java code (except enum definition)

## Verification

After completing all tasks:

1. **Compile check:**
   ```bash
   cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/build
   ( source /work/modelio/alouette/toolkit/env_toolkit.sh && mvn -q clean compile )
   ```

2. **Test execution:**
   ```bash
   cd /work/modelio/alouette/work/eclipse/modelio/platform/platform.search.engine/build
   ( source /work/modelio/alouette/toolkit/env_toolkit.sh && mvn -q verify )
   ```

3. **JSON compatibility check:**
   - Verify Jackson serializes ValueType.STRING as "string" in JSON
   - Verify Jackson deserializes "string" from JSON as ValueType.STRING

4. **Grep for magic strings:**
   ```bash
   # Should only find strings in enum definition and comments
   grep -r '"string"\|"number"\|"bool"' src/ --include='*.java' | grep -v '@objid' | grep -v '^\s*//'
   ```
