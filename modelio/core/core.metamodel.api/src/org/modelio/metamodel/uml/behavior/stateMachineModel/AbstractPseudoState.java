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
 * AbstractPseudoState v0.0.9054
 *
 *
 * PseudoStates represent every kind of graphical Node in a StateMachine, except States, such as a branch, a fork, and so on.
 *
 * Modelio specific:
 * AbstractPseudoState is used to seemlessly migrate old PseudoState elements to the upcoming UML2PseudoState class hierarchy.
 *
 *
 */
@objid ("004d4b30-c4bf-1fd8-97fe-001ec947cd2a")
public interface AbstractPseudoState extends StateVertex {
    /**
     * The metaclass simple name.
     */
    @objid ("71c8da98-d8ba-4f34-8ded-c5d7dc6aad8d")
    public static final String MNAME = "AbstractPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("a7a16c89-ba02-43d7-8be7-25a253030f16")
    public static final String MQNAME = "Standard.AbstractPseudoState";

}
