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
package org.modelio.archimate.diagrams.elements.outcome;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
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
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmOutcome} Node in simple mode.
 */
@objid ("f0a1a098-3a54-4087-a6ee-4b7813a2ab03")
public class OutcomeSimpleEditPart extends ArchiElementEditPart {
    @objid ("62366bf5-de07-4992-ba97-1c65a850b215")
    @Override
    protected IFigure createFigure() {
        // create the figure
        OutcomeFigure fig = new OutcomeFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("58b16b6b-b2e8-413f-881d-8390a552d585")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof OutcomeFigure) {
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

    @objid ("cfc09e56-9f79-4cfe-90f1-f5d5862f2d68")
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
    @objid ("b5846b36-88d2-4fe3-b2b4-a3d0bd9d8835")
    private static class OutcomeFigure extends ShapedFigure {
        @objid ("de1e9e67-a409-4fdb-9836-0c960d4ccea5")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("144a72bd-cc8b-440c-b6f3-c6ff0a790d86")
        private ShapedBorder shapedBorder;

        @objid ("42dd019e-9dd2-4338-9e62-aa30c87db03f")
        public OutcomeFigure() {
            super(new OutcomeShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("18915cbd-9426-4c45-9c78-4c9ffd1e9ad5")
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

        @objid ("a48264f9-5f68-4498-af6f-bca6411de848")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("e6bdaa89-b7a4-456d-9be2-bf7ef6988630")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        @objid ("236db309-e18d-48bd-a793-796795fdb5b8")
        @Override
        protected void paintFigure(Graphics graphics) {
            int lineWidth = getLineWidth();

            // Draw the outer circle
            super.paintFigure(graphics);

            // Take line width into account to compute proper bounds like the ShapedBorder does
            Rectangle tempRect = getBounds().getCopy();
            if (lineWidth % 2 != 0) {
                tempRect.width--;
                tempRect.height--;
            }
            tempRect.shrink(lineWidth / 2, lineWidth / 2);

            int radius = OutcomeShaper.getRadius(tempRect);
            Point center = OutcomeShaper.getCenter(tempRect);

            // Draw the middle and inner circles
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(lineWidth);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);

            // Middle circle
            int radius2 = Math.round(radius * 2.0f / 3.0f - lineWidth / 2);
            graphics.drawOval(center.x - radius2, center.y - radius2, 2 * radius2, 2 * radius2);

            // Inner circle
            int radius3 = Math.round(radius / 3.0f - lineWidth / 2);
            graphics.drawOval(center.x - radius3, center.y - radius3, 2 * radius3, 2 * radius3);

            graphics.popState();

            // Draw the arrow
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setBackgroundColor(this.penOptions.lineColor);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);
            int arrowLineWidth = Math.round(lineWidth * 1.2f);
            graphics.setLineWidth(arrowLineWidth);

            // Arrow head
            int arrowLength = (int) (radius3 * 0.8f);
            graphics.fillPolygon(new int []{center.x - arrowLineWidth, center.y + arrowLineWidth, center.x + arrowLength, center.y, center.x, center.y - arrowLength});

            // Arrow body
            double ratio = 1.2;
            graphics.drawLine(center.x, center.y, (int)(center.x + radius * ratio - 0.5 * arrowLength), (int)(center.y - radius * ratio + 0.5 * arrowLength));

            // Arrow tail
            graphics.drawLine((int)(center.x + ratio * (radius - arrowLength * 1.2)), (int)(center.y + ratio * (arrowLength * 1.2 - radius)), (int)(center.x + radius * ratio), (int)(center.y - radius * ratio) + arrowLength + arrowLineWidth);
            graphics.drawLine((int)(center.x + ratio * (radius - arrowLength * 1.2)), (int)(center.y + ratio * (arrowLength * 1.2 - radius)), (int)(center.x + radius * ratio) - arrowLength - arrowLineWidth, (int)(center.y - radius * ratio));

            graphics.popState();

        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 3 * radius<br/>
         * height = 3 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("8ad25de5-afc3-4067-a270-7c7471382e47")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = OutcomeShaper.getRadius(rect);
            return new Dimension(radius * 3, radius * 3);
        }

        @objid ("4cf6efff-a068-4cc2-b12e-7e364df9a2af")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the circle itself at the center of the bounds.
         */
        @objid ("f306773f-39f8-456f-9c9f-4c1ba98f532c")
        private static class OutcomeShaper implements IShaper {
            @objid ("699bd09c-828d-402d-9769-cdaf1c61c3e5")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int radius = getRadius(rect);
                Point center = getCenter(rect);
                path.addArc((float) center.preciseX() - radius, (float) center.preciseY() - radius, radius * 2, radius * 2, 0, 360);
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             * It is horizontally and vertically centered.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("8959cbf0-a93e-4e2e-a0e3-1ad7be340ee2")
            public static Point getCenter(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int radius = getRadius(rect);
                int figureWidth = (int)(radius * 2.2f);
                int figureHeight = (int)(radius * 2.2f);
                return new PrecisionPoint(x + radius + (w - figureWidth) / 2, y + h - radius - (h - figureHeight) / 2);
            }

            @objid ("cd624258-240c-447d-9b04-3d0646d9b670")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The radius is computed from the width and the height of the proposed rectangle.
             * <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("e9b5239e-455a-486d-be87-093333be97df")
            public static int getRadius(Rectangle rect) {
                int r1 = Math.round(rect.height / 2.2f);
                int r2 = Math.round(rect.width / 2.2f);
                return Math.min(r1, r2);
            }

        }

    }

}
