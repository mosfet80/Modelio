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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddBranchStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.NodeStyles;

/**
 * Edit part for a union branch lane.
 */
@objid ("9224c4c0-4907-4c01-8d9a-3d25f1460cda")
public class MqlUnionBranchEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
    @objid ("061b1b92-fb79-42d4-b2e1-db6c5959425e")
    @Override
    public IFigure createFigure() {
        return new MqlBranchFigure();
    }

    @objid ("d41b85e1-c468-474f-9a55-393b033ea668")
    @Override
    public void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("c13126b5-f356-4ff9-ad20-4b043e497bea")
    @Override
    public void activate() {
        super.activate();
        MqlStepNode unionStep = (MqlStepNode) getParent().getModel();
        unionStep.addPropertyChangeListener(this);
    }

    @objid ("5e386b43-eb62-45bb-8d47-8571e69f6ffb")
    @Override
    public void deactivate() {
        MqlStepNode unionStep = (MqlStepNode) getParent().getModel();
        unionStep.removePropertyChangeListener(this);
        super.deactivate();
    }

    @objid ("ebb619eb-7a7a-434a-987e-de1e44ce5a00")
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        if (getParent() != null) {
            refreshChildren();
        }
    }

    @objid ("4fedfd47-0e6c-4c03-89e3-2b707468b843")
    @Override
    public IFigure getContentPane() {
        return ((MqlBranchFigure) getFigure()).getContentPane();
    }

    @objid ("43a36e65-9292-4fc8-a838-c58f8d75f649")
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getModelChildren() {
        List<MqlStepNode> branchSteps = (List<MqlStepNode>) getModel();
        List<Object> children = new ArrayList<>(branchSteps);

        // Resolve parent union step and branch index
        MqlStepNode unionStep = (MqlStepNode) getParent().getModel();
        int branchIndex = unionStep.getUnionBranches().indexOf(branchSteps);
        children.add(new MqlAddBranchStepNode(unionStep, branchIndex));

        return children;
    }

}
