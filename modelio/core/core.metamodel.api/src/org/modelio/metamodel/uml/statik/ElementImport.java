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
 * ElementImport v0.0.9054
 *
 *
 * ModelElement.Name: Specifies the name that should be added to the namespace of the importing Package in lieu of the name of the imported PackagableElement. The aliased name must not clash with any other member name in the importing Package. By default, no alias is used.
 *
 */
@objid ("0008034a-c4bf-1fd8-97fe-001ec947cd2a")
public interface ElementImport extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("ffb67c59-55e6-4fa1-946e-3ff2391ac3ac")
    public static final String MNAME = "ElementImport";

    /**
     * The metaclass qualified name.
     */
    @objid ("f8f828f8-57a0-47d2-a5e1-62712babcd2f")
    public static final String MQNAME = "Standard.ElementImport";

    /**
     * Getter for attribute 'ElementImport.Visibility'
     *
     * Metamodel description:
     * <i>Specifies the visibility of the imported PackageableElement within the importing Package. The default visibility is the same as that of the imported element. If the imported element does not have a visibility, it is possible to add visibility to the element import.
     *
     * The visibility of an ElementImport is either public or private.</i>
     */
    @objid ("46910994-2149-492f-b507-d62477e9b3d1")
    VisibilityMode getVisibility();

    /**
     * Setter for attribute 'ElementImport.Visibility'
     *
     * Metamodel description:
     * <i>Specifies the visibility of the imported PackageableElement within the importing Package. The default visibility is the same as that of the imported element. If the imported element does not have a visibility, it is possible to add visibility to the element import.
     *
     * The visibility of an ElementImport is either public or private.</i>
     */
    @objid ("32b50c03-82d9-45f7-80f6-1886f9c2fe8b")
    void setVisibility(VisibilityMode value);

    /**
     * Getter for relation 'ElementImport->ImportingNameSpace'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d7b1f9a3-03ef-4f54-8735-b2c3ee2f62c7")
    NameSpace getImportingNameSpace();

    /**
     * Setter for relation 'ElementImport->ImportingNameSpace'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("323e2855-b100-429f-a5a1-9da01cc87819")
    void setImportingNameSpace(NameSpace value);

    /**
     * Getter for relation 'ElementImport->ImportedElement'
     *
     * Metamodel description:
     * <i>Specifies the PackageableElement whose name is to be added to a Namespace. Subsets DirectedRelationship::target.</i>
     */
    @objid ("dbaaee81-493c-4d68-963a-753c73844aba")
    NameSpace getImportedElement();

    /**
     * Setter for relation 'ElementImport->ImportedElement'
     *
     * Metamodel description:
     * <i>Specifies the PackageableElement whose name is to be added to a Namespace. Subsets DirectedRelationship::target.</i>
     */
    @objid ("ccec10b3-dedb-4c2e-a051-c4892b1bcda4")
    void setImportedElement(NameSpace value);

    /**
     * Getter for relation 'ElementImport->ImportingOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fe05e017-ec07-44fd-9e1c-6f7adb04ae73")
    Operation getImportingOperation();

    /**
     * Setter for relation 'ElementImport->ImportingOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("751bc436-74eb-4eba-abd7-85e2f3b570fa")
    void setImportingOperation(Operation value);

}
