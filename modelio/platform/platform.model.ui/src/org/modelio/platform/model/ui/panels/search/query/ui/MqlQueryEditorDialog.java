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
package org.modelio.platform.model.ui.panels.search.query.ui;

import java.beans.PropertyChangeListener;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.query.editor.MqlGraphicalEditor;
import org.modelio.platform.model.ui.panels.search.query.elements.MqlNoSelectionPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddBranchStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddRepeatBodyStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.addstep.MqlAddStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.filter.MqlFilterExpressionPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.repeat.MqlRepeatPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.source.MqlSourceNode;
import org.modelio.platform.model.ui.panels.search.query.elements.source.MqlSourcePanel;
import org.modelio.platform.model.ui.panels.search.query.elements.traverse.MqlTraverseExpressionPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.traverse.MqlTraversePanel;
import org.modelio.platform.model.ui.panels.search.query.elements.union.MqlUnionPanel;
import org.modelio.platform.model.ui.panels.search.query.summary.MqlSummaryRenderer;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.IQueryResolver;
import org.modelio.platform.search.engine.searchers.query.api.Queries;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * Graphical MQL pipeline editor dialog.
 * <p>
 * Layout:
 * <ul>
 * <li><b>Left</b> – Pipeline GEF canvas (diagram of Source → Step → … → [+]) + Summary</li>
 * <li><b>Right</b> – Dynamic property panel that shows the relevant editor
 * depending on which pipeline node is selected:
 * Source &amp; Limits (when Source node is clicked),
 * Traverse, Repeat, Union, or Expression sections.</li>
 * </ul>
 */
@objid ("ca165095-86f9-4774-8689-a93e64fadbf8")
public class MqlQueryEditorDialog extends ModelioDialog2 {
    /**
     * Custom return code indicating the user clicked "Execute".
     * The caller should run the query and optionally auto-save it.
     */
    @objid ("c3fffb04-6e42-4075-beaf-448581397d71")
    public static final int SAVE = IDialogConstants.CLIENT_ID + 1;

    /**
     * {@code true} when the dialog was closed via the Execute button.
     */
    @objid ("db0ca7d9-aa65-4433-a3f4-b10123ee88e7")
    private boolean executeRequested;

    @objid ("21cdefbf-ae65-42ab-8361-18cc11502e7a")
    private boolean selectionPollerEnabled;

    @objid ("1032894c-fc1d-42dd-9886-d83dc76d082d")
    private Composite sourceControl;

    @objid ("1e913946-6df8-4fe7-9afd-30b79f93e066")
    private Composite limitsControl;

    @objid ("9af726bd-4ed5-4128-84f3-bbe0186972a8")
    private Text summaryText;

    /* @objid ("58f94293-88a9-443b-bee5-9233e1f82fb4")
     private Label nodePropertiesLabel;*/
    @objid ("f436b813-cdf9-477b-9495-0a6eef279ae6")
    private ScrolledComposite rightScrolled;

    @objid ("0a74eb35-47e5-423b-97cb-02191fb478dd")
    private Composite rightContent;

    /*  @objid ("14c95c97-b4ca-4ca1-a52f-bc15fa0539b8")
      private Label sectionSeparator;*/
    @objid ("151b6e20-a70d-4519-93fe-bc4324458624")
    private MqlNoSelectionPanel noSelectionSection;

    @objid ("c4a70267-9aa5-4a7d-98fa-55c5fbf43e07")
    private final MqlQueryModel model;

    @objid ("39ab3d5c-0f04-4d1a-a570-912b06e02787")
    private final MqlSummaryRenderer summaryRenderer;

    @objid ("38a92031-4bea-4b96-8ab6-6e022490d313")
    private final MqlValidationService validationService;

    @objid ("cf763c73-51a5-485f-aea7-f35068e3a0ce")
    private final ICoreSession session;

    @objid ("414ce1c0-37a0-456d-b2ea-439cc0e43341")
    private MqlGraphicalEditor graphicalEditor;

    @objid ("3bc7daee-e91c-4962-9b37-9010096b40ea")
    private MqlSourcePanel sourceSection;

    @objid ("9d81b40a-fe0e-4926-b41b-6ea97fe7311d")
    private MqlTraversePanel traverseSection;

    @objid ("5be28383-846b-4e93-b204-cbca5a83efcd")
    private MqlRepeatPanel repeatSection;

    @objid ("e0ce1da4-00f7-40f2-9059-e8660a7afde6")
    private MqlUnionPanel unionSection;

    @objid ("549e2b00-ef8c-42e4-a5cf-9d8ff9d7b3fb")
    private MqlFilterExpressionPanel filterExpressionPanel;

    @objid ("135bf3e8-35b8-40f5-a135-99e54d668d03")
    private PropertyChangeListener changeListener;

