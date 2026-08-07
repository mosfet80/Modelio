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
 * MessageFlow v0.0.9054
 *
 *
 * A Message Flow is used to show the flow of messages between two entities that are prepared to send and receive them.
 *
 * In BPMN, two separate Pools in the Diagram will represent the two entities.
 *
 */
@objid ("0037db42-c4bf-1fd8-97fe-001ec947cd2a")
public interface MessageFlow extends ActivityEdge {
    /**
     * The metaclass simple name.
     */
    @objid ("3f45a0a7-577e-44c5-acb3-85130a869303")
    public static final String MNAME = "MessageFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("0a87cecf-bd2a-4917-bf7c-6652aa623312")
    public static final String MQNAME = "Standard.MessageFlow";

    /**
     * Getter for relation 'MessageFlow->TargetPartition'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("5aabab93-f436-459b-ad6c-fe957d4f47f3")
    ActivityPartition getTargetPartition();

    /**
     * Setter for relation 'MessageFlow->TargetPartition'
     *
     * Metamodel description:
     * <i></i>
     */
    @objid ("fe8c8700-f4b6-4c03-8e7a-03c7534ccb70")
    void setTargetPartition(ActivityPartition value);

    /**
     * Getter for relation 'MessageFlow->SourcePartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f4c1df2e-acde-4bc9-b442-eb1bb6d695d8")
    ActivityPartition getSourcePartition();

    /**
     * Setter for relation 'MessageFlow->SourcePartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3ecae3be-8c92-4b79-bb39-0f779aa782bb")
    void setSourcePartition(ActivityPartition value);

}
