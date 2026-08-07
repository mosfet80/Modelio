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
package org.modelio.metamodel.bpmn.events;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;

/**
 * BpmnCompensateEventDefinition v0.0.9054
 *
 *
 * Compensation Events are used in the context of triggering or handling compensation. There are four (4) variations: a Start Event, both a catch and throw Intermediate Event, and an End Event.
 * - The Compensation Start Event MAY NOT be used for a top-level Process.
 * - The Compensation Start Event MAY be used for an Event Sub-Process.
 * - The catch Compensation Intermediate Event MUST only be attached to the boundary of an Activity and, thus, MAY NOT be used in normal flow.
 * - The throw Compensation Intermediate Event MAY be used in normal flow.
 * - The Compensation End Event MAY be used within any Sub-Process or Process.
 *
 */
@objid ("008944c8-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnCompensateEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("d339182d-a9d9-4c31-86ca-c8f4564fe0c0")
    public static final String MNAME = "BpmnCompensateEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("374a8690-c10a-4aeb-85d4-e538a0f6503f")
    public static final String MQNAME = "Standard.BpmnCompensateEventDefinition";

    /**
     * Getter for attribute 'BpmnCompensateEventDefinition.WaitForCompletion'
     *
     * Metamodel description:
     * <i>The Expression might be underspecified and provided in the form of natural language.
     * For executable Processes (processType = executable), if the trigger is Conditional, then a FormalExpression MUST be entered.</i>
     */
    @objid ("fb5648bf-c5ac-4ede-80f6-91a6013a6493")
    String getWaitForCompletion();

    /**
     * Setter for attribute 'BpmnCompensateEventDefinition.WaitForCompletion'
     *
     * Metamodel description:
     * <i>The Expression might be underspecified and provided in the form of natural language.
     * For executable Processes (processType = executable), if the trigger is Conditional, then a FormalExpression MUST be entered.</i>
     */
    @objid ("bb9b0764-b023-47f9-aecf-7a22d872b0fd")
    void setWaitForCompletion(String value);

    /**
     * Getter for relation 'BpmnCompensateEventDefinition->ActivityRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a6990a38-c5a6-497e-a34d-a586f90ffe20")
    BpmnActivity getActivityRef();

    /**
     * Setter for relation 'BpmnCompensateEventDefinition->ActivityRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b4d18e1f-38cb-4085-be90-1ecfea0691db")
    void setActivityRef(BpmnActivity value);

}
