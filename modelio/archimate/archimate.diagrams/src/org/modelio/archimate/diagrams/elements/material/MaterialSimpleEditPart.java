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
package org.modelio.archimate.diagrams.elements.material;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmMaterial} Node in simple mode.
 */
@objid ("e80ad526-2c77-41f4-9452-297e3c9a5eca")
public class MaterialSimpleEditPart extends ArchiElementEditPart {
    @objid ("50e592e5-0b1f-48e3-9a7d-36f8c059e25e")
    @Override
    protected IFigure createFigure() {
        // create the figure
        MaterialFigure fig = new MaterialFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 70);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("f0b56a08-ea49-4b07-b0f7-310c5484c040")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof MaterialFigure) {
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

    @objid ("b8e9644d-50f3-4999-980b-9ab73d164875")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("594f6def-531b-46dc-b63d-dba845c87567")
    private static class MaterialFigure extends ShapedFigure {
        @objid ("bdc2ad52-dafa-477c-89dc-d5ac38839967")
        private ShapedBorder shapedBorder;

        @objid ("0b13f244-2653-4134-bce8-f90c61ac6498")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("e5fb8af2-adfe-4877-9df2-cc8245b0a3e0")
        public MaterialFigure() {
            super(new MaterialShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("443c2709-99bf-4afb-9357-181972abba0a")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("25067f6b-2c3b-4822-b63b-d45c0d868f51")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("315cc0e4-2fec-44ca-9a6a-62f7a675851e")
        private static class MaterialShaper implements IShaper {
            @objid ("62e74e12-0f0a-40db-81a8-2db60b97352e")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int figureWidth = w;
                int figureHeight = h;

                // Compute dimensions that maintain proper proportions regardless of container shape.
                // The figure is an hexagon, so we need to ensure that the width and height
                // are proportional to the hexagon's geometry, which is 10% wider than it is tall.
                // If available width > height, make figure width proportional to available height (adding 10%)
                // If available height > width, make figure height proportional to available width (subtracting 10%)
                // If square, dimensions remain equal.
                if (w > h) {
                    figureWidth = h +  w / 10;
                } else if (w < h) {
                    figureHeight = w - w / 10;
                }

                // Make sure the figure is centered within the available space
                int xMargin = (w - figureWidth) / 2;
                int yMargin = (h - figureHeight) / 2;

                // Draw hexagon points:
                // Point 1: Top-left vertex (1/4 width from left)
                // Point 2: Left-most vertex (at half height)
                // Point 3: Bottom-left vertex (1/4 width from left, at full height)
                // Point 4: Bottom-right vertex (3/4 width from left, at full height)
                // Point 5: Right-most vertex (at half height)
                // Point 6: Top-right vertex (3/4 width from left)
                // Point 7: Back to Top-left vertex (1/4 width from left)

                path.moveTo(x + xMargin + (figureWidth/4) , y + yMargin);
                path.lineTo(x + xMargin, y + yMargin + (figureHeight/2));
                path.lineTo(x + xMargin + (figureWidth/4), y + yMargin + figureHeight);
                path.lineTo(x + xMargin + 3 * (figureWidth/4), y + yMargin + figureHeight);
                path.lineTo(x + xMargin + figureWidth, y + yMargin + (figureHeight/2));
                path.lineTo(x + xMargin + 3 * (figureWidth/4), y + yMargin);
                path.lineTo(x + xMargin + (figureWidth/4) , y + yMargin);
                path.close();

                path.moveTo(x + xMargin + 3 * (figureWidth/8) , y + yMargin + (figureHeight/10));
                path.lineTo(x + xMargin + (figureWidth/6), y + yMargin + (figureHeight/2));

                path.moveTo(x + xMargin + (figureWidth/3), y + yMargin + figureHeight - (figureHeight/7));
                path.lineTo(x + xMargin + figureWidth - (figureWidth/3), y + yMargin + figureHeight - (figureHeight/7));

                path.moveTo(x + xMargin + figureWidth - 3 * (figureWidth/8) , y + yMargin + (figureHeight/10));
                path.lineTo(x + xMargin + figureWidth - (figureWidth/6), y + yMargin + (figureHeight/2));
                return path;
            }

            @objid ("0267a5c6-6690-45d9-8fba-91835b42d95e")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

        }

    }

}
