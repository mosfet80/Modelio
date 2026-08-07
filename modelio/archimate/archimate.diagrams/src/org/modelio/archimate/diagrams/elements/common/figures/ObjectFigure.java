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
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;

/**
 * Object figure is a rectangular figure with an additional bar drawn in in top area.
 */
@objid ("fdeadafa-1903-4f99-893a-29c295712518")
public class ObjectFigure extends RectangularFigure {
    @objid ("8aa4d9b4-8eca-4dc2-942d-03cad2d1ac4e")
    private static final int OFFSET = 10;

    /**
     * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
     */
    @objid ("04139bb7-37d0-4f02-97f3-37ec4b9d5c95")
    public ObjectFigure() {
        setLayoutManager(new ToolbarLayoutWithGrab());
        this.setOpaque(true);
    }

    @objid ("9455a90c-9149-46b2-90fa-5fd23c5c08dd")
    @Override
    public Insets getInsets() {
        return super.getInsets().getAdded(new Insets(OFFSET, 0, 0, 0));
    }

    @objid ("8f295698-748c-4b06-ab4b-d47a647792ff")
    @Override
    protected void paintFigure(Graphics graphics) {
        super.paintFigure(graphics);

        Rectangle rect = getBounds().getCopy();
        rect.resize(-1, -1); // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
        int lineWidth = getLineWidth();
        ZoomDrawer.setLineWidth(graphics, lineWidth, rect);

        graphics.pushState();
        graphics.setForegroundColor(this.penOptions.lineColor);
        graphics.drawLine(rect.x, rect.y + OFFSET + lineWidth, rect.x + rect.width, rect.y + OFFSET  + lineWidth);
        graphics.popState();
    }

}
