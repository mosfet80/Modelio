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
package org.modelio.metamodel.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Clause v0.0.9054
 *
 *
 * A clause is an element that represents a single branch of a conditional construct, including a test and a body section. The body section is executed only (but not necessarily) if the test section is true.
 *
 */
@objid ("002cb618-c4bf-1fd8-97fe-001ec947cd2a")
public interface Clause extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("513e037c-4b78-4eea-a48b-9279d0061e5b")
    public static final String MNAME = "Clause";

    /**
     * The metaclass qualified name.
     */
    @objid ("43febc64-11e5-4b48-bc32-1ca0d68e28cf")
    public static final String MQNAME = "Standard.Clause";

    /**
     * Getter for attribute 'Clause.Test'
     *
     * Metamodel description:
     * <i>Specifies the result of the test.</i>
     */
    @objid ("b2996388-0b3d-4759-9694-4fbff220764a")
    String getTest();

    /**
     * Setter for attribute 'Clause.Test'
     *
     * Metamodel description:
     * <i>Specifies the result of the test.</i>
     */
    @objid ("5a52e8ed-0e03-4a2e-b4ea-9b4794972045")
    void setTest(String value);

    /**
     * Getter for relation 'Clause->Body'
     *
     * Metamodel description:
     * <i>A nested activity fragment that is executed if the test is true and the clause is chosen over any concurrent clauses that are also true.</i>
     */
    @objid ("157c5ca5-b339-4a95-bb9d-2e81735c16fc")
    EList<ActivityNode> getBody();

    /**
     * Filtered Getter for relation 'Clause->Body'
     *
     * Metamodel description:
     * <i>A nested activity fragment that is executed if the test is true and the clause is chosen over any concurrent clauses that are also true.</i>
     */
    @objid ("99b4a1e7-9d17-40a5-8861-e7d3d5e1f49b")
    <T extends ActivityNode> List<T> getBody(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Clause->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fa49a0ba-3c31-4602-8dde-53e179025b05")
    ConditionalNode getOwner();

    /**
     * Setter for relation 'Clause->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("51265012-9419-49f0-b3e9-03afbe90e44d")
    void setOwner(ConditionalNode value);

}
