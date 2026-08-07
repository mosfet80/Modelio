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
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.engine.core.AbstractControl;
import org.modelio.audit.engine.core.AuditEntry;
import org.modelio.audit.engine.core.IAuditEntry;
import org.modelio.audit.engine.core.IAuditExecutionPlan.AuditTrigger;
import org.modelio.audit.engine.core.IControl;
import org.modelio.audit.engine.core.IDiagnosticCollector;
import org.modelio.audit.engine.core.IRule;
import org.modelio.audit.service.AuditSeverity;
import org.modelio.vcore.model.api.MTools;
import org.modelio.vcore.session.api.model.change.IElementMovedEvent;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * R4030 : name must not be empty nor the default name.
 */
@objid ("5e0f8582-0055-45df-bf83-34726dd1fe6a")
public class R4030 extends AbstractArchimateRule {
    @objid ("d375e3d8-69a1-4f79-a4f3-82868066fbee")
    private static final String RULEID = "R4030";

    /**
     * This field value is generated from the UML model by the Collaboration under the class.
     */
    @objid ("a2ca84dc-de39-4b11-a45f-969065097af9")
    private static final String[] APPLYTO = new String[]{"Archimate.CourseOfAction", "Archimate.Capability", "Archimate.ValueStream", "Archimate.ApplicationEvent", "Archimate.BusinessEvent", "Archimate.ImplementationEvent", "Archimate.TechnologyEvent", "Archimate.ApplicationService", "Archimate.BusinessService", "Archimate.TechnologyService", "Archimate.ApplicationFunction", "Archimate.ApplicationInteraction", "Archimate.ApplicationProcess", "Archimate.BusinessFunction", "Archimate.BusinessInteraction", "Archimate.BusinessProcess", "Archimate.TechnologyFunction", "Archimate.TechnologyInteraction", "Archimate.TechnologyProcess", "Archimate.WorkPackage", "Archimate.Product", "Archimate.Location", "Archimate.Plateau", "Archimate.Assessment", "Archimate.Driver", "Archimate.Goal", "Archimate.Meaning", "Archimate.Outcome", "Archimate.Principle", "Archimate.Requirement", "Archimate.Constraint", "Archimate.Stakeholder", "Archimate.Value", "Archimate.ApplicationInterface", "Archimate.BusinessInterface", "Archimate.TechnologyInterface", "Archimate.BusinessActor", "Archimate.BusinessCollaboration", "Archimate.BusinessRole", "Archimate.ApplicationCollaboration", "Archimate.ApplicationComponent", "Archimate.CommunicationNetwork", "Archimate.DistributionNetwork", "Archimate.Path", "Archimate.Node", "Archimate.Device", "Archimate.Equipment", "Archimate.Facility", "Archimate.SystemSoftware", "Archimate.TechnologyCollaboration", "Archimate.BusinessObject", "Archimate.Contract", "Archimate.Representation", "Archimate.DataObject", "Archimate.Deliverable", "Archimate.Gap", "Archimate.Artifact", "Archimate.Material", "Archimate.Resource"};

    @objid ("29b944e6-b867-4e1e-a817-712f59af9a31")
    private CheckR4030 checkerInstance;

    @objid ("87e9301d-4d1c-41d6-8088-1bdc38b0637e")
    @Override
    public String getRuleId() {
        return R4030.RULEID;
    }

    @objid ("eaa9d05c-1354-4745-a0e2-3ad672d12eeb")
    @Override
    public void autoRegister(ArchimateAuditPlan plan) {
        for (String mc : APPLYTO) {
            plan.registerRule(mc, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        }

    }

    /**
     * Default implementation is using a singleton for the checker. An alternative implementation consists in creating a new instance of the checker for each element to check. This allows for fine tuning of the check depending on the element status or on
     * some external conditions. Use the 'new instance' strategy only if fine tuning of the check is required for each element, because this strategy creates many objects (performance issues).
     */
    @objid ("9fe1aaee-52d5-468c-9fd3-8dfbc9e9803c")
    @Override
    public IControl getCreationControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default implementation is using a singleton for the checker.
     * An alternative implementation consists in creating a new instance of the checker for each element to check.
     * This allows for fine tuning of the check depending on the element status or on
     * some external conditions.
     * Use the 'new instance' strategy only if fine tuning of the check is required for each element,
     * because this strategy creates many objects (performance issues).
     */
    @objid ("05978e49-e7b9-4637-a094-f10046a2a67f")
    @Override
    public IControl getMoveControl(IElementMovedEvent moveEvent) {
        return null;
    }

    /**
     * Default implementation is using a singleton for the checker.
     * <p>
     * An alternative implementation consists in creating a new instance of the checker for each element to check.
     * This allows for fine tuning of the check depending on the element status or on
     * some external conditions.
     * Use the 'new instance' strategy only if fine tuning of the check is required for each element,
     * because this strategy creates many objects (performance issues).
     */
    @objid ("831626b8-301b-4cf2-85b9-2ececae80222")
    @Override
    public IControl getUpdateControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default constructor
     */
    @objid ("a6b48ea9-37a4-4704-a162-d518eac84834")
    public R4030() {
        this.checkerInstance = new CheckR4030(this);
    }

    @objid ("bb1fb3b4-b969-4442-8213-e9f0153f218a")
    private static class CheckR4030 extends AbstractControl {
        @objid ("c938a4d4-cbbd-41ae-adf5-298d1355b91a")
        public CheckR4030(IRule rule) {
            super(rule);
        }

        @objid ("82812847-b57b-4a08-85db-b8fb058718d3")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            if (element instanceof Element) {
                diagnostic.addEntry(check((Element) element));
            } else {
                ArchiUi.LOG.warning("R4030: unsupported element type '%s'", element.getMClass().getName());
            }
            return diagnostic;
        }

        @objid ("1686156a-1c55-404f-9050-6503e6254fd4")
        private IAuditEntry check(Element archiElement) {
            AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, archiElement, null);

            String name = archiElement.getName().strip();
            String defaultName = MTools.get(archiElement).getNamer().getBaseName(archiElement);

            if (name.isEmpty() ||name.equals(defaultName)  || (name.startsWith(defaultName) && isInteger(name.replace(defaultName, "")))) {
                auditEntry.setSeverity(this.rule.getSeverity());
                List<Object> linkedObjects = new ArrayList<>();
                linkedObjects.add(archiElement);
                linkedObjects.add(archiElement.getMClass().getName());
                auditEntry.setLinkedInfos(linkedObjects);
            }
            return auditEntry;
        }

        @objid ("7525a850-d10a-4424-9440-9cd67c794a54")
        public static boolean isInteger(String s) {
            try {
                Integer.parseInt(s);
            } catch(NumberFormatException e) {
                return false;
            } catch(NullPointerException e) {
                return false;
            }
            return true;
        }

    }

}
