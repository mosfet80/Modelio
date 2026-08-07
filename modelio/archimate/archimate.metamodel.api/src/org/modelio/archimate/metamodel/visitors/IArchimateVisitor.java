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
import org.modelio.vcore.smkernel.mapi.MVisitor;

@objid ("66b08ca9-d491-4feb-9501-7a05248f9fdd")
public interface IArchimateVisitor extends MVisitor {
    @objid ("fbcdbd36-1360-493b-ad67-246f707abbf6")
    abstract Object visitAccess(Access obj);

    @objid ("005963c6-d14a-44a3-9980-acf3454d3735")
    abstract Object visitActiveStructureElement(ActiveStructureElement obj);

    @objid ("b53792ed-4c0d-4cd8-89fa-daa9706b220a")
    abstract Object visitAggregation(Aggregation obj);

    @objid ("5b6259c1-23bf-4f39-bb53-72e0f1485521")
    abstract Object visitAndJunction(AndJunction obj);

    @objid ("5ab87688-1cd7-4484-9c6a-7376e00305f4")
    abstract Object visitApplicationCollaboration(ApplicationCollaboration obj);

    @objid ("6dc02a4c-eec5-440e-968c-95f715790473")
    abstract Object visitApplicationComponent(ApplicationComponent obj);

    @objid ("f549045a-3a04-48f1-be84-06a764a8c3e9")
    abstract Object visitApplicationEvent(ApplicationEvent obj);

    @objid ("823cd148-38a4-4859-badd-1c31d406fd34")
    abstract Object visitApplicationFolder(ApplicationFolder obj);

    @objid ("9b2dbc15-f3bf-490c-bb87-ec6a9e6318a9")
    abstract Object visitApplicationFunction(ApplicationFunction obj);

    @objid ("6bd3e464-fc23-4dc2-983b-37ecfa5d2303")
    abstract Object visitApplicationInteraction(ApplicationInteraction obj);

    @objid ("b6c82199-dca3-4da2-8471-3b63dd4ee4af")
    abstract Object visitApplicationInterface(ApplicationInterface obj);

    @objid ("ef42785d-dca8-4844-afe5-05f3f8340c45")
    abstract Object visitApplicationInternalActiveStructureElement(ApplicationInternalActiveStructureElement obj);

    @objid ("fc072602-0922-4bdf-990b-ec19d57381b6")
    abstract Object visitApplicationInternalBehaviorElement(ApplicationInternalBehaviorElement obj);

    @objid ("ca33974b-09ca-41fa-a7b4-428fafe68c1c")
    abstract Object visitApplicationProcess(ApplicationProcess obj);

    @objid ("adb5d56a-837f-4ebe-b417-cf7c4a57d48d")
    abstract Object visitApplicationService(ApplicationService obj);

    @objid ("2c8ec5a2-f0f1-468e-9d25-1d39351b0853")
    abstract Object visitArchimateAbstractElement(ArchimateAbstractElement obj);

    @objid ("0ec248ef-c2d6-4554-9fa3-83399d989b05")
    abstract Object visitArchimateProject(ArchimateProject obj);

    @objid ("b7e712a7-670d-4b1f-80be-b91f64996744")
    abstract Object visitArchimateView(ArchimateView obj);

    @objid ("1a13719f-592c-442c-a2fe-c03f972865d6")
    abstract Object visitArtifact(Artifact obj);

    @objid ("80892df9-7ce7-46a0-91e9-9c9df7f0c95e")
    abstract Object visitAssessment(Assessment obj);

    @objid ("1263ee90-a3a0-4bd5-95e6-5b22c01078da")
    abstract Object visitAssignment(Assignment obj);

    @objid ("4c5d1c16-8479-412f-a253-5daff054ee79")
    abstract Object visitAssociation(Association obj);

    @objid ("7570e986-25ab-4b40-8f1b-5ea7552af8d0")
    abstract Object visitBehaviorElement(BehaviorElement obj);

    @objid ("8b05309b-3756-4543-b8ae-5a31afebc7b6")
    abstract Object visitBusinessActor(BusinessActor obj);

    @objid ("fa8b904f-7104-42f0-a08e-bd8417c57913")
    abstract Object visitBusinessCollaboration(BusinessCollaboration obj);

    @objid ("a4f35bb1-0113-49d3-a070-e4572452538b")
    abstract Object visitBusinessEvent(BusinessEvent obj);

    @objid ("a0786225-49ec-4e1d-8ecc-0a4f3e5d9721")
    abstract Object visitBusinessFolder(BusinessFolder obj);

