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
package org.modelio.metamodel.visitors;

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
import org.modelio.vcore.smkernel.mapi.MVisitor;

@objid ("000a4862-4f2c-1032-829a-001ec947cd2a")
public interface IModelVisitor extends MVisitor {
    @objid ("dfbb6dcf-e5e9-4b63-8122-649456b52a9d")
    abstract Object visitAbstractPseudoState(AbstractPseudoState obj);

    @objid ("f7023bd6-3cd0-473b-affb-c8b392bc1759")
    abstract Object visitAbstraction(Abstraction obj);

    @objid ("879d427e-076d-4928-9978-8f8da9417c3d")
    abstract Object visitAcceptCallEventAction(AcceptCallEventAction obj);

    @objid ("fa0ddf34-da4d-46eb-ab13-3ce2a223dd2a")
    abstract Object visitAcceptChangeEventAction(AcceptChangeEventAction obj);

    @objid ("fffab72b-02a6-4dd7-aee7-5edecb873344")
    abstract Object visitAcceptSignalAction(AcceptSignalAction obj);

    @objid ("ebc56479-e80d-4035-b915-2748df6f1b32")
    abstract Object visitAcceptTimeEventAction(AcceptTimeEventAction obj);

    @objid ("b2951038-8558-4300-a288-1c43fcb00c25")
    abstract Object visitActivity(Activity obj);

    @objid ("43f144bd-62bf-4b01-98fc-b5de0edf506b")
    abstract Object visitActivityAction(ActivityAction obj);

    @objid ("db88a0ee-795a-453a-ae85-e112bb9f2730")
    abstract Object visitActivityDiagram(ActivityDiagram obj);

    @objid ("539f890e-dd39-4a46-9724-e9e52a62291a")
    abstract Object visitActivityEdge(ActivityEdge obj);

    @objid ("8a5a72f4-3a29-4208-a486-1d50a490efe9")
    abstract Object visitActivityFinalNode(ActivityFinalNode obj);

    @objid ("bf2b4473-69ca-4e8e-a5c7-b17db2e1cf51")
    abstract Object visitActivityGroup(ActivityGroup obj);

    @objid ("4a7089bd-7365-410c-af0a-f03e995083ff")
    abstract Object visitActivityNode(ActivityNode obj);

    @objid ("4d97d6f5-8301-4069-92b7-ffc9951275a5")
    abstract Object visitActivityParameterNode(ActivityParameterNode obj);

    @objid ("496fb845-0b56-4298-a48d-9efd5e9db390")
    abstract Object visitActivityPartition(ActivityPartition obj);

    @objid ("183406fe-f894-4009-8fab-2b53be03ffc8")
    abstract Object visitActor(Actor obj);

    @objid ("1923904d-7c85-4ff3-afb9-b65d9daddf41")
    abstract Object visitArtifact(Artifact obj);

    @objid ("773a2052-b8de-4568-b5c6-a0f132125761")
    abstract Object visitAssociation(Association obj);

    @objid ("c016c0aa-be3c-4b94-84a5-085a436c5702")
    abstract Object visitAssociationEnd(AssociationEnd obj);

    @objid ("ac07132d-a238-45e2-a460-ef913d2101a6")
    abstract Object visitAttribute(Attribute obj);

    @objid ("eb969955-02f4-43ce-94a9-e3029418086a")
    abstract Object visitAttributeLink(AttributeLink obj);

    @objid ("92060c10-65c4-4dda-9b00-f72f75f6cf9f")
    abstract Object visitBehavior(Behavior obj);

    @objid ("0423fe62-197f-4f93-9f7e-1a579a5b72c9")
    abstract Object visitBehaviorDiagram(BehaviorDiagram obj);

    @objid ("c62c8aff-3f39-4d0c-9ed1-06239a2a8736")
    abstract Object visitBehaviorParameter(BehaviorParameter obj);

    @objid ("414f297a-b5bc-4bcc-9037-1b4a53ca1f8a")
    abstract Object visitBehavioralFeature(BehavioralFeature obj);

    @objid ("8852f5f1-308a-4aa9-9876-bd03ab5499a7")
    abstract Object visitBindableInstance(BindableInstance obj);

    @objid ("133b7ddf-4d08-4d80-bba6-25e447830927")
    abstract Object visitBinding(Binding obj);

    @objid ("1630e95e-88f7-4e55-a563-98a158c8ccaf")
    abstract Object visitBpmnActivity(BpmnActivity obj);

    @objid ("4d7de97c-50c7-478f-b162-97cc4a3ff001")
    abstract Object visitBpmnAdHocSubProcess(BpmnAdHocSubProcess obj);

    @objid ("213f14a4-3ee8-4ce1-9118-27f39a03e1af")
    abstract Object visitBpmnArtifact(BpmnArtifact obj);

