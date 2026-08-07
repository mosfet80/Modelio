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
package org.modelio.archimate.ui.audit;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.ui.plugin.ArchiUi;
import org.modelio.audit.engine.core.AbstractControl;
import org.modelio.audit.engine.core.AuditEntry;
import org.modelio.audit.engine.core.IAuditEntry;
import org.modelio.audit.engine.core.IAuditExecutionPlan.AuditTrigger;
import org.modelio.audit.engine.core.IDiagnosticCollector;
import org.modelio.audit.engine.core.IRule;
import org.modelio.audit.engine.core.IRuleControlPoster;
import org.modelio.audit.service.AuditSeverity;
import org.modelio.metamodel.uml.infrastructure.Element;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * ArchiMate element must appear in one view
 */
@objid ("360fa935-8d31-4949-b037-b976e38586c6")
public class R4040 extends AbstractArchimateRule {
    @objid ("a24b35aa-69d4-4f44-a047-6328d8a45206")
    private static final String RULEID = "R4040";

    /**
     * This field value is generated from the UML model by the Collaboration under the class.
     */
    @objid ("34327e75-1d7b-4c24-930f-454086a9d1b8")
    private static final String[] APPLYTO = new String[]{"Archimate.ArchimateView","Archimate.CourseOfAction", "Archimate.Capability", "Archimate.ValueStream", "Archimate.ApplicationEvent", "Archimate.BusinessEvent", "Archimate.ImplementationEvent", "Archimate.TechnologyEvent", "Archimate.ApplicationService", "Archimate.BusinessService", "Archimate.TechnologyService", "Archimate.ApplicationFunction", "Archimate.ApplicationInteraction", "Archimate.ApplicationProcess", "Archimate.BusinessFunction", "Archimate.BusinessInteraction", "Archimate.BusinessProcess", "Archimate.TechnologyFunction", "Archimate.TechnologyInteraction", "Archimate.TechnologyProcess", "Archimate.WorkPackage", "Archimate.Product", "Archimate.Location", "Archimate.Plateau", "Archimate.Assessment", "Archimate.Driver", "Archimate.Goal", "Archimate.Meaning", "Archimate.Outcome", "Archimate.Principle", "Archimate.Requirement", "Archimate.Constraint", "Archimate.Stakeholder", "Archimate.Value", "Archimate.ApplicationInterface", "Archimate.BusinessInterface", "Archimate.TechnologyInterface", "Archimate.BusinessActor", "Archimate.BusinessCollaboration", "Archimate.BusinessRole", "Archimate.ApplicationCollaboration", "Archimate.ApplicationComponent", "Archimate.CommunicationNetwork", "Archimate.DistributionNetwork", "Archimate.Path", "Archimate.Node", "Archimate.Device", "Archimate.Equipment", "Archimate.Facility", "Archimate.SystemSoftware", "Archimate.TechnologyCollaboration", "Archimate.BusinessObject", "Archimate.Contract", "Archimate.Representation", "Archimate.DataObject", "Archimate.Deliverable", "Archimate.Gap", "Archimate.Artifact", "Archimate.Material", "Archimate.Resource", "Archimate.Access", "Archimate.Association", "Archimate.Influence", "Archimate.Serving", "Archimate.Flow", "Archimate.Triggering", "Archimate.Specialization", "Archimate.Aggregation", "Archimate.Assignment", "Archimate.Composition", "Archimate.Realization", "Archimate.AndJunction", "Archimate.OrJunction"};

    @objid ("d9fbb3da-72dd-4690-8c2f-e364d8411a1f")
    private CheckR4040 checkerInstance;

    @objid ("27b9395c-f133-4dd1-8701-4a6dc16c58c3")
    @Override
    public String getRuleId() {
        return R4040.RULEID;
    }

    @objid ("4eebaad3-0c88-4ae8-87fb-a425c1fa8fc2")
    @Override
    public void autoRegister(ArchimateAuditPlan plan) {
        for (String mc : APPLYTO) {
            plan.registerRule(mc, this, AuditTrigger.CREATE | AuditTrigger.UPDATE);
        }
    }

    @objid ("00ebba16-167d-43a0-9be0-b84f8f3d314d")
    @Override
    public void postCreateControls(IRuleControlPoster poster, MObject createdElement) {
        poster.postControl(this.checkerInstance, createdElement);
    }

    @objid ("eaf12329-6eb8-450d-8980-0d654d756e79")
    @Override
    public void postUpdateControls(IRuleControlPoster poster, MObject updatedElement) {
        poster.postControl(this.checkerInstance, updatedElement);
    }

    /**
     * Default constructor
     */
    @objid ("ba65a867-57dc-47d5-96f9-f33442da725e")
    public R4040() {
        this.checkerInstance = new CheckR4040(this);
    }

    @objid ("429b6806-4ab1-4330-bfb1-be8259c98f45")
    private static class CheckR4040 extends AbstractControl {
        @objid ("c31533f1-0996-4559-9f90-969c029632a2")
        public CheckR4040(IRule rule) {
            super(rule);
        }

        @objid ("5175e1ef-c5c6-46d9-b257-49726faa2687")
        @Override
        public IDiagnosticCollector doRun(IDiagnosticCollector diagnostic, MObject element) {
            if (element instanceof Folder) {
                ArchiUi.LOG.warning("R4040: unsupported element type '%s'", element.getMClass().getName());
            } else if(element instanceof ArchimateView) {
                for(MObject diagElem  : ((ArchimateView)element).getRepresented()) {
                    if(diagElem instanceof Concept) {
                        diagnostic.addEntry(check((Concept) diagElem));
                    }
                }

               for(Element elt : getRelatedElement((ArchimateView)element)) {
                   diagnostic.addEntry(check((Concept) elt));
               }

            }else if (element instanceof Concept) {
                diagnostic.addEntry(check((Concept) element));
            } else {
                ArchiUi.LOG.warning("R4040: unsupported element type '%s'", element.getMClass().getName());
            }
            return diagnostic;
        }

        @objid ("42777ec3-d9a7-4bfc-b3e1-e7ca0c3f09f8")
        private List<Element> getRelatedElement(ArchimateView element) {
            Model context = ((ViewPoint)element.getOrigin()).getContext();
            List<Element> result = new ArrayList<>();
            if(context != null) {
                for(Folder floder : context.getFolder()) {
                    result.addAll(getRelatedElement(floder));
                }

            }
            return result;
        }

        @objid ("6c88fe6d-0b77-4452-9f7d-4108ad8578fb")
        private List<Element> getRelatedElement(Folder folder) {
            List<Element> result = new ArrayList<>();
            result.addAll(folder.getContent());
            for(Folder floder : folder.getFolder()) {
                result.addAll(getRelatedElement(floder));
            }
            return result;
        }

        @objid ("612144a0-407e-42a6-929d-9d93d63bd900")
        private IAuditEntry check(Concept archiElement) {
            AuditEntry auditEntry = new AuditEntry(this.rule.getRuleId(), AuditSeverity.AuditSuccess, archiElement, null);

            if (archiElement.getDiagramElement().isEmpty()) {
                auditEntry.setSeverity(this.rule.getSeverity());
                List<Object> linkedObjects = new ArrayList<>();
                linkedObjects.add(archiElement);
                linkedObjects.add(archiElement.getMClass().getName());
                auditEntry.setLinkedInfos(linkedObjects);
            }
            return auditEntry;
        }

    }

}
