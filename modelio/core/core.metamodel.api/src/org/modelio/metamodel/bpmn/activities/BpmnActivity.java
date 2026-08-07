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
package org.modelio.metamodel.bpmn.activities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.events.BpmnBoundaryEvent;
import org.modelio.metamodel.bpmn.events.BpmnCompensateEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;

/**
 * BpmnActivity v0.0.9054
 *
 *
 * An Activity is work that is performed within a Business Process. An Activity can be atomic or non-atomic (compound). The types of Activities that are a part of a Process are: Task, Sub-Process, and Call Activity, which allows the inclusion of re-usable Tasks and Processes in the diagram.
 *
 * Ownership
 * An activity belongs to a GlowElementContainer or to a sub process.
 *
 */
@objid ("007d712a-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnActivity extends BpmnFlowNode {
    /**
     * The metaclass simple name.
     */
    @objid ("093ce073-0d1c-4b11-9017-72de3c419d37")
    public static final String MNAME = "BpmnActivity";

    /**
     * The metaclass qualified name.
     */
    @objid ("a0e2fc8f-97e1-4cb1-baa5-288d86724b3b")
    public static final String MQNAME = "Standard.BpmnActivity";

    /**
     * Getter for attribute 'BpmnActivity.IsForCompensation'
     *
     * Metamodel description:
     * <i>A flag that identifies whether this Activity is intended for the purposes of compensation.
     * If false, then this Activity executes as a result of normal execution flow.
     * If true, this Activity is only activated when a Compensation Event is detected and initiated under Compensation Event visibility scope</i>
     */
    @objid ("833b5722-8b6d-46df-8ca5-c51347657a52")
    boolean isIsForCompensation();

    /**
     * Setter for attribute 'BpmnActivity.IsForCompensation'
     *
     * Metamodel description:
     * <i>A flag that identifies whether this Activity is intended for the purposes of compensation.
     * If false, then this Activity executes as a result of normal execution flow.
     * If true, this Activity is only activated when a Compensation Event is detected and initiated under Compensation Event visibility scope</i>
     */
    @objid ("18cb675b-4e70-4319-84dc-3ed433a3031b")
    void setIsForCompensation(boolean value);

    /**
     * Getter for attribute 'BpmnActivity.StartQuantity'
     *
     * Metamodel description:
     * <i>The default value is 1. The value MUST NOT be less than 1. This attribute defines the number of tokens that must arrive before the Activity can begin. Note that any value for the attribute that is greater than 1 is an advanced type of modeling and should be used with caution.</i>
     */
    @objid ("53e66514-f878-41ac-9348-12d2c413c127")
    int getStartQuantity();

    /**
     * Setter for attribute 'BpmnActivity.StartQuantity'
     *
     * Metamodel description:
     * <i>The default value is 1. The value MUST NOT be less than 1. This attribute defines the number of tokens that must arrive before the Activity can begin. Note that any value for the attribute that is greater than 1 is an advanced type of modeling and should be used with caution.</i>
     */
    @objid ("f09ebd96-e967-4682-bdaa-bf88e46aa832")
    void setStartQuantity(int value);

    /**
     * Getter for attribute 'BpmnActivity.CompletionQuantity'
     *
     * Metamodel description:
     * <i>The default value is 1. The value MUST NOT be less than 1. This attribute defines the number of tokens that must be generated from the Activity. This number of tokens will be sent done any outgoing Sequence Flow (assuming any Sequence Flow conditions are satisfied).
     * Note that any value for the attribute that is greater than 1 is an advanced type of modeling and should be used with caution.</i>
     */
    @objid ("14bc9f1a-723a-4419-a180-736bcb79a7b3")
    int getCompletionQuantity();

    /**
     * Setter for attribute 'BpmnActivity.CompletionQuantity'
     *
     * Metamodel description:
     * <i>The default value is 1. The value MUST NOT be less than 1. This attribute defines the number of tokens that must be generated from the Activity. This number of tokens will be sent done any outgoing Sequence Flow (assuming any Sequence Flow conditions are satisfied).
     * Note that any value for the attribute that is greater than 1 is an advanced type of modeling and should be used with caution.</i>
     */
    @objid ("8f071def-4fa4-4f96-a4bb-1f119897d15c")
    void setCompletionQuantity(int value);

    /**
     * Getter for relation 'BpmnActivity->CompensateEventDefinitions'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("75a026aa-f800-486f-9594-6b7eadd6642f")
    EList<BpmnCompensateEventDefinition> getCompensateEventDefinitions();

    /**
     * Filtered Getter for relation 'BpmnActivity->CompensateEventDefinitions'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("21506c36-63f3-4067-a652-f6de572fa57a")
    <T extends BpmnCompensateEventDefinition> List<T> getCompensateEventDefinitions(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->InputSpecification'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("98ed5c10-ceab-4b8f-baff-ea30811c9442")
    EList<BpmnDataInput> getInputSpecification();

    /**
     * Filtered Getter for relation 'BpmnActivity->InputSpecification'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("95d4be42-3491-4eed-b421-d9794da23a0f")
    <T extends BpmnDataInput> List<T> getInputSpecification(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->DataInputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("67dfb795-1a54-4f21-b6e1-e28f10f4fe53")
    EList<BpmnDataAssociation> getDataInputAssociation();

    /**
     * Filtered Getter for relation 'BpmnActivity->DataInputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2ef39bf9-c2db-41a9-92c6-1d1730307890")
    <T extends BpmnDataAssociation> List<T> getDataInputAssociation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->OutputSpecification'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0fff7fff-405a-4415-b9e4-9766454b51f3")
    EList<BpmnDataOutput> getOutputSpecification();

    /**
     * Filtered Getter for relation 'BpmnActivity->OutputSpecification'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5de7bc93-673b-4bb9-8eb9-f83967e17b2b")
    <T extends BpmnDataOutput> List<T> getOutputSpecification(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->LoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ce15a73f-d1ce-4094-8dbf-54aefda7238a")
    BpmnLoopCharacteristics getLoopCharacteristics();

    /**
     * Setter for relation 'BpmnActivity->LoopCharacteristics'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bd63d137-be8c-4cb9-9558-62f86ac63e2a")
    void setLoopCharacteristics(BpmnLoopCharacteristics value);

    /**
     * Getter for relation 'BpmnActivity->BoundaryEventRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("66ec4fc3-45b8-4f37-a631-2c8b17317e61")
    EList<BpmnBoundaryEvent> getBoundaryEventRef();

    /**
     * Filtered Getter for relation 'BpmnActivity->BoundaryEventRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("270c5b78-3872-4475-9dff-7c9a753ceb93")
    <T extends BpmnBoundaryEvent> List<T> getBoundaryEventRef(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->DataOutputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2fafb60b-19f8-44c3-91e1-dfd2891f0ca1")
    EList<BpmnDataAssociation> getDataOutputAssociation();

    /**
     * Filtered Getter for relation 'BpmnActivity->DataOutputAssociation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8f275c91-562a-4504-98ff-7581dbd3d248")
    <T extends BpmnDataAssociation> List<T> getDataOutputAssociation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnActivity->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a66796ed-6f72-4193-b4ff-a822a84e7263")
    BpmnSequenceFlow getDefaultFlow();

    /**
     * Setter for relation 'BpmnActivity->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ccaa7914-537b-4672-b7f6-c0847c64165b")
    void setDefaultFlow(BpmnSequenceFlow value);

}
