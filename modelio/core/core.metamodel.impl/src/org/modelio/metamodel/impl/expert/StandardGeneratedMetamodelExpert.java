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
@objid ("67382fa1-2a08-4074-9f1b-2e45cdf21f89")
public class StandardGeneratedMetamodelExpert extends CompositeMetamodelExpert {
    /**
     * Constructor.
     * <p>
     * You need to call {@link #register()} next.
     *
     * @param mm The metamodel.
     */
    @objid ("94c07ee2-ac68-4b01-8d21-a7c553c243ee")
    public StandardGeneratedMetamodelExpert(MMetamodel mm) {
        super(mm);

    }

    /**
     * Initializes this expert.
     */
    @objid ("d5e9c486-7bdd-45f1-b0c6-a709f2a7d80c")
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

    @objid ("ec327312-9127-4678-b9d0-01cb1ece044d")
    protected void registerLinkExpertForBpmnMessageFlow() {
        // Standard.BpmnMessageFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(BpmnMessageFlow.class);

        // Standard.BpmnMessageFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(BpmnMessageFlow.class, "SourceRef");
        this.ruleLinkExpert.addTargetDep(BpmnMessageFlow.class, "TargetRef");


        // Standard.BpmnMessageFlow rules: all allowed.

        this.ruleLinkExpert.addRule(BpmnMessageFlow.class, null, null);

    }

    @objid ("c31ada8b-dd69-481c-b4c3-7c5c091a59a5")
    protected void registerLinkExpertForBpmnSequenceFlow() {
        // Standard.BpmnSequenceFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(BpmnSequenceFlow.class);

        // Standard.BpmnSequenceFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(BpmnSequenceFlow.class, "SourceRef");
        this.ruleLinkExpert.addTargetDep(BpmnSequenceFlow.class, "TargetRef");


        // Standard.BpmnSequenceFlow rules: all allowed.

        this.ruleLinkExpert.addRule(BpmnSequenceFlow.class, null, null);

    }

    @objid ("f8fd885d-414b-472a-a112-ad476d2a8590")
    protected void registerLinkExpertForActivityEdge() {
        // Standard.ActivityEdge is abstract

        this.ruleLinkExpert.addLinkMetaclass(ActivityEdge.class);

    }

    @objid ("96e9e0d1-d618-4c67-9ce5-3cd9dbb39611")
    protected void registerLinkExpertForCommunicationChannel() {
        // Standard.CommunicationChannel
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(CommunicationChannel.class);

        // Standard.CommunicationChannel sources and target dependencies
        this.ruleLinkExpert.addTargetDep(CommunicationChannel.class, "End");
        this.ruleLinkExpert.addSourceDep(CommunicationChannel.class, "Start");


        // Standard.CommunicationChannel rules: all allowed.

        this.ruleLinkExpert.addRule(CommunicationChannel.class, null, null);

    }

    @objid ("a73500d9-3fe3-4bff-8b8c-e3a93e727107")
    protected void registerLinkExpertForMessage() {
        // Standard.Message
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Message.class);

        // Standard.Message sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Message.class, "ReceiveEvent");
        this.ruleLinkExpert.addSourceDep(Message.class, "SendEvent");


        // Standard.Message rules: all allowed.

