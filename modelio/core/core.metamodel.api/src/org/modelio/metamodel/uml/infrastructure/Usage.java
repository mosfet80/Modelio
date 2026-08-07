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
package org.modelio.metamodel.uml.infrastructure;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.Dependency;

/**
 * Usage v0.0.9054
 *
 *
 * A Usage is a relationship in which one element requires another element (or set of elements) for its full implementation or operation.
 *
 * In the metamodel, a Usage is a Dependency in which the client requires the presence of the supplier.
 *
 *
 */
@objid ("0090bf1e-c4be-1fd8-97fe-001ec947cd2a")
public interface Usage extends Dependency {
    /**
     * The metaclass simple name.
     */
    @objid ("3d2025ce-784b-47fe-975f-991a089eb84a")
    public static final String MNAME = "Usage";

    /**
     * The metaclass qualified name.
     */
    @objid ("5fbd89c9-c994-4a8c-b15e-bc5ec6ab94c7")
    public static final String MQNAME = "Standard.Usage";

}
