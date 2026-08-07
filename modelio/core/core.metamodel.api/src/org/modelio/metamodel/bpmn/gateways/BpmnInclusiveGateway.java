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
 * BpmnInclusiveGateway v0.0.9054
 *
 *
 * A diverging Inclusive Gateway (Inclusive Decision) can be used to create alternative but also parallel paths within a Process flow. Unlike the Exclusive Gateway, all condition Expressions are evaluated. The true evaluation of one condition Expression does not exclude the evaluation of other condition Expressions. All Sequence Flow with a true evaluation will be traversed by a token. Since each path is considered to be independent, all combinations of the paths may be taken, from zero to all. However, it should be designed so that at least one path is taken.
 *
 */
@objid ("00019a82-c4c0-1fd8-97fe-001ec947cd2a")
public interface BpmnInclusiveGateway extends BpmnGateway {
    /**
     * The metaclass simple name.
     */
    @objid ("5651b9bf-248b-4a87-8e76-27f5be7d1ddd")
    public static final String MNAME = "BpmnInclusiveGateway";

    /**
     * The metaclass qualified name.
     */
    @objid ("0d9e1303-af08-41bd-84f0-d94616644a3e")
    public static final String MQNAME = "Standard.BpmnInclusiveGateway";

    /**
     * Getter for relation 'BpmnInclusiveGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("08217617-b651-4b5f-9adb-b819bf6a3c22")
    BpmnSequenceFlow getDefaultFlow();

    /**
     * Setter for relation 'BpmnInclusiveGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("541bcdb5-8b9d-40f4-b63c-36ab10fa2093")
    void setDefaultFlow(BpmnSequenceFlow value);

}
