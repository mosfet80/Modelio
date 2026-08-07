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
package org.modelio.archimate.diagrams.elements.factories;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.modelio.archimate.diagrams.elements.access.AccessEditPart;
import org.modelio.archimate.diagrams.elements.access.GmAccess;
import org.modelio.archimate.diagrams.elements.aggregation.AggregationEditPart;
import org.modelio.archimate.diagrams.elements.aggregation.GmAggregation;
import org.modelio.archimate.diagrams.elements.andjunction.AndJunctionEditPart;
import org.modelio.archimate.diagrams.elements.andjunction.GmAndJunction;
import org.modelio.archimate.diagrams.elements.andjunction.GmAndJunctionPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.ApplicationCollaborationEditPart;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.ApplicationCollaborationSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.GmApplicationCollaboration;
import org.modelio.archimate.diagrams.elements.applicationcollaboration.GmApplicationCollaborationPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationcomponent.ApplicationComponentEditPart;
import org.modelio.archimate.diagrams.elements.applicationcomponent.ApplicationComponentSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponent;
import org.modelio.archimate.diagrams.elements.applicationcomponent.GmApplicationComponentPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationevent.ApplicationEventEditPart;
import org.modelio.archimate.diagrams.elements.applicationevent.ApplicationEventSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEvent;
import org.modelio.archimate.diagrams.elements.applicationevent.GmApplicationEventPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationfunction.ApplicationFunctionEditPart;
import org.modelio.archimate.diagrams.elements.applicationfunction.ApplicationFunctionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunction;
import org.modelio.archimate.diagrams.elements.applicationfunction.GmApplicationFunctionPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationinteraction.ApplicationInteractionEditPart;
import org.modelio.archimate.diagrams.elements.applicationinteraction.ApplicationInteractionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationinteraction.GmApplicationInteraction;
import org.modelio.archimate.diagrams.elements.applicationinteraction.GmApplicationInteractionPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationinterface.ApplicationInterfaceEditPart;
import org.modelio.archimate.diagrams.elements.applicationinterface.ApplicationInterfaceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationinterface.GmApplicationInterface;
import org.modelio.archimate.diagrams.elements.applicationinterface.GmApplicationInterfacePrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationprocess.ApplicationProcessEditPart;
import org.modelio.archimate.diagrams.elements.applicationprocess.ApplicationProcessSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcess;
import org.modelio.archimate.diagrams.elements.applicationprocess.GmApplicationProcessPrimaryNode;
import org.modelio.archimate.diagrams.elements.applicationservice.ApplicationServiceEditPart;
import org.modelio.archimate.diagrams.elements.applicationservice.ApplicationServiceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationService;
import org.modelio.archimate.diagrams.elements.applicationservice.GmApplicationServicePrimaryNode;
import org.modelio.archimate.diagrams.elements.archimatediagram.ArchimateDiagramEditPart;
import org.modelio.archimate.diagrams.elements.archimatediagram.GmArchimateDiagram;
import org.modelio.archimate.diagrams.elements.artifact.ArtifactEditPart;
import org.modelio.archimate.diagrams.elements.artifact.ArtifactSimpleEditPart;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifact;
import org.modelio.archimate.diagrams.elements.artifact.GmArtifactPrimaryNode;
import org.modelio.archimate.diagrams.elements.assessment.AssessmentEditPart;
import org.modelio.archimate.diagrams.elements.assessment.AssessmentSimpleEditPart;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessment;
import org.modelio.archimate.diagrams.elements.assessment.GmAssessmentPrimaryNode;
import org.modelio.archimate.diagrams.elements.assignment.AssignmentEditPart;
import org.modelio.archimate.diagrams.elements.assignment.GmAssignment;
import org.modelio.archimate.diagrams.elements.association.AssociationEditPart;
import org.modelio.archimate.diagrams.elements.association.GmAssociation;
import org.modelio.archimate.diagrams.elements.businessactor.BusinessActorEditPart;
import org.modelio.archimate.diagrams.elements.businessactor.BusinessActorSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessactor.GmBusinessActor;
import org.modelio.archimate.diagrams.elements.businessactor.GmBusinessActorPrimaryNode;
import org.modelio.archimate.diagrams.elements.businesscollaboration.BusinessCollaborationEditPart;
import org.modelio.archimate.diagrams.elements.businesscollaboration.BusinessCollaborationSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businesscollaboration.GmBusinessCollaboration;
import org.modelio.archimate.diagrams.elements.businesscollaboration.GmBusinessCollaborationPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessevent.BusinessEventEditPart;
import org.modelio.archimate.diagrams.elements.businessevent.BusinessEventSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEvent;
import org.modelio.archimate.diagrams.elements.businessevent.GmBusinessEventPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessfunction.BusinessFunctionEditPart;
import org.modelio.archimate.diagrams.elements.businessfunction.BusinessFunctionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunction;
import org.modelio.archimate.diagrams.elements.businessfunction.GmBusinessFunctionPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessinteraction.BusinessInteractionEditPart;
import org.modelio.archimate.diagrams.elements.businessinteraction.BusinessInteractionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessinteraction.GmBusinessInteraction;
import org.modelio.archimate.diagrams.elements.businessinteraction.GmBusinessInteractionPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessinterface.BusinessInterfaceEditPart;
import org.modelio.archimate.diagrams.elements.businessinterface.BusinessInterfaceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessinterface.GmBusinessInterface;
import org.modelio.archimate.diagrams.elements.businessinterface.GmBusinessInterfacePrimaryNode;
import org.modelio.archimate.diagrams.elements.businessobject.BusinessObjectEditPart;
import org.modelio.archimate.diagrams.elements.businessobject.BusinessObjectSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObject;
import org.modelio.archimate.diagrams.elements.businessobject.GmBusinessObjectPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessprocess.BusinessProcessEditPart;
import org.modelio.archimate.diagrams.elements.businessprocess.BusinessProcessSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcess;
import org.modelio.archimate.diagrams.elements.businessprocess.GmBusinessProcessPrimaryNode;
import org.modelio.archimate.diagrams.elements.businessrole.BusinessRoleEditPart;
import org.modelio.archimate.diagrams.elements.businessrole.BusinessRoleSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRole;
import org.modelio.archimate.diagrams.elements.businessrole.GmBusinessRolePrimaryNode;
import org.modelio.archimate.diagrams.elements.businessservice.BusinessServiceEditPart;
import org.modelio.archimate.diagrams.elements.businessservice.BusinessServiceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessService;
import org.modelio.archimate.diagrams.elements.businessservice.GmBusinessServicePrimaryNode;
import org.modelio.archimate.diagrams.elements.capability.CapabilityEditPart;
import org.modelio.archimate.diagrams.elements.capability.CapabilitySimpleEditPart;
import org.modelio.archimate.diagrams.elements.capability.GmCapability;
import org.modelio.archimate.diagrams.elements.capability.GmCapabilityPrimaryNode;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementImageEditPart;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiElementSimpleEditPart;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiFreeZoneEditPart;
import org.modelio.archimate.diagrams.elements.common.archielement.ArchiNonSelectableImageEditPart;
import org.modelio.archimate.diagrams.elements.common.archielement.GmArchiFreeZone;
import org.modelio.archimate.diagrams.elements.common.archiheader.ArchiHeaderEditPart;
import org.modelio.archimate.diagrams.elements.common.archiheader.GmArchiHeader;
import org.modelio.archimate.diagrams.elements.common.portcontainer.GmArchiElementPrimaryNode;
import org.modelio.archimate.diagrams.elements.communicationnetwork.CommunicationNetworkEditPart;
import org.modelio.archimate.diagrams.elements.communicationnetwork.CommunicationNetworkSimpleEditPart;
import org.modelio.archimate.diagrams.elements.communicationnetwork.GmCommunicationNetwork;
import org.modelio.archimate.diagrams.elements.communicationnetwork.GmCommunicationNetworkPrimaryNode;
import org.modelio.archimate.diagrams.elements.composition.CompositionEditPart;
import org.modelio.archimate.diagrams.elements.composition.GmComposition;
import org.modelio.archimate.diagrams.elements.constraint.ConstraintEditPart;
import org.modelio.archimate.diagrams.elements.constraint.ConstraintSimpleEditPart;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraint;
import org.modelio.archimate.diagrams.elements.constraint.GmConstraintPrimaryNode;
import org.modelio.archimate.diagrams.elements.contract.ContractEditPart;
import org.modelio.archimate.diagrams.elements.contract.ContractSimpleEditPart;
import org.modelio.archimate.diagrams.elements.contract.GmContract;
import org.modelio.archimate.diagrams.elements.contract.GmContractPrimaryNode;
import org.modelio.archimate.diagrams.elements.courseofaction.CourseOfActionEditPart;
import org.modelio.archimate.diagrams.elements.courseofaction.CourseOfActionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfAction;
import org.modelio.archimate.diagrams.elements.courseofaction.GmCourseOfActionPrimaryNode;
import org.modelio.archimate.diagrams.elements.dataobject.DataObjectEditPart;
import org.modelio.archimate.diagrams.elements.dataobject.DataObjectSimpleEditPart;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObject;
import org.modelio.archimate.diagrams.elements.dataobject.GmDataObjectPrimaryNode;
import org.modelio.archimate.diagrams.elements.deliverable.DeliverableEditPart;
import org.modelio.archimate.diagrams.elements.deliverable.DeliverableSimpleEditPart;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverable;
import org.modelio.archimate.diagrams.elements.deliverable.GmDeliverablePrimaryNode;
import org.modelio.archimate.diagrams.elements.device.DeviceEditPart;
import org.modelio.archimate.diagrams.elements.device.DeviceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.device.GmDevice;
import org.modelio.archimate.diagrams.elements.device.GmDevicePrimaryNode;
import org.modelio.archimate.diagrams.elements.distributionnetwork.DistributionNetworkEditPart;
import org.modelio.archimate.diagrams.elements.distributionnetwork.DistributionNetworkSimpleEditPart;
import org.modelio.archimate.diagrams.elements.distributionnetwork.GmDistributionNetwork;
import org.modelio.archimate.diagrams.elements.distributionnetwork.GmDistributionNetworkPrimaryNode;
import org.modelio.archimate.diagrams.elements.driver.DriverEditPart;
import org.modelio.archimate.diagrams.elements.driver.DriverSimpleEditPart;
import org.modelio.archimate.diagrams.elements.driver.GmDriver;
import org.modelio.archimate.diagrams.elements.driver.GmDriverPrimaryNode;
import org.modelio.archimate.diagrams.elements.equipment.EquipementSimpleEditPart;
import org.modelio.archimate.diagrams.elements.equipment.EquipmentEditPart;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipment;
import org.modelio.archimate.diagrams.elements.equipment.GmEquipmentPrimaryNode;
import org.modelio.archimate.diagrams.elements.facility.FacilityEditPart;
import org.modelio.archimate.diagrams.elements.facility.FacilitySimpleEditPart;
import org.modelio.archimate.diagrams.elements.facility.GmFacility;
import org.modelio.archimate.diagrams.elements.facility.GmFacilityPrimaryNode;
import org.modelio.archimate.diagrams.elements.flow.FlowEditPart;
import org.modelio.archimate.diagrams.elements.flow.GmFlow;
import org.modelio.archimate.diagrams.elements.gap.GapEditPart;
import org.modelio.archimate.diagrams.elements.gap.GapSimpleEditPart;
import org.modelio.archimate.diagrams.elements.gap.GmGap;
import org.modelio.archimate.diagrams.elements.gap.GmGapPrimaryNode;
import org.modelio.archimate.diagrams.elements.goal.GmGoal;
import org.modelio.archimate.diagrams.elements.goal.GmGoalPrimaryNode;
import org.modelio.archimate.diagrams.elements.goal.GoalEditPart;
import org.modelio.archimate.diagrams.elements.goal.GoalSimpleEditPart;
import org.modelio.archimate.diagrams.elements.grouping.GmGrouping;
import org.modelio.archimate.diagrams.elements.grouping.GmGroupingPrimaryNode;
import org.modelio.archimate.diagrams.elements.grouping.GroupingEditPart;
import org.modelio.archimate.diagrams.elements.grouping.GroupingSimpleEditPart;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEvent;
import org.modelio.archimate.diagrams.elements.implementationevent.GmImplementationEventPrimaryNode;
import org.modelio.archimate.diagrams.elements.implementationevent.ImplementationEventEditPart;
import org.modelio.archimate.diagrams.elements.implementationevent.ImplementationEventSimpleEditPart;
import org.modelio.archimate.diagrams.elements.influence.GmInfluence;
import org.modelio.archimate.diagrams.elements.influence.GmInfluenceStrengthLabel;
import org.modelio.archimate.diagrams.elements.influence.InfluenceEditPart;
import org.modelio.archimate.diagrams.elements.location.GmLocation;
import org.modelio.archimate.diagrams.elements.location.GmLocationPrimaryNode;
import org.modelio.archimate.diagrams.elements.location.LocationEditPart;
import org.modelio.archimate.diagrams.elements.location.LocationSimpleEditPart;
import org.modelio.archimate.diagrams.elements.material.GmMaterial;
import org.modelio.archimate.diagrams.elements.material.GmMaterialPrimaryNode;
import org.modelio.archimate.diagrams.elements.material.MaterialEditPart;
import org.modelio.archimate.diagrams.elements.material.MaterialSimpleEditPart;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaning;
import org.modelio.archimate.diagrams.elements.meaning.GmMeaningPrimaryNode;
import org.modelio.archimate.diagrams.elements.meaning.MeaningEditPart;
import org.modelio.archimate.diagrams.elements.meaning.MeaningSimpleEditPart;
import org.modelio.archimate.diagrams.elements.node.GmNode;
import org.modelio.archimate.diagrams.elements.node.GmNodePrimaryNode;
import org.modelio.archimate.diagrams.elements.node.NodeEditPart;
import org.modelio.archimate.diagrams.elements.node.NodeSimpleEditPart;
import org.modelio.archimate.diagrams.elements.orjunction.GmOrJunction;
import org.modelio.archimate.diagrams.elements.orjunction.GmOrJunctionPrimaryNode;
import org.modelio.archimate.diagrams.elements.orjunction.OrJunctionEditPart;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcome;
import org.modelio.archimate.diagrams.elements.outcome.GmOutcomePrimaryNode;
import org.modelio.archimate.diagrams.elements.outcome.OutcomeEditPart;
import org.modelio.archimate.diagrams.elements.outcome.OutcomeSimpleEditPart;
import org.modelio.archimate.diagrams.elements.path.GmPath;
import org.modelio.archimate.diagrams.elements.path.GmPathPrimaryNode;
import org.modelio.archimate.diagrams.elements.path.PathEditPart;
import org.modelio.archimate.diagrams.elements.path.PathSimpleEditPart;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateau;
import org.modelio.archimate.diagrams.elements.plateau.GmPlateauPrimaryNode;
import org.modelio.archimate.diagrams.elements.plateau.PlateauEditPart;
import org.modelio.archimate.diagrams.elements.plateau.PlateauSimpleEditPart;
import org.modelio.archimate.diagrams.elements.principle.GmPrinciple;
import org.modelio.archimate.diagrams.elements.principle.GmPrinciplePrimaryNode;
import org.modelio.archimate.diagrams.elements.principle.PrincipleEditPart;
import org.modelio.archimate.diagrams.elements.principle.PrincipleSimpleEditPart;
import org.modelio.archimate.diagrams.elements.product.GmProduct;
import org.modelio.archimate.diagrams.elements.product.GmProductPrimaryNode;
import org.modelio.archimate.diagrams.elements.product.ProductEditPart;
import org.modelio.archimate.diagrams.elements.product.ProductSimpleEditPart;
import org.modelio.archimate.diagrams.elements.realization.GmRealization;
import org.modelio.archimate.diagrams.elements.realization.RealizationEditPart;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentation;
import org.modelio.archimate.diagrams.elements.representation.GmRepresentationPrimaryNode;
import org.modelio.archimate.diagrams.elements.representation.RepresentationEditPart;
import org.modelio.archimate.diagrams.elements.representation.RepresentationSimpleEditPart;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirement;
import org.modelio.archimate.diagrams.elements.requirement.GmRequirementPrimaryNode;
import org.modelio.archimate.diagrams.elements.requirement.RequirementEditPart;
import org.modelio.archimate.diagrams.elements.requirement.RequirementSimpleEditPart;
import org.modelio.archimate.diagrams.elements.resource.GmResource;
import org.modelio.archimate.diagrams.elements.resource.GmResourcePrimaryNode;
import org.modelio.archimate.diagrams.elements.resource.ResourceEditPart;
import org.modelio.archimate.diagrams.elements.resource.ResourceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.serving.GmServing;
import org.modelio.archimate.diagrams.elements.serving.ServingEditPart;
import org.modelio.archimate.diagrams.elements.specialization.GmSpecialization;
import org.modelio.archimate.diagrams.elements.specialization.SpecializationEditPart;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholder;
import org.modelio.archimate.diagrams.elements.stakeholder.GmStakeholderPrimaryNode;
import org.modelio.archimate.diagrams.elements.stakeholder.StakeholderEditPart;
import org.modelio.archimate.diagrams.elements.stakeholder.StakeholderSimpleEditPart;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftware;
import org.modelio.archimate.diagrams.elements.systemsoftware.GmSystemSoftwarePrimaryNode;
import org.modelio.archimate.diagrams.elements.systemsoftware.SystemSoftwareEditPart;
import org.modelio.archimate.diagrams.elements.systemsoftware.SystemSoftwareSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologycollaboration.GmTechnologyCollaboration;
import org.modelio.archimate.diagrams.elements.technologycollaboration.GmTechnologyCollaborationPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologycollaboration.TechnologyCollaborationEditPart;
import org.modelio.archimate.diagrams.elements.technologycollaboration.TechnologyCollaborationSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEvent;
import org.modelio.archimate.diagrams.elements.technologyevent.GmTechnologyEventPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyevent.TechnologyEventEditPart;
import org.modelio.archimate.diagrams.elements.technologyevent.TechnologyEventSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunction;
import org.modelio.archimate.diagrams.elements.technologyfunction.GmTechnologyFunctionPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyfunction.TechnologyFunctionEditPart;
import org.modelio.archimate.diagrams.elements.technologyfunction.TechnologyFunctionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyinteraction.GmTechnologyInteraction;
import org.modelio.archimate.diagrams.elements.technologyinteraction.GmTechnologyInteractionPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyinteraction.TechnologyInteractionEditPart;
import org.modelio.archimate.diagrams.elements.technologyinteraction.TechnologyInteractionSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyinterface.GmTechnologyInterface;
import org.modelio.archimate.diagrams.elements.technologyinterface.GmTechnologyInterfacePrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyinterface.TechnologyInterfaceEditPart;
import org.modelio.archimate.diagrams.elements.technologyinterface.TechnologyInterfaceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcess;
import org.modelio.archimate.diagrams.elements.technologyprocess.GmTechnologyProcessPrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyprocess.TechnologyProcessEditPart;
import org.modelio.archimate.diagrams.elements.technologyprocess.TechnologyProcessSimpleEditPart;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyService;
import org.modelio.archimate.diagrams.elements.technologyservice.GmTechnologyServicePrimaryNode;
import org.modelio.archimate.diagrams.elements.technologyservice.TechnologyServiceEditPart;
import org.modelio.archimate.diagrams.elements.technologyservice.TechnologyServiceSimpleEditPart;
import org.modelio.archimate.diagrams.elements.triggering.GmTriggering;
import org.modelio.archimate.diagrams.elements.triggering.TriggeringEditPart;
import org.modelio.archimate.diagrams.elements.value.GmValue;
import org.modelio.archimate.diagrams.elements.value.GmValuePrimaryNode;
import org.modelio.archimate.diagrams.elements.value.ValueEditPart;
import org.modelio.archimate.diagrams.elements.value.ValueSimpleEditPart;
import org.modelio.archimate.diagrams.elements.valuestream.GmValueStream;
import org.modelio.archimate.diagrams.elements.valuestream.GmValueStreamPrimaryNode;
import org.modelio.archimate.diagrams.elements.valuestream.ValueStreamEditPart;
import org.modelio.archimate.diagrams.elements.valuestream.ValueStreamSimpleEditPart;
import org.modelio.archimate.diagrams.elements.viewpoint.GmViewPoint;
import org.modelio.archimate.diagrams.elements.viewpoint.GmViewPointHeader;
import org.modelio.archimate.diagrams.elements.viewpoint.ViewPointEditPart;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.GmViewPointDiagram;
import org.modelio.archimate.diagrams.elements.viewpointdiagram.ViewPointDiagramEditPart;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackage;
import org.modelio.archimate.diagrams.elements.workpackage.GmWorkPackagePrimaryNode;
import org.modelio.archimate.diagrams.elements.workpackage.WorkPackageEditPart;
import org.modelio.archimate.diagrams.elements.workpackage.WorkPackageSimpleEditPart;
import org.modelio.diagram.elements.common.image.LabelledImageEditPart;
import org.modelio.diagram.elements.common.label.base.ElementLabelEditPart;
import org.modelio.diagram.elements.common.portcontainer.GmPortContainer;
import org.modelio.diagram.elements.common.portcontainer.PortContainerEditPart;
import org.modelio.diagram.elements.core.model.factory.GenericUserImageModeEditPartFactory;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.diagram.elements.core.node.IImageableNode;

