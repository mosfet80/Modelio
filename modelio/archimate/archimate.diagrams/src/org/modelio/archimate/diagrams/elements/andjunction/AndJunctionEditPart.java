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
package org.modelio.archimate.diagrams.elements.andjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.swt.graphics.Color;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeStartCreationEditPolicy;
import org.modelio.diagram.elements.core.figures.EllipseFigure;
import org.modelio.diagram.elements.core.link.DefaultCreateLinkEditPolicy;
import org.modelio.diagram.elements.core.link.anchors.fixed2.DefaultFixedAnchorProvider;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;
import org.modelio.diagram.styles.core.IStyle;

/**
 * EditPart for an {@link GmAndJunctionPrimaryNode}.
 */
@objid ("2ca9efc5-761f-4eaa-9fa6-0702738a8b9b")
public final class AndJunctionEditPart extends AbstractNodeEditPart {
    @objid ("8f949115-18b7-4ea8-b4d5-e615391cf102")
    @Override
    public boolean isSelectable() {
        return false;
    }

    @objid ("ef07b00f-e9ca-494a-8e92-1399d87fd051")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.NODE_ROLE, new DefaultCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START, new LinkedNodeStartCreationEditPolicy());
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

    @objid ("4f47a371-5637-4f7e-8c57-e674d52476fd")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final FilledEllipseFigure fig = new FilledEllipseFigure();

        // set style independent properties
        fig.setPreferredSize(20, 20);
        fig.setMinimumSize(new Dimension(20, 20));

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("cb88b854-bfc3-4dd3-87f2-ee7ed80a3e3b")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof EllipseFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("f48983ca-7c59-4bca-befd-c1ab05f14da0")
    @Override
    protected void refreshVisuals() {
        GmAndJunctionPrimaryNode model = (GmAndJunctionPrimaryNode) this.getModel();
        getFigure().getParent().setConstraint(getFigure(), model.getLayoutData());

    }

    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("14fd7662-ca8e-4bfe-8586-dbaec053fd08")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return DefaultFixedAnchorProvider.ellipseFor(this);
    }

    /**
     * Ellipse figure where the line color and the fill color are the same.
     */
    @objid ("4aa00ae0-ea04-4dca-bc74-7211ccc9a39a")
    private static class FilledEllipseFigure extends EllipseFigure {
        /**
         * Public default constructor.
         */
        @objid ("f66ad936-536c-4523-af75-85ae6287df93")
        public FilledEllipseFigure() {

        }

        @objid ("344c8fae-8d3b-442f-8b42-64ff48f3c4e1")
        @Override
        public void setFillColor(Color fillColor) {
            super.setFillColor(fillColor);

            setLineColor(fillColor);

        }

    }

}
