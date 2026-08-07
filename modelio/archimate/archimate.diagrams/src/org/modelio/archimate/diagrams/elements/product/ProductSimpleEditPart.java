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
package org.modelio.archimate.diagrams.elements.product;

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
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmProduct} Node in simple mode.
 */
@objid ("1e9577e3-150c-4d8f-b744-332781926735")
public class ProductSimpleEditPart extends ArchiElementEditPart {
    @objid ("acd6d1d8-ac4d-4a8d-bf27-cb88515e1c92")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final ProductFigure fig = new ProductFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("f45fe72e-4acf-4243-9d18-c5141c8aa1f2")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ProductFigure) {
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

    @objid ("75dcdc23-26eb-41de-83d8-be67fca3dc28")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Object figure is a rectangular figure with an additional bar drawn in in top area.
     */
    @objid ("da52d4af-c4e7-4f1c-b93a-0d65709e9aa0")
    private static class ProductFigure extends RectangularFigure {
        @objid ("94c460e6-fd64-493a-9371-2a89a75e7f9a")
        private static final int OFFSET = 10;

        /**
         * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
         */
        @objid ("403cfbd1-94ac-4b3f-a9b6-ce78875c3bb2")
        public ProductFigure() {
            setLayoutManager(new ToolbarLayoutWithGrab());
            this.setOpaque(true);

        }

        @objid ("ff171aec-cb86-423d-8754-44f78a300f3d")
        @Override
        public Insets getInsets() {
            return super.getInsets().getAdded(new Insets(OFFSET, 0, 0, 0));
        }

        @objid ("d66e13da-040d-4854-9dfc-28f6058613d9")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            Rectangle rect = getBounds();
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(this.penOptions.lineWidth);
            graphics.drawLine(rect.x, rect.y + OFFSET, rect.x + rect.width / 2, rect.y + OFFSET);
            graphics.drawLine(rect.x + rect.width / 2, rect.y, rect.x + rect.width / 2, rect.y + OFFSET);
            graphics.popState();

        }

    }

}
