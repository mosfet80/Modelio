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
package org.modelio.archimate.exchange.v30.exporter.factory.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v30.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v30.xmlmodel.AccessTypeEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.DataType;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.DiagramsType;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementsType;
import org.modelio.archimate.exchange.v30.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v30.xmlmodel.MetadataType;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.ObjectFactory;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationsType;
import org.modelio.archimate.exchange.v30.xmlmodel.PreservedLangStringType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertiesType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertyDefinitionType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertyDefinitionsType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertyType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipsType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewType;
import org.modelio.archimate.exchange.v30.xmlmodel.ViewsType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
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
import org.modelio.archimate.metamodel.relationships.dependency.AccessMode;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;
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
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.TypedPropertyTable;
import org.modelio.vcore.smkernel.mapi.MMetamodel;

@objid ("9e10899f-c33a-458f-bf0a-5f30c06469c1")
public class ElementFactoryExport implements IElementFactoryExport {
    @objid ("da146389-5071-4eb3-96c1-9bfc6f5a3110")
    private static final String PROPERTY_TABLENAME = "archimate";

    @objid ("394297f5-3e73-4f26-a8ef-287852b6fceb")
    private Map<String, Object> refs;

    @objid ("f8ce51ea-574f-4b5d-a2de-9f6a1c801bfc")
    private ObjectFactory baseFactory;

    @objid ("39b52193-e017-49ba-9f4f-181bf1d170ab")
    public ElementFactoryExport() {
        this.refs = new HashMap<>();
        this.baseFactory = new ObjectFactory();

    }

    @objid ("6ac143af-19c1-40c1-9a70-18922d2b15d0")
    @Override
    public void setReferenceMap(Map<String, Object> refs) {
        this.refs = refs;
    }

