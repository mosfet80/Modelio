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
package org.modelio.archimate.diagrams.elements.plateau;

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
 * EditPart for a {@link GmPlateau} Node in simple mode.
 */
@objid ("81499155-7949-4ab1-ba46-f9f782dcba3e")
public class PlateauSimpleEditPart extends ArchiElementEditPart {
    @objid ("793aa1c0-cc00-4556-b5e2-562dc280de4a")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final PlateauFigure fig = new PlateauFigure();
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

    @objid ("fee879ec-417f-4cbc-a456-5bc040cd33fc")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof PlateauFigure) {
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

    @objid ("b43e27c8-97aa-4dd5-b448-320a00df9fb4")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("c50834c3-c044-42af-9ae6-7c5440546112")
    private static class PlateauFigure extends GradientFigure {
        @objid ("5c472ea6-d7c7-47fe-811f-0dea529da49a")
        private static double ARROW_ANGLE_COS = Math.cos(Math.PI / 3);

        @objid ("2d0c7834-ae0b-4139-9eed-a9a07b351c58")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);

            Rectangle rect = getBounds().getCopy();

            Dimension lineSize = getLineSize(rect);
            int autoLineWidth = getAutoLineWidth(new Rectangle(new Point(0, 0), lineSize));

            // Now that linewidth has been chosen, let compute definitive size of the figure
            rect.shrink(autoLineWidth, autoLineWidth);

            int x = rect.x;
            int y = rect.y;

            int width = rect.width;
            int height = rect.height;

            int figureMaxSize = Math.min(width, height);

            // Center figure
            int xMargin = (width - figureMaxSize) / 2;
            int yMargin = (height - figureMaxSize) / 2;

            graphics.setLineWidth(autoLineWidth);
            graphics.setForegroundColor(this.penOptions.lineColor);

            graphics.setLineCap(SWT.CAP_FLAT);

            graphics.drawLine(x + xMargin + 0 * figureMaxSize/6, y + yMargin + 3 * figureMaxSize/4, x + xMargin + figureMaxSize - 2 * figureMaxSize/6, y + yMargin + 3 * figureMaxSize/4);
            graphics.drawLine(x + xMargin + 1 * figureMaxSize/6, y + yMargin + 2 * figureMaxSize/4, x + xMargin + figureMaxSize - 1 * figureMaxSize/6, y + yMargin + 2 * figureMaxSize/4);
            graphics.drawLine(x + xMargin + 2 * figureMaxSize/6, y + yMargin + 1 * figureMaxSize/4, x + xMargin + figureMaxSize - 0 * figureMaxSize/6, y + yMargin + 1 * figureMaxSize/4);

        }

        @objid ("1d1a61b2-c215-45ee-9a6d-09cf7a218d5a")
        private Dimension getLineSize(Rectangle rect) {
            int a1 = rect.height;
            int a2 = (int) (rect.width / (1 + ARROW_ANGLE_COS) / 2);
            int a = Math.max(a1, a2);
            return new Dimension((int) (a * ARROW_ANGLE_COS), a);
        }

        @objid ("d400e266-256b-4fdf-b5f4-79927ee12cd0")
        private int getAutoLineWidth(Rectangle rect) {
            return (int) (Math.sqrt(rect.width * rect.height) / 8);
        }

        @objid ("1cb02646-1c9f-4934-9e6a-23a9969b1116")
        public PlateauFigure() {
            super();
        }

    }

}
