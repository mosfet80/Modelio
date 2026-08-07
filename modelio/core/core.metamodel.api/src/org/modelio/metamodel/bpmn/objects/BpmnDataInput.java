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
package org.modelio.metamodel.bpmn.objects;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;

/**
 * BpmnDataInput v0.0.9054
 *
 *
 * Activities and Processes often required data in order to execute. In addition they may produce data during or as a result of execution. Data requirements are captured as Data Inputs
 * DataInput elements may appear in a Process diagram to show the inputs to
 * the Process as whole, which are passed along as the inputs of Activities by DataAssociations.
 *
 * Ownership:
 * A DtaInput is owned by a process, or by an activity.
 *
 */
@objid ("00065874-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataInput extends BpmnItemAwareElement {
    /**
     * The metaclass simple name.
     */
    @objid ("22ee9a11-5cff-4c85-bcd2-b7443ad99771")
    public static final String MNAME = "BpmnDataInput";

    /**
     * The metaclass qualified name.
     */
    @objid ("4d923d2d-d602-4c83-ad96-40bbc65f8758")
    public static final String MQNAME = "Standard.BpmnDataInput";

    /**
     * Getter for attribute 'BpmnDataInput.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c29cb54a-db0d-4afd-b70c-eda43af0b510")
    boolean isIsCollection();

    /**
     * Setter for attribute 'BpmnDataInput.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ff83ba97-6a6f-4286-9c4a-e733459ad610")
    void setIsCollection(boolean value);

    /**
     * Getter for relation 'BpmnDataInput->OwnerLoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a944b254-5edb-472d-b139-b827c21e73c0")
    BpmnMultiInstanceLoopCharacteristics getOwnerLoopCharacteristics();

    /**
     * Setter for relation 'BpmnDataInput->OwnerLoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("34c49659-0299-4536-9aeb-05afa060fb55")
    void setOwnerLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics value);

    /**
     * Getter for relation 'BpmnDataInput->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b30fecb4-dca8-4682-a7e3-82387d63d3b5")
    BpmnActivity getOwnerActivity();

    /**
     * Setter for relation 'BpmnDataInput->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9cfd129b-edd2-4cbd-8982-e94aa3fd6915")
    void setOwnerActivity(BpmnActivity value);

    /**
     * Getter for relation 'BpmnDataInput->OwnerThrowEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("fc8598f4-9039-4d83-9ce6-b7d89d711db1")
    BpmnThrowEvent getOwnerThrowEvent();

    /**
     * Setter for relation 'BpmnDataInput->OwnerThrowEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5c547482-33c2-4fe8-a2a5-4cc95d723185")
    void setOwnerThrowEvent(BpmnThrowEvent value);

}
