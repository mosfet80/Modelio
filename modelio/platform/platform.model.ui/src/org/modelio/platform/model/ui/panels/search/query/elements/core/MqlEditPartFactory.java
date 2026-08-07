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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddBranchStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddBranchStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddRepeatBodyStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddRepeatBodyStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.filter.MqlFilterStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.repeat.MqlRepeatStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.source.MqlSourceEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.source.MqlSourceNode;
import org.modelio.platform.model.ui.panels.search.query.elements.traverse.MqlTraverseStepEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.union.MqlUnionBranchEditPart;
import org.modelio.platform.model.ui.panels.search.query.elements.union.MqlUnionStepEditPart;

/**
 * Central edit part factory for the MQL pipeline viewer.
 */
@objid ("6b67ee52-19b0-41a9-b344-8f31d8692118")
public final class MqlEditPartFactory implements EditPartFactory {
    @objid ("e4657beb-f032-4c27-ad22-a687e42accbc")
    @Override
    public EditPart createEditPart(final EditPart context, final Object model) {
        if (model instanceof MqlQueryModel) {
            EditPart part = new MqlQueryEditPart();
            part.setModel(model);
            return part;
        }
        if (model instanceof MqlSourceNode) {
            EditPart part = new MqlSourceEditPart();
            part.setModel(model);
            return part;
        }
        if (model instanceof MqlAddStepNode) {
            EditPart part = new MqlAddStepEditPart();
            part.setModel(model);
            return part;
        }
        if (model instanceof MqlAddBranchStepNode) {
            EditPart part = new MqlAddBranchStepEditPart();
            part.setModel(model);
            return part;
        }
        if (model instanceof MqlAddRepeatBodyStepNode) {
            EditPart part = new MqlAddRepeatBodyStepEditPart();
            part.setModel(model);
            return part;
        }
        if (model instanceof MqlStepNode step) {
            if (step.isFilter()) {
                EditPart part = new MqlFilterStepEditPart();
                part.setModel(model);
                return part;
            }
            if (step.isTraverse()) {
                EditPart part = new MqlTraverseStepEditPart();
                part.setModel(model);
                return part;
            }
            if (step.isUnion()) {
                EditPart part = new MqlUnionStepEditPart();
                part.setModel(model);
                return part;
            }
            if (step.isRepeat()) {
                EditPart part = new MqlRepeatStepEditPart();
                part.setModel(model);
                return part;
            }
        }
        if (model instanceof java.util.List<?> list) {
            if (list.isEmpty() || list.get(0) instanceof MqlStepNode) {
                EditPart part = new MqlUnionBranchEditPart();
                part.setModel(model);
                return part;
            }
        }

        EditPart placeholder = new PlaceholderEditPart();
        placeholder.setModel(model);
        return placeholder;
    }

    @objid ("0a8f8a8b-bf5f-48e5-82a8-45f21103b8c6")
    private static final class PlaceholderEditPart extends AbstractGraphicalEditPart {
        @objid ("8e55cf2b-2a64-4216-a937-d7313b85b941")
        @Override
        protected Figure createFigure() {
            Figure fig = new Figure();
            ToolbarLayout layout = new ToolbarLayout();
            layout.setSpacing(4);
            fig.setLayoutManager(layout);
            fig.setBorder(new MarginBorder(6));
            fig.add(new Label("(placeholder)"));
            return fig;
        }

        @objid ("45b8512a-63d3-4ecc-8f74-d4607d6b8c49")
        @Override
        protected void refreshVisuals() {
            Figure fig = (Figure) getFigure();
            Object model = getModel();
            if (fig.getChildren().size() > 0 && fig.getChildren().get(0) instanceof Label label) {
                label.setText(model != null ? model.getClass().getSimpleName() : "null");
            }
        }

        @objid ("409f2e1c-3631-4228-aa1f-b53ab14dd76f")
        @Override
        protected void createEditPolicies() {
            // no-op
        }

    }

}
