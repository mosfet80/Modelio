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
package org.modelio.archimate.diagrams.elements.contract;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RectangularFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmContract} Node in simple mode.
 */
@objid ("9e6f2a4e-f669-49c1-9a3c-39637c617a33")
public class ContractSimpleEditPart extends ArchiElementEditPart {
    @objid ("6effe8fb-5ffe-4962-bc6d-734bf6632e21")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final ContractFigure fig = new ContractFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("2e80787f-2cf6-4874-bc4d-2c1e4f38565a")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ContractFigure) {
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

    @objid ("a3243c44-192e-46ff-bc1f-9cab7f34752f")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Object figure is a rectangular figure with an additional bar drawn in in top area.
     */
    @objid ("fdf97d25-fd11-4442-bc45-0febdb7d5df1")
    private static class ContractFigure extends RectangularFigure {
        @objid ("cd389829-a81f-41e0-9b07-8036f7a50944")
        private static final int OFFSET = 10;

        /**
         * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
         */
        @objid ("820f96fb-00f3-4920-8288-4d7edc9c310d")
        public ContractFigure() {
            setLayoutManager(new ToolbarLayoutWithGrab());
            this.setOpaque(true);
        }

        @objid ("280299c1-03db-4edb-be1c-341e7247b2e0")
        @Override
        public Insets getInsets() {
            return super.getInsets().getAdded(new Insets(OFFSET, 0, OFFSET / 2, 0));
        }

        @objid ("4da2d19a-3607-421d-9c68-351cf04b7ffd")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            graphics.pushState();

            Rectangle rect = getBounds().getCopy();
            rect.resize(-1, -1); // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
            int lineWidth = getLineWidth();
            ZoomDrawer.setLineWidth(graphics, lineWidth, rect);

            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.drawLine(rect.x, rect.y + OFFSET + lineWidth, rect.x + rect.width, rect.y + OFFSET + lineWidth);
            graphics.drawLine(rect.x, rect.y + rect.height - OFFSET - lineWidth, rect.x + rect.width, rect.y + rect.height - OFFSET - lineWidth);
            graphics.popState();
        }

    }

}
