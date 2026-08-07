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
/*
 * Copyright 2013-2024 Docaposte
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
package org.modelio.uml.ui.ext.handlers;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.model.browser.view.properties.BrowserPropertyKey;
import jakarta.inject.Inject;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.modelio.model.browser.view.BrowserView;
import org.modelio.model.browser.view.panel.ModelBrowserPanelProvider;
import org.modelio.platform.preferences.plugin.Preferences;
import org.modelio.platform.project.services.IProjectService;
import org.modelio.uml.ui.browser.handlers.ProjectBrowserPropertyKey;

@objid ("57414ae2-7baa-448d-bacd-146492600793")
public class ShowFeatureVisibilityHandler {
    @objid ("52132df1-7ff2-4bb0-a559-f3ad5d9d3c80")
    @Inject
    protected IProjectService projectService;

    @objid ("ec20b087-e093-4fa9-9034-0b49fc00e2c4")
    @Inject
    public void initialize(EModelService modelService, MPart part) {
        for(MMenu menu : part.getMenus()) {
            MUIElement toolItem = modelService.find("org.modelio.model.browser.directmenuitem.featurevisibility",menu);
            if(toolItem != null) {
                ((MDirectMenuItem) toolItem).setSelected(Preferences.getPreferences().getBoolean(BrowserPropertyKey.SHOWFEATUREVISIBILITY_PREFKEY));
                break;
            }
        }
    }

    @objid ("4fdb8c9e-78ca-46ed-9d76-67a5a0f2bea8")
    @Execute
    public final void execute(MPart part, MDirectMenuItem menuItem) {
        final ModelBrowserPanelProvider panel = (ModelBrowserPanelProvider) ((BrowserView) part.getObject()).getContributedPanel();
            Preferences.getPreferences().setValue(ProjectBrowserPropertyKey.SHOWFEATUREVISIBILITY_PREFKEY, menuItem.isSelected());
            panel.refresh();
    }

}
