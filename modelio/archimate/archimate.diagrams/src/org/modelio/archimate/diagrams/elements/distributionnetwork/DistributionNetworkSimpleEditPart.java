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
package org.modelio.archimate.diagrams.elements.distributionnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmDistributionNetwork} Node in simple mode.
 */
@objid ("602aa0fa-7f73-49ec-915b-f3818a0f0fd1")
public class DistributionNetworkSimpleEditPart extends ArchiElementEditPart {
    @objid ("80d8aaf6-dc9e-42b5-9857-98fadf9d2b92")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final DistributionNetworkFigure fig = new DistributionNetworkFigure();
        // Add layout
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        fig.setLayoutManager(layout);
        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);
        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());
        // return the figure
        return fig;
    }

    @objid ("aa1d486c-1d64-46b6-9429-329e33b4b495")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof DistributionNetworkFigure) {
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

    @objid ("8f64171d-612f-4906-93fc-5dbe4e84e4f0")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("e621722f-c695-4b47-8ab6-734f4451f8f8")
    private static class DistributionNetworkFigure extends ShapedFigure {
        @objid ("0180d6aa-28f3-4a9d-8db7-292ab80c6408")
        private static double ARROW_ANGLE_COS = Math.cos(Math.PI / 3);

        @objid ("d5ceb336-0e8a-498a-a2f8-5ffe8c6c4bd2")
        private ShapedBorder shapedBorder;

        @objid ("9c314951-924d-4ea2-9f0e-ca1ccd512107")
        private static final Dimension DEFAULT_SIZE = new Dimension( 60, 60);

        @objid ("d2d56042-3042-404d-83b9-091fa5f956dd")
        public DistributionNetworkFigure() {
            super(new DistributionNetworkShap());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("66a690db-2dc3-49ed-a864-be06515e4059")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
        }

        @objid ("1f0b897e-ecb8-4038-bc96-d285cfdacaf1")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("bb52e62b-b182-47c5-aa3f-8cdbba61f6f5")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        @objid ("b88e96d0-8857-44e2-8933-d304caf557ae")
        private static class DistributionNetworkShap implements IShaper {
            @objid ("ed6ee9ad-1e06-4936-88df-e26aec29cc30")
            @Override
            public Path createShapePath(Rectangle rect) {
                Dimension arrow = getArrowSize(rect);
                Path path = new Path(Display.getCurrent());

                               path.moveTo(rect.x + arrow.width, rect.y + rect.height / 2 - arrow.height / 2);
                path.lineTo(rect.x, rect.y + rect.height / 2);

                path.lineTo(rect.x, rect.y + rect.height / 2);
                path.lineTo(rect.x + arrow.width, rect.y + rect.height / 2 + arrow.height / 2);

                path.lineTo(rect.x + arrow.height / 5, rect.y + rect.height / 2 + arrow.height / 5);
                path.lineTo(rect.x + rect.width - arrow.height / 5, rect.y + rect.height / 2 + arrow.height / 5);

                path.lineTo(rect.x + rect.width, rect.y + rect.height / 2);
                path.lineTo(rect.x + rect.width - arrow.width, rect.y + rect.height / 2 + arrow.height / 2);

                path.lineTo(rect.x + rect.width, rect.y + rect.height / 2);
                path.lineTo(rect.x + rect.width - arrow.width, rect.y + rect.height / 2 - arrow.height / 2);

                path.lineTo(rect.x + rect.width - arrow.height / 5, rect.y + rect.height / 2 - arrow.height / 5);
                path.lineTo(rect.x + arrow.height / 5, rect.y + rect.height / 2 - arrow.height / 5);
                return path;
            }

            @objid ("6cf404ed-6c64-4796-92b4-36c6217bb380")
            private Dimension getArrowSize(Rectangle rect) {
                int a1 = rect.height;
                int a2 = (int) (rect.width / (1 + ARROW_ANGLE_COS) / 2);
                int a = Math.min(a1, a2);
                return new Dimension((int) (a * ARROW_ANGLE_COS), a);
            }

            @objid ("87059d06-820e-4753-91b2-d7677135fdf3")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

        }

    }

}
