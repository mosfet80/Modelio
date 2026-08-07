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
package org.modelio.archimate.diagrams.elements.path;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmPath} Node in simple mode.
 */
@objid ("d4272b99-80f3-425a-87de-e74bba48479d")
public class PathSimpleEditPart extends ArchiElementEditPart {
    @objid ("9f4b6e5d-b6d3-44f2-a1ca-110f34a61b6e")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final PathFigure fig = new PathFigure();
        fig.setOpaque(false);

        // Add layout
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        fig.setLayoutManager(layout);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("614e9c07-bba0-4f80-8814-d28f31bf2336")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof PathFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }

            final GmArchiElementPrimaryNode<?> gmModel = (GmArchiElementPrimaryNode<?>) getModel();
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

    @objid ("6a468cea-f4fe-474a-be63-39c0bd2ec9e0")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("cef5aacb-421d-43d7-8a64-51cb602aa40d")
    private static class PathFigure extends GradientFigure {
        @objid ("c6de228b-fd7d-4079-ac8a-101b8a6815e9")
        private static double ARROW_ANGLE_COS = Math.cos(Math.PI / 3);

        @objid ("6af55e55-20d2-4ba0-a2c3-4f8d7d24eb6d")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);

            Rectangle rect = getBounds().getCopy();

            // First estimation of arrow size, to allow an estimation of line width
            Dimension arrow = getArrowSize(rect);
            int autoLineWidth = getAutoLineWidth(new Rectangle(new Point(0, 0), arrow));

            // Now that linewidth has been chosen, let compute definitive size of the arrow
            rect.shrink(autoLineWidth, autoLineWidth);
            arrow = getArrowSize(rect);

            graphics.setLineWidth(autoLineWidth);
            graphics.setForegroundColor(this.penOptions.lineColor);

            graphics.setLineCap(SWT.CAP_ROUND);

            graphics.drawLine(rect.x + arrow.width, rect.y + rect.height / 2 - arrow.height / 2, rect.x, rect.y + rect.height / 2);
            graphics.drawLine(rect.x, rect.y + rect.height / 2, rect.x + arrow.width, rect.y + rect.height / 2 + arrow.height / 2);

            graphics.drawLine(rect.x + rect.width - arrow.width, rect.y + rect.height / 2 - arrow.height / 2, rect.x + rect.width, rect.y + rect.height / 2);
            graphics.drawLine(rect.x + rect.width, rect.y + rect.height / 2, rect.x + rect.width - arrow.width, rect.y + rect.height / 2 + arrow.height / 2);

            graphics.setLineStyle(SWT.LINE_CUSTOM);
            graphics.setLineDash(new int[] { autoLineWidth, 2 * autoLineWidth });

            graphics.drawLine(rect.x, rect.y + rect.height / 2, rect.x + rect.width, rect.y + rect.height / 2);

        }

        @objid ("1748c6b8-0e60-4e93-ad5c-17906dcbd367")
        private Dimension getArrowSize(Rectangle rect) {
            int a1 = rect.height;
            int a2 = (int) (rect.width / (1 + ARROW_ANGLE_COS) / 2);
            int a = Math.min(a1, a2);
            return new Dimension((int) (a * ARROW_ANGLE_COS), a);
        }

        @objid ("9731b277-92f4-434b-89bd-ac0a7bfc5b55")
        private int getAutoLineWidth(Rectangle rect) {
            return (int) (Math.sqrt(rect.width * rect.height) / 8);
        }

        @objid ("68933ced-5286-48c6-9f7b-de163e0273b1")
        public PathFigure() {
            super();
        }

    }

}
