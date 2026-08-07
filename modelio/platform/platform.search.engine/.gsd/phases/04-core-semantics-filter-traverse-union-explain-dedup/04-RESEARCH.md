# Phase 4: Core Semantics (Filter/Traverse/Union + Explain + Dedup) - Research

**Researched:** 2026-02-20
**Domain:** MQL execution engine — step pipeline, expression evaluation, graph traversal, path explanation
**Confidence:** HIGH

## Summary

This research investigates the implementation of MQL execution semantics for Filter, Traverse, and Union steps, plus explanation path construction and deduplication. The current engine (`QueryEngine.runQuery()`) has an `UNSUPPORTED_STEP` gate that rejects any query with steps — Phase 4 removes that gate and implements the full step execution pipeline.

The codebase has well-defined resolved model types (sealed interfaces with record variants), a streaming result model (`IQueryResponseFiller`), and an existing source evaluator (`SourceEvaluator`) whose patterns (validity guard, push-or-skip, trivial path construction) serve as templates for step executors. The Modelio kernel provides all required APIs: `MObject.mGet(MDependency)` for dependency traversal, `MExpert.getSource()/getTarget()` for link endpoint discovery, `MClass.getLinkMetaclassSources()/getLinkMetaclassTargets()` for finding which dependencies connect link objects to their endpoints, `MDependency.getSymetric()` for backward traversal, and `ModelElement` typed accessors for property value reading.

**Primary recommendation:** Implement a step-pipeline executor that iterates the resolved step list sequentially, transforming a stream of `NodeWithExplainOut` items. Each step type (Filter, Traverse, Union) gets a dedicated executor method that reads from the previous step's output and produces new `NodeWithExplainOut` items with extended `PathOutput`. Deduplication uses a `Set<String>` keyed by `MObject.getUuid()`. Remove the `UNSUPPORTED_STEP` gate in `QueryEngine.runQuery()`.

## Standard Stack

### Core APIs (Modelio Kernel — already bundled)

| API | Location | Purpose | Why Standard |
|-----|----------|---------|--------------|
| `MObject.mGet(MDependency)` | `core.kernel` / `mapi.MObject` | Navigate dependencies, returns `List<MObject>` | Only way to traverse structural relations at runtime |
| `MObject.mGet(MAttribute)` | `core.kernel` / `mapi.MObject` | Read attribute values, returns `Object` | Only way to read meta-attribute values |
| `MExpert.getSource(MObject)` / `getTarget(MObject)` | `core.kernel` / `mapi.MExpert` | Get link endpoints universally | Works for ALL link types without link-type-specific code |
| `MExpert.isLink(MClass)` | `core.kernel` / `mapi.MExpert` | Verify a metaclass is a link type | Safety check before link traversal |
| `MClass.getLinkMetaclassSources()` | `core.kernel` / `mapi.MClass` | Get source-side dependencies of a link metaclass | Needed to find link objects from endpoint nodes |
| `MClass.getLinkMetaclassTargets()` | `core.kernel` / `mapi.MClass` | Get target-side dependencies of a link metaclass | Needed to find link objects from endpoint nodes |
| `MDependency.getSymetric()` | `core.kernel` / `mapi.MDependency` | Get the opposite dependency | Required for backward MDependency traversal |
| `MClass.isLinkMetaclass()` | `core.kernel` / `mapi.MClass` | Check if metaclass represents a link | Fast check during edge resolution |
| `MClass.hasBase(MClass)` | `core.kernel` / `mapi.MClass` | Check metaclass inheritance | Kind matching with `withSubMetaclasses` |

### Metamodel Element APIs (already bundled)

| API | Location | Purpose |
|-----|----------|---------|
| `ModelElement.getTagValue(TagType)` | `core.metamodel.api` | Read single tag value as String |
| `ModelElement.getTagValues(TagType)` | `core.metamodel.api` | Read multi-valued tag as `List<String>` |
| `ModelElement.getNoteContent(NoteType)` | `core.metamodel.api` | Read note content as String |
| `ModelElement.getProperty(Stereotype, String)` | `core.metamodel.api` | Read typed property value from stereotype table |
| `ModelElement.getProperty(MetaclassReference, String)` | `core.metamodel.api` | Read typed property value from reference table |
| `ModelElement.isStereotyped(String, String)` | `core.metamodel.api` | Check stereotype application |
| `ModelElement.getExtension()` | `core.metamodel.api` | Get applied stereotypes |

