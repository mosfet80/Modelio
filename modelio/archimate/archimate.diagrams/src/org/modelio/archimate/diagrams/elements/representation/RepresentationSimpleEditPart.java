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
package org.modelio.archimate.diagrams.elements.representation;

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
 * EditPart for a {@link GmRepresentation} Node in simple mode.
 */
@objid ("736a46e1-d1f2-41f9-930b-8309c6519e71")
public class RepresentationSimpleEditPart extends ArchiElementEditPart {
    @objid ("f9c9c80e-33fb-4cd8-b9b8-0c39e7b4ea97")
    @Override
    protected IFigure createFigure() {
        // create the figure
        IFigure fig = new RepresentationFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 90, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("99cefd3e-f711-408d-b3d0-0d8d8a91c03e")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof RepresentationFigure) {
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

    @objid ("89020338-c6ee-4bed-83d2-05b8b5a0a93a")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Wave figure is a rectangular-like figure with a wave as its bottom side.
     */
    @objid ("53b139bd-95f5-4b5d-b041-3ccd9035e2d3")
    private static class RepresentationFigure extends ShapedFigure {
        @objid ("004ae1e8-1321-4a3d-a3c4-58541c06f85c")
        private static final int OFFSET = 10;

        @objid ("ab8c01e1-454f-40b0-b0b7-7fff9e1187ef")
        private ShapedBorder shapedBorder;

        /**
         * Default c'tor building an opaque figure using a {@link ToolbarLayoutWithGrab}.
         */
        @objid ("e3af7086-0f5c-4cb9-a152-2061e6d66a06")
        public RepresentationFigure() {
            super(new WaveShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(40, 30);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(OFFSET + 1, 1, 1, 1)));

        }

        @objid ("1f56ab43-1e98-4a1e-8e28-df6f8b6bbfd6")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("4050830d-4649-448e-9f59-55ea011823f4")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }

        }

        @objid ("3bb0e571-9e4b-43cc-bc8a-fd554744c016")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            Rectangle rect = getBounds();

            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setLineWidth(this.penOptions.lineWidth);

            graphics.drawLine(rect.x, rect.y + OFFSET, rect.x + rect.width, rect.y + OFFSET);

            graphics.popState();

        }

        @objid ("f23a666a-2c20-4019-9d38-f792c4aa17eb")
        private static class WaveShaper implements IShaper {
            @objid ("c071dc9c-0251-4ef1-aa70-77264a79428d")
            public WaveShaper() {
                super();
            }

            @objid ("89f9b0af-7a96-4bd7-8a49-9a8de6cc46a5")
            @Override
            public Path createShapePath(Rectangle rect) {
                int a = getWaveDepth(rect);

                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                Path path = new Path(Display.getCurrent());

                path.moveTo(x, y);
                path.lineTo(x + w, y);
                path.lineTo(x + w, y + h - a);

                // Arc 1
                path.cubicTo(x + w, y + h - a, /* P0 */
                        x + w - w / 4, y + h - a - a - a, /* P1 */
                        x + w - w / 2, y + h - a); /* P2 */

                // Arc 2
                path.cubicTo(x + w - w / 2, y + h - a, /* P2 */
                        x + w / 4, y + h + a, /* P3 */
                        x, y + h - a); /* P4 */

                path.lineTo(x, y);
                return path;
            }

            @objid ("3c8673bb-1f94-48a9-8ed9-2cd9e9088d6e")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int a = getWaveDepth(rect);
                return new Insets(1, 1, 2 * a + 1, 1);
            }

            @objid ("c5d87ae3-1c43-4ba7-9e00-ff288a06d32b")
            private int getWaveDepth(Rectangle rect) {
                int a = Math.min(rect.height / 3, Math.max(rect.width, rect.height) * 10 / 100);
                return a;
            }

        }

    }

}
