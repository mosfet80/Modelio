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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;

/**
 * two circles
 *
 * @author phv
 */
@objid ("9e91f161-1ee4-4f02-b5d9-ee3a237150b0")
public class InterfaceFigure extends ShapedFigure {
    @objid ("0cb0b6b9-cb2a-4cb8-a032-f62d55dee70d")
    private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

    @objid ("ed51a3c1-e22e-4086-ad7c-c5901865332e")
    private ShapedBorder shapedBorder;

    @objid ("2c255aed-f635-4b37-ae34-05164225099d")
    public InterfaceFigure() {
        super(new InterfaceShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(DEFAULT_SIZE);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
    }

    @objid ("f3ea6c1a-eb07-4692-bc69-b245ce741a69")
    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        if (wHint != -1 && hHint != -1) {
            // Both width and height hints
            return computePreferredSize(new Rectangle(0, 0, wHint, hHint));
        } else if (wHint == -1 && hHint != -1) {
            // No width hint at all, simulate width larger than height
            return computePreferredSize(new Rectangle(0, 0, Integer.MAX_VALUE, hHint));
        } else if (wHint != -1 && hHint == -1) {
            // No height hint at all, simulate height far larger than width
            return computePreferredSize(new Rectangle(0, 0, wHint, Integer.MAX_VALUE));
        } else {
            return super.getPreferredSize(wHint, hHint);
        }
    }

    @objid ("28df4a5e-b423-4105-ada5-cf504fb6b6ea")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("ace52866-6d37-4897-99d4-e33337dec6ed")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(this.penOptions.lineWidth);
        }
    }

    @objid ("f8922af9-ea23-4cd8-a872-9155cc536ebb")
    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);

        graphics.restoreState();

        // Take line width into account to compute proper bounds like the ShapedBorder does:
        // - resize(-1, -1) the bounds because bounds bottom right corner is not included in the drawing area.
        // - ZoomDrawer.setLineWidth : Same as tempRect.shrink(getLineWidth(), getLineWidth()), but this is more efficient.
        Rectangle rect = getBounds().getCopy();
        rect.resize(-1, -1);
        ZoomDrawer.setLineWidth(graphics, getLineWidth(), rect);


        int radius = InterfaceShaper.getRadius(rect);

        graphics.pushState();
        graphics.setForegroundColor(this.penOptions.lineColor);
        graphics.setLineWidth(this.penOptions.lineWidth);
        graphics.drawLine(rect.x + rect.width / 2 - radius / 2, rect.y + rect.height / 2, rect.x + rect.width / 2 - radius / 2 - radius, rect.y + rect.height / 2);

        graphics.popState();
    }

    /**
     * The preferred size and proportion for a given rect is computed as:<br/>
     * width = 2 * (radius + offset)<br/>
     * height = radius<br/>
     *
     * where radius and offset are computed using the shaper.
     * @return
     */
    @objid ("0e869ccc-4bc9-4a0e-b398-9229d7f7282d")
    private Dimension computePreferredSize(Rectangle rect) {
        int radius = InterfaceShaper.getRadius(rect);
        return new Dimension((radius) * 3, radius);
    }

    @objid ("4eb59079-7413-43b5-93a3-b0bc1b0ed2d1")
    public static class InterfaceShaper implements IShaper {
        @objid ("d064de08-d312-4a10-a265-1a3360a01b3f")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            int radius = getRadius(rect);

            Path path = new Path(Display.getCurrent());

            path.addArc(x + w / 2 + radius / 2 - radius, y + h / 2 - radius, radius * 2, radius * 2, 0, 360);
            return path;
        }

        @objid ("840b57ec-297b-470f-a393-1b88923df38e")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = 0;
            int leftInset = 0;
            int bottomInset = 0;
            int rightInset = 0;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

        /**
         * The radius is computed from the width and the height of the proposed rectangle. The goal is to ensure a proper constant proportion and centering of the drawn figure (circle + line)
         */
        @objid ("2fe610a4-ff67-484b-8e04-c87b8a2b4d02")
        public static int getRadius(Rectangle rect) {
            int r1 = rect.height / 2;
            int r2 = rect.width / 3;
            return Math.min(r1, r2);
        }

    }

}
