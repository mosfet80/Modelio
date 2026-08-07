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
package org.modelio.metamodel.bpmn.flows;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.gateways.BpmnComplexGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnExclusiveGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.bpmn.objects.BpmnSequenceFlowDataAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;

/**
 * BpmnSequenceFlow v0.0.9054
 *
 *
 * A Sequence Flow is used to show the order of Flow Elements in a Process or a Choreography. Each Sequence Flow has only one source and only one target. The source and target must be from the set of the following Flow Elements: Events (Start, Intermediate, and End), Activities (Task and Sub-Process; for Processes), Choreography Activities (Choreography Task and  Sub-Choreography for Choreographies), and Gateways.
 * A Sequence Flow can optionally define a condition Expression, indicating that the token will be passed down the Sequence Flow only if the Expression evaluates to true. This Expression is typically used when the source of the Sequence Flow is a Gateway or an Activity.
 * A Sequence Flow that has an Exclusive, Inclusive, or Complex Gateway or an Activity as its source can also be defined with as default. Such Sequence Flow will have a marker to show that it is a default flow. The default Sequence Flow is taken (a token is passed) only if all the other outgoing Sequence Flow from the Activity or Gateway are not valid (i.e., their condition Expressions are false).
 *
 * A sequence Flow is "default", if has a default association from a flowNode (Gateway or Activity).
 * A sequence flow is "conditional" is it originates from an activity, and has a conditionExpression.
 *
 * Ownership
 * A Sequence flow belongs to a flow element container or a sub process.
 *
 */
@objid ("007cd986-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnSequenceFlow extends BpmnFlowElement {
    /**
     * The metaclass simple name.
     */
    @objid ("66d1bdf6-82ce-48bd-b355-9a5bd01d0372")
    public static final String MNAME = "BpmnSequenceFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("1588d8e4-f07b-4a10-b87b-0574f38b67f1")
    public static final String MQNAME = "Standard.BpmnSequenceFlow";

    /**
     * Getter for attribute 'BpmnSequenceFlow.IsImmediate'
     *
     * Metamodel description:
     * <i>An optional boolean value specifying whether Activities or Choreography
     * Activities not in the model containing the Sequence Flow can occur between the
     * elements connected by the Sequence Flow. If the value is true, they MAY NOT occur. If the value is false, they MAY occur. Also see the isClosed attribute on Process, Choreography, and Collaboration. When the attribute has no value, the default semantics depends on the kind of model containing Sequence Flow:
     * ? For a public Processes and Choreographies no value has the same semantics as if the value were false.
     * ? For an executable and non-executable (internal) Processes no value has the same semantics as if the value were true.
     * ? For executable Processes, the attribute MUST NOT be false.</i>
     */
    @objid ("380371b6-77bf-44ba-9609-e91dcef55619")
    boolean isIsImmediate();

    /**
     * Setter for attribute 'BpmnSequenceFlow.IsImmediate'
     *
     * Metamodel description:
     * <i>An optional boolean value specifying whether Activities or Choreography
     * Activities not in the model containing the Sequence Flow can occur between the
     * elements connected by the Sequence Flow. If the value is true, they MAY NOT occur. If the value is false, they MAY occur. Also see the isClosed attribute on Process, Choreography, and Collaboration. When the attribute has no value, the default semantics depends on the kind of model containing Sequence Flow:
     * ? For a public Processes and Choreographies no value has the same semantics as if the value were false.
     * ? For an executable and non-executable (internal) Processes no value has the same semantics as if the value were true.
     * ? For executable Processes, the attribute MUST NOT be false.</i>
     */
    @objid ("6e87bbc0-4af6-4821-8a16-d383e601c3a2")
    void setIsImmediate(boolean value);

    /**
     * Getter for attribute 'BpmnSequenceFlow.ConditionExpression'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("489b1d75-fb39-4f8d-bafb-a49844a47c01")
    String getConditionExpression();

    /**
     * Setter for attribute 'BpmnSequenceFlow.ConditionExpression'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cef05a44-706b-4268-aa0f-ed3e6811acc3")
    void setConditionExpression(String value);

    /**
     * Getter for relation 'BpmnSequenceFlow->SourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8e229328-e7e6-4406-9f3a-e36f86463107")
    BpmnFlowNode getSourceRef();

    /**
     * Setter for relation 'BpmnSequenceFlow->SourceRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cdfa5eed-618a-4aa3-81aa-ead5646f65bb")
    void setSourceRef(BpmnFlowNode value);

    /**
     * Getter for relation 'BpmnSequenceFlow->TargetRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f3fc9f56-4eed-4f99-bca0-1666b54cabcf")
    BpmnFlowNode getTargetRef();

    /**
     * Setter for relation 'BpmnSequenceFlow->TargetRef'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a54b74b8-32e5-42ef-9cb5-f558046f08bb")
    void setTargetRef(BpmnFlowNode value);

    /**
     * Getter for relation 'BpmnSequenceFlow->DefaultOfInclusive'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b9d5d1ee-4db1-4cf0-aa1c-32c0f0869158")
    BpmnInclusiveGateway getDefaultOfInclusive();

    /**
     * Setter for relation 'BpmnSequenceFlow->DefaultOfInclusive'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d75f35af-1256-4ce3-82e9-2d0d593f94bb")
    void setDefaultOfInclusive(BpmnInclusiveGateway value);

    /**
     * Getter for relation 'BpmnSequenceFlow->DefaultFrom'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dce9b33e-bbca-4142-a67a-9b6553a0b93b")
    BpmnActivity getDefaultFrom();

    /**
     * Setter for relation 'BpmnSequenceFlow->DefaultFrom'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2966f860-e51c-48d3-b933-d26dbea58a0c")
    void setDefaultFrom(BpmnActivity value);

    /**
     * Getter for relation 'BpmnSequenceFlow->DefaultOfExclusive'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("86add9f3-ad05-4fc8-ba64-460716eeaa8a")
    BpmnExclusiveGateway getDefaultOfExclusive();

    /**
     * Setter for relation 'BpmnSequenceFlow->DefaultOfExclusive'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("34a97f72-3c14-48be-891f-0e51f1d0d182")
    void setDefaultOfExclusive(BpmnExclusiveGateway value);

    /**
     * Getter for relation 'BpmnSequenceFlow->Connector'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("70161b21-3020-46ff-be6f-a6babfe99de3")
    EList<BpmnSequenceFlowDataAssociation> getConnector();

    /**
     * Filtered Getter for relation 'BpmnSequenceFlow->Connector'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("cb3c0564-e4d9-4362-86a2-242558ef632b")
    <T extends BpmnSequenceFlowDataAssociation> List<T> getConnector(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BpmnSequenceFlow->DefaultOfComplex'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0d4bd619-64a1-4313-903a-f778e671aa93")
    BpmnComplexGateway getDefaultOfComplex();

    /**
     * Setter for relation 'BpmnSequenceFlow->DefaultOfComplex'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("aee6c4bd-d437-4da9-a0e9-f498508f7e63")
    void setDefaultOfComplex(BpmnComplexGateway value);

}
