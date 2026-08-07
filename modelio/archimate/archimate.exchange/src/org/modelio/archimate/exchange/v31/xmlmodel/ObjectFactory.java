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
//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source.
// Généré le : 2019.08.22 à 10:16:32 AM CEST
//
package org.modelio.archimate.exchange.v31.xmlmodel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.modelio.archimate.exchange.v31.xmlmodel package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@objid ("1c48524c-4301-4983-ba96-844a4f3193b2")
@XmlRegistry
public class ObjectFactory {
    @objid ("68f3acde-64ca-4cb0-807d-3867f2866233")
    private static final QName _Model_QNAME = new QName("http://www.opengroup.org/xsd/archimate/3.0/", "model");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.modelio.archimate.exchange.v31.xmlmodel
     */
    @objid ("298fc291-9bdb-4727-a36b-c7c4a2818f0c")
    public ObjectFactory() {

    }

    /**
     * Create an instance of {@link ModelType }
     */
    @objid ("0fa94c4b-6d30-4044-9c47-47a31cf1a008")
    public ModelType createModelType() {
        return new ModelType();
    }

    /**
     * Create an instance of {@link TechnologyProcess }
     */
    @objid ("23e59405-e59e-4403-9ea0-e8e0bd7f68bd")
    public TechnologyProcess createTechnologyProcess() {
        return new TechnologyProcess();
    }

    /**
     * Create an instance of {@link PropertyDefinitionType }
     */
    @objid ("208f5cd7-f2cb-42e7-8a67-6d34eb0c3aaf")
    public PropertyDefinitionType createPropertyDefinitionType() {
        return new PropertyDefinitionType();
    }

