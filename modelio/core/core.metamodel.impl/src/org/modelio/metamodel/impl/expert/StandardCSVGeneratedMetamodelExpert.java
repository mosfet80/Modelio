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
package org.modelio.metamodel.impl.expert;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnAdHocSubProcess;
import org.modelio.metamodel.bpmn.activities.BpmnBusinessRuleTask;
import org.modelio.metamodel.bpmn.activities.BpmnCallActivity;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.activities.BpmnLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.BpmnManualTask;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnScriptTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.activities.BpmnStandardLoopCharacteristics;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.bpmn.activities.BpmnTransaction;
import org.modelio.metamodel.bpmn.activities.BpmnUserTask;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnCollaborationDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessCollaborationDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnProcessDesignDiagram;
import org.modelio.metamodel.bpmn.bpmnDiagrams.BpmnSubProcessDiagram;
import org.modelio.metamodel.bpmn.bpmnService.BpmnEndPoint;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.bpmn.events.BpmnCancelEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnConditionalEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEndEvent;
import org.modelio.metamodel.bpmn.events.BpmnErrorEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEscalationEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnEvent;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.bpmn.events.BpmnIntermediateCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnIntermediateThrowEvent;
import org.modelio.metamodel.bpmn.events.BpmnLinkEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnSignalEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnStartEvent;
import org.modelio.metamodel.bpmn.events.BpmnTerminateEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.events.BpmnTimerEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnParallelGateway;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataObject;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.bpmn.objects.BpmnDataState;
import org.modelio.metamodel.bpmn.objects.BpmnDataStore;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.bpmn.rootElements.BpmnGroup;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedDefinitions;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.diagrams.ActivityDiagram;
import org.modelio.metamodel.diagrams.BehaviorDiagram;
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.diagrams.CommunicationDiagram;
import org.modelio.metamodel.diagrams.CompositeStructureDiagram;
import org.modelio.metamodel.diagrams.DeploymentDiagram;
import org.modelio.metamodel.diagrams.ObjectDiagram;
import org.modelio.metamodel.diagrams.SequenceDiagram;
import org.modelio.metamodel.diagrams.StateMachineDiagram;
import org.modelio.metamodel.diagrams.StaticDiagram;
import org.modelio.metamodel.diagrams.UseCaseDiagram;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptCallEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptChangeEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptTimeEventAction;
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityFinalNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityParameterNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.CallAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallBehaviorAction;
import org.modelio.metamodel.uml.behavior.activityModel.CallOperationAction;
import org.modelio.metamodel.uml.behavior.activityModel.CentralBufferNode;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.ConditionalNode;
import org.modelio.metamodel.uml.behavior.activityModel.ControlFlow;
import org.modelio.metamodel.uml.behavior.activityModel.ControlNode;
import org.modelio.metamodel.uml.behavior.activityModel.DataStoreNode;
import org.modelio.metamodel.uml.behavior.activityModel.DecisionMergeNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionNode;
import org.modelio.metamodel.uml.behavior.activityModel.ExpansionRegion;
import org.modelio.metamodel.uml.behavior.activityModel.FinalNode;
import org.modelio.metamodel.uml.behavior.activityModel.FlowFinalNode;
import org.modelio.metamodel.uml.behavior.activityModel.ForkJoinNode;
import org.modelio.metamodel.uml.behavior.activityModel.InitialNode;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.behavior.activityModel.InstanceNode;
import org.modelio.metamodel.uml.behavior.activityModel.InterruptibleActivityRegion;
import org.modelio.metamodel.uml.behavior.activityModel.LoopNode;
import org.modelio.metamodel.uml.behavior.activityModel.MessageFlow;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlow;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.activityModel.OpaqueAction;
import org.modelio.metamodel.uml.behavior.activityModel.OutputPin;
import org.modelio.metamodel.uml.behavior.activityModel.Pin;
import org.modelio.metamodel.uml.behavior.activityModel.SendSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ValuePin;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.OpaqueBehavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationInteraction;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.DurationConstraint;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionOccurenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.GeneralOrdering;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionOperand;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.PartDecomposition;
import org.modelio.metamodel.uml.behavior.interactionModel.StateInvariant;
import org.modelio.metamodel.uml.behavior.interactionModel.TerminateSpecification;
import org.modelio.metamodel.uml.behavior.stateMachineModel.AbstractPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ChoicePseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.DeepHistoryPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.FinalState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ForkPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InitialPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InternalTransition;
import org.modelio.metamodel.uml.behavior.stateMachineModel.JoinPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.JunctionPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ShallowHistoryPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.uml.behavior.stateMachineModel.TerminatePseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.behavior.usecaseModel.Actor;
import org.modelio.metamodel.uml.behavior.usecaseModel.ExtensionPoint;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCase;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCaseDependency;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.informationFlow.InformationItem;
import org.modelio.metamodel.uml.infrastructure.Abstraction;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.ModelTree;
import org.modelio.metamodel.uml.infrastructure.Substitution;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.infrastructure.Usage;
import org.modelio.metamodel.uml.statik.Artifact;
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.BehavioralFeature;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.Component;
import org.modelio.metamodel.uml.statik.ComponentRealization;
import org.modelio.metamodel.uml.statik.Connector;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.DataType;
import org.modelio.metamodel.uml.statik.ElementImport;
import org.modelio.metamodel.uml.statik.ElementRealization;
import org.modelio.metamodel.uml.statik.Enumeration;
import org.modelio.metamodel.uml.statik.EnumerationLiteral;
import org.modelio.metamodel.uml.statik.Feature;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Generalization;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociationEnd;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.uml.statik.NaryConnectorEnd;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.Node;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.PackageMerge;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RaisedException;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.metamodel.uml.statik.StructuralFeature;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.utils.metamodel.experts.CompositeMetamodelExpert;

/**
 * This is an automatically generated metamodel expert.
 * <p>
 * All modifications will be overwritten. If you need to modify it, subclass this class instead.
 * <p>
 * You need to call {@link #register()} after instantiation to initialize the expert from the metamodel.
 */
@objid ("584d4183-2654-45b0-9e4e-6c0c5b54c35b")
public class StandardCSVGeneratedMetamodelExpert extends CompositeMetamodelExpert {
    /**
     * Constructor.
     * <p>
     * You need to call {@link #register()} next.
     *
     * @param mm The metamodel.
     */
    @objid ("f39b3123-b87c-45b9-9d15-ba46be3c169a")
    public StandardCSVGeneratedMetamodelExpert(MMetamodel mm) {
        super(mm);

    }

    /**
     * Initializes this expert.
     */
    @objid ("f68af80d-83bf-4dd1-afda-3766f078a9f4")
    public void register() {
        registerLinkExpertForBpmnMessageFlow();
        registerLinkExpertForBpmnSequenceFlow();
        registerLinkExpertForActivityEdge();
        registerLinkExpertForCommunicationChannel();
        registerLinkExpertForMessage();
        registerLinkExpertForTransition();
        registerLinkExpertForUseCaseDependency();
        registerLinkExpertForDataFlow();
        registerLinkExpertForInformationFlow();
        registerLinkExpertForAbstraction();
        registerLinkExpertForSubstitution();
        registerLinkExpertForUsage();
        registerLinkExpertForAssociation();
        registerLinkExpertForAssociationEnd();
        registerLinkExpertForElementImport();
        registerLinkExpertForGeneralization();
        registerLinkExpertForInterfaceRealization();
        registerLinkExpertForLink();
        registerLinkExpertForLinkEnd();
        registerLinkExpertForManifestation();
        registerLinkExpertForPackageImport();
        registerLinkExpertForPackageMerge();
        registerLinkExpertForRaisedException();
        registerLinkExpertForTemplateBinding();
        registerLinkExpertForControlFlow();
        registerLinkExpertForMessageFlow();
        registerLinkExpertForObjectFlow();
        registerLinkExpertForElementRealization();
        registerLinkExpertForConnector();
        registerLinkExpertForConnectorEnd();
        registerMetaExpertForProject();
        registerMetaExpertForTemplateParameterSubstitution();
        registerMetaExpertForTemplateParameter();
        registerMetaExpertForTemplateBinding();
        registerMetaExpertForRequiredInterface();
        registerMetaExpertForRaisedException();
        registerMetaExpertForProvidedInterface();
        registerMetaExpertForPort();
        registerMetaExpertForPackageMerge();
        registerMetaExpertForPackageImport();
        registerMetaExpertForPackage();
        registerMetaExpertForOperation();
        registerMetaExpertForNode();
        registerMetaExpertForNaryConnectorEnd();
        registerMetaExpertForNaryLinkEnd();
        registerMetaExpertForNaryConnector();
        registerMetaExpertForNaryLink();
        registerMetaExpertForNaryAssociationEnd();
        registerMetaExpertForNaryAssociation();
        registerMetaExpertForManifestation();
        registerMetaExpertForInterfaceRealization();
        registerMetaExpertForInterface();
        registerMetaExpertForGeneralization();
        registerMetaExpertForEnumerationLiteral();
        registerMetaExpertForEnumeration();
        registerMetaExpertForElementRealization();
        registerMetaExpertForElementImport();
        registerMetaExpertForDataType();
        registerMetaExpertForConnectorEnd();
        registerMetaExpertForLinkEnd();
        registerMetaExpertForConnector();
        registerMetaExpertForLink();
        registerMetaExpertForComponentRealization();
        registerMetaExpertForComponent();
        registerMetaExpertForCollaborationUse();
        registerMetaExpertForCollaboration();
        registerMetaExpertForClassAssociation();
        registerMetaExpertForClass();
        registerMetaExpertForBinding();
        registerMetaExpertForBindableInstance();
        registerMetaExpertForInstance();
        registerMetaExpertForBehavioralFeature();
        registerMetaExpertForAttributeLink();
        registerMetaExpertForAttribute();
        registerMetaExpertForAssociationEnd();
        registerMetaExpertForStructuralFeature();
        registerMetaExpertForFeature();
        registerMetaExpertForAssociation();
        registerMetaExpertForArtifact();
        registerMetaExpertForUsage();
        registerMetaExpertForSubstitution();
        registerMetaExpertForAbstraction();
        registerMetaExpertForInformationItem();
        registerMetaExpertForInformationFlow();
        registerMetaExpertForDataFlow();
        registerMetaExpertForUseCaseDependency();
        registerMetaExpertForUseCase();
        registerMetaExpertForExtensionPoint();
        registerMetaExpertForActor();
        registerMetaExpertForTerminatePseudoState();
        registerMetaExpertForStateMachine();
        registerMetaExpertForShallowHistoryPseudoState();
        registerMetaExpertForRegion();
        registerMetaExpertForJunctionPseudoState();
        registerMetaExpertForJoinPseudoState();
        registerMetaExpertForInternalTransition();
        registerMetaExpertForTransition();
        registerMetaExpertForInitialPseudoState();
        registerMetaExpertForForkPseudoState();
        registerMetaExpertForFinalState();
        registerMetaExpertForState();
        registerMetaExpertForExitPointPseudoState();
        registerMetaExpertForEntryPointPseudoState();
        registerMetaExpertForDeepHistoryPseudoState();
        registerMetaExpertForConnectionPointReference();
        registerMetaExpertForChoicePseudoState();
        registerMetaExpertForAbstractPseudoState();
        registerMetaExpertForStateVertex();
        registerMetaExpertForTerminateSpecification();
        registerMetaExpertForStateInvariant();
        registerMetaExpertForPartDecomposition();
        registerMetaExpertForMessage();
        registerMetaExpertForLifeline();
        registerMetaExpertForInteractionUse();
        registerMetaExpertForInteractionOperand();
        registerMetaExpertForInteraction();
        registerMetaExpertForGeneralOrdering();
        registerMetaExpertForGate();
        registerMetaExpertForExecutionSpecification();
        registerMetaExpertForExecutionOccurenceSpecification();
        registerMetaExpertForMessageEnd();
        registerMetaExpertForOccurrenceSpecification();
        registerMetaExpertForDurationConstraint();
        registerMetaExpertForConstraint();
        registerMetaExpertForCombinedFragment();
        registerMetaExpertForInteractionFragment();
        registerMetaExpertForCommunicationNode();
        registerMetaExpertForCommunicationMessage();
        registerMetaExpertForCommunicationInteraction();
        registerMetaExpertForCommunicationChannel();
        registerMetaExpertForSignal();
        registerMetaExpertForGeneralClass();
        registerMetaExpertForClassifier();
        registerMetaExpertForNameSpace();
        registerMetaExpertForModelTree();
        registerMetaExpertForOpaqueBehavior();
        registerMetaExpertForEvent();
        registerMetaExpertForBehaviorParameter();
        registerMetaExpertForParameter();
        registerMetaExpertForValuePin();
        registerMetaExpertForSendSignalAction();
        registerMetaExpertForOutputPin();
        registerMetaExpertForOpaqueAction();
        registerMetaExpertForObjectFlow();
        registerMetaExpertForMessageFlow();
        registerMetaExpertForLoopNode();
        registerMetaExpertForInterruptibleActivityRegion();
        registerMetaExpertForInstanceNode();
        registerMetaExpertForInputPin();
        registerMetaExpertForPin();
        registerMetaExpertForInitialNode();
        registerMetaExpertForForkJoinNode();
        registerMetaExpertForFlowFinalNode();
        registerMetaExpertForExpansionRegion();
        registerMetaExpertForExpansionNode();
        registerMetaExpertForExceptionHandler();
        registerMetaExpertForDecisionMergeNode();
        registerMetaExpertForDataStoreNode();
        registerMetaExpertForControlFlow();
        registerMetaExpertForConditionalNode();
        registerMetaExpertForStructuredActivityNode();
        registerMetaExpertForClause();
        registerMetaExpertForCentralBufferNode();
        registerMetaExpertForCallOperationAction();
        registerMetaExpertForCallBehaviorAction();
        registerMetaExpertForCallAction();
        registerMetaExpertForActivityPartition();
        registerMetaExpertForActivityParameterNode();
        registerMetaExpertForObjectNode();
        registerMetaExpertForActivityGroup();
        registerMetaExpertForActivityFinalNode();
        registerMetaExpertForFinalNode();
        registerMetaExpertForControlNode();
        registerMetaExpertForActivityEdge();
        registerMetaExpertForActivity();
        registerMetaExpertForAcceptTimeEventAction();
        registerMetaExpertForAcceptSignalAction();
        registerMetaExpertForAcceptChangeEventAction();
        registerMetaExpertForAcceptCallEventAction();
        registerMetaExpertForActivityAction();
        registerMetaExpertForActivityNode();
        registerMetaExpertForUseCaseDiagram();
        registerMetaExpertForStateMachineDiagram();
        registerMetaExpertForSequenceDiagram();
        registerMetaExpertForObjectDiagram();
        registerMetaExpertForDeploymentDiagram();
        registerMetaExpertForCompositeStructureDiagram();
        registerMetaExpertForCommunicationDiagram();
        registerMetaExpertForClassDiagram();
        registerMetaExpertForStaticDiagram();
        registerMetaExpertForActivityDiagram();
        registerMetaExpertForBpmnSharedDefinitions();
        registerMetaExpertForBpmnGroup();
        registerMetaExpertForBpmnAssociation();
        registerMetaExpertForBpmnArtifact();
        registerMetaExpertForBpmnResourceRole();
        registerMetaExpertForBpmnResourceParameterBinding();
        registerMetaExpertForBpmnResourceParameter();
        registerMetaExpertForBpmnResource();
        registerMetaExpertForBpmnProcess();
        registerMetaExpertForBpmnParticipant();
        registerMetaExpertForBpmnLaneSet();
        registerMetaExpertForBpmnLane();
        registerMetaExpertForBpmnCollaboration();
        registerMetaExpertForBehavior();
        registerMetaExpertForUmlModelElement();
        registerMetaExpertForBpmnSequenceFlowDataAssociation();
        registerMetaExpertForBpmnItemDefinition();
        registerMetaExpertForBpmnDataStore();
        registerMetaExpertForBpmnDataState();
        registerMetaExpertForBpmnDataOutput();
        registerMetaExpertForBpmnDataObject();
        registerMetaExpertForBpmnDataInput();
        registerMetaExpertForBpmnItemAwareElement();
        registerMetaExpertForBpmnDataAssociation();
        registerMetaExpertForBpmnParallelGateway();
        registerMetaExpertForBpmnInclusiveGateway();
        registerMetaExpertForBpmnExclusiveGateway();
        registerMetaExpertForBpmnEventBasedGateway();
        registerMetaExpertForBpmnComplexGateway();
        registerMetaExpertForBpmnGateway();
        registerMetaExpertForBpmnSequenceFlow();
        registerMetaExpertForBpmnMessageFlow();
        registerMetaExpertForBpmnMessage();
        registerMetaExpertForBpmnTimerEventDefinition();
        registerMetaExpertForBpmnTerminateEventDefinition();
        registerMetaExpertForBpmnStartEvent();
        registerMetaExpertForBpmnSignalEventDefinition();
        registerMetaExpertForBpmnMessageEventDefinition();
        registerMetaExpertForBpmnLinkEventDefinition();
        registerMetaExpertForBpmnIntermediateThrowEvent();
        registerMetaExpertForBpmnIntermediateCatchEvent();
        registerMetaExpertForBpmnImplicitThrowEvent();
        registerMetaExpertForBpmnEscalationEventDefinition();
        registerMetaExpertForBpmnErrorEventDefinition();
        registerMetaExpertForBpmnEndEvent();
        registerMetaExpertForBpmnThrowEvent();
        registerMetaExpertForBpmnConditionalEventDefinition();
        registerMetaExpertForBpmnCompensateEventDefinition();
        registerMetaExpertForBpmnCancelEventDefinition();
        registerMetaExpertForBpmnEventDefinition();
        registerMetaExpertForBpmnBoundaryEvent();
        registerMetaExpertForBpmnCatchEvent();
        registerMetaExpertForBpmnEvent();
        registerMetaExpertForBpmnOperation();
        registerMetaExpertForBpmnInterface();
        registerMetaExpertForBpmnEndPoint();
        registerMetaExpertForBpmnSharedElement();
        registerMetaExpertForBpmnCollaborationDiagram();
        registerMetaExpertForBpmnProcessDesignDiagram();
        registerMetaExpertForBpmnSubProcessDiagram();
        registerMetaExpertForBpmnProcessCollaborationDiagram();
        registerMetaExpertForBehaviorDiagram();
        registerMetaExpertForBpmnUserTask();
        registerMetaExpertForBpmnTransaction();
        registerMetaExpertForBpmnStandardLoopCharacteristics();
        registerMetaExpertForBpmnServiceTask();
        registerMetaExpertForBpmnSendTask();
        registerMetaExpertForBpmnScriptTask();
        registerMetaExpertForBpmnReceiveTask();
        registerMetaExpertForBpmnMultiInstanceLoopCharacteristics();
        registerMetaExpertForBpmnManualTask();
        registerMetaExpertForBpmnLoopCharacteristics();
        registerMetaExpertForBpmnComplexBehaviorDefinition();
        registerMetaExpertForBpmnCallActivity();
        registerMetaExpertForBpmnBusinessRuleTask();
        registerMetaExpertForBpmnTask();
        registerMetaExpertForBpmnAdHocSubProcess();
        registerMetaExpertForBpmnSubProcess();
        registerMetaExpertForBpmnActivity();
        registerMetaExpertForBpmnFlowNode();
        registerMetaExpertForBpmnFlowElement();
        registerMetaExpertForBpmnBaseElement();

    }

