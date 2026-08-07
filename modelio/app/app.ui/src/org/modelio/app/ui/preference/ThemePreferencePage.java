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
package org.modelio.app.ui.preference;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.inject.Inject;
import org.eclipse.e4.ui.css.swt.theme.IThemeEngine;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Control;
import org.modelio.app.ui.plugin.AppUi;
import org.modelio.platform.preferences.plugin.Preferences;

@objid ("a2fdf7be-9af4-4b48-98df-eb0d1956c8cb")
public class ThemePreferencePage extends FieldEditorPreferencePage {
    @objid ("0d1507be-0584-4eab-91c0-d0135a417b15")
    public static final String APP_THEME = "MODELIO_UI.Them";

    @objid ("9828c44c-f148-46d2-93c2-47e50fc36b28")
    private ComboFieldEditor themSelector;

    @objid ("617e23d1-77c1-4b08-b233-478d8946ce97")
    private IThemeEngine engine;

    @objid ("2a9d104b-a534-48e6-ad6e-d23aa6fe5d4b")
    @Inject
    public ThemePreferencePage(IThemeEngine engine) {
        super(GRID);
        this.engine = engine;
        init();
    }

    @objid ("3cfe1eb8-d562-4742-b6a5-cf5a8de611a9")
    private void init() {
        setPreferenceStore(Preferences.getPreferences());
        this.setDescription(AppUi.I18N.getMessage("Preference.Description"));
        Preferences.getPreferences().setDefault(APP_THEME, ThemeEnum.LIGHT.getThemeId());
    }

    @objid ("a337b923-8d15-40d0-bfc5-29f8f02ace2b")
    @Override
    protected void createFieldEditors() {
        String[][] predefinedThemValues = new String[][] { { ThemeEnum.LIGHT.getLabel(), ThemeEnum.LIGHT.getThemeId() },
        { ThemeEnum.DARK.getLabel(), ThemeEnum.DARK.getThemeId() },
        { ThemeEnum.SYSTEM.getLabel(), ThemeEnum.SYSTEM.getThemeId() } };

        this.themSelector = new ComboFieldEditor(ThemePreferencePage.APP_THEME,
        AppUi.I18N.getString("Preference.Them"), predefinedThemValues, getFieldEditorParent());
        addField(this.themSelector);

        // Check model size and disable option if model is bigger than MAX_MODEL_SIZE
    }

    @objid ("90301c28-ee92-4053-a3df-dc765a150377")
    @Override
    public boolean performOk() {
        final boolean ret = super.performOk();
        if (this.engine.getActiveTheme() == null) {
        this.engine.setTheme(ThemeEnum.LIGHT.getThemeId() , true);
        } else {
        if (!this.engine.getActiveTheme().getId().equals(Preferences.getPreferences().getString(APP_THEME))) {
        this.engine.setTheme(Preferences.getPreferences().getString(APP_THEME), true);
        }
        }

        return ret;
    }

    @objid ("3d01a95b-6a40-449d-be65-7d4bab22e4d9")
    @Override
    protected void setControl(Control newControl) {
        super.setControl(newControl);
        if (getPreferenceStore() == null) {
        this.setVisible(false);
        }
    }

}
