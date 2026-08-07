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

/**
 * This class is an implementation of {@link IModelVisitor} whose visit() methods simply return <code>null</code>.
 */
@objid ("00106c06-4f2c-1032-829a-001ec947cd2a")
public class AbstractModelVisitor implements IModelVisitor {
    @objid ("e3d0553c-b674-42cf-ad5c-a51379e6d990")
    @Override
    public Object visitAbstractPseudoState(AbstractPseudoState obj) {
        	return null;
    }

    @objid ("8d543e34-07c0-4c07-af08-d0a70c9fb6ec")
    @Override
    public Object visitAbstraction(Abstraction obj) {
        	return null;
    }

    @objid ("ae806b23-751d-4b80-a00c-55f7aa6ac4d9")
    @Override
    public Object visitAcceptCallEventAction(AcceptCallEventAction obj) {
        	return null;
    }

    @objid ("179a5dcf-1f65-4f4b-a191-6d604eaf3fc0")
    @Override
    public Object visitAcceptChangeEventAction(AcceptChangeEventAction obj) {
        	return null;
    }

    @objid ("a5b5ebdd-4975-45e5-bc34-b1ba97357c83")
    @Override
    public Object visitAcceptSignalAction(AcceptSignalAction obj) {
        	return null;
    }

    @objid ("80783a2e-a2da-4aa2-80e4-a84ca0e9f426")
    @Override
    public Object visitAcceptTimeEventAction(AcceptTimeEventAction obj) {
        	return null;
    }

    @objid ("422dec86-d0e2-4364-969e-352a938dd993")
    @Override
    public Object visitActivity(Activity obj) {
        	return null;
    }

    @objid ("9d1c93a9-0df1-4256-a47c-1b1424716007")
    @Override
    public Object visitActivityAction(ActivityAction obj) {
        	return null;
    }

    @objid ("9c5911cd-9ad9-4578-a27e-f33d144a9236")
    @Override
    public Object visitActivityDiagram(ActivityDiagram obj) {
        	return null;
    }

    @objid ("bd63505a-3f12-4e66-b4b6-83cc00ff9b66")
    @Override
    public Object visitActivityEdge(ActivityEdge obj) {
        	return null;
    }

    @objid ("b427c492-5d16-48e6-834b-2eb0288951db")
    @Override
    public Object visitActivityFinalNode(ActivityFinalNode obj) {
        	return null;
    }

    @objid ("f0448c71-2055-480f-b1a8-bc7d85eaecc3")
    @Override
    public Object visitActivityGroup(ActivityGroup obj) {
        	return null;
    }

    @objid ("678d6fed-8363-450a-8056-6efff0ef614f")
    @Override
    public Object visitActivityNode(ActivityNode obj) {
        	return null;
    }

    @objid ("b5380cd7-3ccb-4135-881e-6cfbc376e70d")
    @Override
    public Object visitActivityParameterNode(ActivityParameterNode obj) {
        	return null;
    }

    @objid ("da5dbe71-20a7-4883-a9f1-8f4564ff10a5")
    @Override
    public Object visitActivityPartition(ActivityPartition obj) {
        	return null;
    }

    @objid ("f616e6f3-aa36-463c-b555-fe6d676dbdc3")
    @Override
    public Object visitActor(Actor obj) {
        	return null;
    }

    @objid ("10d2ac35-21c3-47d2-ac2e-ab3a4a58b428")
    @Override
    public Object visitArtifact(Artifact obj) {
        	return null;
    }

    @objid ("98791bfc-7091-47d7-8a0e-106d2a5e9a61")
    @Override
    public Object visitAssociation(Association obj) {
        	return null;
    }

    @objid ("e1a5b036-aaa5-4cf7-9dd1-02230436f739")
    @Override
    public Object visitAssociationEnd(AssociationEnd obj) {
        	return null;
    }

    @objid ("0350f0e4-e66e-4556-a64e-e4050a2994e5")
    @Override
    public Object visitAttribute(Attribute obj) {
        	return null;
    }

    @objid ("2fd4677a-828a-4807-a9af-6948ccb35a6f")
    @Override
    public Object visitAttributeLink(AttributeLink obj) {
        	return null;
    }

    @objid ("f538c0fe-441c-4f8b-8739-beead6a1ffa0")
    @Override
    public Object visitBehavior(Behavior obj) {
        	return null;
    }

    @objid ("23f107ac-6aff-4272-8f37-69b7ec3e1754")
    @Override
    public Object visitBehaviorDiagram(BehaviorDiagram obj) {
        	return null;
    }

    @objid ("9c217255-c40b-4030-9b4e-07b166845c0e")
    @Override
    public Object visitBehaviorParameter(BehaviorParameter obj) {
        	return null;
    }

    @objid ("6b0c2327-ec2a-4d71-ab41-45f05cab00c6")
    @Override
    public Object visitBehavioralFeature(BehavioralFeature obj) {
        	return null;
    }

    @objid ("9b259aa0-ce71-46c4-b0e4-5a0cd51e1501")
    @Override
    public Object visitBindableInstance(BindableInstance obj) {
        	return null;
    }

    @objid ("df9f1762-8777-4ed1-aeb3-0ee848c5915f")
    @Override
    public Object visitBinding(Binding obj) {
        	return null;
    }

    @objid ("8c9131f5-6fa1-49a4-b952-9f7d0a6bfdb6")
    @Override
    public Object visitBpmnActivity(BpmnActivity obj) {
        	return null;
    }

    @objid ("ce5ba314-c31c-4884-a83e-d576a0554ed3")
    @Override
    public Object visitBpmnAdHocSubProcess(BpmnAdHocSubProcess obj) {
        	return null;
    }

    @objid ("9fec0024-996d-4916-9dc3-e87241648c17")
    @Override
    public Object visitBpmnArtifact(BpmnArtifact obj) {
        	return null;
    }

