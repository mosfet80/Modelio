# Phase 5: Repeat + Budgets/Truncation - Context

**Gathered:** 2026-02-23
**Status:** Ready for planning

<domain>
## Phase Boundary

Implement the `Repeat` step execution with cycle-safety, enforce execution budgets (`limit`, `timeoutMs`, `maxDepth`), and report truncation with diagnostics. The authoritative spec is `/work/modelio/alouette/work/other/modelio-query-language/specs/MQL-spec-technical.md` (sections §3.4.5, §3.6, §5.1, §5.2). The old split specs under `core.query/specs/technical/` are outdated — ignore RepeatPolicy, AllSimple, Edge/Path uniqueness from those files.

</domain>

<decisions>
## Implementation Decisions

### Repeat Scope for v1

- **Node-unique only**: the only uniqueness mode is "Node" — do not revisit a node already in the global visited set. No Edge or Path uniqueness modes.
- **Streaming DFS-push**: Repeat follows the same push-based Consumer chain pattern as other steps. No BFS wavefront. For each input item, recursively execute the body, pushing each newly-discovered node downstream immediately.
- **Source NOT included in results**: the source/input node entering the Repeat step is NOT emitted as a result. Only nodes discovered by executing the body (depth ≥ 1) are pushed downstream.
- **Boolean `emitAllDepths` option**: a new boolean option on RepeatStep (default `true`). When `true`, nodes at every depth are emitted. When `false`, only frontier nodes (deepest reached) are emitted. **Update the spec** to reflect this new option.
- **Global visited set**: if a query has multiple Repeat steps, the visited-node set (by UUID) is shared across all of them.
- **maxDepth semantics**: `null` = unlimited (no depth bound, only visited-set terminates). Values `< 1` are illegal → reject with error diagnostic. Value `1` is suspicious → emit a WARNING diagnostic.
- **Streaming DFS-push is preferred but flexible**: the DFS-push algorithm may be replaced during planning/implementation if a different algorithm proves simpler or more performant. The other five decisions above (node-unique, source excluded, emitAllDepths, global visited set, maxDepth semantics) are locked.

### Budget Enforcement Behavior

- **Default values**: `limit` defaults to 1000 items, `timeoutMs` defaults to 60000ms (1 minute) when not specified.
- **Limit counted at response filler**: the `limit` (max items) is enforced by counting items pushed into the response filler (post-dedup), not at intermediate pipeline stages.
- **Timeout via periodic nanoTime check**: the executor checks `System.nanoTime()` periodically during push processing. When elapsed time exceeds `timeoutMs`, stop accepting items.
- **First-hit-wins**: when multiple budgets could fire near-simultaneously, no priority ordering — the first one detected wins and triggers truncation.

### Truncation Diagnostics

- **Single INFO diagnostic**: when any budget is hit, produce one `INFO`-level diagnostic with a human-readable cause message (e.g., "Execution truncated: result limit (1000) reached" or "Execution truncated: timeout (5000ms) exceeded").
- **Single generic DiagnosticCode**: use one `EXECUTION_TRUNCATED` code (not per-budget-type codes). The message text distinguishes the cause.
- **No runtime stats in diagnostic**: stats (visited count, time elapsed) are deferred to a future version's response stats model.

### Cycle Handling & Diagnostics

- **Path-stack cycle detection**: during DFS-push recursion, if a node is already on the current recursion stack (ancestor in the DFS path), that's a cycle. This is distinct from the global visited set.
- **Skip + WARNING diagnostic**: when a cycle is detected, skip the cyclic node (don't recurse further) and add a WARNING diagnostic.
- **Deduplicate by closing node**: if the same cycle closing node is encountered multiple times, only one diagnostic is emitted.
- **Closing node in elements**: the diagnostic's `elements` list contains the closing node. If it's easy to include the full cycle path, do so; otherwise closing node is sufficient for v1.

### Copilot's Discretion

- **PathOutput performance**: PathOutput is currently a record, meaning extending a path copies all nodes+steps. For deep repeats this is costly. Copilot may refactor PathOutput to an interface with a linked-list/parent-pointer internal representation, or keep the record if performance is acceptable. User defers this decision.
- **Algorithm details**: the DFS-push approach is preferred but Copilot may choose a different traversal algorithm if it proves simpler or more performant during implementation. All behavioral decisions (node-unique, source excluded, emitAllDepths, global visited set, maxDepth semantics) remain locked regardless of algorithm choice.

</decisions>

<specifics>
## Specific Ideas

- **Update the spec**: add `emitAllDepths` boolean to RepeatStep in `/work/modelio/alouette/work/other/modelio-query-language/specs/MQL-spec-technical.md` §3.4.5.
- **Update Q8 example**: remove the source node (Customer at depth 0) from the Q8 example output since source is not included in Repeat results.
- The old split specs (`core.query/specs/technical/`) should NOT be treated as authoritative. The single-file spec is the source of truth.
- Reference queries Q6, Q7, Q8, Q12, Q15 exercise Repeat and should be the primary acceptance targets.

</specifics>

<deferred>
## Deferred Ideas

- **Response stats model**: runtime stats (visited count, time elapsed, depth reached) as a structured object on the response — future version.
- **Edge/Path uniqueness modes**: niche usage, not needed for v1.
- **AllSimple / Shortest path modes**: the old spec's path enumeration modes are dropped from v1.

</deferred>

---

_Phase: 05-repeat-budgets-truncation_
_Context gathered: 2026-02-23_
