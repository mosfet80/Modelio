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
package org.modelio.diagram.editor.layout.algorithme.standard;

import java.util.Arrays;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.alg.layered.options.NodePlacementStrategy;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.EdgeRouting;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkLayout;

@objid ("e3cd81b6-5777-45bb-ac7e-2d8548cc5372")
public class TreeLayout extends DefaultElkLayout {
    @objid ("37d58a15-b39b-4d20-89f4-ca0369ecea42")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.layered");
        this.graph.setProperty(CoreOptions.DIRECTION, Direction.UP);
        this.graph.setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.SPLINES);
        this.graph.setProperty(LayeredOptions.SPACING_BASE_VALUE, 30.0);
        this.graph.setProperty(CoreOptions.PADDING, new ElkPadding(20.0));
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 30.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 0.0);
        this.graph.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 40.0);
        this.graph.setProperty(LayeredOptions.NODE_PLACEMENT_STRATEGY, NodePlacementStrategy.BRANDES_KOEPF);
    }

    @objid ("8f79a189-bcfb-4c87-85a3-a2181c176573")
    @Override
    public void postProcessing() {
        // Fix Link layouts

        try (IDiagramHandle handle = getDiagramService().getDiagramHandle(getDiagram())) {

            for(IDiagramLink link : this.getElKLinks().keySet()) {
                if(link.getFrom() instanceof IDiagramNode && link.getTo() instanceof IDiagramNode) {
                    // Get the source and target bounds
                    Rectangle sourceBounds = ((IDiagramNode)link.getFrom()).getBounds();
                    Rectangle targetBounds =  ((IDiagramNode)link.getTo()).getBounds();


                    Point sourceAncor = new Point(
                            sourceBounds.x + (sourceBounds.width / 2),
                            sourceBounds.y);

                    Point mid1 = new Point(
                            sourceBounds.x + (sourceBounds.width / 2),
                            sourceBounds.y - (sourceBounds.y - (targetBounds.y + targetBounds.height)) / 2);

                    Point mid2 = new Point(
                            targetBounds.x + (targetBounds.width / 2),
                            sourceBounds.y - (sourceBounds.y - (targetBounds.y + targetBounds.height)) / 2);

                    Point targetAncor = new Point(
                            targetBounds.x + (targetBounds.width / 2),
                            targetBounds.y + targetBounds.height);

                    link.setPath(Arrays.asList(sourceAncor,mid1,mid2,targetAncor));

                }
            }
            handle.save();
        }

        try (IDiagramHandle handle = getDiagramService().getDiagramHandle(getDiagram())) {

            for(IDiagramLink link : this.getElKLinks().keySet()) {
                System.err.println(link.getPath());
            }
        }
    }

}
