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
package org.modelio.metamodel.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;

/**
 * Message v2.2.01
 *
 *
 * Messages are used in object diagrams, collaboration diagrams and sequence diagrams.
 *
 * If the Message has no InvokedOperation, then its description is in its name.
 *
 * In Modelio, a Message belongs to the sending MessageEnd.
 *
 * The message sequencing information is handled in sequence diagrams by both its MessageEnds, with  an internal feature that is not directly accessible.
 * The Joni Java API will provide methods to access the ordering of MessagesEnd as for InteractionFragments.
 *
 *
 */
@objid ("00493ff4-c4bf-1fd8-97fe-001ec947cd2a")
public interface Message extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("bb699475-cb79-424e-a81e-d67338708f9a")
    public static final String MNAME = "Message";

    /**
     * The metaclass qualified name.
     */
    @objid ("3b044a3c-6c88-4c43-b038-9fe3792d6864")
    public static final String MQNAME = "Standard.Message";

    /**
     * Getter for attribute 'Message.Argument'
     *
     * Metamodel description:
     * <i>Arguments passed with the message.</i>
     */
    @objid ("46c7ec7f-a278-491e-af1d-0e1114ef16e4")
    String getArgument();

    /**
     * Setter for attribute 'Message.Argument'
     *
     * Metamodel description:
     * <i>Arguments passed with the message.</i>
     */
    @objid ("31e5f067-d73d-4242-a6e7-529747f738e9")
    void setArgument(String value);

    /**
     * Getter for attribute 'Message.KindOfMessage'
     *
     * Metamodel description:
     * <i>The derived kind of the Message (complete, lost, found, or unknown). The default value is unknown.</i>
     */
    @objid ("fb6141e9-7ae0-4197-b19e-2b6d5c7d0dd4")
    MessageKind getKindOfMessage();

    /**
     * Setter for attribute 'Message.KindOfMessage'
     *
     * Metamodel description:
     * <i>The derived kind of the Message (complete, lost, found, or unknown). The default value is unknown.</i>
     */
    @objid ("563d5d5a-4466-4aa3-9813-cc58f808baef")
    void setKindOfMessage(MessageKind value);

    /**
     * Getter for attribute 'Message.SortOfMessage'
     *
     * Metamodel description:
     * <i>The sort of communication reflected by the Message. The default value is synchCall.</i>
     */
    @objid ("af4d5d53-48e5-4dc7-8709-ee35efd49b46")
    MessageSort getSortOfMessage();

    /**
     * Setter for attribute 'Message.SortOfMessage'
     *
     * Metamodel description:
     * <i>The sort of communication reflected by the Message. The default value is synchCall.</i>
     */
    @objid ("b5424030-d92a-4a88-b637-b041c0d8b3e0")
    void setSortOfMessage(MessageSort value);

    /**
     * Getter for attribute 'Message.Sequence'
     *
     * Metamodel description:
     * <i>Arguments passed with the message.</i>
     */
    @objid ("fd7cc498-15c2-4365-bb68-65e80483c5c6")
    String getSequence();

    /**
     * Setter for attribute 'Message.Sequence'
     *
     * Metamodel description:
     * <i>Arguments passed with the message.</i>
     */
    @objid ("50258ec2-8796-4833-9187-c9eeed82a550")
    void setSequence(String value);

    /**
     * Getter for relation 'Message->SignalSignature'
     *
     * Metamodel description:
     * <i>Signal that is sent by the message.</i>
     */
    @objid ("220f07e3-208a-4ccf-aeab-0a9689bd702c")
    Signal getSignalSignature();

    /**
     * Setter for relation 'Message->SignalSignature'
     *
     * Metamodel description:
     * <i>Signal that is sent by the message.</i>
     */
    @objid ("fe95dabf-e75b-4466-bc1a-aeafed259dd2")
    void setSignalSignature(Signal value);

    /**
     * Getter for relation 'Message->ReceiveEvent'
     *
     * Metamodel description:
     * <i>References the reception of the message.</i>
     */
    @objid ("ab545a4b-5aae-443b-bc95-a130943e9f45")
    MessageEnd getReceiveEvent();

    /**
     * Setter for relation 'Message->ReceiveEvent'
     *
     * Metamodel description:
     * <i>References the reception of the message.</i>
     */
    @objid ("c419b95a-b9a9-4021-911c-faa7489e4e34")
    void setReceiveEvent(MessageEnd value);

    /**
     * Getter for relation 'Message->SendEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("073e0034-ba64-4aa0-bb76-6956c3084803")
    MessageEnd getSendEvent();

    /**
     * Setter for relation 'Message->SendEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7a8464d1-20c4-4504-9d05-ec863655d2a6")
    void setSendEvent(MessageEnd value);

    /**
     * Getter for relation 'Message->Invoked'
     *
     * Metamodel description:
     * <i>The Operation that is invoked by the Message.</i>
     */
    @objid ("950695d5-732d-4e99-80be-477920c76afb")
    Operation getInvoked();

    /**
     * Setter for relation 'Message->Invoked'
     *
     * Metamodel description:
     * <i>The Operation that is invoked by the Message.</i>
     */
    @objid ("7413d3a0-6139-4071-8f15-ff69a1275259")
    void setInvoked(Operation value);

    /**
     * Getter for relation 'Message->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("26d395d9-0e6b-45c4-87a0-ea20a3c3f945")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'Message->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b2c0ec13-1b1d-466c-a2dc-5f21e62ce9a0")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

}
