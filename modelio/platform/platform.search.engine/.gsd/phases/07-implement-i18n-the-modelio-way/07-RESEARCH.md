# Phase 07 — Research: Implement I18n the Modelio Way

**Date**: 2026-02-24
**Phase**: 07 — Implement I18n the Modelio Way
**Mode**: implementation

---

## TL;DR

The plugin infrastructure (`LOG`, `I18N`) **already exists** in `SearchEngine.java` but is **broken**: no
`res/modelsearch.properties` file exists, so any call to `SearchEngine.I18N` at runtime would throw
`MissingResourceException`. The phase is about completing the setup and wiring all hardcoded diagnostic
strings through `I18N`.

The pattern is 100% Modelio-internal — no external libraries involved.

---

## Standard Stack

| Concern | Class | Bundle |
|---------|-------|--------|
| Plugin logger | `org.modelio.platform.utils.log.writers.PluginLogger` | `org.modelio.platform.utils` |
| I18n messages | `org.modelio.platform.utils.i18n.BundledMessages` | `org.modelio.platform.utils` |
| Resource files | `res/<bundlename>.properties` (EN) + `res/<bundlename>_fr.properties` (FR) | in this bundle |

Both are already in the OSGi `Require-Bundle` dependency (`org.modelio.platform.utils` at line 9 of MANIFEST.MF).

---

## Architecture Patterns

### Pattern: Plugin Constants Class (canonical reference)

[`AppProjectCore.java`](/work/modelio/alouette/work/eclipse/modelio/platform/platform.project/src/org/modelio/platform/project/plugin/AppProjectCore.java) — the reference implementation:

```java
public class AppProjectCore implements BundleActivator {
    public static final String PLUGIN_ID = "org.modelio.platform.project";
    public static BundledMessages I18N;
    public static PluginLogger LOG;

    @Override
    public void start(BundleContext bundleContext) {
        context = bundleContext;
        ServiceReference<ExtendedLogService> ref = bundleContext.getServiceReference(ExtendedLogService.class);
        ExtendedLogService service = bundleContext.getService(ref);
        LOG = new PluginLogger(service.getLogger((String) null));
        I18N = new BundledMessages(LOG, ResourceBundle.getBundle("appprojectcore"));
    }
}
```

### Pattern: PluginLogger initialization variants

Two forms found in the codebase:

| Form | Example plugin | Verdict |
|------|---------------|---------|
| `service.getLogger((String) null)` | `AppProjectCore`, `SearchEngine` (current) | Works but logger has no bundle association |
| `service.getLogger(bundleContext.getBundle(), PLUGIN_ID)` | `CoreUi`, `ModelViewTemplate`, `ModuleCommands` | **Preferred** — associates logger with bundle |

**Updated User decision**: update `SearchEngine.start()` to use `service.getLogger(PLUGIN_ID)`.

### Pattern: ResourceBundle file naming

The `ResourceBundle.getBundle("modelsearch")` call expects either:
- `res/modelsearch.properties` on the classpath root (default / EN), or
- `res/modelsearch_fr.properties` for French locale

The `res/` directory must appear in both `source..` and `bin.includes` in `build.properties`.

### Pattern: build.properties inclusion

From [platform.project/build.properties](/work/modelio/alouette/work/eclipse/modelio/platform/platform.project/build.properties):

```properties
source.. = src/,res/
output.. = bin/
javacSource = 17
javacTarget = 17
bin.includes = META-INF/,\
               .,\
               res/,\
               plugin.xml
```

Search engine current `build.properties` is missing `res/,` in both `source..` and `bin.includes`.

### Pattern: Message key naming

From `appprojectcore.properties` — keys use format `$CODE.field` for model-shield messages, or free-form descriptive keys for other messages. For MQL diagnostics, use a flat namespace per caller:

```properties
# KindResolver
MQL.resolver.kind.unknown.blank=Unknown kind (blank token)
MQL.resolver.kind.unknown=Unknown kind ''{0}''
MQL.resolver.kind.ambiguous=Ambiguous kind ''{0}'' resolved to {1} alternative(s)

# EdgeResolver
MQL.resolver.edge.unknown.blank=Unknown edge (blank token)
MQL.resolver.edge.unknown=Unknown edge ''{0}''
MQL.resolver.edge.ambiguous=Ambiguous edge ''{0}'' resolved to {1} alternative(s)

# PropertyKeyResolver
MQL.resolver.property.unknown.blank=Unknown property key (blank token)
MQL.resolver.property.unknown=Unknown property key ''{0}''
MQL.resolver.property.ambiguous=Ambiguous property key ''{0}''

# QueryResolver
MQL.resolver.source.unsupported=Unsupported source type: {0}

# SourceEvaluator
MQL.executor.element.skipped={0} invalid/deleted element(s) skipped

# ExecutionBudget
MQL.executor.truncated.limit=Execution truncated after {0} results
MQL.executor.truncated.timeout=Execution timeout after {0} ms

# StepPipelineExecutor
MQL.executor.truncated.pipeline=Execution truncated at limit
```

