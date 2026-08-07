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
package org.modelio.archimate.diagrams.elements.access;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.swt.graphics.Color;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.core.figures.IPenOptionsSupport;
import org.modelio.diagram.elements.core.figures.LinkFigure;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolylineDecoration;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

/**
 * EditPart for a {@link GmAccess} Link.
 */
@objid ("2ae9f21f-ff1b-49ff-8bb7-7b10f2926d7d")
public class AccessEditPart extends ArchiRelationshipEditPart {
    @objid ("41537826-63c0-4624-8b11-276c7595eb5a")
    @Override
    protected IFigure createFigure() {
        PolylineConnection connection = (PolylineConnection) super.createFigure();

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

    @objid ("d7ea4b57-bcab-49b0-a9d3-bc1821c944c0")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        super.refreshFromStyle(aFigure, style);

        // recreate arrows if the display navigability changes.
        GmAccess gmModel = (GmAccess) getModel();

        createDecorations((LinkFigure) aFigure, gmModel);

        refreshDecorationsFromStyle((LinkFigure) aFigure, style);

    }

    @objid ("63a2a606-4962-46ec-bb42-68cfc2a84c65")
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();

        LinkFigure connection = (LinkFigure) getFigure();
        GmAccess model = (GmAccess) getModel();

        // navigability
        createDecorations(connection, model);

        refreshDecorationsFromStyle(connection, getModelStyle());

    }

    @objid ("558123ef-1cea-4b21-8b35-6648571a3fa1")
    private void createDecorations(LinkFigure connection, GmAccess model) {
        RotatableDecoration deco;

        deco = createDecoration(model.isToNavigable());
        connection.setTargetDecoration(deco);

        deco = createDecoration(model.isFromNavigable());
        connection.setSourceDecoration(deco);

    }

    @objid ("1345a0b8-5478-4306-a474-40a0d7f4f0a2")
    private RotatableDecoration createDecoration(boolean withArrow) {
        if (withArrow) {
            DefaultPolylineDecoration arrow = new DefaultPolylineDecoration();
            arrow.setTemplate(PolylineDecoration.TRIANGLE_TIP);
            arrow.setScale(5, 5);
            arrow.setOpaque(false);
            arrow.setBackgroundColor(null);
            arrow.setLinePattern(LinePattern.LINE_SOLID);
            return arrow;
        } else {
            return null;
        }

    }

    @objid ("fb67c60d-d5fa-422f-b227-cb8de49a8320")
    protected void refreshDecorationsFromStyle(LinkFigure connection, IStyle style) {
        GmAccess model = (GmAccess) getModel();

        // Get style values
        Color fillColor = null;
        int lineWidth = 1;

        if (model.getStyleKey(MetaKey.FILLCOLOR) != null)
            fillColor = (style.getColor(model.getStyleKey(MetaKey.FILLCOLOR)));
        if (model.getStyleKey(MetaKey.LINEWIDTH) != null)
            lineWidth = (style.getInteger(model.getStyleKey(MetaKey.LINEWIDTH)));

        // Source decoration
        RotatableDecoration decoration = connection.getSourceDecoration();
        if (decoration != null) {
            decoration.setBackgroundColor(fillColor);

            final IPenOptionsSupport pennable = (IPenOptionsSupport) decoration;
            pennable.setLineWidth(lineWidth);
        }

        // Target decoration
        decoration = connection.getTargetDecoration();
        if (decoration != null) {
            decoration.setBackgroundColor(fillColor);

            final IPenOptionsSupport pennable = (IPenOptionsSupport) decoration;
            pennable.setLineWidth(lineWidth);
        }

    }

}
