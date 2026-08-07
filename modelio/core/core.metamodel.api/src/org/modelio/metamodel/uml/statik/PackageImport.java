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
 * PackageImport v0.0.9054
 *
 *
 * A PackageImport is defined as a directed relationship that identifies a Package whose members are to be imported by a NameSpace.
 *
 * A PackageImport is a relationship between an importing NameSpace and a Package, indicating that the importing NameSpace adds the names of the members of the Package to its own NameSpace.
 *
 * Conceptually, a PackageImport is equivalent to having an ElementImport to each individual member of the imported NameSpace, unless there is already a separately defined ElementImport.
 *
 */
@objid ("00160b66-c4bf-1fd8-97fe-001ec947cd2a")
public interface PackageImport extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("18e29e99-e3d8-41e6-9d1f-6decf4ae814a")
    public static final String MNAME = "PackageImport";

    /**
     * The metaclass qualified name.
     */
    @objid ("bec94404-a069-4790-8ff7-80ee84f55efa")
    public static final String MQNAME = "Standard.PackageImport";

    /**
     * Getter for attribute 'PackageImport.Visibility'
     *
     * Metamodel description:
     * <i>Member visibility (public or private).</i>
     */
    @objid ("b6a09926-760b-4216-8b25-e2856d7eb8e7")
    VisibilityMode getVisibility();

    /**
     * Setter for attribute 'PackageImport.Visibility'
     *
     * Metamodel description:
     * <i>Member visibility (public or private).</i>
     */
    @objid ("444db26a-ba67-4c7c-938a-fe1716ef3ce7")
    void setVisibility(VisibilityMode value);

    /**
     * Getter for relation 'PackageImport->ImportingOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7be804fd-67be-4187-812b-0e7350759f08")
    Operation getImportingOperation();

    /**
     * Setter for relation 'PackageImport->ImportingOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7d07dcc0-bc95-42da-b49b-7018af7c270c")
    void setImportingOperation(Operation value);

    /**
     * Getter for relation 'PackageImport->ImportingNameSpace'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("547f8a2d-d0c5-4406-a85f-73e7d75b2157")
    NameSpace getImportingNameSpace();

    /**
     * Setter for relation 'PackageImport->ImportingNameSpace'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1b2245b0-7f55-4dab-902a-90bc8eedc2fa")
    void setImportingNameSpace(NameSpace value);

    /**
     * Getter for relation 'PackageImport->ImportedPackage'
     *
     * Metamodel description:
     * <i>Specifies the Package whose members are imported into a Namespace. Subsets DirectedRelationship:: target.</i>
     */
    @objid ("4032fe22-4503-4380-9195-b204867e6311")
    Package getImportedPackage();

    /**
     * Setter for relation 'PackageImport->ImportedPackage'
     *
     * Metamodel description:
     * <i>Specifies the Package whose members are imported into a Namespace. Subsets DirectedRelationship:: target.</i>
     */
    @objid ("cf188a98-9af9-4dab-a83f-acb8fb202990")
    void setImportedPackage(Package value);

}
