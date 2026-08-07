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
package org.modelio.platform.model.ui.panels.search.query.elements.repeat;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlPipelineEditPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddRepeatBodyStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;

/**
 * Edit part for {@link org.modelio.platform.query.api.model.query.RepeatStep}.
 */
@objid ("d6b7c46e-baf3-4a98-b467-a891331c4af4")
public class MqlRepeatStepEditPart extends MqlStepEditPart {
    @objid ("d7c8cc5d-8420-4a34-8d93-11ea4fd2b83e")
    @Override
    protected IFigure createFigure() {
        return new MqlRepeatFigure();
    }

    @objid ("7d281735-d4b3-431f-ad52-5bc7d2ff4248")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.COMPONENT_ROLE, new MqlPipelineEditPolicy());
    }

    @objid ("31ae9091-4648-4b43-ba60-5465c759db33")
    @Override
    public IFigure getContentPane() {
        return ((MqlRepeatFigure) getFigure()).getBodyPane();
    }

    @objid ("9c348a11-d627-4ca2-99ac-9871e1816beb")
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected List getModelChildren() {
        MqlStepNode node = (MqlStepNode) getMqlNode();
        List<Object> children = new ArrayList<>(node.getRepeatBody());
        children.add(new MqlAddRepeatBodyStepNode(node));
        return children;
    }

    @objid ("f73ef6a0-0cb4-49b8-9bcf-19650f23710b")
    @Override
    protected void refreshVisuals() {

    }

}
