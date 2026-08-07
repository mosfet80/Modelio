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

/**
 * Process figure is an arrow figure, pointing to the right.
 */
@objid ("8c742415-c38f-4e76-b236-99181f6743d3")
public class ProcessFigure extends ShapedFigure {
    @objid ("b3a7471d-ed22-4e95-9d2e-be4511e59f7d")
    private ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("162552a0-3320-4cb1-b0b1-d9a3f1716e33")
    public ProcessFigure() {
        super(new ProcessShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

    }

    @objid ("c4f3c573-992b-410c-ac5c-e01ff3ab872d")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("3ae8f6b5-ab11-4d3d-a159-e99b79e8868e")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("ed66560d-fb94-43e4-933a-d8fee314afb3")
    private static class ProcessShaper implements IShaper {
        @objid ("fa62002b-d065-4cfb-8da3-da82655406af")
        public ProcessShaper() {

        }

        @objid ("e09513c1-8dd1-4947-b8c6-f03f5db2bb3c")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x, y + 4 * h / 5);
            path.lineTo(x + 2 * w / 3, y + 4 * h / 5);
            path.lineTo(x + 2 * w / 3, y + h);
            path.lineTo(x + w, y + h / 2);
            path.lineTo(x + 2 * w / 3, y);
            path.lineTo(x + 2 * w / 3, y + h / 5);
            path.lineTo(x, y + h / 5);
            path.lineTo(x, y + 4 * h / 5);
            path.close();
            return path;
        }

        @objid ("d86f49f4-9363-446f-9f19-7c8d6eb90245")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = rect.height * 30 / 100;
            int leftInset = rect.width * 5 / 100;
            int bottomInset = rect.height * 30 / 100;
            int rightInset = rect.width * 15 / 100;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

    }

}
