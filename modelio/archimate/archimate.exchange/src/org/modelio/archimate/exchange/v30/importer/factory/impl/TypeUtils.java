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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.exchange.v30.xmlmodel.Diagram;
import org.modelio.archimate.exchange.v30.xmlmodel.ModelType;
import org.modelio.archimate.exchange.v30.xmlmodel.RelationshipType;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
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
import org.modelio.vcore.session.api.ICoreSession;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("ab040b66-4f26-4fec-8e6b-e4145167e6c3")
public class TypeUtils {
    @objid ("51048199-d3f7-4ffb-a5e2-fc39dff959d0")
    public static Class<? extends MObject> getModelioType(Object jaxElement, ICoreSession session) {
        Class<? extends MObject> result = null;

        if (jaxElement instanceof ModelType) {
            result = Model.class;
        } else if (jaxElement instanceof Diagram) {
            result = ArchimateView.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationCollaboration) {
            result = ApplicationCollaboration.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationComponent) {
            result = ApplicationComponent.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationEvent) {
            result = ApplicationEvent.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationFunction) {
            result = ApplicationFunction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationInteraction) {
            result = ApplicationInteraction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationInterface) {
            result = ApplicationInterface.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationService) {
            result = ApplicationService.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ApplicationProcess) {
            result = ApplicationProcess.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Artifact) {
            result = Artifact.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Assessment) {
            result = Assessment.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessActor) {
            result = BusinessActor.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessCollaboration) {
            result = BusinessCollaboration.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessEvent) {
            result = BusinessEvent.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessFunction) {
            result = BusinessFunction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessInteraction) {
            result = BusinessInteraction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessInterface) {
            result = BusinessInterface.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessObject) {
            result = BusinessObject.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessProcess) {
            result = BusinessProcess.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessRole) {
            result = BusinessRole.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.BusinessService) {
            result = BusinessService.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Capability) {
            result = Capability.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.CommunicationNetwork) {
            result = CommunicationNetwork.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Constraint) {
            result = Constraint.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Contract) {
            result = Contract.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.CourseOfAction) {
            result = CourseOfAction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.DataObject) {
            result = DataObject.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Deliverable) {
            result = Deliverable.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Device) {
            result = Device.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.DistributionNetwork) {
            result = DistributionNetwork.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Driver) {
            result = Driver.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Equipment) {
            result = Equipment.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Facility) {
            result = Facility.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Gap) {
            result = Gap.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Goal) {
            result = Goal.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Grouping) {
            result = Grouping.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.ImplementationEvent) {
            result = ImplementationEvent.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.AndJunction) {
            result = AndJunction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Location) {
            result = Location.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Material) {
            result = Material.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Meaning) {
            result = Meaning.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Node) {
            result = Node.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.OrJunction) {
            result = OrJunction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Outcome) {
            result = Outcome.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Path) {
            result = Path.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Plateau) {
            result = Plateau.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Principle) {
            result = Principle.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Product) {
            result = Product.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Representation) {
            result = Representation.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Resource) {
            result = Resource.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Stakeholder) {
            result = Stakeholder.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.SystemSoftware) {
            result = SystemSoftware.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyCollaboration) {
            result = TechnologyCollaboration.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyEvent) {
            result = TechnologyEvent.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyFunction) {
            result = TechnologyFunction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyInteraction) {
            result = TechnologyInteraction.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyInterface) {
            result = TechnologyInterface.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyProcess) {
            result = TechnologyProcess.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.TechnologyService) {
            result = TechnologyService.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Value) {
            result = Value.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.WorkPackage) {
            result = WorkPackage.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Requirement) {
            result = Requirement.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Access) {
            result = Access.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Realization) {
            result = Realization.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Assignment) {
            result = Assignment.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Aggregation) {
            result = Aggregation.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Composition) {
            result = Composition.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Influence) {
            result = Influence.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Serving) {
            result = Serving.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Triggering) {
            result = Triggering.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Flow) {
            result = Flow.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Specialization) {
            result = Specialization.class;
        } else if (jaxElement instanceof org.modelio.archimate.exchange.v30.xmlmodel.Association) {
            result = Association.class;
        }

        MClass mElement = session.getMetamodel().getMClass(result);
        {
            if (session.getMetamodel().getMExpert().isLink(mElement)) {
                RelationshipType jaxRelation = (RelationshipType) jaxElement;
                if(jaxRelation.getSource() != null && jaxRelation.getTarget() != null) {
                    if (!TypeUtils.isValideRelation(mElement, jaxElement, session)) {
                        return org.modelio.archimate.metamodel.relationships.other.Association.class;
                    }
                }
            }
        }
        return result;
    }

    @objid ("ff381a54-44b6-4ed1-8b61-27782c40e95b")
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

    @objid ("9f087ec9-fd9e-4485-8b24-a53b7a96a2b4")
    private static boolean isValideRelation(MClass modelioRelation, Object jaxElement, ICoreSession session) {
        RelationshipType jaxRelation = (RelationshipType) jaxElement;

        MClass source = session.getMetamodel().getMClass(TypeUtils.getModelioType(jaxRelation.getSource(), session));
        MClass target = session.getMetamodel().getMClass(TypeUtils.getModelioType(jaxRelation.getTarget(), session));
        return session.getMetamodel().getMExpert().canLink(modelioRelation, source, target);
    }

}
