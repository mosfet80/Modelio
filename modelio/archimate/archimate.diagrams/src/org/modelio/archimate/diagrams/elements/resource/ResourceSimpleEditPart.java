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
package org.modelio.archimate.diagrams.elements.resource;

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
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmResource} Node in simple mode.
 */
@objid ("8f40b530-b603-4fd7-860b-70b1b63de0a0")
public class ResourceSimpleEditPart extends ArchiElementEditPart {
    @objid ("6faf7607-4648-4a12-9f0b-86c208b71145")
    @Override
    protected IFigure createFigure() {
        // create the figure
        ResourceFigure fig = new ResourceFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 80, 40);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("42cabc3f-9120-48ee-a3d6-5804a421aaaf")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ResourceFigure) {
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

    @objid ("907fbe7f-f3de-4aa9-b134-ccd7456575ea")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Assembles a battery-like figure, like this:
     * <pre>
     * ####################
     * #                  #
     * #   #  #  #        ###
     * #   #  #  #        # #
     * #   #  #  #        ###
     * #                  #
     * ####################
     * </pre>
     */
    @objid ("10c4768f-88f1-48a0-aa00-f339f0d89fec")
    private static class ResourceFigure extends ShapedFigure {
        @objid ("d427b643-2bd8-4fdf-a6b1-ccce23042399")
        private static final Dimension DEFAULT_SIZE = new Dimension(80, 40);

        @objid ("de5ed6e0-a458-4a22-963f-9a001ba86153")
        private ShapedBorder shapedBorder;

        @objid ("7e552f79-60b4-4d64-bb2a-730a78fbac8e")
        public ResourceFigure() {
            super(new ResourceShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("4f45567b-b322-4b3a-a984-d37ed30c2c65")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("d29b9313-8e11-4004-bc92-cd4d143175f3")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("2b211819-1e42-46aa-8966-bf32f10e5a38")
        @Override
        protected void paintFigure(Graphics graphics) {
            int lineWidth = getLineWidth();

            // Draw the outer figure
            super.paintFigure(graphics);
            graphics.restoreState();

            // Take line width into account to compute proper bounds like the ShapedBorder does
            Rectangle tempRect = getBounds().getCopy();
            // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
            tempRect.resize(-1, -1);
            // Same as tempRect.shrink(getLineWidth(), getLineWidth()), but this is more efficient.
            ZoomDrawer.setLineWidth(graphics, lineWidth, tempRect);


            // Draw the inner lines
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(lineWidth * 2);

            Dimension headDimension = ResourceShaper.getHeadDimension(tempRect);
            int top = tempRect.y + tempRect.height / 5;
            int bottom = tempRect.y + tempRect.height * 4 / 5;
            int zoneWidth = tempRect.width / 6;
            graphics.drawLine(tempRect.x + zoneWidth * 1, top, tempRect.x + zoneWidth * 1, bottom);
            graphics.drawLine(tempRect.x + zoneWidth * 2, top, tempRect.x + zoneWidth * 2, bottom);
            graphics.drawLine(tempRect.x + zoneWidth * 3, top, tempRect.x + zoneWidth * 3, bottom);

            graphics.popState();

            // Draw the line next to the header
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(lineWidth);
            graphics.drawLine(tempRect.x + tempRect.width - headDimension.width, tempRect.y + (tempRect.height - headDimension.height) / 2, tempRect.x + tempRect.width - headDimension.width, tempRect.y + (tempRect.height - headDimension.height) / 2 + headDimension.height);

            graphics.popState();
        }

        @objid ("0fda28e1-7217-4031-a852-ffe661265920")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the main battery shape at the center of the bounds.
         */
        @objid ("b7cc2e1f-d674-46ee-adbf-483815702283")
        private static class ResourceShaper implements IShaper {
            @objid ("088ec5a7-1774-4a42-a336-6e12ff93cd2f")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;
                Dimension headDimension = getHeadDimension(rect);

                int corner = 4;
                path.moveTo(x + corner, y);
                path.lineTo(x + w - headDimension.width - corner, y);
                path.cubicTo(x + w - headDimension.width - corner, y, x + w - headDimension.width, y, x + w - headDimension.width, y + corner);
                path.lineTo(x + w - headDimension.width, y + (h - headDimension.height) / 2);
                path.lineTo(x + w - corner, y + (h - headDimension.height) / 2);
                path.cubicTo(x + w - corner, y + (h - headDimension.height) / 2, x + w, y + (h - headDimension.height) / 2, x + w, y + (h - headDimension.height) / 2 + corner);
                path.lineTo(x + w, y + (h - headDimension.height) / 2 + headDimension.height - corner);
                path.cubicTo(x + w, y + (h - headDimension.height) / 2 + headDimension.height - corner, x + w, y + (h - headDimension.height) / 2 + headDimension.height, x + w - corner, y + (h - headDimension.height) / 2 + headDimension.height);
                path.lineTo(x + w - headDimension.width, y + (h - headDimension.height) / 2 + headDimension.height);
                path.lineTo(x + w - headDimension.width, y + h - corner);
                path.cubicTo(x + w - headDimension.width, y + h - corner, x + w - headDimension.width, y + h, x + w - headDimension.width - corner, y + h);
                path.lineTo(x + corner, y + h);
                path.cubicTo(x + corner, y + h, x, y + h, x, y + h - corner);
                path.lineTo(x, y + corner);
                path.cubicTo(x, y + corner, x, y, x + corner, y);
                path.close();
                return path;
            }

            @objid ("c8a9f2de-ce98-4013-95aa-56184bece3b1")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The dimension of the battery head is computed from the proposed rectangle.
             * <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the figure into.
             * @return the width and height of the head.
             */
            @objid ("9b21aee5-b6e1-4b8b-b322-0cc38e8f7ff3")
            public static Dimension getHeadDimension(Rectangle rect) {
                return new Dimension(rect.width / 8, rect.height / 3);
            }

        }

    }

}
