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
package org.modelio.platform.model.ui.panels.search.advanced.datas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper.MPropertyInfo;
import org.modelio.platform.model.ui.panels.search.common.PropertyOperator;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.ValueType;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;

@objid ("beb7b997-ea14-4653-b47b-931ac53beb8e")
public class PropertyCriterionDialog extends ModelioDialog2 {
    @objid ("40e52bf0-6771-4dd0-89d3-e7c0d4ea9eff")
    private ComboViewer propertyCombo;

    @objid ("3a539999-5122-42a3-a642-32ad0e94927c")
    private ComboViewer operatorCombo;

    @objid ("913ac5fc-ea15-4f3c-bd44-e72a743c63f2")
    private Text valueText;

    @objid ("051bb39e-5a0b-4f3f-84f8-e2565f75daf5")
    private Combo typeCombo;

    @objid ("a4c46253-d23d-4eb6-bcfc-d30eab356abc")
    private MClass metaclass;

    @objid ("ac26b7e9-fb42-4be2-9796-afeb13beb1e5")
    private ICoreSession session;

    @objid ("6721132d-9b42-4cc2-85b6-0234f5ead132")
    private Stereotype stereotype;

    @objid ("f74a6e16-b221-4c44-bdea-326083cc71aa")
    private PropertyCriterion result;

    @objid ("7e9ad9d8-dbf4-418d-8a7e-8f0a27c3a1ba")
    private MetamodelHelper metamodelhelper;

    @objid ("2f3fab84-4dc8-41c6-a1eb-3da8ecaad10e")
    public PropertyCriterionDialog(Shell parentShell, MClass metaclass, ICoreSession session, Stereotype stereotype, MetamodelHelper metamodelhelper) {
        super(parentShell);
        this.metaclass = metaclass;
        this.session = session;
        this.stereotype = stereotype;
        this.metamodelhelper = metamodelhelper;
    }

    @objid ("3fa08a1e-264a-4f09-a6b1-2667f0b87a30")
    @Override
    protected void okPressed() {
        MPropertyInfo selectedProp = (MPropertyInfo)((IStructuredSelection) this.propertyCombo.getSelection()).getFirstElement();
        PropertyOperator selectedOp = (PropertyOperator) ((IStructuredSelection) this.operatorCombo.getSelection()).getFirstElement();
        this.result = new PropertyCriterion(selectedProp.label(), selectedOp, this.valueText.getText(), selectedProp);
        super.okPressed();
    }

    @objid ("f3fbef6f-b70a-466d-b95f-9b5347b04489")
    public PropertyCriterion getResult() {
        return this.result;
    }

    @objid ("e00daec6-b133-4bbf-9931-1774d1f808d0")
    @Override
    protected void addButtonsInButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true).setEnabled(false);
    }

    @objid ("40fcbd79-5b74-4f8d-8b2f-4296cf267dad")
    @Override
    protected Control createContentArea(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        PolluxWidgetConfigurator.configureContainer(container);

        // Property selection
        Label propLabel = new Label(container, SWT.NONE);
        propLabel.setText(CoreUi.I18N.getString("PropertyCriterion.Property.label"));

        this.propertyCombo = new ComboViewer(container, SWT.READ_ONLY | SWT.BORDER);
        this.propertyCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.propertyCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.propertyCombo.addSelectionChangedListener(e -> validate());
        this.propertyCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if(element instanceof MPropertyInfo) {
                    return ((MPropertyInfo) element).label();
                }
                return super.getText(element);
            }
        });

        PolluxWidgetConfigurator.configureSimpleField(propLabel, this.propertyCombo.getControl(), null);

        List<MPropertyInfo> allProperties = new ArrayList<MPropertyInfo>();
        if(this.stereotype != null) {
            allProperties.addAll(this.metamodelhelper.getAllAttributesByStereotype(this.stereotype));
        }else {
            allProperties.addAll(this.metamodelhelper.getAllAttributesByMetaclass(this.metaclass));
        }

        this.propertyCombo.setInput(allProperties);

        // Operator selection
        Label opLabel = new Label(container, SWT.NONE);
        opLabel.setText(CoreUi.I18N.getString("PropertyCriterion.Operator.label"));

        this.operatorCombo = new ComboViewer(container, SWT.READ_ONLY | SWT.BORDER);
        this.operatorCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.operatorCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.operatorCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof PropertyOperator) {
                    return ((PropertyOperator) element).label;
                }
                return super.getText(element);
            }
        });
        this.operatorCombo.setInput(PropertyOperator.values());
        this.operatorCombo.addSelectionChangedListener(e -> validate());
        PolluxWidgetConfigurator.configureSimpleField(opLabel, this.operatorCombo.getControl(), null);

        Label valueTypeLabel = new Label(container, SWT.NONE);
        valueTypeLabel.setText(CoreUi.I18N.getString("PropertyCriterion.Type.label"));
        GridData valueTypeGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        valueTypeLabel.setLayoutData(valueTypeGd);

        this.typeCombo = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        this.typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.typeCombo.setItems(Arrays.stream(ValueType.values()).map(ValueType::getJsonValue).toArray(String[]::new));
        this.typeCombo.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            @Override
            public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
                validate();
            }
        });
        PolluxWidgetConfigurator.configureSimpleField(valueTypeLabel, this.typeCombo, null);

        // Value input
        Label valueLabel = new Label(container, SWT.NONE);
        valueLabel.setText(CoreUi.I18N.getString("PropertyCriterion.Value.label"));
        this.valueText = new Text(container, SWT.BORDER);
        this.valueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.valueText.addModifyListener(e -> validate());

        PolluxWidgetConfigurator.configureSimpleField(valueLabel, this.valueText, null);

        return container;
    }

    @objid ("48100437-4165-46c4-914b-2d60da8ccbeb")
    @Override
    protected void init() {
        getShell().setText(CoreUi.I18N.getString("PropertyCriterion.Dialog.title"));
        setTitle(CoreUi.I18N.getString("PropertyCriterion.Dialog.title"));
    }

    @objid ("3ba22544-914c-4392-bb6a-52c97f651db3")
    protected void validate() {
        boolean isValid = this.propertyCombo.getSelection() != null && !this.propertyCombo.getSelection().isEmpty()
                && this.operatorCombo.getSelection() != null && !this.operatorCombo.getSelection().isEmpty()
                && this.typeCombo.getSelectionIndex() >= 0
                && !this.valueText.getText().trim().isEmpty();

        getButton(IDialogConstants.OK_ID).setEnabled(isValid);
    }

}
