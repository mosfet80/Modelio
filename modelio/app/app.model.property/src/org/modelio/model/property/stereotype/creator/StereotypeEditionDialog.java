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
package org.modelio.model.property.stereotype.creator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.modelio.api.ui.ModelioDialog;
import org.modelio.gproject.core.IGProject;
import org.modelio.metamodel.Metamodel;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.mda.ModuleParameter;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.mmextensions.standard.services.IMModelServices;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.NoteType;
import org.modelio.metamodel.uml.infrastructure.Profile;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.metamodel.uml.infrastructure.TagType;
import org.modelio.model.property.plugin.ModelProperty;
import org.modelio.platform.core.project.ICurrentProjectService;
import org.modelio.platform.model.ui.swt.selectmetaclass.IMetaclassSelectorFilter;
import org.modelio.platform.model.ui.swt.selectmetaclass.MetaclassSelector;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.osgi.framework.Bundle;

/**
 * Dialog class for Stereotype creation command.
 */
@objid ("8dd9d336-96e3-4cc0-8287-9ff71c9be254")
public class StereotypeEditionDialog extends ModelioDialog {
    @objid ("1955dfe3-30ec-4db3-bfcf-7d468d60d622")
    protected Button createButton;

    @objid ("a65d3fe0-b824-4f0b-a0ae-4af733663dc5")
    protected Text stereotypeNameText;

    @objid ("90bc925f-5654-4997-ad91-e4736be66529")
    protected Label explorerIconImage;

    @objid ("83f9b910-5ba9-4396-9469-7da12f2cb536")
    protected Label diagramImageImage;

    @objid ("553715fd-03df-42bc-964d-026a74654e63")
    private Font sizeFontAdvice;

    @objid ("6a16ae45-564a-455f-a620-de45099eb2f2")
    protected Button applyStereotypeCheckbox;

    @objid ("ee084c61-4a86-4cca-a74c-67e87bd9d3b8")
    private Button explorerIconButton;

    @objid ("2466d4eb-fd61-4ca6-81b7-a401beaecbd3")
    private Button diagramImageButton;

    @objid ("006e3c53-4f98-4c90-b50c-ac6dbff8cd55")
    private Button deleteExplorerIconButton;

    @objid ("7be3c79a-a4b8-485d-a375-6cf851c0ff0e")
    private Button deleteDiagramImageButton;

    @objid ("ccab4cd3-24ac-4ec4-899e-d2aefc8595a3")
    private Image explorerImage;

    @objid ("e55dc674-c181-4a0b-bf6d-ee31e5f46b56")
    private Image diagramImage;

    @objid ("037cbbe2-824e-49f0-af04-9cb242575f8c")
    protected final StereotypeEditionDataModel dataModel;

    @objid ("8a1278cd-8d55-42b4-b555-8ae64579848b")
    private StereotypeValidator stereotypeValidator;

    @objid ("348bde45-0888-4351-8fb0-025dfaa2e8bc")
    private final ICurrentProjectService projectService;

    @objid ("2b4b6cb9-879d-45bc-89a6-e8675d25b40e")
    private ApplyStereotypeListener applyStereotypeListener;

    @objid ("c1fec64a-6ebb-4634-89b1-716d3f9fdcb2")
    private BrowserIconChooserListener explorerIconChooser;

    @objid ("31a820bb-c46f-4996-8f08-3e267bdc9ddf")
    private DiagramImageChooserListener diagramImageChooser;

    @objid ("d280a2a6-5af2-4d9d-bf89-28ea4a4e1435")
    private final IMModelServices mmServices;

    @objid ("574d0b4a-c1ec-4bde-9fc1-6afddb870706")
    private final List<ModelElement> selectedElements;

    @objid ("1029a22b-b9ba-4203-8fd7-329ff6a1acc0")
    private MetaclassSelector mclassSelector;

    /**
     * Default constructor.
     *
     * @param parentShell the parent shell.
     * @param dataModel the data model.
     * @param projectService project manipulation service
     * @param mmServices model manipulation services
     * @param selectedElements the initially selected elements
     */
    @objid ("bf8a3af5-5f7c-454c-a3a1-d703cdebc5af")
    public StereotypeEditionDialog(Shell parentShell, StereotypeEditionDataModel dataModel, ICurrentProjectService projectService, IMModelServices mmServices, List<ModelElement> selectedElements) {
        super(parentShell);
        this.dataModel = dataModel;

        this.projectService = projectService;
        this.sizeFontAdvice = new Font(Display.getDefault(), "Tahoma", 6, SWT.ITALIC);
        this.mmServices = mmServices;
        this.selectedElements = selectedElements;

        setShellStyle(SWT.TITLE | SWT.CLOSE | SWT.BORDER | SWT.APPLICATION_MODAL | getDefaultOrientation());
    }

