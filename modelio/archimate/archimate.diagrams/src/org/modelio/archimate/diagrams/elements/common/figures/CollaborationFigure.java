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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;

/**
 * Two circles crossing each other in the center of the figure.
 *
 * @author phv
 */
@objid ("6aaf1d96-307e-4d13-b28c-9210578c95e0")
public class CollaborationFigure extends ShapedFigure {
    @objid ("6c053c37-d8a4-4912-9166-0316e1820852")
    private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

    @objid ("f7abd899-8ebc-4bf4-be14-d284590b217e")
    private ShapedBorder shapedBorder;

    @objid ("441b8824-e3fa-4c1c-8be4-d8b2a0273f4d")
    public CollaborationFigure() {
        super(new CollaborationShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(DEFAULT_SIZE);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
    }

    @objid ("35a3ce01-b34d-4f08-a637-afe4a4ad03c0")
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

    @objid ("c507a3bf-ddc5-4ee8-9ddb-946f812e32e8")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("6b73efd1-a927-4d84-b2ae-cdbcc8252355")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(this.penOptions.lineWidth);
        }
    }

    @objid ("d238df22-e96b-4d27-bc6f-e9abbf3f90f4")
    @Override
    protected void paintFigure(Graphics graphics) {
        // Paint the background
        super.paintFigure(graphics);

        graphics.restoreState();

        // Take line width into account to compute proper bounds like the ShapedBorder does:
        // - resize(-1, -1) the bounds because bounds bottom right corner is not included in the drawing area.
        // - ZoomDrawer.setLineWidth : Same as tempRect.shrink(getLineWidth(), getLineWidth()), but this is more efficient.
        Rectangle rect = getBounds().getCopy();
        rect.resize(-1, -1);
        ZoomDrawer.setLineWidth(graphics, getLineWidth(), rect);

        graphics.pushState();

        int radius = CollaborationShaper.getRadius(rect);
        int offset = CollaborationShaper.getOffset(rect);

        graphics.setForegroundColor(this.penOptions.lineColor);
        graphics.setLineWidth(this.penOptions.lineWidth);
        graphics.setAdvanced(true);
        graphics.setAntialias(SWT.ON);

        if (true) {
            graphics.drawArc(rect.x + rect.width / 2 - offset - radius, rect.y + rect.height / 2 - radius, radius * 2,
                    radius * 2, CollaborationShaper.ANGLE, -2 * CollaborationShaper.ANGLE);
            graphics.drawArc((rect.x + rect.width / 2) + offset - radius, rect.y + rect.height / 2 - radius, radius * 2,
                    radius * 2, -120, -120);
        }
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
    @objid ("030aba26-5b7b-45c9-9372-aec46e55a1b6")
    private Dimension computePreferredSize(Rectangle rect) {
        int radius = CollaborationShaper.getRadius(rect);
        int offset = CollaborationShaper.getOffset(rect);
        return new Dimension((radius + offset) * 2, radius);
    }

    @objid ("1c81068c-54e3-4845-b9a1-9463f8a54406")
    public static class CollaborationShaper implements IShaper {
        @objid ("28d58100-faa5-437a-9b62-8d2aa68af6c1")
        public static int ANGLE = 60;

        @objid ("5a39e523-a740-4978-beb8-91b7b7929a2a")
        private static double ANGLE_RADIAN = Math.PI / 180.0 * ANGLE;

        @objid ("b3b33a25-8a7e-4041-be7f-e9a3652a6958")
        public CollaborationShaper() {

        }

        @objid ("98199ea8-0742-410d-b721-59c0b913e6c0")
        @Override
        public Path createShapePath(Rectangle rect) {
            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            int radius = getRadius(rect);
            int offset = getOffset(rect);

            Path path = new Path(Display.getCurrent());
            path.addArc((x + w / 2) - offset - radius, y + h / 2 - radius, radius * 2, radius * 2, ANGLE,
                    360 - ANGLE - ANGLE - 0);
            path.addArc((x + w / 2) + offset - radius, y + h / 2 - radius, radius * 2, radius * 2, 180 + ANGLE,
                    360 - ANGLE - ANGLE);
            path.close();
            return path;
        }

        @objid ("36573fe9-461d-4e27-830a-5aa295a1170f")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = 0;
            int leftInset = 0;
            int bottomInset = 0;
            int rightInset = 0;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

        /**
         * The radius is computed from the width and the height of the proposed rectangle. The goal is to ensure a proper and constant proportion of the drawn figure (two crossing circles)
         */
        @objid ("c2a4e299-ea84-4eba-ae23-f42570426e70")
        public static int getRadius(Rectangle rect) {
            int r1 = rect.height / 2;
            int r2 = (int) (rect.width / (2 * (1 + Math.cos(ANGLE_RADIAN))));
            return Math.min(r1, r2);
        }

        @objid ("f427c364-9a15-4ec9-81b6-1244f15d4520")
        public static int getOffset(Rectangle rect) {
            return (int) (Math.cos(ANGLE_RADIAN) * getRadius(rect));
        }

    }

}