    @objid ("33cb2c39-e992-496e-925b-3760c8b131bf")
    protected void registerLinkExpertForBpmnMessageFlow() {
        // Standard.BpmnMessageFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(BpmnMessageFlow.class);

        // Standard.BpmnMessageFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(BpmnMessageFlow.class, "SourceRef");
        this.ruleLinkExpert.addTargetDep(BpmnMessageFlow.class, "TargetRef");


        // Standard.BpmnMessageFlow rules:

    }

    @objid ("c688f5e6-8600-4117-9b5a-ccba14317c73")
    protected void registerLinkExpertForBpmnSequenceFlow() {
        // Standard.BpmnSequenceFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(BpmnSequenceFlow.class);

        // Standard.BpmnSequenceFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(BpmnSequenceFlow.class, "SourceRef");
        this.ruleLinkExpert.addTargetDep(BpmnSequenceFlow.class, "TargetRef");


        // Standard.BpmnSequenceFlow rules:

    }

    @objid ("9a5bdd49-260c-4554-84ce-279487b7eed1")
    protected void registerLinkExpertForActivityEdge() {
        // Standard.ActivityEdge is abstract

        this.ruleLinkExpert.addLinkMetaclass(ActivityEdge.class);

    }

    @objid ("4596f762-2fd7-46ef-9ce0-41627ce98e22")
    protected void registerLinkExpertForCommunicationChannel() {
        // Standard.CommunicationChannel
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(CommunicationChannel.class);

        // Standard.CommunicationChannel sources and target dependencies
        this.ruleLinkExpert.addTargetDep(CommunicationChannel.class, "End");
        this.ruleLinkExpert.addSourceDep(CommunicationChannel.class, "Start");


        // Standard.CommunicationChannel rules:

    }

    @objid ("92e03c60-8db7-4f6e-9f7b-3450486fb363")
    protected void registerLinkExpertForMessage() {
        // Standard.Message
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Message.class);

        // Standard.Message sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Message.class, "ReceiveEvent");
        this.ruleLinkExpert.addSourceDep(Message.class, "SendEvent");


