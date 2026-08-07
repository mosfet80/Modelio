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
package org.modelio.archimate.diagrams.elements.driver;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
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
 * EditPart for a {@link GmDriver} Node in simple mode.
 */
@objid ("526e9cfb-a288-4079-94df-a0b3264ea0b2")
public class DriverSimpleEditPart extends ArchiElementEditPart {
    @objid ("6eb27da7-22e1-4b45-aec8-1ed6cd56cea5")
    @Override
    protected IFigure createFigure() {
        // create the figure
        DriverFigure fig = new DriverFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("6ea972a9-c4f3-4fd9-b326-49d077f1336c")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof DriverFigure) {
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

    @objid ("a5ffada0-366a-46ba-97ba-33ca1713b98e")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Assembles two circles and some lines:
     * <ul>
     * <li>Outer circle based on a shaper dealing with the clipping.</li>
     * <li>Inner filled circle with a 1/3 radius.</li>
     * <li>4 lines crossing the circles in a star pattern,
     * </ul>
     */
    @objid ("a991f1e6-48ff-40d1-9edc-b72282e91a9e")
    private static class DriverFigure extends ShapedFigure {
        @objid ("3f0271d3-c9ef-4dc4-86af-dcb2c5d9a814")
        private static final double BOTTOMLEFT_ANGLE_RADIAN = Math.toRadians(135);

        @objid ("27270461-7ec3-4f96-a71e-4b1a24664c6b")
        private static final double BOTTOMRIGHT_ANGLE_RADIAN = Math.toRadians(45);

        @objid ("41a3125f-cb66-475c-8222-c21cf114a4c3")
        private static final double TOPLEFT_ANGLE_RADIAN = Math.toRadians(225);

        @objid ("f66d0eb7-2311-4be8-8b93-89f4b52b91f5")
        private static final double TOPRIGHT_ANGLE_RADIAN = Math.toRadians(315);

        @objid ("4804dea4-3b48-4912-a634-d5c548ae0b5e")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("79030ea7-58a8-4467-88c8-56c8b525201a")
        private ShapedBorder shapedBorder;

        @objid ("d16f2e82-a49e-4ea3-a4dd-7bf5bfe95d5d")
        public DriverFigure() {
            super(new DriverShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("64a2bac0-97ae-4ea9-a28a-11e6d635d997")
        @Override
        public Dimension getPreferredSize(int wHint, int hHint) {
            if (wHint != -1 && hHint != -1) {
                // Both width and height hints
                return computePreferredSize(new Rectangle(0, 0, wHint, hHint));
            } else if (wHint == -1 && hHint != -1) {
                // No width hint at all, simulate width larger than height
                return computePreferredSize(new Rectangle(0, 0, Integer.MAX_VALUE, hHint));
            } else if (wHint != -1 && hHint == -1) {
                // No height hint at all, simulate height far larger than width
                return computePreferredSize(new Rectangle(0, 0, wHint, Integer.MAX_VALUE));
            } else {
                return super.getPreferredSize(wHint, hHint);
            }
        }

        @objid ("bca82422-e7c0-4362-96ea-f656443d6b82")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("4659f3da-7fce-4a5a-b6ca-1bee0e0aedf4")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("824a9a48-15c1-4c0c-9ffc-338d93710fb8")
        @Override
        protected void paintFigure(Graphics graphics) {
            try {
                // Draw the outer circle
                super.paintFigure(graphics);

                graphics.restoreState();

                // Take line width into account to compute proper bounds like the ShapedBorder does
                Rectangle tempRect = getBounds().getCopy();
                //ZoomDrawer.setLineWidth(graphics, lineWidth, tempRect);

                int radius = DriverShaper.getRadius(tempRect);
                Point center = DriverShaper.getCenter(tempRect);

                // Draw the full inner circle
                graphics.pushState();
                graphics.setBackgroundColor(this.penOptions.lineColor);
                graphics.setAdvanced(true);
                graphics.setAntialias(SWT.ON);

                int radius2 = Math.round(radius / 4.0f);
                graphics.fillOval(center.x - radius2, center.y - radius2, 2 * radius2, 2 * radius2);

                graphics.popState();

                // Draw the star lines
                graphics.pushState();
                graphics.setForegroundColor(this.penOptions.lineColor);
                graphics.setLineWidth(Math.max(this.penOptions.lineWidth - 1, 1));
                graphics.setAdvanced(true);
                graphics.setAntialias(SWT.ON);

                // Top left to bottom right
                int topLeftX = (int) Math.round(center.x + radius * Math.cos(TOPLEFT_ANGLE_RADIAN));
                int topLeftY = (int) Math.round(center.y + radius * Math.sin(TOPLEFT_ANGLE_RADIAN));
                int bottomRightX = (int) Math.round(center.x + radius * Math.cos(BOTTOMRIGHT_ANGLE_RADIAN));
                int bottomRightY = (int) Math.round(center.y + radius * Math.sin(BOTTOMRIGHT_ANGLE_RADIAN));
                graphics.drawLine(topLeftX, topLeftY, bottomRightX, bottomRightY);

                // Middle left to middle right
                graphics.drawLine(center.x - radius, center.y, center.x + radius, center.y);

                // Bottom left to top right
                int bottomLeftX = (int) Math.round(center.x + radius * Math.cos(BOTTOMLEFT_ANGLE_RADIAN));
                int bottomLeftY = (int) Math.round(center.y + radius * Math.sin(BOTTOMLEFT_ANGLE_RADIAN));
                int topRightX = (int) Math.round(center.x + radius * Math.cos(TOPRIGHT_ANGLE_RADIAN));
                int topRightY = (int) Math.round(center.y + radius * Math.sin(TOPRIGHT_ANGLE_RADIAN));
                graphics.drawLine(bottomLeftX, bottomLeftY, topRightX, topRightY);

                // Top middle to bottom middle
                graphics.drawLine(center.x, center.y - radius, center.x, center.y + radius);

                graphics.popState();
            } finally {
            }
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 2 * radius<br/>
         * height = 2 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("5818c316-63b2-4dfb-821c-d030349cb5a1")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = DriverShaper.getRadius(rect);
            return new Dimension(radius * 2, radius * 2);
        }

        @objid ("197d0ac2-858a-47a1-872c-40bd3298236f")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the circle itself at the center of the bounds.
         */
        @objid ("466082ef-2ce9-4ee8-80cc-06e79052067b")
        private static class DriverShaper implements IShaper {
            @objid ("edc36c96-4782-4703-9da1-ccd35afcf400")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int baseRadius = getRadius(rect);

                // Slightly reduce the theoretical radius, we want the lines to go out of the circle a little
                int actualRadius = getRadius(rect) - Math.round(baseRadius / (10.0f));

                Point center = getCenter(rect);
                path.addArc((float) center.preciseX() - actualRadius, (float) center.preciseY() - actualRadius, actualRadius * 2, actualRadius * 2, 0, 360);
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("ef17141a-c0e1-49b0-91ac-1c080f387f84")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("ec6c00d4-0b70-46bb-91f7-8d2569321ff0")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The theoretical radius is computed from the width and the height of the proposed rectangle.
             * <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("da916d80-48b8-474c-92ef-019131f0b7e5")
            public static int getRadius(Rectangle rect) {
                int r1 = rect.height / 2;
                int r2 = rect.width / 2;
                int radius = Math.min(r1, r2);
                // Make sure the radius is divisible by 2 to avoid rounding problems later
                return radius - radius % 2;
            }

        }

    }

}