    @objid ("c184e9c2-5872-4b49-9a56-dd07cadf0771")
    @Override
    public void addButtonsInButtonBar(Composite parent) {
        this.createButton = createButton(parent, IDialogConstants.OK_ID,
        this.dataModel.isCreationMode() ? ModelProperty.I18N.getString("StereotypeCreationDialog.Create")
        : IDialogConstants.OK_LABEL,
        true);
        this.createButton.setEnabled(false);

        createButton(parent, IDialogConstants.CANCEL_ID,
        ModelProperty.I18N.getString("StereotypeCreationDialog.Cancel"), false);
    }

    @objid ("b17889aa-5a52-46af-8969-80873fb27083")
    @Override
    public Control createContentArea(Composite parent) {
        parent.addDisposeListener(ev -> onDispose());

        Composite area = new Composite(parent, SWT.NONE);
        area.setLayout(new GridLayout(1, false));
        area.setLayoutData(new GridData(GridData.FILL_BOTH));

        createFieldArea(area);
        createImagesArea(area);

        if (this.dataModel.isCreationMode()) {
        createApplyStereotype(area);
        }
        return area;
    }

    @objid ("01446d06-8fff-46ac-babf-acfcfc907479")
    @Override
    public void init() {
        setLogoImage(null);
        // Put the MdaExplorer.I18N in the banner area
        if (this.dataModel.isCreationMode()) {
        getShell().setText(ModelProperty.I18N.getString("StereotypeCreationDialog.ShellTitle"));
        setTitle(ModelProperty.I18N.getString("StereotypeCreationDialog.Title"));
        setMessage(ModelProperty.I18N.getString("StereotypeCreationDialog.Message"));
        } else {
        getShell().setText(ModelProperty.I18N.getString("StereotypeEditionDialog.ShellTitle"));
        setTitle(ModelProperty.I18N.getString("StereotypeEditionDialog.Title"));
        setMessage(ModelProperty.I18N.getString("StereotypeEditionDialog.Message"));
        }
        getShell().pack(true);

        refresh();
        getShell().setSize(600, 450);
        // The shell has to be centered
        int x = (getShell().getSize().x / 2);
        int y = (getShell().getSize().y / 2);
        getShell().setLocation(x, y);
        getShell().setMinimumSize(550, 450);
    }

    /**
     * Change stereotype text field color according to the provided boolean.
     * <p>
     * <ul>
     * <li>invalidate == true -> text will be red.</li>
     * <li>invalidate == false -> text will be green.</li>
     * </ul>
     *
     * @param invalidate whether or not the note type name filed will be invalidated
     */
    @objid ("f4569d15-0c00-4ff1-9ae5-8d301d19b0a8")
    public void invalidateStereotypeNameText(boolean invalidate) {
        if (invalidate) {
        this.stereotypeNameText.setForeground(UIColor.RED);
        } else {
        this.stereotypeNameText
        .setForeground(this.stereotypeNameText.getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN));
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see org.eclipse.jface.dialogs.TrayDialog#close()
     */
    @objid ("7e9a0d8f-710d-459e-9cec-8e3a1b8c0306")
    @Override
    public boolean close() {
        onDispose();
        return super.close();
    }

    @objid ("d72e4440-9dc9-40ca-9e6d-ab5a80d437a1")
    private void onDispose() {
        if (this.stereotypeValidator != null) {
        this.stereotypeNameText.removeModifyListener(this.stereotypeValidator);
        this.mclassSelector.getControl().removeModifyListener(this.stereotypeValidator);
        this.stereotypeValidator = null;
        }

        if (this.applyStereotypeListener != null) {
        this.applyStereotypeCheckbox.removeSelectionListener(this.applyStereotypeListener);
        this.applyStereotypeListener = null;
        }

        if (this.explorerIconButton != null) {
        this.explorerIconButton.removeSelectionListener(this.explorerIconChooser);
        this.explorerIconButton = null;
        }

        if (this.diagramImageButton != null) {
        this.diagramImageButton.removeSelectionListener(this.diagramImageChooser);
        this.diagramImageButton = null;
        }

        if (this.explorerImage != null) {
        this.explorerImage.dispose();
        }

        if (this.diagramImage != null) {
        this.diagramImage.dispose();
        }

        if (this.sizeFontAdvice != null) {
        this.sizeFontAdvice.dispose();
        this.sizeFontAdvice = null;
        }
    }

    @objid ("baaa9408-bb69-4d4f-b7c5-59329f99d1f2")
    private void createDiagramImageArea(Composite area) {
        Group diagramImageArea = new Group(area, SWT.NONE);
        diagramImageArea.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.DiagramImageLabel"));
        GridLayout gl_diagramImageArea = new GridLayout(2, false);
        gl_diagramImageArea.verticalSpacing = 3;
        gl_diagramImageArea.marginLeft = 25;
        gl_diagramImageArea.marginRight = 15;
        gl_diagramImageArea.marginTop = 10;
        gl_diagramImageArea.marginBottom = 5;
        diagramImageArea.setLayout(gl_diagramImageArea);
        diagramImageArea.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));

