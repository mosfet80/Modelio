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

/**
 * ConditionalNode v0.0.9054
 *
 *
 * A conditional node consists of one or more clauses. Each clause consists of a test section and a body section. When the conditional node begins execution, the test sections of the clauses are executed. If one or more test sections yield a true value, one of the corresponding body sections will be executed. If more than one test section yields a true value, only one body section will be executed. If no test section yields a true value, then no body section is executed; this may be a semantic error if output values are expected from the conditional node.
 *
 * An "else" clause is a clause that is a successor to all other clauses in the conditional and whose test part always returns true.
 *
 */
@objid ("002d52f8-c4bf-1fd8-97fe-001ec947cd2a")
public interface ConditionalNode extends StructuredActivityNode {
    /**
     * The metaclass simple name.
     */
    @objid ("edddbe75-e7fb-45d8-a04d-564e96aae48e")
    public static final String MNAME = "ConditionalNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("7604c710-7675-4d4d-86ce-e4ec99f761d7")
    public static final String MQNAME = "Standard.ConditionalNode";

    /**
     * Getter for attribute 'ConditionalNode.IsDeterminate'
     *
     * Metamodel description:
     * <i>If true, the modeler asserts that at most one test will succeed. The default value is false. </i>
     */
    @objid ("1d3a0797-e2d7-40bc-ad08-0a715b5515cf")
    boolean isIsDeterminate();

    /**
     * Setter for attribute 'ConditionalNode.IsDeterminate'
     *
     * Metamodel description:
     * <i>If true, the modeler asserts that at most one test will succeed. The default value is false. </i>
     */
    @objid ("3546f279-7e7f-431d-a19e-4b976e4a83a0")
    void setIsDeterminate(boolean value);

    /**
     * Getter for attribute 'ConditionalNode.IsAssured'
     *
     * Metamodel description:
     * <i>If true, the modeler asserts that at least one test will succeed. The default value is false.</i>
     */
    @objid ("55c158dd-7b1d-4cbb-b8ea-84180f153e92")
    boolean isIsAssured();

    /**
     * Setter for attribute 'ConditionalNode.IsAssured'
     *
     * Metamodel description:
     * <i>If true, the modeler asserts that at least one test will succeed. The default value is false.</i>
     */
    @objid ("5e94d890-24bc-49e2-91b0-c3f84ff258fe")
    void setIsAssured(boolean value);

    /**
     * Getter for relation 'ConditionalNode->OwnedClause'
     *
     * Metamodel description:
     * <i>Set of clauses composing the conditional.</i>
     */
    @objid ("9728db1a-55cd-464e-aec1-56df5b401346")
    EList<Clause> getOwnedClause();

    /**
     * Filtered Getter for relation 'ConditionalNode->OwnedClause'
     *
     * Metamodel description:
     * <i>Set of clauses composing the conditional.</i>
     */
    @objid ("c1250050-539f-4b4e-bfe0-3dedce236222")
    <T extends Clause> List<T> getOwnedClause(java.lang.Class<T> filterClass);

}
