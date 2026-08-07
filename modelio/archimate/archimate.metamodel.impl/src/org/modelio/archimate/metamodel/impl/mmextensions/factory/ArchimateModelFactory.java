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
package org.modelio.archimate.metamodel.impl.mmextensions.factory;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
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
import org.modelio.archimate.metamodel.mmextensions.archimate.IArchimateModelFactory;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.metamodel.impl.mmextensions.infrastructure.factory.InfrastructureModelFactoryImpl;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.session.api.repository.IRepository;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MDependency;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("4864a207-f279-4c4b-a1af-2cc92cabbf69")
public class ArchimateModelFactory extends InfrastructureModelFactoryImpl implements IArchimateModelFactory {
    /**
     * The model element initializer used by the factory.
     */
    @objid ("ef0fe1cd-4e15-4aa5-ac94-e4959ec4a4bb")
    private final IArchimateElementInitializer elementInitializer;

    @objid ("6a45133d-4235-4098-b206-e6c8e5884c97")
    public ArchimateModelFactory(ICoreSession session) {
        super(session);

        this.elementInitializer = new ArchimateElementInitializer(this);

    }

    @objid ("82444950-68d5-4191-b017-f5774e468c3f")
    @Override
    public <T extends MObject> T createElement(java.lang.Class<T> metaclass) {
        T newElement = this.genericFactory.create(metaclass, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("194466a6-96e8-4647-a21f-48c40b7086ff")
    @Override
    public MObject createElement(String metaclassName) {
        MObject newElement = this.genericFactory.create(metaclassName, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("7b81022f-d844-4645-b12c-d298e8e706ec")
    @Override
    public MObject createElement(MClass metaclass) {
        MObject newElement = this.genericFactory.create(metaclass, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("67d7ef39-a24c-4e7b-a493-128ea2ae4502")
    @Override
    public MObject createElement(MClass metaclass, MObject owner, MDependency dependency) {
        MObject newElement = this.genericFactory.create(metaclass, owner, dependency);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("045a48a4-64c5-43a7-887f-fcc760b6988c")
    @Override
    public MObject createElement(String metaclassName, MObject owner, String dependencyName) {
        // TODO for all createElement generic methods, process errors (unknown
        // dep unknown metaclass, null objects ... )
        MObject newElement = this.genericFactory.create(metaclassName, owner, dependencyName);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5e2114e4-453b-47f7-8ffc-aabb7a0b8c44")
    @Override
    public <T extends MObject> T createElement(java.lang.Class<T> metaclass, MObject owner, String dependencyName) {
        T newElement = this.genericFactory.create(metaclass, owner, dependencyName);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("799c82cc-564b-4774-8bca-61f36001fb90")
    @Override
    public Grouping createGrouping() {
        Grouping newElement = this.genericFactory.create(Grouping.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("fc578d1a-02da-48cf-b4fc-c0ee9fa8294a")
    @Override
    public Location createLocation() {
        Location newElement = this.genericFactory.create(Location.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("4a82364d-17ad-4fac-99df-9b4b5a99ee67")
    @Override
    public BusinessFolder createBusinessFolder() {
        BusinessFolder newElement = this.genericFactory.create(BusinessFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("8e1b6854-67ed-4531-a574-37ed87c2bc33")
    @Override
    public StrategyFolder createStrategyFolder() {
        StrategyFolder newElement = this.genericFactory.create(StrategyFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("1bb5e985-690e-438b-ab9a-429054fa4436")
    @Override
    public MotivationFolder createMotivationFolder() {
        MotivationFolder newElement = this.genericFactory.create(MotivationFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("c815ffc4-7b55-477f-b7c2-86a8bc3ab825")
    @Override
    public ApplicationFolder createApplicationFolder() {
        ApplicationFolder newElement = this.genericFactory.create(ApplicationFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2e832007-53d1-4bdf-a401-e5ca4a065035")
    @Override
    public TechnologyFolder createTechnologyFolder() {
        TechnologyFolder newElement = this.genericFactory.create(TechnologyFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("127fe929-940c-4b09-a489-360a64b75782")
    @Override
    public PhysicalFolder createPhysicalFolder() {
        PhysicalFolder newElement = this.genericFactory.create(PhysicalFolder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("d36632db-a182-41a2-a10a-86de22c76ae8")
    @Override
    public ImplementationFolder createImplementationFolder() {
        ImplementationFolder newElement = this.genericFactory.create(ImplementationFolder.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("79428f8e-7f01-49ae-b766-d4a3913f03dc")
    @Override
    public ArchimateProject createArchimateProject(String name, IRepository repository) {
        ArchimateProject newElement = this.genericFactory.create(ArchimateProject.class, repository);
        newElement.setName(name);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("3cf10e94-5d06-4a14-831e-92b86882cec6")
    @Override
    public Model createModel() {
        Model newElement = this.genericFactory.create(Model.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("563839fe-b1fa-49b4-b71a-c91c3f6d8c44")
    @Override
    public ViewPoint createViewPoint() {
        ViewPoint newElement = this.genericFactory.create(ViewPoint.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("4c0bfa49-238b-411d-8740-5a59a6d40d1f")
    @Override
    public ArchimateView createArchimateView() {
        ArchimateView newElement = this.genericFactory.create(ArchimateView.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("95bc1c4a-962e-47a8-9c3f-60c69718d1b0")
    @Override
    public Stakeholder createStakeholder() {
        Stakeholder newElement = this.genericFactory.create(Stakeholder.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e59335e7-9ae0-476d-9052-7f14fdace40e")
    @Override
    public Meaning createMeaning() {
        Meaning newElement = this.genericFactory.create(Meaning.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("14198a3f-c68e-4541-892d-81dbe946f1a5")
    @Override
    public Value createValue() {
        Value newElement = this.genericFactory.create(Value.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("597f83c1-e6be-410c-b2e2-714a6d7ba695")
    @Override
    public Driver createDriver() {
        Driver newElement = this.genericFactory.create(Driver.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("4b96a713-161b-4981-8d13-a5453892a22a")
    @Override
    public Assessment createAssessment() {
        Assessment newElement = this.genericFactory.create(Assessment.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("c62d2fdc-2807-457b-9889-a858b7800a03")
    @Override
    public Goal createGoal() {
        Goal newElement = this.genericFactory.create(Goal.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("12088ac2-6d4b-4f4b-9b73-bcaceaa23fb9")
    @Override
    public Outcome createOutcome() {
        Outcome newElement = this.genericFactory.create(Outcome.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("6a76444b-375b-4aa2-8c94-b5f10b862da5")
    @Override
    public Principle createPrinciple() {
        Principle newElement = this.genericFactory.create(Principle.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("d06cab65-5bb5-483a-9952-dbe5f9e5facb")
    @Override
    public Requirement createRequirement() {
        Requirement newElement = this.genericFactory.create(Requirement.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2fcfe628-685a-4480-b36d-638ccd44e677")
    @Override
    public Constraint createConstraint() {
        Constraint newElement = this.genericFactory.create(Constraint.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e63b0cbc-62f3-4e96-a393-494e0bbfa28d")
    @Override
    public WorkPackage createWorkPackage() {
        WorkPackage newElement = this.genericFactory.create(WorkPackage.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5523fba2-47a1-414e-8721-d790b2f176f3")
    @Override
    public Deliverable createDeliverable() {
        Deliverable newElement = this.genericFactory.create(Deliverable.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("a518ef56-7103-4691-9afd-1457c45dca8d")
    @Override
    public ImplementationEvent createImplementationEvent() {
        ImplementationEvent newElement = this.genericFactory.create(ImplementationEvent.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("1515a5f2-1fd2-413f-81c8-48872bbf7569")
    @Override
    public Plateau createPlateau() {
        Plateau newElement = this.genericFactory.create(Plateau.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("17e98b7b-60f1-4b0a-ab31-ff9ef6c8d09d")
    @Override
    public Gap createGap() {
        Gap newElement = this.genericFactory.create(Gap.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2f4770a7-6abf-4006-81fc-dd35e6472a9b")
    @Override
    public BusinessProcess createBusinessProcess() {
        BusinessProcess newElement = this.genericFactory.create(BusinessProcess.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("f5122306-c111-4c8c-ac75-19fcb2963df4")
    @Override
    public BusinessFunction createBusinessFunction() {
        BusinessFunction newElement = this.genericFactory.create(BusinessFunction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2bfa713f-cca8-4775-8742-9ac3d27c3d83")
    @Override
    public BusinessInteraction createBusinessInteraction() {
        BusinessInteraction newElement = this.genericFactory.create(BusinessInteraction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("09f2d4d7-9e92-4810-9395-6f27ab222bd8")
    @Override
    public BusinessEvent createBusinessEvent() {
        BusinessEvent newElement = this.genericFactory.create(BusinessEvent.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("af9d4096-159c-4921-a80a-b2e12b7340c4")
    @Override
    public BusinessService createBusinessService() {
        BusinessService newElement = this.genericFactory.create(BusinessService.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5ffb37b6-0944-4226-8956-d3bc5bc65292")
    @Override
    public Product createProduct() {
        Product newElement = this.genericFactory.create(Product.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("d740ef12-5fcd-437c-9d37-16f7cea2a7f4")
    @Override
    public BusinessActor createBusinessActor() {
        BusinessActor newElement = this.genericFactory.create(BusinessActor.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("ccc852e6-54a1-4f58-82ee-6e4a64bf62e7")
    @Override
    public BusinessRole createBusinessRole() {
        BusinessRole newElement = this.genericFactory.create(BusinessRole.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("f21f2291-e528-43ea-b3f6-dd1b16057cb0")
    @Override
    public BusinessCollaboration createBusinessCollaboration() {
        BusinessCollaboration newElement = this.genericFactory.create(BusinessCollaboration.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("363c863d-6c3f-4ce8-add8-269b55ace290")
    @Override
    public BusinessInterface createBusinessInterface() {
        BusinessInterface newElement = this.genericFactory.create(BusinessInterface.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("6a2a340c-acb1-4b80-a5a0-a11e18c0fb61")
    @Override
    public BusinessObject createBusinessObject() {
        BusinessObject newElement = this.genericFactory.create(BusinessObject.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5b2d1b9e-a612-41f9-bf53-e61572f390ef")
    @Override
    public Contract createContract() {
        Contract newElement = this.genericFactory.create(Contract.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("9d77681e-22b2-4812-bb2b-1edfe6e42a6f")
    @Override
    public Representation createRepresentation() {
        Representation newElement = this.genericFactory.create(Representation.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("7719ee71-a869-48df-9cbb-5091e05842bd")
    @Override
    public ApplicationFunction createApplicationFunction() {
        ApplicationFunction newElement = this.genericFactory.create(ApplicationFunction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("269518b6-8ca0-42c0-8420-0160c71a349b")
    @Override
    public ApplicationInteraction createApplicationInteraction() {
        ApplicationInteraction newElement = this.genericFactory.create(ApplicationInteraction.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5efa0fed-9f80-46dd-9bdf-7cc021723163")
    @Override
    public ApplicationProcess createApplicationProcess() {
        ApplicationProcess newElement = this.genericFactory.create(ApplicationProcess.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("f815fc04-acf8-4f4f-a6fe-87d75b3c1fba")
    @Override
    public ApplicationEvent createApplicationEvent() {
        ApplicationEvent newElement = this.genericFactory.create(ApplicationEvent.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("87cfcbf4-78a8-4be9-8915-ac6ef39f979d")
    @Override
    public ApplicationService createApplicationService() {
        ApplicationService newElement = this.genericFactory.create(ApplicationService.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("bfdd4304-cc9a-4a63-949b-9d9eba02c3c5")
    @Override
    public ApplicationComponent createApplicationComponent() {
        ApplicationComponent newElement = this.genericFactory.create(ApplicationComponent.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("3094bad3-c484-4d87-b786-cff6aca826e8")
    @Override
    public ApplicationCollaboration createApplicationCollaboration() {
        ApplicationCollaboration newElement = this.genericFactory.create(ApplicationCollaboration.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("3e8657c6-4819-4273-92f4-37e8721923ba")
    @Override
    public ApplicationInterface createApplicationInterface() {
        ApplicationInterface newElement = this.genericFactory.create(ApplicationInterface.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("bd5a4faf-549b-41d3-b2ea-beb00dd3e997")
    @Override
    public DataObject createDataObject() {
        DataObject newElement = this.genericFactory.create(DataObject.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("6caa78ac-fe3d-424d-997d-6e608b20351d")
    @Override
    public TechnologyFunction createTechnologyFunction() {
        TechnologyFunction newElement = this.genericFactory.create(TechnologyFunction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("34ba32c6-e64d-4eb8-a142-a9f63dd4cb3a")
    @Override
    public TechnologyProcess createTechnologyProcess() {
        TechnologyProcess newElement = this.genericFactory.create(TechnologyProcess.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("f2e46eb5-27f3-4907-834f-633d9ac579f8")
    @Override
    public TechnologyInteraction createTechnologyInteraction() {
        TechnologyInteraction newElement = this.genericFactory.create(TechnologyInteraction.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("11656288-6262-4c93-a075-f06f5c0a729d")
    @Override
    public TechnologyEvent createTechnologyEvent() {
        TechnologyEvent newElement = this.genericFactory.create(TechnologyEvent.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("03ad0bb6-093c-43e9-8cbd-8d844d2e33a2")
    @Override
    public TechnologyService createTechnologyService() {
        TechnologyService newElement = this.genericFactory.create(TechnologyService.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e4044de6-ea8a-46c1-a8a9-abb4828fb7ff")
    @Override
    public CommunicationNetwork createCommunicationNetwork() {
        CommunicationNetwork newElement = this.genericFactory.create(CommunicationNetwork.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e9492c5c-1b2a-4edc-93a6-4a88e30e9773")
    @Override
    public Device createDevice() {
        Device newElement = this.genericFactory.create(Device.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("b9bbd853-83bc-4546-a5b9-9b11dc680268")
    @Override
    public Node createNode() {
        Node newElement = this.genericFactory.create(Node.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("3b24527a-c3ce-4f5d-adce-264b2af28866")
    @Override
    public Path createPath() {
        Path newElement = this.genericFactory.create(Path.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("81d6c71c-a800-4032-9ccb-2f51daad8141")
    @Override
    public SystemSoftware createSystemSoftware() {
        SystemSoftware newElement = this.genericFactory.create(SystemSoftware.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("4721be9e-54d3-4d1c-a6e0-e7eaab9e03ee")
    @Override
    public TechnologyCollaboration createTechnologyCollaboration() {
        TechnologyCollaboration newElement = this.genericFactory.create(TechnologyCollaboration.class,
                this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e3c80660-6a15-40a8-9f6b-2bae4489563f")
    @Override
    public TechnologyInterface createTechnologyInterface() {
        TechnologyInterface newElement = this.genericFactory.create(TechnologyInterface.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e47eb547-5eeb-47da-a0aa-f2eff7ddbec4")
    @Override
    public Artifact createArtifact() {
        Artifact newElement = this.genericFactory.create(Artifact.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2cc5720f-388d-4839-adc9-69c96ef46f8f")
    @Override
    public DistributionNetwork createDistributionNetwork() {
        DistributionNetwork newElement = this.genericFactory.create(DistributionNetwork.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("8b609d87-b083-49f5-a4ec-f62a3fff2f43")
    @Override
    public Equipment createEquipment() {
        Equipment newElement = this.genericFactory.create(Equipment.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("eebdb6f3-79f7-45a9-b358-d96cae5fd601")
    @Override
    public Facility createFacility() {
        Facility newElement = this.genericFactory.create(Facility.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("29c5ebba-cff3-45c6-b866-d1208804d0c8")
    @Override
    public Material createMaterial() {
        Material newElement = this.genericFactory.create(Material.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("e5da1f3d-03f2-4179-bb44-e62c99a3da8e")
    @Override
    public Resource createResource() {
        Resource newElement = this.genericFactory.create(Resource.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("d407b84d-17f0-4a68-8d48-c3b548b3d87a")
    @Override
    public Capability createCapability() {
        Capability newElement = this.genericFactory.create(Capability.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("a53af99c-892b-4e20-8a61-44b985b1fb2e")
    @Override
    public CourseOfAction createCourseOfAction() {
        CourseOfAction newElement = this.genericFactory.create(CourseOfAction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("10b88491-2df3-403e-bd31-5dadeb220ed2")
    @Override
    public Aggregation createAggregation() {
        Aggregation newElement = this.genericFactory.create(Aggregation.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("115c6c7e-323e-4295-910f-20977e3c6bd9")
    @Override
    public Assignment createAssignment() {
        Assignment newElement = this.genericFactory.create(Assignment.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("7c81c817-ad8c-48a7-9144-a28bdefb2940")
    @Override
    public Composition createComposition() {
        Composition newElement = this.genericFactory.create(Composition.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("12e84306-7ce5-432d-b01c-370d3c3dfb5a")
    @Override
    public Realization createRealization() {
        Realization newElement = this.genericFactory.create(Realization.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("9a78fb00-1d66-420e-aa8c-f55afc81c4bf")
    @Override
    public Access createAccess() {
        Access newElement = this.genericFactory.create(Access.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("a2d627c7-55e3-4cf2-92f0-2dc3108c38c2")
    @Override
    public Influence createInfluence() {
        Influence newElement = this.genericFactory.create(Influence.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("6cf1e38d-9235-4913-a718-45e05a9824a3")
    @Override
    public Serving createServing() {
        Serving newElement = this.genericFactory.create(Serving.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("b78725ed-b602-4311-95d2-3486947bcc95")
    @Override
    public Flow createFlow() {
        Flow newElement = this.genericFactory.create(Flow.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("2af2251a-8b25-4e16-920a-330f25f75832")
    @Override
    public Triggering createTriggering() {
        Triggering newElement = this.genericFactory.create(Triggering.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("c57e2d9b-196c-4155-8cce-9aa7f303c214")
    @Override
    public Association createAssociation() {
        Association newElement = this.genericFactory.create(Association.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("c64e6516-85b3-4a9c-92ec-26b95ffb6ef3")
    @Override
    public Specialization createSpecialization() {
        Specialization newElement = this.genericFactory.create(Specialization.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("5466a7bc-0bf4-44f0-bc67-cf3308bd8d2b")
    @Override
    public OrJunction createOrJunction() {
        OrJunction newElement = this.genericFactory.create(OrJunction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("af650d27-e06f-4695-bf7f-a2d760bf179a")
    @Override
    public AndJunction createAndJunction() {
        AndJunction newElement = this.genericFactory.create(AndJunction.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

    @objid ("8d32a202-3e65-4841-9205-ef2d6784be45")
    @Override
    public ViewPointDiagram createViewPointDiagram() {
        ViewPointDiagram newElement = this.genericFactory.create(ViewPointDiagram.class, this.scratchRepository);
        this.elementInitializer.initialize(newElement);
        return newElement;
    }

}
