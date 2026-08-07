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
package org.modelio.archimate.diagrams.elements.artifact;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedBorderedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmArtifact} Node in simple mode.
 */
@objid ("4352bdbb-c63d-4ab4-ae30-039854c6172d")
public class ArtifactSimpleEditPart extends ArchiElementEditPart {
    @objid ("6dd5862f-ab8c-41e4-a1db-f96324ee6efa")
    private static final Dimension DEFAULT_SIZE = new Dimension(30, 40);

    @objid ("764bf73b-8717-469a-8ef2-8500367f59c7")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final IFigure fig = new ShapedBorderedFigure(new ArtifactShaper());

        // setup vertical toolbar layout
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

    @objid ("59b1a8df-3b62-4bef-ac5a-ed1bf050933a")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof ShapedBorderedFigure) {
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

    @objid ("f17a1063-bff5-43d0-b45b-3aefa67a4a10")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * The artifact shape is a rectangle with a fold on the right side.
     *
     * The fold is a triangle with its top at the top right corner of the rectangle.
     *
     * The fold is defined by the FOLDSIZE constant.
     *
     * it look like this:
     *
     * 1-------------5
     * |             |\
     * |             | \
     * |             6--4
     * |                |
     * 2----------------3
     */
    @objid ("6d94574f-1aab-479e-9028-fec1083025b3")
    private static class ArtifactShaper implements IShaper {
        @objid ("2d22f0b6-cccf-461b-bad1-ad18859683f5")
        private static final int FOLDSIZE = 12;

        @objid ("92e3be01-a9f7-4fd8-bb24-4971d855d954")
        @Override
        public Path createShapePath(Rectangle aBounds) {
            Path path = new Path(Display.getCurrent());

            path.moveTo(aBounds.x(), aBounds.y()); // 1: top left corner
            path.lineTo(aBounds.x(), aBounds.bottom()); // 2: bottom left corner
            path.lineTo(aBounds.right(), aBounds.bottom()); // 3: bottom right corner
            path.lineTo(aBounds.right(), aBounds.y + FOLDSIZE); // 4: right side fold
            path.lineTo(aBounds.right() - FOLDSIZE, aBounds.y); // 5: top right fold
            path.lineTo(aBounds.x(), aBounds.y()); // 1: top left corner
            path.close(); // close the path

            path.moveTo(aBounds.right() - FOLDSIZE, aBounds.y); // 5: top right fold
            path.lineTo(aBounds.right() - FOLDSIZE, aBounds.y + FOLDSIZE); //  6: right side fold bottom
            path.lineTo(aBounds.right(), aBounds.y + FOLDSIZE); // 4: right side fold

            return path;
        }

        @objid ("9afb8120-42a9-4fc0-afe3-9f5889080678")
        @Override
        public Insets getShapeInsets(Rectangle rect) {
            return new Insets();
        }

    }

}
