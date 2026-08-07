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
 * DeepHistoryPseudoState v0.0.9054
 *
 *
 * DeepHistoryPseudoState represents the most recent active configuration of the composite state that directly contains this pseudostate (e.g., the state configuration that was active when the composite state was last exited). A composite state can have at most one deep history vertex. At most one transition may originate from the history connector to the default deep history state. This transition is taken in case the composite state had never been active before. Entry actions of states entered on the path to the state represented by a deep history are performed.
 *
 */
@objid ("004ec28a-c4bf-1fd8-97fe-001ec947cd2a")
public interface DeepHistoryPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("1f40d4f3-3168-4047-a204-cf11f9343cfa")
    public static final String MNAME = "DeepHistoryPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd1ca485-e770-410b-ba4e-ceb88ffc8e5b")
    public static final String MQNAME = "Standard.DeepHistoryPseudoState";

}