    @objid ("612b809c-cce2-4b3f-96b7-2a4147cc6e6d")
    @Override
    public Object createElement(ModelElement element) {
        Object jaxElement = null;
        MMetamodel m = element.getMClass().getMetamodel();
        if (element instanceof Model) {
            jaxElement = this.baseFactory.createModelType();
        } else if (element.getMClass().equals(m.getMClass(ArchimateView.class))) {
            jaxElement = this.baseFactory.createDiagram();
        } else if (element.getMClass().equals(m.getMClass(Access.class))) {
            jaxElement = this.baseFactory.createAccess();

            AccessMode mode = ((Access)element).getMode();

            if(mode.equals(AccessMode.READ)){
                ((org.modelio.archimate.exchange.v30.xmlmodel.Access)jaxElement).setAccessType(AccessTypeEnum.READ);
            }else if(mode.equals(AccessMode.WRITE)){
                ((org.modelio.archimate.exchange.v30.xmlmodel.Access)jaxElement).setAccessType(AccessTypeEnum.WRITE);
            }else if(mode.equals(AccessMode.READWRITE)){
                ((org.modelio.archimate.exchange.v30.xmlmodel.Access)jaxElement).setAccessType(AccessTypeEnum.READ_WRITE);
            }

        } else if (element.getMClass().equals(m.getMClass(Aggregation.class))) {
            jaxElement = this.baseFactory.createAggregation();
        } else if (element.getMClass().equals(m.getMClass(ApplicationCollaboration.class))) {
            jaxElement = this.baseFactory.createApplicationCollaboration();
        } else if (element.getMClass().equals(m.getMClass(ApplicationComponent.class))) {
            jaxElement = this.baseFactory.createApplicationComponent();
        } else if (element.getMClass().equals(m.getMClass(ApplicationEvent.class))) {
            jaxElement = this.baseFactory.createApplicationEvent();
        } else if (element.getMClass().equals(m.getMClass(ApplicationFunction.class))) {
            jaxElement = this.baseFactory.createApplicationFunction();
        } else if (element.getMClass().equals(m.getMClass(ApplicationInteraction.class))) {
            jaxElement = this.baseFactory.createApplicationInteraction();
        } else if (element.getMClass().equals(m.getMClass(ApplicationInterface.class))) {
            jaxElement = this.baseFactory.createApplicationInterface();
        } else if (element.getMClass().equals(m.getMClass(ApplicationProcess.class))) {
            jaxElement = this.baseFactory.createApplicationProcess();
        } else if (element.getMClass().equals(m.getMClass(ApplicationService.class))) {
            jaxElement = this.baseFactory.createApplicationService();
        } else if (element.getMClass().equals(m.getMClass(Artifact.class))) {
            jaxElement = this.baseFactory.createArtifact();
        } else if (element.getMClass().equals(m.getMClass(Assessment.class))) {
            jaxElement = this.baseFactory.createAssessment();
        } else if (element.getMClass().equals(m.getMClass(Assignment.class))) {
            jaxElement = this.baseFactory.createAssignment();
        } else if (element.getMClass().equals(m.getMClass(Association.class))) {
            jaxElement = this.baseFactory.createAssociation();
        } else if (element.getMClass().equals(m.getMClass(BusinessActor.class))) {
            jaxElement = this.baseFactory.createBusinessActor();
        } else if (element.getMClass().equals(m.getMClass(BusinessCollaboration.class))) {
            jaxElement = this.baseFactory.createBusinessCollaboration();
        } else if (element.getMClass().equals(m.getMClass(BusinessEvent.class))) {
            jaxElement = this.baseFactory.createBusinessEvent();
        } else if (element.getMClass().equals(m.getMClass(BusinessFunction.class))) {
            jaxElement = this.baseFactory.createBusinessFunction();
        } else if (element.getMClass().equals(m.getMClass(BusinessInteraction.class))) {
            jaxElement = this.baseFactory.createBusinessInteraction();
        } else if (element.getMClass().equals(m.getMClass(BusinessInterface.class))) {
            jaxElement = this.baseFactory.createBusinessInterface();
        } else if (element.getMClass().equals(m.getMClass(BusinessObject.class))) {
            jaxElement = this.baseFactory.createBusinessObject();
        } else if (element.getMClass().equals(m.getMClass(BusinessProcess.class))) {
            jaxElement = this.baseFactory.createBusinessProcess();
        } else if (element.getMClass().equals(m.getMClass(BusinessRole.class))) {
            jaxElement = this.baseFactory.createBusinessRole();
        } else if (element.getMClass().equals(m.getMClass(BusinessService.class))) {
            jaxElement = this.baseFactory.createBusinessService();
        } else if (element.getMClass().equals(m.getMClass(Capability.class))) {
            jaxElement = this.baseFactory.createCapability();
        } else if (element.getMClass().equals(m.getMClass(CommunicationNetwork.class))) {
            jaxElement = this.baseFactory.createCommunicationNetwork();
        } else if (element.getMClass().equals(m.getMClass(Composition.class))) {
            jaxElement = this.baseFactory.createComposition();
        } else if (element.getMClass().equals(m.getMClass(Constraint.class))) {
            jaxElement = this.baseFactory.createConstraint();
        } else if (element.getMClass().equals(m.getMClass(Contract.class))) {
            jaxElement = this.baseFactory.createContract();
        } else if (element.getMClass().equals(m.getMClass(CourseOfAction.class))) {
            jaxElement = this.baseFactory.createCourseOfAction();
        } else if (element.getMClass().equals(m.getMClass(DataObject.class))) {
            jaxElement = this.baseFactory.createDataObject();
        } else if (element.getMClass().equals(m.getMClass(Deliverable.class))) {
            jaxElement = this.baseFactory.createDeliverable();
        } else if (element.getMClass().equals(m.getMClass(Device.class))) {
            jaxElement = this.baseFactory.createDevice();
        } else if (element.getMClass().equals(m.getMClass(DistributionNetwork.class))) {
            jaxElement = this.baseFactory.createDistributionNetwork();
        } else if (element.getMClass().equals(m.getMClass(Driver.class))) {
            jaxElement = this.baseFactory.createDriver();
        } else if (element.getMClass().equals(m.getMClass(Equipment.class))) {
            jaxElement = this.baseFactory.createEquipment();
        } else if (element.getMClass().equals(m.getMClass(Facility.class))) {
            jaxElement = this.baseFactory.createFacility();
        } else if (element.getMClass().equals(m.getMClass(Flow.class))) {
            jaxElement = this.baseFactory.createFlow();
        } else if (element.getMClass().equals(m.getMClass(Gap.class))) {
            jaxElement = this.baseFactory.createGap();
        } else if (element.getMClass().equals(m.getMClass(Goal.class))) {
            jaxElement = this.baseFactory.createGoal();
        } else if (element.getMClass().equals(m.getMClass(Grouping.class))) {
            jaxElement = this.baseFactory.createGrouping();
        } else if (element.getMClass().equals(m.getMClass(ImplementationEvent.class))) {
            jaxElement = this.baseFactory.createImplementationEvent();
        } else if (element.getMClass().equals(m.getMClass(Influence.class))) {
            jaxElement = this.baseFactory.createInfluence();

            String strengh = ((Influence )element).getStrength();
            if(strengh.equals(InfluenceStrength.SLIGHTLYNEGATIVE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("-");
            }else if(strengh.equals(InfluenceStrength.STRONGLYNEGATIVE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("--");
            }else if(strengh.equals(InfluenceStrength.SLIGHTLYPOSITIVE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("+");
            }else if(strengh.equals(InfluenceStrength.STRONGLYPOSITIVE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("++");
            }else if(strengh.equals(InfluenceStrength.ZERO.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("0");
            }else if(strengh.equals(InfluenceStrength.ONE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("1");
            }else if(strengh.equals(InfluenceStrength.TWO.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("2");
            }else if(strengh.equals(InfluenceStrength.THREE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("3");
            }else if(strengh.equals(InfluenceStrength.FOUR.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("4");
            }else if(strengh.equals(InfluenceStrength.FIVE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("5");
            }else if(strengh.equals(InfluenceStrength.SIX.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("6");
            }else if(strengh.equals(InfluenceStrength.SEVEN.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("7");
            }else if(strengh.equals(InfluenceStrength.EIGHT.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("8");
            }else if(strengh.equals(InfluenceStrength.NINE.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("9");
            }else if(strengh.equals(InfluenceStrength.TEN.name())){
                (( org.modelio.archimate.exchange.v30.xmlmodel.Influence)jaxElement).setModifier("10");
            }
        } else if (element.getMClass().equals(m.getMClass(AndJunction.class))) {
            jaxElement = this.baseFactory.createAndJunction();
        } else if (element.getMClass().equals(m.getMClass(Location.class))) {
            jaxElement = this.baseFactory.createLocation();
        } else if (element.getMClass().equals(m.getMClass(Material.class))) {
            jaxElement = this.baseFactory.createMaterial();
        } else if (element.getMClass().equals(m.getMClass(Meaning.class))) {
            jaxElement = this.baseFactory.createMeaning();
        } else if (element.getMClass().equals(m.getMClass(Node.class))) {
            jaxElement = this.baseFactory.createNode();
        } else if (element.getMClass().equals(m.getMClass(OrJunction.class))) {
            jaxElement = this.baseFactory.createOrJunction();
        } else if (element.getMClass().equals(m.getMClass(Outcome.class))) {
            jaxElement = this.baseFactory.createOutcome();
        } else if (element.getMClass().equals(m.getMClass(Path.class))) {
            jaxElement = this.baseFactory.createPath();
        } else if (element.getMClass().equals(m.getMClass(Plateau.class))) {
            jaxElement = this.baseFactory.createPlateau();
        } else if (element.getMClass().equals(m.getMClass(Principle.class))) {
            jaxElement = this.baseFactory.createPrinciple();
        } else if (element.getMClass().equals(m.getMClass(Product.class))) {
            jaxElement = this.baseFactory.createProduct();
        } else if (element.getMClass().equals(m.getMClass(Realization.class))) {
            jaxElement = this.baseFactory.createRealization();
        } else if (element.getMClass().equals(m.getMClass(Representation.class))) {
            jaxElement = this.baseFactory.createRepresentation();
        } else if (element.getMClass().equals(m.getMClass(Requirement.class))) {
            jaxElement = this.baseFactory.createRequirement();
        } else if (element.getMClass().equals(m.getMClass(Resource.class))) {
            jaxElement = this.baseFactory.createResource();
        } else if (element.getMClass().equals(m.getMClass(Serving.class))) {
            jaxElement = this.baseFactory.createServing();
        } else if (element.getMClass().equals(m.getMClass(Specialization.class))) {
            jaxElement = this.baseFactory.createSpecialization();
        } else if (element.getMClass().equals(m.getMClass(Stakeholder.class))) {
            jaxElement = this.baseFactory.createStakeholder();
        } else if (element.getMClass().equals(m.getMClass(SystemSoftware.class))) {
            jaxElement = this.baseFactory.createSystemSoftware();
        } else if (element.getMClass().equals(m.getMClass(TechnologyCollaboration.class))) {
            jaxElement = this.baseFactory.createTechnologyCollaboration();
        } else if (element.getMClass().equals(m.getMClass(TechnologyEvent.class))) {
            jaxElement = this.baseFactory.createTechnologyEvent();
        } else if (element.getMClass().equals(m.getMClass(TechnologyFunction.class))) {
            jaxElement = this.baseFactory.createTechnologyFunction();
        } else if (element.getMClass().equals(m.getMClass(TechnologyInteraction.class))) {
            jaxElement = this.baseFactory.createTechnologyInteraction();
        } else if (element.getMClass().equals(m.getMClass(TechnologyInterface.class))) {
            jaxElement = this.baseFactory.createTechnologyInterface();
        } else if (element.getMClass().equals(m.getMClass(TechnologyProcess.class))) {
            jaxElement = this.baseFactory.createTechnologyProcess();
        } else if (element.getMClass().equals(m.getMClass(TechnologyService.class))) {
            jaxElement = this.baseFactory.createTechnologyService();
        } else if (element.getMClass().equals(m.getMClass(Triggering.class))) {
            jaxElement = this.baseFactory.createTriggering();
        } else if (element.getMClass().equals(m.getMClass(Value.class))) {
            jaxElement = this.baseFactory.createValue();
        } else if (element.getMClass().equals(m.getMClass(WorkPackage.class))) {
            jaxElement = this.baseFactory.createWorkPackage();
        }
        if (jaxElement != null) {
            this.refs.put(element.getUuid(), jaxElement);
        }
        return jaxElement;
    }

    @objid ("f2d35245-7f71-4e21-988e-fd46c8aaa624")
    @Override
    public Object updateElement(ModelType context, Object jaxObject, ModelElement element) {
        if (jaxObject instanceof ModelType) {
            ModelType jaxModel = (ModelType) jaxObject;
            jaxModel.setIdentifier(IDUtils.exportId(element.getUuid()));


             jaxModel.getNameGroup().add(createLabel(element.getName()));


            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxModel.getDocumentation().add(createValue(description));
            }

            jaxModel.setProperties(createProperties(jaxModel, element));

            MetadataType jaxMetadata = this.baseFactory.createMetadataType();
            jaxMetadata.setSchema(ArchiExchange.I18N.getString("modelio.name"));
            jaxMetadata.setSchemaversion(ArchiExchange.I18N.getString("modelio.version"));
            jaxModel.setMetadata(jaxMetadata);

        } else if (jaxObject instanceof ElementType) {
            ElementType jaxElement = (ElementType) jaxObject;
            jaxElement.setIdentifier(IDUtils.exportId(element.getUuid()));

            ElementsType elemContainer = context.getElements();
            if (elemContainer == null) {
                elemContainer = this.baseFactory.createElementsType();
                context.setElements(elemContainer);
            }
            elemContainer.getElement().add(jaxElement);

            jaxElement.getNameGroup().add(createLabel(element.getName()));

            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxElement.getDocumentation().add(createValue(description));
            }

            jaxElement.setProperties(createProperties(context, element));

        } else if (jaxObject instanceof RelationshipType) {
            RelationshipType jaxRelation = (RelationshipType) jaxObject;
            jaxRelation.setIdentifier(IDUtils.exportId(element.getUuid()));
            Relationship relationship = (Relationship) element;

            RelationshipsType relContainer = context.getRelationships();
            if (relContainer == null) {
                relContainer = this.baseFactory.createRelationshipsType();
                context.setRelationships(relContainer);
            }
            relContainer.getRelationship().add(jaxRelation);

            jaxRelation.getNameGroup().add(createLabel(element.getName()));

            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxRelation.getDocumentation().add(createValue(description));
            }

            if (relationship.getFrom() != null && relationship.getTo() != null) {
                Object source = this.refs.get(relationship.getFrom().getUuid());
                Object target = this.refs.get(relationship.getTo().getUuid());

                if (source != null && target != null) {
                    jaxRelation.setSource(source);
                    jaxRelation.setTarget(target);
                }
            }
            jaxRelation.setProperties(createProperties(context, element));
        } else if (jaxObject instanceof Diagram) {
            Diagram jaxView = (Diagram) jaxObject;
            jaxView.setIdentifier(IDUtils.exportId(element.getUuid()));

            ViewsType viewContainer = context.getViews();
            if (viewContainer == null) {
                viewContainer = this.baseFactory.createViewsType();
                context.setViews(viewContainer);
            }

            DiagramsType diagramType = viewContainer.getDiagrams();
            if (diagramType == null) {
                diagramType = this.baseFactory.createDiagramsType();
                viewContainer.setDiagrams(diagramType);
            }

            diagramType.getView().add(jaxView);

            jaxView.getNameGroup().add(createLabel(element.getName()));

            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxView.getDocumentation().add(createValue(description));
            }

            PropertiesType properties = createProperties(context, element);
            if(properties != null){
                jaxView.setProperties(properties);
            }
        }
        return jaxObject;
    }

    @objid ("0761a71f-47cb-4655-9d2e-59945d771548")
    private PropertiesType createProperties(ModelType context, ModelElement element) {
        List<TypedPropertyTable> propertyTables = element.getProperties(TypedPropertyTable.class);
        PropertiesType jaxPropTypes = null;

        for (TypedPropertyTable typedPropertyTable : propertyTables) {

            for (Object key : typedPropertyTable.toProperties().keySet()) {

                String propName = (String) key;

                PropertyTableDefinition type = typedPropertyTable.getType();
                PropertyDefinition prop = type.getOwned(propName);
                if (prop != null) {
                    String id = IDUtils.exportId(type, propName);

                    PropertyDefinitionType jaxPropDef = null;
                    PropertyDefinitionsType jaxProps = context.getPropertyDefinitions();
                    if(jaxProps != null){
                        for (PropertyDefinitionType propdef : jaxProps.getPropertyDefinition()) {
                            if (propdef.getIdentifier().equals(id)) {
                                jaxPropDef = propdef;
                            }
                        }
                    }

                    if (jaxPropDef == null) {

                        // Create PropertiesDefinition
                        if (jaxProps == null) {
                            jaxProps = this.baseFactory.createPropertyDefinitionsType();
                            context.setPropertyDefinitions(jaxProps);
                        }

                        jaxPropDef = this.baseFactory.createPropertyDefinitionType();
                        jaxProps.getPropertyDefinition().add(jaxPropDef);
                        jaxPropDef.setIdentifier(id);
                        jaxPropDef.setType(getDataType(prop.getType().getName()));
                        jaxPropDef.getNameGroup().add(createLabel(id));
                    }

                    if (jaxPropTypes == null){
                        jaxPropTypes = this.baseFactory.createPropertiesType();
                    }

                    PropertyType jaxProp = this.baseFactory.createPropertyType();
                    jaxProp.setPropertyDefinitionRef(jaxPropDef);
                    jaxProp.getValue().add(createValue(getValue(typedPropertyTable.getProperty(propName), prop)));
                    jaxPropTypes.getProperty().add(jaxProp);
                }
            }
        }
        return jaxPropTypes;
    }

    @objid ("74511a2e-07aa-487e-8435-1a8071ff3b4b")
    private String getValue(String property, PropertyDefinition prop) {
        if (property != null) {
            return property;
        }else {
            return prop.getDefaultValue();
        }

    }

    @objid ("4985ce0c-a22b-4cec-96cd-6eb8f4d28627")
    private DataType getDataType(String name) {
        switch (name){
        case "Boolean" :
            return DataType.BOOLEAN;

        case "Date" :
            return DataType.DATE;

        case "Float" :
            return DataType.NUMBER;

        case "Integer" :
            return DataType.NUMBER;

        case "Time" :
            return DataType.TIME;

        case "Unsigned" :
            return DataType.NUMBER;

        }
        return DataType.STRING;
    }

    @objid ("a5ae8b2e-1b62-42d0-85b7-1f40b7a8069c")
    @Override
    public void createOrganizations(ModelType context, Model model) {
        OrganizationsType modelOrganizations = this.baseFactory.createOrganizationsType();
        context.getOrganizations().add(modelOrganizations);

        for (Folder folder : model.getFolder()) {
            OrganizationType jaxItem = createFolerOrganization(folder);
            modelOrganizations.getItem().add(jaxItem);
        }

        for (ViewPoint viewpoint : model.getReferencedBy()) {
            if (viewpoint.getParent() == null) {
                OrganizationsType viewOrganization = this.baseFactory.createOrganizationsType();
                context.getOrganizations().add(viewOrganization);
                OrganizationType itType = createViewPointOrganization(viewpoint);
                viewOrganization.getItem().add(itType);
            }
        }

    }

    @objid ("d8524f05-0521-4856-959d-1b5d45822aae")
    private OrganizationType createViewPointOrganization(ViewPoint viewpoint) {
        OrganizationType itType = this.baseFactory.createOrganizationType();
        itType.setIdentifier(IDUtils.exportRefId(viewpoint.getUuid()));

        itType.getLabelGroup().add(createLabel(viewpoint.getName()));

        String description = viewpoint.getNoteContent("ModelerModule", "description");
        if (description != null && !"".equals(description)) {
            itType.getDocumentationGroup().add(createValue(description));
        }

        for (AbstractDiagram diag : viewpoint.getProduct()) {
            ViewType jaxViex = (ViewType) this.refs.get(diag.getUuid());

            OrganizationType viewItem = this.baseFactory.createOrganizationType();
            viewItem.setIdentifier(IDUtils.exportRefId(diag.getUuid()));
            itType.getItem().add(viewItem);

            viewItem.getLabelGroup().add(createLabel(diag.getName()));

            description = diag.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                viewItem.getDocumentationGroup().add(createValue(description));
            }
            viewItem.setIdentifierRef(jaxViex);
        }

        for (ViewPoint subViewpoint : viewpoint.getChild()) {
            OrganizationType subItem = createViewPointOrganization(subViewpoint);
            itType.getItem().add(subItem);
        }
        return itType;
    }

    @objid ("fe961582-64a2-4ea4-b687-7581831b145d")
    private OrganizationType createFolerOrganization(Folder folder) {
        OrganizationType itType = this.baseFactory.createOrganizationType();
        itType.setIdentifier(IDUtils.exportRefId(folder.getUuid()));

        itType.getLabelGroup().add(createLabel(folder.getName()));

        String description = folder.getNoteContent("ModelerModule", "description");
        if (description != null && !"".equals(description)) {
            itType.getDocumentationGroup().add(createValue(description));
        }

        for (Concept concept : folder.getContent()) {
            ElementType jaxElement = (ElementType) this.refs.get(concept.getUuid());

            OrganizationType viewItem = this.baseFactory.createOrganizationType();
            viewItem.setIdentifier(IDUtils.exportRefId(concept.getUuid()));
            itType.getItem().add(viewItem);

            viewItem.getLabelGroup().add(createLabel(concept.getName()));

            description = concept.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                viewItem.getDocumentationGroup().add(createValue(description));
            }
            viewItem.setIdentifierRef(jaxElement);
        }

        for (Folder subFolder : folder.getFolder()) {
            OrganizationType subItem = createFolerOrganization(subFolder);
            itType.getItem().add(subItem);
        }
        return itType;
    }

    @objid ("062c73f3-bd00-4c21-aeb4-d43d1f8dfce5")
    private LangStringType createLabel(String element) {
        LangStringType jaxLabel = this.baseFactory.createLangStringType();
        jaxLabel.setValue(element);
        String local = Locale.getDefault().getLanguage();
        jaxLabel.setLang(local);
        return jaxLabel;
    }

    @objid ("3c2a6220-24da-4701-9fcc-e812a7cbd3c4")
    private PreservedLangStringType createValue(String value) {
        PreservedLangStringType jaxdescription = this.baseFactory.createPreservedLangStringType();
        jaxdescription.setValue(value);
        String local = ResourceBundle.getBundle("archiexchange").getLocale().getLanguage();
        jaxdescription.setLang(local);
        return jaxdescription;
    }

}
