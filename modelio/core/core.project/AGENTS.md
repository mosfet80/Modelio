# AGENTS.md - core.project

## Module Overview

**Bundle Name**: Project  
**Artifact ID**: `org.modelio.core.project`  
**Bundle Symbolic Name**: `org.modelio.core.project`

This module provides the **project management layer** for Modelio. It sits above `core.session` and provides project-level abstractions including project structure, modules, fragments, and RAMC (Reusable Asset Model Component) support.

### Purpose

- Project lifecycle management (`GProject`, `IGProject`)
- Project parts management (fragments, modules, resources)
- Module runtime cache and loading
- Project migration support
- Model copy and import utilities
- Project locking and monitoring
- Authentication and catalog services

## Package Structure

| Package                                    | Description                                 |
|--------------------------------------------|---------------------------------------------|
| `org.modelio.gproject`                     | Root project classes and exceptions         |
| `org.modelio.gproject.auth`                | Project authentication                      |
| `org.modelio.gproject.catalog`             | Element catalog services                    |
| `org.modelio.gproject.copy`                | Model copy utilities                        |
| `org.modelio.gproject.core`                | Core project interfaces (IGProject, IGPart) |
| `org.modelio.gproject.env`                 | Project environment                         |
| `org.modelio.gproject.importer`            | Model import support                        |
| `org.modelio.gproject.importer.core`       | Core import utilities                       |
| `org.modelio.gproject.importer.defaultimporter` | Default importer                       |
| `org.modelio.gproject.lock`                | Project locking mechanism                   |
| `org.modelio.gproject.migration`           | Project migration support                   |
| `org.modelio.gproject.module`              | Module management                           |
| `org.modelio.gproject.monitor`             | Project monitoring                          |
| `org.modelio.gproject.mtools`              | Model tools (merge, auth)                   |
| `org.modelio.gproject.parts`               | Project parts (fragments, modules)          |
| `org.modelio.gproject.parts.feature`       | Feature parts                               |
| `org.modelio.gproject.parts.fragment`      | Fragment parts                              |
| `org.modelio.gproject.parts.module`        | Module parts                                |
| `org.modelio.gproject.parts.resource`      | Resource parts                              |
| `org.modelio.gproject.plugin`              | Plugin activation                           |
| `org.modelio.gproject.project`             | Project implementation                      |
| `org.modelio.gproject.ramc`                | RAMC support                                |
| `org.modelio.gproject.ramc.core.model`     | RAMC model                                  |
| `org.modelio.gproject.ramc.core.packaging` | RAMC packaging                              |
| `org.modelio.gproject.rtcache`             | Runtime cache                               |

## Setup Commands

### Build Module

```bash
cd core.project
mvn clean install
```

### Build With All Dependencies

```bash
# Rebuild all core dependencies
# - `-pl`: Specifies the list of modules to build. The modules listed are:
# - `-amd` (also make dependents): also build any modules that depend on the ones specified with `-pl`.
mvn clean install -pl ../core.utils,../core.kernel,../core.session,../core.metamodel.api,. -amd
```

## Dependencies

### OSGi Bundle Dependencies

| Bundle | Purpose |
|--------|---------|
| `org.modelio.core.store.exml` | EXML model storage |
| `org.modelio.core.session` | Session management |
| `org.modelio.core.metamodel.api` | Metamodel API |
| `org.modelio.core.metamodel.impl` | Metamodel implementation |
| `org.modelio.core.project.data` | Project data structures |
| `org.modelio.core.utils` | Base utilities |
| `org.modelio.core.kernel` | Kernel APIs |
| `org.modelio.version` | Version utilities |
| `practicalxml` | XML utilities |
| `org.eclipse.emf.ecore` | EMF Ecore |

## Key Interfaces

### IGProject - Project Interface

```java
public interface IGProject {
    // Identity
    String getName();
    ProjectType getType();
    Version getModelioVersion();
    
    // Session access
    ICoreSession getSession();
    SmMetamodel getMetamodel();
    
    // Parts management
    Collection<IGPart> getParts();
    IGPart getPart(String id);
    void addPart(IGPart part);
    void removePart(IGPart part);
    
    // Lifecycle
    void open(IModelioProgress monitor);
    void save(IModelioProgress monitor);
    void close();
    
    // State
    GProjectStateEnum getState();
    Collection<GProblem> getProblems();
}
```

### GProject - Project Implementation

```java
public class GProject extends AbstractGProject {
    // Project descriptor
    GProjectDescriptor getDescriptor();
    
    // Environment
    IGProjectEnv getEnvironment();
    
    // Module cache
    IModuleRTCache getModuleCache();
    
    // Monitoring
    void addMonitor(IProjectMonitor monitor);
    void removeMonitor(IProjectMonitor monitor);
}
```

### IGPart - Project Part Interface

```java
public interface IGPart {
    // Identity
    String getId();
    GProjectPartType getType();
    
    // Lifecycle
    void open(IModelioProgress monitor) throws GPartException;
    void close() throws GPartException;
    void save(IModelioProgress monitor) throws GPartException;
    
    // State
    boolean isOpen();
    Collection<GProblem> getProblems();
}
```

### Project Part Types

| Type      | Description                        |
|-----------|------------------------------------|
| `FRAGMENT`| Model fragment (local or remote)   |
| `MODULE`  | Modelio module                     |
| `RESOURCE`| Project resource                   |
| `FEATURE` | Feature plugin                     |

## Code Navigation

### Finding Key Files

```bash
# Project interfaces
ls src/org/modelio/gproject/core/

# Project implementation
ls src/org/modelio/gproject/project/

# Parts management
ls src/org/modelio/gproject/parts/

# Module support
ls src/org/modelio/gproject/module/
```

