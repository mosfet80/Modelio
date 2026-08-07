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
package org.modelio.platform.model.ui.panels.search.query.elements.addstep;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.modelio.platform.model.ui.panels.search.query.commands.MqlStepCommands;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.AndExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Expr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.FilterStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.IsExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.NotExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.OrExpr;
import org.modelio.platform.search.engine.searchers.query.api.model.query.RepeatStep;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Step;
import org.modelio.platform.ui.UIImages;

/**
 * UI section for editing the ordered pipeline steps.
 * <p>
 * Steps are shown as horizontal cards. A popup "+" button adds a new step
 * (Filter / Traverse / Union / Repeat). Each card has a "✕" delete button.
 */
@objid ("a0031a16-eb49-490d-9baf-df713195e307")
public final class MqlStepsPanel {
    /**
     * Index of the currently highlighted card (–1 = none).
     */
    @objid ("08c0fa91-6f47-4814-ac8d-fdf61b292087")
    private int selectedIndex = -1;

    /**
     * Horizontal bar containing one Composite per step + the "+" button.
     */
    @objid ("49c07b1b-0faa-4873-9724-12aa03ae2086")
    private Composite cardsBar;

    @objid ("e181dc3c-f02b-4a67-b880-f2a54cb176bc")
    private ScrolledComposite scrolled;

    @objid ("48daad22-ea8d-4e9d-b55a-f28fa20ef81e")
    private Group group;

    @objid ("c3cfd375-3bf7-4850-9686-a8e1d2b70c3c")
    private final MqlQueryModel model;

    @objid ("1e2544c0-e547-45f4-be51-500015a32861")
    private final Consumer<MqlStepNode> onSelectionChanged;

    @objid ("149880e1-40ff-4a76-8d10-e628f9f8710f")
    private PropertyChangeListener listener;

    @objid ("8ec1deda-819a-4cb0-9ba2-bd9313ef860e")
    public MqlStepsPanel(final MqlQueryModel model, final Consumer<MqlStepNode> onSelectionChanged) {
        this.model = Objects.requireNonNull(model, "model");
        this.onSelectionChanged = onSelectionChanged;
    }

