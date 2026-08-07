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
package org.modelio.metamodel.bpmn.rootElements;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;

/**
 * BpmnFlowElement v0.0.9054
 *
 *
 * FlowElement is the abstract super class for all elements that can appear in a Process flow, which are FlowNodes - which consist of Activities, Choreography Activities  Gateways, and Events - Data Objects, Data Associations, and Sequence Flow.
 *
 * Ownership:
 * A FlowElement belongs to an Element Container or a SubProcess
 *
 */
@objid ("00792098-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnFlowElement extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f04e37cb-8ec8-4f83-bc5f-ca0d15a33514")
    public static final String MNAME = "BpmnFlowElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("012bc2b8-34fa-4de7-bd3e-02a6588cd2a8")
    public static final String MQNAME = "Standard.BpmnFlowElement";

    /**
     * Getter for attribute 'BpmnFlowElement.TriggeredByEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0bf34873-b2a4-4038-a6e5-8c258a3e1bb7")
    boolean isTriggeredByEvent();

    /**
     * Setter for attribute 'BpmnFlowElement.TriggeredByEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e4450da9-baa0-4418-9865-b9c0ef5f7031")
    void setTriggeredByEvent(boolean value);

    /**
     * Getter for relation 'BpmnFlowElement->Groups'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3db20725-7c44-4fe6-9fc3-618dd32bef11")
    EList<BpmnGroup> getGroups();

    /**
     * Filtered Getter for relation 'BpmnFlowElement->Groups'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("27c57fd8-4443-41e1-ab4c-23582c8f8700")
    <T extends BpmnGroup> List<T> getGroups(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnFlowElement->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b9826e5f-4fdd-4058-b7bd-b2ca2a62355d")
    BpmnSubProcess getSubProcess();

    /**
     * Setter for relation 'BpmnFlowElement->SubProcess'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("df45156d-62c6-4aa1-8088-1f1e866f3cb9")
    void setSubProcess(BpmnSubProcess value);

    /**
     * Getter for relation 'BpmnFlowElement->Lane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dc18af9e-b057-4bc8-b465-599da5fb6f0c")
    EList<BpmnLane> getLane();

    /**
     * Filtered Getter for relation 'BpmnFlowElement->Lane'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1540d587-770b-4113-b3f1-3d860d605d1e")
    <T extends BpmnLane> List<T> getLane(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnFlowElement->Container'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("82fb1924-6e2d-47c5-a475-c07af4d05be2")
    BpmnProcess getContainer();

    /**
     * Setter for relation 'BpmnFlowElement->Container'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("df72482e-f3cf-4ab3-9d54-63bfb722dfc1")
    void setContainer(BpmnProcess value);

}