### Engine Model Types (already implemented in `platform.search.engine`)

| Type | Description |
|------|-------------|
| `ResolvedStep` | Sealed: `FilterStep`, `TraverseStep`, `UnionStep`, `RepeatStep`, `UnsupportedStep` |
| `ResolvedEdge` | Record with `List<EdgeAlternative>`: `MDependencyEdge` or `LinkObjectEdge` |
| `ResolvedExpr` | Sealed: `And`, `Or`, `Not`, `Compare`, `Is`, `Exists`, `UnsupportedExpr` |
| `ResolvedValueExpr` | Sealed: `ResolvedPropertyValueExpr`, `LiteralValueExpr`, `UnsupportedValueExpr` |
| `ResolvedProperty` | Record with `List<PropertyAlternative>`: `ResolvedMAttribute`, `ResolvedTagType`, `ResolvedNoteType`, `ResolvedPropertyDefinition` |
| `ResolvedKind` | Record with `List<KindAlternative>`: `MetaclassKind`, `StereotypeKind` |
| `PathOutput` | Record: `List<MObject> nodes`, `List<PathStepOutput> steps` |
| `PathStepOutput` | Sealed: `LinkPathStepOutput(MObject link, Direction)`, `MDependencyPathStepOutput(MClass mc, MDependency dep)` |
| `NodeWithExplainOut` | Record: `MObject node`, `PathOutput why` |
| `IQueryResponseFiller` | Interface: `pushItem()`, `pushDiagnostic()`, `setTruncated()`, `isComplete()` |

### Alternatives Considered

None — all required APIs are part of the existing Modelio kernel and metamodel. No external libraries needed.

## Architecture Patterns

### Recommended Package Structure

New classes go under `org.modelio.platform.query.internal.executor`:

```
internal/executor/
├── IQueryResponseFiller.java        # (existing)
├── SourceEvaluator.java             # (existing)
├── SyncQueryResponse.java           # (existing)
├── PreparedAsyncExecution.java      # (existing)
├── StepPipelineExecutor.java        # NEW: orchestrates step pipeline
├── ExpressionEvaluator.java         # NEW: evaluates ResolvedExpr on MObject
├── PropertyValueReader.java         # NEW: reads property values from MObject
└── KindMatcher.java                 # NEW: matches MObject against ResolvedKind
```

### Pattern 1: Step Pipeline Executor

**What:** A sequential pipeline that transforms `List<NodeWithExplainOut>` through each resolved step.

**When to use:** The main execution flow after source evaluation.

**Example shape:**

```java
// In StepPipelineExecutor (new class)
public final class StepPipelineExecutor {

    public static void execute(
            List<ResolvedStep> steps,
            List<NodeWithExplainOut> sourceItems,
            ICoreSession session,
            IQueryResponseFiller filler) {

        List<NodeWithExplainOut> current = sourceItems;

        for (ResolvedStep step : steps) {
            current = executeStep(step, current, session);
        }

        // Dedup by UUID and push to filler
        Set<String> seen = new LinkedHashSet<>();
        for (NodeWithExplainOut item : current) {
            if (filler.isComplete()) return;
            if (seen.add(item.node().getUuid())) {
                filler.pushItem(item);
            }
        }
    }

    private static List<NodeWithExplainOut> executeStep(
            ResolvedStep step,
            List<NodeWithExplainOut> input,
            ICoreSession session) {
        return switch (step) {
            case FilterStep f    -> executeFilter(f, input, session);
            case TraverseStep t  -> executeTraverse(t, input, session);
            case UnionStep u     -> executeUnion(u, input, session);
            case RepeatStep r    -> List.of(); // Out of scope for Phase 4
            case UnsupportedStep us -> List.of(); // Produce diagnostic
        };
    }
}
```

### Pattern 2: Expression Evaluation (Recursive Switch)

**What:** Evaluate a `ResolvedExpr` against an `MObject`, returning boolean.

**When to use:** `FilterStep` predicate evaluation and `TraverseStep` edge filter.

**Key design:** Use `switch` pattern matching on the sealed `ResolvedExpr` hierarchy. Each case is self-contained.

