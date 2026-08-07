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

/**
 * BpmnAdHocSubProcess v0.0.9054
 *
 *
 * An Ad-Hoc Sub-Process is a specialized type of Sub-Process that is a group of Activities that have no required sequence relationships. A set of Activities can be defined for the Process, but the sequence and number of performances for the Activities is determined by the performers of the Activities.
 *
 */
@objid ("007df21c-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnAdHocSubProcess extends BpmnSubProcess {
    /**
     * The metaclass simple name.
     */
    @objid ("121fbba4-551b-44dc-a082-58244a357457")
    public static final String MNAME = "BpmnAdHocSubProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("3a634e4e-6873-4266-ae0a-a3fbad11c010")
    public static final String MQNAME = "Standard.BpmnAdHocSubProcess";

    /**
     * Getter for attribute 'BpmnAdHocSubProcess.Ordering'
     *
     * Metamodel description:
     * <i>This attribute defines if the Activities within the Process can be performed in parallel or must be performed sequentially. The default setting is parallel and the setting of sequential is a restriction on the performance that may be required due to shared resources. When the setting is sequential, then only one Activity can be performed at a time. When the setting is parallel, then zero (0) to all the Activities of the Sub-Process can be performed in parallel.</i>
     */
    @objid ("6a4d324a-7cfa-4e82-be73-31c5acb1fe74")
    AdHocOrdering getOrdering();

    /**
     * Setter for attribute 'BpmnAdHocSubProcess.Ordering'
     *
     * Metamodel description:
     * <i>This attribute defines if the Activities within the Process can be performed in parallel or must be performed sequentially. The default setting is parallel and the setting of sequential is a restriction on the performance that may be required due to shared resources. When the setting is sequential, then only one Activity can be performed at a time. When the setting is parallel, then zero (0) to all the Activities of the Sub-Process can be performed in parallel.</i>
     */
    @objid ("4b1c5689-8001-4911-8263-a621fed800d6")
    void setOrdering(AdHocOrdering value);

    /**
     * Getter for attribute 'BpmnAdHocSubProcess.CancelRemainingInstances'
     *
     * Metamodel description:
     * <i>This attribute is used only if ordering is parallel. It determines whether running instances are cancelled when the completionCondition becomes true.</i>
     */
    @objid ("9bea6524-ef12-4f0e-b5ed-eec1bd0be50b")
    boolean isCancelRemainingInstances();

    /**
     * Setter for attribute 'BpmnAdHocSubProcess.CancelRemainingInstances'
     *
     * Metamodel description:
     * <i>This attribute is used only if ordering is parallel. It determines whether running instances are cancelled when the completionCondition becomes true.</i>
     */
    @objid ("1511afe5-07a7-47f4-ba6c-3c227b5a3e81")
    void setCancelRemainingInstances(boolean value);

    /**
     * Getter for attribute 'BpmnAdHocSubProcess.CompletionCondition'
     *
     * Metamodel description:
     * <i>This Expression defines the conditions when the Process will end. When the Expression is evaluated to true, the Process will be terminated.</i>
     */
    @objid ("ffe9a535-6eb0-4be0-9e70-ed779c518d3a")
    String getCompletionCondition();

    /**
     * Setter for attribute 'BpmnAdHocSubProcess.CompletionCondition'
     *
     * Metamodel description:
     * <i>This Expression defines the conditions when the Process will end. When the Expression is evaluated to true, the Process will be terminated.</i>
     */
    @objid ("430747df-b5be-450c-99b9-8a712a2ff7f1")
    void setCompletionCondition(String value);

}
