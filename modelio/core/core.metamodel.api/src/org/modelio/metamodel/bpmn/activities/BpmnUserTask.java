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
package org.modelio.metamodel.bpmn.activities;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnUserTask v0.0.9054
 *
 *
 * A User Task is a typical "workflow" Task where a human performer performs the Task with the assistance of a software application and is scheduled through a task list manager of some sort.
 * A User Task is executed by and managed by a business process runtime. Attributes concerning the human involvement,like people assignments and UI rendering can be specified in great detail.
 *
 */
@objid ("0086182a-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnUserTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("ed7ee750-638e-44b9-a8f7-b69f17e2b7b4")
    public static final String MNAME = "BpmnUserTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("26b3c9d2-5220-453b-a2be-1d86265ab153")
    public static final String MQNAME = "Standard.BpmnUserTask";

    /**
     * Getter for attribute 'BpmnUserTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages. A Web service is the default technology.</i>
     */
    @objid ("698aa989-f820-4672-b975-9c822f636de7")
    String getImplementation();

    /**
     * Setter for attribute 'BpmnUserTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages. A Web service is the default technology.</i>
     */
    @objid ("dea58245-e0da-4eb6-8d97-e753d0ad9be5")
    void setImplementation(String value);

}
