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
package org.modelio.platform.model.ui.panels.search.query.elements.traverse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.modelio.platform.model.ui.panels.search.common.MetamodelHelper;
import org.modelio.platform.model.ui.panels.search.common.MqlDependencyPickerDialog;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.query.Direction;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;

/**
 * UI section for editing TraverseStep parameters (edge + direction).
 * <p>
 * Supports two navigation modes:
 * <ul>
 * <li><b>Link Navigation</b> ("Suivre les liens"): selects a predefined link
 * type (Dependency, Association).</li>
 * <li><b>Model Navigation</b> ("Parcourir le modèle"): free-text edge name for
 * navigating any model reference.</li>
 * </ul>
 */
@objid ("0a02eca4-eccd-4dc0-a162-8a8bffcd5315")
public final class MqlTraversePanel {
    @objid ("ba7925ca-d49e-4c69-8844-e58c8c4b0a0c")
    private boolean updating;

    @objid ("aba3c3b4-bb87-4e47-91da-a84143946999")
    private Composite group;

    @objid ("98c51f69-9add-4402-9349-5163d4cea760")
    private Label hintLabel;

    // --- Mode radio buttons ---
    @objid ("f732d539-6d2a-4250-9eb3-0b079961d4a7")
    private Button radioLinkNav;

    @objid ("1c8fe8c3-f47f-468b-8914-06a27e6e453c")
    private Button radioModelNav;

    // --- Link Navigation sub-panel ---
    @objid ("d9de168c-ba81-464f-a93e-667b3511e634")
    private Composite linkNavComposite;

    @objid ("eb4b4ac4-f8d0-4294-aabf-a5886b7dd210")
    private Combo edgeLinkCombo;

    @objid ("645b7d77-9621-4004-88c8-0189209fa3ad")
    private Button checkInverseDirection;

    // --- Model Navigation sub-panel ---
    @objid ("0fd090c2-2c7f-492a-a4a4-a55ad413684c")
    private Composite modelNavComposite;

    @objid ("c74312da-3fca-4865-95d8-f3d7b184edb1")
    private Text edgeDisplayText;

    @objid ("da9648f1-0f33-4b6b-8af5-805c71b923f3")
    private Button editDependencyButton;

    @objid ("4875393d-e7b1-4b5a-bdf3-224f1a8c6905")
    private MqlStepNode selected;

    @objid ("a1379f3c-7b65-4d22-8ff1-e5b795940ffe")
    private PropertyChangeListener stepListener;

    @objid ("cc399998-dc12-4654-a33c-36f6d2dc6371")
    private ICoreSession session;

    @objid ("18de0f85-2ee2-4931-9e48-0fdea1548166")
    private MqlTraverseExpressionPanel traverseExpressionPanel;

    @objid ("9ecbcc86-45e7-4344-96fa-1b9fd517d077")
    private final MqlQueryModel model;

    @objid ("5d7ad8fc-a6b5-4c52-92d4-c771ec1522ee")
    private MetamodelHelper metamodelHelper;

    @objid ("1ef60014-36cd-46c4-b99e-29e28508da03")
    private org.modelio.platform.model.ui.panels.search.query.elements.core.MqlStepNode.Location selectedLocation;

    @objid ("1bbe7544-3b0d-4605-b7ed-72d8fc29dde6")
    public MqlTraversePanel(final MqlQueryModel model, MetamodelHelper metamodelHelper, ICoreSession session) {
        this.model = Objects.requireNonNull(model, "model");
        this.metamodelHelper = metamodelHelper;
        this.session = session;
    }

