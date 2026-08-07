# Phase 4: Core Semantics (Filter/Traverse/Union + Explain + Dedup) - Context

**Gathered:** 2026-02-20
**Status:** Ready for planning

<domain>
## Phase Boundary

This phase implements core MQL execution semantics for filter, traverse, union, explanation path (`why`), and deterministic deduplication of results. It clarifies behavior of these existing capabilities only (no new capability expansion).

</domain>

<decisions>
## Implementation Decisions

### Filter behavior

- If a property referenced by a filter does not exist on an element, exclude the element.
- `null` comparisons are permissive (absence/empty treated equivalently for this phase).
- Ambiguous property alternatives in filters use implicit OR semantics.
- Diagnostics verbosity default is balanced.

### Traverse behavior

- Default traversal output order follows discovery/insertion order from execution.
- Missing/unavailable expected links in traversal are ignored silently.
- Mixed forward/backward directions are allowed when explicitly set by each traverse step.
- For first-pass path selection, keep the first discovered path.
- Cardinality limiting remains query-driven (via existing `LimitSpec`), not hardwired at step level.
- For invalid/deleted elements encountered during traversal, filter them out and emit warning diagnostics.
- If requested direction cannot produce a valid traversal (eg incompatible direction on dependency), treat it as an error.

### Explain (`why`) output

- Primary purpose is audit/traceability.
- Explanation path includes source origin.
- Keep compact explanation: retain passing path steps only.
- Keep API data split as designed: visited nodes in `PathOutput.nodes`, traversed link/dependency steps in `PathOutput.steps`.

### Deduplication policy

- Deduplicate using model element identity semantics (`MObject.equals(...)`).
- Keep one result item per deduplicated node and one explanation path.
- If multiple paths reach the same node, keep first discovered path.
- No dedicated dedup diagnostic in V1.

### Copilot's Discretion

- Exact wording and payload details of balanced diagnostics messages.
- Precise error mapping for incompatible-direction edge cases (while preserving the behavior decision above).
- Internal algorithmic mechanics used to preserve discovery order deterministically.

</decisions>

<specifics>
## Specific Ideas

- Keep behavior aligned with existing result model intent (`NodeWithExplainOut` + `PathOutput`).
- Maintain explicit separation between node sequence and path-step sequence in explanations.

</specifics>

<deferred>
## Deferred Ideas

- Optional diagnostic mode for missing properties in filter evaluation (future version).

</deferred>

---

_Phase: 04-core-semantics-filter-traverse-union-explain-dedup_
_Context gathered: 2026-02-20_