    @objid ("031453cc-048d-4cf1-92c8-d0286f55634e")
    @Override
    public Object visitBpmnAssociation(BpmnAssociation obj) {
        	return null;
    }

    @objid ("38c723df-afbc-4c3a-9f8f-f10d8e2d3c7c")
    @Override
    public Object visitBpmnBaseElement(BpmnBaseElement obj) {
        	return null;
    }

    @objid ("2a12e3f6-0cd0-4a7f-ac00-ff21d00ac30a")
    @Override
    public Object visitBpmnBoundaryEvent(BpmnBoundaryEvent obj) {
        	return null;
    }

    @objid ("40da8f2e-4edb-4cfe-8cb6-30a7a15a1045")
    @Override
    public Object visitBpmnBusinessRuleTask(BpmnBusinessRuleTask obj) {
        	return null;
    }

    @objid ("8fd5fcac-966f-4950-81eb-4781c4c08c7f")
    @Override
    public Object visitBpmnCallActivity(BpmnCallActivity obj) {
        	return null;
    }

    @objid ("26dadbc9-5d0d-413b-a6bd-bdadb6fe5d14")
    @Override
    public Object visitBpmnCancelEventDefinition(BpmnCancelEventDefinition obj) {
        	return null;
    }

    @objid ("21d05c32-cd54-433f-8c81-e30c817092b1")
    @Override
    public Object visitBpmnCatchEvent(BpmnCatchEvent obj) {
        	return null;
    }

    @objid ("8c544fde-2285-4b69-9186-bc722b1b8b3d")
    @Override
    public Object visitBpmnCollaboration(BpmnCollaboration obj) {
        	return null;
    }

    @objid ("ada7964c-1b33-4890-9c56-01d26a342ea6")
    @Override
    public Object visitBpmnCollaborationDiagram(BpmnCollaborationDiagram obj) {
        	return null;
    }

    @objid ("47ef6854-7511-4678-9040-d97f421c71c8")
    @Override
    public Object visitBpmnCompensateEventDefinition(BpmnCompensateEventDefinition obj) {
        	return null;
    }

    @objid ("5ed8a49e-d193-428d-af98-d95c684a95b7")
    @Override
    public Object visitBpmnComplexBehaviorDefinition(BpmnComplexBehaviorDefinition obj) {
        	return null;
    }

    @objid ("898efce1-4372-4973-b652-4340a755804a")
    @Override
    public Object visitBpmnComplexGateway(BpmnComplexGateway obj) {
        	return null;
    }

    @objid ("d72d687c-080b-441a-9f68-3d221dcabef8")
    @Override
    public Object visitBpmnConditionalEventDefinition(BpmnConditionalEventDefinition obj) {
        	return null;
    }

    @objid ("36f2d770-61e3-43c9-910b-6b6b696d58a2")
    @Override
    public Object visitBpmnDataAssociation(BpmnDataAssociation obj) {
        	return null;
    }

    @objid ("27602f4f-af16-4259-9e1d-cfea5b3a9105")
    @Override
    public Object visitBpmnDataInput(BpmnDataInput obj) {
        	return null;
    }

    @objid ("e6dcecd2-9fd6-4455-98f6-b3c151ae9e01")
    @Override
    public Object visitBpmnDataObject(BpmnDataObject obj) {
        	return null;
    }

    @objid ("5047ad8a-453e-4384-9b64-24230119b646")
    @Override
    public Object visitBpmnDataOutput(BpmnDataOutput obj) {
        	return null;
    }

    @objid ("a75f3f64-51d0-4fad-a25e-a33e5a3f53e1")
    @Override
    public Object visitBpmnDataState(BpmnDataState obj) {
        	return null;
    }

    @objid ("e0459f06-8105-4a07-844c-70632ab71bab")
    @Override
    public Object visitBpmnDataStore(BpmnDataStore obj) {
        	return null;
    }

    @objid ("12ee0eaa-4b7d-4c24-ab9b-73e5986a2039")
    @Override
    public Object visitBpmnEndEvent(BpmnEndEvent obj) {
        	return null;
    }

    @objid ("a70178a7-3685-4aca-9087-15cca808e664")
    @Override
    public Object visitBpmnEndPoint(BpmnEndPoint obj) {
        	return null;
    }

    @objid ("ca2597c0-b6ae-4cd6-b015-a09d6d3cae08")
    @Override
    public Object visitBpmnErrorEventDefinition(BpmnErrorEventDefinition obj) {
        	return null;
    }

    @objid ("a32fedb3-9c76-4e2d-a80f-7063efdce544")
    @Override
    public Object visitBpmnEscalationEventDefinition(BpmnEscalationEventDefinition obj) {
        	return null;
    }

    @objid ("7620d19b-72bb-471c-9da7-f41cedb35070")
    @Override
    public Object visitBpmnEvent(BpmnEvent obj) {
        	return null;
    }

    @objid ("6d05a551-5f86-4a23-9312-227d3868260f")
    @Override
    public Object visitBpmnEventBasedGateway(BpmnEventBasedGateway obj) {
        	return null;
    }

    @objid ("d696fee5-4e19-4969-a7cd-5394a170210e")
    @Override
    public Object visitBpmnEventDefinition(BpmnEventDefinition obj) {
        	return null;
    }

    @objid ("106225b3-6d63-459d-940c-d74659e8c4e4")
    @Override
    public Object visitBpmnExclusiveGateway(BpmnExclusiveGateway obj) {
        	return null;
    }

    @objid ("d233fd80-4abb-4d79-93a4-689e4d48a1d4")
    @Override
    public Object visitBpmnFlowElement(BpmnFlowElement obj) {
        	return null;
    }

