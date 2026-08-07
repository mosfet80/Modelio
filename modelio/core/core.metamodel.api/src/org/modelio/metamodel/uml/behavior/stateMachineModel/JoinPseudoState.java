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
 * JoinPseudoState v0.0.9054
 *
 *
 * Join vertices serve to merge several transitions emanating from source vertices in different orthogonal regions. The transitions entering a join vertex cannot have guards or triggers.
 *
 */
@objid ("0051d7ea-c4bf-1fd8-97fe-001ec947cd2a")
public interface JoinPseudoState extends AbstractPseudoState {
    /**
     * The metaclass simple name.
     */
    @objid ("7aa60e2a-bd8c-448d-9be5-35c85184b052")
    public static final String MNAME = "JoinPseudoState";

    /**
     * The metaclass qualified name.
     */
    @objid ("eb749730-fd3a-49cc-bdb3-6cd20d65268e")
    public static final String MQNAME = "Standard.JoinPseudoState";

}
