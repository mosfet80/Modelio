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
 * BpmnErrorEventDefinition v0.0.9054
 *
 *
 * Event definition for an error.
 *
 */
@objid ("008b3af8-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnErrorEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("2b2fe0c4-f0d1-4c7f-9d09-904c08b722a2")
    public static final String MNAME = "BpmnErrorEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("afc315c4-38d3-49e9-b23e-1524420643cd")
    public static final String MQNAME = "Standard.BpmnErrorEventDefinition";

    /**
     * Getter for attribute 'BpmnErrorEventDefinition.ErrorCode'
     *
     * Metamodel description:
     * <i>For an End Event:
     * If the result is an Error, then the errorCode MUST be supplied (if the processType attribute of the Process is set to executable) This ?throws? the Error.
     * For an Intermediate Event within normal flow:
     * If the Trigger is an Error, then the errorCode MUST be entered (if the processType attribute of the Process is set to executable). This ?throws? the Error.
     * For an Intermediate Event attached to the boundary of an Activity:
     * If the Trigger is an Error, then the errorCode MAY be entered. This Event ?catches? the Error. If there is no errorCode, then any error SHALL trigger the Event. If there is an errorCode, then only an Error that matches the errorCode SHALL trigger the Event.</i>
     */
    @objid ("cea6b1e9-396e-4bfb-aace-ab1029062ba4")
    String getErrorCode();

    /**
     * Setter for attribute 'BpmnErrorEventDefinition.ErrorCode'
     *
     * Metamodel description:
     * <i>For an End Event:
     * If the result is an Error, then the errorCode MUST be supplied (if the processType attribute of the Process is set to executable) This ?throws? the Error.
     * For an Intermediate Event within normal flow:
     * If the Trigger is an Error, then the errorCode MUST be entered (if the processType attribute of the Process is set to executable). This ?throws? the Error.
     * For an Intermediate Event attached to the boundary of an Activity:
     * If the Trigger is an Error, then the errorCode MAY be entered. This Event ?catches? the Error. If there is no errorCode, then any error SHALL trigger the Event. If there is an errorCode, then only an Error that matches the errorCode SHALL trigger the Event.</i>
     */
    @objid ("927973c2-692f-4c6e-a249-a3aacbf8726e")
    void setErrorCode(String value);

}
