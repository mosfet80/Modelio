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
package org.modelio.archimate.metamodel.visitors;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.RelationshipConnector;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.generic.ActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.archimate.metamodel.core.generic.InternalActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;
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
import org.modelio.archimate.metamodel.layers.strategy.behavior.StrategyBehaviorElement;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
import org.modelio.archimate.metamodel.layers.strategy.structure.Resource;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyEvent;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInteraction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyProcess;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Device;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.archimate.metamodel.relationships.other.OtherRelationship;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.metamodel.visitors.IInfrastructureVisitor;

/**
 * This interface is an implementation of {@link IArchimateVisitor} whose default strategy consists in transmitting the visit() call to the super class visit method.
 * <p>On root metaclasses, the visitor tries to delegate the parent metaclass metamodel visitor if available.If not available, <code>null</code> is returned.
 */
@objid ("45ff38e8-4dd4-482f-842a-5775559b95e9")
public interface IDefaultArchimateVisitor extends IArchimateVisitor {
    /**
     * Get the visitor to delegate to when a {@link IInfrastructureVisitor} is needed.
     * <p>If null is returned the caller will return null.
     *
     * @return the {@link IInfrastructureVisitor} visitor or <i>null</i>.
     */
    @objid ("5eb4c301-2ff4-41d5-ba94-5c6aa19ac4db")
    abstract IInfrastructureVisitor getInfrastructureVisitor();

