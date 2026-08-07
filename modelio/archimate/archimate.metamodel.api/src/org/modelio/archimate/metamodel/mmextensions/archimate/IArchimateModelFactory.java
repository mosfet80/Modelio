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
package org.modelio.archimate.metamodel.mmextensions.archimate;

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
import org.modelio.metamodel.mmextensions.infrastructure.IInfrastructureModelFactory;
import org.modelio.vcore.session.api.repository.IRepository;

/**
 * Factory that creates Archimate model elements.
 * <p>
 * New UML model elements can easily be created using <i>createXxxxx()</i> methods where Xxxxx is the name of the metaclass for
 * which an instance has to be created. At least one method <i>createXxxxx()</i> exists for UML model Element. i.e.:
 * {@linkplain #createClass()}. This method only create an instance of the metaclass. The instance will have to be attached to the
 * model and eventually named to be valid for the current transaction.
 * </p>
 */
@objid ("47b6b61c-f73a-40ec-8d5f-7b18e787771a")
public interface IArchimateModelFactory extends IInfrastructureModelFactory {
    /**
     *
     * @return a new {@link Grouping}.
     */
    @objid ("39292219-ff7d-4f78-b8a3-a9579dfd3c43")
    Grouping createGrouping();

    /**
     *
     * @return a new {@link Location}.
     */
    @objid ("fb402901-d6da-4ffb-bbcd-c4deaad89383")
    Location createLocation();

    /**
     *
     * @return a new {@link BusinessFolder}.
     */
    @objid ("8dcaecb4-4f86-4f00-a342-dd164f287407")
    BusinessFolder createBusinessFolder();

    /**
     *
     * @return a new {@link StrategyFolder}.
     */
    @objid ("bd5df59e-6631-444e-8d47-cf563d0a1def")
    StrategyFolder createStrategyFolder();

    /**
     *
     * @return a new {@link MotivationFolder}.
     */
    @objid ("f899f434-9855-4450-aca3-790d182dd780")
    MotivationFolder createMotivationFolder();

    /**
     *
     * @return a new {@link ApplicationFolder}.
     */
    @objid ("fb685cd0-cbec-4ae3-90a4-d5809c28954e")
    ApplicationFolder createApplicationFolder();

    /**
     *
     * @return a new {@link TechnologyFolder}.
     */
    @objid ("71a2c893-376e-4e0e-960c-d03dcc25750b")
    TechnologyFolder createTechnologyFolder();

    /**
     *
     * @return a new {@link PhysicalFolder}.
     */
    @objid ("da345d1d-a593-49f4-b487-b23c9622e39e")
    PhysicalFolder createPhysicalFolder();

    /**
     *
     * @return a new {@link ImplementationFolder}.
     */
    @objid ("4f24a596-bb22-4b2a-9917-977f59d34411")
    ImplementationFolder createImplementationFolder();

    /**
     *
     * @param name the project's name.
     * @param repository the repository where the model object will be stored.
     * @return a new {@link ArchimateProject}.
     */
    @objid ("4b12854b-84eb-418a-985b-bcaee87d6fce")
    ArchimateProject createArchimateProject(String name, IRepository repository);

    /**
     *
     * @return a new {@link Model}.
     */
    @objid ("8c133a7b-e66b-48f2-af09-133c37c73a64")
    Model createModel();

    /**
     *
     * @return a new {@link ViewPoint}.
     */
    @objid ("c5e6af4a-53e8-4bda-a9ec-d0f5e2b4c77d")
    ViewPoint createViewPoint();

    /**
     *
     * @return a new {@link ArchimateView}.
     */
    @objid ("76638bed-1024-43f5-a92f-e9c468ef83b6")
    ArchimateView createArchimateView();

    /**
     *
     * @return a new {@link Stakeholder}.
     */
    @objid ("bd7e6655-3f19-43e2-91d8-62fbbbf66fec")
    Stakeholder createStakeholder();

    /**
     *
     * @return a new {@link Meaning}.
     */
    @objid ("6b0a70aa-6520-4092-9115-d9d807d6713d")
    Meaning createMeaning();

    /**
     *
     * @return a new {@link Value}.
     */
    @objid ("8db77acb-7718-4a4d-b003-7b037c961cd8")
    Value createValue();

