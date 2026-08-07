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
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;

/**
 * BpmnFlowNode v0.0.9054
 *
 *
 * FlowNodes represent nodes interconnected using sequence flows or message flows.
 *
 * Ownership
 * FlowNodes belong to a FlowElementContainer or a sub process
 *
 *
 *
 */
@objid ("0079b594-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnFlowNode extends BpmnFlowElement {
    /**
     * The metaclass simple name.
     */
    @objid ("6f36181d-ba41-47a1-9f96-cf897ebba0a0")
    public static final String MNAME = "BpmnFlowNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("438c4333-11af-4e99-9f09-51b59bb14558")
    public static final String MQNAME = "Standard.BpmnFlowNode";

    /**
     * Getter for relation 'BpmnFlowNode->Outgoing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a4c48f02-2b83-4c45-b411-bdaaba65826e")
    EList<BpmnSequenceFlow> getOutgoing();

    /**
     * Filtered Getter for relation 'BpmnFlowNode->Outgoing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2d9b604c-3ff0-4554-aa36-fef4291754d4")
    <T extends BpmnSequenceFlow> List<T> getOutgoing(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnFlowNode->Resource'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0ea985ba-bf1f-41df-a122-6e14f1299bf9")
    EList<BpmnResourceRole> getResource();

    /**
     * Filtered Getter for relation 'BpmnFlowNode->Resource'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8d0b1b22-9c95-43f4-a13e-6f02e8514ea8")
    <T extends BpmnResourceRole> List<T> getResource(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnFlowNode->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("444bfbb5-6402-42ee-8209-8d2f26914652")
    EList<BpmnSequenceFlow> getIncoming();

    /**
     * Filtered Getter for relation 'BpmnFlowNode->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("18b8e75c-5260-47de-bbc1-5c2a7709fa32")
    <T extends BpmnSequenceFlow> List<T> getIncoming(java.lang.Class<T> filterClass);

}
