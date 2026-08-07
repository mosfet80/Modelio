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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;

/**
 * Root edit part for the query pipeline.
 * <p>
 * Model children are the source node followed by ordered step nodes.
 */
@objid ("c2a2c3ea-4046-46fc-b828-2dd540c5c845")
public class MqlQueryEditPart extends AbstractGraphicalEditPart {
    @objid ("d46643b6-2db7-4ef2-a698-b41a2c5d5c63")
    @Override
    protected Figure createFigure() {
        Figure lane = new Figure();
        ToolbarLayout layout = new ToolbarLayout(true);
        layout.setStretchMinorAxis(false);
        layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
        layout.setSpacing(20);
        lane.setLayoutManager(layout);
        lane.setBorder(new MarginBorder(10));
        return lane;
    }

    @objid ("d45e5dce-31a4-4fa9-b5bc-6fb50e8534f5")
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("b36a1f30-b43b-42c2-ace6-1f7d61868552")
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List getModelChildren() {
        MqlQueryModel model = (MqlQueryModel) getModel();
        List<Object> children = new ArrayList<>();
        if (model.getSourceNode() != null) {
            children.add(model.getSourceNode());
        }
        children.addAll(model.getStepNodes());
        // "+" button node at the end of the pipeline
        children.add(model.getAddStepNode());
        return children;
    }

}