    /**
     *
     * @return a new {@link Driver}.
     */
    @objid ("304fa766-2eed-4800-88c1-18c030159470")
    Driver createDriver();

    /**
     *
     * @return a new {@link Assessment}.
     */
    @objid ("3854e9a5-153f-4fec-ad17-24fb0067dca4")
    Assessment createAssessment();

    /**
     *
     * @return a new {@link Goal}.
     */
    @objid ("e666c4ec-3bbb-4e3b-b351-fb22a6acc95d")
    Goal createGoal();

    /**
     *
     * @return a new {@link Outcome}.
     */
    @objid ("c4a9dbef-93dc-4481-b849-5704a55e68b1")
    Outcome createOutcome();

    /**
     *
     * @return a new {@link Principle}.
     */
    @objid ("14340f83-d1a6-4416-bb31-d8360ea7f499")
    Principle createPrinciple();

    /**
     *
     * @return a new {@link Requirement}.
     */
    @objid ("06c874f8-6713-4fd5-8a61-f65e12bf9018")
    Requirement createRequirement();

    /**
     *
     * @return a new {@link Constraint}.
     */
    @objid ("1f54e8bd-836e-48aa-8213-a85db9ba5845")
    Constraint createConstraint();

    /**
     *
     * @return a new {@link WorkPackage}.
     */
    @objid ("1829348c-2345-40e1-8c3c-7373ebf54456")
    WorkPackage createWorkPackage();

    /**
     *
     * @return a new {@link Deliverable}.
     */
    @objid ("b93cd9a4-8845-48cc-945d-b4dd051f764d")
    Deliverable createDeliverable();

    /**
     *
     * @return a new {@link ImplementationEvent}.
     */
    @objid ("088333d3-9b15-4d6c-8630-c86107af37c7")
    ImplementationEvent createImplementationEvent();

    /**
     *
     * @return a new {@link Plateau}.
     */
    @objid ("fab30340-a164-4ace-b92e-f9d5097edc0b")
    Plateau createPlateau();

    /**
     *
     * @return a new {@link Gap}.
     */
    @objid ("244fa7b5-58fb-4b19-8a1a-87aea648cb9d")
    Gap createGap();

    /**
     *
     * @return a new {@link BusinessProcess}.
     */
    @objid ("59793802-ec28-473b-b76a-0775708960f2")
    BusinessProcess createBusinessProcess();

    /**
     *
     * @return a new {@link BusinessFunction}.
     */
    @objid ("cecefdba-8e08-4aeb-ab0b-f1ffd628dd9f")
    BusinessFunction createBusinessFunction();

    /**
     *
     * @return a new {@link BusinessInteraction}.
     */
    @objid ("946380fb-c6b3-43c7-ac47-cca6c7bd517e")
    BusinessInteraction createBusinessInteraction();

    /**
     *
     * @return a new {@link BusinessEvent}.
     */
    @objid ("328be567-7547-4deb-a628-9a44d8e03fa3")
    BusinessEvent createBusinessEvent();

    /**
     *
     * @return a new {@link BusinessService}.
     */
    @objid ("aece592c-d458-4873-9dfd-db23f5fa99e6")
    BusinessService createBusinessService();

    /**
     *
     * @return a new {@link Product}.
     */
    @objid ("a4914820-dbda-488f-89e3-ea6e397fb18e")
    Product createProduct();

    /**
     *
     * @return a new {@link BusinessActor}.
     */
    @objid ("5a1db24f-42db-48c9-8b97-24fa03450324")
    BusinessActor createBusinessActor();

    /**
     *
     * @return a new {@link BusinessRole}.
     */
    @objid ("5bbb5fdc-8659-4d1a-9d46-2ac82edd5632")
    BusinessRole createBusinessRole();

    /**
     *
     * @return a new {@link BusinessCollaboration}.
     */
    @objid ("7b5388c1-92b5-4570-858b-bbef37bfd2df")
    BusinessCollaboration createBusinessCollaboration();

    /**
     *
     * @return a new {@link BusinessInterface}.
     */
    @objid ("e84c9a55-5e22-4746-a950-423cec4fcfce")
    BusinessInterface createBusinessInterface();

    /**
     *
     * @return a new {@link BusinessObject}.
     */
    @objid ("e8661a17-8355-458a-b4f1-eef390aa80b2")
    BusinessObject createBusinessObject();

