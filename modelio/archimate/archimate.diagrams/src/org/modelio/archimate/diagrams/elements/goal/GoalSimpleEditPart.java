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
package org.modelio.archimate.diagrams.elements.goal;

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
 * EditPart for a {@link GmGoal} Node in simple mode.
 */
@objid ("f7ffdf52-cbb6-42dc-81b2-76597e01b4a4")
public class GoalSimpleEditPart extends ArchiElementEditPart {
    @objid ("15fa3c62-6aba-42df-b518-6ce6de529098")
    @Override
    protected IFigure createFigure() {
        // create the figure
        GoalFigure fig = new GoalFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("c6819120-ac26-47d8-9e1e-44bbf63ed83b")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof GoalFigure) {
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

    @objid ("0a6e6fe7-2bac-4804-a923-bf89b22650bb")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Assembles three circles inside one another:
     * <ul>
     * <li>Outer circle based on a shaper dealing with the clipping.</li>
     * <li>Middle circle with a 2/3 radius.</li>
     * <li>Inner filled circle with a 1/3 radius.</li>
     * </ul>
     */
    @objid ("2b72a362-0a99-4dd0-a31b-f69012ab6071")
    private static class GoalFigure extends ShapedFigure {
        @objid ("a7170bcd-c11c-4e78-ba4d-394a2a7c4655")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("b0c79672-94a1-4185-9a4f-7a60d7cad6a0")
        private ShapedBorder shapedBorder;

        @objid ("5f584e34-251e-4ff5-b9ec-4ae6688bc18e")
        public GoalFigure() {
            super(new GoalShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("ab2329bd-c025-4e7a-8046-57ea299b0451")
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

        @objid ("8b899489-5706-4a70-84a4-5c717c319b4c")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("608443d4-4246-49d2-8cf8-b21315c5c78e")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("ab96723e-e9a7-46f4-988e-6a793935910e")
        @Override
        protected void paintFigure(Graphics graphics) {
            // Shrink the bounds to draw the circle (therefore fooling the shaper)
            int lineWidth = getLineWidth();

            // Draw the outer circle
            super.paintFigure(graphics);
            graphics.restoreState();

            // Take line width into account to compute proper bounds like the ShapedBorder does
            Rectangle tempRect = getBounds().getCopy();
            tempRect.resize(-1, -1);
            ZoomDrawer.setLineWidth(graphics, lineWidth, tempRect);

            Point center = GoalShaper.getCenter(tempRect);
            int radius = GoalShaper.getRadius(tempRect);

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
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 2 * radius<br/>
         * height = 2 * radius<br/>
         *
         * where radius is computed using the shaper.
         */
        @objid ("65099b15-1f11-43fc-a3a4-13b2b06ac694")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = GoalShaper.getRadius(rect);
            return new Dimension(radius * 2, radius * 2);
        }

        @objid ("c3a40a16-0e08-4586-871d-bd2e4d09cde6")
        @Override
        public int getLineWidth() {
            return super.getLineWidth();
        }

        /**
         * Draws the circle itself at the center of the bounds.
         */
        @objid ("bc8a4807-5abc-438f-a949-6a5ff1071e11")
        private static class GoalShaper implements IShaper {
            @objid ("3b1527b3-c98c-4490-9b5b-8db234ecac62")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int radius = getRadius(rect);
                Point center = getCenter(rect);
                path.addArc((float) center.preciseX() - radius, (float) center.preciseY() - radius, radius * 2, radius * 2, 0, 360);
                path.close();
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             * It is horizontally centered.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("156c98af-dbe2-4431-bc73-4c7954ac8ece")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("9bc42264-7e12-48b0-b54d-84084db515fc")
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
            @objid ("7df72c6d-c517-4d57-896c-2ddb2c91b583")
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
