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

/**
 * BpmnConditionalEventDefinition v0.0.9054
 *
 *
 * Event defined by a condition
 *
 */
@objid ("0089eafe-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnConditionalEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("e87776f5-0f96-4247-9124-e46007020972")
    public static final String MNAME = "BpmnConditionalEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("af38e1f6-5e49-47b4-9902-4641bf79221e")
    public static final String MQNAME = "Standard.BpmnConditionalEventDefinition";

    /**
     * Getter for attribute 'BpmnConditionalEventDefinition.Condition'
     *
     * Metamodel description:
     * <i>The Expression might be underspecified and provided in the form of natural language.
     * For executable Processes (processType = executable), if the trigger is Conditional, then a FormalExpression MUST be entered.</i>
     */
    @objid ("7c716318-d745-4182-932c-89c108e162b2")
    String getCondition();

    /**
     * Setter for attribute 'BpmnConditionalEventDefinition.Condition'
     *
     * Metamodel description:
     * <i>The Expression might be underspecified and provided in the form of natural language.
     * For executable Processes (processType = executable), if the trigger is Conditional, then a FormalExpression MUST be entered.</i>
     */
    @objid ("1454e26a-bd93-443a-95cf-b43756310373")
    void setCondition(String value);

}
