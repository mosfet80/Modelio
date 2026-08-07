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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
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
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Rule implementation origin: AbstractionChecker checkAutoAbstraction
 */
@objid ("206d4f97-2f59-47aa-a046-6385d7c5f0dd")
public class R4000 extends AbstractArchimateRule {
    @objid ("9e927c09-9e3b-45c8-8d00-4a1cb1d6ea75")
    private static final String RULEID = "R4000";

    @objid ("55bec531-32db-41d6-ad14-b8789881d8c2")
    private CheckR4000 checkerInstance;

    @objid ("775c459b-478b-4cdf-b6a2-5beefeae0b6c")
    @Override
    public String getRuleId() {
        return R4000.RULEID;
    }

    @objid ("0f07f6e4-46bc-4fb6-975c-4488290122d9")
    @Override
    public void autoRegister(ArchimateAuditPlan plan) {
        plan.registerRule(Access.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Influence.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Serving.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Association.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Specialization.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Triggering.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Flow.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Aggregation.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Composition.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Assignment.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        plan.registerRule(Realization.MQNAME, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);

    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("77f182e5-9bf9-41e7-8761-53ba06cc376d")
    @Override
    public IControl getCreationControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("7c737729-0139-4288-bb50-dfb399bbb26d")
    @Override
    public IControl getMoveControl(IElementMovedEvent moveEvent) {
        return null;
    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("8edd8cac-3c57-4bf5-823b-ef252eb8c554")
    @Override
    public IControl getUpdateControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default constructor for R4000
     */
    @objid ("0c84bca5-868d-42a1-9af1-7283f796b758")
    public R4000() {
        this.checkerInstance = new CheckR4000(this);
    }

    @objid ("49e7c8c4-2aec-48f5-b7de-6d438e89f3e2")
    private static class CheckR4000 extends AbstractControl {
        @objid ("29acbeaf-0a54-42aa-9c9c-cf23115e6215")
        public CheckR4000(IRule rule) {
            super(rule);
        }

        @objid ("2bdd763c-1f79-4869-ac8e-f10b878bbe64")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            if (element instanceof Relationship) {
                diagnostic.addEntry(checkR4000((Relationship) element));
            } else {
                ArchiUi.LOG.warning("R4000: unsupported element type '%s'", element.getMClass().getName());
            }
            return diagnostic;
        }

        @objid ("9998caa4-73be-4433-9a41-457813062b12")
        private IAuditEntry checkR4000(Relationship relationship) {
            AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(),  AuditSeverity.AuditSuccess,
                    relationship,
                    null);

            MExpert mExpert = relationship.getMClass().getMetamodel().getMExpert();


            if (!mExpert.canLink(relationship.getMClass(), relationship.getFrom(), relationship.getTo())) {
                // test failed
                auditEntry.setSeverity(this.rule.getSeverity());
                List<Object> linkedObjects = new ArrayList<>();
                linkedObjects.add(relationship);
                linkedObjects.add(relationship.getMClass().getName());
                linkedObjects.add(relationship.getFrom());
                linkedObjects.add(relationship.getFrom().getMClass().getName());
                linkedObjects.add(relationship.getTo());
                linkedObjects.add(relationship.getTo().getMClass().getName());
                auditEntry.setLinkedInfos(linkedObjects);
            }
            return auditEntry;
        }

    }

}
