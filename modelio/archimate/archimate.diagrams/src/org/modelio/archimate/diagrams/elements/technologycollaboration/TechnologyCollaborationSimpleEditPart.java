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
package org.modelio.archimate.diagrams.elements.technologycollaboration;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.figures.CollaborationFigure;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmTechnologyCollaboration} Node in simple mode.
 */
@objid ("51430695-9198-4375-bcb0-357e580ec6f6")
public class TechnologyCollaborationSimpleEditPart extends ArchiElementEditPart {
    @objid ("0357cf35-0cae-4081-affc-39dd6d72b4af")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final CollaborationFigure fig = new CollaborationFigure();
        fig.setOpaque(true);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 40);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("04de6706-bfbb-48ca-a297-1ca20492af35")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof CollaborationFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final GmArchiElementPrimaryNode<?> gmModel = (GmArchiElementPrimaryNode<?>) getModel();
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

    @objid ("ddb61af2-f072-4b12-b7df-54391f5d2081")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
