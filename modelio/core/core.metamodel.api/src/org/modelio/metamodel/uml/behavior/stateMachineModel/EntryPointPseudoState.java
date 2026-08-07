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
 * EntryPointPseudoState v0.0.9054
 *
 *
 * An entry point pseudostate is an entry point of a state machine or composite state. In each region of the state machine or composite state it has a single transition to a vertex within the same region.
 *
 */
@objid ("004f3f3a-c4bf-1fd8-97fe-001ec947cd2a")
public interface EntryPointPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("22efd332-cb38-4efd-acdc-42382d729ab6")
    public static final String MNAME = "EntryPointPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("b8f26bd5-1e0a-4b1e-87d0-4d9359711a55")
    public static final String MQNAME = "Standard.EntryPointPseudoState";

    /**
     * Getter for relation 'EntryPointPseudoState->EntryOf'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("d8cbc182-71cf-421c-b91a-a873aad83bcf")
    State getEntryOf();

    /**
     * Setter for relation 'EntryPointPseudoState->EntryOf'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("04c5f1d7-a523-4227-a061-0b9f077f7ca6")
    void setEntryOf(State value);

    /**
     * Getter for relation 'EntryPointPseudoState->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("4b789d9c-e2d2-4d83-b6ef-808474f119ac")
    EList<ConnectionPointReference> getConnection();

    /**
     * Filtered Getter for relation 'EntryPointPseudoState->Connection'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("1d3e56f8-96b9-4040-acb2-4dad43856b50")
    <T extends ConnectionPointReference> List<T> getConnection(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'EntryPointPseudoState->EntryOfMachine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("282acadc-c25e-4e4e-adfa-946647b051a1")
    StateMachine getEntryOfMachine();

    /**
     * Setter for relation 'EntryPointPseudoState->EntryOfMachine'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("48b6cc61-02b6-4e95-a0d9-62e3286eae67")
    void setEntryOfMachine(StateMachine value);

}