    @objid ("dd15d6b9-988a-4a69-b84d-7fea4167b7fd")
    @Override
    public Object visitBpmnFlowNode(BpmnFlowNode obj) {
        	return null;
    }

    @objid ("1572a266-87f0-4e89-93d5-7673ed0a6014")
    @Override
    public Object visitBpmnGateway(BpmnGateway obj) {
        	return null;
    }

    @objid ("63d0aaf1-1a26-430b-b88c-ac0b8f53121e")
    @Override
    public Object visitBpmnGroup(BpmnGroup obj) {
        	return null;
    }

    @objid ("e121a31f-a645-44d5-a971-e55c8df49217")
    @Override
    public Object visitBpmnImplicitThrowEvent(BpmnImplicitThrowEvent obj) {
        	return null;
    }

    @objid ("1f4220f7-a08c-46bf-9dcb-c04c84131590")
    @Override
    public Object visitBpmnInclusiveGateway(BpmnInclusiveGateway obj) {
        	return null;
    }

    @objid ("dc97fc2f-d101-42b8-9bc3-cb5c3b4127ad")
    @Override
    public Object visitBpmnInterface(BpmnInterface obj) {
        	return null;
    }

    @objid ("e1362598-ada3-4df8-9d3e-5d4edc3bc863")
    @Override
    public Object visitBpmnIntermediateCatchEvent(BpmnIntermediateCatchEvent obj) {
        	return null;
    }

    @objid ("8b835ed7-abd9-4f3d-b03c-b41dbbdcb2cb")
    @Override
    public Object visitBpmnIntermediateThrowEvent(BpmnIntermediateThrowEvent obj) {
        	return null;
    }

    @objid ("f29f4eac-0fd8-4334-a5d8-fdd3396a7012")
    @Override
    public Object visitBpmnItemAwareElement(BpmnItemAwareElement obj) {
        	return null;
    }

    @objid ("0bd4cdbc-4179-4c6e-a324-632c84a12dd7")
    @Override
    public Object visitBpmnItemDefinition(BpmnItemDefinition obj) {
        	return null;
    }

    @objid ("66dccc2c-e2e8-4aa4-a0fd-c2bcdc91d0a1")
    @Override
    public Object visitBpmnLane(BpmnLane obj) {
        	return null;
    }

    @objid ("7e8af548-5135-4fe5-a6af-7bdedcca3566")
    @Override
    public Object visitBpmnLaneSet(BpmnLaneSet obj) {
        	return null;
    }

    @objid ("cc303b85-0d02-4247-8bf5-c11c591a2959")
    @Override
    public Object visitBpmnLinkEventDefinition(BpmnLinkEventDefinition obj) {
        	return null;
    }

    @objid ("07a8e82c-7504-471f-8658-d7030e1dc4f2")
    @Override
    public Object visitBpmnLoopCharacteristics(BpmnLoopCharacteristics obj) {
        	return null;
    }

    @objid ("ea752d00-e2bd-4bfc-b653-066e2d597cea")
    @Override
    public Object visitBpmnManualTask(BpmnManualTask obj) {
        	return null;
    }

    @objid ("5af2282d-935a-4c17-bf74-f1662adb9cf6")
    @Override
    public Object visitBpmnMessage(BpmnMessage obj) {
        	return null;
    }

    @objid ("35f7813b-265e-4c93-a69a-6ec5510f9da3")
    @Override
    public Object visitBpmnMessageEventDefinition(BpmnMessageEventDefinition obj) {
        	return null;
    }

    @objid ("c825b033-7a4d-4759-bbe6-6d88348f9adc")
    @Override
    public Object visitBpmnMessageFlow(BpmnMessageFlow obj) {
        	return null;
    }

