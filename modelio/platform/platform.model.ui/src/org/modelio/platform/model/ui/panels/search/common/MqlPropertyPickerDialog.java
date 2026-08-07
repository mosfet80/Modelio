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

import java.util.Comparator;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
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
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper.MPropertyInfo;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * Dialog for picking a metamodel property (MClass + propertyName).
 * <p>
 * Contains a {@link MetaclassSelectorWidget} and a {@link ComboViewer} listing
 * the MDependencies of the selected metaclass. On OK, the selected dependency
 * name is returned via {@link #openDialog()}.
 */
@objid ("7619efaa-0f33-438b-8636-c855b5b34b51")
public class MqlPropertyPickerDialog extends ModelioDialog2 {
    @objid ("84708861-ef08-45f6-88a1-53dfa9cc4780")
    private ComboViewer propertyCombo;

    /**
     * Result: the selected dependency name, or {@code null} if cancelled.
     */
    @objid ("1ceb20a5-89ff-4135-bec0-b5eee236b5e9")
    private MPropertyInfo result;

    @objid ("7a84d498-4007-4f3c-9b6c-35606f2afb58")
    private final ICoreSession session;

    @objid ("2320cf70-0729-4b79-8962-d10a00d4e31f")
    private final MetamodelHelper metamodelHelper;

    @objid ("d8b5e017-c079-4abd-ad4c-79d3323fdfc4")
    private MetaclassSelectorWidget metaclassSelector;

    @objid ("5c6af023-6f28-41c5-a7b5-d6738b3cad83")
    public MqlPropertyPickerDialog(Shell parentShell, ICoreSession session, MetamodelHelper metamodelHelper) {
        super(parentShell);
        this.session = session;
        this.metamodelHelper = metamodelHelper;
    }

    @objid ("d92574be-5b85-4251-8a65-b0e2299219a0")
    @Override
    protected void okPressed() {
        IStructuredSelection sel = (IStructuredSelection) this.propertyCombo.getSelection();
        if (sel != null && !sel.isEmpty() && sel.getFirstElement() instanceof MPropertyInfo) {
            this.result = ((MPropertyInfo) sel.getFirstElement());
        }
        super.okPressed();
    }

    @objid ("61617303-3800-47c3-8f24-125390c38b8a")
    @Override
    protected Control createContentArea(Composite parent) {
        parent.setBackground(UIColor.WHITE);
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        container.setLayout(new GridLayout(1, true));
        PolluxWidgetConfigurator.configureContainer(container);
        ((GridLayout) container.getLayout()).verticalSpacing = 5;
        ((GridLayout) container.getLayout()).marginRight = 10;
        ((GridLayout) container.getLayout()).marginLeft = 10;

        Label selectionLabel = new Label(container, SWT.NONE);
        selectionLabel.setText(CoreUi.I18N.getString("MqlPropertyPickerDialog.metaclassselector.label"));
        PolluxWidgetConfigurator.configureSubtitleField(selectionLabel);

        this.metaclassSelector = new MetaclassSelectorWidget(this.session, selection -> {
            if (selection instanceof MClass) {
                List<MPropertyInfo> properties = this.metamodelHelper.getAllAttributesByMetaclass((MClass) selection);
                properties = properties.stream().sorted(new Comparator<MPropertyInfo>() {
                    @Override
                    public int compare(MPropertyInfo o1, MPropertyInfo o2) {
                        return o1.label().compareTo(o2.label());
                    }
                }).toList();
                this.propertyCombo.setInput(properties);
            } else if (selection instanceof Stereotype) {
                List<MPropertyInfo> properties = this.metamodelHelper.getAllAttributesByStereotype((Stereotype) selection);
                properties = properties.stream().sorted(new Comparator<MPropertyInfo>() {
                    @Override
                    public int compare(MPropertyInfo o1, MPropertyInfo o2) {
                        return o1.label().compareTo(o2.label());
                    }
                }).toList();
                this.propertyCombo.setInput(properties);
            }
        });
        this.metaclassSelector.createControls(container);

        Label propertySubLabel = new Label(container, SWT.NONE);
        propertySubLabel.setText(CoreUi.I18N.getString("MqlPropertyPickerDialog.propertySelection.label"));
        PolluxWidgetConfigurator.configureSubtitleField(propertySubLabel);

        Label edgeLbl = new Label(container, SWT.NONE);
        edgeLbl.setText(CoreUi.I18N.getString("MqlPropertyPickerDialog.property.label"));

        this.propertyCombo = new ComboViewer(container, SWT.BORDER | SWT.READ_ONLY);
        this.propertyCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.propertyCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.propertyCombo.setLabelProvider(new LabelProvider() {

            @Override
            public String getText(Object element) {
                if (element instanceof MPropertyInfo) {
                    return ((MPropertyInfo) element).label();
                }
                return super.getText(element);
            }
        });
        PolluxWidgetConfigurator.configureSimpleCompositeField(container, edgeLbl, this.propertyCombo.getControl(), null);

        this.metaclassSelector.setInput(null);

        MClass baseClass = this.metamodelHelper.getMClassByName("Standard.Package");
        List<MPropertyInfo> properties = this.metamodelHelper.getAllAttributesByMetaclass(baseClass);
        properties = properties.stream().sorted(new Comparator<MPropertyInfo>() {
            @Override
            public int compare(MPropertyInfo o1, MPropertyInfo o2) {
                return o1.label().compareTo(o2.label());
            }
        }).toList();
        this.propertyCombo.setInput(properties);

        return container;
    }

    @objid ("582b97cb-bd87-44ba-b088-aa6edf4f1cdb")
    @Override
    public void addButtonsInButtonBar(final Composite parent) {
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    }

    @objid ("9ad3ad83-478d-4512-b82a-d3f6e79e0b34")
    @Override
    protected void init() {
        getShell().setText(CoreUi.I18N.getString("MqlDependencyPickerDialog.title"));
        setTitle(CoreUi.I18N.getString("MqlDependencyPickerDialog.title"));
    }

    @objid ("a719d8fa-5462-4a9b-884e-4738c56233e1")
    public MPropertyInfo getResult() {
        return this.result;
    }

}
