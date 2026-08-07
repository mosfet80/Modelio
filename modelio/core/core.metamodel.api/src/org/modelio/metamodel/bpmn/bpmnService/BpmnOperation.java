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
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnOperation v0.0.9054
 *
 *
 * <p>An Operation defines Messages that are consumed and, optionally, produced when the Operation is called.</p><p>It can&nbsp;also define zero or more errors that are returned when operation fails. The Operation inherits the attributes and model&nbsp;associations of BaseElement.</p>
 *
 *
 */
@objid ("000d4990-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnOperation extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("b749211c-b663-412e-85a9-c81a3417473b")
    public static final String MNAME = "BpmnOperation";

    /**
     * The metaclass qualified name.
     */
    @objid ("9db7fd3e-5351-4680-9569-b51923cd98eb")
    public static final String MQNAME = "Standard.BpmnOperation";

    /**
     * Getter for relation 'BpmnOperation->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f9ca04fb-a4ef-478a-816a-688889978652")
    EList<BpmnSendTask> getSender();

    /**
     * Filtered Getter for relation 'BpmnOperation->Sender'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("18fb9d93-bb28-4baa-a2c7-085db63e7277")
    <T extends BpmnSendTask> List<T> getSender(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnOperation->InMessageRef'
     *
     * Metamodel description:
     * <i>specifies the input Message of the Operation. An Operation has exactly one input Message. </i>
     */
    @objid ("1a66a02f-0a36-4484-b63c-d738dd697180")
    BpmnMessage getInMessageRef();

    /**
     * Setter for relation 'BpmnOperation->InMessageRef'
     *
     * Metamodel description:
     * <i>specifies the input Message of the Operation. An Operation has exactly one input Message. </i>
     */
    @objid ("6b8cafa6-040a-41e0-993e-5915bbedb0ed")
    void setInMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnOperation->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("623e44d7-7039-4719-bb0e-bb3f2edd5f23")
    EList<BpmnServiceTask> getCaller();

    /**
     * Filtered Getter for relation 'BpmnOperation->Caller'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("13b2e090-ab44-48be-ada6-f69856cb6800")
    <T extends BpmnServiceTask> List<T> getCaller(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnOperation->OutMessageRef'
     *
     * Metamodel description:
     * <i>specifies the output Message of the Operation. An Operation has at most one input Message.</i>
     */
    @objid ("dd898d50-18ab-41c8-9868-1e94e25d1dc8")
    BpmnMessage getOutMessageRef();

    /**
     * Setter for relation 'BpmnOperation->OutMessageRef'
     *
     * Metamodel description:
     * <i>specifies the output Message of the Operation. An Operation has at most one input Message.</i>
     */
    @objid ("baacbf17-0520-4cca-b6a3-69a015f10a49")
    void setOutMessageRef(BpmnMessage value);

    /**
     * Getter for relation 'BpmnOperation->EventDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6e2cdc3a-bcf3-4756-9c94-e87c616f4731")
    EList<BpmnMessageEventDefinition> getEventDefinition();

    /**
     * Filtered Getter for relation 'BpmnOperation->EventDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("75097aa1-4d81-4f4f-a5ad-d5ea774968d3")
    <T extends BpmnMessageEventDefinition> List<T> getEventDefinition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnOperation->BpmnInterfaceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("56c81886-9b60-4dce-94bd-f5c36b56c670")
    BpmnInterface getBpmnInterfaceRef();

    /**
     * Setter for relation 'BpmnOperation->BpmnInterfaceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7104d826-a83d-48a6-8622-12e8da10fca1")
    void setBpmnInterfaceRef(BpmnInterface value);

    /**
     * Getter for relation 'BpmnOperation->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("45f21f5b-8150-44a9-bac9-ed1e85f1484f")
    EList<BpmnReceiveTask> getReceiver();

    /**
     * Filtered Getter for relation 'BpmnOperation->Receiver'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2783946e-9978-4736-9071-1f26d980afdd")
    <T extends BpmnReceiveTask> List<T> getReceiver(java.lang.Class<T> filterClass);

}
