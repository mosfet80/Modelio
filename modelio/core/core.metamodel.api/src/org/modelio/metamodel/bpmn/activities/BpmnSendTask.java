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
 * BpmnSendTask v0.0.9054
 *
 *
 * A Send Task is a simple Task that is designed to send a Message to an external Participant (relative to the Process). Once the Message has been sent, the Task is completed.
 * The actual Participant which the Message is sent can be identified by connecting the Send Task to a Participant using a Message Flow within the definitional Collaboration of the Process
 *
 */
@objid ("00828728-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnSendTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("1900951b-665a-47c3-a9b7-c31fbf20f190")
    public static final String MNAME = "BpmnSendTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("2c165364-5e09-49fb-9e6b-26995517ee29")
    public static final String MQNAME = "Standard.BpmnSendTask";

    /**
     * Getter for attribute 'BpmnSendTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("488662ed-b17a-44ba-a1ed-a752a874c626")
    String getImplementation();

    /**
     * Setter for attribute 'BpmnSendTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("35f5d130-c5ba-4fe3-a389-8cfea1955edb")
    void setImplementation(String value);

    /**
     * Getter for relation 'BpmnSendTask->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bff62d57-a44c-49d6-9b21-a5dce05dbaac")
    BpmnMessage getMessageRef();

    /**
     * Setter for relation 'BpmnSendTask->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("22daaf5f-bb4e-4b7f-b920-536452392134")
    void setMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnSendTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3a2ccd1c-0a95-45e6-964e-b491ac0569dc")
    BpmnOperation getOperationRef();

    /**
     * Setter for relation 'BpmnSendTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4fe0b549-67e3-45e5-9ad8-383bbb907eca")
    void setOperationRef(BpmnOperation value);

}
