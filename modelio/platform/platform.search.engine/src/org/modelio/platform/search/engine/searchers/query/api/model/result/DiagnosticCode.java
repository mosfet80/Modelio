/*
 * Copyright 2013-2025 Docaposte
 *
 * This file is part of Modelio.
 *
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.modelio.platform.search.engine.searchers.query.api.model.result;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Structured codes for diagnostics emitted during MQL query resolution and execution.
 * <p>
 * Resolution codes are produced by the query resolver before execution begins.
 * Execution codes are produced during graph traversal and result streaming.
 */
@objid ("9d0d0cf2-1992-4440-ad76-65bdec2b56d9")
public enum DiagnosticCode {
    // --- Resolution codes ---
    /**
     * A kind token (metaclass or stereotype name) could not be matched to any known definition.
     */
    @objid ("a43400cd-55ed-4749-943b-c813fc681a19")
    UNKNOWN_KIND("Unknown kind token"),
    /**
     * A kind token matched more than one metaclass or stereotype; the engine will use the union.
     */
    @objid ("b5ce9a93-c424-47f7-a5ff-504151d92aeb")
    AMBIGUOUS_KIND("Ambiguous kind token"),
    /**
     * A traverse edge token could not be matched to any known dependency or link.
     */
    @objid ("139c4b33-4e00-4d21-8c41-29316143c0c4")
    UNKNOWN_EDGE("Unknown edge token"),
    /**
     * A traverse edge token matched more than one dependency or link; the engine will use the union.
     */
    @objid ("91ea5c0a-053a-4ec4-8ecb-1ffcceeb0aa3")
    AMBIGUOUS_EDGE("Ambiguous edge token"),
    /**
     * A property key token could not be matched to any known attribute, tag type, note type or property definition.
     */
    @objid ("d0cb1e7f-4f2f-45b1-ba0b-ad2daee1f123")
    UNKNOWN_PROPERTY("Unknown property key token"),
    /**
     * A property key token matched more than one alternative; the engine will use the union.
     */
    @objid ("0ffbff0d-8c4c-4185-81fd-59037d502238")
    AMBIGUOUS_PROPERTY("Ambiguous property key token"),
    /**
     * A step subtype was encountered that the resolver does not support.
     */
    @objid ("2301fc58-17ef-45bb-bed8-34ee2c66097f")
    UNSUPPORTED_STEP("Unsupported step subtype"),
    /**
     * An expression subtype was encountered that the resolver does not support.
     */
    @objid ("ca2f1ae9-6be6-40b2-8424-4b18cffdd95b")
    UNSUPPORTED_EXPR("Unsupported expression subtype"),
    /**
     * A query source subtype was encountered that the resolver does not support.
     */
    @objid ("fff200d8-12f8-42ba-aa47-28e7e6a9c6e7")
    UNSUPPORTED_SOURCE("Unsupported source subtype"),
    /**
     * A required field is missing or blank (e.g., blank edge token, null kind reference).
     * Identifies "editing in progress" diagnostics as distinct from genuine resolution errors.
     */
    @objid ("2be3218b-bd9c-47b4-b69b-a4e32d1f1bc7")
    REQUIRED_FIELD_MISSING("Required field is missing or blank"),
    // --- Execution codes ---
    /**
     * Query execution was interrupted (e.g., via dispose() or thread interruption).
     */
    @objid ("4f7d1f50-2c8d-44e0-aeb7-a41b91e6a498")
    INTERRUPTED("Execution interrupted"),
    /**
     * An element was skipped because it was no longer valid or had been deleted.
     */
    @objid ("cd395f6f-e99a-4e4e-9f96-9202771b32b0")
    INVALID_ELEMENT_SKIPPED("Invalid element skipped"),
    /**
     * The provided source yielded no elements; query returned an empty result.
     */
    @objid ("d25069d5-4bce-4a2f-b7bc-1d57733cf3aa")
    EMPTY_PROVIDED_SOURCE("Provided source is empty"),
    /**
     * Resolution produced errors that prevented execution from starting.
     */
    @objid ("359f85c3-6821-4ace-a11e-d0f4401cea46")
    RESOLUTION_ERROR("Resolution error prevented execution"),
    /**
     * An unexpected runtime exception occurred during graph traversal or expression evaluation.
     */
    @objid ("42ef2271-e5c7-4170-bde8-b414fed1dd4e")
    RUNTIME_ERROR("Runtime error during execution"),
    /**
     * Execution was truncated due to a limit (maxDepth, maxResults, or similar).
     * This is the preferred truncation diagnostic; {@link #LIMIT_REACHED} and {@link #TIMEOUT_REACHED}
     * remain available for backwards compatibility but are not actively emitted.
     */
    @objid ("1b6eaa14-89a9-4e58-9170-aa6531160fd2")
    EXECUTION_TRUNCATED("Execution truncated"),
    /**
     * A cycle was detected during repeat traversal.
     * Emitted as a WARNING; execution continues without revisiting the cycle node.
     */
    @objid ("df8e3924-f43b-44ab-83c8-e2c8b9e015f2")
    CYCLE_DETECTED("Cycle detected during repeat traversal"),
    /**
     * Execution was truncated because the result count reached the configured limit.
     *
     * @deprecated Use {@link #EXECUTION_TRUNCATED} for new code.
     */
    @objid ("0a4053bc-a7c7-4563-97a2-93a1bdb4b0a1")
    LIMIT_REACHED("Result limit reached"),
    /**
     * Execution was truncated because the configured timeout elapsed.
     *
     * @deprecated Use {@link #EXECUTION_TRUNCATED} for new code.
     */
    @objid ("31ab58a9-8095-429a-8339-87c34d00f18b")
    TIMEOUT_REACHED("Execution timeout reached");

    @objid ("b1aadd8a-d427-4cdf-bd1b-b60ae4968b3e")
    private final String description;

    @objid ("e07ba2ab-7dc5-4a47-ad10-11f7ad83985d")
    DiagnosticCode(String description) {
        this.description = description;
    }

    /**
     *
     * @return a short English description of this diagnostic code.
     */
    @objid ("195f6e74-39d3-4cf1-9c6c-2a54d6530ef1")
    public String description() {
        return this.description;
    }

}
