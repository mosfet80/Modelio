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
package org.modelio.archimate.diagrams.elements.composition;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.common.decoration.CompositeDecoration;
import org.modelio.diagram.elements.core.figures.RoundedLinkFigure;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolygonDecoration;

/**
 * EditPart for a {@link GmComposition} Link.
 */
@objid ("d9ad16c9-a6e5-42fe-ab1b-1984f402a94d")
public class CompositionEditPart extends ArchiRelationshipEditPart {
    @objid ("b72034ba-5850-4ce4-8e12-7bb16c10875c")
    private static final PointList COMPOSITION_TIP = new PointList(new int[] { -1, 1, 0, 0, -1, -1, -2, 0 });

    @objid ("671028c4-ceb9-446a-8fac-22b5d10948e9")
    @Override
    protected IFigure createFigure() {
        final RoundedLinkFigure connection = new RoundedLinkFigure();

        DefaultPolygonDecoration deco = new DefaultPolygonDecoration();
        deco.setTemplate(COMPOSITION_TIP);
        deco.setScale(9, 4);
        deco.setOpaque(true);
        deco.setFill(true);
        if (connection.getSourceDecoration() instanceof CompositeDecoration) {
            ((CompositeDecoration) connection.getSourceDecoration()).setDecoration(deco);
        } else {
            connection.setSourceDecoration(deco);
        }

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

}
