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
import org.modelio.archimate.diagrams.elements.common.anchors.ArchimateAnchors;
import org.modelio.diagram.elements.common.image.NonSelectableImageEditPart;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;

@objid ("191e343d-cdac-4110-a3fc-53facd15a424")
public class ArchiNonSelectableImageEditPart extends NonSelectableImageEditPart {
    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("b6c09913-07c4-46a1-ae8c-f94ec5df2593")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return ArchimateAnchors.defaultFor(this);
    }

    @objid ("7d5b2048-c39b-4f2a-96bb-9494e2472c1c")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();

        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

}