MessageFormat patterns use `{0}`, `{1}` placeholders — called via `BundledMessages.getMessage(key, args...)`.

---

## Hardcoded String Inventory

All strings that need to move to `modelsearch.properties`:

### Resolver package

| File | Current literal | Proposed key |
|------|-----------------|--------------|
| `EdgeResolver.java:131` | `"Unknown edge (blank token)"` | `MQL.resolver.edge.unknown.blank` |
| `EdgeResolver.java:136` | `"Unknown edge '" + token + "'"` | `MQL.resolver.edge.unknown` |
| `EdgeResolver.java:138` | `"Ambiguous edge '" + token + "' resolved to " + count + "..."` | `MQL.resolver.edge.ambiguous` |
| `KindResolver.java:93` | `"Unknown kind (blank token)"` | `MQL.resolver.kind.unknown.blank` |
| `KindResolver.java:98` | `"Unknown kind '" + token + "'"` | `MQL.resolver.kind.unknown` |
| `KindResolver.java:100` | `"Ambiguous kind '" + token + "' resolved to " + count + "..."` | `MQL.resolver.kind.ambiguous` |
| `PropertyKeyResolver.java:121` | `"Unknown property key (blank token)"` | `MQL.resolver.property.unknown.blank` |
| `PropertyKeyResolver.java:126` | `"Unknown property key '" + token + "'"` | `MQL.resolver.property.unknown` |
| `PropertyKeyResolver.java:135` | `"Ambiguous property key '" + token + "'"` | `MQL.resolver.property.ambiguous` |
| `QueryResolver.java:187` | `"Unsupported source type: " + clsName` | `MQL.resolver.source.unsupported` |

### Executor package

| File | Current literal | Proposed key |
|------|-----------------|--------------|
| `SourceEvaluator.java:95` | `String.format("Skipped %d invalid/deleted element(s)", count)` | `MQL.executor.element.skipped` |
| `SourceEvaluator.java:151` | `String.format("Skipped %d invalid/deleted element(s)", count)` | `MQL.executor.element.skipped` (same key) |
| `ExecutionBudget.java:80` | `String.format("Execution %s after %d results", ...)` | `MQL.executor.truncated.limit` |
| `ExecutionBudget.java:89` | `String.format("Execution timeout after %d ms", ...)` | `MQL.executor.truncated.timeout` |
| `StepPipelineExecutor.java:124` | `"Execution truncated at limit"` | `MQL.executor.truncated.pipeline` |

**Note on RepeatStepExecutor** — the two `EXECUTION_TRUNCATED` diagnostics there pass strings from
`ExecutionBudget.exhaustionCause()` (already covered above) plus one `CYCLE_DETECTED` that uses inline
`"Cycle detected at: " + node.getName()` — add `MQL.executor.cycle.detected`.

---

## What's Already Done (Don't Redo)

- **`SearchEngine.java`** — static `LOG` and `I18N` fields already declared and initialized ✅
- **`platform.utils` dependency** — already in `MANIFEST.MF` ✅
- **`BundledMessages` constructor call** — already present: `ResourceBundle.getBundle("modelsearch")` ✅
- **Phase 3.02** — already migrated all `System.Logger` usages to `SearchEngine.LOG` ✅

---

## Don't Hand-Roll

- **Do NOT** create a custom i18n mechanism — use `BundledMessages` exactly as other plugins do
- **Do NOT** create a `Messages.java` constants class like Eclipse NLS — Modelio does not use that pattern
- **Do NOT** use `@NLS` or `org.eclipse.osgi.util.NLS` — not used in Modelio
- **Do NOT** put message strings in `plugin.properties` — those are for `%key` substitutions in `plugin.xml`
  labels, not for Java code

---

## Common Pitfalls

1. **Missing `res/` in `build.properties`** — `ResourceBundle.getBundle("modelsearch")` will throw
   `MissingResourceException` at plugin start; breaks logging AND i18n for the entire bundle.

2. **Wrong `source..` path** — the `res/` directory must appear in `source..` (not just `bin.includes`)
   so Tycho compiles it to the output and includes it in the JAR.

3. **`MessageFormat` quoting** — single quotes in property values must be doubled: `It''s` not `It's`.
   Curly-brace tokens `{0}` must not be quoted.

4. **`PluginLogger(Logger)` deprecated form** — current `SearchEngine.start()` uses
   `service.getLogger((String) null)` which is the new form. Fix: use
   `service.getLogger(bundleContext.getBundle(), PLUGIN_ID)`.

5. **`DiagnosticCode.description()` — do NOT migrate to I18N** — these are API-level constants
   embedded in the public `DiagnosticCode` enum. They are serialized and compared in tests; changing
   them to runtime-resolved strings would break API consumers. Leave them as hardcoded English strings.

