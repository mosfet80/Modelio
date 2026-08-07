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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.query.elements.core.AbstractMqlExpressionPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExpressionTreeModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Panel for editing the optional edge-condition expression on a
 * {@link org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep}.
 * <p>
 * The edge condition is optional; a checkbox enables or disables it.
 * No delete button is shown here since the TraversePanel already provides step deletion.
 */
@objid ("246b2482-6cde-4da2-9fc1-07602d6f34ee")
public final class MqlTraverseExpressionPanel extends AbstractMqlExpressionPanel {
    @objid ("6fcb5094-fbb5-42cb-8b6b-d8a80e7fb2ac")
    public MqlTraverseExpressionPanel(final MqlQueryModel rootModel, final MqlValidationService validation, final ICoreSession session, final MetamodelHelper metamodelhelper) {
        super(rootModel, validation, session,metamodelhelper);
    }

    @objid ("df2aa48d-c6f1-497d-8cd3-b045698e4533")
    @Override
    public Composite createControls(final Composite parent) {
        this.group = PanelUtils.createHeaderComposite(parent,CoreUi.I18N.getString("MqlQueryEditor.nodeProperties.edgeCondition"), null);

        this.group  = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.group);
        GridLayout hClayout = new GridLayout(1, true);
        hClayout.marginBottom = 2;
        this.group.setLayout(hClayout);
        GridData hData = new GridData(SWT.FILL, SWT.TOP, true, true);
        hData.horizontalIndent = 0;
        this.group.setLayoutData(hData);

        this.editorArea = new Composite(this.group, SWT.NONE);
        this.editorArea.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        this.editorArea.setLayout(new GridLayout(1, false));
        PolluxWidgetConfigurator.configureContainer(this.editorArea);

        this.issuesLabel = new Label(this.group, SWT.WRAP);
        this.issuesLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.issuesLabel);

        return this.group;
    }

    @objid ("fcfe03b1-38fd-40ca-9934-db46fa73a31a")
    @Override
    public void setSelectedStep(final MqlStepNode stepNode) {
        if (this.group == null || this.group.isDisposed()) {
            return;
        }

        boolean relevant = stepNode != null && stepNode.isTraverse();

        this.expressionModel = relevant
                ? new MqlExpressionTreeModel(this.rootModel, stepNode, MqlExpressionTreeModel.Target.TRAVERSE_EDGE_FILTER)
                : null;

        this.group.setVisible(relevant);
        ((GridData) this.group.getLayoutData()).exclude = !relevant;
        this.group.getParent().layout(true, true);

        if (relevant) {
            rebuild();
        }
    }

    @objid ("dba9a45e-67e0-436b-ab83-17154a4a1c08")
    @Override
    protected void rebuild() {
        if (this.rebuilding) {
            return;
        }
        this.rebuilding = true;
        try {
            disposeChildren(this.editorArea);
            this.issuesLabel.setText("");

            if (this.expressionModel == null) {
                this.editorArea.layout(true, true);
                this.group.layout(true, true);
                return;
            }

            final Button enabled = new Button(this.editorArea, SWT.CHECK);
            enabled.setText(CoreUi.I18N.getString("MqlExpr.enableEdgeCondition"));
            enabled.setSelection(this.expressionModel.getExpr() != null);
            enabled.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(final SelectionEvent e) {
                    if (MqlTraverseExpressionPanel.this.rebuilding) {
                        return;
                    }
                    if (enabled.getSelection()) {
                        if (MqlTraverseExpressionPanel.this.expressionModel.getExpr() == null) {
                            MqlTraverseExpressionPanel.this.expressionModel.setExpr(
                                    MqlExpressionTreeModel.createDefaultExpr(MqlTraverseExpressionPanel.this.rootModel));
                        }
                    } else {
                        MqlTraverseExpressionPanel.this.expressionModel.setExpr(null);
                    }
                    rebuild();
                }
            });

            if (this.expressionModel.getExpr() == null) {
                Label none = new Label(this.editorArea, SWT.WRAP);
                none.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
                none.setText(CoreUi.I18N.getString("MqlExpr.noEdgeCondition"));
            } else {
                renderExprEditor(this.editorArea, this.expressionModel.getExpr(), this.expressionModel::setExpr);
            }

            this.editorArea.layout(true, true);
            this.group.layout(true, true);
        } finally {
            this.rebuilding = false;
            if (this.onLayoutChanged != null && this.group != null && !this.group.isDisposed()) {
                this.group.getDisplay().asyncExec(this.onLayoutChanged);
            }
        }
    }

}