    /**
     * Create an instance of {@link Node }
     */
    @objid ("80fc3fe8-bd06-41ce-9a34-a23d12e50c16")
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link Access }
     */
    @objid ("c8f794cd-ae6e-43e4-88ac-8c3cf1d103c0")
    public Access createAccess() {
        return new Access();
    }

    /**
     * Create an instance of {@link Product }
     */
    @objid ("dee2913f-57ff-4607-ad7f-c98127c6250f")
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link BusinessObject }
     */
    @objid ("30202463-8f18-47b3-82e4-f7ed0289d5c6")
    public BusinessObject createBusinessObject() {
        return new BusinessObject();
    }

    /**
     * Create an instance of {@link ReferenceType }
     */
    @objid ("23aa8c01-da93-4dfd-928a-0a63a06235a0")
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link BusinessCollaboration }
     */
    @objid ("b1934a31-9c4b-4d52-88f5-b0684ea8bcb4")
    public BusinessCollaboration createBusinessCollaboration() {
        return new BusinessCollaboration();
    }

    /**
     * Create an instance of {@link Assignment }
     */
    @objid ("e37dcbc5-64ac-40db-9a00-c4b3e926e2fc")
    public Assignment createAssignment() {
        return new Assignment();
    }

    /**
     * Create an instance of {@link Goal }
     */
    @objid ("db9016a2-df88-4545-9b4c-df3c65777f45")
    public Goal createGoal() {
        return new Goal();
    }

    /**
     * Create an instance of {@link ViewsType }
     */
    @objid ("a4d5f4dd-842d-4f87-8b2d-71a84e43ad03")
    public ViewsType createViewsType() {
        return new ViewsType();
    }

    /**
     * Create an instance of {@link ConcernType }
     */
    @objid ("f75f56ce-4c9e-479e-86e1-ddc4e57674e1")
    public ConcernType createConcernType() {
        return new ConcernType();
    }

    /**
     * Create an instance of {@link ImplementationEvent }
     */
    @objid ("2b4d2579-bfde-46c1-b367-bd33eb3e1b04")
    public ImplementationEvent createImplementationEvent() {
        return new ImplementationEvent();
    }

    /**
     * Create an instance of {@link StakeholderType }
     */
    @objid ("7ceb1fcd-6277-442a-a0ea-0dd56e4efff8")
    public StakeholderType createStakeholderType() {
        return new StakeholderType();
    }

    /**
     * Create an instance of {@link AndJunction }
     */
    @objid ("fe53d76b-1819-446a-90cf-392eee5231d3")
    public AndJunction createAndJunction() {
        return new AndJunction();
    }

    /**
     * Create an instance of {@link DiagramsType }
     */
    @objid ("dd77ec9f-3dbf-4137-bbe6-489aabeb256c")
    public DiagramsType createDiagramsType() {
        return new DiagramsType();
    }

    /**
     * Create an instance of {@link Capability }
     */
    @objid ("90c484b3-ad45-4fc8-8126-f808e55b741f")
    public Capability createCapability() {
        return new Capability();
    }

    /**
     * Create an instance of {@link BusinessEvent }
     */
    @objid ("3a3c3576-61a8-40f6-8e0c-0de8727d0a67")
    public BusinessEvent createBusinessEvent() {
        return new BusinessEvent();
    }

    /**
     * Create an instance of {@link DistributionNetwork }
     */
    @objid ("9e82a3df-7e90-4ec8-a414-b5bf2988e4c6")
    public DistributionNetwork createDistributionNetwork() {
        return new DistributionNetwork();
    }

    /**
     * Create an instance of {@link ApplicationFunction }
     */
    @objid ("37bc62ed-4db4-4e0f-8c8e-7d65ed919025")
    public ApplicationFunction createApplicationFunction() {
        return new ApplicationFunction();
    }

    /**
     * Create an instance of {@link TechnologyInterface }
     */
    @objid ("6715042d-83ed-4ca1-a725-82b369645ad2")
    public TechnologyInterface createTechnologyInterface() {
        return new TechnologyInterface();
    }

    /**
     * Create an instance of {@link ApplicationEvent }
     */
    @objid ("edb67873-416e-4942-8064-3908a8d972a4")
    public ApplicationEvent createApplicationEvent() {
        return new ApplicationEvent();
    }

    /**
     * Create an instance of {@link Grouping }
     */
    @objid ("f6592c0c-fe80-4b56-aa54-dfab6332be90")
    public Grouping createGrouping() {
        return new Grouping();
    }

    /**
     * Create an instance of {@link Principle }
     */
    @objid ("fee5f91d-ab04-4598-bba2-00e43236bd5b")
    public Principle createPrinciple() {
        return new Principle();
    }

    /**
     * Create an instance of {@link AllowedRelationshipTypeType }
     */
    @objid ("3936f2a6-85a2-403f-ad20-9d2a57a25591")
    public AllowedRelationshipTypeType createAllowedRelationshipTypeType() {
        return new AllowedRelationshipTypeType();
    }

    /**
     * Create an instance of {@link RelationshipsType }
     */
    @objid ("58e49e16-6a5e-42dd-84ba-9c98e9c459b7")
    public RelationshipsType createRelationshipsType() {
        return new RelationshipsType();
    }

    /**
     * Create an instance of {@link Line }
     */
    @objid ("385ee03d-c571-49fc-8d55-04c926086d33")
    public Line createLine() {
        return new Line();
    }

    /**
     * Create an instance of {@link Requirement }
     */
    @objid ("6470e2e5-d369-4029-86b5-d05d386a30ff")
    public Requirement createRequirement() {
        return new Requirement();
    }

    /**
     * Create an instance of {@link Influence }
     */
    @objid ("57b32f22-adea-4048-a0e5-f2db26bda65f")
    public Influence createInfluence() {
        return new Influence();
    }

    /**
     * Create an instance of {@link Contract }
     */
    @objid ("fabd1a44-2fa8-422a-9b3a-f48c5bfd5cd6")
    public Contract createContract() {
        return new Contract();
    }

    /**
     * Create an instance of {@link ApplicationService }
     */
    @objid ("314f7f09-6248-40c1-858f-938483c01ad5")
    public ApplicationService createApplicationService() {
        return new ApplicationService();
    }

    /**
     * Create an instance of {@link Deliverable }
     */
    @objid ("89932712-6e3f-4839-b763-3403b101e9b5")
    public Deliverable createDeliverable() {
        return new Deliverable();
    }

    /**
     * Create an instance of {@link CommunicationNetwork }
     */
    @objid ("8368b54c-ddd3-447b-8301-82ddd31df165")
    public CommunicationNetwork createCommunicationNetwork() {
        return new CommunicationNetwork();
    }

    /**
     * Create an instance of {@link ViewpointType }
     */
    @objid ("cd62d55b-1716-4fcb-b192-0690dec11129")
    public ViewpointType createViewpointType() {
        return new ViewpointType();
    }

    /**
     * Create an instance of {@link TechnologyCollaboration }
     */
    @objid ("4e7e4364-7d50-42ac-be9c-5825eda38dfa")
    public TechnologyCollaboration createTechnologyCollaboration() {
        return new TechnologyCollaboration();
    }

    /**
     * Create an instance of {@link ApplicationCollaboration }
     */
    @objid ("1c3681b1-54ba-4528-9497-009969d09117")
    public ApplicationCollaboration createApplicationCollaboration() {
        return new ApplicationCollaboration();
    }

    /**
     * Create an instance of {@link SchemaInfoType }
     */
    @objid ("0a1df78b-424b-402e-943e-150c10aaf8b8")
    public SchemaInfoType createSchemaInfoType() {
        return new SchemaInfoType();
    }

    /**
     * Create an instance of {@link Aggregation }
     */
    @objid ("2483f513-1bab-4426-ac23-3c49a911c712")
    public Aggregation createAggregation() {
        return new Aggregation();
    }

    /**
     * Create an instance of {@link PropertiesType }
     */
    @objid ("d2a313dc-9e3f-4084-9330-41d28ecae53c")
    public PropertiesType createPropertiesType() {
        return new PropertiesType();
    }

    /**
     * Create an instance of {@link Specialization }
     */
    @objid ("7dac6d19-ce02-433f-a7af-3d21b7d65454")
    public Specialization createSpecialization() {
        return new Specialization();
    }

    /**
     * Create an instance of {@link Association }
     */
    @objid ("66416a03-d47f-4134-97ad-c1a39fb5658c")
    public Association createAssociation() {
        return new Association();
    }

    /**
     * Create an instance of {@link ElementsType }
     */
    @objid ("75b5d146-5ac7-47cd-9365-5b7480ef2661")
    public ElementsType createElementsType() {
        return new ElementsType();
    }

    /**
     * Create an instance of {@link Triggering }
     */
    @objid ("a3bb1e96-d815-411a-bf9f-3aed33f3a1f3")
    public Triggering createTriggering() {
        return new Triggering();
    }

    /**
     * Create an instance of {@link Path }
     */
    @objid ("c24cc638-db53-4117-988a-4a5773bdf82b")
    public Path createPath() {
        return new Path();
    }

    /**
     * Create an instance of {@link Plateau }
     */
    @objid ("ef120b72-61b6-4330-84b3-36d84090c49a")
    public Plateau createPlateau() {
        return new Plateau();
    }

    /**
     * Create an instance of {@link ApplicationComponent }
     */
    @objid ("236d45e4-bd9d-42b3-baa8-14652dbe7924")
    public ApplicationComponent createApplicationComponent() {
        return new ApplicationComponent();
    }

    /**
     * Create an instance of {@link StyleType }
     */
    @objid ("3fe1c439-6ef9-450e-8a2a-8a9ace90bf37")
    public StyleType createStyleType() {
        return new StyleType();
    }

    /**
     * Create an instance of {@link TechnologyInteraction }
     */
    @objid ("8e583e23-45fe-47fd-92f4-68c20e256c94")
    public TechnologyInteraction createTechnologyInteraction() {
        return new TechnologyInteraction();
    }

    /**
     * Create an instance of {@link ViewpointsType }
     */
    @objid ("7e18ad9e-ea6f-4be2-b8d6-7285b554ab64")
    public ViewpointsType createViewpointsType() {
        return new ViewpointsType();
    }

    /**
     * Create an instance of {@link Artifact }
     */
    @objid ("e83cd8e6-db63-4a52-90fe-19b8774a3b6d")
    public Artifact createArtifact() {
        return new Artifact();
    }

    /**
     * Create an instance of {@link BusinessFunction }
     */
    @objid ("34d0ff6b-40d8-4252-99c2-9fb22b47f5e6")
    public BusinessFunction createBusinessFunction() {
        return new BusinessFunction();
    }

    /**
     * Create an instance of {@link Flow }
     */
    @objid ("ad9d36be-c161-4272-bd1f-2254537b29b3")
    public Flow createFlow() {
        return new Flow();
    }

    /**
     * Create an instance of {@link Diagram }
     */
    @objid ("786439e4-8c9a-4828-b2fe-722b3558a406")
    public Diagram createDiagram() {
        return new Diagram();
    }

    /**
     * Create an instance of {@link Outcome }
     */
    @objid ("83b699bb-4d5e-4b52-8398-dcba33560039")
    public Outcome createOutcome() {
        return new Outcome();
    }

    /**
     * Create an instance of {@link Relationship }
     */
    @objid ("12b90b11-8aa7-45a7-b927-9292a1c0d16b")
    public Relationship createRelationship() {
        return new Relationship();
    }

    /**
     * Create an instance of {@link Facility }
     */
    @objid ("a4e34ac7-2d61-4a75-96c6-7a698bf9dc6f")
    public Facility createFacility() {
        return new Facility();
    }

    /**
     * Create an instance of {@link LangStringType }
     */
    @objid ("989d8d69-66ab-40d9-9c8f-0d4d651a00ef")
    public LangStringType createLangStringType() {
        return new LangStringType();
    }

    /**
     * Create an instance of {@link Constraint }
     */
    @objid ("fab68e1a-aa2a-4efb-958f-7a69b47739d6")
    public Constraint createConstraint() {
        return new Constraint();
    }

    /**
     * Create an instance of {@link Label }
     */
    @objid ("ef7a7603-4611-4d71-ba94-97645c5b6219")
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link BusinessActor }
     */
    @objid ("a94516f6-b128-4cd1-8bcd-ebfe9907830c")
    public BusinessActor createBusinessActor() {
        return new BusinessActor();
    }

    /**
     * Create an instance of {@link PropertyType }
     */
    @objid ("66cb6432-e6e0-489b-a5c2-eac53fea5537")
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link StakeholdersType }
     */
    @objid ("5a3ed7b0-e2d7-4413-bf23-dd8b4e6739d2")
    public StakeholdersType createStakeholdersType() {
        return new StakeholdersType();
    }

    /**
     * Create an instance of {@link BusinessInteraction }
     */
    @objid ("2991b0b9-3e3a-431e-8c5e-5e488c831c5f")
    public BusinessInteraction createBusinessInteraction() {
        return new BusinessInteraction();
    }

    /**
     * Create an instance of {@link WorkPackage }
     */
    @objid ("ff370a61-c9d9-46ac-97e5-1ae64f19475e")
    public WorkPackage createWorkPackage() {
        return new WorkPackage();
    }

    /**
     * Create an instance of {@link Serving }
     */
    @objid ("4b025d4f-0ff1-4db7-ba4e-c8dfeacc88ce")
    public Serving createServing() {
        return new Serving();
    }

    /**
     * Create an instance of {@link TechnologyFunction }
     */
    @objid ("3977753f-34d7-48f0-af1e-038aadd9476e")
    public TechnologyFunction createTechnologyFunction() {
        return new TechnologyFunction();
    }

    /**
     * Create an instance of {@link Container }
     */
    @objid ("60e31955-f69f-45e0-b1c9-3f97e5298407")
    public Container createContainer() {
        return new Container();
    }

    /**
     * Create an instance of {@link Stakeholder }
     */
    @objid ("6b153029-2c0f-4ada-af81-bbeaeed2227c")
    public Stakeholder createStakeholder() {
        return new Stakeholder();
    }

    /**
     * Create an instance of {@link Device }
     */
    @objid ("70e842a0-eec0-4ea1-96be-306e59d7d4f3")
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link OrJunction }
     */
    @objid ("404175aa-65ad-499c-9d11-118f48d58396")
    public OrJunction createOrJunction() {
        return new OrJunction();
    }

    /**
     * Create an instance of {@link MetadataType }
     */
    @objid ("c48babb7-a898-4de7-a66e-862920cb6cc9")
    public MetadataType createMetadataType() {
        return new MetadataType();
    }

    /**
     * Create an instance of {@link Resource }
     */
    @objid ("1eb1a519-a943-4f4d-92e4-95053d7bd923")
    public Resource createResource() {
        return new Resource();
    }

    /**
     * Create an instance of {@link PreservedLangStringType }
     */
    @objid ("0c341eb7-87e3-4221-be0c-085d6a76d825")
    public PreservedLangStringType createPreservedLangStringType() {
        return new PreservedLangStringType();
    }

    /**
     * Create an instance of {@link Representation }
     */
    @objid ("f7010a5c-d736-4262-8474-820fead06a21")
    public Representation createRepresentation() {
        return new Representation();
    }

    /**
     * Create an instance of {@link DataObject }
     */
    @objid ("435e6ccc-3dc4-44f1-b49d-ffbd36b3989a")
    public DataObject createDataObject() {
        return new DataObject();
    }

    /**
     * Create an instance of {@link Realization }
     */
    @objid ("d448bd79-0fd9-4c0e-ab71-35979b8f51b0")
    public Realization createRealization() {
        return new Realization();
    }

    /**
     * Create an instance of {@link Gap }
     */
    @objid ("7d8b5813-f5f6-4412-878c-3d9ae757b1f7")
    public Gap createGap() {
        return new Gap();
    }

    /**
     * Create an instance of {@link Value }
     */
    @objid ("1f544d37-a230-4e26-91f5-07538b99f73b")
    public Value createValue() {
        return new Value();
    }

    /**
     * Create an instance of {@link BusinessInterface }
     */
    @objid ("dfd11bf1-349c-4849-b9e2-44b778eb6638")
    public BusinessInterface createBusinessInterface() {
        return new BusinessInterface();
    }

    /**
     * Create an instance of {@link ApplicationProcess }
     */
    @objid ("f9b6ee0e-4ba9-4813-9399-40aec2b8c2f5")
    public ApplicationProcess createApplicationProcess() {
        return new ApplicationProcess();
    }

    /**
     * Create an instance of {@link TechnologyService }
     */
    @objid ("a24282cf-b2a8-43f2-9de8-83347b0dad00")
    public TechnologyService createTechnologyService() {
        return new TechnologyService();
    }

    /**
     * Create an instance of {@link BusinessRole }
     */
    @objid ("afc2c813-319c-4588-8adb-2b973558d060")
    public BusinessRole createBusinessRole() {
        return new BusinessRole();
    }

    /**
     * Create an instance of {@link Assessment }
     */
    @objid ("c3b7ee2f-31b5-43de-9b53-42a30594e7b1")
    public Assessment createAssessment() {
        return new Assessment();
    }

    /**
     * Create an instance of {@link Element }
     */
    @objid ("089c496e-5f44-4281-ac0b-54a128fd5030")
    public Element createElement() {
        return new Element();
    }

    /**
     * Create an instance of {@link SystemSoftware }
     */
    @objid ("929d7371-79b6-4283-87a5-cd9dc95ced57")
    public SystemSoftware createSystemSoftware() {
        return new SystemSoftware();
    }

    /**
     * Create an instance of {@link Driver }
     */
    @objid ("6c78fff0-b454-4fb3-bfd3-83b0fdc88b6e")
    public Driver createDriver() {
        return new Driver();
    }

    /**
     * Create an instance of {@link PropertyDefinitionsType }
     */
    @objid ("fcd80848-3e9b-4fae-808a-2206df88dadb")
    public PropertyDefinitionsType createPropertyDefinitionsType() {
        return new PropertyDefinitionsType();
    }

    /**
     * Create an instance of {@link NestingRelationship }
     */
    @objid ("5a4173f3-569b-43cd-9f6b-942b5f5adc32")
    public NestingRelationship createNestingRelationship() {
        return new NestingRelationship();
    }

    /**
     * Create an instance of {@link OrganizationsType }
     */
    @objid ("033167ec-fc6e-4fdc-8268-a2946e448312")
    public OrganizationsType createOrganizationsType() {
        return new OrganizationsType();
    }

    /**
     * Create an instance of {@link ApplicationInterface }
     */
    @objid ("77088574-31b4-4cb6-8ead-6f6cb0f0d67d")
    public ApplicationInterface createApplicationInterface() {
        return new ApplicationInterface();
    }

    /**
     * Create an instance of {@link RGBColorType }
     */
    @objid ("df96fcc2-778a-400a-8307-163d4a32baff")
    public RGBColorType createRGBColorType() {
        return new RGBColorType();
    }

    /**
     * Create an instance of {@link AllowedElementTypeType }
     */
    @objid ("81442ddc-4eec-4f89-aea2-7a2f896db3bc")
    public AllowedElementTypeType createAllowedElementTypeType() {
        return new AllowedElementTypeType();
    }

    /**
     * Create an instance of {@link TechnologyEvent }
     */
    @objid ("f28ba8dd-7b9a-4454-9bbc-ab974f0fa38c")
    public TechnologyEvent createTechnologyEvent() {
        return new TechnologyEvent();
    }

    /**
     * Create an instance of {@link Composition }
     */
    @objid ("83eef5a3-502e-40db-b11e-c73fdd64c85e")
    public Composition createComposition() {
        return new Composition();
    }

    /**
     * Create an instance of {@link ModelingNoteType }
     */
    @objid ("19caa37a-519c-45d2-a593-c3b2253956a5")
    public ModelingNoteType createModelingNoteType() {
        return new ModelingNoteType();
    }

    /**
     * Create an instance of {@link CourseOfAction }
     */
    @objid ("e0bab93e-2d06-4bc8-b001-a5110bebb796")
    public CourseOfAction createCourseOfAction() {
        return new CourseOfAction();
    }

    /**
     * Create an instance of {@link Material }
     */
    @objid ("e204f827-fa84-4a7c-b6b0-13c9ade3d3af")
    public Material createMaterial() {
        return new Material();
    }

    /**
     * Create an instance of {@link OrganizationType }
     */
    @objid ("2ed82816-6119-4447-8ed9-a8bae6bd8355")
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link FontType }
     */
    @objid ("affacce5-c0cf-47df-9538-23b348b7633d")
    public FontType createFontType() {
        return new FontType();
    }

    /**
     * Create an instance of {@link BusinessService }
     */
    @objid ("7bc5e092-c536-4df5-9db0-9142479df4ba")
    public BusinessService createBusinessService() {
        return new BusinessService();
    }

    /**
     * Create an instance of {@link Equipment }
     */
    @objid ("34f99697-eb85-46f4-80e0-58c6784651a1")
    public Equipment createEquipment() {
        return new Equipment();
    }

    /**
     * Create an instance of {@link ApplicationInteraction }
     */
    @objid ("e823d4e7-13df-4583-90be-8a7ab3d5957a")
    public ApplicationInteraction createApplicationInteraction() {
        return new ApplicationInteraction();
    }

    /**
     * Create an instance of {@link LocationType }
     */
    @objid ("336c67a3-3b44-4493-b45d-eb1990539d30")
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link Meaning }
     */
    @objid ("82097d1d-ae0b-48ec-9691-94bc28868099")
    public Meaning createMeaning() {
        return new Meaning();
    }

    /**
     * Create an instance of {@link BusinessProcess }
     */
    @objid ("1af3ce3f-022b-49c5-ab97-d342f908ce37")
    public BusinessProcess createBusinessProcess() {
        return new BusinessProcess();
    }

    /**
     * Create an instance of {@link Location }
     */
    @objid ("0322b481-8996-462d-a6f0-19282a76dfed")
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link OriginalViewsType }
     */
    @objid ("bf6211a0-53c3-435e-beb6-0136c6bce1a9")
    public OriginalViewsType createOriginalViewsType() {
        return new OriginalViewsType();
    }

    /**
     * Create an instance of {@link OriginalModelType }
     */
    @objid ("7bc9a1cf-7c96-45c8-bcac-2d809cb7c075")
    public OriginalModelType createOriginalModelType() {
        return new OriginalModelType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModelType }{@code >}}
     */
    @objid ("41c354cb-5f7e-4195-94fd-47e236fa0774")
    @XmlElementDecl(namespace = "http://www.opengroup.org/xsd/archimate/3.0/", name = "model")
    public JAXBElement<ModelType> createModel(ModelType value) {
        return new JAXBElement<ModelType>(_Model_QNAME, ModelType.class, null, value);
    }

    /**
     * Create an instance of {@link ValueStream }
     */
    @objid ("5e130593-661c-4b5c-bcd6-e2ff0fe3068a")
    public ValueStream createValueStream() {
        return new ValueStream();
    }

}