    @objid ("50663047-62f6-44f6-87c5-557825ca652a")
    abstract Object visitBusinessFunction(BusinessFunction obj);

    @objid ("5a0d20fa-e69f-4e71-8dc2-5941d1b18a62")
    abstract Object visitBusinessInteraction(BusinessInteraction obj);

    @objid ("56c37b28-9f1d-450b-87af-b814b2cee23a")
    abstract Object visitBusinessInterface(BusinessInterface obj);

    @objid ("d84d90b6-4003-487a-825e-f445dfc83fcd")
    abstract Object visitBusinessInternalActiveStructureElement(BusinessInternalActiveStructureElement obj);

    @objid ("9573f29a-c300-4fb9-97f5-c0f97cd0ccc0")
    abstract Object visitBusinessInternalBehaviorElement(BusinessInternalBehaviorElement obj);

    @objid ("1ffd6f6c-227d-419c-a850-cbc3224251ce")
    abstract Object visitBusinessObject(BusinessObject obj);

    @objid ("af21ee67-05ef-4f7b-add6-ea123797660c")
    abstract Object visitBusinessPassiveStructureElement(BusinessPassiveStructureElement obj);

    @objid ("47649694-67fe-4fb6-ae7b-31d65c1fb07b")
    abstract Object visitBusinessProcess(BusinessProcess obj);

    @objid ("d6eb2259-b3e0-427e-8564-aba74b743c48")
    abstract Object visitBusinessRole(BusinessRole obj);

    @objid ("6d8f6413-f6d2-48d7-a5b4-5874fcf33774")
    abstract Object visitBusinessService(BusinessService obj);

    @objid ("831f2145-6de8-4e2d-82ad-e37f66233f62")
    abstract Object visitCapability(Capability obj);

    @objid ("a597c8a2-5874-40a1-b0c1-ce93bfac4d50")
    abstract Object visitCommunicationNetwork(CommunicationNetwork obj);

    @objid ("f66879bc-1df6-4327-acb3-82f9ead5e242")
    abstract Object visitCompositeElement(CompositeElement obj);

    @objid ("fbbd29aa-2f9b-4d77-b1de-b6673e876251")
    abstract Object visitComposition(Composition obj);

    @objid ("331934e7-809c-45c4-baa5-7f17adda9cdd")
    abstract Object visitConcept(Concept obj);

    @objid ("42d8099f-0aac-4d5f-99e1-24ffa8349996")
    abstract Object visitConstraint(Constraint obj);

    @objid ("f5313871-0d0d-429a-ae06-a47a1cd5786a")
    abstract Object visitContract(Contract obj);

    @objid ("93f5749b-5384-4c4f-af43-b67e0eb49d66")
    abstract Object visitCourseOfAction(CourseOfAction obj);

    @objid ("4a14ec55-4e6f-49b8-b3f3-d203d9bf8e08")
    abstract Object visitDataObject(DataObject obj);

    @objid ("a1dbf845-aedc-4072-838c-a404700ad8db")
    abstract Object visitDeliverable(Deliverable obj);

    @objid ("6a44b771-dac2-4008-aec9-98102d13e0f2")
    abstract Object visitDependencyRelationship(DependencyRelationship obj);

    @objid ("0cbb8611-6a09-4479-9818-d76660d2cccb")
    abstract Object visitDevice(Device obj);

    @objid ("d8afe456-515e-42a1-99da-540873757dad")
    abstract Object visitDistributionNetwork(DistributionNetwork obj);

    @objid ("198578a0-0749-4f05-9300-8881b0599d78")
    abstract Object visitDriver(Driver obj);

    @objid ("fc973d5a-fe8f-4eee-8398-2badaf74f122")
    abstract Object visitDynamicRelationship(DynamicRelationship obj);

    @objid ("7724da95-9942-4d1e-b006-48a97a6aba6d")
    abstract Object visitElement(Element obj);

    @objid ("ddfcd228-ca6b-4b4a-8f7a-151f04d227f6")
    abstract Object visitEquipment(Equipment obj);

    @objid ("938d4f66-c440-4dab-9005-7ed90f65be27")
    abstract Object visitEvent(Event obj);

    @objid ("c284cd46-ffdd-4c5a-a196-f0f227e7b97e")
    abstract Object visitExternalActiveStructureElement(ExternalActiveStructureElement obj);

    @objid ("35312490-4b19-45e6-b0f7-706766e39dc2")
    abstract Object visitExternalBehaviorElement(ExternalBehaviorElement obj);

