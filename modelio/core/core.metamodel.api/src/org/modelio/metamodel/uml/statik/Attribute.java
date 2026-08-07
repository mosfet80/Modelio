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

/**
 * Attribute v0.0.9054
 *
 *
 * An Attribute is a named slot within a Classifier that describes a range of values that instances of the Classifier may hold.
 *
 * In Modelio, an Attribute belongs to a Classifier as a Feature or to an AssociationEnd as a Qualifier.
 *
 */
@objid ("0097ec08-c4be-1fd8-97fe-001ec947cd2a")
public interface Attribute extends StructuralFeature {
    /**
     * The metaclass simple name.
     */
    @objid ("16e89258-9089-4fa5-8efe-23c2c71672af")
    public static final String MNAME = "Attribute";

    /**
     * The metaclass qualified name.
     */
    @objid ("f1845bac-9fc4-4d0d-ad62-bb3976342ccd")
    public static final String MQNAME = "Standard.Attribute";

    /**
     * Getter for attribute 'Attribute.TypeConstraint'
     *
     * Metamodel description:
     * <i>Provides an indication of the instanciation of the Attribute's elementary class. For example, in the case of an attribute string, TypeConstraint determines the size of the string (*, 10, etc.).</i>
     */
    @objid ("670920a2-2dd6-44ee-9ed1-baf27350ccaf")
    String getTypeConstraint();

    /**
     * Setter for attribute 'Attribute.TypeConstraint'
     *
     * Metamodel description:
     * <i>Provides an indication of the instanciation of the Attribute's elementary class. For example, in the case of an attribute string, TypeConstraint determines the size of the string (*, 10, etc.).</i>
     */
    @objid ("8ec7bf34-3616-485a-9df1-99778223ec1b")
    void setTypeConstraint(String value);

    /**
     * Getter for attribute 'Attribute.Value'
     *
     * Metamodel description:
     * <i>Default value of the Attribute. This value is assigned at creation time, unless a specific value is specified.</i>
     */
    @objid ("042e21b2-43df-422a-bf90-c2a944064b30")
    String getValue();

    /**
     * Setter for attribute 'Attribute.Value'
     *
     * Metamodel description:
     * <i>Default value of the Attribute. This value is assigned at creation time, unless a specific value is specified.</i>
     */
    @objid ("1870bab6-6c83-4244-a8ee-a7ceafc9727e")
    void setValue(String value);

    /**
     * Getter for attribute 'Attribute.TargetIsClass'
     *
     * Metamodel description:
     * <i>Determines that the target is itself a metaclass.</i>
     */
    @objid ("6b7590e7-613c-4c0e-9499-04bc261bcdfb")
    boolean isTargetIsClass();

    /**
     * Setter for attribute 'Attribute.TargetIsClass'
     *
     * Metamodel description:
     * <i>Determines that the target is itself a metaclass.</i>
     */
    @objid ("4c30645f-bdfe-4e57-a9c5-0918a6d2feb3")
    void setTargetIsClass(boolean value);

    /**
     * Getter for relation 'Attribute->Type'
     *
     * Metamodel description:
     * <i>Determines which Class is the Attribute's type.</i>
     */
    @objid ("187ee829-5acb-4e0a-b1ba-2a02e3649fb9")
    GeneralClass getType();

    /**
     * Setter for relation 'Attribute->Type'
     *
     * Metamodel description:
     * <i>Determines which Class is the Attribute's type.</i>
     */
    @objid ("6801c5dd-d58f-4ad2-a47e-24a22ab731ee")
    void setType(GeneralClass value);

    /**
     * Getter for relation 'Attribute->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ac9139ea-5797-41ce-bad1-b12a57fa83d6")
    Classifier getOwner();

    /**
     * Setter for relation 'Attribute->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("55d44698-e4d3-419b-9fda-9890ed881019")
    void setOwner(Classifier value);

    /**
     * Getter for relation 'Attribute->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("861b9598-5cbd-4638-ad32-7a3c7086834f")
    EList<AttributeLink> getOccurence();

    /**
     * Filtered Getter for relation 'Attribute->Occurence'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9395d022-70bd-4a61-a6a5-295f5ff71e5e")
    <T extends AttributeLink> List<T> getOccurence(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Attribute->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("8f62d47b-588b-49d7-ace8-e2c2e2c3ae2d")
    EList<ObjectNode> getRepresentingObjectNode();

    /**
     * Filtered Getter for relation 'Attribute->RepresentingObjectNode'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("eb1faaee-ed22-4700-89d2-11c6100afa53")
    <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Attribute->Qualified'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1a3baf07-1dc5-4b34-bc73-fa8a8ff0aac3")
    AssociationEnd getQualified();

    /**
     * Setter for relation 'Attribute->Qualified'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("eeacd881-44f4-41bd-a8a6-4067d8acdd21")
    void setQualified(AssociationEnd value);

}
