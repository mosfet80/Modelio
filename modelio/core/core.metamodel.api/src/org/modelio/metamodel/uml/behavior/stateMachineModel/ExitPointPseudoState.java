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

/**
 * ExitPointPseudoState v0.0.9054
 *
 *
 * An exit point pseudostate is an exit point of a state machine or composite state. Entering an exit point within any region of the composite state or state machine referenced by a submachine state implies the exit of this composite state or submachine state and the triggering of the transition that has this exit point as source in the state machine enclosing the submachine or composite state.
 *
 */
@objid ("004fc78e-c4bf-1fd8-97fe-001ec947cd2a")
public interface ExitPointPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("ff99c899-c8d1-4a1e-90f2-ec6c3ca3c1c2")
    public static final String MNAME = "ExitPointPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("54b822ff-e76a-4931-9fde-a50ad2db9d3d")
    public static final String MQNAME = "Standard.ExitPointPseudoState";

    /**
     * Getter for relation 'ExitPointPseudoState->ExitOf'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("9a24ff73-631a-4c0d-8bf3-c56de20118fe")
    State getExitOf();

    /**
     * Setter for relation 'ExitPointPseudoState->ExitOf'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("b64d58d9-33e8-4d69-be68-9e061ce6387c")
    void setExitOf(State value);

    /**
     * Getter for relation 'ExitPointPseudoState->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("0b0f72a4-cae4-47ee-94ec-c27aec3169f9")
    EList<ConnectionPointReference> getConnection();

    /**
     * Filtered Getter for relation 'ExitPointPseudoState->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("b3654ba8-2b6d-43ee-8c16-b99edd1173c4")
    <T extends ConnectionPointReference> List<T> getConnection(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ExitPointPseudoState->ExitOfMachine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("95d5fa76-eb0c-4e87-8298-50ca9d8c45be")
    StateMachine getExitOfMachine();

    /**
     * Setter for relation 'ExitPointPseudoState->ExitOfMachine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("14df35aa-fb38-43db-9d9b-ad75b9be4375")
    void setExitOfMachine(StateMachine value);

}
