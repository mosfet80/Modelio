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
@objid ("6b4da49c-5452-428c-b2d8-2406b179c380")
public interface IAbstractModelVisitor extends IModelVisitor {
    @objid ("adf8ad03-25bc-44a0-b5f4-2e0c576e4cf6")
    @Override
    default Object visitAbstractPseudoState(AbstractPseudoState obj) {
        	return null;
    }

    @objid ("89e2af87-899a-4a42-899e-27c4d10128f5")
    @Override
    default Object visitAbstraction(Abstraction obj) {
        	return null;
    }

    @objid ("0f5651f5-3e94-4997-ad75-302f930570a7")
    @Override
    default Object visitAcceptCallEventAction(AcceptCallEventAction obj) {
        	return null;
    }

    @objid ("9b42d5a9-9975-4029-b595-27468d04ee78")
    @Override
    default Object visitAcceptChangeEventAction(AcceptChangeEventAction obj) {
        	return null;
    }

    @objid ("efa77601-8622-4432-b983-f0bdfdd4cf27")
    @Override
    default Object visitAcceptSignalAction(AcceptSignalAction obj) {
        	return null;
    }

    @objid ("7dd432db-3720-4697-96a3-30ad232891d6")
    @Override
    default Object visitAcceptTimeEventAction(AcceptTimeEventAction obj) {
        	return null;
    }

    @objid ("983c6f8b-f19f-4ea8-babd-daf229281a3c")
    @Override
    default Object visitActivity(Activity obj) {
        	return null;
    }

    @objid ("cf9f561a-c1a7-4824-888b-5495e6114789")
    @Override
    default Object visitActivityAction(ActivityAction obj) {
        	return null;
    }

    @objid ("23e883b3-fea0-48a4-881e-0083a89da3ed")
    @Override
    default Object visitActivityDiagram(ActivityDiagram obj) {
        	return null;
    }

    @objid ("1856143b-2c66-4479-b493-e9d7a52f85cf")
    @Override
    default Object visitActivityEdge(ActivityEdge obj) {
        	return null;
    }

    @objid ("db0162cc-310d-4ede-a081-d5915deeee05")
    @Override
    default Object visitActivityFinalNode(ActivityFinalNode obj) {
        	return null;
    }

    @objid ("3f7bb2de-1de7-406e-a64f-659b245920a4")
    @Override
    default Object visitActivityGroup(ActivityGroup obj) {
        	return null;
    }

    @objid ("d0ff629b-9ac3-456d-abeb-bd9fd8dd207a")
    @Override
    default Object visitActivityNode(ActivityNode obj) {
        	return null;
    }

    @objid ("d8502939-cba3-4f0a-ae5d-6c8a6f9d2cbf")
    @Override
    default Object visitActivityParameterNode(ActivityParameterNode obj) {
        	return null;
    }

    @objid ("bde6af3b-cab5-43e4-9f5f-23f34b7650ad")
    @Override
    default Object visitActivityPartition(ActivityPartition obj) {
        	return null;
    }

    @objid ("432c128e-1d43-4153-a8f7-d55a90a6108f")
    @Override
    default Object visitActor(Actor obj) {
        	return null;
    }

    @objid ("bf4f0400-95fd-48ec-81e3-45dc2cc81785")
    @Override
    default Object visitArtifact(Artifact obj) {
        	return null;
    }

    @objid ("db6dccd9-6da5-4ec9-a188-5feeafb46b00")
    @Override
    default Object visitAssociation(Association obj) {
        	return null;
    }

    @objid ("0ca6d216-a0e7-41e0-b6ca-a30bb85d24ca")
    @Override
    default Object visitAssociationEnd(AssociationEnd obj) {
        	return null;
    }

    @objid ("94813e0e-2b6c-4445-8b2e-575eb0cf3cdf")
    @Override
    default Object visitAttribute(Attribute obj) {
        	return null;
    }

    @objid ("0a464a36-2965-4d45-aa1a-78796f6e6710")
    @Override
    default Object visitAttributeLink(AttributeLink obj) {
        	return null;
    }

    @objid ("54b88b91-bc9d-4f44-bb32-1c7f153275cf")
    @Override
    default Object visitBehavior(Behavior obj) {
        	return null;
    }

    @objid ("c92fe2c6-2f39-48cf-8767-dd85011fff9e")
    @Override
    default Object visitBehaviorDiagram(BehaviorDiagram obj) {
        	return null;
    }

    @objid ("2ecd0ba3-1fca-4371-8d33-8e1f27097d17")
    @Override
    default Object visitBehaviorParameter(BehaviorParameter obj) {
        	return null;
    }

    @objid ("2158cc7a-3bd7-417b-84f8-20c8a7a1ff7d")
    @Override
    default Object visitBehavioralFeature(BehavioralFeature obj) {
        	return null;
    }

    @objid ("ae2593b5-ee37-4c5f-887a-eefc98b88ab3")
    @Override
    default Object visitBindableInstance(BindableInstance obj) {
        	return null;
    }

    @objid ("2e05ca4a-b9aa-4121-98bf-e0d2dc5de357")
    @Override
    default Object visitBinding(Binding obj) {
        	return null;
    }

    @objid ("97e46421-a101-4078-afd0-0fb1bd852216")
    @Override
    default Object visitBpmnActivity(BpmnActivity obj) {
        	return null;
    }

    @objid ("4ddc4a87-a1c0-4f09-b7b4-f24cf6292748")
    @Override
    default Object visitBpmnAdHocSubProcess(BpmnAdHocSubProcess obj) {
        	return null;
    }

    @objid ("c3362e3b-441b-4cbf-9f27-707e26af7682")
    @Override
    default Object visitBpmnArtifact(BpmnArtifact obj) {
        	return null;
    }

