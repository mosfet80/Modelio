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
import org.modelio.metamodel.visitors.IInfrastructureVisitor;

/**
 * This class is an implementation of {@link IModelVisitor} whose default strategy consists in transmitting the visit call to the super class visit method.
 * <p>On root metaclasses, the visitor tries to delegate to the configured delegation visitor if available.If not available, <code>null</code> is returned.
 */
@objid ("00280eec-4f2c-1032-829a-001ec947cd2a")
public class DefaultModelVisitor implements IModelVisitor {
    @objid ("f78f5044-6bbd-43b0-b2b2-c392f3412a58")
    protected IInfrastructureVisitor infrastructureVisitor = null;

    @objid ("f7f96b63-4c62-458c-b414-3ce4bd7f32d8")
    public DefaultModelVisitor() {
        super();
    }

    @objid ("2fd850b0-5b99-421e-91bb-e4629fce020f")
    public DefaultModelVisitor(IInfrastructureVisitor infrastructureVisitor) {
        super();
        this.infrastructureVisitor = infrastructureVisitor;
    }

    @objid ("5e6f8751-fc5f-41a5-82d8-49b0b6d15f8c")
    @Override
    public Object visitAbstractPseudoState(AbstractPseudoState obj) {
        return visitStateVertex(obj);

    }

    @objid ("d4052290-1d52-4851-9c9b-03670c84efa5")
    @Override
    public Object visitAbstraction(Abstraction obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitDependency(obj) : null;

    }

