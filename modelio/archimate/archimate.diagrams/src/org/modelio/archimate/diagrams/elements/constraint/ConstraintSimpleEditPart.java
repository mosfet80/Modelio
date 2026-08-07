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
package org.modelio.archimate.diagrams.elements.constraint;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmConstraint} Node in simple mode.
 */
@objid ("3583396d-7f90-41d4-8514-f3113b1b3b27")
public class ConstraintSimpleEditPart extends ArchiElementEditPart {
    @objid ("4c54090f-a9fa-42f3-abb9-f0e8307ed478")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final ConstraintFigure fig = new ConstraintFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("23a26251-446f-4928-bb9e-efcc56342b5d")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ConstraintFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final INodeWithArchiHeader gmModel = (INodeWithArchiHeader) getModel();
            switch (gmModel.getRepresentationMode()) {
            case STRUCTURED:
                gmModel.getHeader().setShowMetaclassIcon(true);
                break;
            case IMAGE:
            case SIMPLE:
            case USER_IMAGE:
                gmModel.getHeader().setShowMetaclassIcon(false);
                break;
            default:
                break;
            }
        }

    }

    @objid ("ca42da7c-6008-4b29-835c-6f3a9198e1a3")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("65725306-f3f0-4c97-8e58-871a65bfea5c")
    private static class ConstraintFigure extends ShapedFigure {
        @objid ("7e26356a-5d17-4b9b-828e-a0a1a7b18345")
        private static double ANGLE = 81 * (Math.PI / 2) / 90;

        @objid ("a292410b-cc01-4a85-94da-5b7979e2432c")
        private static int OFFSET = 10;

        @objid ("17c9e296-74d6-49f0-aa4c-84b5e146f3d6")
        private ShapedBorder shapedBorder;

        @objid ("af860ff2-20a9-40e0-8944-2d70badc45c4")
        public ConstraintFigure() {
            super(new ConstraintShaper(ANGLE));
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(40, 30);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(1, OFFSET + 1, 1, 1)));

        }

        @objid ("fbd7ef83-5bc4-4cc3-ba9b-6ef7f95445a3")
        @Override
        public Insets getInsets() {
            Insets insets = super.getInsets();
            return insets;
        }

        @objid ("e806c2b6-862d-4ffe-9bd7-d7557a30d2ff")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("b79b8099-4dc5-4ac1-b8bb-21c4347e186d")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        @objid ("57d81f86-dfde-472c-8508-ecc4e6776aaa")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            Rectangle rect = getBounds();
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(this.penOptions.lineWidth);
            int d = ConstraintShaper.getSlant(rect, ANGLE);
            graphics.drawLine(rect.x + d + OFFSET, rect.y, rect.x + OFFSET, rect.y + rect.height);
            graphics.popState();

        }

        @objid ("14b8e824-52f8-4ac5-bbd4-b1d74fafdcb5")
        public static class ConstraintShaper implements IShaper {
            @objid ("56252a9a-50c6-4482-a5d3-1cb2689315ae")
            private double angle;

            @objid ("0cd60599-bb1e-4bef-abaa-3d60b593d444")
            public ConstraintShaper(double angle) {
                this.angle = angle;
            }

            @objid ("e77de253-32bc-4d20-baef-0431b8d6cedd")
            @Override
            public Path createShapePath(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;
                int d = getSlant(rect, this.angle);

                Path path = new Path(Display.getCurrent());

                path.moveTo(x + d, y);
                path.lineTo(x + w, y);
                path.lineTo(x + w - d, y + h);
                path.lineTo(x, y + h);
                path.lineTo(x + d, y);
                return path;
            }

            @objid ("b0775656-2597-4b59-b41d-8c3dcd2b6e32")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int d = getSlant(rect, this.angle);
                return new Insets(0, d, 0, d);
            }

            @objid ("b982c3ff-da30-4757-a6f0-27e87b9916b8")
            public static int getSlant(Rectangle rect, double angle) {
                return Math.min(rect.width * 10 / 100, (int) (rect.height * Math.cos(angle)));
            }

        }

    }

}
