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
package org.modelio.archimate.diagrams.elements.facility;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmFacility} Node.
 */
@objid ("9818ba4d-0c2c-4b54-bc9a-39ba29732c3e")
public class FacilityEditPart extends ArchiElementEditPart {
    @objid ("ff12a1a9-5651-43a4-98ef-052b5d081c87")
    @Override
    protected IFigure createFigure() {
        final IFigure nodeFigure = new RectangularFigure();

        // Set style independent properties
        nodeFigure.setOpaque(true);

        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);

        nodeFigure.setLayoutManager(layout);

        MinimumSizeLayout.apply(nodeFigure, 90, 60);

        // set style dependent properties
        refreshFromStyle(nodeFigure, getModelStyle());

        // return the figure
        return nodeFigure;
    }

    @objid ("21a2b35f-033d-4801-b9fa-a6c9b13cb57c")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RectangularFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("d39aa148-fc9e-4fd0-863e-446d890e476c")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
