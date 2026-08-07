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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * StateMachine v0.0.9054
 *
 *
 * State diagams can also define usage protocol for Classes.
 *
 * In Modelio, a StateMachine belongs to a Package, an Operation, a UseCase or a Class. Its natural position is to belong to a Class.
 *
 */
@objid ("005404fc-c4bf-1fd8-97fe-001ec947cd2a")
public interface StateMachine extends Behavior {
    /**
     * The metaclass simple name.
     */
    @objid ("12068839-9b68-4948-a69a-2709fa91a7eb")
    public static final String MNAME = "StateMachine";

    /**
     * The metaclass qualified name.
     */
    @objid ("7cf7ed77-1c2f-4099-9322-f8bd31047187")
    public static final String MQNAME = "Standard.StateMachine";

    /**
     * Getter for attribute 'StateMachine.Kind'
     *
     * Metamodel description:
     * <i>A state machine can be a dynamic state machine, as usually defined in UML (Harel state diagrams), or a protocol state machine. Protocol state machines represent the usage protocol of the Class' Operations. It defines in which order and for which condition and state an Operation can be invoked.</i>
     */
    @objid ("29339406-d1b2-4e05-a3df-758787b4134c")
    KindOfStateMachine getKind();

    /**
     * Setter for attribute 'StateMachine.Kind'
     *
     * Metamodel description:
     * <i>A state machine can be a dynamic state machine, as usually defined in UML (Harel state diagrams), or a protocol state machine. Protocol state machines represent the usage protocol of the Class' Operations. It defines in which order and for which condition and state an Operation can be invoked.</i>
     */
    @objid ("f4f9a1c0-67d6-435a-96fe-9f2cd021c0dc")
    void setKind(KindOfStateMachine value);

    /**
     * Getter for relation 'StateMachine->Top'
     *
     * Metamodel description:
     * <i>Defines the root state for the current StateMachine. All other states will be substates of the TopState.</i>
     */
    @objid ("6d89d95d-f894-45b9-b64a-5d0f42a04e3c")
    Region getTop();

    /**
     * Setter for relation 'StateMachine->Top'
     *
     * Metamodel description:
     * <i>Defines the root state for the current StateMachine. All other states will be substates of the TopState.</i>
     */
    @objid ("85955946-5308-42cd-8924-03d977a1c5ac")
    void setTop(Region value);

    /**
     * Getter for relation 'StateMachine->SubmachineState'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("7e102643-0558-4962-87e9-131cea93b01a")
    EList<State> getSubmachineState();

    /**
     * Filtered Getter for relation 'StateMachine->SubmachineState'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("4210cd4d-04f4-435c-8a2c-bdf8cf5e3bbc")
    <T extends State> List<T> getSubmachineState(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'StateMachine->EntryPoint'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("20e2d069-9a05-4bf2-ac65-a69e3839f3d5")
    EList<EntryPointPseudoState> getEntryPoint();

    /**
     * Filtered Getter for relation 'StateMachine->EntryPoint'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2683482a-fb68-4c92-82ef-b2f8cdda89fe")
    <T extends EntryPointPseudoState> List<T> getEntryPoint(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'StateMachine->ExitPoint'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1b47f91a-9fd6-4663-a12f-9e7ada1c3bab")
    EList<ExitPointPseudoState> getExitPoint();

    /**
     * Filtered Getter for relation 'StateMachine->ExitPoint'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a6ee8ab1-c565-45ce-a892-a55512072072")
    <T extends ExitPointPseudoState> List<T> getExitPoint(java.lang.Class<T> filterClass);

}
