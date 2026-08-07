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
package org.modelio.archimate.exchange.v31.importer.factory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v31.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v31.xmlmodel.Access;
import org.modelio.archimate.exchange.v31.xmlmodel.AccessTypeEnum;
import org.modelio.archimate.exchange.v31.xmlmodel.Association;
import org.modelio.archimate.exchange.v31.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v31.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v31.xmlmodel.Influence;
import org.modelio.archimate.exchange.v31.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v31.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v31.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v31.xmlmodel.OrganizationsType;
import org.modelio.archimate.exchange.v31.xmlmodel.PropertiesType;
import org.modelio.archimate.exchange.v31.xmlmodel.PropertyDefinitionType;
import org.modelio.archimate.exchange.v31.xmlmodel.PropertyType;
import org.modelio.archimate.exchange.v31.xmlmodel.ReferenceableType;
import org.modelio.archimate.exchange.v31.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.vcommon.importer.AbstractElementFactoryImport;
import org.modelio.archimate.exchange.vcommon.importer.PrimitiveTypeImport;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
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
import org.modelio.archimate.metamodel.relationships.dependency.AccessMode;
import org.modelio.archimate.metamodel.relationships.dependency.InfluenceStrength;
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.gproject.project.AbstractGProject;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Profile;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyBaseType;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTable;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.TypedPropertyTable;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("b404bf82-a114-4ef2-8eb0-8030c0dabcca")
public class ElementFactoryImport extends AbstractElementFactoryImport implements IElementFactoryImport {
    @objid ("e9ed23b4-3022-4bb2-96ca-d87328e83d0e")
    private static final String PROPERTY_TABLENAME = "archimate";

    @objid ("9bcd7664-b928-42c0-9805-f145317ae50c")
    private boolean keepId;

    @objid ("e3170110-5c38-4b3b-81fa-4f4255c6e0b7")
    private static final String PROPERTY_TYPENAME = "ArchimateDefaultType";

    @objid ("1db1573f-1f32-485a-926b-2a84c9e6dce7")
    private static final String PROFILENAME = "Archimate";

    @objid ("ba4b91ee-be75-438d-b871-2891b344337e")
    private static final String MODULENAME = "ArchimateTypes";

    @objid ("93fc667f-46e0-4a9d-bca0-4c95a39d1473")
    private static final String ARCHIMATE_ELEMENT = "Archimate.Element";

    @objid ("03e1e34d-2959-42b5-828d-4a2889ef8a4e")
    private Model model;

    @objid ("e1bb3c41-a102-40c5-af52-d6db8077c157")
    public ElementFactoryImport(ICoreSession session, ArchimateProject context, boolean keepId, boolean isUpdate) {
        super(session, context, keepId,isUpdate);
        this.keepId = keepId;
    }

    @objid ("89c40e4a-0f7c-4488-bcba-1034fd69d5ee")
    @Override
    public ModelElement createElement(String identifier, Object jaxElement) {
        Class<? extends MObject> type = TypeUtils.getModelioType(jaxElement, this.session);
        return createElement(identifier, type);
    }

    @objid ("d32b31f5-4e93-4062-abee-54d2b9662af3")
    @Override
    public ModelElement updateElement(ModelElement element, Object jaxObject) {
        if (jaxObject instanceof ModelType) {
            ModelType jaxModel = (ModelType) jaxObject;
            this.model = (Model) element;
            this.model.setProject(this.context);

            String label = getInternationalisedString(jaxModel.getNameGroup());
            if (label != null) {
                this.model.setName(label);
            }

            updateDocumentation(element, jaxModel);

            createProperties(element, jaxModel.getProperties());

            createFolders();

        } else if (jaxObject instanceof ElementType) {
            ElementType jaxElement = (ElementType) jaxObject;
            Concept concept = (Concept) element;

            concept.setOwnerFolder(TypeUtils.getOwnerFolder(concept, this.model));

            String label = getInternationalisedString(jaxElement.getNameGroup());
            if (label != null) {
                element.setName(label);
            }

            updateDocumentation(element, jaxElement);

            createProperties(element, jaxElement.getProperties());

        } else if (jaxObject instanceof RelationshipType) {
            RelationshipType jaxRelation = (RelationshipType) jaxObject;
            Relationship relation = (Relationship) element;

            String label = getInternationalisedString(jaxRelation.getNameGroup());
            if (label != null) {
                relation.setName(label);
            }

            updateDocumentation(element, jaxRelation);

            Object jaxSource = jaxRelation.getSource();
            Object jaxTarget = jaxRelation.getTarget();
            if (jaxSource != null && jaxTarget != null) {

                Concept source = null;
                if (jaxSource instanceof ElementType) {
                    source = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxSource).getIdentifier()));
                } else if (jaxSource instanceof RelationshipType) {
                    source = (Concept) this.refs.get(IDUtils.importId(((RelationshipType) jaxSource).getIdentifier()));
                }