    @objid ("ee4ee326-9af7-4b23-9d16-485939be3a26")
    abstract Object visitBpmnAssociation(BpmnAssociation obj);

    @objid ("6e2769d6-45dd-416f-abc0-465308da01f0")
    abstract Object visitBpmnBaseElement(BpmnBaseElement obj);

    @objid ("9edf6a0e-06d4-421f-a6f6-5b1bab00245a")
    abstract Object visitBpmnBoundaryEvent(BpmnBoundaryEvent obj);

    @objid ("16041975-cc10-4125-b092-646d3e86fcf7")
    abstract Object visitBpmnBusinessRuleTask(BpmnBusinessRuleTask obj);

    @objid ("bb79f596-5c6a-4825-ac7b-729277ee0bd0")
    abstract Object visitBpmnCallActivity(BpmnCallActivity obj);

    @objid ("10834f1e-baf4-4eb8-a234-7f9f8457e7fb")
    abstract Object visitBpmnCancelEventDefinition(BpmnCancelEventDefinition obj);

    @objid ("9986d500-5bf6-4ce1-b6ce-35f78bcff7c2")
    abstract Object visitBpmnCatchEvent(BpmnCatchEvent obj);

    @objid ("43a59686-90e2-40a6-9204-2c4e9d17e980")
    abstract Object visitBpmnCollaboration(BpmnCollaboration obj);

    @objid ("40e62556-7848-47c2-aa7b-abaa42de1b10")
    abstract Object visitBpmnCollaborationDiagram(BpmnCollaborationDiagram obj);

    @objid ("903a49a8-37ce-4299-9472-110402e064eb")
    abstract Object visitBpmnCompensateEventDefinition(BpmnCompensateEventDefinition obj);

    @objid ("32829edb-6597-455c-8607-a6a62beab746")
    abstract Object visitBpmnComplexBehaviorDefinition(BpmnComplexBehaviorDefinition obj);

    @objid ("c4f1f4a6-e9c9-4b98-b939-93e04fe7988a")
    abstract Object visitBpmnComplexGateway(BpmnComplexGateway obj);

    @objid ("d5ac7447-9d76-4275-b1a6-90414ab2dc5e")
    abstract Object visitBpmnConditionalEventDefinition(BpmnConditionalEventDefinition obj);

    @objid ("0f70a91e-b5ce-47fb-acf0-c98edb4746f7")
    abstract Object visitBpmnDataAssociation(BpmnDataAssociation obj);

    @objid ("81d3603b-f15c-4672-97b3-3bb255e1622c")
    abstract Object visitBpmnDataInput(BpmnDataInput obj);

    @objid ("4e3be1a2-b831-4ab4-91d9-5ce2d1a60d66")
    abstract Object visitBpmnDataObject(BpmnDataObject obj);

    @objid ("233ae0d7-56c1-4860-a987-508372243c0b")
    abstract Object visitBpmnDataOutput(BpmnDataOutput obj);

    @objid ("2640d91b-f222-4d75-8f70-f8ae4cda57f7")
    abstract Object visitBpmnDataState(BpmnDataState obj);

    @objid ("3e46cb2c-84e6-4410-aa6c-c220f6851f54")
    abstract Object visitBpmnDataStore(BpmnDataStore obj);

    @objid ("238303a8-2460-47a9-9726-0e2698ae914f")
    abstract Object visitBpmnEndEvent(BpmnEndEvent obj);

    @objid ("7565a597-5e37-4168-bbc1-c259e89c6ffd")
    abstract Object visitBpmnEndPoint(BpmnEndPoint obj);

    @objid ("f7d4ac7b-0218-4d9f-b7f0-5aa81f702f53")
    abstract Object visitBpmnErrorEventDefinition(BpmnErrorEventDefinition obj);

    @objid ("0d349ac9-93dd-40ec-8004-370181ec84f5")
    abstract Object visitBpmnEscalationEventDefinition(BpmnEscalationEventDefinition obj);

    @objid ("55291cd1-bf9a-4b0b-af58-8d55038c7edd")
    abstract Object visitBpmnEvent(BpmnEvent obj);

    @objid ("f7a3dad5-7299-48f8-af42-d8618f5e3281")
    abstract Object visitBpmnEventBasedGateway(BpmnEventBasedGateway obj);

    @objid ("94c9f595-6732-48d7-9465-7234a640d9a5")
    abstract Object visitBpmnEventDefinition(BpmnEventDefinition obj);

    @objid ("9258748e-ca1e-43c1-ada3-cf0df615ed75")
    abstract Object visitBpmnExclusiveGateway(BpmnExclusiveGateway obj);

    @objid ("d251e187-cf16-4029-b0ed-0a622188e8ed")
    abstract Object visitBpmnFlowElement(BpmnFlowElement obj);