        // Standard.Message rules:

    }

    @objid ("4c62cff0-ec20-4934-8259-a9592311f3c2")
    protected void registerLinkExpertForTransition() {
        // Standard.Transition
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Transition.class);

        // Standard.Transition sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Transition.class, "Source");
        this.ruleLinkExpert.addTargetDep(Transition.class, "Target");


        // Standard.Transition rules:

    }

    @objid ("eb2cbb68-e752-4a9f-bd06-5a271f8de4e5")
    protected void registerLinkExpertForUseCaseDependency() {
        // Standard.UseCaseDependency
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(UseCaseDependency.class);

        // Standard.UseCaseDependency sources and target dependencies
        this.ruleLinkExpert.addSourceDep(UseCaseDependency.class, "Origin");
        this.ruleLinkExpert.addTargetDep(UseCaseDependency.class, "Target");


        // Standard.UseCaseDependency rules:

    }

    @objid ("55b7b086-e54d-415f-b9b2-bbfd80640dc4")
    protected void registerLinkExpertForDataFlow() {
        // Standard.DataFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(DataFlow.class);

        // Standard.DataFlow sources and target dependencies
        this.ruleLinkExpert.addTargetDep(DataFlow.class, "Destination");
        this.ruleLinkExpert.addSourceDep(DataFlow.class, "Origin");


        // Standard.DataFlow rules:

    }

    @objid ("6f6f5a04-c137-48fc-a869-5e3eb64a6787")
    protected void registerLinkExpertForInformationFlow() {
        // Standard.InformationFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(InformationFlow.class);

        // Standard.InformationFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(InformationFlow.class, "InformationSource");
        this.ruleLinkExpert.addTargetDep(InformationFlow.class, "InformationTarget");


        // Standard.InformationFlow rules:

    }

    @objid ("be5b9111-7098-4d53-85b9-b6299e037803")
    protected void registerLinkExpertForAbstraction() {
        // Standard.Abstraction
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Abstraction.class);

        // Standard.Abstraction sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Abstraction.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(Abstraction.class, "Impacted");


        // Standard.Abstraction rules:

    }

    @objid ("b94e0dfa-5d38-471b-8bbb-d0340224e5aa")
    protected void registerLinkExpertForSubstitution() {
        // Standard.Substitution
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Substitution.class);

        // Standard.Substitution sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Substitution.class, "Contract");
        this.ruleLinkExpert.addSourceDep(Substitution.class, "SubstitutingClassifier");


        // Standard.Substitution rules:

    }

    @objid ("53e66ffa-b370-40d3-9184-8f6aabaf13fb")
    protected void registerLinkExpertForUsage() {
        // Standard.Usage
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Usage.class);

        // Standard.Usage sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Usage.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(Usage.class, "Impacted");


        // Standard.Usage rules:

    }

    @objid ("717fc6a5-67de-43b5-a971-aef6edc825c0")
    protected void registerLinkExpertForAssociation() {
        // Standard.Association
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Association.class);

        // Standard.Association sources and target dependencies


        // Standard.Association rules:

    }

    @objid ("5d0fe780-dcc2-4cdb-9d4a-2e973adc65b5")
    protected void registerLinkExpertForAssociationEnd() {
        // Standard.AssociationEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(AssociationEnd.class);

        // Standard.AssociationEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(AssociationEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(AssociationEnd.class, "Target");


        // Standard.AssociationEnd rules:

    }

    @objid ("413e9a42-e1b3-4143-af9d-a87332556b0a")
    protected void registerLinkExpertForElementImport() {
        // Standard.ElementImport
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ElementImport.class);

        // Standard.ElementImport sources and target dependencies
        this.ruleLinkExpert.addTargetDep(ElementImport.class, "ImportedElement");
        this.ruleLinkExpert.addSourceDep(ElementImport.class, "ImportingNameSpace");
        this.ruleLinkExpert.addSourceDep(ElementImport.class, "ImportingOperation");


        // Standard.ElementImport rules:

    }

    @objid ("808d470a-6495-491c-9016-c8048bcbaec4")
    protected void registerLinkExpertForGeneralization() {
        // Standard.Generalization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Generalization.class);

        // Standard.Generalization sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Generalization.class, "SubType");
        this.ruleLinkExpert.addTargetDep(Generalization.class, "SuperType");


        // Standard.Generalization rules:

    }

    @objid ("075d314b-3e6f-4b91-90c7-aacdbde14f3a")
    protected void registerLinkExpertForInterfaceRealization() {
        // Standard.InterfaceRealization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(InterfaceRealization.class);

        // Standard.InterfaceRealization sources and target dependencies
        this.ruleLinkExpert.addTargetDep(InterfaceRealization.class, "Implemented");
        this.ruleLinkExpert.addSourceDep(InterfaceRealization.class, "Implementer");


        // Standard.InterfaceRealization rules:

    }

    @objid ("422c0cb8-c0cc-4e15-901e-3518433fcd80")
    protected void registerLinkExpertForLink() {
        // Standard.Link
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Link.class);

        // Standard.Link sources and target dependencies


        // Standard.Link rules:

    }

    @objid ("a4421ec8-c9a0-40a2-b42a-0330998c0832")
    protected void registerLinkExpertForLinkEnd() {
        // Standard.LinkEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(LinkEnd.class);

        // Standard.LinkEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(LinkEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(LinkEnd.class, "Target");


        // Standard.LinkEnd rules:

    }

    @objid ("47afe125-9fa9-49bf-bf04-8e4b68512e05")
    protected void registerLinkExpertForManifestation() {
        // Standard.Manifestation
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Manifestation.class);

        // Standard.Manifestation sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Manifestation.class, "Owner");
        this.ruleLinkExpert.addTargetDep(Manifestation.class, "UtilizedElement");


        // Standard.Manifestation rules:

    }

    @objid ("a8e6deb6-e299-4c05-827d-9a843bde0138")
    protected void registerLinkExpertForPackageImport() {
        // Standard.PackageImport
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(PackageImport.class);

        // Standard.PackageImport sources and target dependencies
        this.ruleLinkExpert.addTargetDep(PackageImport.class, "ImportedPackage");
        this.ruleLinkExpert.addSourceDep(PackageImport.class, "ImportingNameSpace");
        this.ruleLinkExpert.addSourceDep(PackageImport.class, "ImportingOperation");


        // Standard.PackageImport rules:

    }

    @objid ("ef86cfab-a0fe-47a8-a48b-7421acda811e")
    protected void registerLinkExpertForPackageMerge() {
        // Standard.PackageMerge
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(PackageMerge.class);

        // Standard.PackageMerge sources and target dependencies
        this.ruleLinkExpert.addTargetDep(PackageMerge.class, "MergedPackage");
        this.ruleLinkExpert.addSourceDep(PackageMerge.class, "ReceivingPackage");


        // Standard.PackageMerge rules:

    }

    @objid ("3b4fcc3f-69a8-48b9-8c87-5434455cd663")
    protected void registerLinkExpertForRaisedException() {
        // Standard.RaisedException
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(RaisedException.class);

        // Standard.RaisedException sources and target dependencies
        this.ruleLinkExpert.addSourceDep(RaisedException.class, "Thrower");
        this.ruleLinkExpert.addTargetDep(RaisedException.class, "ThrownType");


        // Standard.RaisedException rules:

    }

    @objid ("4a5847f3-1b6e-448a-b056-e048165db5ef")
    protected void registerLinkExpertForTemplateBinding() {
        // Standard.TemplateBinding
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(TemplateBinding.class);

        // Standard.TemplateBinding sources and target dependencies
        this.ruleLinkExpert.addSourceDep(TemplateBinding.class, "BoundElement");
        this.ruleLinkExpert.addSourceDep(TemplateBinding.class, "BoundOperation");
        this.ruleLinkExpert.addTargetDep(TemplateBinding.class, "InstanciatedTemplate");
        this.ruleLinkExpert.addTargetDep(TemplateBinding.class, "InstanciatedTemplateOperation");


        // Standard.TemplateBinding rules:

    }

    @objid ("4da116c1-155e-4c8b-aa69-2e9c81c30958")
    protected void registerLinkExpertForControlFlow() {
        // Standard.ControlFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ControlFlow.class);

        // Standard.ControlFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ControlFlow.class, "Source");
        this.ruleLinkExpert.addTargetDep(ControlFlow.class, "Target");


        // Standard.ControlFlow rules:

    }

    @objid ("14e1695c-4cb8-43d0-ad6b-c8b2c3359ee3")
    protected void registerLinkExpertForMessageFlow() {
        // Standard.MessageFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(MessageFlow.class);

        // Standard.MessageFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(MessageFlow.class, "Source");
        this.ruleLinkExpert.addSourceDep(MessageFlow.class, "SourcePartition");
        this.ruleLinkExpert.addTargetDep(MessageFlow.class, "Target");
        this.ruleLinkExpert.addTargetDep(MessageFlow.class, "TargetPartition");


        // Standard.MessageFlow rules:

    }

    @objid ("144ef2b9-83a4-4bed-9cd6-cf5519608fe6")
    protected void registerLinkExpertForObjectFlow() {
        // Standard.ObjectFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ObjectFlow.class);

        // Standard.ObjectFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ObjectFlow.class, "Source");
        this.ruleLinkExpert.addTargetDep(ObjectFlow.class, "Target");


        // Standard.ObjectFlow rules:

    }

    @objid ("7b523c50-3e82-47d9-b6f4-b76993ce8400")
    protected void registerLinkExpertForElementRealization() {
        // Standard.ElementRealization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ElementRealization.class);

        // Standard.ElementRealization sources and target dependencies
        this.ruleLinkExpert.addTargetDep(ElementRealization.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(ElementRealization.class, "Impacted");


        // Standard.ElementRealization rules:

    }

    @objid ("a8350921-cfa3-4f3f-b3c7-349158051e40")
    protected void registerLinkExpertForConnector() {
        // Standard.Connector
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Connector.class);

        // Standard.Connector sources and target dependencies


        // Standard.Connector rules:

    }

    @objid ("79995f5f-beb9-4817-b1f7-cdef471c4ccb")
    protected void registerLinkExpertForConnectorEnd() {
        // Standard.ConnectorEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ConnectorEnd.class);

        // Standard.ConnectorEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ConnectorEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(ConnectorEnd.class, "Target");


        // Standard.ConnectorEnd rules:

    }

    @objid ("7e887b23-920a-4494-a45b-3f23d02ba9b9")
    protected void registerMetaExpertForProject() {
        // Standard.Project
        // -----------

        // no constraint on Project.Model : Package from Standard.Project to Standard.Package
        this.ruleMetaExpert.addDependencyRule(Project.class, null, "Model");

    }

    @objid ("634ac2e4-eaed-45ae-8830-d764300a0ec5")
    protected void registerMetaExpertForTemplateParameterSubstitution() {
        // Standard.TemplateParameterSubstitution
        // -----------

        // no constraint on TemplateParameterSubstitution.Actual : UmlModelElement from Standard.TemplateParameterSubstitution to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(TemplateParameterSubstitution.class, null, "Actual");

        // no constraint on TemplateParameterSubstitution.FormalParameter : TemplateParameter from Standard.TemplateParameterSubstitution to Standard.TemplateParameter
        this.ruleMetaExpert.addDependencyRule(TemplateParameterSubstitution.class, null, "FormalParameter");

    }

    @objid ("d9cb8ec2-2939-41a7-ba35-6a4df01c65a1")
    protected void registerMetaExpertForTemplateParameter() {
        // Standard.TemplateParameter
        // -----------

        // no constraint on TemplateParameter.Type : UmlModelElement from Standard.TemplateParameter to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Type");

        // no constraint on TemplateParameter.OwnedParameterElement : UmlModelElement from Standard.TemplateParameter to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedParameterElement");

        // no constraint on TemplateParameter.DefaultType : UmlModelElement from Standard.TemplateParameter to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "DefaultType");

    }

    @objid ("30f037b2-22a9-45b5-913e-193f68d959fb")
    protected void registerMetaExpertForTemplateBinding() {
        // Standard.TemplateBinding
        // -----------

        // no constraint on TemplateBinding.ParameterSubstitution : TemplateParameterSubstitution from Standard.TemplateBinding to Standard.TemplateParameterSubstitution
        this.ruleMetaExpert.addDependencyRule(TemplateBinding.class, null, "ParameterSubstitution");

        // no constraint on TemplateBinding.InstanciatedTemplateOperation : Operation from Standard.TemplateBinding to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(TemplateBinding.class, null, "InstanciatedTemplateOperation");

        // no constraint on TemplateBinding.InstanciatedTemplate : NameSpace from Standard.TemplateBinding to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(TemplateBinding.class, null, "InstanciatedTemplate");

    }

    @objid ("9cb1f6b0-416b-4e64-9f88-43abecb2a674")
    protected void registerMetaExpertForRequiredInterface() {
        // Standard.RequiredInterface
        // -----------

        // no constraint on RequiredInterface.RequiredElement : Interface from Standard.RequiredInterface to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(RequiredInterface.class, null, "RequiredElement");

    }

    @objid ("d85581d6-cee2-4a17-8d85-cdb84f180f42")
    protected void registerMetaExpertForRaisedException() {
        // Standard.RaisedException
        // -----------

        // no constraint on RaisedException.ThrownType : Classifier from Standard.RaisedException to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(RaisedException.class, null, "ThrownType");

    }

    @objid ("8171ae7d-72d6-462c-8a3f-1eadda6e9a2c")
    protected void registerMetaExpertForProvidedInterface() {
        // Standard.ProvidedInterface
        // -----------

        // no constraint on ProvidedInterface.ProvidedElement : Interface from Standard.ProvidedInterface to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(ProvidedInterface.class, null, "ProvidedElement");

    }

    @objid ("e8095055-2709-47f5-8a81-605d82122ca2")
    protected void registerMetaExpertForPort() {
        // Standard.Port
        // -----------

        // no constraint on Port.Provided : ProvidedInterface from Standard.Port to Standard.ProvidedInterface
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Provided");

        // no constraint on Port.Required : RequiredInterface from Standard.Port to Standard.RequiredInterface
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Required");

    }

    @objid ("eac34735-77a7-4fdb-b776-c147c3af0093")
    protected void registerMetaExpertForPackageMerge() {
        // Standard.PackageMerge
        // -----------

        // no constraint on PackageMerge.MergedPackage : Package from Standard.PackageMerge to Standard.Package
        this.ruleMetaExpert.addDependencyRule(PackageMerge.class, null, "MergedPackage");

    }

    @objid ("e4c20e67-91ac-4b6f-9afe-ebec179473b1")
    protected void registerMetaExpertForPackageImport() {
        // Standard.PackageImport
        // -----------

        // no constraint on PackageImport.ImportedPackage : Package from Standard.PackageImport to Standard.Package
        this.ruleMetaExpert.addDependencyRule(PackageImport.class, null, "ImportedPackage");

    }

    @objid ("553f153d-9fb0-488f-8668-fed8a99ad1f8")
    protected void registerMetaExpertForPackage() {
        // Standard.Package
        // -----------

        // no constraint on Package.Merge : PackageMerge from Standard.Package to Standard.PackageMerge
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Merge");

    }

    @objid ("51929883-95b6-4a96-9ec0-9c4318bfb82e")
    protected void registerMetaExpertForOperation() {
        // Standard.Operation
        // -----------

        // no constraint on Operation.OwnedImport : ElementImport from Standard.Operation to Standard.ElementImport
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "OwnedImport");

        // no constraint on Operation.Thrown : RaisedException from Standard.Operation to Standard.RaisedException
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "Thrown");

        // no constraint on Operation.Example : Collaboration from Standard.Operation to Standard.Collaboration
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "Example");

        // no constraint on Operation.OwnedBehavior : Behavior from Standard.Operation to Standard.Behavior
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "OwnedBehavior");

        // no constraint on Operation.IO : Parameter from Standard.Operation to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "IO");

        // no constraint on Operation.TemplateInstanciation : TemplateBinding from Standard.Operation to Standard.TemplateBinding
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "TemplateInstanciation");

        // no constraint on Operation.OwnedPackageImport : PackageImport from Standard.Operation to Standard.PackageImport
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "OwnedPackageImport");

        // no constraint on Operation.Return : Parameter from Standard.Operation to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "Return");

        // no constraint on Operation.Template : TemplateParameter from Standard.Operation to Standard.TemplateParameter
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "Template");

        // no constraint on Operation.OwnedCollaborationUse : CollaborationUse from Standard.Operation to Standard.CollaborationUse
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "OwnedCollaborationUse");

        // no constraint on Operation.Redefines : Operation from Standard.Operation to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "Redefines");

    }

    @objid ("ef735a50-df3a-43fd-b698-02ebc0617c0f")
    protected void registerMetaExpertForNode() {
        // Standard.Node
        // -----------

        // no constraint on Node.Resident : Artifact from Standard.Node to Standard.Artifact
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Resident");

    }

    @objid ("6c81843f-8d60-4b7a-a9cb-a64d2ec945f9")
    protected void registerMetaExpertForNaryConnectorEnd() {
        // Standard.NaryConnectorEnd
        // -----------

    }

    @objid ("e0328e38-e141-4d71-b0d6-4bf7ccb65a52")
    protected void registerMetaExpertForNaryLinkEnd() {
        // Standard.NaryLinkEnd
        // -----------

        // no constraint on NaryLinkEnd.NaryLink : NaryLink from Standard.NaryLinkEnd to Standard.NaryLink
        this.ruleMetaExpert.addDependencyRule(NaryConnectorEnd.class, null, "NaryLink");
        this.ruleMetaExpert.addDependencyRule(NaryLinkEnd.class, null, "NaryLink");

        // no constraint on NaryLinkEnd.Consumer : RequiredInterface from Standard.NaryLinkEnd to Standard.RequiredInterface
        this.ruleMetaExpert.addDependencyRule(NaryConnectorEnd.class, null, "Consumer");
        this.ruleMetaExpert.addDependencyRule(NaryLinkEnd.class, null, "Consumer");

        // no constraint on NaryLinkEnd.Provider : ProvidedInterface from Standard.NaryLinkEnd to Standard.ProvidedInterface
        this.ruleMetaExpert.addDependencyRule(NaryConnectorEnd.class, null, "Provider");
        this.ruleMetaExpert.addDependencyRule(NaryLinkEnd.class, null, "Provider");

    }

    @objid ("e56fd4b1-b8df-43a1-a1cc-a9cb2de94d99")
    protected void registerMetaExpertForNaryConnector() {
        // Standard.NaryConnector
        // -----------

        // no constraint on NaryConnector.RepresentedFeature : UmlModelElement from Standard.NaryConnector to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(NaryConnector.class, null, "RepresentedFeature");

    }

    @objid ("49205f04-ec9a-4889-8b46-4fc73b75fa2a")
    protected void registerMetaExpertForNaryLink() {
        // Standard.NaryLink
        // -----------

        // no constraint on NaryLink.NaryLinkEnd : NaryLinkEnd from Standard.NaryLink to Standard.NaryLinkEnd
        this.ruleMetaExpert.addDependencyRule(NaryConnector.class, null, "NaryLinkEnd");
        this.ruleMetaExpert.addDependencyRule(NaryLink.class, null, "NaryLinkEnd");

        // no constraint on NaryLink.Model : NaryAssociation from Standard.NaryLink to Standard.NaryAssociation
        this.ruleMetaExpert.addDependencyRule(NaryConnector.class, null, "Model");
        this.ruleMetaExpert.addDependencyRule(NaryLink.class, null, "Model");

    }

    @objid ("c132621a-727d-4837-b68c-38bb6c76a49e")
    protected void registerMetaExpertForNaryAssociationEnd() {
        // Standard.NaryAssociationEnd
        // -----------

        // no constraint on NaryAssociationEnd.NaryAssociation : NaryAssociation from Standard.NaryAssociationEnd to Standard.NaryAssociation
        this.ruleMetaExpert.addDependencyRule(NaryAssociationEnd.class, null, "NaryAssociation");

    }

    @objid ("11233d0e-78f4-427a-9242-4ed67487ec44")
    protected void registerMetaExpertForNaryAssociation() {
        // Standard.NaryAssociation
        // -----------

        // no constraint on NaryAssociation.NaryEnd : NaryAssociationEnd from Standard.NaryAssociation to Standard.NaryAssociationEnd
        this.ruleMetaExpert.addDependencyRule(NaryAssociation.class, null, "NaryEnd");

        // no constraint on NaryAssociation.LinkToClass : ClassAssociation from Standard.NaryAssociation to Standard.ClassAssociation
        this.ruleMetaExpert.addDependencyRule(NaryAssociation.class, null, "LinkToClass");

    }

    @objid ("c25a26e2-0cb8-4dda-b42d-e871f8cf60ed")
    protected void registerMetaExpertForManifestation() {
        // Standard.Manifestation
        // -----------

        // no constraint on Manifestation.UtilizedElement : UmlModelElement from Standard.Manifestation to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(Manifestation.class, null, "UtilizedElement");

    }

    @objid ("edd00b7d-bb05-4b24-a45b-0ad9abac21bd")
    protected void registerMetaExpertForInterfaceRealization() {
        // Standard.InterfaceRealization
        // -----------

        // no constraint on InterfaceRealization.Implemented : Interface from Standard.InterfaceRealization to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(InterfaceRealization.class, null, "Implemented");

    }

    @objid ("4b0ab510-5bcf-4c26-9c6b-16b32766ba00")
    protected void registerMetaExpertForInterface() {
        // Standard.Interface
        // -----------

    }

    @objid ("ac5378dd-294a-4a95-9bd0-37b905d10221")
    protected void registerMetaExpertForGeneralization() {
        // Standard.Generalization
        // -----------

        // no constraint on Generalization.SuperType : NameSpace from Standard.Generalization to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(Generalization.class, null, "SuperType");

    }

    @objid ("76f03e10-2703-4a94-abd7-2d3d3cd70aac")
    protected void registerMetaExpertForEnumerationLiteral() {
        // Standard.EnumerationLiteral
        // -----------

    }

    @objid ("64697bfc-e3e3-4f51-84a4-b019dd957145")
    protected void registerMetaExpertForEnumeration() {
        // Standard.Enumeration
        // -----------

        // no constraint on Enumeration.Value : EnumerationLiteral from Standard.Enumeration to Standard.EnumerationLiteral
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Value");

    }

    @objid ("aa4b3996-3bf3-439f-bd64-a069fa60c046")
    protected void registerMetaExpertForElementRealization() {
        // Standard.ElementRealization
        // -----------

    }

    @objid ("dfb4662d-b385-4a4b-b5a8-19264242ea29")
    protected void registerMetaExpertForElementImport() {
        // Standard.ElementImport
        // -----------

        // no constraint on ElementImport.ImportedElement : NameSpace from Standard.ElementImport to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(ElementImport.class, null, "ImportedElement");

    }

    @objid ("d0e292c9-6862-4c42-b8e3-f3bfe122e834")
    protected void registerMetaExpertForDataType() {
        // Standard.DataType
        // -----------

    }

    @objid ("ddba174f-1dec-49fb-af8c-112d0667d49f")
    protected void registerMetaExpertForConnectorEnd() {
        // Standard.ConnectorEnd
        // -----------

        // no constraint on ConnectorEnd.RepresentedFeature : UmlModelElement from Standard.ConnectorEnd to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "RepresentedFeature");

    }

    @objid ("9f80646a-ee4b-4dd4-b06e-3ed7646efb54")
    protected void registerMetaExpertForLinkEnd() {
        // Standard.LinkEnd
        // -----------

        // no constraint on LinkEnd.Link : Link from Standard.LinkEnd to Standard.Link
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Link");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Link");

        // no constraint on LinkEnd.Target : Instance from Standard.LinkEnd to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Target");

        // no constraint on LinkEnd.Model : AssociationEnd from Standard.LinkEnd to Standard.AssociationEnd
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Model");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Model");

        // no constraint on LinkEnd.Consumer : RequiredInterface from Standard.LinkEnd to Standard.RequiredInterface
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Consumer");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Consumer");

        // no constraint on LinkEnd.Opposite : LinkEnd from Standard.LinkEnd to Standard.LinkEnd
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Opposite");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Opposite");

        // no constraint on LinkEnd.Source : Instance from Standard.LinkEnd to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Source");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Source");

        // no constraint on LinkEnd.Provider : ProvidedInterface from Standard.LinkEnd to Standard.ProvidedInterface
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "Provider");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "Provider");

    }

    @objid ("e885c151-0555-4cdd-9337-df2e84d07c4b")
    protected void registerMetaExpertForConnector() {
        // Standard.Connector
        // -----------

    }

    @objid ("8fc3591c-cdae-4e42-a3ab-fc8cc6534596")
    protected void registerMetaExpertForLink() {
        // Standard.Link
        // -----------

        // no constraint on Link.Model : Association from Standard.Link to Standard.Association
        this.ruleMetaExpert.addDependencyRule(Connector.class, null, "Model");
        this.ruleMetaExpert.addDependencyRule(Link.class, null, "Model");

    }

    @objid ("dc17c8d8-684b-4444-b641-cd40cb1c20c1")
    protected void registerMetaExpertForComponentRealization() {
        // Standard.ComponentRealization
        // -----------

        // no constraint on ComponentRealization.RealizingClassifier : Classifier from Standard.ComponentRealization to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(ComponentRealization.class, null, "RealizingClassifier");

    }

    @objid ("dc8a6575-b10b-43a3-ad39-c859c66d069b")
    protected void registerMetaExpertForComponent() {
        // Standard.Component
        // -----------

        // no constraint on Component.Realization : ComponentRealization from Standard.Component to Standard.ComponentRealization
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Realization");

    }

    @objid ("9edf890b-5600-464a-9831-4384d5581039")
    protected void registerMetaExpertForCollaborationUse() {
        // Standard.CollaborationUse
        // -----------

        // no constraint on CollaborationUse.Type : Collaboration from Standard.CollaborationUse to Standard.Collaboration
        this.ruleMetaExpert.addDependencyRule(CollaborationUse.class, null, "Type");

        // no constraint on CollaborationUse.RoleBinding : Binding from Standard.CollaborationUse to Standard.Binding
        this.ruleMetaExpert.addDependencyRule(CollaborationUse.class, null, "RoleBinding");

    }

    @objid ("bea9dbd1-538b-4907-b3a2-35242b9550a6")
    protected void registerMetaExpertForCollaboration() {
        // Standard.Collaboration
        // -----------

    }

    @objid ("b4716726-0e04-4789-afe3-c494eba07735")
    protected void registerMetaExpertForClassAssociation() {
        // Standard.ClassAssociation
        // -----------

        // no constraint on ClassAssociation.ClassPart : Class from Standard.ClassAssociation to Standard.Class
        this.ruleMetaExpert.addDependencyRule(ClassAssociation.class, null, "ClassPart");

    }

    @objid ("6d141916-792c-4e42-9912-0b818f07eecd")
    protected void registerMetaExpertForClass() {
        // Standard.Class
        // -----------

    }

    @objid ("db11c7a5-15ff-49e3-811a-4e1c4debcb4c")
    protected void registerMetaExpertForBinding() {
        // Standard.Binding
        // -----------

        // no constraint on Binding.ConnectorEndRole : ConnectorEnd from Standard.Binding to Standard.ConnectorEnd
        this.ruleMetaExpert.addDependencyRule(Binding.class, null, "ConnectorEndRole");

        // no constraint on Binding.ConnectorRole : NaryConnector from Standard.Binding to Standard.NaryConnector
        this.ruleMetaExpert.addDependencyRule(Binding.class, null, "ConnectorRole");

        // no constraint on Binding.Role : BindableInstance from Standard.Binding to Standard.BindableInstance
        this.ruleMetaExpert.addDependencyRule(Binding.class, null, "Role");

        // no constraint on Binding.RepresentedFeature : UmlModelElement from Standard.Binding to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(Binding.class, null, "RepresentedFeature");

    }

    @objid ("b6b5e7cc-bb3c-419a-b442-20dc93820d4d")
    protected void registerMetaExpertForBindableInstance() {
        // Standard.BindableInstance
        // -----------

        // no constraint on BindableInstance.RepresentedFeature : UmlModelElement from Standard.BindableInstance to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "RepresentedFeature");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "RepresentedFeature");

    }

    @objid ("8d443c9f-8b29-4f8f-b403-ca8e4b2cd291")
    protected void registerMetaExpertForInstance() {
        // Standard.Instance
        // -----------

        // no constraint on Instance.OwnedEnd : LinkEnd from Standard.Instance to Standard.LinkEnd
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "OwnedEnd");

        // no constraint on Instance.Base : NameSpace from Standard.Instance to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "Base");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "Base");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Base");

        // no constraint on Instance.OwnedNaryEnd : NaryLinkEnd from Standard.Instance to Standard.NaryLinkEnd
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "OwnedNaryEnd");

        // no constraint on Instance.Slot : AttributeLink from Standard.Instance to Standard.AttributeLink
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "Slot");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "Slot");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Slot");

        // no constraint on Instance.Part : BindableInstance from Standard.Instance to Standard.BindableInstance
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "Part");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "Part");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Part");

    }

    @objid ("7edb7ecf-9f07-4db0-b124-a13d615b0a25")
    protected void registerMetaExpertForBehavioralFeature() {
        // Standard.BehavioralFeature
        // -----------

    }

    @objid ("98dd823b-580c-402c-957e-e75c62a31972")
    protected void registerMetaExpertForAttributeLink() {
        // Standard.AttributeLink
        // -----------

        // no constraint on AttributeLink.Base : Attribute from Standard.AttributeLink to Standard.Attribute
        this.ruleMetaExpert.addDependencyRule(AttributeLink.class, null, "Base");

    }

    @objid ("bc6e0cdb-b9d6-45c2-b3e9-f836bdbd9235")
    protected void registerMetaExpertForAttribute() {
        // Standard.Attribute
        // -----------

        // no constraint on Attribute.Type : GeneralClass from Standard.Attribute to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(Attribute.class, null, "Type");

    }

    @objid ("bac71cd0-0d0d-4ad1-b7c7-473a3de6ab36")
    protected void registerMetaExpertForAssociationEnd() {
        // Standard.AssociationEnd
        // -----------

        // no constraint on AssociationEnd.Target : Classifier from Standard.AssociationEnd to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "Target");

        // no constraint on AssociationEnd.Source : Classifier from Standard.AssociationEnd to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "Source");

        // no constraint on AssociationEnd.Qualifier : Attribute from Standard.AssociationEnd to Standard.Attribute
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "Qualifier");

        // no constraint on AssociationEnd.Opposite : AssociationEnd from Standard.AssociationEnd to Standard.AssociationEnd
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "Opposite");

        // no constraint on AssociationEnd.Association : Association from Standard.AssociationEnd to Standard.Association
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "Association");

    }

    @objid ("1fff015f-002a-48a9-ba39-5f7e1cc875f0")
    protected void registerMetaExpertForStructuralFeature() {
        // Standard.StructuralFeature
        // -----------

    }

    @objid ("97aa8fc7-4086-4fcc-9ac1-fc5962afca04")
    protected void registerMetaExpertForFeature() {
        // Standard.Feature is abstract

        // -----------

    }

    @objid ("e4452c95-68a7-40a8-b6cd-f5197c32be47")
    protected void registerMetaExpertForAssociation() {
        // Standard.Association
        // -----------

        // no constraint on Association.LinkToClass : ClassAssociation from Standard.Association to Standard.ClassAssociation
        this.ruleMetaExpert.addDependencyRule(Association.class, null, "LinkToClass");

    }

    @objid ("45ed6f3e-9d7c-4351-aa9f-f9b0eca199d7")
    protected void registerMetaExpertForArtifact() {
        // Standard.Artifact
        // -----------

        // no constraint on Artifact.Utilized : Manifestation from Standard.Artifact to Standard.Manifestation
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Utilized");

    }

    @objid ("269d01aa-cff2-4a31-bf5f-293e16019a38")
    protected void registerMetaExpertForUsage() {
        // Standard.Usage
        // -----------

    }

    @objid ("67bc07a2-5b70-4ca0-af9c-e4908fc3d4d3")
    protected void registerMetaExpertForSubstitution() {
        // Standard.Substitution
        // -----------

        // no constraint on Substitution.Contract : Classifier from Standard.Substitution to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(Substitution.class, null, "Contract");

    }

    @objid ("7822ed9a-8d4b-4a51-af93-5c5372fd30ce")
    protected void registerMetaExpertForAbstraction() {
        // Standard.Abstraction
        // -----------

    }

    @objid ("cb1a4ddf-de8e-469b-bc6b-7c1961c37343")
    protected void registerMetaExpertForInformationItem() {
        // Standard.InformationItem
        // -----------

        // no constraint on InformationItem.Represented : Classifier from Standard.InformationItem to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Represented");

    }

    @objid ("8737ea6a-a62b-4620-a801-cc60f60fe8a0")
    protected void registerMetaExpertForInformationFlow() {
        // Standard.InformationFlow
        // -----------

        // no constraint on InformationFlow.InformationSource : UmlModelElement from Standard.InformationFlow to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "InformationSource");

        // no constraint on InformationFlow.InformationTarget : UmlModelElement from Standard.InformationFlow to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "InformationTarget");

        // no constraint on InformationFlow.RealizingActivityEdge : ActivityEdge from Standard.InformationFlow to Standard.ActivityEdge
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingActivityEdge");

        // no constraint on InformationFlow.RealizingCommunicationMessage : CommunicationMessage from Standard.InformationFlow to Standard.CommunicationMessage
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingCommunicationMessage");

        // no constraint on InformationFlow.RealizingFeature : StructuralFeature from Standard.InformationFlow to Standard.StructuralFeature
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingFeature");

        // no constraint on InformationFlow.RealizingLink : LinkEnd from Standard.InformationFlow to Standard.LinkEnd
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingLink");

        // no constraint on InformationFlow.RealizingMessage : Message from Standard.InformationFlow to Standard.Message
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingMessage");

        // no constraint on InformationFlow.RealizingNaryLink : NaryLink from Standard.InformationFlow to Standard.NaryLink
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "RealizingNaryLink");

        // no constraint on InformationFlow.Conveyed : Classifier from Standard.InformationFlow to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "Conveyed");

        // no constraint on InformationFlow.Channel : AssociationEnd from Standard.InformationFlow to Standard.AssociationEnd
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "Channel");

    }

    @objid ("d0d38e4c-057c-46a5-86ab-18a80f54c43b")
    protected void registerMetaExpertForDataFlow() {
        // Standard.DataFlow
        // -----------

        // no constraint on DataFlow.Destination : NameSpace from Standard.DataFlow to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(DataFlow.class, null, "Destination");

        // no constraint on DataFlow.SModel : Signal from Standard.DataFlow to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(DataFlow.class, null, "SModel");

    }

    @objid ("d0304105-cf04-47b5-9b4d-0539ff2cb761")
    protected void registerMetaExpertForUseCaseDependency() {
        // Standard.UseCaseDependency
        // -----------

        // no constraint on UseCaseDependency.ExtensionLocation : ExtensionPoint from Standard.UseCaseDependency to Standard.ExtensionPoint
        this.ruleMetaExpert.addDependencyRule(UseCaseDependency.class, null, "ExtensionLocation");

        // no constraint on UseCaseDependency.Target : UseCase from Standard.UseCaseDependency to Standard.UseCase
        this.ruleMetaExpert.addDependencyRule(UseCaseDependency.class, null, "Target");

    }

    @objid ("96e50db8-e4e2-4a52-9098-a45b126856ff")
    protected void registerMetaExpertForUseCase() {
        // Standard.UseCase
        // -----------

        // no constraint on UseCase.Used : UseCaseDependency from Standard.UseCase to Standard.UseCaseDependency
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Used");

        // no constraint on UseCase.OwnedExtension : ExtensionPoint from Standard.UseCase to Standard.ExtensionPoint
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedExtension");

    }

    @objid ("774bd751-34a4-4fbc-ac18-e1af6db25574")
    protected void registerMetaExpertForExtensionPoint() {
        // Standard.ExtensionPoint
        // -----------

    }

    @objid ("8dad7a2b-6251-4bce-aede-c05734e22997")
    protected void registerMetaExpertForActor() {
        // Standard.Actor
        // -----------

    }

    @objid ("157dc643-8073-4ff6-bd76-04a9d0cf6278")
    protected void registerMetaExpertForTerminatePseudoState() {
        // Standard.TerminatePseudoState
        // -----------

    }

    @objid ("4f6a1740-fc22-4cb9-b5b7-8a1cb4ab990a")
    protected void registerMetaExpertForStateMachine() {
        // Standard.StateMachine
        // -----------

        // no constraint on StateMachine.Top : Region from Standard.StateMachine to Standard.Region
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "Top");

        // no constraint on StateMachine.EntryPoint : EntryPointPseudoState from Standard.StateMachine to Standard.EntryPointPseudoState
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "EntryPoint");

        // no constraint on StateMachine.ExitPoint : ExitPointPseudoState from Standard.StateMachine to Standard.ExitPointPseudoState
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "ExitPoint");

    }

    @objid ("80a72d32-3533-4951-a72c-8f09537eccd2")
    protected void registerMetaExpertForShallowHistoryPseudoState() {
        // Standard.ShallowHistoryPseudoState
        // -----------

    }

    @objid ("e55ca7cb-da99-48b1-89ce-a8bed2516e97")
    protected void registerMetaExpertForRegion() {
        // Standard.Region
        // -----------

        // no constraint on Region.Sub : StateVertex from Standard.Region to Standard.StateVertex
        this.ruleMetaExpert.addDependencyRule(Region.class, null, "Sub");

    }

    @objid ("2d702201-4b50-458e-8b0c-e0631e1bdb01")
    protected void registerMetaExpertForJunctionPseudoState() {
        // Standard.JunctionPseudoState
        // -----------

    }

    @objid ("e9a739f5-ec9e-44a5-970b-34b087e43672")
    protected void registerMetaExpertForJoinPseudoState() {
        // Standard.JoinPseudoState
        // -----------

    }

    @objid ("0ed371bd-50d3-443c-97cf-a12f63d458c9")
    protected void registerMetaExpertForInternalTransition() {
        // Standard.InternalTransition
        // -----------

    }

    @objid ("009f3aa0-d667-4352-a05e-be32c22b8f01")
    protected void registerMetaExpertForTransition() {
        // Standard.Transition
        // -----------

        // no constraint on Transition.Processed : Operation from Standard.Transition to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "Processed");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "Processed");

        // no constraint on Transition.Trigger : Event from Standard.Transition to Standard.Event
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "Trigger");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "Trigger");

        // no constraint on Transition.BehaviorEffect : Behavior from Standard.Transition to Standard.Behavior
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "BehaviorEffect");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "BehaviorEffect");

        // no constraint on Transition.Target : StateVertex from Standard.Transition to Standard.StateVertex
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "Target");

        // no constraint on Transition.Effects : Signal from Standard.Transition to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "Effects");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "Effects");

    }

    @objid ("9aef0d67-f7da-4e2c-823b-536f3df32136")
    protected void registerMetaExpertForInitialPseudoState() {
        // Standard.InitialPseudoState
        // -----------

    }

    @objid ("34a7f4fc-7122-4d3d-9a03-871ebf11c78b")
    protected void registerMetaExpertForForkPseudoState() {
        // Standard.ForkPseudoState
        // -----------

    }

    @objid ("3765a1b1-0504-469c-a51a-6d568c4a9d3b")
    protected void registerMetaExpertForFinalState() {
        // Standard.FinalState
        // -----------

    }

    @objid ("291c7ee6-4b88-423e-800f-35b577cfb7ed")
    protected void registerMetaExpertForState() {
        // Standard.State
        // -----------

        // no constraint on State.ExitPoint : ExitPointPseudoState from Standard.State to Standard.ExitPointPseudoState
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "ExitPoint");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "ExitPoint");

        // no constraint on State.Deffered : Event from Standard.State to Standard.Event
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "Deffered");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "Deffered");

        // no constraint on State.Internal : InternalTransition from Standard.State to Standard.InternalTransition
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "Internal");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "Internal");

        // no constraint on State.EntryPoint : EntryPointPseudoState from Standard.State to Standard.EntryPointPseudoState
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "EntryPoint");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "EntryPoint");

        // no constraint on State.OwnedRegion : Region from Standard.State to Standard.Region
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "OwnedRegion");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "OwnedRegion");

        // no constraint on State.Connection : ConnectionPointReference from Standard.State to Standard.ConnectionPointReference
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "Connection");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "Connection");

        // no constraint on State.SubMachine : StateMachine from Standard.State to Standard.StateMachine
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "SubMachine");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "SubMachine");

    }

    @objid ("be8ad53a-ce61-4889-b444-3fc95a81fe3b")
    protected void registerMetaExpertForExitPointPseudoState() {
        // Standard.ExitPointPseudoState
        // -----------

    }

    @objid ("16b8ec12-8985-4848-9c0f-5c64775d8522")
    protected void registerMetaExpertForEntryPointPseudoState() {
        // Standard.EntryPointPseudoState
        // -----------

    }

    @objid ("9820daaf-799a-4f3d-89c4-35fa68d81506")
    protected void registerMetaExpertForDeepHistoryPseudoState() {
        // Standard.DeepHistoryPseudoState
        // -----------

    }

    @objid ("54996a94-7c9b-400b-b85e-42541939a942")
    protected void registerMetaExpertForConnectionPointReference() {
        // Standard.ConnectionPointReference
        // -----------

        // no constraint on ConnectionPointReference.Exit : ExitPointPseudoState from Standard.ConnectionPointReference to Standard.ExitPointPseudoState
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "Exit");

        // no constraint on ConnectionPointReference.Entry : EntryPointPseudoState from Standard.ConnectionPointReference to Standard.EntryPointPseudoState
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "Entry");

    }

    @objid ("d05ec0d8-8de3-40f3-93f1-dccb9447beec")
    protected void registerMetaExpertForChoicePseudoState() {
        // Standard.ChoicePseudoState
        // -----------

    }

    @objid ("3d3167d8-261c-496c-ab24-3583667aef93")
    protected void registerMetaExpertForAbstractPseudoState() {
        // Standard.AbstractPseudoState is abstract

        // -----------

    }

    @objid ("cfd39df4-172b-4d59-8fc2-d4bd27a69207")
    protected void registerMetaExpertForStateVertex() {
        // Standard.StateVertex is abstract

        // -----------

        // no constraint on StateVertex.OutGoing : Transition from Standard.StateVertex to Standard.Transition
        this.ruleMetaExpert.addDependencyRule(AbstractPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(ChoicePseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(DeepHistoryPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(EntryPointPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(ExitPointPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(ForkPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(InitialPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(JoinPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(JunctionPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(ShallowHistoryPseudoState.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(StateVertex.class, null, "OutGoing");
        this.ruleMetaExpert.addDependencyRule(TerminatePseudoState.class, null, "OutGoing");

    }

    @objid ("5050be66-89f4-43dd-9c5d-6d9e04456bbd")
    protected void registerMetaExpertForTerminateSpecification() {
        // Standard.TerminateSpecification
        // -----------

    }

    @objid ("4e9b4ad3-360d-4a08-9aa6-d0b62bd2803d")
    protected void registerMetaExpertForStateInvariant() {
        // Standard.StateInvariant
        // -----------

    }

    @objid ("6bd84038-3cd8-4ace-ac9b-99003f528a9b")
    protected void registerMetaExpertForPartDecomposition() {
        // Standard.PartDecomposition
        // -----------

    }

    @objid ("b88ba5b0-8923-4673-b3a5-f03c52a6402a")
    protected void registerMetaExpertForMessage() {
        // Standard.Message
        // -----------

        // no constraint on Message.SignalSignature : Signal from Standard.Message to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(Message.class, null, "SignalSignature");

        // no constraint on Message.ReceiveEvent : MessageEnd from Standard.Message to Standard.MessageEnd
        this.ruleMetaExpert.addDependencyRule(Message.class, null, "ReceiveEvent");

        // no constraint on Message.Invoked : Operation from Standard.Message to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Message.class, null, "Invoked");

    }

    @objid ("e2ee392b-8171-4946-8861-eefc680458aa")
    protected void registerMetaExpertForLifeline() {
        // Standard.Lifeline
        // -----------

        // no constraint on Lifeline.DecomposedAs : PartDecomposition from Standard.Lifeline to Standard.PartDecomposition
        this.ruleMetaExpert.addDependencyRule(Lifeline.class, null, "DecomposedAs");

        // no constraint on Lifeline.Represented : Instance from Standard.Lifeline to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(Lifeline.class, null, "Represented");

    }

    @objid ("26a9a9f1-01fa-4813-8568-e29a817554fa")
    protected void registerMetaExpertForInteractionUse() {
        // Standard.InteractionUse
        // -----------

        // no constraint on InteractionUse.ActualGate : Gate from Standard.InteractionUse to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(InteractionUse.class, null, "ActualGate");
        this.ruleMetaExpert.addDependencyRule(PartDecomposition.class, null, "ActualGate");

        // no constraint on InteractionUse.RefersTo : Interaction from Standard.InteractionUse to Standard.Interaction
        this.ruleMetaExpert.addDependencyRule(InteractionUse.class, null, "RefersTo");
        this.ruleMetaExpert.addDependencyRule(PartDecomposition.class, null, "RefersTo");

    }

    @objid ("16bd7e19-2ea5-4a8d-bdde-5e9aec067b66")
    protected void registerMetaExpertForInteractionOperand() {
        // Standard.InteractionOperand
        // -----------

        // no constraint on InteractionOperand.Fragment : InteractionFragment from Standard.InteractionOperand to Standard.InteractionFragment
        this.ruleMetaExpert.addDependencyRule(InteractionOperand.class, null, "Fragment");

    }

    @objid ("6fd5bb55-be9e-420c-9e25-dbbcfddd292a")
    protected void registerMetaExpertForInteraction() {
        // Standard.Interaction
        // -----------

        // no constraint on Interaction.FormalGate : Gate from Standard.Interaction to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "FormalGate");

        // no constraint on Interaction.Fragment : InteractionFragment from Standard.Interaction to Standard.InteractionFragment
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "Fragment");

        // no constraint on Interaction.OwnedLine : Lifeline from Standard.Interaction to Standard.Lifeline
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "OwnedLine");

    }

    @objid ("969fd891-fec8-40e8-9b4d-8c1d37dd3654")
    protected void registerMetaExpertForGeneralOrdering() {
        // Standard.GeneralOrdering
        // -----------

        // no constraint on GeneralOrdering.After : OccurrenceSpecification from Standard.GeneralOrdering to Standard.OccurrenceSpecification
        this.ruleMetaExpert.addDependencyRule(GeneralOrdering.class, null, "After");

    }

    @objid ("293bae67-979e-4323-91da-e44978b30ade")
    protected void registerMetaExpertForGate() {
        // Standard.Gate
        // -----------

        // no constraint on Gate.Formal : Gate from Standard.Gate to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "Formal");

    }

    @objid ("b5f72844-740c-4951-8a02-fca924130bf5")
    protected void registerMetaExpertForExecutionSpecification() {
        // Standard.ExecutionSpecification
        // -----------

        // no constraint on ExecutionSpecification.Finish : ExecutionOccurenceSpecification from Standard.ExecutionSpecification to Standard.ExecutionOccurenceSpecification
        this.ruleMetaExpert.addDependencyRule(ExecutionSpecification.class, null, "Finish");

    }

    @objid ("5b0c2b87-f59f-4174-90a7-1fe2ba966037")
    protected void registerMetaExpertForExecutionOccurenceSpecification() {
        // Standard.ExecutionOccurenceSpecification
        // -----------

        // no constraint on ExecutionOccurenceSpecification.Started : ExecutionSpecification from Standard.ExecutionOccurenceSpecification to Standard.ExecutionSpecification
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "Started");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "Started");

    }

    @objid ("8e7ed36b-37ec-4c5c-80ac-981bd14975a5")
    protected void registerMetaExpertForMessageEnd() {
        // Standard.MessageEnd is abstract

        // -----------

        // no constraint on MessageEnd.SentMessage : Message from Standard.MessageEnd to Standard.Message
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(MessageEnd.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "SentMessage");

    }

    @objid ("8533d8d6-eaca-4659-ab91-b49a7974c93a")
    protected void registerMetaExpertForOccurrenceSpecification() {
        // Standard.OccurrenceSpecification is abstract

        // -----------

        // no constraint on OccurrenceSpecification.ToAfter : GeneralOrdering from Standard.OccurrenceSpecification to Standard.GeneralOrdering
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "ToAfter");
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "ToAfter");
        this.ruleMetaExpert.addDependencyRule(MessageEnd.class, null, "ToAfter");
        this.ruleMetaExpert.addDependencyRule(OccurrenceSpecification.class, null, "ToAfter");
        this.ruleMetaExpert.addDependencyRule(StateInvariant.class, null, "ToAfter");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "ToAfter");

    }

    @objid ("ccbb3df7-77d6-4ca9-9858-d87230eb32f4")
    protected void registerMetaExpertForDurationConstraint() {
        // Standard.DurationConstraint
        // -----------

    }

    @objid ("a8566b59-f4a4-4526-8422-b1f7dd330a9f")
    protected void registerMetaExpertForConstraint() {
        // Standard.Constraint
        // -----------

        // no constraint on Constraint.ConstrainedElement : UmlModelElement from Standard.Constraint to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(Constraint.class, null, "ConstrainedElement");
        this.ruleMetaExpert.addDependencyRule(DurationConstraint.class, null, "ConstrainedElement");

    }

    @objid ("76f6a9d8-077c-4e3f-85e5-65ae9556aac8")
    protected void registerMetaExpertForCombinedFragment() {
        // Standard.CombinedFragment
        // -----------

        // no constraint on CombinedFragment.Operand : InteractionOperand from Standard.CombinedFragment to Standard.InteractionOperand
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "Operand");

        // no constraint on CombinedFragment.FragmentGate : Gate from Standard.CombinedFragment to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "FragmentGate");

    }

    @objid ("8669a3a2-5704-48a7-a5f3-5911241b0099")
    protected void registerMetaExpertForInteractionFragment() {
        // Standard.InteractionFragment is abstract

        // -----------

        // no constraint on InteractionFragment.Covered : Lifeline from Standard.InteractionFragment to Standard.Lifeline
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(ExecutionSpecification.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(InteractionFragment.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(InteractionOperand.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(InteractionUse.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(MessageEnd.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(OccurrenceSpecification.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(PartDecomposition.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(StateInvariant.class, null, "Covered");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "Covered");

    }

    @objid ("dc87b85c-49b2-42db-9784-31550b3f23f7")
    protected void registerMetaExpertForCommunicationNode() {
        // Standard.CommunicationNode
        // -----------

        // no constraint on CommunicationNode.Represented : Instance from Standard.CommunicationNode to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(CommunicationNode.class, null, "Represented");

        // no constraint on CommunicationNode.Started : CommunicationChannel from Standard.CommunicationNode to Standard.CommunicationChannel
        this.ruleMetaExpert.addDependencyRule(CommunicationNode.class, null, "Started");

    }

    @objid ("0b5b65dd-bb80-4a92-b872-9a455d8f4993")
    protected void registerMetaExpertForCommunicationMessage() {
        // Standard.CommunicationMessage
        // -----------

        // no constraint on CommunicationMessage.Invoked : Operation from Standard.CommunicationMessage to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(CommunicationMessage.class, null, "Invoked");

        // no constraint on CommunicationMessage.SignalSignature : Signal from Standard.CommunicationMessage to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(CommunicationMessage.class, null, "SignalSignature");

    }

    @objid ("f7a27305-1324-40d8-bfc5-de720988c44d")
    protected void registerMetaExpertForCommunicationInteraction() {
        // Standard.CommunicationInteraction
        // -----------

        // no constraint on CommunicationInteraction.Owned : CommunicationNode from Standard.CommunicationInteraction to Standard.CommunicationNode
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "Owned");

    }

    @objid ("2350e2ed-6341-4dd5-b9f9-9ed5dba8ff57")
    protected void registerMetaExpertForCommunicationChannel() {
        // Standard.CommunicationChannel
        // -----------

        // no constraint on CommunicationChannel.StartToEndMessage : CommunicationMessage from Standard.CommunicationChannel to Standard.CommunicationMessage
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "StartToEndMessage");

        // no constraint on CommunicationChannel.Channel : Link from Standard.CommunicationChannel to Standard.Link
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "Channel");

        // no constraint on CommunicationChannel.NaryChannel : NaryLink from Standard.CommunicationChannel to Standard.NaryLink
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "NaryChannel");

        // no constraint on CommunicationChannel.EndToStartMessage : CommunicationMessage from Standard.CommunicationChannel to Standard.CommunicationMessage
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "EndToStartMessage");

        // no constraint on CommunicationChannel.End : CommunicationNode from Standard.CommunicationChannel to Standard.CommunicationNode
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "End");

    }

    @objid ("0654bb6b-d943-4d18-b071-5c4b382360ed")
    protected void registerMetaExpertForSignal() {
        // Standard.Signal
        // -----------

        // no constraint on Signal.PBase : Parameter from Standard.Signal to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "PBase");

        // no constraint on Signal.OBase : Operation from Standard.Signal to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OBase");

        // no constraint on Signal.Base : GeneralClass from Standard.Signal to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Base");

    }

    @objid ("8aa8343b-f3c5-4782-af79-153af8acd7ed")
    protected void registerMetaExpertForGeneralClass() {
        // Standard.GeneralClass is abstract

        // -----------

    }

    @objid ("6b52dc0d-bb5c-4ba5-b9ab-db7001497e7d")
    protected void registerMetaExpertForClassifier() {
        // Standard.Classifier is abstract

        // -----------

        // no constraint on Classifier.OwnedOperation : Operation from Standard.Classifier to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedOperation");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedOperation");

        // no constraint on Classifier.Substitued : Substitution from Standard.Classifier to Standard.Substitution
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Substitued");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Substitued");

        // no constraint on Classifier.OwnedAttribute : Attribute from Standard.Classifier to Standard.Attribute
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedAttribute");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedAttribute");

        // no constraint on Classifier.OwnedNaryEnd : NaryAssociationEnd from Standard.Classifier to Standard.NaryAssociationEnd
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedNaryEnd");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedNaryEnd");

        // no constraint on Classifier.OwnedEnd : AssociationEnd from Standard.Classifier to Standard.AssociationEnd
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedEnd");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedEnd");

        // no constraint on Classifier.InternalStructure : BindableInstance from Standard.Classifier to Standard.BindableInstance
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "InternalStructure");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "InternalStructure");

    }

    @objid ("4aae3f63-a594-45c4-be48-4b15a57c64a8")
    protected void registerMetaExpertForNameSpace() {
        // Standard.NameSpace is abstract

        // -----------

        // no constraint on NameSpace.Parent : Generalization from Standard.NameSpace to Standard.Generalization
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Parent");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Parent");

        // no constraint on NameSpace.TemplateInstanciation : TemplateBinding from Standard.NameSpace to Standard.TemplateBinding
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "TemplateInstanciation");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "TemplateInstanciation");

        // no constraint on NameSpace.OwnedBehavior : Behavior from Standard.NameSpace to Standard.Behavior
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedBehavior");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedBehavior");

        // no constraint on NameSpace.OwnedInformationFlow : InformationFlow from Standard.NameSpace to Standard.InformationFlow
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedInformationFlow");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedInformationFlow");

        // no constraint on NameSpace.Sent : DataFlow from Standard.NameSpace to Standard.DataFlow
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Sent");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Sent");

        // no constraint on NameSpace.OwnedDataFlow : DataFlow from Standard.NameSpace to Standard.DataFlow
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedDataFlow");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedDataFlow");

        // no constraint on NameSpace.OwnedCollaborationUse : CollaborationUse from Standard.NameSpace to Standard.CollaborationUse
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedCollaborationUse");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedCollaborationUse");

        // no constraint on NameSpace.OwnedPackageImport : PackageImport from Standard.NameSpace to Standard.PackageImport
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedPackageImport");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedPackageImport");

        // no constraint on NameSpace.Template : TemplateParameter from Standard.NameSpace to Standard.TemplateParameter
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Template");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Template");

        // no constraint on NameSpace.Realized : InterfaceRealization from Standard.NameSpace to Standard.InterfaceRealization
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Realized");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Realized");

        // no constraint on NameSpace.Declared : Instance from Standard.NameSpace to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "Declared");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Declared");

        // no constraint on NameSpace.OwnedImport : ElementImport from Standard.NameSpace to Standard.ElementImport
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedImport");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedImport");

    }

    @objid ("151c6d9f-295f-47ec-85c0-f618e1eacfe1")
    protected void registerMetaExpertForModelTree() {
        // Standard.ModelTree is abstract

        // -----------

        // no constraint on ModelTree.OwnedElement : ModelTree from Standard.ModelTree to Standard.ModelTree
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(ModelTree.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "OwnedElement");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedElement");

    }

    @objid ("2fdd0e0f-6c20-4c1d-8b30-6a606791c6fb")
    protected void registerMetaExpertForOpaqueBehavior() {
        // Standard.OpaqueBehavior
        // -----------

    }

    @objid ("2a667714-378b-4775-bc59-f5c0665b4ce3")
    protected void registerMetaExpertForEvent() {
        // Standard.Event
        // -----------

        // no constraint on Event.Model : Signal from Standard.Event to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "Model");

        // no constraint on Event.Called : Operation from Standard.Event to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "Called");

    }

    @objid ("b0343e94-9bd1-48f1-8e57-3ffe4180aee3")
    protected void registerMetaExpertForBehaviorParameter() {
        // Standard.BehaviorParameter
        // -----------

        // no constraint on BehaviorParameter.Mapped : Parameter from Standard.BehaviorParameter to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(BehaviorParameter.class, null, "Mapped");

    }

    @objid ("ff3c96fe-e1c1-45dd-ab6c-9dddfb5d92a6")
    protected void registerMetaExpertForParameter() {
        // Standard.Parameter
        // -----------

        // no constraint on Parameter.Type : GeneralClass from Standard.Parameter to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(BehaviorParameter.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(Parameter.class, null, "Type");

    }

    @objid ("fbe605c4-4e67-4795-bda4-86dc76ad2fd7")
    protected void registerMetaExpertForValuePin() {
        // Standard.ValuePin
        // -----------

    }

    @objid ("3f5431ea-c666-44ad-a74a-bc0ed4c2bb6a")
    protected void registerMetaExpertForSendSignalAction() {
        // Standard.SendSignalAction
        // -----------

        // no constraint on SendSignalAction.Sent : Signal from Standard.SendSignalAction to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Sent");

    }

    @objid ("78c19ce3-bd5d-4d79-b174-0cc222c9dc07")
    protected void registerMetaExpertForOutputPin() {
        // Standard.OutputPin
        // -----------

    }

    @objid ("0f8ed3a6-6e50-4b5a-a794-e5a7867d9be6")
    protected void registerMetaExpertForOpaqueAction() {
        // Standard.OpaqueAction
        // -----------

    }

    @objid ("9b7e3820-d6b6-4912-9a92-53883121596a")
    protected void registerMetaExpertForObjectFlow() {
        // Standard.ObjectFlow
        // -----------

    }

    @objid ("9213b686-063d-4f61-ba2d-addc85e8f3ec")
    protected void registerMetaExpertForMessageFlow() {
        // Standard.MessageFlow
        // -----------

        // no constraint on MessageFlow.TargetPartition : ActivityPartition from Standard.MessageFlow to Standard.ActivityPartition
        this.ruleMetaExpert.addDependencyRule(MessageFlow.class, null, "TargetPartition");

    }

    @objid ("4e1749ad-bb93-4edb-8868-a888b80e8bcd")
    protected void registerMetaExpertForLoopNode() {
        // Standard.LoopNode
        // -----------

    }

    @objid ("8de94783-beb6-418b-b069-ff3419fd8b7c")
    protected void registerMetaExpertForInterruptibleActivityRegion() {
        // Standard.InterruptibleActivityRegion
        // -----------

        // no constraint on InterruptibleActivityRegion.InterruptingEdge : ActivityEdge from Standard.InterruptibleActivityRegion to Standard.ActivityEdge
        this.ruleMetaExpert.addDependencyRule(InterruptibleActivityRegion.class, null, "InterruptingEdge");

    }

    @objid ("90f098f7-cc1d-42a0-8dae-118d6bd9e351")
    protected void registerMetaExpertForInstanceNode() {
        // Standard.InstanceNode
        // -----------

    }

    @objid ("79897a43-2223-4528-a175-3b62ba66aad6")
    protected void registerMetaExpertForInputPin() {
        // Standard.InputPin
        // -----------

    }

    @objid ("f114483b-dfd5-4446-bbea-349c58e30122")
    protected void registerMetaExpertForPin() {
        // Standard.Pin is abstract

        // -----------

        // no constraint on Pin.Matched : Parameter from Standard.Pin to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "Matched");

    }

    @objid ("5367e340-2cbb-4cc9-8a31-bfdaf5ff6482")
    protected void registerMetaExpertForInitialNode() {
        // Standard.InitialNode
        // -----------

    }

    @objid ("6e754afa-0f33-465d-a94f-4f4d81ad0cc0")
    protected void registerMetaExpertForForkJoinNode() {
        // Standard.ForkJoinNode
        // -----------

    }

    @objid ("fe461cc8-344a-45e0-a9e1-b34c00e5e099")
    protected void registerMetaExpertForFlowFinalNode() {
        // Standard.FlowFinalNode
        // -----------

    }

    @objid ("2ff976b4-7db7-4f93-8abf-ccfe70c33746")
    protected void registerMetaExpertForExpansionRegion() {
        // Standard.ExpansionRegion
        // -----------

        // no constraint on ExpansionRegion.OutputElement : ExpansionNode from Standard.ExpansionRegion to Standard.ExpansionNode
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "OutputElement");

        // no constraint on ExpansionRegion.InputElement : ExpansionNode from Standard.ExpansionRegion to Standard.ExpansionNode
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "InputElement");

    }

    @objid ("2f81e781-1b51-4b23-8d83-f8c62d924be4")
    protected void registerMetaExpertForExpansionNode() {
        // Standard.ExpansionNode
        // -----------

    }

    @objid ("63e4db41-134e-4dff-8be4-7b65035a2992")
    protected void registerMetaExpertForExceptionHandler() {
        // Standard.ExceptionHandler
        // -----------

        // no constraint on ExceptionHandler.ExceptionInput : InputPin from Standard.ExceptionHandler to Standard.InputPin
        this.ruleMetaExpert.addDependencyRule(ExceptionHandler.class, null, "ExceptionInput");

        // no constraint on ExceptionHandler.ExceptionType : GeneralClass from Standard.ExceptionHandler to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(ExceptionHandler.class, null, "ExceptionType");

    }

    @objid ("8fbcd2f5-2030-40d0-978f-a4e1a6df0cd9")
    protected void registerMetaExpertForDecisionMergeNode() {
        // Standard.DecisionMergeNode
        // -----------

    }

    @objid ("d489ec51-7d64-4857-970f-323ffc52a500")
    protected void registerMetaExpertForDataStoreNode() {
        // Standard.DataStoreNode
        // -----------

    }

    @objid ("13758e25-a934-4ad9-8efd-d0a4211ed5e9")
    protected void registerMetaExpertForControlFlow() {
        // Standard.ControlFlow
        // -----------

    }

    @objid ("5a3d6e6d-7c7f-4b0d-b80c-b34317f3021c")
    protected void registerMetaExpertForConditionalNode() {
        // Standard.ConditionalNode
        // -----------

        // no constraint on ConditionalNode.OwnedClause : Clause from Standard.ConditionalNode to Standard.Clause
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "OwnedClause");

    }

    @objid ("799651d8-b66e-4c69-873c-e79e9122bb1e")
    protected void registerMetaExpertForStructuredActivityNode() {
        // Standard.StructuredActivityNode
        // -----------

        // no constraint on StructuredActivityNode.Body : ActivityNode from Standard.StructuredActivityNode to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Body");

    }

    @objid ("45eadf09-2439-48f7-871b-426cfab64cb2")
    protected void registerMetaExpertForClause() {
        // Standard.Clause
        // -----------

        // no constraint on Clause.Body : ActivityNode from Standard.Clause to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(Clause.class, null, "Body");

    }

    @objid ("1e396aa8-c2f6-4d25-8257-7964e209a30f")
    protected void registerMetaExpertForCentralBufferNode() {
        // Standard.CentralBufferNode
        // -----------

    }

    @objid ("b80c878b-678e-470c-bef3-731103bd3d10")
    protected void registerMetaExpertForCallOperationAction() {
        // Standard.CallOperationAction
        // -----------

        // no constraint on CallOperationAction.Called : Operation from Standard.CallOperationAction to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Called");

    }

    @objid ("fe6a8654-8ee3-4a5f-babc-6b3b5fead3a8")
    protected void registerMetaExpertForCallBehaviorAction() {
        // Standard.CallBehaviorAction
        // -----------

        // no constraint on CallBehaviorAction.Called : Behavior from Standard.CallBehaviorAction to Standard.Behavior
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Called");

    }

    @objid ("81c9ab6b-f29a-429f-866d-6f2c06ccd4b0")
    protected void registerMetaExpertForCallAction() {
        // Standard.CallAction is abstract

        // -----------

    }

    @objid ("328cc7d8-5101-42de-bb2b-fc4996187ddd")
    protected void registerMetaExpertForActivityPartition() {
        // Standard.ActivityPartition
        // -----------

        // no constraint on ActivityPartition.Represented : UmlModelElement from Standard.ActivityPartition to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(ActivityPartition.class, null, "Represented");

        // no constraint on ActivityPartition.ContainedNode : ActivityNode from Standard.ActivityPartition to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(ActivityPartition.class, null, "ContainedNode");

        // no constraint on ActivityPartition.Outgoing : MessageFlow from Standard.ActivityPartition to Standard.MessageFlow
        this.ruleMetaExpert.addDependencyRule(ActivityPartition.class, null, "Outgoing");

        // no constraint on ActivityPartition.SubPartition : ActivityPartition from Standard.ActivityPartition to Standard.ActivityPartition
        this.ruleMetaExpert.addDependencyRule(ActivityPartition.class, null, "SubPartition");

    }

    @objid ("38d49928-890c-4980-b952-7f7fb2785d6c")
    protected void registerMetaExpertForActivityParameterNode() {
        // Standard.ActivityParameterNode
        // -----------

    }

    @objid ("0ebe68aa-6d33-4f6d-86b7-b6f3fa21b8d1")
    protected void registerMetaExpertForObjectNode() {
        // Standard.ObjectNode is abstract

        // -----------

        // no constraint on ObjectNode.Represented : Instance from Standard.ObjectNode to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "Represented");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "Represented");

        // no constraint on ObjectNode.RepresentedRealParameter : BehaviorParameter from Standard.ObjectNode to Standard.BehaviorParameter
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "RepresentedRealParameter");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "RepresentedRealParameter");

        // no constraint on ObjectNode.Type : GeneralClass from Standard.ObjectNode to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "Type");

        // no constraint on ObjectNode.RepresentedRole : AssociationEnd from Standard.ObjectNode to Standard.AssociationEnd
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "RepresentedRole");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "RepresentedRole");

        // no constraint on ObjectNode.RepresentedAttribute : Attribute from Standard.ObjectNode to Standard.Attribute
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "RepresentedAttribute");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "RepresentedAttribute");

        // no constraint on ObjectNode.InState : State from Standard.ObjectNode to Standard.State
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "InState");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "InState");

    }

    @objid ("9a69b3fb-330a-4147-92c5-9001f0d62766")
    protected void registerMetaExpertForActivityGroup() {
        // Standard.ActivityGroup is abstract

        // -----------

    }

    @objid ("de3498ea-891a-49ee-9552-0bdb2280ad42")
    protected void registerMetaExpertForActivityFinalNode() {
        // Standard.ActivityFinalNode
        // -----------

    }

    @objid ("616f924f-2f05-42d0-a958-196b6deae8c9")
    protected void registerMetaExpertForFinalNode() {
        // Standard.FinalNode is abstract

        // -----------

    }

    @objid ("27376070-2abf-4029-8598-d1e2c76877bd")
    protected void registerMetaExpertForControlNode() {
        // Standard.ControlNode is abstract

        // -----------

    }

    @objid ("449df7de-5fda-4431-92e1-449b073cf3ac")
    protected void registerMetaExpertForActivityEdge() {
        // Standard.ActivityEdge is abstract

        // -----------

        // no constraint on ActivityEdge.Target : ActivityNode from Standard.ActivityEdge to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(ActivityEdge.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(ControlFlow.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(MessageFlow.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(ObjectFlow.class, null, "Target");

    }

    @objid ("5eb3dcba-664c-4cb6-a655-16b8cda7fd81")
    protected void registerMetaExpertForActivity() {
        // Standard.Activity
        // -----------

        // no constraint on Activity.OwnedGroup : ActivityGroup from Standard.Activity to Standard.ActivityGroup
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "OwnedGroup");

        // no constraint on Activity.OwnedNode : ActivityNode from Standard.Activity to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "OwnedNode");

    }

    @objid ("68d8b094-c578-4498-99c2-34940977fe43")
    protected void registerMetaExpertForAcceptTimeEventAction() {
        // Standard.AcceptTimeEventAction
        // -----------

    }

    @objid ("109c86c8-1069-4d68-940a-9c48640eda7d")
    protected void registerMetaExpertForAcceptSignalAction() {
        // Standard.AcceptSignalAction
        // -----------

        // no constraint on AcceptSignalAction.Accepted : Signal from Standard.AcceptSignalAction to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Accepted");

    }

    @objid ("bbf60241-3b91-4581-af34-3f80c62e4373")
    protected void registerMetaExpertForAcceptChangeEventAction() {
        // Standard.AcceptChangeEventAction
        // -----------

    }

    @objid ("b7109bdb-e2f5-4e2a-94b5-2bf257d1f36a")
    protected void registerMetaExpertForAcceptCallEventAction() {
        // Standard.AcceptCallEventAction
        // -----------

        // no constraint on AcceptCallEventAction.Called : Operation from Standard.AcceptCallEventAction to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Called");

    }

    @objid ("184d5e1a-c39f-4e5e-ac02-4b0cc092ad96")
    protected void registerMetaExpertForActivityAction() {
        // Standard.ActivityAction is abstract

        // -----------

        // no constraint on ActivityAction.Output : OutputPin from Standard.ActivityAction to Standard.OutputPin
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(AcceptChangeEventAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(AcceptTimeEventAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(ActivityAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(CallAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(OpaqueAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Output");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Output");

        // no constraint on ActivityAction.Input : InputPin from Standard.ActivityAction to Standard.InputPin
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(AcceptChangeEventAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(AcceptTimeEventAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(ActivityAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(CallAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(OpaqueAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Input");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Input");

        // no constraint on ActivityAction.Handler : ExceptionHandler from Standard.ActivityAction to Standard.ExceptionHandler
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(AcceptChangeEventAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(AcceptTimeEventAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(ActivityAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(CallAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(OpaqueAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Handler");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Handler");

    }

    @objid ("6a79d67f-a6b6-42e2-8a76-1a68d1e1121c")
    protected void registerMetaExpertForActivityNode() {
        // Standard.ActivityNode is abstract

        // -----------

        // no constraint on ActivityNode.Outgoing : ActivityEdge from Standard.ActivityNode to Standard.ActivityEdge
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(AcceptChangeEventAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(AcceptTimeEventAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ActivityAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ActivityFinalNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ActivityNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(CallAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ControlNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(DecisionMergeNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(FinalNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(FlowFinalNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ForkJoinNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(InitialNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(OpaqueAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Outgoing");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "Outgoing");

    }

    @objid ("10401c41-1ff3-4a84-8f07-006e7852c856")
    protected void registerMetaExpertForUseCaseDiagram() {
        // Standard.UseCaseDiagram
        // -----------

    }

    @objid ("18c01bea-664a-4fcf-aa1a-48fd3dd00b3f")
    protected void registerMetaExpertForStateMachineDiagram() {
        // Standard.StateMachineDiagram
        // -----------

    }

    @objid ("0c51aa97-7978-4230-a815-05f46871bc46")
    protected void registerMetaExpertForSequenceDiagram() {
        // Standard.SequenceDiagram
        // -----------

    }

    @objid ("e58d4b68-44cb-4048-8be8-6a8700db021d")
    protected void registerMetaExpertForObjectDiagram() {
        // Standard.ObjectDiagram
        // -----------

    }

    @objid ("805b0db8-6115-49df-9732-ff26dd92f55a")
    protected void registerMetaExpertForDeploymentDiagram() {
        // Standard.DeploymentDiagram
        // -----------

    }

    @objid ("54019fee-cdae-4a38-aa83-ad1263e43b6d")
    protected void registerMetaExpertForCompositeStructureDiagram() {
        // Standard.CompositeStructureDiagram
        // -----------

    }

    @objid ("0233b749-6238-489b-a5d8-49a8d7805a87")
    protected void registerMetaExpertForCommunicationDiagram() {
        // Standard.CommunicationDiagram
        // -----------

    }

    @objid ("22d7a87d-ef94-4ae6-9fe4-ba6dfcd1dbf4")
    protected void registerMetaExpertForClassDiagram() {
        // Standard.ClassDiagram
        // -----------

    }

    @objid ("a3b58ead-08b4-47e4-bf1c-15c25c25a7b7")
    protected void registerMetaExpertForStaticDiagram() {
        // Standard.StaticDiagram
        // -----------

    }

    @objid ("a20cc9c4-512f-4107-b584-df60ffb00091")
    protected void registerMetaExpertForActivityDiagram() {
        // Standard.ActivityDiagram
        // -----------

    }

    @objid ("d1333e7d-1187-41c2-84cb-0aaa120d6d73")
    protected void registerMetaExpertForBpmnSharedDefinitions() {
        // Standard.BpmnSharedDefinitions
        // -----------

        // no constraint on BpmnSharedDefinitions.RootElement : BpmnSharedElement from Standard.BpmnSharedDefinitions to Standard.BpmnSharedElement
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "RootElement");

    }

    @objid ("6496674d-8fc0-4dc6-ac61-e4e069e83f7f")
    protected void registerMetaExpertForBpmnGroup() {
        // Standard.BpmnGroup
        // -----------

        // no constraint on BpmnGroup.Categorized : BpmnFlowElement from Standard.BpmnGroup to Standard.BpmnFlowElement
        this.ruleMetaExpert.addDependencyRule(BpmnGroup.class, null, "Categorized");

    }

    @objid ("ea189f12-5af5-47d5-85fc-867ed2b662bb")
    protected void registerMetaExpertForBpmnAssociation() {
        // Standard.BpmnAssociation
        // -----------

        // no constraint on BpmnAssociation.TargetRef : BpmnBaseElement from Standard.BpmnAssociation to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnAssociation.class, null, "TargetRef");

        // no constraint on BpmnAssociation.SourceRef : BpmnBaseElement from Standard.BpmnAssociation to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnAssociation.class, null, "SourceRef");

    }

    @objid ("39bc997d-338b-4eee-96dc-f58816059a2f")
    protected void registerMetaExpertForBpmnArtifact() {
        // Standard.BpmnArtifact is abstract

        // -----------

    }

    @objid ("4360d4dd-5d94-4923-b7b2-f47e560a783b")
    protected void registerMetaExpertForBpmnResourceRole() {
        // Standard.BpmnResourceRole
        // -----------

        // no constraint on BpmnResourceRole.ResourceRef : BpmnResource from Standard.BpmnResourceRole to Standard.BpmnResource
        this.ruleMetaExpert.addDependencyRule(BpmnResourceRole.class, null, "ResourceRef");

        // no constraint on BpmnResourceRole.ResourceParameterBinding : BpmnResourceParameterBinding from Standard.BpmnResourceRole to Standard.BpmnResourceParameterBinding
        this.ruleMetaExpert.addDependencyRule(BpmnResourceRole.class, null, "ResourceParameterBinding");

    }

    @objid ("28cb441a-bac2-471f-80f0-eee8bf057a97")
    protected void registerMetaExpertForBpmnResourceParameterBinding() {
        // Standard.BpmnResourceParameterBinding
        // -----------

        // no constraint on BpmnResourceParameterBinding.ParameterRef : BpmnResourceParameter from Standard.BpmnResourceParameterBinding to Standard.BpmnResourceParameter
        this.ruleMetaExpert.addDependencyRule(BpmnResourceParameterBinding.class, null, "ParameterRef");

    }

    @objid ("4e5513e5-d53a-4447-85ca-f67d8f7268ba")
    protected void registerMetaExpertForBpmnResourceParameter() {
        // Standard.BpmnResourceParameter
        // -----------

        // no constraint on BpmnResourceParameter.Type : BpmnItemDefinition from Standard.BpmnResourceParameter to Standard.BpmnItemDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnResourceParameter.class, null, "Type");

    }

    @objid ("6d082b2b-6117-4a04-96d6-ceb91628aba9")
    protected void registerMetaExpertForBpmnResource() {
        // Standard.BpmnResource
        // -----------

        // no constraint on BpmnResource.Parameter : BpmnResourceParameter from Standard.BpmnResource to Standard.BpmnResourceParameter
        this.ruleMetaExpert.addDependencyRule(BpmnResource.class, null, "Parameter");

    }

    @objid ("04d62490-64d6-40ea-ad84-12566e7f0c98")
    protected void registerMetaExpertForBpmnProcess() {
        // Standard.BpmnProcess
        // -----------

        // no constraint on BpmnProcess.Supports : BpmnProcess from Standard.BpmnProcess to Standard.BpmnProcess
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "Supports");

        // no constraint on BpmnProcess.Artifact : BpmnArtifact from Standard.BpmnProcess to Standard.BpmnArtifact
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "Artifact");

        // no constraint on BpmnProcess.LaneSet : BpmnLaneSet from Standard.BpmnProcess to Standard.BpmnLaneSet
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "LaneSet");

        // no constraint on BpmnProcess.FlowElement : BpmnFlowElement from Standard.BpmnProcess to Standard.BpmnFlowElement
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "FlowElement");

        // no constraint on BpmnProcess.Resource : BpmnResourceRole from Standard.BpmnProcess to Standard.BpmnResourceRole
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "Resource");

        // no constraint on BpmnProcess.DefinitionalCollaboration : BpmnCollaboration from Standard.BpmnProcess to Standard.BpmnCollaboration
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "DefinitionalCollaboration");

    }

    @objid ("867a65c4-f08c-4e31-ab8c-a7981b36245b")
    protected void registerMetaExpertForBpmnParticipant() {
        // Standard.BpmnParticipant
        // -----------

        // no constraint on BpmnParticipant.Process : BpmnProcess from Standard.BpmnParticipant to Standard.BpmnProcess
        this.ruleMetaExpert.addDependencyRule(BpmnParticipant.class, null, "Process");

        // no constraint on BpmnParticipant.EndPointRefs : BpmnEndPoint from Standard.BpmnParticipant to Standard.BpmnEndPoint
        this.ruleMetaExpert.addDependencyRule(BpmnParticipant.class, null, "EndPointRefs");

        // no constraint on BpmnParticipant.InterfaceRefs : BpmnInterface from Standard.BpmnParticipant to Standard.BpmnInterface
        this.ruleMetaExpert.addDependencyRule(BpmnParticipant.class, null, "InterfaceRefs");

    }

    @objid ("5acf9434-d835-4ba5-a4cb-0cc624435428")
    protected void registerMetaExpertForBpmnLaneSet() {
        // Standard.BpmnLaneSet
        // -----------

        // no constraint on BpmnLaneSet.Lane : BpmnLane from Standard.BpmnLaneSet to Standard.BpmnLane
        this.ruleMetaExpert.addDependencyRule(BpmnLaneSet.class, null, "Lane");

    }

    @objid ("447c2d85-6741-41aa-be9f-df7a85039333")
    protected void registerMetaExpertForBpmnLane() {
        // Standard.BpmnLane
        // -----------

        // no constraint on BpmnLane.ChildLaneSet : BpmnLaneSet from Standard.BpmnLane to Standard.BpmnLaneSet
        this.ruleMetaExpert.addDependencyRule(BpmnLane.class, null, "ChildLaneSet");

        // no constraint on BpmnLane.FlowElementRef : BpmnFlowElement from Standard.BpmnLane to Standard.BpmnFlowElement
        this.ruleMetaExpert.addDependencyRule(BpmnLane.class, null, "FlowElementRef");

        // no constraint on BpmnLane.BpmnPartitionElementRef : BpmnBaseElement from Standard.BpmnLane to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnLane.class, null, "BpmnPartitionElementRef");

    }

    @objid ("e1f4961b-f975-43f8-b2f8-2bf87754fb74")
    protected void registerMetaExpertForBpmnCollaboration() {
        // Standard.BpmnCollaboration
        // -----------

        // no constraint on BpmnCollaboration.Artifact : BpmnArtifact from Standard.BpmnCollaboration to Standard.BpmnArtifact
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "Artifact");

        // no constraint on BpmnCollaboration.MessageFlow : BpmnMessageFlow from Standard.BpmnCollaboration to Standard.BpmnMessageFlow
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "MessageFlow");

        // no constraint on BpmnCollaboration.Participants : BpmnParticipant from Standard.BpmnCollaboration to Standard.BpmnParticipant
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "Participants");

        // no constraint on BpmnCollaboration.Messages : BpmnMessage from Standard.BpmnCollaboration to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "Messages");

    }

    @objid ("beb7ae07-8817-48e3-bff9-d15e2156b8c2")
    protected void registerMetaExpertForBehavior() {
        // Standard.Behavior is abstract

        // -----------

        // no constraint on Behavior.Parameter : BehaviorParameter from Standard.Behavior to Standard.BehaviorParameter
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(Behavior.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(OpaqueBehavior.class, null, "Parameter");
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "Parameter");

        // no constraint on Behavior.OwnedCollaboration : Collaboration from Standard.Behavior to Standard.Collaboration
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(Behavior.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(OpaqueBehavior.class, null, "OwnedCollaboration");
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "OwnedCollaboration");

        // no constraint on Behavior.EComponent : Event from Standard.Behavior to Standard.Event
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(Behavior.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(OpaqueBehavior.class, null, "EComponent");
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "EComponent");

    }

    @objid ("0f580591-56af-46c5-a4b8-0b385343f342")
    protected void registerMetaExpertForUmlModelElement() {
        // Standard.UmlModelElement is abstract

        // -----------

        // no constraint on UmlModelElement.ConstraintDefinition : Constraint from Standard.UmlModelElement to Standard.Constraint
        this.ruleMetaExpert.addDependencyRule(AbstractPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AcceptChangeEventAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AcceptTimeEventAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityEdge.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityFinalNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityGroup.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityParameterNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ActivityPartition.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Actor.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Association.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AssociationEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Attribute.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(AttributeLink.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Behavior.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BehaviorParameter.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BehavioralFeature.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Binding.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BpmnCollaboration.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BpmnProcess.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CallAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CentralBufferNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ChoicePseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Class.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ClassAssociation.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Classifier.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Clause.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Collaboration.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CollaborationUse.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CommunicationChannel.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CommunicationMessage.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(CommunicationNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ComponentRealization.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Connector.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Constraint.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ControlFlow.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ControlNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DataFlow.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DataStoreNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DataType.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DecisionMergeNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DeepHistoryPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(DurationConstraint.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ElementImport.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(EntryPointPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(EnumerationLiteral.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExceptionHandler.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExecutionSpecification.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExitPointPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExpansionNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ExtensionPoint.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Feature.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(FinalNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(FinalState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(FlowFinalNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ForkJoinNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ForkPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(GeneralClass.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Generalization.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InformationFlow.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InitialNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InitialPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Instance.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InstanceNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Interaction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InteractionFragment.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InteractionOperand.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InteractionUse.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Interface.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InterfaceRealization.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InternalTransition.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(InterruptibleActivityRegion.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(JoinPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(JunctionPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Lifeline.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Link.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(LinkEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Manifestation.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Message.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(MessageEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(MessageFlow.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ModelTree.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NameSpace.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryAssociation.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryAssociationEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryConnector.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryConnectorEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryLink.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(NaryLinkEnd.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ObjectFlow.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ObjectNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(OccurrenceSpecification.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(OpaqueAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(OpaqueBehavior.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Operation.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(PackageImport.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(PackageMerge.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Parameter.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(PartDecomposition.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ProvidedInterface.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(RaisedException.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Region.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(RequiredInterface.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ShallowHistoryPseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Signal.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(State.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(StateInvariant.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(StateMachine.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(StateVertex.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(StructuralFeature.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Substitution.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(TemplateBinding.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(TemplateParameter.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(TemplateParameterSubstitution.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(TerminatePseudoState.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(Transition.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(UmlModelElement.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(UseCaseDependency.class, null, "ConstraintDefinition");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "ConstraintDefinition");

    }

    @objid ("15494f82-3604-45b9-9d0d-c3342bf24692")
    protected void registerMetaExpertForBpmnSequenceFlowDataAssociation() {
        // Standard.BpmnSequenceFlowDataAssociation
        // -----------

        // no constraint on BpmnSequenceFlowDataAssociation.Connected : BpmnSequenceFlow from Standard.BpmnSequenceFlowDataAssociation to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlowDataAssociation.class, null, "Connected");

        // no constraint on BpmnSequenceFlowDataAssociation.DataAssociation : BpmnDataAssociation from Standard.BpmnSequenceFlowDataAssociation to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlowDataAssociation.class, null, "DataAssociation");

    }

    @objid ("8d4fce0d-7795-4f46-8dc7-b3386654f208")
    protected void registerMetaExpertForBpmnItemDefinition() {
        // Standard.BpmnItemDefinition
        // -----------

    }

    @objid ("ca8cea9b-7136-48fa-b94c-80d8a9e55e6b")
    protected void registerMetaExpertForBpmnDataStore() {
        // Standard.BpmnDataStore
        // -----------

    }

    @objid ("c33322ac-fe78-41b3-a5f0-740b840d6a88")
    protected void registerMetaExpertForBpmnDataState() {
        // Standard.BpmnDataState
        // -----------

    }

    @objid ("bd701244-1523-4c7c-a221-74fb949d50f4")
    protected void registerMetaExpertForBpmnDataOutput() {
        // Standard.BpmnDataOutput
        // -----------

    }

    @objid ("22870d85-9cf5-4f40-8a5f-f248e4ed93ad")
    protected void registerMetaExpertForBpmnDataObject() {
        // Standard.BpmnDataObject
        // -----------

    }

    @objid ("c2ed93d8-027d-4713-920e-77d9a48fe11e")
    protected void registerMetaExpertForBpmnDataInput() {
        // Standard.BpmnDataInput
        // -----------

    }

    @objid ("2871bccf-0bcc-429c-8b8c-a09dd00d9dca")
    protected void registerMetaExpertForBpmnItemAwareElement() {
        // Standard.BpmnItemAwareElement is abstract

        // -----------

        // no constraint on BpmnItemAwareElement.ItemSubjectRef : BpmnItemDefinition from Standard.BpmnItemAwareElement to Standard.BpmnItemDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnDataInput.class, null, "ItemSubjectRef");
        this.ruleMetaExpert.addDependencyRule(BpmnDataObject.class, null, "ItemSubjectRef");
        this.ruleMetaExpert.addDependencyRule(BpmnDataOutput.class, null, "ItemSubjectRef");
        this.ruleMetaExpert.addDependencyRule(BpmnDataStore.class, null, "ItemSubjectRef");
        this.ruleMetaExpert.addDependencyRule(BpmnItemAwareElement.class, null, "ItemSubjectRef");

        // no constraint on BpmnItemAwareElement.DataState : BpmnDataState from Standard.BpmnItemAwareElement to Standard.BpmnDataState
        this.ruleMetaExpert.addDependencyRule(BpmnDataInput.class, null, "DataState");
        this.ruleMetaExpert.addDependencyRule(BpmnDataObject.class, null, "DataState");
        this.ruleMetaExpert.addDependencyRule(BpmnDataOutput.class, null, "DataState");
        this.ruleMetaExpert.addDependencyRule(BpmnDataStore.class, null, "DataState");
        this.ruleMetaExpert.addDependencyRule(BpmnItemAwareElement.class, null, "DataState");

    }

    @objid ("f3624f2a-87ba-4de7-a1f0-4c4c3c43ef08")
    protected void registerMetaExpertForBpmnDataAssociation() {
        // Standard.BpmnDataAssociation
        // -----------

        // no constraint on BpmnDataAssociation.SourceRef : BpmnItemAwareElement from Standard.BpmnDataAssociation to Standard.BpmnItemAwareElement
        this.ruleMetaExpert.addDependencyRule(BpmnDataAssociation.class, null, "SourceRef");

        // no constraint on BpmnDataAssociation.TargetRef : BpmnItemAwareElement from Standard.BpmnDataAssociation to Standard.BpmnItemAwareElement
        this.ruleMetaExpert.addDependencyRule(BpmnDataAssociation.class, null, "TargetRef");

    }

    @objid ("b9c18d66-41b3-4a10-941c-06454bf99f49")
    protected void registerMetaExpertForBpmnParallelGateway() {
        // Standard.BpmnParallelGateway
        // -----------

    }

    @objid ("15caf705-d68b-4480-a4d2-64773b640855")
    protected void registerMetaExpertForBpmnInclusiveGateway() {
        // Standard.BpmnInclusiveGateway
        // -----------

        // no constraint on BpmnInclusiveGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnInclusiveGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnInclusiveGateway.class, null, "DefaultFlow");

    }

    @objid ("ee00eb88-0b5f-4d29-989f-3683003329c4")
    protected void registerMetaExpertForBpmnExclusiveGateway() {
        // Standard.BpmnExclusiveGateway
        // -----------

        // no constraint on BpmnExclusiveGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnExclusiveGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnExclusiveGateway.class, null, "DefaultFlow");

    }

    @objid ("ebc52ff0-5124-44f2-99a1-e0254323f77c")
    protected void registerMetaExpertForBpmnEventBasedGateway() {
        // Standard.BpmnEventBasedGateway
        // -----------

    }

    @objid ("e4ecb9ec-cacd-40a2-9588-914b9301b86b")
    protected void registerMetaExpertForBpmnComplexGateway() {
        // Standard.BpmnComplexGateway
        // -----------

        // no constraint on BpmnComplexGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnComplexGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnComplexGateway.class, null, "DefaultFlow");

    }

    @objid ("5296a85d-a593-47f5-9fa4-ed9e968157a8")
    protected void registerMetaExpertForBpmnGateway() {
        // Standard.BpmnGateway is abstract

        // -----------

    }

    @objid ("5a4e6ecf-85b0-459b-ac2d-ab2204db52fa")
    protected void registerMetaExpertForBpmnSequenceFlow() {
        // Standard.BpmnSequenceFlow
        // -----------

        // no constraint on BpmnSequenceFlow.SourceRef : BpmnFlowNode from Standard.BpmnSequenceFlow to Standard.BpmnFlowNode
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlow.class, null, "SourceRef");

        // no constraint on BpmnSequenceFlow.TargetRef : BpmnFlowNode from Standard.BpmnSequenceFlow to Standard.BpmnFlowNode
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlow.class, null, "TargetRef");

        // no constraint on BpmnSequenceFlow.Connector : BpmnSequenceFlowDataAssociation from Standard.BpmnSequenceFlow to Standard.BpmnSequenceFlowDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlow.class, null, "Connector");

    }

    @objid ("40694b3a-01ad-437a-8e12-945e386188e4")
    protected void registerMetaExpertForBpmnMessageFlow() {
        // Standard.BpmnMessageFlow
        // -----------

        // no constraint on BpmnMessageFlow.MessageRef : BpmnMessage from Standard.BpmnMessageFlow to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnMessageFlow.class, null, "MessageRef");

        // no constraint on BpmnMessageFlow.SourceRef : BpmnBaseElement from Standard.BpmnMessageFlow to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnMessageFlow.class, null, "SourceRef");

        // no constraint on BpmnMessageFlow.TargetRef : BpmnBaseElement from Standard.BpmnMessageFlow to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnMessageFlow.class, null, "TargetRef");

    }

    @objid ("292a55f8-ede4-442b-8984-a6c663d56262")
    protected void registerMetaExpertForBpmnMessage() {
        // Standard.BpmnMessage
        // -----------

        // no constraint on BpmnMessage.ItemRef : BpmnItemDefinition from Standard.BpmnMessage to Standard.BpmnItemDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnMessage.class, null, "ItemRef");

    }

    @objid ("72bc5ac4-635e-4021-aaa7-abe9956f5577")
    protected void registerMetaExpertForBpmnTimerEventDefinition() {
        // Standard.BpmnTimerEventDefinition
        // -----------

    }

    @objid ("d3d5fcf4-c169-48c1-93aa-6bf7708bc585")
    protected void registerMetaExpertForBpmnTerminateEventDefinition() {
        // Standard.BpmnTerminateEventDefinition
        // -----------

    }

    @objid ("be6f9855-ebeb-4d02-aa0e-943f03820d4b")
    protected void registerMetaExpertForBpmnStartEvent() {
        // Standard.BpmnStartEvent
        // -----------

    }

    @objid ("cd246861-4508-4f28-ade3-3d56f42f18f5")
    protected void registerMetaExpertForBpmnSignalEventDefinition() {
        // Standard.BpmnSignalEventDefinition
        // -----------

    }

    @objid ("4fe4f275-ef55-4b8b-9c44-d691132a0382")
    protected void registerMetaExpertForBpmnMessageEventDefinition() {
        // Standard.BpmnMessageEventDefinition
        // -----------

        // no constraint on BpmnMessageEventDefinition.MessageRef : BpmnMessage from Standard.BpmnMessageEventDefinition to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnMessageEventDefinition.class, null, "MessageRef");

        // no constraint on BpmnMessageEventDefinition.OperationRef : BpmnOperation from Standard.BpmnMessageEventDefinition to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnMessageEventDefinition.class, null, "OperationRef");

    }

    @objid ("c5bd93dc-da6e-4956-ab00-26f16a5f71a2")
    protected void registerMetaExpertForBpmnLinkEventDefinition() {
        // Standard.BpmnLinkEventDefinition
        // -----------

        // no constraint on BpmnLinkEventDefinition.Target : BpmnLinkEventDefinition from Standard.BpmnLinkEventDefinition to Standard.BpmnLinkEventDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnLinkEventDefinition.class, null, "Target");

    }

    @objid ("0263de41-98d9-4d6e-8a7c-0b7450bd0d66")
    protected void registerMetaExpertForBpmnIntermediateThrowEvent() {
        // Standard.BpmnIntermediateThrowEvent
        // -----------

    }

    @objid ("1d93cb70-92d6-46c1-baad-3e0501e094a0")
    protected void registerMetaExpertForBpmnIntermediateCatchEvent() {
        // Standard.BpmnIntermediateCatchEvent
        // -----------

    }

    @objid ("6e1f8a9a-8265-492f-91f4-73f6d2150771")
    protected void registerMetaExpertForBpmnImplicitThrowEvent() {
        // Standard.BpmnImplicitThrowEvent
        // -----------

    }

    @objid ("86c8e066-c125-4c4e-b90e-d46c57105eb2")
    protected void registerMetaExpertForBpmnEscalationEventDefinition() {
        // Standard.BpmnEscalationEventDefinition
        // -----------

    }

    @objid ("fb979696-ce46-4a5c-9cb2-8557b8a3daf6")
    protected void registerMetaExpertForBpmnErrorEventDefinition() {
        // Standard.BpmnErrorEventDefinition
        // -----------

    }

    @objid ("04c66d7d-3225-4b7a-8d41-26fcb47b5302")
    protected void registerMetaExpertForBpmnEndEvent() {
        // Standard.BpmnEndEvent
        // -----------

    }

    @objid ("62d65ebd-baea-4726-891c-0f3666478034")
    protected void registerMetaExpertForBpmnThrowEvent() {
        // Standard.BpmnThrowEvent is abstract

        // -----------

        // no constraint on BpmnThrowEvent.DataInputAssociation : BpmnDataAssociation from Standard.BpmnThrowEvent to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnEndEvent.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnImplicitThrowEvent.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateThrowEvent.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnThrowEvent.class, null, "DataInputAssociation");

        // no constraint on BpmnThrowEvent.DataInput : BpmnDataInput from Standard.BpmnThrowEvent to Standard.BpmnDataInput
        this.ruleMetaExpert.addDependencyRule(BpmnEndEvent.class, null, "DataInput");
        this.ruleMetaExpert.addDependencyRule(BpmnImplicitThrowEvent.class, null, "DataInput");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateThrowEvent.class, null, "DataInput");
        this.ruleMetaExpert.addDependencyRule(BpmnThrowEvent.class, null, "DataInput");

    }

    @objid ("d4621207-9fda-45ff-92c0-6993231d7ba1")
    protected void registerMetaExpertForBpmnConditionalEventDefinition() {
        // Standard.BpmnConditionalEventDefinition
        // -----------

    }

    @objid ("f1b7958f-7cc7-4970-9e1b-b2635f4368dc")
    protected void registerMetaExpertForBpmnCompensateEventDefinition() {
        // Standard.BpmnCompensateEventDefinition
        // -----------

        // no constraint on BpmnCompensateEventDefinition.ActivityRef : BpmnActivity from Standard.BpmnCompensateEventDefinition to Standard.BpmnActivity
        this.ruleMetaExpert.addDependencyRule(BpmnCompensateEventDefinition.class, null, "ActivityRef");

    }

    @objid ("0e47400f-04cb-4278-96bd-20674000c1e6")
    protected void registerMetaExpertForBpmnCancelEventDefinition() {
        // Standard.BpmnCancelEventDefinition
        // -----------

    }

    @objid ("0f983610-9e66-44cf-b9c3-645ff66e3d02")
    protected void registerMetaExpertForBpmnEventDefinition() {
        // Standard.BpmnEventDefinition is abstract

        // -----------

    }

    @objid ("61208871-8431-4414-ae42-6e87e3c0edb9")
    protected void registerMetaExpertForBpmnBoundaryEvent() {
        // Standard.BpmnBoundaryEvent
        // -----------

    }

    @objid ("5cc910e7-1532-469e-88ab-0e3acda43f32")
    protected void registerMetaExpertForBpmnCatchEvent() {
        // Standard.BpmnCatchEvent is abstract

        // -----------

        // no constraint on BpmnCatchEvent.DataOutputAssociation : BpmnDataAssociation from Standard.BpmnCatchEvent to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnBoundaryEvent.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnCatchEvent.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateCatchEvent.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnStartEvent.class, null, "DataOutputAssociation");

        // no constraint on BpmnCatchEvent.DataOutput : BpmnDataOutput from Standard.BpmnCatchEvent to Standard.BpmnDataOutput
        this.ruleMetaExpert.addDependencyRule(BpmnBoundaryEvent.class, null, "DataOutput");
        this.ruleMetaExpert.addDependencyRule(BpmnCatchEvent.class, null, "DataOutput");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateCatchEvent.class, null, "DataOutput");
        this.ruleMetaExpert.addDependencyRule(BpmnStartEvent.class, null, "DataOutput");

    }

    @objid ("95e1985c-5478-4c2c-8c96-0d4dfe3acf6a")
    protected void registerMetaExpertForBpmnEvent() {
        // Standard.BpmnEvent is abstract

        // -----------

        // no constraint on BpmnEvent.EventDefinitions : BpmnEventDefinition from Standard.BpmnEvent to Standard.BpmnEventDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnBoundaryEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnCatchEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnEndEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnImplicitThrowEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateCatchEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateThrowEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnStartEvent.class, null, "EventDefinitions");
        this.ruleMetaExpert.addDependencyRule(BpmnThrowEvent.class, null, "EventDefinitions");

    }

    @objid ("f363a485-76f9-46ac-8abc-895c49e69350")
    protected void registerMetaExpertForBpmnOperation() {
        // Standard.BpmnOperation
        // -----------

        // no constraint on BpmnOperation.InMessageRef : BpmnMessage from Standard.BpmnOperation to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnOperation.class, null, "InMessageRef");

        // no constraint on BpmnOperation.OutMessageRef : BpmnMessage from Standard.BpmnOperation to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnOperation.class, null, "OutMessageRef");

    }

    @objid ("3f2d7a13-2cbe-49c8-ba02-80be8a08197c")
    protected void registerMetaExpertForBpmnInterface() {
        // Standard.BpmnInterface
        // -----------

        // no constraint on BpmnInterface.Operation : BpmnOperation from Standard.BpmnInterface to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnInterface.class, null, "Operation");

    }

    @objid ("966605bf-46af-4a91-9ae0-df5d3ed82a65")
    protected void registerMetaExpertForBpmnEndPoint() {
        // Standard.BpmnEndPoint
        // -----------

    }

    @objid ("8e443630-3998-4c4c-b66d-db293ee1192c")
    protected void registerMetaExpertForBpmnSharedElement() {
        // Standard.BpmnSharedElement is abstract

        // -----------

    }

    @objid ("ea451a2b-123f-4719-9f76-0e10aa7d22ab")
    protected void registerMetaExpertForBpmnCollaborationDiagram() {
        // Standard.BpmnCollaborationDiagram
        // -----------

    }

    @objid ("94251763-b9d6-402f-9c99-03f038804518")
    protected void registerMetaExpertForBpmnProcessDesignDiagram() {
        // Standard.BpmnProcessDesignDiagram
        // -----------

    }

    @objid ("92b2bbc4-94cd-41fb-bddb-d7516fa3b630")
    protected void registerMetaExpertForBpmnSubProcessDiagram() {
        // Standard.BpmnSubProcessDiagram
        // -----------

    }

    @objid ("192ddf03-893e-446c-9c33-310dfff9ead9")
    protected void registerMetaExpertForBpmnProcessCollaborationDiagram() {
        // Standard.BpmnProcessCollaborationDiagram is abstract

        // -----------

    }

    @objid ("40b7e574-675a-4f43-8242-6b12326fb0ba")
    protected void registerMetaExpertForBehaviorDiagram() {
        // Standard.BehaviorDiagram is abstract

        // -----------

    }

    @objid ("4bfff829-b149-4310-b154-611f49a12805")
    protected void registerMetaExpertForBpmnUserTask() {
        // Standard.BpmnUserTask
        // -----------

    }

    @objid ("8af661a4-045c-4f3b-ad6c-129f37a56efc")
    protected void registerMetaExpertForBpmnTransaction() {
        // Standard.BpmnTransaction
        // -----------

    }

    @objid ("3289efaa-51ec-4c46-8d32-84b3f5b5e4a9")
    protected void registerMetaExpertForBpmnStandardLoopCharacteristics() {
        // Standard.BpmnStandardLoopCharacteristics
        // -----------

    }

    @objid ("0e99190d-f96c-43d5-918c-d9aab3fe581f")
    protected void registerMetaExpertForBpmnServiceTask() {
        // Standard.BpmnServiceTask
        // -----------

        // no constraint on BpmnServiceTask.OperationRef : BpmnOperation from Standard.BpmnServiceTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "OperationRef");

    }

    @objid ("bb07d7e6-d27f-4713-9e17-6712e2cb2cd6")
    protected void registerMetaExpertForBpmnSendTask() {
        // Standard.BpmnSendTask
        // -----------

        // no constraint on BpmnSendTask.MessageRef : BpmnMessage from Standard.BpmnSendTask to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "MessageRef");

        // no constraint on BpmnSendTask.OperationRef : BpmnOperation from Standard.BpmnSendTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "OperationRef");

    }

    @objid ("6a65d9c9-2c98-4d8c-a17d-2a35abb4cd7b")
    protected void registerMetaExpertForBpmnScriptTask() {
        // Standard.BpmnScriptTask
        // -----------

    }

    @objid ("3556d262-dd31-44b2-9017-73ca1a7f985b")
    protected void registerMetaExpertForBpmnReceiveTask() {
        // Standard.BpmnReceiveTask
        // -----------

        // no constraint on BpmnReceiveTask.MessageRef : BpmnMessage from Standard.BpmnReceiveTask to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "MessageRef");

        // no constraint on BpmnReceiveTask.OperationRef : BpmnOperation from Standard.BpmnReceiveTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "OperationRef");

    }

    @objid ("6946543a-0f37-4208-8497-4009db5dfe21")
    protected void registerMetaExpertForBpmnMultiInstanceLoopCharacteristics() {
        // Standard.BpmnMultiInstanceLoopCharacteristics
        // -----------

        // no constraint on BpmnMultiInstanceLoopCharacteristics.LoopDataInput : BpmnDataInput from Standard.BpmnMultiInstanceLoopCharacteristics to Standard.BpmnDataInput
        this.ruleMetaExpert.addDependencyRule(BpmnMultiInstanceLoopCharacteristics.class, null, "LoopDataInput");

        // no constraint on BpmnMultiInstanceLoopCharacteristics.LoopDataOutputRef : BpmnDataOutput from Standard.BpmnMultiInstanceLoopCharacteristics to Standard.BpmnDataOutput
        this.ruleMetaExpert.addDependencyRule(BpmnMultiInstanceLoopCharacteristics.class, null, "LoopDataOutputRef");

        // no constraint on BpmnMultiInstanceLoopCharacteristics.CompletionEventRef : BpmnEventDefinition from Standard.BpmnMultiInstanceLoopCharacteristics to Standard.BpmnEventDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnMultiInstanceLoopCharacteristics.class, null, "CompletionEventRef");

        // no constraint on BpmnMultiInstanceLoopCharacteristics.ComplexBehaviorDefinition : BpmnComplexBehaviorDefinition from Standard.BpmnMultiInstanceLoopCharacteristics to Standard.BpmnComplexBehaviorDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnMultiInstanceLoopCharacteristics.class, null, "ComplexBehaviorDefinition");

    }

    @objid ("cb46441c-1f79-4a4e-a4b0-a6314c07517e")
    protected void registerMetaExpertForBpmnManualTask() {
        // Standard.BpmnManualTask
        // -----------

    }

    @objid ("0b214bf3-e637-45d8-8661-719017551b0e")
    protected void registerMetaExpertForBpmnLoopCharacteristics() {
        // Standard.BpmnLoopCharacteristics is abstract

        // -----------

    }

    @objid ("4049db6f-c949-44fb-9e3f-048d2e25bf32")
    protected void registerMetaExpertForBpmnComplexBehaviorDefinition() {
        // Standard.BpmnComplexBehaviorDefinition
        // -----------

        // no constraint on BpmnComplexBehaviorDefinition.Event : BpmnImplicitThrowEvent from Standard.BpmnComplexBehaviorDefinition to Standard.BpmnImplicitThrowEvent
        this.ruleMetaExpert.addDependencyRule(BpmnComplexBehaviorDefinition.class, null, "Event");

    }

    @objid ("10318ae6-d377-48a4-874d-e68feb2f0e98")
    protected void registerMetaExpertForBpmnCallActivity() {
        // Standard.BpmnCallActivity
        // -----------

        // no constraint on BpmnCallActivity.CalledGlobalTask : BpmnTask from Standard.BpmnCallActivity to Standard.BpmnTask
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "CalledGlobalTask");

    }

    @objid ("ef504bcd-1478-443b-8cf2-92f365125934")
    protected void registerMetaExpertForBpmnBusinessRuleTask() {
        // Standard.BpmnBusinessRuleTask
        // -----------

    }

    @objid ("aeb1f200-6b63-45dd-bb67-ce2526c15b0c")
    protected void registerMetaExpertForBpmnTask() {
        // Standard.BpmnTask
        // -----------

    }

    @objid ("b93bd519-6309-4f25-a1f5-9ec78ec85c75")
    protected void registerMetaExpertForBpmnAdHocSubProcess() {
        // Standard.BpmnAdHocSubProcess
        // -----------

    }

    @objid ("3339fa7f-bfa2-4c71-86b5-10efe2a18af5")
    protected void registerMetaExpertForBpmnSubProcess() {
        // Standard.BpmnSubProcess
        // -----------

        // no constraint on BpmnSubProcess.Artifact : BpmnArtifact from Standard.BpmnSubProcess to Standard.BpmnArtifact
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "Artifact");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "Artifact");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "Artifact");

        // no constraint on BpmnSubProcess.FlowElement : BpmnFlowElement from Standard.BpmnSubProcess to Standard.BpmnFlowElement
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "FlowElement");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "FlowElement");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "FlowElement");

        // no constraint on BpmnSubProcess.LaneSet : BpmnLaneSet from Standard.BpmnSubProcess to Standard.BpmnLaneSet
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "LaneSet");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "LaneSet");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "LaneSet");

    }

    @objid ("35cfd4aa-6234-4c43-8b2e-a30c29dca222")
    protected void registerMetaExpertForBpmnActivity() {
        // Standard.BpmnActivity
        // -----------

        // no constraint on BpmnActivity.InputSpecification : BpmnDataInput from Standard.BpmnActivity to Standard.BpmnDataInput
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "InputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "InputSpecification");

        // no constraint on BpmnActivity.DataInputAssociation : BpmnDataAssociation from Standard.BpmnActivity to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "DataInputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "DataInputAssociation");

        // no constraint on BpmnActivity.OutputSpecification : BpmnDataOutput from Standard.BpmnActivity to Standard.BpmnDataOutput
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "OutputSpecification");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "OutputSpecification");

        // no constraint on BpmnActivity.LoopCharacteristics : BpmnLoopCharacteristics from Standard.BpmnActivity to Standard.BpmnLoopCharacteristics
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "LoopCharacteristics");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "LoopCharacteristics");

        // no constraint on BpmnActivity.BoundaryEventRef : BpmnBoundaryEvent from Standard.BpmnActivity to Standard.BpmnBoundaryEvent
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "BoundaryEventRef");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "BoundaryEventRef");

        // no constraint on BpmnActivity.DataOutputAssociation : BpmnDataAssociation from Standard.BpmnActivity to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "DataOutputAssociation");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "DataOutputAssociation");

        // no constraint on BpmnActivity.DefaultFlow : BpmnSequenceFlow from Standard.BpmnActivity to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "DefaultFlow");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "DefaultFlow");

    }

    @objid ("913ad08f-b525-406d-b14f-ec9da941fe33")
    protected void registerMetaExpertForBpmnFlowNode() {
        // Standard.BpmnFlowNode is abstract

        // -----------

        // no constraint on BpmnFlowNode.Resource : BpmnResourceRole from Standard.BpmnFlowNode to Standard.BpmnResourceRole
        this.ruleMetaExpert.addDependencyRule(BpmnActivity.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnAdHocSubProcess.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnBoundaryEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnBusinessRuleTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnCatchEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnComplexGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnEndEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnEventBasedGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnExclusiveGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnFlowNode.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnImplicitThrowEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnInclusiveGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateCatchEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnIntermediateThrowEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnManualTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnParallelGateway.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnScriptTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnStartEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnSubProcess.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnTask.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnThrowEvent.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnTransaction.class, null, "Resource");
        this.ruleMetaExpert.addDependencyRule(BpmnUserTask.class, null, "Resource");

    }

    @objid ("61b9bbeb-a05d-407f-b9d4-755d8108efe4")
    protected void registerMetaExpertForBpmnFlowElement() {
        // Standard.BpmnFlowElement is abstract

        // -----------

    }

    @objid ("78001ceb-dc68-4037-890a-b102aa9b8e86")
    protected void registerMetaExpertForBpmnBaseElement() {
        // Standard.BpmnBaseElement is abstract

        // -----------

    }

}
