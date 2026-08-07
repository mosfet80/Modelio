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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.modelio.diagram.editor.layout.algorithme.standard.LayeredLayout;

/**
 * DeploymentDiagramLayout is a specialized layout algorithm for deployment diagrams.
 * It extends the LayeredLayout to provide specific configurations for deployment diagrams.
 */
@objid ("e33bb5df-4ebe-4ebc-b760-8ea8427744d2")
public class DeploymentDiagramLayout extends LayeredLayout {
    @objid ("a0ec5adc-a25f-4414-99ed-11d179e1f8df")
    @Override
    public void configureLayout() {
        super.configureLayout();
        this.graph.setProperty(CoreOptions.DIRECTION, Direction.DOWN);
    }

}