    @objid ("8ca6785e-5b07-4dd1-8001-ef7a3e9acd1a")
    abstract Object visitBpmnFlowNode(BpmnFlowNode obj);

    @objid ("c6f375fa-d908-4fac-adac-ddb86f9198ef")
    abstract Object visitBpmnGateway(BpmnGateway obj);

    @objid ("c8d0789b-5a8b-45db-aceb-96b1ebc0e7a4")
    abstract Object visitBpmnGroup(BpmnGroup obj);

    @objid ("beddb73c-9aa4-4ce7-8745-7db71788b6eb")
    abstract Object visitBpmnImplicitThrowEvent(BpmnImplicitThrowEvent obj);

    @objid ("c0fb3ff5-3b41-40b0-88a7-507d3a49ad9b")
    abstract Object visitBpmnInclusiveGateway(BpmnInclusiveGateway obj);

    @objid ("0803a74a-fc7e-4795-b0dc-eb78ca1bde10")
    abstract Object visitBpmnInterface(BpmnInterface obj);

    @objid ("30e6e6ad-fda1-4e0e-ac51-831e5ecd2bd5")
    abstract Object visitBpmnIntermediateCatchEvent(BpmnIntermediateCatchEvent obj);

    @objid ("6986db08-7ba3-4863-a660-43ccd5e51802")
    abstract Object visitBpmnIntermediateThrowEvent(BpmnIntermediateThrowEvent obj);

    @objid ("9bbf7797-f80c-4794-bf15-556661955008")
    abstract Object visitBpmnItemAwareElement(BpmnItemAwareElement obj);

    @objid ("0a33d691-48b2-408d-8934-75be8716083b")
    abstract Object visitBpmnItemDefinition(BpmnItemDefinition obj);

    @objid ("8b735362-d506-4bcf-8f20-9912c729b9bd")
    abstract Object visitBpmnLane(BpmnLane obj);

    @objid ("14c2137a-d2a8-4382-804f-74cc0b89d6dd")
    abstract Object visitBpmnLaneSet(BpmnLaneSet obj);

    @objid ("c9360a02-3ddb-4219-b6b8-c049840a8066")
    abstract Object visitBpmnLinkEventDefinition(BpmnLinkEventDefinition obj);

    @objid ("c8572c3d-6bcc-482c-959b-28fdbabad3cd")
    abstract Object visitBpmnLoopCharacteristics(BpmnLoopCharacteristics obj);

    @objid ("f07c6989-c606-4a3d-8059-6f76d0845b8e")
    abstract Object visitBpmnManualTask(BpmnManualTask obj);

    @objid ("0b3188a6-f79b-4409-8c9e-debbdb865b5e")
    abstract Object visitBpmnMessage(BpmnMessage obj);

    @objid ("ab330a66-db5a-4da8-a167-5e6cc81f4890")
    abstract Object visitBpmnMessageEventDefinition(BpmnMessageEventDefinition obj);

    @objid ("08fb4c8b-a56d-47a1-bfe9-d95fee29f5e9")
    abstract Object visitBpmnMessageFlow(BpmnMessageFlow obj);

