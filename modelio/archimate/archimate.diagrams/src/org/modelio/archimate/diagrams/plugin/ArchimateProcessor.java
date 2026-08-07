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
package org.modelio.archimate.diagrams.plugin;

import java.net.URL;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.modelio.archimate.diagrams.editor.archimateview.ArchimateDiagramConfigurer;
import org.modelio.archimate.diagrams.editor.viewpointdiagram.ViewPointDiagramConfigurer;
import org.modelio.archimate.diagrams.elements.access.GmAccessLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.aggregation.GmAggregationLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.andjunction.GmAndJunctionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.GmApplicationCollaborationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationinteraction.GmApplicationInteractionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationinterface.GmApplicationInterfaceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.archimatediagram.GmArchimateDiagramStyleKeys;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.assignment.GmAssignmentLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.association.GmAssociationLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.businessactor.GmBusinessActorStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businesscollaboration.GmBusinessCollaborationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessinteraction.GmBusinessInteractionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessinterface.GmBusinessInterfaceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRoleStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilityStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.communicationnetwork.GmCommunicationNetworkStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.composition.GmCompositionLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.contract.GmContractStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverableStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.device.GmDeviceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.distributionnetwork.GmDistributionNetworkStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.driver.GmDriverStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.facility.GmFacilityStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.factories.ArchimateEditPartFactory;
import org.modelio.archimate.diagrams.elements.factories.ArchimateGmLinkFactory;
import org.modelio.archimate.diagrams.elements.factories.ArchimateGmNodeFactory;
import org.modelio.archimate.diagrams.elements.flow.GmFlowLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.gap.GmGapStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.goal.GmGoalStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.influence.GmInfluenceLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.location.GmLocationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.material.GmMaterialStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.node.GmNodeStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.orjunction.GmOrJunctionSimpleStyleKeys;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomeStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.path.GmPathStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.principle.GmPrincipleStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.product.GmProductStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.realization.GmRealizationLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.resource.GmResourceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.serving.GmServingLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.specialization.GmSpecializationLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwareStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologycollaboration.GmTechnologyCollaborationStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyinteraction.GmTechnologyInteractionStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyinterface.GmTechnologyInterfaceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServiceStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.triggering.GmTriggeringLinkStyleKeys;
import org.modelio.archimate.diagrams.elements.value.GmValueStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.valuestream.GmValueStreamStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.viewpoint.GmViewPointStructuredStyleKeys;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.GmViewPointDiagramStyleKeys;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackageStructuredStyleKeys;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.ViewPointDiagram;
import org.modelio.diagram.editor.plugin.IDiagramConfigurerRegistry;
import org.modelio.diagram.editor.processor.AbstractDiagramInitializationProcessor;
import org.modelio.diagram.elements.core.model.factory.DiagramFactoryRegistry;
import org.modelio.diagram.styles.core.FactoryStyle;
import org.modelio.diagram.styles.core.StyleLoader;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.diagrams.UseCaseDiagram;
import org.osgi.framework.BundleContext;

/**
 * Processor initializing environment for the {@link ArchimateView} and {@link ViewPointDiagram} diagrams.
 */
@objid ("9040df87-229e-4775-8de6-e822567b244b")
public class ArchimateProcessor extends AbstractDiagramInitializationProcessor {
    @objid ("9a0e16e4-ab41-4ad0-be3b-23a7745df83d")
    @Override
    protected void declareFactories(DiagramFactoryRegistry factoryRegistry) {
        factoryRegistry.registerDiagramFactories(ArchimateView.MNAME, new ArchimateGmNodeFactory(), new ArchimateGmLinkFactory(), new ArchimateEditPartFactory());

        factoryRegistry.registerDiagramFactories(ViewPointDiagram.MNAME, new ArchimateGmNodeFactory(), new ArchimateGmLinkFactory(), new ArchimateEditPartFactory());

        factoryRegistry.registerExtensions(UseCaseDiagram.MNAME, ArchimateView.MNAME);
        factoryRegistry.registerExtensions(StaticDiagram.MNAME, ArchimateView.MNAME);

    }

    @objid ("f3a34b09-ce44-4e09-a92e-f1c7d83158c0")
    @Override
    protected void declareFactorySettings(FactoryStyle factoryStyle) {
        StyleLoader loader = new StyleLoader();
        BundleContext bundle = ArchiDiagrams.getContext();
        URL url = FileLocator.find(bundle.getBundle(), new Path("res/factory.settings"), null);

        loader.load(url);

        factoryStyle.injectDefaultValues(loader.getStyleProperties());

    }

