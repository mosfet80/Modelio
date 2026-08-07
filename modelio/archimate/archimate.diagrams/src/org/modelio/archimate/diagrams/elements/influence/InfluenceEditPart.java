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
package org.modelio.archimate.diagrams.elements.influence;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolylineDecoration;

/**
 * EditPart for a {@link GmInfluence} Link.
 */
@objid ("a14347ce-1cdd-4eee-924e-7e3ecc9fe8dc")
public class InfluenceEditPart extends ArchiRelationshipEditPart {
    @objid ("327ca46e-3e8a-4641-b94f-372d05b7dead")
    @Override
    protected IFigure createFigure() {
        PolylineConnection connection = (PolylineConnection) super.createFigure();

        // Navigability arrow toward target
        DefaultPolylineDecoration arrow = new DefaultPolylineDecoration();
        arrow.setTemplate(PolylineDecoration.TRIANGLE_TIP);
        arrow.setScale(5, 5);
        arrow.setOpaque(false);
        connection.setTargetDecoration(arrow);

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

}
