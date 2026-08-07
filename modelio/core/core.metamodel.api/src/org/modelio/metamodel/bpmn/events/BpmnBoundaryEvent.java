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
 * BpmnBoundaryEvent v0.0.9054
 *
 *
 * Event attached to the boundary of an activity.
 *
 */
@objid ("00875c94-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnBoundaryEvent extends BpmnCatchEvent {
    /**
     * The metaclass simple name.
     */
    @objid ("1b8ae8f6-9479-4247-a5d3-93bf6bdf191f")
    public static final String MNAME = "BpmnBoundaryEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("bf66fb21-1510-4fc4-bd18-b1060f81d139")
    public static final String MQNAME = "Standard.BpmnBoundaryEvent";

    /**
     * Getter for attribute 'BpmnBoundaryEvent.CancelActivity'
     *
     * Metamodel description:
     * <i>Denotes whether the Activity should be cancelled or not, i.e., whether the boundary catch Event acts as an Error or an Escalation. If the Activity is not cancelled, multiple instances of that handler can run concurrently.
     * This attribute cannot be applied to Error Events (where it?s always true), or Compensation Events (where it doesn?t apply).</i>
     */
    @objid ("8f8d5d25-045a-4160-991e-b1cfc0777395")
    boolean isCancelActivity();

    /**
     * Setter for attribute 'BpmnBoundaryEvent.CancelActivity'
     *
     * Metamodel description:
     * <i>Denotes whether the Activity should be cancelled or not, i.e., whether the boundary catch Event acts as an Error or an Escalation. If the Activity is not cancelled, multiple instances of that handler can run concurrently.
     * This attribute cannot be applied to Error Events (where it?s always true), or Compensation Events (where it doesn?t apply).</i>
     */
    @objid ("cc9e0806-fd91-473b-b902-7cb665f4c2c2")
    void setCancelActivity(boolean value);

    /**
     * Getter for relation 'BpmnBoundaryEvent->AttachedToRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dbfb6309-1819-4993-bdc2-ecf703e86f31")
    BpmnActivity getAttachedToRef();

    /**
     * Setter for relation 'BpmnBoundaryEvent->AttachedToRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4e52154d-305a-4c69-873b-d650e91c8663")
    void setAttachedToRef(BpmnActivity value);

}
