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
package org.modelio.archimate.diagrams.elements.applicationcomponent;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmApplicationComponent} Node in simple mode.
 */
@objid ("e8f82023-874c-45b0-b906-ffea1fe34941")
public class ApplicationComponentSimpleEditPart extends ArchiElementEditPart {
    @objid ("de9608b0-daf1-495a-be75-27d71e0c8145")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final ComponentFigure fig = new ComponentFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("46f8552f-af62-47db-a387-a18aa5ddca80")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ComponentFigure) {
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

    @objid ("22fde498-e83e-4c88-a767-bad6491901a3")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("50de31c9-282c-4a70-b28c-d66c6224ea3a")
    private static class ComponentFigure extends ShapedFigure {
        @objid ("01e89f81-8821-4447-913b-5f38f8fd4d0e")
        private ShapedBorder shapedBorder;

        /**
         * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
         */
        @objid ("65c3fd20-806d-4d82-8e8c-0d5761c2322b")
        public ComponentFigure() {
            super(new ComponentShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            setLayoutManager(layout);
            setSize(40, 30);
            setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));
        }

        @objid ("babc472e-8e53-4253-9c8a-192722ad51d1")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("1ec77d7f-b331-4251-9bfc-4ec86e695a96")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("113b0990-32a4-49aa-9002-4a9cbd5e40cb")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);

            graphics.restoreState();

            // Draw the inner pieces of the component
            Rectangle tempRect = getBounds().getCopy();
            tempRect.resize(-1, -1); // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
            ZoomDrawer.setLineWidth(graphics, this.penOptions.lineWidth, tempRect);

            int x = tempRect.x;
            int y = tempRect.y;

            int d = ((ComponentShaper)this.shaper).getD(tempRect);


            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(this.penOptions.lineWidth);

                Path path = new Path(Display.getCurrent());
                path.moveTo(x + d, y + 4 * d);
                path.lineTo(x + 2 * d, y + 4 * d);
                path.lineTo(x + 2 * d, y + 3 * d);
                path.lineTo(x + d, y + 3 * d);

                path.moveTo(x + d, y + 2 * d);
                path.lineTo(x + 2 * d, y + 2 * d);
                path.lineTo(x + 2 * d, y + d);
                path.lineTo(x + d, y + d);

                graphics.drawPath(path);
                path.dispose();

            graphics.popState();
        }

        @objid ("addcb252-812d-4de5-95d7-2f6c9fe812ea")
        private static class ComponentShaper implements IShaper {
            @objid ("94cc257b-9187-4155-8c9f-cf6b26fef3a5")
            private static final int dmax = 20;

            @objid ("74dae14f-c29f-429d-844b-e26aae568b5f")
            public int getD(Rectangle rect) {
                int d = rect.height / 5;
                   if (( rect.height / 5) > dmax) {
                       d = dmax;
                   }
                   return d;
            }

            @objid ("4752d21c-5b96-44dd-a941-0592a6ea3a78")
            @Override
            public Path createShapePath(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int d = getD(rect);

                Path path = new Path(Display.getCurrent());

                path.moveTo(x + d, y);
                path.lineTo(x + w, y);
                path.lineTo(x + w, y + h);
                path.lineTo(x + d, y + h);
                path.lineTo(x + d, y + 4* d);
                path.lineTo(x, y + 4 * d);
                path.lineTo(x, y + 3 * d);
                path.lineTo(x + d, y + 3 * d);
                path.lineTo(x + d, y + 2 * d);
                path.lineTo(x, y + 2 * d);
                path.lineTo(x, y + d);
                path.lineTo(x + d, y + d);
                path.lineTo(x + d, y);

                path.close();
                return path;
            }

            @objid ("4918ee0a-b4df-4b5e-8d1e-99b26e210302")
            @Override
            public int getShapeLineJoin() {
                return SWT.JOIN_MITER;
            }

            @objid ("66e663a1-5e9b-43a5-9a09-054a6afa2eeb")
            @Override
            public int getShapeLineCap() {
                return SWT.CAP_SQUARE;
            }

            @objid ("d4d6727f-2bd2-4bc9-a5ec-958c5c6dc8c8")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int d = getD(rect);

                int topInset = rect.height * 10 / 100;
                int leftInset = 2 * d + 10;
                int bottomInset = rect.height * 10 / 100;
                int rightInset = 10;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

        }

    }

}
