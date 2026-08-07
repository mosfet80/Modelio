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
package org.modelio.metamodel.uml.behavior.stateMachineModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;

/**
 * Transition v0.0.9054
 *
 *
 * Transitions represent the reaction of an object in a certain State, to a particular Event.
 *
 * For protocol state diagrams, Transitions represent the possible paths between States.
 *
 * In Modelio, a Transition belongs to its source StateVertex.
 *
 */
@objid ("0055b6a8-c4bf-1fd8-97fe-001ec947cd2a")
public interface Transition extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("816a5f47-07ff-4efd-9e10-feb3932457af")
    public static final String MNAME = "Transition";

    /**
     * The metaclass qualified name.
     */
    @objid ("3e38f5f5-ea8c-44a0-b1ef-fdc73e01e2cc")
    public static final String MQNAME = "Standard.Transition";

    /**
     * Getter for attribute 'Transition.Effect'
     *
     * Metamodel description:
     * <i>Defines the actions triggered by the Transition. This field excludes the ProcessedOperation association that is shorthand for defining a call action.</i>
     */
    @objid ("8363f0b7-51eb-4b86-85ec-5554f5cb1c9f")
    String getEffect();

    /**
     * Setter for attribute 'Transition.Effect'
     *
     * Metamodel description:
     * <i>Defines the actions triggered by the Transition. This field excludes the ProcessedOperation association that is shorthand for defining a call action.</i>
     */
    @objid ("5fb9af97-dd87-4690-a672-fddf2c839094")
    void setEffect(String value);

    /**
     * Getter for attribute 'Transition.ReceivedEvents'
     *
     * Metamodel description:
     * <i>Received events that trigger the Transition.</i>
     */
    @objid ("0a12363a-6176-4c89-ae55-e4b29317e0d4")
    String getReceivedEvents();

    /**
     * Setter for attribute 'Transition.ReceivedEvents'
     *
     * Metamodel description:
     * <i>Received events that trigger the Transition.</i>
     */
    @objid ("db8880f7-6d9d-4cd7-8c2f-fd56539aa6f0")
    void setReceivedEvents(String value);

    /**
     * Getter for attribute 'Transition.SentEvents'
     *
     * Metamodel description:
     * <i>Events sent by the Transition once it is triggered.</i>
     */
    @objid ("1e200807-b5fd-452b-a5f2-f223da4ec177")
    String getSentEvents();

    /**
     * Setter for attribute 'Transition.SentEvents'
     *
     * Metamodel description:
     * <i>Events sent by the Transition once it is triggered.</i>
     */
    @objid ("c90e1ccd-9932-4fb7-8500-a8153c936509")
    void setSentEvents(String value);

    /**
     * Getter for attribute 'Transition.Guard'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("26689e0e-640c-4d30-80cb-8a2ad8fe1905")
    String getGuard();

    /**
     * Setter for attribute 'Transition.Guard'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("6e0230f6-00cd-4a61-b961-f115460f3838")
    void setGuard(String value);

    /**
     * Getter for attribute 'Transition.PostCondition'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("7f9b2519-2c7d-4c72-b13c-df8bcd1897de")
    String getPostCondition();

    /**
     * Setter for attribute 'Transition.PostCondition'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("beaea1df-7a04-49ad-9d50-c70c6a26bef5")
    void setPostCondition(String value);

    /**
     * Getter for relation 'Transition->Processed'
     *
     * Metamodel description:
     * <i>The Operation processed once the Transition is triggered. This is shorthand for a call event, and is also useful for defining the operation carried by a Transition in protocol state diagrams.</i>
     */
    @objid ("d9a0a548-1657-4250-98d7-7a4a92b0f7de")
    Operation getProcessed();

    /**
     * Setter for relation 'Transition->Processed'
     *
     * Metamodel description:
     * <i>The Operation processed once the Transition is triggered. This is shorthand for a call event, and is also useful for defining the operation carried by a Transition in protocol state diagrams.</i>
     */
    @objid ("2d56c737-7aac-43af-93f6-a3ca9939b3f2")
    void setProcessed(Operation value);

    /**
     * Getter for relation 'Transition->Trigger'
     *
     * Metamodel description:
     * <i>Events that may trigger the Transition (under initial state and initial Transitions). This association is exclusive from the "ReceivedEvents" string.</i>
     */
    @objid ("2cb63fee-4254-46d9-9ed2-5b9183c20a73")
    Event getTrigger();

    /**
     * Setter for relation 'Transition->Trigger'
     *
     * Metamodel description:
     * <i>Events that may trigger the Transition (under initial state and initial Transitions). This association is exclusive from the "ReceivedEvents" string.</i>
     */
    @objid ("d91d0df7-be25-484a-98f3-1e71109445e4")
    void setTrigger(Event value);

    /**
     * Getter for relation 'Transition->BehaviorEffect'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dca00191-f37d-4b3c-b20e-601dde337544")
    Behavior getBehaviorEffect();

    /**
     * Setter for relation 'Transition->BehaviorEffect'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f2ad0020-e560-4248-a444-03a9345a5e31")
    void setBehaviorEffect(Behavior value);

    /**
     * Getter for relation 'Transition->Target'
     *
     * Metamodel description:
     * <i>Specifies the Transitions entering the vertex.</i>
     */
    @objid ("54451c27-a5f2-4ef6-9f99-69881197cacd")
    StateVertex getTarget();

    /**
     * Setter for relation 'Transition->Target'
     *
     * Metamodel description:
     * <i>Specifies the Transitions entering the vertex.</i>
     */
    @objid ("50b92d40-3f12-4a52-9642-70dfc7262389")
    void setTarget(StateVertex value);

    /**
     * Getter for relation 'Transition->Source'
     *
     * Metamodel description:
     * <i>Specifies the Transitions departing from the vertex.</i>
     */
    @objid ("72d65426-cd18-4a5b-8e9e-bc5f85444926")
    StateVertex getSource();

    /**
     * Setter for relation 'Transition->Source'
     *
     * Metamodel description:
     * <i>Specifies the Transitions departing from the vertex.</i>
     */
    @objid ("2bd8a95f-1386-4c67-bfa6-fb5b8efc872f")
    void setSource(StateVertex value);

    /**
     * Getter for relation 'Transition->Effects'
     *
     * Metamodel description:
     * <i>When the Transition is accomplished, occurrences of this Signal will be sent.</i>
     */
    @objid ("9ff7c06b-d479-44b5-8cc2-440fe5ca979d")
    Signal getEffects();

    /**
     * Setter for relation 'Transition->Effects'
     *
     * Metamodel description:
     * <i>When the Transition is accomplished, occurrences of this Signal will be sent.</i>
     */
    @objid ("63cc81e3-7f63-4419-a534-765624847f92")
    void setEffects(Signal value);

}
