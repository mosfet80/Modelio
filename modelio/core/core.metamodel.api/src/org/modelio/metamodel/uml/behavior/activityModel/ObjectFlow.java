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
 * ObjectFlow v0.0.9054
 *
 *
 * An object flow is an activity edge that only passes object and data tokens.
 * Tokens offered by the source node are all offered to the target node.
 *
 * If transformation behavior is specified, then each token offered to the edge is passed to the behavior, and the output of the behavior is given to the target node for consideration instead of the token that was input to the transformation expression.
 *
 * If a selection expression is specified, then it is used to offer a token from the source object node to the edge, rather than using object node's ordering. It has the same semantics as selection expression on object nodes.
 *
 * Modelio specific :
 * In order to make the selection and transformation sections easier to fill, these are string expressions in Modelio, instead of Behaviors in the OMG UML specification.
 *
 */
@objid ("00388c90-c4bf-1fd8-97fe-001ec947cd2a")
public interface ObjectFlow extends ActivityEdge {
    /**
     * The metaclass simple name.
     */
    @objid ("80c030d9-f853-4c3a-9461-17dec06cb44b")
    public static final String MNAME = "ObjectFlow";

    /**
     * The metaclass qualified name.
     */
    @objid ("99e25572-b399-4c10-82ac-0e5df82e641b")
    public static final String MQNAME = "Standard.ObjectFlow";

    /**
     * Getter for attribute 'ObjectFlow.TransformationBehavior'
     *
     * Metamodel description:
     * <i>Expression that changes or replaces data tokens flowing along edge.</i>
     */
    @objid ("76881fb7-9817-4c19-8b8a-b4187b3a76c8")
    String getTransformationBehavior();

    /**
     * Setter for attribute 'ObjectFlow.TransformationBehavior'
     *
     * Metamodel description:
     * <i>Expression that changes or replaces data tokens flowing along edge.</i>
     */
    @objid ("ef1618fa-9397-4dff-ae80-0fb90cb448f8")
    void setTransformationBehavior(String value);

    /**
     * Getter for attribute 'ObjectFlow.SelectionBehavior'
     *
     * Metamodel description:
     * <i>Selects tokens from a source object node.</i>
     */
    @objid ("b3a533dd-8d39-4faf-8f01-c251564478ea")
    String getSelectionBehavior();

    /**
     * Setter for attribute 'ObjectFlow.SelectionBehavior'
     *
     * Metamodel description:
     * <i>Selects tokens from a source object node.</i>
     */
    @objid ("e391b2bf-b126-45a9-8913-a58c978180d3")
    void setSelectionBehavior(String value);

    /**
     * Getter for attribute 'ObjectFlow.IsMultiCast'
     *
     * Metamodel description:
     * <i>Indicates whether the objects in the flow are passed by multicasting.</i>
     */
    @objid ("244db30f-bada-4f03-8a64-457ef7618b4b")
    boolean isIsMultiCast();

    /**
     * Setter for attribute 'ObjectFlow.IsMultiCast'
     *
     * Metamodel description:
     * <i>Indicates whether the objects in the flow are passed by multicasting.</i>
     */
    @objid ("591ae608-7957-4981-bd37-b55e93bc9b11")
    void setIsMultiCast(boolean value);

    /**
     * Getter for attribute 'ObjectFlow.IsMultiReceive'
     *
     * Metamodel description:
     * <i>Indicates whether the objects in the flow are gathered from respondents to multicasting.</i>
     */
    @objid ("49ab353e-46a8-4610-94f7-0ab41de1abef")
    boolean isIsMultiReceive();

    /**
     * Setter for attribute 'ObjectFlow.IsMultiReceive'
     *
     * Metamodel description:
     * <i>Indicates whether the objects in the flow are gathered from respondents to multicasting.</i>
     */
    @objid ("8eccd817-4bb0-4e91-927c-1eec8853cbc3")
    void setIsMultiReceive(boolean value);

    /**
     * Getter for attribute 'ObjectFlow.Effect'
     *
     * Metamodel description:
     * <i>Specifies the effect that the owner of the object flow has on values that it represents.</i>
     */
    @objid ("7464ebb7-f30d-4a2d-a6be-7a9594790d80")
    ObjectFlowEffectKind getEffect();

    /**
     * Setter for attribute 'ObjectFlow.Effect'
     *
     * Metamodel description:
     * <i>Specifies the effect that the owner of the object flow has on values that it represents.</i>
     */
    @objid ("1cac7e5a-b225-40ef-8fee-97eba8894be8")
    void setEffect(ObjectFlowEffectKind value);

}
