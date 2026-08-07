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
package org.modelio.metamodel.bpmn.resources;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;

/**
 * BpmnResourceRole v0.0.9054
 *
 *
 * Resource allocated to a model element. The occurence provides values to resource parameters through resources binding
 *
 */
@objid ("000a8606-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnResourceRole extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("8023377b-1c60-45c5-b0de-e9f3aa1d7d6b")
    public static final String MNAME = "BpmnResourceRole";

    /**
     * The metaclass qualified name.
     */
    @objid ("00536d66-b4cf-426f-af63-b650ff580711")
    public static final String MQNAME = "Standard.BpmnResourceRole";

    /**
     * Getter for relation 'BpmnResourceRole->ResourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2847692e-7ac4-4f1e-b910-4f8f8ba8c716")
    BpmnResource getResourceRef();

    /**
     * Setter for relation 'BpmnResourceRole->ResourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("567cc07c-2e5f-435f-84fd-0ef34970de39")
    void setResourceRef(BpmnResource value);

    /**
     * Getter for relation 'BpmnResourceRole->Annotated'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("54a4dd6a-fdc2-4768-aec3-fdef6f4e7515")
    BpmnFlowNode getAnnotated();

    /**
     * Setter for relation 'BpmnResourceRole->Annotated'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cc126679-bd6d-4281-a289-30645c2ab8fc")
    void setAnnotated(BpmnFlowNode value);

    /**
     * Getter for relation 'BpmnResourceRole->ResourceParameterBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c0303db3-a177-4202-b6d9-66b69cd531ed")
    EList<BpmnResourceParameterBinding> getResourceParameterBinding();

    /**
     * Filtered Getter for relation 'BpmnResourceRole->ResourceParameterBinding'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bfe4f77b-8c69-4418-905c-9fe435d6b40b")
    <T extends BpmnResourceParameterBinding> List<T> getResourceParameterBinding(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnResourceRole->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ca610e0b-6461-4fa1-b07d-3c7ded542cc5")
    BpmnProcess getProcess();

    /**
     * Setter for relation 'BpmnResourceRole->Process'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7603c5b3-ac29-4acd-9906-435ccb13851a")
    void setProcess(BpmnProcess value);

}
