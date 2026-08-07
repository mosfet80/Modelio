# AGENTS.md - core.kernel

## Module Overview

**Bundle Name**: Kernel  
**Artifact ID**: `org.modelio.core.kernel`  
**Bundle Symbolic Name**: `org.modelio.core.kernel`

This module is the **modeling kernel** of Modelio. It provides the core infrastructure for model elements, metamodel definition, and low-level model manipulation. It defines the fundamental APIs like `MObject`, `MClass`, and `SmMetamodel`.

### Purpose

- Define model element API (`MObject`, `MClass`, `MAttribute`, etc.)
- Metamodel infrastructure (`SmMetamodel`, `SmClass`, `MMetamodelFragment`)
- Kernel-level model manipulation (`SmObjectImpl`, `SmObjectData`)
- Transaction support infrastructure
- Memory swap management for large models
- Model composition and navigation

## Package Structure

| Package | Description |
|---------|-------------|
| `org.modelio.vcore.model` | Model utilities (CompositionGetter, etc.) |
| `org.modelio.vcore.model.filter` | Model element filters |
| `org.modelio.vcore.smkernel` | SmObject implementation core |
| `org.modelio.vcore.smkernel.mapi` | **Public API**: MObject, MClass, MMetamodel |
| `org.modelio.vcore.smkernel.mapi.fake` | Fake/stub implementations for testing |
| `org.modelio.vcore.smkernel.mapi.modelshield.api` | ModelShield validation API |
| `org.modelio.vcore.smkernel.mapi.modelshield.spi` | ModelShield SPI |
| `org.modelio.vcore.smkernel.mapi.services` | Kernel services |
| `org.modelio.vcore.smkernel.meta` | Metamodel implementation (SmClass, SmMetamodel) |
| `org.modelio.vcore.smkernel.meta.descriptor` | Metamodel descriptors |
| `org.modelio.vcore.smkernel.meta.mof` | MOF-like meta-operations |
| `org.modelio.vcore.smkernel.meta.smannotations` | Metamodel annotations |
| `org.modelio.vcore.smkernel.transaction` | Low-level transaction support |
| `org.modelio.vcore.swap` | Memory swap for large models |
| `org.modelio.vcore.swap.jmx` | JMX monitoring for swap |
| `org.modelio.vcore.utils` | Kernel utilities |
| `org.modelio.vcore.utils.jdbm` | JDBM database utilities |
| `org.modelio.vcore.utils.metamodel.experts` | Metamodel expert utilities |
| `org.modelio.vcore.utils.metamodel.experts.links` | Link creation experts |
| `org.modelio.vcore.utils.metamodel.experts.meta` | Meta-level experts |

## Setup Commands

### Build Module

```bash
cd core.kernel
# Load environment toolkit, modify the path as needed
source ../../../../../toolkit/env_toolkit.sh
mvn clean install
```

### Build With Dependencies

```bash
# Load environment toolkit, modify the path as needed
source ../../../../../toolkit/env_toolkit.sh
# Rebuild core.utils first if changed
mvn clean install -pl ../core.utils,. -amd
```

## Dependencies

### OSGi Bundle Dependencies

| Bundle | Purpose |
|--------|---------|
| `org.modelio.core.utils` | Base utilities |
| `org.eclipse.emf.ecore`  | EMF Ecore (reexported), only for EMF compatibility |
| `jdbm` | JDBM database (reexported) |

## Key Interfaces

### Model Element API (org.modelio.vcore.smkernel.mapi)

#### MObject - Base Model Element

```java
public interface MObject extends Comparable<MObject> {
    // Identity
    String getUuid();
    String getName();
    MClass getMClass();
    
    // Composition
    MObject getCompositionOwner();
    List<? extends MObject> getCompositionChildren();
    
    // Lifecycle
    void delete();
    boolean isDeleted();
    boolean isValid();
    
    // Status
    MStatus getStatus();
    
    // Visitor pattern
    Object accept(MVisitor v);
}
```

#### MClass - Metaclass Interface

```java
public interface MClass {
    String getName();
    String getQualifiedName();
    MMetamodelFragment getOrigin();
    
    // Attributes and dependencies
    MAttribute getAttribute(String name);
    List<MAttribute> getAttributes(boolean includeInherited);
    MDependency getDependency(String name);
    
    // Inheritance
    MClass getSuper();
    List<MClass> getSub(boolean recursive);
    boolean hasBase(MClass base);
    
    // Instantiation
    boolean isAbstract();
    boolean isCmsNode();
}
```

#### MMetamodel - Metamodel Access

```java
public interface MMetamodel {
    MClass getMClass(String qualifiedName);
    MClass getMClass(Class<? extends MObject> cls);
    Collection<MClass> getRegisteredMClasses();
    MMetamodelFragment getFragment(String name);
    Collection<MMetamodelFragment> getFragments();
}
```

### Internal Implementation (org.modelio.vcore.smkernel.meta)

#### SmMetamodel

The runtime metamodel implementation composed of metamodel fragments (UML, BPMN, Infrastructure ... ).

#### SmClass

