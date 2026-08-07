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
package org.modelio.archimate.diagrams.editor.viewpointdiagram;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.diagram.editor.plugin.AbstractDiagramConfigurer;

/**
 * ViewPoint diagram palette configurer.
 */
@objid ("7743705e-93f2-49b8-a899-4b29e5d9d335")
public class ViewPointDiagramConfigurer extends AbstractDiagramConfigurer {
    @objid ("c785c9bf-92af-4d0b-9d56-8096d0a7f1f0")
    @Override
    public String getContributionURI() {
        return ViewPointDiagramEditor.ID;
    }

}
