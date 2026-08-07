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
package org.modelio.platform.model.ui.panels.search.query.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
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
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlExpressionTreeModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.CompareExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
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
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * SWT UI component that edits {@link Expr} trees for filter and traverse steps.
 * <p>
 * This intentionally avoids JSON and uses friendly labels.
 */
@objid ("82c90c3b-8659-4a09-a054-6acfe4c1e689")
public final class MqlExpressionPanel {
    @objid ("0a7d64e0-e60f-46de-ae33-d6dd304cd52e")
    private boolean rebuilding;

    /**
     * Full sorted list of metaclass qualified names, used for the "Is type" combo.
     */
    @objid ("18e47533-e973-429e-8eaf-5090b3041a36")
    private final List<String> allMetaclassNames;

    @objid ("fcc37efc-ffc0-43e5-89f4-23868798cdf8")
    private Group group;

    @objid ("3759a9e3-f25a-456c-85e6-165ad2582949")
    private Label contextLabel;

    @objid ("db1aa527-512d-4064-b916-81f8e14d0175")
    private Label issuesLabel;

    @objid ("0ff2ffa9-ef44-4cd6-a649-6aa011ef1772")
    private Composite editorArea;

    @objid ("a98db55e-0f87-45ce-9867-a6e8d6e6f1df")
    private final MqlQueryModel rootModel;

    @objid ("675c396a-d8d4-42e8-bc7d-f5e54b4da723")
    private final MqlValidationService validation;

    @objid ("74ece749-61b7-4025-9e10-e6272e46d0a6")
    private final ICoreSession session;

    @objid ("3c5c9fa6-3554-48a3-a252-176d95faecd0")
    private MqlExpressionTreeModel expressionModel;

    /**
     * Called after every {@link #rebuild()} so the host can update its ScrolledComposite minSize.
     */
    @objid ("bf9a022d-b96c-4513-8c7c-a3562b0d7ef2")
    private Runnable onLayoutChanged;

