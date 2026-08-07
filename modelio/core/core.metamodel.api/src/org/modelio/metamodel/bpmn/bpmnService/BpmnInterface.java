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
package org.modelio.metamodel.bpmn.bpmnService;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;

/**
 * BpmnInterface v0.0.9054
 *
 *
 * <p>An Interface defines a set of operations that are implemented by Services.</p><p>The Interface inherits the attributes and model associations of BaseElement through its relationship&nbsp;to RootElement.--</p>
 *
 *
 */
@objid ("000de92c-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnInterface extends BpmnSharedElement {
    /**
     * The metaclass simple name.
     */
    @objid ("dde5ca61-b6d1-41fc-8708-04a33c2251d1")
    public static final String MNAME = "BpmnInterface";

    /**
     * The metaclass qualified name.
     */
    @objid ("dffaf6cd-9684-43f6-a39e-50bf6696f7ff")
    public static final String MQNAME = "Standard.BpmnInterface";

    /**
     * Getter for relation 'BpmnInterface->Operation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("02afa85c-205b-4a29-8412-bc694f018592")
    EList<BpmnOperation> getOperation();

    /**
     * Filtered Getter for relation 'BpmnInterface->Operation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ccd3284e-f279-48e6-b808-8e4cdba93211")
    <T extends BpmnOperation> List<T> getOperation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnInterface->ParticipantRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d35d5a32-9071-4e8c-b922-217762c5cf4d")
    EList<BpmnParticipant> getParticipantRef();

    /**
     * Filtered Getter for relation 'BpmnInterface->ParticipantRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f062e6d4-06a8-4c11-9882-1db761b80b59")
    <T extends BpmnParticipant> List<T> getParticipantRef(java.lang.Class<T> filterClass);

}
