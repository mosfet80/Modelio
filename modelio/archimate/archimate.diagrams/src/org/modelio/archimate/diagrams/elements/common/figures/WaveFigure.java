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
 * Wave figure is a rectangular-like figure with a wave as its bottom side.
 */
@objid ("0ec2fab0-3fac-4faf-ae6c-c5e26eef3bfa")
public class WaveFigure extends ShapedFigure {
    @objid ("95c3d974-f587-4ed9-94d6-bafd3a3dfa05")
    private final ShapedBorder shapedBorder;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("a15f7c33-8bff-42b7-9743-54594c25b6d8")
    public WaveFigure() {
        super(new WaveShaper());
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(40, 30);
        this.setOpaque(true);
        this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
        setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1)));

    }

    @objid ("83100f9f-275a-418e-ac00-424c1224a192")
    @Override
    public void setLineColor(Color lineColor) {
        if (lineColor != this.penOptions.lineColor) {
            super.setLineColor(lineColor);
            this.shapedBorder.setColor(lineColor);
        }

    }

    @objid ("22fb2072-2c97-4059-96f8-a4b077ce0a06")
    @Override
    public void setLineWidth(int lineWidth) {
        if (lineWidth != this.penOptions.lineWidth) {
            super.setLineWidth(lineWidth);
            this.shapedBorder.setWidth(lineWidth);
        }

    }

    @objid ("47a9a912-9b80-43eb-a892-d6513c7d3a5f")
    private static class WaveShaper implements IShaper {
        @objid ("96b9b867-4fa4-4c20-8a9d-80873b22390b")
        public WaveShaper() {
            super();
        }

        @objid ("985dfb75-afa1-4d2c-b5e2-fefc53844348")
        @Override
        public Path createShapePath(Rectangle rect) {
            int a = getWaveDepth(rect);

            int x = rect.x;
            int y = rect.y;
            int w = rect.width;
            int h = rect.height;

            Path path = new Path(Display.getCurrent());

            path.moveTo(x, y);
            path.lineTo(x + w, y);
            path.lineTo(x + w, y + h - a);

            // Arc 1
            path.cubicTo(x + w, y + h - a, /* P0 */
                    x + w - w / 4, y + h - a - a - a, /* P1 */
                    x + w - w / 2, y + h - a); /* P2 */

            // Arc 2
            path.cubicTo(x + w - w / 2, y + h - a, /* P2 */
                    x + w / 4, y + h + a, /* P3 */
                    x, y + h - a); /* P4 */

            path.lineTo(x, y);
            path.close();
            return path;
        }

        @objid ("9b5a1a1d-10e0-407c-88a2-68f68e865125")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            int a = getWaveDepth(rect);
            return new Insets(1, 1, 2 * a + 1, 1);
        }

        @objid ("5ada890e-3590-47ce-858a-4553d5ec6a71")
        private int getWaveDepth(Rectangle rect) {
            int a = Math.min(rect.height / 3, Math.max(rect.width, rect.height) * 10 / 100);
            return a;
        }

    }

}