    @objid ("b05d6dc1-2e4a-4c51-8a9a-1a533712a309")
    public MqlExpressionPanel(final MqlQueryModel rootModel, final MqlValidationService validation, final ICoreSession session) {
        this.rootModel = Objects.requireNonNull(rootModel, "rootModel");
        this.validation = Objects.requireNonNull(validation, "validation");
        this.session = Objects.requireNonNull(session, "session");
        this.allMetaclassNames = this.session.getMetamodel().getRegisteredMClasses()
                .stream()
                .map(MClass::getQualifiedName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Sets a callback invoked (via asyncExec) after every content rebuild.
     * Use this to update a parent {@code ScrolledComposite}'s minSize.
     */
    @objid ("19cf51ec-448e-4b48-bf1b-e948cca52d0f")
    public void setOnLayoutChanged(final Runnable callback) {
        this.onLayoutChanged = callback;
    }

    @objid ("af5b47b2-f9d0-47b7-bb05-a00ca34d6b6e")
    public Composite createControls(final Composite parent) {
        this.group = new Group(parent, SWT.NONE);
        this.group.setText(CoreUi.I18N.getString("MqlExpr.group"));
        GridData groupGd = new GridData(SWT.FILL, SWT.TOP, true, false);
        groupGd.exclude = true;
        this.group.setLayoutData(groupGd);
        this.group.setVisible(false);
        this.group.setLayout(new GridLayout(1, false));

        this.contextLabel = new Label(this.group, SWT.WRAP);
        this.contextLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        this.issuesLabel = new Label(this.group, SWT.WRAP);
        this.issuesLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        this.editorArea = new Composite(this.group, SWT.NONE);
        this.editorArea.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        this.editorArea.setLayout(new GridLayout(1, false));

        // Don't call setSelectedStep(null) here — start hidden
        return this.group;
    }

    @objid ("48d54456-4247-448c-b835-a71e12c56233")
    public Control getControl() {
        return this.group;
    }

    @objid ("aed5a4b2-dfd3-486c-a4c6-872984199de3")
    public void setSelectedStep(final MqlStepNode stepNode) {
        if (this.group == null || this.group.isDisposed()) {
            return;
        }

        boolean relevant = stepNode != null && (stepNode.isFilter() || stepNode.isTraverse());

        if (stepNode == null || !relevant) {
            this.expressionModel = null;
        } else if (stepNode.isFilter()) {
            this.expressionModel = new MqlExpressionTreeModel(this.rootModel, stepNode, MqlExpressionTreeModel.Target.FILTER_WHERE);
        } else if (stepNode.isTraverse()) {
            this.expressionModel = new MqlExpressionTreeModel(this.rootModel, stepNode, MqlExpressionTreeModel.Target.TRAVERSE_EDGE_FILTER);
        } else {
            this.expressionModel = null;
        }

        // Show/hide via GridData.exclude
        this.group.setVisible(relevant);
        ((GridData) this.group.getLayoutData()).exclude = !relevant;
        this.group.getParent().layout(true, true);

        if (relevant) {
            rebuild();
        }
    }

    @objid ("4f2fa787-765f-4025-ab08-a0d901d066bd")
    private void rebuild() {
        if (this.rebuilding) {
            return;
        }

        this.rebuilding = true;
        try {
            disposeChildren(this.editorArea);
            this.issuesLabel.setText("");

            if (this.expressionModel == null) {
                this.contextLabel.setText("");
                this.editorArea.layout(true, true);
                this.group.layout(true, true);
                return; // finally block still fires onLayoutChanged
            }

            if (this.expressionModel.getTarget() == MqlExpressionTreeModel.Target.FILTER_WHERE) {
                this.contextLabel.setText(CoreUi.I18N.getString("MqlExpr.context.filter"));
                renderExprEditor(this.editorArea, this.expressionModel.getExpr(), this.expressionModel::setExpr);
            } else {
                this.contextLabel.setText(CoreUi.I18N.getString("MqlExpr.context.traverse"));

                final Button enabled = new Button(this.editorArea, SWT.CHECK);
                enabled.setText(CoreUi.I18N.getString("MqlExpr.enableEdgeCondition"));
                enabled.setSelection(this.expressionModel.getExpr() != null);
                enabled.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        if (MqlExpressionPanel.this.rebuilding) {
                            return;
                        }
                        if (enabled.getSelection()) {
                            if (MqlExpressionPanel.this.expressionModel.getExpr() == null) {
                                MqlExpressionPanel.this.expressionModel.setExpr(MqlExpressionTreeModel.createDefaultExpr(MqlExpressionPanel.this.rootModel));
                            }
                        } else {
                            MqlExpressionPanel.this.expressionModel.setExpr(null);
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
            }

            this.editorArea.layout(true, true);
            this.group.layout(true, true);
        } finally {
            this.rebuilding = false;
            // Notify host (e.g. MqlQueryEditorDialog) to recompute ScrolledComposite minSize
            if (this.onLayoutChanged != null && this.group != null && !this.group.isDisposed()) {
                this.group.getDisplay().asyncExec(this.onLayoutChanged);
            }
        }
    }

    @objid ("c0afb4e6-a50e-4022-8fe5-aa546d24ba9f")
    private void renderExprEditor(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
        Objects.requireNonNull(parent, "parent");

        Composite container = new Composite(parent, SWT.BORDER);
        container.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        container.setLayout(new GridLayout(2, false));

        Label typeLabel = new Label(container, SWT.NONE);
        typeLabel.setText(CoreUi.I18N.getString("MqlExpr.type"));

        Combo typeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        List<ExprKind> kinds = ExprKind.kinds();
        for (ExprKind k : kinds) {
            typeCombo.add(k.label);
        }

        ExprKind currentKind = ExprKind.fromExpr(expr);
        typeCombo.select(kinds.indexOf(currentKind));

        Composite body = new Composite(container, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
        gd.horizontalSpan = 2;
        body.setLayoutData(gd);
        body.setLayout(new GridLayout(1, false));

        typeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MqlExpressionPanel.this.rebuilding) {
                    return;
                }

                ExprKind selected = kinds.get(typeCombo.getSelectionIndex());
                Expr next = selected.createDefault(MqlExpressionPanel.this.rootModel);
                replaceRoot.accept(next);
                rebuild();
            }
        });

        renderExprBody(body, expr, replaceRoot);
    }

