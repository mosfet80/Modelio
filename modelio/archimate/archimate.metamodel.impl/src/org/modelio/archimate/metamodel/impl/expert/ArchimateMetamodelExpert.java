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
package org.modelio.archimate.metamodel.impl.expert;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
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
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.archimate.metamodel.layers.application.structure.passive.DataObject;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;
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
import org.modelio.archimate.metamodel.layers.technology.behavior.TechnologyInternalBehaviorElement;
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
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;

/**
 * Archimate complete metamodel expert.
 * <p>
 * This expert derives from the expert generated by SemGen and adds customs experts.
 *
 * @author cmarin
 */
@objid ("d9cf39f1-fbcf-485e-ad4b-c23a83529d5c")
public class ArchimateMetamodelExpert extends ArchimateCSVGeneratedMetamodelExpert {
    /**
     *
     * @param mm the metamodel.
     */
    @objid ("a22ecd3f-af93-450e-9f80-c69250f349e7")
    public ArchimateMetamodelExpert(MMetamodel mm) {
        super(mm);

        register();

    }

    @objid ("06a1f36c-e241-427c-90be-2d018b27aa84")
    @Override
    public void register() {
        // Call generated code
        super.register();

        MMetamodel mm = this.metamodel;

        // expert for all relationships
        RelationShipLinkExpertAdapter relationsExpert = new RelationShipLinkExpertAdapter(this.ruleLinkExpert, mm);
        for (MClass mc : mm.getMClass(Relationship.class).getSub(true)) {
            addLinkExpert(mc, relationsExpert);
        }

        // expert for Association
        addLinkExpert(mm.getMClass(Association.class), new RelationShipLinkExpertAdapter(new AssociationLinkExpert(this.ruleLinkExpert, mm),mm));

    }

