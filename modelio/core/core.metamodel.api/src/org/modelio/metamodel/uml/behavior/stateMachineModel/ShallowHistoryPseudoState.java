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
 * ShallowHistoryPseudoState v0.0.9054
 *
 *
 * ShallowHistoryPseudoState represents the most recent active substate of its containing state (but not the substates of that substate).
 *
 * A composite state can have at most one shallow history vertex. A transition coming into the shallow history vertex is equivalent to a transition coming into the most recent active substate of a state. At most one transition may originate from the history connector to the default shallow history state. This transition is taken in case the composite state had never been active before. Entry actions of states entered on the path to the state represented by a shallow history are performed.
 *
 *
 */
@objid ("0052e8a6-c4bf-1fd8-97fe-001ec947cd2a")
public interface ShallowHistoryPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("ba5e1a63-9c03-4a0d-9cc7-24c6fad1b896")
    public static final String MNAME = "ShallowHistoryPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("8e9da261-79d1-44d4-bd0e-cdebee231d49")
    public static final String MQNAME = "Standard.ShallowHistoryPseudoState";

}
