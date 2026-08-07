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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
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
 * R4050 : duplicate relation
 */
@objid ("0a5411ba-f48f-402f-a770-de4116f1df56")
public class R4050 extends AbstractArchimateRule {
    @objid ("11c96c6b-7368-4253-8755-ebd83ea34a4d")
    private static final String RULEID = "R4050";

    /**
     * This field value is generated from the UML model by the Collaboration under the class.
     */
    @objid ("b341a838-d9d0-4efc-89b9-7a347bd7313c")
    private static final String[] APPLYTO = new String[]{"Archimate.CourseOfAction", "Archimate.Capability", "Archimate.ValueStream", "Archimate.ApplicationEvent", "Archimate.BusinessEvent", "Archimate.ImplementationEvent", "Archimate.TechnologyEvent", "Archimate.ApplicationService", "Archimate.BusinessService", "Archimate.TechnologyService", "Archimate.ApplicationFunction", "Archimate.ApplicationInteraction", "Archimate.ApplicationProcess", "Archimate.BusinessFunction", "Archimate.BusinessInteraction", "Archimate.BusinessProcess", "Archimate.TechnologyFunction", "Archimate.TechnologyInteraction", "Archimate.TechnologyProcess", "Archimate.WorkPackage", "Archimate.Product", "Archimate.Grouping", "Archimate.Location", "Archimate.Plateau", "Archimate.Assessment", "Archimate.Driver", "Archimate.Goal", "Archimate.Meaning", "Archimate.Outcome", "Archimate.Principle", "Archimate.Requirement", "Archimate.Constraint", "Archimate.Stakeholder", "Archimate.Value", "Archimate.ApplicationInterface", "Archimate.BusinessInterface", "Archimate.TechnologyInterface", "Archimate.BusinessActor", "Archimate.BusinessCollaboration", "Archimate.BusinessRole", "Archimate.ApplicationCollaboration", "Archimate.ApplicationComponent", "Archimate.CommunicationNetwork", "Archimate.DistributionNetwork", "Archimate.Path", "Archimate.Node", "Archimate.Device", "Archimate.Equipment", "Archimate.Facility", "Archimate.SystemSoftware", "Archimate.TechnologyCollaboration", "Archimate.BusinessObject", "Archimate.Contract", "Archimate.Representation", "Archimate.DataObject", "Archimate.Deliverable", "Archimate.Gap", "Archimate.Artifact", "Archimate.Material", "Archimate.Resource", "Archimate.Access", "Archimate.Association", "Archimate.Influence", "Archimate.Serving", "Archimate.Flow", "Archimate.Triggering", "Archimate.Specialization", "Archimate.Aggregation", "Archimate.Assignment", "Archimate.Composition", "Archimate.Realization", "Archimate.AndJunction", "Archimate.OrJunction"};

    @objid ("b08b02df-f449-434e-ae16-c3fc993ba883")
    private CheckR4050 checkerInstance;

    @objid ("9a1a5039-6206-4a8e-b877-3f4d1479d77f")
    @Override
    public String getRuleId() {
        return R4050.RULEID;
    }

    @objid ("09dcc50c-c502-40f8-96c5-b6302bb8f34d")
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
    @objid ("23ac9eff-55a9-4f2b-9611-39966051186a")
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
    @objid ("34211033-14f5-48e6-a596-7390ac9a9f37")
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
    @objid ("89fc4a06-9e7f-451a-b247-58833fa18eb1")
    @Override
    public IControl getUpdateControl(MObject element) {
        return this.checkerInstance;
    }

    /**
     * Default constructor
     */
    @objid ("abfeb9a4-189a-4236-bf80-8a4fe506a021")
    public R4050() {
        this.checkerInstance = new CheckR4050(this);
    }

    @objid ("9c3e6a76-d0db-4867-b356-b48c14b5d6ec")
    private static class CheckR4050 extends AbstractControl {
        @objid ("b602c77d-669f-4217-ad0b-33b113f9717b")
        public CheckR4050(IRule rule) {
            super(rule);
        }

        @objid ("62eefa7c-9f0a-40a3-a22c-b406d648ec0d")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            if (element instanceof Relationship) {
                Relationship rel = (Relationship) element;
                checkRelationships(diagnostic, rel.getFrom().getRelatedTo());
                checkRelationships(diagnostic, rel.getTo().getRelatedFrom());
            }

