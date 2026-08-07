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
import org.eclipse.elk.alg.force.options.ForceMetaDataProvider;
import org.eclipse.elk.alg.force.options.ForceModelStrategy;
import org.eclipse.elk.core.options.CoreOptions;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkLayout;

@objid ("980a708d-86a0-4d5f-a43b-3fb9a8bca175")
public class ForceLayout extends DefaultElkLayout {
    @objid ("f0406e25-8c56-4bf1-955e-ae540548e82a")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.force");
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 20.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 20.0);
    }

}
