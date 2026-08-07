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
package org.modelio.archimate.diagrams.elements.capability;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.PathData;
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
 * EditPart for a {@link GmCapability} Node in simple mode.
 */
@objid ("b1fb564d-03c7-4820-85fa-ef61792d5015")
public class CapabilitySimpleEditPart extends ArchiElementEditPart {
    @objid ("5da319a1-23fa-49e3-9a2c-497d2813d876")
    @Override
    protected IFigure createFigure() {
        // create the figure
        CapabilityFigure fig = new CapabilityFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("c867eb1c-70a4-41dc-82dd-7dc9857cdcfb")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof CapabilityFigure) {
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

    @objid ("dee63448-050f-4721-9631-06dffecf1677")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Assembles a stairwell-like figure from 6 squares, like this:
     * <pre>
     * ####
     * #  #
     * #######
     * #  #  #
     * ##########
     * #  #  #  #
     * ##########
     * </pre>
     */
    @objid ("2b79414b-3596-48e8-bf5c-a03015443c96")
    private static class CapabilityFigure extends ShapedFigure {
        @objid ("bddad148-f9ba-44a7-941b-127ed487f548")
        private static final Dimension DEFAULT_SIZE = new Dimension(60, 60);

        @objid ("d701cccd-26b5-45c0-ba0d-921e9cc9e8c6")
        private ShapedBorder shapedBorder;

        @objid ("c9f913f5-0374-4531-9dc0-b9a82d470657")
        public CapabilityFigure() {
            super(new CapabilityShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("acc28648-8b44-4d86-938e-22021784c777")
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

        @objid ("342fc5c7-8016-41b4-9ceb-c0448753e8b1")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("a63261b7-06ce-40d0-9508-73b8a4cb0628")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("9e26bd65-aea8-4c45-9a67-7b43fc04f726")
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
            // Same as tempRect.shrink(getLineWidth(), getLineWidth()),
            // but this is more efficient.
            ZoomDrawer.setLineWidth(graphics, lineWidth, tempRect);


            // Draw the inner lines
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(lineWidth);

            Path shapePath = this.shaper.createShapePath(tempRect);
            PathData points = shapePath.getPathData();
            shapePath.dispose();

            // Horizontal lines
            graphics.drawLine(new PrecisionPoint(points.points[4], points.points[5]), new PrecisionPoint(points.points[4], points.points[1]));
            graphics.drawLine(new PrecisionPoint(points.points[8], points.points[9]), new PrecisionPoint(points.points[8], points.points[1]));

            // Vertical lines
            graphics.drawLine(new PrecisionPoint(points.points[8], points.points[9]), new PrecisionPoint(points.points[12], points.points[9]));
            graphics.drawLine(new PrecisionPoint(points.points[4], points.points[5]), new PrecisionPoint(points.points[12], points.points[5]));

            graphics.popState();
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 3 * radius<br/>
         * height = 3 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("1de32037-1f51-4aa1-8909-c8fb58837cf0")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = CapabilityShaper.getEdgeLength(rect);
            return new Dimension(radius * 3, radius * 3);
        }

        @objid ("5465cccf-89fa-4b6d-82a6-799669e8e394")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the main stairwell shape at the center of the bounds.
         */
        @objid ("6d1665c5-3d92-4087-9832-602d63f62108")
        private static class CapabilityShaper implements IShaper {
            @objid ("f9ba8129-e21b-478b-a7be-f08101ebbbee")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;
                int length = getEdgeLength(rect);

                int figureWidth = length * 3;
                int figureHeight = length * 3;

                // Make sure the figure is centered
                int xMargin = (w - figureWidth) / 2;
                int yMargin = (h - figureHeight) / 2;

                // Warning, the order matters here: CapabilityFigure#paintFigure() takes some of these points to draw additional lines
                path.moveTo(x + xMargin + 0 * length, y + yMargin + 3 * length);
                path.lineTo(x + xMargin + 0 * length, y + yMargin + 2 * length);
                path.lineTo(x + xMargin + 1 * length, y + yMargin + 2 * length);
                path.lineTo(x + xMargin + 1 * length, y + yMargin + 1 * length);
                path.lineTo(x + xMargin + 2 * length, y + yMargin + 1 * length);
                path.lineTo(x + xMargin + 2 * length, y + yMargin + 0 * length);
                path.lineTo(x + xMargin + 3 * length, y + yMargin + 0 * length);
                path.lineTo(x + xMargin + 3 * length, y + yMargin + 3 * length);
                path.close();
                return path;
            }

            @objid ("db31eb69-aa15-4fad-b943-7d9f0af1a80a")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The base edge length for the squares is computed from the width and the height of the proposed rectangle.
             * <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the figure into.
             * @return the edge length for the squares.
             */
            @objid ("c7a0f953-3e79-46e5-8f6c-d5c4e4e4b827")
            public static int getEdgeLength(Rectangle rect) {
                int r1 = rect.height / 3;
                int r2 = rect.width / 3;
                int min = Math.min(r1, r2);
                return min - min % 3;
            }

        }

    }

}
