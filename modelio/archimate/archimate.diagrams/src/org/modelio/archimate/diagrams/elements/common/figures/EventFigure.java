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

@objid ("a33ed9ea-9d21-495b-8c86-7311ca30a25b")
public class EventFigure extends ShapedFigure {
    @objid ("a5d9923b-e0e2-478c-ad27-15b0166a957d")
    private ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("70a916be-b52e-4593-b5b3-86953b9f3478")
    public EventFigure() {
        super(new EventShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

    }

    @objid ("36c59671-5c2e-4c95-89e5-55f35595ff9e")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("c47aec17-dbb3-4cfa-9c19-df61d71f99bd")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("ca2f189c-d13e-4190-b3dc-d51179858c2b")
    private static class EventShaper implements IShaper {
        @objid ("0d8c10da-0351-4d95-b09d-5d1b1b3c7a08")
        public EventShaper() {
            super();
        }

        @objid ("bf188e08-6fd7-4109-9a90-088c743e653b")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;
            int d = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x, y);
            path.lineTo(x + w - d / 2, y);
            path.addArc(x + w - d, y, d, d, 90, -180);
            path.lineTo(x, y + h);
            path.lineTo(x + d / 4, y + h / 2);
            path.lineTo(x, y);
            path.close();
            return path;
        }

        @objid ("e758e712-a4e9-42f6-9577-9bdf0ed45382")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int radius = rect.height / 2;
            int topInset = rect.height * 10 / 100;
            int leftInset = radius / 2;
            int bottomInset = rect.height * 10 / 100;
            int rightInset = radius - 2 * topInset;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

    }

}
