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
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;

/**
 * BpmnMultiInstanceLoopCharacteristics v0.0.9054
 *
 *
 * null
 *
 */
@objid ("0080f732-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnMultiInstanceLoopCharacteristics extends BpmnLoopCharacteristics {
    /**
     * The metaclass simple name.
     */
    @objid ("c1b3ca7f-ed86-4129-b66e-8f283d86b615")
    public static final String MNAME = "BpmnMultiInstanceLoopCharacteristics";

    /**
     * The metaclass qualified name.
     */
    @objid ("b7ed6f72-ebfa-4adb-bdc3-35437c58cc93")
    public static final String MQNAME = "Standard.BpmnMultiInstanceLoopCharacteristics";

    /**
     * Getter for attribute 'BpmnMultiInstanceLoopCharacteristics.IsSequencial'
     *
     * Metamodel description:
     * <i>This attribute is a flag that controls whether the Activity instances will execute sequentially or in parallel.
     *
     * If the multi-instance instances are set to be performed in parallel rather than sequential (the isSequential attribute set to false), then the lines of the marker will vertical.
     *
     * If the multi-instance instances are set to be performed in sequence rather than parallel (the isSequential attribute set to true), then the marker will be horizontal</i>
     */
    @objid ("ddcfcaff-367c-4b2c-a95c-4673203dd068")
    boolean isIsSequencial();

    /**
     * Setter for attribute 'BpmnMultiInstanceLoopCharacteristics.IsSequencial'
     *
     * Metamodel description:
     * <i>This attribute is a flag that controls whether the Activity instances will execute sequentially or in parallel.
     *
     * If the multi-instance instances are set to be performed in parallel rather than sequential (the isSequential attribute set to false), then the lines of the marker will vertical.
     *
     * If the multi-instance instances are set to be performed in sequence rather than parallel (the isSequential attribute set to true), then the marker will be horizontal</i>
     */
    @objid ("cf76b7fd-e6eb-4b50-977d-616d7644c7a7")
    void setIsSequencial(boolean value);

    /**
     * Getter for attribute 'BpmnMultiInstanceLoopCharacteristics.Behavior'
     *
     * Metamodel description:
     * <i>The attribute behavior acts as a shortcut for specifying when events SHALL be thrown from an Activity instance that is about to complete. It can assume values of None, One, All, and Complex, resulting in the following behavior:
     * ? None: the EventDefinition which is associated through the noneEvent association will be thrown for each instance completing;
     * ? One: the EventDefinition referenced through the oneEvent association will be thrown upon the first instance completing;
     * ? All: no Event is ever thrown; a token is produced after completion of all instances
     * ? Complex: the complexBehaviorDefinitions are consulted to determine if and which Events to throw.
     *
     * For the behaviors of none and one, a default SignalEventDefinition will be thrown which automatically carries the current runtime attributes of the MI Activity.
     *
     * Any thrown Events can be caught by boundary Events on the MultiInstance Activity.</i>
     */
    @objid ("c3c4a989-24ad-4d71-a6c7-c5735cad11d9")
    MultiInstanceBehavior getBehavior();

    /**
     * Setter for attribute 'BpmnMultiInstanceLoopCharacteristics.Behavior'
     *
     * Metamodel description:
     * <i>The attribute behavior acts as a shortcut for specifying when events SHALL be thrown from an Activity instance that is about to complete. It can assume values of None, One, All, and Complex, resulting in the following behavior:
     * ? None: the EventDefinition which is associated through the noneEvent association will be thrown for each instance completing;
     * ? One: the EventDefinition referenced through the oneEvent association will be thrown upon the first instance completing;
     * ? All: no Event is ever thrown; a token is produced after completion of all instances
     * ? Complex: the complexBehaviorDefinitions are consulted to determine if and which Events to throw.
     *
     * For the behaviors of none and one, a default SignalEventDefinition will be thrown which automatically carries the current runtime attributes of the MI Activity.
     *
     * Any thrown Events can be caught by boundary Events on the MultiInstance Activity.</i>
     */
    @objid ("159cdd1e-3b9e-4e3c-971c-6dfbbf1cf9dc")
    void setBehavior(MultiInstanceBehavior value);

    /**
     * Getter for attribute 'BpmnMultiInstanceLoopCharacteristics.LoopCardinality'
     *
     * Metamodel description:
     * <i>A numeric Expression that controls the number of Activity instances that will be created. This Expression MUST evaluate to an integer.
     * This MAY be underspecified, meaning that the modeler MAY simply document the condition. In such a case the loop cannot be formally executed.
     *
     * In order to initialize a valid multi-instance, either the loopCardinality Expression or the loopDataInput MUST be specified.</i>
     */
    @objid ("5b38b263-a8ec-4a1e-9f73-48a1703885f2")
    String getLoopCardinality();

    /**
     * Setter for attribute 'BpmnMultiInstanceLoopCharacteristics.LoopCardinality'
     *
     * Metamodel description:
     * <i>A numeric Expression that controls the number of Activity instances that will be created. This Expression MUST evaluate to an integer.
     * This MAY be underspecified, meaning that the modeler MAY simply document the condition. In such a case the loop cannot be formally executed.
     *
     * In order to initialize a valid multi-instance, either the loopCardinality Expression or the loopDataInput MUST be specified.</i>
     */
    @objid ("97b41a61-8c1a-41e4-91e0-6594cb08d3a2")
    void setLoopCardinality(String value);

    /**
     * Getter for attribute 'BpmnMultiInstanceLoopCharacteristics.CompletionCondition'
     *
     * Metamodel description:
     * <i>This attribute defines a boolean Expression that when evaluated to true, cancels the remaining Activity instances and produces a token.</i>
     */
    @objid ("8afaa691-6455-4248-a480-7c6ef28fd2b1")
    String getCompletionCondition();

    /**
     * Setter for attribute 'BpmnMultiInstanceLoopCharacteristics.CompletionCondition'
     *
     * Metamodel description:
     * <i>This attribute defines a boolean Expression that when evaluated to true, cancels the remaining Activity instances and produces a token.</i>
     */
    @objid ("bc63fa77-1768-45bc-a50e-db52fb3f5a17")
    void setCompletionCondition(String value);

    /**
     * Getter for relation 'BpmnMultiInstanceLoopCharacteristics->LoopDataInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("977fe5b7-2294-40ce-97f1-64dfe1d93134")
    BpmnDataInput getLoopDataInput();

    /**
     * Setter for relation 'BpmnMultiInstanceLoopCharacteristics->LoopDataInput'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bd67b26b-a3bb-44f0-8851-8739458ab44f")
    void setLoopDataInput(BpmnDataInput value);

    /**
     * Getter for relation 'BpmnMultiInstanceLoopCharacteristics->LoopDataOutputRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("62b86bd1-c6bc-4f58-b60a-8696d0f1512d")
    BpmnDataOutput getLoopDataOutputRef();

    /**
     * Setter for relation 'BpmnMultiInstanceLoopCharacteristics->LoopDataOutputRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2c5e8bd4-82fa-4fb2-9917-e0d2595def69")
    void setLoopDataOutputRef(BpmnDataOutput value);

    /**
     * Getter for relation 'BpmnMultiInstanceLoopCharacteristics->CompletionEventRef'
     *
     * Metamodel description:
     * <i>The EventDefinition which is thrown when:
     * -  behavior is set to one and the first internal Activity instance has completed,
     * - or the behavior is set to none and an internal Activity instance has completed.</i>
     */
    @objid ("2f6dde2c-e62a-46f6-8832-5c30172ae27b")
    BpmnEventDefinition getCompletionEventRef();

    /**
     * Setter for relation 'BpmnMultiInstanceLoopCharacteristics->CompletionEventRef'
     *
     * Metamodel description:
     * <i>The EventDefinition which is thrown when:
     * -  behavior is set to one and the first internal Activity instance has completed,
     * - or the behavior is set to none and an internal Activity instance has completed.</i>
     */
    @objid ("86930d36-43e5-41a8-b552-ca2516e69d39")
    void setCompletionEventRef(BpmnEventDefinition value);

    /**
     * Getter for relation 'BpmnMultiInstanceLoopCharacteristics->ComplexBehaviorDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a8503d67-7e8a-4e58-a99d-1ce0b5f54b8b")
    EList<BpmnComplexBehaviorDefinition> getComplexBehaviorDefinition();

    /**
     * Filtered Getter for relation 'BpmnMultiInstanceLoopCharacteristics->ComplexBehaviorDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2b62824a-7f03-45a5-bdc4-3e2ac1f5727e")
    <T extends BpmnComplexBehaviorDefinition> List<T> getComplexBehaviorDefinition(java.lang.Class<T> filterClass);

}
