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
package org.modelio.archimate.diagrams.elements.association;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.modelio.archimate.diagrams.elements.common.archilink.ArchiRelationshipEditPart;
import org.modelio.diagram.elements.core.figures.IPenOptionsSupport;
import org.modelio.diagram.elements.core.figures.LinkFigure;
import org.modelio.diagram.elements.core.figures.RoundedLinkFigure;
import org.modelio.diagram.elements.core.figures.decorations.DefaultPolylineDecoration;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.MetaKey;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

/**
 * EditPart for a {@link GmAssociation} Link.
 */
@objid ("e695bc9e-a603-4776-a10b-b342d859750d")
public class AssociationEditPart extends ArchiRelationshipEditPart {
    @objid ("13a43801-77fe-4721-aa47-73cf9b918aa8")
    private static final PointList ARROW_TIP = new PointList(new int[] { -1, -1, 0, 0, -1, -1 });

    @objid ("f6252dd7-fefb-4357-990f-f7180522167a")
    @Override
    protected IFigure createFigure() {
        final RoundedLinkFigure connection = new RoundedLinkFigure();

        updateDecorations(connection, getModel());

        refreshFromStyle(connection, getModelStyle());
        return connection;
    }

    @objid ("80f5b7c2-075f-45ab-b85a-ab20511e72cf")
    @Override
    public GmAssociation getModel() {
        return (GmAssociation) super.getModel();
    }

    @objid ("f7587745-c96f-48b1-a71d-edc66b48132f")
    @Override
    public RoundedLinkFigure getFigure() {
        return (RoundedLinkFigure) super.getFigure();
    }

    @objid ("14a9fcb7-81a5-4172-b3ed-7701c28934ad")
    private void updateDecorations(RoundedLinkFigure connection, GmAssociation gmModel) {
        RotatableDecoration deco = createArrowDecoration(gmModel.isDirected());
        connection.setTargetDecoration(deco);

    }

    @objid ("71f81e37-e4ea-42ab-b729-6ad28c3272b3")
    private RotatableDecoration createArrowDecoration(boolean withArrow) {
        if (withArrow) {
            DefaultPolylineDecoration deco = new DefaultPolylineDecoration();
            deco.setTemplate(ARROW_TIP);
            deco.setScale(9, 4);
            deco.setOpaque(false);
            deco.setBackgroundColor(null);
            deco.setFill(false);
            return deco;
        } else {
            return null;
        }

    }

    @objid ("b2a068eb-0ba9-413a-9f8f-cc8e875ec073")
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();

        RoundedLinkFigure connection = getFigure();
        updateDecorations(connection, getModel());
        refreshDecorationsFromStyle(connection, getModelStyle());

    }

    @objid ("c868ea4d-92e7-4cdc-a643-678da127d9be")
    protected void refreshDecorationsFromStyle(LinkFigure connection, IStyle style) {
        GmAssociation gmModel = getModel();

        // Get style values
        int lineWidth = 1;
        LinePattern linePattern = LinePattern.LINE_SOLID;

        if (gmModel.getStyleKey(MetaKey.LINEWIDTH) != null) {
            lineWidth = (style.getInteger(gmModel.getStyleKey(MetaKey.LINEWIDTH)));
        }
        if (gmModel.getStyleKey(MetaKey.LINEPATTERN) != null) {
            linePattern = (style.getProperty(gmModel.getStyleKey(MetaKey.LINEPATTERN)));
        }

        // Target decoration
        RotatableDecoration decoration = connection.getTargetDecoration();
        if (decoration != null) {
            final IPenOptionsSupport pennable = (IPenOptionsSupport) decoration;
            pennable.setLinePattern(linePattern);
            pennable.setLineWidth(lineWidth);
        }

    }

}
