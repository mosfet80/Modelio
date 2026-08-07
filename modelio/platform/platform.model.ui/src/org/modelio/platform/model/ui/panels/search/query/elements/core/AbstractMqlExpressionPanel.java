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
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.common.MetaclassSelectorWidget;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.common.MqlDependencyPickerDialog;
import org.modelio.platform.model.ui.panels.search.common.MqlPropertyPickerDialog;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ExistsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.LiteralValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.PropertyValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.search.engine.searchers.query.api.model.query.TraverseStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueType;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic.Level;
import org.modelio.platform.search.engine.searchers.query.api.model.result.DiagnosticCode;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Abstract base class for expression panels editing {@link Expr} trees.
 * <p>
 * Contains all shared rendering logic for both filter-step and traverse-step
 * expression editors. Concrete subclasses implement step-specific panel
 * creation, step selection handling, and content rebuild.
 */
@objid ("bee06640-fc22-456d-90af-73c7e071a30d")
public abstract class AbstractMqlExpressionPanel {
    @objid ("8917dac9-7b63-4750-9370-7628fe33d0c8")
    protected boolean rebuilding;

    /**
     * Full sorted list of metaclass qualified names, used for the "Is type" combo.
     */
    @objid ("d957ddde-d7e5-4c35-98a6-8d4369593278")
    protected final List<String> allMetaclassNames;

    @objid ("946b7645-7296-4916-a74f-3a104bd0c986")
    protected Composite group;

    @objid ("2fcc2e0f-cb20-44a5-80b9-6207cf3e7a1b")
    protected Label issuesLabel;

    @objid ("5c32211b-6fde-4bbc-a12b-4753bfb0d3ca")
    protected Composite editorArea;

    @objid ("a5a598bd-c28b-4b46-9017-685e84ef7449")
    protected final MqlQueryModel rootModel;

    @objid ("bfce5899-fe22-4391-b949-0f27e1e029ff")
    protected final MqlValidationService validation;

    @objid ("047325a8-ef14-4632-8a6c-a1675e804507")
    protected final ICoreSession session;

    @objid ("5f38a045-325f-4863-b829-28cb2485f663")
    protected MqlExpressionTreeModel expressionModel;

    @objid ("781f6384-564a-4c9d-87c2-d3d193eb9b06")
    protected MetamodelHelper metamodelhelper;

    /**
     * Callback invoked (via asyncExec) after every {@link #rebuild()} so the host
     * can update its ScrolledComposite minSize.
     */
    @objid ("07d8cefa-4894-4438-aad6-ff4cbb6f04ef")
    protected Runnable onLayoutChanged;

    @objid ("49149bce-818d-4fde-af58-87e93fe5bcc3")
    protected AbstractMqlExpressionPanel(final MqlQueryModel rootModel, final MqlValidationService validation, final ICoreSession session, final MetamodelHelper metamodelhelper) {
        this.rootModel = Objects.requireNonNull(rootModel, "rootModel");
        this.validation = Objects.requireNonNull(validation, "validation");
        this.session = Objects.requireNonNull(session, "session");
        this.metamodelhelper = Objects.requireNonNull(metamodelhelper, "metamodelhelper");
        this.allMetaclassNames = this.session.getMetamodel().getRegisteredMClasses().stream().map(MClass::getQualifiedName).sorted().collect(Collectors.toList());
    }

    @objid ("ae6f18a6-6749-4c39-9132-5db5fea359b5")
    public abstract Composite createControls(final Composite parent);

    @objid ("fe9e37e3-b2dc-4489-a70f-4365a9978076")
    public abstract void setSelectedStep(final MqlStepNode stepNode);

    @objid ("2be77d1d-cc33-4987-ba1e-6924093d2d12")
    protected abstract void rebuild();

    @objid ("866a2b77-ee80-4803-afcf-b0f5fd05daf7")
    public void setOnLayoutChanged(final Runnable callback) {
        this.onLayoutChanged = callback;
    }

    @objid ("04fcc709-a386-41b4-8018-ceaf94f4b3ea")
    public Control getControl() {
        return this.group;
    }

