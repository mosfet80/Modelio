
# GSD for GitHub Copilot

A GitHub Copilot port of the [Get Shit Done](https://github.com/glittercowboy/get-shit-done) system by [glittercowboy](https://github.com/glittercowboy), based on the [Kilo Code fork](https://github.com/punal100/get-stuff-done-for-kilocode) by [punal100](https://github.com/punal100).

This project adapts GSD's powerful context engineering and spec-driven development workflow to work natively with [GitHub Copilot](https://github.com/features/copilot) using Custom Agents, Prompt Files, and Agent Skills.


Source: https://github.com/punal100/get-stuff-done-for-github-copilot

# Usage


## Installation

Enable GitHub Copilot customization features in VS Code settings :

```json
{
  "github.copilot.chat.codeGeneration.useInstructionFiles": true,
  "chat.promptFilesLocations": [".github/prompts"],
  "chat.instructionsFilesLocations": [".github/instructions"],
  "chat.customAgentInSubagent.enabled": true
}
```


## The Core Loop

1. **Initialize** — Define project, research domain, create roadmap
2. **Discuss** — Capture your implementation preferences
3. **Plan** — Research and create atomic task plans
4. **Execute** — Run plans with fresh context per task
5. **Verify** — Confirm goals were achieved, not just tasks completed



### 1. Initialize Project

> **Already have code ?** 
>
> Run first :
>  ```
>  /gsd-map-codebase
>  ``` 
> It spawns parallel agents to analyze your stack, architecture, conventions, and concerns. Then `/gsd-new-project` knows your codebase — questions focus on what you're adding, and planning automatically loads your patterns.

Execute in chat view :

```
/gsd-new-project
```

One command, one flow. The system:

1. **Questions** — Asks until it understands your idea completely (goals, constraints, tech preferences, edge cases)
2. **Research** — Spawns parallel agents to investigate the domain (optional but recommended)
3. **Requirements** — Extracts what's v1, v2, and out of scope
4. **Roadmap** — Creates phases mapped to requirements

You approve the roadmap. Now you're ready to build.

**Creates:** `PROJECT.md`, `REQUIREMENTS.md`, `ROADMAP.md`, `STATE.md`, `.planning/research/`

---

### 2. Discuss Phase

```
/gsd-discuss-phase 1
```

**This is where you shape the implementation.**

Your roadmap has a sentence or two per phase. That's not enough context to build something the way *you* imagine it. This step captures your preferences before anything gets researched or planned.

The system analyzes the phase and identifies gray areas based on what's being built:

- **Visual features** → Layout, density, interactions, empty states
- **APIs/CLIs** → Response format, flags, error handling, verbosity
- **Content systems** → Structure, tone, depth, flow
- **Organization tasks** → Grouping criteria, naming, duplicates, exceptions

For each area you select, it asks until you're satisfied. The output — `CONTEXT.md` — feeds directly into the next two steps:

1. **Researcher reads it** — Knows what patterns to investigate ("user wants card layout" → research card component libraries)
2. **Planner reads it** — Knows what decisions are locked ("infinite scroll decided" → plan includes scroll handling)

The deeper you go here, the more the system builds what you actually want. Skip it and you get reasonable defaults. Use it and you get *your* vision.

**Creates:** `{phase}-CONTEXT.md`

---

### 3. Plan Phase

```
/gsd-plan-phase 1
```

The system:

1. **Researches** — Investigates how to implement this phase, guided by your CONTEXT.md decisions
2. **Plans** — Creates 2-3 atomic task plans with XML structure
3. **Verifies** — Checks plans against requirements, loops until they pass

Each plan is small enough to execute in a fresh context window. No degradation, no "I'll be more concise now."

**Creates:** `{phase}-RESEARCH.md`, `{phase}-{N}-PLAN.md`

---

### 4. Execute Phase

```
/gsd-execute-phase 1
```

The system:

1. **Runs plans in waves** — Parallel where possible, sequential when dependent
2. **Fresh context per plan** — 200k tokens purely for implementation, zero accumulated garbage
3. **Commits per task** — Every task gets its own atomic commit
4. **Verifies against goals** — Checks the codebase delivers what the phase promised

Walk away, come back to completed work with clean git history.

**Creates:** `{phase}-{N}-SUMMARY.md`, `{phase}-VERIFICATION.md`

---

### 5. Verify Work

```
/gsd-verify-work 1
```

**This is where you confirm it actually works.**

Automated verification checks that code exists and tests pass. But does the feature *work* the way you expected? This is your chance to use it.

The system:

1. **Extracts testable deliverables** — What you should be able to do now
2. **Walks you through one at a time** — "Can you log in with email?" Yes/no, or describe what's wrong
3. **Diagnoses failures automatically** — Spawns debug agents to find root causes
4. **Creates verified fix plans** — Ready for immediate re-execution

If everything passes, you move on. If something's broken, you don't manually debug — you just run `/gsd-execute-phase` again with the fix plans it created.

**Creates:** `{phase}-UAT.md`, fix plans if issues found

---

### 6. Repeat → Complete → Next Milestone

```
/gsd-discuss-phase 2
/gsd-plan-phase 2
/gsd-execute-phase 2
/gsd-verify-work 2
...
/gsd-complete-milestone
/gsd-new-milestone
```

Loop **discuss → plan → execute → verify** until milestone complete.

Each phase gets your input (discuss), proper research (plan), clean execution (execute), and human verification (verify). Context stays fresh. Quality stays high.

When all phases are done, `/gsd-complete-milestone` archives the milestone and tags the release.

Then `/gsd-new-milestone` starts the next version — same flow as `new-project` but for your existing codebase. You describe what you want to build next, the system researches the domain, you scope requirements, and it creates a fresh roadmap. Each milestone is a clean cycle: define → build → ship.

---

### Quick Mode

```
/gsd-quick
```

**For ad-hoc tasks that don't need full planning.**

Quick mode gives you GSD guarantees (atomic commits, state tracking) with a faster path:

- **Same agents** — Planner + executor, same quality
- **Skips optional steps** — No research, no plan checker, no verifier
- **Separate tracking** — Lives in `.planning/quick/`, not phases

Use for: bug fixes, small features, config changes, one-off tasks.

```
/gsd-quick
> What do you want to do? "Add dark mode toggle to settings"
```

**Creates:** `.planning/quick/001-add-dark-mode-toggle/PLAN.md`, `SUMMARY.md`

---

# .gsd directory content

| File              | What it does |
|-------------------|---------------------------------------------------------------|
| `PROJECT.md`      | Project vision, always loaded |
| `research/`       | Ecosystem knowledge (stack, features, architecture, pitfalls) |
| `REQUIREMENTS.md` | Scoped v1/v2 requirements with phase traceability |
| `ROADMAP.md`      | Where you're going, what's done |
| `STATE.md`        | Decisions, blockers, position — memory across sessions |
| `PLAN.md`         | Atomic task with XML structure, verification steps |
| `SUMMARY.md`      | What happened, what changed, committed to history |
| `todos/`          | Captured ideas and tasks for later work |


## Commands

### Core Workflow

| Command | What it does |
|---------|--------------|
| `/gsd-new-project [--auto]` | Full initialization: questions → research → requirements → roadmap |
| `/gsd-discuss-phase [N]` | Capture implementation decisions before planning |
| `/gsd-plan-phase [N]` | Research + plan + verify for a phase |
| `/gsd-execute-phase <N>` | Execute all plans in parallel waves, verify when complete |
| `/gsd-verify-work [N]` | Manual user acceptance testing ¹ |
| `/gsd-audit-milestone` | Verify milestone achieved its definition of done |
| `/gsd-complete-milestone` | Archive milestone, tag release |
| `/gsd-new-milestone [name]` | Start next version: questions → research → requirements → roadmap |

### Navigation

| Command | What it does |
|---------|--------------|
| `/gsd-progress` | Where am I? What's next? |
| `/gsd-help` | Show all commands and usage guide |
| `/gsd-update` | Update GSD with changelog preview |
| `/gsd-join-discord` | Join the GSD Discord community |

### Brownfield

| Command | What it does |
|---------|--------------|
| `/gsd-map-codebase` | Analyze existing codebase before new-project |

### Phase Management

| Command | What it does |
|---------|--------------|
| `/gsd-add-phase` | Append phase to roadmap |
| `/gsd-insert-phase [N]` | Insert urgent work between phases |
| `/gsd-remove-phase [N]` | Remove future phase, renumber |
| `/gsd-list-phase-assumptions [N]` | See Claude's intended approach before planning |
| `/gsd-plan-milestone-gaps` | Create phases to close gaps from audit |

### Session

| Command | What it does |
|---------|--------------|
| `/gsd-pause-work` | Create handoff when stopping mid-phase |
| `/gsd-resume-work` | Restore from last session |

### Utilities

| Command | What it does |
|---------|--------------|
| `/gsd-settings` | Configure model profile and workflow agents |
| `/gsd-set-profile <profile>` | Switch model profile (quality/balanced/budget) |
| `/gsd-add-todo [desc]` | Capture idea for later |
| `/gsd-check-todos` | List pending todos |
| `/gsd-debug [desc]` | Systematic debugging with persistent state |
| `/gsd-quick` | Execute ad-hoc task with GSD guarantees |

<sup>¹ Contributed by reddit user OracleGreyBeard</sup>

---

## Configuration

GSD stores project settings in `.planning/config.json`. Configure during `/gsd-new-project` or update later with `/gsd-settings`.

### Core Settings

| Setting | Options | Default | What it controls |
|---------|---------|---------|------------------|
| `mode` | `yolo`, `interactive` | `interactive` | Auto-approve vs confirm at each step |
| `depth` | `quick`, `standard`, `comprehensive` | `standard` | Planning thoroughness (phases × plans) |

### Model Profiles

Control which Claude model each agent uses. Balance quality vs token spend.

| Profile | Planning | Execution | Verification |
|---------|----------|-----------|--------------|
| `quality` | Opus | Opus | Sonnet |
| `balanced` (default) | Opus | Sonnet | Sonnet |
| `budget` | Sonnet | Sonnet | Haiku |

Switch profiles:
```
/gsd-set-profile budget
```

Or configure via `/gsd-settings`.