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
package org.modelio.archimate.diagrams.elements.meaning;

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
 * Meaning figure for Archimate.<br/>
 * Features:
 * <ul>
 * <li>a cloud drawing</li>
 * <li>a ToolbarLayoutWithGrab layout</li>
 * </ul>
 */
@objid ("c6e01d9f-f14c-4cd6-add1-caf86a628016")
public class MeaningFigure extends ShapedFigure {
    @objid ("1c114081-4b58-4318-93e1-8f35e76a009e")
    private ShapedBorder shapedBorder;

    /**
     * C'tor building a new meaning figure, with a {@link ToolbarLayoutWithGrab} by default.
     */
    @objid ("cb2e5d73-e504-4518-8ed7-01dff7238d46")
    public MeaningFigure() {
        super(new MeaningShaper());

        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);

        setSize(30, 40);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(this.penOptions.lineWidth * 2 / 3)));
    }

    @objid ("f1f4f4df-56f1-40d6-be42-c9fc09dea69c")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("bf66f9f2-ea4e-4052-a205-42b24d3f2fb3")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(lineWidth * 2 / 3)));
        }
    }

    @objid ("7ed2168b-3e78-40e7-8ebb-dcc96f6a9706")
    private static class MeaningShaper implements IShaper {
        @objid ("5d9f70bf-a9fd-4a6d-a8d5-40c531187edd")
        public MeaningShaper() {

        }

        @objid ("9e123808-ac86-4fb7-87f8-cc5a2ed47087")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int D = getDepth(rect);
            return new Insets(D * 12 / 10, D * 2, D * 14 / 10, D * 12 / 10);
        }

        @objid ("b7f186c1-2dde-4fbe-a174-ef8e01d55fa6")
        @Override
        public Path createShapePath(Rectangle rect) {
            int descX = rect.width /6;
            int descY = rect.height / 6;
            Rectangle innerRectangle = new Rectangle(rect.x + descX, rect.y, rect.width - descX, rect.height - descY);
            int D = getDepth(innerRectangle);

            int x = innerRectangle.x;
            int y = innerRectangle.y;
            int w = innerRectangle.width;
            int h = innerRectangle.height;


            Path path = new Path(Display.getCurrent());

            path.moveTo(x + w / 2, y + D / 2); // P0

            // Arc 1
            path.cubicTo(x + w / 2, y + D / 2, /* P0 */
                    x + w / 2 + w / 3, y - D / 2, /* P1 */
                    x + 5 * w / 6, y + D); /* P2 */

            // Arc 2
            path.cubicTo(x + 5 * w / 6, y + D, /* P2 */
                    x + w + D, y + D / 2, /* P3 */
                    x + w - D, y + h / 3); /* P4 */

            // Arc3
            path.cubicTo(x + w - D, y + h / 3, /* P4 */
                    x + w + D, y + h / 3 + D / 2, /* P5 */
                    x + w - D, y + h - 2 * D); /* P6 */

            // Arc 4
            path.cubicTo(x + w - D, y + h - 2 * D, /* P6 */
                    x + 6 * w / 6, y + h + D, /* P7 */
                    x + w / 2, y + h - D); /* P8 */

            // Arc 5
            path.cubicTo(x + w / 2, y + h - D, /* P8 */
                    x, y + h, /* P9 */
                    x + 2 * D, y + h - 2 * D); /* P10 */

            // Arc 6
            path.cubicTo(x + 2 * D, y + h - 2 * D, /* P10 */
                    x - D / 2, y + h / 2 - D, /* P11 */
                    x + 2 * D, y + h / 2 - D); /* P12 */

            // Arc 7
            path.cubicTo(x + 2 * D, y + h / 2 - D, /* P12 */
                    x - D, y, /* P16 */
                    x + w / 4, y + D); /* P0 */

            // Arc 8
            path.cubicTo(x + w / 4, y + D, /* P15 */
                    x + w / 4, y - D / 2, /* P16 */
                    x + w / 2, y + D / 2); /* P0 */
            path.close(); // Close the path to form a complete shape

            // Add the descender circles
            path.addArc(x -descX/8 , y + h - descY,descX/2, descY, 0, 360);
            path.addArc(x -descX/2, y + h ,descX/3, descY/2, 0, 360);

            return path;
        }

        @objid ("1796ad08-45c1-4ae1-98c0-b258cd33a677")
        private int getDepth(Rectangle rect) {
            int D = (int) (Math.min(rect.width, rect.height) * 0.10f);
            return D;
        }

    }

}