    @objid ("14e71ed9-d174-41cb-820e-890b5e9ca3d0")
    @Override
    default Object visitBpmnAssociation(BpmnAssociation obj) {
        	return null;
    }

    @objid ("cb7ddcd8-8939-4a68-9a10-2f6d78607a33")
    @Override
    default Object visitBpmnBaseElement(BpmnBaseElement obj) {
        	return null;
    }

    @objid ("e07f03d6-0a6c-49dd-bc9c-6c2e0a333fc3")
    @Override
    default Object visitBpmnBoundaryEvent(BpmnBoundaryEvent obj) {
        	return null;
    }

    @objid ("958d7285-b890-4b19-99c9-3f3eea864b25")
    @Override
    default Object visitBpmnBusinessRuleTask(BpmnBusinessRuleTask obj) {
        	return null;
    }

    @objid ("b55f55ac-10ae-433d-9d87-31f9cdeb9872")
    @Override
    default Object visitBpmnCallActivity(BpmnCallActivity obj) {
        	return null;
    }

    @objid ("6595ba69-7c14-4597-a54a-71b9c1d7ab31")
    @Override
    default Object visitBpmnCancelEventDefinition(BpmnCancelEventDefinition obj) {
        	return null;
    }

    @objid ("829ed93b-3708-499d-90c7-b5f36768b714")
    @Override
    default Object visitBpmnCatchEvent(BpmnCatchEvent obj) {
        	return null;
    }

    @objid ("b922773f-d07d-4d11-808f-753e07bfe286")
    @Override
    default Object visitBpmnCollaboration(BpmnCollaboration obj) {
        	return null;
    }

    @objid ("de33e73a-71cc-4fbf-9165-a7e45b86a4d7")
    @Override
    default Object visitBpmnCollaborationDiagram(BpmnCollaborationDiagram obj) {
        	return null;
    }

    @objid ("ca5893ef-c793-4721-92dc-d162c388ac0f")
    @Override
    default Object visitBpmnCompensateEventDefinition(BpmnCompensateEventDefinition obj) {
        	return null;
    }

    @objid ("d11c8caa-de95-42d9-b3da-cb3bbc6ccf03")
    @Override
    default Object visitBpmnComplexBehaviorDefinition(BpmnComplexBehaviorDefinition obj) {
        	return null;
    }

    @objid ("d0f72186-6725-47eb-85c7-0faaaa5c3f1f")
    @Override
    default Object visitBpmnComplexGateway(BpmnComplexGateway obj) {
        	return null;
    }

    @objid ("49b288cc-0bdc-496f-9fc3-7ec2d0a356ed")
    @Override
    default Object visitBpmnConditionalEventDefinition(BpmnConditionalEventDefinition obj) {
        	return null;
    }

    @objid ("1f9390e5-a562-42e7-97cc-ccc7233d5edc")
    @Override
    default Object visitBpmnDataAssociation(BpmnDataAssociation obj) {
        	return null;
    }

    @objid ("4ff6049d-4e96-40a1-9129-2aabd5231988")
    @Override
    default Object visitBpmnDataInput(BpmnDataInput obj) {
        	return null;
    }

    @objid ("998211cd-ad58-472e-81fd-0428da93e95e")
    @Override
    default Object visitBpmnDataObject(BpmnDataObject obj) {
        	return null;
    }

    @objid ("92ffa977-5f76-400f-8230-c1bcac4b0ca5")
    @Override
    default Object visitBpmnDataOutput(BpmnDataOutput obj) {
        	return null;
    }

    @objid ("7dc2446b-64d6-45c9-b1ab-ef0914b2ac0b")
    @Override
    default Object visitBpmnDataState(BpmnDataState obj) {
        	return null;
    }

    @objid ("229d42ee-205b-4dc2-8921-8feecdea32df")
    @Override
    default Object visitBpmnDataStore(BpmnDataStore obj) {
        	return null;
    }

    @objid ("d4f408c4-b8dc-4d09-8e25-4680f4912c25")
    @Override
    default Object visitBpmnEndEvent(BpmnEndEvent obj) {
        	return null;
    }

    @objid ("e17babc5-6a95-4dd4-8702-e340401ba1a9")
    @Override
    default Object visitBpmnEndPoint(BpmnEndPoint obj) {
        	return null;
    }

    @objid ("20dc598b-5ab0-4bd3-b01a-d3ca7b7d74a6")
    @Override
    default Object visitBpmnErrorEventDefinition(BpmnErrorEventDefinition obj) {
        	return null;
    }

    @objid ("c359202a-bd23-48fb-9de0-7896bd3f848c")
    @Override
    default Object visitBpmnEscalationEventDefinition(BpmnEscalationEventDefinition obj) {
        	return null;
    }

    @objid ("17b612d9-bed4-4bf6-b4dc-d965e3e8b480")
    @Override
    default Object visitBpmnEvent(BpmnEvent obj) {
        	return null;
    }

    @objid ("7ef7359d-d6fe-4a96-9dd8-fffe8f84f32e")
    @Override
    default Object visitBpmnEventBasedGateway(BpmnEventBasedGateway obj) {
        	return null;
    }

    @objid ("f14c2187-d3f5-40c6-9c04-593337c23c09")
    @Override
    default Object visitBpmnEventDefinition(BpmnEventDefinition obj) {
        	return null;
    }

    @objid ("a944ef99-a8c4-4c11-8556-4e17950747db")
    @Override
    default Object visitBpmnExclusiveGateway(BpmnExclusiveGateway obj) {
        	return null;
    }

    @objid ("7b4e89c3-4d22-495a-a8f5-eadcdfecd05b")
    @Override
    default Object visitBpmnFlowElement(BpmnFlowElement obj) {
        	return null;
    }

