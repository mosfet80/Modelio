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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * ActivityNode v0.0.9054
 *
 *
 * The execution of an action represents some transformation or processing in the modeled
 * system, be it a computer system or otherwise.
 *
 * An action may have sets of incoming and outgoing activity edges that specify control flow and data flow to and from other nodes. An action will not begin execution until all of its input conditions are satisfied. The completion of the execution of an action may enable the execution of a set  of successor nodes and actions that take their inputs from the outputs of the action.
 *
 * Action can have pre- and postconditions (using constraints).
 *
 */
@objid ("0028adde-c4bf-1fd8-97fe-001ec947cd2a")
public interface ActivityNode extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("7b8572fd-5859-4be2-9def-d16cf4767383")
    public static final String MNAME = "ActivityNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("75c9a417-ee5f-469b-a9f0-89712ad6b6be")
    public static final String MQNAME = "Standard.ActivityNode";

    /**
     * Getter for relation 'ActivityNode->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("61ceb513-0ba5-44b5-8930-5c06c4b4c013")
    Activity getOwner();

    /**
     * Setter for relation 'ActivityNode->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ae04c10c-e750-474b-ab35-1475c082740a")
    void setOwner(Activity value);

    /**
     * Getter for relation 'ActivityNode->OwnerPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("543d7865-cb56-4d8b-b9fe-d7f7a87dff67")
    ActivityPartition getOwnerPartition();

    /**
     * Setter for relation 'ActivityNode->OwnerPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ee015c1e-e815-4d25-83ae-466f6d26c6d8")
    void setOwnerPartition(ActivityPartition value);

    /**
     * Getter for relation 'ActivityNode->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a73e6935-2d94-496e-964c-b4c56195d286")
    EList<ActivityEdge> getIncoming();

    /**
     * Filtered Getter for relation 'ActivityNode->Incoming'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("08ebd4b9-1cfa-4fd6-a7d8-a8bdda58ad8d")
    <T extends ActivityEdge> List<T> getIncoming(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'ActivityNode->OwnerClause'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4ac32adb-0330-48fd-89bb-b37cd04be00f")
    Clause getOwnerClause();

    /**
     * Setter for relation 'ActivityNode->OwnerClause'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("769a29bd-7219-4ad7-b480-e53ddae84be4")
    void setOwnerClause(Clause value);

    /**
     * Getter for relation 'ActivityNode->OwnerNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e1edcaa5-3534-4cb0-91ba-fe275a92f4a3")
    StructuredActivityNode getOwnerNode();

    /**
     * Setter for relation 'ActivityNode->OwnerNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("89524275-2cab-45e5-91a0-da0b4adaa559")
    void setOwnerNode(StructuredActivityNode value);

    /**
     * Getter for relation 'ActivityNode->Outgoing'
     *
     * Metamodel description:
     * <i>Edges that have the node as source.</i>
     */
    @objid ("e33d2087-5b4b-4766-b131-ba24ec278dad")
    EList<ActivityEdge> getOutgoing();

    /**
     * Filtered Getter for relation 'ActivityNode->Outgoing'
     *
     * Metamodel description:
     * <i>Edges that have the node as source.</i>
     */
    @objid ("b231b21e-4a4d-49b3-af3e-3eb4848d70ea")
    <T extends ActivityEdge> List<T> getOutgoing(java.lang.Class<T> filterClass);

}
