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
 * ClassAssociation v0.0.9054
 *
 *
 * A ClassAssociation is represented in UML as a Class that plays the role of an Association.
 *
 * In Modelio, a ClassAssociation belongs to an Association.
 *
 */
@objid ("0002bc78-c4bf-1fd8-97fe-001ec947cd2a")
public interface ClassAssociation extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("053cba00-3b9b-46a3-8d63-d9c8788d32f0")
    public static final String MNAME = "ClassAssociation";

    /**
     * The metaclass qualified name.
     */
    @objid ("886b49c8-b644-46bd-aeb8-0ba30f8ef110")
    public static final String MQNAME = "Standard.ClassAssociation";

    /**
     * Getter for relation 'ClassAssociation->NaryAssociationPart'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("71f04719-37f5-4228-9590-88a6033b7fb7")
    NaryAssociation getNaryAssociationPart();

    /**
     * Setter for relation 'ClassAssociation->NaryAssociationPart'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("938337ef-1118-49c2-9d1a-23d3a76d4994")
    void setNaryAssociationPart(NaryAssociation value);

    /**
     * Getter for relation 'ClassAssociation->ClassPart'
     *
     * Metamodel description:
     * <i>Link to the Class that composes the ClassAssociation.</i>
     */
    @objid ("945c3ca4-3a85-4161-9f60-5b95bdc57236")
    Class getClassPart();

    /**
     * Setter for relation 'ClassAssociation->ClassPart'
     *
     * Metamodel description:
     * <i>Link to the Class that composes the ClassAssociation.</i>
     */
    @objid ("47111325-8c99-4139-bc93-87495c97c0ee")
    void setClassPart(Class value);

    /**
     * Getter for relation 'ClassAssociation->AssociationPart'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c15e4830-7ee2-4ecb-a875-1056f592e1ca")
    Association getAssociationPart();

    /**
     * Setter for relation 'ClassAssociation->AssociationPart'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("22bd4b68-6a44-4254-83eb-c3f23e9fd73d")
    void setAssociationPart(Association value);

}
