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

import java.util.Objects;
import java.util.function.Consumer;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.modelio.platform.model.ui.panels.search.query.commands.MqlStepCommands;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

/**
 * Right-panel section shown when a Repeat step is selected.
 * <p>
 * Shows:
 * <ul>
 * <li>Checkbox: "Emit nodes at every depth level" ({@code emitAllDepths})</li>
 * <li>Mini list of body sub-steps with add / remove buttons</li>
 * </ul>
 */
@objid ("ca7dced4-7d3f-4773-9f8b-23d2ad0b7abc")
public final class MqlRepeatPanel {
    @objid ("7b472735-b27a-41c7-8926-4c60823d6c74")
    private Composite group;

    @objid ("5fbd83d6-5a4f-463c-8d5b-746315b943a7")
    private Button emitAllDepthsCheck;

    @objid ("3c7f12a8-6551-48b3-9738-96c86fb3a49d")
    private List bodyList;

    @objid ("458e4860-81f0-48e8-9eb4-d51f9c6c4590")
    private final MqlQueryModel model;

    @objid ("2c17bc94-8b22-43f7-afd4-faea81e7a6e8")
    private MqlStepNode selected;

    @objid ("1ccc0cce-455f-43c0-baff-9962d04854aa")
    private org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode.Location selectedLocation;

    @objid ("193fe79c-e7bb-47f3-817a-e3b955b3111a")
    private Consumer<MqlStepNode> onSubStepSelected;

    @objid ("3049e8b4-c4be-49b7-bb06-aa8900e21288")
    public MqlRepeatPanel(final MqlQueryModel model) {
        this.model = Objects.requireNonNull(model, "model");
    }

    /**
     * Sets a callback invoked when the user clicks a body step, so the host dialog
     * can update the Traverse/Expression panels for that sub-step.
     */
    @objid ("1445753d-f350-43b9-9c20-c40241a80729")
    public void setOnSubStepSelected(final Consumer<MqlStepNode> callback) {
        this.onSubStepSelected = callback;
    }

    @objid ("def86045-8924-494b-978f-2bdbd11ead4e")
    public Composite createControls(final Composite parent) {
        Listener deleteListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                    if (selectedLocation != null) {
                        switch (selectedLocation.container()) {
                        case TOP_LEVEL    : selectedLocation.root().removeStep(selectedLocation.index()); break;
                        case UNION_BRANCH  : selectedLocation.parentStep().removeUnionBranchStep(selectedLocation.branchIndex(),selectedLocation.index()); break;
                        case REPEAT_BODY  : selectedLocation.parentStep().removeRepeatBodyStep(selectedLocation.index()); break;
                        }
                    }
            }
        };
        this.group = PanelUtils.createHeaderComposite(parent,CoreUi.I18N.getString("MqlQueryEditor.repeatPanel.header"),deleteListener);

        // ── emitAllDepths checkbox ─────────────────────────────────────────
        this.emitAllDepthsCheck = new Button(this.group, SWT.CHECK);
        this.emitAllDepthsCheck.setText(CoreUi.I18N.getString("MqlQueryEditor.repeatPanel.emitFrontierOnly"));
        GridData chkGd = new GridData(SWT.FILL, SWT.TOP, true, false);
        chkGd.horizontalSpan = 2;
        this.emitAllDepthsCheck.setLayoutData(chkGd);
        this.emitAllDepthsCheck.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MqlRepeatPanel.this.selected == null) return;
                RepeatStep rs = (RepeatStep) MqlRepeatPanel.this.selected.getAst();
                rs.setEmitAllDepths(!MqlRepeatPanel.this.emitAllDepthsCheck.getSelection());
                MqlRepeatPanel.this.selected.notifyChanged();
            }
        });
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.emitAllDepthsCheck);

        return this.group;
    }

    @objid ("8fea0db7-a0c7-4621-88d6-f60f2a39c928")
    public Control getControl() {
        return this.group;
    }

    /**
     * Shows / hides this section based on whether {@code step} is a Repeat step.
     */
    @objid ("0e6f5a21-0cb3-4b04-8d66-1961823de6f2")
    public void setSelectedStep(final MqlStepNode step) {
        this.selected = (step != null && step.isRepeat()) ? step : null;
        this.selectedLocation = this.selected != null ? this.selected.locate() : null;
        boolean show = this.selected != null;
        if (this.group == null || this.group.isDisposed()) return;

        this.group.setVisible(show);
        ((GridData) this.group.getLayoutData()).exclude = !show;
        this.group.getParent().layout(true, true);

        if (show) {
            RepeatStep rs = (RepeatStep) this.selected.getAst();
            this.emitAllDepthsCheck.setSelection(!rs.isEmitAllDepths());
        }
    }

}
