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

/**
 * Enumeration v0.0.9054
 *
 *
 * An Enumeration corresponds to C++ or Java enum, or equivalent types in Pascal, Ada or any other language.
 *
 * In Modelio, an Enumeration belongs to its NameSpace.
 *
 */
@objid ("000981a2-c4bf-1fd8-97fe-001ec947cd2a")
public interface Enumeration extends GeneralClass {
    /**
     * The metaclass simple name.
     */
    @objid ("de76a6e8-f3a8-4cd5-b5f9-c27c78c9f0ad")
    public static final String MNAME = "Enumeration";

    /**
     * The metaclass qualified name.
     */
    @objid ("ea4d8a08-230b-489e-8058-c84cd0e8b69c")
    public static final String MQNAME = "Standard.Enumeration";

    /**
     * Getter for relation 'Enumeration->Value'
     *
     * Metamodel description:
     * <i>Link to the "Literal", which represents the possible values of the type representatives.</i>
     */
    @objid ("88956535-40e5-4e8b-889a-814aeb4d054c")
    EList<EnumerationLiteral> getValue();

    /**
     * Filtered Getter for relation 'Enumeration->Value'
     *
     * Metamodel description:
     * <i>Link to the "Literal", which represents the possible values of the type representatives.</i>
     */
    @objid ("f1b56d0b-fe2b-4a41-ba29-1398aed2c6be")
    <T extends EnumerationLiteral> List<T> getValue(java.lang.Class<T> filterClass);

}
