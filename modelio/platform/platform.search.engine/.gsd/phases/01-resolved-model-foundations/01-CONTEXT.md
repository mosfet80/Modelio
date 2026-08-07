# Phase 1: Resolved Model Foundations - Context

**Gathered:** 2026-02-06
**Status:** Planned (ready to execute)

<domain>
## Phase Boundary

Define an internal resolved query model that is close to executable semantics.

- The resolved model must be able to represent ambiguity as explicit alternatives (unions).
- The resolved model should be grounded in Modelio kernel/metamodel handles where applicable.
- This phase defines internal types and shared primitives; resolution logic itself is Phase 2.

</domain>

<decisions>
## Implementation Decisions

### Resolved model fidelity ("close to executable")

- Use **direct kernel/metamodel handles** in resolved references where possible:
  - `MClass`, `Stereotype`, `MDependency`
  - For element properties: direct references to `MAttribute`, `TagType`, `PropertyDefinition`, `NoteType`
- The resolved model should already be able to represent **edge kind** (dependency vs link-object) and **direction** (forward/backward/both) as part of its types.
- The resolved model should already model the **property category** (attribute vs tag vs note vs property-definition) via the concrete handle type above.
- Immutability is **preferred but not a hard constraint** for Phase 1.

### Ambiguity representation (always expand)

- Ambiguity should **always expand** into explicit alternatives in the resolved model.
- No pruning rule is required at this stage (duplicates are not expected).
- Alternative ordering does **not** need to be guaranteed by design (determinism not a hard requirement for now).
- Unknown references should resolve to **empty alternatives** and emit a **warning diagnostic**.
- Carrying a plain **list of alternatives** is sufficient for v1 (no extra “why these alternatives” metadata required yet).

### Diagnostics primitives (severity + location + related elements)

- Diagnostics should capture:
  - **Severity**
  - **Location** when available
  - **Related model elements** (as `MObject` where applicable)
  - **Human message**
- Public result DTO currently supports severity levels `info|warning|error`. A potential `debug` level is **not decided**; changing the public API is acceptable if needed, but should be treated as a deliberate compatibility decision.
- Location is acceptable as **embedded into the diagnostic message** (e.g., `step[2]/filter: ...`) while keeping a structured internal location for engine use.
- For metamodel-only diagnostics (e.g., ambiguous `MClass`/`MDependency`/`Stereotype`), it is fine to have `elements=[]`.
- Cap diagnostic related elements list to **500** to avoid oversized payloads.

### Copilot's Discretion

- Whether and where to introduce strict ordering for alternatives (can be revisited when tests/UX need it).
- Exact internal representation of “location” (as long as it can be rendered in messages).
- Exact immutability approach (records vs classes) consistent with existing code style.

</decisions>

<specifics>
## Specific Ideas

- Resolved model types should be “ready-to-run” by construction: references are already the concrete kernel/metamodel handles (`MClass`, `MDependency`, `Stereotype`, `MAttribute`, `TagType`, `PropertyDefinition`, `NoteType`).
- Ambiguity is represented as explicit union alternatives (engine semantics execute union).

</specifics>

<deferred>
## Deferred Ideas

- Adding a `debug` severity (beyond `info|warning|error`) in the public `Diagnostic` DTO.
- Adding a structured public “location” field to `Diagnostic` (would be a compatibility and serialization decision).

</deferred>

---

_Phase: 01-resolved-model-foundations_
_Context gathered: 2026-02-06_
