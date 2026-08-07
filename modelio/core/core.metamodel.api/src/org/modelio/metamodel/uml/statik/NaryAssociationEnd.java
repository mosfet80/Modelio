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
 * NaryAssociationEnd v0.0.9054
 *
 *
 * null
 *
 */
@objid ("00209ca2-c4bf-1fd8-97fe-001ec947cd2a")
public interface NaryAssociationEnd extends StructuralFeature {
    /**
     * The metaclass simple name.
     */
    @objid ("cae79236-fe9d-4459-9917-bd8a52f9828a")
    public static final String MNAME = "NaryAssociationEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("38f35942-cab2-4afe-b978-b440b8024d24")
    public static final String MQNAME = "Standard.NaryAssociationEnd";

    /**
     * Getter for relation 'NaryAssociationEnd->NaryAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("07a577ea-4de3-46b2-be8f-ef2aa7f3ec7e")
    NaryAssociation getNaryAssociation();

    /**
     * Setter for relation 'NaryAssociationEnd->NaryAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("73dc4d5b-01fe-421d-bd2b-1d8b132b4385")
    void setNaryAssociation(NaryAssociation value);

    /**
     * Getter for relation 'NaryAssociationEnd->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7f6098b7-66f0-4346-b179-15022082ad74")
    Classifier getOwner();

    /**
     * Setter for relation 'NaryAssociationEnd->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d133476a-af89-4404-889b-2e1dcc15577d")
    void setOwner(Classifier value);

}
