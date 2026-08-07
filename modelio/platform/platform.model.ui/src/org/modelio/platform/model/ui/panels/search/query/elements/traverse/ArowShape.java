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
package org.modelio.platform.model.ui.panels.search.query.elements.traverse;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A trapezoid shape with the smaller base at the top.
 */
@objid ("c116fcfe-354b-4c39-8ef5-a5a2736a42e6")
public class ArowShape extends Shape {
    @objid ("e8798cff-87ce-4926-9e91-f3f67f352101")
    private int topInset = 10;

    @objid ("808222ab-0ad9-4a37-a228-b9c4e2808b1b")
    private int marging = 10;

    @objid ("6947b71b-3d95-4ed8-a35b-d39ff2c77a0f")
    public ArowShape() {
        // Default constructor
    }

    @objid ("ff205e4d-f7bc-4ee7-9d29-48135a2e2a02")
    public void setTopInset(final int inset) {
        this.topInset = inset;
        setBorder(new org.eclipse.draw2d.MarginBorder(this.marging,this.marging ,this.marging,this.marging + this.topInset));
    }

    @objid ("02574686-5652-4c60-89c0-be7f8e6fe520")
    @Override
    protected void fillShape(final Graphics graphics) {
        Rectangle bounds = Rectangle.SINGLETON.setBounds(getBounds());
        int[] points = createTrapezoidPoints(bounds);
        graphics.fillPolygon(points);
    }

    @objid ("a14acf1b-ce86-4e3f-9f18-8e23cfab02dc")
    @Override
    protected void outlineShape(final Graphics graphics) {
        Rectangle bounds = Rectangle.SINGLETON.setBounds(getBounds());
        // Adjust for line width
        bounds.width-=2;
        bounds.height-=2;
        int[] points = createTrapezoidPoints(bounds);
        graphics.setLineWidth(getLineWidth());
        graphics.drawPolygon(points);
    }

    @objid ("8ae644bc-e8a5-4936-8ebb-2734221dc32e")
    private int[] createTrapezoidPoints(final Rectangle bounds) {
        return new int[] {
            bounds.x , bounds.y + 1,                    // Top-left
            bounds.x + bounds.width - this.topInset  , bounds.y + 1,     // Top-right,
            bounds.x + bounds.width  , bounds.y + (bounds.height / 2) ,     // Mid-right
            bounds.x + bounds.width - this.topInset , bounds.y + bounds.height  - 1,     // Bottom-right
            bounds.x , bounds.y - 1 + bounds.height                     // Mid-left
        };
    }

}
