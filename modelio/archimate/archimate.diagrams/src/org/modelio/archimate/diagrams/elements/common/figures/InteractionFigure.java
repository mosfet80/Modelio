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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;

@objid ("43de90ff-dc5c-4ada-86a4-ec9dc4b547b2")
public class InteractionFigure extends GradientFigure {
    @objid ("d68d443a-64df-4a39-84d0-a984bd709e79")
    private static final int DEFAULT_DIA = 30;

    @objid ("957ae3d7-3c3b-46e5-8b05-5b5554aa7eac")
    private static final int GAP = 10;

    @objid ("8bd04bb0-0657-4ec4-99da-2f9130d3d384")
    public InteractionFigure() {
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        this.setLayoutManager(layout);
        setSize(getPreferredSize());
        this.setOpaque(true);

    }

    @objid ("467ef569-0f88-4851-a010-9adde0929412")
    @Override
    public Dimension getPreferredSize(int wHint, int hHint) {
        int dia = DEFAULT_DIA;

        if (wHint != -1 && hHint != -1) {
            // Both width and height hints
            dia = getDiameter(new Rectangle(0, 0, wHint, hHint));
        }

        if (wHint == -1 && hHint != -1) {
            // No width hint at all, simulate width larger than height
            dia = getDiameter(new Rectangle(0, 0, Integer.MAX_VALUE, hHint));
        }
        if (wHint != -1 && hHint == -1) {
            // No height hint at all, simulate height far larger than width
            dia = getDiameter(new Rectangle(0, 0, wHint, Integer.MAX_VALUE));
        }
        return new Dimension(2 * dia, 2 * dia);
    }

    @objid ("d6dda7c4-4c2c-4fe4-934e-649d5ee419bd")
    @Override
    protected void paintFigure(Graphics graphics) {
        final Rectangle aBounds = getBounds().getCopy();
        final Rectangle originalClip = new Rectangle();

        if (this.penOptions.lineWidth % 2 != 0) {
            aBounds.width--;
            aBounds.height--;
        }

        // aBounds.shrink(this.penOptions.lineWidth / 2, this.penOptions.lineWidth / 2);

        int dia = getDiameter(aBounds);
        int gap = getGap(aBounds);

        if (this.isOpaque()) {
            graphics.getClip(originalClip);

            final Path path = new Path(Display.getCurrent());

            path.addArc(aBounds.x + aBounds.width / 2 - gap / 2 - dia / 2,
                    aBounds.y + aBounds.height / 2 - dia / 2,
                    dia, dia, 90, 180);
            path.lineTo(aBounds.x + aBounds.width / 2 - gap / 2,
                    aBounds.y + aBounds.height / 2 - dia / 2);

            path.addArc(aBounds.x + aBounds.width / 2 + gap / 2 - dia / 2,
                    aBounds.y + aBounds.height / 2 - dia / 2,
                    dia, dia, 90, -180);
            path.lineTo(aBounds.x + aBounds.width / 2 + gap / 2,
                    aBounds.y + aBounds.height / 2 - dia / 2);

            graphics.setClip(path);

            // now let the BoxFigure draw the gradient
            super.paintFigure(graphics);
            graphics.setClip(originalClip);
            path.dispose();
        } // end is opaque

        aBounds.shrink(this.penOptions.lineWidth / 2, this.penOptions.lineWidth / 2);
        // Draw outline
        graphics.setLineWidth(this.penOptions.lineWidth);
        graphics.setForegroundColor(this.penOptions.lineColor);
        graphics.setLineCap(SWT.CAP_ROUND);
        graphics.setAdvanced(true);
        graphics.setAntialias(SWT.ON);

        graphics.drawArc(aBounds.x + aBounds.width / 2 - gap / 2 - dia / 2 - 1,
                aBounds.y + aBounds.height / 2 - dia / 2,
                dia, dia, 90, 180);
        graphics.drawLine(aBounds.x + aBounds.width / 2 - gap / 2,
                aBounds.y + aBounds.height / 2 - dia / 2,
                aBounds.x + aBounds.width / 2 - gap / 2,
                aBounds.y + aBounds.height / 2 - dia / 2 + dia);

        graphics.drawArc(aBounds.x + aBounds.width / 2 + gap / 2 - dia / 2,
                aBounds.y + aBounds.height / 2 - dia / 2,
                dia, dia, 90, -180);
        graphics.drawLine(aBounds.x + aBounds.width / 2 + gap / 2,
                aBounds.y + aBounds.height / 2 - dia / 2,
                aBounds.x + aBounds.width / 2 + gap / 2,
                aBounds.y + aBounds.height / 2 - dia / 2 + dia);

    }

    /**
     * The diameter is computed so that
     * <ul>
     * <li>its value is the rectangle height if width is large enough (ie wider than dia + dia/8)</li>
     * <li>its value is the rectangle width * 4/9 otherwise</li>
     * </ul>
     * @return
     */
    @objid ("2eefd320-24a6-4cfd-9698-15b1d04586ae")
    public int getDiameter(final Rectangle rect) {
        int d1 = (rect.width * 3 / 7) * 2;
        int d2 = rect.height;
        return Math.min(d1, d2) - this.penOptions.lineWidth;
    }

    @objid ("8c9e261d-d94b-46ff-b8ef-cd747fa71064")
    public int getGap(Rectangle rect) {
        return getDiameter(rect) / 6;
    }

}