    @objid ("9354c996-8178-4361-a1dc-a74d7a2caa10")
    abstract Object visitBpmnMultiInstanceLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics obj);

    @objid ("9ab8c296-a2ec-4077-9a33-c7cd10f2fff4")
    abstract Object visitBpmnOperation(BpmnOperation obj);

    @objid ("82431610-b615-4acf-af6f-70de8ba3aa3b")
    abstract Object visitBpmnParallelGateway(BpmnParallelGateway obj);

    @objid ("4bcb7610-62a6-473a-9c0a-d80f62a4d449")
    abstract Object visitBpmnParticipant(BpmnParticipant obj);

    @objid ("04309a90-27dc-43cc-bfc1-765fae7defd4")
    abstract Object visitBpmnProcess(BpmnProcess obj);

    @objid ("d8beebce-ca43-45d4-ae2e-82704fd858a2")
    abstract Object visitBpmnProcessCollaborationDiagram(BpmnProcessCollaborationDiagram obj);

    @objid ("fc313d39-1d48-461c-8634-e6ad7c0e3a08")
    abstract Object visitBpmnProcessDesignDiagram(BpmnProcessDesignDiagram obj);

    @objid ("50ee0833-502c-4243-a5f5-284c43f45ccc")
    abstract Object visitBpmnReceiveTask(BpmnReceiveTask obj);

    @objid ("8d31638c-de71-4521-bc0f-403d00140f55")
    abstract Object visitBpmnResource(BpmnResource obj);

    @objid ("c3a4493d-8d15-4d38-8461-e1f45e76f61c")
    abstract Object visitBpmnResourceParameter(BpmnResourceParameter obj);

    @objid ("77c5aa92-393c-4882-a49a-8f6b6616ebb2")
    abstract Object visitBpmnResourceParameterBinding(BpmnResourceParameterBinding obj);

    @objid ("8ebf0eb7-b9ca-4636-b8d7-80f32d084ca2")
    abstract Object visitBpmnResourceRole(BpmnResourceRole obj);

    @objid ("6deac0d9-ecd6-4bef-afc2-1681ea4d5db4")
    abstract Object visitBpmnScriptTask(BpmnScriptTask obj);

    @objid ("1fecba3e-4dbf-468c-b2bc-701d6742280d")
    abstract Object visitBpmnSendTask(BpmnSendTask obj);

    @objid ("bb621cf6-36e5-49c6-89b9-dc3f9784f543")
    abstract Object visitBpmnSequenceFlow(BpmnSequenceFlow obj);

    @objid ("13d0880c-8009-4e84-9744-e697b0591a94")
    abstract Object visitBpmnSequenceFlowDataAssociation(BpmnSequenceFlowDataAssociation obj);

    @objid ("11b31e8e-247a-4600-acf3-d177d53afed5")
    abstract Object visitBpmnServiceTask(BpmnServiceTask obj);

    @objid ("2b099866-a7bd-4347-8fa6-64a98856935f")
    abstract Object visitBpmnSharedDefinitions(BpmnSharedDefinitions obj);

    @objid ("2eb35d31-be67-4f96-8b1f-84d97baa5db6")
    abstract Object visitBpmnSharedElement(BpmnSharedElement obj);

    @objid ("abbad5a5-eea7-45c9-9ca4-e1ecd911aac8")
    abstract Object visitBpmnSignalEventDefinition(BpmnSignalEventDefinition obj);

    @objid ("1c8d7fa3-6a5d-4eef-95dd-24dc9a18dc6a")
    abstract Object visitBpmnStandardLoopCharacteristics(BpmnStandardLoopCharacteristics obj);

    @objid ("55c70830-a6b8-4f2f-b216-2fb2bb9577ec")
    abstract Object visitBpmnStartEvent(BpmnStartEvent obj);

    @objid ("840ce414-31cd-4ff0-8ba2-0918b1bd97af")
    abstract Object visitBpmnSubProcess(BpmnSubProcess obj);

    @objid ("637658de-7d3d-4021-9627-e84ef404e9f5")
    abstract Object visitBpmnSubProcessDiagram(BpmnSubProcessDiagram obj);

    @objid ("e377ee27-362f-4497-9e97-4c76d02d88a5")
    abstract Object visitBpmnTask(BpmnTask obj);

    @objid ("48dbd783-8703-422c-b337-aeb51de839ea")
    abstract Object visitBpmnTerminateEventDefinition(BpmnTerminateEventDefinition obj);

    @objid ("1bbddb5c-2865-4242-9e28-2ef131e81f96")
    abstract Object visitBpmnThrowEvent(BpmnThrowEvent obj);

    @objid ("94c1bb8a-c849-4420-aa87-12eba208a721")
    abstract Object visitBpmnTimerEventDefinition(BpmnTimerEventDefinition obj);

    @objid ("7f6a313f-57d3-4d76-8dd1-ce5b2b0ce3f2")
    abstract Object visitBpmnTransaction(BpmnTransaction obj);

    @objid ("2fc259b7-7942-40c1-9857-c7d79c9d3043")
    abstract Object visitBpmnUserTask(BpmnUserTask obj);

    @objid ("3b3a5ff6-6f37-43d4-aec2-08166f15b116")
    abstract Object visitCallAction(CallAction obj);

    @objid ("4b4f5b67-f8a2-4595-aabb-b3a268bab925")
    abstract Object visitCallBehaviorAction(CallBehaviorAction obj);

    @objid ("aefce9e4-affe-47ad-8da5-386c2655a193")
    abstract Object visitCallOperationAction(CallOperationAction obj);

    @objid ("10bbf9f0-24ed-4014-a8ad-744f9d92af03")
    abstract Object visitCentralBufferNode(CentralBufferNode obj);

    @objid ("715670df-f9fb-4972-a036-159e41b62d09")
    abstract Object visitChoicePseudoState(ChoicePseudoState obj);

    @objid ("cb9f9ee0-a4ca-49a5-b6c7-65fa070f5ed8")
    abstract Object visitClass(Class obj);

    @objid ("2d604ffe-f53f-4a0e-a47b-8a10dfd69139")
    abstract Object visitClassAssociation(ClassAssociation obj);

    @objid ("f16db245-77d2-4e35-a6f1-bc6fa8e0ed5a")
    abstract Object visitClassDiagram(ClassDiagram obj);

    @objid ("a45e3200-144d-4a5e-b5a4-55e3189a8049")
    abstract Object visitClassifier(Classifier obj);

    @objid ("37a5603f-925b-4ddc-884f-4c7ca59dc1c1")
    abstract Object visitClause(Clause obj);

    @objid ("6a57a0f9-c0e6-4610-a63f-a9a4dc2b69f9")
    abstract Object visitCollaboration(Collaboration obj);

    @objid ("89405370-64c0-4dc8-820a-db5fb9aaf840")
    abstract Object visitCollaborationUse(CollaborationUse obj);

    @objid ("46c418d0-fddb-4407-83be-7b950d26fac2")
    abstract Object visitCombinedFragment(CombinedFragment obj);

    @objid ("29037e9b-861e-45ec-b124-0e2786e72c18")
    abstract Object visitCommunicationChannel(CommunicationChannel obj);

    @objid ("4c24fe45-084e-4e65-965d-cfe47c090a06")
    abstract Object visitCommunicationDiagram(CommunicationDiagram obj);

    @objid ("43c59e02-708b-42d4-8ed9-6f9f17cf92af")
    abstract Object visitCommunicationInteraction(CommunicationInteraction obj);

    @objid ("d639c1b4-10e3-486a-b759-312c0babfef6")
    abstract Object visitCommunicationMessage(CommunicationMessage obj);

    @objid ("c761937e-69db-47f6-a7ec-a25fcbba5780")
    abstract Object visitCommunicationNode(CommunicationNode obj);

    @objid ("4694804c-cd78-4e8f-ac3d-971ef1c9c454")
    abstract Object visitComponent(Component obj);

    @objid ("e5f2a653-a49a-48b0-9df6-add0e5fd2ba9")
    abstract Object visitComponentRealization(ComponentRealization obj);

    @objid ("82b2e325-c76d-4b74-baa4-81fa6f699375")
    abstract Object visitCompositeStructureDiagram(CompositeStructureDiagram obj);

    @objid ("7fd57350-ac89-4ad9-aca5-6c12e486844f")
    abstract Object visitConditionalNode(ConditionalNode obj);

    @objid ("e7d0fac0-5799-429f-9ae9-8657ee915226")
    abstract Object visitConnectionPointReference(ConnectionPointReference obj);

    @objid ("a2511371-353a-4888-969d-60f347681f0a")
    abstract Object visitConnector(Connector obj);

    @objid ("a60c34b1-e9fd-4e38-96f2-142a85b37f06")
    abstract Object visitConnectorEnd(ConnectorEnd obj);

    @objid ("9f7aa0f1-6c65-492f-abfc-2414576e8519")
    abstract Object visitConstraint(Constraint obj);

    @objid ("3cfcf10c-b7f7-40b0-8858-161009a10cc3")
    abstract Object visitControlFlow(ControlFlow obj);

    @objid ("4cfd1c1b-c890-4802-9fc9-544d46287313")
    abstract Object visitControlNode(ControlNode obj);

    @objid ("b2e20ce8-9885-43a3-87f1-db6ab63751fa")
    abstract Object visitDataFlow(DataFlow obj);

    @objid ("a1c45d9a-db31-4c2d-aa33-df7d6e2fc812")
    abstract Object visitDataStoreNode(DataStoreNode obj);

    @objid ("ab0518a0-a1b7-4a5f-a467-ba9868221773")
    abstract Object visitDataType(DataType obj);

    @objid ("ace072f8-6403-4f4b-9984-052abe4f51fa")
    abstract Object visitDecisionMergeNode(DecisionMergeNode obj);

    @objid ("f42cc649-eb81-46c3-a065-65f291259a27")
    abstract Object visitDeepHistoryPseudoState(DeepHistoryPseudoState obj);

    @objid ("293dcbc9-8e25-4ddd-8e6b-16843d9a492a")
    abstract Object visitDeploymentDiagram(DeploymentDiagram obj);

    @objid ("55dbc3aa-90e6-47a2-a60e-193b0460d5dc")
    abstract Object visitDurationConstraint(DurationConstraint obj);

    @objid ("ce0994d2-2395-4dd3-8292-32c316ce971b")
    abstract Object visitElementImport(ElementImport obj);

    @objid ("f47efc2d-30e7-47ed-948f-af00f5953ea7")
    abstract Object visitElementRealization(ElementRealization obj);

    @objid ("14ce9ac1-19e4-4e07-9ef5-440b0c4965ac")
    abstract Object visitEntryPointPseudoState(EntryPointPseudoState obj);

    @objid ("b0b00ea6-33ff-46b5-ba8e-e562eaa3a43d")
    abstract Object visitEnumeration(Enumeration obj);

    @objid ("acced8d8-ab1f-47c2-ba5b-df5a4ccefc92")
    abstract Object visitEnumerationLiteral(EnumerationLiteral obj);

    @objid ("fb57c5d4-e003-4e9f-a159-b9ef10f07f0f")
    abstract Object visitEvent(Event obj);

    @objid ("fe4e0283-ccd1-4c33-8bef-1e5722bee80c")
    abstract Object visitExceptionHandler(ExceptionHandler obj);

    @objid ("040cb9e2-7359-48cd-9fda-9884307b2578")
    abstract Object visitExecutionOccurenceSpecification(ExecutionOccurenceSpecification obj);

    @objid ("a5779338-1213-4725-8c61-586b6edc5eef")
    abstract Object visitExecutionSpecification(ExecutionSpecification obj);

    @objid ("5b2448d1-754f-4f94-9341-89aa756d966b")
    abstract Object visitExitPointPseudoState(ExitPointPseudoState obj);

    @objid ("77c6716d-c833-468b-8b58-9845e320afa3")
    abstract Object visitExpansionNode(ExpansionNode obj);

    @objid ("8b3c8909-834c-4f3d-8711-40d873d2f026")
    abstract Object visitExpansionRegion(ExpansionRegion obj);

    @objid ("17ec0c89-cfd0-4d38-908b-f4c497ae61ec")
    abstract Object visitExtensionPoint(ExtensionPoint obj);

    @objid ("c24ff922-2c6e-4ff5-8485-4f9f37ddbc36")
    abstract Object visitFeature(Feature obj);

    @objid ("87bde088-ef28-479a-994e-1c67720ead4d")
    abstract Object visitFinalNode(FinalNode obj);

    @objid ("ee9e0cbe-f101-4a32-b0e7-aeac5183dda6")
    abstract Object visitFinalState(FinalState obj);

    @objid ("6a201068-532b-48a0-8d36-6f3e8bd1f39f")
    abstract Object visitFlowFinalNode(FlowFinalNode obj);

    @objid ("5ce11b54-ff5b-4824-a655-b43e891c02b6")
    abstract Object visitForkJoinNode(ForkJoinNode obj);

    @objid ("c10c2036-8d46-4aec-853b-e1162caab76b")
    abstract Object visitForkPseudoState(ForkPseudoState obj);

    @objid ("df2d1d08-1244-4e52-8b49-6819fa9707a2")
    abstract Object visitGate(Gate obj);

    @objid ("8786cf30-1cb6-4fd4-948e-9f3c5c42cfdb")
    abstract Object visitGeneralClass(GeneralClass obj);

    @objid ("ec293643-2b13-4816-bf94-b0a93b390959")
    abstract Object visitGeneralOrdering(GeneralOrdering obj);

    @objid ("f91d09cd-030c-429c-89d0-3961534809cf")
    abstract Object visitGeneralization(Generalization obj);

    @objid ("3fc06cc2-af02-4449-87bf-ed3c6962ec7c")
    abstract Object visitInformationFlow(InformationFlow obj);

    @objid ("e87aaa08-8393-4a93-be18-437e5a2833b7")
    abstract Object visitInformationItem(InformationItem obj);

    @objid ("59be7471-8fcc-4d6b-9c25-136131b34ffb")
    abstract Object visitInitialNode(InitialNode obj);

    @objid ("91119348-c6cf-4851-8e92-343bddef760e")
    abstract Object visitInitialPseudoState(InitialPseudoState obj);

    @objid ("a2378a08-f2b8-464b-9d49-258396287321")
    abstract Object visitInputPin(InputPin obj);

    @objid ("eb878616-1e6b-4ab3-9dee-3da0e930b188")
    abstract Object visitInstance(Instance obj);

    @objid ("ee4a6ec9-d3b1-41f2-a012-f5dcf8400bfc")
    abstract Object visitInstanceNode(InstanceNode obj);

    @objid ("ed24063b-3044-4519-9823-fd62edf05c65")
    abstract Object visitInteraction(Interaction obj);

    @objid ("056bdfaa-5c05-4833-984d-a7be3d92dfe2")
    abstract Object visitInteractionFragment(InteractionFragment obj);

    @objid ("b7d4b679-7ad8-41c5-a4d7-d44fa9ee148c")
    abstract Object visitInteractionOperand(InteractionOperand obj);

    @objid ("78c8a5f6-5efd-4463-9df1-e548dae1220b")
    abstract Object visitInteractionUse(InteractionUse obj);

    @objid ("a7ad8eb9-fee1-4248-8cb0-0174c4859d85")
    abstract Object visitInterface(Interface obj);

    @objid ("9aa1cb6b-2ad8-44e3-84ca-8f57c9b518a9")
    abstract Object visitInterfaceRealization(InterfaceRealization obj);

    @objid ("e0bdf5dd-f72d-496c-82f3-a559abc7ac1f")
    abstract Object visitInternalTransition(InternalTransition obj);

    @objid ("e8ddbf03-5c38-4bbc-8978-f78ec1f6e5cd")
    abstract Object visitInterruptibleActivityRegion(InterruptibleActivityRegion obj);

    @objid ("0593befa-34d9-486a-96e4-97cbd92392e0")
    abstract Object visitJoinPseudoState(JoinPseudoState obj);

    @objid ("89709607-1446-465d-b2a6-58f8fdefdd42")
    abstract Object visitJunctionPseudoState(JunctionPseudoState obj);

    @objid ("bf57d772-c17c-407e-80ab-8aaedc7b375c")
    abstract Object visitLifeline(Lifeline obj);

    @objid ("d0f4722c-be3e-4011-86c1-6b1b6ca414db")
    abstract Object visitLink(Link obj);

    @objid ("e4dbb1c8-8021-4484-8188-a508163582aa")
    abstract Object visitLinkEnd(LinkEnd obj);

    @objid ("893892ac-e406-4e22-a614-e80bcc6ad828")
    abstract Object visitLoopNode(LoopNode obj);

    @objid ("11494eb6-a199-4107-991d-cd023524502f")
    abstract Object visitManifestation(Manifestation obj);

    @objid ("6456115a-9a83-46c3-b8b0-ccab45dfe9ab")
    abstract Object visitMessage(Message obj);

    @objid ("b09cb986-7506-45f8-bef0-aad01afed166")
    abstract Object visitMessageEnd(MessageEnd obj);

    @objid ("91d7161a-d0d4-4c62-8352-8e752c3b3504")
    abstract Object visitMessageFlow(MessageFlow obj);

    @objid ("f22e23f6-9cd3-4a2b-ac18-dfdcabea62c8")
    abstract Object visitModelTree(ModelTree obj);

    @objid ("243e73c5-f2eb-4a5e-987d-e1ee8bec4f08")
    abstract Object visitNameSpace(NameSpace obj);

    @objid ("d8fd4131-7b08-42a2-82b6-6045892afa5e")
    abstract Object visitNaryAssociation(NaryAssociation obj);

    @objid ("66eac5d4-519a-4006-8a1f-4942a18e9ed9")
    abstract Object visitNaryAssociationEnd(NaryAssociationEnd obj);

    @objid ("492f9539-109f-4cc2-a761-e392f3c3ede9")
    abstract Object visitNaryConnector(NaryConnector obj);

    @objid ("72f2a95d-d29d-4250-b509-4352728f3d24")
    abstract Object visitNaryConnectorEnd(NaryConnectorEnd obj);

    @objid ("d6202082-89f0-4e0f-80a1-50bb89ac96f9")
    abstract Object visitNaryLink(NaryLink obj);

    @objid ("2bb0462f-7887-46fd-b71b-68af0ce2346c")
    abstract Object visitNaryLinkEnd(NaryLinkEnd obj);

    @objid ("82c4d08c-4a56-444e-87d7-d811d844e3a1")
    abstract Object visitNode(Node obj);

    @objid ("d68bc001-ac5b-46b3-adaf-eead4c763971")
    abstract Object visitObjectDiagram(ObjectDiagram obj);

    @objid ("6ddec73a-c987-41d5-b791-25accd94007b")
    abstract Object visitObjectFlow(ObjectFlow obj);

    @objid ("8b53365e-8e8f-482a-8f61-f1e2cca7774f")
    abstract Object visitObjectNode(ObjectNode obj);

    @objid ("5c1937ba-7384-439d-aab7-e166f4814f5f")
    abstract Object visitOccurrenceSpecification(OccurrenceSpecification obj);

    @objid ("8be90bab-8560-46c0-b4c7-7b690a7a311e")
    abstract Object visitOpaqueAction(OpaqueAction obj);

    @objid ("4debdbfe-fef1-427d-a632-745d02003088")
    abstract Object visitOpaqueBehavior(OpaqueBehavior obj);

    @objid ("4b692123-ba1b-472c-8fcb-171c048de244")
    abstract Object visitOperation(Operation obj);

    @objid ("a9fb6238-82b8-45e4-8f7b-4c8f1f709ed7")
    abstract Object visitOutputPin(OutputPin obj);

    @objid ("768dbe7f-72ca-49f1-ad23-7f668005d591")
    abstract Object visitPackage(Package obj);

    @objid ("1649a719-dc2a-4503-aa35-322aba80a129")
    abstract Object visitPackageImport(PackageImport obj);

    @objid ("dead96b5-ae62-438c-b8a2-03140a939bd9")
    abstract Object visitPackageMerge(PackageMerge obj);

    @objid ("a4e40c57-fa71-4387-b9ef-8dcc4cac8b27")
    abstract Object visitParameter(Parameter obj);

    @objid ("881639a9-3c37-4c0d-b9a1-520eab53da09")
    abstract Object visitPartDecomposition(PartDecomposition obj);

    @objid ("5b050df0-3518-47e4-b58e-da36cf532c3f")
    abstract Object visitPin(Pin obj);

    @objid ("30588cff-047f-445a-8e1d-48165c592f6e")
    abstract Object visitPort(Port obj);

    @objid ("1002ffda-6dd9-48d2-af8e-c43b10fcdcbd")
    abstract Object visitProject(Project obj);

    @objid ("42caf646-89ef-44f5-bdd8-74de017c4276")
    abstract Object visitProvidedInterface(ProvidedInterface obj);

    @objid ("7a587aaf-5f28-4197-91e0-88af55c05463")
    abstract Object visitRaisedException(RaisedException obj);

    @objid ("d1a80fbe-af4b-4bea-ae00-4632f8e841e3")
    abstract Object visitRegion(Region obj);

    @objid ("f0f6bab7-a67c-44c1-a3cd-541c908933b5")
    abstract Object visitRequiredInterface(RequiredInterface obj);

    @objid ("336766e1-2eef-4f43-af4f-db1ebd3b4514")
    abstract Object visitSendSignalAction(SendSignalAction obj);

    @objid ("f499d770-8ae2-4079-9c2e-97bd4017acfd")
    abstract Object visitSequenceDiagram(SequenceDiagram obj);

    @objid ("d4d1d186-66bb-4c4f-92f6-9f99ba3e99c8")
    abstract Object visitShallowHistoryPseudoState(ShallowHistoryPseudoState obj);

    @objid ("ac5ada12-50fc-4b0a-bcc1-90dcc1b74527")
    abstract Object visitSignal(Signal obj);

    @objid ("e8342a4a-8271-4810-a50e-8ff6ce0ec1ec")
    abstract Object visitState(State obj);

    @objid ("49e688aa-2e6e-47fb-b481-cf7a142ad1ce")
    abstract Object visitStateInvariant(StateInvariant obj);

    @objid ("828ff397-ab71-49dd-b348-7874fd60fc2c")
    abstract Object visitStateMachine(StateMachine obj);

    @objid ("5dd1c843-cb25-4d95-b876-fb266da86744")
    abstract Object visitStateMachineDiagram(StateMachineDiagram obj);

    @objid ("7ae00f8c-a6af-4169-a987-4541ab1645f9")
    abstract Object visitStateVertex(StateVertex obj);

    @objid ("899a1f05-1bc1-453a-84a0-6824f744242e")
    abstract Object visitStaticDiagram(StaticDiagram obj);

    @objid ("8019a22d-d326-4c96-9f0c-133be8aa8a3b")
    abstract Object visitStructuralFeature(StructuralFeature obj);

    @objid ("b1baddbd-2918-4dcd-afc3-fa3ae715405f")
    abstract Object visitStructuredActivityNode(StructuredActivityNode obj);

    @objid ("81497197-8566-4e9a-9b09-d213a4c5a667")
    abstract Object visitSubstitution(Substitution obj);

    @objid ("37848168-e0de-4a35-8a09-4b750ca67c2c")
    abstract Object visitTemplateBinding(TemplateBinding obj);

    @objid ("f6c29aa9-fd1b-4369-9d81-fbcf400fe66a")
    abstract Object visitTemplateParameter(TemplateParameter obj);

    @objid ("03521b15-3a84-44c1-bcdb-9160aaad8dee")
    abstract Object visitTemplateParameterSubstitution(TemplateParameterSubstitution obj);

    @objid ("3da8fa05-f200-4721-9288-465a11f7f583")
    abstract Object visitTerminatePseudoState(TerminatePseudoState obj);

    @objid ("719199b8-edbc-447e-902b-5d906506c210")
    abstract Object visitTerminateSpecification(TerminateSpecification obj);

    @objid ("8408430a-e1b9-47ce-8305-352328c45b2d")
    abstract Object visitTransition(Transition obj);

    @objid ("ece77f20-3b6e-40c2-a063-28415fb05101")
    abstract Object visitUmlModelElement(UmlModelElement obj);

    @objid ("6181a6f7-7f2d-4a32-9ede-1e19d8ff29fe")
    abstract Object visitUsage(Usage obj);

    @objid ("219942fc-da4a-4458-b9fb-40d1b208d0df")
    abstract Object visitUseCase(UseCase obj);

    @objid ("7dda0df0-ae28-4aa5-b902-e0bbcdb7db2e")
    abstract Object visitUseCaseDependency(UseCaseDependency obj);

    @objid ("6c884dff-5586-4d65-bfcb-92a076a948e6")
    abstract Object visitUseCaseDiagram(UseCaseDiagram obj);

    @objid ("3a31784b-6f32-49c7-bf35-0373bce95c1b")
    abstract Object visitValuePin(ValuePin obj);

}
