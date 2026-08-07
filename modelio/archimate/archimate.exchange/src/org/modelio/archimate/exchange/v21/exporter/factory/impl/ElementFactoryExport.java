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
package org.modelio.archimate.exchange.v21.exporter.factory.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v21.exporter.factory.IElementFactoryExport;
import org.modelio.archimate.exchange.v21.xmlmodel.DataType;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementsType;
import org.modelio.archimate.exchange.v21.xmlmodel.ItemType;
import org.modelio.archimate.exchange.v21.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v21.xmlmodel.MetadataType;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v21.xmlmodel.ObjectFactory;
import org.modelio.archimate.exchange.v21.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertiesDefinitionsType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertiesType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertyDefinitionType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertyType;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipsType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewsType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyFunction;
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyService;
import org.modelio.archimate.metamodel.layers.technology.structure.active.CommunicationNetwork;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Path;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.Association;
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

@objid ("d5b9549d-b9bc-4390-92f5-b6c28f0e6ed8")
public class ElementFactoryExport implements IElementFactoryExport {
    @objid ("548bd178-1ee2-402d-ab20-c96b65cad725")
    private static final String PROPERTY_TABLENAME = "archimate";

    @objid ("3b9c2718-8450-4200-b39a-506ef4bc5852")
    private Map<String, Object> refs;

    @objid ("3ff8814a-274b-4b12-9812-270cadaecb09")
    private ObjectFactory baseFactory;

    @objid ("5fed694c-3c52-47dd-a792-9e769ddaf465")
    public ElementFactoryExport() {
        this.refs = new HashMap<>();
        this.baseFactory = new ObjectFactory();

    }

    @objid ("a2895224-c704-4ae9-a428-11108c2bbbc3")
    @Override
    public void setReferenceMap(Map<String, Object> refs) {
        this.refs = refs;
    }

