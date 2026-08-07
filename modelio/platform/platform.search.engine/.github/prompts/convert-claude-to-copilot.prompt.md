---
name: "convert-claude-to-copilot"
description: "Convert Claude/Anthropic-style Task() orchestration to GitHub Copilot runSubagent() syntax"
tools: [vscode/askQuestions, read/readFile, edit/editFiles, search, todo]
---

<objective>
Transform Claude-style LLM orchestration patterns to GitHub Copilot / VS Code runSubagent() semantics.

Use on any markdown prompt file that contains:
- `Task(...)` function calls
- `subagent_type=...` keyword
- `"@..."` file reference patterns
- Task-boundary limitation wording
- Model selection syntax
- Anthropic-specific attribution/branding
- HumanAgent MCP references

Output: Copilot-compatible prompt file with runSubagent() calls and ask_questions tool usage.
</objective>

<input>
**File to convert:** {file_path}

Scan for Claude-style patterns and systematically convert.
</input>

<process>

## 1. Pattern Inventory

Scan the file for these Claude-style patterns:

```
Task(
  prompt="...",
  subagent_type="...",
  model="{...}",
  description="..."
)
```

Also scan for HumanAgent MCP patterns:

```
HumanAgent MCP
(HumanAgent_Chat)
use_tool(name="...")
```

Record each occurrence with line numbers.

## 2. Subagent Type Mapping

Map `subagent_type` values to Copilot `agentName`:

| `subagent_type` | `agentName` |
|---|---|
| `general-purpose` + context clues (researcher) | `"🔬 GSD Phase Researcher"` |
| `general-purpose` + context clues (planner) | `"📋 GSD Planner"` |
| `general-purpose` + context clues (executor) | `"⚡ GSD Executor"` |
| `general-purpose` + context clues (checker) | `"✅ GSD Plan Checker"` |
| `general-purpose` + no context clue | the default agent |
| `gsd-executor` | `"⚡ GSD Executor"` |
| `gsd-planner` | `"📋 GSD Planner"` |
| `gsd-phase-researcher` | `"🔬 GSD Phase Researcher"` |
| `gsd-plan-checker` | `"✅ GSD Plan Checker"` |
| Other values | Use as-is or infer from agent file name |

Use context (surrounding description, file references, prompt content) to disambiguate `general-purpose` cases.

## 3. Task() → runSubagent() Conversion

Replace each `Task(...)` block:

**FROM:**
```
Task(
  prompt="CONTENT",
  subagent_type="TYPE",
  model="{model_var}",
  description="DESC"
)
```

**TO:**
```
runSubagent(
  agentName: "AGENT_NAME",
  description: "DESC",
  model: "{model_var}",
  prompt: "CONTENT"
)
```

