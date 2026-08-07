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
package org.modelio.archimate.diagrams.dg;

import java.util.Collection;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramLink.ExtensionRole;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.api.services.DiagramLink;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.model.IGmNode;

/**
 * This class represents the DiagramGraphic of a {@link Relationship} element.
 */
@objid ("895156e8-e8dc-49a5-a3a9-113ba988128c")
public class ArchiRelationshipDG extends DiagramLink {
    /**
     *
     * @param diagramHandle The diagram manipulation class.
     * @param link The gm link represented by this class.
     */
    @objid ("bba9ff5a-235a-4da3-8f1e-bcc854485be5")
    public ArchiRelationshipDG(DiagramHandle diagramHandle, IGmLink link) {
        super(diagramHandle, link);
    }

    @objid ("bf89998f-25bd-4b01-a0f6-5d9c4be77846")
    @Override
    protected Collection<IGmNode> getGmNodes(ExtensionRole role) {
        return defaultGetGmNodes(role);
    }

}
