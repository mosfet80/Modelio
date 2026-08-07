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
package org.modelio.archimate.diagrams.elements.dataobject;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmDataObject} Node.
 */
@objid ("6b53baaf-2c4f-4d95-87eb-0ead5b0c5cbe")
public class DataObjectEditPart extends ArchiElementEditPart {
    @objid ("22c21717-8b01-4a0b-bcfd-0b0530f16f2f")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final RectangularFigure fig = new RectangularFigure();
        fig.setOpaque(true);

        // Add layout
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        fig.setLayoutManager(layout);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("8e5ef0a8-b73b-41e0-9254-a9b9e83ab47e")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RectangularFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final INodeWithArchiHeader gmModel = (INodeWithArchiHeader) getModel();
            switch (gmModel.getRepresentationMode()) {
            case STRUCTURED:
                gmModel.getHeader().setShowMetaclassIcon(true);
                break;
            case IMAGE:
            case SIMPLE:
            case USER_IMAGE:
                gmModel.getHeader().setShowMetaclassIcon(false);
                break;
            default:
                break;
            }
        }

    }

    @objid ("a6ba988d-feb6-4fc5-b8a4-a31fd9d4de89")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
