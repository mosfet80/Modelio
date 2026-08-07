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
package org.modelio.metamodel.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * ValuePin v0.0.9054
 *
 *
 * null
 *
 */
@objid ("003ed672-c4bf-1fd8-97fe-001ec947cd2a")
public interface ValuePin extends InputPin {
    /**
     * The metaclass simple name.
     */
    @objid ("9345d121-cad4-4ffd-ac80-26123263971f")
    public static final String MNAME = "ValuePin";

    /**
     * The metaclass qualified name.
     */
    @objid ("47072db4-1446-4585-a66a-59044320d97a")
    public static final String MQNAME = "Standard.ValuePin";

    /**
     * Getter for attribute 'ValuePin.Value'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6c593dfd-2df2-4337-b83d-3b369b9ca7c3")
    String getValue();

    /**
     * Setter for attribute 'ValuePin.Value'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4eb8bd27-f456-4ec7-a44f-e964d5749b7f")
    void setValue(String value);

}
