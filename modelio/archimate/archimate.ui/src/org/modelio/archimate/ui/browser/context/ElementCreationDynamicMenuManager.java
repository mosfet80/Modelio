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
package org.modelio.archimate.ui.browser.context;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.platform.model.ui.popupmenu.AbstractPopupProvider;
import org.modelio.platform.utils.i18n.BundledMessages;
import org.osgi.framework.Bundle;

/**
 * Dynamically populates the creation menu with Archimate creation items.
 */
@objid ("5d2773b4-3c2f-42b3-861f-370fb96dbda8")
public class ElementCreationDynamicMenuManager extends AbstractPopupProvider {
    @objid ("07574fa1-9fb5-4604-90d8-77075461b9d6")
    @Override
    protected Bundle getBundle() {
        return ArchiUi.getContext().getBundle();
    }

    @objid ("a1e503c2-f444-4658-9666-450e68ad41b2")
    @Override
    protected BundledMessages getI18nBundle() {
        return ArchiUi.I18N;
    }

    @objid ("6298e9ec-c3e1-49be-b944-3dec798381e0")
    @Override
    protected IPath getXmlPath() {
        return new Path("/res/create-popups-archimate.xml");
    }

    @objid ("0ce95839-3c4e-4f02-a9fa-add4a83f0c42")
    @Override
    protected String getMenuIconPath() {
        return "platform:/plugin/" + getBundle().getSymbolicName() + "/icons/createarchimate.png";
    }

    @objid ("a8289c81-d284-4df4-9df2-da0c8c718f99")
    @Override
    protected String getMenuLabel() {
        return ArchiUi.I18N.getString("CreateElementMenu.label");
    }

    @objid ("d9d0ff6e-a4c5-4217-b86a-8a8c463def65")
    @Override
    protected String computeI18nKey(final String sourceMetaclass, final String dependency, final String targetMetaclass, final String targetStereotype) {
        return "$" + sourceMetaclass + "." + dependency + "." + targetMetaclass + targetStereotype;
    }

}
