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
package org.modelio.metamodel.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnLaneSet v0.0.9054
 *
 *
 * The LaneSet element defines the container for one or more Lanes. A Process can contain one or more LaneSets.
 * Each LaneSet and its Lanes can partition the Flow Elements in a different way.
 *
 * Ownership:
 * A LaneSet belongs to a process, or to a Lane.
 *
 */
@objid ("0074fd92-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnLaneSet extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("25881063-9381-494f-af90-e55d9fb80978")
    public static final String MNAME = "BpmnLaneSet";

    /**
     * The metaclass qualified name.
     */
    @objid ("7d3e1a13-7cf4-4e87-bc43-d203a140b409")
    public static final String MQNAME = "Standard.BpmnLaneSet";

    /**
     * Getter for relation 'BpmnLaneSet->Lane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("260120d1-d80c-421d-aa02-aa9b825dcce3")
    EList<BpmnLane> getLane();

    /**
     * Filtered Getter for relation 'BpmnLaneSet->Lane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("767ddcf8-497a-4b0d-99ab-7e8d3e1b7b19")
    <T extends BpmnLane> List<T> getLane(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnLaneSet->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("47c1a5b4-4bd8-4d7e-8b8b-8d3369b6646e")
    BpmnProcess getProcess();

    /**
     * Setter for relation 'BpmnLaneSet->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c2d05ab8-16f8-4d3e-8003-4791e8d0d369")
    void setProcess(BpmnProcess value);

    /**
     * Getter for relation 'BpmnLaneSet->ParentLane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("31d02d01-b5c1-47b4-9508-4b68be8d0662")
    BpmnLane getParentLane();

    /**
     * Setter for relation 'BpmnLaneSet->ParentLane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("279360a2-8689-4265-9af6-fb0db4f112df")
    void setParentLane(BpmnLane value);

    /**
     * Getter for relation 'BpmnLaneSet->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3d1f86d5-9955-4da0-acb1-b467bdc81e56")
    BpmnSubProcess getSubProcess();

    /**
     * Setter for relation 'BpmnLaneSet->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("97b22159-ca7d-45d1-ab9e-46bbac0047cb")
    void setSubProcess(BpmnSubProcess value);

}
