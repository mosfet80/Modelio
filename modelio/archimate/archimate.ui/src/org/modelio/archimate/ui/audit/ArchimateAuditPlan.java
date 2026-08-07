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
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.engine.core.AbstractAuditExecutionPlan;
import org.modelio.audit.preferences.model.AuditCategory;
import org.modelio.audit.preferences.model.AuditRule;

@objid ("6fe04e23-a616-4364-a4c5-9e466b9aedbf")
public class ArchimateAuditPlan extends AbstractAuditExecutionPlan {
    @objid ("18fb1854-5fc4-4c9d-be75-3ca196de5368")
    public ArchimateAuditPlan(List<AuditCategory> rootCategories) {
        super(rootCategories);
    }

    @objid ("201c30b4-15f8-4562-ad67-5b0118d8ce94")
    @Override
    protected void initRule(AuditRule rule) {
        try {
            Class<?> ruleClass = Class.forName(rule.getImplClass());
            if (AbstractArchimateRule.class.isAssignableFrom(ruleClass)) {
                AbstractArchimateRule archiRule = (AbstractArchimateRule) ruleClass.getDeclaredConstructor().newInstance();
                archiRule.setSeverity(rule.getSeverity());
                archiRule.autoRegister(this);
            }
        } catch (ClassNotFoundException e) {
            // Should be an old deleted rule.
            ArchiUi.LOG.debug(e);
        } catch (ReflectiveOperationException e) {
            ArchiUi.LOG.warning(e);
        } catch (RuntimeException e) {
            ArchiUi.LOG.warning(e);
        }

    }

}
