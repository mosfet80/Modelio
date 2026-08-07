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
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.diagram.elements.common.image.NonSelectableImageEditPart;
import org.modelio.diagram.elements.core.link.anchors.fixed2.DefaultFixedAnchorProvider;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;
import org.modelio.diagram.elements.core.policies.DeferringCreateNodePolicy;
import org.modelio.diagram.elements.core.requests.ModelElementDropRequest;

/**
 * EditPart for a {@link GmArchiElement} in Image/UserImage modes.
 */
@objid ("81661b3f-5c07-498c-bf7e-d67061ade5d3")
public class ArchiElementImageEditPart extends NonSelectableImageEditPart {
    @objid ("6a8027be-4ba4-4050-a784-a222790a0af8")
    @Override
    protected void setFigure(IFigure figure) {
        super.setFigure(figure);
    }

    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("48c2ded2-ff87-4858-83c1-349b21fc45dc")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return DefaultFixedAnchorProvider.defaultFor(this);
    }

    @objid ("bafd9689-3c40-4ec7-8b63-02911595e32f")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeferringCreateNodePolicy());

        // Override the default drop policy.
        installEditPolicy(ModelElementDropRequest.TYPE, new ArchiFreeZoneElementDropEditPolicy());
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

}
