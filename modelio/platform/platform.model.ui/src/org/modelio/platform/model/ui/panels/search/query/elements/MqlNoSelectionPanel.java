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
package org.modelio.platform.model.ui.panels.search.query.elements;

import java.util.Objects;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.modelio.platform.model.ui.panels.search.query.elements.core.MqlQueryModel;
import org.modelio.platform.model.ui.panels.search.query.elements.core.PanelUtils;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIColor;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator.FieldLabelStyle;

/**
 * Right-panel section always visible at the top of the right panel.
 * <p>
 * Contains:
 * <ul>
 * <li>A hint label shown when no pipeline node is selected.</li>
 * <li>A "Name" text field to edit the query name.</li>
 * <li>Limits fields (max depth, result limit, timeout) inlined from the former
 * MqlLimitsSection.</li>
 * </ul>
 */
@objid ("76191e54-ac6e-4b9a-bc08-0d2f004cf294")
public final class MqlNoSelectionPanel {
    @objid ("2f713688-6363-45c0-ac06-89377d23f9f5")
    private Text nameText;

    @objid ("9c9d44d3-5492-4f95-9e9d-88354b2fccc9")
    private Text maxDepthText;

    @objid ("a3ffd288-33b2-4d2e-a2d2-ebfec958f21a")
    private Text limitText;

    @objid ("aa16d091-2c39-484b-8258-da3110617b4b")
    private Text timeoutMsText;

    @objid ("c9615998-faf9-4fcd-a7f1-bacf92d6dded")
    private Label limitsIssuesLabel;

    @objid ("c4bef8f2-a629-425e-b548-5b4eeb5f3519")
    private Composite root;

    @objid ("12e63b91-e3bc-41c9-9042-a6d7b899aa6a")
    private final MqlQueryModel model;

    @objid ("c813b1bd-be80-4d54-9fd7-063d80b24536")
    public MqlNoSelectionPanel(MqlQueryModel model) {
        this.model = model;
    }

