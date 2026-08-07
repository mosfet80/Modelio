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
 * Constraint v0.0.9054
 *
 *
 * Constraints can express restrictions and relationships that cannot be expressed using UML notation. They are particularly useful for stating global conditions or conditions that affect a number of elements.
 *
 * Constraints can have predefined names, and can also represent pre-conditions, post-conditions and invariants (pre-defined stereotypes).
 *
 * The language specific MDACs (C++, Java) add a specific stereotype for the pre-conditions, post-conditions and invariants expressed in these languages, such as, for example, C++Invariant or JavaPreCondition.
 *
 * In Modelio, a Constraint is not made up of anything. It is only  managed by specific copy/transfer rules.
 *
 */
@objid ("008538a6-c4be-1fd8-97fe-001ec947cd2a")
public interface Constraint extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("de1aaaaf-156e-486f-8596-a625b8bdd60c")
    public static final String MNAME = "Constraint";

    /**
     * The metaclass qualified name.
     */
    @objid ("ca0828fb-157c-4b47-8d1a-9978ddd15d01")
    public static final String MQNAME = "Standard.Constraint";

    /**
     * Getter for attribute 'Constraint.BaseClass'
     *
     * Metamodel description:
     * <i>MetaClass whose instances can be constrained by the current Constraint.</i>
     */
    @objid ("dee092ce-bb5c-4e66-9329-453c4e89ac9d")
    String getBaseClass();

    /**
     * Setter for attribute 'Constraint.BaseClass'
     *
     * Metamodel description:
     * <i>MetaClass whose instances can be constrained by the current Constraint.</i>
     */
    @objid ("2358a095-09e9-49bd-a85b-6732079da07c")
    void setBaseClass(String value);

    /**
     * Getter for attribute 'Constraint.Body'
     *
     * Metamodel description:
     * <i>If the Constraint is not predefined (for example, ordered), then it is expressed in the body.
     *
     * Modelio supports natural language. For every generator (C++, Java) some constraints have a dedicated stereotype (JavaPrecondition, C++Invariant), and are taken into account during code generation.</i>
     */
    @objid ("5971d503-242f-4792-9c22-da7e4da13d89")
    String getBody();

    /**
     * Setter for attribute 'Constraint.Body'
     *
     * Metamodel description:
     * <i>If the Constraint is not predefined (for example, ordered), then it is expressed in the body.
     *
     * Modelio supports natural language. For every generator (C++, Java) some constraints have a dedicated stereotype (JavaPrecondition, C++Invariant), and are taken into account during code generation.</i>
     */
    @objid ("a77848ad-7be7-48c6-9a53-bee4015f56dc")
    void setBody(String value);

    /**
     * Getter for attribute 'Constraint.Language'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0464b36d-2a0f-428e-a4fc-1da8a4fe82dd")
    String getLanguage();

    /**
     * Setter for attribute 'Constraint.Language'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d9940dcb-aad6-4d6c-a117-bf1dc61ab765")
    void setLanguage(String value);

    /**
     * Getter for relation 'Constraint->ConstrainedElement'
     *
     * Metamodel description:
     * <i>Defines which elements are concerned by the Constraint.</i>
     */
    @objid ("f4368f8f-7071-4c39-9317-e781755fa499")
    EList<UmlModelElement> getConstrainedElement();

    /**
     * Filtered Getter for relation 'Constraint->ConstrainedElement'
     *
     * Metamodel description:
     * <i>Defines which elements are concerned by the Constraint.</i>
     */
    @objid ("6b266709-7812-44ae-8730-2716a19e83e3")
    <T extends UmlModelElement> List<T> getConstrainedElement(java.lang.Class<T> filterClass);

}
