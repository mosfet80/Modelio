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
package org.modelio.platform.model.ui.panels.search.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.platform.model.ui.panels.search.IPanelValidationListener;
import org.modelio.platform.model.ui.panels.search.ISearchController;
import org.modelio.platform.model.ui.panels.search.ISearchPanel;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.model.ui.swt.selectmetaclass.multiple.IMultipleMetaclassSelectorListener;
import org.modelio.platform.model.ui.swt.selectmetaclass.multiple.MultipleMetaclassSelector;
import org.modelio.platform.search.engine.api.ISearchCriteria;
import org.modelio.platform.search.engine.searchers.model.ModelSearchCriteria;
import org.modelio.platform.ui.UIFont;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * Model search criteria panel. It is composed of:
 * <ul>
 * <li>a name pattern field</li>
 * <li>a multiple metaclass selector</li>
 * <li>a checkbox to include or not the 'ramc' elements</li<<li>a text field to enter a (unique) stereotype name</li>
 * </ul>
 */
@objid ("53e74d23-1a1a-44df-ab92-66cdaf9960f0")
public class ModelSearchPanel implements ISearchPanel {
    @objid ("a123d982-779a-4e25-ba64-86999a4b5fc6")
    public static final String[] DEFAULT_SEARCH_METACLASSES = {
                "Archimate.Element",
                NameSpace.MQNAME,
                BpmnFlowNode.MQNAME,
                BpmnProcess.MQNAME,
                "Analyst.AnalystElement"
        };

    @objid ("34f6e7c6-c124-43b2-b1b3-dea9bbf8282c")
    private Group topGroup;

    @objid ("9b7c806d-d530-409f-a784-58661fd2314a")
    private ComboViewer expressionCombo;

    @objid ("e7b735d6-6534-420d-92e3-dc04487acafe")
    private Button includeRamcCheckBox;

    @objid ("c55a08ed-eec1-47a7-a475-56139457f3fa")
    private Button caseSensitiveCheckBox;

    @objid ("9ffddf1e-f00d-4f3f-9e8d-62109ea50c8f")
    private Text stereotypeText;

    @objid ("860e0d57-f1ab-4bb7-a823-4e1ffb0bab0d")
    private ModelSearchCriteria searchCriteria;

    @objid ("7931b878-267b-4948-80ea-6ce8b440c33f")
    private static List<ModelSearchCriteria> searchHistory = new ArrayList<>();

    @objid ("20d84b83-2aeb-4d39-bcfd-87ed00b6ad11")
    protected ISearchController searchController;

    @objid ("9270f8ab-7da1-4484-8926-ef3078bf6b99")
    private MultipleMetaclassSelector metaclassSelector;

    @objid ("7c80a2ea-df62-4629-9fe0-48077daeabac")
    private SmMetamodel metamodel;

