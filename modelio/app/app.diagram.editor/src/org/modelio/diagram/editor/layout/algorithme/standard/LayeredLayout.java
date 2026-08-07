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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.elk.alg.layered.options.LayeredOptions;
import org.eclipse.elk.alg.layered.options.NodePlacementStrategy;
import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.EdgeRouting;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkLayout;

@objid ("4664738d-e13d-4848-96db-8aa86d0345ec")
public class LayeredLayout extends DefaultElkLayout {
    @objid ("4f311c94-cc03-4156-8270-a20c9c04083b")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.layered");
        this.graph.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
        this.graph.setProperty(CoreOptions.EDGE_ROUTING, EdgeRouting.ORTHOGONAL);
        this.graph.setProperty(LayeredOptions.SPACING_BASE_VALUE, 60.0);
        this.graph.setProperty(CoreOptions.PADDING, new ElkPadding(20.0));
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 60.0);
        this.graph.setProperty(CoreOptions.SPACING_COMPONENT_COMPONENT, 60.0);
        this.graph.setProperty(LayeredOptions.SPACING_NODE_NODE_BETWEEN_LAYERS, 60.0);
        this.graph.setProperty(LayeredOptions.NODE_PLACEMENT_STRATEGY, NodePlacementStrategy.NETWORK_SIMPLEX);
    }

}
