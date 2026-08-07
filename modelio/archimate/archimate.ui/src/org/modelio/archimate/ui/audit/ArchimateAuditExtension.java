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
package org.modelio.archimate.ui.audit;

import java.net.URL;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.URIUtil;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.engine.core.IAuditExecutionPlan;
import org.modelio.audit.extension.IAuditConfigurationPlan;
import org.modelio.audit.extension.IAuditExtension;
import org.modelio.audit.preferences.model.AuditCategory;
import org.modelio.audit.preferences.model.AuditCategoryBuilder;
import org.osgi.framework.Bundle;

@objid ("7c02b323-d081-4a02-b85b-39e167d2a9a5")
public class ArchimateAuditExtension implements IAuditExtension {
    @objid ("11be2d0d-6a4d-427b-b285-350aef9f4af1")
    private ArchimateConfigurationPlan archimateConfigurationPlan;

    @objid ("a51836af-4629-477f-859f-781b77ecaff0")
    private ArchimateAuditPlan archimateAuditPlan;

    @objid ("2fa327b4-d07c-4cf7-b435-4dbcca123059")
    public ArchimateAuditExtension() {
        List<AuditCategory> categories = loadCategories();
        this.archimateConfigurationPlan = new ArchimateConfigurationPlan(categories);
        this.archimateAuditPlan = new ArchimateAuditPlan(categories);

    }

    @objid ("fded6b64-30ac-4168-bd8d-0270d40c06a2")
    @Override
    public IAuditExecutionPlan getExecutionPlan() {
        return this.archimateAuditPlan;
    }

    @objid ("25a56ea5-73f3-4d76-a664-e73076d35e37")
    @Override
    public IAuditConfigurationPlan getConfigurationPlan() {
        return this.archimateConfigurationPlan;
    }

    @objid ("6ab07f59-0181-4b23-900b-ef7e6c25d9d0")
    private List<AuditCategory> loadCategories() {
        List<AuditCategory> categories;

        Bundle bundle = ArchiUi.getContext().getBundle();
        String s = "platform:/plugin/" + bundle.getSymbolicName() + "/res/archiconfiguration.xml";
        URL url = null;
        try {
            url = new URL(s);
            URL fileURL = FileLocator.toFileURL(url);
            java.nio.file.Path xmlFile = Paths.get(URIUtil.toURI(fileURL));

            categories = AuditCategoryBuilder.parseCategories(xmlFile.toFile());
        } catch (Exception e) {
            ArchiUi.LOG.debug("File path %s is not found!", s);
            ArchiUi.LOG.error(e);
            categories = Collections.emptyList();
        }
        return categories;
    }

}