    @objid ("09d83733-a93a-49e7-8158-96a63e413eb1")
    abstract Object visitFacility(Facility obj);

    @objid ("4c43b633-1aac-4862-bd2c-711788e4b8f5")
    abstract Object visitFlow(Flow obj);

    @objid ("bb36ffe3-b3a3-404b-a442-ae64456f2b70")
    abstract Object visitFolder(Folder obj);

    @objid ("0287576b-bb00-47c1-8551-16e2f26a1711")
    abstract Object visitGap(Gap obj);

    @objid ("159fab13-e431-4356-b0e1-7e67d2f022e5")
    abstract Object visitGoal(Goal obj);

    @objid ("b6d4ef46-8ccb-4f6a-b7cf-1652059d3490")
    abstract Object visitGrouping(Grouping obj);

    @objid ("bb8ba0db-7f68-4fa2-8b24-66205c4de072")
    abstract Object visitImplementationEvent(ImplementationEvent obj);

    @objid ("db2809ff-4c49-41c3-9c95-21534e85eb6b")
    abstract Object visitImplementationFolder(ImplementationFolder obj);

    @objid ("0a5f229e-fe01-4c97-9498-6466fa240749")
    abstract Object visitInfluence(Influence obj);

    @objid ("152f5aab-f345-44e0-b725-41ecb593ee79")
    abstract Object visitInternalActiveStructureElement(InternalActiveStructureElement obj);

    @objid ("d0c7fbd6-4968-4a18-991f-4691e75a1068")
    abstract Object visitInternalBehaviorElement(InternalBehaviorElement obj);

    @objid ("820dd05a-687e-4630-8bf3-a79a5d3777bf")
    abstract Object visitJunction(Junction obj);

    @objid ("a46c0707-b023-4cb2-a7ce-317c0f4a304f")
    abstract Object visitLocation(Location obj);

    @objid ("6ea0c83a-6fa1-4816-9200-24990b0c8ab6")
    abstract Object visitMaterial(Material obj);

    @objid ("dcf3ccb8-7639-41df-afca-e99f2e8679ed")
    abstract Object visitMeaning(Meaning obj);

    @objid ("c8c1ad8a-0b44-42de-a45c-7287d0c86431")
    abstract Object visitModel(Model obj);

    @objid ("86c61b5b-fb73-4ad6-9f8c-f062d09d346c")
    abstract Object visitMotivationElement(MotivationElement obj);

    @objid ("8c6ce832-03a7-46f0-83a3-82d812f44ac4")
    abstract Object visitMotivationFolder(MotivationFolder obj);

    @objid ("8e6c6b0b-09c4-446d-b5f1-dd0b18233586")
    abstract Object visitNode(Node obj);

    @objid ("6072d4b5-e84b-4881-8657-79efa2f8a688")
    abstract Object visitOrJunction(OrJunction obj);

    @objid ("e7fc5f4a-6020-4e17-9c9c-28ae7006a9f2")
    abstract Object visitOtherRelationship(OtherRelationship obj);

    @objid ("c7007aa1-422c-4419-98b9-33c8ea19bff8")
    abstract Object visitOutcome(Outcome obj);

    @objid ("ce0f1338-3937-437c-9877-613338af626c")
    abstract Object visitPassiveStructureElement(PassiveStructureElement obj);

    @objid ("f48f7248-0a00-4b84-8a5a-697b6bd0cdaa")
    abstract Object visitPath(Path obj);

    @objid ("bb47f4b3-24b9-476e-8ec4-55d091cdcbba")
    abstract Object visitPhysicalFolder(PhysicalFolder obj);

    @objid ("7fb43ce8-01ce-467d-9f7e-2ea9a4c99da0")
    abstract Object visitPlateau(Plateau obj);

    @objid ("b269c150-06a9-45aa-bb12-fffecd141761")
    abstract Object visitPrinciple(Principle obj);

    @objid ("1ebab207-f53a-4dcf-b577-d915e6833286")
    abstract Object visitProduct(Product obj);

    @objid ("d6ff5151-0380-4838-a4e0-44a101c9c89d")
    abstract Object visitRealization(Realization obj);

    @objid ("339d55fb-4010-49f7-80db-c323745a009b")
    abstract Object visitRelationship(Relationship obj);

    @objid ("9fd28bae-15a6-4f8c-a92b-ed06f9a5b2c2")
    abstract Object visitRelationshipConnector(RelationshipConnector obj);

