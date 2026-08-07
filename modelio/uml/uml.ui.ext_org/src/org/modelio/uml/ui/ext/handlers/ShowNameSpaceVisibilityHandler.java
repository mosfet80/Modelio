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

@objid ("9c99874e-99bf-440d-bbe2-9a27b38dcd61")
public class ShowNameSpaceVisibilityHandler {
    @objid ("5872f03e-eb1a-4336-9f82-dc439bc60e1b")
    @Inject
    protected IProjectService projectService;

    @objid ("289d9680-4a5a-4911-82ce-e6a414932b8e")
    @Inject
    public void initialize(EModelService modelService, MPart part) {
        for(MMenu menu : part.getMenus()) {
            MUIElement toolItem = modelService.find("org.modelio.model.browser.directmenuitem.namespacevisibility",menu);
            if(toolItem != null) {
                ((MDirectMenuItem) toolItem).setSelected(Preferences.getPreferences().getBoolean(BrowserPropertyKey.SHOWNAMSPACEVISIBILITY_PREFKEY));
                break;
            }
        }
    }

    @objid ("a1b3b5b1-27dd-482a-a9e5-d5df21ee4cce")
    @Execute
    public final void execute(MPart part, MDirectMenuItem menuItem) {
        final ModelBrowserPanelProvider panel = (ModelBrowserPanelProvider) ((BrowserView) part.getObject()).getContributedPanel();
            Preferences.getPreferences().setValue(ProjectBrowserPropertyKey.SHOWNAMSPACEVISIBILITY_PREFKEY, menuItem.isSelected());
            panel.refresh();
    }

}
