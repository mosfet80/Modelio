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
package org.modelio.archimate.diagrams.elements.specialization;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.core.figures.LinkFigure;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolygonDecoration;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;

/**
 * EditPart for a {@link GmSpecialization} Link.
 */
@objid ("6976e135-aef4-4e5c-af37-4b57746efeed")
public class SpecializationEditPart extends ArchiRelationshipEditPart {
    @objid ("ffcde634-171a-4c0c-bcf2-cfff0d337fe1")
    @Override
    protected IFigure createFigure() {
        PolylineConnection connection = (PolylineConnection) super.createFigure();

        // Arrow toward target
        DefaultPolygonDecoration arrow = new DefaultPolygonDecoration();
        arrow.setTemplate(PolygonDecoration.TRIANGLE_TIP);
        arrow.setScale(8, 5);
        arrow.setOpaque(true);
        arrow.setFill(true);
        connection.setTargetDecoration(arrow);

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

    @objid ("05384d4b-1472-4a56-ae5f-95fa4838640c")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        super.refreshFromStyle(aFigure, style);

        final GmModel gmModel = getModel();

        final LinkFigure genFigure = (LinkFigure) aFigure;
        if (genFigure.getTargetDecoration() != null && gmModel.getStyleKey(MetaKey.FILLCOLOR) != null) {
            genFigure.getTargetDecoration().setBackgroundColor(style.getColor(gmModel.getStyleKey(MetaKey.FILLCOLOR)));
        }

    }

}
