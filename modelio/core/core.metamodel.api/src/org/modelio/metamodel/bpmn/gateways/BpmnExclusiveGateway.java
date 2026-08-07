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
package org.modelio.metamodel.bpmn.gateways;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;

/**
 * BpmnExclusiveGateway v0.0.9054
 *
 *
 * A diverging Exclusive Gateway (Decision) is used to create alternative paths within a Process flow. This is basically the ?diversion point in the road? for a Process. For a given instance of the Process, only one of the paths can be taken.
 * A Decision can be thought of as a question that is asked at a particular point in the Process. The question has a defined set of alternative answers. Each question is associated with a condition Expression that is associated with a Gateway?s outgoing Sequence Flow.
 *
 */
@objid ("000002bc-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnExclusiveGateway extends BpmnGateway {
    /**
     * The metaclass simple name.
     */
    @objid ("9724399f-ac83-4349-a631-cf2c10a63605")
    public static final String MNAME = "BpmnExclusiveGateway";

    /**
     * The metaclass qualified name.
     */
    @objid ("bd2b9be5-f456-4ca9-9600-14eae4bef94a")
    public static final String MQNAME = "Standard.BpmnExclusiveGateway";

    /**
     * Getter for relation 'BpmnExclusiveGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2c335e87-c7d4-48f1-ba11-c73c41e33084")
    BpmnSequenceFlow getDefaultFlow();

    /**
     * Setter for relation 'BpmnExclusiveGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("222bd4d9-2b99-40dd-a549-42a67901fd4b")
    void setDefaultFlow(BpmnSequenceFlow value);

}
