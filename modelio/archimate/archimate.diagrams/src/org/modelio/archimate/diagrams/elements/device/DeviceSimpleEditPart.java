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
package org.modelio.archimate.diagrams.elements.device;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
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
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for a {@link GmDevice} Node in simple mode.
 */
@objid ("2085615c-7207-4e4f-9f0a-9709f0307b5b")
public class DeviceSimpleEditPart extends ArchiElementEditPart {
    @objid ("8b871ea9-ee51-4859-810a-7f201f76993f")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final IFigure nodeFigure = new DeviceFigure();

        // set style independent properties
        MinimumSizeLayout.apply(nodeFigure, 90, 60);

        // set style dependent properties
        refreshFromStyle(nodeFigure, getModelStyle());

        // return the figure
        return nodeFigure;
    }

    @objid ("45cc3024-9d0e-435c-a64f-57035c7da6ed")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof DeviceFigure) {
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

    @objid ("c4476b28-9f2b-4324-ba80-18074859ce98")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * two circles
     *
     * @author phv
     */
    @objid ("2b2dd28c-9d11-4e32-a3b9-52a36c0ce1aa")
    private static class DeviceFigure extends ShapedFigure {
        @objid ("30970d5a-87c8-4cac-8372-dd272df32a1b")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("a48ef2c3-a469-44dc-a492-699efac33911")
        private ShapedBorder shapedBorder;

        @objid ("188ce8d7-e039-4831-a0e1-0618125d278d")
        public DeviceFigure() {
            super(new DeviceShaper());
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            setSize(DEFAULT_SIZE);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("3356b157-3087-419a-bd54-3710a27cd1f3")
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

        @objid ("10e4ff9b-4ae7-47ef-97d6-a0c54d8f752a")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("3af5a91a-91d3-4c87-ae73-0045a3e07f94")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(this.penOptions.lineWidth);
            }
        }

        @objid ("38f4d945-4c1b-4d87-b929-aa55e8b8d365")
        @Override
        protected void paintFigure(Graphics graphics) {
            super.paintFigure(graphics);

            Rectangle rect = getPaintRectangle();
            rect.resize(-1, -1); // Shrink the bounds because bounds bottom right corner is not included in the drawing area.
            int lineWidth = getLineWidth();
            ZoomDrawer.setLineWidth(graphics, lineWidth, rect);

            int radius = DeviceShaper.getRadius(rect);

            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);

            float halfLineWidth = lineWidth / 2.0f;

            Path path = new Path(Display.getCurrent());
            path.moveTo(rect.x + radius + radius / 2 - lineWidth,
                    rect.y + rect.height - radius - halfLineWidth);
            path.lineTo(rect.x + rect.width - radius - radius / 2,
                    rect.y + rect.height - radius - halfLineWidth);

            graphics.drawPath(path);
            path.dispose();


            graphics.popState();
        }

        /**
         * The preferred size and proportion for a given rect is computed as:<br/>
         * width = 2 * (radius + offset)<br/>
         * height = radius<br/>
         *
         * where radius and offset are computed using the shaper.
         * @return
         */
        @objid ("721a260d-5dbc-4fab-bfb9-e726045c079d")
        private Dimension computePreferredSize(Rectangle rect) {
            int radius = DeviceShaper.getRadius(rect);
            return new Dimension((radius) * 3, radius);
        }

        @objid ("d6d2327a-62ab-4bff-97c6-e969f5f4f8ca")
        private static class DeviceShaper implements IShaper {
            @objid ("cfc653d2-7248-4d43-8f3a-9abfed64e92d")
            public DeviceShaper() {
                super();
            }

            @objid ("c459858c-ae17-477a-a82a-3d1a5da9ca43")
            @Override
            public Path createShapePath(Rectangle rect) {
                int x = rect.x;
                int y = rect.y;
                int w = rect.width;
                int h = rect.height;

                int r = getRadius(rect);

                Path path = new Path(Display.getCurrent());

                int offset = r;

                path.moveTo(x + r, y);
                path.lineTo(x + w - r, y);
                path.addArc(x + w - r - r, y, 2 * r, 2 * r, 90, -90);
                path.lineTo(x + w, y + h - r - offset);
                path.addArc(x + w - r - r, y + h - r - r - offset, 2 * r, 2 * r, 0, -90);
                path.lineTo(x + w - r - offset / 2, y + h - offset);
                path.lineTo(x + w, y + h);
                path.lineTo(x, y + h);
                path.lineTo(x + r + offset / 2, y + h - offset);
                path.lineTo(x + r, y + h - offset);
                path.addArc(x, y + h - r - r - offset, 2 * r, 2 * r, -90, -90);
                path.lineTo(x, y + r);
                path.addArc(x, y, 2 * r, 2 * r, 180, -90);
                path.close();
                return path;
            }

            @objid ("819fd610-63d1-4049-847d-2fac8942a36f")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            /**
             * The radius is set to 20 pixels unless width or height are too small
             */
            @objid ("2d254bda-0bc5-40c7-9dff-f6783c4ad517")
            public static int getRadius(Rectangle rect) {
                int r1 = Math.min(rect.height / 4, 20);
                int r2 = Math.min(rect.width / 4, 20);
                return Math.min(r1, r2);
            }

        }

    }

}
