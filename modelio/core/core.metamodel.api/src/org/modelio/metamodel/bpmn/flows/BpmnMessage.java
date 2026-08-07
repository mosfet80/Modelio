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
package org.modelio.metamodel.bpmn.flows;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;

/**
 * BpmnMessage v0.0.9054
 *
 *
 * <p>A Message represents the content of a communication between two Participants. In BPMN 2.0, a Message is a graphical object (it was a supporting element in BPMN 1.2). An ItemDefinition is used to specify the Message structure.</p><p>In a Process that is not used in a Collaboration, the communication is not displayed, but a Message can be defined for Activities that send and receive Messages (such as a Send Task). Note that the display of Messages in a Process, Collaboration, or Choreography is optional.</p><p>Ownership:<br />
 * A message belongs to a collaboration</p>
 *
 *
 */
@objid ("007be7e2-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnMessage extends BpmnSharedElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f9c51aae-f1b5-46d5-8715-bd57aa74f9c0")
    public static final String MNAME = "BpmnMessage";

    /**
     * The metaclass qualified name.
     */
    @objid ("b52a70aa-4c77-4545-8d3b-fc0ae3735d30")
    public static final String MQNAME = "Standard.BpmnMessage";

    /**
     * Getter for relation 'BpmnMessage->OutputMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8fdf2f2c-ff2c-4a14-8d87-caca0c882740")
    EList<BpmnOperation> getOutputMessage();

    /**
     * Filtered Getter for relation 'BpmnMessage->OutputMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fc330787-d439-4aba-a81e-4447483cffe4")
    <T extends BpmnOperation> List<T> getOutputMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->ItemRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f90992bf-53eb-49b8-89b9-aa4d60250578")
    BpmnItemDefinition getItemRef();

    /**
     * Setter for relation 'BpmnMessage->ItemRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7b92f990-0f3d-425f-b733-2beb804dd7d1")
    void setItemRef(BpmnItemDefinition value);

    /**
     * Getter for relation 'BpmnMessage->EventDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("641234fa-7486-4ab3-978f-1cff61730e84")
    EList<BpmnMessageEventDefinition> getEventDefinition();

    /**
     * Filtered Getter for relation 'BpmnMessage->EventDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("862005f0-ebc0-4316-bb4b-e55f765bcdb7")
    <T extends BpmnMessageEventDefinition> List<T> getEventDefinition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c28634c7-11a3-4b6b-8bd6-4a996d81c5c5")
    EList<BpmnSendTask> getSender();

    /**
     * Filtered Getter for relation 'BpmnMessage->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9a4f73aa-7d1d-498d-a42e-94a46c9d37ad")
    <T extends BpmnSendTask> List<T> getSender(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->InputMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1f5ec622-2df9-46b8-b703-e15bde9af84c")
    EList<BpmnOperation> getInputMessage();

    /**
     * Filtered Getter for relation 'BpmnMessage->InputMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5d27ccf6-d668-4d5e-9594-de91505fd010")
    <T extends BpmnOperation> List<T> getInputMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fa39653d-1ed1-401d-80d3-1175de192b8d")
    EList<BpmnReceiveTask> getReceiver();

    /**
     * Filtered Getter for relation 'BpmnMessage->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2e5514f1-c7f2-4ad9-af23-5e173821389b")
    <T extends BpmnReceiveTask> List<T> getReceiver(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->MessageFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("42f1e023-9a94-4f15-9bef-46bf6c5751bf")
    EList<BpmnMessageFlow> getMessageFlow();

    /**
     * Filtered Getter for relation 'BpmnMessage->MessageFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("76f3d1cb-86ad-4485-983b-bf09dc5842bd")
    <T extends BpmnMessageFlow> List<T> getMessageFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnMessage->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1cb193de-375c-4b27-bd35-ad0857882c80")
    BpmnCollaboration getCollaboration();

    /**
     * Setter for relation 'BpmnMessage->Collaboration'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c1b36a4d-6645-4c78-864d-0dd0822cb995")
    void setCollaboration(BpmnCollaboration value);

}
