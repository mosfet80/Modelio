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
package org.modelio.archimate.metamodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementSmClass;
import org.modelio.archimate.metamodel.impl.core.ArchimateViewSmClass;
import org.modelio.archimate.metamodel.impl.core.ConceptSmClass;
import org.modelio.archimate.metamodel.impl.core.ElementSmClass;
import org.modelio.archimate.metamodel.impl.core.RelationshipConnectorSmClass;
import org.modelio.archimate.metamodel.impl.core.RelationshipSmClass;
import org.modelio.archimate.metamodel.impl.core.ViewPointDiagramSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.ActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.BehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.EventSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.ExternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.InternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.InternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.PassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.StructureElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.composite.CompositeElementSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.composite.GroupingSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.composite.LocationSmClass;
import org.modelio.archimate.metamodel.impl.core.generic.motivation.MotivationElementSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.ArchimateProjectSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.FolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.ModelSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.ViewPointSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.ApplicationFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.BusinessFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.ImplementationFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.MotivationFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.PhysicalFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.StrategyFolderSmClass;
import org.modelio.archimate.metamodel.impl.core.structure.folder.TechnologyFolderSmClass;
import org.modelio.archimate.metamodel.impl.expert.ArchimateMetamodelExpert;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationEventSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationFunctionSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationInteractionSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationProcessSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.behavior.ApplicationServiceSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.structure.active.ApplicationCollaborationSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.structure.active.ApplicationComponentSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.structure.active.ApplicationInterfaceSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.structure.active.ApplicationInternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.application.structure.passive.DataObjectSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.BusinessPassiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.behavior.BusinessEventSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.behavior.BusinessFunctionSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.behavior.BusinessInteractionSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.behavior.BusinessProcessSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.behavior.BusinessServiceSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.composite.ProductSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.active.BusinessActorSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.active.BusinessCollaborationSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.active.BusinessInterfaceSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.active.BusinessRoleSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.passive.BusinessObjectSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.passive.ContractSmClass;
import org.modelio.archimate.metamodel.impl.layers.business.structure.passive.RepresentationSmClass;
import org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.DeliverableSmClass;
import org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.GapSmClass;
import org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.ImplementationEventSmClass;
import org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.PlateauSmClass;
import org.modelio.archimate.metamodel.impl.layers.implementation_and_migration.WorkPackageSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.AssessmentSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.ConstraintSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.DriverSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.GoalSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.MeaningSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.OutcomeSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.PrincipleSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.RequirementSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.StakeholderSmClass;
import org.modelio.archimate.metamodel.impl.layers.motivation.ValueSmClass;
import org.modelio.archimate.metamodel.impl.layers.physical.structure.active.DistributionNetworkSmClass;
import org.modelio.archimate.metamodel.impl.layers.physical.structure.active.EquipmentSmClass;
import org.modelio.archimate.metamodel.impl.layers.physical.structure.active.FacilitySmClass;
import org.modelio.archimate.metamodel.impl.layers.physical.structure.passive.MaterialSmClass;
import org.modelio.archimate.metamodel.impl.layers.strategy.behavior.CapabilitySmClass;
import org.modelio.archimate.metamodel.impl.layers.strategy.behavior.CourseOfActionSmClass;
import org.modelio.archimate.metamodel.impl.layers.strategy.behavior.StrategyBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.strategy.behavior.ValueStreamSmClass;
import org.modelio.archimate.metamodel.impl.layers.strategy.structure.ResourceSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyEventSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyFunctionSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyInteractionSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyInternalBehaviorElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyProcessSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.behavior.TechnologyServiceSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.CommunicationNetworkSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.DeviceSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.NodeSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.PathSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.SystemSoftwareSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.TechnologyActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.TechnologyCollaborationSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.TechnologyInterfaceSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.active.TechnologyInternalActiveStructureElementSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.passive.ArtifactSmClass;
import org.modelio.archimate.metamodel.impl.layers.technology.structure.passive.TechnologyObjectSmClass;
import org.modelio.archimate.metamodel.impl.mmextensions.modelshield.ArchimateCheckerFactory;
import org.modelio.archimate.metamodel.impl.relationships.dependency.AccessSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dependency.DependencyRelationshipSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dependency.InfluenceSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dependency.ServingSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dynamic.DynamicRelationshipSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dynamic.FlowSmClass;
import org.modelio.archimate.metamodel.impl.relationships.dynamic.TriggeringSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.AndJunctionSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.AssociationSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.JunctionSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.OrJunctionSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.OtherRelationshipSmClass;
import org.modelio.archimate.metamodel.impl.relationships.other.SpecializationSmClass;
import org.modelio.archimate.metamodel.impl.relationships.structural.AggregationSmClass;
import org.modelio.archimate.metamodel.impl.relationships.structural.AssignmentSmClass;
import org.modelio.archimate.metamodel.impl.relationships.structural.CompositionSmClass;
import org.modelio.archimate.metamodel.impl.relationships.structural.RealizationSmClass;
import org.modelio.archimate.metamodel.impl.relationships.structural.StructuralRelationshipSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vbasic.version.VersionedItem;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.mapi.MExpert;
import org.modelio.vcore.smkernel.mapi.MMetamodelFragment;
import org.modelio.vcore.smkernel.mapi.modelshield.spi.ICheckerFactory;
import org.modelio.vcore.smkernel.meta.AbstractMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependencyTypeChecker;
import org.modelio.vcore.smkernel.meta.SmMetamodel;

