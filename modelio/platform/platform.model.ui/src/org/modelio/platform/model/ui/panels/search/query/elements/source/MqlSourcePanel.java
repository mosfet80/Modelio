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
package org.modelio.platform.model.ui.panels.search.query.elements.source;

import java.util.List;
import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.platform.model.ui.panels.search.common.MetaclassSelectorWidget;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.panels.search.query.validation.MqlValidationService;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.search.engine.searchers.query.api.model.result.Diagnostic;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;

/**
 * UI section for editing the query Source.
 */
@objid ("b4dc0d87-ef78-4698-b3a6-9205fd3f8623")
public final class MqlSourcePanel {
    /**
     * Prevents infinite refresh loop
     */
    @objid ("0816fa5c-4c1c-40ca-a2d3-f098024f237e")
    private boolean refreshInProgress;

    @objid ("524bda31-e9a9-4292-b653-d66c59a5dbce")
    private Label issuesLabel;

    @objid ("2bedb4c6-c5ee-440d-9290-47561a0aa65f")
    private Composite kindComposite;

    @objid ("cb80d295-c820-4cd4-a673-76907f912fb2")
    private Button radioProvided;

    @objid ("35ebc5bf-ebff-46a9-951e-0ae55cc8ef60")
    private Button radioAllByType;

    @objid ("e7b2f023-0a1f-4cb0-9bb2-dfe109581d33")
    private MetaclassSelectorWidget metaclassSelector;

    @objid ("ba95446d-5570-425a-9d9e-3185a6700e06")
    private final MqlQueryModel model;

    @objid ("21e7294a-cd39-4be2-8233-acc55cf5ff4b")
    private final MqlValidationService validationService;

    @objid ("c05ef3e1-36ba-4216-907a-acc3e8852c40")
    private final ICoreSession session;

    @objid ("fb386568-27dd-4d9b-a280-0209d59aacdb")
    public MqlSourcePanel(final MqlQueryModel model, final MqlValidationService validationService, final ICoreSession session) {
        this.model = Objects.requireNonNull(model, "model");
        this.validationService = Objects.requireNonNull(validationService, "validationService");
        this.session = Objects.requireNonNull(session, "session");
    }

    @objid ("4887f4be-840b-40f1-bccd-2f6036405610")
    public Composite createControls(final Composite parent) {
        Composite group = PanelUtils.createHeaderComposite(parent, CoreUi.I18N.getString("MqlQueryEditor.sourcePanel.header"), null);

        createRadioComposite(group);
        createTypeSelectionComposite(group);

        hookListeners();
        refreshUiFromModel();
        return group;
    }

    @objid ("58aa576b-bd6e-4f1a-bff0-763f84e045dc")
    private void createTypeSelectionComposite(Composite group) {
        this.kindComposite = new Composite(group, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(this.kindComposite);
        this.kindComposite.setLayout(new GridLayout(1, false));
        GridData hData = new GridData(SWT.FILL, SWT.TOP, true, true);
        hData.horizontalIndent = 0;
        this.kindComposite.setLayoutData(hData);

        this.metaclassSelector = new MetaclassSelectorWidget(this.session, qualifiedType -> {
            if (!this.refreshInProgress) {

                String qualifiedName = null;
                if(qualifiedType instanceof MClass) {
                    qualifiedName = ((MClass) qualifiedType).getQualifiedName();
                } else if(qualifiedType instanceof Stereotype) {
                    qualifiedName = ((Stereotype) qualifiedType).getName();
                }

                this.model.getSourceNode().setAllKindRef(qualifiedName);
            }
        });
        this.metaclassSelector.createControls(this.kindComposite);

        this.issuesLabel = new Label(this.kindComposite, SWT.WRAP);
        GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
        this.issuesLabel.setLayoutData(gd);
        this.issuesLabel.setBackground(UIColor.WHITE);
        this.issuesLabel.setForeground(UIColor.COBALT_TEXT);
    }

    @objid ("f5de6487-1ae8-4ff7-8954-ce21ed4329e1")
    private Composite createRadioComposite(Composite group) {
        Composite radioComposite = new Composite(group, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(radioComposite);
        radioComposite.setLayout(new GridLayout(1, true));
        radioComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));

        Label inputTypeLabel = new Label(radioComposite, SWT.NONE);
        inputTypeLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.sourcePanel.typelabel"));
        PolluxWidgetConfigurator.configureSubtitleField(inputTypeLabel);

        this.radioAllByType = new Button(radioComposite, SWT.RADIO);
        this.radioAllByType.setText(CoreUi.I18N.getString("MqlQueryEditor.sourcePanel.radioAllByType"));
        this.radioAllByType.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.radioAllByType);

        this.radioProvided = new Button(radioComposite, SWT.RADIO);
        this.radioProvided.setText(CoreUi.I18N.getString("MqlQueryEditor.sourcePanel.radioProvided"));
        this.radioProvided.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
        PolluxWidgetConfigurator.configureStyleForFieldControl(this.radioProvided);

        return radioComposite;
    }

    @objid ("11fe2cac-9d82-4a97-8823-3c587091b546")
    private void hookListeners() {
        this.radioProvided.addListener(SWT.Selection, e -> {
            if (this.refreshInProgress || !this.radioProvided.getSelection())
                return;
            this.model.getSourceNode().useProvidedSource();
            refreshUiFromModel();
        });

        this.radioAllByType.addListener(SWT.Selection, e -> {
            if (this.refreshInProgress || !this.radioAllByType.getSelection())
                return;
            String qn = this.metaclassSelector.getSelectedQualifiedName();
            if (qn != null) {
                this.model.getSourceNode().setAllKindRef(qn);
            } else {
                // Switch to AllSource with a default kind so the mode changes
                this.model.getSourceNode().setAllKindRef("Standard.Class");
            }
            refreshUiFromModel();
        });
    }

    @objid ("17caae28-0dd5-4f7d-b295-03aa463a3320")
    private void refreshUiFromModel() {
        MqlSourceNode source = this.model.getSourceNode();
        if (source == null)
            return;

        this.refreshInProgress = true;
        try {
            boolean isAll = source.isAll();
            this.radioAllByType.setSelection(isAll);
            this.radioProvided.setSelection(!isAll);

            this.kindComposite.setVisible(isAll);
            //((GridData) this.kindComposite.getLayoutData()).exclude = !isAll;

            if (isAll) {
                String currentKind = source.getAllKindRef();
                if (currentKind != null && !currentKind.isBlank()) {
                    this.metaclassSelector.setSelection(currentKind);
                }
            }

            refreshValidation();

            this.kindComposite.getParent().layout(true, true);
        } finally {
            this.refreshInProgress = false;
        }
    }

    @objid ("8cfe0406-7bca-4e04-989f-84ec54ead9ab")
    private void refreshValidation() {
        MqlSourceNode source = this.model.getSourceNode();
        if (source == null) {
            this.issuesLabel.setText("");
            return;
        }

        // Show source-level diagnostics from the last resolver run
        setIssues(this.validationService.getSourceDiagnostics());
    }

    @objid ("a3cddde2-1405-4754-b136-b50862815b8f")
    private void setIssues(final List<Diagnostic> issues) {
        if (issues == null || issues.isEmpty()) {
            this.issuesLabel.setText("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Diagnostic issue : issues) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append(issue.level()).append(": ").append(issue.message());
        }
        this.issuesLabel.setText(sb.toString());
    }

}
