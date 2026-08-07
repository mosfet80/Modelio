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
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;

/**
 * BpmnServiceTask v0.0.9054
 *
 *
 * A Service Task is a Task that uses some sort of service, which could be a Web service or an automated application.
 * A Service Task object shares the same shape as the Task, which is a rectangle that has rounded corners. However, there is a graphical marker in the upper left corner of the shape that indicates that the Task is a Service Task
 *
 */
@objid ("008313be-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnServiceTask extends BpmnTask {
    /**
     * The metaclass simple name.
     */
    @objid ("93286a9d-1543-4ff0-b9da-0172579937a0")
    public static final String MNAME = "BpmnServiceTask";

    /**
     * The metaclass qualified name.
     */
    @objid ("7ca2b99b-848c-46ea-bba5-930b8caf2bac")
    public static final String MQNAME = "Standard.BpmnServiceTask";

    /**
     * Getter for attribute 'BpmnServiceTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("870879d0-35e1-4b59-ba98-8d02865c1bfe")
    String getImplementation();

    /**
     * Setter for attribute 'BpmnServiceTask.Implementation'
     *
     * Metamodel description:
     * <i>This attribute specifies the technology that will be used to send and receive the Messages.
     *
     * Valid values are "##unspecified" for leaving the implementation technology open, "##WebService" for the Web service technology or a URI identifying any other technology or coordination protocol.
     *
     * A Web service is the default technology.</i>
     */
    @objid ("ffba01a3-676b-4247-b098-ad9793e0a8ea")
    void setImplementation(String value);

    /**
     * Getter for relation 'BpmnServiceTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("06784477-4a86-4095-b5c2-1f957af9faee")
    BpmnOperation getOperationRef();

    /**
     * Setter for relation 'BpmnServiceTask->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6ea2ad7d-84f2-42ac-8eff-43dd8d58df80")
    void setOperationRef(BpmnOperation value);

}
