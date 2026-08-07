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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;

/**
 * BpmnMessageEventDefinition v0.0.9054
 *
 *
 * Specifies the receive or sending of a message.
 *
 */
@objid ("0090c6e4-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnMessageEventDefinition extends BpmnEventDefinition {
    /**
     * The metaclass simple name.
     */
    @objid ("48ad5715-fd4d-40bd-896a-454ad50a67ed")
    public static final String MNAME = "BpmnMessageEventDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("2375f9ef-0403-45d7-bc84-f314e307772a")
    public static final String MQNAME = "Standard.BpmnMessageEventDefinition";

    /**
     * Getter for relation 'BpmnMessageEventDefinition->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("48626fe1-daa1-40e4-bbea-f29d58d824ec")
    BpmnMessage getMessageRef();

    /**
     * Setter for relation 'BpmnMessageEventDefinition->MessageRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7a3caa74-3ad8-4fed-8cf7-4c89b77ac774")
    void setMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnMessageEventDefinition->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2182fe6b-fc7e-48d6-be9b-2e36dedda16d")
    EList<BpmnOperation> getOperationRef();

    /**
     * Filtered Getter for relation 'BpmnMessageEventDefinition->OperationRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d7f4f11d-9942-4285-9428-b0a758a3ac2a")
    <T extends BpmnOperation> List<T> getOperationRef(java.lang.Class<T> filterClass);

}
