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
package org.modelio.archimate.diagrams.elements.facility;

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
 * EditPart for a {@link GmFacility} Node in simple mode.
 */
@objid ("9fc3f09f-5e89-4ca8-8c6a-e94c432d270a")
public class FacilitySimpleEditPart extends ArchiElementEditPart {
    @objid ("e03d4212-4040-4a5a-b403-0b7009a5a6de")
    @Override
    protected IFigure createFigure() {
        // create the figure
        FacilityFigure fig = new FacilityFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 70);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("76ef36ef-e271-4d21-b3ed-0da4e915f122")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof FacilityFigure) {
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

    @objid ("55eb5512-f62a-4d51-9f24-c7c0185bee93")
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
    @objid ("899b5578-e8b7-47c9-9799-38fd61a7edaf")
    private static class FacilityFigure extends ShapedFigure {
        @objid ("7273a2af-9b9c-4cf5-9969-8bf20028ace9")
        private ShapedBorder shapedBorder;

        @objid ("a192bced-1c57-4883-be5d-141e5f1caa86")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("3e96a9e0-e873-4d6d-9c98-67d0439448fa")
        public FacilityFigure() {
            super(new FacilityShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("c3643f33-927c-4008-b425-d44167b6c4ed")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("e57fad6e-1cce-45fd-89fb-c200f886ba32")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        /**
         * Display a factory
         */
        @objid ("b8de29d9-ef01-4e8d-b4a8-7956bc1abe42")
        private static class FacilityShaper implements IShaper {
            @objid ("94c73534-cabf-4e1b-9336-0a251cded4e8")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int figureWidth = 0;
                int figureHeight = 0;

                if (h > w) {
                    figureHeight = w - (1/10) * w;
                    figureWidth = w;
                } else if (w >= h) {
                    figureWidth = h + (1/10) * w;
                    figureHeight = h;
                }

                // Make sure the figure is centered
                int xMargin = (w - figureWidth) / 2;
                int yMargin = (h - figureHeight) / 2;

                int yOffset = figureHeight / 8;
                int xTine = figureWidth / 4 + figureWidth / 20;
                int yTine = figureHeight / 5;

                path.moveTo(x + xMargin, y + yMargin);
                path.lineTo(x + xMargin, y  + yMargin + figureHeight - yOffset);
                path.lineTo(x + xMargin + figureWidth, y + yMargin + figureHeight - yOffset);
                path.lineTo(x + xMargin + figureWidth, y + yMargin + figureHeight / 3);
                path.lineTo(x + xMargin + figureWidth - xTine, y + yMargin + figureHeight / 3 + yTine);
                path.lineTo(x + xMargin + figureWidth - xTine, y + yMargin + figureHeight / 3);
                path.lineTo(x + xMargin + figureWidth - (2 * xTine), y + yMargin + figureHeight / 3 + yTine);
                path.lineTo(x + xMargin + figureWidth - (2 * xTine), y + yMargin + figureHeight / 3);
                path.lineTo(x + xMargin + figureWidth - (3 * xTine), y + yMargin + figureHeight / 3 + yTine);
                path.lineTo(x + xMargin + figureWidth - (3 * xTine), y + yMargin);
                path.lineTo(x + xMargin, y + yMargin);
                path.close();
                return path;
            }

            @objid ("400be79e-7efd-496e-a9b9-ec2bbb7ddf58")
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
