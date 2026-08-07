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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;

/**
 * State v0.0.9054
 *
 *
 * A State represents a period of time during which an object waits for an Event or some Events to occur, or a period of time during which an object performs some ongoing activity.
 *
 * States are interconnected by Transitions.
 *
 * In Modelio, States belong either to another State, or to a StateMachine if they are the root.
 *
 */
@objid ("0053788e-c4bf-1fd8-97fe-001ec947cd2a")
public interface State extends StateVertex {
    /**
     * The metaclass simple name.
     */
    @objid ("ef40f3e9-c8c0-44e7-8aef-d127e6453dc9")
    public static final String MNAME = "State";

    /**
     * The metaclass qualified name.
     */
    @objid ("33f59fa9-1f85-4111-bdb0-ad389713f4ec")
    public static final String MQNAME = "Standard.State";

    /**
     * Getter for relation 'State->ExitPoint'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("407e68da-204e-4382-a56b-7185b99a4bec")
    EList<ExitPointPseudoState> getExitPoint();

    /**
     * Filtered Getter for relation 'State->ExitPoint'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("1bae644d-7429-4c85-8f97-62112f101e5f")
    <T extends ExitPointPseudoState> List<T> getExitPoint(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->Deffered'
     *
     * Metamodel description:
     * <i>A list of Events the effect of whose occurrence during the State is postponed until the owner enters a State in which they are not deferred, at which time they may trigger Transitions as if they had just occurred.</i>
     */
    @objid ("4a74806f-151b-4a9e-b562-8c51a9e29dae")
    EList<Event> getDeffered();

    /**
     * Filtered Getter for relation 'State->Deffered'
     *
     * Metamodel description:
     * <i>A list of Events the effect of whose occurrence during the State is postponed until the owner enters a State in which they are not deferred, at which time they may trigger Transitions as if they had just occurred.</i>
     */
    @objid ("9ae3733f-ce19-437c-b75f-15d60fd73d4b")
    <T extends Event> List<T> getDeffered(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->Internal'
     *
     * Metamodel description:
     * <i>Transitions that occur entirely within the State. If one of their triggers is satisfied then the action is performed without changing State. This means that the entry or exit condition of the State will not be invoked. These Transitions apply even if the StateMachine is in a nested region and they leave it in the same State.</i>
     */
    @objid ("61188c6c-e5c3-422f-a0c2-323cc9d11ab0")
    EList<InternalTransition> getInternal();

    /**
     * Filtered Getter for relation 'State->Internal'
     *
     * Metamodel description:
     * <i>Transitions that occur entirely within the State. If one of their triggers is satisfied then the action is performed without changing State. This means that the entry or exit condition of the State will not be invoked. These Transitions apply even if the StateMachine is in a nested region and they leave it in the same State.</i>
     */
    @objid ("1120f41f-8515-477a-9c2e-62c0f675be4e")
    <T extends InternalTransition> List<T> getInternal(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->EntryPoint'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("4011c8c1-a430-48d9-9257-ec49a99d1fdd")
    EList<EntryPointPseudoState> getEntryPoint();

    /**
     * Filtered Getter for relation 'State->EntryPoint'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("8bd46b7d-40ff-4ee1-bd40-9566bb3540b3")
    <T extends EntryPointPseudoState> List<T> getEntryPoint(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->OwnedRegion'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("da564d75-1d7a-4361-9bd1-6bef8e2da828")
    EList<Region> getOwnedRegion();

    /**
     * Filtered Getter for relation 'State->OwnedRegion'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("7ffd7492-1076-491b-ab78-eb70086e5f6b")
    <T extends Region> List<T> getOwnedRegion(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->RequiredStateOf'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5cc2b1d8-8c85-4d71-a898-f46c73c81c1d")
    EList<ObjectNode> getRequiredStateOf();

    /**
     * Filtered Getter for relation 'State->RequiredStateOf'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9eef82cf-bece-4a3c-960e-3aa3ded9cd19")
    <T extends ObjectNode> List<T> getRequiredStateOf(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("42d00bc7-aa50-4016-97cc-7cc56cb3c11c")
    EList<ConnectionPointReference> getConnection();

    /**
     * Filtered Getter for relation 'State->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("709be6b9-0e17-4d22-893f-6210b465a15a")
    <T extends ConnectionPointReference> List<T> getConnection(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'State->SubMachine'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("9acabd5a-4a09-44c5-bef2-fa6d1a183dd0")
    StateMachine getSubMachine();

    /**
     * Setter for relation 'State->SubMachine'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("79cf04b3-ffd9-45d9-847a-56581577dfb0")
    void setSubMachine(StateMachine value);

}