    @objid ("772c8bc7-8c19-40b1-acce-79e3ec4766ca")
    @Override
    protected void declareStyleProviders(FactoryStyle factoryStyle) {
        // AndJunction
        factoryStyle.declareProvider(GmAndJunctionSimpleStyleKeys.class);

        // ArchimateView
        factoryStyle.declareProvider(GmArchimateDiagramStyleKeys.class);

        // ViewPointDiagram
        factoryStyle.declareProvider(GmViewPointDiagramStyleKeys.class);

        // ApplicationCollaboration
        factoryStyle.declareProvider(GmApplicationCollaborationStructuredStyleKeys.class);

        // ApplicationComponent
        factoryStyle.declareProvider(GmApplicationComponentStructuredStyleKeys.class);

        // ApplicationEvent
        factoryStyle.declareProvider(GmApplicationEventStructuredStyleKeys.class);

        // ApplicationFunction
        factoryStyle.declareProvider(GmApplicationFunctionStructuredStyleKeys.class);

        // ApplicationInteraction
        factoryStyle.declareProvider(GmApplicationInteractionStructuredStyleKeys.class);

        // ApplicationInterface
        factoryStyle.declareProvider(GmApplicationInterfaceStructuredStyleKeys.class);

        // ApplicationProcess
        factoryStyle.declareProvider(GmApplicationProcessStructuredStyleKeys.class);

        // ApplicationService
        factoryStyle.declareProvider(GmApplicationServiceStructuredStyleKeys.class);

        // Artifact
        factoryStyle.declareProvider(GmArtifactStructuredStyleKeys.class);

        // Assessment
        factoryStyle.declareProvider(GmAssessmentStructuredStyleKeys.class);

        // BusinessActor
        factoryStyle.declareProvider(GmBusinessActorStructuredStyleKeys.class);

        // BusinessCollaboration
        factoryStyle.declareProvider(GmBusinessCollaborationStructuredStyleKeys.class);

        // BusinessEvent
        factoryStyle.declareProvider(GmBusinessEventStructuredStyleKeys.class);

        // BusinessFunction
        factoryStyle.declareProvider(GmBusinessFunctionStructuredStyleKeys.class);

        // BusinessInteraction
        factoryStyle.declareProvider(GmBusinessInteractionStructuredStyleKeys.class);

        // BusinessInterface
        factoryStyle.declareProvider(GmBusinessInterfaceStructuredStyleKeys.class);

        // BusinessObject
        factoryStyle.declareProvider(GmBusinessObjectStructuredStyleKeys.class);

        // BusinessProcess
        factoryStyle.declareProvider(GmBusinessProcessStructuredStyleKeys.class);

        // BusinessRole
        factoryStyle.declareProvider(GmBusinessRoleStructuredStyleKeys.class);

        // BusinessService
        factoryStyle.declareProvider(GmBusinessServiceStructuredStyleKeys.class);

        // Capability
        factoryStyle.declareProvider(GmCapabilityStructuredStyleKeys.class);

        // CommunicationNetwork
        factoryStyle.declareProvider(GmCommunicationNetworkStructuredStyleKeys.class);

        // Constraint
        factoryStyle.declareProvider(GmConstraintStructuredStyleKeys.class);

        // Contract
        factoryStyle.declareProvider(GmContractStructuredStyleKeys.class);

        // CourseOfAction
        factoryStyle.declareProvider(GmCourseOfActionStructuredStyleKeys.class);

        // DataObject
        factoryStyle.declareProvider(GmDataObjectStructuredStyleKeys.class);

        // Deliverable
        factoryStyle.declareProvider(GmDeliverableStructuredStyleKeys.class);

        // Device
        factoryStyle.declareProvider(GmDeviceStructuredStyleKeys.class);

        // DistributionNetwork
        factoryStyle.declareProvider(GmDistributionNetworkStructuredStyleKeys.class);

        // Driver
        factoryStyle.declareProvider(GmDriverStructuredStyleKeys.class);

        // Equipment
        factoryStyle.declareProvider(GmEquipmentStructuredStyleKeys.class);

        // Facility
        factoryStyle.declareProvider(GmFacilityStructuredStyleKeys.class);

        // Gap
        factoryStyle.declareProvider(GmGapStructuredStyleKeys.class);

        // Goal
        factoryStyle.declareProvider(GmGoalStructuredStyleKeys.class);

        // Grouping
        factoryStyle.declareProvider(GmGroupingStructuredStyleKeys.class);

        // ImplementationEvent
        factoryStyle.declareProvider(GmImplementationEventStructuredStyleKeys.class);

        // Location
        factoryStyle.declareProvider(GmLocationStructuredStyleKeys.class);

        // Material
        factoryStyle.declareProvider(GmMaterialStructuredStyleKeys.class);

        // Meaning
        factoryStyle.declareProvider(GmMeaningStructuredStyleKeys.class);

        // Node
        factoryStyle.declareProvider(GmNodeStructuredStyleKeys.class);

        // OrJunction
        factoryStyle.declareProvider(GmOrJunctionSimpleStyleKeys.class);

        // Outcome
        factoryStyle.declareProvider(GmOutcomeStructuredStyleKeys.class);

        // Path
        factoryStyle.declareProvider(GmPathStructuredStyleKeys.class);

        // Plateau
        factoryStyle.declareProvider(GmPlateauStructuredStyleKeys.class);

        // Principle
        factoryStyle.declareProvider(GmPrincipleStructuredStyleKeys.class);

        // Product
        factoryStyle.declareProvider(GmProductStructuredStyleKeys.class);

        // Representation
        factoryStyle.declareProvider(GmRepresentationStructuredStyleKeys.class);

        // Requirement
        factoryStyle.declareProvider(GmRequirementStructuredStyleKeys.class);

        // Resource
        factoryStyle.declareProvider(GmResourceStructuredStyleKeys.class);

        // Stakeholder
        factoryStyle.declareProvider(GmStakeholderStructuredStyleKeys.class);

        // SystemSoftware
        factoryStyle.declareProvider(GmSystemSoftwareStructuredStyleKeys.class);

        // TechnologyCollaboration
        factoryStyle.declareProvider(GmTechnologyCollaborationStructuredStyleKeys.class);

        // TechnologyEvent
        factoryStyle.declareProvider(GmTechnologyEventStructuredStyleKeys.class);

        // TechnologyFunction
        factoryStyle.declareProvider(GmTechnologyFunctionStructuredStyleKeys.class);

        // TechnologyInterface
        factoryStyle.declareProvider(GmTechnologyInterfaceStructuredStyleKeys.class);

        // TechnologyInteraction
        factoryStyle.declareProvider(GmTechnologyInteractionStructuredStyleKeys.class);

        // TechnologyProcess
        factoryStyle.declareProvider(GmTechnologyProcessStructuredStyleKeys.class);

        // TechnologyService
        factoryStyle.declareProvider(GmTechnologyServiceStructuredStyleKeys.class);

        // Value
        factoryStyle.declareProvider(GmValueStructuredStyleKeys.class);

        // ValueStream
        factoryStyle.declareProvider(GmValueStreamStructuredStyleKeys.class);

        // WorkPackage
        factoryStyle.declareProvider(GmWorkPackageStructuredStyleKeys.class);

        // Access
        factoryStyle.declareProvider(GmAccessLinkStyleKeys.class);

        // Aggregation
        factoryStyle.declareProvider(GmAggregationLinkStyleKeys.class);

        // Assignment
        factoryStyle.declareProvider(GmAssignmentLinkStyleKeys.class);

        // Association
        factoryStyle.declareProvider(GmAssociationLinkStyleKeys.class);

        // Composition
        factoryStyle.declareProvider(GmCompositionLinkStyleKeys.class);

        // Flow
        factoryStyle.declareProvider(GmFlowLinkStyleKeys.class);

        // Influence
        factoryStyle.declareProvider(GmInfluenceLinkStyleKeys.class);

        // Realization
        factoryStyle.declareProvider(GmRealizationLinkStyleKeys.class);

        // Serving
        factoryStyle.declareProvider(GmServingLinkStyleKeys.class);

        // Specialization
        factoryStyle.declareProvider(GmSpecializationLinkStyleKeys.class);

        // Triggering
        factoryStyle.declareProvider(GmTriggeringLinkStyleKeys.class);

        // ViewPoint
        factoryStyle.declareProvider(GmViewPointStructuredStyleKeys.class);

    }

    @objid ("7077bb89-f43c-4536-9112-b1985c781be5")
    @Override
    protected void declareDiagramConfigurers(IDiagramConfigurerRegistry configurerRegistry) {
        configurerRegistry.registerDiagramConfigurer(ArchimateView.MNAME, null, new ArchimateDiagramConfigurer());

        configurerRegistry.registerDiagramConfigurer(ViewPointDiagram.MNAME, null, new ViewPointDiagramConfigurer());

    }

}
