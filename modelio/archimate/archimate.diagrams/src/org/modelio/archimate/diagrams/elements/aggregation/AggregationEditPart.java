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
package org.modelio.archimate.diagrams.elements.aggregation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.common.decoration.CompositeDecoration;
import org.modelio.diagram.elements.core.figures.LinkFigure;
import org.modelio.diagram.elements.core.figures.RoundedLinkFigure;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolygonDecoration;
import org.modelio.diagram.elements.core.model.GmModel;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;

/**
 * EditPart for a {@link GmAggregation} Link.
 */
@objid ("10bc1a94-853f-4c82-a3a2-bf9ed868b8d1")
public class AggregationEditPart extends ArchiRelationshipEditPart {
    @objid ("dac86819-a56a-4f5f-a20f-a67ee72c3855")
    private static final PointList AGGREGATION_TIP = new PointList(new int[] { -1, 1, 0, 0, -1, -1, -2, 0 });

    @objid ("a79ed2be-9285-4e8f-afa4-002b0a8cb4e3")
    @Override
    protected IFigure createFigure() {
        final RoundedLinkFigure connection = new RoundedLinkFigure();

        DefaultPolygonDecoration deco = new DefaultPolygonDecoration();
        deco.setTemplate(AGGREGATION_TIP);
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

    @objid ("96af68cb-5c42-4bdc-be3d-0060e6af1763")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        super.refreshFromStyle(aFigure, style);

        final GmModel gmModel = getModel();

        final LinkFigure genFigure = (LinkFigure) aFigure;
        if (genFigure.getSourceDecoration() != null && gmModel.getStyleKey(MetaKey.FILLCOLOR) != null) {
            genFigure.getSourceDecoration().setBackgroundColor(style.getColor(gmModel.getStyleKey(MetaKey.FILLCOLOR)));
        }

    }

}
