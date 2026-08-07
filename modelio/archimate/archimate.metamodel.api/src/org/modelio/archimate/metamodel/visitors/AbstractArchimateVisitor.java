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
@objid ("6f888b58-91a4-4182-896e-0dde0c95b97e")
public class AbstractArchimateVisitor implements IArchimateVisitor {
    @objid ("c94cecbf-6979-42d4-822e-5c44c878124e")
    @Override
    public Object visitAccess(Access obj) {
        	return null;
    }

    @objid ("8796d95f-eb92-4a37-bd60-064e65cbde95")
    @Override
    public Object visitActiveStructureElement(ActiveStructureElement obj) {
        	return null;
    }

    @objid ("2b59905b-48ab-429c-a3cd-fb39f71751a9")
    @Override
    public Object visitAggregation(Aggregation obj) {
        	return null;
    }

    @objid ("f37a8931-379f-4f0b-8826-0f2922114e74")
    @Override
    public Object visitAndJunction(AndJunction obj) {
        	return null;
    }

    @objid ("c511201d-3031-426f-8e10-17e1ad3d6c3e")
    @Override
    public Object visitApplicationCollaboration(ApplicationCollaboration obj) {
        	return null;
    }

    @objid ("e95b4925-a18b-44ad-aef0-d75ef892b376")
    @Override
    public Object visitApplicationComponent(ApplicationComponent obj) {
        	return null;
    }

    @objid ("2e25ae2d-393f-4f0f-b13f-f5fbd52a31f8")
    @Override
    public Object visitApplicationEvent(ApplicationEvent obj) {
        	return null;
    }

    @objid ("83bc9741-85b4-45a7-9c27-0c589310219c")
    @Override
    public Object visitApplicationFolder(ApplicationFolder obj) {
        	return null;
    }

    @objid ("e1f0b786-72cc-438d-952e-9fa2b462f732")
    @Override
    public Object visitApplicationFunction(ApplicationFunction obj) {
        	return null;
    }

    @objid ("f020887b-43f0-4f2a-976a-64052449d6d7")
    @Override
    public Object visitApplicationInteraction(ApplicationInteraction obj) {
        	return null;
    }

    @objid ("395d1701-e969-48e3-ab02-83bf07a2df54")
    @Override
    public Object visitApplicationInterface(ApplicationInterface obj) {
        	return null;
    }

