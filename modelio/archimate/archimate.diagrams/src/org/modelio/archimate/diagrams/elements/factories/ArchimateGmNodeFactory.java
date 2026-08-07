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
package org.modelio.archimate.diagrams.elements.factories;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.diagrams.elements.andjunction.GmAndJunction;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.GmApplicationCollaboration;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponent;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEvent;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunction;
import org.modelio.archimate.diagrams.elements.applicationinteraction.GmApplicationInteraction;
import org.modelio.archimate.diagrams.elements.applicationinterface.GmApplicationInterface;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcess;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationService;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifact;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessment;
import org.modelio.archimate.diagrams.elements.businessactor.GmBusinessActor;
import org.modelio.archimate.diagrams.elements.businesscollaboration.GmBusinessCollaboration;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEvent;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunction;
import org.modelio.archimate.diagrams.elements.businessinteraction.GmBusinessInteraction;
import org.modelio.archimate.diagrams.elements.businessinterface.GmBusinessInterface;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObject;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcess;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRole;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessService;
import org.modelio.archimate.diagrams.elements.capability.GmCapability;
import org.modelio.archimate.diagrams.elements.communicationnetwork.GmCommunicationNetwork;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraint;
import org.modelio.archimate.diagrams.elements.contract.GmContract;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfAction;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObject;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverable;
import org.modelio.archimate.diagrams.elements.device.GmDevice;
import org.modelio.archimate.diagrams.elements.distributionnetwork.GmDistributionNetwork;
import org.modelio.archimate.diagrams.elements.driver.GmDriver;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipment;
import org.modelio.archimate.diagrams.elements.facility.GmFacility;
import org.modelio.archimate.diagrams.elements.gap.GmGap;
import org.modelio.archimate.diagrams.elements.goal.GmGoal;
import org.modelio.archimate.diagrams.elements.grouping.GmGrouping;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEvent;
import org.modelio.archimate.diagrams.elements.location.GmLocation;
import org.modelio.archimate.diagrams.elements.material.GmMaterial;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaning;
import org.modelio.archimate.diagrams.elements.node.GmNode;
import org.modelio.archimate.diagrams.elements.orjunction.GmOrJunction;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcome;
import org.modelio.archimate.diagrams.elements.path.GmPath;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateau;
import org.modelio.archimate.diagrams.elements.principle.GmPrinciple;
import org.modelio.archimate.diagrams.elements.product.GmProduct;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentation;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirement;
import org.modelio.archimate.diagrams.elements.resource.GmResource;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholder;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftware;
import org.modelio.archimate.diagrams.elements.technologycollaboration.GmTechnologyCollaboration;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEvent;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunction;
import org.modelio.archimate.diagrams.elements.technologyinteraction.GmTechnologyInteraction;
import org.modelio.archimate.diagrams.elements.technologyinterface.GmTechnologyInterface;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcess;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyService;
import org.modelio.archimate.diagrams.elements.value.GmValue;
import org.modelio.archimate.diagrams.elements.valuestream.GmValueStream;
import org.modelio.archimate.diagrams.elements.viewpoint.GmViewPoint;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackage;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess;
import org.modelio.archimate.metamodel.layers.business.behavior.BusinessService;
import org.modelio.archimate.metamodel.layers.business.composite.Product;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface;
import org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole;
import org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Contract;
import org.modelio.archimate.metamodel.layers.business.structure.passive.Representation;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.ImplementationEvent;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau;
import org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage;
import org.modelio.archimate.metamodel.layers.motivation.Assessment;
import org.modelio.archimate.metamodel.layers.motivation.Constraint;
import org.modelio.archimate.metamodel.layers.motivation.Driver;
import org.modelio.archimate.metamodel.layers.motivation.Goal;
import org.modelio.archimate.metamodel.layers.motivation.Meaning;
import org.modelio.archimate.metamodel.layers.motivation.Outcome;
import org.modelio.archimate.metamodel.layers.motivation.Principle;
import org.modelio.archimate.metamodel.layers.motivation.Requirement;
import org.modelio.archimate.metamodel.layers.motivation.Stakeholder;
import org.modelio.archimate.metamodel.layers.motivation.Value;
import org.modelio.archimate.metamodel.layers.physical.structure.active.DistributionNetwork;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Equipment;
import org.modelio.archimate.metamodel.layers.physical.structure.active.Facility;
import org.modelio.archimate.metamodel.layers.physical.structure.passive.Material;
import org.modelio.archimate.metamodel.layers.strategy.behavior.Capability;
import org.modelio.archimate.metamodel.layers.strategy.behavior.CourseOfAction;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.archimate.metamodel.visitors.DefaultArchimateVisitor;
import org.modelio.diagram.elements.common.group.GmGroup;
import org.modelio.diagram.elements.core.model.IGmDiagram;
import org.modelio.diagram.elements.core.model.factory.IGmNodeFactory;
import org.modelio.diagram.elements.core.node.GmCompositeNode;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.persistence.IPersistent;
import org.modelio.diagram.persistence.IPersistentMigrator;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MRef;