/**
 * The Archimate diagram EditPart factory.
 * <p>
 * This factory only processes the state specific edit parts. It is intended to be used only as a cascaded factory in order to dynamically enriching the Modelio standard factory so that this latter ends by being able to process the complete UML. This
 * factory does not provide edit part for simple and image mode.
 */
@objid ("a5dcf563-ae40-4795-a2b1-0a2c08b2da0f")
public class ArchimateEditPartFactory implements EditPartFactory {
    /**
     * the default factory to use when image mode is requested.
     */
    @objid ("2199947b-5879-4a72-b4ee-a8640223dd51")
    private final EditPartFactory imageModeEditPartFactory = new ImageModeEditPartFactory();

    /**
     * the default factory to use when structured mode is requested.
     */
    @objid ("3e8f3289-d4fa-4785-aa05-70c42ae5e78c")
    private final EditPartFactory structuredModeEditPartFactory = new StructuredModeEditPartFactory();

    /**
     * the default factory to use when the simple mode is requested.
     */
    @objid ("2df3ce36-e7aa-457a-aebd-c69389e0d594")
    private final EditPartFactory simpleModeEditPartFactory = new SimpleModeEditPartFactory();

    /**
     * the default factory to use when user image mode is requested.
     */
    @objid ("4d01355d-8068-432b-8218-53ba1a543f2b")
    private final EditPartFactory userImageModeEditPartFactory = new GenericUserImageModeEditPartFactory(this.imageModeEditPartFactory);