    @objid ("4e4653a9-9452-41dc-ad4e-4bf27c1a5463")
    @Override
    public Object visitAcceptCallEventAction(AcceptCallEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("3c6dccca-e1e8-48a3-b87c-c2e0d6a9d5c8")
    @Override
    public Object visitAcceptChangeEventAction(AcceptChangeEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("61e1ca35-1856-4522-83be-0aa53a6977f3")
    @Override
    public Object visitAcceptSignalAction(AcceptSignalAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("f7aa3983-bea1-4eff-8204-c95441037825")
    @Override
    public Object visitAcceptTimeEventAction(AcceptTimeEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("5cdf0e4e-e617-4a33-9b2a-a57e38d4c80f")
    @Override
    public Object visitActivity(Activity obj) {
        return visitBehavior(obj);

    }

    @objid ("cc826994-9454-41b2-a65a-9dddff887a3b")
    @Override
    public Object visitActivityAction(ActivityAction obj) {
        return visitActivityNode(obj);

    }

    @objid ("13d80ba4-5c92-404b-a3c7-54375cdcef82")
    @Override
    public Object visitActivityDiagram(ActivityDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("8563f76c-8f88-4c53-88a9-55a48b05b34b")
    @Override
    public Object visitActivityEdge(ActivityEdge obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("67b81791-d828-4012-b9f7-cee474856dbb")
    @Override
    public Object visitActivityFinalNode(ActivityFinalNode obj) {
        return visitFinalNode(obj);

    }

    @objid ("a7100664-77d5-4af9-91f4-8899c10b811e")
    @Override
    public Object visitActivityGroup(ActivityGroup obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("5b97f891-24a3-4e2a-a6d9-c89c3b614d5a")
    @Override
    public Object visitActivityNode(ActivityNode obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("d6fa2290-001e-43f2-8178-d06aa9b397c6")
    @Override
    public Object visitActivityParameterNode(ActivityParameterNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("b28f8bf1-03a1-438b-9ba1-c194fb3719ff")
    @Override
    public Object visitActivityPartition(ActivityPartition obj) {
        return visitActivityGroup(obj);

    }

    @objid ("57b4f2b5-65b4-4d51-a62e-0d4f764d4794")
    @Override
    public Object visitActor(Actor obj) {
        return visitGeneralClass(obj);

    }

    @objid ("c1d1dd6b-abda-4eaa-8054-d11dba70c38e")
    @Override
    public Object visitArtifact(Artifact obj) {
        return visitClassifier(obj);

    }

    @objid ("35428e0e-755e-4d73-aa92-51a3dc59a630")
    @Override
    public Object visitAssociation(Association obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("a9a6686b-7862-4f1a-bb6c-444550f51015")
    @Override
    public Object visitAssociationEnd(AssociationEnd obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("bd282f88-5a8b-4346-8917-82e0e5c52587")
    @Override
    public Object visitAttribute(Attribute obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("0022130b-b6d2-47cd-a35a-dcd9f9ce7bec")
    @Override
    public Object visitAttributeLink(AttributeLink obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("24c06359-ef0a-483e-9cf2-9e26b62bd593")
    @Override
    public Object visitBehavior(Behavior obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("fc18b160-45fa-40a8-9435-5e2665a9c69e")
    @Override
    public Object visitBehaviorDiagram(BehaviorDiagram obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractDiagram(obj) : null;

    }

    @objid ("6e44a210-4de8-4800-a546-f7c5990cb164")
    @Override
    public Object visitBehaviorParameter(BehaviorParameter obj) {
        return visitParameter(obj);

    }

    @objid ("ae3a45af-5e04-484c-9a8e-a738e79a4c27")
    @Override
    public Object visitBehavioralFeature(BehavioralFeature obj) {
        return visitFeature(obj);

    }

    @objid ("e2a932f5-39ac-4319-b396-a783b14ad978")
    @Override
    public Object visitBindableInstance(BindableInstance obj) {
        return visitInstance(obj);

    }

    @objid ("7a7f2788-7fe3-4f5d-96c3-884de931736c")
    @Override
    public Object visitBinding(Binding obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("6242eff0-2946-4453-bd00-23cbf1e48113")
    @Override
    public Object visitBpmnActivity(BpmnActivity obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("88fabe7d-1d2b-4e82-bbbd-5a21f8de2b55")
    @Override
    public Object visitBpmnAdHocSubProcess(BpmnAdHocSubProcess obj) {
        return visitBpmnSubProcess(obj);

    }

    @objid ("b049a6af-0331-497f-9f74-2f5e12d0f9d3")
    @Override
    public Object visitBpmnArtifact(BpmnArtifact obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("d88aba0c-2b37-46d8-8184-085e5db7f3e2")
    @Override
    public Object visitBpmnAssociation(BpmnAssociation obj) {
        return visitBpmnArtifact(obj);

    }

    @objid ("49b658db-031d-480a-98ec-f7a6744677f7")
    @Override
    public Object visitBpmnBaseElement(BpmnBaseElement obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitModelElement(obj) : null;

    }

    @objid ("f4624041-ba82-4c71-9f90-069dec379071")
    @Override
    public Object visitBpmnBoundaryEvent(BpmnBoundaryEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("f588f312-b7f9-4b56-a178-758ee01c58a9")
    @Override
    public Object visitBpmnBusinessRuleTask(BpmnBusinessRuleTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("507e9068-76ac-4a44-9e9d-2bf1630e66c2")
    @Override
    public Object visitBpmnCallActivity(BpmnCallActivity obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("53f25db3-7686-427f-9358-849652d4397f")
    @Override
    public Object visitBpmnCancelEventDefinition(BpmnCancelEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("dd0f8a52-be19-4898-9767-349862f4106a")
    @Override
    public Object visitBpmnCatchEvent(BpmnCatchEvent obj) {
        return visitBpmnEvent(obj);

    }

    @objid ("ef861b54-3fe8-4f2a-959f-95ad3283e473")
    @Override
    public Object visitBpmnCollaboration(BpmnCollaboration obj) {
        return visitBehavior(obj);

    }

    @objid ("6cd5510f-b45b-4644-a4fc-83a1c7f04a41")
    @Override
    public Object visitBpmnCollaborationDiagram(BpmnCollaborationDiagram obj) {
        return visitBpmnProcessCollaborationDiagram(obj);

    }

    @objid ("ac0fbf8d-819c-4aed-aaae-07a556b32dd7")
    @Override
    public Object visitBpmnCompensateEventDefinition(BpmnCompensateEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("b0a2a80d-3f6f-4e94-b5bd-ba777c520814")
    @Override
    public Object visitBpmnComplexBehaviorDefinition(BpmnComplexBehaviorDefinition obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("130899a6-a704-4eb1-82be-a992fccaaa61")
    @Override
    public Object visitBpmnComplexGateway(BpmnComplexGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("ff99a72e-23b1-4989-9eab-443de9e158e3")
    @Override
    public Object visitBpmnConditionalEventDefinition(BpmnConditionalEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("0c9ef3f5-833c-4d62-8d36-92c0c0fbe98a")
    @Override
    public Object visitBpmnDataAssociation(BpmnDataAssociation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("056bb573-11b4-473b-beaa-4e8779358629")
    @Override
    public Object visitBpmnDataInput(BpmnDataInput obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("47da67d9-ca79-4ecf-923c-6c4ea82bd644")
    @Override
    public Object visitBpmnDataObject(BpmnDataObject obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("f467516e-97b1-4fd7-9a7c-ab159d8ffcf5")
    @Override
    public Object visitBpmnDataOutput(BpmnDataOutput obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("8ef8fb0a-25fa-4941-bb30-d43cfabed562")
    @Override
    public Object visitBpmnDataState(BpmnDataState obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("09e43dc6-f63f-48e2-85b2-fb2126b4d10a")
    @Override
    public Object visitBpmnDataStore(BpmnDataStore obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("ebc42e4e-fad7-4115-8e92-8699e562101d")
    @Override
    public Object visitBpmnEndEvent(BpmnEndEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("73f4891a-c8df-4bcf-a8b2-23ebc649e269")
    @Override
    public Object visitBpmnEndPoint(BpmnEndPoint obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("b02c222e-9b27-48b7-a5d6-54cce88fd4bd")
    @Override
    public Object visitBpmnErrorEventDefinition(BpmnErrorEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("aef71fd6-32ce-41a3-8b0a-8996007721ed")
    @Override
    public Object visitBpmnEscalationEventDefinition(BpmnEscalationEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("fa59b06c-3c1c-4c9a-9418-c012c88620a5")
    @Override
    public Object visitBpmnEvent(BpmnEvent obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("be2928cb-b429-4ca1-93ff-e56ef5176d1a")
    @Override
    public Object visitBpmnEventBasedGateway(BpmnEventBasedGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("8ea13f0b-71ae-4bfa-986a-b213bb4265b8")
    @Override
    public Object visitBpmnEventDefinition(BpmnEventDefinition obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("09c76111-5b69-4c0b-bc71-86590dbd1b7e")
    @Override
    public Object visitBpmnExclusiveGateway(BpmnExclusiveGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("362d8cf9-0cbc-4543-93ec-b389b0b8cb6b")
    @Override
    public Object visitBpmnFlowElement(BpmnFlowElement obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("35f1c010-e34f-4c92-9ef1-4e62dba60251")
    @Override
    public Object visitBpmnFlowNode(BpmnFlowNode obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("137e8471-dc06-4dee-b4d2-2b4f28d0f79d")
    @Override
    public Object visitBpmnGateway(BpmnGateway obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("e36820ec-d106-4c12-9fee-cec3bc0cb9f2")
    @Override
    public Object visitBpmnGroup(BpmnGroup obj) {
        return visitBpmnArtifact(obj);

    }

    @objid ("7ed287b5-fbf6-4554-8cfc-a191ab69ad45")
    @Override
    public Object visitBpmnImplicitThrowEvent(BpmnImplicitThrowEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("d10e8b1f-98c9-4239-be60-15899fa68864")
    @Override
    public Object visitBpmnInclusiveGateway(BpmnInclusiveGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("af1abd70-d5f9-4060-b038-712158307b6c")
    @Override
    public Object visitBpmnInterface(BpmnInterface obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("86bb846c-732f-44c2-9c3c-2d392c683604")
    @Override
    public Object visitBpmnIntermediateCatchEvent(BpmnIntermediateCatchEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("441ef5cd-7b9f-4511-b652-13cf60a519ea")
    @Override
    public Object visitBpmnIntermediateThrowEvent(BpmnIntermediateThrowEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("87e39f10-9a5e-4776-9338-51ae1cf46862")
    @Override
    public Object visitBpmnItemAwareElement(BpmnItemAwareElement obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("85d2ae09-1033-4a4c-98e4-ac9805d6be06")
    @Override
    public Object visitBpmnItemDefinition(BpmnItemDefinition obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("8bf7b230-84d6-431f-8ae9-231e95eb3c61")
    @Override
    public Object visitBpmnLane(BpmnLane obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("4fbd16ab-d8ed-4621-8d18-430d5a581f2c")
    @Override
    public Object visitBpmnLaneSet(BpmnLaneSet obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("c3db6b06-0871-4437-b38c-e85fdb6c4d29")
    @Override
    public Object visitBpmnLinkEventDefinition(BpmnLinkEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("aba69f3c-ff8a-403c-95d5-fcfcb7f7af36")
    @Override
    public Object visitBpmnLoopCharacteristics(BpmnLoopCharacteristics obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("af386e54-124d-4804-92cc-53fc1197b58b")
    @Override
    public Object visitBpmnManualTask(BpmnManualTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("5197c9eb-417d-432b-9f44-bc1243a51341")
    @Override
    public Object visitBpmnMessage(BpmnMessage obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("e3edf4ab-dd83-4255-bed2-d07694a72d22")
    @Override
    public Object visitBpmnMessageEventDefinition(BpmnMessageEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("08eff507-ef10-44d7-b7cd-d2dcb83d072a")
    @Override
    public Object visitBpmnMessageFlow(BpmnMessageFlow obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("cfb4254d-2ce9-4055-9f66-c9d27241ad5b")
    @Override
    public Object visitBpmnMultiInstanceLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics obj) {
        return visitBpmnLoopCharacteristics(obj);

    }

    @objid ("6cb831ea-e9f5-447c-888a-99af6e024faf")
    @Override
    public Object visitBpmnOperation(BpmnOperation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("f12c5081-1ccc-49bd-9f97-40da1bfa2c30")
    @Override
    public Object visitBpmnParallelGateway(BpmnParallelGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("c393f36c-56a3-40af-9677-186e4fa13c45")
    @Override
    public Object visitBpmnParticipant(BpmnParticipant obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("b665d8f1-5de9-4bfa-800a-2f1ec004662d")
    @Override
    public Object visitBpmnProcess(BpmnProcess obj) {
        return visitBehavior(obj);

    }

    @objid ("a2ff6154-5d35-48e1-94d8-ced3a2d76b1b")
    @Override
    public Object visitBpmnProcessCollaborationDiagram(BpmnProcessCollaborationDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("be14003d-a9ee-431a-94f4-1481dda913c5")
    @Override
    public Object visitBpmnProcessDesignDiagram(BpmnProcessDesignDiagram obj) {
        return visitBpmnProcessCollaborationDiagram(obj);

    }

    @objid ("f8235f8a-8398-43b6-9750-c50575761a3e")
    @Override
    public Object visitBpmnReceiveTask(BpmnReceiveTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("c613bdba-c4da-4525-9972-c8c15f832714")
    @Override
    public Object visitBpmnResource(BpmnResource obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("9505b3a1-e9de-4202-8e93-6d330baae3ca")
    @Override
    public Object visitBpmnResourceParameter(BpmnResourceParameter obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("d5fed120-e89c-4d6e-8e0e-d3634132b78c")
    @Override
    public Object visitBpmnResourceParameterBinding(BpmnResourceParameterBinding obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("09e98a72-db8e-4acc-a005-c1a2e92db53e")
    @Override
    public Object visitBpmnResourceRole(BpmnResourceRole obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("493d132c-318a-49e9-a003-bceede0cffad")
    @Override
    public Object visitBpmnScriptTask(BpmnScriptTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("655de999-c322-46ef-8e18-be226fa33ff2")
    @Override
    public Object visitBpmnSendTask(BpmnSendTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("cd9874ec-11b3-4c82-8533-9cfdeb2932bd")
    @Override
    public Object visitBpmnSequenceFlow(BpmnSequenceFlow obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("990b0fd1-05f2-4b35-aa70-72c40c612e99")
    @Override
    public Object visitBpmnSequenceFlowDataAssociation(BpmnSequenceFlowDataAssociation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("f3a6ce1b-5994-413e-98a7-28e379c1c3f8")
    @Override
    public Object visitBpmnServiceTask(BpmnServiceTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("312d39b7-9485-4de7-9700-e7335572a3e2")
    @Override
    public Object visitBpmnSharedDefinitions(BpmnSharedDefinitions obj) {
        return visitBehavior(obj);

    }

    @objid ("7ae45a20-4133-4695-b636-25d67ea34f5a")
    @Override
    public Object visitBpmnSharedElement(BpmnSharedElement obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("d0b9fd64-caa6-41d5-ad60-6e4d54d50584")
    @Override
    public Object visitBpmnSignalEventDefinition(BpmnSignalEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("0bce55b4-88c5-4ca8-a4bd-8b76fceab5b7")
    @Override
    public Object visitBpmnStandardLoopCharacteristics(BpmnStandardLoopCharacteristics obj) {
        return visitBpmnLoopCharacteristics(obj);

    }

    @objid ("2227000d-dade-4a71-be64-bf286d8ec58f")
    @Override
    public Object visitBpmnStartEvent(BpmnStartEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("da1f66e4-7c92-4bcb-8198-96d941ebda5b")
    @Override
    public Object visitBpmnSubProcess(BpmnSubProcess obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("95dc6aa4-02d9-42f8-914b-184f2ddb235a")
    @Override
    public Object visitBpmnSubProcessDiagram(BpmnSubProcessDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("08cb57c0-335b-444f-b5e3-3c78ab15f52b")
    @Override
    public Object visitBpmnTask(BpmnTask obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("ac881183-e832-4971-a639-6141d2b7c05f")
    @Override
    public Object visitBpmnTerminateEventDefinition(BpmnTerminateEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("0e9960a2-2c45-4ab8-a448-9837726dc84f")
    @Override
    public Object visitBpmnThrowEvent(BpmnThrowEvent obj) {
        return visitBpmnEvent(obj);

    }

    @objid ("8576b738-f207-45de-9106-d3739aec8ffe")
    @Override
    public Object visitBpmnTimerEventDefinition(BpmnTimerEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("207cbccd-5820-49f1-bfff-894ad9b4fc23")
    @Override
    public Object visitBpmnTransaction(BpmnTransaction obj) {
        return visitBpmnSubProcess(obj);

    }

    @objid ("37a5117c-d353-4522-8fe5-1079cefff1db")
    @Override
    public Object visitBpmnUserTask(BpmnUserTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("2e058ec6-b2cd-42c0-bc46-df1eb2cadbc8")
    @Override
    public Object visitCallAction(CallAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("5e31d2ba-2eab-4bd2-a55d-3de8905fc9e7")
    @Override
    public Object visitCallBehaviorAction(CallBehaviorAction obj) {
        return visitCallAction(obj);

    }

    @objid ("f04cd875-c630-46bc-8e3e-a5bfd1553f81")
    @Override
    public Object visitCallOperationAction(CallOperationAction obj) {
        return visitCallAction(obj);

    }

    @objid ("5fe08df8-5dad-4646-a020-b25664a8ce3a")
    @Override
    public Object visitCentralBufferNode(CentralBufferNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("b8a2165d-0e19-4cb9-b159-56edd6e9ad2e")
    @Override
    public Object visitChoicePseudoState(ChoicePseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("cad0d273-d57d-480a-935b-fe77bd684465")
    @Override
    public Object visitClass(Class obj) {
        return visitGeneralClass(obj);

    }

    @objid ("e2317889-58cb-4d72-ae65-3689a130d031")
    @Override
    public Object visitClassAssociation(ClassAssociation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("492312bb-cedf-48af-bca4-65bd92fe1ebd")
    @Override
    public Object visitClassDiagram(ClassDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("9f4c6811-e624-4946-b299-df62042129c7")
    @Override
    public Object visitClassifier(Classifier obj) {
        return visitNameSpace(obj);

    }

    @objid ("16778c85-31c4-4e61-9a66-ae7dad45fe02")
    @Override
    public Object visitClause(Clause obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("9f78c2bd-4028-4e94-9302-2e7efe535696")
    @Override
    public Object visitCollaboration(Collaboration obj) {
        return visitNameSpace(obj);

    }

    @objid ("cb5bafaa-e8c8-4fd6-977e-b96d44cefea6")
    @Override
    public Object visitCollaborationUse(CollaborationUse obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("bfdb5750-eaf2-45e1-bfc2-4207710b8342")
    @Override
    public Object visitCombinedFragment(CombinedFragment obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("46c328a5-1371-4d00-93a6-94a75abea061")
    @Override
    public Object visitCommunicationChannel(CommunicationChannel obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("062c1856-19fa-4b37-ba22-124413888849")
    @Override
    public Object visitCommunicationDiagram(CommunicationDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("6438b71b-126f-45a5-9852-08dc9ef4c25f")
    @Override
    public Object visitCommunicationInteraction(CommunicationInteraction obj) {
        return visitBehavior(obj);

    }

    @objid ("c7962413-1480-4b07-a04f-9ef916fc6502")
    @Override
    public Object visitCommunicationMessage(CommunicationMessage obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("50c3901d-e15f-49ba-9be6-5fcae9cbe6e3")
    @Override
    public Object visitCommunicationNode(CommunicationNode obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("84a17afb-73fa-48e3-a7e5-e5a844527043")
    @Override
    public Object visitComponent(Component obj) {
        return visitClass(obj);

    }

    @objid ("8262dae9-d72a-40cc-b631-9e1417b1d41b")
    @Override
    public Object visitComponentRealization(ComponentRealization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("2b438aef-1327-4f2a-9f2f-117f40633b61")
    @Override
    public Object visitCompositeStructureDiagram(CompositeStructureDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("7eaf5796-b560-4037-b44f-6542818eb1a4")
    @Override
    public Object visitConditionalNode(ConditionalNode obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("783abd70-daf4-4473-b823-9bdda146aac3")
    @Override
    public Object visitConnectionPointReference(ConnectionPointReference obj) {
        return visitStateVertex(obj);

    }

    @objid ("6b96759f-d5dd-48e9-855e-205a74e4ebfd")
    @Override
    public Object visitConnector(Connector obj) {
        return visitLink(obj);

    }

    @objid ("76b372bc-d7be-475c-9aac-deac312d5c4d")
    @Override
    public Object visitConnectorEnd(ConnectorEnd obj) {
        return visitLinkEnd(obj);

    }

    @objid ("df774be6-6ab7-4f57-baf8-d951439fd972")
    @Override
    public Object visitConstraint(Constraint obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cefc896d-f48c-4704-9f51-2dc14adb6057")
    @Override
    public Object visitControlFlow(ControlFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("6457449d-462f-48d4-8d40-5249dc7cf5ea")
    @Override
    public Object visitControlNode(ControlNode obj) {
        return visitActivityNode(obj);

    }

    @objid ("0cef9f09-d8b9-4be4-9e6a-f00bf83df194")
    @Override
    public Object visitDataFlow(DataFlow obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("4e1c33d1-ef9b-4471-b731-154a846ee8f0")
    @Override
    public Object visitDataStoreNode(DataStoreNode obj) {
        return visitCentralBufferNode(obj);

    }

    @objid ("8ab6c610-069e-4a92-a179-17e75d7a7e3b")
    @Override
    public Object visitDataType(DataType obj) {
        return visitGeneralClass(obj);

    }

    @objid ("95ed99ae-36fd-4081-aa48-47ea034f7df8")
    @Override
    public Object visitDecisionMergeNode(DecisionMergeNode obj) {
        return visitControlNode(obj);

    }

    @objid ("e2b0cacf-27b8-424d-83b0-ce76695522be")
    @Override
    public Object visitDeepHistoryPseudoState(DeepHistoryPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("fd19e5ff-54ca-4b43-81b5-ac90311f55e5")
    @Override
    public Object visitDeploymentDiagram(DeploymentDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("5bc649be-611b-4574-925d-647ddc90651f")
    @Override
    public Object visitDurationConstraint(DurationConstraint obj) {
        return visitConstraint(obj);

    }

    @objid ("2e800e4f-1b61-4208-b974-79eb0b9bba5d")
    @Override
    public Object visitElementImport(ElementImport obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cbe6c470-1fca-4dbc-845a-3874ce8c7f2a")
    @Override
    public Object visitElementRealization(ElementRealization obj) {
        return visitAbstraction(obj);

    }

    @objid ("a8e640a3-ba23-4217-b0e8-62f74eefbed4")
    @Override
    public Object visitEntryPointPseudoState(EntryPointPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("eddb5393-f48e-4597-b3b4-c09d4409dec0")
    @Override
    public Object visitEnumeration(Enumeration obj) {
        return visitGeneralClass(obj);

    }

    @objid ("81c30f78-1bcb-4800-ba0e-7b05efb94b25")
    @Override
    public Object visitEnumerationLiteral(EnumerationLiteral obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("22fa8f2b-69e0-4e6d-aef1-8f03e6635c32")
    @Override
    public Object visitEvent(Event obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("2714343a-1e77-4afe-a713-ad61e21eeedd")
    @Override
    public Object visitExceptionHandler(ExceptionHandler obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("c69b2930-01d0-40ae-8025-6f8754b5b221")
    @Override
    public Object visitExecutionOccurenceSpecification(ExecutionOccurenceSpecification obj) {
        return visitMessageEnd(obj);

    }

    @objid ("63e9f734-e164-4ba9-bced-f59fb0885083")
    @Override
    public Object visitExecutionSpecification(ExecutionSpecification obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("160ecac7-5885-40f1-b68f-a332e318a9d7")
    @Override
    public Object visitExitPointPseudoState(ExitPointPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("46fe760b-f1c6-4637-be54-7a2179c59625")
    @Override
    public Object visitExpansionNode(ExpansionNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("751f600b-b025-4dc0-b3b6-24333ae5576b")
    @Override
    public Object visitExpansionRegion(ExpansionRegion obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("4429ba48-32d9-4cba-b526-6e3d92225946")
    @Override
    public Object visitExtensionPoint(ExtensionPoint obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("1e7b6041-0e9e-4e28-b11e-1da7d86b4e06")
    @Override
    public Object visitFeature(Feature obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("75a61dda-8627-4086-bf8e-aff5fd1f0038")
    @Override
    public Object visitFinalNode(FinalNode obj) {
        return visitControlNode(obj);

    }

    @objid ("a638e4fe-bbe8-41d5-92de-307aa613742e")
    @Override
    public Object visitFinalState(FinalState obj) {
        return visitState(obj);

    }

    @objid ("b945b463-0937-451c-b736-0255c2c28eb3")
    @Override
    public Object visitFlowFinalNode(FlowFinalNode obj) {
        return visitFinalNode(obj);

    }

    @objid ("4ef40b6b-5f01-4de0-bafe-6cdbf79b92be")
    @Override
    public Object visitForkJoinNode(ForkJoinNode obj) {
        return visitControlNode(obj);

    }

    @objid ("96380878-0d16-4c00-be41-073111c12777")
    @Override
    public Object visitForkPseudoState(ForkPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("6ebb2310-9d6f-4871-bbd9-f33a4749dab4")
    @Override
    public Object visitGate(Gate obj) {
        return visitMessageEnd(obj);

    }

    @objid ("3d2769b4-b413-42ee-ac13-493ecd7bc225")
    @Override
    public Object visitGeneralClass(GeneralClass obj) {
        return visitClassifier(obj);

    }

    @objid ("c22a9fa2-7821-479e-bfea-52d8cb64fc79")
    @Override
    public Object visitGeneralOrdering(GeneralOrdering obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitElement(obj) : null;

    }

    @objid ("a0747a38-3b3a-460d-a19c-7ada2fbcd8eb")
    @Override
    public Object visitGeneralization(Generalization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("e51ce0a4-9b29-4808-b3a6-2c10eaac85ff")
    @Override
    public Object visitInformationFlow(InformationFlow obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("a482ff2f-08e0-4e9d-9f93-afe840143a75")
    @Override
    public Object visitInformationItem(InformationItem obj) {
        return visitClassifier(obj);

    }

    @objid ("451de48c-e87c-45f5-a338-35b9e6cc0fba")
    @Override
    public Object visitInitialNode(InitialNode obj) {
        return visitControlNode(obj);

    }

    @objid ("88d57d9d-a150-41f8-ba74-170a20bf7706")
    @Override
    public Object visitInitialPseudoState(InitialPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("9bf385a2-cb25-41c4-b2c0-f4cc5e981d6c")
    @Override
    public Object visitInputPin(InputPin obj) {
        return visitPin(obj);

    }

    @objid ("096e1baa-d751-4b58-bacc-20bae5d00412")
    @Override
    public Object visitInstance(Instance obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("8d5b42d7-a291-483a-b66d-dfc046af2b61")
    @Override
    public Object visitInstanceNode(InstanceNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("68b9bb47-9691-4670-829c-9f83fe1b10c8")
    @Override
    public Object visitInteraction(Interaction obj) {
        return visitBehavior(obj);

    }

    @objid ("34da77e7-f690-4bb1-96d6-64b50ce8adb6")
    @Override
    public Object visitInteractionFragment(InteractionFragment obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("63b6b324-26c7-46be-8fb2-e40eb87342ff")
    @Override
    public Object visitInteractionOperand(InteractionOperand obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("19c9f118-796e-45e7-93f4-fd94329fc726")
    @Override
    public Object visitInteractionUse(InteractionUse obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("5547ea32-6063-4767-ac9d-498fae12647d")
    @Override
    public Object visitInterface(Interface obj) {
        return visitGeneralClass(obj);

    }

    @objid ("a59864c3-8d16-4fd7-9ba2-776180bd9fb2")
    @Override
    public Object visitInterfaceRealization(InterfaceRealization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("a8ce4dcf-9294-40dc-9da8-29959245b991")
    @Override
    public Object visitInternalTransition(InternalTransition obj) {
        return visitTransition(obj);

    }

    @objid ("8ed8af3f-c4ba-4326-87ed-a1ea6a9188cd")
    @Override
    public Object visitInterruptibleActivityRegion(InterruptibleActivityRegion obj) {
        return visitActivityGroup(obj);

    }

    @objid ("76403aa2-f173-430b-8b8c-93c6a794f036")
    @Override
    public Object visitJoinPseudoState(JoinPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("25b48c43-6125-4a50-adab-0bc9a40748a8")
    @Override
    public Object visitJunctionPseudoState(JunctionPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("5987049f-15b4-4064-826b-a37f120d5fdc")
    @Override
    public Object visitLifeline(Lifeline obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("7144478d-335a-4487-a16c-b83a065b7612")
    @Override
    public Object visitLink(Link obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("58d67ed7-a598-4af5-a4e0-cd01dc6789ae")
    @Override
    public Object visitLinkEnd(LinkEnd obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cda24285-dc8a-478a-80b7-2425fa0200d4")
    @Override
    public Object visitLoopNode(LoopNode obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("c218a5a3-690f-4deb-9b27-397f5bce6d23")
    @Override
    public Object visitManifestation(Manifestation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("84bad60c-2cea-4975-8176-268531cf5ed3")
    @Override
    public Object visitMessage(Message obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("88161c2f-63d6-4017-9e94-fb680360132c")
    @Override
    public Object visitMessageEnd(MessageEnd obj) {
        return visitOccurrenceSpecification(obj);

    }

    @objid ("88776eb4-36bd-4633-ac4b-418e4a7717e0")
    @Override
    public Object visitMessageFlow(MessageFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("2cc72bd4-2221-4cfa-a043-14fca32ad570")
    @Override
    public Object visitModelTree(ModelTree obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("fe5bc741-5933-444d-b222-161a2b8fbefb")
    @Override
    public Object visitNameSpace(NameSpace obj) {
        return visitModelTree(obj);

    }

    @objid ("3dfe310e-3f96-4432-8dbc-5dc73f8b6163")
    @Override
    public Object visitNaryAssociation(NaryAssociation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("42a9c4fb-73f9-4a43-8da6-3a80995cb06a")
    @Override
    public Object visitNaryAssociationEnd(NaryAssociationEnd obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("2b10f0f1-cd45-4190-9c2e-93e744d24eaf")
    @Override
    public Object visitNaryConnector(NaryConnector obj) {
        return visitNaryLink(obj);

    }

    @objid ("15b6b872-eb4c-407b-a59c-d6e680740703")
    @Override
    public Object visitNaryConnectorEnd(NaryConnectorEnd obj) {
        return visitNaryLinkEnd(obj);

    }

    @objid ("3a325abc-a340-4d32-9377-9467d1069644")
    @Override
    public Object visitNaryLink(NaryLink obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("3f7dacc0-3f53-4e48-a1c5-e809c3cffa57")
    @Override
    public Object visitNaryLinkEnd(NaryLinkEnd obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("2321f215-b545-4a7e-9fde-8713d8674545")
    @Override
    public Object visitNode(Node obj) {
        return visitClassifier(obj);

    }

    @objid ("12c0dfd2-bc8c-4b5c-972f-9f927ee34a87")
    @Override
    public Object visitObjectDiagram(ObjectDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("d90789b9-359d-4e1d-9068-64bfd7c3da9b")
    @Override
    public Object visitObjectFlow(ObjectFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("52d9a0e9-eb6f-4b96-96da-7c7110ba6d01")
    @Override
    public Object visitObjectNode(ObjectNode obj) {
        return visitActivityNode(obj);

    }

    @objid ("8e216273-8bb3-4af3-adc0-720998cc7ed2")
    @Override
    public Object visitOccurrenceSpecification(OccurrenceSpecification obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("a9dac03d-ea4c-4a15-acd3-3a078a65cc4b")
    @Override
    public Object visitOpaqueAction(OpaqueAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("017566d3-a767-4bbf-b4aa-8c6b844ba99f")
    @Override
    public Object visitOpaqueBehavior(OpaqueBehavior obj) {
        return visitBehavior(obj);

    }

    @objid ("383d019c-37d7-4369-8a2a-2b59557718e9")
    @Override
    public Object visitOperation(Operation obj) {
        return visitBehavioralFeature(obj);

    }

    @objid ("66aa2a99-0afe-4faa-a1ed-cf6d518f4b58")
    @Override
    public Object visitOutputPin(OutputPin obj) {
        return visitPin(obj);

    }

    @objid ("7a969e90-3f00-4857-aa2e-2fa47d50cb3c")
    @Override
    public Object visitPackage(Package obj) {
        return visitNameSpace(obj);

    }

    @objid ("3afe090f-8f35-4eef-8dcc-7e3d35998d88")
    @Override
    public Object visitPackageImport(PackageImport obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("17a837e4-6534-488d-b23f-b8b1ee5d3243")
    @Override
    public Object visitPackageMerge(PackageMerge obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("bcddb87f-8535-44dc-af52-0b584378ff59")
    @Override
    public Object visitParameter(Parameter obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("c275e89b-b35f-4c24-ab73-2d8362554c1b")
    @Override
    public Object visitPartDecomposition(PartDecomposition obj) {
        return visitInteractionUse(obj);

    }

    @objid ("945ddd78-7ebd-4077-9571-c1a68c0e5877")
    @Override
    public Object visitPin(Pin obj) {
        return visitObjectNode(obj);

    }

    @objid ("6c601a00-d0ab-4a26-b627-afa36fed4d0c")
    @Override
    public Object visitPort(Port obj) {
        return visitBindableInstance(obj);

    }

    @objid ("c7592715-1a69-4dd6-845a-120fded2c296")
    @Override
    public Object visitProject(Project obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractProject(obj) : null;

    }

    @objid ("0a38541f-2e9b-4c29-a582-9ac41184bf7e")
    @Override
    public Object visitProvidedInterface(ProvidedInterface obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("871066c9-bcef-44f3-bca8-9246c72a38ac")
    @Override
    public Object visitRaisedException(RaisedException obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("1f377d2c-38d4-474d-92a7-8147f1708d53")
    @Override
    public Object visitRegion(Region obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("44f306c0-14db-4a57-b1be-f5412e23f059")
    @Override
    public Object visitRequiredInterface(RequiredInterface obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("71da79d7-3b73-4ecc-89a4-93be5b03732e")
    @Override
    public Object visitSendSignalAction(SendSignalAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("7e9e965f-7626-482f-b3d5-206bb9fb49ac")
    @Override
    public Object visitSequenceDiagram(SequenceDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("cb431342-2642-46c8-b5a3-f58bf59a7dad")
    @Override
    public Object visitShallowHistoryPseudoState(ShallowHistoryPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("02f4d0a4-be0a-4acb-8e42-158f99373a41")
    @Override
    public Object visitSignal(Signal obj) {
        return visitGeneralClass(obj);

    }

    @objid ("2261af84-509d-4120-b7db-0691d6eb2c7e")
    @Override
    public Object visitState(State obj) {
        return visitStateVertex(obj);

    }

    @objid ("b9a2cd61-f768-42cf-8dd1-dc35871f92f7")
    @Override
    public Object visitStateInvariant(StateInvariant obj) {
        return visitOccurrenceSpecification(obj);

    }

    @objid ("742e364a-8497-4c04-94a7-75d69fcf5719")
    @Override
    public Object visitStateMachine(StateMachine obj) {
        return visitBehavior(obj);

    }

    @objid ("907e5ed3-be51-46be-b731-1794300e63ef")
    @Override
    public Object visitStateMachineDiagram(StateMachineDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("baf35884-4920-486b-95b5-abec2883f93e")
    @Override
    public Object visitStateVertex(StateVertex obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("7d4a44a9-2873-4071-bb72-cfd98dbef6a3")
    @Override
    public Object visitStaticDiagram(StaticDiagram obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitAbstractDiagram(obj) : null;

    }

    @objid ("0977312d-f395-4272-aed3-6259ce9573a5")
    @Override
    public Object visitStructuralFeature(StructuralFeature obj) {
        return visitFeature(obj);

    }

    @objid ("c6ee300a-1de2-43cf-954c-9a466b3daed8")
    @Override
    public Object visitStructuredActivityNode(StructuredActivityNode obj) {
        return visitActivityAction(obj);

    }

    @objid ("3e83c777-4f72-49f1-9048-73100467058d")
    @Override
    public Object visitSubstitution(Substitution obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("2bcaa9ee-ea91-4c3a-8479-3e56e5364b1a")
    @Override
    public Object visitTemplateBinding(TemplateBinding obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("95047e34-f8b6-43bc-9781-196c7bdbff42")
    @Override
    public Object visitTemplateParameter(TemplateParameter obj) {
        return visitGeneralClass(obj);

    }

    @objid ("9b085bd5-8ff1-463b-aa0b-bd991314b669")
    @Override
    public Object visitTemplateParameterSubstitution(TemplateParameterSubstitution obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("6c16451e-f89d-441e-822c-066d7818477a")
    @Override
    public Object visitTerminatePseudoState(TerminatePseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("76510692-39a4-4c49-a863-be5c72d62b1c")
    @Override
    public Object visitTerminateSpecification(TerminateSpecification obj) {
        return visitExecutionOccurenceSpecification(obj);

    }

    @objid ("b556941e-5d4c-4de9-9c52-b1a5e9a56568")
    @Override
    public Object visitTransition(Transition obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("b3414739-497d-4c0d-bf89-5ad07b91fc7c")
    @Override
    public Object visitUmlModelElement(UmlModelElement obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitModelElement(obj) : null;

    }

    @objid ("872532c8-19c5-436c-98f6-a3fac2b8e83d")
    @Override
    public Object visitUsage(Usage obj) {
        return this.infrastructureVisitor != null ? this.infrastructureVisitor.visitDependency(obj) : null;

    }

    @objid ("17d144a0-7361-4a91-b42a-ba3c5839c50e")
    @Override
    public Object visitUseCase(UseCase obj) {
        return visitGeneralClass(obj);

    }

    @objid ("3ad613c9-03d4-4182-9f4a-6de6c2e5a390")
    @Override
    public Object visitUseCaseDependency(UseCaseDependency obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("43989c27-33fc-44c1-95ea-e955ebe55763")
    @Override
    public Object visitUseCaseDiagram(UseCaseDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("5b1031b9-bbdc-4ae7-a0ed-a8696b606a96")
    @Override
    public Object visitValuePin(ValuePin obj) {
        return visitInputPin(obj);

    }

}
