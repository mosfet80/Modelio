# Phase 2: Resolver (Unresolved → Resolved) - Context

**Gathered:** 2026-02-09
**Status:** Ready for planning
**Revised:** 2026-02-12 (added general step resolution decision)

<domain>

## Phase Boundary

Convert the public query AST into the internal resolved model using metamodel + stereotype/type registries.
Resolution must expand ambiguous names into explicit alternatives and emit diagnostics; unknown references must not crash execution and must result in safe behavior.

</domain>

<decisions>

## Implementation Decisions

### General step resolution (NEW since 2026-02-12)

Each step must also resolve its output kind based on the input kind and step semantics.
This will reduce alternatives for subsequent steps. It requires the query resolver to carry the resolved kind reference of the previous step and use it during resolution of the next step.

### Kind resolution (metaclass + stereotype)

- Resolution searches **both metaclasses and stereotypes** for the provided kind string.
- If both a metaclass and a stereotype match the same kind string, this is **an ambiguity** and must expand into **explicit alternatives**.
- V1 input normalization: **trim only** (no case folding). Matching stays **case-sensitive**.
- V1 stereotype reference syntax: **`StereotypeName` only**.
  - No `ModuleName.StereotypeName` syntax in V1.
  - No `<<Stereotype>>` syntax in V1.
- Stereotype names **may contain dots**; a dot in a kind string is not reserved as a qualifier.

### Edge resolution (dependencies + links + link stereotypes)

- Edge resolution searches **all relevant mechanisms at once** (metamodel dependency, link metaclass traversal, link stereotypes) and treats multiple matches as **ambiguity → alternatives**.
- Default traversal direction is **forward**.

### Property key resolution (attributes/tags/notes/property-definitions)

- When a property key can match multiple categories (attribute/tag/note/property-definition), the resolver must **keep all alternatives** (no precedence winner).

### Dots in names

- Dots are legal in kind keys, edge keys, and property keys.
- Note: no `MDependency` has a dot in its name (so dots will not collide with dependency names, but they may appear in other namespaces like stereotypes).

### Copilot's Discretion

- Exact ranking/order of alternatives in outputs (must be deterministic, but ordering rule is flexible).
- Exact registry lookup strategy, as long as it conforms to the decisions above and Phase 2 success criteria.

</decisions>

<specifics>
## Specific Ideas

- V1 deliberately keeps parsing simple; richer stereotype reference syntax is deferred.

</specifics>

<deferred>
## Deferred Ideas

- Add support for `ModuleName.StereotypeName` stereotype references.
- Add support for guillemet forms: `<<StereotypeName>>` and `<<ModuleName.StereotypeName>>`.
- Consider case-insensitive matching (beyond trim-only normalization).

</deferred>

---

_Phase: 02-resolver_
_Context gathered: 2026-02-09_