    @objid ("70d9033e-b60c-4eee-8dbc-6208eb5334fb")
    @Override
    public Object createElement(ModelElement element) {
        Object jaxElement = null;
        MMetamodel m = element.getMClass().getMetamodel();
        if (element instanceof Model) {
            jaxElement = this.baseFactory.createModelType();
        } else if (element.getMClass().equals(m.getMClass(ArchimateView.class))) {
            jaxElement = this.baseFactory.createViewType();
        } else if (element.getMClass().equals(m.getMClass(Access.class))) {
            jaxElement = this.baseFactory.createAccessRelationship();
        } else if (element.getMClass().equals(m.getMClass(Aggregation.class))) {
            jaxElement = this.baseFactory.createAggregationRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration.class))) {
            jaxElement = this.baseFactory.createApplicationCollaboration();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.technology.structure.active.Node.class))) {
            jaxElement = this.baseFactory.createNode();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent.class))) {
            jaxElement = this.baseFactory.createApplicationComponent();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction.class))) {
            jaxElement = this.baseFactory.createApplicationFunction();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction.class))) {
            jaxElement = this.baseFactory.createApplicationInteraction();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface.class))) {
            jaxElement = this.baseFactory.createApplicationInterface();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService.class))) {
            jaxElement = this.baseFactory.createApplicationService();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact.class))) {
            jaxElement = this.baseFactory.createArtifact();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Assessment.class))) {
            jaxElement = this.baseFactory.createAssessment();
        } else if (element.getMClass().equals(m.getMClass(Assignment.class))) {
            jaxElement = this.baseFactory.createAssignmentRelationship();
        } else if (element.getMClass().equals(m.getMClass(Association.class))) {
            jaxElement = this.baseFactory.createAssociationRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor.class))) {
            jaxElement = this.baseFactory.createBusinessActor();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration.class))) {
            jaxElement = this.baseFactory.createBusinessCollaboration();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent.class))) {
            jaxElement = this.baseFactory.createBusinessEvent();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction.class))) {
            jaxElement = this.baseFactory.createBusinessFunction();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction.class))) {
            jaxElement = this.baseFactory.createBusinessInteraction();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface.class))) {
            jaxElement = this.baseFactory.createBusinessInterface();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole.class))) {
            jaxElement = this.baseFactory.createBusinessRole();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject.class))) {
            jaxElement = this.baseFactory.createBusinessObject();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess.class))) {
            jaxElement = this.baseFactory.createBusinessProcess();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.behavior.BusinessService.class))) {
            jaxElement = this.baseFactory.createBusinessService();
        } else if (element.getMClass().equals(m.getMClass(Path.class))) {
            jaxElement = this.baseFactory.createCommunicationPath();
        } else if (element.getMClass().equals(m.getMClass(Composition.class))) {
            jaxElement = this.baseFactory.createCompositionRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Constraint.class))) {
            jaxElement = this.baseFactory.createConstraint();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.passive.Contract.class))) {
            jaxElement = this.baseFactory.createContract();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject.class))) {
            jaxElement = this.baseFactory.createDataObject();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable.class))) {
            jaxElement = this.baseFactory.createDeliverable();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.technology.structure.active.Device.class))) {
            jaxElement = this.baseFactory.createDevice();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Driver.class))) {
            jaxElement = this.baseFactory.createDriver();
        } else if (element.getMClass().equals(m.getMClass(Flow.class))) {
            jaxElement = this.baseFactory.createFlowRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap.class))) {
            jaxElement = this.baseFactory.createGap();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Goal.class))) {
            jaxElement = this.baseFactory.createGoal();
        } else if (element.getMClass().equals(m.getMClass(Influence.class))) {
            jaxElement = this.baseFactory.createInfluenceRelationship();
        } else if (element.getMClass().equals(m.getMClass(TechnologyFunction.class))) {
            jaxElement = this.baseFactory.createInfrastructureFunction();
        } else if (element.getMClass().equals(m.getMClass(TechnologyInterface.class))) {
            jaxElement = this.baseFactory.createInfrastructureInterface();
        } else if (element.getMClass().equals(m.getMClass(TechnologyService.class))) {
            jaxElement = this.baseFactory.createInfrastructureService();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.relationships.other.Junction.class))) {
            jaxElement = this.baseFactory.createJunction();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.core.generic.composite.Location.class))) {
            jaxElement = this.baseFactory.createLocation();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Meaning.class))) {
            jaxElement = this.baseFactory.createMeaning();
        } else if (element.getMClass().equals(m.getMClass(CommunicationNetwork.class))) {
            jaxElement = this.baseFactory.createNetwork();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau.class))) {
            jaxElement = this.baseFactory.createPlateau();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Principle.class))) {
            jaxElement = this.baseFactory.createPrinciple();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.composite.Product.class))) {
            jaxElement = this.baseFactory.createProduct();
        } else if (element.getMClass().equals(m.getMClass(Realization.class))) {
            jaxElement = this.baseFactory.createRealisationRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.business.structure.passive.Representation.class))) {
            jaxElement = this.baseFactory.createRepresentation();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Requirement.class))) {
            jaxElement = this.baseFactory.createRequirement();
        } else if (element.getMClass().equals(m.getMClass(Specialization.class))) {
            jaxElement = this.baseFactory.createSpecialisationRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Stakeholder.class))) {
            jaxElement = this.baseFactory.createStakeholder();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware.class))) {
            jaxElement = this.baseFactory.createSystemSoftware();
        } else if (element.getMClass().equals(m.getMClass(Triggering.class))) {
            jaxElement = this.baseFactory.createTriggeringRelationship();
        } else if (element.getMClass().equals(m.getMClass(Serving.class))) {
            jaxElement = this.baseFactory.createUsedByRelationship();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.motivation.Value.class))) {
            jaxElement = this.baseFactory.createValue();
        } else if (element.getMClass().equals(m.getMClass(org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage.class))) {
            jaxElement = this.baseFactory.createWorkPackage();
        }
        if (jaxElement != null) {
            this.refs.put(element.getUuid(), jaxElement);
        }
        return jaxElement;
    }

    @objid ("90fc314b-2677-4486-ba36-ee2e67d5d576")
    @Override
    public Object updateElement(ModelType context, Object jaxObject, ModelElement element) {
        if (jaxObject instanceof ModelType) {
            ModelType jaxModel = (ModelType) jaxObject;
            jaxModel.setIdentifier(IDUtils.exportId(element.getUuid()));

            if (!"".equals(element.getName())) {
                jaxModel.getName().add(createLabel(element));
            }

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

            jaxElement.getLabel().add(createLabel(element));

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

            jaxRelation.getLabel().add(createLabel(element));

            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxRelation.getDocumentation().add(createValue(description));
            }

            if (relationship.getFrom() != null && relationship.getTo() != null) {
                ElementType source = (ElementType) this.refs.get(relationship.getFrom().getUuid());
                ElementType target = (ElementType) this.refs.get(relationship.getTo().getUuid());

                if (source != null && target != null) {
                    jaxRelation.setSource(source);
                    jaxRelation.setTarget(target);
                }
            }
            jaxRelation.setProperties(createProperties(context, element));
        } else if (jaxObject instanceof ViewType) {
            ViewType jaxView = (ViewType) jaxObject;
            jaxView.setIdentifier(IDUtils.exportId(element.getUuid()));

            ViewsType viewContainer = context.getViews();
            if (viewContainer == null) {
                viewContainer = this.baseFactory.createViewsType();
                context.setViews(viewContainer);
            }
            viewContainer.getView().add(jaxView);

            jaxView.getLabel().add(createLabel(element));

            String description = element.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                jaxView.getDocumentation().add(createValue(description));
            }

            jaxView.setProperties(createProperties(context, element));
        }
        return jaxObject;
    }

    @objid ("c64fd4eb-b0b8-4434-8813-aa0ae4b4b835")
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
                    PropertiesDefinitionsType jaxProps = context.getPropertydefs();
                    if(jaxProps != null){
                        for (PropertyDefinitionType propdef : jaxProps.getPropertydef()) {
                            if (propdef.getIdentifier().equals(id)) {
                                jaxPropDef = propdef;
                            }
                        }
                    }

                    if (jaxPropDef == null) {

                        // Create PropertiesDefinition
                        if (jaxProps == null) {
                            jaxProps = this.baseFactory.createPropertiesDefinitionsType();
                            context.setPropertydefs(jaxProps);
                        }

                        jaxPropDef = this.baseFactory.createPropertyDefinitionType();
                        jaxProps.getPropertydef().add(jaxPropDef);
                        jaxPropDef.setIdentifier(id);
                        jaxPropDef.setType(getDataType(prop.getType().getName()));
                        jaxPropDef.setName(id);
                    }

                    if (jaxPropTypes == null){
                        jaxPropTypes = this.baseFactory.createPropertiesType();
                    }

                    PropertyType jaxProp = this.baseFactory.createPropertyType();
                    jaxProp.setIdentifierref(jaxPropDef);
                    jaxProp.getValue().add(createValue(getValue(typedPropertyTable.getProperty(propName), prop)));
                    jaxPropTypes.getProperty().add(jaxProp);
                }
            }
        }
        return jaxPropTypes;
    }

    @objid ("b1c9e1ed-e703-4798-8504-53302f5f67d9")
    private String getValue(String property, PropertyDefinition prop) {
        if (property != null) {
            return property;
        }else {
            return prop.getDefaultValue();
        }

    }

    @objid ("ae228206-92ca-40d2-b4bf-5db51896d3a1")
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

    @objid ("4e8410c7-4c94-48ba-a36c-c60c35b6cfe0")
    @Override
    public void createOrganizations(ModelType context, Model model) {
        OrganizationType modelOrganization = this.baseFactory.createOrganizationType();
        context.getOrganization().add(modelOrganization);
        for (Folder folder : model.getFolder()) {
            ItemType jaxItem = createFolerOrganization(folder);
            modelOrganization.getItem().add(jaxItem);
        }

        for (ViewPoint viewpoint : model.getReferencedBy()) {
            if (viewpoint.getParent() == null) {
                OrganizationType viewOrganization = this.baseFactory.createOrganizationType();
                context.getOrganization().add(viewOrganization);
                ItemType itType = createViewPointOrganization(viewpoint);
                viewOrganization.getItem().add(itType);
            }
        }

    }

    @objid ("c908e965-f8fd-4b37-9d0e-acace5e18aea")
    private ItemType createViewPointOrganization(ViewPoint viewpoint) {
        ItemType itType = this.baseFactory.createItemType();
        itType.setIdentifier(IDUtils.exportRefId(viewpoint.getUuid()));

        itType.getLabel().add(createLabel(viewpoint));

        String description = viewpoint.getNoteContent("ModelerModule", "description");
        if (description != null && !"".equals(description)) {
            itType.getDocumentation().add(createValue(description));
        }

        for (AbstractDiagram diag : viewpoint.getProduct()) {
            ViewType jaxViex = (ViewType) this.refs.get(diag.getUuid());

            ItemType viewItem = this.baseFactory.createItemType();
            viewItem.setIdentifier(IDUtils.exportRefId(diag.getUuid()));
            itType.getItem().add(viewItem);

            viewItem.getLabel().add(createLabel(diag));

            description = diag.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                viewItem.getDocumentation().add(createValue(description));
            }
            viewItem.setIdentifierref(jaxViex);
        }

        for (ViewPoint subViewpoint : viewpoint.getChild()) {
            ItemType subItem = createViewPointOrganization(subViewpoint);
            itType.getItem().add(subItem);
        }
        return itType;
    }

    @objid ("762be6ac-7479-479f-afe0-354b364e4b35")
    private ItemType createFolerOrganization(Folder folder) {
        ItemType itType = this.baseFactory.createItemType();
        itType.setIdentifier(IDUtils.exportRefId(folder.getUuid()));

        itType.getLabel().add(createLabel(folder));

        String description = folder.getNoteContent("ModelerModule", "description");
        if (description != null && !"".equals(description)) {
            itType.getDocumentation().add(createValue(description));
        }

        for (Concept concept : folder.getContent()) {
            ElementType jaxElement = (ElementType) this.refs.get(concept.getUuid());

            ItemType viewItem = this.baseFactory.createItemType();
            viewItem.setIdentifier(IDUtils.exportRefId(concept.getUuid()));
            itType.getItem().add(viewItem);

            viewItem.getLabel().add(createLabel(concept));

            description = concept.getNoteContent("ModelerModule", "description");
            if (description != null && !"".equals(description)) {
                viewItem.getDocumentation().add(createValue(description));
            }
            viewItem.setIdentifierref(jaxElement);
        }

        for (Folder subFolder : folder.getFolder()) {
            ItemType subItem = createFolerOrganization(subFolder);
            itType.getItem().add(subItem);
        }
        return itType;
    }

    @objid ("94d0608a-ef3c-4743-bfe9-cb5ce9d81480")
    private LangStringType createLabel(ModelElement element) {
        LangStringType jaxLabel = this.baseFactory.createLangStringType();
        jaxLabel.setValue(element.getName());
        String local = Locale.getDefault().getLanguage();
        jaxLabel.setLang(local);
        return jaxLabel;
    }

    @objid ("148f82bc-eb91-4399-ac3a-9071c06ec7a1")
    private LangStringType createValue(String value) {
        LangStringType jaxdescription = this.baseFactory.createLangStringType();
        jaxdescription.setValue(value);
        String local = ResourceBundle.getBundle("archiexchange").getLocale().getLanguage();
        jaxdescription.setLang(local);
        return jaxdescription;
    }

}
