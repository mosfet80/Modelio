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
package org.modelio.archimate.exchange.ui.imports;

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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.ArchimateExchangeProxy.ExchangeFormatVersion;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.ModelioDialog2;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

@objid ("497d15b8-ca6a-454c-8949-e935fa6273ea")
class ArchiImportDialog extends ModelioDialog2 {
    @objid ("0e7a176e-0217-4069-8d3b-ceceb9d5108b")
    private Composite composite = null;

    @objid ("2920fad1-61da-4e4a-9b9e-cb4334407d14")
    private Text filePathText;

    @objid ("3d9fbc5f-2bdc-4941-8bd7-89cb13cba75a")
    private Button selectFileButton = null;

    /* @objid ("69e0a8ba-ed10-43ca-ba46-29389b6edf7e")
     private Button keepIdCheckBox;*/
    @objid ("34c5622d-ebbf-43d4-99b3-a726f3cdb427")
    private Button okButton;

    @objid ("26f69ba0-2a66-433b-9588-f2e2da3b9b2f")
    private ComboViewer versionSelection;

    @objid ("60eb6c53-4652-4358-9b3c-5b7402448168")
    private Button applyNativeStyleCheckBox;

    @objid ("164a6394-3519-47f6-a7eb-a67ffcc69cfe")
    private Controller controller;

    @objid ("06859538-4c74-4d62-88fb-865143175366")
    private ArchiImportModel model;

    @objid ("abbfc71e-ecf5-4765-a1d7-d84baaab5c73")
    public ArchiImportDialog(Shell parentShell, ArchiImportModel model) {
        super(parentShell);
        this.setShellStyle(SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX);
        this.controller = new Controller(this, model);
        this.model = model;
    }

    @objid ("f9e98113-9f6f-4982-ac46-0400c4d78b1c")
    @Override
    public void addButtonsInButtonBar(Composite parent) {
        this.okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        this.okButton.setEnabled(false);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }

    @objid ("c3468220-04fb-4fb2-bdcb-24fc0e4c94cb")
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

    @objid ("4780db45-44ba-4a2a-8284-81c1ab68ca55")
    @Override
    public void init() {
        Shell shell = this.getShell();

        shell.setText(ArchiExchange.I18N.getMessage("ui.command.import.title"));
        setTitle(ArchiExchange.I18N.getMessage("ui.command.import.message"));

        addListeners();
    }

    @objid ("78fd4b57-4610-4124-a0e8-fe1155e62abd")
    public void update() {
        if (this.model.getImportPath() != null) {
            this.filePathText.setText(this.model.getImportPath());
            this.okButton.setEnabled(true);
        } else {
            this.okButton.setEnabled(false);
        }
    }

    @objid ("dc19631c-4773-4d90-ac31-1979cc48be94")
    @Override
    protected Point getInitialSize() {
        return new Point(600, 300);
    }

