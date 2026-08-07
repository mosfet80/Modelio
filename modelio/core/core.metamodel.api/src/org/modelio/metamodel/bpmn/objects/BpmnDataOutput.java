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
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;

/**
 * BpmnDataOutput v0.0.9054
 *
 *
 * Activities and Processes often required data in order to execute. In addition they may produce data during or as a result of execution. Data that is produced is captured using Data Outputs
 *
 * A DataOutput belong either to a process or to an activity.
 *
 */
@objid ("0005b81a-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataOutput extends BpmnItemAwareElement {
    /**
     * The metaclass simple name.
     */
    @objid ("78946cec-4a11-4448-859a-41ae8753a18b")
    public static final String MNAME = "BpmnDataOutput";

    /**
     * The metaclass qualified name.
     */
    @objid ("412d3118-b094-4978-bf90-de34cc0e33cc")
    public static final String MQNAME = "Standard.BpmnDataOutput";

    /**
     * Getter for attribute 'BpmnDataOutput.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b746a3d7-b3ca-403a-aa80-9905d41475fc")
    boolean isIsCollection();

    /**
     * Setter for attribute 'BpmnDataOutput.IsCollection'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a59e2c24-87c0-463e-afc9-7bdd37dd2619")
    void setIsCollection(boolean value);

    /**
     * Getter for relation 'BpmnDataOutput->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b2179a20-050c-465b-bc84-f3f379d3c6ff")
    BpmnActivity getOwnerActivity();

    /**
     * Setter for relation 'BpmnDataOutput->OwnerActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bc64efd5-385b-472e-a6c4-90bc948b7bf9")
    void setOwnerActivity(BpmnActivity value);

    /**
     * Getter for relation 'BpmnDataOutput->Catched'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5eccd97a-d7a6-440e-b1d7-2734325170c0")
    BpmnCatchEvent getCatched();

    /**
     * Setter for relation 'BpmnDataOutput->Catched'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("35fc5883-f8fe-444a-8ec4-975a10d37c4b")
    void setCatched(BpmnCatchEvent value);

    /**
     * Getter for relation 'BpmnDataOutput->OwnerLoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("04da0bff-9cdd-48e0-a855-916ff93bec0a")
    BpmnMultiInstanceLoopCharacteristics getOwnerLoopCharacteristics();

    /**
     * Setter for relation 'BpmnDataOutput->OwnerLoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d098d1f2-942c-4db7-be56-6cbb3704461c")
    void setOwnerLoopCharacteristics(BpmnMultiInstanceLoopCharacteristics value);

}
