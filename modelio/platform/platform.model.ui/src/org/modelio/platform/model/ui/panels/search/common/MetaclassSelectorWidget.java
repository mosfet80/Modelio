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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Widget providing two linked combos for selecting a metaclass (or stereotype):
 * <ul>
 * <li>a metamodel/module combo;</li>
 * <li>a metaclass/stereotype combo filtered by the first selection.</li>
 * </ul>
 * <p>
 * A {@link Consumer} listener is invoked with the qualified name of the
 * selected metaclass (or the raw typed text when no exact match is found)
 * whenever the user confirms a selection.
 * </p>
 */
@objid ("b085830c-2a00-4ff6-91ad-ad4f7da80e65")
public class MetaclassSelectorWidget {
    @objid ("d00e906c-c1ba-4716-bd3b-7b68d08f31be")
    private boolean isUpdatingCombo;

    @objid ("23c40ca5-2957-461d-9965-db8316c0e789")
    private String metaclassTypedText = "";

    @objid ("14fe15c3-04a4-473e-bee0-76a53933913d")
    private ComboViewer metamodelCombo;

    @objid ("124aa6d1-4320-489d-a0aa-76593658df5c")
    private ComboViewer metaclassCombo;

    @objid ("c735c199-973e-4040-a32f-e916d303961f")
    private List<MClass> allMetaclassesForMetamodel = new ArrayList<>();

    @objid ("4f0d3e07-753d-4834-b7ac-29f395963d4c")
    private List<Stereotype> allStereotypesForModule = new ArrayList<>();

    @objid ("78a4a089-7b5a-4b6c-bc7c-90215ca1e100")
    private List<ModuleComponent> moduleComponents = new ArrayList<>();

    @objid ("6d3f5397-60ef-4852-9787-d3d5ff159369")
    private final ICoreSession session;

    @objid ("a62939e1-5027-4c37-a245-b8073c4ce986")
    private final Consumer<Object> selectionListener;

    /**
     * Creates the widget.
     *
     * @param session the core session used to query the metamodel and
     * modules.
     * @param selectionListener called with the qualified name (or raw text) when
     * the user selects a metaclass.
     */
    @objid ("39fe6115-0452-4dc7-ad3e-9bd24914993b")
    public MetaclassSelectorWidget(final ICoreSession session, final Consumer<Object> selectionListener) {
        this.session = Objects.requireNonNull(session, "session");
        this.selectionListener = selectionListener;
        buildModuleList();
    }

    /**
     * Creates the metamodel and metaclass combo controls inside {@code parent}. The
     * parent is expected to use a {@code GridLayout}. Labels are taken from the
     * {@code MqlSource.metamodel} and {@code MqlSource.type} i18n keys.
     *
     * @param parent the composite in which controls are created.
     */
    @objid ("af45997f-bf6b-4e83-9fbf-059533f86690")
    public void createControls(final Composite parent) {
        createControls(parent, CoreUi.I18N.getString("MetaclassSelectionWidget.metamodel"),
                CoreUi.I18N.getString("MetaclassSelectionWidget.type"));
    }

