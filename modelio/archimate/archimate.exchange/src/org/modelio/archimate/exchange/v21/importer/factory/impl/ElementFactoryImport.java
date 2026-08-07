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
package org.modelio.archimate.exchange.v21.importer.factory.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.plugin.ArchiExchange;
import org.modelio.archimate.exchange.service.utils.IDUtils;
import org.modelio.archimate.exchange.v21.importer.factory.IElementFactoryImport;
import org.modelio.archimate.exchange.v21.xmlmodel.ElementType;
import org.modelio.archimate.exchange.v21.xmlmodel.ItemType;
import org.modelio.archimate.exchange.v21.xmlmodel.LangStringType;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v21.xmlmodel.OrganizationType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertiesType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertyDefinitionType;
import org.modelio.archimate.exchange.v21.xmlmodel.PropertyType;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
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
import org.modelio.gproject.core.IGModelFragment;
import org.modelio.gproject.project.AbstractGProject;
import org.modelio.metamodel.mda.ModuleComponent;
import org.modelio.metamodel.uml.infrastructure.MetaclassReference;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Profile;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTable;
import org.modelio.metamodel.uml.infrastructure.properties.PropertyTableDefinition;
import org.modelio.metamodel.uml.infrastructure.properties.TypedPropertyTable;
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("9e5bf740-711c-488b-843a-907c4a2e4e66")
public class ElementFactoryImport extends AbstractElementFactoryImport implements IElementFactoryImport {
    @objid ("6c82bc0e-cf19-4594-8c92-74356a111f4f")
    private static final String PROPERTY_TABLENAME = "archimate";

    @objid ("673c0613-5cfb-473a-94b2-5d5e31d177d8")
    private static final String PROPERTY_TYPENAME = "ArchimateDefaultType";

    @objid ("4f977dd3-8dc5-4a7e-a743-68c69f9ba358")
    private static final String PROFILENAME = "Archimate";

    @objid ("62e4ba1c-660f-4227-9d38-238f8556084b")
    private static final String MODULENAME = "ArchimateTypes";

    @objid ("d783324a-c083-4bb2-9bf7-cdf5c77089c6")
    private static final String ARCHIMATE_ELEMENT = "Archimate.Element";

    @objid ("bffc3a9e-2bfa-4257-8063-a1913ea9f3f7")
    private Model model;

    @objid ("bac50056-8c0c-411f-8f2f-2af081943fa9")
    public ElementFactoryImport(ICoreSession session, ArchimateProject context, boolean keepId, boolean isUpdate) {
        super(session, context, keepId,isUpdate);
        this.refs = new HashMap<>();
    }

    @objid ("8e0aa01b-8c58-4f07-adda-9cfea19c494e")
    private void updateDocumentation(ModelElement element, ModelType jaxElement) {
        updateDocumentation(element, jaxElement.getDocumentation());
    }

    @objid ("55a9c435-03cc-426c-a7c7-1544f6b3946d")
    private void updateDocumentation(ModelElement element, ElementType jaxElement) {
        updateDocumentation(element, jaxElement.getDocumentation());
    }

    @objid ("3af60b1d-943d-457e-b1e7-75d6fae66558")
    private void updateDocumentation(ModelElement element, List<LangStringType> jaxDocs) {
        String description = getInternationalisedString(jaxDocs);
        if (description != null) {
            element.putNoteContent(this.descNoteType, description);
        }
    }

    @objid ("33e05a3f-23a3-47ce-a372-7f8ec5db73d2")
    @Override
    public ModelElement createElement(String identifier, Object jaxElement) {
        Class<? extends MObject> type = TypeUtils.getModelioType(jaxElement,this.session);
        ModelElement result = null;
        if (this.keepId) {
            result = (ModelElement) this.baseFactory.createWithId(type, this.context, IDUtils.importId(identifier));
        } else {
            result = (ModelElement) this.baseFactory.create(type, this.context);
        }

        this.refs.put(IDUtils.importId(identifier), result);
        return result;
    }