    @objid ("fdb6bb0d-ccc8-439b-8714-5167e1fc8d0c")
    @Override
    protected void registerLinkExpertForAggregation() {
        super.registerLinkExpertForAggregation();
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Grouping.class);
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Plateau.class);
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, false,Relationship.class,true);
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, false,Relationship.class,true);
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class,false, Relationship.class,true);

    }

    @objid ("860acac5-bc5b-41c9-99fe-79c3963d4050")
    @Override
    protected void registerLinkExpertForAssociation() {
        super.registerLinkExpertForAssociation();
        this.ruleLinkExpert.addRule(Association.class, Grouping.class, Plateau.class);

        // All ArchiMate relationships can be linked with associations
        this.ruleLinkExpert.addRule(Association.class, Relationship.class, true, Relationship.class, true);
        this.ruleLinkExpert.addRule(Association.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Association.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Association.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("dbe4ff5c-12e4-4c78-9722-d5155777bf62")
    @Override
    protected void registerLinkExpertForComposition() {
        super.registerLinkExpertForComposition();
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Grouping.class);
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Plateau.class);
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, false,Relationship.class,true);
        this.ruleLinkExpert.addRule(Composition.class, Location.class, false,Relationship.class,true);
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class,false, Relationship.class,true);

    }

    @objid ("349bddd3-3610-4ea2-b01b-14e3205b3bdd")
    @Override
    protected void registerLinkExpertForFlow() {
        super.registerLinkExpertForFlow();
        this.ruleLinkExpert.addRule(Flow.class, Grouping.class, Plateau.class);
        this.ruleLinkExpert.addRule(Flow.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Flow.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Flow.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("37f3cf5d-8b49-4a54-9c11-4ce31faf8300")
    @Override
    protected void registerLinkExpertForRealization() {
        super.registerLinkExpertForRealization();
        this.ruleLinkExpert.addRule(Realization.class, Grouping.class, Plateau.class);
        this.ruleLinkExpert.addRule(Realization.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Realization.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Realization.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("08c84a9e-1dfc-4220-a6f5-64f896418829")
    @Override
    protected void registerLinkExpertForSpecialization() {
        super.registerLinkExpertForSpecialization();
        this.ruleLinkExpert.addRule(Specialization.class, Grouping.class, Grouping.class);
        this.ruleLinkExpert.addRule(Specialization.class, Grouping.class, Plateau.class);

    }

    @objid ("2463cede-4f0c-4e23-a35e-daf98bc18392")
    @Override
    protected void registerLinkExpertForTriggering() {
        super.registerLinkExpertForTriggering();
        this.ruleLinkExpert.addRule(Triggering.class, Grouping.class, Plateau.class);
        this.ruleLinkExpert.addRule(Triggering.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Triggering.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Triggering.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("cb29ce13-25d2-4eb9-95ef-5bc5e6d9da68")
    @Override
    protected void registerMetaExpertForApplicationFolder() {
        super.registerMetaExpertForApplicationFolder();

        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationCollaboration.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationComponent.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationEvent.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationFunction.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationInteraction.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationInterface.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationInternalBehaviorElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationProcess.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, ApplicationService.class, "content");
        this.ruleMetaExpert.addCompositionRule(ApplicationFolder.class, DataObject.class, "content");

        this.ruleMetaExpert.addDependencyRule(ApplicationFolder.class, ApplicationFolder.class, "folder");

    }

    @objid ("b67596d0-f70b-41a2-85d4-b356e659e555")
    @Override
    protected void registerMetaExpertForArchimateProject() {
        super.registerMetaExpertForArchimateProject();

        this.ruleMetaExpert.addDependencyRule(ArchimateProject.class, Model.class, "model");

        this.ruleMetaExpert.addDependencyRule(ArchimateProject.class, ViewPoint.class, "viewPoints");

    }

    @objid ("a22d15ee-b9c2-4f32-9c84-220478b88909")
    @Override
    protected void registerMetaExpertForBusinessFolder() {
        super.registerMetaExpertForBusinessFolder();

        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessActor.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessCollaboration.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessEvent.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessFunction.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessInteraction.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessInterface.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessInternalActiveStructureElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessInternalBehaviorElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessObject.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessPassiveStructureElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessProcess.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessRole.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, BusinessService.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, Contract.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, Product.class, "content");
        this.ruleMetaExpert.addCompositionRule(BusinessFolder.class, Representation.class, "content");

        this.ruleMetaExpert.addDependencyRule(BusinessFolder.class, BusinessFolder.class, "folder");

    }

    @objid ("84f3f72a-5509-4d1b-919d-1e8b85bbd3da")
    @Override
    protected void registerMetaExpertForImplementationFolder() {
        super.registerMetaExpertForImplementationFolder();

        this.ruleMetaExpert.addCompositionRule(ImplementationFolder.class, Deliverable.class, "content");
        this.ruleMetaExpert.addCompositionRule(ImplementationFolder.class, Gap.class, "content");
        this.ruleMetaExpert.addCompositionRule(ImplementationFolder.class, ImplementationEvent.class, "content");
        this.ruleMetaExpert.addCompositionRule(ImplementationFolder.class, Plateau.class, "content");
        this.ruleMetaExpert.addCompositionRule(ImplementationFolder.class, WorkPackage.class, "content");

        this.ruleMetaExpert.addDependencyRule(StrategyFolder.class, StrategyFolder.class, "folder");

    }

    @objid ("50874e7e-4a7b-4a3f-a853-1a1957d78c04")
    @Override
    protected void registerMetaExpertForModel() {
        super.registerMetaExpertForModel();

        this.ruleMetaExpert.addDependencyRule(Model.class, Grouping.class, "content");
        this.ruleMetaExpert.addDependencyRule(Model.class, Location.class, "content");

        this.ruleMetaExpert.addDependencyRule(Model.class, PhysicalFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, TechnologyFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, ImplementationFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, StrategyFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, ApplicationFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, MotivationFolder.class, "folder");
        this.ruleMetaExpert.addDependencyRule(Model.class, BusinessFolder.class, "folder");

    }

    @objid ("388aa275-15ff-4804-8324-079a54a8d971")
    @Override
    protected void registerMetaExpertForMotivationFolder() {
        super.registerMetaExpertForMotivationFolder();

        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Assessment.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Constraint.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Driver.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Goal.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Meaning.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, MotivationElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Outcome.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Principle.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Requirement.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Stakeholder.class, "content");
        this.ruleMetaExpert.addCompositionRule(MotivationFolder.class, Value.class, "content");

        this.ruleMetaExpert.addDependencyRule(MotivationFolder.class, MotivationFolder.class, "folder");

    }

    @objid ("ed551b3e-f000-40de-aaa6-f7500a97930b")
    @Override
    protected void registerMetaExpertForPhysicalFolder() {
        super.registerMetaExpertForPhysicalFolder();

        this.ruleMetaExpert.addCompositionRule(PhysicalFolder.class, DistributionNetwork.class, "content");
        this.ruleMetaExpert.addCompositionRule(PhysicalFolder.class, Equipment.class, "content");
        this.ruleMetaExpert.addCompositionRule(PhysicalFolder.class, Facility.class, "content");
        this.ruleMetaExpert.addCompositionRule(PhysicalFolder.class, Material.class, "content");

        this.ruleMetaExpert.addDependencyRule(PhysicalFolder.class, PhysicalFolder.class, "folder");

    }

    @objid ("2350284f-3f4b-4b7e-a4f8-356987c81d3a")
    @Override
    protected void registerMetaExpertForStrategyFolder() {
        super.registerMetaExpertForStrategyFolder();

        this.ruleMetaExpert.addCompositionRule(StrategyFolder.class, Capability.class, "content");
        this.ruleMetaExpert.addCompositionRule(StrategyFolder.class, CourseOfAction.class, "content");
        this.ruleMetaExpert.addCompositionRule(StrategyFolder.class, Resource.class, "content");

        this.ruleMetaExpert.addDependencyRule(StrategyFolder.class, StrategyFolder.class, "folder");

    }

    @objid ("27290ec0-00f5-4bc3-8ab1-bfbfa1e08efe")
    @Override
    protected void registerMetaExpertForTechnologyFolder() {
        super.registerMetaExpertForTechnologyFolder();

        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, Artifact.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, CommunicationNetwork.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, Device.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, Node.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, Path.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, SystemSoftware.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyCollaboration.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyEvent.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyFunction.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyInteraction.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyInterface.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyInternalBehaviorElement.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyObject.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyProcess.class, "content");
        this.ruleMetaExpert.addCompositionRule(TechnologyFolder.class, TechnologyService.class, "content");

        this.ruleMetaExpert.addDependencyRule(TechnologyFolder.class, TechnologyFolder.class, "folder");

    }

    @objid ("8a839a4c-7983-444d-a5f4-a0e91765c7bc")
    @Override
    protected void registerLinkExpertForAccess() {
        super.registerLinkExpertForAccess();
        this.ruleLinkExpert.addRule(Access.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Access.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Access.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("0103e1f6-7afb-4911-8c48-65702d01559a")
    @Override
    protected void registerLinkExpertForAssignment() {
        super.registerLinkExpertForAssignment();
        this.ruleLinkExpert.addRule(Assignment.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Assignment.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Assignment.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("c4d5cc0a-2782-489a-971b-dade820b7e44")
    @Override
    protected void registerLinkExpertForInfluence() {
        super.registerLinkExpertForInfluence();
        this.ruleLinkExpert.addRule(Influence.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Influence.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Influence.class, Junction.class,true, MotivationElement.class,true);

    }

    @objid ("000472c0-5f1d-499b-b281-ce49c615da71")
    @Override
    protected void registerLinkExpertForServing() {
        super.registerLinkExpertForServing();
        this.ruleLinkExpert.addRule(Serving.class, Junction.class,true, BehaviorElement.class,true);
        this.ruleLinkExpert.addRule(Serving.class, Junction.class,true, StructureElement.class,true);
        this.ruleLinkExpert.addRule(Serving.class, Junction.class,true, MotivationElement.class,true);

    }

}
