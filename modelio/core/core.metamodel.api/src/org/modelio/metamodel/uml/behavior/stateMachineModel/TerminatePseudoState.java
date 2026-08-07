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
 * TerminatePseudoState v0.0.9054
 *
 *
 * Entering a TerminatePseudoState implies that the execution of this state machine by means of its context object is terminated. The state machine does not exit any states nor does it perform any exit actions other than those associated with the transition leading to the terminate pseudostate. Entering a terminate pseudostate is equivalent to invoking a DestroyObjectAction.
 *
 */
@objid ("0055240e-c4bf-1fd8-97fe-001ec947cd2a")
public interface TerminatePseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("9f683452-3a77-4a18-9e1e-9de1a1aa0fe4")
    public static final String MNAME = "TerminatePseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("5792ec9f-ff4e-4590-a5c0-e8d5a6e7f72b")
    public static final String MQNAME = "Standard.TerminatePseudoState";

}
