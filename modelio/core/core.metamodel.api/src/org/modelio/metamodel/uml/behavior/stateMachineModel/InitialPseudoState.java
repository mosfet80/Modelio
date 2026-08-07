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
 * InitialPseudoState v0.0.9054
 *
 *
 * An initial pseudostate represents a default vertex that is the source for a single transition to the default state of a composite state. There can be at most one initial vertex in a region. The outgoing transition from the initial vertex may have a behavior, but not a trigger or guard.
 *
 */
@objid ("0050cd82-c4bf-1fd8-97fe-001ec947cd2a")
public interface InitialPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("b66f3124-5aac-4af1-b2fb-6cb6529bea89")
    public static final String MNAME = "InitialPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("820e4d00-e051-41a9-9658-9f7f63852389")
    public static final String MQNAME = "Standard.InitialPseudoState";

}
