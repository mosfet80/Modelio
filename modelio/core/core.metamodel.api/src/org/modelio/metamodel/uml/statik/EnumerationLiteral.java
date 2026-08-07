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
package org.modelio.metamodel.uml.statik;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * EnumerationLiteral v0.0.9054
 *
 *
 * An EnumerationLiteral is a possible value of an enumeration. The Name of the EnumerationLiteral represents its symbolic value.
 *
 * An EnumerationLiteral belongs to its Enumeration.
 *
 *
 */
@objid ("000a43ee-c4bf-1fd8-97fe-001ec947cd2a")
public interface EnumerationLiteral extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("efb17fb5-a535-4d87-a5dd-18c8980436ee")
    public static final String MNAME = "EnumerationLiteral";

    /**
     * The metaclass qualified name.
     */
    @objid ("3164e273-dd14-4e95-98f3-349231b58b7c")
    public static final String MQNAME = "Standard.EnumerationLiteral";

    /**
     * Getter for relation 'EnumerationLiteral->Valuated'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c7fdcc21-8423-4c77-bc22-2c84ff8fbf9e")
    Enumeration getValuated();

    /**
     * Setter for relation 'EnumerationLiteral->Valuated'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5fae4e61-f8ce-49e3-babe-2d9dd9750119")
    void setValuated(Enumeration value);

}
