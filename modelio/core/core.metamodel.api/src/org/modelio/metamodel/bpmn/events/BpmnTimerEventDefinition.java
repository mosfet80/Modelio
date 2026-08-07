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
 * BpmnTimerEventDefinition v0.0.9054
 *
 *
 * Event corresponding to a timer event, such as the end of a duration
 *
 */
@objid ("00965cf8-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnTimerEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("cac1db73-8d82-4791-8633-cfd1840047ba")
    public static final String MNAME = "BpmnTimerEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("d672ff95-9094-486f-8701-1b489f509f9b")
    public static final String MQNAME = "Standard.BpmnTimerEventDefinition";

    /**
     * Getter for attribute 'BpmnTimerEventDefinition.TimeCycle'
     *
     * Metamodel description:
     * <i>If the trigger is a Timer, then a timeCycle MAY be entered. If a timeCycle is not entered, then a timeDate MUST be entered (see attribute above?if the processType attribute of the Process is set to executable).</i>
     */
    @objid ("287fe285-4c02-417e-86fe-684211f8bba6")
    String getTimeCycle();

    /**
     * Setter for attribute 'BpmnTimerEventDefinition.TimeCycle'
     *
     * Metamodel description:
     * <i>If the trigger is a Timer, then a timeCycle MAY be entered. If a timeCycle is not entered, then a timeDate MUST be entered (see attribute above?if the processType attribute of the Process is set to executable).</i>
     */
    @objid ("4cd7cb4f-7d05-45e8-afa2-3bdda2a26fce")
    void setTimeCycle(String value);

    /**
     * Getter for attribute 'BpmnTimerEventDefinition.TimeDate'
     *
     * Metamodel description:
     * <i>If the trigger is a Timer, then a timeDate MAY be entered. If a timeDate is not entered, then a timeCycle MUST be entered (see attribute below?if the processType attribute of the Process is set to executable).</i>
     */
    @objid ("30ee8954-d01e-4655-ac20-311f2552d603")
    String getTimeDate();

    /**
     * Setter for attribute 'BpmnTimerEventDefinition.TimeDate'
     *
     * Metamodel description:
     * <i>If the trigger is a Timer, then a timeDate MAY be entered. If a timeDate is not entered, then a timeCycle MUST be entered (see attribute below?if the processType attribute of the Process is set to executable).</i>
     */
    @objid ("1a21b272-1d3c-471c-b435-8b2a3c154c2d")
    void setTimeDate(String value);

    /**
     * Getter for attribute 'BpmnTimerEventDefinition.TimeDuration'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("e04de125-9959-4590-b3e8-bf9ca49781e8")
    String getTimeDuration();

    /**
     * Setter for attribute 'BpmnTimerEventDefinition.TimeDuration'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("2ec32577-88a1-4f4d-b9c1-d066130735a6")
    void setTimeDuration(String value);

}