6. **Test isolation** — `SearchEngine.LOG` and `SearchEngine.I18N` are `null` in test context
   (no OSGi runtime). Tests that exercise resolver/executor message strings must NOT call `I18N.getMessage`;
   the `Diagnostics` factory class receives fully constructed message strings, so message assembly must
   happen before the `Diagnostics.warning(...)` call site, guarded by null-check or a static helper.

   **Recommended approach**: add a `SearchEngineI18N` helper that falls back to the raw pattern string
   when `SearchEngine.I18N` is null (test context):

   ```java
   static String msg(String key, Object... args) {
       BundledMessages i18n = SearchEngine.I18N;
       return (i18n != null) ? i18n.getMessage(key, args) : MessageFormat.format(key, args);
   }
   ```

   Place this helper in the `internal` package, used by resolver and executor.

---

## Implementation Order

Strict dependency order ensures each step is independently testable:

1. **Create `res/modelsearch.properties`** — English message strings (all keys above)
2. **Create `res/modelsearch_fr.properties`** — French translations (translate english values to french)
3. **Update `build.properties`** — add `res/,` to `source..` and `bin.includes`
4. **Fix `SearchEngine.start()`** — use `service.getLogger(bundleContext.getBundle(), PLUGIN_ID)`
5. **Add `SearchEngineI18N` helper** — null-safe `msg(key, args)` in `internal` package
6. **Migrate resolver strings** — `KindResolver`, `EdgeResolver`, `PropertyKeyResolver`, `QueryResolver`
7. **Migrate executor strings** — `SourceEvaluator`, `ExecutionBudget`, `StepPipelineExecutor`, `RepeatStepExecutor`
8. **Verify** — build passes, tests pass, no hardcoded EN strings remain in internal classes

---

## Code Examples

### BundledMessages usage (after migration)

```java
// In KindResolver (internal):
import org.modelio.platform.search.engine.plugin.SearchEngine;

// Before:
diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, "Unknown kind (blank token)"));
diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, "Unknown kind '" + token + "'"));
diagnostics.add(Diagnostics.warning(DiagnosticCode.AMBIGUOUS_KIND, "Ambiguous kind '" + token + "' resolved to " + count + " alternative(s)"));

// After:
diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, I18N.msg("MQL.resolver.kind.unknown.blank")));
diagnostics.add(Diagnostics.warning(DiagnosticCode.UNKNOWN_KIND, I18N.msg("MQL.resolver.kind.unknown", token)));
diagnostics.add(Diagnostics.warning(DiagnosticCode.AMBIGUOUS_KIND, I18N.msg("MQL.resolver.kind.ambiguous", token, count)));
```

### Null-safe helper

```java
// SearchEngineI18N.java in org.modelio.platform.query.internal
package org.modelio.platform.query.internal;

import java.text.MessageFormat;
import org.modelio.platform.utils.i18n.BundledMessages;
import org.modelio.platform.search.engine.plugin.SearchEngine;

/**
 * Null-safe I18n helper for MQL internal classes.
 * Falls back to key-as-pattern when running outside OSGi (e.g., in unit tests).
 */
public final class SearchEngineI18N {
    private SearchEngineI18N() {}

    public static String msg(String key, Object... args) {
        BundledMessages i18n = SearchEngine.I18N;
        if (i18n != null) {
            return i18n.getMessage(key, args);
        }
        // fallback: treat key as MessageFormat pattern (test context)
        return args.length == 0 ? key : MessageFormat.format(key, args);
    }
}
```

### build.properties update

```properties
source.. = src/,res/
output.. = bin/
javacSource = 21
javacTarget = 21
bin.includes = META-INF/,\
               .,\
               res/
```

### SearchEngine.start() fix

```java
@Override
public void start(BundleContext bundleContext) throws Exception {
    context = bundleContext;
    ServiceReference<ExtendedLogService> ref = bundleContext.getServiceReference(ExtendedLogService.class);
    ExtendedLogService service = bundleContext.getService(ref);
    LOG = new PluginLogger(service.getLogger(bundleContext.getBundle(), PLUGIN_ID));
    I18N = new BundledMessages(LOG, ResourceBundle.getBundle("modelsearch"));
}
```

---

## Confidence Levels

| Claim | Confidence | Source |
|-------|-----------|--------|
| `BundledMessages` + `PluginLogger` is the correct stack | HIGH | `AppProjectCore.java`, `CoreUi.java`, 8+ plugins verified |
| `res/` must be in both `source..` and `bin.includes` | HIGH | `platform.project/build.properties` verified |
| `service.getLogger(PLUGIN_ID)` is preferred form | HIGH | User decision |
| `SearchEngine.I18N` is null in test context | HIGH | No OSGi activation in `platform.search.engine.test` fragment |
| `DiagnosticCode.description()` should stay hardcoded | HIGH | It's API/serialized, not a user-visible runtime string |
| French translations must be translations of English values | HIGH | User decision |
