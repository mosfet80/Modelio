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
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Instance;

/**
 * ObjectNode v0.0.9054
 *
 *
 * An object node is an activity node that indicates an instance of a particular classifier, possibly in a particular state, may be available at a particular point in the activity. Object nodes can be used in a variety of ways, depending on where objects are flowing from and to, as described in the semantics section.
 *
 * The ordering of an object node specifies the order in which tokens in the node are offered to the outgoing edges. This can be set to require that tokens do not overtake each other as they pass through the node (FIFO), or that they do (LIFO or modeler-defined ordering). Modeler-defined ordering is indicated by an ordering value of ordered, and a selection expression that determines what token to offer to the edges.
 *
 * Modelio extension:
 * An object node can represent an attribute, a parameter, an association role or an instance.
 *
 */
@objid ("003940c2-c4bf-1fd8-97fe-001ec947cd2a")
public interface ObjectNode extends ActivityNode {
    /**
     * The metaclass simple name.
     */
    @objid ("df051b80-c98d-40bb-a312-99776fa00be4")
    public static final String MNAME = "ObjectNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("834705c0-6249-4f9e-b39c-58c5d6773321")
    public static final String MQNAME = "Standard.ObjectNode";

    /**
     * Getter for attribute 'ObjectNode.IsControlType'
     *
     * Metamodel description:
     * <i>Indicates whether the type of the object node is to be treated as control.</i>
     */
    @objid ("b83056fb-da25-4b9f-90ce-dca47b8f71ea")
    boolean isIsControlType();

    /**
     * Setter for attribute 'ObjectNode.IsControlType'
     *
     * Metamodel description:
     * <i>Indicates whether the type of the object node is to be treated as control.</i>
     */
    @objid ("92025ae7-7fad-46a6-b1c8-1e036793821b")
    void setIsControlType(boolean value);

    /**
     * Getter for attribute 'ObjectNode.Ordering'
     *
     * Metamodel description:
     * <i>Indicates if and how the tokens in the object node are ordered for selection to traverse edges outgoing from the object node.</i>
     */
    @objid ("337ad394-c759-4049-8d77-855c46bf13dc")
    ObjectNodeOrderingKind getOrdering();

    /**
     * Setter for attribute 'ObjectNode.Ordering'
     *
     * Metamodel description:
     * <i>Indicates if and how the tokens in the object node are ordered for selection to traverse edges outgoing from the object node.</i>
     */
    @objid ("c3298ad7-d506-4421-8fcf-ca706abeaff2")
    void setOrdering(ObjectNodeOrderingKind value);

    /**
     * Getter for attribute 'ObjectNode.SelectionBehavior'
     *
     * Metamodel description:
     * <i>Selects tokens for outgoing edges.</i>
     */
    @objid ("1498465f-eaa9-4573-94b0-ef1535512979")
    String getSelectionBehavior();

    /**
     * Setter for attribute 'ObjectNode.SelectionBehavior'
     *
     * Metamodel description:
     * <i>Selects tokens for outgoing edges.</i>
     */
    @objid ("bda26826-3d8e-4708-852a-de6bb987fb42")
    void setSelectionBehavior(String value);

    /**
     * Getter for attribute 'ObjectNode.UpperBound'
     *
     * Metamodel description:
     * <i>The maximum number of tokens allowed in the node. Objects cannot flow into the node if the upper bound is reached.</i>
     */
    @objid ("bad63cce-e522-464a-a75f-e886d75f102c")
    String getUpperBound();

    /**
     * Setter for attribute 'ObjectNode.UpperBound'
     *
     * Metamodel description:
     * <i>The maximum number of tokens allowed in the node. Objects cannot flow into the node if the upper bound is reached.</i>
     */
    @objid ("815b85cd-5a79-4722-af47-5bf14544922b")
    void setUpperBound(String value);