    @objid ("35267699-7e47-4072-b388-7f80a755860c")
    public Composite createControls(final Composite parent) {
        this.group = new Group(parent, SWT.NONE);
        this.group.setText(CoreUi.I18N.getString("MqlStepsPanel.group.label"));
        this.group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        this.group.setLayout(new GridLayout(1, false));

        // ── Delete selected step button ───────────────────────────────────
        Button deleteBtn = new Button(this.group, SWT.PUSH);
        deleteBtn.setImage(UIImages.DELETE);
        deleteBtn.setToolTipText(CoreUi.I18N.getString("MqlStepsPanel.deleteStep.tooltip"));
        deleteBtn.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));
        deleteBtn.addListener(SWT.Selection, e -> {
            if (this.selectedIndex >= 0) {
                onDelete(this.selectedIndex);
            }
        });

        Label help = new Label(this.group, SWT.WRAP);
        help.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        help.setText(CoreUi.I18N.getString("MqlStepsPanel.help"));

        // Horizontal scrollable strip
        this.scrolled = new ScrolledComposite(this.group, SWT.H_SCROLL | SWT.BORDER);
        this.scrolled.setExpandHorizontal(true);
        this.scrolled.setExpandVertical(true);
        GridData sgd = new GridData(SWT.FILL, SWT.TOP, true, false);
        sgd.heightHint = 100;
        this.scrolled.setLayoutData(sgd);

        this.cardsBar = new Composite(this.scrolled, SWT.NONE);
        RowLayout rl = new RowLayout(SWT.HORIZONTAL);
        rl.spacing = 6;
        rl.marginTop = 6;
        rl.marginBottom = 6;
        rl.marginLeft = 6;
        rl.marginRight = 6;
        rl.wrap = false;
        this.cardsBar.setLayout(rl);
        this.scrolled.setContent(this.cardsBar);

        hookModelListener(this.group);
        rebuildCards(false);
        return this.group;
    }

    @objid ("a3b9c190-3008-4892-93cf-1db5050a7a55")
    public Control getControl() {
        return this.group;
    }

    /**
     * Programmatically highlight the card corresponding to {@code topLevelStep}.
     * Does NOT fire {@link #notifySelection()}.
     */
    @objid ("5e109150-b5ac-4dbb-8939-5db1b97cf074")
    public void setHighlightedTopLevelStep(final MqlStepNode topLevelStep) {
        if (topLevelStep == null) {
            this.selectedIndex = -1;
        } else {
            this.selectedIndex = this.model.getStepNodes().indexOf(topLevelStep);
        }
        updateCardSelectionState();
    }

    // ── Private helpers ───────────────────────────────────────────────────────
    /*  private void rebuildCards() {
          if (this.cardsBar == null || this.cardsBar.isDisposed()) return;

          for (Control child : this.cardsBar.getChildren()) {
              child.dispose();
          }

          List<MqlStepNode> steps = this.model.getStepNodes();
          for (int i = 0; i < steps.size(); i++) {
              createStepCard(steps.get(i), i);
          }
          // No add-button here: use the "+ Add step" button inside the Pipeline canvas group.
          this.cardsBar.layout(true);
          this.scrolled.setMinSize(this.cardsBar.computeSize(SWT.DEFAULT, SWT.DEFAULT));
          updateCardSelectionState();
          notifySelection();
      }*/
    @objid ("a9103d89-62a7-409c-b148-62011a6c8f49")
    private void createStepCard(final MqlStepNode step, final int index) {
        Composite card = new Composite(this.cardsBar, SWT.BORDER);
        GridLayout gl = new GridLayout(2, false);
        gl.marginWidth = 5;
        gl.marginHeight = 5;
        gl.horizontalSpacing = 2;
        card.setLayout(gl);
        card.setLayoutData(new RowData(140, 80));

        // Bold type label
        Label typeLabel = new Label(card, SWT.NONE);
        typeLabel.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DEFAULT_FONT));
        typeLabel.setText(stepTypeName(step));
        typeLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        // ✕ delete button (top-right corner)
        Button delBtn = new Button(card, SWT.PUSH | SWT.FLAT);
        delBtn.setText("\u2715");
        delBtn.setToolTipText(CoreUi.I18N.getString("MqlStepsPanel.removeStep.tooltip"));
        GridData delGd = new GridData(SWT.RIGHT, SWT.TOP, false, false);
        delGd.widthHint = 22;
        delGd.heightHint = 22;
        delBtn.setLayoutData(delGd);
        delBtn.addListener(SWT.Selection, e -> onDelete(index));

        // Summary (2 lines max)
        Label summaryLabel = new Label(card, SWT.WRAP);
        GridData sld = new GridData(SWT.FILL, SWT.FILL, true, true);
        sld.horizontalSpan = 2;
        summaryLabel.setLayoutData(sld);
        summaryLabel.setText(stepSummary(step));

        // Click anywhere on the card to select it
        Listener selectListener = e -> {
            this.selectedIndex = index;
            updateCardSelectionState();
            notifySelection();
        };
        card.addListener(SWT.MouseDown, selectListener);
        typeLabel.addListener(SWT.MouseDown, selectListener);
        summaryLabel.addListener(SWT.MouseDown, selectListener);
    }

    @objid ("bbf53b57-5e78-4feb-88fa-13b499800c9d")
    private void createAddButton() {
        Button addBtn = new Button(this.cardsBar, SWT.PUSH);
        addBtn.setText("\u002B");
        addBtn.setFont(JFaceResources.getFontRegistry().get(JFaceResources.HEADER_FONT));
        addBtn.setToolTipText(CoreUi.I18N.getString("MqlStepsPanel.addStep.tooltip"));
        addBtn.setLayoutData(new RowData(38, 80));
        addBtn.addListener(SWT.Selection, e -> {
            Menu menu = new Menu(addBtn);

            addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.property"),    () -> MqlStepCommands.createDefaultFilterStep(this.model,FilterStep.FilerStepKind.PROPERTY));
            addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.type"),  () -> MqlStepCommands.createDefaultFilterStep(this.model,FilterStep.FilerStepKind.KIND));
            addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.filter.composite"),  () -> MqlStepCommands.createDefaultFilterStep(this.model,FilterStep.FilerStepKind.COMPOSITE));

            addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.navigation"), () -> MqlStepCommands.createDefaultTraverseStep(this.model));
            addMenuItem(menu,  CoreUi.I18N.getString("MqlBrowser.itemcreation.union"),    () -> MqlStepCommands.createDefaultUnionStep(this.model));
            addMenuItem(menu, CoreUi.I18N.getString("MqlBrowser.itemcreation.loop"),   () -> MqlStepCommands.createDefaultRepeatStep(this.model));
            org.eclipse.swt.graphics.Point pt = addBtn.toDisplay(0, addBtn.getSize().y);
            menu.setLocation(pt);
            menu.setVisible(true);
        });
    }

    @objid ("45a1210c-e215-45d9-a3b9-0a1d339df5c8")
    private void addMenuItem(final Menu menu, final String label, final Supplier<Step> factory) {
        MenuItem item = new MenuItem(menu, SWT.PUSH);
        item.setText(label);
        item.addListener(SWT.Selection, ev -> {
            int insertAt = (this.selectedIndex >= 0 && this.selectedIndex < this.model.getStepNodes().size())
                    ? this.selectedIndex + 1
                    : this.model.getStepNodes().size();
            this.model.insertStep(insertAt, factory.get());
            this.selectedIndex = insertAt;
            rebuildCards();
        });
    }

    @objid ("ffb0986d-950b-44ef-b946-33152ed7356b")
    private void onDelete(final int index) {
        List<MqlStepNode> steps = this.model.getStepNodes();
        if (index < 0 || index >= steps.size()) return;
        String name = stepTypeName(steps.get(index));
        if (!MessageDialog.openConfirm(this.cardsBar.getShell(), CoreUi.I18N.getString("MqlStepsPanel.removeStep.title"),
                CoreUi.I18N.getMessage("MqlStepsPanel.removeStep.message", name))) return;
        this.model.removeStep(index);
        if (this.selectedIndex >= this.model.getStepNodes().size()) {
            this.selectedIndex = this.model.getStepNodes().size() - 1;
        }
        rebuildCards();
    }

    @objid ("8bf9d753-eed2-4fe9-a87f-005052a078bf")
    private void updateCardSelectionState() {
        if (this.cardsBar == null || this.cardsBar.isDisposed()) return;
        Control[] children = this.cardsBar.getChildren();
        int cardCount = this.model.getStepNodes().size();
        Color selectedBg = this.cardsBar.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION);
        Color normalBg   = this.cardsBar.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
        for (int i = 0; i < cardCount && i < children.length; i++) {
            applyBackground(children[i], i == this.selectedIndex ? selectedBg : normalBg);
        }
    }

    @objid ("c971e07d-ea79-4c3e-ab13-e73fc340ec94")
    private static void applyBackground(final Control control, final Color color) {
        control.setBackground(color);
        if (control instanceof Composite c) {
            for (Control child : c.getChildren()) {
                applyBackground(child, color);
            }
        }
    }

    @objid ("a4af0260-e5e6-452b-aeb1-92acbdff8403")
    private void notifySelection() {
        if (this.onSelectionChanged == null) return;
        List<MqlStepNode> steps = this.model.getStepNodes();
        if (this.selectedIndex >= 0 && this.selectedIndex < steps.size()) {
            this.onSelectionChanged.accept(steps.get(this.selectedIndex));
        } else {
            this.onSelectionChanged.accept(null);
        }
    }

    @objid ("e881f695-679b-458e-8028-9d3c3082fff0")
    private void hookModelListener(final Composite root) {
        this.listener = evt -> {
            if (root == null || root.isDisposed()) return;
            root.getDisplay().asyncExec(() -> {
                if (!this.cardsBar.isDisposed()) rebuildCards();
            });
        };
        this.model.addPropertyChangeListener(this.listener);
        root.addDisposeListener(e -> {
            if (this.listener != null) {
                this.model.removePropertyChangeListener(this.listener);
                this.listener = null;
            }
        });
    }

    // ── Static helpers ────────────────────────────────────────────────────────
    @objid ("f52f39f5-04b8-4386-be4d-e04158fce114")
    private static String stepTypeName(final MqlStepNode step) {
        if (step.isFilter())   return CoreUi.I18N.getString("MqlBrowser.itemcreation.filter");
        if (step.isTraverse()) return CoreUi.I18N.getString("MqlBrowser.itemcreation.navigation");
        if (step.isUnion())    return  CoreUi.I18N.getString("MqlBrowser.itemcreation.union");
        if (step.isRepeat())   return CoreUi.I18N.getString("MqlBrowser.itemcreation.loop");
        return "Step";
    }

    @objid ("f12acef5-f6c3-428b-b2aa-e4ccc161a8ba")
    private static String stepSummary(final MqlStepNode step) {
        if (step.isFilter()) {
            Expr w = step.getWhere() != null ? step.getWhere().getAst() : null;
            return "where: " + exprShort(w);
        }
        if (step.isTraverse()) {
            String edge = step.getTraverseEdge();
            return "edge: " + (edge == null || edge.isBlank() ? "?" : edge)
                    + "\n" + step.getTraverseDirection().name().toLowerCase();
        }
        if (step.isUnion()) {
            int n = step.getUnionBranches().size();
            return n + " branch" + (n != 1 ? "es" : "");
        }
        if (step.isRepeat()) {
            int n = step.getRepeatBody().size();
            boolean all = ((RepeatStep) step.getAst()).isEmitAllDepths();
            return n + " step" + (n != 1 ? "s" : "") + "\n" + (all ? "all depths" : "frontier only");
        }
        return "";
    }

    @objid ("3866d8dd-11c5-4eb7-b530-5d07b324db04")
    private static String exprShort(final Expr expr) {
        if (expr == null) return "?";
        if (expr instanceof IsExpr is) return "is(" + is.getOfQualifiedName() + ")";
        if (expr instanceof AndExpr)   return "(AND)";
        if (expr instanceof OrExpr)    return "(OR)";
        if (expr instanceof NotExpr)   return "(NOT)";
        return expr.getClass().getSimpleName().replace("Expr", "");
    }

    @objid ("dc030e30-cc01-41ad-93bb-95edf95413d5")
    private void rebuildCards() {
        rebuildCards(true); // normal rebuild → notify
    }

    @objid ("e4f1d7ef-09c3-4805-a778-c3579f038a28")
    private void rebuildCards(final boolean notify) {
        if (this.cardsBar == null || this.cardsBar.isDisposed()) return;

        for (Control child : this.cardsBar.getChildren()) {
            child.dispose();
        }

        List<MqlStepNode> steps = this.model.getStepNodes();
        for (int i = 0; i < steps.size(); i++) {
            createStepCard(steps.get(i), i);
        }

        this.cardsBar.layout(true);
        this.scrolled.setMinSize(this.cardsBar.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        updateCardSelectionState();

        if (notify) {
            notifySelection(); // ← only fire when NOT called from createControls()
        }
    }

}
