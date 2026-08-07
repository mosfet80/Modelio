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
package org.modelio.archimate.diagrams.elements.orjunction;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
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
 * EditPart for an {@link GmOrJunctionPrimaryNode}.
 */
@objid ("12c8d04b-46fb-4516-b293-2eddde579905")
public final class OrJunctionEditPart extends AbstractNodeEditPart {
    @objid ("668de55e-9972-47ff-8f43-76a53b45513b")
    @Override
    public boolean isSelectable() {
        return false;
    }

    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("280b7b7b-435b-40a6-b6ee-0cce52690906")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return DefaultFixedAnchorProvider.ellipseFor(this);
    }

    @objid ("88c31c97-25fc-4487-b046-ef11b37df11a")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.NODE_ROLE, new DefaultCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START, new LinkedNodeStartCreationEditPolicy());
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

    @objid ("0cf585dd-f7de-489e-be13-a08de75169b0")
    @Override
    protected IFigure createFigure() {
        // create the figure
        final EllipseFigure fig = new EllipseFigure();

        // set style independent properties
        fig.setPreferredSize(20, 20);
        fig.setMinimumSize(new Dimension(20, 20));

        // set style dependent properties
        refreshFromStyle(fig, getModelStyle());

        // return the figure
        return fig;
    }

    @objid ("e47b8cda-f105-45d6-8fb8-4cc78fd775e4")
    @Override
    protected void refreshFromStyle(IFigure aFigure, IStyle style) {
        if (aFigure instanceof EllipseFigure) {
            if (!switchRepresentationMode()) {
                super.refreshFromStyle(aFigure, style);
            }
        }

    }

    @objid ("41b6e997-4090-4920-bd30-297af46be129")
    @Override
    protected void refreshVisuals() {
        GmOrJunctionPrimaryNode model = (GmOrJunctionPrimaryNode) this.getModel();
        getFigure().getParent().setConstraint(getFigure(), model.getLayoutData());

    }

}
