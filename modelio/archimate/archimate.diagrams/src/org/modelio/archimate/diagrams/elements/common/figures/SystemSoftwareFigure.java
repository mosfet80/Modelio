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
 * Two circles crossing each other .
 */
@objid ("3b669928-c870-430d-b703-b5e5dd942be3")
public class SystemSoftwareFigure extends ShapedFigure {
    @objid ("a57ff2d7-fff8-4498-9b5b-012dccae8cec")
    private static final Dimension DEFAULT_SIZE = new Dimension(100, 60);

    @objid ("61be19ee-ec13-41ea-af29-e4dbb2837537")
    private ShapedBorder shapedBorder;

    @objid ("859b3904-7e38-4805-b64c-b57b47154806")
    public SystemSoftwareFigure() {
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

    @objid ("bc2728ca-1438-4122-9c7c-d7862b109940")
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

    @objid ("8912ca2b-6a8e-49ea-8911-ecec9c5fab74")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }
    }

    @objid ("f0b97578-b43e-439d-8218-585b98be261d")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(this.penOptions.lineWidth);
        }
    }

    @objid ("8e50bd67-c85d-4bd8-b690-825f6cac6232")
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

        int decal = rect.height / 4 ;

        Rectangle innerRec = new Rectangle(rect).resize(-decal, -decal);

        int radius = CollaborationShaper.getRadius(innerRec);
        int offset = CollaborationShaper.getOffset(innerRec);

        graphics.pushState();
        graphics.setForegroundColor(this.penOptions.lineColor);
        graphics.setAdvanced(true);
        graphics.setAntialias(SWT.ON);

        // Draw the bottom left circle completely
        Path path = new Path(Display.getCurrent());
        path.addArc(
                (innerRec.x + innerRec.width / 2) - offset - radius,
                (innerRec.y + radius/2)+ innerRec.height / 2 - radius,
                radius * 2,
                radius * 2,
                0,
                360 );
        graphics.drawPath(path);
        path.dispose();

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
    @objid ("3d8ce949-567a-4ab4-a97f-1f1f1b926cc2")
    private Dimension computePreferredSize(Rectangle rect) {
        int radius = CollaborationShaper.getRadius(rect);
        int offset = CollaborationShaper.getOffset(rect);
        return new Dimension((radius + offset) * 2, radius);
    }

    @objid ("375e80a3-a721-4c8a-ad94-3a600470d126")
    public static class CollaborationShaper implements IShaper {
        @objid ("5383059a-cce7-47cd-83ff-d30d62743b64")
        public static final int ANGLE = 60;

        @objid ("6be90cf2-cccf-4a06-aefc-4c4f5b8582f6")
        private static final double ANGLE_RADIAN = Math.PI / 180.0 * ANGLE;

        @objid ("5f82e733-1eb2-4928-9fb4-3eaa7b9ba3ed")
        public CollaborationShaper() {

        }

        @objid ("b1f5aeb1-0d11-4b24-979e-72aae240ffb9")
        @Override
        public Path createShapePath(Rectangle rect) {
            int decal = rect.height / 4;
            Rectangle innerRec = new Rectangle(rect.x, rect.y, rect.width - decal, rect.height() - decal);

            int radius = getRadius(innerRec);
            int offset = getOffset(innerRec);

            Path path = new Path(Display.getCurrent());
            // Draw the bottom left arc
            path.addArc(
                    (innerRec.x + innerRec.width / 2) - offset - radius,
                    (innerRec.y + radius/2)+ innerRec.height / 2 - radius,
                    radius * 2,
                    radius * 2,
                    ANGLE,
                    360 - ANGLE -30);
            // Draw the top right arc
            path.addArc(
                    (innerRec.x + innerRec.width / 2) + offset - radius,
                    innerRec.y + innerRec.height / 2 - radius,
                    radius * 2, radius * 2,
                    180 + ANGLE +30,
                    360 - ANGLE -60);
            return path;
        }

        @objid ("3588b361-578a-484f-890c-f5a1dfd4c75e")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int topInset = 0;
            int leftInset = 0;
            int bottomInset = 0;
            int rightInset = 0;
            return new Insets(topInset, leftInset, bottomInset, rightInset);
        }

        /**
         * The radius is computed from the width and the height of the proposed rectangle.
         * <p>
         * The goal is to ensure a proper and constant proportion of the drawn figure (two crossing circles)
         */
        @objid ("e6e6ac20-7599-4210-9131-c1fc6eddf7c3")
        public static int getRadius(Rectangle rect) {
            int r1 = rect.height / 2;
            int r2 = (int) (rect.width / (2 * (1 + Math.cos(ANGLE_RADIAN))));
            return Math.min(r1, r2);
        }

        @objid ("fd1d426b-d1ac-4a0b-a396-e5a6223e3f3e")
        public static int getOffset(Rectangle rect) {
            return (int) (Math.cos(ANGLE_RADIAN) * getRadius(rect));
        }

    }

}
