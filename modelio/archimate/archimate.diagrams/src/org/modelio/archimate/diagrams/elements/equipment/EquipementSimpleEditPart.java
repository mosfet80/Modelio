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
package org.modelio.archimate.diagrams.elements.equipment;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.INodeWithArchiHeader;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.figures.IBrushOptionsSupport;
import org.modelio.diagram.elements.core.figures.IPenOptionsSupport;
import org.modelio.diagram.elements.core.figures.IShaper;
import org.modelio.diagram.elements.core.figures.MinimumSizeLayout;
import org.modelio.diagram.elements.core.figures.ShapedFigure;
import org.modelio.diagram.elements.core.figures.ToolbarLayoutWithGrab;
import org.modelio.diagram.elements.core.figures.ZoomDrawer;
import org.modelio.diagram.elements.core.figures.borders.ShapedBorder;
import org.modelio.diagram.styles.core.IStyle;
import org.modelio.diagram.styles.core.StyleKey.LinePattern;

/**
 * EditPart for a {@link GmEquipement} Node in simple mode.
 */
@objid ("03686764-efbd-4806-9d27-ec4ad865295d")
public class EquipementSimpleEditPart extends ArchiElementEditPart {
    @objid ("08f7f732-3d3f-484b-a0ff-96d62717d542")
    @Override
    protected IFigure createFigure() {
        // create the figure
        EquipmentFigure fig = new EquipmentFigure();

        // set style independent properties
        MinimumSizeLayout.apply(fig, 120, 80);

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("36e6a087-3f5d-4895-a14e-660716cbf7ec")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof EquipmentFigure) {
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

    @objid ("12743d29-d631-4ba6-9247-c59707d47568")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("3374cbcd-3a43-41dd-a753-f6764297b8ed")
    private static class GearFigure extends ShapedFigure {
        @objid ("59bb07e9-f34c-4629-bff2-b22d1405016b")
        private static final Dimension DEFAULT_SIZE = new Dimension(40, 30);

        @objid ("7c4b6d31-5c82-4121-a09f-bb646dc8fdf8")
        private ShapedBorder shapedBorder;

        @objid ("9897e618-fc7d-4627-951e-3f6081e3b331")
        public GearFigure(boolean isPrimary) {
            super(new EquipementShaper(isPrimary));
            final ToolbarLayoutWithGrab layout = new ToolbarLayoutWithGrab();
            layout.setHorizontal(false);
            layout.setStretchMinorAxis(true);
            this.setLayoutManager(layout);
            this.setOpaque(true);
            this.shapedBorder = new ShapedBorder(this.penOptions.lineColor, this.penOptions.lineWidth, this.shaper);
            setBorder(new CompoundBorder(this.shapedBorder, new MarginBorder(0)));
        }

        @objid ("537d0bf9-1128-4925-86c2-f5bfe966ac2b")
        @Override
        public void setLineColor(Color lineColor) {
            if (lineColor != this.penOptions.lineColor) {
                super.setLineColor(lineColor);
                this.shapedBorder.setColor(lineColor);
            }
        }

        @objid ("19186994-4bfb-4bc4-998d-805bcd907d5b")
        @Override
        public void setLineWidth(int lineWidth) {
            if (lineWidth != this.penOptions.lineWidth) {
                super.setLineWidth(lineWidth);
                this.shapedBorder.setWidth(lineWidth);
            }
        }

        @objid ("2e9fd0dd-8f93-45aa-b53d-482c534f92cc")
        @Override
        protected void paintFigure(Graphics graphics) {
            // Shrink the bounds to draw the circle (therefore fooling the shaper)
            int lineWidth = getLineWidth();

            // Draw the outer circle
            super.paintFigure(graphics);

            graphics.restoreState();

            Rectangle tempRect = getBounds();

            // Draw the full inner circle
            graphics.pushState();
            graphics.setForegroundColor(this.penOptions.lineColor);
            graphics.setAdvanced(true);
            graphics.setAntialias(SWT.ON);
            ZoomDrawer.setLineWidth(graphics, lineWidth);

            graphics.drawOval(new PrecisionRectangle(
                    EquipementShaper.getCenter(tempRect).preciseX() - tempRect.preciseWidth()/2.0 + tempRect.preciseWidth()/3,
                    EquipementShaper.getCenter(tempRect).preciseY() - tempRect.preciseHeight()/2.0 + tempRect.preciseHeight()/3,
                    tempRect.preciseWidth()/3,
                    tempRect.preciseHeight()/3));

            //graphics.restoreState();
            graphics.popState();
        }

        @objid ("dc5a7c0e-d4b6-401e-99bf-e9dd45fc0112")
        @Override
        public EquipementShaper getShaper() {
            return (EquipementShaper) super.getShaper();
        }

        @objid ("ef574bae-17aa-4057-a58b-67bc2f4190eb")
        @Override
        public Dimension getPreferredSize(int wHint, int hHint) {
            if (getShaper().isPrimary()) {
                return new Dimension(45, 45);
            } else {
                return new Dimension(35, 35);
            }
        }

        @objid ("039b8e4d-033d-4499-98b0-d999adb2cee8")
        private static class EquipementShaper implements IShaper {
            @objid ("5e529836-b9ff-4084-9374-be0fac65ac21")
            private boolean isPrimary;

            @objid ("46adc96c-ab79-4d6a-8689-6ff88f7cfc1f")
            @Override
            public Path createShapePath(Rectangle rect) {
                Path path = new Path(Display.getCurrent());

                double x = rect.preciseX();
                double y = rect.y;
                double w = rect.width;
                double h = rect.height;

                double figureWidth = w;
                double figureHeight = h;

                if (w > h) {
                    figureWidth = h;
                    figureHeight = h;
                } else {
                    figureWidth = w;
                    figureHeight = w;
                }

                PrecisionPoint center = new PrecisionPoint();
                center.setPreciseLocation(x + figureWidth / 2, y + figureHeight / 2);

                // Beta = 45 - alpha
                int alphaFirstCircle = 14;
                int betaFirstCircle = 31;
                int alphaSecondCircle = 22;
                int betaSecondCirlce = 23;

                float xMargin = (float) ((w - figureWidth) / 2);
                float yMargin = (float) ((h - figureHeight) / 2);

                PrecisionPoint firstPoint = new PrecisionPoint(x + (figureWidth/2), y);

                PrecisionPoint secondPoint = new PrecisionPoint();
                secondPoint.setPreciseLocation(x + (figureWidth/2) - (figureWidth/5.9), y + (figureHeight/6.5));

                PrecisionPoint firstCirclePoint = new PrecisionPoint();
                firstCirclePoint =  rotate(firstPoint, center, alphaFirstCircle);

                PrecisionPoint secondCirclePoint = new PrecisionPoint();
                secondCirclePoint =  rotate(secondPoint, center, alphaSecondCircle);
                secondCirclePoint =  rotate(secondCirclePoint, center, betaSecondCirlce);

                path.moveTo((float)firstPoint.preciseX() + xMargin, (float)firstPoint.preciseY() + yMargin);
                path.lineTo((float)firstCirclePoint.preciseX() + xMargin, (float)firstCirclePoint.preciseY() + yMargin);
                path.lineTo((float)secondCirclePoint.preciseX() + xMargin, (float)secondCirclePoint.preciseY() + yMargin);
                secondCirclePoint =  rotate(secondCirclePoint, center, alphaSecondCircle);
                path.lineTo((float)secondCirclePoint.preciseX() + xMargin, (float)secondCirclePoint.preciseY() + yMargin);

                for ( int k = 0; k < 7; k++) {
                    firstCirclePoint = rotate(firstCirclePoint, center, betaFirstCircle);
                    path.lineTo((float)firstCirclePoint.preciseX() + xMargin, (float)firstCirclePoint.preciseY() + yMargin);
                    firstCirclePoint = rotate(firstCirclePoint, center, alphaFirstCircle);
                    path.lineTo((float)firstCirclePoint.preciseX() + xMargin, (float)firstCirclePoint.preciseY() + yMargin);
                    secondCirclePoint =  rotate(secondCirclePoint, center, betaSecondCirlce);
                    path.lineTo((float)secondCirclePoint.preciseX() + xMargin, (float)secondCirclePoint.preciseY() + yMargin);
                    secondCirclePoint =  rotate(secondCirclePoint, center, alphaSecondCircle);
                    path.lineTo((float)secondCirclePoint.preciseX() + xMargin, (float)secondCirclePoint.preciseY() + yMargin);
                }

                path.close();
                return path;
            }

            @objid ("3b5d98c5-f9e2-4563-a587-a8b0ec970e7c")
            @Override
            public Insets getShapeInsets(Rectangle rect) {
                int topInset = 0;
                int leftInset = 0;
                int bottomInset = 0;
                int rightInset = 0;
                return new Insets(topInset, leftInset, bottomInset, rightInset);
            }

            @objid ("8a61f676-baeb-4bc5-80cc-a587bc430d73")
            public EquipementShaper(boolean isPrimary) {
                this.isPrimary = isPrimary;
            }

            @objid ("77d9ef47-b24b-4bfc-a2cb-5337cd9186e8")
            public boolean isPrimary() {
                return this.isPrimary;
            }

            @objid ("ec2d7693-7988-4c08-843b-60cee0bb56d1")
            public static Point getCenter(Rectangle rect) {
                return rect.getCenter();
            }

            @objid ("6d26d493-0346-4a73-874b-09acb46d14c3")
            private PrecisionPoint rotate(PrecisionPoint toRotate, PrecisionPoint rotationCenter, double degreeAngle) {
                double xM;
                double yM;

                double radAngle = degreeAngle * Math.PI / 180;

                xM = toRotate.preciseX() - rotationCenter.preciseX();
                yM = toRotate.preciseY() - rotationCenter.preciseY();
                PrecisionPoint point = new PrecisionPoint();
                point.setPreciseLocation(
                        xM * Math.cos (radAngle) - yM * Math.sin (radAngle) + rotationCenter.preciseX(),
                        xM * Math.sin (radAngle) + yM * Math.cos (radAngle) + rotationCenter.preciseY());
                return point;
            }

        }

    }

    @objid ("0c7672db-a775-4d64-8234-fc833c5d14b1")
    private static class EquipmentFigure extends GradientFigure implements IBrushOptionsSupport, IPenOptionsSupport, HandleBounds {
        @objid ("130d45c4-6fa3-418b-84a0-0aa1c7b0749b")
        private GearFigure primaryGear;

        @objid ("17a06bc5-2d0f-40fb-93df-727e7eab3b08")
        private GearFigure secondaryGear;

        @objid ("e6622396-7e2a-4bfd-b9e2-d3181ec83c2f")
        public EquipmentFigure() {
            setLayoutManager(new XYLayout());

            this.primaryGear = new GearFigure(true);
            add(this.primaryGear);

            this.secondaryGear = new GearFigure(false);
            add(this.secondaryGear);

            addFigureListener(new OnFigureChange());
        }

        @objid ("37e67fa0-b95c-4814-979f-0953c31320cd")
        @Override
        public Rectangle getHandleBounds() {
            return getBounds().getCopy();
        }

        @objid ("2606b6cd-b7ed-4f2a-9da5-6d6ccea1a370")
        @Override
        public void setLineColor(Color lineColor) {
            this.primaryGear.setLineColor(lineColor);
            this.secondaryGear.setLineColor(lineColor);
        }

        @objid ("ca6f189d-0015-423f-a679-31839ba4cbce")
        @Override
        public void setLineWidth(int lineWidth) {
            this.primaryGear.setLineWidth(lineWidth);
            this.secondaryGear.setLineWidth(lineWidth);
        }

        @objid ("dde32e34-7616-4dc8-9857-12a4fbc6972f")
        @Override
        public Color getLineColor() {
            return this.primaryGear.getLineColor();
        }

        @objid ("3afcc1fa-430e-488f-a362-aa1f8d4898d0")
        @Override
        public int getLineWidth() {
            return this.primaryGear.getLineWidth();
        }

        @objid ("940c37f6-ffd3-4469-93d1-e776597b9fcc")
        @Override
        public void setTextColor(Color textColor) {
            this.primaryGear.setTextColor(textColor);
            this.secondaryGear.setTextColor(textColor);
        }

        @objid ("b91efd23-5a76-4200-8812-0b84691e4998")
        @Override
        public void setTextFont(Font textFont) {
            this.primaryGear.setTextFont(textFont);
            this.secondaryGear.setTextFont(textFont);
        }

        @objid ("0cd97532-3b60-43ca-a073-b3da7546e1ea")
        @Override
        public Color getTextColor() {
            return this.primaryGear.getTextColor();
        }

        @objid ("e5b2834d-f789-4d82-a918-ecb150e5fa8d")
        @Override
        public Font getTextFont() {
            return this.primaryGear.getTextFont();
        }

        @objid ("ba1f360e-2464-4c1c-a00e-8e6d2e22df32")
        @Override
        public void setLinePattern(LinePattern lineStyle) {
            this.primaryGear.setLinePattern(lineStyle);
            this.secondaryGear.setLinePattern(lineStyle);
        }

        @objid ("4f9cf34f-81dd-4f90-a5f6-02ff8399642b")
        @Override
        public LinePattern getLinePattern() {
            return this.primaryGear.getLinePattern();
        }

        @objid ("65ebbac3-0f65-418b-8719-7aa12d244db0")
        @Override
        public void setFillColor(Color fillColor) {
            this.primaryGear.setFillColor(fillColor);
            this.secondaryGear.setFillColor(fillColor);
        }

        @objid ("65f90c7a-1fbb-4f22-a92c-348ba6ada6ac")
        @Override
        public void setUseGradient(boolean useGradient) {
            this.primaryGear.setUseGradient(useGradient);
            this.secondaryGear.setUseGradient(useGradient);
        }

        @objid ("de2e7b62-f54e-4d3d-8526-42ad3dbc6696")
        @Override
        public Color getFillColor() {
            return this.primaryGear.getFillColor();
        }

        @objid ("4d2a3543-185b-4e33-958d-5ffcff6e5b92")
        @Override
        public boolean getUseGradient() {
            return this.primaryGear.getUseGradient();
        }

        @objid ("64253a67-f7ae-4b7c-a226-132cdbe2349c")
        @Override
        public void setFillAlpha(int alpha) {
            this.primaryGear.setFillAlpha(alpha);
            this.secondaryGear.setFillAlpha(alpha);
        }

        @objid ("1d5e3b9b-48ae-4e0a-8848-565aae63b31e")
        @Override
        public int getFillAlpha() {
            return this.primaryGear.getFillAlpha();
        }

        @objid ("690db1c5-0ffd-4e6d-ab4a-70ade6fc8f62")
        private static class OnFigureChange implements FigureListener {
            @objid ("09bb2702-e440-41a7-9bb0-856a8653e9cc")
            @Override
            public void figureMoved(IFigure equipment) {
                LayoutManager layout = equipment.getLayoutManager();

                Rectangle equipmentBounds = equipment.getBounds();
                int equipmentWidth = equipmentBounds.width;
                int equipmentHeight = equipmentBounds.height;

                IFigure primaryGear = (IFigure) equipment.getChildren().get(0);
                IFigure secondaryGear = (IFigure) equipment.getChildren().get(1);

                float maxGearDiameter = Math.min(equipmentWidth, equipmentHeight);
                float primaryGearRadius = 3 * maxGearDiameter / 12;
                float secondaryGearRadius = 2 * maxGearDiameter / 12;

                PrecisionRectangle primaryBounds = new PrecisionRectangle(
                        equipmentWidth/2 - 3 * primaryGearRadius/2,
                        equipmentHeight/2 - primaryGearRadius/2,
                        primaryGearRadius * 2,
                        primaryGearRadius * 2);
                layout.setConstraint(primaryGear, primaryBounds);

                PrecisionRectangle secondaryBounds = new PrecisionRectangle(
                        equipmentWidth/2 - 3 * primaryGearRadius/2 + primaryGearRadius + maxGearDiameter / 12,
                        equipmentHeight/2 - primaryGearRadius/2 - 4 * primaryGearRadius/5,
                        secondaryGearRadius * 2,
                        secondaryGearRadius * 2);
                layout.setConstraint(secondaryGear, secondaryBounds);
            }

        }

    }

}
