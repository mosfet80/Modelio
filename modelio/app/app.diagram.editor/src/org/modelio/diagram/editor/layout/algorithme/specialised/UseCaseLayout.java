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
package org.modelio.diagram.editor.layout.algorithme.specialised;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.alg.layered.options.NodePlacementStrategy;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.EdgeRouting;
import org.eclipse.elk.graph.ElkEdge;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.dg.IDiagramDG;
import org.modelio.diagram.editor.layout.algorithme.elk.utils.ElkModelUtils;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;

/**
 * UseCaseLayout is a specialized layout algorithm for use case diagrams.
 * It extends the LayeredLayout to provide specific configurations for use case diagrams.
 */
@objid ("cf584451-50dc-413c-afa3-302631908e4e")
public class UseCaseLayout extends LayeredLayout {
    @objid ("d23b747b-e55e-43a7-b4cb-b0a4aba1147b")
    @Override
    public void configureLayout() {
        super.configureLayout();

        this.graph.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
        this.graph.setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.POLYLINE);
        this.graph.setProperty(LayeredOptions.SPACING_BASE_VALUE, 60.0);
        this.graph.setProperty(CoreOptions.PADDING, new ElkPadding(20.0));
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.SPACING_COMPONENT_COMPONENT, 60.0);
        this.graph.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 120.0);
        this.graph.setProperty(LayeredOptions.NODE_PLACEMENT_STRATEGY, NodePlacementStrategy.NETWORK_SIMPLEX);
    }

    @objid ("ce9f5bf8-4ebf-42b0-bb25-a3e1896c9df8")
    @Override
    protected void updateLinkDGModel(IDiagramDG diagramDg) {
        for (IDiagramLink linkDg : ElkModelUtils.getAllLinks(diagramDg)) {
            List<ElkEdge> edges = getElKLinks().get(linkDg);
            ILinkPath path = linkDg.getPath();
            if (edges != null && path != null) {
                ElkModelUtils.updateLinkPath(edges, path, new Point(0, 0));
                linkDg.setPath(path);
            }
        }
    }

}