    @objid ("6bab8c9d-054b-419e-9f22-a98547a1c616")
    @Override
    public EditPart createEditPart(EditPart context, Object model) {
        EditPart editPart;
        if (model instanceof GmNodeModel) {
            // For node models, delegates according the representation model.
            GmNodeModel node = (GmNodeModel) model;
            switch (node.getRepresentationMode()) {
            case USER_IMAGE:
                editPart = this.userImageModeEditPartFactory.createEditPart(context, model);
                break;
            case IMAGE:
                editPart = this.imageModeEditPartFactory.createEditPart(context, model);
                break;
            case SIMPLE:
                editPart = this.simpleModeEditPartFactory.createEditPart(context, model);
                break;
            case STRUCTURED:
                editPart = this.structuredModeEditPartFactory.createEditPart(context, model);
                break;
            default:
                editPart = null;
            }

            return editPart;
        } else {
            // Link models are always in structured mode.
            editPart = this.structuredModeEditPartFactory.createEditPart(context, model);
            return editPart;
        }

    }

    /**
     * EditPart factory for node models in standard structured mode.
     * <p>
     * This is the default mode so the default factory.
     */
    @objid ("3ceb1071-da23-4d09-9944-0c8f50c682bd")
    private static final class StructuredModeEditPartFactory implements EditPartFactory {
        @objid ("32ca6462-3d15-45b1-9bc1-59ca56890203")
        @Override
        public EditPart createEditPart(EditPart context, Object model) {
            // Lets handle special cases.
            EditPart editPart = null;

            // Access
            if (model.getClass() == GmAccess.class) {
                editPart = new AccessEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Aggregation
            if (model.getClass() == GmAggregation.class) {
                editPart = new AggregationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // AndJunction
            if (model.getClass() == GmAndJunction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationCollaboration
            if (model.getClass() == GmApplicationCollaboration.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationCollaborationPrimaryNode
            if (model.getClass() == GmApplicationCollaborationPrimaryNode.class) {
                editPart = new ApplicationCollaborationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationComponent
            if (model.getClass() == GmApplicationComponent.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationComponentPrimaryNode
            if (model.getClass() == GmApplicationComponentPrimaryNode.class) {
                editPart = new ApplicationComponentEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationEvent
            if (model.getClass() == GmApplicationEvent.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationEventPrimaryNode
            if (model.getClass() == GmApplicationEventPrimaryNode.class) {
                editPart = new ApplicationEventEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationFunction
            if (model.getClass() == GmApplicationFunction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationFunctionPrimaryNode
            if (model.getClass() == GmApplicationFunctionPrimaryNode.class) {
                editPart = new ApplicationFunctionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationInteraction
            if (model.getClass() == GmApplicationInteraction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // ApplicationInteractionPrimaryNode
            if (model.getClass() == GmApplicationInteractionPrimaryNode.class) {
                editPart = new ApplicationInteractionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationInterface
            if (model.getClass() == GmApplicationInterface.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationInterfacePrimaryNode
            if (model.getClass() == GmApplicationInterfacePrimaryNode.class) {
                editPart = new ApplicationInterfaceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationProcess
            if (model.getClass() == GmApplicationProcess.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationProcessPrimaryNode
            if (model.getClass() == GmApplicationProcessPrimaryNode.class) {
                editPart = new ApplicationProcessEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationService
            if (model.getClass() == GmApplicationService.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationServicePrimaryNode
            if (model.getClass() == GmApplicationServicePrimaryNode.class) {
                editPart = new ApplicationServiceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Assignment
            if (model.getClass() == GmAssignment.class) {
                editPart = new AssignmentEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Association
            if (model.getClass() == GmAssociation.class) {
                editPart = new AssociationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ArchiHeader
            if (model.getClass() == GmArchiHeader.class) {
                editPart = new ArchiHeaderEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ArchiFreeZone
            if (model.getClass() == GmArchiFreeZone.class) {
                editPart = new ArchiFreeZoneEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ArchimateDiagram
            if (model.getClass() == GmArchimateDiagram.class) {
                editPart = new ArchimateDiagramEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Artifact
            if (model.getClass() == GmArtifact.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ArtifactPrimaryNode
            if (model.getClass() == GmArtifactPrimaryNode.class) {
                editPart = new ArtifactEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Assessment
            if (model.getClass() == GmAssessment.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // AssessmentPrimaryNode
            if (model.getClass() == GmAssessmentPrimaryNode.class) {
                editPart = new AssessmentEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessActor
            if (model.getClass() == GmBusinessActor.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // BusinessActorPrimaryNode
            if (model.getClass() == GmBusinessActorPrimaryNode.class) {
                editPart = new BusinessActorEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessCollaboration
            if (model.getClass() == GmBusinessCollaboration.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // BusinessCollaborationPrimaryNode
            if (model.getClass() == GmBusinessCollaborationPrimaryNode.class) {
                editPart = new BusinessCollaborationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessEvent
            if (model.getClass() == GmBusinessEvent.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessEventPrimaryNode
            if (model.getClass() == GmBusinessEventPrimaryNode.class) {
                editPart = new BusinessEventEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessFunction
            if (model.getClass() == GmBusinessFunction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessFunctionPrimaryNode
            if (model.getClass() == GmBusinessFunctionPrimaryNode.class) {
                editPart = new BusinessFunctionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInteraction
            if (model.getClass() == GmBusinessInteraction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInteractionPrimaryNode
            if (model.getClass() == GmBusinessInteractionPrimaryNode.class) {
                editPart = new BusinessInteractionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInterface
            if (model.getClass() == GmBusinessInterface.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInterfacePrimaryNode
            if (model.getClass() == GmBusinessInterfacePrimaryNode.class) {
                editPart = new BusinessInterfaceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessObject
            if (model.getClass() == GmBusinessObject.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessObject
            if (model.getClass() == GmBusinessObjectPrimaryNode.class) {
                editPart = new BusinessObjectEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessProcess
            if (model.getClass() == GmBusinessProcess.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessProcessPrimaryNode
            if (model.getClass() == GmBusinessProcessPrimaryNode.class) {
                editPart = new BusinessProcessEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessRole
            if (model.getClass() == GmBusinessRole.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessRolePrimaryNode
            if (model.getClass() == GmBusinessRolePrimaryNode.class) {
                editPart = new BusinessRoleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessService
            if (model.getClass() == GmBusinessService.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessServicePrimaryNode
            if (model.getClass() == GmBusinessServicePrimaryNode.class) {
                editPart = new BusinessServiceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Capability
            if (model.getClass() == GmCapability.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CapabilityPrimaryNode
            if (model.getClass() == GmCapabilityPrimaryNode.class) {
                editPart = new CapabilityEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CommunicationNetwork
            if (model.getClass() == GmCommunicationNetwork.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CommunicationNetworkPrimaryNode
            if (model.getClass() == GmCommunicationNetworkPrimaryNode.class) {
                editPart = new CommunicationNetworkEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Composition
            if (model.getClass() == GmComposition.class) {
                editPart = new CompositionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Constraint
            if (model.getClass() == GmConstraint.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ConstraintPrimaryNode
            if (model.getClass() == GmConstraintPrimaryNode.class) {
                editPart = new ConstraintEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Contract
            if (model.getClass() == GmContract.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ContractPrimaryNode
            if (model.getClass() == GmContractPrimaryNode.class) {
                editPart = new ContractEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CourseOfAction
            if (model.getClass() == GmCourseOfAction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CourseOfActionPrimaryNode
            if (model.getClass() == GmCourseOfActionPrimaryNode.class) {
                editPart = new CourseOfActionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DataObject
            if (model.getClass() == GmDataObject.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DataObjectPrimaryNode
            if (model.getClass() == GmDataObjectPrimaryNode.class) {
                editPart = new DataObjectEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Deliverable
            if (model.getClass() == GmDeliverable.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DeliverablePrimaryNode
            if (model.getClass() == GmDeliverablePrimaryNode.class) {
                editPart = new DeliverableEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Device
            if (model.getClass() == GmDevice.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DevicePrimaryNode
            if (model.getClass() == GmDevicePrimaryNode.class) {
                editPart = new DeviceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DistributionNetwork
            if (model.getClass() == GmDistributionNetwork.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // DistributionNetworkPrimaryNode
            if (model.getClass() == GmDistributionNetworkPrimaryNode.class) {
                editPart = new DistributionNetworkEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Driver
            if (model.getClass() == GmDriver.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DriverPrimaryNode
            if (model.getClass() == GmDriverPrimaryNode.class) {
                editPart = new DriverEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Equipment
            if (model.getClass() == GmEquipment.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // EquipmentPrimaryNode
            if (model.getClass() == GmEquipmentPrimaryNode.class) {
                editPart = new EquipmentEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Facility
            if (model.getClass() == GmFacility.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // FacilityPrimaryNode
            if (model.getClass() == GmFacilityPrimaryNode.class) {
                editPart = new FacilityEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Flow
            if (model.getClass() == GmFlow.class) {
                editPart = new FlowEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Gap
            if (model.getClass() == GmGap.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // GapPrimaryNode
            if (model.getClass() == GmGapPrimaryNode.class) {
                editPart = new GapEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Goal
            if (model.getClass() == GmGoal.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Goal
            if (model.getClass() == GmGoalPrimaryNode.class) {
                editPart = new GoalEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Grouping
            if (model.getClass() == GmGrouping.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Grouping
            if (model.getClass() == GmGroupingPrimaryNode.class) {
                editPart = new GroupingEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ImplementationEvent
            if (model.getClass() == GmImplementationEvent.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ImplementationEvent
            if (model.getClass() == GmImplementationEventPrimaryNode.class) {
                editPart = new ImplementationEventEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Influence
            if (model.getClass() == GmInfluence.class) {
                editPart = new InfluenceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Influence strength label
            if (model.getClass() == GmInfluenceStrengthLabel.class) {
                editPart = new ElementLabelEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Location
            if (model.getClass() == GmLocation.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // LocationPrimaryNode
            if (model.getClass() == GmLocationPrimaryNode.class) {
                editPart = new LocationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Material
            if (model.getClass() == GmMaterial.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // MaterialPrimaryNode
            if (model.getClass() == GmMaterialPrimaryNode.class) {
                editPart = new MaterialEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Meaning
            if (model.getClass() == GmMeaning.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // MeaningPrimaryNode
            if (model.getClass() == GmMeaningPrimaryNode.class) {
                editPart = new MeaningEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Node
            if (model.getClass() == GmNode.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // NodePrimaryNode
            if (model.getClass() == GmNodePrimaryNode.class) {
                editPart = new NodeEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // OrJunction
            if (model.getClass() == GmOrJunction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Outcome
            if (model.getClass() == GmOutcome.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // OutcomePrimaryNode
            if (model.getClass() == GmOutcomePrimaryNode.class) {
                editPart = new OutcomeEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Path
            if (model.getClass() == GmPath.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // PathPrimaryNode
            if (model.getClass() == GmPathPrimaryNode.class) {
                editPart = new PathEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Plateau
            if (model.getClass() == GmPlateau.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // PlateauPrimaryNode
            if (model.getClass() == GmPlateauPrimaryNode.class) {
                editPart = new PlateauEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Principle
            if (model.getClass() == GmPrinciple.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // PrinciplePrimaryNode
            if (model.getClass() == GmPrinciplePrimaryNode.class) {
                editPart = new PrincipleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Product
            if (model.getClass() == GmProduct.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ProductPrimaryNode
            if (model.getClass() == GmProductPrimaryNode.class) {
                editPart = new ProductEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Realization
            if (model.getClass() == GmRealization.class) {
                editPart = new RealizationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Requirement
            if (model.getClass() == GmRequirement.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // RequirementPrimaryNode
            if (model.getClass() == GmRequirementPrimaryNode.class) {
                editPart = new RequirementEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Representation
            if (model.getClass() == GmRepresentation.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // RepresentationPrimaryNode
            if (model.getClass() == GmRepresentationPrimaryNode.class) {
                editPart = new RepresentationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Resource
            if (model.getClass() == GmResource.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ResourcePrimaryNode
            if (model.getClass() == GmResourcePrimaryNode.class) {
                editPart = new ResourceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Serving
            if (model.getClass() == GmServing.class) {
                editPart = new ServingEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Specialization
            if (model.getClass() == GmSpecialization.class) {
                editPart = new SpecializationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Stakeholder
            if (model.getClass() == GmStakeholder.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // StakeholderPrimaryNode
            if (model.getClass() == GmStakeholderPrimaryNode.class) {
                editPart = new StakeholderEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // SystemSoftware
            if (model.getClass() == GmSystemSoftware.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // SystemSoftwarePrimaryNode
            if (model.getClass() == GmSystemSoftwarePrimaryNode.class) {
                editPart = new SystemSoftwareEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyCollaboration
            if (model.getClass() == GmTechnologyCollaboration.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // TechnologyCollaborationPrimaryNode
            if (model.getClass() == GmTechnologyCollaborationPrimaryNode.class) {
                editPart = new TechnologyCollaborationEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyEvent
            if (model.getClass() == GmTechnologyEvent.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyEventPrimaryNode
            if (model.getClass() == GmTechnologyEventPrimaryNode.class) {
                editPart = new TechnologyEventEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyFunction
            if (model.getClass() == GmTechnologyFunction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyFunctionPrimaryNode
            if (model.getClass() == GmTechnologyFunctionPrimaryNode.class) {
                editPart = new TechnologyFunctionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyInterface
            if (model.getClass() == GmTechnologyInterface.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // TechnologyInterfacePrimaryNode
            if (model.getClass() == GmTechnologyInterfacePrimaryNode.class) {
                editPart = new TechnologyInterfaceEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // TechnologyInteraction
            if (model.getClass() == GmTechnologyInteraction.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // TechnologyInteractionPrimaryNode
            if (model.getClass() == GmTechnologyInteractionPrimaryNode.class) {
                editPart = new TechnologyInteractionEditPart();
                editPart.setModel(model);
                return editPart;
            }
            // TechnologyProcess
            if (model.getClass() == GmTechnologyProcess.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyProcessPrimaryNode
            if (model.getClass() == GmTechnologyProcessPrimaryNode.class) {
                editPart = new TechnologyProcessEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyService
            if (model.getClass() == GmTechnologyService.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyServicePrimaryNode
            if (model.getClass() == GmTechnologyServicePrimaryNode.class) {
                editPart = new TechnologyServiceEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Triggering
            if (model.getClass() == GmTriggering.class) {
                editPart = new TriggeringEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Value
            if (model.getClass() == GmValue.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ValuePrimaryNode
            if (model.getClass() == GmValuePrimaryNode.class) {
                editPart = new ValueEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ValueStream
            if (model.getClass() == GmValueStream.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ValueStreamPrimaryNode
            if (model.getClass() == GmValueStreamPrimaryNode.class) {
                editPart = new ValueStreamEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ViewPoint
            if (model.getClass() == GmViewPoint.class) {
                editPart = new ViewPointEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ViewPointHeader
            if (model.getClass() == GmViewPointHeader.class) {
                editPart = new ArchiHeaderEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ViewPointDiagram
            if (model.getClass() == GmViewPointDiagram.class) {
                editPart = new ViewPointDiagramEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // WorkPackage
            if (model.getClass() == GmWorkPackage.class) {
                editPart = new PortContainerEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // WorkPackagePrimaryNode
            if (model.getClass() == GmWorkPackagePrimaryNode.class) {
                editPart = new WorkPackageEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // not found
            return null;
        }

    }

    /**
     * EditPart factory for node models in stereotype image mode.
     */
    @objid ("ced1f85c-0622-4528-9058-ce588cf3896a")
    private static final class ImageModeEditPartFactory implements EditPartFactory {
        @objid ("67dc60b3-0e5e-4eee-8a71-07c0ebd408ec")
        @Override
        public EditPart createEditPart(EditPart context, Object model) {
            if (model instanceof IImageableNode && model instanceof GmNodeModel) {
                GmNodeModel gmModel = (GmNodeModel) model;
                if (gmModel instanceof GmArchiElementPrimaryNode && gmModel.getParent() instanceof GmPortContainer) {
                    final EditPart editPart = new ArchiElementImageEditPart();
                    editPart.setModel(model);
                    return editPart;
                } else if (((GmNodeModel) model).getParent() instanceof GmPortContainer) {
                    final EditPart editPart = new ArchiNonSelectableImageEditPart();
                    editPart.setModel(model);
                    return editPart;
                } else {
                    final EditPart editPart = new LabelledImageEditPart();
                    editPart.setModel(model);
                    return editPart;
                }
            }
            return null;
        }

    }

    /**
     * EditPart factory for node models in simple mode.
     */
    @objid ("26e42b7e-acc1-4fca-8ac9-014a458555f4")
    private static final class SimpleModeEditPartFactory implements EditPartFactory {
        @objid ("05c2061f-3b55-4b99-b458-a33a5e68ac69")
        @Override
        public EditPart createEditPart(final EditPart context, final Object model) {
            EditPart editPart;

            // AndJunctionPrimaryNode
            if (model.getClass() == GmAndJunctionPrimaryNode.class) {
                editPart = new AndJunctionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationCollaborationPrimaryNode
            if (model.getClass() == GmApplicationCollaborationPrimaryNode.class) {
                editPart = new ApplicationCollaborationSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationComponentPrimaryNode
            if (model.getClass() == GmApplicationComponentPrimaryNode.class) {
                editPart = new ApplicationComponentSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationEventPrimaryNode
            if (model.getClass() == GmApplicationEventPrimaryNode.class) {
                editPart = new ApplicationEventSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationFunctionPrimaryNode
            if (model.getClass() == GmApplicationFunctionPrimaryNode.class) {
                editPart = new ApplicationFunctionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationInteractionPrimaryNode
            if (model.getClass() == GmApplicationInteractionPrimaryNode.class) {
                editPart = new ApplicationInteractionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationInterfacePrimaryNode
            if (model.getClass() == GmApplicationInterfacePrimaryNode.class) {
                editPart = new ApplicationInterfaceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationProcessPrimaryNode
            if (model.getClass() == GmApplicationProcessPrimaryNode.class) {
                editPart = new ApplicationProcessSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ApplicationServicePrimaryNode
            if (model.getClass() == GmApplicationServicePrimaryNode.class) {
                editPart = new ApplicationServiceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // AssessmentPrimaryNode
            if (model.getClass() == GmAssessmentPrimaryNode.class) {
                editPart = new AssessmentSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ArtifactPrimaryNodePrimaryNode
            if (model.getClass() == GmArtifactPrimaryNode.class) {
                editPart = new ArtifactSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessActorPrimaryNode
            if (model.getClass() == GmBusinessActorPrimaryNode.class) {
                editPart = new BusinessActorSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessCollaborationPrimaryNode
            if (model.getClass() == GmBusinessCollaborationPrimaryNode.class) {
                editPart = new BusinessCollaborationSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessEventPrimaryNode
            if (model.getClass() == GmBusinessEventPrimaryNode.class) {
                editPart = new BusinessEventSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessFunctionPrimaryNode
            if (model.getClass() == GmBusinessFunctionPrimaryNode.class) {
                editPart = new BusinessFunctionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInteractionPrimaryNode
            if (model.getClass() == GmBusinessInteractionPrimaryNode.class) {
                editPart = new BusinessInteractionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessInterfacePrimaryNode
            if (model.getClass() == GmBusinessInterfacePrimaryNode.class) {
                editPart = new BusinessInterfaceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }


            // BusinessObject
            if (model.getClass() == GmBusinessObjectPrimaryNode.class) {
                editPart = new BusinessObjectSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }


            // BusinessProcessPrimaryNode
            if (model.getClass() == GmBusinessProcessPrimaryNode.class) {
                editPart = new BusinessProcessSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessRolePrimaryNode
            if (model.getClass() == GmBusinessRolePrimaryNode.class) {
                editPart = new BusinessRoleSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // BusinessServicePrimaryNode
            if (model.getClass() == GmBusinessServicePrimaryNode.class) {
                editPart = new BusinessServiceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CapabilityPrimaryNode
            if (model.getClass() == GmCapabilityPrimaryNode.class) {
                editPart = new CapabilitySimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CommunicationNetworkPrimaryNode
            if (model.getClass() == GmCommunicationNetworkPrimaryNode.class) {
                editPart = new CommunicationNetworkSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ConstraintPrimaryNode
            if (model.getClass() == GmConstraintPrimaryNode.class) {
                editPart = new ConstraintSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ContractPrimaryNode
            if (model.getClass() == GmContractPrimaryNode.class) {
                editPart = new ContractSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // CourseOfActionPrimaryNode
            if (model.getClass() == GmCourseOfActionPrimaryNode.class) {
                editPart = new CourseOfActionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DataObjectPrimaryNode
            if (model.getClass() == GmDataObjectPrimaryNode.class) {
                editPart = new DataObjectSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DeliverablePrimaryNode
            if (model.getClass() == GmDeliverablePrimaryNode.class) {
                editPart = new DeliverableSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DevicePrimaryNode
            if (model.getClass() == GmDevicePrimaryNode.class) {
                editPart = new DeviceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DistributionNetworkPrimaryNode
            if (model.getClass() == GmDistributionNetworkPrimaryNode.class) {
                editPart = new DistributionNetworkSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // DriverPrimaryNode
            if (model.getClass() == GmDriverPrimaryNode.class) {
                editPart = new DriverSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // EquipementPrimaryNode
            if (model.getClass() == GmEquipmentPrimaryNode.class) {
                editPart = new EquipementSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // FacilityPrimaryNode
            if (model.getClass() == GmFacilityPrimaryNode.class) {
                editPart = new FacilitySimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // GapPrimaryNode
            if (model.getClass() == GmGapPrimaryNode.class) {
                editPart = new GapSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // GoalPrimaryNode
            if (model.getClass() == GmGoalPrimaryNode.class) {
                editPart = new GoalSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }


            // Grouping
            if (model.getClass() == GmGroupingPrimaryNode.class) {
                editPart = new GroupingSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ImplementationEventPrimaryNode
            if (model.getClass() == GmImplementationEventPrimaryNode.class) {
                editPart = new ImplementationEventSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // LocationPrimaryNode
            if (model.getClass() == GmLocationPrimaryNode.class) {
                editPart = new LocationSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // MaterialPrimaryNode
            if (model.getClass() == GmMaterialPrimaryNode.class) {
                editPart = new MaterialSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // MeaningPrimaryNode
            if (model.getClass() == GmMeaningPrimaryNode.class) {
                editPart = new MeaningSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // NodePrimaryNode
            if (model.getClass() == GmNodePrimaryNode.class) {
                editPart = new NodeSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // OrJunctionPrimaryNode
            if (model.getClass() == GmOrJunctionPrimaryNode.class) {
                editPart = new OrJunctionEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // OutcomePrimaryNode
            if (model.getClass() == GmOutcomePrimaryNode.class) {
                editPart = new OutcomeSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // PathPrimaryNode
            if (model.getClass() == GmPathPrimaryNode.class) {
                editPart = new PathSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // PlateauPrimaryNode
            if (model.getClass() == GmPlateauPrimaryNode.class) {
                editPart = new PlateauSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // PrinciplePrimaryNode
            if (model.getClass() == GmPrinciplePrimaryNode.class) {
                editPart = new PrincipleSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ProductPrimaryNode
            if (model.getClass() == GmProductPrimaryNode.class) {
                editPart = new ProductSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // RequirementPrimaryNode
            if (model.getClass() == GmRequirementPrimaryNode.class) {
                editPart = new RequirementSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // RepresentationPrimaryNode
            if (model.getClass() == GmRepresentationPrimaryNode.class) {
                editPart = new RepresentationSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }


            // ResourcePrimaryNode
            if (model.getClass() == GmResourcePrimaryNode.class) {
                editPart = new ResourceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // StakeholderPrimaryNode
            if (model.getClass() == GmStakeholderPrimaryNode.class) {
                editPart = new StakeholderSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // SystemSoftwarePrimaryNode
            if (model.getClass() == GmSystemSoftwarePrimaryNode.class) {
                editPart = new SystemSoftwareSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyCollaborationPrimaryNode
            if (model.getClass() == GmTechnologyCollaborationPrimaryNode.class) {
                editPart = new TechnologyCollaborationSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyEventPrimaryNode
            if (model.getClass() == GmTechnologyEventPrimaryNode.class) {
                editPart = new TechnologyEventSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyFunctionPrimaryNode
            if (model.getClass() == GmTechnologyFunctionPrimaryNode.class) {
                editPart = new TechnologyFunctionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyInterfacePrimaryNode
            if (model.getClass() == GmTechnologyInterfacePrimaryNode.class) {
                editPart = new TechnologyInterfaceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyInteractionPrimaryNode
            if (model.getClass() == GmTechnologyInteractionPrimaryNode.class) {
                editPart = new TechnologyInteractionSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyProcessPrimaryNode
            if (model.getClass() == GmTechnologyProcessPrimaryNode.class) {
                editPart = new TechnologyProcessSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // TechnologyServicePrimaryNode
            if (model.getClass() == GmTechnologyServicePrimaryNode.class) {
                editPart = new TechnologyServiceSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ValuePrimaryNode
            if (model.getClass() == GmValuePrimaryNode.class) {
                editPart = new ValueSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // ValueStreamPrimaryNode
            if (model.getClass() == GmValueStreamPrimaryNode.class) {
                editPart = new ValueStreamSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }


            // WorkPackagePrimaryNode
            if (model.getClass() == GmWorkPackagePrimaryNode.class) {
                editPart = new WorkPackageSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }




            if (model instanceof GmArchiElementPrimaryNode) {
                editPart = new ArchiElementSimpleEditPart();
                editPart.setModel(model);
                return editPart;
            }

            // Lets handle special cases.
            return null;
        }

    }

}