            if (element instanceof Concept) {
                Concept concept = (Concept) element;
                checkRelationships(diagnostic, concept.getRelatedTo());
                checkRelationships(diagnostic, concept.getRelatedFrom());
            } else {
                ArchiUi.LOG.warning("R4050: unsupported element type '%s'", element.getMClass().getName());
            }
            return diagnostic;
        }

        @objid ("a2c0e935-acf6-41ec-b3b0-e067d28b2385")
        private IAuditEntry checkRelationship(Relationship archiElement) {
            AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, archiElement, null);

            archiElement.getFrom();
            archiElement.getTo();

            String name = archiElement.getName().strip();
            String defaultName = MTools.get(archiElement).getNamer().getBaseName(archiElement);

            if (name.isEmpty() ||name.contains(defaultName)) {
                auditEntry.setSeverity(this.rule.getSeverity());
                List<Object> linkedObjects = new ArrayList<>();
                linkedObjects.add(archiElement);
                linkedObjects.add(archiElement.getMClass().getName());
                auditEntry.setLinkedInfos(linkedObjects);
            }
            return auditEntry;
        }

        @objid ("242bd383-50b5-4b88-800d-60a602f51c12")
        private void checkRelationships(IDiagnosticCollector diagnostic, Collection<Relationship> relations) {
            Map<RelationshipSignature, List<Relationship>> relBySignature = new HashMap<>(relations.size());
            for (Relationship a : relations) {
                relBySignature.computeIfAbsent(new RelationshipSignature(a), s -> new ArrayList<>(3)).add(a);
            }

            for (Entry<RelationshipSignature, List<Relationship>> entry : relBySignature.entrySet()) {
                if (entry.getValue().size() == 1) {
                    AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, entry.getValue().get(0), null);
                    diagnostic.addEntry(auditEntry);
                } else {
                    for (Relationship duplicate : entry.getValue()) {
                        List<Object> linkedObjects = new ArrayList<>();
                        linkedObjects.add(duplicate.getFrom());
                        linkedObjects.add(duplicate.getFrom().getMClass().getName());
                        linkedObjects.add(duplicate.getTo());
                        linkedObjects.add(duplicate.getTo().getMClass().getName());
                        linkedObjects.add(entry.getValue().size());
                        if (duplicate.getExtension().isEmpty()) {
                            linkedObjects.add(duplicate.getMClass().getName());
                        } else {
                            linkedObjects.add(duplicate.getMClass().getName() + "" + duplicate.getExtension().stream().map(MObject::getName).collect(Collectors.joining(",", "<<", ">>")));
                        }
                        linkedObjects.addAll(entry.getValue());

                        AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), this.rule.getSeverity(), duplicate, linkedObjects);
                        diagnostic.addEntry(auditEntry);
                    }
                }
            }

        }

        @objid ("7b69b425-f740-4a5d-a696-0a7b2b1744eb")
        private static class RelationshipSignature {
            @objid ("f71f965f-bc71-4209-bfc2-12ad8790804c")
            private final Relationship wrapped;

            @objid ("826def7c-4bbe-4895-8a83-ec1eaff78d9d")
            public RelationshipSignature(Relationship obj) {
                this.wrapped = obj;
            }

            @objid ("adc114e4-7a8c-4f91-abb6-1ba8f086aa9e")
            public static boolean signatureEquals(Relationship a, Relationship b, boolean withName) {
                return a.getMClass() == b.getMClass()
                        && Objects.equals(a.getFrom(), b.getFrom())
                        && Objects.equals(a.getTo(), b.getTo())
                        && (! withName || a.getName().equals(b.getName()))
                        && a.getExtension().containsAll(b.getExtension())
                        && b.getExtension().containsAll(a.getExtension())
                        ;

            }

            @objid ("57d67f98-2e88-45f0-b390-3d832582d160")
            @Override
            public int hashCode() {
                return Objects.hash(this.wrapped.getMClass(), this.wrapped.getFrom(), this.wrapped.getTo());
            }

            @objid ("1beb73e7-2a52-49d9-b34a-5ed3ee259533")
            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null) {
                    return false;
                }
                if (getClass() != obj.getClass()) {
                    return false;
                }
                RelationshipSignature other = (RelationshipSignature) obj;
                return signatureEquals(this.wrapped, other.wrapped, false);
            }

        }

    }

}