/**
 * <h2>Metamodel history since&nbsp;ArchiMate 3.0 (Coronado)</h2>
 *
 * <p><strong>Modelio Wyrm (4.0)&nbsp;- 1.0.4&nbsp;</strong><em>(by&nbsp;cma)</em></p><p>+ StrategicBehaviourElement&nbsp;abstract class</p><p>+&nbsp;ApplicationInternalActiveStructureElement abstract class</p><p>+&nbsp;TechnologyActiveStructureElement&nbsp;abstract class</p><p>+&nbsp;TechnologyInternalActiveStructureElement&nbsp;abstract class</p><p>+ ValueStream</p><p>+ Association.IsDirected : boolean</p><p># some inheritance modifications</p><p># updated allowed links</p><p><strong>Modelio Unicorn (3.7)&nbsp;- 1.0.3&nbsp;</strong><em>(by&nbsp;cma)</em></p><p><em>#&nbsp;</em>Influence.strength : type changed from&nbsp;InfluenceStrength to&nbsp;string</p><p><strong>Modelio Toutatis (3.6)&nbsp;- 1.0.2 </strong><em>(by&nbsp;chm)</em></p><p>+ Influence.strength: InfluenceStrength</p><p>+Goal.equivalentRef: string</p><p>+Meaning.equivalentRef: string</p><p>+Requirement.equivalentRef: InfluenceStength</p><p>&nbsp;</p><p><strong>Modelio Toutatis (3.6)&nbsp;- 1.0.1 </strong><em>(by&nbsp;cma)</em></p><p>1st ArchiMate 3.0 metamodel</p>
 */
@objid ("6ac6e274-b974-42eb-8bf3-71ddf61e3e84")
public final class ArchimateMetamodelFragment extends AbstractMetamodelFragment {
    @objid ("b87f0ea7-1cbb-44b1-8223-4389835016e4")
    private static final ArchimateMetamodelFragment INSTANCE = new ArchimateMetamodelFragment();

    @objid ("3be0722e-210e-4e59-ad80-0df47eb3d8df")
    @Override
    public final MExpert createMExpert(SmMetamodel mm) {
        return new ArchimateMetamodelExpert(mm);
    }

    @objid ("2fcbc1a3-395d-4efb-961b-94c665a81bc7")
    public static ArchimateMetamodelFragment getInstance() {
        return ArchimateMetamodelFragment.INSTANCE;
    }

    @objid ("6a9d628b-ee82-45ec-8312-c45246574d0c")
    @Override
    public Collection<VersionedItem<MMetamodelFragment>> getNeededFragments() {
        Collection<VersionedItem<MMetamodelFragment>> ret = new ArrayList<>(super.getNeededFragments());

        ret.add(new VersionedItem<MMetamodelFragment>("Infrastructure", new Version("2.1.03")));

        return ret;

    }

    @objid ("48fba003-de42-4d9f-97eb-92cdd705cda2")
    public ArchimateMetamodelFragment() {
        	super("Archimate", new Version("1.0.4"), "Modeliosoft", "4.0.00");

    }

