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
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;

/**
 * BpmnLane v0.0.9054
 *
 *
 * A Lane element defines one specific partition in a LaneSet. The Lane can define a partition element which specifies the value and element type, a tool can use to determine the list of Flow Elements to be partitioned into this Lane.
 *
 * Ownership:
 * A Lane belongs to a LaneSet
 *
 */
@objid ("00746c56-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnLane extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3fdd24cf-02ef-489d-b827-acb2344c8b4e")
    public static final String MNAME = "BpmnLane";

    /**
     * The metaclass qualified name.
     */
    @objid ("69681257-bbe3-40bd-9243-4dfff39b57c5")
    public static final String MQNAME = "Standard.BpmnLane";

    /**
     * Getter for relation 'BpmnLane->ChildLaneSet'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fe276e1b-52cf-4175-9883-dc768d1f05a7")
    BpmnLaneSet getChildLaneSet();

    /**
     * Setter for relation 'BpmnLane->ChildLaneSet'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d8deb500-8404-4938-891f-55cb8bfaf10c")
    void setChildLaneSet(BpmnLaneSet value);

    /**
     * Getter for relation 'BpmnLane->FlowElementRef'
     *
     * Metamodel description:
     * <i><p>The list of FlowNodes partitioned into this Lane according to the&nbsp;partitionElement defined as part of the Lane element.</p>
     * </i>
     */
    @objid ("d7c77e6b-3d2d-4b24-b323-41f6c0d846bf")
    EList<BpmnFlowElement> getFlowElementRef();

    /**
     * Filtered Getter for relation 'BpmnLane->FlowElementRef'
     *
     * Metamodel description:
     * <i><p>The list of FlowNodes partitioned into this Lane according to the&nbsp;partitionElement defined as part of the Lane element.</p>
     * </i>
     */
    @objid ("ead79455-8127-4f9c-9269-fb392a89a7d5")
    <T extends BpmnFlowElement> List<T> getFlowElementRef(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnLane->LaneSet'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d1422ba6-c1ad-42f8-a725-bb3b68626a08")
    BpmnLaneSet getLaneSet();

    /**
     * Setter for relation 'BpmnLane->LaneSet'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0eaa89fc-dd2c-486c-9424-a802ae3c2ac5")
    void setLaneSet(BpmnLaneSet value);

    /**
     * Getter for relation 'BpmnLane->BpmnPartitionElementRef'
     *
     * Metamodel description:
     * <i><p>A reference to a BaseElement that specifies the partition value and partition&nbsp;type. Using this partition element a BPMN compliant tool can determine the&nbsp;FlowElements that have to be partitioned in this Lane.</p>
     * </i>
     */
    @objid ("4c98cfc3-7413-4e41-ade3-9316aa0e705e")
    BpmnBaseElement getBpmnPartitionElementRef();

    /**
     * Setter for relation 'BpmnLane->BpmnPartitionElementRef'
     *
     * Metamodel description:
     * <i><p>A reference to a BaseElement that specifies the partition value and partition&nbsp;type. Using this partition element a BPMN compliant tool can determine the&nbsp;FlowElements that have to be partitioned in this Lane.</p>
     * </i>
     */
    @objid ("2b6a92da-1c34-4f2a-b83d-0470c610323f")
    void setBpmnPartitionElementRef(BpmnBaseElement value);

}