        Composite imageArea = new Composite(diagramImageArea, SWT.BORDER);
        GridLayout gl_imageArea = new GridLayout(1, true);
        gl_imageArea.marginHeight = 0;
        gl_imageArea.marginWidth = 0;
        imageArea.setLayout(gl_imageArea);
        GridData gd_imageArea = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        gd_imageArea.heightHint = 100;
        gd_imageArea.widthHint = 100;
        imageArea.setLayoutData(gd_imageArea);

        this.diagramImageImage = new Label(imageArea, SWT.CENTER);
        GridData gd_diagramImageText = new GridData(SWT.CENTER, SWT.CENTER, false, false);
        gd_diagramImageText.heightHint = 100;
        gd_diagramImageText.widthHint = 100;
        this.diagramImageImage.setLayoutData(gd_diagramImageText);

        Composite buttonArea = new Composite(diagramImageArea, SWT.NONE);
        buttonArea.setLayout(new GridLayout());
        buttonArea.setLayoutData(new GridData());

        this.diagramImageButton = new Button(buttonArea, SWT.CENTER);
        this.diagramImageButton.setImage(UIImages.FILECHOOSE);
        this.diagramImageButton
        .setToolTipText(ModelProperty.I18N.getString("StereotypeCreationDialog.DiagramImageLabel"));
        this.diagramImageChooser = new DiagramImageChooserListener(this, this.projectService, this.dataModel);
        this.diagramImageButton.addSelectionListener(this.diagramImageChooser);
        GridData gd_diagramImageButton = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        this.diagramImageButton.setLayoutData(gd_diagramImageButton);