    @objid ("adea39e7-a628-4e28-86df-a75b20afd176")
    @Override
    public void initialize(Composite parent, ICoreSession session, ISearchController theSearchController, ESelectionService selectionService, IPanelValidationListener validationListener) {
        this.searchController = theSearchController;
        this.metamodel = session.getMetamodel();

        this.topGroup = new Group(parent, SWT.NONE);
        this.topGroup.setText(CoreUi.I18N.getString("ModelSearch.CriteriaGroup.label")); //$NON-NLS-1$
        this.topGroup.setFont(UIFont.NORMALB);

        final GridLayout gridLayout = new GridLayout();
        gridLayout.verticalSpacing = 1;
        gridLayout.marginWidth = 2;
        GridData gridData = null;
        gridLayout.numColumns = 3;
        this.topGroup.setLayout(gridLayout);

        // The name pattern field and its label
        final Label nameLabel = new Label(this.topGroup, SWT.NONE);
        nameLabel.setText(CoreUi.I18N.getString("ModelSearch.NamePattern.label")); //$NON-NLS-1$
        this.expressionCombo = new ComboViewer(this.topGroup, SWT.BORDER);

        gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
        this.expressionCombo.getCombo().setLayoutData(gridData);
        this.expressionCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.expressionCombo.getCombo().setToolTipText(CoreUi.I18N.getString("ModelSearch.NamePattern.tooltip"));
        this.expressionCombo.setLabelProvider(new org.eclipse.jface.viewers.LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((ModelSearchCriteria) element).getExpression();
            }
        });

        // Prevent CR from going to the default button
        this.expressionCombo.getCombo().addTraverseListener(new TraverseListener() {
            @Override
            public void keyTraversed(TraverseEvent e) {
                if (e.detail == SWT.TRAVERSE_RETURN) {
                    e.doit = false;
                    e.detail = SWT.TRAVERSE_NONE;
                }
            }
        });

        this.expressionCombo.getCombo().addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent e) {
                final Combo text = (Combo) e.getSource();
                if (ModelSearchCriteria.isValidExpression(text.getText())) {
                    text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND));
                } else {
                    text.setForeground(text.getDisplay().getSystemColor(SWT.COLOR_RED));
                }
            }
        });

        this.expressionCombo.getCombo().addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
                    ModelSearchPanel.this.searchController.runSearch();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // do nothing
            }
        });
        this.expressionCombo.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ModelSearchCriteria value = (ModelSearchCriteria) ((IStructuredSelection) event.getSelection()).getFirstElement();
                if(!value.equals(searchCriteria))
                    setCriteria(value);
            }
        });

        this.caseSensitiveCheckBox = new Button(this.topGroup, SWT.CHECK);
        this.caseSensitiveCheckBox.setText("");
        this.caseSensitiveCheckBox.setToolTipText(CoreUi.I18N.getString("ModelSearch.NameCase.tooltip"));
        gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
        this.caseSensitiveCheckBox.setLayoutData(gridData);

        this.caseSensitiveCheckBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // TODO Auto-generated method stub
                super.widgetSelected(e);
                ModelSearchPanel.this.searchController.runSearch();
            }
        });

        // The metaclass selector
        final Label metaclassLabel = new Label(this.topGroup, SWT.NONE);
        metaclassLabel.setText(CoreUi.I18N.getString("ModelSearch.MetaclassSelector.label")); //$NON-NLS-1$
        this.metaclassSelector = new MultipleMetaclassSelector(this.topGroup, SWT.BORDER, this.metamodel);
        gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
        gridData.widthHint = 650;
        this.metaclassSelector.getControl().setLayoutData(gridData);
        this.metaclassSelector.addListener(new IMultipleMetaclassSelectorListener() {
            @Override
            public void selectMetaclasses(List<MClass> mClasses) {
                ModelSearchPanel.this.searchController.runSearch();
            }
        });
        new Label(this.topGroup, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        // The 'stereotype' criterion
        final Label stereotypeLabel = new Label(this.topGroup, SWT.NONE);
        stereotypeLabel.setText(CoreUi.I18N.getString("ModelSearch.Stereotype.label")); //$NON-NLS-1$

        this.stereotypeText = new Text(this.topGroup, SWT.SINGLE | SWT.BORDER);
        gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        this.stereotypeText.setLayoutData(gridData);
        this.stereotypeText.setToolTipText(CoreUi.I18N.getString("ModelSearch.Stereotype.tooltip"));

        new Label(this.topGroup, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        // The 'include ramc' option
        final Label includeRamcLabel = new Label(this.topGroup, SWT.NONE);
        includeRamcLabel.setText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.label")); //$NON-NLS-1$

        this.includeRamcCheckBox = new Button(this.topGroup, SWT.CHECK);
        this.includeRamcCheckBox.setToolTipText(CoreUi.I18N.getString("ModelSearch.IncludeRamc.tooltip")); //$NON-NLS-1$
        gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        this.includeRamcCheckBox.setLayoutData(gridData);

        new Label(this.topGroup, SWT.NONE).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

        this.includeRamcCheckBox.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                super.widgetSelected(e);
                ModelSearchPanel.this.searchController.runSearch();
            }
        });

        // Setup default values for criteria
        setCriteria(getDefaultCriteria());
    }

    @objid ("19cb47c3-a4c1-41c4-9b02-b68d8658c26c")
    private ISearchCriteria getDefaultCriteria() {
        final ModelSearchCriteria defaultCriteria = new ModelSearchCriteria();
        defaultCriteria.setExpression(".*");
        defaultCriteria.setStereotype("");
        defaultCriteria.setIncludeRamc(false);

        if(searchHistory.size() > 0) {
            defaultCriteria.getMetaclasses().addAll(searchHistory.get(0).getMetaclasses());
        }else {
            for (String smcName : ModelSearchPanel.DEFAULT_SEARCH_METACLASSES) {
                SmClass mc = metamodel.getMClass(smcName);
                if (mc != null)
                    defaultCriteria.addMetaclass(mc);
            }
        }

        return defaultCriteria;
    }

    @objid ("2085432e-37ae-4207-ba2c-b183395a0477")
    @Override
    public Control getControl() {
        return this.topGroup;
    }

    @objid ("d042b204-a503-4bd4-8d1d-b0de28fd9fe0")
    @Override
    public ISearchCriteria getCriteria() {
        this.searchCriteria.reset();
        this.searchCriteria.setExpression(this.expressionCombo.getCombo().getText());
        this.searchCriteria.setIncludeRamc(this.includeRamcCheckBox.getSelection());

        for (MClass mc : this.metaclassSelector.getSelected())
            this.searchCriteria.addMetaclass(mc);

        this.searchCriteria.setStereotype(this.stereotypeText.getText().trim());
        this.searchCriteria.setCaseSensitive(this.caseSensitiveCheckBox.getSelection());


        if(searchHistory.size() > 0 && searchHistory.get(0).getExpression().equals(this.searchCriteria.getExpression())) {
            searchHistory.remove(0);
        }
        searchHistory.add(0, this.searchCriteria);

        return this.searchCriteria;
    }

    @objid ("d1f57fd9-6576-4b34-ae48-d371eac5705e")
    @Override
    public void setCriteria(ISearchCriteria searchCriteria) {
        if(searchCriteria == null || !(searchCriteria instanceof ModelSearchCriteria)) {
            return;
        }

        ModelSearchCriteria criteria = (ModelSearchCriteria) searchCriteria;

        this.searchCriteria = criteria;

        List<ModelSearchCriteria> newCrt = new ArrayList<ModelSearchCriteria>(this.searchHistory);
        newCrt.add(0,(ModelSearchCriteria)searchCriteria);

        this.expressionCombo.setInput(newCrt);
        this.expressionCombo.setSelection(new StructuredSelection(searchCriteria));
        this.includeRamcCheckBox.setSelection(criteria.isIncludeRamc());

        this.stereotypeText.setText(criteria.getStereotype() != null ? criteria.getStereotype() : "");
        this.caseSensitiveCheckBox.setSelection(this.searchCriteria.isCaseSensitive());

        if(searchHistory.size() > 0 ) {
            this.metaclassSelector.setSelected(searchHistory.get(0).getMetaclasses().stream()
                    .map(o -> metamodel.getMClass(o))
                    .collect(Collectors.toList()));
        }else {
            this.metaclassSelector.setSelected(criteria.getMetaclasses().stream()
                    .map(o -> metamodel.getMClass(o))
                    .collect(Collectors.toList()));
        }
    }

}
