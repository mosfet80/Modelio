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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnDataAssociation v0.0.9054
 *
 *
 * <p>Data Associations are used to move data between Data Objects, Properties, and inputs and outputs of Activities, Processes, and GlobalTasks.</p><p>Tokens do not flow along a Data Association, and as a result they have no direct effect on the flow of the Process. The purpose of retrieving data from Data Objects or Process Data Inputs is to fill the Activities inputs and later push the output values from the execution of the Activity back into Data Objects or Process Data Outputs.</p><p>The DataAssociation class is a BaseElement contained by an Activity or Event, used to model how data is pushed into or pulled from item-aware elements.</p><p>DataAssociation elements may have one or more sources and a target; the source of the association is copied into the target.</p>
 *
 *
 */
@objid ("00047c84-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnDataAssociation extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f0d8ab57-d622-4411-bda4-7f0daf2c945c")
    public static final String MNAME = "BpmnDataAssociation";

    /**
     * The metaclass qualified name.
     */
    @objid ("29a3dac3-2897-4560-8bf7-09a257be124f")
    public static final String MQNAME = "Standard.BpmnDataAssociation";

    /**
     * Getter for attribute 'BpmnDataAssociation.Assignment'
     *
     * Metamodel description:
     * <i>Specifies one or more data elements Assignments. By using an Assignment, single data structure elements can be assigned from the source structure to the target structure.</i>
     */
    @objid ("9536664a-d54d-454f-b16d-ed8ad489aa0d")
    String getAssignment();

    /**
     * Setter for attribute 'BpmnDataAssociation.Assignment'
     *
     * Metamodel description:
     * <i>Specifies one or more data elements Assignments. By using an Assignment, single data structure elements can be assigned from the source structure to the target structure.</i>
     */
    @objid ("1f67d31d-b0e9-4077-bd61-663422714ce3")
    void setAssignment(String value);

    /**
     * Getter for attribute 'BpmnDataAssociation.Transfomation'
     *
     * Metamodel description:
     * <i>Specifies an optional transformation Expression. The actual scope of visible data for that Expression is defined by the source and target of the specific data association types.</i>
     */
    @objid ("11186d49-5c15-4226-a224-d3857ad99bfb")
    String getTransfomation();

    /**
     * Setter for attribute 'BpmnDataAssociation.Transfomation'
     *
     * Metamodel description:
     * <i>Specifies an optional transformation Expression. The actual scope of visible data for that Expression is defined by the source and target of the specific data association types.</i>
     */
    @objid ("ab2ec365-e73b-4b60-b05a-59b2bc739724")
    void setTransfomation(String value);

    /**
     * Getter for attribute 'BpmnDataAssociation.Language'
     *
     * Metamodel description:
     * <i>Language used for the assignment expression.</i>
     */
    @objid ("f20db04c-269e-4d53-9897-4d5b1a2f2db4")
    String getLanguage();

    /**
     * Setter for attribute 'BpmnDataAssociation.Language'
     *
     * Metamodel description:
     * <i>Language used for the assignment expression.</i>
     */
    @objid ("599045c1-0040-4eeb-9189-4cf4c373e9c7")
    void setLanguage(String value);

    /**
     * Getter for relation 'BpmnDataAssociation->SourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bbf7a498-4c04-47e8-b8d3-1aa74dffa488")
    EList<BpmnItemAwareElement> getSourceRef();

    /**
     * Filtered Getter for relation 'BpmnDataAssociation->SourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0e58ba80-b1f0-4320-9bf4-05cdad414f59")
    <T extends BpmnItemAwareElement> List<T> getSourceRef(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnDataAssociation->TargetRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f9b1bae0-ffb7-4974-a58f-59e7253405ee")
    BpmnItemAwareElement getTargetRef();

    /**
     * Setter for relation 'BpmnDataAssociation->TargetRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3fdb694a-b379-4fcd-acc1-9ae39efcbf1d")
    void setTargetRef(BpmnItemAwareElement value);

    /**
     * Getter for relation 'BpmnDataAssociation->EndingActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("47167670-d23e-4e26-a74e-67856c292137")
    BpmnActivity getEndingActivity();

    /**
     * Setter for relation 'BpmnDataAssociation->EndingActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1b225217-1e8f-492f-99bd-77ff3a2f8c70")
    void setEndingActivity(BpmnActivity value);

    /**
     * Getter for relation 'BpmnDataAssociation->StartingActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0549b166-f371-4c86-816f-160104a1221f")
    BpmnActivity getStartingActivity();

    /**
     * Setter for relation 'BpmnDataAssociation->StartingActivity'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e19d7eb9-f08a-42b0-801b-9f9cb6063757")
    void setStartingActivity(BpmnActivity value);

    /**
     * Getter for relation 'BpmnDataAssociation->StartingEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8e4bc368-31bb-4300-b1c4-efc1c0680f84")
    BpmnThrowEvent getStartingEvent();

    /**
     * Setter for relation 'BpmnDataAssociation->StartingEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ad012742-7da0-453f-9dec-0f336c6e5c31")
    void setStartingEvent(BpmnThrowEvent value);

    /**
     * Getter for relation 'BpmnDataAssociation->VisualShortCut'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("38e179f4-4e93-4f8d-b373-e5133698bc51")
    EList<BpmnSequenceFlowDataAssociation> getVisualShortCut();

    /**
     * Filtered Getter for relation 'BpmnDataAssociation->VisualShortCut'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c27dd199-62dc-4cd5-a068-6aa07d7dc86d")
    <T extends BpmnSequenceFlowDataAssociation> List<T> getVisualShortCut(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnDataAssociation->EndingEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("43b2dd90-54d1-4f36-902e-3f477acd6adc")
    BpmnCatchEvent getEndingEvent();

    /**
     * Setter for relation 'BpmnDataAssociation->EndingEvent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2745c78b-1100-4143-b55c-4201bc231432")
    void setEndingEvent(BpmnCatchEvent value);

}
