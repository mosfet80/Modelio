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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;

@objid ("fcbef991-2b2b-4cdc-b191-8b873dc2be9e")
public class CylinderFigure extends ShapedFigure {
    @objid ("3185aca0-52d7-47ad-bad4-0776d6491c2d")
    private ShapedBorder shapedBorder;

    @objid ("8b277c5d-6734-40ee-9920-8d0c57dc95ad")
    public CylinderFigure() {
        super(new CylinderShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));
    }

    @objid ("f971b3ee-de14-4582-8e76-37de004cd12e")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("9230e1fa-ba83-4773-8c05-f1bcb8f4a7e5")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }
    }

    @objid ("bb98f50a-6c46-48df-9bb5-dcca31e63ff9")
    private static class CylinderShaper implements IShaper {
        @objid ("fd3ba00f-b06c-4582-8e9e-9e0b5cd9bf2c")
        public CylinderShaper() {

        }

        @objid ("d265ad49-f4b6-4f9f-875f-003f54fbb52b")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            int d = getDepth(rect);

            Path path = new Path(Display.getCurrent());

            path.moveTo(x + d, y); // Start at the top left corner
            path.lineTo(x + w - d - d, y); // Draw to the top right corner
            path.addArc(x + w - d - d, y, 2 * d, h, 90, -180); // Draw the outer right arc
            path.lineTo(x + d, y + h); // Draw to the bottom left corner
            path.addArc(x, y, 2 * d, h, -90, -180); // Draw the left arc
            path.close();

            // Draw the inner right arc
            path.moveTo(x + w - d - d, y); // Move to the top right corner
            path.addArc(x + w - d - d, y, 2 * d, h, -90, -180); // Draw the inner right arc
            return path;
        }

        @objid ("222fbf8b-f972-4368-a71a-6e43436a71e9")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int d = CylinderShaper.getDepth(rect);
            int topInset = 0;
            int leftInset = d;
            int bottomInset = 0;
            int rightInset = d * 2;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

        @objid ("4d462208-5d2a-43d0-b76a-5186e218578f")
        public static int getDepth(Rectangle rect) {
            return Math.min(rect.width * 15 / 100, rect.height * 20 / 100);
        }

    }

}
