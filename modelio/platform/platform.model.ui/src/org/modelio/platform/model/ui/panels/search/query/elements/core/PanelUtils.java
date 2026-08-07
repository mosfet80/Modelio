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
package org.modelio.platform.model.ui.panels.search.query.elements.core;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.modelio.platform.model.ui.plugin.CoreUi;
import org.modelio.platform.ui.UIImages;
import org.modelio.platform.ui.dialog.PolluxWidgetConfigurator;

@objid ("e7e4589b-8fe6-426d-9420-c514ca6114a3")
public class PanelUtils {
    @objid ("e4f6d33c-f8ac-4ce7-bc88-b95e202ef747")
    public static Composite createHeaderComposite(final Composite parent, String label, Listener deleteListener) {
        Composite root = new Composite(parent, SWT.NONE);
        GridData groupGd = new GridData(SWT.FILL, SWT.TOP, true, false);
        groupGd.exclude = true;
        groupGd.horizontalIndent = 0;
        root.setLayoutData(groupGd);
        root.setVisible(false);
        root.setLayout(new GridLayout(1, false));
        PolluxWidgetConfigurator.configureContainer(root);

        Composite headerComposite = new Composite(root, SWT.NONE);
        PolluxWidgetConfigurator.configureContainer(headerComposite);
        GridLayout hClayout = new GridLayout(2, true);
        hClayout.marginBottom = 0;
        headerComposite.setLayout(hClayout);
        GridData hData = new GridData(SWT.FILL, SWT.TOP, true, true);
        hData.horizontalIndent = 0;
        headerComposite.setLayoutData(hData);

        Label compositeLabel = new Label(headerComposite, SWT.NONE);
        GridData compositeLabelGd = new GridData(SWT.FILL, SWT.BOTTOM, true, false);
        compositeLabel.setLayoutData(compositeLabelGd);
        compositeLabel.setText(label);
        PolluxWidgetConfigurator.configureHeaderStyle(compositeLabel);

        Button deleteBtn = new Button(headerComposite, SWT.PUSH);
        deleteBtn.setImage(UIImages.DELETE);
        deleteBtn.setToolTipText(CoreUi.I18N.getString("MqlExpr.deleteNode"));
        GridData delGd = new GridData(SWT.RIGHT, SWT.TOP, false, false);
        deleteBtn.setLayoutData(delGd);
        if(deleteListener != null) {
            deleteBtn.addListener(SWT.Selection, deleteListener);
        }

        GridData sepData = new GridData(SWT.FILL, SWT.TOP, true, false);
        sepData.horizontalSpan = 2;
        new Label(headerComposite, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(sepData);

        return root;
    }

}
