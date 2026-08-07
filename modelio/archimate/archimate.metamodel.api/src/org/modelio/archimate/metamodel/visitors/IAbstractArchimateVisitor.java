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

/**
 * This class is an implementation of {@link IArchimateVisitor} whose visit() methods simply return <code>null</code>.
 */
@objid ("713bb91d-ef2d-42d9-95bf-f2fec65768f0")
public interface IAbstractArchimateVisitor extends IArchimateVisitor {
    @objid ("409d3aa7-7e47-4387-8611-c0e426dda541")
    @Override
    default Object visitAccess(Access obj) {
        	return null;
    }

    @objid ("b776da81-141e-4e55-9685-f6e685a3e1ff")
    @Override
    default Object visitActiveStructureElement(ActiveStructureElement obj) {
        	return null;
    }

    @objid ("68f09441-7e9e-47e1-bff1-18f6a2681e3c")
    @Override
    default Object visitAggregation(Aggregation obj) {
        	return null;
    }

    @objid ("f5ccb1b1-2d5b-456f-a8ed-478099fab2d9")
    @Override
    default Object visitAndJunction(AndJunction obj) {
        	return null;
    }

    @objid ("5e5802ef-5033-4c1c-bd04-cb7cf4a5fa69")
    @Override
    default Object visitApplicationCollaboration(ApplicationCollaboration obj) {
        	return null;
    }

    @objid ("bbcd8338-cc59-4b6f-9327-0dcbfe225e50")
    @Override
    default Object visitApplicationComponent(ApplicationComponent obj) {
        	return null;
    }

    @objid ("0b9eb2e9-559f-45d8-ac79-47becd5d4515")
    @Override
    default Object visitApplicationEvent(ApplicationEvent obj) {
        	return null;
    }

    @objid ("17a812e9-29be-42b1-8e63-6dda42338f5a")
    @Override
    default Object visitApplicationFolder(ApplicationFolder obj) {
        	return null;
    }

    @objid ("f7c68e92-5d83-4872-97dd-1fe3cba306ec")
    @Override
    default Object visitApplicationFunction(ApplicationFunction obj) {
        	return null;
    }

    @objid ("9b87ad20-76db-4c3f-8302-939fca2f41e1")
    @Override
    default Object visitApplicationInteraction(ApplicationInteraction obj) {
        	return null;
    }

    @objid ("20d5f99a-e606-4fba-a523-4982b50e058e")
    @Override
    default Object visitApplicationInterface(ApplicationInterface obj) {
        	return null;
    }

