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
 * BpmnEscalationEventDefinition v0.0.9054
 *
 *
 * Event corresponding to an escalation.
 *
 */
@objid ("008be606-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnEscalationEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("c57101c7-5e90-439c-ad86-23461e4d5af7")
    public static final String MNAME = "BpmnEscalationEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("574cd7af-f8f2-48f9-a11b-c6b5097ba211")
    public static final String MQNAME = "Standard.BpmnEscalationEventDefinition";

    /**
     * Getter for attribute 'BpmnEscalationEventDefinition.EscalationCode'
     *
     * Metamodel description:
     * <i>For an End Event:
     * If the Result is an Escalation, then the escalationCode MUST be supplied (if the processType attribute of the Process is set to executable).
     * This ?throws? the Escalation.
     * For an Intermediate Event within normal flow:
     * If the trigger is an Escalation, then the escalationCode MUST be entered (if the processType attribute of the Process is set to executable).
     * This ?throws? the Escalation.
     * For an Intermediate Event attached to the boundary of an Activity:
     * If the trigger is an Escalation, then the escalationCode MAY be entered.
     * This Event ?catches? the Escalation. If there is no escalationCode, then any Escalation SHALL trigger the Event. If there is an escalationCode, then only an Escalation that matches the escalationCode SHALL trigger the Event.</i>
     */
    @objid ("2c7e1311-2dc2-4d3a-852c-92dfda05a966")
    String getEscalationCode();

    /**
     * Setter for attribute 'BpmnEscalationEventDefinition.EscalationCode'
     *
     * Metamodel description:
     * <i>For an End Event:
     * If the Result is an Escalation, then the escalationCode MUST be supplied (if the processType attribute of the Process is set to executable).
     * This ?throws? the Escalation.
     * For an Intermediate Event within normal flow:
     * If the trigger is an Escalation, then the escalationCode MUST be entered (if the processType attribute of the Process is set to executable).
     * This ?throws? the Escalation.
     * For an Intermediate Event attached to the boundary of an Activity:
     * If the trigger is an Escalation, then the escalationCode MAY be entered.
     * This Event ?catches? the Escalation. If there is no escalationCode, then any Escalation SHALL trigger the Event. If there is an escalationCode, then only an Escalation that matches the escalationCode SHALL trigger the Event.</i>
     */
    @objid ("ac1c9b70-c8f4-4201-b650-0ae78c578243")
    void setEscalationCode(String value);

}