    @objid ("d1aa7084-f462-4f4c-87a5-62058466e27e")
    @Override
    public ModelElement updateElement(ModelElement element, Object jaxObject) {
        if (jaxObject instanceof ModelType) {
            ModelType jaxModel = (ModelType) jaxObject;
            this.model = (Model) element;
            this.model.setProject(this.context);

            String label = getInternationalisedString(jaxModel.getName());
            if (label != null) {
                this.model.setName(label);
            }

            updateDocumentation(element, jaxModel);

            createProperties(element, jaxModel.getProperties());

            createFolders();
            return this.model;
        } else if (jaxObject instanceof ElementType) {
            ElementType jaxElement = (ElementType) jaxObject;
            Concept concept = (Concept) element;

            concept.setOwnerFolder(TypeUtils.getOwnerFolder(concept, this.model));

            String label = getInternationalisedString(jaxElement.getLabel());
            if (label != null) {
                element.setName(label);
            }

            updateDocumentation(element, jaxElement);

            createProperties(element, jaxElement.getProperties());
            return concept;
        } else if (jaxObject instanceof RelationshipType) {
            RelationshipType jaxRelation = (RelationshipType) jaxObject;
            Relationship relation = (Relationship) element;

            String label = getInternationalisedString(jaxRelation.getLabel());
            if (label != null) {
                relation.setName(label);
            }

            updateDocumentation(element, jaxRelation.getDocumentation());

            ElementType jaxSource = (ElementType) jaxRelation.getSource();
            ElementType jaxTarget = (ElementType) jaxRelation.getTarget();
            if (jaxSource != null && jaxTarget != null) {
                Concept source = (Concept) this.refs.get(IDUtils.importId(jaxSource.getIdentifier()));
                Concept target = (Concept) this.refs.get(IDUtils.importId(jaxTarget.getIdentifier()));
                relation.setFrom(source);
                relation.setTo(target);
                createProperties(element, jaxRelation.getProperties());
            } else {
                element.delete();
            }

            return relation;
        } else if (jaxObject instanceof ViewType) {
            ViewType jaxView = (ViewType) jaxObject;
            ArchimateView view = (ArchimateView) element;

            String label = getInternationalisedString(jaxView.getLabel());
            if (label != null) {
                view.setName(label);
            }

            updateDocumentation(element, jaxView.getDocumentation());

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
            return view;
        }
        return null;
    }