```java
// In ExpressionEvaluator (new class)
public static boolean evaluate(ResolvedExpr expr, MObject element, ICoreSession session) {
    return switch (expr) {
        case ResolvedAndExpr and  -> and.operands().stream().allMatch(e -> evaluate(e, element, session));
        case ResolvedOrExpr or    -> or.operands().stream().anyMatch(e -> evaluate(e, element, session));
        case ResolvedNotExpr not  -> !evaluate(not.operand(), element, session);
        case ResolvedIsExpr is    -> KindMatcher.matches(element, is.kind());
        case ResolvedCompareExpr cmp -> evaluateCompare(cmp, element, session);
        case ResolvedExistsExpr ex -> evaluateExists(ex, element, session);
        case ResolvedExpr.UnsupportedExpr u -> false; // defensive: exclude
    };
}
```

### Pattern 3: Link-Object Traversal (Forward and Backward)

**What:** Navigate from a node through link objects (e.g., Generalization, Dependency) to reach neighbor nodes.

**When to use:** `TraverseStep` with `LinkObjectEdge` alternatives.

**Critical insight:** Link objects are compositions of their _source_ endpoint. To find link objects from a node:
- **FORWARD** (node is source): use `getLinkMetaclassSources()` to find the composition dependency, then `mGet(dep)` to get link objects, then `MExpert.getTarget(link)` to get the far end.
- **BACKWARD** (node is target): use `getLinkMetaclassTargets()` to find the target dependency, then use its `getSymetric()` to get the incoming dependency from which the link objects can be found via `mGet()`, then `MExpert.getSource(link)` to get the far end.

```java
// Forward link traversal from a node
private static List<MObject> traverseLinkForward(
        MObject node, MClass linkMetaclass, MExpert expert) {
    List<MObject> results = new ArrayList<>();
    Collection<MDependency> sourceDeps = linkMetaclass.getLinkMetaclassSources();
    for (MDependency srcDep : sourceDeps) {
        // srcDep goes from linkMetaclass → sourceEndpoint
        // We need the opposite: sourceEndpoint → linkMetaclass
        MDependency oppositeDep = srcDep.getSymetric();
        if (oppositeDep != null && oppositeDep.getSource().isInstance(node)) {
            List<MObject> links = node.mGet(oppositeDep);
            for (MObject link : links) {
                if (link.getMClass().hasBase(linkMetaclass)) {
                    MObject target = expert.getTarget(link);
                    if (target != null && target.isValid() && !target.isDeleted()) {
                        results.add(target);
                    }
                }
            }
        }
    }
    return results;
}
```

### Pattern 4: MDependency Traversal (Forward and Backward via getSymetric)

**What:** Navigate a structural relation (e.g., `OwnedElement`, `Owner`).

**When to use:** `TraverseStep` with `MDependencyEdge` alternatives.

**Note:** `MDependencyEdge.direction()` currently always returns `FORWARD`. If backward traversal of an MDependency is needed in the future, use `dep.getSymetric()` to get the opposite dependency, then `mGet()` on that. If `getSymetric()` returns null, backward is not supported for that dependency.

```java
// MDependency traversal
private static List<MObject> traverseMDependency(MObject node, MDependency dep) {
    // dep.direction() is always FORWARD for MDependencyEdge
    List<MObject> targets = node.mGet(dep);
    return targets.stream()
        .filter(t -> t != null && t.isValid() )
        .toList();
}
```

### Pattern 5: Path Extension (Immutable Append)

**What:** Extend a `PathOutput` when traversing to a new node, adding a `PathStepOutput`.

**When to use:** Every traverse operation must record the step taken.

```java
// Extend path for link traversal
private static PathOutput extendPath(
        PathOutput existing, MObject newNode,
        MObject link, Direction direction) {
    List<MObject> newNodes = new ArrayList<>(existing.nodes());
    newNodes.add(newNode);
    List<PathStepOutput> newSteps = new ArrayList<>(existing.steps());
    newSteps.add(new LinkPathStepOutput(link, direction));
    return new PathOutput(List.copyOf(newNodes), List.copyOf(newSteps));
}

// Extend path for MDependency traversal
private static PathOutput extendPath(
        PathOutput existing, MObject newNode,
        MClass mc, MDependency dep) {
    List<MObject> newNodes = new ArrayList<>(existing.nodes());
    newNodes.add(newNode);
    List<PathStepOutput> newSteps = new ArrayList<>(existing.steps());
    newSteps.add(new MDependencyPathStepOutput(mc, dep));
    return new PathOutput(List.copyOf(newNodes), List.copyOf(newSteps));
}
```