    /**
     * Creates the metamodel and metaclass combo controls inside {@code parent}
     * using the supplied label texts. The parent is expected to use a
     * {@code GridLayout}.
     *
     * @param parent the composite in which controls are created.
     * @param metamodelLabelText text for the metamodel label.
     * @param metaclassLabelText text for the metaclass label.
     */
    @objid ("618e8366-bf47-48f3-97a1-e8ece99753c1")
    public void createControls(final Composite parent, final String metamodelLabelText, final String metaclassLabelText) {
        // Metamodel combo
        Label metamodelLabel = new Label(parent, SWT.NONE);
        metamodelLabel.setText(metamodelLabelText);

        this.metamodelCombo = new ComboViewer(parent, SWT.READ_ONLY | SWT.BORDER);
        this.metamodelCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.metamodelCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.metamodelCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof ModuleComponent) {
                    return ((ModuleComponent) element).getName();
                }else if(element instanceof BusinessMetamodelType) {
                    return ((BusinessMetamodelType) element).label;
                }
                return element != null ? element.toString() : "";
            }
        });


        List<Object> modelEntries = new ArrayList<Object>();
        modelEntries.addAll(Arrays.asList(BusinessMetamodelType.values()));
        modelEntries.addAll(this.moduleComponents);
        this.metamodelCombo.setInput(modelEntries);
        PolluxWidgetConfigurator.configureSimpleField(metamodelLabel, this.metamodelCombo.getCombo(), null);

        // Metaclass combo
        Label metaclassLabel = new Label(parent, SWT.NONE);
        metaclassLabel.setText(metaclassLabelText);

        this.metaclassCombo = new ComboViewer(parent, SWT.BORDER);
        this.metaclassCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.metaclassCombo.setContentProvider(ArrayContentProvider.getInstance());
        this.metaclassCombo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element instanceof MClass) {
                    return ((MClass) element).getName();
                }
                return super.getText(element);
            }
        });
        PolluxWidgetConfigurator.configureSimpleField(metaclassLabel, this.metaclassCombo.getCombo(), null);

        this.metamodelCombo.setSelection(new StructuredSelection("UML"));
        this.metaclassCombo.setSelection(new StructuredSelection(resolveBaseClass("Standard.Package")));
        updateMetaclassList();

        hookListeners();
    }

    /**
     * Programmatically sets the selection from a qualified name.
     * <p>
     * This method does <em>not</em> fire the selection listener.
     * </p>
     *
     * @param qualifiedName the qualified name of the metaclass to select.
     */
    @objid ("b4adbd0c-1f24-4b32-a921-d9b719ae204c")
    public void setSelection(final String qualifiedName) {
        if (qualifiedName == null || qualifiedName.isBlank()) {
            return;
        }
        this.isUpdatingCombo = true;
        try {
            BusinessMetamodelType mm = resolveMetamodelFromQualifiedName(qualifiedName);
            IStructuredSelection currentMM = this.metamodelCombo.getStructuredSelection();
            if (currentMM.isEmpty() || !mm.equals(currentMM.getFirstElement())) {
                this.metamodelCombo.setSelection(new StructuredSelection(mm));
                updateMetaclassList();
            }
            MClass mc = this.allMetaclassesForMetamodel.stream().filter(c -> c.getQualifiedName().equals(qualifiedName))
                    .findFirst().orElse(null);
            if (mc != null) {
                this.metaclassCombo.getCombo().setText(mc.getName());
                this.metaclassTypedText = mc.getName();
            }
        } finally {
            this.isUpdatingCombo = false;
        }
    }

    /**
     * Returns the qualified name of the currently selected metaclass, or the raw
     * typed text if no exact match is found. Returns {@code null} when the combo is
     * empty.
     *
     * @return the qualified name / typed text, or {@code null}.
     */
    @objid ("d9d14a38-c566-4d0c-a367-e6b8dd820f8a")
    public String getSelectedQualifiedName() {
        MClass mc = getSelectedMetaclass();
        if (mc != null) {
            return mc.getQualifiedName();
        }

        Stereotype st = getSelectedStereotype();
        if (st != null) {
            return st.getBaseClassName();
        }

        String text = this.metaclassCombo.getCombo().getText();
        return (text != null && !text.isBlank()) ? text : null;
    }

    // ── Private helpers ───────────────────────────────────────────────────
    @objid ("97315eb2-b93e-4c82-9da5-57d516e89fcf")
    private void hookListeners() {
        this.metamodelCombo.addSelectionChangedListener(event -> {
            if (this.isUpdatingCombo) {
                return;
            }
            updateMetaclassList();
        });

        this.metaclassCombo.getCombo().addListener(SWT.KeyDown, event -> {
            if (this.isUpdatingCombo) {
                return;
            }
            boolean isTypingKey = (event.character >= 32) || event.keyCode == SWT.BS || event.keyCode == SWT.DEL;
            if (!isTypingKey) {
                return;
            }
            final String current = this.metaclassTypedText;
            final String next;
            if (event.keyCode == SWT.BS) {

                Combo combo = this.metaclassCombo.getCombo();
                Point sel = combo.getSelection();
                String fullText = combo.getText();
                String selected = fullText.substring(sel.x, sel.y);
                if(selected != null && !selected.isEmpty()) {
                    next = fullText.substring(0, sel.x) + fullText.substring(sel.y);
                }else {
                    next = current.length() > 0 ? current.substring(0, current.length() - 1) : "";
                }

            } else if (event.keyCode == SWT.DEL) {
                next = "";
            } else {
                next = current + event.character;
            }
            this.metaclassTypedText = next;
            final String textToFilter = next;
            notifyListener();
            this.metaclassCombo.getCombo().getDisplay().asyncExec(() -> {
                if (!this.metaclassCombo.getCombo().isDisposed()) {
                    filterMetaclassByText(textToFilter);
                }
            });
        });

        this.metaclassCombo.getCombo().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (MetaclassSelectorWidget.this.isUpdatingCombo) {
                    return;
                }
                MetaclassSelectorWidget.this.metaclassTypedText = MetaclassSelectorWidget.this.metaclassCombo.getCombo()
                        .getText();
                notifyListener();
            }
        });
    }

    @objid ("f91405a1-2554-497d-aeff-1ff8dd435398")
    private void notifyListener() {
        Stereotype st = getSelectedStereotype();
        if (st != null) {
            this.selectionListener.accept(st);
            return;
        }

        MClass mc = getSelectedMetaclass();
        this.selectionListener.accept(mc);
    }

    @objid ("c1432201-2dd5-438b-8161-538b84f80f26")
    private void buildModuleList() {
        try {
            Collection<? extends ModuleComponent> found = this.session.getModel().findByClass(ModuleComponent.class);
            this.moduleComponents = found.stream().filter(m -> m.isValid() && hasAnyStereotype(m))
                    .sorted((a, b) -> a.getName().compareToIgnoreCase(b.getName())).collect(Collectors.toList());
        } catch (Exception e) {
            this.moduleComponents = new ArrayList<>();
        }
    }

    @objid ("23d2db89-bd5c-4d0a-bf9b-7fc6f496a4ee")
    private boolean hasAnyStereotype(final ModuleComponent module) {
        for (MObject profile : module.getCompositionChildren()) {
            for (MObject child : profile.getCompositionChildren()) {
                if (child instanceof Stereotype) {
                    return true;
                }
            }
        }
        return false;
    }

    @objid ("3b65b556-da94-4022-b616-f271912fc5e6")
    private void updateMetaclassList() {
        IStructuredSelection sel = this.metamodelCombo.getStructuredSelection();
        Object selected = sel.getFirstElement();
        if (selected == null) {
            return;
        }

        this.isUpdatingCombo = true;
        if (selected instanceof ModuleComponent) {
            List<Stereotype> stereotypes = getStereotypesForModule((ModuleComponent) selected);
            this.allStereotypesForModule = stereotypes;
            this.allMetaclassesForMetamodel = new ArrayList<>();
            String[] items = stereotypes.stream().map(Stereotype::getName).toArray(String[]::new);
            this.metaclassCombo.getCombo().setItems(items);
        } else if(selected instanceof BusinessMetamodelType) {
            BusinessMetamodelType selectedMetamodel = (BusinessMetamodelType) selected;
            this.allMetaclassesForMetamodel = this.session.getMetamodel().getMClass(MObject.class).getSub(true).stream()
                    .filter(mc -> matchesMetamodel(mc.getQualifiedName(), selectedMetamodel.qualifier))
                    .sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
            this.allStereotypesForModule = new ArrayList<>();
            this.metaclassCombo.setInput(this.allMetaclassesForMetamodel);
        }
        this.metaclassCombo.getCombo().setText("");
        this.metaclassTypedText = "";
        this.isUpdatingCombo = false;
    }

    @objid ("442007e1-10d6-43c3-b398-24960b55de7a")
    private List<Stereotype> getStereotypesForModule(final ModuleComponent module) {
        List<Stereotype> stereotypes = new ArrayList<>();
        for (MObject profile : module.getCompositionChildren()) {
            for (MObject child : profile.getCompositionChildren()) {
                if (child instanceof Stereotype) {
                    stereotypes.add((Stereotype) child);
                }
            }
        }
        stereotypes.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        return stereotypes;
    }

    @objid ("74416ec8-cf85-43b3-a801-8b88db6750f8")
    private boolean matchesMetamodel(final String qualifiedName, final String metamodelName) {
        if (qualifiedName == null || metamodelName == null) {
            return false;
        }
        switch (metamodelName) {
        case "General":
            return qualifiedName.startsWith("Infrastructure.");
        case "UML":
            return qualifiedName.startsWith("Standard.") && !qualifiedName.contains("Bpmn");
        case "BPMN":
            return qualifiedName.startsWith("Standard.") && qualifiedName.contains("Bpmn");
        case "Archimate":
            return qualifiedName.startsWith("Archimate.");
        case "Analyst":
            return qualifiedName.startsWith("Analyst.");
        default:
            return false;
        }
    }

    @objid ("5290601f-0aa6-49ce-8da8-8016d794f91d")
    private void filterMetaclassByText(final String typedText) {
        this.isUpdatingCombo = true;
        try {
            String[] itemArray;
            if (!this.allStereotypesForModule.isEmpty()) {
                List<Stereotype> filtered;
                if (typedText == null || typedText.isEmpty()) {
                    filtered = this.allStereotypesForModule;
                } else {
                    final String lower = typedText.toLowerCase();
                    filtered = this.allStereotypesForModule.stream()
                            .filter(s -> s.getName().toLowerCase().startsWith(lower)).collect(Collectors.toList());
                }
                itemArray = filtered.stream().map(Stereotype::getName).toArray(String[]::new);
            } else {
                List<MClass> filtered;
                if (typedText == null || typedText.isEmpty()) {
                    filtered = this.allMetaclassesForMetamodel;
                } else {
                    final String lower = typedText.toLowerCase();
                    filtered = this.allMetaclassesForMetamodel.stream()
                            .filter(mc -> mc.getName().toLowerCase().startsWith(lower)).collect(Collectors.toList());
                }
                itemArray = filtered.stream().map(MClass::getName).toArray(String[]::new);
            }
            final String safeText = (typedText != null) ? typedText : "";
            this.metaclassCombo.getCombo().setItems(itemArray);
            this.metaclassCombo.getCombo().setText(safeText);
            this.metaclassCombo.getCombo()
                    .setSelection(new org.eclipse.swt.graphics.Point(safeText.length(), safeText.length()));
            if (itemArray.length > 0) {
                this.metaclassCombo.getCombo().setListVisible(true);
            }
            this.metaclassCombo.getCombo().getDisplay().asyncExec(() -> {
                if (!this.metaclassCombo.getCombo().isDisposed() && !this.isUpdatingCombo
                        && !safeText.equals(this.metaclassCombo.getCombo().getText())) {
                    this.isUpdatingCombo = true;
                    this.metaclassCombo.getCombo().setText(safeText);
                    this.metaclassCombo.getCombo()
                            .setSelection(new org.eclipse.swt.graphics.Point(safeText.length(), safeText.length()));
                    this.isUpdatingCombo = false;
                }
            });
        } finally {
            this.isUpdatingCombo = false;
        }
    }

    /**
     * Returns the currently selected {@link MClass}, or {@code null} if none. In
     * stereotype mode, returns the base class of the selected stereotype.
     */
    @objid ("6bd55fea-e98f-4f35-8635-3090dd78667f")
    public MClass getSelectedMetaclass() {
        String text = this.metaclassTypedText;
        if (text == null || text.isEmpty()) {
            return null;
        }
        if (!this.allStereotypesForModule.isEmpty()) {
            Stereotype st = this.allStereotypesForModule.stream().filter(s -> s.getName().equalsIgnoreCase(text))
                    .findFirst().orElse(null);
            if (st != null) {
                return this.session.getMetamodel().getMClass(st.getBaseClassName());
            }
            return null;
        }
        return this.allMetaclassesForMetamodel.stream().filter(mc -> mc.getName().equalsIgnoreCase(text)).findFirst()
                .orElse(null);
    }

    /**
     * Returns the currently selected {@link Stereotype}, or {@code null} if the
     * panel is not in stereotype mode or nothing is selected.
     */
    @objid ("0cbdc293-50f1-422c-ad8c-31bc39bd9eb2")
    public Stereotype getSelectedStereotype() {
        if (this.allStereotypesForModule.isEmpty()) {
            return null;
        }
        String text = this.metaclassCombo.getCombo().getText();
        if (text == null || text.isEmpty()) {
            return null;
        }
        return this.allStereotypesForModule.stream().filter(s -> s.getName().equalsIgnoreCase(text)).findFirst()
                .orElse(null);
    }

    /**
     * Returns the currently selected {@link ModuleComponent} from the metamodel
     * combo, or {@code null} when a built-in metamodel is selected.
     */
    @objid ("6363a37d-d38c-4999-9822-ce34cfaa8c5c")
    public ModuleComponent getSelectedModule() {
        IStructuredSelection selection = this.metamodelCombo.getStructuredSelection();
        Object element = selection.getFirstElement();
        return (element instanceof ModuleComponent) ? (ModuleComponent) element : null;
    }

    @objid ("2d7fe233-90c8-4d81-8dc6-dec0f0d6d847")
    private MClass resolveBaseClass(final String baseClassName) {
        if (baseClassName == null || baseClassName.isEmpty()) {
            return null;
        }
        MClass mc = this.session.getMetamodel().getMClass(baseClassName);
        if (mc != null) {
            return mc;
        }
        final String lower = baseClassName.toLowerCase();
        final int dot = baseClassName.lastIndexOf('.');
        final String simpleName = (dot >= 0) ? baseClassName.substring(dot + 1) : baseClassName;
        return this.session.getMetamodel().getMClass(MObject.class).getSub(true).stream()
                .filter(c -> c.getQualifiedName().equalsIgnoreCase(lower) || c.getName().equalsIgnoreCase(simpleName))
                .findFirst().orElse(null);
    }

    @objid ("adfc5c06-25dc-4444-b008-4ac3dc97ee25")
    private BusinessMetamodelType resolveMetamodelFromQualifiedName(final String qn) {
        if (qn.startsWith("Infrastructure.")) {
            return BusinessMetamodelType.GENERAL;
        }
        if (qn.startsWith("Standard.") && qn.contains("Bpmn")) {
            return BusinessMetamodelType.BPMN;
        }
        if (qn.startsWith("Standard.")) {
            return BusinessMetamodelType.UML;
        }
        if (qn.startsWith("Archimate")) {
            return BusinessMetamodelType.ARCHIMATE;
        }
        if (qn.startsWith("Analyst")) {
            return BusinessMetamodelType.ANALYST;
        }
        return BusinessMetamodelType.UML;
    }

    @objid ("0e532773-780a-42c8-abd4-f1696b0d7090")
    public void setInput(MClass mClasse) {
        if (mClasse == null) {
            this.metamodelCombo.setSelection(new StructuredSelection("UML"));
            this.metaclassCombo.setSelection(new StructuredSelection(resolveBaseClass("Standard.Package")));
            this.metaclassCombo.getCombo().setText("Package");
        } else {
            this.metamodelCombo.setSelection(
                    new StructuredSelection(resolveMetamodelFromQualifiedName(mClasse.getQualifiedName())));
            updateMetaclassList();
            this.metaclassCombo.setSelection(new StructuredSelection(mClasse));
        }
    }

    @objid ("b010fbd0-bb7e-4291-a57a-5fbbefb0b454")
    private enum BusinessMetamodelType {
        @objid ("1d13ea65-a3c5-4804-9160-f6b7cd4b7a26")
        GENERAL(CoreUi.I18N.getString("MetaclassSelectorWidget.models.General"), "General"),
        @objid ("586f5d14-3be8-47b8-ba24-3b9291c89f29")
        UML(CoreUi.I18N.getString("MetaclassSelectorWidget.models.UML"), "UML"),
        @objid ("6e8b81e5-8c5f-48db-add8-856735ac3220")
        BPMN(CoreUi.I18N.getString("MetaclassSelectorWidget.models.BPMN"), "BPMN"),
        @objid ("5d8c9efd-6d9f-4d2c-894c-253080cb91d3")
        ARCHIMATE(CoreUi.I18N.getString("MetaclassSelectorWidget.models.Archimate"), "Archimate"),
        @objid ("f717b02f-9df5-49c5-8aba-2f3497efa823")
        ANALYST(CoreUi.I18N.getString("MetaclassSelectorWidget.models.Analyst"), "Analyst");

        @objid ("44a87d03-91bf-4cf6-990c-09f18386676b")
        public String label;

        @objid ("723f3dc2-8a01-4b46-8c2b-9f3ea47fe18f")
        public String qualifier;

        @objid ("d7ce5e08-80ef-49f9-ae94-8242c57edbca")
        BusinessMetamodelType(String label, String qualifier) {
            this.label = label;
            this.qualifier = qualifier;
        }

    }

}
