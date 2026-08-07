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
package org.modelio.metamodel.uml.infrastructure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;

/**
 * ModelTree v0.0.9054
 *
 *
 * The ElementOwnerShip association provides a hierarchy of ModelElements that can be managed by the model explorer or by the teamwork facility.
 *
 * This metaclass is not part of the UML standard. NameSpace is a typical subclass, which takes advantage of the containment facility provided by ModelTree.
 *
 */
@objid ("00891e1c-c4be-1fd8-97fe-001ec947cd2a")
public interface ModelTree extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3a2ca57c-f1f1-4eab-b55c-b62e266c1e4b")
    public static final String MNAME = "ModelTree";

    /**
     * The metaclass qualified name.
     */
    @objid ("16637bbe-2592-4a27-9363-421e68ae5a87")
    public static final String MQNAME = "Standard.ModelTree";

    /**
     * Getter for relation 'ModelTree->Owner'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("5b05c191-4f02-4daf-8cc7-c8b74d2b22ea")
    ModelTree getOwner();

    /**
     * Setter for relation 'ModelTree->Owner'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("e71efb7d-2d6a-4cb8-8935-2e884cc1e58b")
    void setOwner(ModelTree value);

    /**
     * Getter for relation 'ModelTree->OwnedElement'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("91f95c58-84b4-4396-b98b-6b88afe911b6")
    EList<ModelTree> getOwnedElement();

    /**
     * Filtered Getter for relation 'ModelTree->OwnedElement'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("469f3937-3ac4-4748-86d7-5a5d228cd034")
    <T extends ModelTree> List<T> getOwnedElement(java.lang.Class<T> filterClass);

}
