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
 * Association v0.0.9054
 *
 *
 * An Association describes discrete connections among objects or other instances in a system.  An Association is often established between two Classes (binary associations), but can be established between several Classes (n-ary associations).
 *
 * An Association can be related to a ClassAssociation that may, for example, provide Attributes and Operations.  The connections to the associated Classes are specified through the AssociationEnd metaclass.  The AssociationEnd metaclass will provide the properties of an Association, such as cardinalities, navigability, and so on. Aggregation is a specific case of an Association.
 *
 * In Modelio, an Association physically belongs to no other elements. It has a specific way of behaving during transfer and copy/paste operations, depending on whether the connected Classes are transferred in conjunction or not.
 *
 */
@objid ("28f7c9fd-bee9-46f0-8969-5c46572cec86")
public interface Association extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("1d9bdc03-0b40-4566-a24f-7218622f3b90")
    public static final String MNAME = "Association";

    /**
     * The metaclass qualified name.
     */
    @objid ("22c76033-85e4-4456-b898-e3357197378b")
    public static final String MQNAME = "Standard.Association";

    /**
     * Getter for relation 'Association->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("206454a9-1b3a-4bcd-a84d-6c602a9ec33f")
    EList<Link> getOccurence();

    /**
     * Filtered Getter for relation 'Association->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d22ae633-993d-4719-a985-77b08a5dd1e8")
    <T extends Link> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Association->End'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("719e3228-1d20-4823-a641-0f9eab768d01")
    EList<AssociationEnd> getEnd();

    /**
     * Filtered Getter for relation 'Association->End'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("09f2457a-bfdb-4a70-9132-58ee4d817084")
    <T extends AssociationEnd> List<T> getEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Association->LinkToClass'
     *
     * Metamodel description:
     * <i>Specifies a ClassAssociation that may be related to the Association.</i>
     */
    @objid ("02f6cb1d-9113-4cb9-8236-5540932fd62a")
    ClassAssociation getLinkToClass();

    /**
     * Setter for relation 'Association->LinkToClass'
     *
     * Metamodel description:
     * <i>Specifies a ClassAssociation that may be related to the Association.</i>
     */
    @objid ("d9e4b519-66c8-4544-8a45-35277be1551c")
    void setLinkToClass(ClassAssociation value);

}
