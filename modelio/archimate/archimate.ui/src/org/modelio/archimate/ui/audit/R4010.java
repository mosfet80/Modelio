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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.engine.core.AbstractControl;
import org.modelio.audit.engine.core.AuditEntry;
import org.modelio.audit.engine.core.IAuditEntry;
import org.modelio.audit.engine.core.IAuditExecutionPlan.AuditTrigger;
import org.modelio.audit.engine.core.IControl;
import org.modelio.audit.engine.core.IDiagnosticCollector;
import org.modelio.audit.engine.core.IRule;
import org.modelio.audit.service.AuditSeverity;
import org.modelio.vcore.session.api.model.change.IElementMovedEvent;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Rule implementation origin: AbstractionChecker checkAutoAbstraction
 */
@objid ("b980040e-00f6-4d73-9954-fcf51e7dc3f1")
public class R4010 extends AbstractArchimateRule {
    @objid ("a974f694-b67c-42ad-a17f-484c5e482f12")
    private static final String RULEID = "R4010";

    @objid ("43b1baff-3b3b-49a8-9638-f8cb055bc9da")
    private CheckR4010 checkerInstance;

    @objid ("b97f1d3f-c12f-42cb-9d10-0c70255e6f92")
    @Override
    public String getRuleId() {
        return R4010.RULEID;
    }

    @objid ("c3234520-4524-4597-af7a-1c2f823bb291")
    @Override
    public void autoRegister(ArchimateAuditPlan plan) {
        plan.registerRule(OrJunction.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(AndJunction.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);

    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on
     * some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("258d2b59-be15-4314-9239-5e6095a36dc0")
    @Override
    public IControl getCreationControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on
     * some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("623f81dd-96be-44fc-b57e-42feb88eacda")
    @Override
    public IControl getMoveControl(IElementMovedEvent moveEvent) {
        return null;
    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on
     * some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("3a446a9c-4b10-432e-8bc2-d1e2510a9ec0")
    @Override
    public IControl getUpdateControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default constructor for R4000
     */
    @objid ("39243481-7593-4b60-b98a-29c12c40899e")
    public R4010() {
        this.checkerInstance = new CheckR4010(this);
    }

    @objid ("9936c0d3-b78f-4318-82af-85642198bb9e")
    private static class CheckR4010 extends AbstractControl {
        @objid ("f1ff4988-4ef8-442c-82bd-028ca4dabe7d")
        public CheckR4010(IRule rule) {
            super(rule);
        }

        @objid ("6687bb4c-0d4e-4548-8f1b-a083cf3d9be8")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            if (element instanceof Junction) {
                diagnostic.addEntry(checkR4010((Junction) element));
            } else {
                ArchiUi.LOG.warning("R4010: unsupported element type '%s'", element.getMClass().getName());
            }
            return diagnostic;
        }

        @objid ("c3270187-704c-4be7-9f0c-67bc31403f7d")
        private IAuditEntry checkR4010(Junction junction) {
            AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, junction, null);
            Set<String> linkedMetaclass = new HashSet<>();
            for (Relationship rs : junction.getRelatedFrom()) {
                if (!linkedMetaclass.contains(rs.getMClass().getName())) {
                    linkedMetaclass.add(rs.getMClass().getName());
                }
            }

            for (Relationship rs : junction.getRelatedTo()) {
                if (!linkedMetaclass.contains(rs.getMClass().getName())) {
                    linkedMetaclass.add(rs.getMClass().getName());
                }
            }

            if (linkedMetaclass.size() > 1) {
                auditEntry.setSeverity(this.rule.getSeverity());
                List<Object> linkedObjects = new ArrayList<>();
                linkedObjects.add(junction);
                linkedObjects.add(junction.getMClass().getName());
                auditEntry.setLinkedInfos(linkedObjects);
                return auditEntry;
            }
            return auditEntry;
        }

    }

}
