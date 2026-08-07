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
package org.modelio.metamodel.uml.behavior.commonBehaviors;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;

/**
 * Event v0.0.9054
 *
 *
 * An Event is the specification of a specific occurrence at a specific point in space and time.  An instance of an Event can lead to the activation of a behavioral Feature in an object.
 *
 * An Event can be either an occurrence of a Signal, a message occurrence, a time or a change expression occurrence.
 *
 * In Modelio, an Event belongs to a State Machine.
 *
 */
@objid ("00428d1c-c4bf-1fd8-97fe-001ec947cd2a")
public interface Event extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("865c2a97-3e78-4928-a203-8581030d3a89")
    public static final String MNAME = "Event";

    /**
     * The metaclass qualified name.
     */
    @objid ("8ee3f502-6340-4410-b0c4-6802f981c8c3")
    public static final String MQNAME = "Standard.Event";

    /**
     * Getter for attribute 'Event.Expression'
     *
     * Metamodel description:
     * <i>Expression initiating the Event. This can be a time expression or a triggering condition, and can contain parameter values in the case of operation call event, and so on.</i>
     */
    @objid ("4e3bf9fc-7ead-4491-a566-3def8e3dbfab")
    String getExpression();

    /**
     * Setter for attribute 'Event.Expression'
     *
     * Metamodel description:
     * <i>Expression initiating the Event. This can be a time expression or a triggering condition, and can contain parameter values in the case of operation call event, and so on.</i>
     */
    @objid ("080d36ea-ae6e-4c10-b167-4359ad382ef8")
    void setExpression(String value);

    /**
     * Getter for attribute 'Event.Kind'
     *
     * Metamodel description:
     * <i>Defines the nature of the event (Time, Signal occurrence, and so on.)</i>
     */
    @objid ("6ca9d2bc-7b05-462f-b487-133a5668690c")
    EventType getKind();

    /**
     * Setter for attribute 'Event.Kind'
     *
     * Metamodel description:
     * <i>Defines the nature of the event (Time, Signal occurrence, and so on.)</i>
     */
    @objid ("69f18cf2-7370-4988-beea-a99f416cd23e")
    void setKind(EventType value);

    /**
     * Getter for relation 'Event->Triggered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dc29f6ca-4808-45a3-bb88-1eac088bb45a")
    EList<Transition> getTriggered();

    /**
     * Filtered Getter for relation 'Event->Triggered'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6edbcbf4-057d-4b1a-8847-646c46fb3ba3")
    <T extends Transition> List<T> getTriggered(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Event->Model'
     *
     * Metamodel description:
     * <i>Signal of which the Event is an occurrence.</i>
     */
    @objid ("cf785605-78e5-4d2c-b72f-191183f961e9")
    Signal getModel();

    /**
     * Setter for relation 'Event->Model'
     *
     * Metamodel description:
     * <i>Signal of which the Event is an occurrence.</i>
     */
    @objid ("7db5565f-9cb7-4c47-a1b6-ed0f0062237d")
    void setModel(Signal value);

    /**
     * Getter for relation 'Event->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("157ebe57-d55b-4a67-8bc0-cb04e0d53483")
    EList<State> getOrigin();

    /**
     * Filtered Getter for relation 'Event->Origin'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("28a3f4d6-18d3-4e9a-bd6c-e41d42144f16")
    <T extends State> List<T> getOrigin(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Event->Called'
     *
     * Metamodel description:
     * <i>Direct link to an Operation in case of a call Event.</i>
     */
    @objid ("3c03f6b0-fbf8-4fe0-8600-39557880a020")
    Operation getCalled();

    /**
     * Setter for relation 'Event->Called'
     *
     * Metamodel description:
     * <i>Direct link to an Operation in case of a call Event.</i>
     */
    @objid ("814d48e7-ced8-44bb-8b45-8e1ebbc5ded3")
    void setCalled(Operation value);

    /**
     * Getter for relation 'Event->Composed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("623d1beb-12e1-40cb-bfb5-cd3d2957bf3b")
    Behavior getComposed();

    /**
     * Setter for relation 'Event->Composed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f871e546-bb17-48e4-843d-f9f92f60cf54")
    void setComposed(Behavior value);

}