    @objid ("52889fe2-f165-4dc2-9195-8da62c38ddfe")
    abstract Object visitRepresentation(Representation obj);

    @objid ("1bfca314-e7ac-4cf9-88a7-a4562539be9e")
    abstract Object visitRequirement(Requirement obj);

    @objid ("2e2031e1-943d-4efe-bfb1-ba324784f9ce")
    abstract Object visitResource(Resource obj);

    @objid ("fd5eb4b4-e5aa-49ea-9eb8-adcd215da20c")
    abstract Object visitServing(Serving obj);

    @objid ("6d6eea51-d756-4a3e-81ff-5b3bb42764e6")
    abstract Object visitSpecialization(Specialization obj);

    @objid ("1fd5beb9-3fff-4dd8-902c-e1e2e53f342d")
    abstract Object visitStakeholder(Stakeholder obj);

    @objid ("08d7b2e2-740a-4523-952b-b3b0dfdc8665")
    abstract Object visitStrategyBehaviorElement(StrategyBehaviorElement obj);

    @objid ("acc303ad-3972-480d-b9db-bb9827da583e")
    abstract Object visitStrategyFolder(StrategyFolder obj);

    @objid ("cf7eb5e6-8ecb-4316-8827-eaaa098ba3b0")
    abstract Object visitStructuralRelationship(StructuralRelationship obj);

    @objid ("7875f1e9-7c9c-4700-8a1e-4cedff86a014")
    abstract Object visitStructureElement(StructureElement obj);

    @objid ("6865b19d-62fd-4a6b-99e1-eca26963fab7")
    abstract Object visitSystemSoftware(SystemSoftware obj);

    @objid ("a43ed9c4-1898-4185-9182-30b9b99d6a5c")
    abstract Object visitTechnologyActiveStructureElement(TechnologyActiveStructureElement obj);

    @objid ("0f326be5-59a6-4b46-a7f0-7e7df912004a")
    abstract Object visitTechnologyCollaboration(TechnologyCollaboration obj);

    @objid ("54cb71a1-a536-42b1-93b8-9ca2cea7d02b")
    abstract Object visitTechnologyEvent(TechnologyEvent obj);

    @objid ("badf86ac-852a-467d-ad9a-809614c01680")
    abstract Object visitTechnologyFolder(TechnologyFolder obj);

    @objid ("f54f457a-0c1a-492f-8783-b34494d97b14")
    abstract Object visitTechnologyFunction(TechnologyFunction obj);

    @objid ("41b03aa1-5d45-4227-b1a5-6acf08070036")
    abstract Object visitTechnologyInteraction(TechnologyInteraction obj);

    @objid ("f5aa56ed-a328-4b7d-bf96-fb6c8d7695cb")
    abstract Object visitTechnologyInterface(TechnologyInterface obj);

    @objid ("e854d21b-8b0c-4122-87b8-aca44880950b")
    abstract Object visitTechnologyInternalActiveStructureElement(TechnologyInternalActiveStructureElement obj);

    @objid ("19af6295-596a-440f-97b3-0f575f160c64")
    abstract Object visitTechnologyInternalBehaviorElement(TechnologyInternalBehaviorElement obj);

    @objid ("83156697-3256-4c02-b751-a5790823e746")
    abstract Object visitTechnologyObject(TechnologyObject obj);

    @objid ("5e08be78-29cb-4cfb-838e-3f27a228a2f6")
    abstract Object visitTechnologyProcess(TechnologyProcess obj);

    @objid ("c272403d-42a6-4df4-8a9a-1b9176f7a2a4")
    abstract Object visitTechnologyService(TechnologyService obj);

    @objid ("4f62f85e-0dd9-45a2-919b-a275f109a700")
    abstract Object visitTriggering(Triggering obj);

    @objid ("bd09b020-c6e5-4879-8608-35986b5b6d6a")
    abstract Object visitValue(Value obj);

    @objid ("0eee849c-10ae-4b57-b0dd-aeaea65e6a8d")
    abstract Object visitValueStream(ValueStream obj);

    @objid ("d4f35986-c10a-4c7a-aa0b-130b4c22eaf3")
    abstract Object visitViewPoint(ViewPoint obj);

    @objid ("1cb27405-e4e5-4f20-9dbc-53d8d84a9e4c")
    abstract Object visitViewPointDiagram(ViewPointDiagram obj);

    @objid ("dfa94d8a-724c-4406-90b8-cf4d7423c27c")
    abstract Object visitWorkPackage(WorkPackage obj);

}
