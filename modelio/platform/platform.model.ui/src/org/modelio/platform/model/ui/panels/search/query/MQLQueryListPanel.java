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
package org.modelio.platform.model.ui.panels.search.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.e4.ui.workbench.modeling.ISelectionListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.platform.model.ui.panels.search.IPanelValidationListener;
import org.modelio.platform.model.ui.panels.search.ISearchController;
import org.modelio.platform.model.ui.panels.search.ISearchPanel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.saved.MqlQueryRepository;
import org.modelio.platform.model.ui.panels.search.query.saved.SavedMqlQuery;
import org.modelio.platform.model.ui.panels.search.query.summary.MqlSummaryRenderer;
import org.modelio.platform.model.ui.panels.search.query.ui.MqlQueryEditorDialog;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.model.ui.swt.SelectionHelper;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.searchers.query.QuerySearchCriteria;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ProvidedSource;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * MQL Queries Browser.
 * <p>
 * Shows the list of saved MQL queries with a toolbar (New, Edit, Delete,
 * Execute) and a preview pane below the list (name, description, last executed,
 * pipeline summary).
 * <p>
 * Opening the pipeline editor (via New or Edit) opens
 * {@link MqlQueryEditorDialog} as a separate modal dialog.
 * <p>
 * Supports two modes:
 * <ul>
 * <li><b>Standalone</b> – opened via {@link #open()} as a regular dialog.</li>
 * <li><b>Embedded</b> – content inlined into any parent composite via
 * {@link #buildEmbedded(Composite, Runnable)}.</li>
 * </ul>
 */
@objid ("16e5ea30-d89a-48f5-8b29-baf118021934")
public class MQLQueryListPanel implements ISearchPanel {
    @objid ("e746ca49-f6c0-44fc-873d-7d85a6afd543")
    private Text previewSummaryText;

    @objid ("c8040d3e-4249-48dd-ae0a-e1d9a94de9ba")
    private TableViewer tableViewer;

    @objid ("aecad548-cb5d-4cf5-a2b3-18ee4d8f5078")
    private Button btnEdit;

    @objid ("0b667564-194c-49d2-ad36-a022237cfbd0")
    private Button btnDelete;

    @objid ("7e534cce-a974-4a37-b123-f32fcac3652f")
    private Shell hostShell;

    @objid ("20dc3aaa-18d4-4998-a1a2-2108435a940d")
    private Composite topGroup;

    @objid ("abda69fe-0e9f-40a8-8d75-98d20f1ab7a9")
    private Text inputText;

    @objid ("482291e8-3c43-437d-94f9-5b41814a4972")
    private Composite inputGroup;

    @objid ("8cb8e2d0-ac68-40da-be43-9a08d18f148c")
    private Button includeRamcCheckBox;

    @objid ("d3206314-6d4c-4d54-869a-0d3297ec51a5")
    private List<MObject> inputList = new ArrayList<>();

    @objid ("e138383e-e179-4209-bb30-9c282e48f4c1")
    private ICoreSession session;

    @objid ("d0fe2916-fc4d-472e-83f1-710f9c4a92f4")
    private final MqlQueryRepository repository = MqlQueryRepository.getInstance();

    @objid ("4d452e79-9a7a-46cd-b056-97f39f5565f1")
    private final MqlSummaryRenderer summaryRenderer = new MqlSummaryRenderer();

    @objid ("15bf9827-b26b-4324-91f1-960a40f91e3f")
    private SavedMqlQuery selectedQuery;

    @objid ("22dc09f9-1624-44a0-8733-db058a59fc23")
    private SavedMqlQuery queryToExecute;

    @objid ("449abb8f-fe23-416e-941e-054072e9742c")
    private IPanelValidationListener validationListener;

    /**
     * Called instead of {@link #okPressed()} when running embedded.
     */
    @objid ("eca16dd8-3359-4a95-af02-4b2b26868e43")
    private Runnable executeCallback;

    @objid ("8e97e190-6e48-414c-9a43-d483953f81b0")
    private void createQueriesGroup(final Composite parent) {
        Composite grp = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(grp);
        grp.setLayout(new GridLayout(2, false));
        grp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));


        this.tableViewer = new TableViewer(grp, SWT.FULL_SELECTION | SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
        Table table = this.tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        addColumn(CoreUi.I18N.getString("MqlBrowser.column.name"), 160, SavedMqlQuery::getName);
        addColumn(CoreUi.I18N.getString("MqlBrowser.column.summary"), 300, q -> q.getSummary() != null ? q.getSummary() : "");

        this.tableViewer.setContentProvider(ArrayContentProvider.getInstance());
        this.tableViewer.addSelectionChangedListener(event -> {
            IStructuredSelection sel = this.tableViewer.getStructuredSelection();
            this.selectedQuery = sel.isEmpty() ? null : (SavedMqlQuery) sel.getFirstElement();
            onSelectionChanged();
        });




        // Button bar to the right of the table
        Composite buttonBar = new Composite(grp, SWT.NONE);
        GridLayout barLayout = new GridLayout(1, false);
        barLayout.marginWidth = 0;
        barLayout.marginHeight = 0;
        buttonBar.setLayout(barLayout);
        buttonBar.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, false, false));

        Button btnNew = new Button(buttonBar, SWT.PUSH);
        btnNew.setImage(UIImages.ADD);
        btnNew.setToolTipText(CoreUi.I18N.getString("MqlBrowser.newQuery"));
        btnNew.addListener(SWT.Selection, e -> onNew());

        this.btnEdit = new Button(buttonBar, SWT.PUSH);
        this.btnEdit.setImage(UIImages.EDIT);
        this.btnEdit.setToolTipText(CoreUi.I18N.getString("MqlBrowser.edit"));
        this.btnEdit.setEnabled(false);
        this.btnEdit.addListener(SWT.Selection, e -> onEdit());

        this.btnDelete = new Button(buttonBar, SWT.PUSH);
        this.btnDelete.setImage(UIImages.DELETE);
        this.btnDelete.setToolTipText(CoreUi.I18N.getString("MqlBrowser.delete"));
        this.btnDelete.setEnabled(false);
        this.btnDelete.addListener(SWT.Selection, e -> onDelete());

        this.includeRamcCheckBox = new Button(this.topGroup, SWT.CHECK);
        this.includeRamcCheckBox.setToolTipText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.tooltip")); //$NON-NLS-1$
        this.includeRamcCheckBox.setText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.label"));
        GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        this.includeRamcCheckBox.setLayoutData(gd);
        this.includeRamcCheckBox.setBackground(UIColor.WHITE);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(this.includeRamcCheckBox);
    }

    @objid ("d8396674-137b-41f7-b0f6-43afc3aeff45")
    private void addColumn(final String title, final int width, final Function<SavedMqlQuery, String> provider) {
        TableViewerColumn col = new TableViewerColumn(this.tableViewer, SWT.NONE);
        col.getColumn().setText(title);
        col.getColumn().setWidth(width);
        col.setLabelProvider(new ColumnLabelProvider() {
            @Override
            public String getText(Object element) {
                return element instanceof SavedMqlQuery q ? provider.apply(q) : "";
            }
        });
    }

    @objid ("929ec522-c217-441e-9fef-f21332402be8")
    private void createPreviewGroup(final Composite parent) {
        Composite previewGroup = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(previewGroup);
        GridData pgd = new GridData(SWT.FILL, SWT.FILL, true, true);
        previewGroup.setLayoutData(pgd);
        previewGroup.setLayout(new GridLayout(1, false));


        Label lbl = new Label(previewGroup, SWT.NONE);
        lbl.setText(CoreUi.I18N.getString("MqlBrowser.preview.pipelineSummary"));
        this.previewSummaryText = new Text(previewGroup, SWT.MULTI | SWT.READ_ONLY | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        this.previewSummaryText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        this.previewSummaryText.setText(CoreUi.I18N.getString("MqlBrowser.preview.selectQuery"));
        PolluxWidgetConfigurator.configureMultiField(lbl, this.previewSummaryText, null);
        this.previewSummaryText.setBackground(UIColor.SWT_INFO_BACKGROUND);
    }

    @objid ("7c902f83-b60b-4715-94ca-4aead25241aa")
    private void createInputGroup(Composite parent, ESelectionService selectionService) {
        this.inputGroup = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.inputGroup);
        GridData pgd = new GridData(SWT.FILL, SWT.FILL, true, false);
        this.inputGroup.setLayoutData(pgd);
        this.inputGroup.setLayout(new GridLayout(1, false));

        Label lbl = new Label(this.inputGroup, SWT.NONE);
        lbl.setText(CoreUi.I18N.getString("MqlBrowser.preview.piplineInput"));
        this.inputText = new Text(this.inputGroup, SWT.READ_ONLY | SWT.BORDER) ;
        PolluxWidgetConfigurator.configureSimpleField(lbl, this.inputText, null);
        this.inputText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

        this.inputText.setBackground(UIColor.SWT_INFO_BACKGROUND);

        this.inputList = SelectionHelper.toList((ISelection)selectionService.getSelection(), MObject.class);
        this.inputGroup.setVisible(false);
        ((GridData) this.inputGroup.getLayoutData()).exclude = true;
        selectionService.addSelectionListener(new ISelectionListener() {
            @Override
            public void selectionChanged(MPart part, Object selection) {
                List<MObject> selectedElements = SelectionHelper.toList((ISelection)selection, MObject.class);

                if(selectedQuery != null && selectedQuery.getQueryAst().getSource() instanceof ProvidedSource) {
                    ProvidedSource source = (ProvidedSource) selectedQuery.getQueryAst().getSource();
                    source.setElements(selectedElements);
                }

                if (!inputText.isDisposed()) {
                    inputText.setText(selectedElements.stream().filter(elt -> elt instanceof ModelElement).map(elt -> ((ModelElement)elt).getName()).collect(Collectors.joining(", ")));
                }
            }
        });
    }

    @objid ("27b521f2-eb35-4168-8182-9cc6445fbdca")
    private void updatePreview(final SavedMqlQuery query) {
        if (this.previewSummaryText == null || this.previewSummaryText.isDisposed())
            return;
        if (query == null) {
            this.previewSummaryText.setText(CoreUi.I18N.getString("MqlBrowser.preview.selectQuery"));
            this.inputGroup.setVisible(false);
            ((GridData) this.inputGroup.getLayoutData()).exclude = true;
            this.inputGroup.getParent().layout(true, true);
        } else {
            String sum = query.getSummary();
            this.previewSummaryText.setText((sum != null && !sum.isBlank()) ? sum : CoreUi.I18N.getString("MqlBrowser.preview.noSummary"));

            if(this.selectedQuery.getQueryAst().getSource() instanceof ProvidedSource) {
                ProvidedSource source = (ProvidedSource) this.selectedQuery.getQueryAst().getSource();
                source.setElements(this.inputList);
                inputText.setText(this.inputList.stream().filter(elt -> elt instanceof ModelElement).map(elt -> ((ModelElement)elt).getName()).collect(Collectors.joining(", ")));
                this.inputGroup.setVisible(true);
                ((GridData) this.inputGroup.getLayoutData()).exclude = false;
                this.inputGroup.getParent().layout(true, true);
            }else {
                this.inputGroup.setVisible(false);
                ((GridData) this.inputGroup.getLayoutData()).exclude = true;
                this.inputGroup.getParent().layout(true, true);
            }
        }
    }

    @objid ("39714173-433d-47f8-b105-9e7efac5e57a")
    private Shell resolveShell() {
        return this.hostShell;
    }

    @objid ("f8fd7719-e011-407f-a3f9-14cc96de25ee")
    private void onNew() {
        MqlQueryModel model = MqlQueryModel.createDefaultAllSource("Infrastructure.ModelElement");
        MqlQueryEditorDialog editor = new MqlQueryEditorDialog(resolveShell(), model, this.session);
        int result = editor.open();

        if (result == MqlQueryEditorDialog.SAVE) {
            // Execute immediately, then auto-save to history
            String summary = this.summaryRenderer.render(model);
            SavedMqlQuery q = new SavedMqlQuery();
            q.setName(editor.getQueryModel().getName());
            q.setQueryAst(editor.getQuery());
            q.setSummary(summary);
            q.setExecutionCount(1);
            q.setLastExecuted(java.time.LocalDateTime.now());
            this.repository.save(q);
            refreshTable();
            this.tableViewer.setSelection(new StructuredSelection(q), true);
        }
    }

    @objid ("5c12a067-c940-4efe-a460-9cabc3cd334d")
    private void onEdit() {
        if (this.selectedQuery == null)
            return;
        // Restore the saved query pipeline; fall back to a default model if no AST has
        // been saved yet
        MqlQueryModel model = (this.selectedQuery.getQueryAst() != null) ? new MqlQueryModel(this.selectedQuery.getName(),this.selectedQuery.getQueryAst()) : MqlQueryModel.createDefaultAllSource("Standard.ModelElement"/* , this.selectionProvider */);
        MqlQueryEditorDialog editor = new MqlQueryEditorDialog(resolveShell(), model, this.session);
        if (editor.open() == MqlQueryEditorDialog.SAVE) {
            // Save updated query and execute immediately

            MqlQueryModel updatedModel = editor.getQueryModel();
            this.selectedQuery.setQueryAst(updatedModel.getQueryAst());
            this.selectedQuery.setName(updatedModel.getName());
            this.selectedQuery.setSummary(this.summaryRenderer.render(model));
            this.selectedQuery.setExecutionCount(this.selectedQuery.getExecutionCount() + 1);
            this.selectedQuery.setLastExecuted(java.time.LocalDateTime.now());
            this.repository.save(this.selectedQuery);
            refreshTable();
            this.tableViewer.setSelection(new StructuredSelection(this.selectedQuery), true);
            updatePreview(this.selectedQuery);

        }
    }

    @objid ("570ec816-4e14-4213-9f87-8a4b5fd62a62")
    private void onDelete() {
        if (this.selectedQuery == null)
            return;
        if (!MessageDialog.openConfirm(resolveShell(), CoreUi.I18N.getString("MqlBrowser.deleteConfirm.title"), CoreUi.I18N.getMessage("MqlBrowser.deleteConfirm.message", this.selectedQuery.getName())))
            return;
        this.repository.delete(this.selectedQuery);
        this.selectedQuery = null;
        refreshTable();
        updatePreview(null);
    }

    @objid ("40a4a037-8b7c-4f0e-aacf-4d0b5a443c39")
    private void onSelectionChanged() {
        boolean has = this.selectedQuery != null;
        this.btnEdit.setEnabled(has);
        this.btnDelete.setEnabled(has);
        this.validationListener.validationStateChanged(has);

        updatePreview(this.selectedQuery);
    }

    @objid ("e7a2b2b1-f298-4383-a8b0-7900d88bf89a")
    private void refreshTable() {
        if (this.tableViewer == null || this.tableViewer.getTable().isDisposed())
            return;
        this.tableViewer.setInput(this.repository.getQueries());
        this.tableViewer.refresh();
    }

    @objid ("a889a90d-6392-4785-a441-23f9a7e1806c")
    public SavedMqlQuery getQueryToExecute() {
        return this.queryToExecute;
    }

    @objid ("2346f451-e6d9-45d1-a22c-a91cdb8b2ba2")
    @Override
    public void initialize(Composite parent, ICoreSession session, ISearchController controller, ESelectionService selectionService, IPanelValidationListener validationListener) {
        this.session = session;
        this.hostShell = parent.getShell();
        this.validationListener =validationListener;
        this.topGroup = new Composite(parent, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.topGroup);
        topGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        topGroup.setLayout(new GridLayout(1, false));

        createQueriesGroup(topGroup);
        createPreviewGroup(topGroup);
        createInputGroup(topGroup,selectionService);

        this.validationListener.validationStateChanged(false);
        refreshTable();
    }

    @objid ("9f96e372-1969-4965-9562-b59a39ca8e51")
    @Override
    public Control getControl() {
        return this.topGroup;
    }

    @objid ("dc2cdda6-3240-4e7f-a180-438de6a3305c")
    @Override
    public ISearchCriteria getCriteria() {
        if(this.selectedQuery != null) {
            QuerySearchCriteria sr = new QuerySearchCriteria(this.selectedQuery.getQueryAst(), new ArrayList<>());
            sr.setIncludeLibraryElements(this.includeRamcCheckBox.getSelection());
            return sr;
        }
        return null;
    }

    @objid ("c5f14165-14ae-4181-bdc0-575245c49c16")
    @Override
    public void setCriteria(ISearchCriteria criteria) {
        // Not implemented: this panel does not support loading criteria from outside; it only allows executing and managing the list of saved queries.
    }

    @objid ("7f11ecb7-5a6c-4b47-a708-ce919ca986cb")
    public int getPriority() {
        return -1;
    }

}