    @objid ("1eeaf039-c192-46ce-be60-592c459ee4cb")
    @Override
    public Object visitBpmnMultiInstanceLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics obj) {
        	return null;
    }

    @objid ("db3838d5-aeda-4a8b-b4f3-6e2f0939d794")
    @Override
    public Object visitBpmnOperation(BpmnOperation obj) {
        	return null;
    }

    @objid ("a3806d4f-7b55-49c2-bf4a-c3d2cdbae9ab")
    @Override
    public Object visitBpmnParallelGateway(BpmnParallelGateway obj) {
        	return null;
    }

    @objid ("9c5e129c-e6ef-4795-8b31-b86ce3c70c12")
    @Override
    public Object visitBpmnParticipant(BpmnParticipant obj) {
        	return null;
    }

    @objid ("63853d53-523c-41b1-8c49-469f8e8a2efe")
    @Override
    public Object visitBpmnProcess(BpmnProcess obj) {
        	return null;
    }

    @objid ("b81594b3-7c96-4849-928d-c8493fe901d5")
    @Override
    public Object visitBpmnProcessCollaborationDiagram(BpmnProcessCollaborationDiagram obj) {
        	return null;
    }

    @objid ("139508fb-dd10-4ae2-9405-4def3cfa8696")
    @Override
    public Object visitBpmnProcessDesignDiagram(BpmnProcessDesignDiagram obj) {
        	return null;
    }

    @objid ("38f4e60a-a9aa-49ab-8940-9628bb454ab1")
    @Override
    public Object visitBpmnReceiveTask(BpmnReceiveTask obj) {
        	return null;
    }

    @objid ("7bfe370f-ccc2-4e7f-9fb4-be71473f9788")
    @Override
    public Object visitBpmnResource(BpmnResource obj) {
        	return null;
    }

    @objid ("c7282b7e-dfd8-4206-b07e-05a8b4fddf3c")
    @Override
    public Object visitBpmnResourceParameter(BpmnResourceParameter obj) {
        	return null;
    }

    @objid ("cea1c5c8-1ec7-439b-a3f9-07b9b8b73188")
    @Override
    public Object visitBpmnResourceParameterBinding(BpmnResourceParameterBinding obj) {
        	return null;
    }

    @objid ("5b4cf289-e6e9-4c25-b492-3bf02538bfeb")
    @Override
    public Object visitBpmnResourceRole(BpmnResourceRole obj) {
        	return null;
    }

    @objid ("8b5d3979-f1f2-419b-b7e1-ad47c37bb23c")
    @Override
    public Object visitBpmnScriptTask(BpmnScriptTask obj) {
        	return null;
    }

    @objid ("59f26c15-cfb5-48ca-99e0-b25868e3b4f7")
    @Override
    public Object visitBpmnSendTask(BpmnSendTask obj) {
        	return null;
    }

    @objid ("27e202de-2b90-43e3-89f7-d2fc0c123cd8")
    @Override
    public Object visitBpmnSequenceFlow(BpmnSequenceFlow obj) {
        	return null;
    }

    @objid ("8ba21e60-6431-4cb0-8600-bddaa27dd3ca")
    @Override
    public Object visitBpmnSequenceFlowDataAssociation(BpmnSequenceFlowDataAssociation obj) {
        	return null;
    }

    @objid ("92e6dad1-b5c0-49d8-9ec3-e4fdf89b2b51")
    @Override
    public Object visitBpmnServiceTask(BpmnServiceTask obj) {
        	return null;
    }

    @objid ("1a32ebb9-c7f5-440e-8382-f2098fa55e45")
    @Override
    public Object visitBpmnSharedDefinitions(BpmnSharedDefinitions obj) {
        	return null;
    }

    @objid ("89e2600f-4fe9-4de2-b829-38475518fd26")
    @Override
    public Object visitBpmnSharedElement(BpmnSharedElement obj) {
        	return null;
    }

    @objid ("b2aab391-ee96-4317-a8a4-d85c228b278b")
    @Override
    public Object visitBpmnSignalEventDefinition(BpmnSignalEventDefinition obj) {
        	return null;
    }

    @objid ("4805aa6b-2b6a-49d2-9f6e-8315643124cd")
    @Override
    public Object visitBpmnStandardLoopCharacteristics(BpmnStandardLoopCharacteristics obj) {
        	return null;
    }

    @objid ("018f7db4-8cac-4444-8ae1-b5a4c39231f0")
    @Override
    public Object visitBpmnStartEvent(BpmnStartEvent obj) {
        	return null;
    }

    @objid ("cf4cb3da-1479-40f5-acb1-f846ffccc81d")
    @Override
    public Object visitBpmnSubProcess(BpmnSubProcess obj) {
        	return null;
    }

    @objid ("8d47b614-ed04-4d98-b49f-e26d986a5801")
    @Override
    public Object visitBpmnSubProcessDiagram(BpmnSubProcessDiagram obj) {
        	return null;
    }

    @objid ("9492fae6-b5c7-4349-b49e-8796dccaa6c9")
    @Override
    public Object visitBpmnTask(BpmnTask obj) {
        	return null;
    }

    @objid ("90c9050c-dc14-4cf6-8032-d7469316a05f")
    @Override
    public Object visitBpmnTerminateEventDefinition(BpmnTerminateEventDefinition obj) {
        	return null;
    }

    @objid ("bfe2289a-6193-4ce0-8d95-58ec5224904d")
    @Override
    public Object visitBpmnThrowEvent(BpmnThrowEvent obj) {
        	return null;
    }

    @objid ("fa8e38da-28a3-4799-93b8-9fae9ec181ca")
    @Override
    public Object visitBpmnTimerEventDefinition(BpmnTimerEventDefinition obj) {
        	return null;
    }

    @objid ("4d4dbfd7-8950-4fb1-8416-4aba6bd28860")
    @Override
    public Object visitBpmnTransaction(BpmnTransaction obj) {
        	return null;
    }

    @objid ("73220b13-21e7-4e3d-907b-5f1fcfce401c")
    @Override
    public Object visitBpmnUserTask(BpmnUserTask obj) {
        	return null;
    }

    @objid ("5727ac03-a45b-4994-9357-e23db0869e7b")
    @Override
    public Object visitCallAction(CallAction obj) {
        	return null;
    }

    @objid ("aac989ab-75af-462e-989d-4a6b5e9ab1bd")
    @Override
    public Object visitCallBehaviorAction(CallBehaviorAction obj) {
        	return null;
    }

    @objid ("22b7b0a1-a2c8-4bf3-883d-045d9907962a")
    @Override
    public Object visitCallOperationAction(CallOperationAction obj) {
        	return null;
    }

    @objid ("4e42ecfe-3cc6-47d8-94e1-4b88d5b2fa0c")
    @Override
    public Object visitCentralBufferNode(CentralBufferNode obj) {
        	return null;
    }

    @objid ("ca10d4cb-4f7e-4e0e-8406-ccce9bbe04f5")
    @Override
    public Object visitChoicePseudoState(ChoicePseudoState obj) {
        	return null;
    }

    @objid ("14308fbc-1a73-4462-9952-afea39a11451")
    @Override
    public Object visitClass(Class obj) {
        	return null;
    }

    @objid ("b8ba758e-3f69-4a98-8081-533c36c0a9f8")
    @Override
    public Object visitClassAssociation(ClassAssociation obj) {
        	return null;
    }

    @objid ("c106d6a4-8dbb-4541-b1db-38ec6d085a6e")
    @Override
    public Object visitClassDiagram(ClassDiagram obj) {
        	return null;
    }

    @objid ("c560ae06-6b68-4c6c-be6c-12aab1c97f61")
    @Override
    public Object visitClassifier(Classifier obj) {
        	return null;
    }

    @objid ("0a4885f6-da78-4329-b9f0-fe0522c80dab")
    @Override
    public Object visitClause(Clause obj) {
        	return null;
    }

    @objid ("8094f943-82c7-4f7c-b83b-8e710f4664cb")
    @Override
    public Object visitCollaboration(Collaboration obj) {
        	return null;
    }

    @objid ("ccdf0bf5-c7a0-4d6e-aea1-e07b308eeff2")
    @Override
    public Object visitCollaborationUse(CollaborationUse obj) {
        	return null;
    }

    @objid ("ba136600-bdf6-49d3-8b9c-8b8aa4a6fd2c")
    @Override
    public Object visitCombinedFragment(CombinedFragment obj) {
        	return null;
    }

    @objid ("9bb62c5e-c9e6-4474-b57e-058f5a3d16db")
    @Override
    public Object visitCommunicationChannel(CommunicationChannel obj) {
        	return null;
    }

    @objid ("43c62d54-4407-4ea9-861b-4de72055df3d")
    @Override
    public Object visitCommunicationDiagram(CommunicationDiagram obj) {
        	return null;
    }

    @objid ("d865f7db-c924-477c-b693-0aaf41ea709f")
    @Override
    public Object visitCommunicationInteraction(CommunicationInteraction obj) {
        	return null;
    }

    @objid ("96ef28fb-3a94-4c77-a59f-4942ef641ff3")
    @Override
    public Object visitCommunicationMessage(CommunicationMessage obj) {
        	return null;
    }

    @objid ("6dea8e05-05dd-4076-8c86-cd4a66b1bcad")
    @Override
    public Object visitCommunicationNode(CommunicationNode obj) {
        	return null;
    }

    @objid ("033f749b-92aa-45b4-9330-1f8a27b4030b")
    @Override
    public Object visitComponent(Component obj) {
        	return null;
    }

    @objid ("940468f2-27c7-4acd-9345-144d84fe7ad1")
    @Override
    public Object visitComponentRealization(ComponentRealization obj) {
        	return null;
    }

    @objid ("b83d667c-a271-4a56-8a00-8dfae5a621c5")
    @Override
    public Object visitCompositeStructureDiagram(CompositeStructureDiagram obj) {
        	return null;
    }

    @objid ("9b2b0d67-036f-45dc-99bd-eb19fc656cd2")
    @Override
    public Object visitConditionalNode(ConditionalNode obj) {
        	return null;
    }

    @objid ("e35bc83d-2297-422f-af0b-d2b1e738930e")
    @Override
    public Object visitConnectionPointReference(ConnectionPointReference obj) {
        	return null;
    }

    @objid ("fef8c776-4a6d-4c9d-8386-e38d3b91e9b8")
    @Override
    public Object visitConnector(Connector obj) {
        	return null;
    }

    @objid ("2f1194b5-f284-493f-bfdf-32e579442ba2")
    @Override
    public Object visitConnectorEnd(ConnectorEnd obj) {
        	return null;
    }

    @objid ("cf1905f3-2143-4209-9173-f143ad6db54d")
    @Override
    public Object visitConstraint(Constraint obj) {
        	return null;
    }

    @objid ("ce0b2859-532e-470f-8a47-bdd292d92761")
    @Override
    public Object visitControlFlow(ControlFlow obj) {
        	return null;
    }

    @objid ("39649ab8-26db-4c39-bd22-e3cb55b24e19")
    @Override
    public Object visitControlNode(ControlNode obj) {
        	return null;
    }

    @objid ("14623043-2ec2-47df-a9a1-6a930f8c9e85")
    @Override
    public Object visitDataFlow(DataFlow obj) {
        	return null;
    }

    @objid ("6f2c290c-7f49-42b6-9eb6-6ab4fde419c9")
    @Override
    public Object visitDataStoreNode(DataStoreNode obj) {
        	return null;
    }

    @objid ("e9d5b3fc-0608-4f59-8a5d-e15f1216c744")
    @Override
    public Object visitDataType(DataType obj) {
        	return null;
    }

    @objid ("706573a5-2969-4339-a680-941aedbb1fe1")
    @Override
    public Object visitDecisionMergeNode(DecisionMergeNode obj) {
        	return null;
    }

    @objid ("36833de7-2048-4322-ab4b-1fda32c359a1")
    @Override
    public Object visitDeepHistoryPseudoState(DeepHistoryPseudoState obj) {
        	return null;
    }

    @objid ("71359f1c-3f8d-4788-b6e2-c9a23e972050")
    @Override
    public Object visitDeploymentDiagram(DeploymentDiagram obj) {
        	return null;
    }

    @objid ("da549422-fe63-446a-aab9-796258e6fdc2")
    @Override
    public Object visitDurationConstraint(DurationConstraint obj) {
        	return null;
    }

    @objid ("6d89cb40-f478-4c27-904a-77c867e4cb80")
    @Override
    public Object visitElementImport(ElementImport obj) {
        	return null;
    }

    @objid ("4a29eca1-5e01-4efd-8277-52b8a3e2501e")
    @Override
    public Object visitElementRealization(ElementRealization obj) {
        	return null;
    }

    @objid ("ad82d6d6-190f-445e-9949-580978387fc3")
    @Override
    public Object visitEntryPointPseudoState(EntryPointPseudoState obj) {
        	return null;
    }

    @objid ("fadf56f6-061d-4de4-9d0d-ac0a2ba77006")
    @Override
    public Object visitEnumeration(Enumeration obj) {
        	return null;
    }

    @objid ("6cf9555b-c347-43dc-9de5-bedfceccbe4f")
    @Override
    public Object visitEnumerationLiteral(EnumerationLiteral obj) {
        	return null;
    }

    @objid ("54b6dedb-3172-4985-892d-d722289778ba")
    @Override
    public Object visitEvent(Event obj) {
        	return null;
    }

    @objid ("4b7c1506-8690-42ad-92dd-89ee54dcfb6a")
    @Override
    public Object visitExceptionHandler(ExceptionHandler obj) {
        	return null;
    }

    @objid ("c7a01aeb-6417-4535-9ce5-c32f4e7f5df6")
    @Override
    public Object visitExecutionOccurenceSpecification(ExecutionOccurenceSpecification obj) {
        	return null;
    }

    @objid ("0a6403cc-d877-423c-97bb-57c97eb3e495")
    @Override
    public Object visitExecutionSpecification(ExecutionSpecification obj) {
        	return null;
    }

    @objid ("d64a0b8d-1b42-4be6-b052-afda48c25d10")
    @Override
    public Object visitExitPointPseudoState(ExitPointPseudoState obj) {
        	return null;
    }

    @objid ("7b3d6ac8-682c-44ee-8253-661ea5ac1f6d")
    @Override
    public Object visitExpansionNode(ExpansionNode obj) {
        	return null;
    }

    @objid ("2fca498c-9700-4327-af19-e47f1dc4de44")
    @Override
    public Object visitExpansionRegion(ExpansionRegion obj) {
        	return null;
    }

    @objid ("bbb8630d-b6ed-4671-acae-f318f7a23f28")
    @Override
    public Object visitExtensionPoint(ExtensionPoint obj) {
        	return null;
    }

    @objid ("f9c01214-96f3-4e5b-8b09-74eb613f091e")
    @Override
    public Object visitFeature(Feature obj) {
        	return null;
    }

    @objid ("22a2e21b-41b5-411a-8bbd-5098b2fff7a2")
    @Override
    public Object visitFinalNode(FinalNode obj) {
        	return null;
    }

    @objid ("1aaec87a-8163-4622-8ea1-70dd74d0e667")
    @Override
    public Object visitFinalState(FinalState obj) {
        	return null;
    }

    @objid ("3b107d0f-8fec-4b93-b99d-b244fd4d780e")
    @Override
    public Object visitFlowFinalNode(FlowFinalNode obj) {
        	return null;
    }

    @objid ("dbc7af27-6426-496a-adda-8465dc55f4bb")
    @Override
    public Object visitForkJoinNode(ForkJoinNode obj) {
        	return null;
    }

    @objid ("de9df448-4fbb-411f-9861-290b4dc3eb4d")
    @Override
    public Object visitForkPseudoState(ForkPseudoState obj) {
        	return null;
    }

    @objid ("ef00ddae-c33a-43fd-9222-8f3544763a36")
    @Override
    public Object visitGate(Gate obj) {
        	return null;
    }

    @objid ("b11af674-50aa-4b65-a7e8-c77b9384ee7e")
    @Override
    public Object visitGeneralClass(GeneralClass obj) {
        	return null;
    }

    @objid ("5d772a34-5f3d-4c25-b1bd-6d3c77c2aa0c")
    @Override
    public Object visitGeneralOrdering(GeneralOrdering obj) {
        	return null;
    }

    @objid ("ee41448a-17d0-4d8e-ac83-db34efc27fdd")
    @Override
    public Object visitGeneralization(Generalization obj) {
        	return null;
    }

    @objid ("ad4d2dff-3fa9-4973-966b-7e6711d000b0")
    @Override
    public Object visitInformationFlow(InformationFlow obj) {
        	return null;
    }

    @objid ("98b953c7-50ef-4327-bb68-7d44b6388842")
    @Override
    public Object visitInformationItem(InformationItem obj) {
        	return null;
    }

    @objid ("87ed8b99-ef59-42ce-b918-70c306d139b0")
    @Override
    public Object visitInitialNode(InitialNode obj) {
        	return null;
    }

    @objid ("79facf64-7d6c-4fcd-8f54-ee7a0e088f1d")
    @Override
    public Object visitInitialPseudoState(InitialPseudoState obj) {
        	return null;
    }

    @objid ("ffc2844e-91c9-454b-96d4-3c6e47570dc0")
    @Override
    public Object visitInputPin(InputPin obj) {
        	return null;
    }

    @objid ("5c8b034d-8bd0-421b-a6d6-db3542e95f34")
    @Override
    public Object visitInstance(Instance obj) {
        	return null;
    }

    @objid ("973688a7-437c-4ff8-a1c7-391de97cb172")
    @Override
    public Object visitInstanceNode(InstanceNode obj) {
        	return null;
    }

    @objid ("8e18652e-7908-4bc9-98cf-bef1bc708b0d")
    @Override
    public Object visitInteraction(Interaction obj) {
        	return null;
    }

    @objid ("b1949a37-c80b-4a9b-a48c-56ba1a439ffa")
    @Override
    public Object visitInteractionFragment(InteractionFragment obj) {
        	return null;
    }

    @objid ("1d11faa1-b8fb-4797-ac24-62769f968bc1")
    @Override
    public Object visitInteractionOperand(InteractionOperand obj) {
        	return null;
    }

    @objid ("cb63bb89-5cc3-4d60-be94-96af79547e22")
    @Override
    public Object visitInteractionUse(InteractionUse obj) {
        	return null;
    }

    @objid ("7dff9aba-36e5-44b0-9bba-c76c14ce4a24")
    @Override
    public Object visitInterface(Interface obj) {
        	return null;
    }

    @objid ("9467e171-6cde-48d5-ac19-e18614685da0")
    @Override
    public Object visitInterfaceRealization(InterfaceRealization obj) {
        	return null;
    }

    @objid ("ddbe3488-3f81-4f0c-8078-38c677751132")
    @Override
    public Object visitInternalTransition(InternalTransition obj) {
        	return null;
    }

    @objid ("4e8f7f8f-b6b5-403d-b3a5-52fc9a256809")
    @Override
    public Object visitInterruptibleActivityRegion(InterruptibleActivityRegion obj) {
        	return null;
    }

    @objid ("c862865d-12f5-4ec5-ad7a-c92569058560")
    @Override
    public Object visitJoinPseudoState(JoinPseudoState obj) {
        	return null;
    }

    @objid ("7b8d5a2a-b47a-4950-8dfd-c5dadf868be3")
    @Override
    public Object visitJunctionPseudoState(JunctionPseudoState obj) {
        	return null;
    }

    @objid ("bd2d7383-4411-4ea0-a5a0-a62b418f7c13")
    @Override
    public Object visitLifeline(Lifeline obj) {
        	return null;
    }

    @objid ("c3d8eb3c-b24a-4cd5-805b-a9596961f1de")
    @Override
    public Object visitLink(Link obj) {
        	return null;
    }

    @objid ("d266c54d-33bf-44ac-b3a3-bc9113f4b483")
    @Override
    public Object visitLinkEnd(LinkEnd obj) {
        	return null;
    }

    @objid ("c0378697-1c8c-4889-8e90-fd9b813091f6")
    @Override
    public Object visitLoopNode(LoopNode obj) {
        	return null;
    }

    @objid ("8ef4b709-efbe-4849-9633-1221e8be53f6")
    @Override
    public Object visitManifestation(Manifestation obj) {
        	return null;
    }

    @objid ("4123e4b6-bb48-4427-b97d-0e822f6fb381")
    @Override
    public Object visitMessage(Message obj) {
        	return null;
    }

    @objid ("3baa7c99-517b-44da-a901-31ee2e412593")
    @Override
    public Object visitMessageEnd(MessageEnd obj) {
        	return null;
    }

    @objid ("5ed9c7ab-febb-45a4-b9f7-cab01b981464")
    @Override
    public Object visitMessageFlow(MessageFlow obj) {
        	return null;
    }

    @objid ("075bc475-3241-4029-8cbd-5cf8cfa98d0a")
    @Override
    public Object visitModelTree(ModelTree obj) {
        	return null;
    }

    @objid ("727aa246-b662-49e7-a4a9-276c65c6ec6f")
    @Override
    public Object visitNameSpace(NameSpace obj) {
        	return null;
    }

    @objid ("cfb5000e-3284-4268-aff2-6726f08c53ce")
    @Override
    public Object visitNaryAssociation(NaryAssociation obj) {
        	return null;
    }

    @objid ("cc34ded2-358c-4d67-bea8-efc25e770ce3")
    @Override
    public Object visitNaryAssociationEnd(NaryAssociationEnd obj) {
        	return null;
    }

    @objid ("fa2db181-799b-4350-9297-9189ebd82c2a")
    @Override
    public Object visitNaryConnector(NaryConnector obj) {
        	return null;
    }

    @objid ("a6959c0e-daee-4887-9253-c74f3650869a")
    @Override
    public Object visitNaryConnectorEnd(NaryConnectorEnd obj) {
        	return null;
    }

    @objid ("274e58e3-d793-45ce-9d26-76e06c3580ec")
    @Override
    public Object visitNaryLink(NaryLink obj) {
        	return null;
    }

    @objid ("6999a8df-6695-4d3d-80a7-c40ad2b71e28")
    @Override
    public Object visitNaryLinkEnd(NaryLinkEnd obj) {
        	return null;
    }

    @objid ("a99f1705-e391-4ce6-96b5-a2f64f752f25")
    @Override
    public Object visitNode(Node obj) {
        	return null;
    }

    @objid ("02760be0-d71a-40ed-b187-f81ed0dfba03")
    @Override
    public Object visitObjectDiagram(ObjectDiagram obj) {
        	return null;
    }

    @objid ("c7055919-3de3-4c26-a1e3-11873ffa852f")
    @Override
    public Object visitObjectFlow(ObjectFlow obj) {
        	return null;
    }

    @objid ("1925df5d-2d67-4872-a241-430d2b095d37")
    @Override
    public Object visitObjectNode(ObjectNode obj) {
        	return null;
    }

    @objid ("855a1abc-db3b-4214-b00c-e129d49adab7")
    @Override
    public Object visitOccurrenceSpecification(OccurrenceSpecification obj) {
        	return null;
    }

    @objid ("1846f612-9295-42de-9469-51ca0318ae83")
    @Override
    public Object visitOpaqueAction(OpaqueAction obj) {
        	return null;
    }

    @objid ("999d318a-505a-4a6c-9cf3-37f4ad039bec")
    @Override
    public Object visitOpaqueBehavior(OpaqueBehavior obj) {
        	return null;
    }

    @objid ("4716177f-4043-403c-b0c5-52fa569e6917")
    @Override
    public Object visitOperation(Operation obj) {
        	return null;
    }

    @objid ("227ed0d3-4258-41d4-a5ed-15a839214138")
    @Override
    public Object visitOutputPin(OutputPin obj) {
        	return null;
    }

    @objid ("754a08be-5ab1-4a1d-85e6-9de1d0ccf409")
    @Override
    public Object visitPackage(Package obj) {
        	return null;
    }

    @objid ("d8335ddb-5005-4333-a67d-e8b3bd768dba")
    @Override
    public Object visitPackageImport(PackageImport obj) {
        	return null;
    }

    @objid ("14d237d0-c905-4cd6-be32-7a1aa76fddd7")
    @Override
    public Object visitPackageMerge(PackageMerge obj) {
        	return null;
    }

    @objid ("92e8d356-1c11-4f61-becb-5eb26b2c73aa")
    @Override
    public Object visitParameter(Parameter obj) {
        	return null;
    }

    @objid ("1b9f4451-d88c-431e-89b3-29c1d0035955")
    @Override
    public Object visitPartDecomposition(PartDecomposition obj) {
        	return null;
    }

    @objid ("78edb386-f80e-449e-8b2e-a4cbd9dacadb")
    @Override
    public Object visitPin(Pin obj) {
        	return null;
    }

    @objid ("724015fb-8e20-4c89-96b0-a9ca8e354148")
    @Override
    public Object visitPort(Port obj) {
        	return null;
    }

    @objid ("f5de6d56-9ad0-4d6e-abcf-d3d832910b25")
    @Override
    public Object visitProject(Project obj) {
        	return null;
    }

    @objid ("1e5e2e02-6e33-4a96-a3a2-7f6a8e214686")
    @Override
    public Object visitProvidedInterface(ProvidedInterface obj) {
        	return null;
    }

    @objid ("3b9115fa-3520-45d2-87dc-4e17db1e26c2")
    @Override
    public Object visitRaisedException(RaisedException obj) {
        	return null;
    }

    @objid ("5e3a7712-1858-4aa4-b6a8-d5f53a0dd002")
    @Override
    public Object visitRegion(Region obj) {
        	return null;
    }

    @objid ("ec5bbe82-a3af-4aa6-9c80-3ff393a5ebcd")
    @Override
    public Object visitRequiredInterface(RequiredInterface obj) {
        	return null;
    }

    @objid ("00c7ae16-85d1-40d3-b2c5-7417ab23e17c")
    @Override
    public Object visitSendSignalAction(SendSignalAction obj) {
        	return null;
    }

    @objid ("be6dc59b-0e2f-4bc9-8ff1-1def5cf08eb2")
    @Override
    public Object visitSequenceDiagram(SequenceDiagram obj) {
        	return null;
    }

    @objid ("0d38ec00-67fd-4f9e-8384-9bc0e9a0cd47")
    @Override
    public Object visitShallowHistoryPseudoState(ShallowHistoryPseudoState obj) {
        	return null;
    }

    @objid ("1a59eda4-16ff-447f-b057-928d38bcbc8e")
    @Override
    public Object visitSignal(Signal obj) {
        	return null;
    }

    @objid ("c057f0cb-d5c7-48e2-bee4-1208767486f4")
    @Override
    public Object visitState(State obj) {
        	return null;
    }

    @objid ("a2d42b75-73ac-4e28-93b7-61e5be48fccd")
    @Override
    public Object visitStateInvariant(StateInvariant obj) {
        	return null;
    }

    @objid ("e04214b3-f7bc-4f5a-a9bf-4b172d4652f9")
    @Override
    public Object visitStateMachine(StateMachine obj) {
        	return null;
    }

    @objid ("cc1e638f-5510-423b-9f5f-f5473ba154a5")
    @Override
    public Object visitStateMachineDiagram(StateMachineDiagram obj) {
        	return null;
    }

    @objid ("c32c74b9-dec6-41f9-ac13-88cedc133d5e")
    @Override
    public Object visitStateVertex(StateVertex obj) {
        	return null;
    }

    @objid ("33cc3f79-1006-4f20-8dbd-4ce3929f6472")
    @Override
    public Object visitStaticDiagram(StaticDiagram obj) {
        	return null;
    }

    @objid ("7b5aed44-c872-4050-97b9-2ae8a6ff9247")
    @Override
    public Object visitStructuralFeature(StructuralFeature obj) {
        	return null;
    }

    @objid ("ad379953-45e7-4258-b83c-4f17c1651524")
    @Override
    public Object visitStructuredActivityNode(StructuredActivityNode obj) {
        	return null;
    }

    @objid ("2df59519-4989-4a3a-a9d2-86de37bc9f4d")
    @Override
    public Object visitSubstitution(Substitution obj) {
        	return null;
    }

    @objid ("67bc4037-b138-4b7d-abe8-25b74c10e75e")
    @Override
    public Object visitTemplateBinding(TemplateBinding obj) {
        	return null;
    }

    @objid ("fd4aab98-415e-4529-ad12-fb92b40cc056")
    @Override
    public Object visitTemplateParameter(TemplateParameter obj) {
        	return null;
    }

    @objid ("48eb1ec1-ae97-4d6d-9152-1c23925fc639")
    @Override
    public Object visitTemplateParameterSubstitution(TemplateParameterSubstitution obj) {
        	return null;
    }

    @objid ("00a9f25b-0ab3-4ae8-a17f-2cb8fcdea66f")
    @Override
    public Object visitTerminatePseudoState(TerminatePseudoState obj) {
        	return null;
    }

    @objid ("e9b87553-54c9-41e4-95f4-20c3cc774dfc")
    @Override
    public Object visitTerminateSpecification(TerminateSpecification obj) {
        	return null;
    }

    @objid ("efd3a8ff-b968-4d41-afc3-8ed83ca54dcc")
    @Override
    public Object visitTransition(Transition obj) {
        	return null;
    }

    @objid ("63fd2d6b-8694-46f6-b37b-c406f92eb5cd")
    @Override
    public Object visitUmlModelElement(UmlModelElement obj) {
        	return null;
    }

    @objid ("c662baf3-a435-496b-a0df-92aa536357b1")
    @Override
    public Object visitUsage(Usage obj) {
        	return null;
    }

    @objid ("1205d839-b784-4763-a7df-ed471f43b41d")
    @Override
    public Object visitUseCase(UseCase obj) {
        	return null;
    }

    @objid ("fd1a04a5-474a-4309-a294-9dcaca175b22")
    @Override
    public Object visitUseCaseDependency(UseCaseDependency obj) {
        	return null;
    }

    @objid ("2fb9de7f-fd6f-47b8-8f68-fe63220bef5e")
    @Override
    public Object visitUseCaseDiagram(UseCaseDiagram obj) {
        	return null;
    }

    @objid ("aa2bf088-0468-4edf-b91f-b18d2d92dae8")
    @Override
    public Object visitValuePin(ValuePin obj) {
        	return null;
    }

}