### Key Source Files

| File                               | Description                |
|------------------------------------|----------------------------|
| `core/IGProject.java`              | Project interface          |
| `project/GProject.java`            | Project implementation     |
| `core/IGPart.java`                 | Project part interface     |
| `parts/GPartFactory.java`          | Part factory               |
| `parts/fragment/*.java`            | Fragment implementation    |
| `parts/module/*.java`              | Module implementation      |
| `module/IModuleRTCache.java`       | Module runtime cache       |
| `migration/*.java`                 | Model Migration support    |
| `GProjectCreator.java`             | Project creation           |

## Code Style

### Package Naming

- Public API: `org.modelio.gproject.*`
- Core interfaces: `org.modelio.gproject.core.*`
- Implementation: `org.modelio.gproject.project.*`
- Parts: `org.modelio.gproject.parts.*`

### Exception Handling

Project-specific exceptions:

```java
// Authentication failure
throw new FragmentAuthenticationException(...);

// Conflict detected
throw new FragmentConflictException(...);

// Migration required
throw new FragmentMigrationNeededException(...);

// Migration failed
throw new MigrationFailedException(...);
```

## File Organization

```
core.project/
├── META-INF/
│   └── MANIFEST.MF          # OSGi bundle manifest
├── build.properties         # Tycho build configuration
├── pom.xml                  # Maven configuration
├── src/
│   └── org/modelio/gproject/
│       ├── GProjectCreator.java
│       ├── GProblem.java
│       ├── FragmentAuthenticationException.java
│       ├── FragmentConflictException.java
│       ├── FragmentMigrationNeededException.java
│       ├── MigrationFailedException.java
│       ├── auth/            # Authentication
│       ├── catalog/         # Element catalog
│       ├── copy/            # Model copy
│       ├── core/            # Core interfaces (IGProject, IGPart)
│       ├── env/             # Project environment
│       ├── importer/        # Model import
│       │   ├── core/
│       │   └── defaultimporter/
│       ├── lock/            # Project locking
│       ├── migration/       # Migration support
│       ├── module/          # Module management
│       ├── monitor/         # Project monitoring
│       ├── mtools/          # Model tools
│       │   └── merge/       # Model merge
│       ├── parts/           # Project parts
│       │   ├── feature/
│       │   ├── fragment/
│       │   ├── module/
│       │   └── resource/
│       ├── plugin/          # Plugin activation
│       ├── project/         # Project implementation
│       ├── ramc/            # RAMC support
│       │   └── core/
│       │       ├── model/
│       │       └── packaging/
│       │           └── filters/
│       └── rtcache/         # Runtime cache
└── res/
    ├── coreproject.properties
    ├── coreproject_fr.properties
    └── migration/           # Migration scripts
```

## Common Patterns

### Opening a Project

```java
// Create project
GProject project = GProjectCreator.create(
    projectPath,
    projectDescriptor,
    environment,
    monitor
);

// Open project
project.open(monitor);

// Access session
ICoreSession session = project.getSession();
```

### Working with Project Parts

```java
// Get all parts
Collection<IGPart> parts = project.getParts();

// Get fragments only
List<IGPart> fragments = parts.stream()
    .filter(p -> p.getType() == GProjectPartType.FRAGMENT)
    .collect(Collectors.toList());

// Add a new part
IGPart newPart = partFactory.create(descriptor);
project.addPart(newPart);
```

### Project Monitoring

```java
project.addMonitor(new IProjectMonitor() {
    @Override
    public void handleProjectEvent(GProjectEvent event) {
        // Handle project configuration changes
        switch (event.getType()) {
            case PART_ADDED:
                // Handle part addition
                break;
            case PART_REMOVED:
                // Handle part removal
                break;
            // ...
        }
    }
});
```

### Saving a Project

```java
try (ITransaction t = session.getTransactionSupport()
        .createTransaction("Modify project")) {
    // Make changes
    t.commit();
}

// Save project
project.save(monitor);
```

### Handling Project Problems

```java
Collection<GProblem> problems = project.getProblems();
for (GProblem problem : problems) {
    Log.warning("Project problem: %s", problem.getMessage());
}
```

## Testing Instructions

### Run Tests

```bash
mvn test
```

### Test Focus Areas

- Project creation and opening
- Project part management
- Module loading and caching
- Project migration
- Lock/unlock behavior
- Save/close lifecycle

## Debugging Tips

### Project Opening Issues

1. Check project descriptor validity
2. Verify all required parts are accessible
3. Check authentication for remote fragments
4. Look for migration requirements

### Part Issues

1. Check part state with `isOpen()`
2. Verify part problems with `getProblems()`
3. Check part type matches expected

### Module Issues

1. Verify module cache initialization
2. Check module compatibility with project version
3. Verify module dependencies

### Migration Issues

1. Check `FragmentMigrationNeededException`
2. Review migration scripts in `res/migration/`
3. Verify source and target versions

## Dependencies Graph

```
org.modelio.core.utils
        ↓
org.modelio.core.kernel
        ↓
org.modelio.core.session
        ↓
org.modelio.core.metamodel.api
        ↓
org.modelio.core.project (this module)
        ↓
  Used by: application modules, UI layers
```

## Notes for Code Changes

1. **Project Descriptor Compatibility**: Changes may affect existing projects
2. **Migration Scripts**: Major changes may require migration support
3. **Part Lifecycle**: Respect open/close ordering
4. **Module Compatibility**: Consider module version requirements
5. **Lock Handling**: Properly acquire and release project locks
6. **Error Reporting**: Use `GProblem` for user-visible issues
7. **Monitoring Events**: Fire appropriate events for configuration changes
