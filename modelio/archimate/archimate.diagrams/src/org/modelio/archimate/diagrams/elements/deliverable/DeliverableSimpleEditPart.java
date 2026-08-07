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
package org.modelio.archimate.diagrams.elements.deliverable;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.archimate.diagrams.elements.common.figures.WaveFigure;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmDeliverable} Node in simple mode.
 */
@objid ("78cbb62c-f700-4eb5-9b6b-da7ba72bf76a")
public class DeliverableSimpleEditPart extends ArchiElementEditPart {
    @objid ("38b01e6a-e992-44a8-a9ad-40dfc510a389")
    @Override
    protected IFigure createFigure() {
        // create the figure
        IFigure fig = new WaveFigure();

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // return the figure
        return fig;
    }

    @objid ("67937ecf-b9da-47d3-a14e-2e179f9ad54a")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof WaveFigure) {
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

    @objid ("bb451b8e-face-426b-8e9e-d4370e8e0f2c")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
