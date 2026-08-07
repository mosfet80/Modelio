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
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

/**
 * Right-panel section shown when a Union step is selected.
 * <p>
 * Shows:
 * <ul>
 * <li>Delete union node button</li>
 * <li>Add branch button</li>
 * <li>Table of existing branches with a remove button</li>
 * </ul>
 */
@objid ("f0ea023c-12f6-4c19-ae28-6250d7ff4ae3")
public final class MqlUnionPanel {
    @objid ("ab391786-3379-4ce8-a262-6051bf529fd0")
    private Composite group;

    @objid ("b74bab04-77f6-46ed-9af0-53cb062eeea5")
    private TableViewer branchTable;

    @objid ("ec7eb6f6-8164-4502-b051-5c56c9aaa8aa")
    private final MqlQueryModel model;

    @objid ("3140de4a-3027-4296-a09d-df63037c7b96")
    private MqlStepNode selected;

    @objid ("cc90a408-2795-4b66-8b52-51ecbf8db9f3")
    private org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode.Location selectedLocation;

    @objid ("0a2bfd7b-2da6-48a8-930f-ba85bb610517")
    public MqlUnionPanel(final MqlQueryModel model) {
        this.model = Objects.requireNonNull(model, "model");
    }

    @objid ("075fc1a0-830c-4007-863f-d6c4ae1c7b36")
    public Composite createControls(final Composite parent) {
        Listener deleteListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (selectedLocation != null) {
                    switch (selectedLocation.container()) {
                    case TOP_LEVEL    : selectedLocation.root().removeStep(selectedLocation.index()); break;
                    case UNION_BRANCH : selectedLocation.parentStep().removeUnionBranchStep(selectedLocation.branchIndex(), selectedLocation.index()); break;
                    case REPEAT_BODY  : selectedLocation.parentStep().removeRepeatBodyStep(selectedLocation.index()); break;
                    }
                }
            }
        };
        this.group = PanelUtils.createHeaderComposite(parent, CoreUi.I18N.getString("MqlQueryEditor.unionPanel.header"), deleteListener);

        Label brancheLabel = new Label(this.group, SWT.NONE);
        brancheLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.unionPanel.branch.label"));
        PolluxWidgetConfigurator.configureSubtitleStyle(brancheLabel);
        brancheLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));

        // ── Table + buttons wrapper (2 columns) ──────────────────────────
        Composite tableArea = new Composite(this.group, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(tableArea);
        tableArea.setLayout(new GridLayout(2, false));
        tableArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        // ── Branch table ───────────────────────────────────────────────────
        this.branchTable = new TableViewer(tableArea, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
        Table table = this.branchTable.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        GridData tableGd = new GridData(SWT.FILL, SWT.FILL, true, true);
        tableGd.heightHint = 100;
        table.setLayoutData(tableGd);

        this.branchTable.setContentProvider(ArrayContentProvider.getInstance());

        // Column: Branch name
        TableViewerColumn nameCol = new TableViewerColumn(this.branchTable, SWT.NONE);
        nameCol.getColumn().setText(CoreUi.I18N.getString("MqlQueryEditor.unionPanel.branch.column.name"));
        nameCol.getColumn().setWidth(120);
        nameCol.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                int index = ((BranchRow) element).index;
                return CoreUi.I18N.getMessage("MqlUnion.branch", String.valueOf(index + 1));
            }
        });

        // Column: Step count
        TableViewerColumn countCol = new TableViewerColumn(this.branchTable, SWT.NONE);
        countCol.getColumn().setText(CoreUi.I18N.getString("MqlQueryEditor.unionPanel.branch.column.steps"));
        countCol.getColumn().setWidth(80);
        countCol.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                int count = ((BranchRow) element).stepCount;
                return count + " step" + (count != 1 ? "s" : "");
            }
        });

        // ── Button bar (right of table, vertical) ──────────────────────────
        Composite btnBar = new Composite(tableArea, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(btnBar);
        btnBar.setLayout(new GridLayout(1, false));
        btnBar.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));

        Button addBranchBtn = new Button(btnBar, SWT.PUSH);
        addBranchBtn.setImage(UIImages.ADD);
        addBranchBtn.setToolTipText(CoreUi.I18N.getString("MqlQueryEditor.unionPanel.addBranch.tooltip"));
        addBranchBtn.addListener(SWT.Selection, e -> {
            if (this.selected != null) {
                this.selected.addUnionBranch();
                refreshBranches();
            }
        });

        Button removeBranchBtn = new Button(btnBar, SWT.PUSH);
        removeBranchBtn.setImage(UIImages.DELETE);
        removeBranchBtn.setToolTipText(CoreUi.I18N.getString("MqlQueryEditor.unionPanel.removeBranch.tooltip"));
        removeBranchBtn.addListener(SWT.Selection, e -> {
            if (this.selected != null) {
                IStructuredSelection sel = this.branchTable.getStructuredSelection();
                if (!sel.isEmpty()) {
                    int branchIndex = ((BranchRow) sel.getFirstElement()).index;
                    this.selected.removeUnionBranch(branchIndex);
                    refreshBranches();
                }
            }
        });

        return this.group;
    }

    /**
     * Shows / hides this section based on whether {@code step} is a Union step.
     */
    @objid ("8e7cc921-ae1a-4cfc-aa10-4fbe9e688dc5")
    public void setSelectedStep(final MqlStepNode step) {
        this.selected = (step != null && step.isUnion()) ? step : null;
        this.selectedLocation = this.selected != null ? this.selected.locate() : null;
        boolean show = this.selected != null;
        if (this.group == null || this.group.isDisposed()) return;

        this.group.setVisible(show);
        ((GridData) this.group.getLayoutData()).exclude = !show;
        this.group.getParent().layout(true, true);

        if (show) {
            refreshBranches();
        }
    }

    @objid ("196f32af-def0-4492-9769-2e222538b771")
    public Control getControl() {
        return this.group;
    }

    // ── Private ───────────────────────────────────────────────────────────────
    @objid ("535d529e-d4f3-4062-9e52-790fdf9533a7")
    private void refreshBranches() {
        if (this.branchTable == null || this.branchTable.getTable().isDisposed() || this.selected == null) return;

        List<List<MqlStepNode>> branches = this.selected.getUnionBranches();
        BranchRow[] rows = new BranchRow[branches.size()];
        for (int i = 0; i < branches.size(); i++) {
            rows[i] = new BranchRow(i, branches.get(i).size());
        }
        this.branchTable.setInput(rows);
        this.group.layout(true, true);
    }

    @objid ("04bbac56-5fef-4234-a8d0-666c4c2c2378")
    private static final class BranchRow {
        @objid ("ce40d12d-1fa3-48c0-899f-d761c907b610")
        final int index;

        @objid ("c1e5876c-9ba8-4156-894c-a10ff330b88b")
        final int stepCount;

        @objid ("26cbba46-8e99-4c96-adb8-f5a23333b4a1")
        BranchRow(int index, int stepCount) {
            this.index = index;
            this.stepCount = stepCount;
        }

    }

}