**Rules:**
- Field order: `agentName`, `description`, `model`, `prompt` (for readability)
- Keep model: property as-is for forward compatibility (unless explicitly None)
- Preserve prompt text verbatim
- If prompt prepends "First, read .github/agents/..." → comment that line with fallback note (see step 5)
- Preserve line-by-line formatting (don't collapse multi-line prompts)

## 4. HumanAgent MCP → ask_questions Tool Conversion

**Pattern 1: Simple mention**

| OLD | NEW |
|---|---|
| "use HumanAgent MCP" | "use the `ask_questions` tool" |
| "use (HumanAgent_Chat)" | "use the `ask_questions` tool" |
| "HumanAgent MCP tool" | "`ask_questions` tool" |
| "via HumanAgent" | "via the `ask_questions` tool" |

**Pattern 2: Claude use_tool → ask_questions (Multiple Choice)**

TOOL LIMITATION: The real Copilot `ask_questions` tool:
- Takes an array of questions (1-4 per call)
- Requires a `header` (max 12 chars) + `question` text
- Supports optional `options` array (0-6 choices)
- Has NO `context` or `format` parameters

**FROM (Claude):**
```
use_tool(
  name="HumanAgent_Chat",
  system_prompt="You are a decision helper...",
  user_message="What authentication method?",
  expected_format="json"
)
```

**TO (Copilot - Decision Scenario):**
```
ask_questions({
  questions: [
    {
      header: "Auth method",
      question: "What authentication method should we use?",
      allowFreeformInput: true, // if freeform input is expected
      options: [
        { label: "JWT", description: "Simple token-based" },
        { label: "OAuth2", description: "Third-party integration" },
        { label: "SAML", description: "Enterprise SSO" }
      ]
    }
  ]
})
```

**Conversion Rules for Structured Decisions:**
- `name="HumanAgent_Chat"` → (remove, implicit in `ask_questions`)
- `user_message` → `question` text
- `system_prompt` → (discard; not supported; bake context into question text if needed)
- `expected_format="json"` → (discard; responses are structured by design)
- Create `header` (max 12 chars) from context and `system_prompt`
- Create `options` array from content that describes choices
- Extract `label` from choice names, `description` from explanations

**Conversion Rules for Freeform/Information Gathering:**
- If the Claude prompt needs freeform text input (not multiple choice):
  - Use `allowFreeformInput: true` instead of options array
  - Keep question text clear and actionable
  - Example: `{ header: "Color", question: "Enter hex color code", allowFreeformInput: true }`

**Pattern 3: Multi-question Batching**

**FROM (Two separate Claude calls):**
```
use_tool(name="HumanAgent_Chat", user_message="Q1?")
use_tool(name="HumanAgent_Chat", user_message="Q2?")
```

**TO (Copilot - Batch into single call):**
```
ask_questions({
  questions: [
    {
      header: "Question1",
      question: "Q1?",
      options: [...]
    },
    {
      header: "Question2",
      question: "Q2?",
      options: [...]
    }
  ]
})
```

- Batch up to 4 related questions into single `ask_questions` call
- Each question still needs its own `header`, `question`, and optional `options`
- Use `multiSelect: true` only when user should pick multiple options
- Use `allowFreeformInput: true` for open-ended questions that also allow typed options

## 5. Wording Cleanup

Replace phrases:

| OLD | NEW |
|---|---|
| "across Task() boundaries" | "across agent boundaries" |
| "Task tool blocks until" | "runSubagent parallelization" |
| "Task calls" | "agent calls" |
| "Store resolved models for use in Task calls" | "Store resolved models for use in agent spawning" |
| "Spawn ... with a single message containing multiple Task calls" | "Spawn ... with parallel runSubagent calls" |
| "HumanAgent MCP for user interaction" | "`ask_questions` tool for user interaction" |
| "across Task boundaries" | "across agent boundaries" |

## 6. Agent Instruction File Handling

**Pattern:** `prompt="First, read .github/agents/gsd-xyz.agent.md..."`

If found, convert to:

```
  # Note: `agentName` should already load the agent instructions.
  # If your environment does NOT, prepend this line to the prompt:
  # "First, read .github/agents/gsd-xyz.agent.md for your role and instructions.\n\n"
  prompt: CONTENT_WITHOUT_PREFIX,
```

This makes prompts leaner by default but documents the fallback.

## 7. Model Parameter Handling

**Keep:** `model: "{planner_model}"`, `model: "{executor_model}"`, `model: "{PROFILE_MODEL}"`, etc. as forward-compatible hints.

**Remove or clarify:** If model value is hardcoded like `model="claude-opus"` → convert to variable placeholder `model: "{model_var}"` or comment with rationale.

## 8. File Reference Patterns

**Pattern:** `prompt="First, read {file-to-inline}" + "@file_reference"`

- If prompt already inlines content (`{variable_content}`), no action needed
- If references `@file` patterns inside prompt text, leave as-is (subagent tools can handle file reads)
- Remove redundant comments about "@file limitations across Task boundaries"

## 9. Formatting & Style

- Use 2-space indentation for JSON-like structure
- Keep multi-line prompts readable (no unnecessary collapsing)
- Use backticks for code blocks consistently
- Preserve all markdown structure outside these changes

## 10. Anthropic-Specific Removal

Remove or replace:

- `Co-Authored-By: ... @anthropic.com` → (replace with flexible version or placeholder comment)
- "Claude Code" references → "Copilot" or "GitHub Copilot"
- Copilot Opus / Sonnet hardcoded versions → keep as model profile variables

## 11. Validation Checklist

Before declaring complete:

- [ ] All `Task(...)` blocks converted to `runSubagent(...)`
- [ ] No remaining `subagent_type=` or `subagent_type:` lines
- [ ] All HumanAgent MCP / (HumanAgent_Chat) references converted to `ask_questions` tool
- [ ] All `use_tool(name="HumanAgent_Chat"...)` calls converted to `ask_questions({questions: [...]})` syntax
- [ ] Each question in `questions` array has: `header` (max 12 chars), `question` text, optional `options` array
- [ ] For freeform input: `allowFreeformInput: true` set (not generic prompts)
- [ ] Up to 4 questions batched per `ask_questions` call
- [ ] All wording updates applied (boundaries, model, Task → agent, HumanAgent → ask_questions)
- [ ] Agent instruction fallback comments in place
- [ ] Model parameters preserved
- [ ] Formatting consistent (readability maintained)
- [ ] File is valid markdown (no syntax breaks)

## 12. Output & Commit

**Action:** Save modified file back to disk.

**Report:**
```
## CONVERSION COMPLETE

**File:** {file_path}
**Task Blocks Converted:** {N}
**HumanAgent References Converted:** {H}
**Wording Updates:** {M}
**Validation:** ✓

Key Changes:
- Converted {N} Task(...) to runSubagent(...)
- Mapped {M} subagent_type values to agentName
- Converted {H} HumanAgent MCP / (HumanAgent_Chat) to ask_questions tool
- Updated {P} structured parameter blocks (Claude → Copilot syntax)
- Updated Task-boundary wording ({K} occurrences)
- Preserved {R} model parameters

Validation checklist: ✓ PASSED
```

</process>

<success_criteria>

- [ ] No `Task(...)` calls remain
- [ ] No `subagent_type` references remain
- [ ] No `HumanAgent MCP` or `(HumanAgent_Chat)` references remain
- [ ] No `use_tool(name="HumanAgent_Chat"...)` calls remain
- [ ] All `runSubagent(...)` blocks have agentName, description, model, prompt fields
- [ ] All `ask_questions(...)` calls use `questions: [...]` array structure
- [ ] Each question in array has `header` (max 12 chars) and `question` fields
- [ ] No `context` or `format` parameters used (not supported by real tool)
- [ ] `options` arrays properly structured for multiple choice (0-6 items)
- [ ] `allowFreeformInput: true` used for freeform text scenarios
- [ ] Up to 4 questions batched per `ask_questions` call
- [ ] Wording reflects Copilot / agent / ask_questions semantics
- [ ] Agent instruction file handling done (comments where relevant)
- [ ] Model parameters preserved
- [ ] File is valid markdown
</success_criteria>
- [ ] Model parameters preserved
- [ ] File is valid markdown
- [ ] No Anthropic-specific hardcoding remains
</success_criteria>
