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
package org.modelio.archimate.diagrams.elements.businessactor;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmBusinessActor} Node in simple mode.
 */
@objid ("2c1f0156-e156-412b-bbd3-c307d07d851a")
public class BusinessActorSimpleEditPart extends ArchiElementEditPart {
    @objid ("0bf1db65-be84-4ab7-8fe1-46fba8b8ffe8")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final BusinessActorFigure fig = new BusinessActorFigure();
        fig.setOpaque(true);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 40);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("074d4695-b2d1-43c9-b632-d763b6ceeee0")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof BusinessActorFigure) {
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

    @objid ("9c3fc973-c9f4-4233-a5b9-88ddeadf1396")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("f396578a-b37d-4ddb-86a8-d3cd4f9a693a")
    private static class BusinessActorFigure extends GradientFigure {
        @objid ("ed87b3d7-5bbc-4739-99ff-95e05abaebae")
        private static final int DEFAULT_DIA = 20;

        @objid ("0cd430b8-a032-4904-b81c-571a481a81c1")
        public BusinessActorFigure() {
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(getPreferredSize());
            this.setOpaque(true);

        }

        @objid ("7cb32a38-40aa-4f40-a230-e46efd9886ca")
        @Override
        public Dimension getPreferredSize(int wHint, int hHint) {
            int dia = DEFAULT_DIA;

            if (wHint != -1 && hHint != -1) {
                // Both width and height hints
                dia = getDiameter(new Rectangle(0, 0, wHint, hHint));
            }

            if (wHint == -1 && hHint != -1) {
                // No width hint at all, simulate width larger than height
                dia = getDiameter(new Rectangle(0, 0, Integer.MAX_VALUE, hHint));
            }
            if (wHint != -1 && hHint == -1) {
                // No height hint at all, simulate height far larger than width
                dia = getDiameter(new Rectangle(0, 0, wHint, Integer.MAX_VALUE));
            }
            return new Dimension(2 * dia, 3 * dia);
        }

        @objid ("4a8f6b0b-8c75-4cb6-92d0-012bf43327c6")
        @Override
        protected void paintFigure(Graphics graphics) {
            final Rectangle aBounds = getBounds().getCopy();
            final Rectangle originalClip = new Rectangle();

            if (this.penOptions.lineWidth % 2 != 0) {
                aBounds.width--;
                aBounds.height--;
            }

            aBounds.shrink(this.penOptions.lineWidth / 2, this.penOptions.lineWidth / 2);

            int dia = getDiameter(aBounds);

            if (this.isOpaque()) {
                graphics.getClip(originalClip);
                final Path path = new Path(Display.getCurrent());
                path.addArc(aBounds.x + aBounds.width / 2 - dia / 2, aBounds.y + aBounds.height / 2 - dia - dia / 2, dia,
                        dia, 0, 360);
                graphics.setClip(path);
                // now let the BoxFigure draw the gradient
                super.paintFigure(graphics);
                graphics.setClip(originalClip);
                path.dispose();
            } // end is opaque

            // Draw outline
            graphics.setLineWidth(this.penOptions.lineWidth);
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);

            graphics.drawOval(aBounds.x + aBounds.width / 2 - dia / 2, aBounds.y + aBounds.height / 2 - dia - dia / 2, dia,
                    dia);

            graphics.drawLine(aBounds.x + aBounds.width / 2, aBounds.y + aBounds.height / 2 - dia / 2,
                    aBounds.x + aBounds.width / 2, aBounds.y + aBounds.height / 2 - dia / 2 + dia);

            graphics.drawLine(aBounds.x + aBounds.width / 2, aBounds.y + aBounds.height / 2 - dia / 2 + dia,
                    aBounds.x + aBounds.width / 2 - dia, aBounds.y + aBounds.height / 2 - dia / 2 + dia + dia);

            graphics.drawLine(aBounds.x + aBounds.width / 2, aBounds.y + aBounds.height / 2 - dia / 2 + dia,
                    aBounds.x + aBounds.width / 2 + dia, aBounds.y + aBounds.height / 2 - dia / 2 + dia + dia);

            graphics.drawLine(aBounds.x + aBounds.width / 2 - dia, aBounds.y + aBounds.height / 2 - dia / 4,
                    aBounds.x + aBounds.width / 2 + dia, aBounds.y + aBounds.height / 2 - dia / 4);

        }

        @objid ("cfb1f5fc-638b-42bf-b326-5a5ba2b11b73")
        private int getDiameter(final Rectangle rect) {
            int d1 = rect.width / 2;
            int d2 = rect.height / 3;
            return Math.min(d1, d2);
        }

    }

}
