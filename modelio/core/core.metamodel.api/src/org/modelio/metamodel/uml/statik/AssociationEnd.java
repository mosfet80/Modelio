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
package org.modelio.metamodel.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;

/**
 * AssociationEnd v0.0.9054
 *
 *
 * An AssociationEnd is an endpoint of an Association, which connects the Association to a Classifier. Each AssociationEnd is part of one Association.
 *
 * When the Association is navigable, this link is considered to be a property of the connected Class. It is thus a Feature in the same way as Attributes or Operations.
 *
 * An Association is linked to several Classes via AssociationEnds, which determine roles, multiplicities and navigabilities. The connected Classifier is defined by the usual composition link from Classifier to Feature.
 *
 * In Modelio, an AssociationEnd is a Feature of a Class.
 *
 */
@objid ("00974ea6-c4be-1fd8-97fe-001ec947cd2a")
public interface AssociationEnd extends StructuralFeature {
    /**
     * The metaclass simple name.
     */
    @objid ("ebb42c5d-2ac7-4983-8149-796d92be851b")
    public static final String MNAME = "AssociationEnd";

    /**
     * The metaclass qualified name.
     */
    @objid ("2de6557c-f46c-4841-974f-7b49cc8fcec7")
    public static final String MQNAME = "Standard.AssociationEnd";

    /**
     * Get the 'graphical owner' related to this end.
     * The owner is the current source or the opposite end's target according to the navigability.
     */
    @objid ("1bfd0899-45a2-49c8-b8dc-083141e68be2")
    abstract Classifier getOwner();

    /**
     * Sets both ends sources and targets according to the given navigability.
     * <ul>
     * <li>THISSIDE: only current source and target must be filled.</li>
     * <li>OHERSIDE: only opposite source and target must be filled.</li>
     * <li>BOTHSIDES: current source must be equals to opposite target as well as current target and opposite source.</li>
     * <li>NONE: both sources must be filled, but no target</li>
     * </ul>
     *
     * @param value whether or not to synchronize the other end and both source/target values. This end will be made navigable whatever the current navigability is.
     */
    @objid ("00788250-28da-1080-943a-001ec947cd2a")
    abstract void setNavigable(boolean value);

    /**
     * Sets the value of the 'target' dependency.
     *
     * @param fixModel whether or not to synchronize the other end and both source/target values. This end will be made navigable whatever the current navigability is.
     */
    @objid ("00308234-28fb-1080-943a-001ec947cd2a")
    abstract void setTarget(Classifier value, boolean fixModel);

    /**
     * Sets the value of the 'source' dependency.
     *
     * @param fixModel whether or not to synchronize the other end and both source/target values. This end will be made navigable whatever the current navigability is.
     */
    @objid ("000bdc7c-291a-1080-943a-001ec947cd2a")
    abstract void setSource(Classifier value, boolean fixModel);

    @objid ("44b82fff-5b39-4aaa-ac0d-ddb26b837ecd")
    abstract boolean isNavigable();

    /**
     * Getter for attribute 'AssociationEnd.Aggregation'
     *
     * Metamodel description:
     * <i>This attribute is used to distinguish between normal Associations (KindIsAssociation), shared aggregation (KindIsAggregation) and strong aggregations (KindIsComposition)</i>
     */
    @objid ("2d64c15d-3e60-4ce3-bc5b-0dd9cb5c2cf8")
    AggregationKind getAggregation();

    /**
     * Setter for attribute 'AssociationEnd.Aggregation'
     *
     * Metamodel description:
     * <i>This attribute is used to distinguish between normal Associations (KindIsAssociation), shared aggregation (KindIsAggregation) and strong aggregations (KindIsComposition)</i>
     */
    @objid ("13eefde2-2055-4c10-841f-79cb3db604ff")
    void setAggregation(AggregationKind value);