    /**
     *
     * @return a new {@link Contract}.
     */
    @objid ("ba682925-4af3-430f-91d1-bf03accace21")
    Contract createContract();

    /**
     *
     * @return a new {@link Representation}.
     */
    @objid ("c233e5c3-7ff4-4bc5-a9e1-5f58d9200b7d")
    Representation createRepresentation();

    /**
     *
     * @return a new {@link ApplicationFunction}.
     */
    @objid ("2ea936b8-2879-4645-962b-81f34c2fae7b")
    ApplicationFunction createApplicationFunction();

    /**
     *
     * @return a new {@link ApplicationInteraction}.
     */
    @objid ("3f77bed7-13a2-4c7b-b839-455310e60f39")
    ApplicationInteraction createApplicationInteraction();

    /**
     *
     * @return a new {@link ApplicationProcess}.
     */
    @objid ("d237f5d2-5204-4a32-bdb2-8b0a388e21ca")
    ApplicationProcess createApplicationProcess();

    /**
     *
     * @return a new {@link ApplicationEvent}.
     */
    @objid ("38207eb2-ff64-4eff-af70-ebf45dabaac3")
    ApplicationEvent createApplicationEvent();

    /**
     *
     * @return a new {@link ApplicationService}.
     */
    @objid ("a82e6a38-c1ae-4c0f-87e7-160b0acb8bda")
    ApplicationService createApplicationService();

    /**
     *
     * @return a new {@link ApplicationComponent}.
     */
    @objid ("a518c1cf-68f3-4473-a698-e3ac187e9b7f")
    ApplicationComponent createApplicationComponent();

    /**
     *
     * @return a new {@link ApplicationCollaboration}.
     */
    @objid ("3b919348-eafe-4f3f-af49-4bd925e84e2e")
    ApplicationCollaboration createApplicationCollaboration();

    /**
     *
     * @return a new {@link ApplicationInterface}.
     */
    @objid ("bf07ca70-6b76-462d-baab-6174b367d503")
    ApplicationInterface createApplicationInterface();

    /**
     *
     * @return a new {@link DataObject}.
     */
    @objid ("4610a7f9-ce44-4dea-bf52-27fed72b779b")
    DataObject createDataObject();

    /**
     *
     * @return a new {@link TechnologyFunction}.
     */
    @objid ("61445bdb-c3a3-43ab-97c0-0de7c11b7223")
    TechnologyFunction createTechnologyFunction();

    /**
     *
     * @return a new {@link TechnologyProcess}.
     */
    @objid ("697a5e3a-38b5-4ae4-b924-74543f2799d4")
    TechnologyProcess createTechnologyProcess();

    /**
     *
     * @return a new {@link TechnologyInteraction}.
     */
    @objid ("2949c312-facc-426f-9ccb-fa582ca1f303")
    TechnologyInteraction createTechnologyInteraction();

    /**
     *
     * @return a new {@link TechnologyEvent}.
     */
    @objid ("89c7997c-0388-48fb-af9b-26e9f78c7bf6")
    TechnologyEvent createTechnologyEvent();

    /**
     *
     * @return a new {@link TechnologyService}.
     */
    @objid ("b2f824da-68c1-4d52-aa0f-0cc8667bd187")
    TechnologyService createTechnologyService();

    /**
     *
     * @return a new {@link CommunicationNetwork}.
     */
    @objid ("67a75915-6ca0-4035-b7af-1a0455cc1f36")
    CommunicationNetwork createCommunicationNetwork();

    /**
     *
     * @return a new {@link Device}.
     */
    @objid ("7736f845-afc5-4021-a49e-818ef28bad17")
    Device createDevice();

    /**
     *
     * @return a new {@link Node}.
     */
    @objid ("5972c07a-d755-4a53-a326-3878c0153481")
    Node createNode();

    /**
     *
     * @return a new {@link Path}.
     */
    @objid ("4bd0a07d-b655-46e4-85fa-6e85eecc0e69")
    Path createPath();

    /**
     *
     * @return a new {@link SystemSoftware}.
     */
    @objid ("560506ed-523a-40c2-acf8-3354416e7c0c")
    SystemSoftware createSystemSoftware();

