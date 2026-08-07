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
package org.modelio.archimate.ui.browser.contrib;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Comparator for Archimate elements, sorting them by metaclass.
 */
@objid ("68b7e8cb-5c5c-4e72-905f-eb3fd27f5275")
public class ArchimateMetaclassSorter implements Comparator<MObject> {
    /**
     * Defines the standard metaclass order, from top to bottom.
     */
    @objid ("64aeb0aa-716c-4f83-869a-90f3a7e61777")
    private static final List<java.lang.Class<? extends MObject>> ORDERING = Arrays.asList(
    	        Access.class, // 0
    	        ActiveStructureElement.class, // 1
    	        Aggregation.class, // 2
    	        AndJunction.class, // 3
    	        ApplicationCollaboration.class, // 4
    	        ApplicationComponent.class, // 5
    	        ApplicationEvent.class, // 6
    	        ApplicationFolder.class, // 7
    	        ApplicationFunction.class, // 8
    	        ApplicationInteraction.class, // 9
    	        ApplicationInterface.class, // 10
    	        ApplicationInternalBehaviorElement.class, // 11
    	        ApplicationProcess.class, // 12
    	        ApplicationService.class, // 13
    	        ArchimateAbstractElement.class, // 14
    	        ArchimateProject.class, // 15
    	        ArchimateView.class, // 16
    	        Artifact.class, // 17
    	        Assessment.class, // 18
    	        Assignment.class, // 19
    	        Association.class, // 20
    	        BehaviorElement.class, // 21
    	        BusinessActor.class, // 22
    	        BusinessCollaboration.class, // 23
    	        BusinessEvent.class, // 24
    	        BusinessFolder.class, // 25
    	        BusinessFunction.class, // 26
    	        BusinessInteraction.class, // 27
    	        BusinessInterface.class, // 28
    	        BusinessInternalActiveStructureElement.class, // 29
    	        BusinessInternalBehaviorElement.class, // 30
    	        BusinessObject.class, // 31
    	        BusinessPassiveStructureElement.class, // 32
    	        BusinessProcess.class, // 33
    	        BusinessRole.class, // 34
    	        BusinessService.class, // 35
    	        Capability.class, // 36
    	        CommunicationNetwork.class, // 37
    	        CompositeElement.class, // 38
    	        Composition.class, // 39
    	        Concept.class, // 40
    	        Constraint.class, // 41
    	        Contract.class, // 42
    	        CourseOfAction.class, // 43
    	        DataObject.class, // 44
    	        Deliverable.class, // 45
    	        DependencyRelationship.class, // 46
    	        Device.class, // 47
    	        DistributionNetwork.class, // 48
    	        Driver.class, // 49
    	        DynamicRelationship.class, // 50
    	        Element.class, // 51
    	        Equipment.class, // 52
    	        Event.class, // 53
    	        ExternalActiveStructureElement.class, // 54
    	        ExternalBehaviorElement.class, // 55
    	        Facility.class, // 56
    	        Flow.class, // 57
    	        Folder.class, // 58
    	        Gap.class, // 59
    	        Goal.class, // 60
    	        Grouping.class, // 61
    	        ImplementationEvent.class, // 62
    	        ImplementationFolder.class, // 63
    	        Influence.class, // 64
    	        InternalActiveStructureElement.class, // 65
    	        InternalBehaviorElement.class, // 66
    	        Junction.class, // 67
    	        Location.class, // 68
    	        Material.class, // 69
    	        Meaning.class, // 70
    	        Model.class, // 71
    	        MotivationElement.class, // 72
    	        MotivationFolder.class, // 73
    	        Node.class, // 74
    	        OrJunction.class, // 75
    	        OtherRelationship.class, // 76
    	        Outcome.class, // 77
    	        PassiveStructureElement.class, // 78
    	        Path.class, // 79
    	        PhysicalFolder.class, // 80
    	        Plateau.class, // 81
    	        Principle.class, // 82
    	        Product.class, // 83
    	        Realization.class, // 84
    	        Relationship.class, // 85
    	        RelationshipConnector.class, // 86
    	        Representation.class, // 87
    	        Requirement.class, // 88
    	        Resource.class, // 89
    	        Serving.class, // 90
    	        Specialization.class, // 91
    	        Stakeholder.class, // 92
    	        StrategyFolder.class, // 93
    	        StructuralRelationship.class, // 94
    	        StructureElement.class, // 95
    	        SystemSoftware.class, // 96
    	        TechnologyCollaboration.class, // 97
    	        TechnologyEvent.class, // 98
    	        TechnologyFolder.class, // 99
    	        TechnologyFunction.class, // 100
    	        TechnologyInteraction.class, // 101
    	        TechnologyInterface.class, // 102
    	        TechnologyInternalBehaviorElement.class, // 103
    	        TechnologyObject.class, // 104
    	        TechnologyProcess.class, // 105
    	        TechnologyService.class, // 106
    	        Triggering.class, // 107
    	        Value.class, // 108
    	        ViewPoint.class, // 109
    	        ViewPointDiagram.class, // 110
    	        WorkPackage.class // 111
    	);

    @objid ("1f859692-08bd-4d78-a74d-fa8f7669f7c0")
    @Override
    public int compare(MObject mo1, MObject mo2) {
        return Integer.compare(-ArchimateMetaclassSorter.ORDERING.indexOf(mo1.getMClass().getJavaInterface()),
                        -ArchimateMetaclassSorter.ORDERING.indexOf(mo2.getMClass().getJavaInterface()));
    }

static {
            // We do not want unlisted metaclasses to go first because of indexOf == -1, so we have to reverse the stored order
            Collections.reverse(ArchimateMetaclassSorter.ORDERING);
        }

}