    /**
     * Getter for attribute 'AssociationEnd.IsChangeable'
     *
     * Metamodel description:
     * <i>When placed on a target end, specifies whether an instance of the Association may be modified from the source end.</i>
     */
    @objid ("e72cb8a0-8e15-4a0e-aa53-db0200401d93")
    boolean isIsChangeable();

    /**
     * Setter for attribute 'AssociationEnd.IsChangeable'
     *
     * Metamodel description:
     * <i>When placed on a target end, specifies whether an instance of the Association may be modified from the source end.</i>
     */
    @objid ("31931ab0-5d94-4b47-9021-3f68a3f49b45")
    void setIsChangeable(boolean value);

    /**
     * Getter for relation 'AssociationEnd->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e898eaa7-c170-470d-a847-2ab662268d8b")
    Classifier getTarget();

    /**
     * Setter for relation 'AssociationEnd->Target'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b03ee96a-4430-4a13-966d-3b593488c9c9")
    void setTarget(Classifier value);

    /**
     * Getter for relation 'AssociationEnd->OppositeOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("27ea284a-01d3-46e6-86e3-551c389740b0")
    AssociationEnd getOppositeOwner();

    /**
     * Setter for relation 'AssociationEnd->OppositeOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("208cc314-9a12-410c-8a1b-48a9a5529140")
    void setOppositeOwner(AssociationEnd value);

    /**
     * Getter for relation 'AssociationEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("945d4d97-ef14-4eab-8d55-12a5fdc52f2d")
    Classifier getSource();

    /**
     * Setter for relation 'AssociationEnd->Source'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ca5d1ca4-31c8-4e2d-937b-a393b6c7a0e8")
    void setSource(Classifier value);

    /**
     * Getter for relation 'AssociationEnd->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5e266ec2-1bac-4cff-a740-c201a6fa9ce6")
    EList<LinkEnd> getOccurence();

    /**
     * Filtered Getter for relation 'AssociationEnd->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3e30bf05-68b4-4996-adb5-416772d6f699")
    <T extends LinkEnd> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'AssociationEnd->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2c727e28-6182-4299-8829-a35b1695dfdd")
    EList<InformationFlow> getSent();

    /**
     * Filtered Getter for relation 'AssociationEnd->Sent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7a58c5eb-8662-4013-a269-43fa4ef3356d")
    <T extends InformationFlow> List<T> getSent(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'AssociationEnd->Qualifier'
     *
     * Metamodel description:
     * <i>Defines a Qualifier on the AssociationEnd. </i>
     */
    @objid ("33b3cc74-cb51-4f74-a9c9-a9da6b8482f7")
    EList<Attribute> getQualifier();

    /**
     * Filtered Getter for relation 'AssociationEnd->Qualifier'
     *
     * Metamodel description:
     * <i>Defines a Qualifier on the AssociationEnd. </i>
     */
    @objid ("7752902f-d3be-45f5-923c-0da63d5933f3")
    <T extends Attribute> List<T> getQualifier(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'AssociationEnd->Opposite'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("86be9ac7-46b8-4279-9ac5-d2c5b79f8799")
    AssociationEnd getOpposite();

    /**
     * Setter for relation 'AssociationEnd->Opposite'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("6c199d89-0a33-4bce-a72b-da054e7d7696")
    void setOpposite(AssociationEnd value);

    /**
     * Getter for relation 'AssociationEnd->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("45129ca2-dd98-46b8-b696-e7c22a45b2e4")
    EList<ObjectNode> getRepresentingObjectNode();

    /**
     * Filtered Getter for relation 'AssociationEnd->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("2e086cbc-eb58-4575-bcd4-e8343a74efa4")
    <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'AssociationEnd->Association'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("890093e4-8a9a-419f-bd87-1941f3da747d")
    Association getAssociation();

    /**
     * Setter for relation 'AssociationEnd->Association'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("70dd1010-4856-4efe-9d18-2385eaa5a30d")
    void setAssociation(Association value);

}