    @objid ("5d6f4293-4ab4-4571-851e-54eb97dbef7a")
    @Override
    default Object visitApplicationInternalActiveStructureElement(ApplicationInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("3d18552b-a343-4d35-8e3c-7f1d771dda38")
    @Override
    default Object visitApplicationInternalBehaviorElement(ApplicationInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("5eaaf7e1-64d9-4a5c-9cf9-af9d60f9ee60")
    @Override
    default Object visitApplicationProcess(ApplicationProcess obj) {
        	return null;
    }

    @objid ("f8cecd8f-d215-4c85-a8fa-58eb2e228fd7")
    @Override
    default Object visitApplicationService(ApplicationService obj) {
        	return null;
    }

    @objid ("d19280b0-3664-4d8a-adcc-ede8fb5d3b3d")
    @Override
    default Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
        	return null;
    }

    @objid ("b4e6ef5f-6ad4-434e-bcd3-4cced14eb165")
    @Override
    default Object visitArchimateProject(ArchimateProject obj) {
        	return null;
    }

    @objid ("574d69d8-0142-4d58-8e9c-a3bd6f36dac2")
    @Override
    default Object visitArchimateView(ArchimateView obj) {
        	return null;
    }

    @objid ("affef985-bdf8-40f1-bb77-eae8405eab65")
    @Override
    default Object visitArtifact(Artifact obj) {
        	return null;
    }

    @objid ("7cfe723f-abd4-47aa-83b3-3f9d1bb3ac76")
    @Override
    default Object visitAssessment(Assessment obj) {
        	return null;
    }

    @objid ("f2e49b8f-2876-472f-a9dc-69dedb71cede")
    @Override
    default Object visitAssignment(Assignment obj) {
        	return null;
    }

    @objid ("b97a8a0d-2b36-4022-b953-104798d3da4b")
    @Override
    default Object visitAssociation(Association obj) {
        	return null;
    }

    @objid ("49f18087-9657-45c1-b1f6-1689d7c45f1d")
    @Override
    default Object visitBehaviorElement(BehaviorElement obj) {
        	return null;
    }

    @objid ("6dc692f1-660a-46aa-9c5e-66c55fc765ef")
    @Override
    default Object visitBusinessActor(BusinessActor obj) {
        	return null;
    }

    @objid ("22c8c8ca-a3b5-4f5a-b6b3-fba4c062013d")
    @Override
    default Object visitBusinessCollaboration(BusinessCollaboration obj) {
        	return null;
    }

    @objid ("8b1a47f4-2071-4c22-93ad-00b1e6ae7031")
    @Override
    default Object visitBusinessEvent(BusinessEvent obj) {
        	return null;
    }

    @objid ("f93ebd83-4659-49bd-a06c-de3a875d999b")
    @Override
    default Object visitBusinessFolder(BusinessFolder obj) {
        	return null;
    }

    @objid ("5f736283-20a5-4b9a-8613-13561b89cf29")
    @Override
    default Object visitBusinessFunction(BusinessFunction obj) {
        	return null;
    }

    @objid ("d68cd871-0e83-4310-81b7-57df6e9bc7df")
    @Override
    default Object visitBusinessInteraction(BusinessInteraction obj) {
        	return null;
    }

    @objid ("b7b128cf-6f4c-4108-8336-97bd18ea5244")
    @Override
    default Object visitBusinessInterface(BusinessInterface obj) {
        	return null;
    }

    @objid ("ade52023-d341-48d8-8aa4-1ce278fd7322")
    @Override
    default Object visitBusinessInternalActiveStructureElement(BusinessInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("0afe069e-f795-4784-b887-dc634613a441")
    @Override
    default Object visitBusinessInternalBehaviorElement(BusinessInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("ed673f68-aad3-4bec-ae30-d7ff447c9f26")
    @Override
    default Object visitBusinessObject(BusinessObject obj) {
        	return null;
    }

    @objid ("723d6891-2dc9-4d47-9580-15e43186d74b")
    @Override
    default Object visitBusinessPassiveStructureElement(BusinessPassiveStructureElement obj) {
        	return null;
    }

    @objid ("615fc7e1-e842-4b9c-8bab-606e250717bb")
    @Override
    default Object visitBusinessProcess(BusinessProcess obj) {
        	return null;
    }

    @objid ("dfb1a1ab-4992-4f42-bcc0-e3a678a2a539")
    @Override
    default Object visitBusinessRole(BusinessRole obj) {
        	return null;
    }

    @objid ("c1d3a95e-b6b5-4f58-8481-503871ba8379")
    @Override
    default Object visitBusinessService(BusinessService obj) {
        	return null;
    }

    @objid ("e099ef89-48e4-4de9-a0be-e15c52cc297d")
    @Override
    default Object visitCapability(Capability obj) {
        	return null;
    }

    @objid ("a862e8a9-b873-493c-9310-a3ee33087057")
    @Override
    default Object visitCommunicationNetwork(CommunicationNetwork obj) {
        	return null;
    }

    @objid ("6fa63f0f-9acf-4f53-97d2-d5f455ba5fcb")
    @Override
    default Object visitCompositeElement(CompositeElement obj) {
        	return null;
    }

    @objid ("1c9862fe-e1c9-4b19-9fa5-a027152643ca")
    @Override
    default Object visitComposition(Composition obj) {
        	return null;
    }

    @objid ("c4653209-45b0-4866-9760-b0ee0cedac92")
    @Override
    default Object visitConcept(Concept obj) {
        	return null;
    }

    @objid ("e5fb38a5-398f-4c74-99ac-118e38993886")
    @Override
    default Object visitConstraint(Constraint obj) {
        	return null;
    }

    @objid ("a08f8323-e049-4acc-8e47-256ea55e186d")
    @Override
    default Object visitContract(Contract obj) {
        	return null;
    }

    @objid ("61b35e74-0cfc-4929-bafe-ddeece44b393")
    @Override
    default Object visitCourseOfAction(CourseOfAction obj) {
        	return null;
    }

    @objid ("b801f1fb-a097-4416-b14a-a2c7be9c0d3c")
    @Override
    default Object visitDataObject(DataObject obj) {
        	return null;
    }

    @objid ("832fca6f-aa62-4e6b-990a-92b9334cc37a")
    @Override
    default Object visitDeliverable(Deliverable obj) {
        	return null;
    }

    @objid ("d239af83-36ab-4904-8e52-99e44c333df8")
    @Override
    default Object visitDependencyRelationship(DependencyRelationship obj) {
        	return null;
    }

    @objid ("7d20f59b-a1a4-4cd8-9d88-5d1cf8c27ad8")
    @Override
    default Object visitDevice(Device obj) {
        	return null;
    }

    @objid ("9be1106c-0cd9-4fa0-8030-f4b680d7b1c3")
    @Override
    default Object visitDistributionNetwork(DistributionNetwork obj) {
        	return null;
    }

    @objid ("c5b113da-5c65-4786-a570-ece245197e0d")
    @Override
    default Object visitDriver(Driver obj) {
        	return null;
    }

    @objid ("f1d50259-6396-470a-b3f5-606da1b0341a")
    @Override
    default Object visitDynamicRelationship(DynamicRelationship obj) {
        	return null;
    }

    @objid ("aa7b1155-d87e-4771-a747-afdec26203c1")
    @Override
    default Object visitElement(Element obj) {
        	return null;
    }

    @objid ("b70e9866-0ffe-402b-a2ed-5469b5007cce")
    @Override
    default Object visitEquipment(Equipment obj) {
        	return null;
    }

    @objid ("b738a752-1b57-4a6c-a537-c2b589ef1aeb")
    @Override
    default Object visitEvent(Event obj) {
        	return null;
    }

    @objid ("1cc4908f-2f5f-489c-9446-75f1fa95af34")
    @Override
    default Object visitExternalActiveStructureElement(ExternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("922bcdf5-e379-4e89-b8d4-f9004a690952")
    @Override
    default Object visitExternalBehaviorElement(ExternalBehaviorElement obj) {
        	return null;
    }

    @objid ("e7319693-92e3-44ca-8f88-c23cc36d6709")
    @Override
    default Object visitFacility(Facility obj) {
        	return null;
    }

    @objid ("d367cbd7-03cd-41df-9e8d-785dfddd52cc")
    @Override
    default Object visitFlow(Flow obj) {
        	return null;
    }

    @objid ("0df944bd-3bf8-4ef1-8989-a2d44230bde1")
    @Override
    default Object visitFolder(Folder obj) {
        	return null;
    }

    @objid ("817ccda5-9cb7-4d6e-bb86-e71e8853e3f2")
    @Override
    default Object visitGap(Gap obj) {
        	return null;
    }

    @objid ("b6fd0f6b-3bb5-49b1-92f3-29cdc223dff9")
    @Override
    default Object visitGoal(Goal obj) {
        	return null;
    }

    @objid ("1ff73207-1f9f-41b3-81b9-88a632d8f8c0")
    @Override
    default Object visitGrouping(Grouping obj) {
        	return null;
    }

    @objid ("bd528e8f-9cef-4fde-8529-7f2551068856")
    @Override
    default Object visitImplementationEvent(ImplementationEvent obj) {
        	return null;
    }

    @objid ("c505fddb-94d6-4458-b835-27005462dd76")
    @Override
    default Object visitImplementationFolder(ImplementationFolder obj) {
        	return null;
    }

    @objid ("3ef3d1a2-8cef-4c1b-9576-71ac55d2c29d")
    @Override
    default Object visitInfluence(Influence obj) {
        	return null;
    }

    @objid ("ca5e2317-dfb8-4186-bfec-3b976542eeca")
    @Override
    default Object visitInternalActiveStructureElement(InternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("90e8792a-91bb-4d8e-bc81-2ddc799d188a")
    @Override
    default Object visitInternalBehaviorElement(InternalBehaviorElement obj) {
        	return null;
    }

    @objid ("43dcf333-108e-4707-b4f0-3c03ba683c29")
    @Override
    default Object visitJunction(Junction obj) {
        	return null;
    }

    @objid ("5d9a39f2-2231-4b30-a5ee-ee02bf5200e7")
    @Override
    default Object visitLocation(Location obj) {
        	return null;
    }

    @objid ("72c7b61c-ed50-4b93-be53-61bda2caec27")
    @Override
    default Object visitMaterial(Material obj) {
        	return null;
    }

    @objid ("c45a5c4a-cabf-4cfb-a129-716600d66731")
    @Override
    default Object visitMeaning(Meaning obj) {
        	return null;
    }

    @objid ("82d96a55-1c98-4510-859f-c7747cd0d1d5")
    @Override
    default Object visitModel(Model obj) {
        	return null;
    }

    @objid ("000330ca-278f-4673-a513-107561b91e12")
    @Override
    default Object visitMotivationElement(MotivationElement obj) {
        	return null;
    }

    @objid ("94cfa707-f6eb-494f-b298-18bcec1bf721")
    @Override
    default Object visitMotivationFolder(MotivationFolder obj) {
        	return null;
    }

    @objid ("c9336677-110f-44f0-99dc-8060e9f66858")
    @Override
    default Object visitNode(Node obj) {
        	return null;
    }

    @objid ("b89e37e5-a08b-4ae1-ad51-7c4588d74871")
    @Override
    default Object visitOrJunction(OrJunction obj) {
        	return null;
    }

    @objid ("3afbc13b-f6bd-4d7f-9d39-71e5e33dcd85")
    @Override
    default Object visitOtherRelationship(OtherRelationship obj) {
        	return null;
    }

    @objid ("88f1c714-7db6-4eac-8602-9d46e5787de7")
    @Override
    default Object visitOutcome(Outcome obj) {
        	return null;
    }

    @objid ("646e4dfb-20b5-44d8-a354-f323740fc404")
    @Override
    default Object visitPassiveStructureElement(PassiveStructureElement obj) {
        	return null;
    }

    @objid ("56e5ef2c-51b9-421c-9faa-68075a9f6327")
    @Override
    default Object visitPath(Path obj) {
        	return null;
    }

    @objid ("0e3f9f38-cec5-4d87-ab94-9bc00d7cc238")
    @Override
    default Object visitPhysicalFolder(PhysicalFolder obj) {
        	return null;
    }

    @objid ("0a71a0c2-3748-4b79-bb8c-2fc5795833d5")
    @Override
    default Object visitPlateau(Plateau obj) {
        	return null;
    }

    @objid ("05b11687-84e1-4ec8-b6db-52097de5491a")
    @Override
    default Object visitPrinciple(Principle obj) {
        	return null;
    }

    @objid ("c76fb6ad-6e3e-4674-b0a7-ea89554ce64d")
    @Override
    default Object visitProduct(Product obj) {
        	return null;
    }

    @objid ("7bdc868b-7eef-4e1f-a2bc-7d045046e40e")
    @Override
    default Object visitRealization(Realization obj) {
        	return null;
    }

    @objid ("fdda1768-12b5-4224-afe3-621066c54743")
    @Override
    default Object visitRelationship(Relationship obj) {
        	return null;
    }

    @objid ("84a50fd4-7cec-4222-ae3a-a8b4f762b38a")
    @Override
    default Object visitRelationshipConnector(RelationshipConnector obj) {
        	return null;
    }

    @objid ("af5eeab9-46be-48c1-b643-f35a2a23b201")
    @Override
    default Object visitRepresentation(Representation obj) {
        	return null;
    }

    @objid ("c9082bf7-b39c-45f9-b557-40a042c09fc3")
    @Override
    default Object visitRequirement(Requirement obj) {
        	return null;
    }

    @objid ("e2778bc6-70a2-47c9-ac72-e0c7631f54a8")
    @Override
    default Object visitResource(Resource obj) {
        	return null;
    }

    @objid ("9605e68b-ec71-44c3-82f5-05ed27463d88")
    @Override
    default Object visitServing(Serving obj) {
        	return null;
    }

    @objid ("44f624ae-aaa8-43c0-8647-6625bf59b502")
    @Override
    default Object visitSpecialization(Specialization obj) {
        	return null;
    }

    @objid ("7325bb39-e1ac-471b-9c72-42dfba490faf")
    @Override
    default Object visitStakeholder(Stakeholder obj) {
        	return null;
    }

    @objid ("ec677093-3fad-4b05-a020-f06de2a0e4c3")
    @Override
    default Object visitStrategyBehaviorElement(StrategyBehaviorElement obj) {
        	return null;
    }

    @objid ("9717179e-66f5-4717-b616-ccff90b620fb")
    @Override
    default Object visitStrategyFolder(StrategyFolder obj) {
        	return null;
    }

    @objid ("367b47f3-d181-4f1f-970a-a0e671ef8384")
    @Override
    default Object visitStructuralRelationship(StructuralRelationship obj) {
        	return null;
    }

    @objid ("8f4c64aa-25df-40b6-b82a-71c3149ecf19")
    @Override
    default Object visitStructureElement(StructureElement obj) {
        	return null;
    }

    @objid ("04ddc1c6-df82-4437-b46f-ddbf64dc5bda")
    @Override
    default Object visitSystemSoftware(SystemSoftware obj) {
        	return null;
    }

    @objid ("5b8f24a0-9d34-44a5-b057-697df2fde35b")
    @Override
    default Object visitTechnologyActiveStructureElement(TechnologyActiveStructureElement obj) {
        	return null;
    }

    @objid ("92005254-99ed-4f32-9dc3-557b29a952c4")
    @Override
    default Object visitTechnologyCollaboration(TechnologyCollaboration obj) {
        	return null;
    }

    @objid ("5fbe2dc5-56e8-4572-8c41-049174c506a7")
    @Override
    default Object visitTechnologyEvent(TechnologyEvent obj) {
        	return null;
    }

    @objid ("394886cb-9d8c-47c1-aca0-f7f05ff22278")
    @Override
    default Object visitTechnologyFolder(TechnologyFolder obj) {
        	return null;
    }

    @objid ("47bc246a-dc60-48f7-afc3-0bf193e207d3")
    @Override
    default Object visitTechnologyFunction(TechnologyFunction obj) {
        	return null;
    }

    @objid ("8a1316fc-775f-4662-90be-517b5a0a9e95")
    @Override
    default Object visitTechnologyInteraction(TechnologyInteraction obj) {
        	return null;
    }

    @objid ("b2924e1b-cf48-4867-ad20-c09fa32a3b76")
    @Override
    default Object visitTechnologyInterface(TechnologyInterface obj) {
        	return null;
    }

    @objid ("a9eb381e-ab6e-4241-8e2f-15f11e7d6d84")
    @Override
    default Object visitTechnologyInternalActiveStructureElement(TechnologyInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("a2da5081-0749-40c5-b3df-a07d4271af2f")
    @Override
    default Object visitTechnologyInternalBehaviorElement(TechnologyInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("5ce9260c-5dc7-478a-9153-38ca22deb948")
    @Override
    default Object visitTechnologyObject(TechnologyObject obj) {
        	return null;
    }

    @objid ("2760872d-b7e0-4185-a7e7-d83fb0e557c7")
    @Override
    default Object visitTechnologyProcess(TechnologyProcess obj) {
        	return null;
    }

    @objid ("05df5896-639a-4ebb-b465-1b4db193dee0")
    @Override
    default Object visitTechnologyService(TechnologyService obj) {
        	return null;
    }

    @objid ("2778e33e-de6c-46b4-9eb1-684d9c13e097")
    @Override
    default Object visitTriggering(Triggering obj) {
        	return null;
    }

    @objid ("27ece878-b755-4e9d-b859-da47350c56a8")
    @Override
    default Object visitValue(Value obj) {
        	return null;
    }

    @objid ("93efe7a5-334f-4c67-9fff-38b9a7e02fbc")
    @Override
    default Object visitValueStream(ValueStream obj) {
        	return null;
    }

    @objid ("af38dec1-ed59-4d0f-8035-52b2066e3c12")
    @Override
    default Object visitViewPoint(ViewPoint obj) {
        	return null;
    }

    @objid ("750a6cb0-a9cc-41e2-b832-de696a026304")
    @Override
    default Object visitViewPointDiagram(ViewPointDiagram obj) {
        	return null;
    }

    @objid ("f79fa1c5-4378-4725-b0bf-0f7952c6aa6b")
    @Override
    default Object visitWorkPackage(WorkPackage obj) {
        	return null;
    }

}
