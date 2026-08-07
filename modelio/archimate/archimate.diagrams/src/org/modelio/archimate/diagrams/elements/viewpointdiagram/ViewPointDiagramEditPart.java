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
package org.modelio.archimate.diagrams.elements.viewpointdiagram;

import java.util.Iterator;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.GmViewPointDiagramStyleKeys.ElementSize;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramEditPart;
import org.modelio.diagram.elements.common.abstractdiagram.AbstractDiagramLayout;
import org.modelio.diagram.elements.core.figures.GradientFigure;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart (== controller in the GEF model) for {@link ViewPointDiagram} background.
 */
@objid ("aad06a88-f947-4ffd-9dc7-da8bca7d2301")
public class ViewPointDiagramEditPart extends AbstractDiagramEditPart {
    /**
     *
     * @see AbstractDiagramEditPart#createEditPolicies()
     */
    @objid ("c06112cf-4790-48bf-8530-0e09bcbdea06")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        // Layout Policy
        installEditPolicy(EditPolicy.LAYOUT_ROLE, new ViewPointDiagramEditLayoutPolicy());

    }

    /**
     * Creates the Figure to be used as this part's visuals
     *
     * @see AbstractDiagramEditPart#createFigure()
     */
    @objid ("45fc8091-8d6e-4daa-8d96-4aa11475b0ab")
    @Override
    protected IFigure createFigure() {
        IStyle style = ((GmAbstractObject) getModel()).getDisplayedStyle();
        IFigure diagramFigure = new ViewPointDiagramFigure();

        diagramFigure.setLayoutManager(new RowLayout(style.getInteger(GmViewPointDiagramStyleKeys.LAYOUTCOLUNMS),
                style.getProperty((GmViewPointDiagramStyleKeys.ELEMENTSIZE)),
                style.getBoolean(GmViewPointDiagramStyleKeys.AUTOLAYOUT)));

        // Set style independent properties

        // Set style dependent properties
        refreshFromStyle(diagramFigure, style);
        return diagramFigure;
    }

    @objid ("4404aa2c-8b12-4e91-bf9b-e357af5795b8")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        RowLayout layout = (RowLayout) aFigure.getLayoutManager();

        layout.setColumns(style.getInteger(GmViewPointDiagramStyleKeys.LAYOUTCOLUNMS));
        layout.setElementSize(style.getProperty(GmViewPointDiagramStyleKeys.ELEMENTSIZE));

        if (layout.isAuto() != style.getBoolean(GmViewPointDiagramStyleKeys.AUTOLAYOUT)) {
            layout.setAuto(style.getBoolean(GmViewPointDiagramStyleKeys.AUTOLAYOUT));
            if (!style.getBoolean(GmViewPointDiagramStyleKeys.AUTOLAYOUT)) {
                for (Object child : getChildren()) {
                    if (child instanceof AbstractNodeEditPart) {
                        for (Object figureChild : aFigure.getChildren()) {
                            if (figureChild instanceof IFigure) {
                                if (((AbstractNodeEditPart) child).getFigure().equals(figureChild)) {
                                    ((AbstractNodeEditPart) child).getModel().setLayoutData(((AbstractNodeEditPart) child).getFigure().getBounds());
                                }
                            }
                        }
                    }
                }
            }
        }

        super.refreshFromStyle(aFigure, style);

    }

    @objid ("ea4dbfc6-c390-49f2-8e93-c95ebea7c523")
    public class RowLayout extends AbstractDiagramLayout {
        @objid ("899fa9ef-dbfd-4c9d-bfe4-53b62fe5f600")
        private int WIDTH;

        @objid ("dd1208d4-7c57-4e85-9436-a600fb002b2f")
        private int HEIGH;

        @objid ("cb661ea1-e1c5-41db-a062-facab5b00322")
        private static final int MARGING = 20;

        @objid ("e0793357-6c77-47e9-ab6b-d94fbfa91b6d")
        private int COLMNS;

        @objid ("fd2949ad-3228-4c0d-a351-4d945d6030b9")
        private boolean isAuto;

        @objid ("c5a476fb-2918-4c86-883d-37c5c68f2448")
        public RowLayout(int columns, ElementSize size, boolean isAuto) {
            this.COLMNS = columns;
            if (ElementSize.SMALL == size) {
                this.WIDTH = 100;
                this.HEIGH = 100;
            } else if (ElementSize.LARGE == size) {
                this.WIDTH = 300;
                this.HEIGH = 300;
            } else {
                this.WIDTH = 200;
                this.HEIGH = 200;
            }
            this.isAuto = isAuto;

        }

        @objid ("f8e9fb57-e6ae-4344-968e-66d2b9bc1b97")
        @Override
        public void layout(IFigure parent) {
            IFigure f;
            if (this.isAuto) {
                int dx = 0;
                int dy = 0;

                Iterator<?> childrenIterator = parent.getChildren().iterator();
                while (childrenIterator.hasNext()) {
                    f = (IFigure) childrenIterator.next();
                    if (f instanceof GradientFigure) {
                        if (dx >= this.COLMNS) {
                            dx = 0;
                            dy++;
                        }
                        Rectangle bounds = new Rectangle(dx * (this.WIDTH + RowLayout.MARGING), dy * (this.HEIGH + RowLayout.MARGING), this.WIDTH, this.HEIGH);
                        if (!bounds.equals(getConstraint(f))) {
                            setConstraint(f, bounds);
                        }

                        dx++;
                    }
                }
            }
            super.layout(parent);

        }

        @objid ("91fbb097-405e-4e03-b1c8-1cd2843fed32")
        public boolean isAuto() {
            return this.isAuto;
        }

        @objid ("be9e9d41-8f71-48c2-927c-f04b76207a6b")
        public void setAuto(boolean isAuto) {
            this.isAuto = isAuto;
        }

        @objid ("d31a897a-c186-438a-b45c-3687e938414b")
        public void setElementSize(ElementSize size) {
            if (ElementSize.SMALL == size) {
                this.WIDTH = 100;
                this.HEIGH = 100;
            } else if (ElementSize.LARGE == size) {
                this.WIDTH = 300;
                this.HEIGH = 300;
            } else {
                this.WIDTH = 200;
                this.HEIGH = 200;
            }

        }

        @objid ("0f51a6e4-912e-4873-a02e-1440a2df4bca")
        public void setColumns(int columns) {
            this.COLMNS = columns;
        }

    }

}
