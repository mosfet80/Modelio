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
 * This class is an implementation of {@link IArchimateVisitor} whose default strategy consists in transmitting the visit call to the super class visit method.
 * <p>On root metaclasses, the visitor tries to delegate to the configured delegation visitor if available.If not available, <code>null</code> is returned.
 */
@objid ("6a4944f5-c8b9-464e-979e-16abbdeb294f")
public class DefaultArchimateVisitor implements IArchimateVisitor {
    @objid ("de8b4f99-d1fe-4aeb-9600-285ac646f0fb")
    protected IInfrastructureVisitor infrastructureVisitor = null;

    @objid ("2b35be9f-efed-4d65-aa06-987eb7344895")
    public DefaultArchimateVisitor() {
        super();
    }

    @objid ("497ee6bc-090c-4528-9296-28dedafe5aba")
    public DefaultArchimateVisitor(IInfrastructureVisitor infrastructureVisitor) {
        super();
        this.infrastructureVisitor = infrastructureVisitor;
    }

    @objid ("dd55edca-a612-47fa-a4be-27749c710da7")
    @Override
    public Object visitAccess(Access obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("d124d5d0-76fa-46ec-b221-f9944990151f")
    @Override
    public Object visitActiveStructureElement(ActiveStructureElement obj) {
        return visitStructureElement(obj);

    }

    @objid ("6528a9e8-d70d-45a1-aa0c-a446c6e7b761")
    @Override
    public Object visitAggregation(Aggregation obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("bd8b73e3-cb98-438e-b85d-5907900a2f70")
    @Override
    public Object visitAndJunction(AndJunction obj) {
        return visitJunction(obj);

    }

    @objid ("f5f92a73-cc12-43f1-9c47-cce2ca3511d9")
    @Override
    public Object visitApplicationCollaboration(ApplicationCollaboration obj) {
        return visitApplicationInternalActiveStructureElement(obj);

    }

    @objid ("1d4e95df-0a78-417f-a1fd-390c735cb17f")
    @Override
    public Object visitApplicationComponent(ApplicationComponent obj) {
        return visitApplicationInternalActiveStructureElement(obj);

    }

    @objid ("814e4f42-482f-4e3d-8d47-fd28fa7eb9be")
    @Override
    public Object visitApplicationEvent(ApplicationEvent obj) {
        return visitEvent(obj);

    }

    @objid ("71b4f045-3606-475b-ab62-a6f843731e07")
    @Override
    public Object visitApplicationFolder(ApplicationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("42d90368-a6b4-4402-81e0-b9c46b3c95fe")
    @Override
    public Object visitApplicationFunction(ApplicationFunction obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("290ffc3a-fca8-4dcc-8b06-fdec8acf9ad8")
    @Override
    public Object visitApplicationInteraction(ApplicationInteraction obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("d1e6abda-6487-46e3-bc08-70acd63538af")
    @Override
    public Object visitApplicationInterface(ApplicationInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("e1487b3e-2e8d-4e48-a786-3dddf5e86dae")
    @Override
    public Object visitApplicationInternalActiveStructureElement(ApplicationInternalActiveStructureElement obj) {
        return visitInternalActiveStructureElement(obj);

    }

    @objid ("b5861b6e-c9af-4514-87b2-ef4bd68f5f42")
    @Override
    public Object visitApplicationInternalBehaviorElement(ApplicationInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("cc478a2a-e24d-4b57-b64a-ba988c30b56b")
    @Override
    public Object visitApplicationProcess(ApplicationProcess obj) {
        return visitApplicationInternalBehaviorElement(obj);

    }

    @objid ("be2f9354-ba90-418d-b6cf-4281e74f8693")
    @Override
    public Object visitApplicationService(ApplicationService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("cf6b7188-93d3-4af4-abbd-93c4915958ee")
    @Override
    public Object visitArchimateAbstractElement(ArchimateAbstractElement obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitModelElement(obj) : null;

    }

    @objid ("0f19b049-afe5-499e-9bb4-235ea6c35bc5")
    @Override
    public Object visitArchimateProject(ArchimateProject obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractProject(obj) : null;

    }

    @objid ("99b72d94-97c9-4efd-a24b-f1e448be30ad")
    @Override
    public Object visitArchimateView(ArchimateView obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractDiagram(obj) : null;

    }

    @objid ("fd3360ee-45cb-46f8-bf1c-c3d886780707")
    @Override
    public Object visitArtifact(Artifact obj) {
        return visitTechnologyObject(obj);

    }

    @objid ("bfb8ab46-dd6d-4ad3-972b-222d60398b67")
    @Override
    public Object visitAssessment(Assessment obj) {
        return visitMotivationElement(obj);

    }

    @objid ("a42ae48e-cb33-4675-be2b-0e8250c99144")
    @Override
    public Object visitAssignment(Assignment obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("fa81421b-8aa0-452c-9db9-fb017518c481")
    @Override
    public Object visitAssociation(Association obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("0f5cb2df-a76a-467d-a645-4dea89616c6a")
    @Override
    public Object visitBehaviorElement(BehaviorElement obj) {
        return visitElement(obj);

    }

    @objid ("86618582-10d2-46d0-9ab1-e3491412cd53")
    @Override
    public Object visitBusinessActor(BusinessActor obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("b5b5b0e5-bacd-460e-8684-a35875c4806e")
    @Override
    public Object visitBusinessCollaboration(BusinessCollaboration obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("df976e69-2f0e-4bec-9f53-a64129aff6f8")
    @Override
    public Object visitBusinessEvent(BusinessEvent obj) {
        return visitEvent(obj);

    }

    @objid ("127198b7-7112-4696-9663-991b10e3ae89")
    @Override
    public Object visitBusinessFolder(BusinessFolder obj) {
        return visitFolder(obj);

    }

    @objid ("136d23bf-f182-4956-b348-a3aaf4885536")
    @Override
    public Object visitBusinessFunction(BusinessFunction obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("bd616e5a-e525-428e-9e7d-761c6b72f05d")
    @Override
    public Object visitBusinessInteraction(BusinessInteraction obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("614ad3f8-fae4-4a5e-9114-deedd611cebc")
    @Override
    public Object visitBusinessInterface(BusinessInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("92496216-82c3-47e6-bdd7-b1261f970152")
    @Override
    public Object visitBusinessInternalActiveStructureElement(BusinessInternalActiveStructureElement obj) {
        return visitInternalActiveStructureElement(obj);

    }

    @objid ("7422b089-1f99-476c-a480-77f4c8ee32b2")
    @Override
    public Object visitBusinessInternalBehaviorElement(BusinessInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("5f070b98-3024-4f8d-bff5-5e586b79811c")
    @Override
    public Object visitBusinessObject(BusinessObject obj) {
        return visitBusinessPassiveStructureElement(obj);

    }

    @objid ("cdc977e9-0b0e-4622-a909-4c5b585afd05")
    @Override
    public Object visitBusinessPassiveStructureElement(BusinessPassiveStructureElement obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("74a3a8b0-224d-4db3-88e2-a44043cf0c3a")
    @Override
    public Object visitBusinessProcess(BusinessProcess obj) {
        return visitBusinessInternalBehaviorElement(obj);

    }

    @objid ("5b070f7b-c3a2-4c81-8d03-1cb6d83ccfd6")
    @Override
    public Object visitBusinessRole(BusinessRole obj) {
        return visitBusinessInternalActiveStructureElement(obj);

    }

    @objid ("a53ae1e4-2989-4792-ac1e-9a39cf7dc724")
    @Override
    public Object visitBusinessService(BusinessService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("cabaa267-0bd6-4c56-add5-7dde3a7a5715")
    @Override
    public Object visitCapability(Capability obj) {
        return visitStrategyBehaviorElement(obj);

    }

    @objid ("137acbce-b8b5-4c00-b441-76d69eeac247")
    @Override
    public Object visitCommunicationNetwork(CommunicationNetwork obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("6ada7fbe-9962-4c72-b60f-f0bdb2609daf")
    @Override
    public Object visitCompositeElement(CompositeElement obj) {
        return visitElement(obj);

    }

    @objid ("5a988d91-d961-4ba9-b4db-763dc9bc6710")
    @Override
    public Object visitComposition(Composition obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("27916a8c-62b8-450a-b5c6-45eb42de887a")
    @Override
    public Object visitConcept(Concept obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("b4b52493-7394-4e62-b64a-56715ed1ce3c")
    @Override
    public Object visitConstraint(Constraint obj) {
        return visitRequirement(obj);

    }

    @objid ("f3eb61c4-fd88-4e54-bda4-872bc7081edc")
    @Override
    public Object visitContract(Contract obj) {
        return visitBusinessObject(obj);

    }

    @objid ("112b624a-4760-4b22-a014-23426381a824")
    @Override
    public Object visitCourseOfAction(CourseOfAction obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("5a9b0ca5-c276-4e23-a3f7-bb48f876f2f9")
    @Override
    public Object visitDataObject(DataObject obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("ea865da9-1858-4ee4-8818-8af5c7df4c7f")
    @Override
    public Object visitDeliverable(Deliverable obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("c6090ece-7dac-40c0-99e9-20ba775722e2")
    @Override
    public Object visitDependencyRelationship(DependencyRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("c6402bf1-bd5a-4f66-a2e6-5494affc212d")
    @Override
    public Object visitDevice(Device obj) {
        return visitNode(obj);

    }

    @objid ("a0c80a37-80d3-4428-97bb-1660e87a97a6")
    @Override
    public Object visitDistributionNetwork(DistributionNetwork obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("d0fdcf39-dcc8-462b-b47d-d4d474f35bf2")
    @Override
    public Object visitDriver(Driver obj) {
        return visitMotivationElement(obj);

    }

    @objid ("97ac924e-df1c-4c2b-a3fc-62966cd53031")
    @Override
    public Object visitDynamicRelationship(DynamicRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("31ee32b8-0593-440d-925a-a41fee4338b2")
    @Override
    public Object visitElement(Element obj) {
        return visitConcept(obj);

    }

    @objid ("bca5f214-990f-4d39-b3de-1a8788ec8490")
    @Override
    public Object visitEquipment(Equipment obj) {
        return visitNode(obj);

    }

    @objid ("aa41f8ff-a81b-41fc-8b36-d0425d0b6f7d")
    @Override
    public Object visitEvent(Event obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("0d5b831c-7787-4ccf-8d82-1341ce500870")
    @Override
    public Object visitExternalActiveStructureElement(ExternalActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("3c523a60-f6f5-4ea9-adff-8ba97149ed7e")
    @Override
    public Object visitExternalBehaviorElement(ExternalBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("0d6ebcab-ea49-4035-8480-4d7bd91e3c6b")
    @Override
    public Object visitFacility(Facility obj) {
        return visitNode(obj);

    }

    @objid ("a885fde7-be2c-430c-9642-9cfc4844f59f")
    @Override
    public Object visitFlow(Flow obj) {
        return visitDynamicRelationship(obj);

    }

    @objid ("ac16f42e-03f4-403b-83f0-bef4ad987a35")
    @Override
    public Object visitFolder(Folder obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("18ecc6da-ec05-4521-84ab-a5954ad5ef41")
    @Override
    public Object visitGap(Gap obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("a87dbe63-4069-4269-beb2-555830bd2674")
    @Override
    public Object visitGoal(Goal obj) {
        return visitMotivationElement(obj);

    }

    @objid ("eee9596b-2d29-4447-b2a8-83641fd09fe6")
    @Override
    public Object visitGrouping(Grouping obj) {
        return visitCompositeElement(obj);

    }

    @objid ("9850f50e-be58-4bb3-b7f8-ecae48cd2b67")
    @Override
    public Object visitImplementationEvent(ImplementationEvent obj) {
        return visitEvent(obj);

    }

    @objid ("8061545e-d9c2-4a9d-a9a2-a838161785a9")
    @Override
    public Object visitImplementationFolder(ImplementationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("2975da71-e1bc-4c7e-8555-5d3ca5abec9f")
    @Override
    public Object visitInfluence(Influence obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("710244db-4b3d-4c2e-9d6a-ea6b37f319fb")
    @Override
    public Object visitInternalActiveStructureElement(InternalActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("62367b99-031f-4c65-9f1a-b660f91c4f42")
    @Override
    public Object visitInternalBehaviorElement(InternalBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("22a7cbea-01d8-46f0-aad5-3e4a4ebf0917")
    @Override
    public Object visitJunction(Junction obj) {
        return visitRelationshipConnector(obj);

    }

    @objid ("5aa3c53d-8c9d-4d9e-b264-70bc620d5c27")
    @Override
    public Object visitLocation(Location obj) {
        return visitCompositeElement(obj);

    }

    @objid ("46404538-d3d2-4a16-98e6-55886c05dd67")
    @Override
    public Object visitMaterial(Material obj) {
        return visitTechnologyObject(obj);

    }

    @objid ("0a0c4812-cc47-4de5-86a3-0e4d990a3138")
    @Override
    public Object visitMeaning(Meaning obj) {
        return visitMotivationElement(obj);

    }

    @objid ("46219e4f-e0a5-4404-a97d-160245379926")
    @Override
    public Object visitModel(Model obj) {
        return visitFolder(obj);

    }

    @objid ("143a65e6-8c91-473a-b8f6-6c3cda1aac41")
    @Override
    public Object visitMotivationElement(MotivationElement obj) {
        return visitElement(obj);

    }

    @objid ("fe981c08-30e1-492f-8b80-91a119667c88")
    @Override
    public Object visitMotivationFolder(MotivationFolder obj) {
        return visitFolder(obj);

    }

    @objid ("d85808d1-b317-4e26-8489-3919d2327352")
    @Override
    public Object visitNode(Node obj) {
        return visitTechnologyInternalActiveStructureElement(obj);

    }

    @objid ("da7b1ad9-7215-4ff1-a04d-36a94edac70b")
    @Override
    public Object visitOrJunction(OrJunction obj) {
        return visitJunction(obj);

    }

    @objid ("3a359120-f092-40d6-a046-73d2d0c9fc9d")
    @Override
    public Object visitOtherRelationship(OtherRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("30340558-7468-46f2-8674-2479aa47b947")
    @Override
    public Object visitOutcome(Outcome obj) {
        return visitMotivationElement(obj);

    }

    @objid ("f043c992-a18e-4c29-8a0e-608863456d7a")
    @Override
    public Object visitPassiveStructureElement(PassiveStructureElement obj) {
        return visitStructureElement(obj);

    }

    @objid ("582114b2-b6a2-4d3f-ba65-9144b1c9ecb4")
    @Override
    public Object visitPath(Path obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("f6e695e0-f6db-4526-9f4d-e131a8cac630")
    @Override
    public Object visitPhysicalFolder(PhysicalFolder obj) {
        return visitFolder(obj);

    }

    @objid ("02443e7d-5ed1-4f56-8747-9d653846ddb4")
    @Override
    public Object visitPlateau(Plateau obj) {
        return visitCompositeElement(obj);

    }

    @objid ("333adeab-9f75-4690-ae4e-cb698cdbeb31")
    @Override
    public Object visitPrinciple(Principle obj) {
        return visitMotivationElement(obj);

    }

    @objid ("06aecc9a-ae96-49a5-838e-68a0e419cfc6")
    @Override
    public Object visitProduct(Product obj) {
        return visitCompositeElement(obj);

    }

    @objid ("934f8656-25fa-451e-8d26-49973020e5e8")
    @Override
    public Object visitRealization(Realization obj) {
        return visitStructuralRelationship(obj);

    }

    @objid ("fcd5361e-1d25-4109-b7a7-b40c1999e7fb")
    @Override
    public Object visitRelationship(Relationship obj) {
        return visitConcept(obj);

    }

    @objid ("ecf7ba91-4d2c-407e-8cd2-0c9706b51218")
    @Override
    public Object visitRelationshipConnector(RelationshipConnector obj) {
        return visitConcept(obj);

    }

    @objid ("884f1042-af6f-4082-b077-d06bbc96700f")
    @Override
    public Object visitRepresentation(Representation obj) {
        return visitBusinessPassiveStructureElement(obj);

    }

    @objid ("a7d61079-d4c2-4174-ba02-1df21cb9a22f")
    @Override
    public Object visitRequirement(Requirement obj) {
        return visitMotivationElement(obj);

    }

    @objid ("1e582ddf-f788-4cfc-b7ea-90f1a2575ac2")
    @Override
    public Object visitResource(Resource obj) {
        return visitStructureElement(obj);

    }

    @objid ("38aa79ea-5ccc-453e-ba0d-be2b4e00345e")
    @Override
    public Object visitServing(Serving obj) {
        return visitDependencyRelationship(obj);

    }

    @objid ("67f2b788-96d1-414d-b5a7-af17d9ab1169")
    @Override
    public Object visitSpecialization(Specialization obj) {
        return visitOtherRelationship(obj);

    }

    @objid ("4de84199-9a69-44d7-9ca7-d4b4a7210db1")
    @Override
    public Object visitStakeholder(Stakeholder obj) {
        return visitMotivationElement(obj);

    }

    @objid ("21e5d137-5768-428a-bc2f-6fd8940b54c5")
    @Override
    public Object visitStrategyBehaviorElement(StrategyBehaviorElement obj) {
        return visitBehaviorElement(obj);

    }

    @objid ("639397f4-8d36-4fdf-8d46-a2ef097df6e6")
    @Override
    public Object visitStrategyFolder(StrategyFolder obj) {
        return visitFolder(obj);

    }

    @objid ("bf2a2d43-e30f-4063-9e51-eb282f12697f")
    @Override
    public Object visitStructuralRelationship(StructuralRelationship obj) {
        return visitRelationship(obj);

    }

    @objid ("b436052e-a7c3-47d5-8024-ada2dad74f5e")
    @Override
    public Object visitStructureElement(StructureElement obj) {
        return visitElement(obj);

    }

    @objid ("14573119-aaba-48d4-96b2-16a31c0230ff")
    @Override
    public Object visitSystemSoftware(SystemSoftware obj) {
        return visitNode(obj);

    }

    @objid ("e37b3b13-476c-4cf7-9694-66c78a07a58f")
    @Override
    public Object visitTechnologyActiveStructureElement(TechnologyActiveStructureElement obj) {
        return visitActiveStructureElement(obj);

    }

    @objid ("a18bef8d-c797-44f1-89c9-e98bc28a8306")
    @Override
    public Object visitTechnologyCollaboration(TechnologyCollaboration obj) {
        return visitTechnologyInternalActiveStructureElement(obj);

    }

    @objid ("83e5cc6c-c70b-474c-bbcb-c31fdd4fec7d")
    @Override
    public Object visitTechnologyEvent(TechnologyEvent obj) {
        return visitEvent(obj);

    }

    @objid ("5cf5d5f3-5707-4e32-9258-d614dfce2f2b")
    @Override
    public Object visitTechnologyFolder(TechnologyFolder obj) {
        return visitFolder(obj);

    }

    @objid ("0e2a2ead-a5a9-4152-80b5-9f2534cf6247")
    @Override
    public Object visitTechnologyFunction(TechnologyFunction obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("c61b4a27-0347-432e-83ae-64a5692c6554")
    @Override
    public Object visitTechnologyInteraction(TechnologyInteraction obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("83d42c86-e0aa-4468-b6e6-64d36fff4ae5")
    @Override
    public Object visitTechnologyInterface(TechnologyInterface obj) {
        return visitExternalActiveStructureElement(obj);

    }

    @objid ("277718ea-903f-4beb-8a07-c3f63806a916")
    @Override
    public Object visitTechnologyInternalActiveStructureElement(TechnologyInternalActiveStructureElement obj) {
        return visitTechnologyActiveStructureElement(obj);

    }

    @objid ("125ab4f9-67cb-401d-b164-f7a6ac3d8cc5")
    @Override
    public Object visitTechnologyInternalBehaviorElement(TechnologyInternalBehaviorElement obj) {
        return visitInternalBehaviorElement(obj);

    }

    @objid ("c748492e-a5a2-4773-a45e-e257e6bc49ee")
    @Override
    public Object visitTechnologyObject(TechnologyObject obj) {
        return visitPassiveStructureElement(obj);

    }

    @objid ("20761a03-b61d-4ed8-843c-c8566767f2a3")
    @Override
    public Object visitTechnologyProcess(TechnologyProcess obj) {
        return visitTechnologyInternalBehaviorElement(obj);

    }

    @objid ("bdf794d5-f818-420f-a682-4fd49cbcda40")
    @Override
    public Object visitTechnologyService(TechnologyService obj) {
        return visitExternalBehaviorElement(obj);

    }

    @objid ("65874c5f-bc6b-4ea9-b352-82df9e600586")
    @Override
    public Object visitTriggering(Triggering obj) {
        return visitDynamicRelationship(obj);

    }

    @objid ("a0bbf7a7-3db2-4a5d-9752-8857ba744e73")
    @Override
    public Object visitValue(Value obj) {
        return visitMotivationElement(obj);

    }

    @objid ("eb0ba73e-dce7-4d29-8c67-d6ae0939ef0a")
    @Override
    public Object visitValueStream(ValueStream obj) {
        return visitStrategyBehaviorElement(obj);

    }

    @objid ("ff48dba2-be33-4bf6-8160-c4b83b126673")
    @Override
    public Object visitViewPoint(ViewPoint obj) {
        return visitArchimateAbstractElement(obj);

    }

    @objid ("169564ee-cb8e-4084-8541-1a84722537e1")
    @Override
    public Object visitViewPointDiagram(ViewPointDiagram obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractDiagram(obj) : null;

    }

    @objid ("495fbb47-d341-4e17-94bc-922a8e3263c8")
    @Override
    public Object visitWorkPackage(WorkPackage obj) {
        return visitBehaviorElement(obj);

    }

}
