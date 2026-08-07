---
description: "Using the ask_questions tool for user interaction - communicating with users and gathering input"
applyTo: "**"

---

<core_principle>

**Always use the ask_questions tool for user interaction.**

Direct conversation with the user should happen through the `ask_questions` tool rather than asking inline in responses.

If the tool is not available, tell the user loudly that you need it to continue, and fall back to asking for input in the conversation as a last resort.
</core_principle>

## Tool Name : **`ask_questions`**

This is the only tool Copilot should use for interactive user communication. Other instructions files may reference it with other names (asqQuestions, HumanAgent chat agent) but they MUST all resolve to the same `ask_questions` tool.