    @objid ("e7358963-900e-4cbf-955e-143ae1f6fde1")
    private void renderExprBody(final Composite parent, final Expr expr, final java.util.function.Consumer<Expr> replaceRoot) {
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
            // Unknown expression type - replace with default.
            Label unknown = new Label(parent, SWT.WRAP);
            unknown.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            unknown.setText(CoreUi.I18N.getString("MqlExpr.unknown"));

            Button fix = new Button(parent, SWT.PUSH);
            fix.setText(CoreUi.I18N.getString("MqlExpr.replace"));
            fix.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    replaceRoot.accept(MqlExpressionTreeModel.createDefaultExpr(MqlExpressionPanel.this.rootModel));
                    rebuild();
                }
            });
        }
    }

    @objid ("ebdc9197-8199-4a59-9db7-12d8bc77f5ee")
    private void renderMultiExpr(final Composite parent, final String title, final List<Expr> exprs, final java.util.function.Consumer<Expr> onAdd, final java.util.function.IntConsumer onRemove, final java.util.function.BiConsumer<Integer, Expr> onReplace) {
        Label help = new Label(parent, SWT.WRAP);
        help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        help.setText(title);

        if (exprs.isEmpty()) {
            Label none = new Label(parent, SWT.WRAP);
            none.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            none.setText(CoreUi.I18N.getString("MqlExpr.noSubConditions"));
        }

        for (int i = 0; i < exprs.size(); i++) {
            int index = i;
            Group childGroup = new Group(parent, SWT.NONE);
            childGroup.setText(CoreUi.I18N.getMessage("MqlExpr.condition", String.valueOf(i + 1)));
            childGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            childGroup.setLayout(new GridLayout(2, false));

            Composite childEditorHost = new Composite(childGroup, SWT.NONE);
            GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
            gd.horizontalSpan = 1;
            childEditorHost.setLayoutData(gd);
            childEditorHost.setLayout(new GridLayout(1, false));

            renderExprEditor(childEditorHost, exprs.get(i), replacement -> onReplace.accept(index, replacement));

            Composite buttons = new Composite(childGroup, SWT.NONE);
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
                onAdd.accept(MqlExpressionTreeModel.createDefaultExpr(MqlExpressionPanel.this.rootModel));
            }
        });
    }

    @objid ("e5687264-ef6b-43ea-8872-41cc255b1f3c")
    private void renderCompareExpr(final Composite parent, final CompareExpr cmp) {
        Composite row = new Composite(parent, SWT.NONE);
        row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        row.setLayout(new GridLayout(2, false));

        new Label(row, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.operator"));
        Combo opCombo = new Combo(row, SWT.DROP_DOWN | SWT.READ_ONLY);
        opCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        String[] ops = new String[] { "=", "!=", "<", ">", "<=", ">=", "contains", "startsWith" };
        for (String op : ops) {
            opCombo.add(op);
        }
        opCombo.select(indexOf(ops, cmp.getOp()));

        opCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                cmp.setOp(opCombo.getText());
                MqlExpressionPanel.this.expressionModel.notifyAstMutated();
            }
        });

        Group left = new Group(parent, SWT.NONE);
        left.setText(CoreUi.I18N.getString("MqlExpr.left"));
        left.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        left.setLayout(new GridLayout(1, false));
        renderValueExprEditor(left, cmp.getLeft(), replacement -> {
            cmp.setLeft(replacement);
            this.expressionModel.notifyAstMutated();
        });

        Group right = new Group(parent, SWT.NONE);
        right.setText(CoreUi.I18N.getString("MqlExpr.right"));
        right.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        right.setLayout(new GridLayout(1, false));
        renderValueExprEditor(right, cmp.getRight(), replacement -> {
            cmp.setRight(replacement);
            this.expressionModel.notifyAstMutated();
        });
    }

    @objid ("12231976-23ab-4a7a-834f-584cbb1ccba0")
    private void renderIsExpr(final Composite parent, final IsExpr is) {
        Composite row = new Composite(parent, SWT.NONE);
        row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        row.setLayout(new GridLayout(2, false));

        new Label(row, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.isType.label"));
        Combo kindCombo = new Combo(row, SWT.DROP_DOWN);
        kindCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        kindCombo.setItems(this.allMetaclassNames.toArray(new String[0]));
        kindCombo.setText(nullToEmpty(is.getOfQualifiedName()));

        // Update the model when the user types a metaclass name directly.
        // NOTE: never call setItems() inside a ModifyListener – on Windows SWT it resets
        // the cursor to position 0 on every keystroke, causing reversed text and combo
        // state corruption on reopen.  The full item list is set once at construction;
        // the native combo provides type-ahead matching, matching the Advanced Search panel.
        kindCombo.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (MqlExpressionPanel.this.rebuilding) {
                    return;
                }
                String typed = kindCombo.getText();
                if (typed != null && !typed.isBlank()) {
                    is.setOfQualifiedName(typed);
                    MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
                renderIssues(validateKindRefLocally(typed));
            }
        });

        // Update the model when the user picks an item from the dropdown.
        kindCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MqlExpressionPanel.this.rebuilding) {
                    return;
                }
                String selected = kindCombo.getText();
                if (selected != null && !selected.isBlank()) {
                    is.setOfQualifiedName(selected);
                    MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
                renderIssues(validateKindRefLocally(selected));
            }
        });

        renderIssues(validateKindRefLocally(is.getOfQualifiedName()));

        Label hint = new Label(parent, SWT.WRAP);
        hint.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        hint.setText(CoreUi.I18N.getString("MqlExpr.isType.hint"));
    }

    @objid ("15c2c02b-89d1-4d69-93af-9f364257e833")
    private void renderExistsExpr(final Composite parent, final ExistsExpr exists) {
        Label help = new Label(parent, SWT.WRAP);
        help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        help.setText(CoreUi.I18N.getString("MqlExpr.exists.help"));

        Group stepsGroup = new Group(parent, SWT.NONE);
        stepsGroup.setText(CoreUi.I18N.getString("MqlExpr.exists.pathSteps"));
        stepsGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        stepsGroup.setLayout(new GridLayout(1, false));

        List<Step> steps = exists.getIn();
        if (steps == null) {
            steps = new ArrayList<>();
            exists.setIn(steps);
        }

        for (int i = 0; i < steps.size(); i++) {
            Step s = steps.get(i);
            int index = i;

            Composite stepRow = new Composite(stepsGroup, SWT.BORDER);
            stepRow.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            stepRow.setLayout(new GridLayout(4, false));

            Label lbl = new Label(stepRow, SWT.NONE);
            lbl.setText(CoreUi.I18N.getMessage("MqlExpr.exists.step", String.valueOf(i + 1)));

            if (s instanceof TraverseStep traverse) {
                Text edgeText = new Text(stepRow, SWT.BORDER);
                edgeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
                edgeText.setText(nullToEmpty(traverse.getEdge()));
                edgeText.setMessage(CoreUi.I18N.getString("MqlExpr.exists.edgeHint"));

                Combo dirCombo = new Combo(stepRow, SWT.DROP_DOWN | SWT.READ_ONLY);
                dirCombo.setItems(new String[] { CoreUi.I18N.getString("MqlTraverse.direction.forward"), CoreUi.I18N.getString("MqlTraverse.direction.backward") });
                dirCombo.select(traverse.getDirection() == Direction.BACKWARD ? 1 : 0);

                edgeText.addModifyListener(new ModifyListener() {
                    @Override
                    public void modifyText(ModifyEvent e) {
                        String v = edgeText.getText();
                        if (v == null || v.isBlank()) {
                            return;
                        }
                        traverse.setEdge(v);
                        MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    }
                });
                dirCombo.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        traverse.setDirection(dirCombo.getSelectionIndex() == 1 ? Direction.BACKWARD : Direction.FORWARD);
                        MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    }
                });
            } else {
                Label unsupported = new Label(stepRow, SWT.WRAP);
                unsupported.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
                unsupported.setText(CoreUi.I18N.getMessage("MqlExpr.exists.unsupported", s.getClass().getSimpleName()));

                new Label(stepRow, SWT.NONE);
            }

            Button remove = new Button(stepRow, SWT.PUSH);
            remove.setText(CoreUi.I18N.getString("MqlExpr.remove"));
            remove.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
            remove.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    exists.removeStep(index);
                    MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    rebuild();
                }
            });
        }

        Button addTraverse = new Button(stepsGroup, SWT.PUSH);
        addTraverse.setText(CoreUi.I18N.getString("MqlExpr.exists.addTraverse"));
        addTraverse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        addTraverse.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                exists.addStep(new TraverseStep("Parent"));
                MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });

        Button whereEnabled = new Button(parent, SWT.CHECK);
        whereEnabled.setText(CoreUi.I18N.getString("MqlExpr.exists.enableWhere"));
        whereEnabled.setSelection(exists.getWhere() != null);
        whereEnabled.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (whereEnabled.getSelection()) {
                    if (exists.getWhere() == null) {
                        exists.setWhere(MqlExpressionTreeModel.createDefaultExpr(MqlExpressionPanel.this.rootModel));
                    }
                } else {
                    exists.setWhere(null);
                }
                MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });

        if (exists.getWhere() != null) {
            Group whereGroup = new Group(parent, SWT.NONE);
            whereGroup.setText(CoreUi.I18N.getString("MqlExpr.exists.where"));
            whereGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            whereGroup.setLayout(new GridLayout(1, false));
            renderExprEditor(whereGroup, exists.getWhere(), replacement -> {
                exists.setWhere(replacement);
                this.expressionModel.notifyAstMutated();
            });
        }
    }

    @objid ("14db6d51-4786-411a-8c61-2da76fb65895")
    private void renderValueExprEditor(final Composite parent, final ValueExpr valueExpr, final java.util.function.Consumer<ValueExpr> replace) {
        Composite row = new Composite(parent, SWT.NONE);
        row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        row.setLayout(new GridLayout(2, false));

        new Label(row, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.valueKind"));

        Combo kindCombo = new Combo(row, SWT.DROP_DOWN | SWT.READ_ONLY);
        kindCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        kindCombo.setItems(new String[] { CoreUi.I18N.getString("MqlExpr.valueKind.property"), CoreUi.I18N.getString("MqlExpr.valueKind.literal") });

        ValueKind current = ValueKind.fromValueExpr(valueExpr);
        kindCombo.select(current == ValueKind.LITERAL ? 1 : 0);

        Composite body = new Composite(row, SWT.NONE);
        GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
        gd.horizontalSpan = 2;
        body.setLayoutData(gd);
        body.setLayout(new GridLayout(1, false));

        kindCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MqlExpressionPanel.this.rebuilding) {
                    return;
                }
                if (kindCombo.getSelectionIndex() == 1) {
                    replace.accept(MqlExpressionTreeModel.createDefaultLiteralValueExpr());
                } else {
                    replace.accept(MqlExpressionTreeModel.createDefaultPropertyValueExpr());
                }
                rebuild();
            }
        });

        if (valueExpr instanceof PropertyValueExpr prop) {
            renderPropertyValueExpr(body, prop);
        } else if (valueExpr instanceof LiteralValueExpr lit) {
            renderLiteralValueExpr(body, lit);
        }
    }

    @objid ("8fa8a7da-4e6f-4f12-ae30-e88f4ad4e483")
    private void renderPropertyValueExpr(final Composite parent, final PropertyValueExpr prop) {
        Composite row = new Composite(parent, SWT.NONE);
        row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        row.setLayout(new GridLayout(2, false));

        new Label(row, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.property.label"));
        Text keyText = new Text(row, SWT.BORDER);
        keyText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        keyText.setText(nullToEmpty(prop.getProperty()));
        keyText.setMessage(CoreUi.I18N.getString("MqlExpr.property.hint"));

        keyText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                String value = keyText.getText();
                if (value == null || value.isBlank()) {
                    return;
                }
                prop.setProperty(value);
                MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                renderIssues(validatePropertyKeyLocally(value));
            }
        });

        renderIssues(validatePropertyKeyLocally(prop.getProperty()));
    }

    @objid ("8f49f320-7828-4a45-81f0-67b12af5653f")
    private void renderLiteralValueExpr(final Composite parent, final LiteralValueExpr lit) {
        Composite row = new Composite(parent, SWT.NONE);
        row.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        row.setLayout(new GridLayout(2, false));

        new Label(row, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.literal.type"));
        Combo typeCombo = new Combo(row, SWT.DROP_DOWN | SWT.READ_ONLY);
        typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        typeCombo.setItems(Arrays.stream(ValueType.values()).map(ValueType::getJsonValue).toArray(String[]::new));

        int typeIndex = indexOf(typeCombo.getItems(), lit.getValueType().getJsonValue());
        typeCombo.select(typeIndex >= 0 ? typeIndex : 0);

        Composite valueHost = new Composite(parent, SWT.NONE);
        valueHost.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        valueHost.setLayout(new GridLayout(2, false));

        renderLiteralValueEditor(valueHost, lit);

        typeCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                lit.setValueType(ValueType.fromString(typeCombo.getText()));
                lit.setValue(defaultValueForType(lit.getValueType()));
                MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                rebuild();
            }
        });
    }

    @objid ("cdc391b7-4415-4ec0-aa3e-723f68a9bf92")
    private void renderLiteralValueEditor(final Composite parent, final LiteralValueExpr lit) {
        new Label(parent, SWT.NONE).setText(CoreUi.I18N.getString("MqlExpr.literal.value"));

        ValueType valueType = lit.getValueType();
        if (ValueType.BOOL.equals(valueType)) {
            Combo boolCombo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
            boolCombo.setItems(new String[] { "false", "true" });
            boolean current = Boolean.TRUE.equals(lit.getValue());
            boolCombo.select(current ? 1 : 0);
            boolCombo.addSelectionListener(new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    lit.setValue(boolCombo.getSelectionIndex() == 1);
                    MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
            });
            return;
        }

        Text valueText = new Text(parent, SWT.BORDER);
        valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        valueText.setText(lit.getValue() != null ? String.valueOf(lit.getValue()) : "");

        valueText.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                if (MqlExpressionPanel.this.rebuilding) {
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
                        MqlExpressionPanel.this.issuesLabel.setText("");
                        MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                    } catch (NumberFormatException ex) {
                        MqlExpressionPanel.this.issuesLabel.setText(CoreUi.I18N.getString("MqlExpr.error.numberInvalid"));
                    }
                } else {
                    lit.setValue(valueText.getText());
                    MqlExpressionPanel.this.expressionModel.notifyAstMutated();
                }
            }
        });
    }

    @objid ("8f9ed916-8998-42ab-b633-9a3f4c04b825")
    private void renderIssues(final List<Diagnostic> issues) {
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

    /**
     * Local blank-check for kind reference tokens (immediate SWT feedback).
     * Deep validation is performed by the resolver and shown on the GEF canvas.
     */
    @objid ("35b59ce9-fd41-4055-8f0d-09a00cbeb3f0")
    private static List<Diagnostic> validateKindRefLocally(String kindRef) {
        if (kindRef == null || kindRef.isBlank()) {
            return List.of(new Diagnostic(DiagnosticCode.RESOLUTION_ERROR, Level.ERROR, CoreUi.I18N.getString("MqlExpr.error.typeEmpty"), null));
        }
        return List.of();
    }

    /**
     * Local blank-check for property key tokens (immediate SWT feedback).
     * Deep validation is performed by the resolver and shown on the GEF canvas.
     */
    @objid ("fc79021f-6649-4290-8385-87d468f55eb9")
    private static List<Diagnostic> validatePropertyKeyLocally(String key) {
        if (key == null || key.isBlank()) {
            return List.of(new Diagnostic(DiagnosticCode.RESOLUTION_ERROR, Level.ERROR, CoreUi.I18N.getString("MqlExpr.error.propertyEmpty"), null));
        }
        return List.of();
    }

    @objid ("610ab7ac-9bc7-4660-9e1f-0dc593a6ae9d")
    private static void disposeChildren(final Composite parent) {
        if (parent == null || parent.isDisposed()) {
            return;
        }
        for (org.eclipse.swt.widgets.Control c : parent.getChildren()) {
            c.dispose();
        }
    }

    @objid ("7e7953d8-5e48-4b4d-94e2-07f1bb8d5968")
    private static int indexOf(final String[] items, final String value) {
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

    @objid ("d5187e1e-559e-4fbe-85bc-d7862f1fd527")
    private static String nullToEmpty(final String s) {
        return s != null ? s : "";
    }

    @objid ("f85af71d-c015-449e-b4e7-ae64856a3f47")
    private static Object defaultValueForType(final ValueType valueType) {
        if (ValueType.NUMBER.equals(valueType)) {
            return Long.valueOf(0);
        }
        if (ValueType.BOOL.equals(valueType)) {
            return Boolean.FALSE;
        }
        return "";
    }

    @objid ("8405a5fa-28a4-4e33-b57b-61e8c4abe386")
    private enum ExprKind {
        @objid ("72f3273a-ca49-469e-abc4-2e85e25b36e1")
        AND(CoreUi.I18N.getString("MqlExpr.kind.and")),
        @objid ("8f2bbfc1-7ba9-475b-b3c6-6573526d403d")
        OR(CoreUi.I18N.getString("MqlExpr.kind.or")),
        @objid ("148d5b77-bbfe-40e7-925d-462a7a9fef0e")
        NOT(CoreUi.I18N.getString("MqlExpr.kind.not")),
        @objid ("c717bbbe-37ee-42cd-b64d-08630b0f804f")
        COMPARE(CoreUi.I18N.getString("MqlExpr.kind.compare")),
        @objid ("c4d7c22a-963a-4779-8421-45ec8dc1e87a")
        IS(CoreUi.I18N.getString("MqlExpr.kind.is")),
        @objid ("b7ba0417-767e-4d15-98a5-97a72b0fa0e9")
        EXISTS(CoreUi.I18N.getString("MqlExpr.kind.exists"));

        @objid ("2432df83-4c72-4297-a5e7-9af0fe1b1265")
        private final String label;

        @objid ("8b053a99-c43a-4e48-a90d-a5bad9db15a6")
        ExprKind(final String label) {
            this.label = label;
        }

        @objid ("c3eb4ab5-8ba9-41cd-be8f-86e7aa33cc4b")
        static List<ExprKind> kinds() {
            return List.of(values());
        }

        @objid ("dd485d5a-85a3-4a40-a229-c40396a111b2")
        static ExprKind fromExpr(final Expr expr) {
            if (expr instanceof AndExpr) {
                return AND;
            }
            if (expr instanceof OrExpr) {
                return OR;
            }
            if (expr instanceof NotExpr) {
                return NOT;
            }
            if (expr instanceof CompareExpr) {
                return COMPARE;
            }
            if (expr instanceof IsExpr) {
                return IS;
            }
            if (expr instanceof ExistsExpr) {
                return EXISTS;
            }
            return IS;
        }

        @objid ("24d44ebd-4be7-435e-ad0e-2551b7dea7ad")
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

    @objid ("012c7716-a35d-4805-b35d-f925cd7d6967")
    private enum ValueKind {
        @objid ("858e007d-a2d7-4bb5-9353-d407d409a661")
        PROPERTY,
        @objid ("d8bb234b-7c2b-4901-a47e-e669b2d69d22")
        LITERAL;

        @objid ("34666a42-e844-49b9-99af-9e67e176cffc")
        static ValueKind fromValueExpr(final ValueExpr expr) {
            if (expr instanceof LiteralValueExpr) {
                return LITERAL;
            }
            return PROPERTY;
        }

    }

}
