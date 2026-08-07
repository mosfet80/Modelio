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
package org.modelio.platform.model.ui.panels.search.common;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;

/**
 * Dialog for picking a metamodel dependency (MClass + MDependency).
 * <p>
 * Contains a {@link MetaclassSelectorWidget} and a {@link ComboViewer} listing
 * the MDependencies of the selected metaclass. On OK, the selected dependency
 * name is returned via {@link #openDialog()}.
 */
@objid ("007660e9-a4a3-4f75-95da-9306649c5efa")
public class MqlDependencyPickerDialog extends ModelioDialog2 {
    /**
     * Result: the selected dependency name, or {@code null} if cancelled.
     */
    @objid ("294b4742-87dd-4313-b70a-31ec6e8fb311")
    private String result;

    @objid ("736b013f-122a-4df5-a268-816c77ed7b39")
    private ComboViewer mdependencyCombo;

    @objid ("9d7896ce-77d3-4af4-8769-70f2c7975867")
    private final ICoreSession session;

    @objid ("70835b42-1c92-4f26-ade3-b999be587f41")
    private final MetamodelHelper metamodelHelper;

    @objid ("5f99d9e0-770d-4c05-a138-3cc796cd24c4")
    private MetaclassSelectorWidget metaclassSelector;

    @objid ("049b406b-4c6e-4e3c-8f12-dde62265ba3e")
    public MqlDependencyPickerDialog(Shell parentShell, ICoreSession session, MetamodelHelper metamodelHelper) {
        super(parentShell);
        this.session = session;
        this.metamodelHelper = metamodelHelper;
    }

    @objid ("4b90ab67-3f37-4ec2-bf5c-bb4be725c679")
    @Override
    protected void okPressed() {
        IStructuredSelection sel = (IStructuredSelection) this.mdependencyCombo.getSelection();
        if (sel != null && !sel.isEmpty() && sel.getFirstElement() instanceof MDependency) {
            this.result = ((MDependency) sel.getFirstElement()).getName();
        }
        super.okPressed();
    }

    @objid ("352e16ab-b0d7-49c6-aa7d-b7987e5653e8")
    @Override
    protected Control createContentArea(Composite parent) {
        parent.setBackground(UIColor.WHITE);
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        container.setLayout(new GridLayout(1, true));
        PolluxWidgetConfigurator.configureContainer(container);
        ((GridLayout) container.getLayout()).verticalSpacing = 5;
        ((GridLayout) container.getLayout()).marginRight=10;
        ((GridLayout) container.getLayout()).marginLeft=10;


        Label selectionLabel = new Label(container, SWT.NONE);
        selectionLabel.setText(CoreUi.I18N.getString("MqlDependencyPickerDialog.metaclassselector.label"));
        PolluxWidgetConfigurator.configureSubtitleField(selectionLabel);

        this.metaclassSelector = new MetaclassSelectorWidget(this.session, selectedType -> {
            if(selectedType instanceof MClass) {
                this.mdependencyCombo.setInput(this.metamodelHelper.getMDependencyByMetaclass(((MClass)selectedType).getQualifiedName()));
            }else if(selectedType instanceof Stereotype){
                this.mdependencyCombo.setInput(this.metamodelHelper.getMDependencyByMetaclass(((Stereotype)selectedType).getBaseClassName()));
            }
        });
        this.metaclassSelector.createControls(container);


        Label edgeSubLabel = new Label(container, SWT.NONE);
        edgeSubLabel.setText(CoreUi.I18N.getString("MqlDependencyPickerDialog.edgeselection.label"));
        PolluxWidgetConfigurator.configureSubtitleField(edgeSubLabel);

        Label edgeLbl = new Label(container, SWT.NONE);
        edgeLbl.setText(CoreUi.I18N.getString("MqlDependencyPickerDialog.edge.label"));

        this.mdependencyCombo = new ComboViewer(container, SWT.BORDER | SWT.READ_ONLY);
        this.mdependencyCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.mdependencyCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.mdependencyCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof MDependency) {
                    MDependency dep = (MDependency) element;
                    String text = "";
                    if (dep.isComposition()) {
                        text = CoreUi.I18N.getString("MqlDependencyPickerDialog.edgeselection.edge.composition") + " : ";
                    } else if (dep.getSymetric().isComposition()) {
                        text = CoreUi.I18N.getString("MqlDependencyPickerDialog.edgeselection.edge.compositionSymetric") + " : ";
                    }
                    text = text + dep.getName();
                    text = text + " (" + dep.getTarget().getName().substring(dep.getTarget().getName().indexOf(".") + 1) + ")";
                    return text;
                }
                return super.getText(element);
            }
        });
        PolluxWidgetConfigurator.configureSimpleCompositeField(container,edgeLbl,this.mdependencyCombo.getControl(),null);

        this.metaclassSelector.setInput(null);
        this.mdependencyCombo.setInput(this.metamodelHelper.getMDependencyByMetaclass("Standard.Package"));

        return container;
    }

    @objid ("c201808f-4221-4298-b730-2b12137eb5f0")
    @Override
    public void addButtonsInButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    @objid ("c6085b0b-d16c-45be-b039-0a0c68e0ca5e")
    @Override
    protected void init() {
        getShell().setText(CoreUi.I18N.getString("MqlDependencyPickerDialog.title"));
        setTitle(CoreUi.I18N.getString("MqlDependencyPickerDialog.title"));
    }

    @objid ("a5a597ac-ce08-41c3-94be-34382807865f")
    public String getResult() {
        return this.result;
    }

}
