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
package org.modelio.archimate.diagrams.elements.communicationnetwork;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
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
 * EditPart for a {@link GmCommunicationNetwork} Node in simple mode.
 */
@objid ("708b2641-2564-4f25-9d0b-4385cf051e0a")
public class CommunicationNetworkSimpleEditPart extends ArchiElementEditPart {
    @objid ("67d29e66-a682-4c59-8c16-1d03f26119cd")
    @Override
    protected IFigure createFigure() {
        // create the figure
        CommunicationNetwork fig = new CommunicationNetwork();
        fig.setOpaque(true);

        // Add layout
        final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
        layout.setHorizontal(false);
        layout.setStretchMinorAxis(true);
        fig.setLayoutManager(layout);

        // set style independent properties
        MinimumSizeLayout.apply(fig, 60, 60);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("e5dbfafa-8cb0-43e2-acc8-9f6dc15bbcc3")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof CommunicationNetwork) {
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

    @objid ("cb0730b5-3970-4bae-89bf-e2122b3ecdcb")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("96ca87a2-8dda-4670-a784-7206a1be9347")
    private static class CommunicationNetwork extends ShapedFigure {
        @objid ("7c13ff33-6ff6-4256-a39c-3952bd3b1884")
        private static final Dimension DEFAULT_SIZE = new Dimension( 60, 60);

        @objid ("9327d4cb-e549-406d-9933-6125db417352")
        private ShapedBorder shapedBorder;

        @objid ("2cf4c83a-fc1c-4261-aec0-7e52da1bdd38")
        public CommunicationNetwork() {
            super(new CommunicationNetworkShape());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));

        }

        @objid ("0bde4b33-9fa3-4b50-8ff6-2405c0c75246")
        @Override
        public Dimension getPreferredSize(int wHint, int hHint) {
            if (wHint != -1 && hHint != -1) {
                // Both width and height hints
                return computePreferredSize(new Rectangle(0, 0, wHint, hHint));
            } else if (wHint == -1 && hHint != -1) {
                // No width hint at all, simulate width larger than height
                return computePreferredSize(new Rectangle(0, 0, Integer.MAX_VALUE, hHint));
            } else if (wHint != -1 && hHint == -1) {
                // No height hint at all, simulate height far larger than width
                return computePreferredSize(new Rectangle(0, 0, wHint, Integer.MAX_VALUE));
            } else {
                return super.getPreferredSize(wHint, hHint);
            }

        }

        @objid ("c927d5e5-12ff-4b73-8986-90880b5a3b61")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }

        }

        @objid ("c1105b73-5162-4900-94d4-f688306220ca")
        @Override
        public void setLineWidth(int lineWidth) {
            this.shapedBorder.setWidth(Math.min(getBounds().width, getBounds().height)  / 20);
        }

        @objid ("9ea64c5a-eabb-4b8f-8ff6-3f0f3bb97127")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = CommunicationNetworkShape.getRadius(rect);
            return new Dimension(radius * 2, radius * 2);
        }

        @objid ("61b9c8ac-410d-4201-aae3-7d1d44a06999")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);
            setLineWidth(0);

        }

        @objid ("7fd40e7e-9e55-49cb-ab85-a5ae40c888f5")
        @Override
        public void setFillColor(Color fillColor) {
            Color color = new Color(20, 50, 105, 255);
            super.setFillColor(color);
            this.brushOptions.fillColor = color;
            this.repaint();

        }

        @objid ("36cfe2b7-9504-409e-a07e-978d1a5f5e18")
        @Override
        public int getLineWidth() {
            return Math.min(getPreferredSize().width,getPreferredSize().height) / 12;
        }

        @objid ("527ad6cd-81d7-46fe-a11c-421f5d7f3f87")
        private static class CommunicationNetworkShape implements IShaper {
            @objid ("f7e52e62-492b-4cb2-bd1c-35570be387c6")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());


                int size = Math.min(rect.width, rect.height);
                int marging = size / 8;
                int round = size / 8;


                path.addArc((float) rect.x + (marging * 2)- round , rect.y + marging  - round, round * 2, round  * 2, 0, 360);
                path.addArc((float) rect.x + size - marging - round , rect.y + marging  - round, round * 2, round  * 2, 0, 360);
                path.addArc((float) rect.x  + size - (marging * 2)- round , rect.y  + size   - marging - round, round * 2, round  * 2, 0, 360);
                path.addArc((float) rect.x  + marging- round , rect.y  + size - marging  - round, round * 2, round  * 2, 0, 360);

                path.moveTo(rect.x + (marging * 2) + round,rect.y + marging );
                path.lineTo((float) rect.x + size - marging - round,  (float) rect.y + marging);

                path.moveTo((float) rect.x + size - marging,  (float) rect.y + marging + round);
                path.lineTo((float) rect.x + size - (marging * 2),  (float) rect.y  + size - marging - round);

                path.moveTo((float) rect.x + size - (marging * 2) -round,  (float) rect.y  + size - marging);
                path.lineTo((float) rect.x  + marging + round,  (float) rect.y  + size - marging);

                path.moveTo((float) rect.x  + marging,  (float) rect.y  + size - marging - round);
                path.lineTo((float) rect.x + (marging * 2),(float)rect.y + marging  + round);
                return path;
            }

            /**
             * The center is computed from the width and the height of the proposed rectangle.
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's center.
             */
            @objid ("03ce3765-6b86-41f3-afa4-f8975c606cc2")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("d688717f-0ddc-4ae7-8b7c-cc14eedd5c62")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The theoretical radius is computed from the width and the height of the proposed rectangle.
             * <br/>
             * The goal is to ensure a proper constant proportion of the complete drawn figure
             *
             * @param rect the rectangle to draw the circle into.
             * @return the circle's radius.
             */
            @objid ("ea6377d4-cd2f-4013-b2c8-b28e2b0f5e9e")
            public static int getRadius(Rectangle rect) {
                int r1 = rect.height / 2;
                int r2 = rect.width / 2;
                int radius = Math.min(r1, r2);
                // Make sure the radius is divisible by 2 to avoid rounding problems later
                return radius - radius % 2;
            }

        }

    }

}
