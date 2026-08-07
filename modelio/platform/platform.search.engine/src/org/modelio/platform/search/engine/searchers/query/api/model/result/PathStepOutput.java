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
 * Step taken between two nodes in an explanation path, representing a single graph edge traversal.
 * <p>
 * Defined in MQL Technical Specification, Section 4.4 "Edge step in paths".
 * <p>
 * A path step describes how the query engine moved from one node to the next during graph exploration.
 * There are two kinds of steps:
 * <ul>
 * <li><b>{@link LinkPathStepOutput}</b> - traversal via a link model object (e.g., UML Generalization, Dependency).
 * The link itself is an {@code MObject} with identity and may have stereotypes.</li>
 * <li><b>{@link MDependencyPathStepOutput}</b> - traversal via a structural relation (metamodel {@code MDependency}).
 * This represents composition, aggregation, or other metamodel-defined relationships.</li>
 * </ul>
 * <p>
 * The engine selects the appropriate step type based on the {@code EdgeRef} in the query AST:
 * <ul>
 * <li>If the edge name resolves to a link metaclass or stereotype → {@code LinkPathStepOutput}</li>
 * <li>If the edge name resolves to an {@code MDependency} → {@code RelPathStepOutput}</li>
 * <li>If ambiguous, the engine produces the union of all interpretations and emits a warning</li>
 * </ul>
 */
@objid ("11b32e91-e6e7-4aa2-9445-982f9600d7a1")
public sealed interface PathStepOutput permits LinkPathStepOutput, MDependencyPathStepOutput {
}
