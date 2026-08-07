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
package org.modelio.archimate.diagrams.elements.node;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.box.Box3DFigure;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmNode} Node in simple mode.
 */
@objid ("96c1b405-d032-43fc-97a8-e19fcb1afcfe")
public class NodeSimpleEditPart extends ArchiElementEditPart {
    @objid ("1758afb1-b734-46fa-8afe-01523f68d873")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final IFigure nodeFigure = new Box3DFigure();

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

    @objid ("2c483191-bc31-4ff5-acdb-8396f2f6ab6a")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof Box3DFigure) {
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

    @objid ("0badd834-bb46-4923-a726-f17ca151db93")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
