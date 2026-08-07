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
package org.modelio.archimate.exchange.v30.importer.factory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v30.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v30.xmlmodel.Access;
import org.modelio.archimate.exchange.v30.xmlmodel.AccessTypeEnum;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v30.xmlmodel.Influence;
import org.modelio.archimate.exchange.v30.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v30.xmlmodel.OrganizationsType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertiesType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertyDefinitionType;
import org.modelio.archimate.exchange.v30.xmlmodel.PropertyType;
import org.modelio.archimate.exchange.v30.xmlmodel.ReferenceableType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.vcommon.importer.AbstractElementFactoryImport;
import org.modelio.archimate.exchange.vcommon.importer.PrimitiveTypeImport;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
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

@objid ("cba9c9c5-3a1c-41fd-b93e-9a9e98b708ac")
public class ElementFactoryImport extends AbstractElementFactoryImport implements IElementFactoryImport {
    @objid ("5a5f7829-c6de-4fdb-a48b-319379f8dac9")
    private static final String PROPERTY_TABLENAME = "archimate";

    @objid ("2724c078-5ece-4415-a693-389ff80a3011")
    private static final String PROPERTY_TYPENAME = "ArchimateDefaultType";

    @objid ("8c1bff46-12ea-4984-a96c-e1edc3607cb0")
    private static final String PROFILENAME = "Archimate";

    @objid ("ac6cebca-968c-4a67-9150-6dd94bf93d1a")
    private static final String MODULENAME = "ArchimateTypes";

    @objid ("d0dbfa6d-f23b-46e6-b2e9-523691139cf8")
    private static final String ARCHIMATE_ELEMENT = "Archimate.Element";

    @objid ("196e84b6-4144-46a7-9e85-f5a6f06e9b6a")
    private Model model;

    @objid ("604750a6-75ed-4b9b-b34f-17f3e5774bbd")
    public ElementFactoryImport(ICoreSession session, ArchimateProject context, boolean keepId, boolean isUpdate) {
        super(session, context, keepId,isUpdate);
        this.refs = new HashMap<>();
    }

    @objid ("f18dd3da-1d25-43ca-ad53-71e626a7e71d")
    @Override
    public ModelElement createElement(String identifier, Object jaxElement) {
        Class<? extends MObject> type = TypeUtils.getModelioType(jaxElement, this.session);
        return createElement(identifier, type);
    }

    @objid ("03005c15-aeff-453a-9b99-fefd5cf377eb")
    private void updateDocumentation(ModelElement element, ReferenceableType jaxElement) {
        String description = getInternationalisedString(jaxElement.getDocumentation());
        if (description != null) {
            element.putNoteContent(this.descNoteType, description);
        }
    }

    @objid ("2659ad96-28ce-4a15-8142-108ac5915353")
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

    @objid ("1e4ba5f6-b507-4adb-8cd5-3388987ea227")
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

    @objid ("d14e114d-4103-446b-9c40-7371bd990785")
    private PropertyTableDefinition getPropertyTableDefinition(ModelElement element, String id) {
        PropertyTableDefinition result = findPropertyTable(id);
        if (result == null) {
            return createArchimatePropertyTableDefinition(element);
        }else {
            return result;
        }
    }

    @objid ("bfa75ede-02a5-40f7-85f7-ce85b3069a25")
    public final PropertyTableDefinition findPropertyTable(String identifier) {
        PropertyTableDefinition result = this.session.getModel().findById(PropertyTableDefinition.class, IDUtils.importId(identifier));

        if (result != null) {
            this.refs.put(IDUtils.importId(identifier), result);
        }
        return result;
    }

    @objid ("76c0c89a-44d6-4031-bd12-1199f003a512")
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

    @objid ("cbf20c69-ecc1-4208-9eb5-0759c2091ae9")
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

    @objid ("153c05d0-d71b-4e10-9449-eb2c6f3a61ae")
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

    @objid ("ff8cc6e9-ac27-4d1e-838e-b8ed95c36191")
    @Override
    public void createOrganization(OrganizationsType jaxOrg, Model aModel) {
        for (OrganizationType jaxItem : jaxOrg.getItem()) {
            createStructuralElement(aModel, jaxItem);
        }
    }

    @objid ("a3fe9b03-ec8a-4fee-90e9-8ef75c3d9072")
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

    @objid ("66fd95b8-be50-428e-b7a9-69ae6555779a")
    private void createStructure(MObject owner, Organization organization) {
        if (organization.element instanceof Concept) {
            Concept concept = (Concept) organization.element;
            Folder folder = TypeUtils.getOwnerFolder(concept, this.model);

            String firstLabel = getInternationalisedString(organization.hierarchy.get(0).getLabelGroup());
            if (folder.getName().equals(firstLabel)) {
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
                    viewPoint = newViewPoint;
                } else {
                    viewPoint = existingViewPoint;
                }
            }

            ViewPoint origin = (ViewPoint) view.getOrigin();
            view.setOrigin(viewPoint);
            if (origin.getProduct().size() == 0) {
                origin.delete();
            }
        }
    }

    @objid ("969897b8-2d7c-4a28-936d-921546668cc2")
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

    @objid ("b8e31dd5-569d-4cff-97a0-5f2e51323f7a")
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

    @objid ("50b3dfd3-3093-4371-bc93-bd5d5a448e2c")
    private Folder findFolder(Folder folder, OrganizationType item) {
        for (Folder subFolder : folder.getFolder()) {
            String label = getInternationalisedString(item.getLabelGroup());
            if (subFolder.getName().equals(label) || subFolder.getUuid().equals(item.getIdentifier())) {
                return subFolder;
            }
        }
        return null;
    }

    @objid ("9e61bd83-37cb-4a68-ab95-12b7162f7727")
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

    @objid ("5125f473-6e52-4ff7-a052-be2631058822")
    private PropertyTableDefinition createPropertyTableDefinition(ModelElement element, PropertiesType properties) {
        IGModelFragment fragment = AbstractGProject.getProject(this.session).getFragment(element);

        Optional<MObject> strObj = fragment.getRoots().stream().filter(obj -> obj instanceof ModuleComponent).findFirst();
        ModuleComponent localModule = null;
        if (strObj.isPresent()) {
            localModule = (ModuleComponent) strObj.get();
        } else {
            localModule = this.baseFactory.create(ModuleComponent.class, element);
            fragment.getRoots().add(localModule);
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

    @objid ("2fd37c94-5471-47aa-acd6-dec470899352")
    private static <T extends MObject, U> U findFirstModifiable(Collection<T> input, Class<U> requested, String name) {
        for (T t : input) {
            if (requested.isInstance(t) && t.getStatus().isModifiable())
                if (name==null || name.equals(t.getName()))
                    return requested.cast(t);
        }
        return null;
    }

    @objid ("202d0591-1074-432a-873d-28c8c99cee57")
    private class Organization {
        @objid ("4f9e230c-45bd-4c58-932c-2dc45f7acf51")
        public MObject element;

        @objid ("dc9b45b5-c481-434d-9ff8-e3f7658d975c")
        public List<OrganizationType> hierarchy;

        @objid ("a47213dd-39ba-4f3a-982f-986c4c11eeab")
        public Organization(MObject element, List<OrganizationType> hierarchy) {
            this.element = element;
            this.hierarchy = hierarchy;
        }

    }

}
