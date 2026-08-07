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
 * NaryAssociation v0.0.9054
 *
 *
 * null
 *
 */
@objid ("0021601a-c4bf-1fd8-97fe-001ec947cd2a")
public interface NaryAssociation extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b71efc98-42e3-4e6a-a088-b4ee81ae64fa")
    public static final String MNAME = "NaryAssociation";

    /**
     * The metaclass qualified name.
     */
    @objid ("aa423df0-1675-48f1-abef-e889e10d5390")
    public static final String MQNAME = "Standard.NaryAssociation";

    /**
     * Getter for relation 'NaryAssociation->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("23f1cad1-6d3b-4ce7-b1b3-44a98bc4ebb0")
    EList<NaryLink> getOccurence();

    /**
     * Filtered Getter for relation 'NaryAssociation->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("788bc549-d317-445c-aaad-024a39796650")
    <T extends NaryLink> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NaryAssociation->NaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f0ae37c0-2def-4f23-9149-580b4ec91da7")
    EList<NaryAssociationEnd> getNaryEnd();

    /**
     * Filtered Getter for relation 'NaryAssociation->NaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("198264f5-1a8b-4e41-9be3-cba5d64104f9")
    <T extends NaryAssociationEnd> List<T> getNaryEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'NaryAssociation->LinkToClass'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2c9fb3f2-d4f7-4abc-87d4-eb5a41209c37")
    ClassAssociation getLinkToClass();

    /**
     * Setter for relation 'NaryAssociation->LinkToClass'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("476ed4f1-186c-4b1e-a00c-be0e11a94356")
    void setLinkToClass(ClassAssociation value);

}