    @objid ("a47a2d5f-87c2-49ba-bccd-8e3600171fbf")
    public Composite createControls(final Composite parent) {
        Listener deleteListener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (selectedLocation != null) {
                    switch (selectedLocation.container()) {
                    case TOP_LEVEL:
                        selectedLocation.root().removeStep(selectedLocation.index());
                        break;
                    case UNION_BRANCH:
                        selectedLocation.parentStep().removeUnionBranchStep(selectedLocation.branchIndex(), selectedLocation.index());
                        break;
                    case REPEAT_BODY:
                        selectedLocation.parentStep().removeRepeatBodyStep(selectedLocation.index());
                        break;
                    }
                }
            }
        };
        this.group = PanelUtils.createHeaderComposite(parent, CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.header"), deleteListener);


        Composite radioComposite = new Composite(this.group, SWT.NONE);
        radioComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        radioComposite.setLayout(new GridLayout(1, true));
        PolluxWidgetConfigurator.configureContainer(radioComposite);
        ((GridLayout) radioComposite.getLayout()).verticalSpacing = 5;

        Label navTypeLabel = new Label(radioComposite, SWT.NONE);
        navTypeLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.navTypesSlection.header"));
        PolluxWidgetConfigurator.configureSubtitleField(navTypeLabel);

        this.radioLinkNav = new Button(radioComposite, SWT.RADIO);
        this.radioLinkNav.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.mode.linkNav"));
        this.radioLinkNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.radioLinkNav);
        this.radioLinkNav.setSelection(true);

        this.radioModelNav = new Button(radioComposite, SWT.RADIO);
        this.radioModelNav.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.mode.modelNav"));
        this.radioModelNav.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.radioModelNav);

        createLinkNavigatinPanel();
        createModelNavigationPanel();

        hookControlListeners();
        setSelectedStep(null);
        return this.group;
    }

    @objid ("6eec251d-7331-433c-8113-51887ca8275a")
    private void createModelNavigationPanel() {
        this.modelNavComposite = new Composite(this.group, SWT.NONE);
        this.modelNavComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        PolluxWidgetConfigurator.configureContainer(this.modelNavComposite);
        this.modelNavComposite.setLayout(new GridLayout(2, false));

        Label edgeLbl = new Label(this.modelNavComposite, SWT.NONE);
        edgeLbl.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.metamodelNavigation.label"));
        GridData lblGd = new GridData(SWT.FILL, SWT.CENTER, true, false);
        lblGd.horizontalSpan = 2;
        edgeLbl.setLayoutData(lblGd);
        PolluxWidgetConfigurator.configureStyleForSubtitleField(edgeLbl);

        this.edgeDisplayText = new Text(this.modelNavComposite, SWT.BORDER | SWT.READ_ONLY | SWT.NO_FOCUS);
        GridData edgeData = new GridData(SWT.FILL, SWT.CENTER, true, true);

        this.edgeDisplayText.setLayoutData(edgeData);
        this.edgeDisplayText.setBackground(UIColor.SWT_INFO_BACKGROUND);
        this.edgeDisplayText.setEditable(false);
        this.edgeDisplayText.setEnabled(false);

        this.editDependencyButton = new Button(this.modelNavComposite, SWT.PUSH);
        this.editDependencyButton.setImage(UIImages.EDIT);
        GridData btnGd = new GridData(SWT.CENTER, SWT.CENTER, false, false);
        btnGd.widthHint = 30;
        this.editDependencyButton.setLayoutData(btnGd);

        // --- Hint label ---
        this.hintLabel = new Label(this.modelNavComposite, SWT.WRAP);
        GridData hintGd = new GridData(SWT.FILL, SWT.TOP, true, false);
        hintGd.horizontalSpan = 2;
        this.hintLabel.setLayoutData(hintGd);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(this.hintLabel);
    }

    @objid ("c2fae677-2f64-4c15-9e41-f72f3101b1fb")
    private void createLinkNavigatinPanel() {
        this.linkNavComposite = new Composite(this.group, SWT.NONE);
        this.linkNavComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        this.linkNavComposite.setLayout(new GridLayout(1, false));
        PolluxWidgetConfigurator.configureContainer(this.linkNavComposite);
        ((GridLayout) this.linkNavComposite.getLayout()).verticalSpacing = 5;

        Label edgeLinkLbl = new Label(this.linkNavComposite, SWT.NONE);
        edgeLinkLbl.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.edge.label"));
        this.edgeLinkCombo = new Combo(this.linkNavComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
        this.edgeLinkCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        this.edgeLinkCombo.setItems(this.metamodelHelper.getAvailableLinkMetaclass(null).toArray(new String[0]));
        PolluxWidgetConfigurator.configureSimpleCompositeField(this.group, edgeLinkLbl, this.edgeLinkCombo, null);

        this.checkInverseDirection = new Button(this.linkNavComposite, SWT.CHECK);
        this.checkInverseDirection.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.direction.inverse"));
        this.checkInverseDirection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureSimpleCompositeField(this.group, null, this.checkInverseDirection, null);
    }

    @objid ("2fccc75c-e8d5-44ba-9f29-a240c7246f53")
    public Control getControl() {
        return this.group;
    }

    @objid ("06600fd1-17c1-48f9-8a8a-c3c6042a3676")
    public void setSelectedStep(final MqlStepNode stepNode) {
        unhookSelected();
        this.selected = (stepNode != null && stepNode.isTraverse()) ? stepNode : null;
        this.selectedLocation = this.selected != null ? this.selected.locate() : null;
        boolean show = this.selected != null;

        if (this.group != null && !this.group.isDisposed()) {
            this.group.setVisible(show);
            ((GridData) this.group.getLayoutData()).exclude = !show;
            this.group.getParent().layout(true, true);
        }

        hookSelected();
        refresh();
    }

    @objid ("5fb7f566-9686-4ff7-be4c-de923c4a5f23")
    private void applyLinkNavMode(final boolean linkNav) {
        this.radioLinkNav.setSelection(linkNav);
        this.radioModelNav.setSelection(!linkNav);
        ((GridData) this.linkNavComposite.getLayoutData()).exclude = !linkNav;
        this.linkNavComposite.setVisible(linkNav);
        ((GridData) this.modelNavComposite.getLayoutData()).exclude = linkNav;
        this.modelNavComposite.setVisible(!linkNav);
        this.group.layout(true, true);
        this.group.getParent().layout(true, true);
    }

    @objid ("6409a7a2-659d-45db-8dbe-5b15f12dbffa")
    private void hookControlListeners() {
        // Link Navigation: edge combo listener
        this.edgeLinkCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (updating || selected == null) {
                    return;
                }
                int idx = edgeLinkCombo.getSelectionIndex();
                selected.setTraverseEdge(idx >= 0 ? metamodelHelper.getAvailableLinkMetaclass(null).get(idx) : "");
                hintLabel.setText("");
            }
        });

        // Link Navigation: inverse direction checkbox
        this.checkInverseDirection.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (updating || selected == null) {
                    return;
                }
                Direction direction = checkInverseDirection.getSelection() ? Direction.BACKWARD : Direction.FORWARD;
                selected.setTraverseDirection(direction);
            }
        });

        this.edgeLinkCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (updating || selected == null) {
                    return;
                }
                int idx = edgeLinkCombo.getSelectionIndex();
                String edgeName = idx >= 0 ? metamodelHelper.getAvailableLinkMetaclass(null).get(idx) : "";
                try {
                    selected.setTraverseEdge(edgeName);
                    hintLabel.setText("");
                } catch (RuntimeException ex) {
                    hintLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.navigationPanel.error.edgeEmpty"));
                }
            }
        });

        // Model Navigation: edit dependency button
        this.editDependencyButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (selected == null) {
                    return;
                }
                MqlDependencyPickerDialog dlg = new MqlDependencyPickerDialog(group.getShell(), session, metamodelHelper);
                if (dlg.open() == IDialogConstants.OK_ID) {
                    String picked = dlg.getResult();
                    selected.setTraverseEdge(picked);
                    edgeDisplayText.setText(picked);
                    hintLabel.setText("");
                }
            }
        });

        // Radio: "Suivre les liens"
        this.radioLinkNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioLinkNav.getSelection()) {
                    return;
                }
                applyLinkNavMode(true);
                if (selected != null) {
                    String currentEdge = selected.getTraverseEdge();
                    if (currentEdge == null || !metamodelHelper.getAvailableLinkMetaclass(null).contains(currentEdge)) {
                        selected.setTraverseEdge(metamodelHelper.getAvailableLinkMetaclass(null).get(0));
                    }
                    refresh();
                }
            }
        });

        // Radio: "Parcourir le modèle"
        this.radioModelNav.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (!radioModelNav.getSelection()) {
                    return;
                }
                applyLinkNavMode(false);
                if (selected != null) {
                    String currentEdge = selected.getTraverseEdge();
                    if (currentEdge != null && metamodelHelper.getAvailableLinkMetaclass(null).contains(currentEdge)) {
                        selected.setTraverseEdge("");
                    }
                    refresh();
                }
            }
        });
    }

    @objid ("426551a5-aa20-45a6-9d5a-a0b7f60035f6")
    private void hookSelected() {
        if (this.selected == null || this.group == null || this.group.isDisposed()) {
            return;
        }

        this.stepListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (group == null || group.isDisposed()) {
                    return;
                }
                group.getDisplay().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                    }
                });
            }
        };

        this.selected.addPropertyChangeListener(this.stepListener);
    }

    @objid ("9218610e-b7f6-4243-afe9-589c0a0bf9b5")
    private void unhookSelected() {
        if (this.selected != null && this.stepListener != null) {
            this.selected.removePropertyChangeListener(this.stepListener);
        }
        this.stepListener = null;
    }

    @objid ("f49a6501-5980-473a-8a8f-a7b03c749c62")
    private void refresh() {
        if (this.group == null || this.group.isDisposed()) {
            return;
        }

        this.updating = true;
        try {
            boolean enabled = this.selected != null;
            this.radioLinkNav.setEnabled(enabled);
            this.radioModelNav.setEnabled(enabled);
            this.edgeLinkCombo.setEnabled(enabled);
            this.checkInverseDirection.setEnabled(enabled);

            if (!enabled) {
                applyLinkNavMode(true);
                this.edgeLinkCombo.select(metamodelHelper.getAvailableLinkMetaclass(null).indexOf("Dependency"));
                this.checkInverseDirection.setSelection(false);
                return;
            }

            String modelEdge = Objects.toString(this.selected.getTraverseEdge(), "");
            boolean linkNav = metamodelHelper.getAvailableLinkMetaclass(null).contains(modelEdge);
            applyLinkNavMode(linkNav);

            if (linkNav) {
                int idx = metamodelHelper.getAvailableLinkMetaclass(null).indexOf(modelEdge);
                this.edgeLinkCombo.select(idx >= 0 ? idx : 0);
                this.checkInverseDirection.setSelection(this.selected.getTraverseDirection() == Direction.BACKWARD);
            } else {
                this.edgeDisplayText.setText(modelEdge);
            }

            this.hintLabel.setText("");
        } finally {
            this.updating = false;
        }

        this.group.layout(true, true);
    }

}
