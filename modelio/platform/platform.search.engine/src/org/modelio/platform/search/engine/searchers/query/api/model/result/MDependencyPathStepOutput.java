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
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;

/**
 * Path step representing a traversal over a structural relation (metamodel {@code MDependency}).
 * <p>
 * Defined in MQL Technical Specification, Section 4.4 "Edge step in paths" (rel variant).
 * <p>
 * A structural relation step describes traversal via a metamodel-defined {@code MDependency}.
 * These represent composition, aggregation, and other structural relationships defined in the metamodel.
 * Unlike link steps, these are not represented as separate model objects with identity.
 * <ul>
 * <li>The relation is defined on a metaclass ({@code mc})</li>
 * <li>The relation has a name ({@code dep}) and knows its opposite dependency</li>
 * <li>Navigation uses {@code MObject.mGet(MDependency)} to reach neighbor nodes</li>
 * </ul>
 * <p>
 * <b>Examples:</b>
 * <ul>
 * <li>Package composition: {@code mc="Standard.Package", dep="OwnedElement"}</li>
 * <li>Class ownership: {@code mc="Standard.Class", dep="OwnedAttribute"}</li>
 * <li>Operation parameters: {@code mc="Standard.Operation", dep="IO"}</li>
 * </ul>
 * <p>
 *
 * @param mc owner metaclass qualified name (e.g., {@code "Standard.Package"}), never null or blank
 * @param dep dependency name (e.g., {@code "OwnedElement"}), never null or blank
 */
@objid ("674eea54-42d5-4ec9-a026-37bb1a6c00a5")
public record MDependencyPathStepOutput ( MClass mc,
        MDependency dep )  implements PathStepOutput {
    @objid ("f72a4f77-d5a8-45d4-b158-23a0b4557e80")
    public MDependencyPathStepOutput {
        if (mc == null) {
            throw new IllegalArgumentException("mc must not be null");
        }
        if (dep == null) {
            throw new IllegalArgumentException("dep must not be null");
        }
    }

}
