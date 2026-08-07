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
package org.modelio.archimate.diagrams.elements.assessment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.figures.motivation.MotivationFigure;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmAssessment} Node.
 */
@objid ("ea48ce96-c9f9-484a-8a43-0bd417d8d8c0")
public class AssessmentEditPart extends ArchiElementEditPart {
    @objid ("466d0cdc-feea-4b95-8677-35bb2f1a4a31")
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

    @objid ("f521583a-02cc-4ff6-9409-746f59e7b2e7")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof MotivationFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("25e34bb3-12cc-42f0-926e-8823daef1988")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