NOTE : Te above pattern implies creating new `PathOutput` instances for each step extension and using `List.copyOf()` . Is this efficient enough for large paths? Consider using a mutable builder pattern internally and only creating immutable `PathOutput` at the end of the pipeline.

### Pattern 6: Kind Matching

**What:** Check whether an `MObject` matches a `ResolvedKind` (union of metaclass and stereotype alternatives).

**When to use:** `ResolvedIsExpr` evaluation and any output-kind filtering on steps.

```java
public static boolean matches(MObject element, ResolvedKind kind) {
    if (kind.isUnknown()) return false;
    for (KindAlternative alt : kind.alternatives()) {
        switch (alt) {
            case MetaclassKind mk -> {
                // FIXME :match must be exact if mk.isAbstract() is false,
                // with sub metaclasses if mk.isAbstract() is true.
                if (element.getMClass().hasBase(mk.metaclass())) return true;
            }
            case StereotypeKind sk -> {
                // FIXME :match must be exact if sk.stereotype().isAbstract() is false,
                // with sub metaclasses if sk.stereotype().isAbstract() is true.
                if (element instanceof ModelElement me
                        && me.getExtension().contains(sk.stereotype())) {
                    return true;
                }
            }
        }
    }
    return false;
}
```

### Pattern 7: Property Value Reading

**What:** Read a property value from an `MObject` given a `ResolvedProperty`.

**When to use:** `ResolvedPropertyValueExpr` evaluation inside `ResolvedCompareExpr`.

There are two approaches: high-level typed accessors on `ModelElement`, or low-level `mGet()`. The high-level API is cleaner and safer; use it when the element is a `ModelElement` (which it almost always is). Fall back to low-level `mGet()` only for non-ModelElement objects.

```java
// Using high-level ModelElement API (preferred)
private static Object readProperty(MObject element, PropertyAlternative alt) {
    return switch (alt) {
        case ResolvedMAttribute a -> element.mGet(a.attribute());
        case ResolvedTagType t -> {
            if (element instanceof ModelElement me) {
                yield me.getTagValue(t.tagType()); // returns String or null
            }
            yield null;
        }
        case ResolvedNoteType n -> {
            if (element instanceof ModelElement me) {
                yield me.getNoteContent(n.noteType()); // returns String or null
            }
            yield null;
        }
        case ResolvedPropertyDefinition pd -> {
            // Note : owner reference or stereotype is also accessible via
            // pd.getOwner().getOwnerReference() or pd.getOwner().getStereotype() .
            // Consider whether pd.owner() is really needed or if we can just use the stereotype/owner reference directly from the ResolvedPropertyDefinition.
            if (element instanceof ModelElement me) {
                yield switch (pd.owner()) {
                    case OwnerStereotype os -> me.getProperty(
                        os.stereotype(), pd.propertyDefinition().getName());
                    case OwnerReference or -> me.getProperty(
                        or.reference(), pd.propertyDefinition().getName());
                };
            }
            yield null;
        }
    };
}
```

### Pattern 8: Deduplication by MObject comparison

**What:** Deduplicate result nodes, keeping the first-discovered path.

**When to use:** At the end of the pipeline, before pushing to `IQueryResponseFiller`.

```java
Set<MObject> seen = new HashSet<>();
for (NodeWithExplainOut item : pipelineOutput) {
    if (seen.add(item.node())) {
        filler.pushItem(item);
    }
}
```

### Anti-Patterns to Avoid

- **Casting to specific metamodel types for link traversal:** Don't cast to `Generalization`, `Dependency`, etc. Use `MExpert.getSource()/getTarget()` universally.
- **Building custom metaclass hierarchies:** Use `MClass.hasBase()` for inheritance checks, never manual parent walking.
- **String-based dependency lookup at runtime:** Dependency objects are resolved at resolution time into `MDependency` instances. Don't do `getMClass().getDependency("OwnedElement")` during execution — the resolver already did that.
- **Recursive step execution with unbounded depth:** Phase 4 does NOT implement `RepeatStep`. Don't add recursive logic.

## Don't Hand-Roll

