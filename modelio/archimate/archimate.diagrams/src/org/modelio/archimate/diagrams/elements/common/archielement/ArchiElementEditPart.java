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
package org.modelio.archimate.diagrams.elements.common.archielement;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.modelio.archimate.diagrams.elements.common.anchors.ArchimateAnchors;
import org.modelio.archimate.diagrams.elements.common.archiheader.ArchiHeaderEditPart;
import org.modelio.archimate.diagrams.elements.common.figures.motivation.MotivationFigure;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeRequestConstants;
import org.modelio.diagram.elements.common.linkednode.LinkedNodeStartCreationEditPolicy;
import org.modelio.diagram.elements.core.link.DefaultCreateLinkEditPolicy;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.model.GmAbstractObject;
import org.modelio.diagram.elements.core.node.AbstractNodeEditPart;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;
import org.modelio.diagram.elements.core.policies.DeferringCreateNodePolicy;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;

/**
 * EditPart for a {@link GmArchiElement}.
 * <p>
 * Uses a {@link MotivationFigure}.
 * </p>
 */
@objid ("2db1440f-09c6-4bfb-9a75-812ba561d8d7")
public abstract class ArchiElementEditPart extends AbstractNodeEditPart {
    @objid ("4c0dae8c-12c6-4299-a274-44563c6bbee2")
    @Override
    public boolean isSelectable() {
        return true;
    }

    @objid ("073b60e0-828a-45f2-9f6f-9824f6a0e363")
    @Override
    protected void addChildVisual(EditPart childEditPart, int index) {
        final IFigure child = ((GraphicalEditPart) childEditPart).getFigure();
        if (index == 0) {
            getFigure().add(child, BorderLayout.TOP, index);
        } else {
            getFigure().add(child, BorderLayout.CENTER, index);
        }

    }

    @objid ("5430cd90-6fd3-415e-af42-2bc0d2c9c019")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.NODE_ROLE, new DefaultCreateLinkEditPolicy());
        installEditPolicy(LinkedNodeRequestConstants.REQ_LINKEDNODE_START, new LinkedNodeStartCreationEditPolicy());

        installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeferringCreateNodePolicy());

        // Override the default drop policy.
        installEditPolicy(ModelElementDropRequest.TYPE, new ArchiFreeZoneElementDropEditPolicy());
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

    @objid ("b8755e2a-9c53-40bc-a3ef-26e6ce36fdfc")
    @Override
    protected void refreshVisuals() {
        super.refreshVisuals();
        GmAbstractObject model = getModel();
        getFigure().getParent().setConstraint(getFigure(), model.getLayoutData());

    }

    @objid ("b2753cc2-49c4-4f7e-b9ce-48372bf28376")
    @Override
    protected void refreshChildren() {
        super.refreshChildren();
        boolean wideMode = this.getChildren().size() == 1;
        for (Object e : getChildren()) {
            if (e instanceof ArchiHeaderEditPart) {
                ((ArchiHeaderEditPart) e).setWideMode(wideMode);
                break;
            }
        }

    }

    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("e668e4e3-3a03-4320-ae47-61c04ce8506c")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return ArchimateAnchors.defaultFor(this);
    }

}
