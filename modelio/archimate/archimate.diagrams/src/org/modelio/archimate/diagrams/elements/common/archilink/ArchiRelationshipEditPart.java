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
package org.modelio.archimate.diagrams.elements.common.archilink;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.elements.core.link.LinkEditPart;
import org.modelio.diagram.elements.core.tools.multipoint.CreateMultiPointRequest;

/**
 * EditPart for a {@link GmArchiRelationship} Link.
 */
@objid ("85b01da3-028c-4f70-a7ac-d76c9917b889")
public abstract class ArchiRelationshipEditPart extends LinkEditPart {
    @objid ("d38fbf0b-44e0-43d4-9913-419f81f35e99")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        removeEditPolicy(CreateMultiPointRequest.REQ_MULTIPOINT_FIRST);

    }

}