    @objid ("d4305c32-2094-454e-a898-b9ad7c1ac2d0")
    @Override
    default Object visitBpmnFlowNode(BpmnFlowNode obj) {
        	return null;
    }

    @objid ("29328237-96bf-4fa8-b602-3b354a6c3dac")
    @Override
    default Object visitBpmnGateway(BpmnGateway obj) {
        	return null;
    }

    @objid ("fd44344b-cb85-49b3-afcd-80135f6aa03a")
    @Override
    default Object visitBpmnGroup(BpmnGroup obj) {
        	return null;
    }

    @objid ("924b9094-e824-4d0e-9757-af0f7ad907ec")
    @Override
    default Object visitBpmnImplicitThrowEvent(BpmnImplicitThrowEvent obj) {
        	return null;
    }

    @objid ("95b82473-8b22-4790-ad3f-6b5135dd5e1b")
    @Override
    default Object visitBpmnInclusiveGateway(BpmnInclusiveGateway obj) {
        	return null;
    }

    @objid ("4857c667-e578-4ae9-b5b5-c4de7a2f489a")
    @Override
    default Object visitBpmnInterface(BpmnInterface obj) {
        	return null;
    }

    @objid ("0cfe20b9-0169-43ee-a5f9-0ed7d6fa65f4")
    @Override
    default Object visitBpmnIntermediateCatchEvent(BpmnIntermediateCatchEvent obj) {
        	return null;
    }

    @objid ("836f76d0-80e5-46d2-8252-97abeb84436f")
    @Override
    default Object visitBpmnIntermediateThrowEvent(BpmnIntermediateThrowEvent obj) {
        	return null;
    }

    @objid ("41df11bd-aea9-4cf3-8290-94bf3f6318e7")
    @Override
    default Object visitBpmnItemAwareElement(BpmnItemAwareElement obj) {
        	return null;
    }

    @objid ("2ef1873f-c744-49e6-ad1b-823614481a07")
    @Override
    default Object visitBpmnItemDefinition(BpmnItemDefinition obj) {
        	return null;
    }

    @objid ("1b107e5c-7952-45a9-bf25-cbc93b3dffdd")
    @Override
    default Object visitBpmnLane(BpmnLane obj) {
        	return null;
    }

    @objid ("8c17fd8d-dfb5-4d97-87c8-a9c3bda12b86")
    @Override
    default Object visitBpmnLaneSet(BpmnLaneSet obj) {
        	return null;
    }

    @objid ("143967d1-82e3-40e0-8503-396384cd77e1")
    @Override
    default Object visitBpmnLinkEventDefinition(BpmnLinkEventDefinition obj) {
        	return null;
    }

    @objid ("d6068669-502c-4c73-99f7-ee467d4df61e")
    @Override
    default Object visitBpmnLoopCharacteristics(BpmnLoopCharacteristics obj) {
        	return null;
    }

    @objid ("f5b81538-85bf-4d05-b54f-fb80801ea309")
    @Override
    default Object visitBpmnManualTask(BpmnManualTask obj) {
        	return null;
    }

    @objid ("497d4761-0be0-4f8a-a77b-fc805ac91d3c")
    @Override
    default Object visitBpmnMessage(BpmnMessage obj) {
        	return null;
    }

    @objid ("320d8e2b-51f1-4c37-9d47-e5b5dfad9eee")
    @Override
    default Object visitBpmnMessageEventDefinition(BpmnMessageEventDefinition obj) {
        	return null;
    }

    @objid ("65b2a0d7-bc1f-41f9-9a92-d79622e8adef")
    @Override
    default Object visitBpmnMessageFlow(BpmnMessageFlow obj) {
        	return null;
    }

