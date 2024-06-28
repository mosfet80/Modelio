/* 
 * Copyright 2013-2020 Modeliosoft
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
package org.modelio.xmi.preferences;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Control;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.xmi.api.FormatExport;
import org.modelio.xmi.api.XMIExtension;
import org.modelio.xmi.plugin.Xmi;

/**
 * XMI preferences page.
 */
@objid ("e5cb73bb-449f-4642-a161-3e2fd421b118")
public class XmiPreferencesPage extends FieldEditorPreferencePage {
    @objid ("ee647b9c-996f-4fdc-b0c0-06eb080c0c7e")
    private ComboFieldEditor formatField;

    @objid ("bda69dd4-01e5-4efb-8661-92b6c8a5be4b")
    private ComboFieldEditor extensionField;

    @objid ("59b8e4f0-888b-4741-8335-9f7ad53fbab2")
    private BooleanFieldEditor compatibilityField;

    /**
     * XMI preferences page.
     * <p>
     * This class represents a preference page that
     * is contributed to the Preferences dialog. By
     * subclassing <samp>FieldEditorPreferencePage</samp>, we
     * can use the field support built into JFace that allows
     * us to create a page that is small and knows how to
     * save, restore and apply itself.
     * <p>
     * This page is used to modify preferences only. They
     * are stored in the preference store that belongs to
     * the main plug-in class. That way, preferences can
     * be accessed directly via the preference store.
     * @param projectService : the Modelio project service used for project management
     */
    @objid ("50d88f00-a8e7-4e21-a996-f6e9fd2e13cd")
    @Inject
    public  XmiPreferencesPage(IProjectService projectService) {
        super(GRID);
        init(projectService);
        
    }

    @objid ("70dfb2cf-ce89-4745-8624-9b2e196b960f")
    @Override
    public void createFieldEditors() {
        if (getPreferenceStore() != null) {
            String[][] formatValues = new String[][] { { Xmi.I18N.getString("$ui.parameter.versionExport." + FormatExport.EMF300.toString()), FormatExport.EMF300.toString() },
                    { Xmi.I18N.getString("$ui.parameter.versionExport." + FormatExport.UML211.toString()), FormatExport.UML211.toString() },
                    { Xmi.I18N.getString("$ui.parameter.versionExport." + FormatExport.UML22.toString()), FormatExport.UML22.toString() },
                    { Xmi.I18N.getString("$ui.parameter.versionExport." + FormatExport.UML23.toString()), FormatExport.UML23.toString() },
                    { Xmi.I18N.getString("$ui.parameter.versionExport." + FormatExport.UML241.toString()), FormatExport.UML241.toString() } };
        
            this.formatField = new ComboFieldEditor(XmiPreferencesKeys.XMIFORMAT_PREFKEY,
                    Xmi.I18N.getString("xmiprefpage.format.label"), formatValues, getFieldEditorParent());
            addField(this.formatField);
        
            String[][] extensionValues = new String[][] { { XMIExtension.XMI.toString(), XMIExtension.XMI.toString() },
                    { XMIExtension.UML.toString(), XMIExtension.UML.toString() } };
        
            this.extensionField = new ComboFieldEditor(XmiPreferencesKeys.XMIEXTENSION_PREFKEY, Xmi.I18N.getString("xmiprefpage.extension.label"), extensionValues, getFieldEditorParent());
        
            addField(this.extensionField);
        
            this.compatibilityField = new BooleanFieldEditor(XmiPreferencesKeys.XMIANNOTATION_PREFKEY,
                    Xmi.I18N.getString("xmiprefpage.compatibility.label"), getFieldEditorParent());
        
            addField(this.compatibilityField);
        }
        
    }

    @objid ("36bfd509-9405-43d4-948b-23efed3a68be")
    private void init(IProjectService projectService) {
        this.setDescription(Xmi.I18N.getString("preferences.description"));
        
        if ((projectService == null) || (projectService.getOpenedProject() == null)) {
        
            setPreferenceStore(null);
            if (isControlCreated()) {
                setVisible(false);
            }
            noDefaultAndApplyButton();
        
        } else {
            // use project store
            IPreferenceStore preferenceStore = projectService.getProjectPreferences(Xmi.PLUGIN_ID);
            setPreferenceStore(preferenceStore);
        
            preferenceStore.setDefault(XmiPreferencesKeys.XMIANNOTATION_PREFKEY, false);
            preferenceStore.setDefault(XmiPreferencesKeys.XMIEXTENSION_PREFKEY, XMIExtension.XMI.toString());
            preferenceStore.setDefault(XmiPreferencesKeys.XMIFORMAT_PREFKEY, FormatExport.EMF300.toString());
        
        }
        
    }

    @objid ("b9b91e12-b17e-4656-89f9-c76b1c8fdfd4")
    @Override
    public boolean performOk() {
        final boolean ret = super.performOk();
        
        // Protect against NPE, the fields might be null if the page wasn't shown
        if (this.extensionField != null) {
            this.extensionField.store();
        }
        
        if (this.compatibilityField != null) {
            this.compatibilityField.store();
        }
        
        if (this.formatField != null) {
            this.formatField.store();
        }
        return ret;
    }

    @objid ("9891ee15-cd7c-42f5-8aa6-6487061fa14f")
    @Override
    protected void setControl(Control newControl) {
        super.setControl(newControl);
        
        if (getPreferenceStore() == null) {
            this.setVisible(false);
        }
        
    }

}