/**
 * Archimate diagram specific implementation of {@link IGmNodeFactory}.
 * <p>
 * This particular implementation:
 * <ul>
 * <li>does not support cascading</li>
 * <li>only processes Archimate elements</li>
 * </ul>
 * </p>
 */
@objid ("32eaa2b7-f817-4469-83a3-93152d5c8ba3")
public class ArchimateGmNodeFactory implements IGmNodeFactory {
    @objid ("afb4370e-0e7f-444a-b415-d72875c35cd5")
    @Override
    public GmNodeModel create(IGmDiagram diagram, GmCompositeNode parent, MObject newElement, Object initialLayoutData) {
        if (parent instanceof GmGroup) {
            // Use the group element factory visitor
            final GroupElementFactoryVisitor v = new GroupElementFactoryVisitor(diagram);

            final GmNodeModel child = (GmNodeModel) newElement.accept(v);
            if (child != null) {
                parent.addChild(child);
            }
            return child;
        } else {
            // Use the node factory visitor
            final NodeFactoryVisitor v = new NodeFactoryVisitor(diagram, parent, initialLayoutData);

            final GmNodeModel child = (GmNodeModel) newElement.accept(v);
            if (child != null) {
                parent.addChild(child);
            }
            return child;
        }

    }

    @objid ("14048103-2009-4195-b9a1-930f0ca1aeae")
    @Override
    public Class<? extends IPersistent> resolveClass(String namespace) {
        try {
            if (namespace.startsWith("org.modelio.archimate.diagrams")) {
                Class<?> clazz = Class.forName(namespace);
                if (clazz != null) {
                    return clazz.asSubclass(IPersistent.class);
                }
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Class not found, return null
        }
        return null;
    }

    @objid ("46806f88-68d0-4a63-84cc-81e5814f4012")
    @Override
    public Class<? extends IPersistentMigrator> resolveMigratorClass(String classNamespace) {
        try {
            Class<?> clazz = Class.forName(classNamespace);
            if (clazz != null) {
                return clazz.asSubclass(IPersistentMigrator.class);
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Class not found, return null
        }
        return null;
    }

    @objid ("7d73db15-42e7-4edc-a03b-acca4f0fd5e3")
    @Override
    public Class<? extends Enum<?>> resolveEnumClass(String enumNamespace) {
        try {
            Class<?> clazz = Class.forName(enumNamespace);
            if (clazz != null && clazz.isEnum()) {
                return (Class<? extends Enum<?>>) clazz;
            }
        } catch (@SuppressWarnings ("unused") ClassNotFoundException | ClassCastException e) {
            // Enum not found, return null
        }
        return null;
    }

    /**
     * Factory visitor that creates instances to put into {@link GmGroup}.
     */
    @objid ("9459fd98-9c3f-4a13-a05e-d749995f0934")
    private class GroupElementFactoryVisitor extends DefaultArchimateVisitor {
        @objid ("d633f6d2-50a9-4d3a-9b36-4b9deee67a44")
        private IGmDiagram diagram;

        @objid ("46d04034-98fc-4043-a622-ebc682e0930d")
        public GroupElementFactoryVisitor(IGmDiagram diagram) {
            this.diagram = diagram;
        }

        @objid ("c38f7fb0-070d-486f-9143-35eac9099ee6")
        @Override
        public Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
            // We don't know what to do with that element.
            return null;
        }

    }

    /**
     * Factory visitor that creates standard GmNodes.
     */
    @objid ("a801639b-aa1e-4e23-82e1-1cc07046d3c7")
    private class NodeFactoryVisitor extends DefaultArchimateVisitor {
        @objid ("3344036d-d0a7-4f8f-af38-ea4b10beb52e")
        private IGmDiagram diagram;

        @objid ("9a6a3832-b96a-4313-9dfb-e0479806ed0b")
        private Object initialLayoutData;

        @objid ("cc4f9473-c04c-49bd-8356-ac6bfc5501cb")
        private GmCompositeNode parent;

        @objid ("c28fec57-03f4-40bf-82ef-e18e315efdcd")
        public NodeFactoryVisitor(IGmDiagram diagram, GmCompositeNode parent, Object initialLayoutData) {
            this.diagram = diagram;
            this.parent = parent;
            this.initialLayoutData = initialLayoutData;

        }

        @objid ("6e325eff-6cbf-46d0-ad95-7153d95df02c")
        @Override
        public Object visitAndJunction(AndJunction theAndJunction) {
            // GmAndJunction
            final GmAndJunction andJunction = new GmAndJunction(this.diagram, theAndJunction, new MRef(theAndJunction));
            andJunction.setLayoutData(this.initialLayoutData);
            return andJunction;
        }

        @objid ("75a1925b-0053-4439-b6f5-621a15f4ca99")
        @Override
        public Object visitApplicationCollaboration(ApplicationCollaboration theApplicationCollaboration) {
            // GmApplicationCollaboration
            final GmApplicationCollaboration applicationcollaboration = new GmApplicationCollaboration(this.diagram, theApplicationCollaboration, new MRef(theApplicationCollaboration));
            applicationcollaboration.setLayoutData(this.initialLayoutData);
            return applicationcollaboration;
        }

        @objid ("7c91727a-551e-4578-b977-29b25c5d0e07")
        @Override
        public Object visitApplicationComponent(ApplicationComponent theApplicationComponent) {
            // GmApplicationComponent
            final GmApplicationComponent applicationcomponent = new GmApplicationComponent(this.diagram, theApplicationComponent, new MRef(theApplicationComponent));
            applicationcomponent.setLayoutData(this.initialLayoutData);
            return applicationcomponent;
        }

        @objid ("fa1f3a48-e9e9-4a37-bc67-bc5ce747e72b")
        @Override
        public Object visitApplicationEvent(ApplicationEvent theApplicationEvent) {
            // GmApplicationEvent
            final GmApplicationEvent applicationevent = new GmApplicationEvent(this.diagram, theApplicationEvent, new MRef(theApplicationEvent));
            applicationevent.setLayoutData(this.initialLayoutData);
            return applicationevent;
        }

        @objid ("108a19ae-bac0-4269-8f39-2c2ba859f305")
        @Override
        public Object visitApplicationFunction(ApplicationFunction theApplicationFunction) {
            // GmApplicationFunction
            final GmApplicationFunction applicationfunction = new GmApplicationFunction(this.diagram, theApplicationFunction, new MRef(theApplicationFunction));
            applicationfunction.setLayoutData(this.initialLayoutData);
            return applicationfunction;
        }

        @objid ("9320fa77-1393-4a88-8b40-ab4d987738f4")
        @Override
        public Object visitApplicationInteraction(ApplicationInteraction theApplicationInteraction) {
            // GmApplicationInteraction
            final GmApplicationInteraction applicationinteraction = new GmApplicationInteraction(this.diagram, theApplicationInteraction, new MRef(theApplicationInteraction));
            applicationinteraction.setLayoutData(this.initialLayoutData);
            return applicationinteraction;
        }

        @objid ("a6755516-84b8-45f2-b450-1d33458718dc")
        @Override
        public Object visitApplicationInterface(ApplicationInterface theApplicationInterface) {
            // GmApplicationInterface
            final GmApplicationInterface applicationinterface = new GmApplicationInterface(this.diagram, theApplicationInterface, new MRef(theApplicationInterface));
            applicationinterface.setLayoutData(this.initialLayoutData);
            return applicationinterface;
        }

        @objid ("04d79b12-34d6-4f62-8bd7-52e2c6e82c8e")
        @Override
        public Object visitApplicationProcess(ApplicationProcess theApplicationProcess) {
            // GmApplicationProcess
            final GmApplicationProcess applicationprocess = new GmApplicationProcess(this.diagram, theApplicationProcess, new MRef(theApplicationProcess));
            applicationprocess.setLayoutData(this.initialLayoutData);
            return applicationprocess;
        }

        @objid ("f0896e8f-aaab-454a-b7e0-5695bd062d52")
        @Override
        public Object visitApplicationService(ApplicationService theApplicationService) {
            // GmApplicationService
            final GmApplicationService applicationservice = new GmApplicationService(this.diagram, theApplicationService, new MRef(theApplicationService));
            applicationservice.setLayoutData(this.initialLayoutData);
            return applicationservice;
        }

        @objid ("6918f689-f9c1-4040-9a96-e0c0f3a97a92")
        @Override
        public Object visitArtifact(Artifact theArtifact) {
            // GmArtifact
            final GmArtifact artifact = new GmArtifact(this.diagram, theArtifact, new MRef(theArtifact));
            artifact.setLayoutData(this.initialLayoutData);
            return artifact;
        }

        @objid ("be97d41d-49fc-4080-8737-71cce7c4322b")
        @Override
        public Object visitAssessment(Assessment theAssessment) {
            // GmAssessment
            final GmAssessment assessment = new GmAssessment(this.diagram, theAssessment, new MRef(theAssessment));
            assessment.setLayoutData(this.initialLayoutData);
            return assessment;
        }

        @objid ("20f9c3fb-6542-40a8-81df-dc8f7b071b4c")
        @Override
        public Object visitBusinessActor(BusinessActor theBusinessActor) {
            // GmBusinessActor
            final GmBusinessActor businessactor = new GmBusinessActor(this.diagram, theBusinessActor, new MRef(theBusinessActor));
            businessactor.setLayoutData(this.initialLayoutData);
            return businessactor;
        }

        @objid ("15d33818-1434-431e-960b-4d26d79db8ee")
        @Override
        public Object visitBusinessCollaboration(BusinessCollaboration theBusinessCollaboration) {
            // GmBusinessCollaboration
            final GmBusinessCollaboration businesscollaboration = new GmBusinessCollaboration(this.diagram, theBusinessCollaboration, new MRef(theBusinessCollaboration));
            businesscollaboration.setLayoutData(this.initialLayoutData);
            return businesscollaboration;
        }

        @objid ("0dd75a38-46ff-4309-9909-a2ef5be9435b")
        @Override
        public Object visitBusinessEvent(BusinessEvent theBusinessEvent) {
            // GmBusinessEvent
            final GmBusinessEvent businessevent = new GmBusinessEvent(this.diagram, theBusinessEvent, new MRef(theBusinessEvent));
            businessevent.setLayoutData(this.initialLayoutData);
            return businessevent;
        }

        @objid ("f9dd8146-22f5-4d60-92b9-4158caa9124b")
        @Override
        public Object visitBusinessFunction(BusinessFunction theBusinessFunction) {
            // GmBusinessFunction
            final GmBusinessFunction businessfunction = new GmBusinessFunction(this.diagram, theBusinessFunction, new MRef(theBusinessFunction));
            businessfunction.setLayoutData(this.initialLayoutData);
            return businessfunction;
        }

        @objid ("a91d1d9c-e642-416e-8872-03e2d0a198f3")
        @Override
        public Object visitBusinessInteraction(BusinessInteraction theBusinessInteraction) {
            // GmBusinessInteraction
            final GmBusinessInteraction businessinteraction = new GmBusinessInteraction(this.diagram, theBusinessInteraction, new MRef(theBusinessInteraction));
            businessinteraction.setLayoutData(this.initialLayoutData);
            return businessinteraction;
        }

        @objid ("328603db-dcf6-4d54-ace6-be689647aea8")
        @Override
        public Object visitBusinessInterface(BusinessInterface theBusinessInterface) {
            // GmBusinessInterface
            final GmBusinessInterface businessinterface = new GmBusinessInterface(this.diagram, theBusinessInterface, new MRef(theBusinessInterface));
            businessinterface.setLayoutData(this.initialLayoutData);
            return businessinterface;
        }

        @objid ("8445902b-0a4b-49ba-bd7a-02b781b5a8ea")
        @Override
        public Object visitBusinessObject(BusinessObject theBusinessObject) {
            // GmBusinessObject
            final GmBusinessObject businessobject = new GmBusinessObject(this.diagram, theBusinessObject, new MRef(theBusinessObject));
            businessobject.setLayoutData(this.initialLayoutData);
            return businessobject;
        }

        @objid ("12221bc9-35f7-4a7f-ba60-dcf577d7fedf")
        @Override
        public Object visitBusinessProcess(BusinessProcess theBusinessProcess) {
            // GmBusinessProcess
            final GmBusinessProcess businessprocess = new GmBusinessProcess(this.diagram, theBusinessProcess, new MRef(theBusinessProcess));
            businessprocess.setLayoutData(this.initialLayoutData);
            return businessprocess;
        }

        @objid ("d6503127-f46b-426e-831a-d478e8b2ee72")
        @Override
        public Object visitBusinessRole(BusinessRole theBusinessRole) {
            // GmBusinessRole
            final GmBusinessRole businessrole = new GmBusinessRole(this.diagram, theBusinessRole, new MRef(theBusinessRole));
            businessrole.setLayoutData(this.initialLayoutData);
            return businessrole;
        }

        @objid ("777e4bd7-952a-4103-a6f8-429e05f301e7")
        @Override
        public Object visitBusinessService(BusinessService theBusinessService) {
            // GmBusinessService
            final GmBusinessService businessservice = new GmBusinessService(this.diagram, theBusinessService, new MRef(theBusinessService));
            businessservice.setLayoutData(this.initialLayoutData);
            return businessservice;
        }

        @objid ("8d2c1280-2877-48aa-9516-265abdf420d2")
        @Override
        public Object visitCapability(Capability theCapability) {
            // GmCapability
            final GmCapability capability = new GmCapability(this.diagram, theCapability, new MRef(theCapability));
            capability.setLayoutData(this.initialLayoutData);
            return capability;
        }

        @objid ("50c1b34b-25f1-4625-b0f9-23aa215eeb85")
        @Override
        public Object visitCommunicationNetwork(CommunicationNetwork theCommunicationNetwork) {
            // GmCommunicationNetwork
            final GmCommunicationNetwork communicationnetwork = new GmCommunicationNetwork(this.diagram, theCommunicationNetwork, new MRef(theCommunicationNetwork));
            communicationnetwork.setLayoutData(this.initialLayoutData);
            return communicationnetwork;
        }

        @objid ("f096c92d-5ba3-4115-812a-40799aedceeb")
        @Override
        public Object visitConstraint(Constraint theConstraint) {
            // GmConstraint
            final GmConstraint constraint = new GmConstraint(this.diagram, theConstraint, new MRef(theConstraint));
            constraint.setLayoutData(this.initialLayoutData);
            return constraint;
        }

        @objid ("f8fb2a4d-13a3-48a6-ab30-75bd15f892f5")
        @Override
        public Object visitContract(Contract theContract) {
            // GmContract
            final GmContract contract = new GmContract(this.diagram, theContract, new MRef(theContract));
            contract.setLayoutData(this.initialLayoutData);
            return contract;
        }

        @objid ("b2d8c070-2bca-4cc7-bbad-832f0a6ae2b6")
        @Override
        public Object visitCourseOfAction(CourseOfAction theCourseOfAction) {
            // GmCourseOfAction
            final GmCourseOfAction courseofaction = new GmCourseOfAction(this.diagram, theCourseOfAction, new MRef(theCourseOfAction));
            courseofaction.setLayoutData(this.initialLayoutData);
            return courseofaction;
        }

        @objid ("e49c01a9-a7e1-4175-a092-9af29b465c63")
        @Override
        public Object visitDataObject(DataObject theDataObject) {
            // GmDataObject
            final GmDataObject dataobject = new GmDataObject(this.diagram, theDataObject, new MRef(theDataObject));
            dataobject.setLayoutData(this.initialLayoutData);
            return dataobject;
        }

        @objid ("c3896136-4792-4b28-be3a-abbbfc2b06c8")
        @Override
        public Object visitDeliverable(Deliverable theDeliverable) {
            // GmDeliverable
            final GmDeliverable deliverable = new GmDeliverable(this.diagram, theDeliverable, new MRef(theDeliverable));
            deliverable.setLayoutData(this.initialLayoutData);
            return deliverable;
        }

        @objid ("5258f427-6d32-483c-a6ee-f7c3d942f336")
        @Override
        public Object visitDevice(Device theDevice) {
            // GmDevice
            final GmDevice device = new GmDevice(this.diagram, theDevice, new MRef(theDevice));
            device.setLayoutData(this.initialLayoutData);
            return device;
        }

        @objid ("17285a78-7382-4a12-be5d-41026aa264b0")
        @Override
        public Object visitDistributionNetwork(DistributionNetwork theDistributionNetwork) {
            // GmDistributionNetwork
            final GmDistributionNetwork distributionnetwork = new GmDistributionNetwork(this.diagram, theDistributionNetwork, new MRef(theDistributionNetwork));
            distributionnetwork.setLayoutData(this.initialLayoutData);
            return distributionnetwork;
        }

        @objid ("fda964d6-2781-40e9-8aae-864b63f0db50")
        @Override
        public Object visitDriver(Driver theDriver) {
            // GmDriver
            final GmDriver driver = new GmDriver(this.diagram, theDriver, new MRef(theDriver));
            driver.setLayoutData(this.initialLayoutData);
            return driver;
        }

        @objid ("6e7a9225-e85c-41d2-9656-786ba71dcd97")
        @Override
        public Object visitEquipment(Equipment theEquipment) {
            // GmEquipment
            final GmEquipment equipment = new GmEquipment(this.diagram, theEquipment, new MRef(theEquipment));
            equipment.setLayoutData(this.initialLayoutData);
            return equipment;
        }

        @objid ("014557eb-60ba-4f2c-a4e2-abd1c9fd974a")
        @Override
        public Object visitFacility(Facility theFacility) {
            // GmFacility
            final GmFacility facility = new GmFacility(this.diagram, theFacility, new MRef(theFacility));
            facility.setLayoutData(this.initialLayoutData);
            return facility;
        }

        @objid ("24bb9256-8d97-46a4-81b5-caf7d4c7b311")
        @Override
        public Object visitGap(Gap theGap) {
            // GmGap
            final GmGap gap = new GmGap(this.diagram, theGap, new MRef(theGap));
            gap.setLayoutData(this.initialLayoutData);
            return gap;
        }

        @objid ("69ad1cc3-6c31-441e-846e-d807a6b5bc9f")
        @Override
        public Object visitGoal(Goal theGoal) {
            // GmGoal
            final GmGoal goal = new GmGoal(this.diagram, theGoal, new MRef(theGoal));
            goal.setLayoutData(this.initialLayoutData);
            return goal;
        }

        @objid ("9ee90ca5-e11d-4fe0-a4b9-b037ee0b8a15")
        @Override
        public Object visitGrouping(Grouping theGrouping) {
            // GmGrouping
            final GmGrouping grouping = new GmGrouping(this.diagram, theGrouping, new MRef(theGrouping));
            grouping.setLayoutData(this.initialLayoutData);
            return grouping;
        }

        @objid ("45c41fe5-b2a2-4d9d-a54b-5b2047b576a3")
        @Override
        public Object visitImplementationEvent(ImplementationEvent theImplementationEvent) {
            // GmImplementationEvent
            final GmImplementationEvent implementationevent = new GmImplementationEvent(this.diagram, theImplementationEvent, new MRef(theImplementationEvent));
            implementationevent.setLayoutData(this.initialLayoutData);
            return implementationevent;
        }

        @objid ("528039db-5dc4-40f1-839b-384c57d191d1")
        @Override
        public Object visitLocation(Location theLocation) {
            // GmLocation
            final GmLocation location = new GmLocation(this.diagram, theLocation, new MRef(theLocation));
            location.setLayoutData(this.initialLayoutData);
            return location;
        }

        @objid ("30ab870b-5581-416a-aa6a-c28fa0c7ad3c")
        @Override
        public Object visitMaterial(Material theMaterial) {
            // GmMaterial
            final GmMaterial material = new GmMaterial(this.diagram, theMaterial, new MRef(theMaterial));
            material.setLayoutData(this.initialLayoutData);
            return material;
        }

        @objid ("f3e1f84c-9d43-43a9-a1f4-2acb428b3429")
        @Override
        public Object visitMeaning(Meaning theMeaning) {
            final GmMeaning meaning = new GmMeaning(this.diagram, theMeaning, new MRef(theMeaning));
            meaning.setLayoutData(this.initialLayoutData);
            return meaning;
        }

        @objid ("f815f4bf-d151-4a8f-b268-33ec7d7b1946")
        @Override
        public Object visitNode(Node theNode) {
            // GmNode
            final GmNode node = new GmNode(this.diagram, theNode, new MRef(theNode));
            node.setLayoutData(this.initialLayoutData);
            return node;
        }

        @objid ("ede4637c-4054-4172-a5a7-592fc42dfc43")
        @Override
        public Object visitOrJunction(OrJunction theOrJunction) {
            // GmOrJunction
            final GmOrJunction orJunction = new GmOrJunction(this.diagram, theOrJunction, new MRef(theOrJunction));
            orJunction.setLayoutData(this.initialLayoutData);
            return orJunction;
        }

        @objid ("02a9a53b-a35c-4570-9262-32934d342a8b")
        @Override
        public Object visitOutcome(Outcome theOutcome) {
            // GmOutcome
            final GmOutcome outcome = new GmOutcome(this.diagram, theOutcome, new MRef(theOutcome));
            outcome.setLayoutData(this.initialLayoutData);
            return outcome;
        }

        @objid ("3efe0185-c96a-441c-b67b-96e58543eff0")
        @Override
        public Object visitPath(Path thePath) {
            // GmPath
            final GmPath path = new GmPath(this.diagram, thePath, new MRef(thePath));
            path.setLayoutData(this.initialLayoutData);
            return path;
        }

        @objid ("17f615bf-624c-464e-822b-6ac81f039f27")
        @Override
        public Object visitPlateau(Plateau thePlateau) {
            // GmPlateau
            final GmPlateau plateau = new GmPlateau(this.diagram, thePlateau, new MRef(thePlateau));
            plateau.setLayoutData(this.initialLayoutData);
            return plateau;
        }

        @objid ("96278584-303e-4f7a-9b88-341cd4908a7e")
        @Override
        public Object visitPrinciple(Principle thePrinciple) {
            final GmPrinciple principle = new GmPrinciple(this.diagram, thePrinciple, new MRef(thePrinciple));
            principle.setLayoutData(this.initialLayoutData);
            return principle;
        }

        @objid ("0a8727a0-bf84-4554-a06f-2fbf1343d68e")
        @Override
        public Object visitProduct(Product theProduct) {
            // GmProduct
            final GmProduct product = new GmProduct(this.diagram, theProduct, new MRef(theProduct));
            product.setLayoutData(this.initialLayoutData);
            return product;
        }

        @objid ("6221bf77-3cdb-41bd-81ec-d7b40696d589")
        @Override
        public Object visitRepresentation(Representation theRepresentation) {
            // GmRepresentation
            final GmRepresentation representation = new GmRepresentation(this.diagram, theRepresentation, new MRef(theRepresentation));
            representation.setLayoutData(this.initialLayoutData);
            return representation;
        }

        @objid ("8049875a-4088-4ef5-b0f9-cdc0877468cb")
        @Override
        public Object visitRequirement(Requirement theRequirement) {
            // GmRequirement
            final GmRequirement requirement = new GmRequirement(this.diagram, theRequirement, new MRef(theRequirement));
            requirement.setLayoutData(this.initialLayoutData);
            return requirement;
        }

        @objid ("d772bad7-da1a-4c4f-8432-9ce24f56a9b9")
        @Override
        public Object visitResource(Resource theResource) {
            // GmResource
            final GmResource resource = new GmResource(this.diagram, theResource, new MRef(theResource));
            resource.setLayoutData(this.initialLayoutData);
            return resource;
        }

        @objid ("581cad68-6676-42ff-b3fd-de8ff3f04488")
        @Override
        public Object visitStakeholder(Stakeholder theStakeholder) {
            // GmStakeholder
            final GmStakeholder stakeholder = new GmStakeholder(this.diagram, theStakeholder, new MRef(theStakeholder));
            stakeholder.setLayoutData(this.initialLayoutData);
            return stakeholder;
        }

        @objid ("56e06ba8-0f30-436c-b3c2-8b5be004e08a")
        @Override
        public Object visitSystemSoftware(SystemSoftware theSystemSoftware) {
            // GmSystemSoftware
            final GmSystemSoftware systemsoftware = new GmSystemSoftware(this.diagram, theSystemSoftware, new MRef(theSystemSoftware));
            systemsoftware.setLayoutData(this.initialLayoutData);
            return systemsoftware;
        }

        @objid ("e6e598e4-819d-4079-8723-a048bce621a7")
        @Override
        public Object visitTechnologyCollaboration(TechnologyCollaboration theTechnologyCollaboration) {
            // GmTechnologyCollaboration
            final GmTechnologyCollaboration technologycollaboration = new GmTechnologyCollaboration(this.diagram, theTechnologyCollaboration, new MRef(theTechnologyCollaboration));
            technologycollaboration.setLayoutData(this.initialLayoutData);
            return technologycollaboration;
        }

        @objid ("f81d3923-2c06-4c48-a0c2-ea8e0dbbacfc")
        @Override
        public Object visitTechnologyEvent(TechnologyEvent theTechnologyEvent) {
            // GmTechnologyEvent
            final GmTechnologyEvent technologyevent = new GmTechnologyEvent(this.diagram, theTechnologyEvent, new MRef(theTechnologyEvent));
            technologyevent.setLayoutData(this.initialLayoutData);
            return technologyevent;
        }

        @objid ("2892d46c-0d48-47fc-b29e-b5971cd149e4")
        @Override
        public Object visitTechnologyFunction(TechnologyFunction theTechnologyFunction) {
            // GmTechnologyFunction
            final GmTechnologyFunction technologyfunction = new GmTechnologyFunction(this.diagram, theTechnologyFunction, new MRef(theTechnologyFunction));
            technologyfunction.setLayoutData(this.initialLayoutData);
            return technologyfunction;
        }

        @objid ("03cdd832-f6f0-424a-b286-38c6d0e52168")
        @Override
        public Object visitTechnologyInteraction(TechnologyInteraction theTechnologyInteraction) {
            // GmTechnologyInteraction
            final GmTechnologyInteraction technologyinterface = new GmTechnologyInteraction(this.diagram, theTechnologyInteraction, new MRef(theTechnologyInteraction));
            technologyinterface.setLayoutData(this.initialLayoutData);
            return technologyinterface;
        }

        @objid ("a5b268da-4833-4d1d-bcb5-f8de5654f15a")
        @Override
        public Object visitTechnologyInterface(TechnologyInterface theTechnologyInterface) {
            // GmTechnologyInterface
            final GmTechnologyInterface technologyinterface = new GmTechnologyInterface(this.diagram, theTechnologyInterface, new MRef(theTechnologyInterface));
            technologyinterface.setLayoutData(this.initialLayoutData);
            return technologyinterface;
        }

        @objid ("406bc2f9-c841-4ec3-8118-d088daa0c955")
        @Override
        public Object visitTechnologyProcess(TechnologyProcess theTechnologyProcess) {
            // GmTechnologyProcess
            final GmTechnologyProcess technologyprocess = new GmTechnologyProcess(this.diagram, theTechnologyProcess, new MRef(theTechnologyProcess));
            technologyprocess.setLayoutData(this.initialLayoutData);
            return technologyprocess;
        }

        @objid ("be5f2ca1-f461-40a1-9213-52ea067a804b")
        @Override
        public Object visitTechnologyService(TechnologyService theTechnologyService) {
            // GmTechnologyService
            final GmTechnologyService technologyservice = new GmTechnologyService(this.diagram, theTechnologyService, new MRef(theTechnologyService));
            technologyservice.setLayoutData(this.initialLayoutData);
            return technologyservice;
        }

        @objid ("a1cba1c2-5e8e-48be-80d4-523aea54ba7b")
        @Override
        public Object visitValue(Value theValue) {
            // GmValue
            final GmValue value = new GmValue(this.diagram, theValue, new MRef(theValue));
            value.setLayoutData(this.initialLayoutData);
            return value;
        }

        @objid ("39e02387-0a39-48ae-992c-350ae12b61b0")
        @Override
        public Object visitValueStream(ValueStream theValueStream) {
            // GmValueStream
            final GmValueStream valueStream = new GmValueStream(this.diagram, theValueStream, new MRef(theValueStream));
            valueStream.setLayoutData(this.initialLayoutData);
            return valueStream;
        }

        @objid ("a9aba864-862e-4887-90ac-775b37e025ac")
        @Override
        public Object visitViewPoint(ViewPoint theValue) {
            // GmViewPoint
            final GmViewPoint viewPoint = new GmViewPoint(this.diagram, theValue, new MRef(theValue));
            viewPoint.setLayoutData(this.initialLayoutData);
            return viewPoint;
        }

        @objid ("f7fd86a4-5261-4a3b-ae26-ebd7e73be443")
        @Override
        public Object visitWorkPackage(WorkPackage theWorkPackage) {
            // GmWorkPackage
            final GmWorkPackage workpackage = new GmWorkPackage(this.diagram, theWorkPackage, new MRef(theWorkPackage));
            workpackage.setLayoutData(this.initialLayoutData);
            return workpackage;
        }

    }

}
