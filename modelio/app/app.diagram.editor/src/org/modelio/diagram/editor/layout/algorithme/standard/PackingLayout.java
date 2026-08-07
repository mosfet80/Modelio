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

@objid ("f2a8dd9f-41ea-45ac-bc75-c20f7e2a5cc0")
public class PackingLayout extends DefaultElkLayout {
    @objid ("1c235d77-17f0-4f9f-ae61-ac1e39cdadd1")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.ALGORITHM, "org.eclipse.elk.rectpacking");
    }

}