    @objid ("2df22ee0-853d-4286-93bc-90bcb677ca38")
    @Override
    default Object visitAccess(Access obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("c069400f-714d-45c9-bbb4-83798bbe4db3")
    @Override
    default Object visitActiveStructureElement(ActiveStructureElement obj) {
        return visitStructureElement(obj);

    }

    @objid ("b84ff7e1-a1a7-40a4-8c17-90d01f1c8700")
    @Override
    default Object visitAggregation(Aggregation obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("d89a85bc-9a96-48f8-9a6b-e2eb37016035")
    @Override
    default Object visitAndJunction(AndJunction obj) {
        return visitJunction(obj);

    }

    @objid ("5206b079-7fd1-44b5-bec0-a2ba8f0d8fca")
    @Override
    default Object visitApplicationCollaboration(ApplicationCollaboration obj) {
        return visitApplicationInternalActiveStructureElement(obj);

    }

    @objid ("9f691e4b-1584-4d86-8ace-c320c6a13a86")
    @Override
    default Object visitApplicationComponent(ApplicationComponent obj) {
        return visitApplicationInternalActiveStructureElement(obj);

    }

    @objid ("a2918f83-b72d-42ab-a7d2-a552f4654b30")
    @Override
    default Object visitApplicationEvent(ApplicationEvent obj) {
        return visitEvent(obj);

    }

    @objid ("41ebb335-d841-4696-80a5-219fa98a3ec0")
    @Override
    default Object visitApplicationFolder(ApplicationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("912ebc3e-a5dc-43b0-bfa2-88c4d7c4eb80")
    @Override
    default Object visitApplicationFunction(ApplicationFunction obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("7516df0b-c7cd-433c-9be8-fc1adebf73f1")
    @Override
    default Object visitApplicationInteraction(ApplicationInteraction obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("c87b61c4-533c-41a3-9cb5-b67cc82d9ee5")
    @Override
    default Object visitApplicationInterface(ApplicationInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("c0854657-4334-473e-8d30-913ba139bd6f")
    @Override
    default Object visitApplicationInternalActiveStructureElement(ApplicationInternalActiveStructureElement obj) {
        return visitInternalActiveStructureElement(obj);

    }

    @objid ("5ff5e1e1-18f8-466a-8381-e02718301826")
    @Override
    default Object visitApplicationInternalBehaviorElement(ApplicationInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("8e000e12-8f6c-4953-a3da-6d2c0d242a3a")
    @Override
    default Object visitApplicationProcess(ApplicationProcess obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("27330ba9-59c8-42ac-a6e1-721aedd21861")
    @Override
    default Object visitApplicationService(ApplicationService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("8f48f20e-9a1b-4755-a52b-559f5fd7251e")
    @Override
    default Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitModelElement(obj);
        else
          return null;

    }

    @objid ("1642c095-6d22-4256-b467-eb1eadaa13e3")
    @Override
    default Object visitArchimateProject(ArchimateProject obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractProject(obj);
        else
          return null;

    }

    @objid ("df29213a-60a7-4bac-a3a2-2add7bc94a97")
    @Override
    default Object visitArchimateView(ArchimateView obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractDiagram(obj);
        else
          return null;

    }

    @objid ("b32696c7-e2a1-4623-914e-264527750d60")
    @Override
    default Object visitArtifact(Artifact obj) {
        return visitTechnologyObject(obj);

    }

    @objid ("49a14dc9-6227-458a-ae81-61e03d5a3767")
    @Override
    default Object visitAssessment(Assessment obj) {
        return visitMotivationElement(obj);

    }

    @objid ("5f97a071-c223-4560-8212-7a09b1b6809e")
    @Override
    default Object visitAssignment(Assignment obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("3a2db53c-c0b0-4c09-955b-98e0e1692346")
    @Override
    default Object visitAssociation(Association obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("b731b987-9a7b-4e36-97cd-3aa0443db537")
    @Override
    default Object visitBehaviorElement(BehaviorElement obj) {
        return visitElement(obj);

    }

    @objid ("ce693824-8423-449e-987e-8e31a5a0deaf")
    @Override
    default Object visitBusinessActor(BusinessActor obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("030554f9-8717-44bf-945e-fa2349fdf6e1")
    @Override
    default Object visitBusinessCollaboration(BusinessCollaboration obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("1763c8f1-70bc-44da-9841-e0f31a22fbf5")
    @Override
    default Object visitBusinessEvent(BusinessEvent obj) {
        return visitEvent(obj);

    }

    @objid ("5d9a821f-a9db-439c-a433-3c32542b525b")
    @Override
    default Object visitBusinessFolder(BusinessFolder obj) {
        return visitFolder(obj);

    }

    @objid ("9b701bb8-06a2-4c08-b12b-2d27d4b77b8f")
    @Override
    default Object visitBusinessFunction(BusinessFunction obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("d917b6ec-a93b-4d57-9145-38bf416d17ca")
    @Override
    default Object visitBusinessInteraction(BusinessInteraction obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("03605838-6388-48d5-acab-211c517459c1")
    @Override
    default Object visitBusinessInterface(BusinessInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("7a0243a5-88dc-40d2-a718-02f207f8cd15")
    @Override
    default Object visitBusinessInternalActiveStructureElement(BusinessInternalActiveStructureElement obj) {
        return visitInternalActiveStructureElement(obj);

    }

    @objid ("940e75bc-0fe7-42e0-b0ee-62eac2225dd6")
    @Override
    default Object visitBusinessInternalBehaviorElement(BusinessInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("c1533d4a-f388-4f67-9288-9c95d85d7502")
    @Override
    default Object visitBusinessObject(BusinessObject obj) {
        return visitBusinessPassiveStructureElement(obj);

    }

    @objid ("857bdfc8-075b-4700-ac26-3a75b59ce45f")
    @Override
    default Object visitBusinessPassiveStructureElement(BusinessPassiveStructureElement obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("16fa8f9e-eb33-44c8-8cf1-a987f8472092")
    @Override
    default Object visitBusinessProcess(BusinessProcess obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("79d48a5e-5a71-4fcb-9cbf-2b97e3e848f5")
    @Override
    default Object visitBusinessRole(BusinessRole obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("069f57ea-4185-4601-85c5-9f47a1566613")
    @Override
    default Object visitBusinessService(BusinessService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("a59bd5b1-3058-41ff-bbab-f223aea4444b")
    @Override
    default Object visitCapability(Capability obj) {
        return visitStrategyBehaviorElement(obj);

    }

    @objid ("7ed949df-edef-41a3-8ff6-563bedb99e6a")
    @Override
    default Object visitCommunicationNetwork(CommunicationNetwork obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("e431c247-896f-46f0-b4e2-00b4c439ea18")
    @Override
    default Object visitCompositeElement(CompositeElement obj) {
        return visitElement(obj);

    }

    @objid ("bab035ff-0521-4cdf-88de-ea7e2117ef68")
    @Override
    default Object visitComposition(Composition obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("355c9c21-4cfe-4ff0-b6f7-f8429e3f5998")
    @Override
    default Object visitConcept(Concept obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("219e25ef-8a6f-4587-b338-8d12e24d2ed0")
    @Override
    default Object visitConstraint(Constraint obj) {
        return visitRequirement(obj);

    }

    @objid ("f1e8297d-1559-4def-a88c-b245e4898884")
    @Override
    default Object visitContract(Contract obj) {
        return visitBusinessObject(obj);

    }

    @objid ("1cbcadcd-be9e-44a6-b051-b35740a938ef")
    @Override
    default Object visitCourseOfAction(CourseOfAction obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("c4c01742-d1ab-49a7-8e3d-d4dc359daa51")
    @Override
    default Object visitDataObject(DataObject obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("983dc79c-9128-4fee-8e30-26a765dfed4b")
    @Override
    default Object visitDeliverable(Deliverable obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("068d0920-047d-4528-83cd-0598aa1050f5")
    @Override
    default Object visitDependencyRelationship(DependencyRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("3aefb047-295d-4f33-ac6b-6a9c09677af5")
    @Override
    default Object visitDevice(Device obj) {
        return visitNode(obj);

    }

    @objid ("4f1f73c8-5f71-40aa-93b2-9d21c52638ec")
    @Override
    default Object visitDistributionNetwork(DistributionNetwork obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("51e82025-ceea-4aa5-be66-a8340f2c1944")
    @Override
    default Object visitDriver(Driver obj) {
        return visitMotivationElement(obj);

    }

    @objid ("38c804ea-986f-4f90-83c7-0214877fdada")
    @Override
    default Object visitDynamicRelationship(DynamicRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("026332c4-8f58-4320-80c4-a52c3510315f")
    @Override
    default Object visitElement(Element obj) {
        return visitConcept(obj);

    }

    @objid ("1c7adf4a-42f5-4155-885f-11f9f35bd83b")
    @Override
    default Object visitEquipment(Equipment obj) {
        return visitNode(obj);

    }

    @objid ("31c1e24b-2138-447d-bed6-8dc0b28d50cb")
    @Override
    default Object visitEvent(Event obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("21bd6d1d-9938-4d79-892f-f77250d7f442")
    @Override
    default Object visitExternalActiveStructureElement(ExternalActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("d1c09bdf-3e95-49af-ab71-a7c0a60324bc")
    @Override
    default Object visitExternalBehaviorElement(ExternalBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("655e72e9-0bb7-4f00-917f-5ec247f22d92")
    @Override
    default Object visitFacility(Facility obj) {
        return visitNode(obj);

    }

    @objid ("6c7ae893-63d1-49e0-a3a2-ff5e3c3b68c3")
    @Override
    default Object visitFlow(Flow obj) {
        return visitDynamicRelationship(obj);

    }

    @objid ("fc377c66-8307-4a13-b128-b19f22d6427f")
    @Override
    default Object visitFolder(Folder obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("9a0a9067-e0c6-446a-9478-066dbc7bb8f4")
    @Override
    default Object visitGap(Gap obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("7e3ab2fc-854e-4a68-974d-debc83db3769")
    @Override
    default Object visitGoal(Goal obj) {
        return visitMotivationElement(obj);

    }

    @objid ("542f0734-1bb3-43f3-8440-06bb714fe821")
    @Override
    default Object visitGrouping(Grouping obj) {
        return visitCompositeElement(obj);

    }

    @objid ("e5c904c6-38af-467b-8a11-c73c37e1d105")
    @Override
    default Object visitImplementationEvent(ImplementationEvent obj) {
        return visitEvent(obj);

    }

    @objid ("b520cf16-5756-4ace-8b9d-e951698c12b7")
    @Override
    default Object visitImplementationFolder(ImplementationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("6f4f39ae-e00d-4be1-8e2d-f9f7194e6fb2")
    @Override
    default Object visitInfluence(Influence obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("a86abdbb-3052-4be7-9325-32563a2354d4")
    @Override
    default Object visitInternalActiveStructureElement(InternalActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("d978244a-87d8-4cf3-ac30-ae205f3e3ade")
    @Override
    default Object visitInternalBehaviorElement(InternalBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("8bd1391b-296a-4542-a7b3-c91146536f60")
    @Override
    default Object visitJunction(Junction obj) {
        return visitRelationshipConnector(obj);

    }

    @objid ("a12b4124-ad8a-465f-917a-de2373d96018")
    @Override
    default Object visitLocation(Location obj) {
        return visitCompositeElement(obj);

    }

    @objid ("21696c3a-65ac-460b-80c7-872ea5e44f4f")
    @Override
    default Object visitMaterial(Material obj) {
        return visitTechnologyObject(obj);

    }

    @objid ("bcd38e2f-d506-4e36-9a02-6e40c77cc23a")
    @Override
    default Object visitMeaning(Meaning obj) {
        return visitMotivationElement(obj);

    }

    @objid ("f9b5f855-bc36-4b07-8944-96b0eefd8fdc")
    @Override
    default Object visitModel(Model obj) {
        return visitFolder(obj);

    }

    @objid ("e612d1cd-df39-4af5-8e70-3d5af0a1ee39")
    @Override
    default Object visitMotivationElement(MotivationElement obj) {
        return visitElement(obj);

    }

    @objid ("cd826a47-b44b-48f0-ac61-dbdae408111b")
    @Override
    default Object visitMotivationFolder(MotivationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("80f1a551-cc98-4180-9874-0085f0b2da9e")
    @Override
    default Object visitNode(Node obj) {
        return visitTechnologyInternalActiveStructureElement(obj);

    }

    @objid ("9f332c92-5f1f-4ab4-b0b1-9870d2960a90")
    @Override
    default Object visitOrJunction(OrJunction obj) {
        return visitJunction(obj);

    }

    @objid ("8902b721-eb54-409c-82b4-18bcc9a86091")
    @Override
    default Object visitOtherRelationship(OtherRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("eae995d0-5c29-49ae-a851-894583ca6b25")
    @Override
    default Object visitOutcome(Outcome obj) {
        return visitMotivationElement(obj);

    }

    @objid ("bfae7d6f-c85a-44cf-b0fc-a8004ca04a62")
    @Override
    default Object visitPassiveStructureElement(PassiveStructureElement obj) {
        return visitStructureElement(obj);

    }

    @objid ("a2013319-f4da-48ac-8f55-3577e9a46329")
    @Override
    default Object visitPath(Path obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("7dbf7f28-0ca0-4253-9c5a-0b4fe12c70fe")
    @Override
    default Object visitPhysicalFolder(PhysicalFolder obj) {
        return visitFolder(obj);

    }

    @objid ("edd5b065-92f1-48f0-93a8-7cea468a3c25")
    @Override
    default Object visitPlateau(Plateau obj) {
        return visitCompositeElement(obj);

    }

    @objid ("f961fdd2-1db4-4c15-8512-c6b89ce2892f")
    @Override
    default Object visitPrinciple(Principle obj) {
        return visitMotivationElement(obj);

    }

    @objid ("4d0453e6-51f8-49e2-9a44-63f702fd4a27")
    @Override
    default Object visitProduct(Product obj) {
        return visitCompositeElement(obj);

    }

    @objid ("1c93d81c-9205-43d8-bd68-0debc7cc321f")
    @Override
    default Object visitRealization(Realization obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("6a54a64c-ae15-42e1-acef-ac53400d52cd")
    @Override
    default Object visitRelationship(Relationship obj) {
        return visitConcept(obj);

    }

    @objid ("fd04a24c-b687-4fd4-b524-0699d618df02")
    @Override
    default Object visitRelationshipConnector(RelationshipConnector obj) {
        return visitConcept(obj);

    }

    @objid ("bd382438-1809-4f2b-992e-c6184a45f5fc")
    @Override
    default Object visitRepresentation(Representation obj) {
        return visitBusinessPassiveStructureElement(obj);

    }

    @objid ("898a07ea-df72-459d-bd54-b4faf60cec7c")
    @Override
    default Object visitRequirement(Requirement obj) {
        return visitMotivationElement(obj);

    }

    @objid ("31319dbb-23aa-4c51-bb2e-db351c75a90a")
    @Override
    default Object visitResource(Resource obj) {
        return visitStructureElement(obj);

    }

    @objid ("d226322e-9fd6-4ed8-bcbd-c2a6ae4ec4ba")
    @Override
    default Object visitServing(Serving obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("33d1c724-d141-437e-a7c2-66dd7e1b1864")
    @Override
    default Object visitSpecialization(Specialization obj) {
        return visitOtherRelationship(obj);

    }

    @objid ("640d4ea1-b397-479c-a496-11f09fbb4c83")
    @Override
    default Object visitStakeholder(Stakeholder obj) {
        return visitMotivationElement(obj);

    }

    @objid ("62899318-329f-4822-bdb4-970d9abeae12")
    @Override
    default Object visitStrategyBehaviorElement(StrategyBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("c0a2a151-5013-4135-ae85-9ea912510e9e")
    @Override
    default Object visitStrategyFolder(StrategyFolder obj) {
        return visitFolder(obj);

    }

    @objid ("8a26e936-fe42-448c-9f60-da0b2a36da88")
    @Override
    default Object visitStructuralRelationship(StructuralRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("cb8d6c28-1fea-4782-9aaf-cf83a165d63d")
    @Override
    default Object visitStructureElement(StructureElement obj) {
        return visitElement(obj);

    }

    @objid ("40b9888f-c8c0-48f8-a19e-a22930998ef6")
    @Override
    default Object visitSystemSoftware(SystemSoftware obj) {
        return visitNode(obj);

    }

    @objid ("84bb0e40-309b-4c11-8cf5-bff4c74b2cc4")
    @Override
    default Object visitTechnologyActiveStructureElement(TechnologyActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("2dae7dfb-3393-406d-9e3f-a7193e32ce38")
    @Override
    default Object visitTechnologyCollaboration(TechnologyCollaboration obj) {
        return visitTechnologyInternalActiveStructureElement(obj);

    }

    @objid ("a9c9c48b-547c-4bf6-bb12-f5bdb76f6505")
    @Override
    default Object visitTechnologyEvent(TechnologyEvent obj) {
        return visitEvent(obj);

    }

    @objid ("0747502c-711f-4409-b9a2-89e215ab2be7")
    @Override
    default Object visitTechnologyFolder(TechnologyFolder obj) {
        return visitFolder(obj);

    }

    @objid ("df24813b-a809-4b5c-bab7-ca6291bd07f7")
    @Override
    default Object visitTechnologyFunction(TechnologyFunction obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("1b24d3ef-affe-4e3f-ad37-bd899ac3ea7a")
    @Override
    default Object visitTechnologyInteraction(TechnologyInteraction obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("d67d7a1d-9d6c-4b8e-ae0f-9491f75d44f7")
    @Override
    default Object visitTechnologyInterface(TechnologyInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("cec6994f-0b92-4e1a-9061-37f660b207ab")
    @Override
    default Object visitTechnologyInternalActiveStructureElement(TechnologyInternalActiveStructureElement obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("bc421628-68fc-4177-9148-c37fca19568d")
    @Override
    default Object visitTechnologyInternalBehaviorElement(TechnologyInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("8537f09f-b460-409f-b815-bdab03e77d4c")
    @Override
    default Object visitTechnologyObject(TechnologyObject obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("deb47430-1c73-4786-88e9-c734e51bf40b")
    @Override
    default Object visitTechnologyProcess(TechnologyProcess obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("b88d59e7-7135-4ea8-abb7-93d67b992892")
    @Override
    default Object visitTechnologyService(TechnologyService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("46df7ddf-388c-4051-8e5b-9c4470b9857b")
    @Override
    default Object visitTriggering(Triggering obj) {
        return visitDynamicRelationship(obj);

    }

    @objid ("d7330f42-611d-4774-81d3-9f1e305ff41b")
    @Override
    default Object visitValue(Value obj) {
        return visitMotivationElement(obj);

    }

    @objid ("92506970-8614-4822-afa8-8d5c8a73cd6c")
    @Override
    default Object visitValueStream(ValueStream obj) {
        return visitStrategyBehaviorElement(obj);

    }

    @objid ("7a14cc1a-41c6-45b1-b4ea-4ae8bd5cab3b")
    @Override
    default Object visitViewPoint(ViewPoint obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("9acf36dd-66c6-418d-96c9-6233cdd9cd0e")
    @Override
    default Object visitViewPointDiagram(ViewPointDiagram obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractDiagram(obj);
        else
          return null;

    }

    @objid ("cfb6f0c9-bd51-4eb1-a82f-b7d6ef738663")
    @Override
    default Object visitWorkPackage(WorkPackage obj) {
        return visitBehaviorElement(obj);

    }

}
