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
 * ChoicePseudoState v0.0.9054
 *
 *
 * ChoicePseudoState vertices result in the dynamic evaluation of the guards of the triggers of its outgoing transitions. This realizes a dynamic conditional branch. It allows transitions to be split into multiple outgoing paths such that the decision on which path to take may be a function of the results of prior actions performed in the same run-to-completion step. If more than one of the guards evaluates to true, an arbitrary one is selected. If none of the guards evaluates to true, then the model is considered ill-formed. (To avoid this, it is recommended that you define one outgoing transition with the predefined "else" guard for every choice vertex.) Choice vertices should be distinguished from static branch points that are based on junction points (described above).
 *
 */
@objid ("004dc326-c4bf-1fd8-97fe-001ec947cd2a")
public interface ChoicePseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("28a151c7-0881-42af-8765-e48138f86fa4")
    public static final String MNAME = "ChoicePseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("85f60d53-5f5e-44ba-a398-70576c4fb96b")
    public static final String MQNAME = "Standard.ChoicePseudoState";

}
