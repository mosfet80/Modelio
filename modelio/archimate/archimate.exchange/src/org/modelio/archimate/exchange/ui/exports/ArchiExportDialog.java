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
package org.modelio.archimate.exchange.ui.exports;

import java.io.File;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.api.ui.ModelioDialog;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy.ExchangeFormatVersion;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

@objid ("bc31d780-fa4c-43cd-a65b-be2a5b47a4be")
class ArchiExportDialog extends ModelioDialog2 {
    @objid ("3f1d5a3d-4f74-4475-ac54-53e36d802b90")
    private boolean isDirectory;

    @objid ("69d306dc-937a-49cb-86c4-c8b33563f490")
    private Composite composite = null;

    @objid ("f26b9a36-8a6c-48fb-a406-72fca194cd60")
    private Text exportPathText;

    @objid ("1efb4583-3e50-4e89-bc03-1b20491192ff")
    private Button selectFileButton = null;

    @objid ("6f36bb8e-4e0a-4cc8-8233-78c1fde6ba14")
    private Button okButton;

    @objid ("caa9dffe-90a5-4f7d-b708-19c7ad584d01")
    private ComboViewer versionSelection;

    @objid ("bbc4d45e-c4c3-4610-b897-e1556d5e67f5")
    private Controller controller;

    @objid ("9fdbe3e9-bc54-4fe0-a6ca-306310e83589")
    private ArchiExportModel model;

    @objid ("2912d37f-1a11-46f4-b1f4-dcf991b48383")
    public ArchiExportDialog(Shell parentShell, ArchiExportModel model, boolean isDirectory) {
        super(parentShell);
        setShellStyle(SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX);
        this.controller = new Controller(this, model, isDirectory);
        this.model = model;
        this.isDirectory = isDirectory;
    }

    @objid ("e8836a41-da72-4fd7-944d-5f853e18f033")
    @Override
    public void addButtonsInButtonBar(Composite parent) {
        this.okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        this.okButton.setEnabled(false);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    @objid ("6c7c5951-bc23-430d-b5df-1b2d9c50a7e4")
    @Override
    public Control createContentArea(Composite parent) {
        this.composite = new Composite(parent, SWT.NONE);
        GridData gd = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL);
        this.composite.setLayoutData(gd);
        this.composite.setFont(parent.getFont());
        PolluxWidgetConfigurator.configureContainer(this.composite);

        // Action group
        Composite generateGroup = createActionGroup(this.composite);
        generateGroup.setLayoutData(new GridData(GridData.FILL_BOTH));
        return this.composite;
    }

    @objid ("e5831dfd-e72e-4dc1-9cf4-3f3c75adfcaa")
    @Override
    public void init() {
        Shell shell = getShell();

        shell.setText(ArchiExchange.I18N.getMessage("ui.command.export.title"));
        setTitle(ArchiExchange.I18N.getMessage("ui.command.export.message"));

        update();

        addListeners();
    }

    @objid ("99c232b3-151f-4ca6-8f5f-c1b3b7498753")
    public void update() {
        if (this.model.getExportPath() != null) {
            this.exportPathText.setText(this.model.getExportPath());
            this.okButton.setEnabled(true);
        } else {
            this.okButton.setEnabled(false);
        }
    }

    @objid ("08d98f6f-ad19-425e-a9c2-6fbe3ed30c54")
    @Override
    protected Point getInitialSize() {
        return new Point(600, 250);
    }

