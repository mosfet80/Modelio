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
 * OpaqueAction v0.0.9054
 *
 *
 * The semantics of the action are determined by the implementation. OpaqueAction is introduced for implementation-specific actions or for use as a temporary placeholder before some other action is chosen.
 *
 * Modelio specific:
 * The action may be filled in one language only.
 * Code generation MDA components may allow specific note types in order to allow the user to fill code in their generated language.
 *
 *
 */
@objid ("0039f63e-c4bf-1fd8-97fe-001ec947cd2a")
public interface OpaqueAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("b0e5d867-5c9d-4800-bc34-5c6f9320169d")
    public static final String MNAME = "OpaqueAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("e8e5f571-c8a8-4f45-b227-b3ddecd0c234")
    public static final String MQNAME = "Standard.OpaqueAction";

    /**
     * Getter for attribute 'OpaqueAction.Body'
     *
     * Metamodel description:
     * <i>Specifies the action in one language.</i>
     */
    @objid ("b2a3d142-d571-433b-b24c-36f9a1bda870")
    String getBody();

    /**
     * Setter for attribute 'OpaqueAction.Body'
     *
     * Metamodel description:
     * <i>Specifies the action in one language.</i>
     */
    @objid ("95a1b315-8eda-450c-9ebc-079adbecb59c")
    void setBody(String value);

}
