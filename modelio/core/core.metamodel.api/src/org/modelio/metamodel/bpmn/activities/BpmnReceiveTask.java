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
package org.modelio.metamodel.bpmn.activities;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;

/**
 * BpmnReceiveTask v0.0.9054
 *
 *
 * A Receive Task is a simple Task that is designed to wait for a Message to arrive from an external Participant (relative to the Process). Once the Message has been received, the Task is completed.
 * The actual Participant from which the Message is received can be identified by connecting the Receive Task to a Participant using a Message Flow within the definitional Collaboration of the Process.
 *
 * A Receive Task is often used to start a Process. In a sense, the Process is bootstrapped by the receipt of the Message. In order for the Task to Instantiate the Process it must meet one of the following conditions:
 * - The Process does not have a Start Event and the Receive Task has no incoming Sequence Flow.
 * - The incoming Sequence Flow for the Receive Task has a source of a Start Event.
 * - Note that no other incoming Sequence Flow are allowed for that Receive Task (in particular, a loop
 * connection from a downstream object).
 *
 */
@objid ("008180d0-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnReceiveTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("a7c8a8a9-c124-4463-b56f-a227a3662a7c")
    public static final String MNAME = "BpmnReceiveTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("889f7e0a-92d4-4529-a8da-88d251bc2258")
    public static final String MQNAME = "Standard.BpmnReceiveTask";

    /**
     * Getter for attribute 'BpmnReceiveTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("9aad8b5a-f240-4096-98f0-6e58d5225fb0")
    String getImplementation();

    /**
     * Setter for attribute 'BpmnReceiveTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("12ee7da3-3321-454b-8d73-d596cb388735")
    void setImplementation(String value);

    /**
     * Getter for attribute 'BpmnReceiveTask.Instanciate'
     *
     * Metamodel description:
     * <i>Receive Tasks can be defined as the instantiation mechanism for the Process with the instantiate attribute.
     *
     * This attribute MAY be set to true if the Task is the first Activity (i.e., there are no incoming Sequence Flows).
     *
     * Multiple Tasks MAY have this attribute set to true.</i>
     */
    @objid ("2bea010f-db44-4274-8cea-74262c5a41b8")
    boolean isInstanciate();

    /**
     * Setter for attribute 'BpmnReceiveTask.Instanciate'
     *
     * Metamodel description:
     * <i>Receive Tasks can be defined as the instantiation mechanism for the Process with the instantiate attribute.
     *
     * This attribute MAY be set to true if the Task is the first Activity (i.e., there are no incoming Sequence Flows).
     *
     * Multiple Tasks MAY have this attribute set to true.</i>
     */
    @objid ("9a8dea2a-5e3d-4824-a439-6023956ddee8")
    void setInstanciate(boolean value);

    /**
     * Getter for relation 'BpmnReceiveTask->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dcd830b0-382b-404b-9a57-b77229ea969c")
    BpmnMessage getMessageRef();

    /**
     * Setter for relation 'BpmnReceiveTask->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7b76c569-3903-4137-ae06-062297849710")
    void setMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnReceiveTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("55a36a71-3173-4d11-8e6e-9164690a3f39")
    BpmnOperation getOperationRef();

    /**
     * Setter for relation 'BpmnReceiveTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5af6f02b-8806-42a9-ab49-f86f034c8c3f")
    void setOperationRef(BpmnOperation value);

}
