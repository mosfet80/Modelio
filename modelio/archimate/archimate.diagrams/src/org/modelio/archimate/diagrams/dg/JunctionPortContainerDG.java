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
import org.modelio.diagram.api.dg.common.PortContainerDG;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * This class represents the DiagramGraphic of an {@link Element} element.
 */
@objid ("799aaaa3-6d61-4b73-a1fa-2ceb1bde2c53")
public class JunctionPortContainerDG extends PortContainerDG {
    /**
     *
     * @param diagramHandle The diagram manipulation class.
     * @param node The gm node represented by this class.
     */
    @objid ("33e93e21-ef35-4c01-a19f-dc335649940a")
    public JunctionPortContainerDG(DiagramHandle diagramHandle, GmNodeModel node) {
        super(diagramHandle, node);
    }

    @objid ("e0f0c1f9-135b-4c26-a378-d143cdff6ec7")
    @Override
    protected List<IDiagramNode> getPrimaryChildrenNodes() {
        return new ArrayList<>();
    }

}