    /**
     * Getter for relation 'ObjectNode->Represented'
     *
     * Metamodel description:
     * <i>Instance that is represented by the ObjectNode.</i>
     */
    @objid ("4ec61058-b5b8-4a23-b9bd-c00b18bf781b")
    Instance getRepresented();

    /**
     * Setter for relation 'ObjectNode->Represented'
     *
     * Metamodel description:
     * <i>Instance that is represented by the ObjectNode.</i>
     */
    @objid ("29d166ba-0ee9-4813-bb58-1726ff9ceea3")
    void setRepresented(Instance value);

    /**
     * Getter for relation 'ObjectNode->RepresentedRealParameter'
     *
     * Metamodel description:
     * <i>The represented parameter. For a Pin on a CallOperationAction or a CallBehaviorAction, links to the matched parameter of the called operation or behavior.</i>
     */
    @objid ("219c25c4-591f-4f55-baa1-2fbdc39ef8a0")
    BehaviorParameter getRepresentedRealParameter();

    /**
     * Setter for relation 'ObjectNode->RepresentedRealParameter'
     *
     * Metamodel description:
     * <i>The represented parameter. For a Pin on a CallOperationAction or a CallBehaviorAction, links to the matched parameter of the called operation or behavior.</i>
     */
    @objid ("7a2d00de-ae87-45c5-ba6a-66e14660ce0a")
    void setRepresentedRealParameter(BehaviorParameter value);

    /**
     * Getter for relation 'ObjectNode->Type'
     *
     * Metamodel description:
     * <i>Type of the object node.</i>
     */
    @objid ("9b884604-377b-4448-bd26-e9bb9fc6fd18")
    GeneralClass getType();

    /**
     * Setter for relation 'ObjectNode->Type'
     *
     * Metamodel description:
     * <i>Type of the object node.</i>
     */
    @objid ("c048f283-d252-416a-a58b-f593096dc67f")
    void setType(GeneralClass value);

    /**
     * Getter for relation 'ObjectNode->RepresentedRole'
     *
     * Metamodel description:
     * <i>Shortcut to directly represent an association end by the node. This replaces the normal way: representing an instance bound to the associationEnd.</i>
     */
    @objid ("6e6763ee-80d4-482e-b9ec-752cb709cec4")
    AssociationEnd getRepresentedRole();

    /**
     * Setter for relation 'ObjectNode->RepresentedRole'
     *
     * Metamodel description:
     * <i>Shortcut to directly represent an association end by the node. This replaces the normal way: representing an instance bound to the associationEnd.</i>
     */
    @objid ("0f23f822-1456-4085-9637-b74070cc8be8")
    void setRepresentedRole(AssociationEnd value);

    /**
     * Getter for relation 'ObjectNode->RepresentedAttribute'
     *
     * Metamodel description:
     * <i>Represented attribute. Shortcut to directly represent an attribute, instead of representing an instance bound to the attribute.</i>
     */
    @objid ("f4106176-23a5-4f4f-84ae-5b31e831ebd1")
    Attribute getRepresentedAttribute();

    /**
     * Setter for relation 'ObjectNode->RepresentedAttribute'
     *
     * Metamodel description:
     * <i>Represented attribute. Shortcut to directly represent an attribute, instead of representing an instance bound to the attribute.</i>
     */
    @objid ("d721410a-dff4-4ab4-a5aa-010e05b204c0")
    void setRepresentedAttribute(Attribute value);

    /**
     * Getter for relation 'ObjectNode->InState'
     *
     * Metamodel description:
     * <i>The required state of the object available at this point in the activity. This state must belong to the type of the objectNode, or of the represented element. </i>
     */
    @objid ("6f47413e-725b-4d15-b544-ab413ec86780")
    State getInState();

    /**
     * Setter for relation 'ObjectNode->InState'
     *
     * Metamodel description:
     * <i>The required state of the object available at this point in the activity. This state must belong to the type of the objectNode, or of the represented element. </i>
     */
    @objid ("0f0b4a0b-92cc-48d1-bb8d-097c04a3e8b8")
    void setInState(State value);

}
