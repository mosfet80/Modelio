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
package org.modelio.archimate.diagrams.elements.common.figures;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;

@objid ("1bf69f06-df6f-416a-86b5-b2e6a1d20f1f")
public class ServiceFigure extends ShapedFigure {
    @objid ("9d4342ef-8c5e-409c-97d0-532cd90256ad")
    private final ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("b1b18848-82b4-4943-bf60-c7564603aba9")
    public ServiceFigure() {
        super(new ServiceShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

    }

    @objid ("f9fd9942-8290-445a-8d40-e7dd4d9e1cca")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("7cde35ed-4655-44dc-b1b4-6dbed6bca7c0")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("762a2c72-ed7c-452f-82ad-23812334d9d8")
    private static class ServiceShaper implements IShaper {
        @objid ("1793cedc-62bf-4088-ba1e-b5845ebb283d")
        public ServiceShaper() {
            super();
        }

        @objid ("aed620c0-4aa8-45f4-a075-3c0bb93e32e8")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;
            int d = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x + d / 2, y);
            path.lineTo(x + w - d / 2, y);
            path.addArc(x + w - d, y, d, d, 90, -180);
            path.lineTo(x + d / 2, y + h);
            path.addArc(x, y, d, d, -90, -180);
            return path;
        }

        @objid ("ad2ff7b6-58ca-4b9e-96a9-3709f69065d8")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int radius = rect.height / 2;
            int topInset = rect.height * 10 / 100;
            int leftInset = radius / 2;
            int bottomInset = rect.height * 10 / 100;
            int rightInset = radius / 2;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

    }

}
