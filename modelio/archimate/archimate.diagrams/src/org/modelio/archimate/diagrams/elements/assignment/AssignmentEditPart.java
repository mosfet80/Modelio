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
package org.modelio.archimate.diagrams.elements.assignment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolygonDecoration;

/**
 * EditPart for a {@link GmAssignment} Link.
 */
@objid ("6f24f32f-47b3-43c8-80bd-9c66520907d4")
public class AssignmentEditPart extends ArchiRelationshipEditPart {
    @objid ("cf67ed80-22f6-4c4b-a118-6dd461feaa55")
    @Override
    protected IFigure createFigure() {
        PolylineConnection connection = (PolylineConnection) super.createFigure();

        // Arrow toward target
        DefaultPolygonDecoration arrow = new DefaultPolygonDecoration();
        arrow.setTemplate(PolygonDecoration.TRIANGLE_TIP);
        arrow.setScale(5, 5);
        arrow.setOpaque(true);
        arrow.setFill(true);

        // Circle at target
        AssignmentFigure circle = new AssignmentFigure();

        connection.setSourceDecoration(circle);
        connection.setTargetDecoration(arrow);

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

}
