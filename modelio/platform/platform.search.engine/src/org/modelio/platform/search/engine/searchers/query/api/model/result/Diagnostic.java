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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Diagnostic message reporting information, warnings, or errors from query execution.
 * <p>
 * Defined in MQL Technical Specification, Section 4.1 "Query response" (diagnostics field).
 * <p>
 * Diagnostics provide feedback about query execution without stopping processing.
 * They are essential for:
 * <ul>
 * <li><b>Ambiguity warnings</b> - when a name (Kind, Edge, or Element Property) resolves to multiple
 * valid definitions, the engine executes the union of all alternatives and emits a warning</li>
 * <li><b>Cycle detection</b> - when traversal returns to a node already in the current path,
 * a warning is emitted with the involved elements (spec section 5.2)</li>
 * <li><b>Limit reached</b> - informational messages when {@code limit}, {@code maxDepth}, or
 * {@code timeoutMs} causes truncation</li>
 * <li><b>Execution errors</b> - problems during traversal, filtering, or expression evaluation</li>
 * </ul>
 * <p>
 * <b>Level semantics:</b>
 * <ul>
 * <li><b>info</b> - informational messages (e.g., "Query completed in 250ms", "Limit of 1000 items reached")</li>
 * <li><b>warning</b> - issues that don't prevent execution but may indicate unexpected behavior
 * (e.g., "Ambiguous edge 'Generalization' resolved to 2 alternatives", "Cycle detected at node X")</li>
 * <li><b>error</b> - serious problems during execution (e.g., "Type mismatch in comparison",
 * "Invalid metaclass name")</li>
 * </ul>
 * <p>
 * <b>Example diagnostic:</b>
 * <pre>
 * Diagnostic(
 * level = "warning",
 * message = "Cycle detected.",
 * elements = [Customer MObject]
 * )
 * </pre>
 *
 * @param code structured diagnostic code identifying the kind of issue (never null)
 * @param level severity level: {@code "info"}, {@code "warning"}, or {@code "error"} (never null)
 * @param message human-readable description of the diagnostic (never null or blank)
 * @param elements optional related model elements providing context (may be null or empty, transient: serialized as {mc, uuid, name})
 */
@objid ("3485d6d0-946d-4174-ae38-f1b35b250bee")
public record Diagnostic ( DiagnosticCode code,
        Level level,
        String message,
        List<MObject> elements )  {
    @objid ("7209e8d7-df8e-4ee8-860a-f7b7ce4ab305")
    public Diagnostic {
        if (code == null) {
            throw new IllegalArgumentException("code must not be null");
        }
        if (level == null) {
            throw new IllegalArgumentException("level must not be null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("message must not be null/blank");
        }
    }

    @objid ("984778d9-a16e-4db3-908b-100f18a16555")
    public enum Level {
        @objid ("a5557e31-7595-465b-913a-957368be4f27")
        INFO("info"),
        @objid ("e2300691-9824-4a17-9ad4-8f77c2886a11")
        WARNING("warning"),
        @objid ("1e41812f-6068-4fab-a1ce-5f3d28a25da2")
        ERROR("error");

        @objid ("24d4edd6-3d2a-4192-b794-2af019fc99d9")
        private final String value;

        @objid ("952b7d2b-953f-4cee-be9a-c7ef8175cfc1")
        Level(String value) {
            this.value = value;
        }

        @objid ("2aec6c51-bb08-4225-b04d-35079a0a6f27")
        @Override
        public String toString() {
            return this.value;
        }

    }

}
