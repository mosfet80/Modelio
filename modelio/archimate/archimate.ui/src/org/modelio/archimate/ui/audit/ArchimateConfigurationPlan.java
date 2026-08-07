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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.swt.graphics.Image;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.extension.IAuditConfigurationPlan;
import org.modelio.audit.preferences.model.AuditCategory;
import org.modelio.audit.preferences.model.AuditRule;
import org.modelio.platform.model.ui.swt.images.MetamodelImageService;

@objid ("04f7ac41-4a02-44fb-a5a8-f795df7779ee")
public class ArchimateConfigurationPlan implements IAuditConfigurationPlan {
    @objid ("7a9018c8-d364-4c5a-97f2-5cb92f745c17")
    private List<AuditCategory> rootCategories;

    @objid ("aa5932ce-b28f-4d37-8d93-e75bc7116574")
    public ArchimateConfigurationPlan(List<AuditCategory> rootCategories) {
        this.rootCategories = rootCategories;
    }

    @objid ("021b2849-a361-4d94-a604-20c8f292aad8")
    @Override
    public List<AuditCategory> getRootCategories() {
        return this.rootCategories;
    }

    @objid ("3e2bc6ba-9170-45d0-861b-18e48d04723a")
    @Override
    public String getLabel(AuditCategory category) {
        return ArchiUi.I18N.getString(IAuditConfigurationPlan.CATEGORY_PREFIX + category.getId() + ".label");
    }

    @objid ("a55d2646-b40a-43be-b911-5df39f922542")
    @Override
    public String getMessage(String ruleId) {
        return ArchiUi.I18N.getString(IAuditConfigurationPlan.RULE_PREFIX + ruleId + ".message");
    }

    @objid ("cd687edd-9ee1-4bce-9ac1-ae843c18b4b5")
    @Override
    public String getDescription(AuditRule rule) {
        return ArchiUi.I18N.getString(IAuditConfigurationPlan.RULE_PREFIX + rule.getId() + ".description");
    }

    @objid ("65bbd3ff-e984-492e-819f-1e7acbf1f64e")
    @Override
    public String getLabel(AuditRule element) {
        return element.getId();
    }

    @objid ("6fcdcba5-a27e-4483-a1f6-dfb572076c6a")
    @Override
    public Image getImage(AuditCategory category) {
        switch (category.getId()) {
        case "Archimate":
            return MetamodelImageService.getIcon(ApplicationComponent.MQNAME);
        case "Others":
            // No icon yet...
        default:
            break;

        }
        return null;
    }

}
