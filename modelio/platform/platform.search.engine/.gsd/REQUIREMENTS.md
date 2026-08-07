# Milestone v1.1 Requirements

Shipped: v1.0 executed single explanation path per result.
New: v1.1 collects ALL explanation paths per result with bounded enumeration.

## Active Requirements

### REQ-1: Multi-path API

- [x] **REQ-1-01**: Change `NodeWithExplainOut.why: PathOutput` → `whyPaths: Collection<PathOutput>` (LinkedHashSet)
  - Record field renamed for clarity
  - Validation: whyPaths must be non-empty
  - Convenience method: `getSinglePath()` for backward-compat helpers

### REQ-2: Path Collection Engine

- [x] **REQ-2-01**: Accumulate paths per result node in pipeline terminal consumer
  - `StepPipelineExecutor.buildPipeline()` buffers by node-UUID
  - Flushes accumulated paths when moving to new node or on completion
  - Preserves insertion order (LinkedHashSet)

- [x] **REQ-2-02**: Deduplicate paths by sequence (node traversal route)
  - Override `PathOutput.equals()/hashCode()` for sequence comparison
  - Two identical paths from different routes coalesce into one

- [ ] **REQ-2-03**: Enumerate paths within budget constraints
  - Path enumeration counts toward existing result LIMIT budget
  - Timeout breaks mid-accumulation; partial paths OK
  - Set truncation flag on response if collection interrupted

### REQ-3: Budget & Performance

- [ ] **REQ-3-01**: Timeout handling during path enumeration
  - Check `ExecutionBudget.isExhausted()` between each path accumulation
  - Push accumulated results on timeout with truncation flag
  - Maintain deterministic behavior across runs

### REQ-4: Test Coverage

- [ ] **REQ-4-01**: Update acceptance tests Q1-Q15 for multiple paths
  - Change assertions from `result.why != null` → `result.whyPaths.size() >= 1`
  - Add test: cyclic graph produces N paths per result node
  - Verify path dedup (identical sequences coalesce)

- [ ] **REQ-4-02**: Jackson serialization handles `Collection<PathOutput>`
  - Update test expectations for JSON structure
  - Round-trip verification: serialize → deserialize → paths intact

- [ ] **REQ-4-03**: API contract tests
  - `whyPaths` never empty (validated in record constructor)
  - Paths maintain order across serialization
  - Multi-path results are reproducible (same query = same path set)

## Future Requirements (v1.2+)

- UI result display with multi-path expansion
- Separate path budget (e.g., max 10 paths per node)
- Path dedup strategy configuration (strict vs lenient)
- Cursor pagination for large path sets

## Out of Scope (v1.1)

| Feature | Reason |
|---------|--------|
| Textual path syntax in diagnostics | Deferred to v2 |
| Path ranking/scoring | No user priority given |
| Async path enumeration UI updates | Display layer, not v1.1 |
| Path compression (common prefix merging) | Complexity vs benefit unclear |

---

**Requirements Count:** 8
**Traceability:** Will be mapped to phases during roadmap creation
**Last updated:** 2026-05-18

