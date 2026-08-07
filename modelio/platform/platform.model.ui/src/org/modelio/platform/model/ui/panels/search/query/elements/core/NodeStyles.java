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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

@objid ("283f37bd-0ae6-4df2-a35f-462a350a8479")
public class NodeStyles {
    @objid ("eb677b18-a221-4be8-8ebe-c8c8b8d1807b")
    public static final NodeStyle DEFAULT = new NodeStyle(new Color(0, 0, 200), new Color(255, 255, 255));

    @objid ("0065341c-ef49-433f-bc8a-e8944c82b7f3")
    public static final NodeStyle SELECTED = new NodeStyle(new Color(100, 100, 200), new Color(230, 230, 255));

    @objid ("59258652-3396-40a1-a17e-d1f98954a5a6")
    public static final class NodeStyle {
        @objid ("94e017c8-cca4-4578-bd03-59df92a9a6ef")
        public final Color fg;

        @objid ("5b91e695-a855-433d-9f79-537cd68f965f")
        public final Color bg;

        @objid ("691304a6-0b99-4497-9e3f-9cf81397e2d7")
        public NodeStyle(Color fg, Color bg) {
            this.fg = fg;
            this.bg = bg;
        }

        @objid ("8b082788-e925-479e-a129-db8d9f0c4700")
        public void applyTo(org.eclipse.draw2d.Figure figure) {
            figure.setForegroundColor(this.fg);
            figure.setBackgroundColor(this.bg);
            if(figure.getBorder() == null) {
                figure.setBorder(new MarginBorder(new Insets(8,10,8,10)));
            }
            figure.setOpaque(true);

            if (figure instanceof org.eclipse.draw2d.RoundedRectangle roundedRectangle) {
                roundedRectangle.setCornerDimensions(new Dimension(10, 10));
            }
            if (figure instanceof Shape shape) {
                shape.setAntialias(SWT.ON);
                shape.setLineWidth(3);
                shape.setOutline(true);
            }
        }

    }

}
