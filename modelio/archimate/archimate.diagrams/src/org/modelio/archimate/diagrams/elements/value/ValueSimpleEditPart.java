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
package org.modelio.archimate.diagrams.elements.value;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
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
 * EditPart for a {@link GmValue} Node in simple mode.
 */
@objid ("cdd63803-4e94-4180-8326-9089df135b32")
public class ValueSimpleEditPart extends ArchiElementEditPart {
    @objid ("b25dda12-2798-4ff5-8231-b83b98f31554")
    @Override
    protected IFigure createFigure() {
        // create the figure
        IFigure fig = new ValueFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("7c7a7d73-b202-49a0-9759-9cce0b4552ca")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ValueFigure) {
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

    @objid ("e881a101-d8a9-47ce-bf95-91e34a3cf8fe")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("6a0cc1a7-3299-4653-9fcd-208689017e9f")
    private static class ValueFigure extends ShapedFigure {
        @objid ("31371982-2536-4dd1-acc3-7946c79d4a8c")
        private ShapedBorder shapedBorder;

        @objid ("ad68cec0-514e-44f3-8691-bbb96d82ecf9")
        public ValueFigure() {
            super(new EllipseShaper());

            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);

            this.setLayoutManager(layout);

            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor,
                    this.penOptions.lineWidth,
                    this.shaper);

            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));
            setSize(60, 40);
            setOpaque(true);

        }

        /**
         * Shapes an ellipse that touches the given rectangle borders.
         *
         * @author phv
         */
        @objid ("7ff91f8e-aa00-4c2c-b6db-0bf25a3b8a11")
        private static class EllipseShaper implements IShaper {
            @objid ("0edc1e92-d246-406a-8b61-f4bd2abb75e9")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                final int a = rect.width / 2;
                final int b = rect.height / 2;
                final double sqrt2 = Math.sqrt(2);
                final int x = (int) Math.ceil(a / sqrt2);
                final int y = (int) Math.ceil(b / sqrt2);
                return new Insets(b - y, a - x, b - y, a - x);
            }

            @objid ("27d5b35d-a6cc-4122-b6cc-f87333372e0d")
            @Override
            public Path createShapePath(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width - 1;
                int h = rect.height - 1;

                Path path = new Path(Display.getCurrent());

                path.moveTo(x, y);
                path.addArc(x, y, w, h, 0, 360);
                return path;
            }

            /**
             * Default constructor.
             */
            @objid ("490a8620-8309-4c22-b9d8-61bf671340bf")
            public EllipseShaper() {
                // Empty
            }

        }

    }

}