| Problem | Don't Build | Use Instead | Why |
|---------|-------------|-------------|-----|
| Link endpoint discovery | Custom per-link-type getSource/getTarget | `MExpert.getSource(link)` / `MExpert.getTarget(link)` | Universal, works for all 30+ link metaclasses |
| Metaclass hierarchy check | Walk `.getSuper()` chain manually | `MClass.hasBase(baseClass)` | Kernel-optimized, handles all inheritance |
| Link metaclass detection | Check against known link type names | `MClass.isLinkMetaclass()` | Authoritative metamodel answer |
| Source/target deps of links | Hard-code "SubType" / "SuperType" per type | `MClass.getLinkMetaclassSources()` / `getLinkMetaclassTargets()` | Generic, metamodel-driven |
| Backward dependency navigation | Manually track inverses | `MDependency.getSymetric()` | Kernel-maintained bidirectional mapping |
| Tag value reading | Navigate Tag→Actual→Value manually via mGet | `ModelElement.getTagValue(TagType)` | Type-safe, handles empty/multi params |
| Note content reading | Navigate Descriptor→Content via mGet | `ModelElement.getNoteContent(NoteType)` | Type-safe, null-safe |
| Property table reading | Navigate Properties→Type→Content | `ModelElement.getProperty(Stereotype, key)` | Handles table lookup and type conversion |
| Stereotype check | Compare UUIDs or names manually | `ModelElement.isStereotyped(moduleName, stereoName)` | Standard Modelio API |
| MExpert access | Look for it on MTools or MObject | `session.getMetamodel().getMExpert()` | The only correct access path |

**Key insight:** The Modelio kernel already solves all graph navigation problems at the metamodel level. The execution engine's job is to map resolved types to the correct kernel API calls, not to re-implement metamodel semantics.

## Common Pitfalls

### Pitfall 1: Wrong Method for Backward Dependency

**What goes wrong:** Using `dep.getTarget()` or looking for a method named `getOpposite()` for backward navigation.
**Why it happens:** The method is named `getSymetric()` (French spelling, not `getSymmetric` or `getOpposite`).
**How to avoid:** Always use `MDependency.getSymetric()`. Returns null if no opposite exists. If null, backward traversal is not supported for that dependency → produce an error diagnostic.
**Warning signs:** `NullPointerException` or `NoSuchMethodError` at runtime.

### Pitfall 2: Link Object Discovery Direction Confusion

**What goes wrong:** Using `getLinkMetaclassSources()` when you should use `getLinkMetaclassTargets()`, or vice versa.
**Why it happens:** The naming is from the link's perspective: "sources" = dependencies pointing from link to the source endpoint. To find link objects from a source node, you need the _symmetric_ of a source dependency.
**How to avoid:**
- FORWARD traversal from node: find "source deps" on the link metaclass → get their symmetrics → `mGet()` on the node → filter links → `MExpert.getTarget(link)` for far end.
- BACKWARD traversal from node: find "target deps" on the link metaclass → get their symmetrics → `mGet()` on the node → filter links → `MExpert.getSource(link)` for far end.
**Warning signs:** Empty traversal results on test scenarios that should produce results.

### Pitfall 3: Forgetting Validity Guards on Traversed Nodes

**What goes wrong:** Pushing deleted or invalid elements into results.
**Why it happens:** `mGet(dep)` can return elements that have been deleted or are in an invalid state.
**How to avoid:** Apply `isValidElement(element)` guard (null check + `isValid()` ) on every traversed target before including it in results. This pattern exists in `SourceEvaluator.isValidElement()`.
**Warning signs:** Crashes or stale elements in UI display.

### Pitfall 4: Property Absence vs. Null Confusion

**What goes wrong:** Treating "property doesn't exist on this element" as an error instead of excluding the element.
**Why it happens:** Not all elements have all properties. A tag type only exists on elements where it's been applied.
**How to avoid:** Per CONTEXT.md decision: "If a property referenced by a filter does not exist on an element, exclude the element." Return `null` from property reader → comparison returns `false` → element excluded. Never throw.
**Warning signs:** Queries filtering on tag types match zero elements when some should match.

### Pitfall 5: Compare Operator on Incompatible Types

**What goes wrong:** Comparing a Number literal to a String property value, producing ClassCastException.
**Why it happens:** `MObject.mGet(MAttribute)` returns `Object` (could be String, Enum, Integer, Boolean). TagType values are always Strings. Literals have explicit `ValueType`.
**How to avoid:** Coerce values to a common type before comparison. Use this coercion matrix:
- **`=` / `!=`** : Convert both to String via `String.valueOf()` and compare with `equalsIgnoreCase()`.
- **`<` / `>` / `<=` / `>=`** : If both are numeric (or parseable as Number), compare as `double`. Otherwise, lexicographic String comparison.
- **`contains` / `startsWith`** : Convert both to String. `contains` = `left.contains(right)`. `startsWith` = `left.startsWith(right)`.
- **Null handling:** If either operand is null, comparison returns `false` (per CONTEXT.md: "null comparisons are permissive").
**Warning signs:** `ClassCastException` at runtime during expression evaluation.

