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

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * LoopNode v0.0.9054
 *
 *
 * First the setup section of the loop node is executed.
 *
 * When the setup section has completed execution (if the test comes first) or when the body section has completed execution of an iteration, the test section is executed.
 *
 * When the test section has completed execution, the Boolean value on the designated test expression is examined. If the value is true, the body section is executed again. If the value is false, execution of the loop node is complete.
 *
 * Modelio specific :
 * In order to make the Setup and Test sections easier to fill, these are string expressions in Modelio, instead of a set of activity nodes in the OMG UML specification.
 *
 *
 */
@objid ("00372b20-c4bf-1fd8-97fe-001ec947cd2a")
public interface LoopNode extends StructuredActivityNode {
    /**
     * The metaclass simple name.
     */
    @objid ("14444072-e382-44d3-a1dd-e7259c57abc9")
    public static final String MNAME = "LoopNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("3ebc264f-7260-42eb-bca9-765f36528e0a")
    public static final String MQNAME = "Standard.LoopNode";

    /**
     * Getter for attribute 'LoopNode.IsTestedFirst'
     *
     * Metamodel description:
     * <i>If true, the test is performed before the first execution of the body. If false, the body is executed once before the test is performed. The default value is false. </i>
     */
    @objid ("97a6c3a0-acb5-4da8-b679-7b290951adec")
    boolean isIsTestedFirst();

    /**
     * Setter for attribute 'LoopNode.IsTestedFirst'
     *
     * Metamodel description:
     * <i>If true, the test is performed before the first execution of the body. If false, the body is executed once before the test is performed. The default value is false. </i>
     */
    @objid ("f210f3fb-ba03-40a4-9d5b-7d5cafa9096f")
    void setIsTestedFirst(boolean value);

    /**
     * Getter for attribute 'LoopNode.Setup'
     *
     * Metamodel description:
     * <i>Section that initialize values or perform other setup computations for the loop.</i>
     */
    @objid ("540bea5f-7ebb-42f0-aac0-023dd04b46e3")
    String getSetup();

    /**
     * Setter for attribute 'LoopNode.Setup'
     *
     * Metamodel description:
     * <i>Section that initialize values or perform other setup computations for the loop.</i>
     */
    @objid ("af42aa7f-670f-47b7-92cf-dc030cce5f30")
    void setSetup(String value);

    /**
     * Getter for attribute 'LoopNode.Test'
     *
     * Metamodel description:
     * <i>Expression that computes a Boolean value to determine if another execution of the body will be performed.</i>
     */
    @objid ("2f84d258-ce50-4391-be4a-1dfd07914808")
    String getTest();

    /**
     * Setter for attribute 'LoopNode.Test'
     *
     * Metamodel description:
     * <i>Expression that computes a Boolean value to determine if another execution of the body will be performed.</i>
     */
    @objid ("835ac924-1230-4708-9fb5-28050fb80a55")
    void setTest(String value);

}