                Concept target = null;

                if (jaxTarget instanceof ElementType) {
                    target = (Concept) this.refs.get(IDUtils.importId(((ElementType) jaxTarget).getIdentifier()));
                } else if (jaxTarget instanceof RelationshipType) {
                    target = (Concept) this.refs.get(IDUtils.importId(((RelationshipType) jaxTarget).getIdentifier()));
                }

                relation.setFrom(source);
                relation.setTo(target);
                createProperties(element, jaxRelation.getProperties());
            } else {
                element.delete();
            }

            if (jaxRelation instanceof Access && !element.isDeleted() && relation instanceof org.modelio.archimate.metamodel.relationships.dependency.Access) {
                org.modelio.archimate.metamodel.relationships.dependency.Access access = (org.modelio.archimate.metamodel.relationships.dependency.Access) relation;
                AccessTypeEnum type = ((Access) jaxRelation).getAccessType();
                if (type != null) {
                    if (type.equals(AccessTypeEnum.READ)) {
                        access.setMode(AccessMode.READ);
                    } else if (type.equals(AccessTypeEnum.READ_WRITE)) {
                        access.setMode(AccessMode.READWRITE);
                    } else if (type.equals(AccessTypeEnum.WRITE)) {
                        access.setMode(AccessMode.WRITE);
                    } else if (type.equals(AccessTypeEnum.ACCESS)) {
                        access.setMode(AccessMode.UNDEFINED);
                    }
                } else {
                    access.setMode(AccessMode.UNDEFINED);
                }
            }

            if (jaxRelation instanceof Influence && !element.isDeleted() && relation instanceof org.modelio.archimate.metamodel.relationships.dependency.Influence) {
                org.modelio.archimate.metamodel.relationships.dependency.Influence influence = (org.modelio.archimate.metamodel.relationships.dependency.Influence) relation;
                String qualifier = ((Influence) jaxRelation).getModifier();
                if (qualifier != null) {
                    if ("-".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.SLIGHTLYNEGATIVE.name());
                    } else if ("--".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.STRONGLYNEGATIVE.name());
                    } else if ("+".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.SLIGHTLYPOSITIVE.name());
                    } else if ("++".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.STRONGLYPOSITIVE.name());
                    }else if ("0".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.ZERO.name());
                    }else if ("1".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.ONE.name());
                    } else if ("2".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.TWO.name());
                    } else if ("3".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.THREE.name());
                    } else if ("4".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.FOUR.name());
                    } else if ("5".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.FIVE.name());
                    } else if ("6".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.SIX.name());
                    } else if ("7".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.SEVEN.name());
                    } else if ("8".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.EIGHT.name());
                    } else if ("9".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.NINE.name());
                    } else if ("10".equals(qualifier)) {
                        influence.setStrength(InfluenceStrength.TEN.name());
                    }  else {
                        influence.setStrength(InfluenceStrength.UNDEFINED.name());
                    }
                } else {
                    influence.setStrength(InfluenceStrength.UNDEFINED.name());
                }
            }

            if (jaxRelation instanceof Association && !element.isDeleted()) {
                org.modelio.archimate.metamodel.relationships.other.Association association = (org.modelio.archimate.metamodel.relationships.other.Association) relation;
                Boolean qualifier = ((Association) jaxRelation).isIsDirected();
                if (qualifier) {
                    association.setDirected(true);
                } else {
                   association.setDirected(false);
                }
            }

        } else if (jaxObject instanceof Diagram) {
            Diagram jaxView = (Diagram) jaxObject;
            ArchimateView view = (ArchimateView) element;

            String label = getInternationalisedString(jaxView.getNameGroup());
            if (label != null) {
                view.setName(label);
            }

            updateDocumentation(element, jaxView);

            List<ViewPoint> vps = this.model.getReferencedBy();
            if (vps.size() == 0) {
                ViewPoint newViewPoint = this.baseFactory.create(ViewPoint.class, this.context);
                newViewPoint.setName(this.model.getName() + "ViewPoint");
                newViewPoint.setProject(this.context);
                newViewPoint.setContext(this.model);
                view.setOrigin(newViewPoint);
            } else {
                view.setOrigin(vps.get(0));
            }

            createProperties(element, jaxView.getProperties());
        }
        return null;
    }

    @objid ("00fc3254-4084-4d20-a17f-94e7923d4804")
    private void updateDocumentation(ModelElement element, ReferenceableType jaxElement) {
        String description = getInternationalisedString(jaxElement.getDocumentation());
        if (description != null) {
            element.putNoteContent(this.descNoteType, description);
        }
    }

    @objid ("79042073-af51-4429-a9db-2a8a92083419")
    private void updateDocumentation(ModelElement element, OrganizationType jaxElement) {
        String description = getInternationalisedString(jaxElement.getDocumentationGroup());
        if (description != null) {
            element.putNoteContent(this.descNoteType, description);
        }
    }

    @objid ("e1520393-8751-4ce7-ba1c-cda244a29d12")
    private void createProperties(ModelElement element, PropertiesType properties) {
        if (properties != null) {

            PrimitiveTypeImport typeImport = new PrimitiveTypeImport(this.session.getModel());

            for(PropertyType propType : properties.getProperty()){

                //Get associated PropertyTableDefinition
                PropertyTableDefinition tableDef = null;

                Object obj = propType.getPropertyDefinitionRef();

                if (obj instanceof PropertyDefinitionType) {

                    PropertyDefinitionType propDefType = (PropertyDefinitionType) obj;

                    String tabId = IDUtils.getTableId(propDefType.getIdentifier());
                    tableDef =  (PropertyTableDefinition) this.refs.get(tabId);

                    if (tableDef == null) {
                        tableDef = getPropertyTableDefinition(element, tabId);
                        this.refs.put(tabId, tableDef);
                    }

                    //finding table
                    TypedPropertyTable table = null;
                    for( PropertyTable existingTable : element.getProperties()) {
                        if ((existingTable instanceof TypedPropertyTable)
                                && ((TypedPropertyTable) existingTable).getType().equals(tableDef))
                            table = ((TypedPropertyTable) existingTable);
                    }

                    if (table == null) {
                        table = this.baseFactory.create(TypedPropertyTable.class, element);
                        table.setName(tableDef.getCompositionOwner().getUuid());
                        table.setOwner(element);
                        table.setType(tableDef);
                    }

                    String propName = IDUtils.getPropName(getInternationalisedString(propDefType.getNameGroup()));
                    if (tableDef.getOwned().stream().noneMatch(owned -> owned.getName().equals(propName))) {
                        PropertyDefinition newType = this.baseFactory.create(PropertyDefinition.class, element);
                        newType.setName(propName);
                        newType.setOwner(tableDef);
                        newType.setIsEditable(true);
                        newType.setType(typeImport.getType(propDefType.getType().name()));
                    }

                    //setValue
                    table.setProperty(propName, getInternationalisedString(propType.getValue()));
                }
            }
        }
    }

    @objid ("134f8022-14c8-4f19-a689-3eee45fc9dbb")
    private PropertyTableDefinition getPropertyTableDefinition(ModelElement element, String id) {
        PropertyTableDefinition result = findPropertyTable(id);
        if (result == null) {
            return createArchimatePropertyTableDefinition(element);
        }else {
            return result;
        }
    }

    @objid ("92b04335-b5ea-4c9d-8ff3-a194b7ca716e")
    public final PropertyTableDefinition findPropertyTable(String identifier) {
        PropertyTableDefinition result = this.session.getModel().findById(PropertyTableDefinition.class, IDUtils.importId(identifier));

        if (result != null) {
            this.refs.put(IDUtils.importId(identifier), result);
        }
        return result;
    }

    @objid ("d7eda254-48b2-4325-95a6-58ed12ddebc8")
    private PropertyTableDefinition createArchimatePropertyTableDefinition(ModelElement element) {
        IGModelFragment fragment = AbstractGProject.getProject(this.session).getFragment(element);

        ModuleComponent localModule = findFirstModifiable(fragment.getRoots(), ModuleComponent.class, null);
        if (localModule==null) {
            localModule = this.baseFactory.create(ModuleComponent.class, element);
            fragment.getRoots().add(localModule);
            localModule.setName(MODULENAME);
        }

        Profile archiProfile = findFirstModifiable(localModule.getOwnedProfile(), Profile.class, PROFILENAME);
        if (archiProfile == null) {
            archiProfile = this.baseFactory.create(Profile.class, element);
            archiProfile.setName(PROFILENAME);
            archiProfile.setOwnerModule(localModule);
        }

        MetaclassReference ref = findFirstModifiable(archiProfile.getOwnedReference(), MetaclassReference.class, ARCHIMATE_ELEMENT);
        if (ref == null) {
            ref = this.baseFactory.create(MetaclassReference.class, element);
            ref.setOwnerProfile(archiProfile);
            ref.setName(ARCHIMATE_ELEMENT);
            ref.setReferencedClassName(ARCHIMATE_ELEMENT);
        }

        PropertyTableDefinition strProp = ref.getDefinedTable();
        PropertyTableDefinition result = null;

        if ((strProp != null) && (strProp.getStatus().isModifiable())) {
            result = strProp;
        } else {
            result = this.baseFactory.create(PropertyTableDefinition.class, element);
            result.setName(PROPERTY_TABLENAME);
            result.setOwnerReference(ref);
        }
        return result;
    }

    @objid ("60c7849d-0fba-4c9e-a636-5c2f11fd6fb2")
    private void createFolders() {
        Folder businessLayer = null;
        Folder applicatinoLayer = null;
        Folder technologyLayer = null;
        Folder motivationLayer = null;
        Folder implementationLayer = null;
        Folder physicalLayer = null;
        Folder strategyLayer = null;

        for (Folder folder : this.model.getFolder()) {
            if (folder instanceof BusinessFolder) {
                businessLayer = folder;
            } else if (folder instanceof ApplicationFolder) {
                applicatinoLayer = folder;
            } else if (folder instanceof TechnologyFolder) {
                technologyLayer = folder;
            } else if (folder instanceof MotivationFolder) {
                motivationLayer = folder;
            } else if (folder instanceof ImplementationFolder) {
                implementationLayer = folder;
            } else if (folder instanceof PhysicalFolder) {
                physicalLayer = folder;
            } else if (folder instanceof StrategyFolder) {
                strategyLayer = folder;
            }
        }

        if (businessLayer == null) {
            businessLayer = this.baseFactory.create(BusinessFolder.class, this.context);
            businessLayer.setName(ArchiExchange.I18N.getString("default.layer.business.label"));
            businessLayer.setOwner(this.model);
        }
        if (applicatinoLayer == null) {
            applicatinoLayer = this.baseFactory.create(ApplicationFolder.class, this.context);
            applicatinoLayer.setName(ArchiExchange.I18N.getString("default.layer.application.label"));
            applicatinoLayer.setOwner(this.model);
        }
        if (technologyLayer == null) {
            technologyLayer = this.baseFactory.create(TechnologyFolder.class, this.context);
            technologyLayer.setName(ArchiExchange.I18N.getString("default.layer.technology.label"));
            technologyLayer.setOwner(this.model);
        }
        if (motivationLayer == null) {
            motivationLayer = this.baseFactory.create(MotivationFolder.class, this.context);
            motivationLayer.setName(ArchiExchange.I18N.getString("default.layer.motivation.label"));
            motivationLayer.setOwner(this.model);
        }
        if (implementationLayer == null) {
            implementationLayer = this.baseFactory.create(ImplementationFolder.class, this.context);
            implementationLayer.setName(ArchiExchange.I18N.getString("default.layer.implementation.label"));
            implementationLayer.setOwner(this.model);
        }
        if (physicalLayer == null) {
            physicalLayer = this.baseFactory.create(PhysicalFolder.class, this.context);
            physicalLayer.setName(ArchiExchange.I18N.getString("default.layer.physical.label"));
            physicalLayer.setOwner(this.model);
        }
        if (strategyLayer == null) {
            strategyLayer = this.baseFactory.create(StrategyFolder.class, this.context);
            strategyLayer.setName(ArchiExchange.I18N.getString("default.layer.strategy.label"));
            strategyLayer.setOwner(this.model);
        }
    }

    @objid ("b7d108ac-1c05-4c9a-9b2a-fd4cd3cdf579")
    private String getInternationalisedString(List<? extends LangStringType> labels) {
        if (labels != null) {
            for (LangStringType label : labels) {
                if (label.getLang() != null && label.getLang().equals(this.primaryLocale)) {
                    return label.getValue();
                }
            }

            if (labels.size() > 0) {
                return labels.get(0).getValue();
            }
        }
        return null;
    }

    @objid ("7cfa09e1-e014-438b-beab-a6429956e4d0")
    @Override
    public void createOrganization(OrganizationsType jaxOrg, Model aModel) {
        for (OrganizationType jaxItem : jaxOrg.getItem()) {
            createStructuralElement(aModel, jaxItem);
        }
    }

    @objid ("558e3183-ce1f-4631-8fd0-844ba026733f")
    private Object createStructuralElement(Model aModel, OrganizationType jaxItem) {
        for (Organization organization : findOrganizations(jaxItem)) {
            if (organization.hierarchy.size() != 0) {
                createStructure(aModel, organization);
            }
        }

        // delete empty view points
        for (ViewPoint vp : aModel.getReferencedBy()) {
            if (vp.getProduct().size() == 0 && vp.getChild().size() == 0) {
                vp.delete();
            }
        }
        return aModel;
    }

    @objid ("8cca44b4-56d4-485d-891f-e0cd093870ec")
    private void createStructure(MObject owner, Organization organization) {
        if (organization.element instanceof Concept) {
            Concept concept = (Concept) organization.element;
            Folder folder = TypeUtils.getOwnerFolder(concept, this.model);

            String firstLabel = getInternationalisedString(organization.hierarchy.get(0).getLabelGroup());
            if (folder.getName().equals(firstLabel)) {
                updateDocumentation(folder, organization.hierarchy.get(0));
                organization.hierarchy.remove(0);
            }

            for (OrganizationType item : organization.hierarchy) {
                Folder newFloder = findFolder(folder, item);
                // TODO : must support generic folder
                if (newFloder == null && folder instanceof Model) {
                    break;
                } else {
                    if (newFloder == null) {
                        newFloder = createSubFolder(folder);
                        String label = getInternationalisedString(item.getLabelGroup());
                        if (label != null) {
                            newFloder.setName(label);
                        }

                        updateDocumentation(newFloder, item);
                    }
                    folder = newFloder;
                }
            }

            concept.setOwnerFolder(folder);
        } else if (organization.element instanceof ArchimateView) {
            ArchimateView view = (ArchimateView) organization.element;
            ViewPoint viewPoint = findViewPoint(this.model, organization.hierarchy.get(0));
            if (viewPoint != null) {
                organization.hierarchy.remove(0);
            } else {
                viewPoint = this.baseFactory.create(ViewPoint.class, this.context);
                String label = getInternationalisedString(organization.hierarchy.get(0).getLabelGroup());
                viewPoint.setName(label);
                viewPoint.setContext(this.model);
                viewPoint.setProject(this.model.getProject());

                updateDocumentation(viewPoint, organization.hierarchy.get(0));

                ViewPointDiagram diagram = this.baseFactory.create(ViewPointDiagram.class, this.context);
                diagram.setOrigin(viewPoint);
                diagram.setName(viewPoint.getName());

                organization.hierarchy.remove(0);
            }

            for (OrganizationType item : organization.hierarchy) {
                ViewPoint existingViewPoint = findViewPoint(viewPoint, item);
                if (existingViewPoint == null) {
                    ViewPoint newViewPoint = this.baseFactory.create(ViewPoint.class, this.context);
                    String label = getInternationalisedString(item.getLabelGroup());
                    newViewPoint.setName(label);
                    newViewPoint.setContext(this.model);
                    newViewPoint.setParent(viewPoint);

                    updateDocumentation(viewPoint, item);


                    ViewPointDiagram diagram = this.baseFactory.create(ViewPointDiagram.class, this.context);
                    diagram.setOrigin(newViewPoint);
                    diagram.setName(newViewPoint.getName());



                    viewPoint = newViewPoint;
                } else {
                    viewPoint = existingViewPoint;
                }
            }

            ViewPoint origin = (ViewPoint) view.getOrigin();
            view.setOrigin(viewPoint);
            if (origin.getProduct().stream().filter(dg -> !(dg instanceof ViewPointDiagram)).toArray().length == 0) {
                origin.delete();
            }
        }
    }

    @objid ("e8d1d016-acd7-4db3-adb2-4129c4348530")
    private Folder createSubFolder(Folder folder) {
        Folder newFolder = (Folder) this.baseFactory.create(folder.getMClass().getJavaInterface(), this.context);

        if (newFolder instanceof BusinessFolder) {
            ((BusinessFolder) newFolder).setOwnerFolder((BusinessFolder) folder);
        } else if (newFolder instanceof ApplicationFolder) {
            ((ApplicationFolder) newFolder).setOwnerFolder((ApplicationFolder) folder);
        } else if (newFolder instanceof TechnologyFolder) {
            ((TechnologyFolder) newFolder).setOwnerFolder((TechnologyFolder) folder);
        } else if (newFolder instanceof ImplementationFolder) {
            ((ImplementationFolder) newFolder).setOwnerFolder((ImplementationFolder) folder);
        } else if (newFolder instanceof PhysicalFolder) {
            ((PhysicalFolder) newFolder).setOwnerFolder((PhysicalFolder) folder);
        } else if (newFolder instanceof StrategyFolder) {
            ((StrategyFolder) newFolder).setOwnerFolder((StrategyFolder) folder);
        } else if (newFolder instanceof MotivationFolder) {
            ((MotivationFolder) newFolder).setOwnerFolder((MotivationFolder) folder);
        }
        return newFolder;
    }

    @objid ("2ff2a04f-a279-4e65-9287-b46430953707")
    private ViewPoint findViewPoint(MObject owner, OrganizationType item) {
        List<ViewPoint> viewPoints = null;
        if (owner instanceof ViewPoint) {
            viewPoints = ((ViewPoint) owner).getChild();
        } else if (owner instanceof Model) {
            viewPoints = ((Model) owner).getReferencedBy();
        }

        if (viewPoints != null) {
            for (ViewPoint subViewPoint : viewPoints) {
                String label = getInternationalisedString(item.getLabelGroup());
                if (subViewPoint.getName().equals(label) || subViewPoint.getUuid().equals(item.getIdentifier())) {
                    return subViewPoint;
                }
            }
        }
        return null;
    }

    @objid ("3af5579c-61d0-40d9-b209-7295f8f72961")
    private Folder findFolder(Folder folder, OrganizationType item) {
        for (Folder subFolder : folder.getFolder()) {
            String label = getInternationalisedString(item.getLabelGroup());
            if (subFolder.getName().equals(label) || subFolder.getUuid().equals(item.getIdentifier())) {
                return subFolder;
            }
        }
        return null;
    }

    @objid ("c883734a-9a03-42bb-894d-77199aa22955")
    private List<Organization> findOrganizations(OrganizationType jaxItem) {
        List<Organization> result = new ArrayList<>();
        if (jaxItem.getIdentifierRef() instanceof Diagram) {
            result.add(new Organization(this.refs.get(IDUtils.importId(((Diagram) jaxItem.getIdentifierRef()).getIdentifier())),
                    new ArrayList<>()));
        } else if (jaxItem.getIdentifierRef() instanceof ElementType) {
            result.add(new Organization(this.refs.get(IDUtils.importId(((ElementType) jaxItem.getIdentifierRef()).getIdentifier())),
                    new ArrayList<>()));
        } else if (jaxItem.getLabelGroup().size() > 0) {
            for (OrganizationType jaxSubItem : jaxItem.getItem()) {
                List<Organization> subResults = findOrganizations(jaxSubItem);
                for (Organization subResult : subResults) {
                    subResult.hierarchy.add(0, jaxItem);
                }
                result.addAll(subResults);
            }
        }
        return result;
    }

    @objid ("24f9d230-60d5-42d6-b994-777b6a9ae91b")
    private PropertyTableDefinition createPropertyTableDefinition(ModelElement element, PropertiesType properties) {
        IGModelFragment fragemnt = AbstractGProject.getProject(this.session).getFragment(element);

        Optional<MObject> strObj = fragemnt.getRoots().stream().filter(obj -> obj instanceof ModuleComponent).findFirst();
        ModuleComponent localModule = null;
        if (strObj.isPresent()) {
            localModule = (ModuleComponent) strObj.get();
        } else {
            localModule = this.baseFactory.create(ModuleComponent.class, element);
            fragemnt.getRoots().add(localModule);
            localModule.setName(MODULENAME);
        }

        PropertyTableDefinition tableDef = this.genericTableMap.get(element.getMClass().getName());
        if (tableDef == null) {

            Optional<Profile> strProf = localModule.getOwnedProfile().stream().filter(obj -> obj.getName().equals(PROFILENAME)).findFirst();
            Profile archiProfile = null;
            if (strProf.isPresent()) {
                archiProfile = strProf.get();
            } else {
                archiProfile = this.baseFactory.create(Profile.class, element);
                archiProfile.setName(PROFILENAME);
                archiProfile.setOwnerModule(localModule);
            }

            MetaclassReference ref = this.baseFactory.create(MetaclassReference.class, element);
            ref.setOwnerProfile(archiProfile);
            ref.setName(element.getMClass().getName());
            ref.setReferencedClassName(element.getMClass().getQualifiedName());

            tableDef = this.baseFactory.create(PropertyTableDefinition.class, element);
            tableDef.setName(PROPERTY_TABLENAME);
            tableDef.setOwnerReference(ref);

            this.genericTableMap.put(element.getMClass().getName(), tableDef);
        }

        Optional<org.modelio.metamodel.uml.infrastructure.properties.PropertyType> strProp = localModule.getDefinedPropertyType().stream().filter(obj -> obj.getName().equals(PROPERTY_TYPENAME)).findFirst();
        org.modelio.metamodel.uml.infrastructure.properties.PropertyType mPropertyType = null;
        if (strProp.isPresent()) {
            mPropertyType = strProp.get();
        } else {
            mPropertyType = this.baseFactory.create(org.modelio.metamodel.uml.infrastructure.properties.PropertyType.class, element);
            mPropertyType.setModuleOwner(localModule);
            mPropertyType.setBaseType(PropertyBaseType.STRING);
            mPropertyType.setName(PROPERTY_TYPENAME);
        }

        for (PropertyType pType : properties.getProperty()) {
            PropertyDefinitionType definition = (PropertyDefinitionType) pType.getPropertyDefinitionRef();
            if (tableDef.getOwned().stream().filter(obj -> obj.getName().equals(getInternationalisedString(definition.getNameGroup()))).count() == 0) {
                PropertyDefinition newType = this.baseFactory.create(PropertyDefinition.class, element);
                newType.setName(getInternationalisedString(definition.getNameGroup()));
                newType.setOwner(tableDef);
                newType.setIsEditable(true);
                newType.setType(mPropertyType);

                updateDocumentation(newType, definition);

            }
        }
        return tableDef;
    }

    @objid ("1d2e1750-e5fe-445d-8bdc-331ba218aa9b")
    private static <T extends MObject, U> U findFirstModifiable(Collection<T> input, Class<U> requested, String name) {
        for (T t : input) {
            if (requested.isInstance(t) && t.getStatus().isModifiable())
                if (name==null || name.equals(t.getName()))
                    return requested.cast(t);
        }
        return null;
    }

    @objid ("bd26e053-d731-4a6e-98c4-355c30658287")
    private class Organization {
        @objid ("6c0ec16c-cb11-45df-9b4f-9a950f76f23d")
        public MObject element;

        @objid ("ea0b3a80-f873-4ab2-8e45-f470635e165c")
        public List<OrganizationType> hierarchy;

        @objid ("dbf67b55-03b3-49f5-a8f1-7180434467cc")
        public Organization(MObject element, List<OrganizationType> hierarchy) {
            this.element = element;
            this.hierarchy = hierarchy;
        }

    }

}
