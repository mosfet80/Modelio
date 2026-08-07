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
package org.modelio.platform.model.ui.panels.search.advanced;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.IPanelValidationListener;
import org.modelio.platform.model.ui.panels.search.ISearchController;
import org.modelio.platform.model.ui.panels.search.ISearchPanel;
import org.modelio.platform.model.ui.panels.search.advanced.datas.NameMatchMode;
import org.modelio.platform.model.ui.panels.search.advanced.datas.PropertyCriterion;
import org.modelio.platform.model.ui.panels.search.advanced.datas.PropertyCriterionDialog;
import org.modelio.platform.model.ui.panels.search.common.MetaclassSelectorWidget;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.api.DefaultSearchCriteria;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.api.ModelSearchResult.SearchCriterion;
import org.modelio.platform.search.engine.searchers.query.QuerySearchCriteria;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Query;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Advanced search panel with metamodel/metaclass selection and property
 * criteria.
 */
@objid ("e724efcc-eb5e-4b58-be9b-2658f7e84061")
public class AdvancedSearchPanel implements ISearchPanel {
    @objid ("a587d5e7-422d-4102-97ce-97618b9c11ad")
    private Composite topGroup;

    @objid ("38e727e1-53df-4313-918e-8360eeadb22d")
    private Text nameText;

    @objid ("9353fbf0-8380-4b0e-b6b9-853529b28fdd")
    private ComboViewer nameMatchModeCombo;

    @objid ("d6cc055f-3a00-4c4d-b400-8e33cee652a5")
    private Table propertyCriteriaTable;

    @objid ("0a2df27e-e9ad-4ad1-98c5-5b2e4478cfbf")
    private Button addCriterionButton;

    @objid ("c7df6c68-b985-4ba8-8bc2-14054ac61800")
    private Control controlWidget;

    @objid ("305df514-93a2-41c7-bc84-84770ec68d82")
    private Button includeRamcCheckBox;

    @objid ("dea5e30a-0378-4fad-9265-573517b0e406")
    private MetaclassSelectorWidget metaclassSelector;

    @objid ("e1074df2-f409-4a1e-9590-16a2df2feab6")
    private ISearchController searchController;

    @objid ("508912c8-b567-4213-9219-c84fe0e2f786")
    private ICoreSession session;

    @objid ("7abf7b01-4006-4454-b7fa-0674b96f19f3")
    private List<PropertyCriterion> propertyCriteria = new ArrayList<>();

    @objid ("ecd52e0d-68bd-440f-8843-db278a94c1ff")
    private MetamodelHelper metamodelHelper;

    @objid ("bd09c533-35a9-4b19-a241-d2f696cf3f14")
    private IPanelValidationListener validationListener;

