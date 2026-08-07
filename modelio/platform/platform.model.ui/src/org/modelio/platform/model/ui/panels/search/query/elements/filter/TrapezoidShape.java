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
package org.modelio.platform.model.ui.panels.search.query.elements.filter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A trapezoid shape with the smaller base at the top.
 */
@objid ("24f45821-965f-4cf4-a5b4-155e3d5933f4")
public class TrapezoidShape extends Shape {
    @objid ("16de17a4-9c60-4e1f-ab2a-cf533501c834")
    private int topInset = 10;

    @objid ("4b897e2c-242c-4283-ae79-f5f333954c14")
    public TrapezoidShape() {
        // Default constructor
    }

    @objid ("846b4a31-0440-47a3-9519-2cdfc806933d")
    public void setTopInset(final int inset) {
        this.topInset = inset;
        setBorder(new org.eclipse.draw2d.MarginBorder(this.topInset));
    }

    @objid ("229e75e7-c35e-485c-acfe-1c1425bed333")
    @Override
    protected void fillShape(final Graphics graphics) {
        Rectangle bounds = Rectangle.SINGLETON.setBounds(getBounds());
        int[] points = createTrapezoidPoints(bounds);
        graphics.fillPolygon(points);
    }

    @objid ("faf02e31-f64f-48af-bf6a-95aabab7b45b")
    @Override
    protected void outlineShape(final Graphics graphics) {
        Rectangle bounds = Rectangle.SINGLETON.setBounds(getBounds());
        // Adjust for line width
        bounds.width--;
        bounds.height--;
        int[] points = createTrapezoidPoints(bounds);
        graphics.setLineWidth(getLineWidth());
        graphics.drawPolygon(points);
    }

    @objid ("b5cde5b9-bbc5-4a9d-9d68-10cabe51238b")
    private int[] createTrapezoidPoints(final Rectangle bounds) {
        return new int[] {
            bounds.x + this.topInset , bounds.y,                    // Top-left
            bounds.x + bounds.width - this.topInset , bounds.y,     // Top-right,
            bounds.x + bounds.width  , bounds.y + (bounds.height / 2),     // Mid-right
            bounds.x + bounds.width - this.topInset, bounds.y + bounds.height,     // Bottom-right
            bounds.x + this.topInset, bounds.y + bounds.height,                     // Bottom-left
            bounds.x, bounds.y + (bounds.height / 2)                     // Mid-left
        };
    }

}
