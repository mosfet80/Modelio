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
package org.modelio.archimate.diagrams.elements.principle;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.RoundedBoxFigure;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmPrinciple} Node in simple mode.
 */
@objid ("cb17eb88-ee94-498d-9030-bcc75cc9ae96")
public class PrincipleSimpleEditPart extends ArchiElementEditPart {
    @objid ("f49f3dbb-a1e2-4a8f-b521-91336d77e85d")
    @Override
    protected IFigure createFigure() {
        // create the figure
        PrincipleRoundedBoxFigure fig = new PrincipleRoundedBoxFigure();
        fig.setLayoutManager(new BorderLayout());

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("c5394852-69b1-45ff-b10b-08b3951190bc")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof PrincipleRoundedBoxFigure) {
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

    @objid ("42d280c2-c530-4c18-bd5f-f5d0b6c94aba")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Extends the {@link RoundedBoxFigure} to draw an exclamation mark in the center.
     */
    @objid ("266f50f6-f08d-4640-aaf2-86cba9dc8f68")
    private static class PrincipleRoundedBoxFigure extends RoundedBoxFigure {
        @objid ("54b5012c-dd12-42a9-b439-5f1fb9b70b9b")
        @Override
        protected void paintFigure(Graphics graphics) {
            // Draw the round box
            super.paintFigure(graphics);

            int lineWidth = getLineWidth();
            // Take line width into account to compute proper bounds like the ShapedBorder does
            Rectangle tempRect = getBounds().getCopy();
            if (lineWidth % 2 != 0) {
                tempRect.width--;
                tempRect.height--;
            }
            tempRect.shrink(lineWidth / 2, lineWidth / 2);

            // Draw the exclamation mark
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setBackgroundColor(this.penOptions.lineColor);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);

            Point center = tempRect.getCenter();

            int block = Math.max(1, Math.round((tempRect.height - 2.0f * lineWidth) / 20.0f));
            if (block >= tempRect.width / 2) {
                block = Math.max(1, tempRect.width / 4);
            }
            graphics.fillPolygon(new int [] {
                    center.x - Math.round(block), tempRect.y + 3 * block,
                    center.x + Math.round(block), tempRect.y + 3 * block,
                    center.x + Math.round(0.8f * block), tempRect.y + tempRect.height - 7 * block,
                    center.x - Math.round(0.8f * block), tempRect.y + tempRect.height - 7 * block
            });

            graphics.fillPolygon(new int [] {
                    center.x + Math.round(0.8f * block), tempRect.y + tempRect.height - 5 * block,
                    center.x - Math.round(0.8f * block), tempRect.y + tempRect.height - 5 * block,
                    center.x - Math.round(0.8f * block), tempRect.y + tempRect.height - 3 * block,
                    center.x + Math.round(0.8f * block), tempRect.y + tempRect.height - 3 * block
                    });

            graphics.popState();

        }

    }

}