    @objid ("1f794379-c3d1-47b8-8f34-b37c7b902a0b")
    private Runnable selectionPoller;

    @objid ("ed032039-1706-4b60-b2ac-07eb535caa0c")
    private MetamodelHelper metamodelHelper;

    // ────────────────────────────────────────────────────────────────────────────
    @objid ("430e88b1-a0af-4b09-a7b8-fd69731674b7")
    public MqlQueryEditorDialog(final Shell parentShell, final MqlQueryModel model, final ICoreSession session) {
        super(parentShell);
        this.model = model;
        this.session = session;
        this.metamodelHelper = new MetamodelHelper(session);

        this.summaryRenderer = new MqlSummaryRenderer();
        IQueryResolver resolver = Queries.createEngine(session).getResolver();
        this.validationService = new MqlValidationService(resolver);
        setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
    }

    @objid ("e908e4ed-1dcf-42c2-8bbc-3bccca04a217")
    @Override
    public void init() {
        getShell().setText(CoreUi.I18N.getString("MqlQueryEditor.shell.title"));
        setTitle(CoreUi.I18N.getString("MqlQueryEditor.title"));
    }

    @objid ("614f5b34-b65f-459e-9ee1-9ff124d07801")
    @Override
    public void addButtonsInButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        createButton(parent, SAVE, CoreUi.I18N.getString("MqlQueryEditor.execute"), true);
    }

    @objid ("5e683a21-509d-4f3a-b1e2-037c349d016f")
    @Override
    protected void buttonPressed(final int buttonId) {
        if (buttonId == SAVE) {
            this.executeRequested = true;
            setReturnCode(SAVE);
            close();
        } else {
            super.buttonPressed(buttonId);
        }
    }

    @objid ("14398a23-fa2b-4e16-876d-0c5fb7b68047")
    @Override
    public Control createContentArea(final Composite parent) {
        SashForm mainSash = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);
        mainSash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        mainSash.setSashWidth(1);
        mainSash.setBackground(UIColor.LIGHTGRAY);

        // ── Left: pipeline canvas + summary ──────────────────────────────────
        Composite left = new Composite(mainSash, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(left);
        left.setLayout(new GridLayout(1, false));
        createPipelineViewer(left);
        createSummaryArea(left);

        // ── Right: property sections (scrollable) ────────────────────────────
        this.rightScrolled = new ScrolledComposite(mainSash, SWT.V_SCROLL | SWT.H_SCROLL);
        this.rightScrolled.setExpandHorizontal(true);
        this.rightScrolled.setExpandVertical(true);

        this.rightContent = new Composite(this.rightScrolled, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.rightContent);
        this.rightContent.setLayout(new GridLayout(1, false));

        if (this.model != null) {
            // ── Source section (shown only when source node is selected) ──
            this.sourceSection = new MqlSourcePanel(this.model, this.validationService, this.session);
            this.sourceControl = this.sourceSection.createControls(this.rightContent);
            this.sourceControl.setVisible(false);
            ((GridData) this.sourceControl.getLayoutData()).exclude = true;

            // ── Hint shown when nothing is selected ──
            this.noSelectionSection = new MqlNoSelectionPanel(this.model);
            this.noSelectionSection.createControls(this.rightContent);

            // ── Traverse section (shown only for traverse steps) ──
            this.traverseSection = new MqlTraversePanel(this.model,this.metamodelHelper,this.session);
            this.traverseSection.createControls(this.rightContent);

            // ── Repeat section (shown only for repeat steps) ──
            this.repeatSection = new MqlRepeatPanel(this.model);
            this.repeatSection.createControls(this.rightContent);
            this.repeatSection.setOnSubStepSelected(subStep -> onSubStepSelected(subStep));

            // ── Union section (shown only for union steps) ──
            this.unionSection = new MqlUnionPanel(this.model);
            this.unionSection.createControls(this.rightContent);

            // ── Filter expression panel (shown for filter steps) ──
            this.filterExpressionPanel = new MqlFilterExpressionPanel(this.model, this.validationService, this.session,this.metamodelHelper);
            this.filterExpressionPanel.createControls(this.rightContent);
            this.filterExpressionPanel.setOnLayoutChanged(() -> recomputeScrolledMinSize());
        }

        this.rightScrolled.setContent(this.rightContent);
        recomputeScrolledMinSize();
        this.rightContent.addListener(SWT.Resize, e -> recomputeScrolledMinSize());

        setSelectedStep(null);
        mainSash.setWeights(60, 40);
        hookModelListeners();
        refreshSummary();
        return mainSash;
    }

    // ── Private helpers ──────────────────────────────────────────────────────
    @objid ("ffdfd90c-2ae8-4f16-83be-68f46bd2cd43")
    private void createPipelineViewer(final Composite parent) {
        Composite group = new Composite(parent, SWT.BORDER);
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        group.setLayout(new GridLayout(1, false));
        PolluxWidgetConfigurator.configureContainer(group);

        Label pipelineLabel = new Label(group, SWT.NONE);
        pipelineLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.pipeline"));
        PolluxWidgetConfigurator.configureHeaderField(pipelineLabel);

        this.graphicalEditor = new MqlGraphicalEditor(group, this.validationService);
        this.graphicalEditor.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.graphicalEditor.setModel(this.model);

        this.graphicalEditor.getViewer().addSelectionChangedListener(
                (SelectionChangedEvent event) -> onGefSelectionChanged(event.getSelection()));
    }

    @objid ("92818ed7-d266-4092-8e81-b130c1704847")
    private void onGefSelectionChanged(final ISelection sel) {
        if (sel.isEmpty()) {
            setSelectedStep(null, false);
            return;
        }
        if (sel instanceof IStructuredSelection structured) {
            Object first = structured.getFirstElement();
            Object m = (first instanceof EditPart ep) ? ep.getModel() : first;
            boolean isSourceSelected = m instanceof MqlSourceNode;
            setSelectedStep(extractStepNode(first), isSourceSelected);
        }
    }

    /**
     * Unwraps a GEF {@link EditPart} to the underlying {@link MqlStepNode},
     * or {@code null} when the source / add-step node is selected.
     */
    @objid ("9db24d64-c18b-48ba-b568-079f42c90c18")
    private static MqlStepNode extractStepNode(final Object element) {
        Object m = (element instanceof EditPart ep) ? ep.getModel() : element;

        if (m instanceof MqlStepNode sn)  return sn;
        if (m instanceof MqlSourceNode)   return null;
        if (m instanceof MqlAddStepNode)  return null;
        if (m instanceof MqlAddBranchStepNode)  return null;
        if (m instanceof MqlAddRepeatBodyStepNode)  return null;

        // Union branch (List<?>) – walk up to the enclosing union step
        if (m instanceof java.util.List<?> && element instanceof EditPart ep) {
            return findEnclosingUnionStep(ep);
        }
        return null;
    }

    @objid ("e0cd9599-8865-49ca-ab87-fab2810c6fbb")
    private void createSummaryArea(final Composite parent) {
        Composite group = new Composite(parent, SWT.BORDER);
        PolluxWidgetConfigurator.configureContainer(group);
        Label groupeLabel = new Label(group, SWT.NONE);
        groupeLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.summary"));
        PolluxWidgetConfigurator.configureHeaderField(groupeLabel);

        GridData gd = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
        gd.heightHint = 150;
        group.setLayoutData(gd);
        group.setLayout(new GridLayout(1, false));
        this.summaryText = new Text(group, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
        this.summaryText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.summaryText);
    }

    /**
     * Updates all dynamic property sections based on the selected step.
     * <ul>
     * <li>Source &amp; Limits are always visible and not affected.</li>
     * <li>TraverseSection is shown only for traverse steps.</li>
     * <li>RepeatSection is shown only for repeat steps.</li>
     * <li>UnionSection is shown only for union steps.</li>
     * <li>ExpressionPanel is shown for filter and traverse steps.</li>
     * </ul>
     */
    @objid ("be57e0a6-c98e-44fc-a821-10f605800dab")
    private void setSelectedStep(final MqlStepNode step) {
        setSelectedStep(step, false);
    }

    @objid ("607cec3e-7dce-4407-8490-8b4b56b64264")
    private void setSelectedStep(final MqlStepNode step, final boolean isSourceSelected) {
        // Show/hide the "no selection" hint
        boolean nothingSelected = !isSourceSelected && step == null;
        if (this.noSelectionSection != null) {
            this.noSelectionSection.setVisible(nothingSelected);
        }

        // Show/hide Source and Limits sections (only visible when source node is selected)
        if (this.sourceControl != null && !this.sourceControl.isDisposed()) {
            this.sourceControl.setVisible(isSourceSelected);
            ((GridData) this.sourceControl.getLayoutData()).exclude = !isSourceSelected;
        }
        if (this.limitsControl != null && !this.limitsControl.isDisposed()) {
            this.limitsControl.setVisible(isSourceSelected);
            ((GridData) this.limitsControl.getLayoutData()).exclude = !isSourceSelected;
        }

        // Dispatch to each section (each handles its own show/hide)
        if (this.traverseSection != null) {
            this.traverseSection.setSelectedStep(step);
        }
        if (this.repeatSection != null) {
            this.repeatSection.setSelectedStep(step);
        }
        if (this.unionSection != null) {
            this.unionSection.setSelectedStep(step);
        }
        if (this.filterExpressionPanel != null) {
            this.filterExpressionPanel.setSelectedStep(step);
        }

        // Re-layout the right panel and recompute scroll size
        if (this.rightContent != null && !this.rightContent.isDisposed()) {
            this.rightContent.layout(true, true);
        }
        recomputeScrolledMinSize();
    }

    /**
     * Called by Repeat / Union sections when the user clicks a sub-step within
     * a repeat body or union branch. Updates Traverse + Expression sections
     * to reflect the selected sub-step without changing the Repeat/Union section.
     */
    @objid ("805f8e5e-4dbe-4b08-8986-0d74da4a1ba7")
    private void onSubStepSelected(final MqlStepNode subStep) {
        if (this.traverseSection != null) {
            this.traverseSection.setSelectedStep(subStep);
        }
        if (this.filterExpressionPanel != null) {
            this.filterExpressionPanel.setSelectedStep(subStep);
        }

        recomputeScrolledMinSize();
    }

    @objid ("b93673ed-be33-4f1a-b06b-413b31c1bbc8")
    private void recomputeScrolledMinSize() {
        if (this.rightScrolled != null && !this.rightScrolled.isDisposed()
                 && this.rightContent != null && !this.rightContent.isDisposed()) {
             this.rightContent.layout(true, true);
             Point size = this.rightContent.computeSize(
                     this.rightScrolled.getClientArea().width, SWT.DEFAULT);
             this.rightScrolled.setMinSize(size);
         }
    }

    @objid ("6b279f80-449b-41ec-baf4-74bdda592b83")
    private static MqlStepNode findEnclosingUnionStep(final EditPart start) {
        EditPart current = start;
        while (current != null) {
            Object m = current.getModel();
            if (m instanceof MqlStepNode sn && sn.isUnion()) {
                return sn;
            }
            current = current.getParent();
        }
        return null;
    }

    @objid ("88fb47bc-639c-4a31-85ba-c62df152e060")
    private void hookModelListeners() {
        if (this.model == null) {
            return;
        }
        this.changeListener = evt -> {
            String prop = evt.getPropertyName();
            // Re-resolve and refresh on any model change
            if (MqlQueryModel.PROP_CHANGED.equals(prop)
                    || MqlQueryModel.PROP_STEPS.equals(prop)
                    || MqlQueryModel.PROP_SOURCE.equals(prop)
                    || MqlQueryModel.PROP_LIMITS.equals(prop)) {
                this.validationService.resolve(this.model.getQueryAst());
                refreshSummary();
                updateExecuteButton();
            }
        };
        this.model.addPropertyChangeListener(this.changeListener);
        this.validationService.resolve(this.model.getQueryAst());
    }

    @objid ("ed2030af-7fa4-4f25-b997-c1760fa980b8")
    private void unhookModelListeners() {
        if (this.model != null && this.changeListener != null) {
            this.model.removePropertyChangeListener(this.changeListener);
        }
        this.changeListener = null;
    }

    @objid ("3ab7cb1a-b7c5-4927-8b36-2c83efa29892")
    private void updateExecuteButton() {
        boolean valid = !this.validationService.hasErrors();
        Button exec = getButton(SAVE);
        if (exec != null && !exec.isDisposed()) {
            exec.setEnabled(valid);
        }
    }

    @objid ("927c6610-5165-4a8f-b3ba-50cf49cccd6a")
    private void refreshSummary() {
        if (this.summaryText == null || this.summaryText.isDisposed()) {
            return;
        }
        this.summaryText.setText(this.model != null ? this.summaryRenderer.render(this.model) : "");
    }

    @objid ("f8ce798c-2858-4af8-a084-b81ef5f552c5")
    private void stopSelectionPolling() {
        this.selectionPollerEnabled = false;
        this.selectionPoller = null;
    }

    @objid ("3e19d1dc-ae3c-406e-988f-534af9685a12")
    @Override
    public boolean close() {
        stopSelectionPolling();
        unhookModelListeners();
        return super.close();
    }

    @objid ("96653d5b-e00d-481d-914d-7097ded22a39")
    @Override
    protected Point getInitialSize() {
        return new Point(1100, 720);
    }

    /**
     * Returns {@code true} if the dialog was closed via the Execute button.
     */
    @objid ("9bc4388f-2a51-44c8-a06e-deb4b2257bb1")
    public boolean isExecuteRequested() {
        return this.executeRequested;
    }

    /**
     * Returns the query AST after the user clicks "Execute".
     */
    @objid ("89d14b17-f245-4c43-b9fd-b820dca40e17")
    public Query getQuery() {
        return this.model != null ? this.model.getQueryAst() : null;
    }

    /**
     * Returns the underlying query model.
     */
    @objid ("cbef90a8-cf32-48cf-8e0c-0ecee0a00825")
    public MqlQueryModel getQueryModel() {
        return this.model;
    }

}