        this.ruleLinkExpert.addRule(Message.class, null, null);

    }

    @objid ("3c18af2d-e4aa-4834-8b40-467e3840e81d")
    protected void registerLinkExpertForTransition() {
        // Standard.Transition
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Transition.class);

        // Standard.Transition sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Transition.class, "Source");
        this.ruleLinkExpert.addTargetDep(Transition.class, "Target");


        // Standard.Transition rules: all allowed.

        this.ruleLinkExpert.addRule(Transition.class, null, null);

    }

    @objid ("4b8d5202-1a88-4907-bee5-9e5e4edf8e8a")
    protected void registerLinkExpertForUseCaseDependency() {
        // Standard.UseCaseDependency
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(UseCaseDependency.class);

        // Standard.UseCaseDependency sources and target dependencies
        this.ruleLinkExpert.addSourceDep(UseCaseDependency.class, "Origin");
        this.ruleLinkExpert.addTargetDep(UseCaseDependency.class, "Target");


        // Standard.UseCaseDependency rules: all allowed.

        this.ruleLinkExpert.addRule(UseCaseDependency.class, null, null);

    }

    @objid ("80e436f5-fcbd-4593-96b5-cf9d64186cae")
    protected void registerLinkExpertForDataFlow() {
        // Standard.DataFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(DataFlow.class);

        // Standard.DataFlow sources and target dependencies
        this.ruleLinkExpert.addTargetDep(DataFlow.class, "Destination");
        this.ruleLinkExpert.addSourceDep(DataFlow.class, "Origin");


        // Standard.DataFlow rules: all allowed.

        this.ruleLinkExpert.addRule(DataFlow.class, null, null);

    }

    @objid ("7b1c0ec9-2b1d-4ea5-b187-d296f608b311")
    protected void registerLinkExpertForInformationFlow() {
        // Standard.InformationFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(InformationFlow.class);

        // Standard.InformationFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(InformationFlow.class, "InformationSource");
        this.ruleLinkExpert.addTargetDep(InformationFlow.class, "InformationTarget");


        // Standard.InformationFlow rules: all allowed.

        this.ruleLinkExpert.addRule(InformationFlow.class, null, null);

    }

    @objid ("69eb5efc-d7e1-41f9-b124-d1b06ef47e4c")
    protected void registerLinkExpertForAbstraction() {
        // Standard.Abstraction
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Abstraction.class);

        // Standard.Abstraction sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Abstraction.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(Abstraction.class, "Impacted");


        // Standard.Abstraction rules: all allowed.

        this.ruleLinkExpert.addRule(Abstraction.class, null, null);

    }

    @objid ("ccedc4b3-3c7f-4941-a269-7a60a8083b93")
    protected void registerLinkExpertForSubstitution() {
        // Standard.Substitution
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Substitution.class);

        // Standard.Substitution sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Substitution.class, "Contract");
        this.ruleLinkExpert.addSourceDep(Substitution.class, "SubstitutingClassifier");


        // Standard.Substitution rules: all allowed.

        this.ruleLinkExpert.addRule(Substitution.class, null, null);

    }

    @objid ("80dea8dc-133d-4184-9753-9b38032866e2")
    protected void registerLinkExpertForUsage() {
        // Standard.Usage
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Usage.class);

        // Standard.Usage sources and target dependencies
        this.ruleLinkExpert.addTargetDep(Usage.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(Usage.class, "Impacted");


        // Standard.Usage rules: all allowed.

        this.ruleLinkExpert.addRule(Usage.class, null, null);

    }

    @objid ("5c07b395-3dbc-4dd8-8904-62a8ad543a37")
    protected void registerLinkExpertForAssociation() {
        // Standard.Association
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Association.class);

        // Standard.Association sources and target dependencies


        // Standard.Association rules: all allowed.

        this.ruleLinkExpert.addRule(Association.class, null, null);

    }

    @objid ("007f6462-d6e0-436d-9483-285c5a9862cb")
    protected void registerLinkExpertForAssociationEnd() {
        // Standard.AssociationEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(AssociationEnd.class);

        // Standard.AssociationEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(AssociationEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(AssociationEnd.class, "Target");


        // Standard.AssociationEnd rules: all allowed.

        this.ruleLinkExpert.addRule(AssociationEnd.class, null, null);

    }

    @objid ("1d684d3d-9f8c-4ff4-82e3-c45be7369336")
    protected void registerLinkExpertForElementImport() {
        // Standard.ElementImport
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ElementImport.class);

        // Standard.ElementImport sources and target dependencies
        this.ruleLinkExpert.addTargetDep(ElementImport.class, "ImportedElement");
        this.ruleLinkExpert.addSourceDep(ElementImport.class, "ImportingNameSpace");
        this.ruleLinkExpert.addSourceDep(ElementImport.class, "ImportingOperation");


        // Standard.ElementImport rules: all allowed.

        this.ruleLinkExpert.addRule(ElementImport.class, null, null);

    }

    @objid ("23a955eb-0e1e-41bb-870d-9c45c2e01a37")
    protected void registerLinkExpertForGeneralization() {
        // Standard.Generalization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Generalization.class);

        // Standard.Generalization sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Generalization.class, "SubType");
        this.ruleLinkExpert.addTargetDep(Generalization.class, "SuperType");


        // Standard.Generalization rules: all allowed.

        this.ruleLinkExpert.addRule(Generalization.class, null, null);

    }

    @objid ("7ef4bf07-79a5-454c-8666-41e38bd50173")
    protected void registerLinkExpertForInterfaceRealization() {
        // Standard.InterfaceRealization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(InterfaceRealization.class);

        // Standard.InterfaceRealization sources and target dependencies
        this.ruleLinkExpert.addTargetDep(InterfaceRealization.class, "Implemented");
        this.ruleLinkExpert.addSourceDep(InterfaceRealization.class, "Implementer");


        // Standard.InterfaceRealization rules: all allowed.

        this.ruleLinkExpert.addRule(InterfaceRealization.class, null, null);

    }

    @objid ("9170a647-c3aa-46e0-8611-76216fe39c19")
    protected void registerLinkExpertForLink() {
        // Standard.Link
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Link.class);

        // Standard.Link sources and target dependencies


        // Standard.Link rules: all allowed.

        this.ruleLinkExpert.addRule(Link.class, null, null);

    }

    @objid ("8408371d-4c6c-4ee1-a42e-8e7dfe9d65fa")
    protected void registerLinkExpertForLinkEnd() {
        // Standard.LinkEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(LinkEnd.class);

        // Standard.LinkEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(LinkEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(LinkEnd.class, "Target");


        // Standard.LinkEnd rules: all allowed.

        this.ruleLinkExpert.addRule(LinkEnd.class, null, null);

    }

    @objid ("1ace9f6c-1d3d-4f4a-8374-2345a91618d7")
    protected void registerLinkExpertForManifestation() {
        // Standard.Manifestation
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Manifestation.class);

        // Standard.Manifestation sources and target dependencies
        this.ruleLinkExpert.addSourceDep(Manifestation.class, "Owner");
        this.ruleLinkExpert.addTargetDep(Manifestation.class, "UtilizedElement");


        // Standard.Manifestation rules: all allowed.

        this.ruleLinkExpert.addRule(Manifestation.class, null, null);

    }

    @objid ("d19087be-c787-4710-9635-12018f574c9c")
    protected void registerLinkExpertForPackageImport() {
        // Standard.PackageImport
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(PackageImport.class);

        // Standard.PackageImport sources and target dependencies
        this.ruleLinkExpert.addTargetDep(PackageImport.class, "ImportedPackage");
        this.ruleLinkExpert.addSourceDep(PackageImport.class, "ImportingNameSpace");
        this.ruleLinkExpert.addSourceDep(PackageImport.class, "ImportingOperation");


        // Standard.PackageImport rules: all allowed.

        this.ruleLinkExpert.addRule(PackageImport.class, null, null);

    }

    @objid ("e66d8e58-f035-471f-b527-9ac903cfe957")
    protected void registerLinkExpertForPackageMerge() {
        // Standard.PackageMerge
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(PackageMerge.class);

        // Standard.PackageMerge sources and target dependencies
        this.ruleLinkExpert.addTargetDep(PackageMerge.class, "MergedPackage");
        this.ruleLinkExpert.addSourceDep(PackageMerge.class, "ReceivingPackage");


        // Standard.PackageMerge rules: all allowed.

        this.ruleLinkExpert.addRule(PackageMerge.class, null, null);

    }

    @objid ("65a76d99-a9e5-4632-9435-5e888588c731")
    protected void registerLinkExpertForRaisedException() {
        // Standard.RaisedException
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(RaisedException.class);

        // Standard.RaisedException sources and target dependencies
        this.ruleLinkExpert.addSourceDep(RaisedException.class, "Thrower");
        this.ruleLinkExpert.addTargetDep(RaisedException.class, "ThrownType");


        // Standard.RaisedException rules: all allowed.

        this.ruleLinkExpert.addRule(RaisedException.class, null, null);

    }

    @objid ("a0be6fdb-b26b-4b44-87d4-c208b36d1d9b")
    protected void registerLinkExpertForTemplateBinding() {
        // Standard.TemplateBinding
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(TemplateBinding.class);

        // Standard.TemplateBinding sources and target dependencies
        this.ruleLinkExpert.addSourceDep(TemplateBinding.class, "BoundElement");
        this.ruleLinkExpert.addSourceDep(TemplateBinding.class, "BoundOperation");
        this.ruleLinkExpert.addTargetDep(TemplateBinding.class, "InstanciatedTemplate");
        this.ruleLinkExpert.addTargetDep(TemplateBinding.class, "InstanciatedTemplateOperation");


        // Standard.TemplateBinding rules: all allowed.

        this.ruleLinkExpert.addRule(TemplateBinding.class, null, null);

    }

    @objid ("4f919b6b-7b93-4c70-934f-8cb7614a599f")
    protected void registerLinkExpertForControlFlow() {
        // Standard.ControlFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ControlFlow.class);

        // Standard.ControlFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ControlFlow.class, "Source");
        this.ruleLinkExpert.addTargetDep(ControlFlow.class, "Target");


        // Standard.ControlFlow rules: all allowed.

        this.ruleLinkExpert.addRule(ControlFlow.class, null, null);

    }

    @objid ("5945ebc8-ad7d-49ad-b5b6-8c6c2002d1a0")
    protected void registerLinkExpertForMessageFlow() {
        // Standard.MessageFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(MessageFlow.class);

        // Standard.MessageFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(MessageFlow.class, "Source");
        this.ruleLinkExpert.addSourceDep(MessageFlow.class, "SourcePartition");
        this.ruleLinkExpert.addTargetDep(MessageFlow.class, "Target");
        this.ruleLinkExpert.addTargetDep(MessageFlow.class, "TargetPartition");


        // Standard.MessageFlow rules: all allowed.

        this.ruleLinkExpert.addRule(MessageFlow.class, null, null);

    }

    @objid ("99e6d66b-92b6-43f0-be0a-31b7fa47dd48")
    protected void registerLinkExpertForObjectFlow() {
        // Standard.ObjectFlow
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ObjectFlow.class);

        // Standard.ObjectFlow sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ObjectFlow.class, "Source");
        this.ruleLinkExpert.addTargetDep(ObjectFlow.class, "Target");


        // Standard.ObjectFlow rules: all allowed.

        this.ruleLinkExpert.addRule(ObjectFlow.class, null, null);

    }

    @objid ("61158971-494a-4ba6-a5ff-17cc31720399")
    protected void registerLinkExpertForElementRealization() {
        // Standard.ElementRealization
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ElementRealization.class);

        // Standard.ElementRealization sources and target dependencies
        this.ruleLinkExpert.addTargetDep(ElementRealization.class, "DependsOn");
        this.ruleLinkExpert.addSourceDep(ElementRealization.class, "Impacted");


        // Standard.ElementRealization rules: all allowed.

        this.ruleLinkExpert.addRule(ElementRealization.class, null, null);

    }

    @objid ("ae1be80e-c344-4294-ac6d-bf56aa366ae4")
    protected void registerLinkExpertForConnector() {
        // Standard.Connector
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(Connector.class);

        // Standard.Connector sources and target dependencies


        // Standard.Connector rules: all allowed.

        this.ruleLinkExpert.addRule(Connector.class, null, null);

    }

    @objid ("353130b6-8495-4acf-9052-0712f4df273a")
    protected void registerLinkExpertForConnectorEnd() {
        // Standard.ConnectorEnd
        // -----------

        this.ruleLinkExpert.addLinkMetaclass(ConnectorEnd.class);

        // Standard.ConnectorEnd sources and target dependencies
        this.ruleLinkExpert.addSourceDep(ConnectorEnd.class, "Source");
        this.ruleLinkExpert.addTargetDep(ConnectorEnd.class, "Target");


        // Standard.ConnectorEnd rules: all allowed.

        this.ruleLinkExpert.addRule(ConnectorEnd.class, null, null);

    }

    @objid ("a94dd998-3d2e-4269-975d-2cf0ca7d0290")
    protected void registerMetaExpertForProject() {
        // Standard.Project
        // -----------

        // no constraint on Project.Model : Package from Standard.Project to Standard.Package
        this.ruleMetaExpert.addDependencyRule(Project.class, null, "Model");

    }

    @objid ("48927491-f0b3-4518-87ea-b9c72d6d9c8e")
    protected void registerMetaExpertForTemplateParameterSubstitution() {
        // Standard.TemplateParameterSubstitution
        // -----------

        // no constraint on TemplateParameterSubstitution.Actual : UmlModelElement from Standard.TemplateParameterSubstitution to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(TemplateParameterSubstitution.class, null, "Actual");

        // no constraint on TemplateParameterSubstitution.FormalParameter : TemplateParameter from Standard.TemplateParameterSubstitution to Standard.TemplateParameter
        this.ruleMetaExpert.addDependencyRule(TemplateParameterSubstitution.class, null, "FormalParameter");

    }

    @objid ("72b4455a-49b3-4c47-b093-215bc0ed713c")
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

    @objid ("4e8870ee-7695-4391-bbaf-5ba2e0a82b08")
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

    @objid ("52f31fba-522c-4adf-9385-1aeb54d422b0")
    protected void registerMetaExpertForRequiredInterface() {
        // Standard.RequiredInterface
        // -----------

        // no constraint on RequiredInterface.RequiredElement : Interface from Standard.RequiredInterface to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(RequiredInterface.class, null, "RequiredElement");

    }

    @objid ("f1296d35-d016-4fbe-bc4f-dd5a4fe45196")
    protected void registerMetaExpertForRaisedException() {
        // Standard.RaisedException
        // -----------

        // no constraint on RaisedException.ThrownType : Classifier from Standard.RaisedException to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(RaisedException.class, null, "ThrownType");

    }

    @objid ("9a91470d-2bd8-4f71-968c-e41ecea65f25")
    protected void registerMetaExpertForProvidedInterface() {
        // Standard.ProvidedInterface
        // -----------

        // no constraint on ProvidedInterface.ProvidedElement : Interface from Standard.ProvidedInterface to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(ProvidedInterface.class, null, "ProvidedElement");

    }

    @objid ("d8c9fd22-34cb-4fcc-aa85-34dfcdc11f92")
    protected void registerMetaExpertForPort() {
        // Standard.Port
        // -----------

        // no constraint on Port.Provided : ProvidedInterface from Standard.Port to Standard.ProvidedInterface
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Provided");

        // no constraint on Port.Required : RequiredInterface from Standard.Port to Standard.RequiredInterface
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "Required");

    }

    @objid ("9189005c-b7b9-4da4-a47a-dcfc172da01f")
    protected void registerMetaExpertForPackageMerge() {
        // Standard.PackageMerge
        // -----------

        // no constraint on PackageMerge.MergedPackage : Package from Standard.PackageMerge to Standard.Package
        this.ruleMetaExpert.addDependencyRule(PackageMerge.class, null, "MergedPackage");

    }

    @objid ("eed448c0-75a3-4762-b046-ae3e3c96e9a3")
    protected void registerMetaExpertForPackageImport() {
        // Standard.PackageImport
        // -----------

        // no constraint on PackageImport.ImportedPackage : Package from Standard.PackageImport to Standard.Package
        this.ruleMetaExpert.addDependencyRule(PackageImport.class, null, "ImportedPackage");

    }

    @objid ("3e3a9e61-6282-474d-9472-592497f59b09")
    protected void registerMetaExpertForPackage() {
        // Standard.Package
        // -----------

        // no constraint on Package.Merge : PackageMerge from Standard.Package to Standard.PackageMerge
        this.ruleMetaExpert.addDependencyRule(Package.class, null, "Merge");

    }

    @objid ("ac560de6-7ec8-403c-a4e7-d1043cce5a13")
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

    @objid ("48ef70c8-c8b4-4c59-8cf6-ef3a1cfe1882")
    protected void registerMetaExpertForNode() {
        // Standard.Node
        // -----------

        // no constraint on Node.Resident : Artifact from Standard.Node to Standard.Artifact
        this.ruleMetaExpert.addDependencyRule(Node.class, null, "Resident");

    }

    @objid ("46e2396b-de61-45de-a5cd-96c01928adf7")
    protected void registerMetaExpertForNaryConnectorEnd() {
        // Standard.NaryConnectorEnd
        // -----------

    }

    @objid ("ec2248a6-ebbc-41b8-bd02-e5315cb087ee")
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

    @objid ("1c44a943-f629-426c-ab16-c429da2d7c26")
    protected void registerMetaExpertForNaryConnector() {
        // Standard.NaryConnector
        // -----------

        // no constraint on NaryConnector.RepresentedFeature : UmlModelElement from Standard.NaryConnector to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(NaryConnector.class, null, "RepresentedFeature");

    }

    @objid ("ad08c124-cdda-423c-99a7-e997120ed82f")
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

    @objid ("ca2b7837-e1ae-432b-9398-eba88bbc3e4c")
    protected void registerMetaExpertForNaryAssociationEnd() {
        // Standard.NaryAssociationEnd
        // -----------

        // no constraint on NaryAssociationEnd.NaryAssociation : NaryAssociation from Standard.NaryAssociationEnd to Standard.NaryAssociation
        this.ruleMetaExpert.addDependencyRule(NaryAssociationEnd.class, null, "NaryAssociation");

    }

    @objid ("226b6109-1e18-4f50-9b00-fef30c4fc295")
    protected void registerMetaExpertForNaryAssociation() {
        // Standard.NaryAssociation
        // -----------

        // no constraint on NaryAssociation.NaryEnd : NaryAssociationEnd from Standard.NaryAssociation to Standard.NaryAssociationEnd
        this.ruleMetaExpert.addDependencyRule(NaryAssociation.class, null, "NaryEnd");

        // no constraint on NaryAssociation.LinkToClass : ClassAssociation from Standard.NaryAssociation to Standard.ClassAssociation
        this.ruleMetaExpert.addDependencyRule(NaryAssociation.class, null, "LinkToClass");

    }

    @objid ("15875b89-99df-4260-958c-3edca55b2b80")
    protected void registerMetaExpertForManifestation() {
        // Standard.Manifestation
        // -----------

        // no constraint on Manifestation.UtilizedElement : UmlModelElement from Standard.Manifestation to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(Manifestation.class, null, "UtilizedElement");

    }

    @objid ("461f21ea-5abf-434f-b916-13412ffc2874")
    protected void registerMetaExpertForInterfaceRealization() {
        // Standard.InterfaceRealization
        // -----------

        // no constraint on InterfaceRealization.Implemented : Interface from Standard.InterfaceRealization to Standard.Interface
        this.ruleMetaExpert.addDependencyRule(InterfaceRealization.class, null, "Implemented");

    }

    @objid ("72e5d14b-ba26-4102-833d-c62bf41d446d")
    protected void registerMetaExpertForInterface() {
        // Standard.Interface
        // -----------

    }

    @objid ("3e306999-90cf-4426-acbf-9c6fd61b9993")
    protected void registerMetaExpertForGeneralization() {
        // Standard.Generalization
        // -----------

        // no constraint on Generalization.SuperType : NameSpace from Standard.Generalization to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(Generalization.class, null, "SuperType");

    }

    @objid ("54bd0800-9ab1-43bd-a2a1-fd477d6891f8")
    protected void registerMetaExpertForEnumerationLiteral() {
        // Standard.EnumerationLiteral
        // -----------

    }

    @objid ("8323a2b6-2014-4526-9c12-14ebc28f3e36")
    protected void registerMetaExpertForEnumeration() {
        // Standard.Enumeration
        // -----------

        // no constraint on Enumeration.Value : EnumerationLiteral from Standard.Enumeration to Standard.EnumerationLiteral
        this.ruleMetaExpert.addDependencyRule(Enumeration.class, null, "Value");

    }

    @objid ("e2db4ad9-a05a-4e2a-8151-255dda0e2870")
    protected void registerMetaExpertForElementRealization() {
        // Standard.ElementRealization
        // -----------

    }

    @objid ("b7cbf5cd-6321-4017-b966-8b3194edf762")
    protected void registerMetaExpertForElementImport() {
        // Standard.ElementImport
        // -----------

        // no constraint on ElementImport.ImportedElement : NameSpace from Standard.ElementImport to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(ElementImport.class, null, "ImportedElement");

    }

    @objid ("d97732f3-2cc5-4e37-9ae6-f3042ff9ecbe")
    protected void registerMetaExpertForDataType() {
        // Standard.DataType
        // -----------

    }

    @objid ("131c8c15-63ca-47ab-896f-cfda88c6af59")
    protected void registerMetaExpertForConnectorEnd() {
        // Standard.ConnectorEnd
        // -----------

        // no constraint on ConnectorEnd.RepresentedFeature : UmlModelElement from Standard.ConnectorEnd to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(ConnectorEnd.class, null, "RepresentedFeature");

    }

    @objid ("4e2e24d2-e8ce-4fd4-a8d8-0e0aa968cbdc")
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

    @objid ("38788d58-f659-4b71-9f67-9a57772430d8")
    protected void registerMetaExpertForConnector() {
        // Standard.Connector
        // -----------

    }

    @objid ("81e43620-46d9-42a4-b1da-338da5063410")
    protected void registerMetaExpertForLink() {
        // Standard.Link
        // -----------

        // no constraint on Link.Model : Association from Standard.Link to Standard.Association
        this.ruleMetaExpert.addDependencyRule(Connector.class, null, "Model");
        this.ruleMetaExpert.addDependencyRule(Link.class, null, "Model");

    }

    @objid ("18f3f097-b30d-4011-873e-dcdc106cd0b3")
    protected void registerMetaExpertForComponentRealization() {
        // Standard.ComponentRealization
        // -----------

        // no constraint on ComponentRealization.RealizingClassifier : Classifier from Standard.ComponentRealization to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(ComponentRealization.class, null, "RealizingClassifier");

    }

    @objid ("872023ed-4ebc-4a07-8585-63b142890bf3")
    protected void registerMetaExpertForComponent() {
        // Standard.Component
        // -----------

        // no constraint on Component.Realization : ComponentRealization from Standard.Component to Standard.ComponentRealization
        this.ruleMetaExpert.addDependencyRule(Component.class, null, "Realization");

    }

    @objid ("882aee90-2cf4-4215-af70-4d73abc7c224")
    protected void registerMetaExpertForCollaborationUse() {
        // Standard.CollaborationUse
        // -----------

        // no constraint on CollaborationUse.Type : Collaboration from Standard.CollaborationUse to Standard.Collaboration
        this.ruleMetaExpert.addDependencyRule(CollaborationUse.class, null, "Type");

        // no constraint on CollaborationUse.RoleBinding : Binding from Standard.CollaborationUse to Standard.Binding
        this.ruleMetaExpert.addDependencyRule(CollaborationUse.class, null, "RoleBinding");

    }

    @objid ("9f9649f8-8e09-46be-a2ea-419d61e4aaa3")
    protected void registerMetaExpertForCollaboration() {
        // Standard.Collaboration
        // -----------

    }

    @objid ("be73723a-935e-47fe-af09-8a189dd1265a")
    protected void registerMetaExpertForClassAssociation() {
        // Standard.ClassAssociation
        // -----------

        // no constraint on ClassAssociation.ClassPart : Class from Standard.ClassAssociation to Standard.Class
        this.ruleMetaExpert.addDependencyRule(ClassAssociation.class, null, "ClassPart");

    }

    @objid ("10190fad-d90f-4d9f-9dd6-7c5bbffcab82")
    protected void registerMetaExpertForClass() {
        // Standard.Class
        // -----------

    }

    @objid ("96919344-5e2d-42fc-8e6f-1c8c1e864b66")
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

    @objid ("b7e78f98-6e11-4298-803c-76782489fe11")
    protected void registerMetaExpertForBindableInstance() {
        // Standard.BindableInstance
        // -----------

        // no constraint on BindableInstance.RepresentedFeature : UmlModelElement from Standard.BindableInstance to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(BindableInstance.class, null, "RepresentedFeature");
        this.ruleMetaExpert.addDependencyRule(Port.class, null, "RepresentedFeature");

    }

    @objid ("a9ae6b68-6c7d-445b-94c7-345733b66075")
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

    @objid ("8bf2a360-5627-469b-bbe9-0de6d9ed2b9c")
    protected void registerMetaExpertForBehavioralFeature() {
        // Standard.BehavioralFeature
        // -----------

    }

    @objid ("f1d81ed4-cfca-4711-b41b-ba3dc929ea4e")
    protected void registerMetaExpertForAttributeLink() {
        // Standard.AttributeLink
        // -----------

        // no constraint on AttributeLink.Base : Attribute from Standard.AttributeLink to Standard.Attribute
        this.ruleMetaExpert.addDependencyRule(AttributeLink.class, null, "Base");

    }

    @objid ("16df50b5-9466-4198-aa98-10b06eaa2411")
    protected void registerMetaExpertForAttribute() {
        // Standard.Attribute
        // -----------

        // no constraint on Attribute.Type : GeneralClass from Standard.Attribute to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(Attribute.class, null, "Type");

    }

    @objid ("81f2f885-ee50-421f-8d4f-98609d335676")
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

    @objid ("529fed7f-7801-4b57-b499-3b053881c20d")
    protected void registerMetaExpertForStructuralFeature() {
        // Standard.StructuralFeature
        // -----------

    }

    @objid ("76c0b57e-c98e-4217-82bc-7c4f259bdac0")
    protected void registerMetaExpertForFeature() {
        // Standard.Feature is abstract

        // -----------

    }

    @objid ("188c4c89-e6d2-4e8b-99e6-b1061d536a71")
    protected void registerMetaExpertForAssociation() {
        // Standard.Association
        // -----------

        // no constraint on Association.LinkToClass : ClassAssociation from Standard.Association to Standard.ClassAssociation
        this.ruleMetaExpert.addDependencyRule(Association.class, null, "LinkToClass");

    }

    @objid ("70a35dd3-63c6-45dc-a39c-5d860e45fcdc")
    protected void registerMetaExpertForArtifact() {
        // Standard.Artifact
        // -----------

        // no constraint on Artifact.Utilized : Manifestation from Standard.Artifact to Standard.Manifestation
        this.ruleMetaExpert.addDependencyRule(Artifact.class, null, "Utilized");

    }

    @objid ("01a1342c-ece6-4692-bf46-d5bb1dc4f4d7")
    protected void registerMetaExpertForUsage() {
        // Standard.Usage
        // -----------

    }

    @objid ("cf4da6d1-57a7-4763-8d01-22eff1cc2b8a")
    protected void registerMetaExpertForSubstitution() {
        // Standard.Substitution
        // -----------

        // no constraint on Substitution.Contract : Classifier from Standard.Substitution to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(Substitution.class, null, "Contract");

    }

    @objid ("0e671703-e9fc-4c8a-86fe-935352d1e667")
    protected void registerMetaExpertForAbstraction() {
        // Standard.Abstraction
        // -----------

    }

    @objid ("b870184e-4476-4534-95a7-cc6683fdbcce")
    protected void registerMetaExpertForInformationItem() {
        // Standard.InformationItem
        // -----------

        // no constraint on InformationItem.Represented : Classifier from Standard.InformationItem to Standard.Classifier
        this.ruleMetaExpert.addDependencyRule(InformationItem.class, null, "Represented");

    }

    @objid ("963abeef-b4b7-4a44-9563-fcd70058f469")
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

    @objid ("a48954a4-a1ad-4ade-9d3f-dd31c79af62d")
    protected void registerMetaExpertForDataFlow() {
        // Standard.DataFlow
        // -----------

        // no constraint on DataFlow.Destination : NameSpace from Standard.DataFlow to Standard.NameSpace
        this.ruleMetaExpert.addDependencyRule(DataFlow.class, null, "Destination");

        // no constraint on DataFlow.SModel : Signal from Standard.DataFlow to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(DataFlow.class, null, "SModel");

    }

    @objid ("a40ebf6f-94a4-41b6-8f13-b337f7a37e27")
    protected void registerMetaExpertForUseCaseDependency() {
        // Standard.UseCaseDependency
        // -----------

        // no constraint on UseCaseDependency.ExtensionLocation : ExtensionPoint from Standard.UseCaseDependency to Standard.ExtensionPoint
        this.ruleMetaExpert.addDependencyRule(UseCaseDependency.class, null, "ExtensionLocation");

        // no constraint on UseCaseDependency.Target : UseCase from Standard.UseCaseDependency to Standard.UseCase
        this.ruleMetaExpert.addDependencyRule(UseCaseDependency.class, null, "Target");

    }

    @objid ("c3cfaced-88c1-462e-9fb6-ec259b553973")
    protected void registerMetaExpertForUseCase() {
        // Standard.UseCase
        // -----------

        // no constraint on UseCase.Used : UseCaseDependency from Standard.UseCase to Standard.UseCaseDependency
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "Used");

        // no constraint on UseCase.OwnedExtension : ExtensionPoint from Standard.UseCase to Standard.ExtensionPoint
        this.ruleMetaExpert.addDependencyRule(UseCase.class, null, "OwnedExtension");

    }

    @objid ("50004cb5-02f8-4acb-aa55-6e4432368836")
    protected void registerMetaExpertForExtensionPoint() {
        // Standard.ExtensionPoint
        // -----------

    }

    @objid ("44e6c2ca-b6e3-446e-8a28-8f1acd4a6bd0")
    protected void registerMetaExpertForActor() {
        // Standard.Actor
        // -----------

    }

    @objid ("352fd4cd-4cc0-42c0-849c-6aff833eeb3a")
    protected void registerMetaExpertForTerminatePseudoState() {
        // Standard.TerminatePseudoState
        // -----------

    }

    @objid ("830fb251-e4a5-4c18-80e2-40efc83a8fab")
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

    @objid ("e406058a-ba62-4735-bd17-492af4fe5000")
    protected void registerMetaExpertForShallowHistoryPseudoState() {
        // Standard.ShallowHistoryPseudoState
        // -----------

    }

    @objid ("de3da724-0a32-49fa-ab3c-612d2e76586e")
    protected void registerMetaExpertForRegion() {
        // Standard.Region
        // -----------

        // no constraint on Region.Sub : StateVertex from Standard.Region to Standard.StateVertex
        this.ruleMetaExpert.addDependencyRule(Region.class, null, "Sub");

    }

    @objid ("d4b336e1-ddaf-46e2-9799-2228fcad87ac")
    protected void registerMetaExpertForJunctionPseudoState() {
        // Standard.JunctionPseudoState
        // -----------

    }

    @objid ("b13d720c-6b4b-4b39-9fac-c91e305aaf8c")
    protected void registerMetaExpertForJoinPseudoState() {
        // Standard.JoinPseudoState
        // -----------

    }

    @objid ("40eef5a2-9a8f-47fb-9432-5045ed2b234f")
    protected void registerMetaExpertForInternalTransition() {
        // Standard.InternalTransition
        // -----------

    }

    @objid ("d489c5dd-50df-4261-a44c-c0594dd71ae8")
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

    @objid ("89807b17-16bf-410b-bb82-6d6ab59e6ba5")
    protected void registerMetaExpertForInitialPseudoState() {
        // Standard.InitialPseudoState
        // -----------

    }

    @objid ("426354fb-eaae-412e-aa3d-e9c0220d5237")
    protected void registerMetaExpertForForkPseudoState() {
        // Standard.ForkPseudoState
        // -----------

    }

    @objid ("5e2b75c7-3765-403a-b91f-eeeb789de26e")
    protected void registerMetaExpertForFinalState() {
        // Standard.FinalState
        // -----------

    }

    @objid ("4e1b0577-cbc6-415b-ac6c-e9a078a6d6aa")
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

    @objid ("ba51cbd4-d14a-4987-968f-074729a8b515")
    protected void registerMetaExpertForExitPointPseudoState() {
        // Standard.ExitPointPseudoState
        // -----------

    }

    @objid ("a4f6c30f-23c2-41ef-86fa-7d5fa04cd63c")
    protected void registerMetaExpertForEntryPointPseudoState() {
        // Standard.EntryPointPseudoState
        // -----------

    }

    @objid ("ad6510b2-7d03-47bb-bd7f-db5db3cdd3cc")
    protected void registerMetaExpertForDeepHistoryPseudoState() {
        // Standard.DeepHistoryPseudoState
        // -----------

    }

    @objid ("5f30b2ce-0983-479f-95e9-5f1415663f70")
    protected void registerMetaExpertForConnectionPointReference() {
        // Standard.ConnectionPointReference
        // -----------

        // no constraint on ConnectionPointReference.Exit : ExitPointPseudoState from Standard.ConnectionPointReference to Standard.ExitPointPseudoState
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "Exit");

        // no constraint on ConnectionPointReference.Entry : EntryPointPseudoState from Standard.ConnectionPointReference to Standard.EntryPointPseudoState
        this.ruleMetaExpert.addDependencyRule(ConnectionPointReference.class, null, "Entry");

    }

    @objid ("b8c7c4b8-eec7-4cd3-82d0-70e191f53ff5")
    protected void registerMetaExpertForChoicePseudoState() {
        // Standard.ChoicePseudoState
        // -----------

    }

    @objid ("ee4f1485-98cd-4687-afea-c09c09fc82bb")
    protected void registerMetaExpertForAbstractPseudoState() {
        // Standard.AbstractPseudoState is abstract

        // -----------

    }

    @objid ("9833f98e-b5d9-4f12-8daa-c2b46239760f")
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

    @objid ("a36da166-3838-4de6-b9a7-411d66287251")
    protected void registerMetaExpertForTerminateSpecification() {
        // Standard.TerminateSpecification
        // -----------

    }

    @objid ("d34f31f8-1acd-4be6-bbe1-248e9f9dde08")
    protected void registerMetaExpertForStateInvariant() {
        // Standard.StateInvariant
        // -----------

    }

    @objid ("4ea930ca-344a-4662-b1b0-c1ca41074351")
    protected void registerMetaExpertForPartDecomposition() {
        // Standard.PartDecomposition
        // -----------

    }

    @objid ("825c2c99-6a16-466b-95af-28095561073b")
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

    @objid ("987b31cb-1f01-4e6d-a607-9b6a8870fe69")
    protected void registerMetaExpertForLifeline() {
        // Standard.Lifeline
        // -----------

        // no constraint on Lifeline.DecomposedAs : PartDecomposition from Standard.Lifeline to Standard.PartDecomposition
        this.ruleMetaExpert.addDependencyRule(Lifeline.class, null, "DecomposedAs");

        // no constraint on Lifeline.Represented : Instance from Standard.Lifeline to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(Lifeline.class, null, "Represented");

    }

    @objid ("6bcff381-1c0d-466e-b156-05d59191f70b")
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

    @objid ("774344ba-3d1d-4ff2-840a-d70680170dea")
    protected void registerMetaExpertForInteractionOperand() {
        // Standard.InteractionOperand
        // -----------

        // no constraint on InteractionOperand.Fragment : InteractionFragment from Standard.InteractionOperand to Standard.InteractionFragment
        this.ruleMetaExpert.addDependencyRule(InteractionOperand.class, null, "Fragment");

    }

    @objid ("433f571d-64e6-41c0-ab38-0041d784a6bd")
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

    @objid ("f68fb686-754b-4b0c-b9e9-e6d47f180156")
    protected void registerMetaExpertForGeneralOrdering() {
        // Standard.GeneralOrdering
        // -----------

        // no constraint on GeneralOrdering.After : OccurrenceSpecification from Standard.GeneralOrdering to Standard.OccurrenceSpecification
        this.ruleMetaExpert.addDependencyRule(GeneralOrdering.class, null, "After");

    }

    @objid ("a1c4aa40-16bb-47d7-9450-d92015b6f5fe")
    protected void registerMetaExpertForGate() {
        // Standard.Gate
        // -----------

        // no constraint on Gate.Formal : Gate from Standard.Gate to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "Formal");

    }

    @objid ("d52a7bba-a568-49b1-82b6-d2424270db3c")
    protected void registerMetaExpertForExecutionSpecification() {
        // Standard.ExecutionSpecification
        // -----------

        // no constraint on ExecutionSpecification.Finish : ExecutionOccurenceSpecification from Standard.ExecutionSpecification to Standard.ExecutionOccurenceSpecification
        this.ruleMetaExpert.addDependencyRule(ExecutionSpecification.class, null, "Finish");

    }

    @objid ("e0d117bb-014f-43da-a270-65e0059ce632")
    protected void registerMetaExpertForExecutionOccurenceSpecification() {
        // Standard.ExecutionOccurenceSpecification
        // -----------

        // no constraint on ExecutionOccurenceSpecification.Started : ExecutionSpecification from Standard.ExecutionOccurenceSpecification to Standard.ExecutionSpecification
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "Started");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "Started");

    }

    @objid ("347e8f3d-3d96-45b5-8b3c-b9b59152ccfb")
    protected void registerMetaExpertForMessageEnd() {
        // Standard.MessageEnd is abstract

        // -----------

        // no constraint on MessageEnd.SentMessage : Message from Standard.MessageEnd to Standard.Message
        this.ruleMetaExpert.addDependencyRule(ExecutionOccurenceSpecification.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(Gate.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(MessageEnd.class, null, "SentMessage");
        this.ruleMetaExpert.addDependencyRule(TerminateSpecification.class, null, "SentMessage");

    }

    @objid ("fecf4892-de58-4981-8c0a-9661942456cd")
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

    @objid ("8d72fa80-161f-4118-a61c-8a0b3a4fde26")
    protected void registerMetaExpertForDurationConstraint() {
        // Standard.DurationConstraint
        // -----------

    }

    @objid ("712cd079-80fc-401d-8384-668a5e2524d8")
    protected void registerMetaExpertForConstraint() {
        // Standard.Constraint
        // -----------

        // no constraint on Constraint.ConstrainedElement : UmlModelElement from Standard.Constraint to Standard.UmlModelElement
        this.ruleMetaExpert.addDependencyRule(Constraint.class, null, "ConstrainedElement");
        this.ruleMetaExpert.addDependencyRule(DurationConstraint.class, null, "ConstrainedElement");

    }

    @objid ("64ae9d4d-8685-4da6-87a6-732be541700b")
    protected void registerMetaExpertForCombinedFragment() {
        // Standard.CombinedFragment
        // -----------

        // no constraint on CombinedFragment.Operand : InteractionOperand from Standard.CombinedFragment to Standard.InteractionOperand
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "Operand");

        // no constraint on CombinedFragment.FragmentGate : Gate from Standard.CombinedFragment to Standard.Gate
        this.ruleMetaExpert.addDependencyRule(CombinedFragment.class, null, "FragmentGate");

    }

    @objid ("65b67df5-60c6-4286-9c19-b5bd09b06ad5")
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

    @objid ("f16fb053-f161-4982-8f50-2a2d00b335f2")
    protected void registerMetaExpertForCommunicationNode() {
        // Standard.CommunicationNode
        // -----------

        // no constraint on CommunicationNode.Represented : Instance from Standard.CommunicationNode to Standard.Instance
        this.ruleMetaExpert.addDependencyRule(CommunicationNode.class, null, "Represented");

        // no constraint on CommunicationNode.Started : CommunicationChannel from Standard.CommunicationNode to Standard.CommunicationChannel
        this.ruleMetaExpert.addDependencyRule(CommunicationNode.class, null, "Started");

    }

    @objid ("476f73c4-8608-413c-8199-12fbe645c7ae")
    protected void registerMetaExpertForCommunicationMessage() {
        // Standard.CommunicationMessage
        // -----------

        // no constraint on CommunicationMessage.Invoked : Operation from Standard.CommunicationMessage to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(CommunicationMessage.class, null, "Invoked");

        // no constraint on CommunicationMessage.SignalSignature : Signal from Standard.CommunicationMessage to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(CommunicationMessage.class, null, "SignalSignature");

    }

    @objid ("fb8339a0-9ad0-45c5-8a2f-c3480466c70e")
    protected void registerMetaExpertForCommunicationInteraction() {
        // Standard.CommunicationInteraction
        // -----------

        // no constraint on CommunicationInteraction.Owned : CommunicationNode from Standard.CommunicationInteraction to Standard.CommunicationNode
        this.ruleMetaExpert.addDependencyRule(CommunicationInteraction.class, null, "Owned");

    }

    @objid ("e9b61618-0b44-4bbb-84b3-82880469795c")
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

    @objid ("88fabf3d-36c1-4671-b64c-c64b870a7897")
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

    @objid ("a50f79b6-7002-4e91-a08b-8e050e2c25b0")
    protected void registerMetaExpertForGeneralClass() {
        // Standard.GeneralClass is abstract

        // -----------

    }

    @objid ("8ad7a87c-9601-406c-8873-61f0457ec18d")
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

    @objid ("e0648650-7722-4b98-9fd3-ac3e62d615da")
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

    @objid ("1bec9273-68cb-4de9-b253-acc7d8b9cb61")
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

    @objid ("465c9956-6b93-457d-b40f-cd7f3b52a03b")
    protected void registerMetaExpertForOpaqueBehavior() {
        // Standard.OpaqueBehavior
        // -----------

    }

    @objid ("6d43fcf1-57b0-4260-8984-b5f5b7efc13a")
    protected void registerMetaExpertForEvent() {
        // Standard.Event
        // -----------

        // no constraint on Event.Model : Signal from Standard.Event to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "Model");

        // no constraint on Event.Called : Operation from Standard.Event to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(Event.class, null, "Called");

    }

    @objid ("e2b46a7d-f39e-4292-a22c-6212b3887fca")
    protected void registerMetaExpertForBehaviorParameter() {
        // Standard.BehaviorParameter
        // -----------

        // no constraint on BehaviorParameter.Mapped : Parameter from Standard.BehaviorParameter to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(BehaviorParameter.class, null, "Mapped");

    }

    @objid ("f20ec4bc-3de2-4949-9cfd-247d3ef8073c")
    protected void registerMetaExpertForParameter() {
        // Standard.Parameter
        // -----------

        // no constraint on Parameter.Type : GeneralClass from Standard.Parameter to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(BehaviorParameter.class, null, "Type");
        this.ruleMetaExpert.addDependencyRule(Parameter.class, null, "Type");

    }

    @objid ("3897a894-1b96-432d-9f6c-2d3312d8d970")
    protected void registerMetaExpertForValuePin() {
        // Standard.ValuePin
        // -----------

    }

    @objid ("578baaef-3cab-430a-a27b-50f3ee96a732")
    protected void registerMetaExpertForSendSignalAction() {
        // Standard.SendSignalAction
        // -----------

        // no constraint on SendSignalAction.Sent : Signal from Standard.SendSignalAction to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(SendSignalAction.class, null, "Sent");

    }

    @objid ("39f75ee8-5bc0-423a-a31c-b953ff705739")
    protected void registerMetaExpertForOutputPin() {
        // Standard.OutputPin
        // -----------

    }

    @objid ("d3b13389-7a9f-4005-ad08-80db354f7fa1")
    protected void registerMetaExpertForOpaqueAction() {
        // Standard.OpaqueAction
        // -----------

    }

    @objid ("a03ae4f2-e388-4a73-b0cc-042a0e3246e9")
    protected void registerMetaExpertForObjectFlow() {
        // Standard.ObjectFlow
        // -----------

    }

    @objid ("291730d3-56d5-482d-9363-17edc93b1f93")
    protected void registerMetaExpertForMessageFlow() {
        // Standard.MessageFlow
        // -----------

        // no constraint on MessageFlow.TargetPartition : ActivityPartition from Standard.MessageFlow to Standard.ActivityPartition
        this.ruleMetaExpert.addDependencyRule(MessageFlow.class, null, "TargetPartition");

    }

    @objid ("11873f58-22d5-4b79-b370-14003fe9cb9d")
    protected void registerMetaExpertForLoopNode() {
        // Standard.LoopNode
        // -----------

    }

    @objid ("b501800e-927f-4f7e-b510-3aca50bb80c6")
    protected void registerMetaExpertForInterruptibleActivityRegion() {
        // Standard.InterruptibleActivityRegion
        // -----------

        // no constraint on InterruptibleActivityRegion.InterruptingEdge : ActivityEdge from Standard.InterruptibleActivityRegion to Standard.ActivityEdge
        this.ruleMetaExpert.addDependencyRule(InterruptibleActivityRegion.class, null, "InterruptingEdge");

    }

    @objid ("40e8910e-7b82-4121-a24f-c971955cd08f")
    protected void registerMetaExpertForInstanceNode() {
        // Standard.InstanceNode
        // -----------

    }

    @objid ("4e9fa59f-6662-453c-bd78-8bec77dd5725")
    protected void registerMetaExpertForInputPin() {
        // Standard.InputPin
        // -----------

    }

    @objid ("045b80f5-bf6e-4155-9ede-614b9639e508")
    protected void registerMetaExpertForPin() {
        // Standard.Pin is abstract

        // -----------

        // no constraint on Pin.Matched : Parameter from Standard.Pin to Standard.Parameter
        this.ruleMetaExpert.addDependencyRule(InputPin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(OutputPin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(Pin.class, null, "Matched");
        this.ruleMetaExpert.addDependencyRule(ValuePin.class, null, "Matched");

    }

    @objid ("7beffc4f-23ff-489b-a2ec-1032e1a54a31")
    protected void registerMetaExpertForInitialNode() {
        // Standard.InitialNode
        // -----------

    }

    @objid ("6e06c4d5-c6ae-46b5-9f5c-7a01ddd60d3b")
    protected void registerMetaExpertForForkJoinNode() {
        // Standard.ForkJoinNode
        // -----------

    }

    @objid ("fed4ae8a-cc38-46f8-a8cd-678cbf187bf4")
    protected void registerMetaExpertForFlowFinalNode() {
        // Standard.FlowFinalNode
        // -----------

    }

    @objid ("0c87f911-867f-4d89-919a-562c5c009840")
    protected void registerMetaExpertForExpansionRegion() {
        // Standard.ExpansionRegion
        // -----------

        // no constraint on ExpansionRegion.OutputElement : ExpansionNode from Standard.ExpansionRegion to Standard.ExpansionNode
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "OutputElement");

        // no constraint on ExpansionRegion.InputElement : ExpansionNode from Standard.ExpansionRegion to Standard.ExpansionNode
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "InputElement");

    }

    @objid ("93d9ffab-03f6-40ae-a7f9-e16846b7af70")
    protected void registerMetaExpertForExpansionNode() {
        // Standard.ExpansionNode
        // -----------

    }

    @objid ("b1dba175-0195-4fa8-a704-9655240a7ab1")
    protected void registerMetaExpertForExceptionHandler() {
        // Standard.ExceptionHandler
        // -----------

        // no constraint on ExceptionHandler.ExceptionInput : InputPin from Standard.ExceptionHandler to Standard.InputPin
        this.ruleMetaExpert.addDependencyRule(ExceptionHandler.class, null, "ExceptionInput");

        // no constraint on ExceptionHandler.ExceptionType : GeneralClass from Standard.ExceptionHandler to Standard.GeneralClass
        this.ruleMetaExpert.addDependencyRule(ExceptionHandler.class, null, "ExceptionType");

    }

    @objid ("fe07e331-14ff-4189-aa63-d29fd22db020")
    protected void registerMetaExpertForDecisionMergeNode() {
        // Standard.DecisionMergeNode
        // -----------

    }

    @objid ("15a66753-b8ee-4376-aaf0-0f0fc2fb478f")
    protected void registerMetaExpertForDataStoreNode() {
        // Standard.DataStoreNode
        // -----------

    }

    @objid ("b3f76306-8f02-49da-a109-0afdd974599c")
    protected void registerMetaExpertForControlFlow() {
        // Standard.ControlFlow
        // -----------

    }

    @objid ("1fcd3f6c-2049-4275-93f2-c9e0b8066fa3")
    protected void registerMetaExpertForConditionalNode() {
        // Standard.ConditionalNode
        // -----------

        // no constraint on ConditionalNode.OwnedClause : Clause from Standard.ConditionalNode to Standard.Clause
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "OwnedClause");

    }

    @objid ("409f80dd-7192-48a1-bf65-5b5164b6eb97")
    protected void registerMetaExpertForStructuredActivityNode() {
        // Standard.StructuredActivityNode
        // -----------

        // no constraint on StructuredActivityNode.Body : ActivityNode from Standard.StructuredActivityNode to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(ConditionalNode.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(ExpansionRegion.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(LoopNode.class, null, "Body");
        this.ruleMetaExpert.addDependencyRule(StructuredActivityNode.class, null, "Body");

    }

    @objid ("38cdcd40-a9c9-4ecb-b176-fa3ad8778021")
    protected void registerMetaExpertForClause() {
        // Standard.Clause
        // -----------

        // no constraint on Clause.Body : ActivityNode from Standard.Clause to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(Clause.class, null, "Body");

    }

    @objid ("3c0236c3-a0a4-45ae-a6b7-120d450a3bee")
    protected void registerMetaExpertForCentralBufferNode() {
        // Standard.CentralBufferNode
        // -----------

    }

    @objid ("b283dd58-79ff-440e-97e6-0c1a5f51cc3f")
    protected void registerMetaExpertForCallOperationAction() {
        // Standard.CallOperationAction
        // -----------

        // no constraint on CallOperationAction.Called : Operation from Standard.CallOperationAction to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(CallOperationAction.class, null, "Called");

    }

    @objid ("73c06ddd-b932-4a3b-a0b6-dc1dd5b73369")
    protected void registerMetaExpertForCallBehaviorAction() {
        // Standard.CallBehaviorAction
        // -----------

        // no constraint on CallBehaviorAction.Called : Behavior from Standard.CallBehaviorAction to Standard.Behavior
        this.ruleMetaExpert.addDependencyRule(CallBehaviorAction.class, null, "Called");

    }

    @objid ("479ae5dc-3544-47ee-a5a9-15f66689d789")
    protected void registerMetaExpertForCallAction() {
        // Standard.CallAction is abstract

        // -----------

    }

    @objid ("b795d525-5701-48c4-9aea-12e994704c21")
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

    @objid ("c3ec751d-31cb-4cd9-8a2e-a5ea3c476a25")
    protected void registerMetaExpertForActivityParameterNode() {
        // Standard.ActivityParameterNode
        // -----------

    }

    @objid ("a64f30e1-de69-4f4c-8947-ac34652f2400")
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

    @objid ("b939a246-d368-4fec-80d0-dfe6d1c7b6f5")
    protected void registerMetaExpertForActivityGroup() {
        // Standard.ActivityGroup is abstract

        // -----------

    }

    @objid ("211ffca2-84a5-4808-b8b6-1d9da9f3ab73")
    protected void registerMetaExpertForActivityFinalNode() {
        // Standard.ActivityFinalNode
        // -----------

    }

    @objid ("d3ce4407-9d40-4f5b-b04e-e833402190aa")
    protected void registerMetaExpertForFinalNode() {
        // Standard.FinalNode is abstract

        // -----------

    }

    @objid ("1473dd2c-18d2-4b48-a09b-e3fafedd9492")
    protected void registerMetaExpertForControlNode() {
        // Standard.ControlNode is abstract

        // -----------

    }

    @objid ("fcf3d0d2-3e71-4779-b1ba-10be298068db")
    protected void registerMetaExpertForActivityEdge() {
        // Standard.ActivityEdge is abstract

        // -----------

        // no constraint on ActivityEdge.Target : ActivityNode from Standard.ActivityEdge to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(ActivityEdge.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(ControlFlow.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(MessageFlow.class, null, "Target");
        this.ruleMetaExpert.addDependencyRule(ObjectFlow.class, null, "Target");

    }

    @objid ("db7975a5-0201-4a14-86fd-72008a6e771c")
    protected void registerMetaExpertForActivity() {
        // Standard.Activity
        // -----------

        // no constraint on Activity.OwnedGroup : ActivityGroup from Standard.Activity to Standard.ActivityGroup
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "OwnedGroup");

        // no constraint on Activity.OwnedNode : ActivityNode from Standard.Activity to Standard.ActivityNode
        this.ruleMetaExpert.addDependencyRule(Activity.class, null, "OwnedNode");

    }

    @objid ("dfa12d43-c553-4af1-8a05-ab8b0282671f")
    protected void registerMetaExpertForAcceptTimeEventAction() {
        // Standard.AcceptTimeEventAction
        // -----------

    }

    @objid ("8e2cec52-6d24-4679-9f92-dcbaa1ef6964")
    protected void registerMetaExpertForAcceptSignalAction() {
        // Standard.AcceptSignalAction
        // -----------

        // no constraint on AcceptSignalAction.Accepted : Signal from Standard.AcceptSignalAction to Standard.Signal
        this.ruleMetaExpert.addDependencyRule(AcceptSignalAction.class, null, "Accepted");

    }

    @objid ("1d65ea10-0dbe-4559-9547-4c59669f06d6")
    protected void registerMetaExpertForAcceptChangeEventAction() {
        // Standard.AcceptChangeEventAction
        // -----------

    }

    @objid ("1b516f07-ca09-40e0-be10-2dadb5c3d7d0")
    protected void registerMetaExpertForAcceptCallEventAction() {
        // Standard.AcceptCallEventAction
        // -----------

        // no constraint on AcceptCallEventAction.Called : Operation from Standard.AcceptCallEventAction to Standard.Operation
        this.ruleMetaExpert.addDependencyRule(AcceptCallEventAction.class, null, "Called");

    }

    @objid ("b2bb7bb2-d016-42a4-8984-b7aa3b45cc2e")
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

    @objid ("bd643b6e-6830-4cf9-829b-d3dac8c568be")
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

    @objid ("36849ef3-4877-4157-ad82-b99eecb72747")
    protected void registerMetaExpertForUseCaseDiagram() {
        // Standard.UseCaseDiagram
        // -----------

    }

    @objid ("7e411d1d-7c60-423f-a76b-91156f945234")
    protected void registerMetaExpertForStateMachineDiagram() {
        // Standard.StateMachineDiagram
        // -----------

    }

    @objid ("ef3e915c-ed73-41c7-b9ab-b9dd7e415e8c")
    protected void registerMetaExpertForSequenceDiagram() {
        // Standard.SequenceDiagram
        // -----------

    }

    @objid ("04521a74-e0fb-4a61-a57f-1a71dc9ae0dd")
    protected void registerMetaExpertForObjectDiagram() {
        // Standard.ObjectDiagram
        // -----------

    }

    @objid ("969860a6-541b-4c0d-963a-3405ed52e3cc")
    protected void registerMetaExpertForDeploymentDiagram() {
        // Standard.DeploymentDiagram
        // -----------

    }

    @objid ("06060067-a0b2-4326-9098-00fb72981b36")
    protected void registerMetaExpertForCompositeStructureDiagram() {
        // Standard.CompositeStructureDiagram
        // -----------

    }

    @objid ("840bed55-e3b6-490a-bf73-ef95b1a7bc09")
    protected void registerMetaExpertForCommunicationDiagram() {
        // Standard.CommunicationDiagram
        // -----------

    }

    @objid ("8d52a518-3bb0-4cfa-9e6f-d1b130050e37")
    protected void registerMetaExpertForClassDiagram() {
        // Standard.ClassDiagram
        // -----------

    }

    @objid ("0ef02ec0-691e-4d6e-890a-07f01328ea5f")
    protected void registerMetaExpertForStaticDiagram() {
        // Standard.StaticDiagram
        // -----------

    }

    @objid ("ac81acf3-f0fb-4f1f-b6a8-ce8f185ac275")
    protected void registerMetaExpertForActivityDiagram() {
        // Standard.ActivityDiagram
        // -----------

    }

    @objid ("637515d2-5335-4b7e-b859-cf4d4642c014")
    protected void registerMetaExpertForBpmnSharedDefinitions() {
        // Standard.BpmnSharedDefinitions
        // -----------

        // no constraint on BpmnSharedDefinitions.RootElement : BpmnSharedElement from Standard.BpmnSharedDefinitions to Standard.BpmnSharedElement
        this.ruleMetaExpert.addDependencyRule(BpmnSharedDefinitions.class, null, "RootElement");

    }

    @objid ("8e5379cb-0c84-4cea-9da5-773a82606665")
    protected void registerMetaExpertForBpmnGroup() {
        // Standard.BpmnGroup
        // -----------

        // no constraint on BpmnGroup.Categorized : BpmnFlowElement from Standard.BpmnGroup to Standard.BpmnFlowElement
        this.ruleMetaExpert.addDependencyRule(BpmnGroup.class, null, "Categorized");

    }

    @objid ("f5608b59-6481-49e9-bd4f-7be481e0c482")
    protected void registerMetaExpertForBpmnAssociation() {
        // Standard.BpmnAssociation
        // -----------

        // no constraint on BpmnAssociation.TargetRef : BpmnBaseElement from Standard.BpmnAssociation to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnAssociation.class, null, "TargetRef");

        // no constraint on BpmnAssociation.SourceRef : BpmnBaseElement from Standard.BpmnAssociation to Standard.BpmnBaseElement
        this.ruleMetaExpert.addDependencyRule(BpmnAssociation.class, null, "SourceRef");

    }

    @objid ("fa703086-05e8-41d0-bfbf-90d2055fe17f")
    protected void registerMetaExpertForBpmnArtifact() {
        // Standard.BpmnArtifact is abstract

        // -----------

    }

    @objid ("62b711fc-1f5a-43e5-8896-f4bea2c95b48")
    protected void registerMetaExpertForBpmnResourceRole() {
        // Standard.BpmnResourceRole
        // -----------

        // no constraint on BpmnResourceRole.ResourceRef : BpmnResource from Standard.BpmnResourceRole to Standard.BpmnResource
        this.ruleMetaExpert.addDependencyRule(BpmnResourceRole.class, null, "ResourceRef");

        // no constraint on BpmnResourceRole.ResourceParameterBinding : BpmnResourceParameterBinding from Standard.BpmnResourceRole to Standard.BpmnResourceParameterBinding
        this.ruleMetaExpert.addDependencyRule(BpmnResourceRole.class, null, "ResourceParameterBinding");

    }

    @objid ("ecb727fe-5ca2-4b60-aede-777d7c3cc6ff")
    protected void registerMetaExpertForBpmnResourceParameterBinding() {
        // Standard.BpmnResourceParameterBinding
        // -----------

        // no constraint on BpmnResourceParameterBinding.ParameterRef : BpmnResourceParameter from Standard.BpmnResourceParameterBinding to Standard.BpmnResourceParameter
        this.ruleMetaExpert.addDependencyRule(BpmnResourceParameterBinding.class, null, "ParameterRef");

    }

    @objid ("bf6ec48d-3520-4788-ba38-bb25df896d60")
    protected void registerMetaExpertForBpmnResourceParameter() {
        // Standard.BpmnResourceParameter
        // -----------

        // no constraint on BpmnResourceParameter.Type : BpmnItemDefinition from Standard.BpmnResourceParameter to Standard.BpmnItemDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnResourceParameter.class, null, "Type");

    }

    @objid ("5f1c9eef-6eae-4c44-899d-b97ce6e85c9d")
    protected void registerMetaExpertForBpmnResource() {
        // Standard.BpmnResource
        // -----------

        // no constraint on BpmnResource.Parameter : BpmnResourceParameter from Standard.BpmnResource to Standard.BpmnResourceParameter
        this.ruleMetaExpert.addDependencyRule(BpmnResource.class, null, "Parameter");

    }

    @objid ("a9edb38d-6890-46cb-a36e-f9de477807b6")
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

    @objid ("e30903f3-710c-44e1-9664-f6218e624ff8")
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

    @objid ("02c3cf14-8469-4511-b37e-fbe6daf5eb9e")
    protected void registerMetaExpertForBpmnLaneSet() {
        // Standard.BpmnLaneSet
        // -----------

        // no constraint on BpmnLaneSet.Lane : BpmnLane from Standard.BpmnLaneSet to Standard.BpmnLane
        this.ruleMetaExpert.addDependencyRule(BpmnLaneSet.class, null, "Lane");

    }

    @objid ("55e418c1-2a40-4f03-a5f5-05318a115513")
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

    @objid ("003c568d-b913-4453-b4d7-13250ce18a94")
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

    @objid ("48fcb5d4-e76c-423e-9d1f-1ece281f1b9c")
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

    @objid ("5cc28709-86f5-4af1-871e-86e2ff42f4d9")
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

    @objid ("c1083120-36f9-4e5e-9c68-7b7d2bde6466")
    protected void registerMetaExpertForBpmnSequenceFlowDataAssociation() {
        // Standard.BpmnSequenceFlowDataAssociation
        // -----------

        // no constraint on BpmnSequenceFlowDataAssociation.Connected : BpmnSequenceFlow from Standard.BpmnSequenceFlowDataAssociation to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlowDataAssociation.class, null, "Connected");

        // no constraint on BpmnSequenceFlowDataAssociation.DataAssociation : BpmnDataAssociation from Standard.BpmnSequenceFlowDataAssociation to Standard.BpmnDataAssociation
        this.ruleMetaExpert.addDependencyRule(BpmnSequenceFlowDataAssociation.class, null, "DataAssociation");

    }

    @objid ("015d874f-b60f-4a94-844d-7f8d3484f70e")
    protected void registerMetaExpertForBpmnItemDefinition() {
        // Standard.BpmnItemDefinition
        // -----------

    }

    @objid ("91e3f016-42bc-4090-8daa-639da070b86c")
    protected void registerMetaExpertForBpmnDataStore() {
        // Standard.BpmnDataStore
        // -----------

    }

    @objid ("182ce913-1e4a-400f-ba55-3308d9921667")
    protected void registerMetaExpertForBpmnDataState() {
        // Standard.BpmnDataState
        // -----------

    }

    @objid ("61e927ab-8f8d-4962-9731-e7c1b4e241fd")
    protected void registerMetaExpertForBpmnDataOutput() {
        // Standard.BpmnDataOutput
        // -----------

    }

    @objid ("2be10df3-7cee-443c-a053-ed45d3aa677f")
    protected void registerMetaExpertForBpmnDataObject() {
        // Standard.BpmnDataObject
        // -----------

    }

    @objid ("362384eb-5a76-4154-a145-f69d4134d904")
    protected void registerMetaExpertForBpmnDataInput() {
        // Standard.BpmnDataInput
        // -----------

    }

    @objid ("13f28f8c-9ded-484e-9a54-7afcd02a13d4")
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

    @objid ("1a84f889-7388-4f1a-84db-1b2d0ca4885b")
    protected void registerMetaExpertForBpmnDataAssociation() {
        // Standard.BpmnDataAssociation
        // -----------

        // no constraint on BpmnDataAssociation.SourceRef : BpmnItemAwareElement from Standard.BpmnDataAssociation to Standard.BpmnItemAwareElement
        this.ruleMetaExpert.addDependencyRule(BpmnDataAssociation.class, null, "SourceRef");

        // no constraint on BpmnDataAssociation.TargetRef : BpmnItemAwareElement from Standard.BpmnDataAssociation to Standard.BpmnItemAwareElement
        this.ruleMetaExpert.addDependencyRule(BpmnDataAssociation.class, null, "TargetRef");

    }

    @objid ("7ed666ba-e56f-4f86-9f01-1afdd47e492a")
    protected void registerMetaExpertForBpmnParallelGateway() {
        // Standard.BpmnParallelGateway
        // -----------

    }

    @objid ("3231f134-0848-4f48-b51d-f41de7810ad8")
    protected void registerMetaExpertForBpmnInclusiveGateway() {
        // Standard.BpmnInclusiveGateway
        // -----------

        // no constraint on BpmnInclusiveGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnInclusiveGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnInclusiveGateway.class, null, "DefaultFlow");

    }

    @objid ("9de8ad4d-86ad-411c-adc8-5f13804c9495")
    protected void registerMetaExpertForBpmnExclusiveGateway() {
        // Standard.BpmnExclusiveGateway
        // -----------

        // no constraint on BpmnExclusiveGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnExclusiveGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnExclusiveGateway.class, null, "DefaultFlow");

    }

    @objid ("82c48890-20e1-493c-91f6-b6d45b1eea33")
    protected void registerMetaExpertForBpmnEventBasedGateway() {
        // Standard.BpmnEventBasedGateway
        // -----------

    }

    @objid ("ee2b471e-13d5-4bc3-91e1-8a31fd06834d")
    protected void registerMetaExpertForBpmnComplexGateway() {
        // Standard.BpmnComplexGateway
        // -----------

        // no constraint on BpmnComplexGateway.DefaultFlow : BpmnSequenceFlow from Standard.BpmnComplexGateway to Standard.BpmnSequenceFlow
        this.ruleMetaExpert.addDependencyRule(BpmnComplexGateway.class, null, "DefaultFlow");

    }

    @objid ("2618d179-753f-4db7-8ee5-0df04fbb593f")
    protected void registerMetaExpertForBpmnGateway() {
        // Standard.BpmnGateway is abstract

        // -----------

    }

    @objid ("1b0228e7-d20b-4995-8e11-2bebe1f23a88")
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

    @objid ("5179af74-529f-44a1-9667-1a9abb4c51fa")
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

    @objid ("eb5f3c86-683c-4d39-98e1-af44d0f43a44")
    protected void registerMetaExpertForBpmnMessage() {
        // Standard.BpmnMessage
        // -----------

        // no constraint on BpmnMessage.ItemRef : BpmnItemDefinition from Standard.BpmnMessage to Standard.BpmnItemDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnMessage.class, null, "ItemRef");

    }

    @objid ("92fba445-ef90-4136-88b0-1b0e7602bbe9")
    protected void registerMetaExpertForBpmnTimerEventDefinition() {
        // Standard.BpmnTimerEventDefinition
        // -----------

    }

    @objid ("9790c89a-0088-4df3-9e60-a29b820c5a62")
    protected void registerMetaExpertForBpmnTerminateEventDefinition() {
        // Standard.BpmnTerminateEventDefinition
        // -----------

    }

    @objid ("7d633b14-0a6f-47d5-8e8e-41a8e1ff6ca0")
    protected void registerMetaExpertForBpmnStartEvent() {
        // Standard.BpmnStartEvent
        // -----------

    }

    @objid ("de2fe860-3f1a-46dd-a9c4-4daf0b21f5a5")
    protected void registerMetaExpertForBpmnSignalEventDefinition() {
        // Standard.BpmnSignalEventDefinition
        // -----------

    }

    @objid ("04503c8b-11de-499a-86e2-3eafd477283d")
    protected void registerMetaExpertForBpmnMessageEventDefinition() {
        // Standard.BpmnMessageEventDefinition
        // -----------

        // no constraint on BpmnMessageEventDefinition.MessageRef : BpmnMessage from Standard.BpmnMessageEventDefinition to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnMessageEventDefinition.class, null, "MessageRef");

        // no constraint on BpmnMessageEventDefinition.OperationRef : BpmnOperation from Standard.BpmnMessageEventDefinition to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnMessageEventDefinition.class, null, "OperationRef");

    }

    @objid ("e0633839-c552-444e-9259-ec0ab68d1488")
    protected void registerMetaExpertForBpmnLinkEventDefinition() {
        // Standard.BpmnLinkEventDefinition
        // -----------

        // no constraint on BpmnLinkEventDefinition.Target : BpmnLinkEventDefinition from Standard.BpmnLinkEventDefinition to Standard.BpmnLinkEventDefinition
        this.ruleMetaExpert.addDependencyRule(BpmnLinkEventDefinition.class, null, "Target");

    }

    @objid ("0ce1223d-960a-4166-ae23-35c8e094d39f")
    protected void registerMetaExpertForBpmnIntermediateThrowEvent() {
        // Standard.BpmnIntermediateThrowEvent
        // -----------

    }

    @objid ("3c23971c-e289-443c-a409-15fe54cd360a")
    protected void registerMetaExpertForBpmnIntermediateCatchEvent() {
        // Standard.BpmnIntermediateCatchEvent
        // -----------

    }

    @objid ("0c87d784-2da7-4fe2-9dff-a1529bcacafb")
    protected void registerMetaExpertForBpmnImplicitThrowEvent() {
        // Standard.BpmnImplicitThrowEvent
        // -----------

    }

    @objid ("79477dec-7117-4ba8-b3fa-aa42eaf14cc2")
    protected void registerMetaExpertForBpmnEscalationEventDefinition() {
        // Standard.BpmnEscalationEventDefinition
        // -----------

    }

    @objid ("425d98c0-ed3d-47bf-939c-be1f95b30490")
    protected void registerMetaExpertForBpmnErrorEventDefinition() {
        // Standard.BpmnErrorEventDefinition
        // -----------

    }

    @objid ("606aa51e-011e-4424-8f2c-5304d829f79c")
    protected void registerMetaExpertForBpmnEndEvent() {
        // Standard.BpmnEndEvent
        // -----------

    }

    @objid ("6da93a54-7e82-4ac7-bfa3-b8ed4d401db5")
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

    @objid ("4478f8a9-72e8-4be8-9636-61c9fdcc6c57")
    protected void registerMetaExpertForBpmnConditionalEventDefinition() {
        // Standard.BpmnConditionalEventDefinition
        // -----------

    }

    @objid ("d1240680-13b6-44b8-aaab-052684d469c5")
    protected void registerMetaExpertForBpmnCompensateEventDefinition() {
        // Standard.BpmnCompensateEventDefinition
        // -----------

        // no constraint on BpmnCompensateEventDefinition.ActivityRef : BpmnActivity from Standard.BpmnCompensateEventDefinition to Standard.BpmnActivity
        this.ruleMetaExpert.addDependencyRule(BpmnCompensateEventDefinition.class, null, "ActivityRef");

    }

    @objid ("78bb86f1-7fc8-4520-8643-159197bbf08d")
    protected void registerMetaExpertForBpmnCancelEventDefinition() {
        // Standard.BpmnCancelEventDefinition
        // -----------

    }

    @objid ("5f0618c1-4aa0-47a6-8fcb-3e073068042f")
    protected void registerMetaExpertForBpmnEventDefinition() {
        // Standard.BpmnEventDefinition is abstract

        // -----------

    }

    @objid ("630fa346-3172-4ebe-ad5f-5f297e07e329")
    protected void registerMetaExpertForBpmnBoundaryEvent() {
        // Standard.BpmnBoundaryEvent
        // -----------

    }

    @objid ("b7f7f75e-e5c7-4154-8d13-4209226ccfa4")
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

    @objid ("ce4539d3-6dc0-4f5f-89c0-5f17b167f3af")
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

    @objid ("a3a7672e-269e-4a96-bb90-2acadbc96079")
    protected void registerMetaExpertForBpmnOperation() {
        // Standard.BpmnOperation
        // -----------

        // no constraint on BpmnOperation.InMessageRef : BpmnMessage from Standard.BpmnOperation to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnOperation.class, null, "InMessageRef");

        // no constraint on BpmnOperation.OutMessageRef : BpmnMessage from Standard.BpmnOperation to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnOperation.class, null, "OutMessageRef");

    }

    @objid ("cec22109-52d4-4a43-a46b-3d58351bebf0")
    protected void registerMetaExpertForBpmnInterface() {
        // Standard.BpmnInterface
        // -----------

        // no constraint on BpmnInterface.Operation : BpmnOperation from Standard.BpmnInterface to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnInterface.class, null, "Operation");

    }

    @objid ("296abb9c-60f2-4501-9805-ba9676b32b65")
    protected void registerMetaExpertForBpmnEndPoint() {
        // Standard.BpmnEndPoint
        // -----------

    }

    @objid ("595d94c1-fc2b-4cbd-9dd3-89b8fdc3314d")
    protected void registerMetaExpertForBpmnSharedElement() {
        // Standard.BpmnSharedElement is abstract

        // -----------

    }

    @objid ("daa0868e-78ec-46ba-9434-91f0fca2211c")
    protected void registerMetaExpertForBpmnCollaborationDiagram() {
        // Standard.BpmnCollaborationDiagram
        // -----------

    }

    @objid ("8765415b-3485-4c32-b8d1-09e07d81ae7a")
    protected void registerMetaExpertForBpmnProcessDesignDiagram() {
        // Standard.BpmnProcessDesignDiagram
        // -----------

    }

    @objid ("e3f8a8ce-3fdf-4b05-90ea-45d94eb7bce7")
    protected void registerMetaExpertForBpmnSubProcessDiagram() {
        // Standard.BpmnSubProcessDiagram
        // -----------

    }

    @objid ("3dfa3958-9c66-4e2c-a61f-7bb4a5602020")
    protected void registerMetaExpertForBpmnProcessCollaborationDiagram() {
        // Standard.BpmnProcessCollaborationDiagram is abstract

        // -----------

    }

    @objid ("dd0179a5-faef-46b1-8e78-9835a2240d22")
    protected void registerMetaExpertForBehaviorDiagram() {
        // Standard.BehaviorDiagram is abstract

        // -----------

    }

    @objid ("4dc917e8-82d3-4caa-9c23-891b12c165db")
    protected void registerMetaExpertForBpmnUserTask() {
        // Standard.BpmnUserTask
        // -----------

    }

    @objid ("3731d2ba-cf8b-4327-90e2-36b5d5f350d1")
    protected void registerMetaExpertForBpmnTransaction() {
        // Standard.BpmnTransaction
        // -----------

    }

    @objid ("ccd29dc3-3c4e-4ccc-b535-50f6ee75f8fc")
    protected void registerMetaExpertForBpmnStandardLoopCharacteristics() {
        // Standard.BpmnStandardLoopCharacteristics
        // -----------

    }

    @objid ("1255d41b-b55a-4619-b2aa-932e736bdefa")
    protected void registerMetaExpertForBpmnServiceTask() {
        // Standard.BpmnServiceTask
        // -----------

        // no constraint on BpmnServiceTask.OperationRef : BpmnOperation from Standard.BpmnServiceTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnServiceTask.class, null, "OperationRef");

    }

    @objid ("af553aeb-a687-47f7-bcc1-c99f85f7a961")
    protected void registerMetaExpertForBpmnSendTask() {
        // Standard.BpmnSendTask
        // -----------

        // no constraint on BpmnSendTask.MessageRef : BpmnMessage from Standard.BpmnSendTask to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "MessageRef");

        // no constraint on BpmnSendTask.OperationRef : BpmnOperation from Standard.BpmnSendTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnSendTask.class, null, "OperationRef");

    }

    @objid ("9521a8b4-4416-45f4-a661-8ac0a5ae6637")
    protected void registerMetaExpertForBpmnScriptTask() {
        // Standard.BpmnScriptTask
        // -----------

    }

    @objid ("b742fe66-69cb-4f53-a359-299f27d20c47")
    protected void registerMetaExpertForBpmnReceiveTask() {
        // Standard.BpmnReceiveTask
        // -----------

        // no constraint on BpmnReceiveTask.MessageRef : BpmnMessage from Standard.BpmnReceiveTask to Standard.BpmnMessage
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "MessageRef");

        // no constraint on BpmnReceiveTask.OperationRef : BpmnOperation from Standard.BpmnReceiveTask to Standard.BpmnOperation
        this.ruleMetaExpert.addDependencyRule(BpmnReceiveTask.class, null, "OperationRef");

    }

    @objid ("a791f6e2-cb38-4c37-9720-989f5415ce21")
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

    @objid ("62c7bc4b-0ad2-4e4f-9f6f-0ddb299b59f8")
    protected void registerMetaExpertForBpmnManualTask() {
        // Standard.BpmnManualTask
        // -----------

    }

    @objid ("77b0ed61-6972-4a97-a6d9-8b1be665022b")
    protected void registerMetaExpertForBpmnLoopCharacteristics() {
        // Standard.BpmnLoopCharacteristics is abstract

        // -----------

    }

    @objid ("9d05d3ef-6c5b-414f-ba12-8c7849b4939b")
    protected void registerMetaExpertForBpmnComplexBehaviorDefinition() {
        // Standard.BpmnComplexBehaviorDefinition
        // -----------

        // no constraint on BpmnComplexBehaviorDefinition.Event : BpmnImplicitThrowEvent from Standard.BpmnComplexBehaviorDefinition to Standard.BpmnImplicitThrowEvent
        this.ruleMetaExpert.addDependencyRule(BpmnComplexBehaviorDefinition.class, null, "Event");

    }

    @objid ("ccb22fd6-e887-4f12-9289-77df9283a2ad")
    protected void registerMetaExpertForBpmnCallActivity() {
        // Standard.BpmnCallActivity
        // -----------

        // no constraint on BpmnCallActivity.CalledGlobalTask : BpmnTask from Standard.BpmnCallActivity to Standard.BpmnTask
        this.ruleMetaExpert.addDependencyRule(BpmnCallActivity.class, null, "CalledGlobalTask");

    }

    @objid ("2e036224-3ba1-41fc-a193-9c143c8d6217")
    protected void registerMetaExpertForBpmnBusinessRuleTask() {
        // Standard.BpmnBusinessRuleTask
        // -----------

    }

    @objid ("b2766562-c31a-4279-b550-9f7e920c9025")
    protected void registerMetaExpertForBpmnTask() {
        // Standard.BpmnTask
        // -----------

    }

    @objid ("ca7019fc-1bf2-44ff-a475-9a058ccc1308")
    protected void registerMetaExpertForBpmnAdHocSubProcess() {
        // Standard.BpmnAdHocSubProcess
        // -----------

    }

    @objid ("da82baaa-60a2-4526-b0be-805369ea4224")
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

    @objid ("f9adf8b9-ea9c-48dc-ac20-201f50b00299")
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

    @objid ("06b35565-dde0-4e8b-b9e1-d750dd8d4acf")
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

    @objid ("56a58f37-402e-4bc5-8de5-ad6587327799")
    protected void registerMetaExpertForBpmnFlowElement() {
        // Standard.BpmnFlowElement is abstract

        // -----------

    }

    @objid ("52d68179-1324-400e-8d13-734594bfc4a9")
    protected void registerMetaExpertForBpmnBaseElement() {
        // Standard.BpmnBaseElement is abstract

        // -----------

    }

}
