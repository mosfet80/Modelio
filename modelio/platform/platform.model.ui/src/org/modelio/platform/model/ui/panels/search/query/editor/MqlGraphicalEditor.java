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
package org.modelio.platform.model.ui.panels.search.query.editor;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlRequestConstants;
import org.modelio.platform.model.ui.panels.search.query.editpolicies.MqlRequestConstants.StepType;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlEditPartFactory;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

/**
 * Minimal GEF-based viewer for an {@link MqlQueryModel}.
 * <p>
 * This class is a lightweight embeddable editor component (not a file editor).
 */
@objid ("b7084528-8994-4fe5-bac8-5b1b335a619d")
public final class MqlGraphicalEditor {
    @objid ("bc760a11-fa9c-4ae4-893d-b6e57f624df6")
    private final GraphicalViewer viewer;

    @objid ("44ae11c4-cec3-477a-a323-b49ef2f046c8")
    private final CommandStack commandStack = new CommandStack();

    @objid ("df9a61d3-1360-499a-b04a-dd844de3121e")
    private MqlQueryModel model;

    @objid ("c8c3b6ed-0fab-4801-bad7-0b2b47a75210")
    private PropertyChangeListener modelListener;

    @objid ("bac6d878-1ef7-4e1a-b38f-8aaf57b84d4d")
    public MqlGraphicalEditor(final Composite parent, MqlValidationService validationService) {
        Objects.requireNonNull(parent, "parent");
        Objects.requireNonNull(validationService, "validationService");

        ScrollingGraphicalViewer scrollingViewer = new ScrollingGraphicalViewer();
        scrollingViewer.createControl(parent);
        this.viewer = scrollingViewer;

        PolluxWidgetConfigurator.configureContainer((Composite)this.viewer.getControl());

        // Install an EditDomain with a SelectionTool so that mouse clicks are
        // processed and edit parts can be selected in the pipeline.
        EditDomain editDomain = new EditDomain();
        editDomain.setDefaultTool(new SelectionTool());
        editDomain.addViewer(this.viewer);

        this.viewer.setRootEditPart(new ScalableRootEditPart());
        this.viewer.setEditPartFactory(new MqlEditPartFactory());
        this.viewer.setProperty(MqlValidationService.class.getName(), validationService);
        //  installContextMenu();
    }

    @objid ("0024f0ee-affb-4db5-9c07-91d9365f9c3a")
    public Control getControl() {
        return this.viewer.getControl();
    }

    @objid ("efa4d3fb-9319-4161-9b27-7029a234ed8e")
    public GraphicalViewer getViewer() {
        return this.viewer;
    }

    @objid ("89f0aae9-fb3d-42db-b71e-a0ec22077802")
    public CommandStack getCommandStack() {
        return this.commandStack;
    }

    @objid ("4a65a48d-21c4-4346-9492-aaaeb98c1581")
    public void setModel(final MqlQueryModel model) {
        if (this.model == model) {
            return;
        }

        unhookModel();
        this.model = model;
        hookModel();

        if (model != null) {
            this.viewer.setContents(model);
        } else {
            this.viewer.setContents(new Object());
        }
    }

    @objid ("8967844e-99d0-44d4-a318-184853f20cb1")
    private void hookModel() {
        if (this.model == null) {
            return;
        }

        this.modelListener = evt -> {
            String prop = evt.getPropertyName();
            // Only react to structural changes — individual property edits are
            // handled by per-step PropertyChangeListeners in MqlStepEditPart.
        if (MqlQueryModel.PROP_STEPS.equals(prop) || MqlQueryModel.PROP_SOURCE.equals(prop)) {
                Control ctrl = this.viewer.getControl();
                if (ctrl != null && !ctrl.isDisposed()) {
                    ctrl.getDisplay().asyncExec(() -> {
                        if (ctrl.isDisposed()) return;
                        // refresh() preserves current selection; setContents() would clear it
                        org.eclipse.gef.EditPart contents = this.viewer.getContents();
                        if (contents != null) {
                            contents.refresh();
                        }
                    });
                }
            }
        };

        this.model.addPropertyChangeListener(this.modelListener);
    }

    @objid ("312eea40-e226-4286-9a40-309f5fad7875")
    private void unhookModel() {
        if (this.model != null && this.modelListener != null) {
            this.model.removePropertyChangeListener(this.modelListener);
        }
        this.modelListener = null;
    }

}
