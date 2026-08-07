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
package org.modelio.archimate.diagrams.elements.assessment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
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
 * EditPart for a {@link GmAssessment} Node in simple mode.
 */
@objid ("2e1015ea-ba14-4463-987a-aa8735766b36")
public class AssessmentSimpleEditPart extends ArchiElementEditPart {
    @objid ("3af6f107-124c-4210-acd3-65cf9a657575")
    @Override
    protected IFigure createFigure() {
        // create the figure
        AssessmentFigure fig = new AssessmentFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("486f617e-564d-4ce1-862d-8191598cdc2f")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof AssessmentFigure) {
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

    @objid ("844d4a3b-4825-46f3-ba6e-926730a1c4df")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * A circle in the top right corner with a line from the bottom left corner to the circle, targeting its center.
     */
    @objid ("5df9a634-d3a6-4bba-9d88-40e9706b1e7e")
    private static class AssessmentFigure extends ShapedFigure {
        @objid ("61f6a786-00c9-47b5-96ea-9f03ffddab8c")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("0dd50c32-b278-45a3-9eec-071e41cca9ef")
        private ShapedBorder shapedBorder;

        @objid ("8e311c7e-e049-49ff-a90f-40c6cffea9f3")
        public AssessmentFigure() {
            super(new AssessmentShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("74440390-0481-4856-845c-5b5ed4774e4e")
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

        @objid ("9e29097c-1f58-40e7-a6b7-40a9a164188e")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("849ef95c-3646-4d16-ad89-add32a07c649")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(this.penOptions.lineWidth);
            }

        }

        @objid ("0e8fefa7-352d-47e1-a246-f6ab0f146f84")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);

            // Take line width into account to compute proper bounds like the ShapedBorder does
            int lineWidth = getLineWidth();
            Rectangle tempRect = getBounds().getCopy();
            if (lineWidth % 2 != 0) {
                tempRect.width--;
                tempRect.height--;
            }
            tempRect.shrink(lineWidth / 2, lineWidth / 2);

            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(getLineWidth());
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);

            int radius = AssessmentShaper.getRadius(tempRect);
            PrecisionPoint center = AssessmentShaper.getCenter(tempRect);

            double ratio = 2.5f;
            int x1 = (int)(center.x - radius * ratio);
            int y1 = (int)(center.y + radius * ratio);

            // Assume the segment goes to the circle's center
            PrecisionPoint intersection = findFirstIntersection(x1, y1, center.preciseX(), center.preciseY(), center.preciseX(), center.preciseY(), radius);
            if (intersection != null) {
                //graphics.drawLine(x1, y1, (int)Math.round(intersection.preciseX()), (int)Math.round(intersection.preciseY()));
                //graphics.drawLine((int)Math.round(intersection.preciseX()), (int)Math.round(intersection.preciseY()), (int)Math.round(intersection.preciseX()) - radius, (int)Math.round(intersection.preciseY()) + radius);
                graphics.drawLine((int)Math.round(intersection.preciseX()), (int)Math.round(intersection.preciseY()), x1, y1);
            }

            graphics.popState();

        }

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
        @objid ("a6955dec-1c83-4e62-b2cf-f8ff63f1c6d7")
        private static PrecisionPoint findFirstIntersection(double x1, double y1, double x2, double y2, double xCenter, double yCenter, double radius) {
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

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 3 * radius<br/>
         * height = 3 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("cfe226ac-3ace-4083-9fbe-0ff511ec91d8")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = AssessmentShaper.getRadius(rect);
            return new Dimension(radius * 3, radius * 3);
        }

        /**
         * Draws the circle itself in the top right corner.
         */
        @objid ("dbb3b71b-0b19-4889-b7e6-3881d50ff7df")
        private static class AssessmentShaper implements IShaper {
            @objid ("7c3249fc-e209-4740-bcb1-2b21eedeb6fc")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int radius = getRadius(rect);
                PrecisionPoint center = getCenter(rect);
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
            @objid ("0d20af96-6c25-423b-9635-ace562c3ef90")
            public static PrecisionPoint getCenter(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int radius = getRadius(rect);

                int figureWidth = (int)(radius * 2.5f);
                int figureHeight = (int)(radius * 2.5f);
                return new PrecisionPoint(x + w - radius - (w - figureWidth) / 2, y + radius + (h - figureHeight) / 2);
            }

            @objid ("dd42add3-30d7-4bed-a554-79adb3f5fa05")
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
             * The goal is to ensure a proper constant proportion of the complete drawn figure (circle + line)
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("2ffe32bf-23f3-4d01-be99-e1f1ac27cd37")
            public static int getRadius(Rectangle rect) {
                int r1 = Math.round(rect.height / 2.5f);
                int r2 = Math.round(rect.width / 2.5f);
                return Math.min(r1, r2);
            }

        }

    }

}
