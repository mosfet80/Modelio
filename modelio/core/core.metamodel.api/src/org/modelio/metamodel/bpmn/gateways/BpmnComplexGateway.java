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
 * BpmnComplexGateway v0.0.9054
 *
 *
 * The Complex Gateway can be used to model complex synchronization behavior. An Expression
 * activationCondition is used to describe the precise behavior. For example, this Expression could specify that tokens on three out of five incoming Sequence Flow are needed to activate the Gateway. What tokens are produced by the Gateway is determined by conditions on the outgoing Sequence Flow as in the split behavior of the Inclusive Gateway. If token arrive later on the two remaining Sequence Flow, those tokens cause a reset of the Gateway and new token can be produced on the outgoing Sequence Flow. To determine whether it needs to wait for additional tokens before it can reset, the Gateway uses the synchronization semantics of the Inclusive Gateway.
 *
 */
@objid ("00973ae2-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnComplexGateway extends BpmnGateway {
    /**
     * The metaclass simple name.
     */
    @objid ("1b62d1f8-a019-44e0-870b-5c796def77ba")
    public static final String MNAME = "BpmnComplexGateway";

    /**
     * The metaclass qualified name.
     */
    @objid ("951aaeeb-9f41-4403-8850-400a3dceaaa9")
    public static final String MQNAME = "Standard.BpmnComplexGateway";

    /**
     * Getter for attribute 'BpmnComplexGateway.ActivationExpression'
     *
     * Metamodel description:
     * <i>An activationExpression is a boolean Expression
     * that refers to data and to the activationCount of incoming gates. For example, an activationExpression
     * could be x1+x2+?+xm >= 3 stating that it needs 3 out of the m incoming gates to have a token in order to proceed. To
     * prevent undesirable oscillation of activation of the Complex Gateway, ActivationCount variables should only be
     * used in subexpressions of the form expr >= const where expr is an arithmetic Expression that uses only addition and
     * const is an Expression whose evaluation remains constant during execution of the Process.</i>
     */
    @objid ("81d134b4-b301-4024-9e53-0f5116dcf862")
    String getActivationExpression();

    /**
     * Setter for attribute 'BpmnComplexGateway.ActivationExpression'
     *
     * Metamodel description:
     * <i>An activationExpression is a boolean Expression
     * that refers to data and to the activationCount of incoming gates. For example, an activationExpression
     * could be x1+x2+?+xm >= 3 stating that it needs 3 out of the m incoming gates to have a token in order to proceed. To
     * prevent undesirable oscillation of activation of the Complex Gateway, ActivationCount variables should only be
     * used in subexpressions of the form expr >= const where expr is an arithmetic Expression that uses only addition and
     * const is an Expression whose evaluation remains constant during execution of the Process.</i>
     */
    @objid ("3774a2a8-6b6e-4482-b39e-2b415358f2ef")
    void setActivationExpression(String value);

    /**
     * Getter for relation 'BpmnComplexGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8d0532ec-15cc-47fb-821b-5f3416db0195")
    BpmnSequenceFlow getDefaultFlow();

    /**
     * Setter for relation 'BpmnComplexGateway->DefaultFlow'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("de86bf70-313a-4c0f-ba37-0adcb001e454")
    void setDefaultFlow(BpmnSequenceFlow value);

}
