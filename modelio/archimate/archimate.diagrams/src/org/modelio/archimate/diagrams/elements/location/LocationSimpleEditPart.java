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
package org.modelio.archimate.diagrams.elements.location;

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
 * EditPart for a {@link GmLocation} Node in simple mode.
 */
@objid ("5e9a1b1d-beef-4950-ba15-e76aa127ac21")
public class LocationSimpleEditPart extends ArchiElementEditPart {
    @objid ("93e0089d-f5bf-4313-a418-266675306857")
    @Override
    protected IFigure createFigure() {
        // create the figure
        LocationFigure fig = new LocationFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("9bcabe31-f6fe-4a04-9240-adc731a796c1")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof LocationFigure) {
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

    @objid ("cb7e93b2-cd39-4fc9-b526-14fb1c23f4ae")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * A half circle at the top with two curves targeting the middle bottom point of the figure.
     */
    @objid ("74286619-39df-4eeb-9795-1cd34c9ddca6")
    private static class LocationFigure extends ShapedFigure {
        @objid ("ce0e8e39-9867-4fdb-af79-590bf5d7c3c7")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("cdeec005-0f7c-4745-a4b2-5602dd76d31d")
        private ShapedBorder shapedBorder;

        @objid ("b3da38cc-82cf-48e0-b5de-543945ee476c")
        public LocationFigure() {
            super(new LocationShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("4912a547-674f-41ad-bb0c-16a778c03ad7")
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

        @objid ("fb5b5366-492c-4130-a725-d753281922e7")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("fcb84bf6-a0a0-45f8-9efd-1e10457b52cf")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(this.penOptions.lineWidth);
            }

        }

        @objid ("2a4a994b-fbf7-4a37-820c-5e85641d71cb")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 3 * radius<br/>
         * height = 3 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("4e283965-12b6-45a1-807d-2b7caba72ad3")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = LocationShaper.getRadius(rect);
            return new Dimension(radius * 3, radius * 3);
        }

        /**
         * Draws the figure.
         */
        @objid ("e05b7c60-07ac-46b8-bdfe-ed8f132e0706")
        private static class LocationShaper implements IShaper {
            @objid ("3859d8d3-2880-4ee5-9683-8638950f4886")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int radius = getRadius(rect);
                PrecisionPoint center = getCenter(rect);
                path.addArc((float) center.preciseX() - radius, (float) center.preciseY() - radius, radius * 2, radius * 2, 0, 180);

                // Bottom left curve
                //path.lineTo((float) center.preciseX(), (float) center.preciseY() + radius * 2);
                {
                    float cx1 = (float) center.preciseX() - radius;
                    float cy1 = (float) center.preciseY() + radius - radius / 2;
                    float cx2 = (float) center.preciseX() - radius / 10;
                    float cy2 = (float) center.preciseY() + radius;
                    float xEnd = (float) center.preciseX();
                    float yEnd = (float) center.preciseY() + radius * 2;
                    path.cubicTo(cx1, cy1, cx2, cy2, xEnd, yEnd);
                }

                // Bottom right curve
                //path.lineTo((float) center.preciseX() + radius, (float) center.preciseY());
                {
                    float cx1 = (float) center.preciseX() + radius / 10;
                    float cy1 = (float) center.preciseY() + radius;
                    float cx2 = (float) center.preciseX() + radius;
                    float cy2 = (float) center.preciseY() + radius - radius / 2;
                    float xEnd = (float) center.preciseX() + radius;
                    float yEnd = (float) center.preciseY();
                    path.cubicTo(cx1, cy1, cx2, cy2, xEnd, yEnd);
                }
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             * It is horizontally and vertically centered.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("051c415c-74e6-4bab-a256-6e920aa3939a")
            public static PrecisionPoint getCenter(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int radius = getRadius(rect);

                int figureHeight = (int)(radius * 3f);
                return new PrecisionPoint(x + w / 2, y + radius + (h - figureHeight) / 2);
            }

            @objid ("fc3c755b-23db-4996-8881-a619cf6546a7")
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
             * The goal is to ensure a proper constant proportion of the complete drawn figure (half circle + curved lines)
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("03458976-e59a-4ba9-89a0-59e57b968977")
            public static int getRadius(Rectangle rect) {
                int r1 = Math.round(rect.height / 3f);
                int r2 = Math.round(rect.width / 2f);
                return Math.min(r1, r2);
            }

        }

    }

}