    @objid ("2d9a81e1-0178-47fe-a8cd-7ca759de8702")
    private void createProperties(ModelElement element, PropertiesType properties) {
        if (properties != null) {

            PrimitiveTypeImport typeImport = new PrimitiveTypeImport(this.session.getModel());

            for(PropertyType propType : properties.getProperty()){

                //Get associated PropertyTableDefinition
                PropertyTableDefinition tableDef = null;

                Object obj = propType.getIdentifierref();

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

                    String propName = IDUtils.getPropName(propDefType.getName());
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

    @objid ("3ecb6169-96d5-4f22-a74a-3cbac8840dc5")
    private PropertyTableDefinition getPropertyTableDefinition(ModelElement element, String id) {
        PropertyTableDefinition result = findPropertyTable(id);
        if (result == null) {
            return createArchimatePropertyTableDefinition(element);
        }else {
            return result;
        }
    }

    @objid ("73108959-801b-44df-8bd1-4a7fd11aeee3")
    public final PropertyTableDefinition findPropertyTable(String identifier) {
        PropertyTableDefinition result = this.session.getModel().findById(PropertyTableDefinition.class, IDUtils.importId(identifier));

        if (result != null) {
            this.refs.put(IDUtils.importId(identifier), result);
        }
        return result;
    }

    @objid ("424ae687-1b0c-4fd3-96eb-027edd47516e")
    private static <T extends MObject, U> U findFirstModifiable(Collection<T> input, Class<U> requested, String name) {
        for (T t : input) {
            if (requested.isInstance(t) && t.getStatus().isModifiable())
                if (name==null || name.equals(t.getName()))
                    return requested.cast(t);
        }
        return null;
    }

    @objid ("3a87054c-66fa-4f1d-bec3-2a09fc6297e1")
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

    @objid ("bd102c17-28da-4202-8e0d-5a0b63f437aa")
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

    @objid ("b3fa0159-90f0-4ae4-9a66-057851b16378")
    private String getInternationalisedString(List<LangStringType> labels) {
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

    @objid ("cb85e90a-d37f-45c1-9f24-0246f45b12bb")
    @Override
    public void createOrganization(OrganizationType jaxOrg, Model aModel) {
        for (ItemType jaxItem : jaxOrg.getItem()) {
            createStructuralElement(aModel, jaxItem);
        }
    }

    @objid ("04214a39-3a0f-48e4-9045-49b619215640")
    private Object createStructuralElement(Model aModel, ItemType jaxItem) {
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

    @objid ("e86e8fe1-db38-442a-88ad-a58dd10ffbf6")
    private void createStructure(MObject owner, Organization organization) {
        if (organization.element instanceof Concept) {
            Concept concept = (Concept) organization.element;
            Folder folder = TypeUtils.getOwnerFolder(concept, this.model);

            String firstLabel = getInternationalisedString(organization.hierarchy.get(0).getLabel());
            if (folder.getName().equals(firstLabel)) {
                organization.hierarchy.remove(0);
            }

            for (ItemType item : organization.hierarchy) {
                Folder newFloder = findFolder(folder, item);
                if (newFloder == null && folder instanceof Model) {
                    break;
                } else {
                    if (newFloder == null) {
                        newFloder = createSubFolder(folder);
                        String label = getInternationalisedString(item.getLabel());
                        if (label != null)
                            newFloder.setName(label);
                    }
                    folder = newFloder;
                    updateDocumentation(newFloder, item.getDocumentation());
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
                String label = getInternationalisedString(organization.hierarchy.get(0).getLabel());
                viewPoint.setName(label);
                viewPoint.setContext(this.model);
                viewPoint.setProject(this.model.getProject());
                organization.hierarchy.remove(0);
            }

            for (ItemType item : organization.hierarchy) {
                ViewPoint existingViewPoint = findViewPoint(viewPoint, item);
                if (existingViewPoint == null) {
                    ViewPoint newViewPoint = this.baseFactory.create(ViewPoint.class, this.context);
                    String label = getInternationalisedString(item.getLabel());
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

    @objid ("e4cd321a-e25a-42dd-ae96-084ba7a781fb")
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

    @objid ("2dd1be1b-9d74-4d82-9d81-ad1d4cd21bf7")
    private ViewPoint findViewPoint(MObject owner, ItemType item) {
        List<ViewPoint> viewPoints = null;
        if (owner instanceof ViewPoint) {
            viewPoints = ((ViewPoint) owner).getChild();
        } else if (owner instanceof Model) {
            viewPoints = ((Model) owner).getReferencedBy();
        }

        if (viewPoints != null) {
            for (ViewPoint subViewPoint : viewPoints) {
                String label = getInternationalisedString(item.getLabel());
                if (subViewPoint.getName().equals(label) || subViewPoint.getUuid().equals(item.getIdentifier())) {
                    return subViewPoint;
                }
            }
        }
        return null;
    }

    @objid ("5ee2565e-0ff1-4a9c-876c-794362fd6c7e")
    private Folder findFolder(Folder folder, ItemType item) {
        for (Folder subFolder : folder.getFolder()) {
            String label = getInternationalisedString(item.getLabel());
            if (subFolder.getName().equals(label) || subFolder.getUuid().equals(item.getIdentifier())) {
                return subFolder;
            }
        }
        return null;
    }

    @objid ("034324f1-ef5f-42a1-a765-80fb23a9aa5e")
    private List<Organization> findOrganizations(ItemType jaxItem) {
        List<Organization> result = new ArrayList<>();
        if (jaxItem.getIdentifierref() instanceof ViewType) {
            result.add(new Organization(this.refs.get(IDUtils.importId(((ViewType) jaxItem.getIdentifierref()).getIdentifier())),
                    new ArrayList<>()));
        } else if (jaxItem.getIdentifierref() instanceof ElementType) {
            result.add(new Organization(this.refs.get(IDUtils.importId(((ElementType) jaxItem.getIdentifierref()).getIdentifier())),
                    new ArrayList<>()));
        } else if (jaxItem.getLabel().size() > 0) {
            for (ItemType jaxSubItem : jaxItem.getItem()) {
                List<Organization> subResults = findOrganizations(jaxSubItem);
                for (Organization subResult : subResults) {
                    subResult.hierarchy.add(0, jaxItem);
                }
                result.addAll(subResults);
            }
        }
        return result;
    }

    @objid ("adee35fe-74e3-40be-9f35-264806a86331")
    private class Organization {
        @objid ("7d1d33a7-654d-4e5d-a2f5-614b0f2d4d09")
        public List<ItemType> hierarchy;

        @objid ("f071b40e-2210-4d29-93be-7dcfe3f83626")
        public MObject element;

        @objid ("ab4fdd72-1695-4d17-81b5-70bc0546a0b6")
        public Organization(MObject element, List<ItemType> hierarchy) {
            this.element = element;
            this.hierarchy = hierarchy;
        }

    }

}