    @objid ("1b6e4f2d-f97a-4d84-b51e-3b8b07cf49a8")
    public Control createControls(final Composite parent) {
        this.root = PanelUtils.createHeaderComposite(parent,CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.header"),null);




        createPropertyPanel();

        createLimitePanel();

        refreshLimitsFromModel();
        hookLimitListeners();

        return this.root;
    }

    @objid ("3e08fb94-5d12-4daf-92ce-708957952963")
    private void createLimitePanel() {
        Composite limitPanel = new Composite(this.root, SWT.NONE);
        limitPanel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        PolluxWidgetConfigurator.configureContainer(limitPanel);
        ((GridLayout)limitPanel.getLayout()).marginBottom=10;

        Label limitHeader = new Label(limitPanel, SWT.NONE);
        limitHeader.setText(CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.MqlLimits.header"));
        PolluxWidgetConfigurator.configureSubtitleField(limitHeader);

        this.limitText = createLimitField(limitPanel,CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.MqlLimits.resultLimit"));
        this.timeoutMsText = createLimitField(limitPanel,CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.MqlLimits.timeoutMs"));
        this.maxDepthText = createLimitField(limitPanel,CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.MqlLimits.maxDepth"));

        this.limitsIssuesLabel = new Label(limitPanel, SWT.WRAP);
        PolluxWidgetConfigurator.configureStyleForFieldLabel(limitsIssuesLabel, FieldLabelStyle.ERROR);

        GridData issuGd = new GridData(SWT.FILL, SWT.TOP, true, false);
        issuGd.horizontalSpan = 2;
        this.limitsIssuesLabel.setLayoutData(issuGd);
    }

    @objid ("47eae2b4-f1af-4b7d-be30-73ee1a8a3129")
    private void createPropertyPanel() {
        Composite propertyPanel = new Composite(this.root, SWT.NONE);
        propertyPanel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
        PolluxWidgetConfigurator.configureContainer(propertyPanel);

        Label propertyHeader = new Label(propertyPanel, SWT.NONE);
        propertyHeader.setText(CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.property.header"));
        PolluxWidgetConfigurator.configureSubtitleField(propertyHeader);

        Label nameLabel = new Label(propertyPanel, SWT.NONE);
        nameLabel.setText(CoreUi.I18N.getString("MqlQueryEditor.noSelectionPanel.queryName.label"));
        this.nameText = new Text(propertyPanel, SWT.BORDER | SWT.SINGLE);
        this.nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureSimpleCompositeField(propertyPanel, nameLabel, this.nameText, null);
    }

    @objid ("e8399f54-416c-4add-a01f-689a8063ada8")
    public void setVisible(final boolean visible) {
        this.root.setVisible(visible);
        ((GridData) this.getControl().getLayoutData()).exclude = !visible;
    }

    @objid ("65ffb3fe-cbc2-4b73-b7f0-480dbea8a5f0")
    public Control getControl() {
        return this.root;
    }

    @objid ("9ba162fc-ab51-47d6-8ec0-60a4db9ab844")
    private Text createLimitField(Composite parent, final String labelText) {
        Label fieldLabel = new Label(parent, SWT.NONE);
        fieldLabel.setText(labelText);
        Text t = new Text(parent, SWT.BORDER);
        t.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        PolluxWidgetConfigurator.configureSimpleCompositeField(parent, fieldLabel, t, null);
        return t;
    }

    @objid ("e6cee2c4-7408-42be-936e-ccf9bda4ec30")
    private void hookLimitListeners() {
        this.nameText.addModifyListener(e -> {
            this.model.setName(this.nameText.getText());
            refreshLimitsValidation();
        });
        hookLimitField(this.maxDepthText, v -> this.model.setLimitsMaxDepth(v));
        hookLimitField(this.limitText, v -> this.model.setLimitsLimit(v));
        hookLimitField(this.timeoutMsText, v -> this.model.setLimitsTimeoutMs(v != null ? (long) v : null));
    }

    @objid ("3993c95c-7670-4354-b32f-04ed48408861")
    private void hookLimitField(final Text field, final ValueIntSetter setter) {
        field.addModifyListener(e -> {
            ParseResult parsed = parseNullableInt(field.getText());
            if (parsed.valid) {
                setter.set(parsed.value);
            }
            refreshLimitsValidation();
        });
    }

    @objid ("ab933bbb-f3c0-439b-949f-2265df993c7e")
    private void refreshLimitsFromModel() {
        if (this.model == null)
            return;
        setText(this.nameText, this.model.getName());
        setText(this.maxDepthText, this.model.getLimits().getMaxDepth());
        setText(this.limitText, this.model.getLimits().getLimit());
        setText(this.timeoutMsText, this.model.getLimits().getTimeoutMs());
    }

    @objid ("b304dbe9-e418-485e-bd17-c106f8e4f2c7")
    private static void setText(final Text field, final Number value) {
        if (field == null || field.isDisposed())
            return;
        field.setText(value != null ? String.valueOf(value) : "");
    }

    @objid ("38dc84aa-3b6d-4325-ad24-c30a5c1bc7f1")
    private static void setText(final Text field, final String value) {
        if (field == null || field.isDisposed())
            return;
        field.setText(value != null ? String.valueOf(value) : "");
    }

    @objid ("7024b44b-ba1b-480c-9e35-c6303733bb63")
    private void refreshLimitsValidation() {
        if (this.limitsIssuesLabel == null || this.limitsIssuesLabel.isDisposed())
            return;

        ParseResult mdp = parseNullableInt(this.maxDepthText != null ? this.maxDepthText.getText() : "");
        ParseResult lmp = parseNullableInt(this.limitText != null ? this.limitText.getText() : "");
        ParseResult tmp = parseNullableInt(this.timeoutMsText != null ? this.timeoutMsText.getText() : "");

        if (!mdp.valid || !lmp.valid || !tmp.valid) {
            this.limitsIssuesLabel.setText(CoreUi.I18N.getString("MqlLimits.error.numbersOnly"));
            this.root.layout(true, true);
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (mdp.value != null && mdp.value < 0)
            sb.append(CoreUi.I18N.getString("MqlLimits.error.maxDepthNegative")).append("\n");
        if (lmp.value != null && lmp.value < 0)
            sb.append(CoreUi.I18N.getString("MqlLimits.error.limitNegative")).append("\n");
        if (tmp.value != null && tmp.value < 0)
            sb.append(CoreUi.I18N.getString("MqlLimits.error.timeoutNegative")).append("\n");
        String text = sb.toString().trim();
        this.limitsIssuesLabel.setText(text);
        if (!text.isEmpty()) {
            this.root.layout(true, true);
        }
    }

    @objid ("d21f6634-60a9-45e5-9a78-47f51d3491c3")
    private static ParseResult parseNullableInt(final String text) {
        if (text == null)
            return new ParseResult(true, null);
        String trimmed = text.trim();
        if (trimmed.isEmpty())
            return new ParseResult(true, null);
        try {
            return new ParseResult(true, Integer.valueOf(trimmed));
        } catch (NumberFormatException e) {
            return new ParseResult(false, null);
        }
    }

    @objid ("8c640b7a-fe9a-4713-95d4-f3b3dc92cb02")
    private record ParseResult ( boolean valid,
            Integer value )  {
    }

    @objid ("d5afa837-4f17-417d-9aa7-5e9e7dd6745f")
    private interface ValueIntSetter {
        @objid ("98335061-db7b-44c0-b3f1-201905fc6e18")
        void set(Integer value);

    }

}