### Pitfall 6: Union Branches Producing Duplicates

**What goes wrong:** Union of two branches that reach the same node produces duplicate items.
**Why it happens:** Per MQL spec: "Union never implies automatic deduplication by itself." But CONTEXT.md says "Keep one result item per deduplicated node."
**How to avoid:** Deduplication is applied at the END of the full pipeline, not per-step. Union may produce duplicates internally, but the final dedup pass (keyed by UUID, keeping first-discovered) removes them.
**Warning signs:** Duplicate items in query results.

### Pitfall 7: Ambiguous Edge/Property Handling

**What goes wrong:** Using only the first alternative and ignoring the rest.
**Why it happens:** `ResolvedEdge` and `ResolvedProperty` can have multiple `alternatives` (ambiguity awareness).
**How to avoid:** Per CONTEXT.md: "Ambiguous property alternatives in filters use implicit OR semantics." Iterate ALL alternatives. For edges, traverse all alternatives and merge results. For properties, try alternatives in order and use the first that returns non-null. For `IsExpr`, match against any alternative in the `ResolvedKind`.
**Warning signs:** Queries involving ambiguous names return partial results.

## Code Examples

### Accessing MExpert from Session

```java
// Source: core.kernel MMetamodel interface
ICoreSession session = ...;
MExpert expert = session.getMetamodel().getMExpert();

// From an element:
MExpert expert = element.getMClass().getMetamodel().getMExpert();

// Check if a metaclass is a link type:
boolean isLink = expert.isLink(someMetaclass);
// or equivalently:
boolean isLink = someMetaclass.isLinkMetaclass();
```

### Complete Link-Object Forward Traversal

```java
// Source: MClass API (core.kernel)
// Given: node (source endpoint), linkMetaclass (e.g., Generalization MClass)
// Result: list of target endpoint nodes

MExpert expert = session.getMetamodel().getMExpert();
Collection<MDependency> sourceDeps = linkMetaclass.getLinkMetaclassSources();
List<MObject> targets = new ArrayList<>();

for (MDependency srcDep : sourceDeps) {
    // srcDep: linkMetaclass → source endpoint (e.g., Generalization → SubType)
    // We need the reverse: source endpoint → link objects
    MDependency opposite = srcDep.getSymetric();
    if (opposite != null && opposite.getSource().isInstance(node)) {
        List<MObject> links = node.mGet(opposite);
        for (MObject link : links) {
            if (link.getMClass().hasBase(linkMetaclass)) {
                MObject target = expert.getTarget(link);
                if (target != null && target.isValid() ) {
                    targets.add(target);
                    // Record: link object + Direction.FORWARD for PathOutput
                }
            }
        }
    }
}
```

### Complete Link-Object Backward Traversal

```java
// Given: node (target endpoint), linkMetaclass (e.g., Generalization MClass)
// Backward: find nodes that are the SOURCE of links pointing TO this node

Collection<MDependency> targetDeps = linkMetaclass.getLinkMetaclassTargets();
List<MObject> sources = new ArrayList<>();

for (MDependency tgtDep : targetDeps) {
    // tgtDep: linkMetaclass → target endpoint (e.g., Generalization → SuperType)
    // We need the reverse: target endpoint → link objects
    MDependency opposite = tgtDep.getSymetric();
    if (opposite != null && opposite.getSource().isInstance(node)) {
        List<MObject> links = node.mGet(opposite);
        for (MObject link : links) {
            if (link.getMClass().hasBase(linkMetaclass)) {
                MObject source = expert.getSource(link);
                if (source != null && source.isValid() ) {
                    sources.add(source);
                    // Record: link object + Direction.BACKWARD for PathOutput
                }
            }
        }
    }
}
```

### MDependency Forward Traversal

```java
// Source: MObject API (core.kernel)
// Given: node, resolved MDependency dep
List<MObject> targets = node.mGet(dep);
// Filter: targets.stream().filter(t -> t != null && t.isValid())
// PathStepOutput: new MDependencyPathStepOutput(dep.getSource(), dep)
```

