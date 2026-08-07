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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v21.xmlmodel.AccessRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.AggregationRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationCollaboration;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationComponent;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationFunction;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationInteraction;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationInterface;
import org.modelio.archimate.exchange.v21.xmlmodel.ApplicationService;
import org.modelio.archimate.exchange.v21.xmlmodel.Artifact;
import org.modelio.archimate.exchange.v21.xmlmodel.Assessment;
import org.modelio.archimate.exchange.v21.xmlmodel.AssignmentRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.AssociationRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessActor;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessCollaboration;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessEvent;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessFunction;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessInteraction;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessInterface;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessObject;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessProcess;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessRole;
import org.modelio.archimate.exchange.v21.xmlmodel.BusinessService;
import org.modelio.archimate.exchange.v21.xmlmodel.CommunicationPath;
import org.modelio.archimate.exchange.v21.xmlmodel.CompositionRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.Constraint;
import org.modelio.archimate.exchange.v21.xmlmodel.Contract;
import org.modelio.archimate.exchange.v21.xmlmodel.DataObject;
import org.modelio.archimate.exchange.v21.xmlmodel.Deliverable;
import org.modelio.archimate.exchange.v21.xmlmodel.Device;
import org.modelio.archimate.exchange.v21.xmlmodel.Driver;
import org.modelio.archimate.exchange.v21.xmlmodel.FlowRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.Gap;
import org.modelio.archimate.exchange.v21.xmlmodel.Goal;
import org.modelio.archimate.exchange.v21.xmlmodel.InfluenceRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.InfrastructureFunction;
import org.modelio.archimate.exchange.v21.xmlmodel.InfrastructureInterface;
import org.modelio.archimate.exchange.v21.xmlmodel.InfrastructureService;
import org.modelio.archimate.exchange.v21.xmlmodel.Junction;
import org.modelio.archimate.exchange.v21.xmlmodel.Location;
import org.modelio.archimate.exchange.v21.xmlmodel.Meaning;
import org.modelio.archimate.exchange.v21.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v21.xmlmodel.Network;
import org.modelio.archimate.exchange.v21.xmlmodel.Node;
import org.modelio.archimate.exchange.v21.xmlmodel.Plateau;
import org.modelio.archimate.exchange.v21.xmlmodel.Principle;
import org.modelio.archimate.exchange.v21.xmlmodel.Product;
import org.modelio.archimate.exchange.v21.xmlmodel.RealisationRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.RelationshipType;
import org.modelio.archimate.exchange.v21.xmlmodel.Representation;
import org.modelio.archimate.exchange.v21.xmlmodel.Requirement;
import org.modelio.archimate.exchange.v21.xmlmodel.SpecialisationRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.Stakeholder;
import org.modelio.archimate.exchange.v21.xmlmodel.SystemSoftware;
import org.modelio.archimate.exchange.v21.xmlmodel.TriggeringRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.UsedByRelationship;
import org.modelio.archimate.exchange.v21.xmlmodel.Value;
import org.modelio.archimate.exchange.v21.xmlmodel.ViewType;
import org.modelio.archimate.exchange.v21.xmlmodel.WorkPackage;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
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
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("826df0f2-72ba-4565-8f4d-035564274ab0")
public class TypeUtils {
    @objid ("b7ca06e9-24a7-4db9-8c6e-8572127d3669")
    public static Class<? extends MObject> getModelioType(Object jaxElement, ICoreSession session) {
        Class<? extends MObject> result = null;
        if (jaxElement instanceof ModelType) {
             result =  Model.class;
        } else if (jaxElement instanceof ViewType) {
             result =  ArchimateView.class;
        } else if (jaxElement instanceof AccessRelationship) {
             result =  Access.class;
        } else if (jaxElement instanceof AggregationRelationship) {
             result =  Aggregation.class;
        } else if (jaxElement instanceof ApplicationCollaboration) {
             result =  org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration.class;
        } else if (jaxElement instanceof ApplicationComponent) {
             result =  org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent.class;
        } else if (jaxElement instanceof ApplicationFunction) {
             result =  org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction.class;
        } else if (jaxElement instanceof ApplicationInteraction) {
             result =  org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction.class;
        } else if (jaxElement instanceof ApplicationInterface) {
             result =  org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface.class;
        } else if (jaxElement instanceof ApplicationService) {
             result =  org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService.class;
        } else if (jaxElement instanceof Artifact) {
             result =  org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact.class;
        } else if (jaxElement instanceof Assessment) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Assessment.class;
        } else if (jaxElement instanceof AssignmentRelationship) {
             result =  Assignment.class;
        } else if (jaxElement instanceof AssociationRelationship) {
             result =  Association.class;
        } else if (jaxElement instanceof BusinessActor) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.active.BusinessActor.class;
        } else if (jaxElement instanceof BusinessCollaboration) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.active.BusinessCollaboration.class;
        } else if (jaxElement instanceof BusinessEvent) {
             result =  org.modelio.archimate.metamodel.layers.business.behavior.BusinessEvent.class;
        } else if (jaxElement instanceof BusinessFunction) {
             result =  org.modelio.archimate.metamodel.layers.business.behavior.BusinessFunction.class;
        } else if (jaxElement instanceof BusinessInteraction) {
             result =  org.modelio.archimate.metamodel.layers.business.behavior.BusinessInteraction.class;
        } else if (jaxElement instanceof BusinessInterface) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.active.BusinessInterface.class;
        } else if (jaxElement instanceof BusinessObject) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.passive.BusinessObject.class;
        } else if (jaxElement instanceof BusinessProcess) {
             result =  org.modelio.archimate.metamodel.layers.business.behavior.BusinessProcess.class;
        } else if (jaxElement instanceof BusinessRole) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.active.BusinessRole.class;
        } else if (jaxElement instanceof BusinessService) {
             result =  org.modelio.archimate.metamodel.layers.business.behavior.BusinessService.class;
        } else if (jaxElement instanceof CommunicationPath) {
             result =  Path.class;
        } else if (jaxElement instanceof CompositionRelationship) {
             result =  Composition.class;
        } else if (jaxElement instanceof Constraint) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Constraint.class;
        } else if (jaxElement instanceof Contract) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.passive.Contract.class;
        } else if (jaxElement instanceof DataObject) {
             result =  org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject.class;
        } else if (jaxElement instanceof Deliverable) {
             result =  org.modelio.archimate.metamodel.layers.implementation_and_migration.Deliverable.class;
        } else if (jaxElement instanceof Device) {
             result =  org.modelio.archimate.metamodel.layers.technology.structure.active.Device.class;
        } else if (jaxElement instanceof Driver) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Driver.class;
        } else if (jaxElement instanceof FlowRelationship) {
             result =  Flow.class;
        } else if (jaxElement instanceof Gap) {
             result =  org.modelio.archimate.metamodel.layers.implementation_and_migration.Gap.class;
        } else if (jaxElement instanceof Goal) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Goal.class;
        } else if (jaxElement instanceof InfluenceRelationship) {
             result =  Influence.class;
        } else if (jaxElement instanceof InfrastructureFunction) {
             result =  TechnologyFunction.class;
        } else if (jaxElement instanceof InfrastructureInterface) {
             result =  TechnologyInterface.class;
        } else if (jaxElement instanceof InfrastructureService) {
             result =  TechnologyService.class;
        } else if (jaxElement instanceof Junction) {
             result =  org.modelio.archimate.metamodel.relationships.other.AndJunction.class;
        } else if (jaxElement instanceof Location) {
             result =  org.modelio.archimate.metamodel.core.generic.composite.Location.class;
        } else if (jaxElement instanceof Meaning) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Meaning.class;
        } else if (jaxElement instanceof Network) {
             result =  CommunicationNetwork.class;
        } else if (jaxElement instanceof Node) {
             result =  org.modelio.archimate.metamodel.layers.technology.structure.active.Node.class;
        } else if (jaxElement instanceof Plateau) {
             result =  org.modelio.archimate.metamodel.layers.implementation_and_migration.Plateau.class;
        } else if (jaxElement instanceof Principle) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Principle.class;
        } else if (jaxElement instanceof Product) {
             result =  org.modelio.archimate.metamodel.layers.business.composite.Product.class;
        } else if (jaxElement instanceof RealisationRelationship) {
             result =  Realization.class;
        } else if (jaxElement instanceof Representation) {
             result =  org.modelio.archimate.metamodel.layers.business.structure.passive.Representation.class;
        } else if (jaxElement instanceof Requirement) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Requirement.class;
        } else if (jaxElement instanceof SpecialisationRelationship) {
             result =  Specialization.class;
        } else if (jaxElement instanceof Stakeholder) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Stakeholder.class;
        } else if (jaxElement instanceof SystemSoftware) {
             result =  org.modelio.archimate.metamodel.layers.technology.structure.active.SystemSoftware.class;
        } else if (jaxElement instanceof TriggeringRelationship) {
             result =  Triggering.class;
        } else if (jaxElement instanceof UsedByRelationship) {
             result =  Serving.class;
        } else if (jaxElement instanceof Value) {
             result =  org.modelio.archimate.metamodel.layers.motivation.Value.class;
        } else if (jaxElement instanceof WorkPackage) {
             result =  org.modelio.archimate.metamodel.layers.implementation_and_migration.WorkPackage.class;
        }

        MClass mElement = session.getMetamodel().getMClass(result);{
            if(session.getMetamodel().getMExpert().isLink(mElement)){
                if(!isValideRelation(mElement,jaxElement,session)){
                    return org.modelio.archimate.metamodel.relationships.other.Association.class;
                }
            }
        }
        return result;
    }

    @objid ("ddcf1259-43c9-411b-a39a-e1b1f7567383")
    public static Folder getOwnerFolder(Concept concept, Model model) {
        Folder businessLayer = null;
        Folder applicatinoLayer = null;
        Folder technologyLayer = null;
        Folder motivationLayer = null;
        Folder implementationLayer = null;
        Folder physicalLayer = null;
        Folder strategyLayer = null;

        for (Folder folder : model.getFolder()) {
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

        if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.application.")) {
            return applicatinoLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.technology.")) {
            return technologyLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.motivation.")) {
            return motivationLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.business.")) {
            return businessLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.strategy.")) {
            return strategyLayer;
        } else if (concept.getClass().getName().startsWith("org.modelio.archimate.metamodel.impl.layers.physical.")) {
            return physicalLayer;
        } else if (concept.getClass().getName()
                .startsWith("org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.")) {
            return implementationLayer;
        }
        return model;
    }

    @objid ("da69b31e-fcb9-4201-95cf-e6ac5a366566")
    private static boolean isValideRelation(MClass modelioRelation, Object jaxElement, ICoreSession session) {
        RelationshipType jaxRelation = (RelationshipType)jaxElement;

        MClass source =  session.getMetamodel().getMClass(getModelioType(jaxRelation.getSource(),session));
        MClass target = session.getMetamodel().getMClass(getModelioType(jaxRelation.getTarget(),session));
        return session.getMetamodel().getMExpert().canLink(modelioRelation, source, target);
    }

}