    @objid ("61132f3f-f058-4a56-8584-cf799fd35bd4")
    private void addListeners() {
        this.selectFileButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                ArchiExportDialog.this.controller.onSelectSelectFile();
            }
        });

        this.versionSelection.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                ArchiExportDialog.this.controller.onSelectVersion((ExchangeFormatVersion) selection.getFirstElement());
            }
        });
    }

    @objid ("bb97c62d-55b6-4454-ba26-a80728f51f29")
    private Composite createActionGroup(Composite parent) {
        GridData gd = null;

        // Archive
        Label exportPathLabel = new Label(parent, SWT.NONE);
        gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        gd.horizontalAlignment = GridData.FILL;
        gd.minimumHeight = 200;
        exportPathLabel.setLayoutData(gd);
        if (this.isDirectory) {
            exportPathLabel.setText(ArchiExchange.I18N.getMessage("ui.command.export.selectdirectory.label"));
        } else {
            exportPathLabel.setText(ArchiExchange.I18N.getMessage("ui.command.export.selectfile.label"));
        }
        PolluxWidgetConfigurator.configureStyleForFieldLabel(exportPathLabel);


        Composite fileComposite = new Composite(parent, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalIndent = - 5;
        fileComposite.setLayout(new GridLayout(2, false));
        fileComposite.setLayoutData(gd);
        PolluxWidgetConfigurator.configureStyleForFieldCaption(fileComposite);

        this.exportPathText = new Text(fileComposite, SWT.BORDER);
        gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.horizontalAlignment = GridData.FILL;
        this.exportPathText.setLayoutData(gd);
        this.exportPathText.setEditable(false);
        this.exportPathText.setText(this.model.getExportPath());
        PolluxWidgetConfigurator.configureStyleForFieldLabel(this.exportPathText);

        this.selectFileButton = new Button(fileComposite, SWT.FLAT);
        this.selectFileButton.setImage(UIImages.FILECHOOSE);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false);
        gd.horizontalAlignment = GridData.FILL;
        this.selectFileButton.setLayoutData(gd);
        this.selectFileButton.setFocus();
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.selectFileButton);

        Label versionLabel = new Label(parent, SWT.NONE);
        gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        gd.horizontalAlignment = GridData.FILL;
        gd.minimumHeight = 200;
        versionLabel.setLayoutData(gd);
        versionLabel.setText(ArchiExchange.I18N.getMessage("ui.command.export.version.label"));
        PolluxWidgetConfigurator.configureStyleForFieldLabel(versionLabel);

        this.versionSelection = new ComboViewer(parent, SWT.READ_ONLY);
        gd = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gd.horizontalSpan = 2;
        gd.minimumWidth = 150;
        this.versionSelection.getCombo().setLayoutData(gd);
        this.versionSelection.setContentProvider(ArrayContentProvider.getInstance());
        this.versionSelection.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof ExchangeFormatVersion) {
                    if (element.equals(ExchangeFormatVersion.V21)) {
                        return ArchiExchange.I18N.getMessage("ui.command.export.selectversion.v21.label");
                    } else if (element.equals(ExchangeFormatVersion.V30)) {
                        return ArchiExchange.I18N.getMessage("ui.command.export.selectversion.v30.label");
                    }else if (element.equals(ExchangeFormatVersion.V31)) {
                        return ArchiExchange.I18N.getMessage("ui.command.export.selectversion.v31.label");
                    }
                }
                return super.getText(element);
            }
        });
        this.versionSelection.add(ExchangeFormatVersion.V31);
        this.versionSelection.add(ExchangeFormatVersion.V30);
        this.versionSelection.add(ExchangeFormatVersion.V21);
        this.versionSelection.setSelection(new StructuredSelection(this.model.getVersion()));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.versionSelection.getControl());

        return parent;
    }

    @objid ("9529fd50-bbf7-4173-8694-dbe4511fa95a")
    private static class Controller {
        @objid ("8df44697-07ad-45c3-817d-34007dd71263")
        private boolean isDirectory;

        @objid ("64596e4e-e969-4063-a2ba-dd5e39a032be")
        private ArchiExportDialog dlg;

        @objid ("2a719502-3f2f-4f2a-b267-9e984dcc17b7")
        private ArchiExportModel model;

        @objid ("b55d016d-4887-495d-ba21-006cf04cfd45")
        public Controller(ArchiExportDialog dlg, ArchiExportModel model, boolean isDirectory) {
            this.dlg = dlg;
            this.model = model;
            this.isDirectory = isDirectory;
        }

        @objid ("88663849-08d2-43cf-b62f-c669be4359ca")
        public void onSelectVersion(ExchangeFormatVersion version) {
            this.model.setVersion(version);
        }

        @objid ("973d7f3a-6cc0-4f26-941e-29f7a56fa57e")
        public void onSelectSelectFile() {
            if (this.isDirectory) {
                DirectoryDialog dialog = new DirectoryDialog(new Shell(), SWT.SAVE);
                dialog.setText(ArchiExchange.I18N.getMessage("ui.command.export.description"));
                dialog.setFilterPath(this.model.getExportPath());

                String path = dialog.open();
                if (path != null) {
                    this.model.setExportPath(path);
                }
            } else {
                FileDialog dialog = new FileDialog(new Shell(), SWT.SAVE);
                dialog.setFilterExtensions(new String[] { "*.xml" });
                dialog.setFilterNames(new String[] { "*.xml" });
                dialog.setText(ArchiExchange.I18N.getMessage("ui.command.export.description"));
                dialog.setFileName(new File(this.model.getExportPath()).getName());
                dialog.setFilterPath(this.model.getExportPath());
                String path = dialog.open();

                if (path != null) {
                    this.model.setExportPath(path);
                }
            }

            this.dlg.update();
        }

    }

}