    // ─── Shared rendering methods ────────────────────────────────────────────
    @objid ("d6defab6-4e1c-4f9e-9d9f-06bc36ce69bf")
    protected void renderCompareFilterPanel(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        renderExprBody(parent, expr, replaceRoot);
    }

    @objid ("bfccd677-af45-4ca8-93ac-de7f14c7bdc1")
    protected void renderByTypeFilterPanel(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        Composite headerComposite = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(headerComposite);
        GridLayout hClayout = new GridLayout(1, true);
        hClayout.marginBottom = 2;
        hClayout.verticalSpacing = 5;
        headerComposite.setLayout(hClayout);
        GridData hData = new GridData(SWT.FILL, SWT.TOP, true, true);
        hData.horizontalIndent = 0;
        headerComposite.setLayoutData(hData);

        Label header = new Label(headerComposite, SWT.NONE);
        header.setText(CoreUi.I18N.getString("MqlQueryEditor.filterPanel.byType.header"));
        PolluxWidgetConfigurator.configureSubtitleField(header);

        Button radioIsNav = new Button(headerComposite, SWT.RADIO);
        radioIsNav.setText(CoreUi.I18N.getString("MqlQueryEditor.filterPanel.byType.istype"));
        radioIsNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(radioIsNav);
        radioIsNav.setSelection(true);
        radioIsNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioIsNav.getSelection()) {
                    return;
                }
                ExprKind selected = ExprKind.IS;
                Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        Button radioExistNav = new Button(headerComposite, SWT.RADIO);
        radioExistNav.setText(CoreUi.I18N.getString("MqlQueryEditor.filterPanel.byType.existpath"));
        radioExistNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(radioExistNav);
        radioExistNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioExistNav.getSelection()) {
                    return;
                }
                ExprKind selected = ExprKind.EXISTS;
                Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        if (expr == null) {
            ExprKind selected = ExprKind.EXISTS;
            Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
            replaceRoot.accept(next);
            rebuild();
        } else {
            radioIsNav.setSelection(expr instanceof IsExpr);
            radioExistNav.setSelection(!(expr instanceof IsExpr));
        }

        renderExprBody(parent, expr, replaceRoot);
    }

    @objid ("260dfa9b-f1da-4fea-b285-445794c87033")
    protected void renderCompositeComparePanel(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        Button radioAndNav = new Button(parent, SWT.RADIO);
        radioAndNav.setText(CoreUi.I18N.getString("MqlQueryEditor.filterPanel.composite.and"));
        radioAndNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(radioAndNav);
        radioAndNav.setSelection(true);
        radioAndNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioAndNav.getSelection()) {
                    return;
                }
                ExprKind selected = ExprKind.AND;
                Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        Button radioOrNav = new Button(parent, SWT.RADIO);
        radioOrNav.setText(CoreUi.I18N.getString("MqlQueryEditor.filterPanel.composite.or"));
        radioOrNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(radioOrNav);
        radioOrNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioOrNav.getSelection()) {
                    return;
                }
                ExprKind selected = ExprKind.OR;
                Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        if (expr == null) {
            ExprKind selected = ExprKind.AND;
            Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
            replaceRoot.accept(next);
            rebuild();
        } else {
            radioAndNav.setSelection(expr instanceof AndExpr);
            radioOrNav.setSelection(!(expr instanceof AndExpr));
        }
        renderExprBody(parent, expr, replaceRoot);
    }

    @objid ("7e5beefb-b775-4b0c-aeac-b4eded2df5d5")
    protected void renderExprEditor(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        Objects.requireNonNull(parent, "parent");

        Composite container = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(container);
        container.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        container.setLayout(new GridLayout(1, false));

        Label typeLabel = new Label(container, SWT.NONE);
        typeLabel.setText(CoreUi.I18N.getString("MqlExpr.type"));

        Combo typeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        List<ExprKind> kinds = ExprKind.kinds();
        for (ExprKind k : kinds) {
            typeCombo.add(k.label);
        }
        PolluxWidgetConfigurator.configureSimpleCompositeField(container, typeLabel, typeCombo, null);

        ExprKind currentKind = ExprKind.fromExpr(expr);
        typeCombo.select(kinds.indexOf(currentKind));

        Composite body = new Composite(container, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(body);
        GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
        gd.horizontalSpan = 2;
        body.setLayoutData(gd);
        body.setLayout(new GridLayout(1, false));

        typeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (AbstractMqlExpressionPanel.this.rebuilding) {
                    return;
                }
                ExprKind selected = kinds.get(typeCombo.getSelectionIndex());
                Expr next = selected.createDefault(AbstractMqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        renderExprBody(body, expr, replaceRoot);
    }

    @objid ("c4520afd-f190-4cd2-8b21-649f081a02bd")
    protected void renderExprBody(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        if (expr instanceof AndExpr and) {
            renderMultiExpr(parent, CoreUi.I18N.getString("MqlExpr.and.title"), and.getExprs(), newChild -> {
                and.addExpr(newChild);
                this.expressionModel.notifyAstMutated();
                rebuild();
            }, index -> {
                and.removeExpr(index);
                this.expressionModel.notifyAstMutated();
                rebuild();
            }, (index, replacement) -> {
                and.getExprs().set(index, replacement);
                this.expressionModel.notifyAstMutated();
                rebuild();
            });
        } else if (expr instanceof OrExpr or) {
            renderMultiExpr(parent, CoreUi.I18N.getString("MqlExpr.or.title"), or.getExprs(), newChild -> {
                or.addExpr(newChild);
                this.expressionModel.notifyAstMutated();
                rebuild();
            }, index -> {
                or.removeExpr(index);
                this.expressionModel.notifyAstMutated();
                rebuild();
            }, (index, replacement) -> {
                or.getExprs().set(index, replacement);
                this.expressionModel.notifyAstMutated();
                rebuild();
            });
        } else if (expr instanceof NotExpr not) {
            Label help = new Label(parent, SWT.WRAP);
            help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            help.setText(CoreUi.I18N.getString("MqlExpr.not.help"));
            renderExprEditor(parent, not.getExpr(), replacement -> {
                not.setExpr(replacement);
                this.expressionModel.notifyAstMutated();
                rebuild();
            });
        } else if (expr instanceof CompareExpr cmp) {
            renderCompareExpr(parent, cmp);
        } else if (expr instanceof IsExpr is) {
            renderIsExpr(parent, is);
        } else if (expr instanceof ExistsExpr exists) {
            renderExistsExpr(parent, exists);
        } else {
            Label unknown = new Label(parent, SWT.WRAP);
            unknown.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            unknown.setText(CoreUi.I18N.getString("MqlExpr.unknown"));

            Button fix = new Button(parent, SWT.PUSH);
            fix.setText(CoreUi.I18N.getString("MqlExpr.replace"));
            fix.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    replaceRoot.accept(MqlExpressionTreeModel.createDefaultExpr(AbstractMqlExpressionPanel.this.rootModel));
                    rebuild();
                }
            });
        }
    }

    @objid ("e1f63270-3472-49cb-9134-0e5cd533e070")
    protected void renderMultiExpr(final Composite parent, final String title, final List<Expr> exprs, final java.util.function.Consumer<Expr> onAdd, final java.util.function.IntConsumer onRemove, final java.util.function.BiConsumer<Integer, Expr> onReplace) {
        Label help = new Label(parent, SWT.WRAP);
        help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        PolluxWidgetConfigurator.configureStyleForSubtitleField(help);
        help.setText(title);

        if (exprs.isEmpty()) {
            Label none = new Label(parent, SWT.WRAP);
            PolluxWidgetConfigurator.configureStyleForFieldLabel(none);
            none.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            none.setText(CoreUi.I18N.getString("MqlExpr.noSubConditions"));
        }

        for (int i = 0; i < exprs.size(); i++) {
            int index = i;
            Group childGroup = new Group(parent, SWT.NONE);
            PolluxWidgetConfigurator.configureContainer(childGroup);
            childGroup.setText(CoreUi.I18N.getMessage("MqlExpr.condition", String.valueOf(i + 1)));
            childGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            childGroup.setLayout(new GridLayout(2, false));

            Composite childEditorHost = new Composite(childGroup, SWT.NONE);
            PolluxWidgetConfigurator.configureContainer(childEditorHost);
            GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
            gd.horizontalSpan = 1;
            childEditorHost.setLayoutData(gd);
            childEditorHost.setLayout(new GridLayout(1, false));

            renderExprEditor(childEditorHost, exprs.get(i), replacement -> onReplace.accept(index, replacement));

            Composite buttons = new Composite(childGroup, SWT.NONE);
            PolluxWidgetConfigurator.configureContainer(buttons);
            buttons.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));
            buttons.setLayout(new GridLayout(1, false));

            Button remove = new Button(buttons, SWT.PUSH);
            remove.setText(CoreUi.I18N.getString("MqlExpr.remove"));
            remove.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
            remove.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    onRemove.accept(index);
                }
            });
        }

        Button add = new Button(parent, SWT.PUSH);
        add.setText(CoreUi.I18N.getString("MqlExpr.addCondition"));
        add.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        add.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                onAdd.accept(MqlExpressionTreeModel.createDefaultExpr(AbstractMqlExpressionPanel.this.rootModel));
            }

        });
    }

    @objid ("50523e55-d84e-4c15-852d-e5838e04f3ef")
    protected void renderCompareExpr(final Composite parent, final CompareExpr cmp) {
        Composite headerComposite = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(headerComposite);
        headerComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        headerComposite.setLayout(new GridLayout(2, false));



        Label edgeLbl = new Label(headerComposite, SWT.NONE);
        edgeLbl.setText(CoreUi.I18N.getString("MqlExpr.propertyType.label"));
        GridData lblGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        edgeLbl.setLayoutData(lblGd);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(edgeLbl);

        Button editPropertyButton = new Button(headerComposite, SWT.PUSH);
        editPropertyButton.setImage(UIImages.EDIT);
        GridData btnGd = new GridData(SWT.CENTER, SWT.BOTTOM, false, false);
        btnGd.widthHint = 30;
        btnGd.verticalSpan = 2;
        editPropertyButton.setLayoutData(btnGd);

        Text propertyDisplayText = new Text(headerComposite, SWT.BORDER | SWT.READ_ONLY | SWT.NO_FOCUS);
        propertyDisplayText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true));
        propertyDisplayText.setBackground(UIColor.SWT_INFO_BACKGROUND);
        propertyDisplayText.setEditable(false);
        propertyDisplayText.setEnabled(false);

        editPropertyButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                MqlPropertyPickerDialog dlg = new MqlPropertyPickerDialog(group.getShell(), session, metamodelhelper);
                if (dlg.open() == IDialogConstants.OK_ID) {
                    if (dlg.getResult() != null) {
                        cmp.setLeft(new PropertyValueExpr(dlg.getResult().label()));
                        propertyDisplayText.setText(dlg.getResult().label());
                    } else {
                        cmp.setLeft(MqlExpressionTreeModel.createDefaultPropertyValueExpr());
                    }
                }
            }
        });


        Label operatorLabel = new Label(headerComposite, SWT.NONE);
        operatorLabel.setText(CoreUi.I18N.getString("MqlExpr.operator"));
        GridData operatorData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        operatorData.horizontalSpan = 2;
        operatorLabel.setLayoutData(operatorData);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(operatorLabel);

        Combo operatorCombo = new Combo(headerComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
        GridData comboData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        comboData.horizontalSpan = 2;
        operatorCombo.setLayoutData(comboData);

        for (String op : new String[] { "=", "contains", "startsWith", "!=", "<", ">", "<=", ">=", }) {
            operatorCombo.add(op);
        }
        operatorCombo.select(0);
        operatorCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                cmp.setOp(operatorCombo.getText());
                AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
            }
        });

        if (cmp.getLeft() != null && cmp.getLeft() instanceof PropertyValueExpr) {
            PropertyValueExpr prop = (PropertyValueExpr) cmp.getLeft();
            propertyDisplayText.setText(prop.getProperty());
        }




        Label valueTypeLabel = new Label(headerComposite, SWT.NONE);
        valueTypeLabel.setText(CoreUi.I18N.getString("MqlExpr.literal.type"));
        GridData valueTypeGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        valueTypeGd.horizontalSpan = 2;
        valueTypeLabel.setLayoutData(valueTypeGd);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(valueTypeLabel);

        Combo typeCombo = new Combo(headerComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
        GridData typeComboGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        typeComboGd.horizontalSpan = 2;
        typeCombo.setLayoutData(typeComboGd);
        typeCombo.setItems(Arrays.stream(ValueType.values()).map(ValueType::getJsonValue).toArray(String[]::new));
        typeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                LiteralValueExpr lit = LiteralValueExpr.ofString("");
                lit.setValueType(ValueType.fromString(typeCombo.getText()));
                lit.setValue(defaultValueForType(lit.getValueType()));
                cmp.setRight(lit);
                AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });



        LiteralValueExpr lit = null;
        if (cmp.getRight() instanceof LiteralValueExpr) {
            lit = (LiteralValueExpr) cmp.getRight();
        } else {
            lit = LiteralValueExpr.ofString("");
            cmp.setRight(lit);
        }

        renderLiteralValueEditor(headerComposite, lit);

        int typeIndex = indexOf(typeCombo.getItems(), lit.getValueType().getJsonValue());
        typeCombo.select(typeIndex >= 0 ? typeIndex : 0);
    }

    @objid ("cc37d1de-07b0-412c-a7dc-0e675c865fcd")
    protected void renderIsExpr(final Composite parent, final IsExpr is) {
        MetaclassSelectorWidget metaclassSelector = new MetaclassSelectorWidget(this.session, selectedType -> {
            if (AbstractMqlExpressionPanel.this.rebuilding) {
                return;
            }

            String qualifiedName = null;
            if (selectedType != null ) {
                if(selectedType instanceof MClass) {
                    qualifiedName = ((MClass)selectedType).getQualifiedName();
                }else if(selectedType instanceof Stereotype) {
                    qualifiedName = ((Stereotype)selectedType).getName();
                }
            }

            if (qualifiedName != null && !qualifiedName.isBlank()) {
                is.setOfQualifiedName(qualifiedName);
                AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
            }
            renderIssues(validateKindRefLocally(qualifiedName));
        });
        metaclassSelector.createControls(parent);

        if (is.getOfQualifiedName() != null) {
            MClass mClass = this.metamodelhelper.getMClassByName(is.getOfQualifiedName());
            if (mClass != null) {
                metaclassSelector.setInput(mClass);
            }
        }

        renderIssues(validateKindRefLocally(is.getOfQualifiedName()));
    }

    @objid ("eb1d4691-c7bb-49aa-97f4-f978c2fbe7da")
    protected void renderExistsExpr(final Composite parent, final ExistsExpr exists) {
        Label help = new Label(parent, SWT.WRAP);
        help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        help.setText(CoreUi.I18N.getString("MqlExpr.exists.help"));
        PolluxWidgetConfigurator.configureStyleForFieldLabel(help);

        List<Step> steps = exists.getIn();
        if (steps == null) {
            steps = new ArrayList<>();
            exists.setIn(steps);
        }

        for (int i = 0; i < steps.size(); i++) {
            Step s = steps.get(i);
            int index = i;

            Composite stepRow = new Composite(parent, SWT.BORDER);
            stepRow.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            PolluxWidgetConfigurator.configureContainer(stepRow);
            stepRow.setLayout(new GridLayout(2, false));

            Label lbl = new Label(stepRow, SWT.NONE);
            lbl.setText(CoreUi.I18N.getMessage("MqlExpr.exists.step", String.valueOf(i + 1)));
            PolluxWidgetConfigurator.configureStyleForFieldLabel(lbl);
            GridData lblData = new GridData(SWT.FILL, SWT.CENTER, true, false);
            lblData.horizontalSpan = 2;
            lbl.setLayoutData(lblData);

            if (s instanceof TraverseStep traverse) {
                Text edgeDisplayText = new Text(stepRow, SWT.BORDER | SWT.READ_ONLY | SWT.NO_FOCUS);
                GridData edgeData = new GridData(SWT.FILL, SWT.CENTER, true, false);
                edgeData.minimumHeight = 30;
                edgeDisplayText.setLayoutData(edgeData);
                edgeDisplayText.setText(nullToEmpty(traverse.getEdge()));
                edgeDisplayText.setBackground(UIColor.SWT_INFO_BACKGROUND);
                edgeDisplayText.setEditable(false);
                edgeDisplayText.setEnabled(false);

                Button editBtn = new Button(stepRow, SWT.PUSH);
                editBtn.setImage(UIImages.EDIT);
                GridData editBtnGd = new GridData(SWT.CENTER, SWT.CENTER, false, false);
                editBtnGd.widthHint = 30;
                editBtnGd.heightHint = 30;
                editBtn.setLayoutData(editBtnGd);
                editBtn.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        MqlDependencyPickerDialog dlg = new MqlDependencyPickerDialog(parent.getShell(), session, metamodelhelper);

                        if (dlg.open() == IDialogConstants.OK_ID) {
                            traverse.setEdge(dlg.getResult());
                            edgeDisplayText.setText(dlg.getResult());
                            AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                        }
                    }
                });
            } else {
                Label unsupported = new Label(stepRow, SWT.WRAP);
                PolluxWidgetConfigurator.configureStyleForFieldLabel(unsupported);
                GridData unsupportedData = new GridData(SWT.FILL, SWT.CENTER, true, false);
                unsupportedData.horizontalSpan = 2;
                unsupported.setLayoutData(unsupportedData);
                unsupported.setText(CoreUi.I18N.getMessage("MqlExpr.exists.unsupported", s.getClass().getSimpleName()));
            }

            Button remove = new Button(stepRow, SWT.PUSH);
            remove.setText(CoreUi.I18N.getString("MqlExpr.remove"));
            GridData removeData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
            removeData.horizontalSpan = 2;
            remove.setLayoutData(removeData);
            PolluxWidgetConfigurator.configureStyleForFieldControl(remove);
            remove.addSelectionListener(new SelectionAdapter() {

                @Override
                public void widgetSelected(SelectionEvent e) {
                    exists.removeStep(index);
                    AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    rebuild();
                }
            });
        }

        Button addTraverse = new Button(parent, SWT.PUSH);
        addTraverse.setText(CoreUi.I18N.getString("MqlExpr.exists.addTraverse"));
        addTraverse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(addTraverse);
        addTraverse.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                exists.addStep(new TraverseStep("Parent"));
                AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });

        Button whereEnabled = new Button(parent, SWT.CHECK);
        PolluxWidgetConfigurator.configureStyleForFieldControl(whereEnabled);
        whereEnabled.setText(CoreUi.I18N.getString("MqlExpr.exists.enableWhere"));
        whereEnabled.setSelection(exists.getWhere() != null);
        whereEnabled.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (whereEnabled.getSelection()) {
                    if (exists.getWhere() == null) {
                        exists.setWhere(MqlExpressionTreeModel.createDefaultExpr(AbstractMqlExpressionPanel.this.rootModel));
                    }
                } else {
                    exists.setWhere(null);
                }
                AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });

        if (exists.getWhere() != null) {
            Composite whereGroup = new Composite(parent, SWT.NONE);
            PolluxWidgetConfigurator.configureContainer(whereGroup);
            whereGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            whereGroup.setLayout(new GridLayout(1, false));
            renderExprEditor(whereGroup, exists.getWhere(), replacement -> {
                exists.setWhere(replacement);
                this.expressionModel.notifyAstMutated();
            });
        }
    }

    @objid ("4af6570a-f871-40ae-a880-c57f84e08eec")
    protected void renderLiteralValueEditor(final Composite parent, final LiteralValueExpr lit) {
        Label valLabel = new Label(parent, SWT.NONE);
        valLabel.setText(CoreUi.I18N.getString("MqlExpr.literal.value"));
        GridData valLabelGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        valLabelGd.horizontalSpan = 2;
        valLabel.setLayoutData(valLabelGd);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(valLabel);

        ValueType valueType = lit.getValueType();
        if (ValueType.BOOL.equals(valueType)) {

            Combo boolCombo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
            GridData boolComboGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
            boolComboGd.horizontalSpan = 2;
            boolCombo.setLayoutData(boolComboGd);

            boolCombo.setItems(new String[] { "false", "true" });

            boolean current = Boolean.TRUE.equals(lit.getValue());
            boolCombo.select(current ? 1 : 0);
            boolCombo.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    lit.setValue(boolCombo.getSelectionIndex() == 1);
                    AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
            });
            return;
        }

        Text valueText = new Text(parent, SWT.BORDER);
        GridData valueTextGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        valueTextGd.horizontalSpan = 2;
        valueText.setLayoutData(valueTextGd);
        PolluxWidgetConfigurator.configureStyleForFieldControl(valueText);

        valueText.setText(lit.getValue() != null ? String.valueOf(lit.getValue()) : "");

        valueText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (AbstractMqlExpressionPanel.this.rebuilding) {
                    return;
                }
                if (ValueType.NUMBER.equals(lit.getValueType())) {
                    String raw = valueText.getText();
                    if (raw == null || raw.isBlank()) {
                        return;
                    }
                    try {
                        if (raw.contains(".")) {
                            lit.setValue(Double.valueOf(raw));
                        } else {
                            lit.setValue(Long.valueOf(raw));
                        }
                        AbstractMqlExpressionPanel.this.issuesLabel.setText("");
                        AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    } catch (NumberFormatException ex) {
                        AbstractMqlExpressionPanel.this.issuesLabel.setText(CoreUi.I18N.getString("MqlExpr.error.numberInvalid"));
                    }
                } else {
                    lit.setValue(valueText.getText());
                    AbstractMqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
            }

        });
    }

    @objid ("661e5034-a0fe-4a4f-8b04-a70e821749a7")
    protected void renderIssues(final List<Diagnostic> issues) {
        if (this.issuesLabel == null || this.issuesLabel.isDisposed()) {
            return;
        }
        if (issues == null || issues.isEmpty()) {
            this.issuesLabel.setText("");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Diagnostic issue : issues) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            if (issue.level() == Level.ERROR) {
                sb.append(CoreUi.I18N.getString("MqlExpr.error.prefix"));
            } else if (issue.level() == Level.WARNING) {
                sb.append(CoreUi.I18N.getString("MqlExpr.warning.prefix"));
            }
            sb.append(issue.message());
        }
        this.issuesLabel.setText(sb.toString());
        this.group.layout(true, true);
    }

    @objid ("faa29213-1b05-4bf9-9963-b22219e1ab80")
    protected static List<Diagnostic> validateKindRefLocally(final String kindRef) {
        if (kindRef == null || kindRef.isBlank()) {
            return List.of(new Diagnostic(DiagnosticCode.RESOLUTION_ERROR, Level.ERROR, CoreUi.I18N.getString("MqlExpr.error.typeEmpty"), null));
        }
        return List.of();
    }

    @objid ("d6b45771-5bd8-4ddd-ac04-b530eca47bc2")
    protected static List<Diagnostic> validatePropertyKeyLocally(final String key) {
        if (key == null || key.isBlank()) {
            return List.of(new Diagnostic(DiagnosticCode.RESOLUTION_ERROR, Level.ERROR, CoreUi.I18N.getString("MqlExpr.error.propertyEmpty"), null));
        }
        return List.of();
    }

    @objid ("15d6cbd7-74be-4eb7-a90f-8793a06b6307")
    protected static void disposeChildren(final Composite parent) {
        if (parent == null || parent.isDisposed()) {
            return;
        }
        for (Control c : parent.getChildren()) {
            c.dispose();
        }
    }

    @objid ("d427c9a9-0f4f-4908-b614-973d4bc7f438")
    protected static int indexOf(final String[] items, final String value) {
        if (items == null || value == null) {
            return -1;
        }
        for (int i = 0; i < items.length; i++) {
            if (value.equals(items[i])) {
                return i;
            }
        }
        return -1;
    }

    @objid ("4958079b-f211-4c68-989f-2569a28fb85b")
    protected static String nullToEmpty(final String s) {
        return s != null ? s : "";
    }

    @objid ("ed6ef96d-37a0-467b-a1c2-36f1c0eb6694")
    protected static Object defaultValueForType(final ValueType valueType) {
        if (ValueType.NUMBER.equals(valueType)) {
            return Long.valueOf(0);
        }
        if (ValueType.BOOL.equals(valueType)) {
            return Boolean.FALSE;
        }
        return "";
    }

    // ─── Enums ───────────────────────────────────────────────────────────────
    @objid ("17b496b8-0323-4f70-95c3-cd5a39477061")
    protected enum ExprKind {
        @objid ("b455f891-e1aa-4c89-a07b-50165c70817e")
        AND(CoreUi.I18N.getString("MqlExpr.kind.and")),
        @objid ("81eb997c-9dc0-499a-8618-7847494a0638")
        OR(CoreUi.I18N.getString("MqlExpr.kind.or")),
        @objid ("95224bd2-f60b-4447-818d-b66e9b63767f")
        NOT(CoreUi.I18N.getString("MqlExpr.kind.not")),
        @objid ("84b8bb69-ae58-4d8e-b564-212857b94ac8")
        COMPARE(CoreUi.I18N.getString("MqlExpr.kind.compare")),
        @objid ("0723bb25-5796-4ad4-8486-cde246c34b39")
        IS(CoreUi.I18N.getString("MqlExpr.kind.is")),
        @objid ("5d42cbf7-b1a8-4130-a706-068a0bdf624a")
        EXISTS(CoreUi.I18N.getString("MqlExpr.kind.exists"));

        @objid ("532d7b35-1d11-43a3-af1c-9e5f8e1a9ed0")
        private final String label;

        @objid ("24f17d84-4891-4740-bfeb-e8ffd39571fc")
        ExprKind(final String label) {
            this.label = label;
        }

        @objid ("a815f301-a8aa-45eb-ae69-bc0609aecfb7")
        static List<ExprKind> kinds() {
            return List.of(values());
        }

        @objid ("625b5560-174c-45cc-b813-4cdb9bcd6ef5")
        static ExprKind fromExpr(final Expr expr) {
            if (expr instanceof AndExpr)
                return AND;
            if (expr instanceof OrExpr)
                return OR;
            if (expr instanceof NotExpr)
                return NOT;
            if (expr instanceof CompareExpr)
                return COMPARE;
            if (expr instanceof IsExpr)
                return IS;
            if (expr instanceof ExistsExpr)
                return EXISTS;
            return IS;
        }

        @objid ("fe360967-e04d-4b8f-94d6-1cd96539d4a7")
        Expr createDefault(final MqlQueryModel rootModel) {
            return switch (this) {
            case AND -> MqlExpressionTreeModel.createDefaultAndExpr(rootModel);
            case OR -> MqlExpressionTreeModel.createDefaultOrExpr(rootModel);
            case NOT -> MqlExpressionTreeModel.createDefaultNotExpr(rootModel);
            case COMPARE -> MqlExpressionTreeModel.createDefaultCompareExpr();
            case IS -> MqlExpressionTreeModel.createDefaultIsExpr(rootModel);
            case EXISTS -> MqlExpressionTreeModel.createDefaultExistsExpr();
            };
        }

    }

    @objid ("300f9534-63f6-4830-b167-b0fbb924c95e")
    protected enum ValueKind {
        @objid ("2222965e-11d9-42b6-a054-7872bfb9f602")
        PROPERTY,
        @objid ("f154240c-3910-4d35-9017-74e99f6e7100")
        LITERAL;

        @objid ("bd74c682-75ef-4064-8063-3eff3b8dde70")
        static ValueKind fromValueExpr(final ValueExpr expr) {
            if (expr instanceof LiteralValueExpr) {
                return LITERAL;
            }
            return PROPERTY;
        }

    }

}
