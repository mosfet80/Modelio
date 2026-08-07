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
 * BpmnStartEvent v0.0.9054
 *
 *
 * <p>the Start Event indicates where a particular Process will start. In terms of Sequence Flow, the Start Event starts the flow of the Process, and thus, will not have any incoming Sequence Flow.</p><p>No Sequence Flow can connect to a Start Event.</p>
 *
 *
 */
@objid ("00924686-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnStartEvent extends BpmnCatchEvent {
    /**
     * The metaclass simple name.
     */
    @objid ("e0082699-d746-4537-a3a6-ea71f4f5e89a")
    public static final String MNAME = "BpmnStartEvent";

    /**
     * The metaclass qualified name.
     */
    @objid ("063e65ae-89db-4256-bf8e-4ce62933c0f9")
    public static final String MQNAME = "Standard.BpmnStartEvent";

    /**
     * Getter for attribute 'BpmnStartEvent.IsInterrupting'
     *
     * Metamodel description:
     * <i><p>This attribute only applies to Start Events of Event Sub-Processes; it is ignored for other Start Events. This attribute denotes whether the Sub-Process encompassing the Event Sub-Process should be cancelled or not, If the encompassing Sub-Process is not cancelled, multiple instances of the Event Sub-Process can run concurrently. This attribute cannot be applied to Error Events (where it?s always true), or Compensation Events (where it doesn?t apply).</p>
     * </i>
     */
    @objid ("07a5bd52-e81e-4307-bd46-29bf91ae3a3f")
    boolean isIsInterrupting();

    /**
     * Setter for attribute 'BpmnStartEvent.IsInterrupting'
     *
     * Metamodel description:
     * <i><p>This attribute only applies to Start Events of Event Sub-Processes; it is ignored for other Start Events. This attribute denotes whether the Sub-Process encompassing the Event Sub-Process should be cancelled or not, If the encompassing Sub-Process is not cancelled, multiple instances of the Event Sub-Process can run concurrently. This attribute cannot be applied to Error Events (where it?s always true), or Compensation Events (where it doesn?t apply).</p>
     * </i>
     */
    @objid ("906c46de-6461-4673-a881-5cf7bc5c0220")
    void setIsInterrupting(boolean value);

}
