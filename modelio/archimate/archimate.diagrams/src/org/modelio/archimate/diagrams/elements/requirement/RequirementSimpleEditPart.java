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
package org.modelio.archimate.diagrams.elements.requirement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
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
 * EditPart for a {@link GmRequirement} Node in simple mode.
 */
@objid ("d4e967e2-65e6-4836-8895-f2b034cc1914")
public class RequirementSimpleEditPart extends ArchiElementEditPart {
    @objid ("a74ba4e9-a37e-4d09-b974-da29e211300b")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final RequirementFigure fig = new RequirementFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("d55b19f8-f6d9-4f11-a808-2e3e44baaafc")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RequirementFigure) {
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

    @objid ("6976b770-b296-49cf-8fc5-e3aa0a3fa393")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("9877a969-7488-4728-87e3-0d40c929c71e")
    private static class RequirementFigure extends ShapedFigure {
        @objid ("45a0db1d-7aeb-4785-947e-bd6f0c5e5226")
        private static double ANGLE = 81 * (Math.PI / 2) / 90;

        @objid ("1c72dd5a-2422-41b2-9ea5-a7397a24eca3")
        private ShapedBorder shapedBorder;

        @objid ("36b4d79a-ab32-4e4e-be83-afe17e83516d")
        public RequirementFigure() {
            super(new RequirementShaper(ANGLE));
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(40, 30);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

        }

        @objid ("ffbf0931-3920-4837-9b41-69e80e2f5b2f")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("7bf3de41-178d-490d-b70a-f76e429629a6")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        @objid ("6cf440e1-2dbc-4d4d-a258-a01465cae3cc")
        public static class RequirementShaper implements IShaper {
            @objid ("4beabab1-4e65-4837-873c-210c6bd07d88")
            private double cosAlpha;

            @objid ("1f22e527-70f8-472b-a6af-6016cdf511f3")
            public RequirementShaper(double angle) {
                this.cosAlpha = Math.cos(angle);
            }

            @objid ("836a759f-201a-4fa7-9907-06f61fec1e82")
            @Override
            public Path createShapePath(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;
                int d = getSlant(rect);

                Path path = new Path(Display.getCurrent());

                path.moveTo(x + d, y);
                path.lineTo(x + w, y);
                path.lineTo(x + w - d, y + h);
                path.lineTo(x, y + h);
                path.close();
                return path;
            }

            @objid ("c3d69fe5-3417-4a6c-9e1c-a20bf0f58993")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int d = getSlant(rect);
                return new Insets(0, d, 0, d);
            }

            @objid ("4d5e20a8-c688-49d9-9582-0e6adacccbea")
            private int getSlant(Rectangle rect) {
                return Math.min(rect.width * 10 / 100, (int) (rect.height * this.cosAlpha));
            }

        }

    }

}