    @objid ("a192456e-e62e-45d5-8eff-0151a019d45a")
    @Override
    public Object visitApplicationInternalActiveStructureElement(ApplicationInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("49276daa-cd10-4063-9b5a-1857c5787eb0")
    @Override
    public Object visitApplicationInternalBehaviorElement(ApplicationInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("55f94aa3-d1da-49f7-bbcb-6ae6de111b49")
    @Override
    public Object visitApplicationProcess(ApplicationProcess obj) {
        	return null;
    }

    @objid ("5360d635-fa4c-44d0-964b-fae227393cb2")
    @Override
    public Object visitApplicationService(ApplicationService obj) {
        	return null;
    }

    @objid ("d25d3365-556a-4700-90ac-5d3adf1d6ad8")
    @Override
    public Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
        	return null;
    }

    @objid ("1666568f-f33d-493a-a0f6-df5584c2b8f2")
    @Override
    public Object visitArchimateProject(ArchimateProject obj) {
        	return null;
    }

    @objid ("5fa8a702-dfe0-4c9a-83f9-5fe86db7562e")
    @Override
    public Object visitArchimateView(ArchimateView obj) {
        	return null;
    }

    @objid ("bfc3161a-ff7b-45d4-bcbe-804cff28677d")
    @Override
    public Object visitArtifact(Artifact obj) {
        	return null;
    }

    @objid ("0e1d52a7-cca6-4cf4-8dcf-9f1dc78ea1a4")
    @Override
    public Object visitAssessment(Assessment obj) {
        	return null;
    }

    @objid ("1477e165-7c0e-4144-b4d5-83ec37d823a0")
    @Override
    public Object visitAssignment(Assignment obj) {
        	return null;
    }

    @objid ("1e917d16-1288-4b74-b489-fb69e46b4047")
    @Override
    public Object visitAssociation(Association obj) {
        	return null;
    }

    @objid ("be2868e5-5b56-4c03-aa81-b51a0cdb3052")
    @Override
    public Object visitBehaviorElement(BehaviorElement obj) {
        	return null;
    }

    @objid ("1dca1bb3-1a82-41d2-8c72-eebe640be87b")
    @Override
    public Object visitBusinessActor(BusinessActor obj) {
        	return null;
    }

    @objid ("d060d040-d14e-4e28-8bfb-95f2fecd634a")
    @Override
    public Object visitBusinessCollaboration(BusinessCollaboration obj) {
        	return null;
    }

    @objid ("d1277592-1bbc-488a-9d3f-929cf0036e31")
    @Override
    public Object visitBusinessEvent(BusinessEvent obj) {
        	return null;
    }

    @objid ("4b47aa56-e641-4faf-ade1-a5318ae0841f")
    @Override
    public Object visitBusinessFolder(BusinessFolder obj) {
        	return null;
    }

    @objid ("72727a95-662a-4d23-ad46-e0657aec9537")
    @Override
    public Object visitBusinessFunction(BusinessFunction obj) {
        	return null;
    }

    @objid ("d64f07e3-93b4-493f-84d7-2d3d09ec046f")
    @Override
    public Object visitBusinessInteraction(BusinessInteraction obj) {
        	return null;
    }

    @objid ("fe6ee457-b697-4b5b-9459-8a540839b597")
    @Override
    public Object visitBusinessInterface(BusinessInterface obj) {
        	return null;
    }

    @objid ("0c0bbcab-bf83-4976-b376-84d279604f2d")
    @Override
    public Object visitBusinessInternalActiveStructureElement(BusinessInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("d236c164-416e-49b7-8ad7-65f11c7a6d0a")
    @Override
    public Object visitBusinessInternalBehaviorElement(BusinessInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("3dad048c-19bc-434c-9458-478985a84f0c")
    @Override
    public Object visitBusinessObject(BusinessObject obj) {
        	return null;
    }

    @objid ("6199316e-d96e-4d53-b0b9-f985c2fecd44")
    @Override
    public Object visitBusinessPassiveStructureElement(BusinessPassiveStructureElement obj) {
        	return null;
    }

    @objid ("a5e0a159-32cd-4e10-94a0-4c442b6aeacb")
    @Override
    public Object visitBusinessProcess(BusinessProcess obj) {
        	return null;
    }

    @objid ("21c98c32-68ac-4b2d-a7f7-ee8987a6ed0a")
    @Override
    public Object visitBusinessRole(BusinessRole obj) {
        	return null;
    }

    @objid ("dab59e8c-1729-42b5-85de-9d9be78f308b")
    @Override
    public Object visitBusinessService(BusinessService obj) {
        	return null;
    }

    @objid ("93fe8db5-9bb6-41c7-8289-1f5c07d9849f")
    @Override
    public Object visitCapability(Capability obj) {
        	return null;
    }

    @objid ("7dc02794-c68b-4d50-a812-b6a4c07ab654")
    @Override
    public Object visitCommunicationNetwork(CommunicationNetwork obj) {
        	return null;
    }

    @objid ("c2dec6a0-9dac-4524-89d8-3610ccaaa25d")
    @Override
    public Object visitCompositeElement(CompositeElement obj) {
        	return null;
    }

    @objid ("f9aac596-2f3e-4b01-b929-fc43ec1371fe")
    @Override
    public Object visitComposition(Composition obj) {
        	return null;
    }

    @objid ("cacc98d6-82f0-41a1-b6d2-e475fb36548d")
    @Override
    public Object visitConcept(Concept obj) {
        	return null;
    }

    @objid ("860f9a98-0609-40b9-9ff2-95321d4f45f3")
    @Override
    public Object visitConstraint(Constraint obj) {
        	return null;
    }

    @objid ("6879c12c-8ef0-4a0d-9ee4-3d91ef2eed3a")
    @Override
    public Object visitContract(Contract obj) {
        	return null;
    }

    @objid ("d3d3e368-5f53-4228-af3d-98d9a3517c7b")
    @Override
    public Object visitCourseOfAction(CourseOfAction obj) {
        	return null;
    }

    @objid ("6f6b41f9-459a-40d4-bf21-47e1337f8e90")
    @Override
    public Object visitDataObject(DataObject obj) {
        	return null;
    }

    @objid ("4180a233-d0da-40c7-a08a-3b452ca719dd")
    @Override
    public Object visitDeliverable(Deliverable obj) {
        	return null;
    }

    @objid ("cf26b802-a929-423e-bf61-382ed657d702")
    @Override
    public Object visitDependencyRelationship(DependencyRelationship obj) {
        	return null;
    }

    @objid ("ed7242af-b0b6-4791-98c7-3d5524f39176")
    @Override
    public Object visitDevice(Device obj) {
        	return null;
    }

    @objid ("80e544a3-d39b-44c1-a5f8-376596241686")
    @Override
    public Object visitDistributionNetwork(DistributionNetwork obj) {
        	return null;
    }

    @objid ("80fbe0d8-444e-4697-b098-7c164f7d7e54")
    @Override
    public Object visitDriver(Driver obj) {
        	return null;
    }

    @objid ("7054bbc2-b7b2-4a0d-9dde-8eb760113a56")
    @Override
    public Object visitDynamicRelationship(DynamicRelationship obj) {
        	return null;
    }

    @objid ("f6b29fb6-4d14-4815-85dc-ce1007697de9")
    @Override
    public Object visitElement(Element obj) {
        	return null;
    }

    @objid ("1a045810-05f5-44c9-b76d-a02587424a24")
    @Override
    public Object visitEquipment(Equipment obj) {
        	return null;
    }

    @objid ("57734bc3-1747-4fc7-8fff-22bd9f167822")
    @Override
    public Object visitEvent(Event obj) {
        	return null;
    }

    @objid ("f85c237d-e8b2-4349-982c-96c47627e59c")
    @Override
    public Object visitExternalActiveStructureElement(ExternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("c051f60c-d095-45d0-b2a7-7df38032bb76")
    @Override
    public Object visitExternalBehaviorElement(ExternalBehaviorElement obj) {
        	return null;
    }

    @objid ("e0888b64-27ef-4555-b011-daafcda2cb26")
    @Override
    public Object visitFacility(Facility obj) {
        	return null;
    }

    @objid ("bd7981ac-0a1a-4d19-a34e-560edf3daa7f")
    @Override
    public Object visitFlow(Flow obj) {
        	return null;
    }

    @objid ("49da7517-03e5-4b69-bcb6-7c1195dc5242")
    @Override
    public Object visitFolder(Folder obj) {
        	return null;
    }

    @objid ("12dc0686-659c-4fbf-b7e5-b4f03dea8b9c")
    @Override
    public Object visitGap(Gap obj) {
        	return null;
    }

    @objid ("299220e0-473b-41ff-a4d6-fee8cb6678d6")
    @Override
    public Object visitGoal(Goal obj) {
        	return null;
    }

    @objid ("3c89ff08-bf6a-48a9-854a-89532a86c37e")
    @Override
    public Object visitGrouping(Grouping obj) {
        	return null;
    }

    @objid ("0e4bfda9-eff7-4b32-9eae-71e65a76be83")
    @Override
    public Object visitImplementationEvent(ImplementationEvent obj) {
        	return null;
    }

    @objid ("d3fd1e57-8f93-4056-8b45-87d770998be0")
    @Override
    public Object visitImplementationFolder(ImplementationFolder obj) {
        	return null;
    }

    @objid ("dc9eea02-cbe8-415c-ae6a-b1a537f824b3")
    @Override
    public Object visitInfluence(Influence obj) {
        	return null;
    }

    @objid ("cbcd309f-9a43-4c25-9ca6-01197d382409")
    @Override
    public Object visitInternalActiveStructureElement(InternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("c986e38b-7709-499d-803f-365e4dac020a")
    @Override
    public Object visitInternalBehaviorElement(InternalBehaviorElement obj) {
        	return null;
    }

    @objid ("7641743d-3fc1-4e9a-a563-a86293790a23")
    @Override
    public Object visitJunction(Junction obj) {
        	return null;
    }

    @objid ("b4424122-f05d-4188-be54-a03b8da418c2")
    @Override
    public Object visitLocation(Location obj) {
        	return null;
    }

    @objid ("a21a2bf2-0bd8-4a99-83f9-5a06c08451e5")
    @Override
    public Object visitMaterial(Material obj) {
        	return null;
    }

    @objid ("6ba2c91b-c5fd-422f-a6bf-d30c5c2761c6")
    @Override
    public Object visitMeaning(Meaning obj) {
        	return null;
    }

    @objid ("01c6920a-f327-4459-9cf6-de3aafe76f2c")
    @Override
    public Object visitModel(Model obj) {
        	return null;
    }

    @objid ("b0eaaa21-9e07-4d0b-8f3c-f444d9274098")
    @Override
    public Object visitMotivationElement(MotivationElement obj) {
        	return null;
    }

    @objid ("a189d86d-2ed1-4360-ade1-230427ad9e04")
    @Override
    public Object visitMotivationFolder(MotivationFolder obj) {
        	return null;
    }

    @objid ("69334b2b-f9fa-4940-b8d0-704a70309e6a")
    @Override
    public Object visitNode(Node obj) {
        	return null;
    }

    @objid ("b46ffce9-7f40-4c65-8305-47390a4ad8b6")
    @Override
    public Object visitOrJunction(OrJunction obj) {
        	return null;
    }

    @objid ("fb66feb6-9bb2-4dd1-83eb-4bb80097fc2f")
    @Override
    public Object visitOtherRelationship(OtherRelationship obj) {
        	return null;
    }

    @objid ("aa741312-7ed8-4f9b-aa4f-37ba9e3633bf")
    @Override
    public Object visitOutcome(Outcome obj) {
        	return null;
    }

    @objid ("9d34fdfc-c2b7-4715-9181-0eb7d4286532")
    @Override
    public Object visitPassiveStructureElement(PassiveStructureElement obj) {
        	return null;
    }

    @objid ("6d3c419c-ba70-4245-a091-3b85a64d08ea")
    @Override
    public Object visitPath(Path obj) {
        	return null;
    }

    @objid ("e59e3a04-bcf1-4528-be35-5f9f84f22f79")
    @Override
    public Object visitPhysicalFolder(PhysicalFolder obj) {
        	return null;
    }

    @objid ("a2db9573-95ec-48f1-ba85-adcae21b8177")
    @Override
    public Object visitPlateau(Plateau obj) {
        	return null;
    }

    @objid ("a3a4a0da-05bb-4f2b-ae26-a6df55d6697d")
    @Override
    public Object visitPrinciple(Principle obj) {
        	return null;
    }

    @objid ("0204e080-9f51-4930-8001-2fdb0cfd59b1")
    @Override
    public Object visitProduct(Product obj) {
        	return null;
    }

    @objid ("6fdbebd6-c5e3-4006-9dc8-12300c648843")
    @Override
    public Object visitRealization(Realization obj) {
        	return null;
    }

    @objid ("5d868eeb-d31f-4243-9c98-95bcf932eb38")
    @Override
    public Object visitRelationship(Relationship obj) {
        	return null;
    }

    @objid ("6cc701d3-f5f9-4bc0-a5f3-cbcd327706d7")
    @Override
    public Object visitRelationshipConnector(RelationshipConnector obj) {
        	return null;
    }

    @objid ("a7715b65-836a-41ad-b521-5c8056eb7f30")
    @Override
    public Object visitRepresentation(Representation obj) {
        	return null;
    }

    @objid ("d45bbf79-3af3-4b75-856f-598ba92a2326")
    @Override
    public Object visitRequirement(Requirement obj) {
        	return null;
    }

    @objid ("be8d96ee-6c18-4fca-bf61-9f6c5bd38030")
    @Override
    public Object visitResource(Resource obj) {
        	return null;
    }

    @objid ("150b50f7-3001-4b06-bbd7-37fada6154b3")
    @Override
    public Object visitServing(Serving obj) {
        	return null;
    }

    @objid ("74696243-7374-4fa8-9d1f-b931efcb54d0")
    @Override
    public Object visitSpecialization(Specialization obj) {
        	return null;
    }

    @objid ("8b437ce6-4785-4c5a-9369-5724211fd23d")
    @Override
    public Object visitStakeholder(Stakeholder obj) {
        	return null;
    }

    @objid ("b316c61b-31ed-46e0-9662-e7ba35f5596f")
    @Override
    public Object visitStrategyBehaviorElement(StrategyBehaviorElement obj) {
        	return null;
    }

    @objid ("408b6d10-cdf2-4743-8b8b-bb8f98e5cf08")
    @Override
    public Object visitStrategyFolder(StrategyFolder obj) {
        	return null;
    }

    @objid ("965b272c-bce6-4e78-af08-563b73d2a461")
    @Override
    public Object visitStructuralRelationship(StructuralRelationship obj) {
        	return null;
    }

    @objid ("e67e4dd3-38c0-47ed-a064-144d5de375e5")
    @Override
    public Object visitStructureElement(StructureElement obj) {
        	return null;
    }

    @objid ("b6aaaf2c-ffa3-4244-a1f1-03e770fe189f")
    @Override
    public Object visitSystemSoftware(SystemSoftware obj) {
        	return null;
    }

    @objid ("c3f2b7d8-26aa-4538-810a-f0d7fec14cb1")
    @Override
    public Object visitTechnologyActiveStructureElement(TechnologyActiveStructureElement obj) {
        	return null;
    }

    @objid ("4d04ad76-666c-4523-aad2-1a1e9f9edde0")
    @Override
    public Object visitTechnologyCollaboration(TechnologyCollaboration obj) {
        	return null;
    }

    @objid ("2432e32c-d63b-48ae-b609-9784fb2c145b")
    @Override
    public Object visitTechnologyEvent(TechnologyEvent obj) {
        	return null;
    }

    @objid ("beaad3fb-ea65-4fcf-8b4a-1e24ff361174")
    @Override
    public Object visitTechnologyFolder(TechnologyFolder obj) {
        	return null;
    }

    @objid ("aad04e24-544d-4384-8e37-8876375343d9")
    @Override
    public Object visitTechnologyFunction(TechnologyFunction obj) {
        	return null;
    }

    @objid ("e23d6c84-4872-476b-adc1-c52831c070c6")
    @Override
    public Object visitTechnologyInteraction(TechnologyInteraction obj) {
        	return null;
    }

    @objid ("a8dadb31-03be-45c1-9bae-c1378feaf9db")
    @Override
    public Object visitTechnologyInterface(TechnologyInterface obj) {
        	return null;
    }

    @objid ("cdf30dc6-b261-47e8-83ff-f9c7eadcd4dd")
    @Override
    public Object visitTechnologyInternalActiveStructureElement(TechnologyInternalActiveStructureElement obj) {
        	return null;
    }

    @objid ("e60a89da-7b2c-4157-b443-7d41a9697069")
    @Override
    public Object visitTechnologyInternalBehaviorElement(TechnologyInternalBehaviorElement obj) {
        	return null;
    }

    @objid ("0331d36f-a86f-4bb3-a642-d4cfef8c2155")
    @Override
    public Object visitTechnologyObject(TechnologyObject obj) {
        	return null;
    }

    @objid ("b81ceb81-8c24-466d-9fd1-542094d9bb60")
    @Override
    public Object visitTechnologyProcess(TechnologyProcess obj) {
        	return null;
    }

    @objid ("567bf279-ec25-4d22-a14c-2c90873b4a5c")
    @Override
    public Object visitTechnologyService(TechnologyService obj) {
        	return null;
    }

    @objid ("9447d7ef-57ea-4ec2-91b5-59d98e807a00")
    @Override
    public Object visitTriggering(Triggering obj) {
        	return null;
    }

    @objid ("587a26b0-70ed-4477-b857-c5a351d0522a")
    @Override
    public Object visitValue(Value obj) {
        	return null;
    }

    @objid ("8545aab5-0fac-4033-bd95-4b7d5d1c629f")
    @Override
    public Object visitValueStream(ValueStream obj) {
        	return null;
    }

    @objid ("fc619ac2-5015-4e00-849d-f913b9f2dabc")
    @Override
    public Object visitViewPoint(ViewPoint obj) {
        	return null;
    }

    @objid ("7d4c1c09-e822-4ba5-ae33-4fae68a15d49")
    @Override
    public Object visitViewPointDiagram(ViewPointDiagram obj) {
        	return null;
    }

    @objid ("6dbdf582-96f5-4ad2-8f99-b7e4eb61469d")
    @Override
    public Object visitWorkPackage(WorkPackage obj) {
        	return null;
    }

}
