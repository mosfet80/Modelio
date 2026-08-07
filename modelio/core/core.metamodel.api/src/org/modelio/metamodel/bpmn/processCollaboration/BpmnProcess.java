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
/* WARNING: GENERATED FILE -  DO NOT EDIT
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * BpmnProcess v2.2.0
 *
 *
 * <p>A Process describes a sequence or flow of Activities in an organization with the objective of carrying out work.</p><p>In BPMN a Process is depicted as a graph of Flow Elements, which are a set of Activities, Events, Gateways, and Sequence Flow that define finite execution semantics.</p><p>Processes may be defined at any level from enterprise-wide Processes to Processes performed by a single person. Low-level Processes may be grouped together to achieve a common business goal.</p><p>Note that BPMN uses the term Process specifically to mean a set of flow elements. It uses the terms Collaboration and Choreography when modeling the interaction between</p><p>Processes Ownership: In Modelio, a&nbsp;Process is a Behavior so&nbsp;belongs to any UML element that can contain a Behavior. BPMN Process will usually be created in UML Packages, but may also be found to a Class or an Operation.</p>
 *
 *
 */
@objid ("00762104-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnProcess extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("c8020cbb-3810-4355-9292-2ad9d3147c53")
    public static final String MNAME = "BpmnProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("9cf8e0a1-e1f3-4fa4-af6d-3123a5159d4f")
    public static final String MQNAME = "Standard.BpmnProcess";

    /**
     * Getter for attribute 'BpmnProcess.ProcessType'
     *
     * Metamodel description:
     * <i><p>The <em>processType</em> attribute Provides additional information about the level of abstraction modeled by this Process.</p><p>A <em>public</em> Process shows only those flow elements that are relevant to&nbsp;external consumers. Internal details are not modeled. These&nbsp;Processes are publicly visible and can be used within a&nbsp;Collaboration . Note that the public processType was named&nbsp;abstract in BPMN 1.2 .</p><p>A <em>private</em> Process is one that is internal to a specific organization.</p><p>By default, the processType is &quot;<em>none</em>&quot;,&nbsp;meaning undefined.</p>
     * </i>
     */
    @objid ("fd2d3eb7-2f5a-4484-885c-e2de5feb3e4b")
    BpmnProcessType getProcessType();

    /**
     * Setter for attribute 'BpmnProcess.ProcessType'
     *
     * Metamodel description:
     * <i><p>The <em>processType</em> attribute Provides additional information about the level of abstraction modeled by this Process.</p><p>A <em>public</em> Process shows only those flow elements that are relevant to&nbsp;external consumers. Internal details are not modeled. These&nbsp;Processes are publicly visible and can be used within a&nbsp;Collaboration . Note that the public processType was named&nbsp;abstract in BPMN 1.2 .</p><p>A <em>private</em> Process is one that is internal to a specific organization.</p><p>By default, the processType is &quot;<em>none</em>&quot;,&nbsp;meaning undefined.</p>
     * </i>
     */
    @objid ("17819fc0-4d20-4560-bfb8-d81a57d2198a")
    void setProcessType(BpmnProcessType value);

    /**
     * Getter for attribute 'BpmnProcess.IsClosed'
     *
     * Metamodel description:
     * <i><p>A boolean value specifying whether interactions, such as sending and receiving Messages and Events, not modeled in the Process can occur when the Process is executed or performed.</p><p>If the value is <em>true</em>, they MAY NOT occur. If the value is <em>false</em>, they MAY occur.</p>
     * </i>
     */
    @objid ("2648f6b7-432c-4832-9718-d0417c525806")
    boolean isIsClosed();

    /**
     * Setter for attribute 'BpmnProcess.IsClosed'
     *
     * Metamodel description:
     * <i><p>A boolean value specifying whether interactions, such as sending and receiving Messages and Events, not modeled in the Process can occur when the Process is executed or performed.</p><p>If the value is <em>true</em>, they MAY NOT occur. If the value is <em>false</em>, they MAY occur.</p>
     * </i>
     */
    @objid ("b0c2ef6f-55d6-4093-a10c-473a651fb059")
    void setIsClosed(boolean value);

    /**
     * Getter for attribute 'BpmnProcess.IsExecutable'
     *
     * Metamodel description:
     * <i><p>An optional Boolean value specifying whether the Process is executable.</p><p>An executable Process is a private Process that has been modeled for the purpose of being executed according to the semantics of Chapter 14 (see page 442). Of course, during the development cycle of the Process, there will be stages where the Process does not have enough detail to be &#39;executable.&#39;</p><p>A non-executable Process is a private Process that has been modeled for the purpose of documenting Process behavior at a modeler-defined level of detail. Thus, information needed for execution, such as formal condition expressions are typically not included in a non-executable Process.</p><p>For public Processes, no value has the same semantics as if the value were <em>false</em>. The value MAY not be <em>true</em> for public Processes.</p>
     * </i>
     */
    @objid ("0b42219e-baa3-437d-9719-6afbfa93e0c4")
    OptionalBoolean getIsExecutable();

    /**
     * Setter for attribute 'BpmnProcess.IsExecutable'
     *
     * Metamodel description:
     * <i><p>An optional Boolean value specifying whether the Process is executable.</p><p>An executable Process is a private Process that has been modeled for the purpose of being executed according to the semantics of Chapter 14 (see page 442). Of course, during the development cycle of the Process, there will be stages where the Process does not have enough detail to be &#39;executable.&#39;</p><p>A non-executable Process is a private Process that has been modeled for the purpose of documenting Process behavior at a modeler-defined level of detail. Thus, information needed for execution, such as formal condition expressions are typically not included in a non-executable Process.</p><p>For public Processes, no value has the same semantics as if the value were <em>false</em>. The value MAY not be <em>true</em> for public Processes.</p>
     * </i>
     */
    @objid ("ddbeba0a-2235-418d-ab20-c1ba93d9b352")
    void setIsExecutable(OptionalBoolean value);

    /**
     * Getter for relation 'BpmnProcess->Supports'
     *
     * Metamodel description:
     * <i>Modelers can declare that they intend all executions or performances of one Process to also be valid for another Process. This means they expect all the executions or performances of the first Processes to also follow the steps laid out in the second Process.</i>
     */
    @objid ("6b64c1bc-a94d-407e-a988-8d3553216089")
    EList<BpmnProcess> getSupports();

    /**
     * Filtered Getter for relation 'BpmnProcess->Supports'
     *
     * Metamodel description:
     * <i>Modelers can declare that they intend all executions or performances of one Process to also be valid for another Process. This means they expect all the executions or performances of the first Processes to also follow the steps laid out in the second Process.</i>
     */
    @objid ("c2d64eb4-1dc9-4e71-9f57-0b6762100052")
    <T extends BpmnProcess> List<T> getSupports(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f4bf27c7-4ed7-479b-b817-d87be28688e3")
    EList<BpmnArtifact> getArtifact();

    /**
     * Filtered Getter for relation 'BpmnProcess->Artifact'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a33f4728-86dc-4f2d-8387-2b1c3e4b4308")
    <T extends BpmnArtifact> List<T> getArtifact(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->LaneSet'
     *
     * Metamodel description:
     * <i>laneset of the process. The process is represented in this cas by a pool which is decomposed by lansets and lanes.</i>
     */
    @objid ("4b62b410-5ef3-4759-835d-7efb4404dd01")
    BpmnLaneSet getLaneSet();

    /**
     * Setter for relation 'BpmnProcess->LaneSet'
     *
     * Metamodel description:
     * <i>laneset of the process. The process is represented in this cas by a pool which is decomposed by lansets and lanes.</i>
     */
    @objid ("8bb432db-8cce-4d86-a305-72bca2916e92")
    void setLaneSet(BpmnLaneSet value);

    /**
     * Getter for relation 'BpmnProcess->Supported'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9d458453-ca8b-4479-9314-25be38d1a190")
    EList<BpmnProcess> getSupported();

    /**
     * Filtered Getter for relation 'BpmnProcess->Supported'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a62ce64b-ec9b-41f9-ada4-addc934ff468")
    <T extends BpmnProcess> List<T> getSupported(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->Participant'
     *
     * Metamodel description:
     * <i>When a participant is decomposed by a process, both are related by this association.</i>
     */
    @objid ("c3bf8bc4-cf59-4744-b472-5876c01cbd52")
    EList<BpmnParticipant> getParticipant();

    /**
     * Filtered Getter for relation 'BpmnProcess->Participant'
     *
     * Metamodel description:
     * <i>When a participant is decomposed by a process, both are related by this association.</i>
     */
    @objid ("1bb9d754-61db-4094-93a3-c45dd63a1ab9")
    <T extends BpmnParticipant> List<T> getParticipant(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->FlowElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cd64ee06-6bfc-46a4-b31f-e40c3007202e")
    EList<BpmnFlowElement> getFlowElement();

    /**
     * Filtered Getter for relation 'BpmnProcess->FlowElement'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f3423b07-5829-4777-a5f4-278f22a78f40")
    <T extends BpmnFlowElement> List<T> getFlowElement(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->Resource'
     *
     * Metamodel description:
     * <i>Resources attached to the process, such as auditing or monitoring. These resources can be defined externally, in particular by the user, in order to attach descritpion properties to a process.</i>
     */
    @objid ("02556169-5c2f-49c6-8893-f398fcf2fc68")
    EList<BpmnResourceRole> getResource();

    /**
     * Filtered Getter for relation 'BpmnProcess->Resource'
     *
     * Metamodel description:
     * <i>Resources attached to the process, such as auditing or monitoring. These resources can be defined externally, in particular by the user, in order to attach descritpion properties to a process.</i>
     */
    @objid ("d01b51b9-f533-49eb-ae9f-bf4153403f20")
    <T extends BpmnResourceRole> List<T> getResource(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnProcess->DefinitionalCollaboration'
     *
     * Metamodel description:
     * <i><p>For <strong>Processes</strong> that interact with other <strong>Participants</strong>, a <strong>definitional&nbsp;Collaboration</strong> can be referenced by the <strong>Process</strong>. The <strong>definitional</strong>&nbsp;<strong>Collaboration</strong> specifies the <strong>Participants</strong> the Process interacts with,&nbsp;and more specifically, which individual service, Send or Receive <strong>Task</strong>,&nbsp;or <strong>Message Event</strong>, is connected to which <strong>Participant</strong> through&nbsp;<strong>Message Flows</strong>.</p><p>The <strong>definitional Collaboration</strong> need not be&nbsp;displayed.</p><p>Additionally, the definitional Collaboration can be used to include&nbsp;Conversation information within a Process.</p>
     * </i>
     */
    @objid ("25192cf2-f636-4d0b-be0d-093c15edcb0d")
    BpmnCollaboration getDefinitionalCollaboration();

    /**
     * Setter for relation 'BpmnProcess->DefinitionalCollaboration'
     *
     * Metamodel description:
     * <i><p>For <strong>Processes</strong> that interact with other <strong>Participants</strong>, a <strong>definitional&nbsp;Collaboration</strong> can be referenced by the <strong>Process</strong>. The <strong>definitional</strong>&nbsp;<strong>Collaboration</strong> specifies the <strong>Participants</strong> the Process interacts with,&nbsp;and more specifically, which individual service, Send or Receive <strong>Task</strong>,&nbsp;or <strong>Message Event</strong>, is connected to which <strong>Participant</strong> through&nbsp;<strong>Message Flows</strong>.</p><p>The <strong>definitional Collaboration</strong> need not be&nbsp;displayed.</p><p>Additionally, the definitional Collaboration can be used to include&nbsp;Conversation information within a Process.</p>
     * </i>
     */
    @objid ("8de3fa75-4516-44ac-b01c-8d4f467009ab")
    void setDefinitionalCollaboration(BpmnCollaboration value);

}