Internal metaclass implementation with full metamodel manipulation capabilities.

## Code Navigation

### Finding Key Files

```bash
# Main API interfaces
ls src/org/modelio/vcore/smkernel/mapi/

# Metamodel implementation
ls src/org/modelio/vcore/smkernel/meta/

# Core SmObject implementation
cat src/org/modelio/vcore/smkernel/SmObjectImpl.java
```

### Key Source Files

| File | Description |
|------------------------|-------------|
| `mapi/MObject.java`    | Model element interface |
| `mapi/MClass.java`     | Metaclass interface |
| `mapi/MMetamodel.java` | Metamodel interface |
| `mapi/MAttribute.java` | Attribute interface |
| `mapi/MDependency.java` | Dependency/association interface |
| `mapi/MVisitor.java`   | Visitor pattern interface |
| `meta/SmMetamodel.java` | Metamodel implementation |
| `meta/SmClass.java`    | Metaclass implementation |
| `SmObjectImpl.java`    | Base model element implementation |
| `SmObjectData.java`    | Model element data storage |

## Code Style

### @objid Annotations

All persistent elements use `@objid` annotations for identity tracking:

```java
@objid ("001dc7ac-a714-1f4f-9c13-001ec947cd2a")
public interface MObject extends Comparable<MObject> {
    // ...
}
```

### Package Naming

- Public API: `org.modelio.vcore.smkernel.mapi.*`
- Internal implementation: `org.modelio.vcore.smkernel.*`
- Metamodel: `org.modelio.vcore.smkernel.meta.*`

### Interface vs Implementation

- **mapi** package = Public API interfaces for external consumers
- **smkernel** package = Internal implementation (SmXxx classes)

## File Organization

```
core.kernel/
├── META-INF/
│   └── MANIFEST.MF          # OSGi bundle manifest
├── build.properties         # Tycho build configuration
├── pom.xml                  # Maven configuration
├── src/
│   └── org/modelio/vcore/
│       ├── emf/             # EMF integration
│       ├── model/           # Model utilities
│       │   └── filter/      # Element filters
│       ├── smkernel/        # Kernel implementation
│       │   ├── mapi/        # PUBLIC API
│       │   │   ├── fake/    # Fake implementations
│       │   │   ├── modelshield/ # Validation
│       │   │   └── services/
│       │   ├── meta/        # Metamodel implementation
│       │   │   ├── descriptor/
│       │   │   ├── mof/
│       │   │   └── smannotations/
│       │   └── transaction/ # Transaction support
│       ├── swap/            # Memory swap
│       │   └── jmx/
│       └── utils/           # Kernel utilities
│           ├── jdbm/
│           └── metamodel/
│               └── experts/
└── doc/                     # Documentation
```

## Common Patterns

### Getting Metaclass

```java
MMetamodel metamodel = session.getMetamodel();
MClass classUmlClass = metamodel.getMClass("Standard.Class");
MClass packageClass = metamodel.getMClass("Standard.Package");
```

### Navigating Composition

```java
MObject element = ...;

// Get owner
MObject owner = element.getCompositionOwner();

// Get children
List<? extends MObject> children = element.getCompositionChildren();
```

### Using Visitor Pattern

```java
public class MyVisitor implements MVisitor {
    @Override
    public Object visitMObject(MObject obj) {
        // Process element
        return null;
    }
}

MObject element = ...;
element.accept(new MyVisitor());
```

### Checking Metaclass Hierarchy

```java
MClass elementClass = element.getMClass();
MClass baseClass = metamodel.getMClass("Standard.ModelElement");

if (elementClass.hasBase(baseClass)) {
    // element is a ModelElement
}
```

## Testing Instructions

### Run Tests

```bash
mvn test
```

### Test Focus Areas

- MObject lifecycle (creation, deletion, validation)
- Metaclass inheritance hierarchy
- Composition relationships
- Metamodel fragment registration
- Swap/unload behavior

### Using Fake Implementations

For unit testing without full metamodel:

```java
import org.modelio.vcore.smkernel.mapi.fake.*;

// Use fake classes for isolated testing
```

## Debugging Tips

### Model Element Issues

1. Check `isValid()` and `isDeleted()` status
2. Verify metaclass with `getMClass().getName()`
3. Check composition owner chain

### Metamodel Issues

1. Verify fragment registration in `SmMetamodel`
2. Check qualified name format: `Fragment.ClassName`
3. Verify inheritance hierarchy with `hasBase()`

### Memory/Swap Issues

Monitor via JMX beans in `org.modelio.vcore.swap.jmx`

## Dependencies Graph

```
org.modelio.core.utils
        ↓
org.modelio.core.kernel (this module)
        ↓
  Used by: core.session, core.metamodel.api, core.project
```

## Notes for Code Changes

1. **API Stability**: `mapi` package is public API - changes require careful consideration
2. **Thread Safety**: SmObjectImpl and SmObjectData have threading considerations
3. **Memory Management**: Large models use swap - be aware of memory patterns
4. **Transaction Awareness**: Model modifications should occur within transactions
5. **Composition Integrity**: Maintain composition tree consistency
