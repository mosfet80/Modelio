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

/**
 * ConnectionPointReference v0.0.9054
 *
 *
 *
 *
 */
@objid ("004e3efa-c4bf-1fd8-97fe-001ec947cd2a")
public interface ConnectionPointReference extends StateVertex {
    /**
     * The metaclass simple name.
     */
    @objid ("65590e4d-7238-44f5-a45c-346d436d44be")
    public static final String MNAME = "ConnectionPointReference";

    /**
     * The metaclass qualified name.
     */
    @objid ("5ccf653d-f119-4e8a-8c5f-ffb18eff2852")
    public static final String MQNAME = "Standard.ConnectionPointReference";

    /**
     * Getter for relation 'ConnectionPointReference->Exit'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("6d9d3cad-4558-4037-9173-7c0fa5843d98")
    ExitPointPseudoState getExit();

    /**
     * Setter for relation 'ConnectionPointReference->Exit'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("51989e4d-2ca3-4fe5-90d8-bbf3d5c7d7bd")
    void setExit(ExitPointPseudoState value);

    /**
     * Getter for relation 'ConnectionPointReference->Entry'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("0825013b-1269-45dd-934b-276dc2f27db2")
    EntryPointPseudoState getEntry();

    /**
     * Setter for relation 'ConnectionPointReference->Entry'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("d4f149c2-84fd-4d16-9291-2d0838deab91")
    void setEntry(EntryPointPseudoState value);

    /**
     * Getter for relation 'ConnectionPointReference->OwnerState'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("de138d55-9547-4361-aa27-3bf1fe34cc83")
    State getOwnerState();

    /**
     * Setter for relation 'ConnectionPointReference->OwnerState'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("35c9737a-44b8-4cd3-b5e9-f6f2be47a1bf")
    void setOwnerState(State value);

}