    @objid ("20692bfa-911e-4752-9fd6-3505b7f8c197")
    @Override
    public void initialize(Composite parent, ICoreSession session, ISearchController searchController, ESelectionService selectionService, IPanelValidationListener validationListener) {
        this.validationListener = validationListener;
        this.metamodelHelper = new MetamodelHelper(session);
        this.searchController = searchController;
        this.session = session;

        this.topGroup = new Composite(parent, SWT.NONE);
        this.topGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        PolluxWidgetConfigurator.configureContainer(this.topGroup);

        GridLayout gridLayout = new GridLayout(1, false);
        this.topGroup.setLayout(gridLayout);

        // Element Type Section
        Label typeLabel = new Label(this.topGroup, SWT.NONE);
        typeLabel.setText(CoreUi.I18N.getString("AdvancedSearch.ElementType.label") + " *");
        GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        typeLabel.setLayoutData(gd);
        PolluxWidgetConfigurator.configureHeaderField(typeLabel);

        this.metaclassSelector = new MetaclassSelectorWidget(session, qn -> updatePropertyCriteriaOptions());
        this.metaclassSelector.createControls(this.topGroup,
                CoreUi.I18N.getString("AdvancedSearch.Metamodel.label"),
                CoreUi.I18N.getString("AdvancedSearch.Metaclass.label"));



        this.includeRamcCheckBox = new Button(this.topGroup, SWT.CHECK);
        this.includeRamcCheckBox.setToolTipText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.tooltip")); //$NON-NLS-1$
        this.includeRamcCheckBox.setText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.label"));
        gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        this.includeRamcCheckBox.setLayoutData(gd);

        PolluxWidgetConfigurator.configureStyleForFieldLabel(this.includeRamcCheckBox);



        // Element Name Section
        Label nameLabel = new Label(this.topGroup, SWT.NONE);
        nameLabel.setText(CoreUi.I18N.getString("AdvancedSearch.ElementName.label"));
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        gd.verticalIndent = 10;
        nameLabel.setLayoutData(gd);
        PolluxWidgetConfigurator.configureHeaderField(nameLabel);


        // Name text field FIRST
        Label nameFieldLabel = new Label(this.topGroup, SWT.NONE);
        nameFieldLabel.setText(CoreUi.I18N.getString("AdvancedSearch.Name.label"));

        this.nameText = new Text(this.topGroup, SWT.BORDER);
        this.nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureSimpleField(nameFieldLabel, this.nameText, null);

        Label matchModeLabel = new Label(this.topGroup, SWT.NONE);
        matchModeLabel.setText(CoreUi.I18N.getString("AdvancedSearch.MatchMode.label"));
        this.nameMatchModeCombo = new ComboViewer(this.topGroup, SWT.READ_ONLY | SWT.BORDER);
        this.nameMatchModeCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.nameMatchModeCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.nameMatchModeCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof NameMatchMode) {
                    return getNameMatchModeLabel((NameMatchMode) element);
                }
                return super.getText(element);
            }
        });

        // Only these 4 modes available
        NameMatchMode[] modeOptions = new NameMatchMode[] {
            NameMatchMode.EXACT,
            NameMatchMode.CONTAINS,
            NameMatchMode.STARTS_WITH,
            NameMatchMode.ENDS_WITH
        };
        this.nameMatchModeCombo.setInput(modeOptions);
        this.nameMatchModeCombo.setSelection(new StructuredSelection(NameMatchMode.CONTAINS));
        PolluxWidgetConfigurator.configureSimpleField(matchModeLabel, this.nameMatchModeCombo.getControl(), null);

        // Property Criteria Section
        Label propertiesLabel = new Label(this.topGroup, SWT.NONE);
        propertiesLabel.setText(CoreUi.I18N.getString("AdvancedSearch.PropertyCriteria.label"));
        gd = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
        gd.verticalIndent = 10;
        propertiesLabel.setLayoutData(gd);
        PolluxWidgetConfigurator.configureHeaderField(propertiesLabel);


        // Property criteria table
        this.propertyCriteriaTable = new Table(this.topGroup, SWT.BORDER | SWT.FULL_SELECTION);
        gd = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
        gd.heightHint = 150;
        this.propertyCriteriaTable.setLayoutData(gd);
        this.propertyCriteriaTable.setHeaderVisible(true);
        this.propertyCriteriaTable.setLinesVisible(true);

        TableColumn propColumn = new TableColumn(this.propertyCriteriaTable, SWT.NONE);
        propColumn.setText(CoreUi.I18N.getString("AdvancedSearch.Property.column"));
        propColumn.setWidth(200);

        TableColumn operatorColumn = new TableColumn(this.propertyCriteriaTable, SWT.NONE);
        operatorColumn.setText(CoreUi.I18N.getString("AdvancedSearch.Operator.column"));
        operatorColumn.setWidth(150);

        TableColumn valueColumn = new TableColumn(this.propertyCriteriaTable, SWT.NONE);
        valueColumn.setText(CoreUi.I18N.getString("AdvancedSearch.Value.column"));
        valueColumn.setWidth(200);

        TableColumn actionColumn = new TableColumn(this.propertyCriteriaTable, SWT.NONE);
        actionColumn.setText("");
        actionColumn.setWidth(80);

        // Add Criterion button
        this.addCriterionButton = new Button(this.topGroup, SWT.PUSH);
        this.addCriterionButton.setText(CoreUi.I18N.getString("AdvancedSearch.AddCriterion.button"));
        this.addCriterionButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
        this.addCriterionButton.setEnabled(false);
        this.addCriterionButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                addPropertyCriterion();
            }
        });

        validationListener.validationStateChanged(false);

        this.controlWidget = this.topGroup;
    }

    @objid ("5a467730-60c2-4cfe-8df1-cc1c4aadb1f7")
    private void updatePropertyCriteriaOptions() {
        MClass selectedMetaclass = this.metaclassSelector.getSelectedMetaclass();
        this.addCriterionButton.setEnabled(selectedMetaclass != null);
        this.validationListener.validationStateChanged(selectedMetaclass != null);
        this.propertyCriteria.clear();
        this.propertyCriteriaTable.removeAll();
    }

    @objid ("377c1337-108d-475f-b986-9c94a6690351")
    private void addPropertyCriterion() {
        MClass selectedMetaclass = this.metaclassSelector.getSelectedMetaclass();
        if (selectedMetaclass == null) {
            return;
        }

        Stereotype selectedStereotype = this.metaclassSelector.getSelectedStereotype();
        PropertyCriterionDialog dialog = new PropertyCriterionDialog(this.controlWidget.getShell(), selectedMetaclass,
                this.session, selectedStereotype,this.metamodelHelper);


        if (dialog.open() == IDialogConstants.OK_ID) {
            this.propertyCriteria.add(dialog.getResult());
            displayPropertyCriterion(dialog.getResult());
        }
    }

    @objid ("2e9fdc3c-d7f6-4083-81a2-5ff2fdebbae0")
    private void displayPropertyCriterion(PropertyCriterion criterion) {
        TableItem item = new TableItem(this.propertyCriteriaTable, SWT.NONE);
        item.setText(0, criterion.getPropertyName());
        item.setText(1, criterion.getOperator().toString());
        item.setText(2, criterion.getValue());
        item.setData(criterion);

        Button deleteButton = new Button(this.propertyCriteriaTable, SWT.FLAT);
        deleteButton.setImage(UIImages.DELETE);
        deleteButton.setToolTipText(CoreUi.I18N.getString("AdvancedSearch.Delete.tooltip"));
        deleteButton.setData(criterion);

        deleteButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                deletePropertyCriterion(criterion, item);
            }
        });

        org.eclipse.swt.custom.TableEditor editor = new org.eclipse.swt.custom.TableEditor(
                this.propertyCriteriaTable);
        editor.grabHorizontal = true;
        editor.grabVertical = true;
        editor.setEditor(deleteButton, item, 3);

        item.setData("editor", editor);
    }

    @objid ("d0e75ece-dacd-4711-9239-552239fa640e")
    private void deletePropertyCriterion(PropertyCriterion criterion, TableItem item) {
        this.propertyCriteria.remove(criterion);

        Object editorObj = item.getData("editor");
        if (editorObj instanceof org.eclipse.swt.custom.TableEditor) {
            org.eclipse.swt.custom.TableEditor editor = (org.eclipse.swt.custom.TableEditor) editorObj;
            if (editor.getEditor() != null && !editor.getEditor().isDisposed()) {
                editor.getEditor().dispose();
            }
            editor.dispose();
        }

        item.dispose();
    }

    @objid ("a64be94d-1772-4522-8eeb-85310a8a1113")
    private String getSelectedMetamodel() {
        return this.metaclassSelector.getSelectedModule() == null
                ? this.metaclassSelector.getSelectedQualifiedName()
                : null;
    }

    @objid ("1f641f53-d3fb-4876-85f9-01c7e7dd2965")
    private org.modelio.metamodel.mda.ModuleComponent getSelectedModule() {
        return this.metaclassSelector.getSelectedModule();
    }

    @objid ("d06e515a-ebf3-4871-b6f1-dcdbace8bbd4")
    private MClass getSelectedMetaclass() {
        return this.metaclassSelector.getSelectedMetaclass();
    }

    @objid ("bdc3c964-6c9c-440a-a7dc-808af5067681")
    private Stereotype getSelectedStereotype() {
        return this.metaclassSelector.getSelectedStereotype();
    }

    @objid ("78453e3c-43a3-401c-a2d8-ad8012102c2f")
    private String getNameMatchModeLabel(NameMatchMode mode) {
        switch (mode) {
        case EXACT:
            return CoreUi.I18N.getString("NameMatchMode.Exact");
        case CONTAINS:
            return CoreUi.I18N.getString("NameMatchMode.Contains");
        case STARTS_WITH:
            return CoreUi.I18N.getString("NameMatchMode.StartsWith");
        case ENDS_WITH:
            return CoreUi.I18N.getString("NameMatchMode.EndsWith");
        default:
            return mode.toString();
        }
    }

    @objid ("77f4c434-3065-4533-a042-7d4cec1c7d7a")
    @Override
    public Control getControl() {
        return this.controlWidget;
    }

    @objid ("2e5cd723-6f1a-4b6f-ad06-0d7d0eb5cf6a")
    @Override
    public ISearchCriteria getCriteria() {
        MClass selectedMetaclass = this.metaclassSelector.getSelectedMetaclass();
        // When a module stereotype is selected but its base class can't be resolved,
        // fall back to ModelElement so the MQL query can still run.
        Stereotype selectedStereotype = this.metaclassSelector.getSelectedStereotype();
        if (selectedMetaclass == null && selectedStereotype != null) {
            selectedMetaclass = this.session.getMetamodel().getMClass(MObject.class).getSub(true).stream()
                    .filter(c -> "ModelElement".equalsIgnoreCase(c.getName()))
                    .findFirst().orElse(null);
        }


        // Get name and match mode
        String name = this.nameText.getText().trim();
        NameMatchMode nameMatchMode = NameMatchMode.CONTAINS; // Default
        if (!name.isEmpty()) {
            IStructuredSelection modeSelection = (IStructuredSelection) this.nameMatchModeCombo.getSelection();
            Object selectedMode = modeSelection.getFirstElement();
            if (selectedMode instanceof NameMatchMode) {
                nameMatchMode = ((NameMatchMode) selectedMode);
            }
        }

        Query query = QueryConverter.instance().setMetaclass(selectedMetaclass)
                                               .setName(name,nameMatchMode)
                                               .setProperty(this.propertyCriteria)
                                               .setModuleComponent(this.metaclassSelector.getSelectedModule())
                                               .setStereotype(selectedStereotype)
                                               .convert();

        List<SearchCriterion> criteria = new ArrayList<>();
        for(PropertyCriterion pc : this.propertyCriteria) {
            criteria.add(new SearchCriterion(pc.getPropertyName(),pc.getType().type()));
        }

        QuerySearchCriteria search = new QuerySearchCriteria(query,criteria);
        search.setIncludeLibraryElements(this.includeRamcCheckBox.getSelection());

        return search;
    }

    @objid ("950d866c-5b0a-43a9-a2df-11b690eb8233")
    @Override
    public void setCriteria(ISearchCriteria criteria) {
        if(criteria == null || !(criteria instanceof DefaultSearchCriteria)) {
            return;
        }
        String name = (String) criteria.getOption("name");

        if(name != null) {
            this.nameText.setText(name);
            this.nameMatchModeCombo.setSelection(new StructuredSelection(NameMatchMode.CONTAINS));
        }
    }

    @objid ("cf5ef40e-44d1-4289-a2d0-d8ebb3a9121c")
    public int getPriority() {
        return 10;
    }

}
