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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.NaryLink;

/**
 * CommunicationChannel v0.0.9054
 *
 *
 * A CommunicationChannel is a link between two CommunicationNodes.
 *
 * A CommunicationChannel can represent a Link. It owns messages that follow the channel from its start to the end, and inverted messages that go from the end to the start.
 *
 */
@objid ("5451d474-f72f-46a9-b8b5-35997413d584")
public interface CommunicationChannel extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("db480b7a-702e-4faf-9d73-9bcaec166352")
    public static final String MNAME = "CommunicationChannel";

    /**
     * The metaclass qualified name.
     */
    @objid ("9138317e-9822-4150-9e8b-9ecbabcb263d")
    public static final String MQNAME = "Standard.CommunicationChannel";

    /**
     * Getter for relation 'CommunicationChannel->StartToEndMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6cdf1d6b-cd83-4f97-87b7-d9c6e3966088")
    EList<CommunicationMessage> getStartToEndMessage();

    /**
     * Filtered Getter for relation 'CommunicationChannel->StartToEndMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("96a0ca22-06df-4600-8903-fe65d93e4143")
    <T extends CommunicationMessage> List<T> getStartToEndMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'CommunicationChannel->Channel'
     *
     * Metamodel description:
     * <i>References the Link the communication channel represents.</i>
     */
    @objid ("dec3e5b3-2101-4fee-946a-91e62d11b968")
    Link getChannel();

    /**
     * Setter for relation 'CommunicationChannel->Channel'
     *
     * Metamodel description:
     * <i>References the Link the communication channel represents.</i>
     */
    @objid ("c2f7f9c0-7cd0-4624-8830-a75c05a4d966")
    void setChannel(Link value);

    /**
     * Getter for relation 'CommunicationChannel->Start'
     *
     * Metamodel description:
     * <i>Node starting the channel.</i>
     */
    @objid ("34f6447e-82fe-4724-815a-fe2811e0bbd2")
    CommunicationNode getStart();

    /**
     * Setter for relation 'CommunicationChannel->Start'
     *
     * Metamodel description:
     * <i>Node starting the channel.</i>
     */
    @objid ("164af0b8-5ac7-4a1e-805f-255e08918599")
    void setStart(CommunicationNode value);

    /**
     * Getter for relation 'CommunicationChannel->NaryChannel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f798c97-fa58-4b82-b5c7-0c7d0dbe89dd")
    NaryLink getNaryChannel();

    /**
     * Setter for relation 'CommunicationChannel->NaryChannel'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("899fa67f-0cc5-43eb-8b91-a34ca8313988")
    void setNaryChannel(NaryLink value);

    /**
     * Getter for relation 'CommunicationChannel->EndToStartMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("58cb80f1-4d05-426d-b8ed-3a17521afaf2")
    EList<CommunicationMessage> getEndToStartMessage();

    /**
     * Filtered Getter for relation 'CommunicationChannel->EndToStartMessage'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7d9c31bd-4fe0-4908-be39-184029956874")
    <T extends CommunicationMessage> List<T> getEndToStartMessage(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'CommunicationChannel->End'
     *
     * Metamodel description:
     * <i>Node at the end of the channel.</i>
     */
    @objid ("23df4645-423c-4939-93c6-deb10329b50e")
    CommunicationNode getEnd();

    /**
     * Setter for relation 'CommunicationChannel->End'
     *
     * Metamodel description:
     * <i>Node at the end of the channel.</i>
     */
    @objid ("b546eab0-56a4-47b0-a306-02f593648ed0")
    void setEnd(CommunicationNode value);

}