### Reading Property Values (High-Level API)

```java
// Source: ModelElement API (core.metamodel.api)
// TagType value reading:
ModelElement me = (ModelElement) element;
String singleValue = me.getTagValue(tagType);        // null if absent
List<String> multiValues = me.getTagValues(tagType);  // empty if absent

// NoteType content reading:
String noteContent = me.getNoteContent(noteType);     // null if absent

// PropertyDefinition reading (via Stereotype owner):
String propValue = me.getProperty(stereotype, propertyDef.getName()); // null if absent

// PropertyDefinition reading (via MetaclassReference owner):
String propValue = me.getProperty(metaclassRef, propertyDef.getName()); // null if absent

// MAttribute reading (low-level kernel API):
Object attrValue = element.mGet(mAttribute);  // returns Object: String, Enum, Integer, Boolean
```

### Removing the UNSUPPORTED_STEP Gate

```java
// In QueryEngine.runQuery(), REPLACE this block:
//   if (!resolvedQuery.steps().isEmpty()) {
//       responseFiller.pushDiagnostic(Diagnostics.error(
//               DiagnosticCode.UNSUPPORTED_STEP,
//               "Step execution is not yet implemented"));
//       responseFiller.getState().complete(QueryCompletionStatus.FAILED);
//       return;
//   }
// WITH: pipeline execution call to new StepPipelineExecutor
```

### Creating Test Fixtures

```java
// Source: TestModelFactory (platform.search.engine.test)
// Create elements
MObject pkg = factory.createElement("Package", "myPkg");
MObject cls1 = factory.createElement("Class", "Animal");
MObject cls2 = factory.createElement("Class", "Dog");

// Set ownership
factory.setDependency(cls1, "Owner", pkg);
factory.setDependency(cls2, "Owner", pkg);

// Create generalization link: Dog extends Animal
MObject gen = factory.createElement("Generalization", "");
factory.setDependency(gen, "SubType", cls2);   // source endpoint
factory.setDependency(gen, "SuperType", cls1); // target endpoint
```

### Stereotype Matching in Kind Check

```java
// Source: ModelElement API + ResolvedKind
if (element instanceof ModelElement me) {
    for (Stereotype st : me.getExtension()) {
        if (st.equals(targetStereotype)) return true;
        // For withSubStereotypes, also check st.getParent()
    }
}
```

## State of the Art

| Old Approach (backup) | Current Approach | When Changed | Impact |
|----------------------|------------------|--------------|--------|
| `ExecutionNode` graph with visitor | Sequential pipeline on `List<NodeWithExplainOut>` | Phase 3 refactoring | Simpler, no custom node graph needed |
| Custom dedup data structure | `Set<MObject>` directly | Phase 4 (this research) | MObject.equals() handles identity |
| Low-level mGet for all property reads | High-level `ModelElement` typed accessors | Phase 4 (this research) | Cleaner, type-safe, null-safe |

**Deprecated/outdated from backup research:**
- The backup proposed an `ExecutionNode`-based graph structure. The current codebase uses flat `List<NodeWithExplainOut>` processing through `IQueryResponseFiller`. Stay with this simpler approach.
- The backup mentioned `frontier-based expansion`. This is relevant for `RepeatStep` (out of Phase 4 scope), not for linear pipeline steps.

## Open Questions

1. **Edge filter vs. node filter timing in TraverseStep**
   - What we know: `TraverseStep` has both an `edgeFilter` (applied to link objects) and `outputKind` (applied to traversal targets). For `MDependencyEdge`, the `edgeFilter` should be null since there's no link object.
   - What's unclear: Should `edgeFilter` be evaluated on the link MObject before following to the target, or after?
   - Recommendation: Evaluate `edgeFilter` on the link object immediately after finding it, before calling `getTarget()/getSource()`. This filters early and avoids unnecessary navigation.

2. **Stereotype sub-hierarchy matching**
   - What we know: `ResolvedKind.StereotypeKind` exists. The spec mentions `withSubStereotypes` but the resolved model doesn't expose it.
   - What's unclear: Does the resolver already handle sub-stereotype expansion into multiple alternatives, or does the executor need to walk stereotype inheritance?
   - Recommendation: Check how `KindResolver` emits `StereotypeKind`. If it already expands, no executor work needed. If not, executor must walk `Stereotype.getParent()` chain.

