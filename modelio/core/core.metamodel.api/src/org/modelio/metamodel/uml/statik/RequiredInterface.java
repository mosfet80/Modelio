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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * RequiredInterface v0.0.9054
 *
 *
 *
 *
 */
@objid ("001b5224-c4bf-1fd8-97fe-001ec947cd2a")
public interface RequiredInterface extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("92cb3190-122c-47f5-ba07-983768b94f1c")
    public static final String MNAME = "RequiredInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("9dacfe66-45f0-4831-b6ec-93de59a5dfcd")
    public static final String MQNAME = "Standard.RequiredInterface";

    /**
     * Getter for relation 'RequiredInterface->RequiredElement'
     *
     * Metamodel description:
     * <i>Interface required by the Port.</i>
     */
    @objid ("c93688f8-8e4b-4ada-82ff-c64876b65a07")
    EList<Interface> getRequiredElement();

    /**
     * Filtered Getter for relation 'RequiredInterface->RequiredElement'
     *
     * Metamodel description:
     * <i>Interface required by the Port.</i>
     */
    @objid ("ca5c6b51-fc17-4348-beb3-d9734267ead3")
    <T extends Interface> List<T> getRequiredElement(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'RequiredInterface->Provider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("feddff3a-98c6-4680-902b-fa383d9cdf20")
    EList<LinkEnd> getProvider();

    /**
     * Filtered Getter for relation 'RequiredInterface->Provider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8f0844d6-ed44-476d-ba76-a520bbd02aac")
    <T extends LinkEnd> List<T> getProvider(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'RequiredInterface->Requiring'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5b482725-f69f-4726-92aa-8c3ece74bb6f")
    Port getRequiring();

    /**
     * Setter for relation 'RequiredInterface->Requiring'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("16a6b383-3310-4c10-8a05-91f7e2f41317")
    void setRequiring(Port value);

    /**
     * Getter for relation 'RequiredInterface->NaryProvider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4cc5a17c-ec11-472a-806b-51e6f2b65472")
    EList<NaryLinkEnd> getNaryProvider();

    /**
     * Filtered Getter for relation 'RequiredInterface->NaryProvider'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f6c9323-ae9a-4b9c-9ba0-813e6f82fd9a")
    <T extends NaryLinkEnd> List<T> getNaryProvider(java.lang.Class<T> filterClass);

}
