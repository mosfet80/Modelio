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

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.diagram.api.dg.DGFactory;
import org.modelio.diagram.api.dg.common.PortContainerDG;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * This class represents the DiagramGraphic of an {@link Element} element.
 */
@objid ("8cfbdde7-a6e9-44b5-aa7d-dd33c9b463f5")
public class ArchiElementPortContainerDG extends PortContainerDG {
    /**
     *
     * @param diagramHandle The diagram manipulation class.
     * @param node The gm node represented by this class.
     */
    @objid ("8ca133b8-f15c-44df-8313-63a27fed8a83")
    public ArchiElementPortContainerDG(DiagramHandle diagramHandle, GmNodeModel node) {
        super(diagramHandle, node);
    }

    @objid ("60be31e8-280e-4282-9704-46a119be2a48")
    @Override
    protected List<IDiagramNode> getPrimaryChildrenNodes() {
        List<IDiagramNode> nodes = new ArrayList<>();

        // Inner nodes
        GmCompositeNode mainNode = (GmCompositeNode) getPrimaryNode();

        // Body
        GmCompositeNode bodyZone = mainNode.getCompositeFor(Element.class);
        if (bodyZone != null) {
            nodes.addAll(DGFactory.getInstance().getDiagramNodes(this.diagramHandle, bodyZone.getVisibleChildren()));
        }
        return nodes;
    }

}
