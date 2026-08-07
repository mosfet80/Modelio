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

/**
 * Class v0.0.9054
 *
 *
 * The Class is the main concept used in object-oriented modeling. It specifies which Instances can exist in an application.
 *
 * In Modelio, a Class is owned by a NameSpace (ModelTree) that can be a Package or a Class.
 *
 */
@objid ("0002155c-c4bf-1fd8-97fe-001ec947cd2a")
public interface Class extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("9ed10bd8-d5ab-4353-b332-63cc9ff68194")
    public static final String MNAME = "Class";

    /**
     * The metaclass qualified name.
     */
    @objid ("688b45b3-1123-457a-96be-bc04cb325330")
    public static final String MQNAME = "Standard.Class";

    /**
     * Getter for attribute 'Class.IsActive'
     *
     * Metamodel description:
     * <i>Specifies whether an Object of the Class maintains its own thread of control. If true, then an Object has its own thread of control and runs concurrently with other active Objects. If false, then Operations run in the address space and under the control of the active Object that controls the caller.</i>
     */
    @objid ("8b5b6ba8-f9fe-47bc-be09-9de62b06f1ac")
    boolean isIsActive();

    /**
     * Setter for attribute 'Class.IsActive'
     *
     * Metamodel description:
     * <i>Specifies whether an Object of the Class maintains its own thread of control. If true, then an Object has its own thread of control and runs concurrently with other active Objects. If false, then Operations run in the address space and under the control of the active Object that controls the caller.</i>
     */
    @objid ("84336ad4-83ac-4f99-b6be-d97fed4b6fe8")
    void setIsActive(boolean value);

    /**
     * Getter for attribute 'Class.IsMain'
     *
     * Metamodel description:
     * <i>A main Class is a Class whose unique instance represents the application.</i>
     */
    @objid ("38ede4f4-f9fe-4522-af5b-c2c5601e7059")
    boolean isIsMain();

    /**
     * Setter for attribute 'Class.IsMain'
     *
     * Metamodel description:
     * <i>A main Class is a Class whose unique instance represents the application.</i>
     */
    @objid ("87232a07-d0c8-4632-9514-270fed9627e1")
    void setIsMain(boolean value);

    /**
     * Getter for relation 'Class->LinkToAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dc93eba8-44f9-4cef-a02d-af196fbeed94")
    ClassAssociation getLinkToAssociation();

    /**
     * Setter for relation 'Class->LinkToAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("43f182fe-b720-44b5-ac0a-c305f7a6d3f0")
    void setLinkToAssociation(ClassAssociation value);

}
