---
name: "gsd:verify-work"
description: "Validate built features through conversational UAT"
tools:
  ['vscode/askQuestions', 'execute/getTerminalOutput', 'execute/awaitTerminal', 'execute/killTerminal', 'execute/runInTerminal', 'read/readFile', 'agent', 'edit/createDirectory', 'edit/createFile', 'edit/editFiles', 'search/listDirectory', 'search/textSearch']
argument-hint: phase number (optional, e.g. "4"); already found problems (optional)
---

<objective>
Validate built features through conversational testing with persistent state.

Purpose: Confirm what Copilot built actually works from user's perspective. One test at a time, plain text responses. When issues are found, automatically diagnose, plan fixes, and prepare for execution.

Output: {phase}-UAT.md tracking all test results. If issues found: diagnosed gaps, verified fix plans ready for /gsd-execute-phase
</objective>

<CRITICAL_CONSTRAINT>
## 🚫 CRITICAL CONSTRAINT — VIOLATIONS RESULT IN RESTART

If you detect that problems have been presented to you in the prompt:

1. **BEFORE reading problem details**, you MUST:
   - Set a flag: `VERIFY_MODE_ACTIVE = true`
   - Disable all tools: `fix`, `edit`, `refactor`, `implement`
   - Load ONLY: `read_file`, `ask_questions`, `create_file` (for UAT.md updates)

2. **If you accidentally generate fix code**, you have violated the contract.
   - User will respond: `/gsd-verify-work`
   - All progress is lost
   - You start over from the beginning

3. **Proof of compliance**: Every response must start with:
[VERIFY_MODE ✓ | TOOLS: UAT logging only]
</CRITICAL_CONSTRAINT>

<execution_context>
../skills/verify-work/SKILL.md
@.gsd/templates/UAT.md
</execution_context>

<context>
Phase: $ARGUMENTS (optional)
- If provided: Test specific phase (e.g., "4")
- If not provided: Check for active sessions or prompt for phase

@.gsd/STATE.md
@.gsd/ROADMAP.md
</context>

<process>
1. Check for active UAT sessions (resume or start new)
2. Find SUMMARY.md files for the phase
3. Extract testable deliverables (user-observable outcomes)
4. Create {phase}-UAT.md with test list
5. Present tests one at a time:
   - Show expected behavior
   - Wait for plain text response
   - "yes/y/next" = pass, anything else = issue (severity inferred)
6. Update UAT.md after each response
7. On completion: commit, present summary
8. If issues found:
   - Spawn parallel debug agents to diagnose root causes
   - Spawn gsd-planner in --gaps mode to create fix plans
   - Spawn gsd-plan-checker to verify fix plans
   - Iterate planner ↔ checker until plans pass (max 3)
   - Present ready status with `/clear` then `/gsd-execute-phase`
</process>

<anti_patterns>
- Don't ask severity — infer from description
- Don't present full checklist upfront — one test at a time
- Don't run automated tests — this is manual user validation
- Don't fix issues during testing — log as gaps, diagnose after all tests complete
</anti_patterns>

<offer_next>
Output this markdown directly (not as a code block). Route based on UAT results:

| Status                          | Route                         |
| ------------------------------- | ----------------------------- |
| All tests pass + more phases    | Route A (next phase)          |
| All tests pass + last phase     | Route B (milestone complete)  |
| Issues found + fix plans ready  | Route C (execute fixes)       |
| Issues found + planning blocked | Route D (manual intervention) |

---

**Route A: All tests pass, more phases remain**

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
GSD ► PHASE {Z} VERIFIED ✓
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

**Phase {Z}: {Name}**

{N}/{N} tests passed
UAT complete ✓

───────────────────────────────────────────────────────────────

## ▶ Next Up

**Phase {Z+1}: {Name}** — {Goal from ROADMAP.md}

/gsd-discuss-phase {Z+1} — gather context and clarify approach

<sub>/clear first → fresh context window</sub>

───────────────────────────────────────────────────────────────

**Also available:**

- /gsd-plan-phase {Z+1} — skip discussion, plan directly
- /gsd-execute-phase {Z+1} — skip to execution (if already planned)

───────────────────────────────────────────────────────────────

---

**Route B: All tests pass, milestone complete**

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
GSD ► PHASE {Z} VERIFIED ✓
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

**Phase {Z}: {Name}**

{N}/{N} tests passed
Final phase verified ✓

───────────────────────────────────────────────────────────────

## ▶ Next Up

**Audit milestone** — verify requirements, cross-phase integration, E2E flows

/gsd-audit-milestone

<sub>/clear first → fresh context window</sub>

───────────────────────────────────────────────────────────────

**Also available:**

- /gsd-complete-milestone — skip audit, archive directly

───────────────────────────────────────────────────────────────

---

**Route C: Issues found, fix plans ready**

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
GSD ► PHASE {Z} ISSUES FOUND ⚠
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

**Phase {Z}: {Name}**

{N}/{M} tests passed
{X} issues diagnosed
Fix plans verified ✓

### Issues Found

{List issues with severity from UAT.md}

───────────────────────────────────────────────────────────────

## ▶ Next Up

**Execute fix plans** — run diagnosed fixes

/gsd-execute-phase {Z} --gaps-only

<sub>/clear first → fresh context window</sub>

───────────────────────────────────────────────────────────────

**Also available:**

- cat .gsd/phases/{phase_dir}/\*-PLAN.md — review fix plans
- /gsd-plan-phase {Z} --gaps — regenerate fix plans

───────────────────────────────────────────────────────────────

---

**Route D: Issues found, planning blocked**

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
GSD ► PHASE {Z} BLOCKED ✗
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

**Phase {Z}: {Name}**

{N}/{M} tests passed
Fix planning blocked after {X} iterations

### Unresolved Issues

{List blocking issues from planner/checker output}

───────────────────────────────────────────────────────────────

## ▶ Next Up

**Manual intervention required**

Review the issues above and either:

1. Provide guidance for fix planning
2. Manually address blockers
3. Accept current state and continue

───────────────────────────────────────────────────────────────

**Options:**

- /gsd-plan-phase {Z} --gaps — retry fix planning with guidance
- /gsd-discuss-phase {Z} — gather more context before replanning

───────────────────────────────────────────────────────────────
</offer_next>

<success_criteria>

- [ ] UAT.md created with tests from SUMMARY.md
- [ ] Tests presented one at a time with expected behavior
- [ ] Plain text responses (no structured forms)
- [ ] Severity inferred, never asked
- [ ] Batched writes: on issue, every 5 passes, or completion
- [ ] Committed on completion
- [ ] If issues: parallel debug agents diagnose root causes
- [ ] If issues: gsd-planner creates fix plans from diagnosed gaps
- [ ] If issues: gsd-plan-checker verifies fix plans (max 3 iterations)
- [ ] Ready for `/execute-phase.md` when complete
</success_criteria>
