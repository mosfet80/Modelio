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
package org.modelio.platform.model.ui.panels.search.query.elements.filter;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.query.elements.core.AbstractMqlExpressionPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExpressionTreeModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Panel for editing the WHERE expression on a
 * {@link org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep}.
 * <p>
 * Shows a delete button in the header, since a filter node can be removed from the pipeline.
 */
@objid ("5200471c-b9ab-466d-bc22-83943cc41275")
public final class MqlFilterExpressionPanel extends AbstractMqlExpressionPanel {
    @objid ("47472474-d196-4cc0-bd6a-b7560a9553f1")
    private org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode.Location selectedLocation;

    @objid ("9e357fe9-dc89-47df-b134-122ff691e836")
    public MqlFilterExpressionPanel(final MqlQueryModel rootModel, final MqlValidationService validation, final ICoreSession session, final MetamodelHelper metamodelhelper) {
        super(rootModel, validation, session,metamodelhelper);
    }

    @objid ("aca9b5fb-3c93-42e8-9eff-6cf36afca9ee")
    @Override
    public Composite createControls(final Composite parent) {
        Listener deleteListener = new Listener() {
            @Override
            public void handleEvent(final Event event) {
                if (MqlFilterExpressionPanel.this.selectedLocation != null) {
                    switch (MqlFilterExpressionPanel.this.selectedLocation.container()) {
                    case TOP_LEVEL:
                        MqlFilterExpressionPanel.this.selectedLocation.root()
                                .removeStep(MqlFilterExpressionPanel.this.selectedLocation.index());
                        break;
                    case UNION_BRANCH:
                        MqlFilterExpressionPanel.this.selectedLocation.parentStep().removeUnionBranchStep(
                                MqlFilterExpressionPanel.this.selectedLocation.branchIndex(),
                                MqlFilterExpressionPanel.this.selectedLocation.index());
                        break;
                    case REPEAT_BODY:
                        MqlFilterExpressionPanel.this.selectedLocation.parentStep()
                                .removeRepeatBodyStep(MqlFilterExpressionPanel.this.selectedLocation.index());
                        break;
                    }
                }
            }
        };

        this.group = PanelUtils.createHeaderComposite(parent, CoreUi.I18N.getString("MqlQueryEditor.filterPanel.filter"), deleteListener);

        this.editorArea = new Composite(this.group, SWT.NONE);
        this.editorArea.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        this.editorArea.setLayout(new GridLayout(1, false));
        PolluxWidgetConfigurator.configureContainer(this.editorArea);

        this.issuesLabel = new Label(this.group, SWT.WRAP);
        this.issuesLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.issuesLabel);


        return this.group;
    }

    @objid ("99f220c5-ede3-4caa-83da-c75bd38c0c6a")
    @Override
    public void setSelectedStep(final MqlStepNode stepNode) {
        if (this.group == null || this.group.isDisposed()) {
            return;
        }

        boolean relevant = stepNode != null && stepNode.isFilter();

        this.selectedLocation = relevant ? stepNode.locate() : null;
        this.expressionModel = relevant?
                new MqlExpressionTreeModel(this.rootModel, stepNode, MqlExpressionTreeModel.Target.FILTER_WHERE)
                : null;
        this.group.setVisible(relevant);
        ((GridData) this.group.getLayoutData()).exclude = !relevant;
        this.group.getParent().layout(true, true);

        if (relevant) {
            rebuild();
        }
    }

    @objid ("c726da27-b292-4ed3-b263-cb4b8d4cac6d")
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

            if(this.expressionModel.getExpr() instanceof IsExpr || this.expressionModel.getExpr() instanceof ExistsExpr) {
                this.
                renderByTypeFilterPanel(this.editorArea, this.expressionModel.getExpr(), this.expressionModel::setExpr);
            }else if(this.expressionModel.getExpr() instanceof CompareExpr) {
                renderCompareFilterPanel(this.editorArea, this.expressionModel.getExpr(), this.expressionModel::setExpr);
            }else if(this.expressionModel.getExpr() instanceof AndExpr || this.expressionModel.getExpr() instanceof OrExpr) {
                renderCompositeComparePanel(this.editorArea, this.expressionModel.getExpr(), this.expressionModel::setExpr);
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
