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
package org.modelio.platform.model.ui.panels.search.query.elements.source;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlSelectionFeedbackPolicy;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepEditPart;

/**
 * Edit part for the query {@link org.modelio.platform.query.api.model.query.Source}.
 */
@objid ("f581d02f-6f37-4374-a141-21739675997d")
public class MqlSourceEditPart extends MqlStepEditPart {
    @objid ("ea9cddb8-80f7-49b2-bbeb-8754000073a5")
    @Override
    protected IFigure createFigure() {
        return new MqlSourceFigure();
    }

    @objid ("7540ef9a-488b-4f03-b301-adbe2f253045")
    @Override
    protected void createEditPolicies() {
        super.createEditPolicies();
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new MqlSelectionFeedbackPolicy());
    }

    @objid ("065aa33c-b47c-40af-9953-c51f7af7cbe2")
    @Override
    protected void refreshVisuals() {
        MqlSourceNode node = (MqlSourceNode) getModel();
        MqlSourceFigure fig = (MqlSourceFigure) getFigure();
        if (node.isAll()) {
            fig.setAllSource(node.getAllKindRef());
        } else if (node.isProvided()) {
            int providedCount = node.getProvidedCount();
            fig.setProvidedSource(providedCount);
        }
    }

}
