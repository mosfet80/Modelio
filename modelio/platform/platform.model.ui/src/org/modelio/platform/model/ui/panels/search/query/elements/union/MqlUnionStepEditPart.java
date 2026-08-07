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
package org.modelio.platform.model.ui.panels.search.query.elements.union;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Edit part for {@link org.modelio.platform.query.api.model.query.UnionStep}.
 */
@objid ("61870af3-cf47-4ed6-9531-fa95feaa6cd6")
public class MqlUnionStepEditPart extends MqlStepEditPart {
    @objid ("68b4b447-8e72-416b-9f86-8b882113627a")
    @Override
    public IFigure createFigure() {
        return new MqlUnionFigure();
    }

    @objid ("b24d20b5-629f-434b-8723-67be3ef766b4")
    @Override
    public void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("1e531815-8c87-4d5a-8ec9-c5e1fdb50732")
    @Override
    public IFigure getContentPane() {
        return ((MqlUnionFigure) getFigure()).getBranchesPane();
    }

    @objid ("b60e7bf7-2bbb-456e-8664-4cac2f415008")
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getModelChildren() {
        MqlStepNode node = (MqlStepNode) getMqlNode();
        return node.getUnionBranches();
    }

    @objid ("e29220c7-6ace-4589-a4d5-f52d5318b1eb")
    @Override
    protected void refreshVisuals() {
        MqlStepNode node = (MqlStepNode) getMqlNode();
        MqlUnionFigure fig = (MqlUnionFigure) getFigure();

        int branchCount = node.getUnionBranches().size();
        fig.setBranchCount(branchCount);
    }

}
