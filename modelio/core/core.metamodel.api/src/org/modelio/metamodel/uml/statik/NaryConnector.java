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
 * NaryConnector v0.0.9054
 *
 *
 * null
 *
 */
@objid ("0005d2fa-c4bf-1fd8-97fe-001ec947cd2a")
public interface NaryConnector extends NaryLink {
    /**
     * The metaclass simple name.
     */
    @objid ("d0b52fcd-b311-46ad-af7b-b136fec99054")
    public static final String MNAME = "NaryConnector";

    /**
     * The metaclass qualified name.
     */
    @objid ("4f524448-0a80-41ec-8027-6aaf8c9ccf56")
    public static final String MQNAME = "Standard.NaryConnector";

    /**
     * Getter for relation 'NaryConnector->Representation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("22446bea-7eed-40ee-b7ac-03944fd1513a")
    EList<Binding> getRepresentation();

    /**
     * Filtered Getter for relation 'NaryConnector->Representation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3c276a77-dd32-46ee-9494-dda537e7d929")
    <T extends Binding> List<T> getRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NaryConnector->RepresentedFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3f6eb11e-4f7d-4809-8093-128bebd894fb")
    UmlModelElement getRepresentedFeature();

    /**
     * Setter for relation 'NaryConnector->RepresentedFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0a7a5f93-f292-491c-b7f1-21bb6626c5d6")
    void setRepresentedFeature(UmlModelElement value);

}