    /**
     *
     * @return a new {@link TechnologyCollaboration}.
     */
    @objid ("41bc4d7e-5c36-4451-b08c-6b5504e293db")
    TechnologyCollaboration createTechnologyCollaboration();

    /**
     *
     * @return a new {@link TechnologyInterface}.
     */
    @objid ("17f8edba-55bd-4724-97dd-c0adcd20acfa")
    TechnologyInterface createTechnologyInterface();

    /**
     *
     * @return a new {@link Artifact}.
     */
    @objid ("4275b507-6370-4fc5-88f5-e506a5f941d1")
    Artifact createArtifact();

    /**
     *
     * @return a new {@link DistributionNetwork}.
     */
    @objid ("145388f4-3f52-4211-ba64-51c42dd19f7b")
    DistributionNetwork createDistributionNetwork();

    /**
     *
     * @return a new {@link Equipment}.
     */
    @objid ("9b83e961-e48e-4093-8a81-2bcbfd7b68db")
    Equipment createEquipment();

    /**
     *
     * @return a new {@link Facility}.
     */
    @objid ("32302c32-a3ee-4c9b-b570-b18dce880075")
    Facility createFacility();

    /**
     *
     * @return a new {@link Material}.
     */
    @objid ("72f7af2f-2745-4a3e-aacc-072453c1dea9")
    Material createMaterial();

    /**
     *
     * @return a new {@link Resource}.
     */
    @objid ("924837bb-f185-414e-bc3c-6b53d147b54f")
    Resource createResource();

    /**
     *
     * @return a new {@link Capability}.
     */
    @objid ("643f7359-add0-4ec7-9aef-fa80f24f9f83")
    Capability createCapability();

    /**
     *
     * @return a new {@link CourseOfAction}.
     */
    @objid ("61024795-52fe-468b-a8dc-f27957b36df3")
    CourseOfAction createCourseOfAction();

    /**
     *
     * @return a new {@link Aggregation}.
     */
    @objid ("79162cc1-9bf9-4bfe-8f76-4f20b7ab12d0")
    Aggregation createAggregation();

    /**
     *
     * @return a new {@link Assignment}.
     */
    @objid ("3158a058-756d-48b1-afea-d946d4715a48")
    Assignment createAssignment();

    /**
     *
     * @return a new {@link Composition}.
     */
    @objid ("62bc8a8f-1b6d-49ae-8592-96c65ec32411")
    Composition createComposition();

    /**
     *
     * @return a new {@link Realization}.
     */
    @objid ("5d612e6a-a81d-4b3e-a241-975d1ae7a9ae")
    Realization createRealization();

    /**
     *
     * @return a new {@link Access}.
     */
    @objid ("ec057135-6992-4f8a-9f2d-e83e98692949")
    Access createAccess();

    /**
     *
     * @return a new {@link Influence}.
     */
    @objid ("8a337ca8-fc55-4a96-8dd3-4e8d79dd6acc")
    Influence createInfluence();

    /**
     *
     * @return a new {@link Serving}.
     */
    @objid ("657beadb-ce21-4207-97a1-e11a8a8c66af")
    Serving createServing();

    /**
     *
     * @return a new {@link Flow}.
     */
    @objid ("eabb08cf-ea9e-47d3-a9d6-93acd97a4d5c")
    Flow createFlow();

    /**
     *
     * @return a new {@link Triggering}.
     */
    @objid ("106185c1-6bb4-4e4b-b583-1495b5251458")
    Triggering createTriggering();

    /**
     *
     * @return a new {@link Association}.
     */
    @objid ("4087a2da-196d-4a08-a31a-b75f40ef921b")
    Association createAssociation();

    /**
     *
     * @return a new {@link Specialization}.
     */
    @objid ("abe8f5f2-126f-401d-bf6a-19543c3386e0")
    Specialization createSpecialization();

    /**
     *
     * @return a new {@link OrJunction}.
     */
    @objid ("9e755f34-292f-421c-9b24-840a3c397d3c")
    OrJunction createOrJunction();

    /**
     *
     * @return a new {@link AndJunction}.
     */
    @objid ("3c2d25f5-9f9d-4e19-9e9b-38801ee6d7bd")
    AndJunction createAndJunction();

    @objid ("4fc36f0c-ff48-4b4e-b202-3ba53b632c63")
    ViewPointDiagram createViewPointDiagram();

}
