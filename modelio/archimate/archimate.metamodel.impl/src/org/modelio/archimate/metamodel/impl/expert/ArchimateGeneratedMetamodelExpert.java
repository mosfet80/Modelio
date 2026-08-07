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
import org.modelio.archimate.metamodel.core.ArchimateAbstractElement;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Element;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.RelationshipConnector;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.archimate.metamodel.core.generic.ActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.BehaviorElement;
import org.modelio.archimate.metamodel.core.generic.Event;
import org.modelio.archimate.metamodel.core.generic.ExternalActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;
import org.modelio.archimate.metamodel.core.generic.InternalActiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;
import org.modelio.archimate.metamodel.core.generic.StructureElement;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;
import org.modelio.archimate.metamodel.core.generic.composite.Grouping;
import org.modelio.archimate.metamodel.core.generic.composite.Location;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;
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
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationEvent;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationFunction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInteraction;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationInternalBehaviorElement;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationProcess;
import org.modelio.archimate.metamodel.layers.application.behavior.ApplicationService;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationCollaboration;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationComponent;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInterface;
import org.modelio.archimate.metamodel.layers.application.structure.active.ApplicationInternalActiveStructureElement;
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
import org.modelio.archimate.metamodel.layers.strategy.behavior.StrategyBehaviorElement;
import org.modelio.archimate.metamodel.layers.strategy.behavior.ValueStream;
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
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyCollaboration;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInterface;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyInternalActiveStructureElement;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.Artifact;
import org.modelio.archimate.metamodel.layers.technology.structure.passive.TechnologyObject;
import org.modelio.archimate.metamodel.relationships.dependency.Access;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;
import org.modelio.archimate.metamodel.relationships.dependency.Influence;
import org.modelio.archimate.metamodel.relationships.dependency.Serving;
import org.modelio.archimate.metamodel.relationships.dynamic.DynamicRelationship;
import org.modelio.archimate.metamodel.relationships.dynamic.Flow;
import org.modelio.archimate.metamodel.relationships.dynamic.Triggering;
import org.modelio.archimate.metamodel.relationships.other.AndJunction;
import org.modelio.archimate.metamodel.relationships.other.Association;
import org.modelio.archimate.metamodel.relationships.other.Junction;
import org.modelio.archimate.metamodel.relationships.other.OrJunction;
import org.modelio.archimate.metamodel.relationships.other.OtherRelationship;
import org.modelio.archimate.metamodel.relationships.other.Specialization;
import org.modelio.archimate.metamodel.relationships.structural.Aggregation;
import org.modelio.archimate.metamodel.relationships.structural.Assignment;
import org.modelio.archimate.metamodel.relationships.structural.Composition;
import org.modelio.archimate.metamodel.relationships.structural.Realization;
import org.modelio.archimate.metamodel.relationships.structural.StructuralRelationship;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.utils.metamodel.experts.CompositeMetamodelExpert;

/**
 * This is an automatically generated metamodel expert.
 * <p>
 * All modifications will be overwritten. If you need to modify it, subclass this class instead.
 * <p>
 * You need to call {@link #register()} after instantiation to initialize the expert from the metamodel.
 */
@objid ("d942c335-42cf-48da-9169-8d8d498ba4ba")
class ArchimateGeneratedMetamodelExpert extends CompositeMetamodelExpert {
    /**
     * Constructor.
     * <p>
     * You need to call {@link #register()} next.
     *
     * @param mm The metamodel.
     */
    @objid ("66155726-4206-4901-9443-bf0af34bd07c")
    public ArchimateGeneratedMetamodelExpert(MMetamodel mm) {
        super(mm);

    }

    /**
     * Initializes this expert.
     */
    @objid ("1f8edd06-f812-4e38-97a8-7fc6f6cbfb71")
    public void register() {
        registerLinkExpertForRelationship();
        registerLinkExpertForDependencyRelationship();
        registerLinkExpertForDynamicRelationship();
        registerLinkExpertForOtherRelationship();
        registerLinkExpertForStructuralRelationship();
        registerLinkExpertForAccess();
        registerLinkExpertForInfluence();
        registerLinkExpertForServing();
        registerLinkExpertForAssociation();
        registerLinkExpertForFlow();
        registerLinkExpertForTriggering();
        registerLinkExpertForSpecialization();
        registerLinkExpertForAggregation();
        registerLinkExpertForAssignment();
        registerLinkExpertForComposition();
        registerLinkExpertForRealization();
        registerMetaExpertForRealization();
        registerMetaExpertForComposition();
        registerMetaExpertForAssignment();
        registerMetaExpertForAggregation();
        registerMetaExpertForStructuralRelationship();
        registerMetaExpertForSpecialization();
        registerMetaExpertForOtherRelationship();
        registerMetaExpertForOrJunction();
        registerMetaExpertForAssociation();
        registerMetaExpertForAndJunction();
        registerMetaExpertForJunction();
        registerMetaExpertForTriggering();
        registerMetaExpertForFlow();
        registerMetaExpertForDynamicRelationship();
        registerMetaExpertForServing();
        registerMetaExpertForInfluence();
        registerMetaExpertForAccess();
        registerMetaExpertForDependencyRelationship();
        registerMetaExpertForArtifact();
        registerMetaExpertForTechnologyInterface();
        registerMetaExpertForTechnologyCollaboration();
        registerMetaExpertForSystemSoftware();
        registerMetaExpertForPath();
        registerMetaExpertForDevice();
        registerMetaExpertForCommunicationNetwork();
        registerMetaExpertForTechnologyService();
        registerMetaExpertForTechnologyProcess();
        registerMetaExpertForTechnologyInteraction();
        registerMetaExpertForTechnologyFunction();
        registerMetaExpertForTechnologyInternalBehaviorElement();
        registerMetaExpertForTechnologyEvent();
        registerMetaExpertForResource();
        registerMetaExpertForValueStream();
        registerMetaExpertForCourseOfAction();
        registerMetaExpertForCapability();
        registerMetaExpertForStrategyBehaviorElement();
        registerMetaExpertForMaterial();
        registerMetaExpertForTechnologyObject();
        registerMetaExpertForFacility();
        registerMetaExpertForEquipment();
        registerMetaExpertForNode();
        registerMetaExpertForTechnologyInternalActiveStructureElement();
        registerMetaExpertForDistributionNetwork();
        registerMetaExpertForTechnologyActiveStructureElement();
        registerMetaExpertForValue();
        registerMetaExpertForStakeholder();
        registerMetaExpertForPrinciple();
        registerMetaExpertForOutcome();
        registerMetaExpertForMeaning();
        registerMetaExpertForGoal();
        registerMetaExpertForDriver();
        registerMetaExpertForConstraint();
        registerMetaExpertForRequirement();
        registerMetaExpertForAssessment();
        registerMetaExpertForWorkPackage();
        registerMetaExpertForPlateau();
        registerMetaExpertForImplementationEvent();
        registerMetaExpertForGap();
        registerMetaExpertForDeliverable();
        registerMetaExpertForRepresentation();
        registerMetaExpertForContract();
        registerMetaExpertForBusinessObject();
        registerMetaExpertForBusinessPassiveStructureElement();
        registerMetaExpertForBusinessRole();
        registerMetaExpertForBusinessInterface();
        registerMetaExpertForBusinessCollaboration();
        registerMetaExpertForBusinessActor();
        registerMetaExpertForBusinessInternalActiveStructureElement();
        registerMetaExpertForProduct();
        registerMetaExpertForBusinessService();
        registerMetaExpertForBusinessProcess();
        registerMetaExpertForBusinessInteraction();
        registerMetaExpertForBusinessFunction();
        registerMetaExpertForBusinessInternalBehaviorElement();
        registerMetaExpertForBusinessEvent();
        registerMetaExpertForDataObject();
        registerMetaExpertForApplicationInterface();
        registerMetaExpertForApplicationComponent();
        registerMetaExpertForApplicationCollaboration();
        registerMetaExpertForApplicationInternalActiveStructureElement();
        registerMetaExpertForApplicationService();
        registerMetaExpertForApplicationProcess();
        registerMetaExpertForApplicationInteraction();
        registerMetaExpertForApplicationFunction();
        registerMetaExpertForApplicationInternalBehaviorElement();
        registerMetaExpertForApplicationEvent();
        registerMetaExpertForViewPointDiagram();
        registerMetaExpertForRelationshipConnector();
        registerMetaExpertForRelationship();
        registerMetaExpertForArchimateView();
        registerMetaExpertForViewPoint();
        registerMetaExpertForModel();
        registerMetaExpertForArchimateProject();
        registerMetaExpertForTechnologyFolder();
        registerMetaExpertForStrategyFolder();
        registerMetaExpertForPhysicalFolder();
        registerMetaExpertForMotivationFolder();
        registerMetaExpertForImplementationFolder();
        registerMetaExpertForBusinessFolder();
        registerMetaExpertForApplicationFolder();
        registerMetaExpertForFolder();
        registerMetaExpertForPassiveStructureElement();
        registerMetaExpertForInternalBehaviorElement();
        registerMetaExpertForInternalActiveStructureElement();
        registerMetaExpertForExternalBehaviorElement();
        registerMetaExpertForExternalActiveStructureElement();
        registerMetaExpertForEvent();
        registerMetaExpertForBehaviorElement();
        registerMetaExpertForActiveStructureElement();
        registerMetaExpertForStructureElement();
        registerMetaExpertForMotivationElement();
        registerMetaExpertForLocation();
        registerMetaExpertForGrouping();
        registerMetaExpertForCompositeElement();
        registerMetaExpertForElement();
        registerMetaExpertForConcept();
        registerMetaExpertForArchimateAbstractElement();

    }

    @objid ("eefce1b0-1c27-4908-9789-7d62c24a758c")
    protected void registerLinkExpertForRelationship() {
        // Archimate.Relationship is abstract

        this.ruleLinkExpert.addLinkMetaclass(Relationship.class);

    }

    @objid ("71240623-2206-4bcf-a6da-d814ca9cb579")
    protected void registerLinkExpertForDependencyRelationship() {
        // Archimate.DependencyRelationship is abstract

        this.ruleLinkExpert.addLinkMetaclass(DependencyRelationship.class);

    }

    @objid ("d678dbdd-cc20-4735-876f-f5493036a7a1")
    protected void registerLinkExpertForDynamicRelationship() {
        // Archimate.DynamicRelationship is abstract

        this.ruleLinkExpert.addLinkMetaclass(DynamicRelationship.class);

    }

    @objid ("799dd7d8-f360-4796-96ae-2a08dd0aeb8d")
    protected void registerLinkExpertForOtherRelationship() {
        // Archimate.OtherRelationship is abstract

        this.ruleLinkExpert.addLinkMetaclass(OtherRelationship.class);

    }

    @objid ("4f0b0c6c-8311-474b-bdd5-4113abad7651")
    protected void registerLinkExpertForStructuralRelationship() {
        // Archimate.StructuralRelationship is abstract

        this.ruleLinkExpert.addLinkMetaclass(StructuralRelationship.class);

    }

    @objid ("c17135d8-6f3b-49d0-8876-15e7c23162de")
    protected void registerLinkExpertForAccess() {
        // Archimate.Access
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Access.class);

        // Archimate.Access sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Access.class, "from");
        this.ruleLinkExpert.addTargetDep(Access.class, "to");


        // Archimate.Access rules:

        this.ruleLinkExpert.addRule(Access.class, ApplicationEvent.class, DataObject.class); // generated from 'InformationFlow'{45e007f4-b92d-461d-a3c2-dc353cb39ce4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ApplicationFunction.class, DataObject.class); // generated from 'InformationFlow'{bc3f53c8-55e7-4d31-8a0d-abda871e754b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ApplicationInteraction.class, DataObject.class); // generated from 'InformationFlow'{bc3f53c8-55e7-4d31-8a0d-abda871e754b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ApplicationInternalBehaviorElement.class, DataObject.class); // generated from 'InformationFlow'{bc3f53c8-55e7-4d31-8a0d-abda871e754b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ApplicationProcess.class, DataObject.class); // generated from 'InformationFlow'{bc3f53c8-55e7-4d31-8a0d-abda871e754b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ApplicationService.class, DataObject.class); // generated from 'InformationFlow'{be3704c9-25ca-499d-ad61-dcb64bd9b4c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessEvent.class, BusinessObject.class); // generated from 'InformationFlow'{b6eb0b7b-2080-40df-b4d0-bbcbeeb03c2a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessEvent.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{b6eb0b7b-2080-40df-b4d0-bbcbeeb03c2a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessEvent.class, Contract.class); // generated from 'InformationFlow'{b6eb0b7b-2080-40df-b4d0-bbcbeeb03c2a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessEvent.class, Representation.class); // generated from 'InformationFlow'{b6eb0b7b-2080-40df-b4d0-bbcbeeb03c2a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessFunction.class, BusinessObject.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessFunction.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessFunction.class, Contract.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessFunction.class, Representation.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInteraction.class, BusinessObject.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInteraction.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInteraction.class, Contract.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInteraction.class, Representation.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInternalBehaviorElement.class, BusinessObject.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInternalBehaviorElement.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInternalBehaviorElement.class, Contract.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessInternalBehaviorElement.class, Representation.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessProcess.class, BusinessObject.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessProcess.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessProcess.class, Contract.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessProcess.class, Representation.class); // generated from 'InformationFlow'{6285fee4-40b4-4d1a-920c-2889a2fc487b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessService.class, BusinessObject.class); // generated from 'InformationFlow'{cd28ad3b-0007-4f7e-9e66-9b4cd9f64ee9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessService.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{cd28ad3b-0007-4f7e-9e66-9b4cd9f64ee9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessService.class, Contract.class); // generated from 'InformationFlow'{cd28ad3b-0007-4f7e-9e66-9b4cd9f64ee9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, BusinessService.class, Representation.class); // generated from 'InformationFlow'{cd28ad3b-0007-4f7e-9e66-9b4cd9f64ee9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, ImplementationEvent.class, Deliverable.class); // generated from ''{f576421a-eecb-4494-9a24-eabd3628f5f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyEvent.class, Artifact.class); // generated from 'InformationFlow'{98515c31-5be9-4cc1-a7cc-e57abefdd58c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyEvent.class, Material.class); // generated from 'InformationFlow'{98515c31-5be9-4cc1-a7cc-e57abefdd58c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyEvent.class, TechnologyObject.class); // generated from 'InformationFlow'{98515c31-5be9-4cc1-a7cc-e57abefdd58c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyFunction.class, Material.class); // generated from 'InformationFlow'{fb131e04-47c6-48f9-bde5-c5912f7aae21} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInteraction.class, Material.class); // generated from 'InformationFlow'{fb131e04-47c6-48f9-bde5-c5912f7aae21} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInternalBehaviorElement.class, Material.class); // generated from 'InformationFlow'{fb131e04-47c6-48f9-bde5-c5912f7aae21} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyProcess.class, Material.class); // generated from 'InformationFlow'{fb131e04-47c6-48f9-bde5-c5912f7aae21} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyFunction.class, Artifact.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyFunction.class, Material.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyFunction.class, TechnologyObject.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInteraction.class, Artifact.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInteraction.class, Material.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInteraction.class, TechnologyObject.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInternalBehaviorElement.class, Artifact.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInternalBehaviorElement.class, Material.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyInternalBehaviorElement.class, TechnologyObject.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyProcess.class, Artifact.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyProcess.class, Material.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyProcess.class, TechnologyObject.class); // generated from 'InformationFlow'{f0ee353d-09aa-4405-9208-b952e909f84c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyService.class, Artifact.class); // generated from 'InformationFlow'{87477742-c5d8-4ef4-a922-1cd8efb81785} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyService.class, Material.class); // generated from 'InformationFlow'{87477742-c5d8-4ef4-a922-1cd8efb81785} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, TechnologyService.class, TechnologyObject.class); // generated from 'InformationFlow'{87477742-c5d8-4ef4-a922-1cd8efb81785} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Access.class, WorkPackage.class, Deliverable.class); // generated from 'InformationFlow'{65ce56df-f87d-470a-9936-a96a94706b74} Standard.InformationFlow

    }

    @objid ("46c8448e-cfa3-42c5-aadd-61302bd4b4d4")
    protected void registerLinkExpertForInfluence() {
        // Archimate.Influence
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Influence.class);

        // Archimate.Influence sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Influence.class, "from");
        this.ruleLinkExpert.addTargetDep(Influence.class, "to");


        // Archimate.Influence rules:

        this.ruleLinkExpert.addRule(Influence.class, CourseOfAction.class, Outcome.class); // generated from 'InformationFlow'{9ac58e3e-fe1f-4f79-8529-a934b5faf858} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, CourseOfAction.class, Constraint.class); // generated from 'InformationFlow'{fe176cd7-be29-45f4-a22b-bd0d2ac6cee4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, CourseOfAction.class, Requirement.class); // generated from 'InformationFlow'{fe176cd7-be29-45f4-a22b-bd0d2ac6cee4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ExternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ExternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, TechnologyInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, TechnologyInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationCollaboration.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationCollaboration.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationComponent.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationComponent.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationInternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ApplicationInternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessActor.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessActor.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessCollaboration.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessCollaboration.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessInternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessInternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessRole.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessRole.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, InternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, InternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Assessment.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Constraint.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Driver.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Goal.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Meaning.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, MotivationElement.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Outcome.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Principle.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Requirement.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Stakeholder.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Assessment.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Constraint.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Driver.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Goal.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Meaning.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, MotivationElement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Outcome.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Principle.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Requirement.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Stakeholder.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Value.class, Value.class); // generated from 'InformationFlow'{c920039b-4b8d-4150-853a-04cd2c90f841} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Device.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Device.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Equipment.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Equipment.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Facility.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Facility.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Node.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Node.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, SystemSoftware.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, SystemSoftware.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Artifact.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Artifact.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessPassiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, BusinessPassiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Contract.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Contract.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, DataObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, DataObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Deliverable.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Deliverable.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Gap.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Gap.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Material.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Material.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, PassiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, PassiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Representation.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Representation.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, TechnologyObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, TechnologyObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Resource.class, Constraint.class); // generated from 'InformationFlow'{ef6b050b-9a45-437d-8292-5e9c7de0d88b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Resource.class, Requirement.class); // generated from 'InformationFlow'{ef6b050b-9a45-437d-8292-5e9c7de0d88b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Resource.class, Constraint.class); // generated from 'InformationFlow'{55653d87-8eb0-4fe1-8e70-0c98b96c5070} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Resource.class, Requirement.class); // generated from 'InformationFlow'{55653d87-8eb0-4fe1-8e70-0c98b96c5070} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Capability.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, Capability.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, StrategyBehaviorElement.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, StrategyBehaviorElement.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ValueStream.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Influence.class, ValueStream.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow

    }

    @objid ("2712ea97-5920-4f38-b902-abfbc19536d0")
    protected void registerLinkExpertForServing() {
        // Archimate.Serving
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Serving.class);

        // Archimate.Serving sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Serving.class, "from");
        this.ruleLinkExpert.addTargetDep(Serving.class, "to");


        // Archimate.Serving rules:

        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{98d563b6-464f-4a30-86aa-b4962b968f8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, ApplicationComponent.class); // generated from 'InformationFlow'{98d563b6-464f-4a30-86aa-b4962b968f8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{98d563b6-464f-4a30-86aa-b4962b968f8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, BusinessActor.class); // generated from 'InformationFlow'{d848a535-71c7-48e9-8f06-bc7445e5e522} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, BusinessCollaboration.class); // generated from 'InformationFlow'{d848a535-71c7-48e9-8f06-bc7445e5e522} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{d848a535-71c7-48e9-8f06-bc7445e5e522} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, BusinessRole.class); // generated from 'InformationFlow'{d848a535-71c7-48e9-8f06-bc7445e5e522} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, Device.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, Equipment.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, Facility.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, Node.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, SystemSoftware.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationInterface.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{cdc89bf1-9109-4a56-87e8-cb85d3a0338e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{3227fefd-ef11-4dd4-9522-20efcf5838d8} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationComponent.class); // generated from 'InformationFlow'{3227fefd-ef11-4dd4-9522-20efcf5838d8} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{3227fefd-ef11-4dd4-9522-20efcf5838d8} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessFunction.class); // generated from 'InformationFlow'{45b125d7-0854-41b9-b247-b08d7e9638e4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessInteraction.class); // generated from 'InformationFlow'{45b125d7-0854-41b9-b247-b08d7e9638e4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{45b125d7-0854-41b9-b247-b08d7e9638e4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessProcess.class); // generated from 'InformationFlow'{45b125d7-0854-41b9-b247-b08d7e9638e4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessActor.class); // generated from 'InformationFlow'{af713f78-d996-4e8c-9dec-3f7c84d6a694} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessCollaboration.class); // generated from 'InformationFlow'{af713f78-d996-4e8c-9dec-3f7c84d6a694} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{af713f78-d996-4e8c-9dec-3f7c84d6a694} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, BusinessRole.class); // generated from 'InformationFlow'{af713f78-d996-4e8c-9dec-3f7c84d6a694} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, Device.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, Equipment.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, Facility.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, Node.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, SystemSoftware.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{c5cd3f47-b310-4c8d-9c05-7d797d15570e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyFunction.class); // generated from 'InformationFlow'{69f9e6d8-35f5-4c80-a2ec-3d08929c4880} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyInteraction.class); // generated from 'InformationFlow'{69f9e6d8-35f5-4c80-a2ec-3d08929c4880} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{69f9e6d8-35f5-4c80-a2ec-3d08929c4880} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, TechnologyProcess.class); // generated from 'InformationFlow'{69f9e6d8-35f5-4c80-a2ec-3d08929c4880} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationFunction.class); // generated from 'InformationFlow'{ead372dc-a548-4059-a801-e7a4d2368bd7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationInteraction.class); // generated from 'InformationFlow'{ead372dc-a548-4059-a801-e7a4d2368bd7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{ead372dc-a548-4059-a801-e7a4d2368bd7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ApplicationService.class, ApplicationProcess.class); // generated from 'InformationFlow'{ead372dc-a548-4059-a801-e7a4d2368bd7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{a245a4a1-41c5-48cd-bf21-0af88f7760b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, ApplicationComponent.class); // generated from 'InformationFlow'{a245a4a1-41c5-48cd-bf21-0af88f7760b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{a245a4a1-41c5-48cd-bf21-0af88f7760b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, Device.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, Equipment.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, Facility.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, Node.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, SystemSoftware.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{b2adf3e3-9d8f-47f3-bec6-7eb2a59f782b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, BusinessActor.class); // generated from 'InformationFlow'{a35f098a-2742-47aa-803b-93ba018a739f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, BusinessCollaboration.class); // generated from 'InformationFlow'{a35f098a-2742-47aa-803b-93ba018a739f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{a35f098a-2742-47aa-803b-93ba018a739f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessInterface.class, BusinessRole.class); // generated from 'InformationFlow'{a35f098a-2742-47aa-803b-93ba018a739f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationFunction.class); // generated from 'InformationFlow'{f3dae411-c12c-40a2-8d41-a2691f558ba6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationInteraction.class); // generated from 'InformationFlow'{f3dae411-c12c-40a2-8d41-a2691f558ba6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{f3dae411-c12c-40a2-8d41-a2691f558ba6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationProcess.class); // generated from 'InformationFlow'{f3dae411-c12c-40a2-8d41-a2691f558ba6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, TechnologyFunction.class); // generated from 'InformationFlow'{c19d9d56-dc73-4932-8642-1011700ff7a4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, TechnologyInteraction.class); // generated from 'InformationFlow'{c19d9d56-dc73-4932-8642-1011700ff7a4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{c19d9d56-dc73-4932-8642-1011700ff7a4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, TechnologyProcess.class); // generated from 'InformationFlow'{c19d9d56-dc73-4932-8642-1011700ff7a4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{dae67ec2-89bf-4176-a4ae-98b682d2cdb9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationComponent.class); // generated from 'InformationFlow'{dae67ec2-89bf-4176-a4ae-98b682d2cdb9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{dae67ec2-89bf-4176-a4ae-98b682d2cdb9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessFunction.class); // generated from 'InformationFlow'{d99f8cc8-6da0-4145-8ae6-c159993fa68e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessInteraction.class); // generated from 'InformationFlow'{d99f8cc8-6da0-4145-8ae6-c159993fa68e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{d99f8cc8-6da0-4145-8ae6-c159993fa68e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessProcess.class); // generated from 'InformationFlow'{d99f8cc8-6da0-4145-8ae6-c159993fa68e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessActor.class); // generated from 'InformationFlow'{ec0448b6-f6ff-4ff7-a531-de5090aec262} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessCollaboration.class); // generated from 'InformationFlow'{ec0448b6-f6ff-4ff7-a531-de5090aec262} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{ec0448b6-f6ff-4ff7-a531-de5090aec262} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, BusinessService.class, BusinessRole.class); // generated from 'InformationFlow'{ec0448b6-f6ff-4ff7-a531-de5090aec262} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, CourseOfAction.class, CourseOfAction.class); // generated from 'InformationFlow'{9e01a407-6a46-4c44-86b0-9aea1b5dfa4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, Capability.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, StrategyBehaviorElement.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ValueStream.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, Capability.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, StrategyBehaviorElement.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ValueStream.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, Capability.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, Capability.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, Capability.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, StrategyBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, StrategyBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, StrategyBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ValueStream.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ValueStream.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, ValueStream.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, BusinessActor.class); // generated from 'InformationFlow'{4cbc57e2-6891-43aa-9335-a500c0be655f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, BusinessCollaboration.class); // generated from 'InformationFlow'{4cbc57e2-6891-43aa-9335-a500c0be655f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{4cbc57e2-6891-43aa-9335-a500c0be655f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, BusinessRole.class); // generated from 'InformationFlow'{4cbc57e2-6891-43aa-9335-a500c0be655f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{0487a81a-2d9a-4935-a3cb-a9b9fb8b8b4c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, ApplicationComponent.class); // generated from 'InformationFlow'{0487a81a-2d9a-4935-a3cb-a9b9fb8b8b4c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{0487a81a-2d9a-4935-a3cb-a9b9fb8b8b4c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, Device.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, Equipment.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, Facility.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, Node.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, SystemSoftware.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInterface.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{1cad68ed-7c1f-4d8f-b03c-39657cacd7c0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyFunction.class, TechnologyService.class); // generated from 'InformationFlow'{78bf860c-8da2-4b47-92da-ff7aa60b8cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInteraction.class, TechnologyService.class); // generated from 'InformationFlow'{78bf860c-8da2-4b47-92da-ff7aa60b8cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyInternalBehaviorElement.class, TechnologyService.class); // generated from 'InformationFlow'{78bf860c-8da2-4b47-92da-ff7aa60b8cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyProcess.class, TechnologyService.class); // generated from 'InformationFlow'{78bf860c-8da2-4b47-92da-ff7aa60b8cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessFunction.class); // generated from 'InformationFlow'{e4efe2ec-bdf4-4cd4-b10d-b23d47b2e784} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessInteraction.class); // generated from 'InformationFlow'{e4efe2ec-bdf4-4cd4-b10d-b23d47b2e784} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{e4efe2ec-bdf4-4cd4-b10d-b23d47b2e784} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessProcess.class); // generated from 'InformationFlow'{e4efe2ec-bdf4-4cd4-b10d-b23d47b2e784} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessActor.class); // generated from 'InformationFlow'{75a7ce0f-b929-46c8-ad3e-b34b0b00c6c7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessCollaboration.class); // generated from 'InformationFlow'{75a7ce0f-b929-46c8-ad3e-b34b0b00c6c7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{75a7ce0f-b929-46c8-ad3e-b34b0b00c6c7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, BusinessRole.class); // generated from 'InformationFlow'{75a7ce0f-b929-46c8-ad3e-b34b0b00c6c7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{17b8d68b-d6c7-4d93-964b-ad0c17346f6d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationComponent.class); // generated from 'InformationFlow'{17b8d68b-d6c7-4d93-964b-ad0c17346f6d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{17b8d68b-d6c7-4d93-964b-ad0c17346f6d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationFunction.class); // generated from 'InformationFlow'{77498a81-4788-4ae8-bb09-8761405b6cf5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationInteraction.class); // generated from 'InformationFlow'{77498a81-4788-4ae8-bb09-8761405b6cf5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{77498a81-4788-4ae8-bb09-8761405b6cf5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, ApplicationProcess.class); // generated from 'InformationFlow'{77498a81-4788-4ae8-bb09-8761405b6cf5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, Device.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, Equipment.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, Facility.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, Node.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, SystemSoftware.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{adc41be9-ce65-4653-be9d-09651c2e8cc4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyFunction.class); // generated from 'InformationFlow'{90dc520e-1781-445d-b237-a511a5ea86d0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyInteraction.class); // generated from 'InformationFlow'{90dc520e-1781-445d-b237-a511a5ea86d0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{90dc520e-1781-445d-b237-a511a5ea86d0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Serving.class, TechnologyService.class, TechnologyProcess.class); // generated from 'InformationFlow'{90dc520e-1781-445d-b237-a511a5ea86d0} Standard.InformationFlow

    }

    @objid ("764539f2-7258-48ed-9bc0-ae2521f21695")
    protected void registerLinkExpertForAssociation() {
        // Archimate.Association
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Association.class);

        // Archimate.Association sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Association.class, "from");
        this.ruleLinkExpert.addTargetDep(Association.class, "to");


        // Archimate.Association rules:

        this.ruleLinkExpert.addRule(Association.class, Assessment.class, Goal.class); // generated from 'InformationFlow'{9f792624-d609-42e7-b2df-6ed4c0ba9269} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, CommunicationNetwork.class, Device.class); // generated from 'InformationFlow'{db0649e5-e826-4b57-928c-7a132fcf104c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, CommunicationNetwork.class, SystemSoftware.class); // generated from 'InformationFlow'{37701377-d684-4a22-9e07-701eb3aea103} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, DistributionNetwork.class, Facility.class); // generated from 'InformationFlow'{21c05c1e-ff96-40f4-815e-d5baa28f4a7e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, DistributionNetwork.class, Material.class); // generated from 'InformationFlow'{e5a81eda-a909-45b0-8cdc-9edf1313f0de} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Driver.class, Assessment.class); // generated from 'InformationFlow'{851000ea-a4d4-40bd-81e3-81921c314288} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Driver.class, Goal.class); // generated from 'InformationFlow'{3f9d2f29-007f-40b2-9e37-88ba8036f0ac} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Plateau.class); // generated from '2'{62c2026e-c1ea-44ba-b352-38043b905c4b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationComponent.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationEvent.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationFunction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationInteraction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationInterface.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationProcess.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ApplicationService.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Artifact.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessActor.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessCollaboration.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessEvent.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessFunction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessInteraction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessInterface.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessObject.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessProcess.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessRole.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, BusinessService.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Capability.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, CommunicationNetwork.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Contract.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, DataObject.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Device.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, DistributionNetwork.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Equipment.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Facility.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Material.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Node.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Path.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, Representation.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, SystemSoftware.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyEvent.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyFunction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyInteraction.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyInterface.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyObject.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyProcess.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, TechnologyService.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Gap.class, ValueStream.class); // generated from 'InformationFlow'{0a1c7d8f-3776-4ac0-9d65-196a6f891e4e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, ApplicationInterface.class); // generated from 'InformationFlow'{1a12c5c7-c290-45aa-b49e-d6d8712672f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessInterface.class); // generated from 'InformationFlow'{1a12c5c7-c290-45aa-b49e-d6d8712672f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{1a12c5c7-c290-45aa-b49e-d6d8712672f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, TechnologyInterface.class); // generated from 'InformationFlow'{1a12c5c7-c290-45aa-b49e-d6d8712672f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, ApplicationComponent.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessActor.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessCollaboration.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessRole.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{01f7b2e8-7d48-4c8c-8158-177918f05a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Artifact.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessObject.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Contract.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, DataObject.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Deliverable.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Gap.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Material.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, PassiveStructureElement.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Representation.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, TechnologyObject.class); // generated from 'InformationFlow'{b7671045-1977-431c-aee4-aa04fd5eb34e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Device.class); // generated from 'InformationFlow'{7c721dec-32b6-4380-8ad7-3d2935259b75} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Equipment.class); // generated from 'InformationFlow'{7c721dec-32b6-4380-8ad7-3d2935259b75} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Facility.class); // generated from 'InformationFlow'{7c721dec-32b6-4380-8ad7-3d2935259b75} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Node.class); // generated from 'InformationFlow'{7c721dec-32b6-4380-8ad7-3d2935259b75} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, SystemSoftware.class); // generated from 'InformationFlow'{7c721dec-32b6-4380-8ad7-3d2935259b75} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Resource.class); // generated from 'InformationFlow'{a8e1dd37-c3c4-4df8-8273-9910514fe33c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Meaning.class, Stakeholder.class); // generated from 'InformationFlow'{01377d1d-abdd-46e0-a62b-d23601c47ce0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, Device.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, Equipment.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, Facility.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, Node.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, SystemSoftware.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Path.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{84fc079c-d108-46f4-bc85-975efb731aad} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationInterface.class); // generated from 'InformationFlow'{0e2e7d4e-4ecc-41ff-bc55-d7885112b876} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessInterface.class); // generated from 'InformationFlow'{0e2e7d4e-4ecc-41ff-bc55-d7885112b876} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{0e2e7d4e-4ecc-41ff-bc55-d7885112b876} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyInterface.class); // generated from 'InformationFlow'{0e2e7d4e-4ecc-41ff-bc55-d7885112b876} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationComponent.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessActor.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessCollaboration.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessRole.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{a4bd7453-871e-4062-a706-472d91d910f7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Artifact.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessObject.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Contract.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, DataObject.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Deliverable.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Gap.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Material.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, PassiveStructureElement.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Representation.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyObject.class); // generated from 'InformationFlow'{9e5e41c6-f75e-440f-9cb3-2e741f9b772f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationEvent.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationFunction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationInteraction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationProcess.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ApplicationService.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessEvent.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessFunction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessInteraction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessProcess.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, BusinessService.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Capability.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, CourseOfAction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Event.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ImplementationEvent.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyEvent.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyFunction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyInteraction.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyProcess.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, TechnologyService.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, ValueStream.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, WorkPackage.class); // generated from 'InformationFlow'{a8616454-c6aa-47a8-bb6f-251f347933c6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Device.class); // generated from 'InformationFlow'{ea299d0c-35dc-4586-9d80-7ef49723b882} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Equipment.class); // generated from 'InformationFlow'{ea299d0c-35dc-4586-9d80-7ef49723b882} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Facility.class); // generated from 'InformationFlow'{ea299d0c-35dc-4586-9d80-7ef49723b882} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Node.class); // generated from 'InformationFlow'{ea299d0c-35dc-4586-9d80-7ef49723b882} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, SystemSoftware.class); // generated from 'InformationFlow'{ea299d0c-35dc-4586-9d80-7ef49723b882} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Resource.class); // generated from 'InformationFlow'{b96a49b9-3a99-4d70-80d2-14ed7090750b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Stakeholder.class); // generated from 'InformationFlow'{994d81d0-8d7d-4c6c-b056-cb47163bcf7c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Association.class, Value.class, Outcome.class); // generated from 'InformationFlow'{861a033d-506d-4d6d-8f60-c16b23eabcd4} Standard.InformationFlow

    }

    @objid ("8faf4a5a-48c4-47ee-be55-0a5d18d60456")
    protected void registerLinkExpertForFlow() {
        // Archimate.Flow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Flow.class);

        // Archimate.Flow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Flow.class, "from");
        this.ruleLinkExpert.addTargetDep(Flow.class, "to");


        // Archimate.Flow rules:

        this.ruleLinkExpert.addRule(Flow.class, ApplicationEvent.class, ApplicationEvent.class); // generated from 'InformationFlow'{1b45f85a-5426-4e5c-abfd-6d7b6b6e46e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationEvent.class, ApplicationFunction.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationEvent.class, ApplicationInteraction.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationEvent.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationEvent.class, ApplicationProcess.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationFunction.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInteraction.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInternalBehaviorElement.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationProcess.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationFunction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationFunction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationFunction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationFunction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInteraction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInteraction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInteraction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInteraction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInternalBehaviorElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInternalBehaviorElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInternalBehaviorElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationInternalBehaviorElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationProcess.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationProcess.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationProcess.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationProcess.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ApplicationService.class, ApplicationService.class); // generated from 'InformationFlow'{f53c1a57-41e7-4b49-9435-a487b5e30472} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessFunction.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessInteraction.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessProcess.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessEvent.class); // generated from 'InformationFlow'{5815c166-a3d4-4c60-be18-d5211c81798d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessEvent.class, BusinessService.class); // generated from 'InformationFlow'{58e0e07e-9a81-47d4-87d4-cf4ef8ae1d1f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessFunction.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInteraction.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInternalBehaviorElement.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessProcess.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, BusinessService.class, BusinessEvent.class); // generated from 'InformationFlow'{680140c3-971e-4a1c-a820-65fec20146de} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, CourseOfAction.class, CourseOfAction.class); // generated from 'InformationFlow'{9e01a407-6a46-4c44-86b0-9aea1b5dfa4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ImplementationEvent.class, WorkPackage.class); // generated from 'InformationFlow'{bb9d2b54-4e11-4086-bd65-357e70682111} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ImplementationEvent.class, ImplementationEvent.class); // generated from 'InformationFlow'{7f6ca99f-cf4b-497e-b85c-30b29a253f9d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, Capability.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, Capability.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, Capability.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, StrategyBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, StrategyBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, StrategyBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ValueStream.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ValueStream.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, ValueStream.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyEvent.class, TechnologyFunction.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyEvent.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyEvent.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyEvent.class, TechnologyProcess.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyEvent.class, TechnologyService.class); // generated from 'InformationFlow'{58287b28-fe8f-47a6-a91a-268f8603b1b5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyFunction.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInteraction.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInternalBehaviorElement.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyProcess.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyFunction.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyFunction.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyFunction.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyFunction.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInteraction.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInteraction.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInteraction.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInteraction.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInternalBehaviorElement.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInternalBehaviorElement.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInternalBehaviorElement.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyInternalBehaviorElement.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyProcess.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyProcess.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyProcess.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyProcess.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, TechnologyService.class, TechnologyEvent.class); // generated from 'InformationFlow'{42b60fe8-d476-453d-a9b4-adc6c1d0eef6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, WorkPackage.class, ImplementationEvent.class); // generated from 'InformationFlow'{cc88d82a-ab7c-48da-81be-d9632fa6434e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Flow.class, WorkPackage.class, WorkPackage.class); // generated from 'InformationFlow'{ea3b4375-cb8d-44ee-ad55-32b5e5ffe736} Standard.InformationFlow

    }

    @objid ("e4f41a88-3d01-4ebf-845f-dd1c9312b281")
    protected void registerLinkExpertForTriggering() {
        // Archimate.Triggering
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Triggering.class);

        // Archimate.Triggering sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Triggering.class, "from");
        this.ruleLinkExpert.addTargetDep(Triggering.class, "to");


        // Archimate.Triggering rules:

        this.ruleLinkExpert.addRule(Triggering.class, ApplicationEvent.class, ApplicationEvent.class); // generated from 'InformationFlow'{1b45f85a-5426-4e5c-abfd-6d7b6b6e46e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationEvent.class, ApplicationFunction.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationEvent.class, ApplicationInteraction.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationEvent.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationEvent.class, ApplicationProcess.class); // generated from 'InformationFlow'{bf22b99f-4830-462a-9adc-4c1e5052db4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationFunction.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInteraction.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInternalBehaviorElement.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationProcess.class, ApplicationEvent.class); // generated from 'InformationFlow'{ea3fb02f-5125-4b54-a1cc-5db327ff60b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationFunction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationFunction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationFunction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationFunction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInteraction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInteraction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInteraction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInteraction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInternalBehaviorElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInternalBehaviorElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInternalBehaviorElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationInternalBehaviorElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationProcess.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationProcess.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationProcess.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationProcess.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ApplicationService.class, ApplicationService.class); // generated from 'InformationFlow'{f53c1a57-41e7-4b49-9435-a487b5e30472} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessFunction.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessInteraction.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessProcess.class); // generated from 'InformationFlow'{bfb7283d-0b44-4d21-8f7a-3721b136935f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessEvent.class); // generated from 'InformationFlow'{5815c166-a3d4-4c60-be18-d5211c81798d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessEvent.class, BusinessService.class); // generated from 'InformationFlow'{58e0e07e-9a81-47d4-87d4-cf4ef8ae1d1f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessFunction.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInteraction.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInternalBehaviorElement.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessProcess.class, BusinessEvent.class); // generated from 'InformationFlow'{0a86466e-c198-48e5-acc5-a0916e1b42b9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, BusinessService.class, BusinessEvent.class); // generated from 'InformationFlow'{680140c3-971e-4a1c-a820-65fec20146de} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, CourseOfAction.class, CourseOfAction.class); // generated from 'InformationFlow'{9e01a407-6a46-4c44-86b0-9aea1b5dfa4f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ImplementationEvent.class, WorkPackage.class); // generated from 'InformationFlow'{bb9d2b54-4e11-4086-bd65-357e70682111} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ImplementationEvent.class, Plateau.class); // generated from 'InformationFlow'{43676eae-a67e-4ebe-a771-4fc3ccf289a1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ImplementationEvent.class, ImplementationEvent.class); // generated from 'InformationFlow'{7f6ca99f-cf4b-497e-b85c-30b29a253f9d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, Plateau.class, ImplementationEvent.class); // generated from 'InformationFlow'{741cd24b-3247-4216-b63f-d3d2a6a0e48e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, Plateau.class, Plateau.class); // generated from 'InformationFlow'{8862db9e-d8db-4ab9-aac3-0f2d49a6b32a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, Capability.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, Capability.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, Capability.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, StrategyBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, StrategyBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, StrategyBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ValueStream.class, Capability.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ValueStream.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, ValueStream.class, ValueStream.class); // generated from 'InformationFlow'{ccdc0465-3695-42ba-9f5e-4c6d469e9c3b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyEvent.class, TechnologyFunction.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyEvent.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyEvent.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyEvent.class, TechnologyProcess.class); // generated from 'InformationFlow'{ec5c118c-d8f2-4d6e-970e-dcaee9321579} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyEvent.class, TechnologyService.class); // generated from 'InformationFlow'{58287b28-fe8f-47a6-a91a-268f8603b1b5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyFunction.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInteraction.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInternalBehaviorElement.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyProcess.class, TechnologyEvent.class); // generated from 'InformationFlow'{fb011cf4-8096-4d2f-9a3c-9788414c8787} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyFunction.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyFunction.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyFunction.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyFunction.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInteraction.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInteraction.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInteraction.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInteraction.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInternalBehaviorElement.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInternalBehaviorElement.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInternalBehaviorElement.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyInternalBehaviorElement.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyProcess.class, TechnologyFunction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyProcess.class, TechnologyInteraction.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyProcess.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyProcess.class, TechnologyProcess.class); // generated from 'InformationFlow'{adf659ee-76e5-4da7-9766-85f187940c8e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, TechnologyService.class, TechnologyEvent.class); // generated from 'InformationFlow'{42b60fe8-d476-453d-a9b4-adc6c1d0eef6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, WorkPackage.class, ImplementationEvent.class); // generated from 'InformationFlow'{cc88d82a-ab7c-48da-81be-d9632fa6434e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Triggering.class, WorkPackage.class, WorkPackage.class); // generated from 'InformationFlow'{ea3b4375-cb8d-44ee-ad55-32b5e5ffe736} Standard.InformationFlow

    }

    @objid ("9885e337-e024-47d7-86c2-91a4e4919036")
    protected void registerLinkExpertForSpecialization() {
        // Archimate.Specialization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Specialization.class);

        // Archimate.Specialization sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Specialization.class, "from");
        this.ruleLinkExpert.addTargetDep(Specialization.class, "to");


        // Archimate.Specialization rules: all allowed.

        this.ruleLinkExpert.addRule(Specialization.class, null, null);

    }

    @objid ("de89b680-1414-42af-9a00-6e9ea0f32f31")
    protected void registerLinkExpertForAggregation() {
        // Archimate.Aggregation
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Aggregation.class);

        // Archimate.Aggregation sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Aggregation.class, "from");
        this.ruleLinkExpert.addTargetDep(Aggregation.class, "to");


        // Archimate.Aggregation rules:

        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationCollaboration.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8345b052-36b1-4e3c-9336-ca39c3df954f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationCollaboration.class, ApplicationComponent.class); // generated from 'InformationFlow'{8345b052-36b1-4e3c-9336-ca39c3df954f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationCollaboration.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8345b052-36b1-4e3c-9336-ca39c3df954f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationFunction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationFunction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationFunction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationFunction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInteraction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInteraction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInteraction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInteraction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInternalBehaviorElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInternalBehaviorElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInternalBehaviorElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationInternalBehaviorElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationProcess.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationProcess.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationProcess.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ApplicationProcess.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Artifact.class, Artifact.class); // generated from ''{78865c54-6a20-4be3-90e2-df5c230e9c33} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Assessment.class, Assessment.class); // generated from ''{16775885-f801-489c-969c-fea07ced3c09} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessActor.class, BusinessActor.class); // generated from ''{757e94d8-b7e5-4c48-87c3-739ebd5f00ac} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessCollaboration.class, BusinessActor.class); // generated from 'InformationFlow'{ae0031ae-04d5-45d5-ab85-09999ca4b5f5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessCollaboration.class, BusinessCollaboration.class); // generated from 'InformationFlow'{ae0031ae-04d5-45d5-ab85-09999ca4b5f5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessCollaboration.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{ae0031ae-04d5-45d5-ab85-09999ca4b5f5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessCollaboration.class, BusinessRole.class); // generated from 'InformationFlow'{ae0031ae-04d5-45d5-ab85-09999ca4b5f5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessCollaboration.class, BusinessCollaboration.class); // generated from ''{0cf1d85e-85b9-40f9-b14e-898cff18723d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessFunction.class, BusinessFunction.class); // generated from ''{a432e5f6-c76a-449b-a9b9-8dc1656e04cf} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessObject.class, BusinessObject.class); // generated from ''{bf3a5aaf-f0f0-4897-bf2b-edb88d334fc5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessObject.class, Contract.class); // generated from ''{bf3a5aaf-f0f0-4897-bf2b-edb88d334fc5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Contract.class, BusinessObject.class); // generated from ''{bf3a5aaf-f0f0-4897-bf2b-edb88d334fc5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Contract.class, Contract.class); // generated from ''{bf3a5aaf-f0f0-4897-bf2b-edb88d334fc5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, BusinessRole.class, BusinessRole.class); // generated from ''{84564b3b-8b66-466a-8779-e026418b023f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CommunicationNetwork.class, Device.class); // generated from 'InformationFlow'{6594afb9-3461-4e2b-a0b3-9d44091e9b79} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CommunicationNetwork.class, SystemSoftware.class); // generated from 'InformationFlow'{ba6010eb-be54-48dd-9b02-ef370b5c807c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, CompositeElement.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Grouping.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Constraint.class, Constraint.class); // generated from ''{d441b1f3-553c-462d-b1b4-e3ee0addf3db} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Contract.class, Contract.class); // generated from ''{54098338-fdd3-438d-bb37-7eba8810655c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Deliverable.class, Deliverable.class); // generated from ''{5fb42b7f-6e74-4d79-a81b-4e640070073f} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Device.class, Device.class); // generated from ''{af24cb4c-d257-4b0e-af47-f055e241271b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, DistributionNetwork.class, Facility.class); // generated from 'InformationFlow'{2070c2ff-0c51-468a-b4f9-45e6f00e3082} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, DistributionNetwork.class, Equipment.class); // generated from 'InformationFlow'{a538f533-f20c-4f6f-bf5e-91efe3fdc22d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Driver.class, Driver.class); // generated from ''{01124ad7-7fb5-4d5e-afad-535da1b99a85} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Equipment.class, Equipment.class); // generated from ''{e9a69067-a5a5-4c66-ae7f-6e5eadc98055} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Facility.class, Facility.class); // generated from ''{2c48796b-5387-4570-b707-f2d99f9b9941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Gap.class, Gap.class); // generated from ''{a5e07f6b-1791-4cb8-8c8a-41e3a6bf61a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Goal.class, Goal.class); // generated from ''{5d16b01d-11db-4cb7-af09-e7f113f4a30e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, ImplementationEvent.class, ImplementationEvent.class); // generated from ''{6c71bbaf-2f79-4fe6-9292-0fe3e673d9ce} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Location.class, Location.class); // generated from ''{66d54fbb-d5d1-47c5-adf6-1fed8130bc9d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Material.class, Material.class); // generated from ''{9f0a6e2a-60b2-4319-b890-1411a1a76a95} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Meaning.class, Meaning.class); // generated from ''{139f970a-ccaa-4784-a20d-4446b28a91a5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Outcome.class, Outcome.class); // generated from ''{204b3722-8089-4f81-a574-30c5f2035bd8} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, Device.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, Equipment.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, Facility.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, Node.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, SystemSoftware.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Path.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{b67dfc9a-f54c-42ef-b716-a28c587784e7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Location.class); // generated from 'InformationFlow'{5b376bf3-339b-4483-891d-0d1e338b6341} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Product.class); // generated from 'InformationFlow'{b046d7bf-e88c-420d-97c1-758022e702bb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, AndJunction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Junction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, OrJunction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, RelationshipConnector.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Access.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Aggregation.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Assignment.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Association.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Composition.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DependencyRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DynamicRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Flow.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Influence.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, OtherRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Realization.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Relationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Serving.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Specialization.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, StructuralRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Triggering.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Goal.class); // generated from 'InformationFlow'{9193210f-7c83-4a65-9067-e2558a6d855c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Constraint.class); // generated from 'InformationFlow'{f2d4b952-4426-4e54-a13f-a79fdd65bb29} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Requirement.class); // generated from 'InformationFlow'{f2d4b952-4426-4e54-a13f-a79fdd65bb29} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationComponent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ApplicationService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Artifact.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessActor.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessRole.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, BusinessService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Capability.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, CommunicationNetwork.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Contract.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DataObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Device.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, DistributionNetwork.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Equipment.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Facility.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Material.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Node.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Path.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Representation.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, SystemSoftware.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, TechnologyService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, ValueStream.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Plateau.class, Plateau.class); // generated from ''{754e42eb-dc4d-4b57-b9a7-bc866630008e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Principle.class, Principle.class); // generated from ''{22b5458b-0abf-4f39-829b-cee76580f30e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessService.class); // generated from 'InformationFlow'{0c8fa4e8-cc26-4d6c-8c7c-cc373c960cf4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, ApplicationService.class); // generated from 'InformationFlow'{b24374de-72dd-4a49-b6ba-45cf6a504bae} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyService.class); // generated from 'InformationFlow'{1745b494-12d5-4c68-8cb6-274f8f66cb2b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessObject.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Contract.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Representation.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, DataObject.class); // generated from 'InformationFlow'{44cb2d81-127b-4409-856f-341e9e7537f1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Artifact.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, Material.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Product.class, TechnologyObject.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Representation.class, Representation.class); // generated from ''{0f5aa7c4-d722-4042-a526-3bd391b74e54} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Constraint.class, Constraint.class); // generated from ''{150ba24f-4d63-4635-9883-0be65682c86e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Constraint.class, Requirement.class); // generated from ''{150ba24f-4d63-4635-9883-0be65682c86e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Requirement.class, Constraint.class); // generated from ''{150ba24f-4d63-4635-9883-0be65682c86e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Requirement.class, Requirement.class); // generated from ''{150ba24f-4d63-4635-9883-0be65682c86e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Stakeholder.class, Stakeholder.class); // generated from ''{cbf51117-55d4-4513-83cd-250606f45a8b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, Device.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, Equipment.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, Facility.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, Node.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, SystemSoftware.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, TechnologyCollaboration.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyCollaboration.class, TechnologyInternalActiveStructureElement.class); // generated from '2..*'{93f74dad-aa83-4b16-b7cb-c64e0a4d1be9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Artifact.class, Artifact.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Artifact.class, Material.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Artifact.class, TechnologyObject.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Material.class, Artifact.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Material.class, Material.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Material.class, TechnologyObject.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyObject.class, Artifact.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyObject.class, Material.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, TechnologyObject.class, TechnologyObject.class); // generated from ''{411e8824-7112-452f-9063-e08215a1d0d9} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, Value.class, Value.class); // generated from ''{82101943-8005-495e-a566-a85e518db5b3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Aggregation.class, WorkPackage.class, WorkPackage.class); // generated from ''{98f8b08d-386f-4c53-a120-d294e94a642f} Standard.InformationFlow

    }

    @objid ("97bb9c4e-171a-4062-94e0-fe3102394f86")
    protected void registerLinkExpertForAssignment() {
        // Archimate.Assignment
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Assignment.class);

        // Archimate.Assignment sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Assignment.class, "from");
        this.ruleLinkExpert.addTargetDep(Assignment.class, "to");


        // Archimate.Assignment rules:

        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInterface.class, ApplicationService.class); // generated from 'InformationFlow'{cd88fd1e-ed03-42ba-9d32-89d652008043} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationCollaboration.class, ApplicationEvent.class); // generated from 'InformationFlow'{df107f5e-495f-4885-9ad9-c87911c04765} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationComponent.class, ApplicationEvent.class); // generated from 'InformationFlow'{df107f5e-495f-4885-9ad9-c87911c04765} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInternalActiveStructureElement.class, ApplicationEvent.class); // generated from 'InformationFlow'{df107f5e-495f-4885-9ad9-c87911c04765} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationCollaboration.class, ApplicationFunction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationCollaboration.class, ApplicationInteraction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationCollaboration.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationCollaboration.class, ApplicationProcess.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationComponent.class, ApplicationFunction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationComponent.class, ApplicationInteraction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationComponent.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationComponent.class, ApplicationProcess.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInternalActiveStructureElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInternalActiveStructureElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInternalActiveStructureElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, ApplicationInternalActiveStructureElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{5111832d-7bf6-43df-8b74-037f8ef3d2a2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, Stakeholder.class); // generated from 'InformationFlow'{308927a1-7636-4531-9fcb-0f8bfac45036} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessRole.class); // generated from 'InformationFlow'{379299b3-4630-486f-98a4-e4e546489aab} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInterface.class, BusinessService.class); // generated from 'InformationFlow'{d9ac9cbc-139c-4699-85bd-cb07f92d06e5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, WorkPackage.class); // generated from 'InformationFlow'{bb539274-2081-4789-bad6-0d0f983d52a0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, WorkPackage.class); // generated from 'InformationFlow'{bb539274-2081-4789-bad6-0d0f983d52a0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, WorkPackage.class); // generated from 'InformationFlow'{bb539274-2081-4789-bad6-0d0f983d52a0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, WorkPackage.class); // generated from 'InformationFlow'{bb539274-2081-4789-bad6-0d0f983d52a0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, ImplementationEvent.class); // generated from 'InformationFlow'{26550164-0ea3-4fb3-ad8d-fd5ed6c0f457} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, ImplementationEvent.class); // generated from 'InformationFlow'{26550164-0ea3-4fb3-ad8d-fd5ed6c0f457} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, ImplementationEvent.class); // generated from 'InformationFlow'{26550164-0ea3-4fb3-ad8d-fd5ed6c0f457} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, ImplementationEvent.class); // generated from 'InformationFlow'{26550164-0ea3-4fb3-ad8d-fd5ed6c0f457} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessEvent.class); // generated from 'InformationFlow'{42e6a9bc-7810-4cc0-a6e0-f1a7a648ba5c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, BusinessEvent.class); // generated from 'InformationFlow'{42e6a9bc-7810-4cc0-a6e0-f1a7a648ba5c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, BusinessEvent.class); // generated from 'InformationFlow'{42e6a9bc-7810-4cc0-a6e0-f1a7a648ba5c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, BusinessEvent.class); // generated from 'InformationFlow'{42e6a9bc-7810-4cc0-a6e0-f1a7a648ba5c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessFunction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessInteraction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessActor.class, BusinessProcess.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, BusinessFunction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, BusinessInteraction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessCollaboration.class, BusinessProcess.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, BusinessFunction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessInternalActiveStructureElement.class, BusinessProcess.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, BusinessFunction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, BusinessInteraction.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, BusinessRole.class, BusinessProcess.class); // generated from 'InformationFlow'{e992a5c1-8613-406a-b46a-cb5918f51c1c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, SystemSoftware.class); // generated from 'InformationFlow'{5b30c161-38ea-47ef-bac4-27b70343d4f8} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyFunction.class); // generated from 'InformationFlow'{a2bcb543-912e-46e0-aeef-d155af822ed4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyInteraction.class); // generated from 'InformationFlow'{a2bcb543-912e-46e0-aeef-d155af822ed4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{a2bcb543-912e-46e0-aeef-d155af822ed4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyProcess.class); // generated from 'InformationFlow'{a2bcb543-912e-46e0-aeef-d155af822ed4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, Material.class); // generated from 'InformationFlow'{10d03519-08d2-4484-8ff0-86ca77a326ca} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, BusinessActor.class); // generated from 'InformationFlow'{d3747fa8-15f1-43c0-a895-eb2493a55a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, BusinessCollaboration.class); // generated from 'InformationFlow'{d3747fa8-15f1-43c0-a895-eb2493a55a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{d3747fa8-15f1-43c0-a895-eb2493a55a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, BusinessRole.class); // generated from 'InformationFlow'{d3747fa8-15f1-43c0-a895-eb2493a55a87} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, Device.class); // generated from 'InformationFlow'{669365f7-1f3a-4dde-ba5f-636f79e20965} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, Equipment.class); // generated from 'InformationFlow'{669365f7-1f3a-4dde-ba5f-636f79e20965} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, Facility.class); // generated from 'InformationFlow'{669365f7-1f3a-4dde-ba5f-636f79e20965} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, Node.class); // generated from 'InformationFlow'{669365f7-1f3a-4dde-ba5f-636f79e20965} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, SystemSoftware.class); // generated from 'InformationFlow'{669365f7-1f3a-4dde-ba5f-636f79e20965} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Resource.class, Capability.class); // generated from 'InformationFlow'{599ce2f5-22e7-4bb6-a37d-9eb97d9d2d32} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Resource.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{599ce2f5-22e7-4bb6-a37d-9eb97d9d2d32} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Resource.class, ValueStream.class); // generated from 'InformationFlow'{599ce2f5-22e7-4bb6-a37d-9eb97d9d2d32} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, SystemSoftware.class); // generated from ''{3929ae35-0530-4b18-b8ec-b0ab9b621651} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInterface.class, TechnologyService.class); // generated from 'InformationFlow'{599a2efb-01b0-4b9d-86dd-0098339ba6f4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, Artifact.class); // generated from 'InformationFlow'{11beec5a-23b5-445b-bd57-b5381ae521b0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, TechnologyEvent.class); // generated from 'InformationFlow'{804dd8ae-3ca7-4d2b-b1e5-7ac9ea0883be} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Device.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Equipment.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Facility.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, Node.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, SystemSoftware.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyCollaboration.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, TechnologyFunction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, TechnologyInteraction.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Assignment.class, TechnologyInternalActiveStructureElement.class, TechnologyProcess.class); // generated from 'InformationFlow'{ebbcbc57-4adf-4d20-9a31-c65471266cf2} Standard.InformationFlow

    }

    @objid ("2f4e4e0a-b54d-45e1-bd3c-88066cf33bc7")
    protected void registerLinkExpertForComposition() {
        // Archimate.Composition
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Composition.class);

        // Archimate.Composition sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Composition.class, "from");
        this.ruleLinkExpert.addTargetDep(Composition.class, "to");


        // Archimate.Composition rules:

        this.ruleLinkExpert.addRule(Composition.class, ApplicationCollaboration.class, ApplicationInterface.class); // generated from 'InformationFlow'{728ca6ff-0ddf-4fe7-b6ab-dc6fc77b2990} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationComponent.class, ApplicationInterface.class); // generated from 'InformationFlow'{728ca6ff-0ddf-4fe7-b6ab-dc6fc77b2990} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInternalActiveStructureElement.class, ApplicationInterface.class); // generated from 'InformationFlow'{728ca6ff-0ddf-4fe7-b6ab-dc6fc77b2990} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationFunction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationFunction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationFunction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationFunction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInteraction.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInteraction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInteraction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInteraction.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInternalBehaviorElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInternalBehaviorElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInternalBehaviorElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationInternalBehaviorElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationProcess.class, ApplicationFunction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationProcess.class, ApplicationInteraction.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationProcess.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, ApplicationProcess.class, ApplicationProcess.class); // generated from 'InformationFlow'{76e67497-ad45-47ca-a0fa-6ce75fb17f66} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessActor.class, BusinessInterface.class); // generated from 'InformationFlow'{53ed93aa-5146-494f-8aca-a026a420bee3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessCollaboration.class, BusinessInterface.class); // generated from 'InformationFlow'{53ed93aa-5146-494f-8aca-a026a420bee3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInternalActiveStructureElement.class, BusinessInterface.class); // generated from 'InformationFlow'{53ed93aa-5146-494f-8aca-a026a420bee3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessRole.class, BusinessInterface.class); // generated from 'InformationFlow'{53ed93aa-5146-494f-8aca-a026a420bee3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, BusinessProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{dcda00d7-020e-4c09-9c3a-ae0c073f2377} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, CompositeElement.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Grouping.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Location.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Access.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Aggregation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, AndJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationComponent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Artifact.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Assessment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Assignment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Association.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessActor.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessRole.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Capability.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, CommunicationNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, CompositeElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Composition.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Concept.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Constraint.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Contract.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, CourseOfAction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, DataObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Deliverable.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, DependencyRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Device.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, DistributionNetwork.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Driver.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, DynamicRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Element.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Equipment.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Event.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Facility.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Flow.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Gap.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Goal.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Grouping.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ImplementationEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Influence.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Junction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Location.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Material.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Meaning.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, MotivationElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Node.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, OrJunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, OtherRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Outcome.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, PassiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Path.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Plateau.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Principle.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Product.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Realization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Relationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, RelationshipConnector.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Representation.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Requirement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Resource.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Serving.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Specialization.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Stakeholder.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, StructuralRelationship.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, StructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, SystemSoftware.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyEvent.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyFunction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyInteraction.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyInterface.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyObject.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyProcess.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyService.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Triggering.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Value.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ValueStream.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, WorkPackage.class); // generated from 'InformationFlow'{8a4379b2-38b4-4cd6-bc64-97725f32bd17} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Location.class); // generated from 'InformationFlow'{5b376bf3-339b-4483-891d-0d1e338b6341} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Product.class); // generated from 'InformationFlow'{b046d7bf-e88c-420d-97c1-758022e702bb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, AndJunction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Junction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, OrJunction.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, RelationshipConnector.class); // generated from 'InformationFlow'{9839640b-891d-493a-839b-01a081f4f627} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Access.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Aggregation.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Assignment.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Association.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Composition.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DependencyRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DynamicRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Flow.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Influence.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, OtherRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Realization.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Relationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Serving.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Specialization.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, StructuralRelationship.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Triggering.class); // generated from 'InformationFlow'{fed0aa1a-21fb-4b16-9e49-cc2f597a8941} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Goal.class); // generated from 'InformationFlow'{9193210f-7c83-4a65-9067-e2558a6d855c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Constraint.class); // generated from 'InformationFlow'{f2d4b952-4426-4e54-a13f-a79fdd65bb29} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Requirement.class); // generated from 'InformationFlow'{f2d4b952-4426-4e54-a13f-a79fdd65bb29} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationComponent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ApplicationService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Artifact.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessActor.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessRole.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, BusinessService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Capability.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, CommunicationNetwork.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Contract.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DataObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Device.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, DistributionNetwork.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Equipment.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Facility.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Material.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Node.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Path.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, Representation.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, SystemSoftware.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyEvent.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyFunction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInteraction.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInterface.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyObject.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyProcess.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, TechnologyService.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Plateau.class, ValueStream.class); // generated from 'InformationFlow'{3a62c165-17ae-4bfe-a7e0-55bc523c9960} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessService.class); // generated from 'InformationFlow'{0c8fa4e8-cc26-4d6c-8c7c-cc373c960cf4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, ApplicationService.class); // generated from 'InformationFlow'{b24374de-72dd-4a49-b6ba-45cf6a504bae} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyService.class); // generated from 'InformationFlow'{1745b494-12d5-4c68-8cb6-274f8f66cb2b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessObject.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Contract.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Representation.class); // generated from 'InformationFlow'{87214f28-8cb3-42da-b56a-29b349dec452} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, DataObject.class); // generated from 'InformationFlow'{44cb2d81-127b-4409-856f-341e9e7537f1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Artifact.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, Material.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Product.class, TechnologyObject.class); // generated from 'InformationFlow'{31fe7d2c-a914-4cde-9f95-6b448122d381} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Device.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Equipment.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Facility.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, Node.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, SystemSoftware.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, TechnologyCollaboration.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Composition.class, TechnologyInternalActiveStructureElement.class, TechnologyInterface.class); // generated from 'InformationFlow'{ce1354cf-3e2b-4b23-a947-57bd7a54a51b} Standard.InformationFlow

    }

    @objid ("03890a7e-ef70-44d8-bc81-e97ab0223f52")
    protected void registerLinkExpertForRealization() {
        // Archimate.Realization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Realization.class);

        // Archimate.Realization sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Realization.class, "from");
        this.ruleLinkExpert.addTargetDep(Realization.class, "to");


        // Archimate.Realization rules:

        this.ruleLinkExpert.addRule(Realization.class, ActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationCollaboration.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationComponent.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInterface.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessActor.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessCollaboration.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInterface.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessRole.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, CommunicationNetwork.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DistributionNetwork.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Path.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyCollaboration.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInterface.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalActiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{c61c3956-1366-48a1-a464-786c604bd477} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationComponent.class, ApplicationComponent.class); // generated from 'InformationFlow'{e13dfe80-3b08-4898-80f9-0d8dd782682a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInterface.class, BusinessInterface.class); // generated from 'InformationFlow'{3d9bca1e-5fbe-4c8d-92bf-15b325aa350e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{93af4e1f-d2c5-4087-80ea-90885a68ac8d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, ApplicationService.class); // generated from 'InformationFlow'{84927b12-c1fe-4431-ad6d-a3d272e65d91} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, ApplicationService.class); // generated from 'InformationFlow'{84927b12-c1fe-4431-ad6d-a3d272e65d91} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, ApplicationService.class); // generated from 'InformationFlow'{84927b12-c1fe-4431-ad6d-a3d272e65d91} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, ApplicationService.class); // generated from 'InformationFlow'{84927b12-c1fe-4431-ad6d-a3d272e65d91} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationService.class, BusinessService.class); // generated from 'InformationFlow'{405447f2-fa3e-4920-bc47-fc80e5db4c44} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, DataObject.class); // generated from 'InformationFlow'{349d3864-6146-4a2d-9e85-de75b2733d14} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{db426d17-3ad3-42ba-89b4-4ac66698efcd} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, ApplicationComponent.class); // generated from 'InformationFlow'{db426d17-3ad3-42ba-89b4-4ac66698efcd} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{db426d17-3ad3-42ba-89b4-4ac66698efcd} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessFunction.class, BusinessService.class); // generated from 'InformationFlow'{799035fe-906d-4b8b-8962-a553ad877fc1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInteraction.class, BusinessService.class); // generated from 'InformationFlow'{799035fe-906d-4b8b-8962-a553ad877fc1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalBehaviorElement.class, BusinessService.class); // generated from 'InformationFlow'{799035fe-906d-4b8b-8962-a553ad877fc1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessProcess.class, BusinessService.class); // generated from 'InformationFlow'{799035fe-906d-4b8b-8962-a553ad877fc1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, CommunicationNetwork.class, Path.class); // generated from 'InformationFlow'{9662c284-ec47-4973-9461-7f5e806397f6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, CourseOfAction.class, Outcome.class); // generated from 'InformationFlow'{9ac58e3e-fe1f-4f79-8529-a934b5faf858} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, CourseOfAction.class, Constraint.class); // generated from 'InformationFlow'{fe176cd7-be29-45f4-a22b-bd0d2ac6cee4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, CourseOfAction.class, Requirement.class); // generated from 'InformationFlow'{fe176cd7-be29-45f4-a22b-bd0d2ac6cee4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DataObject.class, BusinessObject.class); // generated from 'InformationFlow'{2af1ed94-2281-45c0-bd0d-5083e3dd2dc3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DataObject.class, Contract.class); // generated from 'InformationFlow'{2af1ed94-2281-45c0-bd0d-5083e3dd2dc3} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Location.class); // generated from 'InformationFlow'{2e9a008c-4e90-4332-b615-19ffdf153fb4} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Product.class); // generated from 'InformationFlow'{c6628922-b08d-4cee-9aaf-d14ee7a724e6} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Constraint.class); // generated from 'InformationFlow'{a2122645-dfdf-4173-a5a7-35a61c7d4301} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Requirement.class); // generated from 'InformationFlow'{a2122645-dfdf-4173-a5a7-35a61c7d4301} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Plateau.class); // generated from 'InformationFlow'{c61ca65a-0a81-4eed-84fa-57d9d99d7cc0} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationComponent.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationEvent.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationFunction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationInteraction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationInterface.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationProcess.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ApplicationService.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Artifact.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessActor.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessCollaboration.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessEvent.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessFunction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessInteraction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessInterface.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessObject.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessProcess.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessRole.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, BusinessService.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Capability.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, CommunicationNetwork.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Contract.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, DataObject.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Device.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, DistributionNetwork.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Equipment.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Facility.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Material.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Node.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Path.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Representation.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, SystemSoftware.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyEvent.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyFunction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyInteraction.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyInterface.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyObject.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyProcess.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, TechnologyService.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, ValueStream.class); // generated from 'InformationFlow'{afda85ad-1c4b-4f7b-a276-954811aea2dc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DistributionNetwork.class, Path.class); // generated from 'realizes'{e942ba11-6c25-4e2f-856e-86fc406c64cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInterface.class, Constraint.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInterface.class, Requirement.class); // generated from 'InformationFlow'{e59f56af-a01c-41cb-a07e-e13332fed82a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationService.class, Capability.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationService.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationService.class, ValueStream.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessService.class, Capability.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessService.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessService.class, ValueStream.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ExternalBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyService.class, Capability.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyService.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyService.class, ValueStream.class); // generated from 'InformationFlow'{d3bf3cab-4bd5-4052-92ae-67555d135a06} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationCollaboration.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationCollaboration.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationComponent.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationComponent.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessActor.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessActor.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessCollaboration.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessCollaboration.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessRole.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessRole.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalActiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalActiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{fa781d0e-127f-4fe5-badf-03a6ab035cdc} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationFunction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInteraction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationInternalBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ApplicationProcess.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessFunction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessFunction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessFunction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInteraction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInteraction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInteraction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessInternalBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessProcess.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessProcess.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessProcess.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, InternalBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, Capability.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, ValueStream.class); // generated from 'InformationFlow'{7721a715-0157-4688-8848-7d020423441c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Location.class, Resource.class); // generated from 'InformationFlow'{79c12623-f4ca-4baf-b3eb-bb0c0693fc81} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Constraint.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Requirement.class); // generated from 'InformationFlow'{16ed8da6-a213-4096-99d8-ae965a310c16} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Device.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Equipment.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Facility.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, Node.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Device.class, SystemSoftware.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Device.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Equipment.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Facility.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, Node.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Equipment.class, SystemSoftware.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Device.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Equipment.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Facility.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, Node.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Facility.class, SystemSoftware.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Device.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Equipment.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Facility.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, Node.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Node.class, SystemSoftware.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Device.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Equipment.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Facility.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Node.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, SystemSoftware.class); // generated from 'InformationFlow'{511adf10-dbef-4041-8f72-5e8ad6a0c9a7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Outcome.class, Goal.class); // generated from 'InformationFlow'{db6408da-c8be-4a60-8706-32f113fe9eed} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessPassiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessPassiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Contract.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Contract.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DataObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DataObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Gap.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Gap.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Material.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Material.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, PassiveStructureElement.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, PassiveStructureElement.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Representation.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Representation.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyObject.class, Constraint.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyObject.class, Requirement.class); // generated from 'InformationFlow'{8d1604f4-6f28-43b2-a2fb-fc4c620c469e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessObject.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, BusinessPassiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Contract.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, DataObject.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Deliverable.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Gap.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Material.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, PassiveStructureElement.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Representation.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyObject.class, Resource.class); // generated from 'InformationFlow'{28c54f98-188d-48c8-9308-c0b6285c717e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Principle.class, Outcome.class); // generated from 'InformationFlow'{42d25ae1-ebff-43b7-b8ad-ec698d9aed2e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Product.class, Resource.class); // generated from 'InformationFlow'{d59213e9-5a6e-4b4d-b7a0-e6a81e40c73c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Representation.class, BusinessObject.class); // generated from 'InformationFlow'{355c0ccf-e0f3-4b75-a562-d2de2c41942d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Representation.class, Contract.class); // generated from 'InformationFlow'{355c0ccf-e0f3-4b75-a562-d2de2c41942d} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Constraint.class, Principle.class); // generated from 'InformationFlow'{24fa5efd-5537-40ad-9b97-dafd458adb62} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Requirement.class, Principle.class); // generated from 'InformationFlow'{24fa5efd-5537-40ad-9b97-dafd458adb62} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Constraint.class, Outcome.class); // generated from 'InformationFlow'{8373d534-d60e-40c1-bfc6-0bcd1c1c6c0c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Requirement.class, Outcome.class); // generated from 'InformationFlow'{8373d534-d60e-40c1-bfc6-0bcd1c1c6c0c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Resource.class, Constraint.class); // generated from 'InformationFlow'{ef6b050b-9a45-437d-8292-5e9c7de0d88b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Resource.class, Requirement.class); // generated from 'InformationFlow'{ef6b050b-9a45-437d-8292-5e9c7de0d88b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Resource.class, Constraint.class); // generated from 'InformationFlow'{55653d87-8eb0-4fe1-8e70-0c98b96c5070} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Resource.class, Requirement.class); // generated from 'InformationFlow'{55653d87-8eb0-4fe1-8e70-0c98b96c5070} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Capability.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Capability.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, StrategyBehaviorElement.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, StrategyBehaviorElement.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ValueStream.class, Constraint.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ValueStream.class, Requirement.class); // generated from 'InformationFlow'{b7ab0660-da97-4f9a-a022-85c6c4b09d59} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Capability.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, StrategyBehaviorElement.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ValueStream.class, CourseOfAction.class); // generated from 'InformationFlow'{46abe3b0-c2d6-4d0b-80b5-d906d62e9015} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Capability.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, StrategyBehaviorElement.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, ValueStream.class, CourseOfAction.class); // generated from 'InformationFlow'{b34c827d-3c52-4342-9d3f-6bcce2caedd1} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, SystemSoftware.class, Artifact.class); // generated from 'InformationFlow'{437e3361-03ea-4ef1-bb7a-df265402cfa5} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInterface.class, BusinessInterface.class); // generated from 'InformationFlow'{fd18070a-8e8a-4848-8da0-2183ea191a5e} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInterface.class, ApplicationInterface.class); // generated from 'InformationFlow'{7856da7c-722a-437c-9ae6-8de9352df974} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, ApplicationFunction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, ApplicationProcess.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, ApplicationFunction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, ApplicationProcess.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, ApplicationFunction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, ApplicationProcess.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, ApplicationFunction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, ApplicationInteraction.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, ApplicationProcess.class); // generated from 'InformationFlow'{8833185a-360d-4cb1-bdd8-9603930cf42c} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, BusinessFunction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, BusinessInteraction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyFunction.class, BusinessProcess.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, BusinessFunction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, BusinessInteraction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInteraction.class, BusinessProcess.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, BusinessFunction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, BusinessInteraction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyInternalBehaviorElement.class, BusinessProcess.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, BusinessFunction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, BusinessInteraction.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyProcess.class, BusinessProcess.class); // generated from 'InformationFlow'{d75a995c-b7d5-46c7-b084-23cb8e144e94} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, BusinessObject.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Artifact.class, Contract.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Material.class, BusinessObject.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, Material.class, Contract.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyObject.class, BusinessObject.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyObject.class, Contract.class); // generated from 'InformationFlow'{01c2b062-b671-4adc-b9ca-8472093766b7} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyService.class, BusinessService.class); // generated from 'InformationFlow'{f6a19d3d-b85e-4b1e-8b11-6f669a7fb811} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, TechnologyService.class, ApplicationService.class); // generated from 'InformationFlow'{86f86ae3-b0f6-46f3-a117-6ad912b98a8a} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Product.class); // generated from 'InformationFlow'{a47a04c1-04c1-4f10-99be-176048c8738b} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationCollaboration.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationComponent.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationEvent.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationFunction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationInteraction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationInterface.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationInternalActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationInternalBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationProcess.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ApplicationService.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Artifact.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessActor.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessCollaboration.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessEvent.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessFunction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessInteraction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessInterface.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessInternalActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessInternalBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessObject.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessPassiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessProcess.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessRole.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, BusinessService.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Capability.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, CommunicationNetwork.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Contract.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, DataObject.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Device.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, DistributionNetwork.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Equipment.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ExternalActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ExternalBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Facility.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, InternalActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, InternalBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Material.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Node.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Path.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Representation.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, StrategyBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, SystemSoftware.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyCollaboration.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyEvent.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyFunction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyInteraction.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyInterface.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyInternalActiveStructureElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyInternalBehaviorElement.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyObject.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyProcess.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, TechnologyService.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, ValueStream.class); // generated from 'InformationFlow'{9fcd4b72-af7a-4bdb-8c12-19867a8581cb} Standard.InformationFlow
        this.ruleLinkExpert.addRule(Realization.class, WorkPackage.class, Deliverable.class); // generated from 'InformationFlow'{65ce56df-f87d-470a-9936-a96a94706b74} Standard.InformationFlow

    }

    @objid ("fdddd867-8393-47ad-97e7-f6ae207479b7")
    protected void registerMetaExpertForRealization() {
        // Archimate.Realization
        // -----------

    }

    @objid ("581c8df4-fa03-41a0-8c02-8d2ded0ee750")
    protected void registerMetaExpertForComposition() {
        // Archimate.Composition
        // -----------

    }

    @objid ("01a8ca69-d5a6-459b-84dc-7ba2d7e38ba6")
    protected void registerMetaExpertForAssignment() {
        // Archimate.Assignment
        // -----------

    }

    @objid ("f1815a6f-d85a-4c5f-be0d-9c7958f22ec9")
    protected void registerMetaExpertForAggregation() {
        // Archimate.Aggregation
        // -----------

    }

    @objid ("be03736f-888f-464e-92df-21c67477528a")
    protected void registerMetaExpertForStructuralRelationship() {
        // Archimate.StructuralRelationship is abstract

        // -----------

    }

    @objid ("36414ee7-e78b-4150-9a55-50857ecad30b")
    protected void registerMetaExpertForSpecialization() {
        // Archimate.Specialization
        // -----------

    }

    @objid ("2104f2e8-6df3-4a34-b352-715363e3dc4a")
    protected void registerMetaExpertForOtherRelationship() {
        // Archimate.OtherRelationship is abstract

        // -----------

    }

    @objid ("0bffca79-6d0d-4594-95dd-50772b3dad54")
    protected void registerMetaExpertForOrJunction() {
        // Archimate.OrJunction
        // -----------

    }

    @objid ("dd86c87c-b33e-4097-8c96-4fbedc56dc06")
    protected void registerMetaExpertForAssociation() {
        // Archimate.Association
        // -----------

    }

    @objid ("f3a720a3-9512-4021-8a47-3dd3500d23e8")
    protected void registerMetaExpertForAndJunction() {
        // Archimate.AndJunction
        // -----------

    }

    @objid ("a2de4d49-3fa6-4c41-b6cc-f42c5e00baef")
    protected void registerMetaExpertForJunction() {
        // Archimate.Junction is abstract

        // -----------

    }

    @objid ("33712ee8-3a3a-4dc9-b63b-1bfbe8f30f43")
    protected void registerMetaExpertForTriggering() {
        // Archimate.Triggering
        // -----------

    }

    @objid ("91b767b4-5ed5-40ee-b78a-83fe0214f800")
    protected void registerMetaExpertForFlow() {
        // Archimate.Flow
        // -----------

    }

    @objid ("873176d1-8544-407b-bb37-9633c7a93d7d")
    protected void registerMetaExpertForDynamicRelationship() {
        // Archimate.DynamicRelationship is abstract

        // -----------

    }

    @objid ("dfd33816-b37b-4c49-8854-71aa9907884f")
    protected void registerMetaExpertForServing() {
        // Archimate.Serving
        // -----------

    }

    @objid ("b5ee6525-72fe-4e63-8c63-41c43c3cd7da")
    protected void registerMetaExpertForInfluence() {
        // Archimate.Influence
        // -----------

    }

    @objid ("0fc0e793-f102-4407-a46c-1619571bf8fc")
    protected void registerMetaExpertForAccess() {
        // Archimate.Access
        // -----------

    }

    @objid ("46e589c0-e479-4f21-837f-e8fba6743934")
    protected void registerMetaExpertForDependencyRelationship() {
        // Archimate.DependencyRelationship is abstract

        // -----------

    }

    @objid ("48af3db5-4f56-44dd-afa9-807476f95f91")
    protected void registerMetaExpertForArtifact() {
        // Archimate.Artifact
        // -----------

    }

    @objid ("4d51781c-ff21-48c7-a02c-00c79bf060ab")
    protected void registerMetaExpertForTechnologyInterface() {
        // Archimate.TechnologyInterface
        // -----------

    }

    @objid ("b147390c-8e97-4179-90ac-e50c88bbd979")
    protected void registerMetaExpertForTechnologyCollaboration() {
        // Archimate.TechnologyCollaboration
        // -----------

    }

    @objid ("9a09e32f-76fb-4bc8-8a0a-09bd6f7c2746")
    protected void registerMetaExpertForSystemSoftware() {
        // Archimate.SystemSoftware
        // -----------

    }

    @objid ("e5b1b9f8-f72e-4e03-899d-72a03a629637")
    protected void registerMetaExpertForPath() {
        // Archimate.Path
        // -----------

    }

    @objid ("1ea93dc6-926c-4867-a032-6645a8e8c5d2")
    protected void registerMetaExpertForDevice() {
        // Archimate.Device
        // -----------

    }

    @objid ("f9bb7d37-2fe2-4568-b79b-9f770825a5ea")
    protected void registerMetaExpertForCommunicationNetwork() {
        // Archimate.CommunicationNetwork
        // -----------

    }

    @objid ("9602ae4b-f57f-4590-953d-761813fcde9b")
    protected void registerMetaExpertForTechnologyService() {
        // Archimate.TechnologyService
        // -----------

    }

    @objid ("7d0e116e-c727-424b-9b81-85893bcaaeee")
    protected void registerMetaExpertForTechnologyProcess() {
        // Archimate.TechnologyProcess
        // -----------

    }

    @objid ("0d64abad-92ae-4f6f-a4bc-c7a078521d1a")
    protected void registerMetaExpertForTechnologyInteraction() {
        // Archimate.TechnologyInteraction
        // -----------

    }

    @objid ("22b141b9-b2ff-49af-9ef3-290a4608522a")
    protected void registerMetaExpertForTechnologyFunction() {
        // Archimate.TechnologyFunction
        // -----------

    }

    @objid ("f276cd9b-9d4b-4994-b512-a70b1998e6dc")
    protected void registerMetaExpertForTechnologyInternalBehaviorElement() {
        // Archimate.TechnologyInternalBehaviorElement is abstract

        // -----------

    }

    @objid ("3a58fb18-024c-4ae2-bbb7-706b69086165")
    protected void registerMetaExpertForTechnologyEvent() {
        // Archimate.TechnologyEvent
        // -----------

    }

    @objid ("5e072068-3534-4bd5-a15e-98c54b08e871")
    protected void registerMetaExpertForResource() {
        // Archimate.Resource
        // -----------

    }

    @objid ("ef86de0d-8ed4-4107-9cd9-e204d9869d2b")
    protected void registerMetaExpertForValueStream() {
        // Archimate.ValueStream
        // -----------

    }

    @objid ("83c4f77f-17d9-468e-abcf-4c9e7d7e603f")
    protected void registerMetaExpertForCourseOfAction() {
        // Archimate.CourseOfAction
        // -----------

    }

    @objid ("54f9b827-9db4-4f79-98c7-d92f30f0a6e5")
    protected void registerMetaExpertForCapability() {
        // Archimate.Capability
        // -----------

    }

    @objid ("3bc72990-a42c-49bd-9458-be75e17df025")
    protected void registerMetaExpertForStrategyBehaviorElement() {
        // Archimate.StrategyBehaviorElement is abstract

        // -----------

    }

    @objid ("c5628f4a-201b-4792-a67f-58fd581ac09c")
    protected void registerMetaExpertForMaterial() {
        // Archimate.Material
        // -----------

    }

    @objid ("4aea7bd0-3dc9-4849-b041-3d3d7966b43c")
    protected void registerMetaExpertForTechnologyObject() {
        // Archimate.TechnologyObject is abstract

        // -----------

    }

    @objid ("d4294d76-e164-4a32-95e5-030f689d21ed")
    protected void registerMetaExpertForFacility() {
        // Archimate.Facility
        // -----------

    }

    @objid ("bb4735ab-51b5-4d19-94d8-8b3c962f0978")
    protected void registerMetaExpertForEquipment() {
        // Archimate.Equipment
        // -----------

    }

    @objid ("4f7d41e3-e279-4f7e-9a2e-605b146ec5c8")
    protected void registerMetaExpertForNode() {
        // Archimate.Node
        // -----------

    }

    @objid ("2bc22400-49d0-4e0c-9186-2018fa50e48d")
    protected void registerMetaExpertForTechnologyInternalActiveStructureElement() {
        // Archimate.TechnologyInternalActiveStructureElement is abstract

        // -----------

    }

    @objid ("73897fea-1f03-4125-86ba-48ccc1eba268")
    protected void registerMetaExpertForDistributionNetwork() {
        // Archimate.DistributionNetwork
        // -----------

    }

    @objid ("4a52bcfd-368c-4133-8432-372f04253800")
    protected void registerMetaExpertForTechnologyActiveStructureElement() {
        // Archimate.TechnologyActiveStructureElement is abstract

        // -----------

    }

    @objid ("20a24204-f955-45ff-8805-533ce8c0309d")
    protected void registerMetaExpertForValue() {
        // Archimate.Value
        // -----------

    }

    @objid ("e81125fd-f62a-4098-98d9-146dd145a747")
    protected void registerMetaExpertForStakeholder() {
        // Archimate.Stakeholder
        // -----------

    }

    @objid ("6b6f4b16-0f2a-4f71-ba72-86c470b56d69")
    protected void registerMetaExpertForPrinciple() {
        // Archimate.Principle
        // -----------

    }

    @objid ("7f5dde9f-60b3-4991-87d1-022d417583a8")
    protected void registerMetaExpertForOutcome() {
        // Archimate.Outcome
        // -----------

    }

    @objid ("b962595e-cb1f-4bd9-956a-728f42de8746")
    protected void registerMetaExpertForMeaning() {
        // Archimate.Meaning
        // -----------

    }

    @objid ("8cfa7f5f-0f95-4557-971e-69b25555f1ad")
    protected void registerMetaExpertForGoal() {
        // Archimate.Goal
        // -----------

    }

    @objid ("a33715eb-cd25-42e5-a9b8-1fc138b79270")
    protected void registerMetaExpertForDriver() {
        // Archimate.Driver
        // -----------

    }

    @objid ("057e76cd-bad8-4fee-8fe7-70b1372b4019")
    protected void registerMetaExpertForConstraint() {
        // Archimate.Constraint
        // -----------

    }

    @objid ("eb9bf80e-f6dc-45a3-9c8f-4b8a79cc9f55")
    protected void registerMetaExpertForRequirement() {
        // Archimate.Requirement
        // -----------

    }

    @objid ("f7923374-e342-4da2-93be-2632ba007ba1")
    protected void registerMetaExpertForAssessment() {
        // Archimate.Assessment
        // -----------

    }

    @objid ("c818089f-f005-4d80-8e33-e9e821b6cfe3")
    protected void registerMetaExpertForWorkPackage() {
        // Archimate.WorkPackage
        // -----------

    }

    @objid ("1dd54d80-f058-4197-a232-499c7296b07c")
    protected void registerMetaExpertForPlateau() {
        // Archimate.Plateau
        // -----------

    }

    @objid ("bfaf7b74-05ef-4d7f-85d8-93799e75a728")
    protected void registerMetaExpertForImplementationEvent() {
        // Archimate.ImplementationEvent
        // -----------

    }

    @objid ("83b39f0e-8ada-4c09-854e-308e4124c6b6")
    protected void registerMetaExpertForGap() {
        // Archimate.Gap
        // -----------

    }

    @objid ("61911733-71e0-4d39-a0cb-9db1faa89328")
    protected void registerMetaExpertForDeliverable() {
        // Archimate.Deliverable
        // -----------

    }

    @objid ("3cac7e3e-488f-4843-a857-73887fcd12a5")
    protected void registerMetaExpertForRepresentation() {
        // Archimate.Representation
        // -----------

    }

    @objid ("a057a2e3-e1b3-46d4-8188-4b221b9e4bba")
    protected void registerMetaExpertForContract() {
        // Archimate.Contract
        // -----------

    }

    @objid ("920ef2cb-73b9-416f-adc2-6b8c6c5590ba")
    protected void registerMetaExpertForBusinessObject() {
        // Archimate.BusinessObject
        // -----------

    }

    @objid ("5fc65fe4-50a3-48ba-a273-f642d2b7ceb5")
    protected void registerMetaExpertForBusinessPassiveStructureElement() {
        // Archimate.BusinessPassiveStructureElement is abstract

        // -----------

    }

    @objid ("285be74c-7fad-455f-962a-5a3ebbe5c2da")
    protected void registerMetaExpertForBusinessRole() {
        // Archimate.BusinessRole
        // -----------

    }

    @objid ("0277ba3f-f5f9-4da7-bb63-14f90dea76a6")
    protected void registerMetaExpertForBusinessInterface() {
        // Archimate.BusinessInterface
        // -----------

    }

    @objid ("b95f04a7-aecb-4563-9e0c-dc85ce4eabeb")
    protected void registerMetaExpertForBusinessCollaboration() {
        // Archimate.BusinessCollaboration
        // -----------

    }

    @objid ("2aff149a-5bdd-417f-92e4-2d2348f82c77")
    protected void registerMetaExpertForBusinessActor() {
        // Archimate.BusinessActor
        // -----------

    }

    @objid ("c96a9389-353c-46c0-95d3-d666fcd398d6")
    protected void registerMetaExpertForBusinessInternalActiveStructureElement() {
        // Archimate.BusinessInternalActiveStructureElement is abstract

        // -----------

    }

    @objid ("a0d84f00-1e98-4599-8303-c30e05c33819")
    protected void registerMetaExpertForProduct() {
        // Archimate.Product
        // -----------

    }

    @objid ("cb5076b3-4b25-4e4f-8b31-eceb1720f0ef")
    protected void registerMetaExpertForBusinessService() {
        // Archimate.BusinessService
        // -----------

    }

    @objid ("f678df16-00e1-49f3-89b0-7570d772e0e8")
    protected void registerMetaExpertForBusinessProcess() {
        // Archimate.BusinessProcess
        // -----------

    }

    @objid ("4f8e9edd-f411-4810-ae63-895b7526cb82")
    protected void registerMetaExpertForBusinessInteraction() {
        // Archimate.BusinessInteraction
        // -----------

    }

    @objid ("d3bd5d3f-c6c8-461b-8e44-3036fd75f46b")
    protected void registerMetaExpertForBusinessFunction() {
        // Archimate.BusinessFunction
        // -----------

    }

    @objid ("5838671c-1c77-4544-a2ab-4f893fd7c84b")
    protected void registerMetaExpertForBusinessInternalBehaviorElement() {
        // Archimate.BusinessInternalBehaviorElement is abstract

        // -----------

    }

    @objid ("cae33a61-34ef-46ed-8467-358108a7e555")
    protected void registerMetaExpertForBusinessEvent() {
        // Archimate.BusinessEvent
        // -----------

    }

    @objid ("8ea5cde3-69bc-40c1-af00-9611b77839f8")
    protected void registerMetaExpertForDataObject() {
        // Archimate.DataObject
        // -----------

    }

    @objid ("86e33a0a-8740-4a88-9381-f04411666d88")
    protected void registerMetaExpertForApplicationInterface() {
        // Archimate.ApplicationInterface
        // -----------

    }

    @objid ("119b5f51-cc66-4805-bebd-f176c67f867f")
    protected void registerMetaExpertForApplicationComponent() {
        // Archimate.ApplicationComponent
        // -----------

    }

    @objid ("5aca250f-36e3-4138-a2a8-dadfeb2fea28")
    protected void registerMetaExpertForApplicationCollaboration() {
        // Archimate.ApplicationCollaboration
        // -----------

    }

    @objid ("fe122d70-35f4-4ec2-9a79-6fae4e3a20bf")
    protected void registerMetaExpertForApplicationInternalActiveStructureElement() {
        // Archimate.ApplicationInternalActiveStructureElement is abstract

        // -----------

    }

    @objid ("52c869ff-9aff-4d58-8ca3-c9111b436150")
    protected void registerMetaExpertForApplicationService() {
        // Archimate.ApplicationService
        // -----------

    }

    @objid ("b7e327ba-9059-4bac-8df4-c80ce6624a60")
    protected void registerMetaExpertForApplicationProcess() {
        // Archimate.ApplicationProcess
        // -----------

    }

    @objid ("d55a110f-b817-44eb-8a28-ff84f9298a5c")
    protected void registerMetaExpertForApplicationInteraction() {
        // Archimate.ApplicationInteraction
        // -----------

    }

    @objid ("ba92e9bb-286f-44a3-8c9d-54f44d737395")
    protected void registerMetaExpertForApplicationFunction() {
        // Archimate.ApplicationFunction
        // -----------

    }

    @objid ("5ec00a75-51a2-4513-a8aa-3968090b98c8")
    protected void registerMetaExpertForApplicationInternalBehaviorElement() {
        // Archimate.ApplicationInternalBehaviorElement is abstract

        // -----------

    }

    @objid ("ce633c65-8202-4808-8fb7-1b05e726595e")
    protected void registerMetaExpertForApplicationEvent() {
        // Archimate.ApplicationEvent
        // -----------

    }

    @objid ("e2718aee-ec6d-46ad-a207-d025825349b7")
    protected void registerMetaExpertForViewPointDiagram() {
        // Archimate.ViewPointDiagram
        // -----------

    }

    @objid ("7226ca93-6852-4669-8b51-f9be8a9b3f3c")
    protected void registerMetaExpertForRelationshipConnector() {
        // Archimate.RelationshipConnector is abstract

        // -----------

    }

    @objid ("ea4e39d1-dbe6-4423-854c-1e612e1f65be")
    protected void registerMetaExpertForRelationship() {
        // Archimate.Relationship is abstract

        // -----------

        // no constraint on Relationship.to : Concept from Archimate.Relationship to Archimate.Concept
        this.ruleMetaExpert.addDependencyRule(Access.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Aggregation.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Assignment.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Association.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Composition.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(DependencyRelationship.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(DynamicRelationship.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Flow.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Influence.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(OtherRelationship.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Realization.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Relationship.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Serving.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Specialization.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(StructuralRelationship.class, null, "to");
        this.ruleMetaExpert.addDependencyRule(Triggering.class, null, "to");

    }

    @objid ("3973de6f-43d7-45b7-b09c-3370a6bedcb5")
    protected void registerMetaExpertForArchimateView() {
        // Archimate.ArchimateView
        // -----------

        // no constraint on ArchimateView.context : Model from Archimate.ArchimateView to Archimate.Model
        this.ruleMetaExpert.addDependencyRule(ArchimateView.class, null, "context");

    }

    @objid ("b3894cc3-b876-4751-957f-a074f919c876")
    protected void registerMetaExpertForViewPoint() {
        // Archimate.ViewPoint
        // -----------

        // ModelElement.Product: AbstractDiagram allowed from Archimate.ViewPoint to Archimate.ArchimateView by 'ModelElement.Product'{55cbcc53-b072-4be2-bd2e-85b1998b410b} Standard.InformationFlow
        this.ruleMetaExpert.addDependencyRule(ViewPoint.class, ArchimateView.class, "Product");

        // ModelElement.Product: AbstractDiagram allowed from Archimate.ViewPoint to Archimate.ViewPointDiagram by 'ModelElement.Product'{e3fd9b37-9e5a-482a-83b0-5c1854d48039} Standard.InformationFlow
        this.ruleMetaExpert.addDependencyRule(ViewPoint.class, ViewPointDiagram.class, "Product");

        // no constraint on ViewPoint.child : ViewPoint from Archimate.ViewPoint to Archimate.ViewPoint
        this.ruleMetaExpert.addDependencyRule(ViewPoint.class, null, "child");

        // no constraint on ViewPoint.context : Model from Archimate.ViewPoint to Archimate.Model
        this.ruleMetaExpert.addDependencyRule(ViewPoint.class, null, "context");

    }

    @objid ("4e619cfd-e49b-4e49-a9f6-2016618b337c")
    protected void registerMetaExpertForModel() {
        // Archimate.Model
        // -----------

        // no constraint on Model.folder : Folder from Archimate.Model to Archimate.Folder
        this.ruleMetaExpert.addDependencyRule(Model.class, null, "folder");

    }

    @objid ("8caa9d57-8f4b-4568-89da-2dbc7534f5ad")
    protected void registerMetaExpertForArchimateProject() {
        // Archimate.ArchimateProject
        // -----------

        // no constraint on ArchimateProject.model : Model from Archimate.ArchimateProject to Archimate.Model
        this.ruleMetaExpert.addDependencyRule(ArchimateProject.class, null, "model");

        // no constraint on ArchimateProject.viewPoints : ViewPoint from Archimate.ArchimateProject to Archimate.ViewPoint
        this.ruleMetaExpert.addDependencyRule(ArchimateProject.class, null, "viewPoints");

    }

    @objid ("f4e9bc7f-f5a8-40c9-b7e5-42be1336fca2")
    protected void registerMetaExpertForTechnologyFolder() {
        // Archimate.TechnologyFolder
        // -----------

        // no constraint on TechnologyFolder.folder : TechnologyFolder from Archimate.TechnologyFolder to Archimate.TechnologyFolder
        this.ruleMetaExpert.addDependencyRule(TechnologyFolder.class, null, "folder");

    }

    @objid ("d484eaed-e214-4329-bed9-5a92d510906a")
    protected void registerMetaExpertForStrategyFolder() {
        // Archimate.StrategyFolder
        // -----------

        // no constraint on StrategyFolder.folder : StrategyFolder from Archimate.StrategyFolder to Archimate.StrategyFolder
        this.ruleMetaExpert.addDependencyRule(StrategyFolder.class, null, "folder");

    }

    @objid ("a3b2ff02-773d-4c94-a222-70f6646a87f5")
    protected void registerMetaExpertForPhysicalFolder() {
        // Archimate.PhysicalFolder
        // -----------

        // no constraint on PhysicalFolder.folder : PhysicalFolder from Archimate.PhysicalFolder to Archimate.PhysicalFolder
        this.ruleMetaExpert.addDependencyRule(PhysicalFolder.class, null, "folder");

    }

    @objid ("9d5b37b4-3076-4394-8cb6-e01a14158813")
    protected void registerMetaExpertForMotivationFolder() {
        // Archimate.MotivationFolder
        // -----------

        // no constraint on MotivationFolder.folder : MotivationFolder from Archimate.MotivationFolder to Archimate.MotivationFolder
        this.ruleMetaExpert.addDependencyRule(MotivationFolder.class, null, "folder");

    }

    @objid ("1dee1368-6d6d-46bc-a4dd-e1e14ed8cd5f")
    protected void registerMetaExpertForImplementationFolder() {
        // Archimate.ImplementationFolder
        // -----------

        // no constraint on ImplementationFolder.folder : ImplementationFolder from Archimate.ImplementationFolder to Archimate.ImplementationFolder
        this.ruleMetaExpert.addDependencyRule(ImplementationFolder.class, null, "folder");

    }

    @objid ("e91cafe0-bc70-472e-8cdb-73980831e71e")
    protected void registerMetaExpertForBusinessFolder() {
        // Archimate.BusinessFolder
        // -----------

        // no constraint on BusinessFolder.folder : BusinessFolder from Archimate.BusinessFolder to Archimate.BusinessFolder
        this.ruleMetaExpert.addDependencyRule(BusinessFolder.class, null, "folder");

    }

    @objid ("f90f25ff-2890-4790-95b7-61cf70d11381")
    protected void registerMetaExpertForApplicationFolder() {
        // Archimate.ApplicationFolder
        // -----------

        // no constraint on ApplicationFolder.folder : ApplicationFolder from Archimate.ApplicationFolder to Archimate.ApplicationFolder
        this.ruleMetaExpert.addDependencyRule(ApplicationFolder.class, null, "folder");

    }

    @objid ("9bf1b4e7-ab35-429c-96e6-b148248c25c9")
    protected void registerMetaExpertForFolder() {
        // Archimate.Folder is abstract

        // -----------

        // no constraint on Folder.content : Concept from Archimate.Folder to Archimate.Concept
        this.ruleMetaExpert.addDependencyRule(ApplicationFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(BusinessFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(Folder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(ImplementationFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(Model.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(MotivationFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(PhysicalFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(StrategyFolder.class, null, "content");
        this.ruleMetaExpert.addDependencyRule(TechnologyFolder.class, null, "content");

    }

    @objid ("ce0a937d-dbd8-48a2-a71f-0e115aba9069")
    protected void registerMetaExpertForPassiveStructureElement() {
        // Archimate.PassiveStructureElement is abstract

        // -----------

    }

    @objid ("4540d9c4-469c-4537-8604-3776d2c797d0")
    protected void registerMetaExpertForInternalBehaviorElement() {
        // Archimate.InternalBehaviorElement is abstract

        // -----------

    }

    @objid ("2b7179f1-92b3-4368-8708-96df525e8521")
    protected void registerMetaExpertForInternalActiveStructureElement() {
        // Archimate.InternalActiveStructureElement is abstract

        // -----------

    }

    @objid ("f778b7ec-453d-4236-bc72-60a96328618a")
    protected void registerMetaExpertForExternalBehaviorElement() {
        // Archimate.ExternalBehaviorElement is abstract

        // -----------

    }

    @objid ("490e3bb7-144e-435c-a278-7a0d5133fc4a")
    protected void registerMetaExpertForExternalActiveStructureElement() {
        // Archimate.ExternalActiveStructureElement is abstract

        // -----------

    }

    @objid ("7bc9a968-6058-4e57-a371-8d3e3dc3861e")
    protected void registerMetaExpertForEvent() {
        // Archimate.Event is abstract

        // -----------

    }

    @objid ("630b1c18-2441-4872-a30b-402554694702")
    protected void registerMetaExpertForBehaviorElement() {
        // Archimate.BehaviorElement is abstract

        // -----------

    }

    @objid ("8c2112c1-2a37-40b1-9875-d6d36bb7e273")
    protected void registerMetaExpertForActiveStructureElement() {
        // Archimate.ActiveStructureElement is abstract

        // -----------

    }

    @objid ("dace24f6-ffee-4838-9da5-a993210675cd")
    protected void registerMetaExpertForStructureElement() {
        // Archimate.StructureElement is abstract

        // -----------

    }

    @objid ("1ac225f1-18ce-494c-a707-ecd0565cafc3")
    protected void registerMetaExpertForMotivationElement() {
        // Archimate.MotivationElement is abstract

        // -----------

    }

    @objid ("181ac43d-be0c-453c-a0e6-892e2c35d0b1")
    protected void registerMetaExpertForLocation() {
        // Archimate.Location
        // -----------

    }

    @objid ("beb6605d-8bf0-44a1-bd7b-45327c190e2f")
    protected void registerMetaExpertForGrouping() {
        // Archimate.Grouping
        // -----------

    }

    @objid ("129ecdd5-cd91-4feb-9b57-e7993e48e310")
    protected void registerMetaExpertForCompositeElement() {
        // Archimate.CompositeElement is abstract

        // -----------

    }

    @objid ("5279bf1a-b826-4960-88c7-f3970c062055")
    protected void registerMetaExpertForElement() {
        // Archimate.Element is abstract

        // -----------

    }

    @objid ("4ea4a8d4-0c00-49cc-b298-0b53e5a0f3e7")
    protected void registerMetaExpertForConcept() {
        // Archimate.Concept is abstract

        // -----------

        // no constraint on Concept.relatedTo : Relationship from Archimate.Concept to Archimate.Relationship
        this.ruleMetaExpert.addDependencyRule(Access.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Aggregation.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(AndJunction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationCollaboration.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationComponent.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationEvent.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationFunction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationInteraction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationInterface.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationInternalActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationInternalBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationProcess.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ApplicationService.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Assessment.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Assignment.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Association.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessActor.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessCollaboration.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessEvent.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessFunction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessInteraction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessInterface.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessInternalActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessInternalBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessObject.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessPassiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessProcess.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessRole.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(BusinessService.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Capability.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(CommunicationNetwork.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(CompositeElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Composition.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Concept.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Constraint.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Contract.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(CourseOfAction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(DataObject.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Deliverable.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(DependencyRelationship.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Device.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(DistributionNetwork.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Driver.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(DynamicRelationship.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Element.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Equipment.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ExternalActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ExternalBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Facility.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Flow.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Gap.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Goal.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Grouping.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ImplementationEvent.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Influence.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(InternalActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(InternalBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Junction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Location.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Material.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Meaning.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(MotivationElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(OrJunction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(OtherRelationship.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Outcome.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(PassiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Path.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Plateau.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Principle.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Product.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Realization.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Relationship.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(RelationshipConnector.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Representation.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Requirement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Resource.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Serving.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Specialization.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Stakeholder.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(StrategyBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(StructuralRelationship.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(StructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(SystemSoftware.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyCollaboration.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyEvent.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyFunction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyInteraction.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyInterface.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyInternalActiveStructureElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyInternalBehaviorElement.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyObject.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyProcess.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(TechnologyService.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Triggering.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(Value.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(ValueStream.class, null, "relatedTo");
        this.ruleMetaExpert.addDependencyRule(WorkPackage.class, null, "relatedTo");

    }

    @objid ("c4fe1349-ea1a-4658-b5f1-5fc0f7df5a44")
    protected void registerMetaExpertForArchimateAbstractElement() {
        // Archimate.ArchimateAbstractElement is abstract

        // -----------

    }

}