    @objid ("62e6cd92-bbc9-48ec-9a52-5670193708ea")
    private void addListeners() {
        /*  this.keepIdCheckBox.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent e) {
                  ArchiImportDialog.this.controller.onSelectKeepId(((Button) e.getSource()).getSelection());
              }
          });*/


          this.applyNativeStyleCheckBox.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent e) {
                  ArchiImportDialog.this.controller.onSelectApplyNativeStyle(((Button) e.getSource()).getSelection());
              }
          });

          this.selectFileButton.addSelectionListener(new SelectionAdapter() {
              @Override
              public void widgetSelected(SelectionEvent e) {
                  ArchiImportDialog.this.controller.onSelectSelectFile();
              }
          });

          this.versionSelection.addSelectionChangedListener(new ISelectionChangedListener() {
              @Override
              public void selectionChanged(SelectionChangedEvent event) {
                  IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                  ArchiImportDialog.this.controller.onSelectVersion((ExchangeFormatVersion) selection.getFirstElement());
              }
          });
    }

    @objid ("3cbcfb77-1e93-4abe-9e29-2d1f8a4f3493")
    private Composite createActionGroup(Composite parent) {
        GridData gd = null;

        // Archive
        Label filePathLabel = new Label(parent, SWT.NONE);
        gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
        gd.horizontalAlignment = GridData.FILL;
        gd.minimumHeight = 200;
        filePathLabel.setLayoutData(gd);
        filePathLabel.setText(ArchiExchange.I18N.getMessage("ui.command.import.selectfile.label"));
        PolluxWidgetConfigurator.configureStyleForFieldLabel(filePathLabel);

        Composite fileComposite = new Composite(parent, SWT.NONE);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalIndent = - 5;
        fileComposite.setLayout(new GridLayout(2, false));
        fileComposite.setLayoutData(gd);
        PolluxWidgetConfigurator.configureStyleForFieldCaption(fileComposite);
        this.filePathText = new Text(fileComposite, SWT.BORDER);
        gd = new GridData(SWT.FILL, SWT.FILL, true, false);
        gd.horizontalAlignment = GridData.FILL;
        this.filePathText.setLayoutData(gd);
        this.filePathText.setEditable(false);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(this.filePathText);

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
        versionLabel.setText(ArchiExchange.I18N.getMessage("ui.command.import.version.label"));
        PolluxWidgetConfigurator.configureStyleForFieldLabel(versionLabel);

        this.versionSelection = new ComboViewer(parent, SWT.READ_ONLY);
        gd = new GridData(SWT.LEFT, SWT.TOP, true, false);
        gd.horizontalSpan = 10;
        gd.minimumWidth = 150;
        this.versionSelection.getCombo().setLayoutData(gd);
        this.versionSelection.setContentProvider(ArrayContentProvider.getInstance());
        this.versionSelection.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof ExchangeFormatVersion) {
                    if (element.equals(ExchangeFormatVersion.V21)) {
                        return ArchiExchange.I18N.getMessage("ui.command.import.selectversion.v21.label");
                    } else if (element.equals(ExchangeFormatVersion.V30)) {
                        return ArchiExchange.I18N.getMessage("ui.command.import.selectversion.v30.label");
                    }else if (element.equals(ExchangeFormatVersion.V31)) {
                        return ArchiExchange.I18N.getMessage("ui.command.import.selectversion.v31.label");
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
        // Build type
        /* this.keepIdCheckBox = new Button(parent, SWT.CHECK);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false);
        gd.horizontalAlignment = GridData.FILL;
        gd.horizontalSpan = 3;
        this.keepIdCheckBox.setLayoutData(gd);
        this.keepIdCheckBox.setText(ArchiExchange.I18N.getMessage("ui.command.import.keepid.label"));
        this.keepIdCheckBox.setToolTipText(ArchiExchange.I18N.getMessage("ui.command.import.keepid.tooltip"));
        this.keepIdCheckBox.setSelection(this.model.isKeepId());*/


        this.applyNativeStyleCheckBox = new Button(parent, SWT.CHECK);
        gd = new GridData(SWT.FILL, SWT.FILL, false, false);
        gd.horizontalAlignment = GridData.FILL;
        gd.verticalIndent = 10;
        this.applyNativeStyleCheckBox.setLayoutData(gd);
        this.applyNativeStyleCheckBox.setText(ArchiExchange.I18N.getMessage("ui.command.import.applynativestyle.label"));
        this.applyNativeStyleCheckBox.setToolTipText(ArchiExchange.I18N.getMessage("ui.command.import.applynativestyle.tooltip"));
        this.applyNativeStyleCheckBox.setSelection(this.model.isApplyNativeStyle());
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.applyNativeStyleCheckBox);

        return parent;
    }

    @objid ("b61131cb-1118-4b70-b27e-b83519df8aa4")
    private static class Controller {
        @objid ("7229846f-827a-41cc-aadf-0b518a57743e")
        private ArchiImportDialog dlg;

        @objid ("0aca7dff-348d-4fdf-8ec0-d4e5a4c2926a")
        private ArchiImportModel model;

        @objid ("9aa27fee-1fc9-4645-a18d-e7ce9e2ef4d2")
        public Controller(ArchiImportDialog dlg, ArchiImportModel model) {
            this.dlg = dlg;
            this.model = model;
        }

        @objid ("62bf77da-8d51-4e57-af01-29eaf8ea3a13")
        public void onSelectVersion(ExchangeFormatVersion version) {
            this.model.setVersion(version);
        }

        @objid ("94a95972-eaf9-4276-9130-de91fc90cbc4")
        public void onSelectSelectFile() {
            FileDialog dialog = new FileDialog(new Shell(), SWT.OPEN);
            dialog.setFilterExtensions(new String[] { "*.xml" });
            dialog.setFilterNames(new String[] { "*.xml" });
            dialog.setText(ArchiExchange.I18N.getMessage("ui.command.import.description"));

            String path = dialog.open();

            if (path != null) {
                File bpmnFile = new File(path);
                if (bpmnFile.exists()) {
                    this.model.setImportPath(bpmnFile.getAbsolutePath());
                }
            }
            this.dlg.update();
        }

        @objid ("c6248d76-39fb-4c65-afbd-1f2cefd589e0")
        public void onSelectKeepId(boolean keepIdCkeckbox) {
            this.model.setKeepId(keepIdCkeckbox);
            this.dlg.update();
        }

        @objid ("81f9f4dd-f9da-46d0-850f-252627e62e5d")
        public void onSelectApplyNativeStyle(boolean applyNativeStyle) {
            this.model.setApplyNativeStyle(applyNativeStyle);
            this.dlg.update();
        }

    }

}
