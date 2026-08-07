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
package org.modelio.metamodel.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * DecisionMergeNode v0.0.9054
 *
 *
 * A decision node is a control node that chooses between outgoing flows.
 *
 * A merge node is a control node that brings together multiple alternate flows. It is not used to synchronize concurrent flows but to accept one among several alternate flows.
 *
 * Modelio specific:
 * The functionality of merge node and decision node can be combined by using the same node. This case maps to a model containing a merge node with all the incoming edges and one outgoing edge to a decision node that has all the outgoing edges.
 *
 *
 *
 */
@objid ("002fbdcc-c4bf-1fd8-97fe-001ec947cd2a")
public interface DecisionMergeNode extends ControlNode {
    /**
     * The metaclass simple name.
     */
    @objid ("22b5684c-084f-42d0-a09c-5fbaa0cc941d")
    public static final String MNAME = "DecisionMergeNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("ac0ba9c0-8705-4580-bc65-fbac6d3388dc")
    public static final String MQNAME = "Standard.DecisionMergeNode";

    /**
     * Getter for attribute 'DecisionMergeNode.DecisionKind'
     *
     * Metamodel description:
     * <i>BPMN decision kind.</i>
     */
    @objid ("c5284325-d29f-4ffd-b5da-e656374f60ac")
    DecisionNodeKind getDecisionKind();

    /**
     * Setter for attribute 'DecisionMergeNode.DecisionKind'
     *
     * Metamodel description:
     * <i>BPMN decision kind.</i>
     */
    @objid ("95dc96d3-d3dd-471b-b120-a45c53b0426d")
    void setDecisionKind(DecisionNodeKind value);

    /**
     * Getter for attribute 'DecisionMergeNode.DecisionInputBehavior'
     *
     * Metamodel description:
     * <i>Provides input to guard specifications on edges outgoing from the decision node.</i>
     */
    @objid ("a44b085e-ca98-4c93-8d3a-698e81a10914")
    String getDecisionInputBehavior();

    /**
     * Setter for attribute 'DecisionMergeNode.DecisionInputBehavior'
     *
     * Metamodel description:
     * <i>Provides input to guard specifications on edges outgoing from the decision node.</i>
     */
    @objid ("d4b6f867-8e59-4d4a-9df4-cd4ec795a7d9")
    void setDecisionInputBehavior(String value);

}
