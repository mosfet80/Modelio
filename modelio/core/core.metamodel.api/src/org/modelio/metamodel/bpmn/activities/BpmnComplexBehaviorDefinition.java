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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;

/**
 * BpmnComplexBehaviorDefinition v0.0.9054
 *
 *
 * This element controls when and which Events are thrown in case behavior of the Multi-Instance Activity is set to complex.
 *
 */
@objid ("007f7bdc-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnComplexBehaviorDefinition extends BpmnBaseElement {
    /**
     * The metaclass simple name.
     */
    @objid ("1f8a3427-2397-4991-89c2-10e25f4ef4a0")
    public static final String MNAME = "BpmnComplexBehaviorDefinition";

    /**
     * The metaclass qualified name.
     */
    @objid ("822a3cec-0a1d-4e0a-ab4d-0adab462ec16")
    public static final String MQNAME = "Standard.BpmnComplexBehaviorDefinition";

    /**
     * Getter for attribute 'BpmnComplexBehaviorDefinition.Condition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("19daabe1-0269-4914-a2bf-6ccec3854e7c")
    String getCondition();

    /**
     * Setter for attribute 'BpmnComplexBehaviorDefinition.Condition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7af82781-45d2-4e34-b552-3e1a3ad441a8")
    void setCondition(String value);

    /**
     * Getter for relation 'BpmnComplexBehaviorDefinition->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("64f3edfd-c7a0-43cc-8d49-472f7eb92131")
    BpmnMultiInstanceLoopCharacteristics getOwner();

    /**
     * Setter for relation 'BpmnComplexBehaviorDefinition->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("792e5935-ed9b-435c-ad28-fca003d12766")
    void setOwner(BpmnMultiInstanceLoopCharacteristics value);

    /**
     * Getter for relation 'BpmnComplexBehaviorDefinition->Event'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6b9ffc4f-fe86-4ce4-8a82-625f18951c61")
    BpmnImplicitThrowEvent getEvent();

    /**
     * Setter for relation 'BpmnComplexBehaviorDefinition->Event'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a704faac-299c-4619-8d2b-37f7ab333124")
    void setEvent(BpmnImplicitThrowEvent value);

}