        this.deleteDiagramImageButton = new Button(buttonArea, SWT.NONE);
        this.deleteDiagramImageButton.setImage(UIImages.DELETE);
        this.deleteDiagramImageButton.setEnabled(false);
        this.deleteDiagramImageButton.setLayoutData(gd_diagramImageButton);
        this.deleteDiagramImageButton.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetSelected(SelectionEvent e) {
        String diagramImagePath = StereotypeEditionDialog.this.dataModel.getDiagramImage();
        if (!diagramImagePath.isEmpty()) {
        if (diagramImage != null) {
        diagramImage.dispose();
        }
        deleteTempFileIfExist(StereotypeEditionDialog.this.dataModel.getDefaultTempImagePath());
        StereotypeEditionDialog.this.dataModel.setImageName("");
        refresh();
        }
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        // Nothing
        }
        });

        Label diagramImageSizeLabel = new Label(diagramImageArea, SWT.CENTER);
        diagramImageSizeLabel.setFont(this.sizeFontAdvice);
        diagramImageSizeLabel.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.DiagramImageSizeLabel"));
        GridData gd_diagramImageSizeLabel = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        gd_diagramImageSizeLabel.widthHint = 100;
        diagramImageSizeLabel.setLayoutData(gd_diagramImageSizeLabel);
    }

    @objid ("2e73e619-78da-4469-88f5-286bef8322ab")
    private void createExplorerIconArea(Composite area) {
        Group explorerIconArea = new Group(area, SWT.NONE);
        explorerIconArea.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.BrowserIconLabel"));
        GridLayout gl_explorerIconArea = new GridLayout(2, false);
        gl_explorerIconArea.verticalSpacing = 3;
        gl_explorerIconArea.marginLeft = 25;
        gl_explorerIconArea.marginRight = 15;
        gl_explorerIconArea.marginTop = 10;
        gl_explorerIconArea.marginBottom = 5;
        explorerIconArea.setLayout(gl_explorerIconArea);
        explorerIconArea.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));

        Composite imageArea = new Composite(explorerIconArea, SWT.BORDER);
        GridLayout gl_imageArea = new GridLayout(1, true);
        gl_imageArea.marginHeight = 0;
        gl_imageArea.marginWidth = 0;
        imageArea.setLayout(gl_imageArea);
        GridData gd_imageArea = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        gd_imageArea.heightHint = 100;
        gd_imageArea.widthHint = 100;
        imageArea.setLayoutData(gd_imageArea);

        this.explorerIconImage = new Label(imageArea, SWT.CENTER);
        this.explorerIconImage.setSize(100, 100);
        this.explorerIconImage.setImage(null);
        GridData gd_explorerIconImage = new GridData(SWT.CENTER, SWT.CENTER, false, false);
        gd_explorerIconImage.heightHint = 100;
        gd_explorerIconImage.widthHint = 100;
        this.explorerIconImage.setLayoutData(gd_explorerIconImage);

        Composite buttonArea = new Composite(explorerIconArea, SWT.NONE);
        buttonArea.setLayout(new GridLayout());
        buttonArea.setLayoutData(new GridData());

        this.explorerIconButton = new Button(buttonArea, SWT.NONE);
        this.explorerIconButton.setImage(UIImages.FILECHOOSE);
        this.explorerIconButton
        .setToolTipText(ModelProperty.I18N.getString("StereotypeCreationDialog.BrowserIconLabel"));
        this.explorerIconChooser = new BrowserIconChooserListener(this, this.projectService, this.dataModel);
        this.explorerIconButton.addSelectionListener(this.explorerIconChooser);
        GridData gd_browserIconButton = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        this.explorerIconButton.setLayoutData(gd_browserIconButton);

        this.deleteExplorerIconButton = new Button(buttonArea, SWT.NONE);
        this.deleteExplorerIconButton.setEnabled(false);
        this.deleteExplorerIconButton.setImage(UIImages.DELETE);
        this.deleteExplorerIconButton.addSelectionListener(new SelectionListener() {

        @Override
        public void widgetSelected(SelectionEvent e) {
        String explorerIconPath = StereotypeEditionDialog.this.dataModel.getExplorerIcon();
        if (!explorerIconPath.isEmpty()) {
        if (explorerImage != null) {
        explorerImage.dispose();
        }
        deleteTempFileIfExist(StereotypeEditionDialog.this.dataModel.getDefaultTempIconPath());
        StereotypeEditionDialog.this.dataModel.setIconName("");
        refresh();
        }
        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        // Nothing
        }
        });

        Label explorerIconSizeLabel = new Label(explorerIconArea, SWT.CENTER);

        explorerIconSizeLabel.setFont(this.sizeFontAdvice);
        explorerIconSizeLabel.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.ExplorerIconSizeLabel"));
        GridData gd_explorerIconSizeLabel = new GridData(SWT.CENTER, SWT.CENTER, true, false);
        gd_explorerIconSizeLabel.widthHint = 100;
        explorerIconSizeLabel.setLayoutData(gd_explorerIconSizeLabel);
    }

    @objid ("ec52b451-700b-4b5f-ad2e-ecc562b845dd")
    private void createMetaclassArea(Composite area) {
        Label metaclassLabel = new Label(area, SWT.NONE);
        metaclassLabel.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.MetaclassLabel"));
        GridData gd_metaclassLabel = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
        metaclassLabel.setLayoutData(gd_metaclassLabel);

        // excluded metaclasses
        Collection<Class<? extends ModelElement>> excluded = Arrays.asList(ModuleComponent.class, Profile.class,
        Project.class, TagType.class, NoteType.class, Stereotype.class, ModuleParameter.class);

        // Compute allowed metaclasses
        SmMetamodel metamodel = this.projectService.getSession().getMetamodel();
        SmClass modelElementMClass = metamodel.getMClass(ModelElement.class);
        Collection<MClass> mClasses = modelElementMClass.getSub(true);
        Collection<MClass> metaclasses = mClasses.stream().filter(mc -> !excluded.contains(mc.getJavaInterface()))
        .collect(Collectors.toCollection(HashSet::new));

        metaclasses.add(modelElementMClass);

        // Create the metaclass selector
        IMetaclassSelectorFilter mclassFilter = mClass -> metaclasses.contains(mClass);

        this.mclassSelector = new MetaclassSelector(area, SWT.BORDER, metamodel, mclassFilter);
        this.mclassSelector.getControl().setText(this.dataModel.getMetaclassName());
        GridData gd_metaclassCombo = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
        this.mclassSelector.getControl().setLayoutData(gd_metaclassCombo);
        this.mclassSelector.addListener(this.stereotypeValidator);
    }

    @objid ("e3c58479-36fc-4a14-be85-1b97c099cd85")
    private void createNameArea(Composite area) {
        Label docLabel = new Label(area, SWT.WRAP);
        docLabel.setForeground(UIColor.LABEL_TIP_FG);
        docLabel.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.DocLabel"));
        GridData gd_docLabel = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
        gd_docLabel.widthHint = 400;
        docLabel.setLayoutData(gd_docLabel);

        Label noteTypeNameLabel = new Label(area, SWT.NONE);
        noteTypeNameLabel.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.NameLabel"));
        GridData gd_noteTypeNameLabel = new GridData(SWT.LEFT, SWT.FILL, false, false);
        noteTypeNameLabel.setLayoutData(gd_noteTypeNameLabel);

        this.stereotypeNameText = new Text(area, SWT.BORDER);
        this.stereotypeValidator = new StereotypeValidator(this, this.dataModel, this.mmServices);
        this.stereotypeNameText.addModifyListener(this.stereotypeValidator);
        GridData gd_stereotypeNameText = new GridData(SWT.FILL, SWT.FILL, true, false);
        this.stereotypeNameText.setLayoutData(gd_stereotypeNameText);
    }

    /**
     * Refresh the dialog from the data model.
     */
    @objid ("cb5d2344-5cfd-4402-afce-9d909b424291")
    public void refresh() {
        this.stereotypeNameText.setText(this.dataModel.getStereotypeName());
        this.mclassSelector.setSelected(Metamodel.getMClass(this.dataModel.getMetaclassName()));

        this.explorerIconButton.setEnabled(true);
        this.diagramImageButton.setEnabled(true);

        IGProject openedProject = this.projectService.getOpenedProject();
        if (openedProject != null) {
        String explorerIconPath = this.dataModel.getExplorerIcon();
        if (explorerIconPath != null && !explorerIconPath.equals("")) {
        try {
        if (this.explorerImage != null) {
        this.explorerImage.dispose();
        }

        File explorerIconFile = new File(explorerIconPath);
        ImageDescriptor explorerImageDesc = ImageDescriptor.createFromURL(explorerIconFile.toURI().toURL());
        ImageData explorerImageData = explorerImageDesc.getImageData(100);
        if (explorerImageData.width > 100 || explorerImageData.height > 100) {
        ImageData data = scaleImage(explorerImageData);
        explorerImageDesc = ImageDescriptor.createFromImageData(data);
        }

        this.explorerImage = explorerImageDesc.createImage();
        this.explorerIconImage.setImage(this.explorerImage);
        this.deleteExplorerIconButton.setEnabled(true);
        } catch (MalformedURLException e) {
        ModelProperty.LOG.error(e);
        }

        } else {
        this.explorerIconImage.setImage(UIImages.PLACEHOLDER);
        this.deleteExplorerIconButton.setEnabled(false);
        }

        String diagramImagePath = this.dataModel.getDiagramImage();
        if (diagramImagePath != null && !diagramImagePath.equals("")) {

        try {

        if (this.diagramImage != null) {
        this.diagramImage.dispose();
        }

        File diagramIconFile = new File(diagramImagePath);
        ImageDescriptor diagramImageDesc = ImageDescriptor.createFromURL(diagramIconFile.toURI().toURL());
        ImageData diagramImageData = diagramImageDesc.getImageData(100);
        if (diagramImageData.width > 100 || diagramImageData.height > 100) {
        ImageData data = scaleImage(diagramImageData);
        diagramImageDesc = ImageDescriptor.createFromImageData(data);
        }

        this.diagramImage = diagramImageDesc.createImage();
        this.diagramImageImage.setImage(this.diagramImage);
        this.deleteDiagramImageButton.setEnabled(true);
        } catch (MalformedURLException e) {
        ModelProperty.LOG.error(e);
        }
        } else {
        this.diagramImageImage.setImage(UIImages.PLACEHOLDER_48);
        this.deleteDiagramImageButton.setEnabled(false);
        }
        }
    }

    @objid ("2f7c1279-cd75-4750-a744-7e57327c0766")
    private void createFieldArea(Composite area) {
        Composite fieldArea = new Composite(area, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginRight = 12;
        fieldArea.setLayout(layout);
        fieldArea.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        createNameArea(fieldArea);
        createMetaclassArea(fieldArea);
    }

    @objid ("dbcc878c-79ed-4955-949b-e1190d081f83")
    private void createImagesArea(Composite area) {
        Composite imageArea = new Composite(area, SWT.NONE);
        GridLayout gl_imageArea = new GridLayout(2, true);
        gl_imageArea.horizontalSpacing = 50;
        gl_imageArea.verticalSpacing = 0;
        gl_imageArea.marginHeight = 0;
        gl_imageArea.marginWidth = 0;
        imageArea.setLayout(gl_imageArea);
        GridData gd_imageArea = new GridData(SWT.CENTER, SWT.CENTER, true, true);
        imageArea.setLayoutData(gd_imageArea);

        createExplorerIconArea(imageArea);
        createDiagramImageArea(imageArea);
    }

    @objid ("06b5299a-eaf7-4e77-ae64-7faabdb273f0")
    private void createApplyStereotype(Composite area) {
        this.applyStereotypeCheckbox = new Button(area, SWT.CHECK);
        this.applyStereotypeCheckbox.setSelection(!this.selectedElements.isEmpty());
        this.applyStereotypeCheckbox.setEnabled(!this.selectedElements.isEmpty());
        this.applyStereotypeCheckbox.setText(ModelProperty.I18N.getString("StereotypeCreationDialog.ApplyStereotype"));
        this.applyStereotypeListener = new ApplyStereotypeListener(this, this.dataModel);
        this.applyStereotypeCheckbox.addSelectionListener(this.applyStereotypeListener);
        GridData gd_applyStereotype = new GridData(SWT.LEFT, SWT.CENTER, true, false);
        this.applyStereotypeCheckbox.setLayoutData(gd_applyStereotype);
    }

    /**
     * @return
     */
    @objid ("36577c56-f1ad-44bb-9a8e-e048b1127ec1")
    private ImageData scaleImage(ImageData explorerIconData) {
        if (explorerIconData.height > explorerIconData.width) {
        int w = explorerIconData.width * 100 / explorerIconData.height;
        return explorerIconData.scaledTo(w, 100);
        }

        int h = explorerIconData.height * 100 / explorerIconData.width;
        return explorerIconData.scaledTo(100, h);
    }

    @objid ("7e154813-e084-475a-afcc-a27d2c554936")
    @Override
    protected void cancelPressed() {
        deleteTempFileIfExist(this.dataModel.getDefaultTempIconPath());
        deleteTempFileIfExist(this.dataModel.getDefaultTempImagePath());
        super.cancelPressed();
    }

    @objid ("629dcb27-4478-47a2-b89b-1c326d107cb9")
    protected void deleteTempFileIfExist(Path filePath) {
        if (filePath != null) {
        File file = filePath.toFile();
        if (file.exists()) {
        file.delete();
        }
        }
    }

    @objid ("1aacfd61-6208-4ced-8986-b27d10ca4d62")
    private String getFilePathOf(String fileName) {
        String path = "";
        Bundle bundle = Platform.getBundle(ModelProperty.PLUGIN_ID);
        String s = "platform:/plugin/" + bundle.getSymbolicName() + "/" + fileName; // To avoid the space in the bundle
        // path
        URL url = null;
        try {
        url = new URL(s);
        path = FileLocator.toFileURL(url).getPath();
        } catch (Exception e) {
        ModelProperty.LOG.debug("File path %s is not found!", s);
        ModelProperty.LOG.error(e);
        }
        return path;
    }

    /**
     * Get the metaclass displayed in the metaclass field.
     *
     * @return the displayed metaclass .
     */
    @objid ("ead828f1-3e3d-4a84-a311-1cc55204ccf4")
    MClass getBaseClass() {
        return this.mclassSelector.getSelected();
    }

}
