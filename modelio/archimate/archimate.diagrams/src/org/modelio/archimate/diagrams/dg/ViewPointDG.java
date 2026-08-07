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
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.api.services.DiagramNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;

/**
 * This class represents the DiagramGraphic of a {@link ViewPoint} element.
 *
 * @since 5.0.2
 */
@objid ("1f821b7a-8028-4431-9651-92f5fff8a497")
public class ViewPointDG extends DiagramNode {
    /**
     *
     * @param diagramHandle The diagram manipulation class.
     * @param node The gm node represented by this class.
     */
    @objid ("8eedc1db-27e5-472e-a39b-75bacd979beb")
    public ViewPointDG(DiagramHandle diagramHandle, GmNodeModel node) {
        super(diagramHandle, node);
    }

    @objid ("355c754d-eca2-4b48-bc62-dfc64f29821e")
    @Override
    public List<IDiagramNode> getNodes() {
        return Collections.emptyList();
    }

    @objid ("ddc6806c-0ac5-4c47-bdc9-14d5a57db813")
    @Override
    public Collection<IDiagramNode> getNodes(Role role) {
        return Collections.emptyList();
    }

}
