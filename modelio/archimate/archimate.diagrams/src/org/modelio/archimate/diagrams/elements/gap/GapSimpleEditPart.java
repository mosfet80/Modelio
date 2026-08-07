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
package org.modelio.archimate.diagrams.elements.gap;

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
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmGap} Node in simple mode.
 */
@objid ("b423ccc5-4fc7-4c93-a891-0afc9582f910")
public class GapSimpleEditPart extends ArchiElementEditPart {
    @objid ("56268854-761c-4f11-b866-6679924f6cb0")
    @Override
    protected IFigure createFigure() {
        // create the figure
        GapFigure fig = new GapFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 70);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("7fefc0ca-a5c0-467c-a905-1e47afc146a0")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof GapFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final INodeWithArchiHeader gmModel = (INodeWithArchiHeader) getModel();
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

    @objid ("ba7b7405-fa36-4504-afb8-320f643db9a3")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Assembles three circles inside one another and then adds a diagonal arrow:
     * <ul>
     * <li>Outer circle based on a shaper dealing with the clipping.</li>
     * <li>Middle circle with a 2/3 radius.</li>
     * <li>Inner circle with a 1/3 radius.</li>
     * <li>Diagonal arrow with a tail targeting the center of the circles</li>
     * </ul>
     */
    @objid ("b4087b9b-674e-43f7-98af-a6c67e0fbd72")
    private static class GapFigure extends ShapedFigure {
        @objid ("9cf22987-23c3-4fdd-b8c8-75fede9bce78")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("4c997fc6-89b3-42cf-b2c9-69418913a35e")
        private ShapedBorder shapedBorder;

        @objid ("0bac4a60-9040-4b36-98aa-9ab193a4dbc2")
        public GapFigure() {
            super(new GapShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("6a939ac7-88a9-405c-bf66-6a5560200e2e")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("95b3bfbf-6de1-4546-8d7c-f0b6d2fbf58a")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("9166e55d-1941-49d8-a656-0fe44ba0c558")
        @Override
        protected void paintFigure(Graphics graphics) {
            // Shrink the bounds to draw the circle (therefore fooling the shaper)
            int lineWidth = getLineWidth();
            final Rectangle innerRect = getBounds().getCopy().shrink(lineWidth, lineWidth);
            Path shapePath = this.shaper.createShapePath(innerRect);
            try {
                graphics.setClip(shapePath);

                // Draw the outer circle
                super.paintFigure(graphics);
                graphics.restoreState();

                // Take line width into account to compute proper bounds like the ShapedBorder does
                Rectangle tempRect = getBounds().getCopy();
                // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
                tempRect.resize(-1, -1);
                // Same as tempRect.shrink(getLineWidth(), getLineWidth()),
                // but this is more efficient.
                ZoomDrawer.setLineWidth(graphics, lineWidth, tempRect);


                // Draw the full inner circle
                graphics.pushState();
                graphics.setBackgroundColor(this.penOptions.lineColor);
                graphics.setAdvanced(true);
                graphics.setAntialias(SWT.ON);

                Point aCenter = GapShaper.getCenter(tempRect);
                int circleRadius = GapShaper.getCircleRadius(tempRect);

                graphics.drawLine(new Point(aCenter.x - (circleRadius + circleRadius/2),  aCenter.y - circleRadius/4), new Point(new Point(aCenter.x + (circleRadius + circleRadius/2),  aCenter.y - circleRadius/4)));
                graphics.drawLine(new Point(aCenter.x - (circleRadius + circleRadius/2),  aCenter.y + circleRadius/4), new Point(new Point(aCenter.x + (circleRadius + circleRadius/2),  aCenter.y + circleRadius/4)));

                graphics.popState();
            } finally {
                shapePath.dispose();
            }
        }

        /**
         * Display a factory
         */
        @objid ("6d2b97a1-0211-429d-8a5a-c177eb5794d2")
        private static class GapShaper implements IShaper {
            @objid ("a5d94d0f-ef5e-45b0-8bdb-3d6192cc625a")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int x = rect.x;
                int y = rect.y;

                float xMidlle = x + rect.width/2;
                float yMidlle = y + rect.height/2;

                int circleRadius = getCircleRadius(rect);

                path.addArc(xMidlle - circleRadius, yMidlle - circleRadius, circleRadius * 2, circleRadius * 2, 0, 360);
                return path;
            }

            @objid ("46e772d4-a602-4593-a47f-4771631d4a02")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            @objid ("6a7c1425-637e-4a63-a22f-8ef003dc31fe")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("ae1b796d-d5e9-4dca-a737-56812939b9e8")
            public static int getCircleRadius(Rectangle rect) {
                int w = rect.width;
                int h = rect.height;

                int maxFigureSize = Math.min(w, h);
                int circleRadius = 3 * maxFigureSize / 10;
                return circleRadius;
            }

        }

    }

}
