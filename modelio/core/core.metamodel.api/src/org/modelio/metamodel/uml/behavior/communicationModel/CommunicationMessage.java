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
package org.modelio.metamodel.uml.behavior.communicationModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;

/**
 * CommunicationMessage v0.0.9054
 *
 *
 * CommunicationMessages are used in communication diagrams.
 *
 * If the CommunicationMessage has no InvokedOperation, then its description is in its name.
 *
 * In Modelio, a Message belongs to the Communication it follows.
 *
 * The message sequencing information is handled in communication diagrams by the 'Sequencing' attribute.
 *
 *
 */
@objid ("005b08f6-c4bf-1fd8-97fe-001ec947cd2a")
public interface CommunicationMessage extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3d5251f4-1181-4994-b4b6-8a88d1168ded")
    public static final String MNAME = "CommunicationMessage";

    /**
     * The metaclass qualified name.
     */
    @objid ("daba8fa9-2ae2-493f-b69d-00e5126b7320")
    public static final String MQNAME = "Standard.CommunicationMessage";

    /**
     * Getter for attribute 'CommunicationMessage.Argument'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f46e582c-54e8-4636-bf90-9afb1728a5a5")
    String getArgument();

    /**
     * Setter for attribute 'CommunicationMessage.Argument'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("38e86987-0b25-432f-a78a-74c0aa8fabec")
    void setArgument(String value);

    /**
     * Getter for attribute 'CommunicationMessage.Sequence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2b99d188-3454-44a0-b06a-2b75e5ac9a5f")
    String getSequence();

    /**
     * Setter for attribute 'CommunicationMessage.Sequence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9280bb67-3500-4fd3-a793-f0251920223c")
    void setSequence(String value);

    /**
     * Getter for attribute 'CommunicationMessage.SortOfMessage'
     *
     * Metamodel description:
     * <i>The sort of communication reflected by the CommunicationMessage. Default value is synchCall.</i>
     */
    @objid ("661efaa7-7253-4517-8bf0-49a612d77211")
    MessageSort getSortOfMessage();

    /**
     * Setter for attribute 'CommunicationMessage.SortOfMessage'
     *
     * Metamodel description:
     * <i>The sort of communication reflected by the CommunicationMessage. Default value is synchCall.</i>
     */
    @objid ("e926495f-bc43-4546-ae82-461e8f1ca5b6")
    void setSortOfMessage(MessageSort value);

    /**
     * Getter for relation 'CommunicationMessage->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cf289db8-a5b7-48b2-8990-48e7f42e17f6")
    EList<InformationFlow> getRealizedInformationFlow();

    /**
     * Filtered Getter for relation 'CommunicationMessage->RealizedInformationFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d46851c5-1cf7-4a4c-9362-34b9f2a2e2ae")
    <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'CommunicationMessage->Channel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ef144fd3-9962-4f34-8487-c62b225066dc")
    CommunicationChannel getChannel();

    /**
     * Setter for relation 'CommunicationMessage->Channel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8d94a818-9799-4fb4-bc7c-cf2a0b0f5098")
    void setChannel(CommunicationChannel value);

    /**
     * Getter for relation 'CommunicationMessage->InvertedChannel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0d5ba0f6-a941-4902-bf18-6530b0943fe0")
    CommunicationChannel getInvertedChannel();

    /**
     * Setter for relation 'CommunicationMessage->InvertedChannel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("be150abb-d1e4-44f2-8509-851ac2cfc926")
    void setInvertedChannel(CommunicationChannel value);

    /**
     * Getter for relation 'CommunicationMessage->Invoked'
     *
     * Metamodel description:
     * <i>The Operation is invoked by the Message.</i>
     */
    @objid ("548df634-59fb-4a1f-a21a-06c6dbb32667")
    Operation getInvoked();

    /**
     * Setter for relation 'CommunicationMessage->Invoked'
     *
     * Metamodel description:
     * <i>The Operation is invoked by the Message.</i>
     */
    @objid ("4179cc1a-67fc-41d4-8191-3a04884b9583")
    void setInvoked(Operation value);

    /**
     * Getter for relation 'CommunicationMessage->SignalSignature'
     *
     * Metamodel description:
     * <i>Signal that is sent by the message.</i>
     */
    @objid ("69a5e20f-6569-440e-b6cf-5d09d241f17f")
    Signal getSignalSignature();

    /**
     * Setter for relation 'CommunicationMessage->SignalSignature'
     *
     * Metamodel description:
     * <i>Signal that is sent by the message.</i>
     */
    @objid ("0e27a130-66f7-4da2-8a21-956815d2d860")
    void setSignalSignature(Signal value);

}
