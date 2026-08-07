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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlSelectionFeedbackPolicy;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;

/**
 * Base edit part for a pipeline {@link MqlStepNode}.
 * <p>
 * Installs selection feedback so nodes are visually highlighted when clicked,
 * and fires {@link #refreshVisuals()} on model property changes.
 */
@objid ("0aab2852-1310-4454-a519-2cd58f774438")
public abstract class MqlStepEditPart extends AbstractGraphicalEditPart implements PropertyChangeListener {
    @objid ("e5be6f00-24d4-4b06-9e43-c49f17005f26")
    public MqlValidationService getValidator() {
        return (MqlValidationService) getViewer().getProperty(MqlValidationService.class.getName());
    }

    /**
     * Get resolver-attributed diagnostics for a given AST step.
     */
    @objid ("1cf51e3c-98cd-47c5-a0bf-2afac850efba")
    protected List<Diagnostic> getDiagnosticsFor(final Step step) {
        MqlValidationService service = getValidator();
        return service != null ? service.getDiagnosticsFor(step) : List.of();
    }

    @objid ("3da620f5-b2a7-4cab-bb00-586243220bc3")
    @Override
    public void activate() {
        super.activate();
        getMqlNode().addPropertyChangeListener(this);
        refreshVisuals();
    }

    @objid ("6aec880b-c9b6-45cc-82f0-06a8fce85041")
    @Override
    public void deactivate() {
        getMqlNode().removePropertyChangeListener(this);
        super.deactivate();
    }

    @objid ("c3434164-8a3c-4710-b182-392931ee3f76")
    protected final AbstractMqlNode getMqlNode() {
        return (AbstractMqlNode) getModel();
    }

    @objid ("3c956a34-1033-4e37-b203-90e4cc415747")
    @Override
    public void propertyChange(final PropertyChangeEvent evt) {
        refreshVisuals();
        refreshChildren();
    }

    /**
     * Installs a {@link SelectionEditPolicy} that draws a colored border
     * around the figure when the node is selected or has focus.
     * <p>
     * Subclasses must call {@code super.createEditPolicies()} (or install their
     * own SELECTION_FEEDBACK_ROLE policy) to keep selection feedback working.
     */
    @objid ("fbcc0bbe-a569-4953-8b60-7dfd4a3986df")
    @Override
    protected void createEditPolicies() {
        installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new MqlSelectionFeedbackPolicy());
    }

    @objid ("c9cc3fd0-142f-4166-89a3-e870c926530d")
    protected static String bestIssueMessage(final List<Diagnostic> issues) {
        if (issues == null || issues.isEmpty()) return "";
        for (Diagnostic d : issues) {
            if (d.level() == Diagnostic.Level.ERROR) return d.message();
        }
        for (Diagnostic d : issues) {
            if (d.level() == Diagnostic.Level.WARNING) return d.message();
        }
        return issues.get(0).message();
    }

}
