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
import org.eclipse.elk.core.options.CoreOptions;
import org.modelio.diagram.editor.layout.algorithme.elk.DefaultElkLayout;

@objid ("95fc9e3e-cb6c-41be-b6f4-9289f4d2b5ef")
public class OverlapLayout extends DefaultElkLayout {
    @objid ("8c24d404-6e58-4ad4-8054-6d463988062a")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.sporeOverlap");
        this.graph.setProperty(CoreOptions.SPACING_NODE_NODE, 20.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_NODE, 20.0);
        this.graph.setProperty(CoreOptions.SPACING_EDGE_EDGE, 20.0);
    }

}
