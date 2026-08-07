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
import org.modelio.diagram.elements.common.simple.SimpleEditPart;
import org.modelio.diagram.elements.core.link.anchors.fixed2.core.IFixedNodeAnchorProvider;
import org.modelio.diagram.elements.core.policies.AnchorsFeedbackEditPolicy;

/**
 * EditPart for a {@link GmArchiElement} in Simple mode.
 */
@objid ("82d76551-b882-4bb5-b506-3e97bbb04dec")
public class ArchiElementSimpleEditPart extends SimpleEditPart {
    /**
     * Create the {@link IFixedNodeAnchorProvider} for this edit part.
     *
     * @return the created anchor provider.
     */
    @objid ("1cb9f158-8d95-47c4-af58-5eb25a7cad7c")
    @Override
    protected IFixedNodeAnchorProvider createAnchorProvider() {
        return ArchimateAnchors.defaultFor(this);
    }

    @objid ("3eb23fbe-891e-49d0-8b54-b9703ec65594")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(AnchorsFeedbackEditPolicy.class, new AnchorsFeedbackEditPolicy(getNodeAnchorProvider()));

    }

    @objid ("df326c63-8a63-498e-8b25-ae5e26b2375e")
    @Override
    public boolean isSelectable() {
        return false;
    }

}
