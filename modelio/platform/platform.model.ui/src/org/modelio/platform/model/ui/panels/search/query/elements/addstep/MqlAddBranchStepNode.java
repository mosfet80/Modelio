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
package org.modelio.platform.model.ui.panels.search.query.elements.addstep;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Marker model object for the "+" add-step node at the end of a union branch.
 * <p>
 * This node is not a real step; it is a visual placeholder that allows the user
 * to append a new step to a specific union branch by clicking the "+" circle.
 */
@objid ("678173fd-f56d-4a1f-9a5e-d909218b4ce9")
public final class MqlAddBranchStepNode {
    @objid ("f40e1462-d7c4-48ae-992f-2579ed0269af")
    private final int branchIndex;

    @objid ("43944f77-05c9-4cc6-9581-d49e950fd38b")
    private final MqlStepNode unionStep;

    @objid ("213d30b1-58c1-4e03-9bb3-0938a4f43264")
    public MqlAddBranchStepNode(final MqlStepNode unionStep, final int branchIndex) {
        this.unionStep = unionStep;
        this.branchIndex = branchIndex;
    }

    @objid ("81c99423-2d39-43b4-9b47-be4c02938e59")
    public MqlStepNode getUnionStep() {
        return this.unionStep;
    }

    @objid ("0becc6b4-ccb8-44e4-a963-c38a3f82ac6b")
    public int getBranchIndex() {
        return this.branchIndex;
    }

    @objid ("60908514-5a03-42af-8f5f-ba2bcad491c8")
    public MqlQueryModel getQueryModel() {
        return this.unionStep.getRoot();
    }

}
