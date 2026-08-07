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
package org.modelio.archimate.diagrams.elements.assignment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transform;
import org.modelio.diagram.elements.core.figures.GradientFigure;

/**
 * A rotatable filled circle shaped decoration for decorating the ends of {@link org.eclipse.draw2d.Polyline polylines}.
 */
@objid ("55f75680-0759-4dfc-a1ed-4ae4d61ad130")
public class AssignmentFigure extends GradientFigure implements RotatableDecoration {
    @objid ("d1d191a1-6e8c-4e55-9dbd-36f0da4607d3")
    private static final int CIRCLE_OFFSET = 5;

    @objid ("0e6d6d1d-cc27-409b-9295-b1987b3253c9")
    private Point location = new Point();

    @objid ("e68a6488-3712-476a-b550-7a44280d633d")
    private Transform transform = new Transform();

    @objid ("b3de27fb-9a1d-4aa9-a709-5936021ba84a")
    private static final PrecisionPoint tmp = new PrecisionPoint();

    /**
     * Default constructor.
     */
    @objid ("a5aa157a-096f-4c0a-8380-f3a876fe01d0")
    public AssignmentFigure() {
        super();
        setSize(CIRCLE_OFFSET * 2, CIRCLE_OFFSET * 2);

    }

    @objid ("673af9ff-fea8-46a3-adf0-a3fbd6b5c75b")
    @Override
    public void setReferencePoint(final Point ref) {
        Point pt = Point.SINGLETON;
        pt.setLocation(ref);
        pt.negate().translate(this.location);
        this.transform.setRotation(Math.atan2(pt.y, pt.x));

    }

    @objid ("b216475c-2752-49a1-9229-37561a8c1ceb")
    @Override
    public void setLocation(final Point p) {
        this.location.setLocation(p);
        this.transform.setTranslation(p.x, p.y);

    }

    @objid ("8f155a89-cb79-4968-929d-b96a5658c8e6")
    @Override
    protected void paintFigure(final Graphics graphics) {
        tmp.setLocation(-CIRCLE_OFFSET, 0);
        tmp.setLocation(this.transform.getTransformed(tmp));
        graphics.setForegroundColor(this.getLineColor());
        graphics.setBackgroundColor(this.getLineColor());
        graphics.setClip(new Rectangle(tmp.x() - (CIRCLE_OFFSET + 1),
                tmp.y() - (CIRCLE_OFFSET + 1),
                (CIRCLE_OFFSET + 1) * 2,
                (CIRCLE_OFFSET + 1) * 2));
        graphics.fillArc(tmp.x() - CIRCLE_OFFSET,
                tmp.y() - CIRCLE_OFFSET,
                (CIRCLE_OFFSET * 2) + 1,
                (CIRCLE_OFFSET * 2) + 1,
                0,
                360);

    }

    @objid ("8a3d4c6a-a164-46a4-aca7-f823fe4a4f05")
    @Override
    protected void paintBorder(final Graphics graphics) {
        tmp.setLocation(-CIRCLE_OFFSET, 0);
        tmp.setLocation(this.transform.getTransformed(tmp));
        graphics.setForegroundColor(this.getLineColor());
        graphics.setBackgroundColor(this.getLineColor());
        graphics.setClip(new Rectangle(tmp.x() - (CIRCLE_OFFSET + 1),
                tmp.y() - (CIRCLE_OFFSET + 1),
                (CIRCLE_OFFSET + 1) * 2,
                (CIRCLE_OFFSET + 1) * 2));
        graphics.drawArc(tmp.x() - CIRCLE_OFFSET,
                tmp.y() - CIRCLE_OFFSET,
                CIRCLE_OFFSET * 2,
                CIRCLE_OFFSET * 2,
                0,
                360);

    }

    @objid ("074690cc-f56c-4004-906f-64c1c918cc16")
    @Override
    public Rectangle getBounds() {
        tmp.setLocation(-10, 0);
        tmp.setLocation(this.transform.getTransformed(tmp));
        return new Rectangle(tmp.x() - (CIRCLE_OFFSET + 1),
                        tmp.y() - (CIRCLE_OFFSET + 1),
                        (CIRCLE_OFFSET + 1) * 2,
                        (CIRCLE_OFFSET + 1) * 2);

    }

}
