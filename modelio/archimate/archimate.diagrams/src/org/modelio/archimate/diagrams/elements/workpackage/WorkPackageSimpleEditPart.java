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
package org.modelio.archimate.diagrams.elements.workpackage;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
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
 * EditPart for a {@link GmWorkPackage} Node in simple mode.
 */
@objid ("04538e50-7e2c-43d7-a30f-c65fef09396a")
public class WorkPackageSimpleEditPart extends ArchiElementEditPart {
    @objid ("e391d8b9-3d4e-40b0-b4c4-59cb8c89b154")
    @Override
    protected IFigure createFigure() {
        // create the figure
        WorkPackageFigure fig = new WorkPackageFigure();
        fig.setOpaque(false);

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

    @objid ("be301923-f403-446e-9417-18664b32b538")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof WorkPackageFigure) {
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

    @objid ("6b0ad9e0-1e21-4dde-ba8f-ba9327f61b78")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("714a97e0-67bd-4acf-9664-384b5559d515")
    private static class WorkPackageFigure extends ShapedFigure {
        @objid ("39b24978-9864-4068-84f8-4c5933bb06eb")
        private static final Dimension DEFAULT_SIZE = new Dimension(90, 60);

        @objid ("84c6044e-a13a-4b9f-bcd2-ba64c0f1faf3")
        private ShapedBorder shapedBorder;

        @objid ("8c451715-7e7d-4aff-9bfb-f98c269b0058")
        public WorkPackageFigure() {
            super(new WorkPackageShaper());

            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));
        }

        @objid ("7ffd431d-071a-42cd-bf4e-1337f4709670")
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

        @objid ("86204670-7403-4d65-9748-09c74906b722")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("f6f3613f-5b7d-4db5-986a-92dd8973e85b")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = WorkPackageShaper.getRadius(rect);
            return new Dimension(radius * 2, radius * 2);
        }

        @objid ("4396c076-e022-4615-8aa5-69c6f0dce738")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            setLineWidth(0);
        }

        @objid ("e269bd27-04a2-4361-bd94-4ecec73f5fab")
        @Override
        public void setLineWidth(int lineWidth) {
            this.shapedBorder.setWidth(Math.min(getBounds().width, getBounds().height) / 20);
        }

        @objid ("97a43b4f-d502-4d46-bfe5-85f8808fe46d")
        private static class WorkPackageShaper implements IShaper {
            @objid ("7c374028-6b65-4a23-a385-3f0e0618c1b8")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int baseRadius = getRadius(rect);

                // Slightly reduce the theoretical radius, we want the lines to go out of the circle a little
                float actualRadius = getRadius(rect) - Math.round(baseRadius / (10.0f));
                float marge = actualRadius / 4;
                Point center = getCenter(rect);
                float centerX = (float) center.preciseX();
                float centerY = (float) center.preciseY();

                // Draw the circle
                path.addArc(
                        centerX - actualRadius,
                        centerY - actualRadius + marge,
                        (actualRadius - marge - 1) * 2,
                        (actualRadius - marge) * 2, 0, 360);

                // Draw the horizontal line exiting the circle
                path.moveTo(centerX - marge, centerY + actualRadius - marge);
                path.lineTo(centerX + actualRadius + marge - 12, centerY + actualRadius - marge);

                // Draw the arrow head at the end of the horizontal line
                path.moveTo(centerX + actualRadius - 10,          centerY + actualRadius - (marge * 2));
                path.lineTo(centerX + actualRadius - 10  + marge, centerY + actualRadius - marge );
                path.lineTo(centerX + actualRadius - 10,          centerY + actualRadius);

                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("9769df9b-62f3-4240-b4b2-333f81698e49")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("5177bff2-0374-4228-8a78-d3707a7adb4e")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The theoretical radius is computed from the width and the height of the proposed rectangle. <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("c1a447e9-d230-46c6-ab37-ed5d076c306f")
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
