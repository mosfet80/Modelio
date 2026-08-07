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
 * ForkJoinNode v0.0.9054
 *
 *
 * A fork node has one incoming edge and multiple outgoing edges. A fork node is a control node that splits a flow into multiple concurrent flows.
 *
 * A join node has multiple incoming edges and one outgoing edge. Join nodes have a boolean specification using the names of the incoming edges to specify the conditions under which the join will emit a token.
 *
 * Modelio extension:
 * The functionality of join node and fork node can be combined by using the same node.
 * This case maps to a model containing a join node with all the incoming edges shown in the diagram and one outgoing edge to a fork node that has all the outgoing edges shown in the diagram.
 *
 */
@objid ("0033b2ec-c4bf-1fd8-97fe-001ec947cd2a")
public interface ForkJoinNode extends ControlNode {
    /**
     * The metaclass simple name.
     */
    @objid ("40106d2d-784f-47d2-b318-50e7bb8c80e6")
    public static final String MNAME = "ForkJoinNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("c1a166b0-1d7a-49df-b555-7e11f2aba500")
    public static final String MQNAME = "Standard.ForkJoinNode";

    /**
     * Getter for attribute 'ForkJoinNode.IsCombineDuplicate'
     *
     * Metamodel description:
     * <i>Indicates whether tokens with objects with the same identity are combined into one by the join. The default value is true.</i>
     */
    @objid ("d5ed0c8d-7dd7-4772-ad5d-1a6b3d5cf249")
    boolean isIsCombineDuplicate();

    /**
     * Setter for attribute 'ForkJoinNode.IsCombineDuplicate'
     *
     * Metamodel description:
     * <i>Indicates whether tokens with objects with the same identity are combined into one by the join. The default value is true.</i>
     */
    @objid ("a1711169-3950-4f5b-b9c5-a17eb42a6325")
    void setIsCombineDuplicate(boolean value);

    /**
     * Getter for attribute 'ForkJoinNode.JoinSpec'
     *
     * Metamodel description:
     * <i>A specification giving the conditions under which the join will emit a
     * token. The default value is �??and.</i>
     */
    @objid ("c1596066-fe43-4fdf-846f-625a05fb4cec")
    String getJoinSpec();

    /**
     * Setter for attribute 'ForkJoinNode.JoinSpec'
     *
     * Metamodel description:
     * <i>A specification giving the conditions under which the join will emit a
     * token. The default value is �??and.</i>
     */
    @objid ("64f5e308-e898-4724-b46d-fa01c4f1e0a5")
    void setJoinSpec(String value);

}