    @objid ("5295e977-4de0-4007-847a-43ff16705654")
    @Override
    default Object visitBpmnMultiInstanceLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics obj) {
        	return null;
    }

    @objid ("ef21a376-2b72-485f-86e5-107dd4dbc1f9")
    @Override
    default Object visitBpmnOperation(BpmnOperation obj) {
        	return null;
    }

    @objid ("ffeb3065-5ff8-4f2c-9d4a-7c20b243e496")
    @Override
    default Object visitBpmnParallelGateway(BpmnParallelGateway obj) {
        	return null;
    }

    @objid ("5c0384b7-f5e9-4c6d-bc93-583dee927a7a")
    @Override
    default Object visitBpmnParticipant(BpmnParticipant obj) {
        	return null;
    }

    @objid ("fd410bcb-0d79-4f71-a6ec-5096beaeedcd")
    @Override
    default Object visitBpmnProcess(BpmnProcess obj) {
        	return null;
    }

    @objid ("6507f7dd-20d2-4f3b-8fbd-5993d8cd0e9e")
    @Override
    default Object visitBpmnProcessCollaborationDiagram(BpmnProcessCollaborationDiagram obj) {
        	return null;
    }

    @objid ("427007ac-cfad-417f-ac9b-c2e57d6e9c97")
    @Override
    default Object visitBpmnProcessDesignDiagram(BpmnProcessDesignDiagram obj) {
        	return null;
    }

    @objid ("06b33bd1-14a9-4d62-bb2f-b65b57e71b97")
    @Override
    default Object visitBpmnReceiveTask(BpmnReceiveTask obj) {
        	return null;
    }

    @objid ("07b0e137-651e-4f3f-b595-3c55d1818613")
    @Override
    default Object visitBpmnResource(BpmnResource obj) {
        	return null;
    }

    @objid ("8b18b43d-6b35-4b54-b1b2-d8820f4e7e1d")
    @Override
    default Object visitBpmnResourceParameter(BpmnResourceParameter obj) {
        	return null;
    }

    @objid ("b3e2b3f4-b2b8-4b91-93d2-cbf27802d242")
    @Override
    default Object visitBpmnResourceParameterBinding(BpmnResourceParameterBinding obj) {
        	return null;
    }

    @objid ("0bc7c12a-5563-42e0-b451-8ac52106f539")
    @Override
    default Object visitBpmnResourceRole(BpmnResourceRole obj) {
        	return null;
    }

    @objid ("6c280bb9-3b1c-4f28-985f-9c2278a14a40")
    @Override
    default Object visitBpmnScriptTask(BpmnScriptTask obj) {
        	return null;
    }

    @objid ("56e8f9a6-f25d-4a52-9b7d-0ead5e673539")
    @Override
    default Object visitBpmnSendTask(BpmnSendTask obj) {
        	return null;
    }

    @objid ("19c444df-6d10-4a7b-8ad7-6d942cd7837d")
    @Override
    default Object visitBpmnSequenceFlow(BpmnSequenceFlow obj) {
        	return null;
    }

    @objid ("0e97a954-4875-48b4-b5df-406441c7145a")
    @Override
    default Object visitBpmnSequenceFlowDataAssociation(BpmnSequenceFlowDataAssociation obj) {
        	return null;
    }

    @objid ("cb0ea7d9-dbb0-45ba-b06e-b8ebf81452f8")
    @Override
    default Object visitBpmnServiceTask(BpmnServiceTask obj) {
        	return null;
    }

    @objid ("63b592d3-f686-4dc5-94f4-76c368b3850b")
    @Override
    default Object visitBpmnSharedDefinitions(BpmnSharedDefinitions obj) {
        	return null;
    }

    @objid ("2ff0b3aa-3251-45f2-9a10-480a03595ee3")
    @Override
    default Object visitBpmnSharedElement(BpmnSharedElement obj) {
        	return null;
    }

    @objid ("b286d188-01fb-440b-88fe-0dc627442a6b")
    @Override
    default Object visitBpmnSignalEventDefinition(BpmnSignalEventDefinition obj) {
        	return null;
    }

    @objid ("ceb8a988-6dd6-4153-a354-587395af0a06")
    @Override
    default Object visitBpmnStandardLoopCharacteristics(BpmnStandardLoopCharacteristics obj) {
        	return null;
    }

    @objid ("a5cc65a3-e0a0-4135-a804-b5fdf071ed9d")
    @Override
    default Object visitBpmnStartEvent(BpmnStartEvent obj) {
        	return null;
    }

    @objid ("f6f9fe6b-8452-4b49-aeb8-60e8ccb1b3f1")
    @Override
    default Object visitBpmnSubProcess(BpmnSubProcess obj) {
        	return null;
    }

    @objid ("bc8d67dc-af43-4391-a225-541186905bd4")
    @Override
    default Object visitBpmnSubProcessDiagram(BpmnSubProcessDiagram obj) {
        	return null;
    }

    @objid ("cf26a40a-b11d-4041-8d77-8100a3a22f06")
    @Override
    default Object visitBpmnTask(BpmnTask obj) {
        	return null;
    }

    @objid ("8388544a-62fd-470d-8e03-9fe9b16a3d03")
    @Override
    default Object visitBpmnTerminateEventDefinition(BpmnTerminateEventDefinition obj) {
        	return null;
    }

    @objid ("d6f444be-f438-405d-9893-6adc58e9fadb")
    @Override
    default Object visitBpmnThrowEvent(BpmnThrowEvent obj) {
        	return null;
    }

    @objid ("60478407-59c8-418a-9f47-d535cf647365")
    @Override
    default Object visitBpmnTimerEventDefinition(BpmnTimerEventDefinition obj) {
        	return null;
    }

    @objid ("4d5057f5-b276-44e3-a985-8d833c117e1c")
    @Override
    default Object visitBpmnTransaction(BpmnTransaction obj) {
        	return null;
    }

    @objid ("ddba7125-51e9-4b23-a1a5-02d856de3e20")
    @Override
    default Object visitBpmnUserTask(BpmnUserTask obj) {
        	return null;
    }

    @objid ("e989dd70-a03a-46f9-a847-81aa2f483cff")
    @Override
    default Object visitCallAction(CallAction obj) {
        	return null;
    }

    @objid ("4d190b14-07a5-4025-b5f7-7da87f12523e")
    @Override
    default Object visitCallBehaviorAction(CallBehaviorAction obj) {
        	return null;
    }

    @objid ("3003e166-fd06-4015-b164-5658ec2bc1f4")
    @Override
    default Object visitCallOperationAction(CallOperationAction obj) {
        	return null;
    }

    @objid ("80ebcc92-4716-4787-93ce-934ca69b595a")
    @Override
    default Object visitCentralBufferNode(CentralBufferNode obj) {
        	return null;
    }

    @objid ("e0bcd1c5-73f2-49d4-abf7-404302cfdf34")
    @Override
    default Object visitChoicePseudoState(ChoicePseudoState obj) {
        	return null;
    }

    @objid ("2c722f28-1ad9-4771-9da7-469e4c3a9a39")
    @Override
    default Object visitClass(Class obj) {
        	return null;
    }

    @objid ("6eebed22-0e02-4d9c-89c0-970b1ee316c6")
    @Override
    default Object visitClassAssociation(ClassAssociation obj) {
        	return null;
    }

    @objid ("c2b1039e-13b7-480f-b165-142d026a48a6")
    @Override
    default Object visitClassDiagram(ClassDiagram obj) {
        	return null;
    }

    @objid ("929902f0-6c5e-43af-b405-d8d617f5d250")
    @Override
    default Object visitClassifier(Classifier obj) {
        	return null;
    }

    @objid ("faad7a0b-9631-42e9-b878-183d3efd2875")
    @Override
    default Object visitClause(Clause obj) {
        	return null;
    }

    @objid ("26a6131d-e66e-40fe-8d78-edba1dcc83d8")
    @Override
    default Object visitCollaboration(Collaboration obj) {
        	return null;
    }

    @objid ("f76c3938-f9af-48a1-9825-fc60fc596bcd")
    @Override
    default Object visitCollaborationUse(CollaborationUse obj) {
        	return null;
    }

    @objid ("bd1bb801-9289-4802-80d0-26e8ce79643e")
    @Override
    default Object visitCombinedFragment(CombinedFragment obj) {
        	return null;
    }

    @objid ("49367db0-22f4-4a82-ba51-7b1dc3b7fa9b")
    @Override
    default Object visitCommunicationChannel(CommunicationChannel obj) {
        	return null;
    }

    @objid ("f142c766-a66c-4589-86c9-febe6f16d977")
    @Override
    default Object visitCommunicationDiagram(CommunicationDiagram obj) {
        	return null;
    }

    @objid ("f18bc7eb-3566-4a88-9280-78967b7ba0aa")
    @Override
    default Object visitCommunicationInteraction(CommunicationInteraction obj) {
        	return null;
    }

    @objid ("ddd52f76-dcec-40b6-a8d1-d7554167b010")
    @Override
    default Object visitCommunicationMessage(CommunicationMessage obj) {
        	return null;
    }

    @objid ("76fe0334-429e-465d-aa83-271c85bee0a8")
    @Override
    default Object visitCommunicationNode(CommunicationNode obj) {
        	return null;
    }

    @objid ("eabaed99-57c8-45aa-a546-e16c1fcad438")
    @Override
    default Object visitComponent(Component obj) {
        	return null;
    }

    @objid ("2136d6c9-95a4-45f3-ba71-7c7585e49d15")
    @Override
    default Object visitComponentRealization(ComponentRealization obj) {
        	return null;
    }

    @objid ("7110827e-cab7-4132-a813-eeb8a895b5a5")
    @Override
    default Object visitCompositeStructureDiagram(CompositeStructureDiagram obj) {
        	return null;
    }

    @objid ("7c19cf09-caf4-493e-b55c-67308a333536")
    @Override
    default Object visitConditionalNode(ConditionalNode obj) {
        	return null;
    }

    @objid ("bbe2e690-67c0-4c21-9be5-e08dfbfb6272")
    @Override
    default Object visitConnectionPointReference(ConnectionPointReference obj) {
        	return null;
    }

    @objid ("409833d1-83ea-4d17-a385-6e8e07a38d57")
    @Override
    default Object visitConnector(Connector obj) {
        	return null;
    }

    @objid ("07cebb91-7f7d-4585-bb30-40b3e8c3f0b6")
    @Override
    default Object visitConnectorEnd(ConnectorEnd obj) {
        	return null;
    }

    @objid ("5b450182-d761-4dba-b721-5c4eedca9843")
    @Override
    default Object visitConstraint(Constraint obj) {
        	return null;
    }

    @objid ("c9437d8f-6f96-4954-9ba7-9699d9661ed4")
    @Override
    default Object visitControlFlow(ControlFlow obj) {
        	return null;
    }

    @objid ("3099c8b0-2048-49e0-b198-e4be378a2b72")
    @Override
    default Object visitControlNode(ControlNode obj) {
        	return null;
    }

    @objid ("531fbdb6-c83b-4ec2-a363-128155acaefb")
    @Override
    default Object visitDataFlow(DataFlow obj) {
        	return null;
    }

    @objid ("ca6ed03c-9bc3-49bc-80a5-89b4d83b487b")
    @Override
    default Object visitDataStoreNode(DataStoreNode obj) {
        	return null;
    }

    @objid ("0a21f05c-b0a8-432d-8b9c-6c3857d84a01")
    @Override
    default Object visitDataType(DataType obj) {
        	return null;
    }

    @objid ("eed9d3bd-a4d6-410f-bcf7-68fae6d98497")
    @Override
    default Object visitDecisionMergeNode(DecisionMergeNode obj) {
        	return null;
    }

    @objid ("25a84efe-eacd-4645-a9af-e64848c42dd4")
    @Override
    default Object visitDeepHistoryPseudoState(DeepHistoryPseudoState obj) {
        	return null;
    }

    @objid ("59bcd829-861a-4414-91b3-4ffef9cb5359")
    @Override
    default Object visitDeploymentDiagram(DeploymentDiagram obj) {
        	return null;
    }

    @objid ("4b3a0314-2615-4474-a1b2-5cab80c81fcf")
    @Override
    default Object visitDurationConstraint(DurationConstraint obj) {
        	return null;
    }

    @objid ("d40a1eb2-9751-484d-9389-c8cdedecaacf")
    @Override
    default Object visitElementImport(ElementImport obj) {
        	return null;
    }

    @objid ("43b08ddd-1f5c-4685-92ab-791ff1acb8f5")
    @Override
    default Object visitElementRealization(ElementRealization obj) {
        	return null;
    }

    @objid ("76839e6e-8f50-4f16-b1cf-1829162ce045")
    @Override
    default Object visitEntryPointPseudoState(EntryPointPseudoState obj) {
        	return null;
    }

    @objid ("429a86d9-5b95-4514-8b5e-3031a0ffb834")
    @Override
    default Object visitEnumeration(Enumeration obj) {
        	return null;
    }

    @objid ("c308588a-af22-4dd2-9805-dcc5825bd363")
    @Override
    default Object visitEnumerationLiteral(EnumerationLiteral obj) {
        	return null;
    }

    @objid ("67ffc576-e628-4592-aa09-1546aa62b5cc")
    @Override
    default Object visitEvent(Event obj) {
        	return null;
    }

    @objid ("9d6a920b-e560-4e58-8e9e-ad421d16b068")
    @Override
    default Object visitExceptionHandler(ExceptionHandler obj) {
        	return null;
    }

    @objid ("73896f99-b914-4310-b75a-72a3614e7968")
    @Override
    default Object visitExecutionOccurenceSpecification(ExecutionOccurenceSpecification obj) {
        	return null;
    }

    @objid ("c9458ccc-419c-4651-bafa-206e0d46ae95")
    @Override
    default Object visitExecutionSpecification(ExecutionSpecification obj) {
        	return null;
    }

    @objid ("c4480f25-abcd-49c3-a6b0-c3ee5bf75e38")
    @Override
    default Object visitExitPointPseudoState(ExitPointPseudoState obj) {
        	return null;
    }

    @objid ("d372d90a-9e9d-4bde-8ec7-2e493368b81e")
    @Override
    default Object visitExpansionNode(ExpansionNode obj) {
        	return null;
    }

    @objid ("4b8635cc-4c10-4cad-a1f6-750d3b6b4ac4")
    @Override
    default Object visitExpansionRegion(ExpansionRegion obj) {
        	return null;
    }

    @objid ("92210839-7c8b-4851-b513-562a3436667b")
    @Override
    default Object visitExtensionPoint(ExtensionPoint obj) {
        	return null;
    }

    @objid ("1c04460b-dfc1-41d7-b94f-160d5fcdbfcd")
    @Override
    default Object visitFeature(Feature obj) {
        	return null;
    }

    @objid ("77d2754d-fe82-4aa3-a9e6-28d5ab6b1f42")
    @Override
    default Object visitFinalNode(FinalNode obj) {
        	return null;
    }

    @objid ("3cf7b653-9625-4f3d-92e0-42fe6bd8bec1")
    @Override
    default Object visitFinalState(FinalState obj) {
        	return null;
    }

    @objid ("b15631a9-8002-4f1c-b10d-ef9f38f1989b")
    @Override
    default Object visitFlowFinalNode(FlowFinalNode obj) {
        	return null;
    }

    @objid ("7c5fc14e-6d51-43ce-8fe1-b3fc108359db")
    @Override
    default Object visitForkJoinNode(ForkJoinNode obj) {
        	return null;
    }

    @objid ("ccc249b3-26a3-467c-8b98-a20205534545")
    @Override
    default Object visitForkPseudoState(ForkPseudoState obj) {
        	return null;
    }

    @objid ("06744281-285b-4622-9f02-b55d9b09e640")
    @Override
    default Object visitGate(Gate obj) {
        	return null;
    }

    @objid ("8d9b9729-3734-4cf6-9f03-28a9f99de697")
    @Override
    default Object visitGeneralClass(GeneralClass obj) {
        	return null;
    }

    @objid ("471fc481-64de-4d87-8b41-0187afeb9168")
    @Override
    default Object visitGeneralOrdering(GeneralOrdering obj) {
        	return null;
    }

    @objid ("8c3f72c3-4dc5-413e-ac0a-4ae0959252c7")
    @Override
    default Object visitGeneralization(Generalization obj) {
        	return null;
    }

    @objid ("5a9ba465-f154-4384-99b5-4fbe8a6962f5")
    @Override
    default Object visitInformationFlow(InformationFlow obj) {
        	return null;
    }

    @objid ("7faa6341-3835-414a-8714-752f2712818e")
    @Override
    default Object visitInformationItem(InformationItem obj) {
        	return null;
    }

    @objid ("8dff3886-35ae-470b-b1c4-c41c4b8c8bce")
    @Override
    default Object visitInitialNode(InitialNode obj) {
        	return null;
    }

    @objid ("05e38bb4-e134-49f9-8998-1f3254fd6daa")
    @Override
    default Object visitInitialPseudoState(InitialPseudoState obj) {
        	return null;
    }

    @objid ("526d4bb3-612f-4852-bc73-8044bfbe1fda")
    @Override
    default Object visitInputPin(InputPin obj) {
        	return null;
    }

    @objid ("e81f91b0-7b0c-401a-8e53-8c0eb371c05c")
    @Override
    default Object visitInstance(Instance obj) {
        	return null;
    }

    @objid ("6ba28b97-bbf8-4456-867b-fae74637738b")
    @Override
    default Object visitInstanceNode(InstanceNode obj) {
        	return null;
    }

    @objid ("47f3cfb4-224c-445d-bac0-ecde3c2578ea")
    @Override
    default Object visitInteraction(Interaction obj) {
        	return null;
    }

    @objid ("f40d785d-bd03-4ebd-aae2-b49b594af319")
    @Override
    default Object visitInteractionFragment(InteractionFragment obj) {
        	return null;
    }

    @objid ("e33c0430-f76f-4457-84e1-ca29ef845cb0")
    @Override
    default Object visitInteractionOperand(InteractionOperand obj) {
        	return null;
    }

    @objid ("2bbd1ac3-5631-404c-af1f-378b5856b8c7")
    @Override
    default Object visitInteractionUse(InteractionUse obj) {
        	return null;
    }

    @objid ("3256b70f-2ecf-4030-ab2e-b6e11c22c466")
    @Override
    default Object visitInterface(Interface obj) {
        	return null;
    }

    @objid ("1b425461-7a39-460c-9582-ccd085327bc0")
    @Override
    default Object visitInterfaceRealization(InterfaceRealization obj) {
        	return null;
    }

    @objid ("5aa4c233-aafa-4bd5-a3f0-6e333b12340b")
    @Override
    default Object visitInternalTransition(InternalTransition obj) {
        	return null;
    }

    @objid ("f174b357-6b12-4101-939d-1e4fc87b12f2")
    @Override
    default Object visitInterruptibleActivityRegion(InterruptibleActivityRegion obj) {
        	return null;
    }

    @objid ("4eb3ac40-61b4-45a0-ae76-9fac97fdec5b")
    @Override
    default Object visitJoinPseudoState(JoinPseudoState obj) {
        	return null;
    }

    @objid ("56bd4fec-9154-4f88-823e-d86566f76c83")
    @Override
    default Object visitJunctionPseudoState(JunctionPseudoState obj) {
        	return null;
    }

    @objid ("64b7689e-4b1f-407f-8991-53c2400e3374")
    @Override
    default Object visitLifeline(Lifeline obj) {
        	return null;
    }

    @objid ("55696711-7639-4e71-a712-dc8e34df3564")
    @Override
    default Object visitLink(Link obj) {
        	return null;
    }

    @objid ("01bcb4ea-872f-41b8-a05f-61bccdfd54f9")
    @Override
    default Object visitLinkEnd(LinkEnd obj) {
        	return null;
    }

    @objid ("a68d50f6-a6d2-418b-b312-535814c70e48")
    @Override
    default Object visitLoopNode(LoopNode obj) {
        	return null;
    }

    @objid ("3b62c3b3-4eba-42b6-8aff-71669850306e")
    @Override
    default Object visitManifestation(Manifestation obj) {
        	return null;
    }

    @objid ("aa35cd99-9096-4757-81d8-c04df203c515")
    @Override
    default Object visitMessage(Message obj) {
        	return null;
    }

    @objid ("36ca0ada-f0d6-45cf-8e73-8522209ecc78")
    @Override
    default Object visitMessageEnd(MessageEnd obj) {
        	return null;
    }

    @objid ("06a7ff7e-370c-409c-9a3d-9680d42ea24f")
    @Override
    default Object visitMessageFlow(MessageFlow obj) {
        	return null;
    }

    @objid ("73e35968-54ca-4d3a-a1fc-f1a78b743a16")
    @Override
    default Object visitModelTree(ModelTree obj) {
        	return null;
    }

    @objid ("69fefd4d-91e5-4481-994c-77e3929af7c5")
    @Override
    default Object visitNameSpace(NameSpace obj) {
        	return null;
    }

    @objid ("34d1c04d-81b0-44e4-bcb4-64cd49617728")
    @Override
    default Object visitNaryAssociation(NaryAssociation obj) {
        	return null;
    }

    @objid ("18060d37-c8fb-44fa-be3e-91fdd8f9c32d")
    @Override
    default Object visitNaryAssociationEnd(NaryAssociationEnd obj) {
        	return null;
    }

    @objid ("a7aa0a9e-d0a8-43be-ac2b-23783febe1ed")
    @Override
    default Object visitNaryConnector(NaryConnector obj) {
        	return null;
    }

    @objid ("b7cfe905-bf5f-451a-b9b7-2a955a0e0525")
    @Override
    default Object visitNaryConnectorEnd(NaryConnectorEnd obj) {
        	return null;
    }

    @objid ("92755d28-9783-4ade-aaf4-5dbb9e9176f5")
    @Override
    default Object visitNaryLink(NaryLink obj) {
        	return null;
    }

    @objid ("78073252-2c33-4baf-99be-9f33132703bb")
    @Override
    default Object visitNaryLinkEnd(NaryLinkEnd obj) {
        	return null;
    }

    @objid ("7606a726-d8c5-450e-9877-0788cd6f8652")
    @Override
    default Object visitNode(Node obj) {
        	return null;
    }

    @objid ("e2aacebf-8258-4cb2-b15e-19b85703eb9e")
    @Override
    default Object visitObjectDiagram(ObjectDiagram obj) {
        	return null;
    }

    @objid ("ced67a0f-ad6d-4977-b560-d5cd07007772")
    @Override
    default Object visitObjectFlow(ObjectFlow obj) {
        	return null;
    }

    @objid ("1c943645-0c69-4849-9a61-df8508424d0f")
    @Override
    default Object visitObjectNode(ObjectNode obj) {
        	return null;
    }

    @objid ("8f377585-3abb-4707-be6f-f65cddc6b4b9")
    @Override
    default Object visitOccurrenceSpecification(OccurrenceSpecification obj) {
        	return null;
    }

    @objid ("8c7ec49f-fdbd-44df-bd88-a05e6b6e06c8")
    @Override
    default Object visitOpaqueAction(OpaqueAction obj) {
        	return null;
    }

    @objid ("62746a5d-18bd-4338-aba2-752850198542")
    @Override
    default Object visitOpaqueBehavior(OpaqueBehavior obj) {
        	return null;
    }

    @objid ("f8f38b75-8ae5-4852-8feb-08d07a4eaee4")
    @Override
    default Object visitOperation(Operation obj) {
        	return null;
    }

    @objid ("05c7f9bc-b05c-4084-9b04-00a32648c3da")
    @Override
    default Object visitOutputPin(OutputPin obj) {
        	return null;
    }

    @objid ("5bfb4e53-095c-44bf-97bd-6a2d9b09b829")
    @Override
    default Object visitPackage(Package obj) {
        	return null;
    }

    @objid ("9446c8ca-e9ee-441e-8282-1808e1768ac9")
    @Override
    default Object visitPackageImport(PackageImport obj) {
        	return null;
    }

    @objid ("be8f83f1-edf3-4ff5-b90e-447a0220ace3")
    @Override
    default Object visitPackageMerge(PackageMerge obj) {
        	return null;
    }

    @objid ("41622a4d-a0d2-40f4-ad52-bb773db99998")
    @Override
    default Object visitParameter(Parameter obj) {
        	return null;
    }

    @objid ("60f6b9e2-c67f-4deb-a50f-4d8849178ac8")
    @Override
    default Object visitPartDecomposition(PartDecomposition obj) {
        	return null;
    }

    @objid ("eeffac0d-a9af-49d8-b70b-487d94d3d362")
    @Override
    default Object visitPin(Pin obj) {
        	return null;
    }

    @objid ("7c651429-a76f-492e-a268-4ccdfa091b5e")
    @Override
    default Object visitPort(Port obj) {
        	return null;
    }

    @objid ("24d82e93-9cb3-4acb-a3ef-c34907b28b3d")
    @Override
    default Object visitProject(Project obj) {
        	return null;
    }

    @objid ("90a247ee-c08a-4575-856f-4446eb0b9233")
    @Override
    default Object visitProvidedInterface(ProvidedInterface obj) {
        	return null;
    }

    @objid ("9101d085-4e57-4f37-a825-6d3d037633ec")
    @Override
    default Object visitRaisedException(RaisedException obj) {
        	return null;
    }

    @objid ("acde14cb-0d45-4973-8737-aab42bc0cf19")
    @Override
    default Object visitRegion(Region obj) {
        	return null;
    }

    @objid ("cc04de85-e52b-451f-8873-b1eaec565ebf")
    @Override
    default Object visitRequiredInterface(RequiredInterface obj) {
        	return null;
    }

    @objid ("0594e1d2-cea9-49d4-9f5c-135c13cb8e96")
    @Override
    default Object visitSendSignalAction(SendSignalAction obj) {
        	return null;
    }

    @objid ("89db5a8a-ca28-4d7b-b45f-a833dc98101a")
    @Override
    default Object visitSequenceDiagram(SequenceDiagram obj) {
        	return null;
    }

    @objid ("10362f90-5136-4dc5-b074-7101b810606b")
    @Override
    default Object visitShallowHistoryPseudoState(ShallowHistoryPseudoState obj) {
        	return null;
    }

    @objid ("abb5b059-f488-4a0a-836c-08e72589e529")
    @Override
    default Object visitSignal(Signal obj) {
        	return null;
    }

    @objid ("a9715056-4707-4be3-8285-f7ea015aca91")
    @Override
    default Object visitState(State obj) {
        	return null;
    }

    @objid ("2b1c4836-bcb7-4ae9-8baf-3485a97c8a3e")
    @Override
    default Object visitStateInvariant(StateInvariant obj) {
        	return null;
    }

    @objid ("d582b8bd-a820-4734-8bcb-16aa6594392f")
    @Override
    default Object visitStateMachine(StateMachine obj) {
        	return null;
    }

    @objid ("5a612a8a-4155-420c-ad7f-25845f0e2527")
    @Override
    default Object visitStateMachineDiagram(StateMachineDiagram obj) {
        	return null;
    }

    @objid ("3825d3a7-625e-4a5b-b7cd-9d3596ff34a3")
    @Override
    default Object visitStateVertex(StateVertex obj) {
        	return null;
    }

    @objid ("ebac8dfa-3c77-49eb-babc-07ab450116be")
    @Override
    default Object visitStaticDiagram(StaticDiagram obj) {
        	return null;
    }

    @objid ("7532e94c-778b-4003-8892-fa8ce3ca3242")
    @Override
    default Object visitStructuralFeature(StructuralFeature obj) {
        	return null;
    }

    @objid ("f46a2344-29be-4df7-9a76-65087f3eb70f")
    @Override
    default Object visitStructuredActivityNode(StructuredActivityNode obj) {
        	return null;
    }

    @objid ("e4d22d95-f117-4656-b8cc-9dcf79bd28bc")
    @Override
    default Object visitSubstitution(Substitution obj) {
        	return null;
    }

    @objid ("1868d871-16c4-479b-a56e-2286f2b36868")
    @Override
    default Object visitTemplateBinding(TemplateBinding obj) {
        	return null;
    }

    @objid ("cf601ff0-a73d-40ba-931a-c95387ecad2d")
    @Override
    default Object visitTemplateParameter(TemplateParameter obj) {
        	return null;
    }

    @objid ("475061b0-10ac-4f0c-a0dc-cef4d8e4ebb9")
    @Override
    default Object visitTemplateParameterSubstitution(TemplateParameterSubstitution obj) {
        	return null;
    }

    @objid ("77d584cf-22c4-4419-8494-061c7d7225b3")
    @Override
    default Object visitTerminatePseudoState(TerminatePseudoState obj) {
        	return null;
    }

    @objid ("13f7e4f1-6a52-40fe-b0a2-8e01a65da4f7")
    @Override
    default Object visitTerminateSpecification(TerminateSpecification obj) {
        	return null;
    }

    @objid ("235a016d-6919-4b6c-a957-4dd17edb411d")
    @Override
    default Object visitTransition(Transition obj) {
        	return null;
    }

    @objid ("ee0ee3d4-4fe5-4ec9-aa3d-7fb1920d10d5")
    @Override
    default Object visitUmlModelElement(UmlModelElement obj) {
        	return null;
    }

    @objid ("f9b4289a-672b-41f7-926f-e7158714e451")
    @Override
    default Object visitUsage(Usage obj) {
        	return null;
    }

    @objid ("e90142c4-3460-4c14-b8e3-1cfde5aad56d")
    @Override
    default Object visitUseCase(UseCase obj) {
        	return null;
    }

    @objid ("e3cdaf00-35c8-487d-99bf-070f3a756139")
    @Override
    default Object visitUseCaseDependency(UseCaseDependency obj) {
        	return null;
    }

    @objid ("b3555402-435f-40ee-a1a6-c5461c75e936")
    @Override
    default Object visitUseCaseDiagram(UseCaseDiagram obj) {
        	return null;
    }

    @objid ("a5098b1f-ea1f-4cd7-8786-81a7522b9087")
    @Override
    default Object visitValuePin(ValuePin obj) {
        	return null;
    }

}
