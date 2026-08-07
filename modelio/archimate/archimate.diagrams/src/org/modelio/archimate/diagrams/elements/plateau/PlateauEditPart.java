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
package org.modelio.archimate.diagrams.elements.plateau;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmPlateau} Node.
 */
@objid ("be0118d5-b381-47b3-9dfa-9f076abc8d94")
public class PlateauEditPart extends ArchiElementEditPart {
    @objid ("3eec7f6d-4d8a-4561-aadf-e2534658c5b2")
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

    @objid ("a7f62b72-7a2c-4558-9340-79e9727c1057")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RectangularFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("de8d0035-c90e-4461-9d40-3d46187279ae")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
