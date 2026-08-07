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
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * BpmnBaseElement v0.0.9054
 *
 *
 * BaseElement is the abstract super class for most BPMN elements.
 *
 */
@objid ("0077d2a6-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnBaseElement extends ModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3542422e-e5d2-435f-b5e3-264d3db0f7c8")
    public static final String MNAME = "BpmnBaseElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("01bb25f7-ea34-4f2e-9f4a-ed14577686e5")
    public static final String MQNAME = "Standard.BpmnBaseElement";

    /**
     *
     * @return the first non BPMN element in the upward model composition tree.
     * @since 3.7
     */
    @objid ("d081356e-12cd-4d66-aff2-fab9f0cfcff4")
    MObject getBpmnContext();

    /**
     * Getter for relation 'BpmnBaseElement->OutgoingAssoc'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e4900836-8cd8-4a61-8a44-eb62a8845b62")
    EList<BpmnAssociation> getOutgoingAssoc();

    /**
     * Filtered Getter for relation 'BpmnBaseElement->OutgoingAssoc'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7a575ea4-c97b-49df-ac0a-2ef0b2daac5d")
    <T extends BpmnAssociation> List<T> getOutgoingAssoc(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnBaseElement->IncomingAssoc'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cf24fc19-b90a-4a60-a5a6-e26fd0bcadb9")
    EList<BpmnAssociation> getIncomingAssoc();

    /**
     * Filtered Getter for relation 'BpmnBaseElement->IncomingAssoc'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d34750e0-f3cd-402c-81b6-623547a31d53")
    <T extends BpmnAssociation> List<T> getIncomingAssoc(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnBaseElement->IncomingFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("671d8dba-e17e-475a-a8cb-8f6ed4311d0b")
    EList<BpmnMessageFlow> getIncomingFlow();

    /**
     * Filtered Getter for relation 'BpmnBaseElement->IncomingFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("beb8e96d-e54c-49c1-bde6-e7b80da3aeff")
    <T extends BpmnMessageFlow> List<T> getIncomingFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnBaseElement->OutgoingFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("325b7e3c-b6f6-4f01-9c33-3ea724f6d76d")
    EList<BpmnMessageFlow> getOutgoingFlow();

    /**
     * Filtered Getter for relation 'BpmnBaseElement->OutgoingFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4e40f0ee-af69-4d96-968d-580f6690ec9d")
    <T extends BpmnMessageFlow> List<T> getOutgoingFlow(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnBaseElement->PartitionedLaneRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("61263fd4-eadc-4bec-9737-179b22bd830e")
    EList<BpmnLane> getPartitionedLaneRefs();

    /**
     * Filtered Getter for relation 'BpmnBaseElement->PartitionedLaneRefs'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ecf21979-41b3-4032-8498-a3f4ab08fcbe")
    <T extends BpmnLane> List<T> getPartitionedLaneRefs(java.lang.Class<T> filterClass);

}
