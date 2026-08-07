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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.figures.motivation.MotivationFigure;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmOutcome} Node.
 */
@objid ("0b9a11b2-7d5c-4623-813f-a812a5b18a7c")
public class OutcomeEditPart extends ArchiElementEditPart {
    @objid ("8a9f87d3-fb04-4fd1-9376-7367d431db68")
    @Override
    protected IFigure createFigure() {
        // create the figure
        IFigure fig = new MotivationFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("d97b8b43-a671-4ac7-bb65-fe8b7fdab50e")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof MotivationFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("1624c25e-42a2-4bd2-ae09-00fba676b6bf")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
