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
package org.modelio.archimate.diagrams.elements.courseofaction;

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
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmCourseOfAction} Node in simple mode.
 */
@objid ("402cee35-c4b8-4d2c-8e66-1061ec18853f")
public class CourseOfActionSimpleEditPart extends ArchiElementEditPart {
    @objid ("c555e92c-b5a6-44e2-80e6-2fdca89f771d")
    @Override
    protected IFigure createFigure() {
        // create the figure
        CourseOfActionFigure fig = new CourseOfActionFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 80, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("85e897d6-ad08-476b-b689-696a70962a93")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof CourseOfActionFigure) {
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

    @objid ("1ca4f6a8-caa9-4e20-801d-2beb04cc3d53")
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
    @objid ("95cdaf95-7896-489e-9c48-bae2195e1ce7")
    private static class CourseOfActionFigure extends ShapedFigure {
        @objid ("a7e9c09b-b55d-425c-bf1d-7af737c11ebf")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("e7b93bd5-397b-42a3-8f3e-17f2098c0da8")
        private ShapedBorder shapedBorder;

        /**
         * Find the first intersection between a segment and a circle.
         *
         * @param x1 starting x coordinate of the segment
         * @param y1 starting y coordinate of the segment
         * @param x2 ending x coordinate of the segment
         * @param y2 ending y coordinate of the segment
         * @param xCenter x coordinate of the circle's center
         * @param yCenter y coordinate of the circle's center
         * @param radius radius of the circle
         * @return the first intersection of both figures. Might be <code>null</code>.
         */
        @objid ("11d5207c-511d-4771-81af-5b5bdfa84136")
        private PrecisionPoint findFirstIntersection(double x1, double y1, double x2, double y2, double xCenter, double yCenter, double radius) {
            double baX = x2 - x1;
            double baY = y2 - y1;
            double caX = xCenter - x1;
            double caY = yCenter - y1;

            double a = baX * baX + baY * baY;
            double bBy2 = baX * caX + baY * caY;
            double c = caX * caX + caY * caY - radius * radius;

            double pBy2 = bBy2 / a;
            double q = c / a;

            double disc = pBy2 * pBy2 - q;
            if (disc >= 0) {
                double tmpSqrt = Math.sqrt(disc);

                // First intersection point
                double abScalingFactor1 = -pBy2 + tmpSqrt;
                double xi1 = x1 - baX * abScalingFactor1;
                double yi1 = y1 - baY * abScalingFactor1;
                return new PrecisionPoint(xi1, yi1);

                // Second intersection point, only if disc > 0
                // double abScalingFactor2 = -pBy2 - tmpSqrt;
                // double xi2 = x1 - baX * abScalingFactor2;
                // double yi2 = y1 - baY * abScalingFactor2;
            }
            return null;
        }

        @objid ("b40098d0-0af2-4c81-9a33-ba3bfa3b4620")
        public CourseOfActionFigure() {
            super(new CourseOfActionShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("0873e2b4-c703-4e0d-9a6f-92b63401d5f1")
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

        @objid ("d4356652-54e5-4439-bceb-ba6b702713bc")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("8f854b04-0f9e-48eb-8e5e-331a24c0d02f")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("89f71a2b-3d38-4b05-ac84-3b3260379af4")
        @Override
        protected void paintFigure(Graphics graphics) {
            // Shrink the bounds to draw the circle (therefore fooling the shaper)
            int lineWidth = getLineWidth();
            try {

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

                int radius = CourseOfActionShaper.getRadius(tempRect);
                Point center = CourseOfActionShaper.getCenter(tempRect);

                // Draw the middle and inner circles
                graphics.pushState();
                graphics.setForegroundColor(this.penOptions.lineColor);
                graphics.setBackgroundColor(this.penOptions.lineColor);
                graphics.setLineWidth(lineWidth);
                graphics.setAdvanced(true);
                graphics.setAntialias(SWT.ON);

                // Middle circle
                int radius2 = Math.round(radius * 2.0f / 3.0f - lineWidth / 2.0f);
                graphics.drawOval(center.x - radius2, center.y - radius2, 2 * radius2, 2 * radius2);

                // Inner circle
                int radius3 = Math.round(radius / 3.0f - lineWidth / 2.0f);
                graphics.fillOval(center.x - radius3, center.y - radius3, 2 * radius3, 2 * radius3);

                graphics.popState();

                // Draw the arrow
                drawArrow(graphics, center, lineWidth, radius, radius3);
            } finally {
            }
        }

        @objid ("4bd2a5eb-28f5-4600-bf7b-af3d71110d62")
        protected void drawArrow(Graphics graphics, Point center, int lineWidth, int radius, int radius3) {
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setBackgroundColor(this.penOptions.lineColor);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);
            int arrowLineWidth = Math.round(lineWidth * 1.5f);
            graphics.setLineWidth(arrowLineWidth);

            int x = Math.round(center.x - radius * 2f);
            int y = Math.round(center.y + radius * 2f);
            PrecisionPoint intersection = findFirstIntersection(x, y, center.preciseX() - radius3, center.preciseY() - radius3, center.preciseX() - radius3, center.preciseY() - radius3, radius);
            if (intersection != null) {
                // Arrow head
                int arrowLength = (int) (Math.max(radius3 * 1.5f, arrowLineWidth * 2f));
                graphics.fillPolygon(new int[] {
                        intersection.x, intersection.y,
                        intersection.x - arrowLength, intersection.y - arrowLength / 3,
                        intersection.x - arrowLength / 3, intersection.y + arrowLength
                });

                // Arrow body
                graphics.drawPolyline(new int[] {
                        x, y,
                        x + (intersection.x - x) / 3, intersection.y + (y - intersection.y) / 3,
                        intersection.x - arrowLineWidth, intersection.y + arrowLineWidth
                });
            }

            graphics.popState();
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 3 * radius<br/>
         * height = 3 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("f13663fc-597e-43c0-bb45-bc5cd0ae3bf5")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = CourseOfActionShaper.getRadius(rect);
            return new Dimension(radius * 3, radius * 3);
        }

        @objid ("be7e6b23-2d73-4ba9-bcc2-467cd0811f76")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the circle itself at the center of the bounds.
         */
        @objid ("8cba36cf-f9c0-4713-80ac-eb15a12b42cc")
        private static class CourseOfActionShaper implements IShaper {
            @objid ("c18a83b0-93e2-459d-879f-178de9ff4789")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int radius = getRadius(rect);
                Point center = getCenter(rect);
                path.addArc((float) center.preciseX() - radius, (float) center.preciseY() - radius, radius * 2, radius * 2, 0, 360);
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle. It is horizontally centered.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("062df18d-39d2-4d8f-bf8d-1fd46e977778")
            public static Point getCenter(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int radius = getRadius(rect);
                int figureWidth = (int)(radius * 3.1f);
                int figureHeight = (int)(radius * 2.5f);
                return new PrecisionPoint(x + w - radius - (w - figureWidth) / 2, y + radius + (h - figureHeight) / 2);
            }

            @objid ("0950f211-98b1-4bb5-ae1b-256ad206d825")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The radius is computed from the width and the height of the proposed rectangle. <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("52c7a63a-f8c4-4461-b3b4-4ff928eaa1a0")
            public static int getRadius(Rectangle rect) {
                int r1 = Math.round(rect.height / 2.5f);
                int r2 = Math.round(rect.width / 3.1f);
                return Math.min(r1, r2);
            }

        }

    }

}