    @objid ("278720dd-bef1-4f65-ab84-3259ca794792")
    @Override
    public List<SmClass> createMetaclasses() {
        	final List<SmClass> metaclasses = new ArrayList<>(119);
        	metaclasses.add(new ArchimateProjectSmClass(this));
        	metaclasses.add(new ArchimateAbstractElementSmClass(this));
        	metaclasses.add(new ConceptSmClass(this));
        	metaclasses.add(new ElementSmClass(this));
        	metaclasses.add(new BehaviorElementSmClass(this));
        	metaclasses.add(new CourseOfActionSmClass(this));
        	metaclasses.add(new StrategyBehaviorElementSmClass(this));
        	metaclasses.add(new CapabilitySmClass(this));
        	metaclasses.add(new ValueStreamSmClass(this));
        	metaclasses.add(new EventSmClass(this));
        	metaclasses.add(new ApplicationEventSmClass(this));
        	metaclasses.add(new BusinessEventSmClass(this));
        	metaclasses.add(new ImplementationEventSmClass(this));
        	metaclasses.add(new TechnologyEventSmClass(this));
        	metaclasses.add(new ExternalBehaviorElementSmClass(this));
        	metaclasses.add(new ApplicationServiceSmClass(this));
        	metaclasses.add(new BusinessServiceSmClass(this));
        	metaclasses.add(new TechnologyServiceSmClass(this));
        	metaclasses.add(new InternalBehaviorElementSmClass(this));
        	metaclasses.add(new ApplicationInternalBehaviorElementSmClass(this));
        	metaclasses.add(new ApplicationFunctionSmClass(this));
        	metaclasses.add(new ApplicationInteractionSmClass(this));
        	metaclasses.add(new ApplicationProcessSmClass(this));
        	metaclasses.add(new BusinessInternalBehaviorElementSmClass(this));
        	metaclasses.add(new BusinessFunctionSmClass(this));
        	metaclasses.add(new BusinessInteractionSmClass(this));
        	metaclasses.add(new BusinessProcessSmClass(this));
        	metaclasses.add(new TechnologyInternalBehaviorElementSmClass(this));
        	metaclasses.add(new TechnologyFunctionSmClass(this));
        	metaclasses.add(new TechnologyInteractionSmClass(this));
        	metaclasses.add(new TechnologyProcessSmClass(this));
        	metaclasses.add(new WorkPackageSmClass(this));
        	metaclasses.add(new CompositeElementSmClass(this));
        	metaclasses.add(new ProductSmClass(this));
        	metaclasses.add(new GroupingSmClass(this));
        	metaclasses.add(new LocationSmClass(this));
        	metaclasses.add(new PlateauSmClass(this));
        	metaclasses.add(new MotivationElementSmClass(this));
        	metaclasses.add(new AssessmentSmClass(this));
        	metaclasses.add(new DriverSmClass(this));
        	metaclasses.add(new GoalSmClass(this));
        	metaclasses.add(new MeaningSmClass(this));
        	metaclasses.add(new OutcomeSmClass(this));
        	metaclasses.add(new PrincipleSmClass(this));
        	metaclasses.add(new RequirementSmClass(this));
        	metaclasses.add(new ConstraintSmClass(this));
        	metaclasses.add(new StakeholderSmClass(this));
        	metaclasses.add(new ValueSmClass(this));
        	metaclasses.add(new StructureElementSmClass(this));
        	metaclasses.add(new ActiveStructureElementSmClass(this));
        	metaclasses.add(new ExternalActiveStructureElementSmClass(this));
        	metaclasses.add(new ApplicationInterfaceSmClass(this));
        	metaclasses.add(new BusinessInterfaceSmClass(this));
        	metaclasses.add(new TechnologyInterfaceSmClass(this));
        	metaclasses.add(new InternalActiveStructureElementSmClass(this));
        	metaclasses.add(new BusinessInternalActiveStructureElementSmClass(this));
        	metaclasses.add(new BusinessActorSmClass(this));
        	metaclasses.add(new BusinessCollaborationSmClass(this));
        	metaclasses.add(new BusinessRoleSmClass(this));
        	metaclasses.add(new ApplicationInternalActiveStructureElementSmClass(this));
        	metaclasses.add(new ApplicationCollaborationSmClass(this));
        	metaclasses.add(new ApplicationComponentSmClass(this));
        	metaclasses.add(new TechnologyActiveStructureElementSmClass(this));
        	metaclasses.add(new CommunicationNetworkSmClass(this));
        	metaclasses.add(new DistributionNetworkSmClass(this));
        	metaclasses.add(new PathSmClass(this));
        	metaclasses.add(new TechnologyInternalActiveStructureElementSmClass(this));
        	metaclasses.add(new NodeSmClass(this));
        	metaclasses.add(new DeviceSmClass(this));
        	metaclasses.add(new EquipmentSmClass(this));
        	metaclasses.add(new FacilitySmClass(this));
        	metaclasses.add(new SystemSoftwareSmClass(this));
        	metaclasses.add(new TechnologyCollaborationSmClass(this));
        	metaclasses.add(new PassiveStructureElementSmClass(this));
        	metaclasses.add(new BusinessPassiveStructureElementSmClass(this));
        	metaclasses.add(new BusinessObjectSmClass(this));
        	metaclasses.add(new ContractSmClass(this));
        	metaclasses.add(new RepresentationSmClass(this));
        	metaclasses.add(new DataObjectSmClass(this));
        	metaclasses.add(new DeliverableSmClass(this));
        	metaclasses.add(new GapSmClass(this));
        	metaclasses.add(new TechnologyObjectSmClass(this));
        	metaclasses.add(new ArtifactSmClass(this));
        	metaclasses.add(new MaterialSmClass(this));
        	metaclasses.add(new ResourceSmClass(this));
        	metaclasses.add(new RelationshipSmClass(this));
        	metaclasses.add(new DependencyRelationshipSmClass(this));
        	metaclasses.add(new AccessSmClass(this));
        	metaclasses.add(new AssociationSmClass(this));
        	metaclasses.add(new InfluenceSmClass(this));
        	metaclasses.add(new ServingSmClass(this));
        	metaclasses.add(new DynamicRelationshipSmClass(this));
        	metaclasses.add(new FlowSmClass(this));
        	metaclasses.add(new TriggeringSmClass(this));
        	metaclasses.add(new OtherRelationshipSmClass(this));
        	metaclasses.add(new SpecializationSmClass(this));
        	metaclasses.add(new StructuralRelationshipSmClass(this));
        	metaclasses.add(new AggregationSmClass(this));
        	metaclasses.add(new AssignmentSmClass(this));
        	metaclasses.add(new CompositionSmClass(this));
        	metaclasses.add(new RealizationSmClass(this));
        	metaclasses.add(new RelationshipConnectorSmClass(this));
        	metaclasses.add(new JunctionSmClass(this));
        	metaclasses.add(new AndJunctionSmClass(this));
        	metaclasses.add(new OrJunctionSmClass(this));
        	metaclasses.add(new FolderSmClass(this));
        	metaclasses.add(new ApplicationFolderSmClass(this));
        	metaclasses.add(new BusinessFolderSmClass(this));
        	metaclasses.add(new ModelSmClass(this));
        	metaclasses.add(new ImplementationFolderSmClass(this));
        	metaclasses.add(new MotivationFolderSmClass(this));
        	metaclasses.add(new PhysicalFolderSmClass(this));
        	metaclasses.add(new StrategyFolderSmClass(this));
        	metaclasses.add(new TechnologyFolderSmClass(this));
        	metaclasses.add(new ViewPointSmClass(this));
        	metaclasses.add(new ArchimateViewSmClass(this));
        	metaclasses.add(new ViewPointDiagramSmClass(this));

        	 return metaclasses;

    }

    /**
     * Create all the model checker classes.
     *
     * @param metamodel the metamodel
     * @return the live model checkers.
     */
    @objid ("f8195270-c5f3-4471-92ca-123ef0b8bb97")
    @Override
    public final Collection<SmDependencyTypeChecker> createDependencyCheckers(SmMetamodel metamodel) {
        // This code is automatically generated from all checker classes found in
        //   'null' package.
        final List<SmDependencyTypeChecker> checkers = new ArrayList<>(+0);


        return checkers;

    }

    @objid ("a1db1286-e17c-4e01-aefc-10646232da3f")
    @Override
    public final boolean isExtension() {
        return true;

    }

    /**
     * Get the model shield checkers factory.
     *
     * @param metamodel the metamodel
     * @return the model shield checkers factory.
     */
    @objid ("3cf8d3e8-d5d3-42c7-8697-db31b35c8112")
    @Override
    public ICheckerFactory getModelShieldCheckers() {
        return new ArchimateCheckerFactory();

    }

}
