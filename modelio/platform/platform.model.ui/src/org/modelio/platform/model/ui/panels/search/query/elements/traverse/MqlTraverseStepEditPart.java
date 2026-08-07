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
package org.modelio.platform.model.ui.panels.search.query.elements.traverse;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExprNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Edit part for {@link org.modelio.platform.query.api.model.query.TraverseStep}.
 */
@objid ("c7588ff7-8964-4cc0-b51e-71949392acc0")
public class MqlTraverseStepEditPart extends MqlStepEditPart {
    @objid ("1a8a6818-81a7-4d29-8fc8-d77b417d43cb")
    @Override
    protected IFigure createFigure() {
        return new MqlTraverseFigure();
    }

    @objid ("6d3288c7-76f2-48a1-a286-a51721452a81")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("40fbd766-fc32-411c-90c4-c3da7216ebd4")
    @Override
    protected void refreshVisuals() {
        MqlStepNode node = (MqlStepNode) getMqlNode();
        MqlTraverseFigure fig = (MqlTraverseFigure) getFigure();

        fig.setEdgeText(node.getTraverseEdge(),String.valueOf(node.getTraverseDirection()).toLowerCase());

        // MqlExprNode edgeFilter = node.getEdgeFilter();
        //fig.setHasEdgeFilter(edgeFilter != null);
    }

}
