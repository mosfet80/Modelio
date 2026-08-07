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
 * This interface is an implementation of {@link IModelVisitor} whose default strategy consists in transmitting the visit() call to the super class visit method.
 * <p>On root metaclasses, the visitor tries to delegate the parent metaclass metamodel visitor if available.If not available, <code>null</code> is returned.
 */
@objid ("f3891086-541e-4b45-aa3f-564ccb1cb308")
public interface IDefaultModelVisitor extends IModelVisitor {
    /**
     * Get the visitor to delegate to when a {@link IInfrastructureVisitor} is needed.
     * <p>If null is returned the caller will return null.
     *
     * @return the {@link IInfrastructureVisitor} visitor or <i>null</i>.
     */
    @objid ("2aadc6fb-45a9-498c-acf1-80131670b97e")
    abstract IInfrastructureVisitor getInfrastructureVisitor();

    @objid ("25dfe577-c9af-49af-bf66-48777ab38952")
    @Override
    default Object visitAbstractPseudoState(AbstractPseudoState obj) {
        return visitStateVertex(obj);

    }

    @objid ("fa5f30c2-da3b-4215-bcef-add03039b855")
    @Override
    default Object visitAbstraction(Abstraction obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitDependency(obj);
        else
          return null;

    }

    @objid ("ee113d2d-060b-4dd7-bb72-2325c26382cf")
    @Override
    default Object visitAcceptCallEventAction(AcceptCallEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("07a6c98e-964b-4199-9fed-bb021d3593a8")
    @Override
    default Object visitAcceptChangeEventAction(AcceptChangeEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("58ee346f-8cea-4dcb-9458-37db90f96770")
    @Override
    default Object visitAcceptSignalAction(AcceptSignalAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("920e08ca-cd66-41bd-81c3-eff2c81fc054")
    @Override
    default Object visitAcceptTimeEventAction(AcceptTimeEventAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("3a51a5b5-f796-4389-8fc0-db329ec97526")
    @Override
    default Object visitActivity(Activity obj) {
        return visitBehavior(obj);

    }

    @objid ("97162945-478b-4f99-b8bc-1bf555586de2")
    @Override
    default Object visitActivityAction(ActivityAction obj) {
        return visitActivityNode(obj);

    }

    @objid ("c131b148-b606-46ad-9188-dd6839e61435")
    @Override
    default Object visitActivityDiagram(ActivityDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("4f2f27a0-1d99-4894-b41d-c20cf48042aa")
    @Override
    default Object visitActivityEdge(ActivityEdge obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("18a4eb79-6228-44a0-a4d8-168536fd98be")
    @Override
    default Object visitActivityFinalNode(ActivityFinalNode obj) {
        return visitFinalNode(obj);

    }

    @objid ("02ab670d-85b7-473c-af01-94f4bb704b5f")
    @Override
    default Object visitActivityGroup(ActivityGroup obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("5e798ef0-258f-4b93-b46b-6cca102a3fca")
    @Override
    default Object visitActivityNode(ActivityNode obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("43c15381-4acc-40d9-81c0-e29c153273b2")
    @Override
    default Object visitActivityParameterNode(ActivityParameterNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("5e41b068-5f70-401b-83ed-2a55ae24579b")
    @Override
    default Object visitActivityPartition(ActivityPartition obj) {
        return visitActivityGroup(obj);

    }

    @objid ("c4792175-3783-4677-bf55-01433b85e894")
    @Override
    default Object visitActor(Actor obj) {
        return visitGeneralClass(obj);

    }

    @objid ("bf0edb53-c5b8-45e9-aeda-ef437f7123b7")
    @Override
    default Object visitArtifact(Artifact obj) {
        return visitClassifier(obj);

    }

    @objid ("938f101f-2d6c-44cf-aae7-1c2a8668ade9")
    @Override
    default Object visitAssociation(Association obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("1dce72e3-e5d1-4666-b211-15afb4d75f9f")
    @Override
    default Object visitAssociationEnd(AssociationEnd obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("b87039b5-6a70-4c74-a0f0-1706cd145ced")
    @Override
    default Object visitAttribute(Attribute obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("3c14bc1a-8bdb-4981-b96e-9601f2a42874")
    @Override
    default Object visitAttributeLink(AttributeLink obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("02d0567a-6253-49b3-a501-f6b967221a1b")
    @Override
    default Object visitBehavior(Behavior obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("836c823c-f1cc-465d-964c-d0b6811437e9")
    @Override
    default Object visitBehaviorDiagram(BehaviorDiagram obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractDiagram(obj);
        else
          return null;

    }

    @objid ("4d61381b-0859-4b84-b59f-1cb7d28e9495")
    @Override
    default Object visitBehaviorParameter(BehaviorParameter obj) {
        return visitParameter(obj);

    }

    @objid ("1261cd65-5ed4-4600-82b3-c096b7727a13")
    @Override
    default Object visitBehavioralFeature(BehavioralFeature obj) {
        return visitFeature(obj);

    }

    @objid ("880171f2-4ff6-4773-8521-8f2256754810")
    @Override
    default Object visitBindableInstance(BindableInstance obj) {
        return visitInstance(obj);

    }

    @objid ("165d6158-26e7-4017-9799-b9a790ec8492")
    @Override
    default Object visitBinding(Binding obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("55d80eaa-f295-4ba9-aab7-329edd75783d")
    @Override
    default Object visitBpmnActivity(BpmnActivity obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("7f058cc0-219d-43ac-a816-5c84081d967c")
    @Override
    default Object visitBpmnAdHocSubProcess(BpmnAdHocSubProcess obj) {
        return visitBpmnSubProcess(obj);

    }

    @objid ("95da5e2f-72b4-456a-99ee-b55cf5391904")
    @Override
    default Object visitBpmnArtifact(BpmnArtifact obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("f9ed8a7e-88fc-4fe8-ba46-aacf82097ff0")
    @Override
    default Object visitBpmnAssociation(BpmnAssociation obj) {
        return visitBpmnArtifact(obj);

    }

    @objid ("1a5331af-1cc7-4486-9964-3e56b8f1a2bb")
    @Override
    default Object visitBpmnBaseElement(BpmnBaseElement obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitModelElement(obj);
        else
          return null;

    }

    @objid ("9a4d19bd-dbb4-4e62-85bd-2c8361fb8349")
    @Override
    default Object visitBpmnBoundaryEvent(BpmnBoundaryEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("802500c3-fc70-42b0-9d29-314821617e0f")
    @Override
    default Object visitBpmnBusinessRuleTask(BpmnBusinessRuleTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("f29dfae0-babf-45c1-890c-63bffdc1dc3d")
    @Override
    default Object visitBpmnCallActivity(BpmnCallActivity obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("ce22294f-ca8e-46a8-893c-c7fb6706019e")
    @Override
    default Object visitBpmnCancelEventDefinition(BpmnCancelEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("29c30daf-41ba-40fa-86d3-6c309d3516a1")
    @Override
    default Object visitBpmnCatchEvent(BpmnCatchEvent obj) {
        return visitBpmnEvent(obj);

    }

    @objid ("5bc37ff0-01ef-4fc5-b169-92117f9cdf5d")
    @Override
    default Object visitBpmnCollaboration(BpmnCollaboration obj) {
        return visitBehavior(obj);

    }

    @objid ("aee1438b-49f2-41ad-b88a-08cfd248116a")
    @Override
    default Object visitBpmnCollaborationDiagram(BpmnCollaborationDiagram obj) {
        return visitBpmnProcessCollaborationDiagram(obj);

    }

    @objid ("e673868b-8469-4ab1-8286-a877bd05e70b")
    @Override
    default Object visitBpmnCompensateEventDefinition(BpmnCompensateEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("2f141d87-be11-4a9e-b22e-143759b89d49")
    @Override
    default Object visitBpmnComplexBehaviorDefinition(BpmnComplexBehaviorDefinition obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("8c943905-1b48-4ed4-976e-608ff5840ff1")
    @Override
    default Object visitBpmnComplexGateway(BpmnComplexGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("c77a6c83-73fc-4346-b102-496f272822e1")
    @Override
    default Object visitBpmnConditionalEventDefinition(BpmnConditionalEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("f6c39f16-38ad-458f-86b0-e497d411b7d1")
    @Override
    default Object visitBpmnDataAssociation(BpmnDataAssociation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("39b47edd-bed8-4ab8-8a74-b810283ff72a")
    @Override
    default Object visitBpmnDataInput(BpmnDataInput obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("981cfa80-4136-45c8-bd97-dfa7a80b35e2")
    @Override
    default Object visitBpmnDataObject(BpmnDataObject obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("73881b70-fb91-411a-9b32-cdffe41cc573")
    @Override
    default Object visitBpmnDataOutput(BpmnDataOutput obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("cccf535d-6c2b-42cd-8971-66c9902561f7")
    @Override
    default Object visitBpmnDataState(BpmnDataState obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("958672e4-395c-495e-acad-47f638c33b52")
    @Override
    default Object visitBpmnDataStore(BpmnDataStore obj) {
        return visitBpmnItemAwareElement(obj);

    }

    @objid ("81f1a244-24a3-4a8a-8625-3dd2c23c767e")
    @Override
    default Object visitBpmnEndEvent(BpmnEndEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("fc8628de-c30d-44c2-b9e3-3f17826e9a2d")
    @Override
    default Object visitBpmnEndPoint(BpmnEndPoint obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("c4ea9194-202d-4159-aa3a-ff2650587020")
    @Override
    default Object visitBpmnErrorEventDefinition(BpmnErrorEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("f5a2513c-0b2d-4179-bd1a-fedb8fc3718f")
    @Override
    default Object visitBpmnEscalationEventDefinition(BpmnEscalationEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("99380e76-4693-4aa6-9433-cade8bbc3ca9")
    @Override
    default Object visitBpmnEvent(BpmnEvent obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("8db4d212-359b-4888-a9e8-16aabb858b13")
    @Override
    default Object visitBpmnEventBasedGateway(BpmnEventBasedGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("2448330c-9a47-4ac3-b87e-a07fe2b220da")
    @Override
    default Object visitBpmnEventDefinition(BpmnEventDefinition obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("7220cff5-8cbf-4a51-b103-f8e11a7047bd")
    @Override
    default Object visitBpmnExclusiveGateway(BpmnExclusiveGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("ebda2b73-985a-4a91-84be-a96ae5d62e58")
    @Override
    default Object visitBpmnFlowElement(BpmnFlowElement obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("5af5557f-fde3-475a-a5c1-ac56fd36b6c6")
    @Override
    default Object visitBpmnFlowNode(BpmnFlowNode obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("2a2a8ccf-2201-4152-9c90-0bc07a165860")
    @Override
    default Object visitBpmnGateway(BpmnGateway obj) {
        return visitBpmnFlowNode(obj);

    }

    @objid ("85c01f2c-a024-48ec-88eb-2f59c769fa19")
    @Override
    default Object visitBpmnGroup(BpmnGroup obj) {
        return visitBpmnArtifact(obj);

    }

    @objid ("70da1ddc-2bdd-4e15-b0e6-617e96e103ec")
    @Override
    default Object visitBpmnImplicitThrowEvent(BpmnImplicitThrowEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("30713410-4d12-4545-a815-e9bdf3132af7")
    @Override
    default Object visitBpmnInclusiveGateway(BpmnInclusiveGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("7ea309a3-6553-4492-b948-4bd012fefb7d")
    @Override
    default Object visitBpmnInterface(BpmnInterface obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("bdb7a983-78e5-4f87-9b7d-33042d71f8cd")
    @Override
    default Object visitBpmnIntermediateCatchEvent(BpmnIntermediateCatchEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("16ccf642-39de-4c58-9d71-9d55a0b34c02")
    @Override
    default Object visitBpmnIntermediateThrowEvent(BpmnIntermediateThrowEvent obj) {
        return visitBpmnThrowEvent(obj);

    }

    @objid ("20234653-f024-4208-aa84-457d36fdaea1")
    @Override
    default Object visitBpmnItemAwareElement(BpmnItemAwareElement obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("2192a581-73db-46fe-bdf9-0de241265d40")
    @Override
    default Object visitBpmnItemDefinition(BpmnItemDefinition obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("6b9b93df-fdd2-419e-bce9-7ea68625bdc2")
    @Override
    default Object visitBpmnLane(BpmnLane obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("4775e41c-f3fd-492a-9015-6bb9e814b9f7")
    @Override
    default Object visitBpmnLaneSet(BpmnLaneSet obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("9deb6c1e-b8bf-474f-add1-1ab9cf17976e")
    @Override
    default Object visitBpmnLinkEventDefinition(BpmnLinkEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("02bf4f93-fa14-41e3-ab2b-963ae889e212")
    @Override
    default Object visitBpmnLoopCharacteristics(BpmnLoopCharacteristics obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("3d5b3662-9095-4b80-881b-5fafeff95061")
    @Override
    default Object visitBpmnManualTask(BpmnManualTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("fdb9d4bb-c2d6-4bd7-bbea-7a7181330556")
    @Override
    default Object visitBpmnMessage(BpmnMessage obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("021be1ea-8409-4203-b0a9-3516115762be")
    @Override
    default Object visitBpmnMessageEventDefinition(BpmnMessageEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("542ef07b-43ea-4271-ad33-72808cf4c95d")
    @Override
    default Object visitBpmnMessageFlow(BpmnMessageFlow obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("6f03110c-3e07-40cf-953a-cf5cd37afc3d")
    @Override
    default Object visitBpmnMultiInstanceLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics obj) {
        return visitBpmnLoopCharacteristics(obj);

    }

    @objid ("b7bad84a-1853-43ac-9580-b04c9a257244")
    @Override
    default Object visitBpmnOperation(BpmnOperation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("c28d2926-31f9-4f6f-9dd5-07458d08337d")
    @Override
    default Object visitBpmnParallelGateway(BpmnParallelGateway obj) {
        return visitBpmnGateway(obj);

    }

    @objid ("a34f06cf-6404-4e40-8730-9496303bcb2b")
    @Override
    default Object visitBpmnParticipant(BpmnParticipant obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("7507a9af-1acc-4dc6-acb3-f87a9a07e956")
    @Override
    default Object visitBpmnProcess(BpmnProcess obj) {
        return visitBehavior(obj);

    }

    @objid ("60104391-8a15-4acb-98a6-39f8b5f2351d")
    @Override
    default Object visitBpmnProcessCollaborationDiagram(BpmnProcessCollaborationDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("7356368f-5eb6-4b8b-bbf4-da91ecbf1840")
    @Override
    default Object visitBpmnProcessDesignDiagram(BpmnProcessDesignDiagram obj) {
        return visitBpmnProcessCollaborationDiagram(obj);

    }

    @objid ("bb69d83e-2dfe-4de0-8eb1-8bc201cce55f")
    @Override
    default Object visitBpmnReceiveTask(BpmnReceiveTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("7227de83-9725-4008-982b-eae370104db5")
    @Override
    default Object visitBpmnResource(BpmnResource obj) {
        return visitBpmnSharedElement(obj);

    }

    @objid ("f6a2a933-f4f8-4784-9950-483926d78e40")
    @Override
    default Object visitBpmnResourceParameter(BpmnResourceParameter obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("d3209ea2-a31c-470d-83f8-6d4eaabc6c25")
    @Override
    default Object visitBpmnResourceParameterBinding(BpmnResourceParameterBinding obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("e321000d-3fbd-45d3-aa0e-136928cfc587")
    @Override
    default Object visitBpmnResourceRole(BpmnResourceRole obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("18d753b9-4a94-43e5-93fd-5489e8d129f9")
    @Override
    default Object visitBpmnScriptTask(BpmnScriptTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("92116851-5063-4cf6-b1a4-34bbbd7088d5")
    @Override
    default Object visitBpmnSendTask(BpmnSendTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("bdc6b0ae-e059-46dc-9336-f8a72d3b9aaf")
    @Override
    default Object visitBpmnSequenceFlow(BpmnSequenceFlow obj) {
        return visitBpmnFlowElement(obj);

    }

    @objid ("259adb28-9a0c-4b63-9a31-e1a22671ec92")
    @Override
    default Object visitBpmnSequenceFlowDataAssociation(BpmnSequenceFlowDataAssociation obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("647430ad-e8cb-418a-9b46-0168a291eba0")
    @Override
    default Object visitBpmnServiceTask(BpmnServiceTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("a8ce0e2e-9477-48f0-a743-160700161426")
    @Override
    default Object visitBpmnSharedDefinitions(BpmnSharedDefinitions obj) {
        return visitBehavior(obj);

    }

    @objid ("a525f975-b98c-4241-b8fd-05b3c3333ccb")
    @Override
    default Object visitBpmnSharedElement(BpmnSharedElement obj) {
        return visitBpmnBaseElement(obj);

    }

    @objid ("cb53dd60-dd4b-44d9-98df-88ea1efec622")
    @Override
    default Object visitBpmnSignalEventDefinition(BpmnSignalEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("0aa49db4-305a-4a11-88d0-b0fb452d1916")
    @Override
    default Object visitBpmnStandardLoopCharacteristics(BpmnStandardLoopCharacteristics obj) {
        return visitBpmnLoopCharacteristics(obj);

    }

    @objid ("3da13ff5-94f9-45a9-a66b-31b9c7ea6f04")
    @Override
    default Object visitBpmnStartEvent(BpmnStartEvent obj) {
        return visitBpmnCatchEvent(obj);

    }

    @objid ("ab370896-06d3-4795-a25d-2604917203c3")
    @Override
    default Object visitBpmnSubProcess(BpmnSubProcess obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("927137be-e836-40ae-9551-f45e0de18a69")
    @Override
    default Object visitBpmnSubProcessDiagram(BpmnSubProcessDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("41e07f56-653c-43cc-9b25-68f47bd1898b")
    @Override
    default Object visitBpmnTask(BpmnTask obj) {
        return visitBpmnActivity(obj);

    }

    @objid ("43bd21e6-851a-47dd-aa76-ed32d0e7ca84")
    @Override
    default Object visitBpmnTerminateEventDefinition(BpmnTerminateEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("e7a4aac2-eb6a-4460-8d25-1f898338f011")
    @Override
    default Object visitBpmnThrowEvent(BpmnThrowEvent obj) {
        return visitBpmnEvent(obj);

    }

    @objid ("cc79681d-04f2-4c49-8032-7bad13da5a14")
    @Override
    default Object visitBpmnTimerEventDefinition(BpmnTimerEventDefinition obj) {
        return visitBpmnEventDefinition(obj);

    }

    @objid ("1135519d-03db-4053-acbb-c239cc752c21")
    @Override
    default Object visitBpmnTransaction(BpmnTransaction obj) {
        return visitBpmnSubProcess(obj);

    }

    @objid ("ee37d11e-4a13-4561-9e7f-adea76deaf47")
    @Override
    default Object visitBpmnUserTask(BpmnUserTask obj) {
        return visitBpmnTask(obj);

    }

    @objid ("37706c04-8e9a-45bd-9f47-c6fd14acd99a")
    @Override
    default Object visitCallAction(CallAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("b64ea344-b665-48b8-9be4-11d53d334046")
    @Override
    default Object visitCallBehaviorAction(CallBehaviorAction obj) {
        return visitCallAction(obj);

    }

    @objid ("5ee33b12-dfc2-4bba-bb29-150a65aa7f46")
    @Override
    default Object visitCallOperationAction(CallOperationAction obj) {
        return visitCallAction(obj);

    }

    @objid ("e2cac4a0-971d-4ea1-9722-061133b87b0e")
    @Override
    default Object visitCentralBufferNode(CentralBufferNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("904b0e81-12a0-4d3d-a12a-23e7ff907b1d")
    @Override
    default Object visitChoicePseudoState(ChoicePseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("75bb7d24-6c1d-4dd5-a094-fc0984e7b06d")
    @Override
    default Object visitClass(Class obj) {
        return visitGeneralClass(obj);

    }

    @objid ("0130af1b-5e3a-49bf-8365-61a6b8c69700")
    @Override
    default Object visitClassAssociation(ClassAssociation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cf7df430-6c0b-44c1-9d57-bf1e8d43672e")
    @Override
    default Object visitClassDiagram(ClassDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("25e26e8d-c551-401f-b57c-74402c7a707e")
    @Override
    default Object visitClassifier(Classifier obj) {
        return visitNameSpace(obj);

    }

    @objid ("a99f6bc4-7cf6-439a-9702-5561d2377ebb")
    @Override
    default Object visitClause(Clause obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("19ca6e9f-d5a3-4937-a6f1-52952e550f38")
    @Override
    default Object visitCollaboration(Collaboration obj) {
        return visitNameSpace(obj);

    }

    @objid ("22ee9bc0-f769-4980-b1ea-dbbda32316de")
    @Override
    default Object visitCollaborationUse(CollaborationUse obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("8e0a74ee-39f4-42c5-bd59-7e3d974faed8")
    @Override
    default Object visitCombinedFragment(CombinedFragment obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("17fa3aab-9b7e-4ac8-a2eb-fd3ed9c2b97c")
    @Override
    default Object visitCommunicationChannel(CommunicationChannel obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("4b1b33f9-2cdc-4579-8b6e-4440baf054b7")
    @Override
    default Object visitCommunicationDiagram(CommunicationDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("4fdd8ec1-dad2-4c52-9b02-294b6d878638")
    @Override
    default Object visitCommunicationInteraction(CommunicationInteraction obj) {
        return visitBehavior(obj);

    }

    @objid ("2fd10344-cade-4e85-bcd6-a99af1a10129")
    @Override
    default Object visitCommunicationMessage(CommunicationMessage obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("4c439976-46ee-4f1b-9457-9c54a29dfbd7")
    @Override
    default Object visitCommunicationNode(CommunicationNode obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("39089a99-97ee-42ea-8973-8576ae3c15f5")
    @Override
    default Object visitComponent(Component obj) {
        return visitClass(obj);

    }

    @objid ("b61c53f1-7904-4208-be02-6df5186c1768")
    @Override
    default Object visitComponentRealization(ComponentRealization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("da23d4b1-991e-4508-8836-58d76d52816e")
    @Override
    default Object visitCompositeStructureDiagram(CompositeStructureDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("5416e82b-92c2-40d8-a043-0e058c51bf32")
    @Override
    default Object visitConditionalNode(ConditionalNode obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("6fd34bbf-9f68-407c-8a1d-da20350a3488")
    @Override
    default Object visitConnectionPointReference(ConnectionPointReference obj) {
        return visitStateVertex(obj);

    }

    @objid ("d7f1f7ab-b737-43ac-985a-e3af46e2b38d")
    @Override
    default Object visitConnector(Connector obj) {
        return visitLink(obj);

    }

    @objid ("95d1932a-0a1c-4e6e-931c-2264eaad9fdc")
    @Override
    default Object visitConnectorEnd(ConnectorEnd obj) {
        return visitLinkEnd(obj);

    }

    @objid ("8303f75e-ac0c-4329-847d-03e40ee13a91")
    @Override
    default Object visitConstraint(Constraint obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("a78235d3-5845-4a17-880c-a9c8603558b2")
    @Override
    default Object visitControlFlow(ControlFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("faef397c-8644-4a62-b070-b4d54443fa68")
    @Override
    default Object visitControlNode(ControlNode obj) {
        return visitActivityNode(obj);

    }

    @objid ("18a0c47a-1c82-4668-8910-37d81ad98a11")
    @Override
    default Object visitDataFlow(DataFlow obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("f5514d48-964a-4950-817c-9a1beeab7c1a")
    @Override
    default Object visitDataStoreNode(DataStoreNode obj) {
        return visitCentralBufferNode(obj);

    }

    @objid ("873f70f0-8617-4a75-934a-9a3d41ab65c6")
    @Override
    default Object visitDataType(DataType obj) {
        return visitGeneralClass(obj);

    }

    @objid ("54b15d88-edf4-4b71-a5d1-16e1537e08ec")
    @Override
    default Object visitDecisionMergeNode(DecisionMergeNode obj) {
        return visitControlNode(obj);

    }

    @objid ("6eb13d1f-7576-4741-a7b5-6d7535384b1b")
    @Override
    default Object visitDeepHistoryPseudoState(DeepHistoryPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("0d22f490-5f76-4dd0-8363-06e2379c8199")
    @Override
    default Object visitDeploymentDiagram(DeploymentDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("14a05290-6d22-4637-9c32-c295bd9ef4c9")
    @Override
    default Object visitDurationConstraint(DurationConstraint obj) {
        return visitConstraint(obj);

    }

    @objid ("276ba7e2-e50a-466c-8eca-453177721f4c")
    @Override
    default Object visitElementImport(ElementImport obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("91907636-08d2-4dff-a5c9-3354dc5a01c8")
    @Override
    default Object visitElementRealization(ElementRealization obj) {
        return visitAbstraction(obj);

    }

    @objid ("2c20faae-2981-4815-a058-93faa53689f7")
    @Override
    default Object visitEntryPointPseudoState(EntryPointPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("dc8719ef-6abf-406e-8154-e5f02ab62be8")
    @Override
    default Object visitEnumeration(Enumeration obj) {
        return visitGeneralClass(obj);

    }

    @objid ("8d1803c1-004d-453a-a51a-12d4fedd0450")
    @Override
    default Object visitEnumerationLiteral(EnumerationLiteral obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("162f015d-b65d-4bfb-9844-04aa36ba4b48")
    @Override
    default Object visitEvent(Event obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("c2c9bfed-daa9-49ef-8c05-4212db601b20")
    @Override
    default Object visitExceptionHandler(ExceptionHandler obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("b2f5fd48-1e8d-419f-8778-f9a922e0b872")
    @Override
    default Object visitExecutionOccurenceSpecification(ExecutionOccurenceSpecification obj) {
        return visitMessageEnd(obj);

    }

    @objid ("bcda351f-7e90-420a-8aaa-14616fbd5c00")
    @Override
    default Object visitExecutionSpecification(ExecutionSpecification obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("41cb70af-817c-4979-a513-c2ecd7bc176c")
    @Override
    default Object visitExitPointPseudoState(ExitPointPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("e52c28fc-d120-404f-9fc4-bba6d4840e22")
    @Override
    default Object visitExpansionNode(ExpansionNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("966e0f15-7477-4772-b658-d88e94e9ec34")
    @Override
    default Object visitExpansionRegion(ExpansionRegion obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("1319e540-7215-4db3-a6fa-3888e7a82f39")
    @Override
    default Object visitExtensionPoint(ExtensionPoint obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("7ced03eb-8d1e-4e11-8521-209aecb78ebf")
    @Override
    default Object visitFeature(Feature obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("c0049128-69b6-4ac9-9d14-1e835bfde479")
    @Override
    default Object visitFinalNode(FinalNode obj) {
        return visitControlNode(obj);

    }

    @objid ("c9f31cd1-7cd9-4efe-92d9-9b738737610d")
    @Override
    default Object visitFinalState(FinalState obj) {
        return visitState(obj);

    }

    @objid ("a1fbccca-1675-40e6-942a-eb939847cad8")
    @Override
    default Object visitFlowFinalNode(FlowFinalNode obj) {
        return visitFinalNode(obj);

    }

    @objid ("69ae0a6d-902a-4603-bb61-d524e369f7f8")
    @Override
    default Object visitForkJoinNode(ForkJoinNode obj) {
        return visitControlNode(obj);

    }

    @objid ("8ea48660-2de8-4548-a0ca-49582cd2ab99")
    @Override
    default Object visitForkPseudoState(ForkPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("489cf86e-5b9c-4d55-b1a1-4c40ea9b5ef4")
    @Override
    default Object visitGate(Gate obj) {
        return visitMessageEnd(obj);

    }

    @objid ("accf5555-29ef-4d91-a89a-926e2a4d2048")
    @Override
    default Object visitGeneralClass(GeneralClass obj) {
        return visitClassifier(obj);

    }

    @objid ("b3d2f9fa-2605-4945-96c5-d0e4d214b12e")
    @Override
    default Object visitGeneralOrdering(GeneralOrdering obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitElement(obj);
        else
          return null;

    }

    @objid ("6c03d158-f7ce-4903-bf4a-111d8527cea5")
    @Override
    default Object visitGeneralization(Generalization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("ceda46a2-14d1-4864-afbd-7e57fdb64117")
    @Override
    default Object visitInformationFlow(InformationFlow obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("ccc95596-1cea-497b-86fc-76639756def9")
    @Override
    default Object visitInformationItem(InformationItem obj) {
        return visitClassifier(obj);

    }

    @objid ("e26a0a53-7709-4f6d-bf97-2f9de04bf722")
    @Override
    default Object visitInitialNode(InitialNode obj) {
        return visitControlNode(obj);

    }

    @objid ("7583d4f2-b688-49e3-aed3-6f442998f70f")
    @Override
    default Object visitInitialPseudoState(InitialPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("b57dc790-7b1e-458b-bf21-1ac636093789")
    @Override
    default Object visitInputPin(InputPin obj) {
        return visitPin(obj);

    }

    @objid ("5efc9b56-fe82-40d7-9047-bd341c5a443f")
    @Override
    default Object visitInstance(Instance obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("1fe360eb-21cd-4112-8108-beb511f6f04b")
    @Override
    default Object visitInstanceNode(InstanceNode obj) {
        return visitObjectNode(obj);

    }

    @objid ("72c06dd3-6292-4523-8eed-cef067c5b052")
    @Override
    default Object visitInteraction(Interaction obj) {
        return visitBehavior(obj);

    }

    @objid ("2bbb7007-f969-4701-87e0-af311a8e1f0f")
    @Override
    default Object visitInteractionFragment(InteractionFragment obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cac83e1c-ee8b-4ac2-b4a1-4ab57c50326b")
    @Override
    default Object visitInteractionOperand(InteractionOperand obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("441483bf-bb04-4ca0-8750-a6562594949a")
    @Override
    default Object visitInteractionUse(InteractionUse obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("fb927852-1333-4af7-a426-2c1121b810d6")
    @Override
    default Object visitInterface(Interface obj) {
        return visitGeneralClass(obj);

    }

    @objid ("194b1b80-3c0a-486c-b1d6-b9a6bdb30721")
    @Override
    default Object visitInterfaceRealization(InterfaceRealization obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("18966726-9c98-494a-9af6-fae624729093")
    @Override
    default Object visitInternalTransition(InternalTransition obj) {
        return visitTransition(obj);

    }

    @objid ("ebd606aa-1372-4848-b597-c0adc03c1a47")
    @Override
    default Object visitInterruptibleActivityRegion(InterruptibleActivityRegion obj) {
        return visitActivityGroup(obj);

    }

    @objid ("f34874de-2683-49ee-9f66-9df2fa979682")
    @Override
    default Object visitJoinPseudoState(JoinPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("da02a1cc-4fe0-4675-b180-6a394e5fe574")
    @Override
    default Object visitJunctionPseudoState(JunctionPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("7d05b30e-1cfb-487d-9d41-ed9ac8ece27c")
    @Override
    default Object visitLifeline(Lifeline obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("15faf5c7-5e3e-4216-94f0-6a6da663800a")
    @Override
    default Object visitLink(Link obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("6be390d9-e28c-41ca-9279-916c4ff00668")
    @Override
    default Object visitLinkEnd(LinkEnd obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("ce852115-1ee3-499d-a23e-64189303e565")
    @Override
    default Object visitLoopNode(LoopNode obj) {
        return visitStructuredActivityNode(obj);

    }

    @objid ("14ce5c7a-4664-4170-921e-b951ac17b6c5")
    @Override
    default Object visitManifestation(Manifestation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("ba636faa-cbe6-40f2-9072-ed3e9455f6e6")
    @Override
    default Object visitMessage(Message obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("723e51f0-1ad7-45ea-ad1b-40722a6cb1ae")
    @Override
    default Object visitMessageEnd(MessageEnd obj) {
        return visitOccurrenceSpecification(obj);

    }

    @objid ("1ac2bc9f-45d3-41c0-9597-ec8da78bb845")
    @Override
    default Object visitMessageFlow(MessageFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("c4c89e36-61da-4b9e-b1df-ec6244d0077e")
    @Override
    default Object visitModelTree(ModelTree obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("3bc7aea5-e927-4a08-9275-bea753a40cbe")
    @Override
    default Object visitNameSpace(NameSpace obj) {
        return visitModelTree(obj);

    }

    @objid ("ace31603-7636-47b1-98fa-5c666fe6660f")
    @Override
    default Object visitNaryAssociation(NaryAssociation obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("918df5cd-4952-40d5-a6e3-680148b7fcef")
    @Override
    default Object visitNaryAssociationEnd(NaryAssociationEnd obj) {
        return visitStructuralFeature(obj);

    }

    @objid ("6fcc9603-d3ed-4379-9737-6c82a0be8639")
    @Override
    default Object visitNaryConnector(NaryConnector obj) {
        return visitNaryLink(obj);

    }

    @objid ("270326c2-0965-44ed-ac1d-2c46e3504db0")
    @Override
    default Object visitNaryConnectorEnd(NaryConnectorEnd obj) {
        return visitNaryLinkEnd(obj);

    }

    @objid ("595f14d2-c7e8-440a-9321-bb1e76aba02c")
    @Override
    default Object visitNaryLink(NaryLink obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("e34fdd53-a6b2-42da-8933-9249672f7f9f")
    @Override
    default Object visitNaryLinkEnd(NaryLinkEnd obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cb64bdfd-1129-4df7-8b0f-a20e98bd7c8d")
    @Override
    default Object visitNode(Node obj) {
        return visitClassifier(obj);

    }

    @objid ("6a806fa9-7244-43e6-9e48-bda4905f590d")
    @Override
    default Object visitObjectDiagram(ObjectDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("0e70744d-dece-4de3-8919-3ae079199727")
    @Override
    default Object visitObjectFlow(ObjectFlow obj) {
        return visitActivityEdge(obj);

    }

    @objid ("b82ff73e-1482-41e4-a1f6-bab1a35ce457")
    @Override
    default Object visitObjectNode(ObjectNode obj) {
        return visitActivityNode(obj);

    }

    @objid ("79c68383-4827-4cfd-bcd0-ee74f8cacfe9")
    @Override
    default Object visitOccurrenceSpecification(OccurrenceSpecification obj) {
        return visitInteractionFragment(obj);

    }

    @objid ("4c12873c-d9f7-43d5-ad56-d239723fff74")
    @Override
    default Object visitOpaqueAction(OpaqueAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("10199fd3-e821-4f1e-bea6-2cd3b46d2e96")
    @Override
    default Object visitOpaqueBehavior(OpaqueBehavior obj) {
        return visitBehavior(obj);

    }

    @objid ("d156d06d-57ee-4238-804e-4be820e3477c")
    @Override
    default Object visitOperation(Operation obj) {
        return visitBehavioralFeature(obj);

    }

    @objid ("a9bc2d54-30c1-4794-a788-274e77ec1667")
    @Override
    default Object visitOutputPin(OutputPin obj) {
        return visitPin(obj);

    }

    @objid ("eae143ef-e994-43fb-9f9e-7daa80d9a435")
    @Override
    default Object visitPackage(Package obj) {
        return visitNameSpace(obj);

    }

    @objid ("a0459963-1773-4d96-8531-980bd20d7eb0")
    @Override
    default Object visitPackageImport(PackageImport obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("dd4f72c0-8808-45a3-8b97-010aedf32b6b")
    @Override
    default Object visitPackageMerge(PackageMerge obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("f0999a74-be92-4741-a9c1-cef0de5e34ad")
    @Override
    default Object visitParameter(Parameter obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("d70c9ea5-95d4-44e6-a903-6bbc7bede320")
    @Override
    default Object visitPartDecomposition(PartDecomposition obj) {
        return visitInteractionUse(obj);

    }

    @objid ("7731aeb1-6c61-4c15-aebc-364b0f0cfe1e")
    @Override
    default Object visitPin(Pin obj) {
        return visitObjectNode(obj);

    }

    @objid ("dfe0d2ef-538d-4aad-82dc-f9eb60cc3db1")
    @Override
    default Object visitPort(Port obj) {
        return visitBindableInstance(obj);

    }

    @objid ("d449723e-97ae-409c-b263-13c293c38e1e")
    @Override
    default Object visitProject(Project obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractProject(obj);
        else
          return null;

    }

    @objid ("6fe5ee30-3125-44d1-ab09-550aaef2a3f6")
    @Override
    default Object visitProvidedInterface(ProvidedInterface obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("cad283d4-c346-45df-a04c-9a370dfd88a8")
    @Override
    default Object visitRaisedException(RaisedException obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("1c771f22-1af0-4000-b89c-d3f3a4620249")
    @Override
    default Object visitRegion(Region obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("964d3e30-cf01-4f8b-aa28-b0eb0b80e056")
    @Override
    default Object visitRequiredInterface(RequiredInterface obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("74be59b4-3dc6-4b43-851b-15e05ea80125")
    @Override
    default Object visitSendSignalAction(SendSignalAction obj) {
        return visitActivityAction(obj);

    }

    @objid ("3cd98d9b-cc20-4020-8c89-4444354ba318")
    @Override
    default Object visitSequenceDiagram(SequenceDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("7086bd2b-9461-4456-a604-44257b837465")
    @Override
    default Object visitShallowHistoryPseudoState(ShallowHistoryPseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("bce527a4-a26d-4817-8047-43613b076fe3")
    @Override
    default Object visitSignal(Signal obj) {
        return visitGeneralClass(obj);

    }

    @objid ("473a0b7f-1049-42f8-af28-c67198a542c7")
    @Override
    default Object visitState(State obj) {
        return visitStateVertex(obj);

    }

    @objid ("8e1ed8ec-9aea-4208-8547-bc3819e48bce")
    @Override
    default Object visitStateInvariant(StateInvariant obj) {
        return visitOccurrenceSpecification(obj);

    }

    @objid ("87dd8830-83ad-4134-ba02-f286b9fff168")
    @Override
    default Object visitStateMachine(StateMachine obj) {
        return visitBehavior(obj);

    }

    @objid ("111d6356-c5d6-4675-9506-149a5a81b0df")
    @Override
    default Object visitStateMachineDiagram(StateMachineDiagram obj) {
        return visitBehaviorDiagram(obj);

    }

    @objid ("29fa5c3b-3aa1-4e4c-973e-559f89e9c6cb")
    @Override
    default Object visitStateVertex(StateVertex obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("03e4713b-b98e-4c7a-b787-ba868d9937e7")
    @Override
    default Object visitStaticDiagram(StaticDiagram obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitAbstractDiagram(obj);
        else
          return null;

    }

    @objid ("d9d26fe2-fdc5-47ba-b029-ae70d1c61d42")
    @Override
    default Object visitStructuralFeature(StructuralFeature obj) {
        return visitFeature(obj);

    }

    @objid ("29a3b755-a5a6-4b35-9e7c-1b06c75f9762")
    @Override
    default Object visitStructuredActivityNode(StructuredActivityNode obj) {
        return visitActivityAction(obj);

    }

    @objid ("26f91115-7f63-4cdf-aa16-5a747dda91fd")
    @Override
    default Object visitSubstitution(Substitution obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("9c021e76-3b65-4362-b8f0-d4877ec107e3")
    @Override
    default Object visitTemplateBinding(TemplateBinding obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("49df7af5-a1a5-4255-aa14-142f4062cc30")
    @Override
    default Object visitTemplateParameter(TemplateParameter obj) {
        return visitGeneralClass(obj);

    }

    @objid ("7bdca6ec-5c25-466c-a961-ece3f3bc67ba")
    @Override
    default Object visitTemplateParameterSubstitution(TemplateParameterSubstitution obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("856b3462-6632-4c5e-91a0-bd4fefdf942d")
    @Override
    default Object visitTerminatePseudoState(TerminatePseudoState obj) {
        return visitAbstractPseudoState(obj);

    }

    @objid ("94be348f-c76d-4669-ac58-d27ba8f10074")
    @Override
    default Object visitTerminateSpecification(TerminateSpecification obj) {
        return visitExecutionOccurenceSpecification(obj);

    }

    @objid ("84ac626a-28cc-4dd3-9ff5-6a19739c2179")
    @Override
    default Object visitTransition(Transition obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("deac8b2e-7722-4ec3-a1a0-ecd08268b6a5")
    @Override
    default Object visitUmlModelElement(UmlModelElement obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitModelElement(obj);
        else
          return null;

    }

    @objid ("0d97e0d0-27b7-4ea8-9fbd-8086f5ce0214")
    @Override
    default Object visitUsage(Usage obj) {
        IInfrastructureVisitor v = getInfrastructureVisitor();
        if (v != null)
          return v.visitDependency(obj);
        else
          return null;

    }

    @objid ("0da5c2ae-2669-4893-82b9-8c884b78bb1e")
    @Override
    default Object visitUseCase(UseCase obj) {
        return visitGeneralClass(obj);

    }

    @objid ("87f9c221-6a8f-4421-9da0-ed910ae174fb")
    @Override
    default Object visitUseCaseDependency(UseCaseDependency obj) {
        return visitUmlModelElement(obj);

    }

    @objid ("035314e2-5477-476d-98fc-0473141ca3a7")
    @Override
    default Object visitUseCaseDiagram(UseCaseDiagram obj) {
        return visitStaticDiagram(obj);

    }

    @objid ("51b74708-1650-4916-8352-8cf089b85d94")
    @Override
    default Object visitValuePin(ValuePin obj) {
        return visitInputPin(obj);

    }

}