3. **Exists expression implementation depth**
   - What we know: `ResolvedExistsExpr` contains `List<ResolvedStep> in` and `ResolvedExpr where`. This is a sub-query requiring step execution from the current node.
   - What's unclear: Whether Phase 4 should fully implement `Exists` or leave it as `UnsupportedExpr`.
   - Recommendation: Implement basic `Exists` if it uses only Filter/Traverse steps (no Repeat). It reuses the same step execution machinery.

## Sources

### Primary (HIGH confidence)

- **`MObject.java`** — core.kernel: `mGet(MDependency)` returns `List<MObject>`, `mGet(MAttribute)` returns `Object`
- **`MClass.java`** — core.kernel: `getLinkMetaclassSources()`, `getLinkMetaclassTargets()`, `isLinkMetaclass()`, `hasBase(MClass)`
- **`MDependency.java`** — core.kernel: `getSymetric()` returns `MDependency` (opposite), `isComposition()`, `getSource()`, `getTarget()`
- **`MExpert.java`** — core.kernel: `getSource(MObject)`, `getTarget(MObject)`, `isLink(MClass)`
- **`ModelElement.java`** — core.metamodel.api: `getTagValue(TagType)`, `getTagValues(TagType)`, `getNoteContent(NoteType)`, `getProperty(Stereotype, String)`, `getProperty(MetaclassReference, String)`, `getExtension()`, `isStereotyped(String, String)`
- **`ResolvedStep.java`**, **`ResolvedEdge.java`**, **`ResolvedExpr.java`**, **`ResolvedValueExpr.java`**, **`ResolvedProperty.java`**, **`ResolvedKind.java`** — platform.search.engine: Full sealed type hierarchies
- **`PathOutput.java`**, **`PathStepOutput.java`**, **`LinkPathStepOutput.java`**, **`MDependencyPathStepOutput.java`**, **`NodeWithExplainOut.java`** — platform.search.engine: Result model types
- **`SourceEvaluator.java`** — platform.search.engine: Existing execution patterns (validity guard, push-or-skip, trivial path)
- **`QueryEngine.java`** — platform.search.engine: UNSUPPORTED_STEP gate at lines 130-136
- **`IQueryResponseFiller.java`** — platform.search.engine: Streaming result API
- **`DiagnosticCode.java`** — platform.search.engine: Existing diagnostic codes
- **`TestModelFactory.java`**, **`AbstractMqlTest.java`**, **`TestSession.java`** — platform.search.engine.test: Test infrastructure
- **`QueryEngineExecutionTest.java`** — platform.search.engine.test: Existing test patterns
- **`ValueKeyReference.java`** — core.query: Reference patterns for low-level property reading via mGet

### Secondary (MEDIUM confidence)

- **MQL Technical Spec §4 (Resolved AST)** — `core.query/specs/technical/06-resolved-ast-v1.md`: Edge semantics, step definitions, return spec
- **MQL Technical Spec §5 (Expressions)** — `core.query/specs/technical/07-expressions.md`: Comparison operators, KV value semantics
- **MQL Technical Spec §6 (Execution)** — `core.query/specs/technical/08-execution-semantics.md`: Streaming, cycle safety, BFS/DFS
- **MQL Technical Spec §10 (MVP)** — `core.query/specs/technical/12-implementation-notes-mvp.md`: Suggested implementation order
- **CONTEXT.md** (Phase 4) — Implementation decisions from user discussion

### Tertiary (very LOW confidence)

- **Backup research** (`build/bak/04-RESEARCH.md`) — Older analysis made by a dumb AI, superseded by current codebase state. Some architectural patterns (frontier-based expansion) are relevant to RepeatStep (Phase 5+), not Phase 4.

## Metadata

**Confidence breakdown:**
- Standard stack: **HIGH** — All APIs verified by reading source files directly
- Architecture patterns: **HIGH** — Based on existing code patterns in SourceEvaluator and the sealed type hierarchies
- Pitfalls: **HIGH** — Verified by reading actual method signatures (e.g., `getSymetric()` spelling confirmed)
- Value coercion: **MEDIUM** — Based on spec §5.3 and CONTEXT.md decisions, specific edge cases may need refinement during implementation

**Research date:** 2026-02-20
**Valid until:** Stable — these are Modelio kernel APIs that change rarely. Resolved model types are in active development but sealed interfaces constrain the shape.
