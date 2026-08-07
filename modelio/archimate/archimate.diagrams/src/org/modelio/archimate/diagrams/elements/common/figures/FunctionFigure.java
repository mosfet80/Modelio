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
 * Function figure is a chevron figure, pointing upwards.
 */
@objid ("88c27999-acd6-4243-9032-1e13aaea3909")
public class FunctionFigure extends ShapedFigure {
    @objid ("a4f4500e-cf71-426a-a701-c9837b61588c")
    private ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("f7eba685-148c-462e-afd9-6de56c7276ff")
    public FunctionFigure() {
        super(new FunctionShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));
    }

    @objid ("7f354a7e-b0d4-445a-8937-db02ae42c2dd")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("19d4ed12-216b-48ae-ba16-b44160d69aca")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }
    }

    @objid ("d2316648-8045-4c3f-bc44-4bfc517e0205")
    private static class FunctionShaper implements IShaper {
        @objid ("a0b07296-7959-4424-b39f-a268fa563a84")
        public FunctionShaper() {

        }

        @objid ("79f05cef-911b-46db-8818-8ac71d4e8207")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x, y + h / 5);
            path.lineTo(x + w / 2, y);
            path.lineTo(x + w, y + h / 5);
            path.lineTo(x + w, y + h);
            path.lineTo(x + w / 2, y + 4 * h / 5);
            path.lineTo(x, y + h);
            path.lineTo(x, y + h / 5);
            path.close();
            return path;
        }

        @objid ("72fb1859-0d3b-4dc2-b860-6e99ec04b011")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = rect.height * 20 / 100;
            int leftInset = rect.width * 5 / 100;
            int bottomInset = rect.height * 20 / 100;
            int rightInset = rect.width * 5 / 100;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

    }

}
