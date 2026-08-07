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
 * InternalTransition v0.0.9054
 *
 *
 * This Transition is related to a State. It can be triggered when entering or exiting the State, or can describe an activity that is performed whilst in the State (do Transitions).
 *
 * A Transition belongs to its origin StateVertex.
 *
 */
@objid ("005151a8-c4bf-1fd8-97fe-001ec947cd2a")
public interface InternalTransition extends Transition {
    /**
     * The metaclass simple name.
     */
    @objid ("f2009d9f-784d-4452-8b1f-0f3425b20b76")
    public static final String MNAME = "InternalTransition";

    /**
     * The metaclass qualified name.
     */
    @objid ("7db7171b-042d-4b95-a4a2-ed3ab5f62cd9")
    public static final String MQNAME = "Standard.InternalTransition";

    /**
     * Getter for relation 'InternalTransition->SComposed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0714a9a4-1977-4c57-b0b1-2b1a88c5ab1a")
    State getSComposed();

    /**
     * Setter for relation 'InternalTransition->SComposed'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("11eb0567-4909-4b85-9ae8-f6a802e251a0")
    void setSComposed(State value);

}
