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
 * Value Stream figure is a chevron figure, pointing to the right.
 */
@objid ("b210cc4f-7dda-4326-8de5-cbf2c99da15d")
public class StreamFigure extends ShapedFigure {
    @objid ("f2141ce3-2214-4b65-bf78-d204430a8aa2")
    private final ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("1abe74d5-5805-4606-90d3-88d3e9e3a062")
    public StreamFigure() {
        super(new StreamShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

    }

    @objid ("28155b9c-6959-4af9-942a-50311f2a59ce")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("ecc53b03-f428-4994-8bba-9caf006acebc")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("ce9b78b8-c829-434a-8c05-22ed39a32c72")
    private static class StreamShaper implements IShaper {
        @objid ("4bc7e6da-af71-41cd-9df3-1c99255464a7")
        public StreamShaper() {

        }

        @objid ("60a6aa38-c383-4efe-adec-9bb118b7ca16")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x, y);
            path.lineTo(x + w * 4 / 5, y);
            path.lineTo(x + w, y + h / 2);
            path.lineTo(x + w * 4 / 5, y + h);
            path.lineTo(x, y + h);
            path.lineTo(x + w / 5, y + h / 2);
            path.close();
            return path;
        }

        @objid ("2e7cae5f-cf44-4570-b9a0-ff29a55ec75a")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = rect.height * 5 / 100;
            int leftInset = rect.width * 20 / 100;
            int bottomInset = rect.height * 5 / 100;
            int rightInset = rect.width * 20 / 100;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

    }

}
