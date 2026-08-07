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
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.IDiagramNode.Role;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiElement;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.diagram.api.dg.DGFactory;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.api.services.DiagramNode;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * This class represents the DiagramGraphic of a {@link Element} element.
 */
@objid ("f5c5b287-daa2-4108-a123-502c18ed46fd")
public class ArchiElementDG extends DiagramNode {
    /**
     *
     * @param diagramHandle The diagram manipulation class.
     * @param node The gm node represented by this class.
     */
    @objid ("514fe44f-bddd-4468-a3d4-d97cf64817e0")
    public ArchiElementDG(DiagramHandle diagramHandle, GmNodeModel node) {
        super(diagramHandle, node);
    }

    @objid ("f9db160b-8f17-4c9e-bbc7-807421ffb571")
    @Override
    public List<IDiagramNode> getNodes() {
        GmCompositeNode bodyZone = ((GmArchiElement<?>) this.gmNode).getCompositeFor(Element.class);
        if (bodyZone != null) {
            return DGFactory.getInstance().getDiagramNodes(this.diagramHandle, bodyZone.getVisibleChildren());
        } else {
            return Collections.emptyList();
        }

    }

    @objid ("c65f5f4f-8c84-4d22-8e36-a313ef8eb0c3")
    @Override
    public Collection<IDiagramNode> getNodes(Role role) {
        if (role == Role.INNER) {
            return getNodes();
        } else {
            return Collections.emptyList();
        }

    }

}
