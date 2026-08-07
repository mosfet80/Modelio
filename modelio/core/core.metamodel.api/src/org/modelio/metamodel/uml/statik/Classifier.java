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
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.informationFlow.InformationItem;
import org.modelio.metamodel.uml.infrastructure.Substitution;

/**
 * Classifier v0.0.9054
 *
 *
 * A Classifier is an abstract view of the most important metaclasses such as Class, UseCase, Actor, Component and Node.
 *
 * A Classifier notably factorizes the aggregation to Features. The Classifier can act as a structured Classifier (as defined in UML 2.0). In this case, its internal structure, which expresses its configuration in terms of Parts and Ports, is defined through a dedicated Collaboration.
 *
 * A Classifier is owned by a NameSpace.
 *
 */
@objid ("0003645c-c4bf-1fd8-97fe-001ec947cd2a")
public interface Classifier extends NameSpace {
    /**
     * The metaclass simple name.
     */
    @objid ("6a6c09c0-9d3c-4b17-8930-6c511d8ae2d4")
    public static final String MNAME = "Classifier";

    /**
     * The metaclass qualified name.
     */
    @objid ("af99d909-237f-4992-b9d5-5a8a047d5747")
    public static final String MQNAME = "Standard.Classifier";

    /**
     * Getter for relation 'Classifier->OwnedOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("e84af7e1-3665-4b96-9541-929c503281f3")
    EList<Operation> getOwnedOperation();

    /**
     * Filtered Getter for relation 'Classifier->OwnedOperation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1bf1e1e1-6dce-42f8-9bae-6d0517dcd0b8")
    <T extends Operation> List<T> getOwnedOperation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->Representation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ecaa5395-e9d8-40d3-8308-61b33511adad")
    EList<InformationItem> getRepresentation();

    /**
     * Filtered Getter for relation 'Classifier->Representation'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("894351e4-834d-4ebb-a6ba-67b80085ff20")
    <T extends InformationItem> List<T> getRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->Substitued'
     *
     * Metamodel description:
     * <i>Specifies the Classifier to which it can be substituted.</i>
     */
    @objid ("6c42ba39-842a-4065-a2de-f61e60a83c8d")
    EList<Substitution> getSubstitued();

    /**
     * Filtered Getter for relation 'Classifier->Substitued'
     *
     * Metamodel description:
     * <i>Specifies the Classifier to which it can be substituted.</i>
     */
    @objid ("b46cf694-82ae-4622-ac1e-595fff6fba9c")
    <T extends Substitution> List<T> getSubstitued(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->OwnedAttribute'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("98c48f32-92c2-43b5-8d10-d0551fb86f6a")
    EList<Attribute> getOwnedAttribute();

    /**
     * Filtered Getter for relation 'Classifier->OwnedAttribute'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("02461df9-5c75-4f2f-aa98-ef38c96a524b")
    <T extends Attribute> List<T> getOwnedAttribute(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->OwnedNaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3809ee4a-d02d-4c24-923b-7857ea485f61")
    EList<NaryAssociationEnd> getOwnedNaryEnd();

    /**
     * Filtered Getter for relation 'Classifier->OwnedNaryEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d7294b99-2b84-4ffd-9421-8a39dfa084bb")
    <T extends NaryAssociationEnd> List<T> getOwnedNaryEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->Conveyer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("1a211e95-8d63-4117-9f12-943c657b11a2")
    EList<InformationFlow> getConveyer();

    /**
     * Filtered Getter for relation 'Classifier->Conveyer'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f4c3d20d-7b52-4ca1-8b0a-37a610053921")
    <T extends InformationFlow> List<T> getConveyer(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->SubstitutingSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("742dd468-cfa5-4302-adb5-aff32252d002")
    EList<Substitution> getSubstitutingSubstitution();

    /**
     * Filtered Getter for relation 'Classifier->SubstitutingSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5b39e056-5674-4ca3-abcb-f06e64357d42")
    <T extends Substitution> List<T> getSubstitutingSubstitution(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->TargetingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("df23c2cc-1f49-40cb-9e7d-d903431c9280")
    EList<AssociationEnd> getTargetingEnd();

    /**
     * Filtered Getter for relation 'Classifier->TargetingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("306146ea-0057-4819-af4b-9edc3e96fc24")
    <T extends AssociationEnd> List<T> getTargetingEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->OwnedEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("addc0685-833a-402a-8f65-479b0115a81f")
    EList<AssociationEnd> getOwnedEnd();

    /**
     * Filtered Getter for relation 'Classifier->OwnedEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0373534e-1d19-4802-b63c-59c22856f2ce")
    <T extends AssociationEnd> List<T> getOwnedEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->Throwing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a4308924-4133-4167-a02e-09890cbfc0b1")
    EList<RaisedException> getThrowing();

    /**
     * Filtered Getter for relation 'Classifier->Throwing'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0491ee4b-8daf-438a-80a8-96466d06982f")
    <T extends RaisedException> List<T> getThrowing(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->InternalStructure'
     *
     * Metamodel description:
     * <i>Parts owned by the internal structure of the Class. These Parts represent the structure of instances of the Class, once they are instanciated.</i>
     */
    @objid ("17fbcafe-3f1e-4483-8fc2-95bb5ae5a30c")
    EList<BindableInstance> getInternalStructure();

    /**
     * Filtered Getter for relation 'Classifier->InternalStructure'
     *
     * Metamodel description:
     * <i>Parts owned by the internal structure of the Class. These Parts represent the structure of instances of the Class, once they are instanciated.</i>
     */
    @objid ("febfa395-ed7c-43f4-9fcd-610308c9188c")
    <T extends BindableInstance> List<T> getInternalStructure(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'Classifier->RealizedComponent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("24b6ba20-63c7-4c2b-8226-1fe4f9cdb4e9")
    EList<ComponentRealization> getRealizedComponent();

    /**
     * Filtered Getter for relation 'Classifier->RealizedComponent'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b812dcd5-b673-4fca-98d4-8a0d8cac3064")
    <T extends ComponentRealization> List<T> getRealizedComponent(java.lang.Class<T> filterClass);

}
