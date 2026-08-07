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
package org.modelio.metamodel.uml.infrastructure;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.ConnectorEnd;
import org.modelio.metamodel.uml.statik.Manifestation;
import org.modelio.metamodel.uml.statik.NaryConnector;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;

/**
 * UmlModelElement v0.0.9054
 *
 *
 * A ModelElement describes every element that can exist in a model. Only low-level Elements are not ModelElements.
 *
 * ModelElements can be extended by Stereotypes and TaggedValues, can have Notes, can be the origin or target of Dependencies, and can have Constraints.
 *
 */
@objid ("7bd99241-ebad-4f0a-aa75-6ce5e877b315")
public interface UmlModelElement extends ModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("6665ba7d-53cf-4478-9649-701d3b1d49da")
    public static final String MNAME = "UmlModelElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("4c1ae142-10ea-4674-bfee-0f6f3951791d")
    public static final String MQNAME = "Standard.UmlModelElement";

    /**
     * Getter for relation 'UmlModelElement->TemplateSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("918d9bc4-639e-432a-9dac-14615b74efc6")
    EList<TemplateParameterSubstitution> getTemplateSubstitution();

    /**
     * Filtered Getter for relation 'UmlModelElement->TemplateSubstitution'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3d8d388c-c362-4f01-b871-75241a6d8eb3")
    <T extends TemplateParameterSubstitution> List<T> getTemplateSubstitution(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->DefaultParametering'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d96e7f45-73b5-46c9-8d3f-e44ddc7716fa")
    EList<TemplateParameter> getDefaultParametering();

    /**
     * Filtered Getter for relation 'UmlModelElement->DefaultParametering'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("703e8198-4295-4d9f-a0ea-7b86fba94098")
    <T extends TemplateParameter> List<T> getDefaultParametering(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->Represents'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ef74513a-7854-4636-951d-1077fa623761")
    EList<Binding> getRepresents();

    /**
     * Filtered Getter for relation 'UmlModelElement->Represents'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("382e44ff-4401-4c90-bff2-43ea62eaff01")
    <T extends Binding> List<T> getRepresents(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->OwnerTemplateParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d86fbad9-2477-4bbd-aaba-307f765ec390")
    TemplateParameter getOwnerTemplateParameter();

    /**
     * Setter for relation 'UmlModelElement->OwnerTemplateParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5a0b1c3e-69e9-4f41-a93f-10050839bf2d")
    void setOwnerTemplateParameter(TemplateParameter value);

    /**
     * Getter for relation 'UmlModelElement->RepresentingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("d6708ba1-3c84-453d-8e3d-defa0ac2387c")
    EList<ConnectorEnd> getRepresentingEnd();

    /**
     * Filtered Getter for relation 'UmlModelElement->RepresentingEnd'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f3d2edea-bbb8-4295-9ebd-147ff7556a1d")
    <T extends ConnectorEnd> List<T> getRepresentingEnd(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->RepresentingPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("c2441246-ec8f-4d44-b5b6-e5e193f11893")
    EList<ActivityPartition> getRepresentingPartition();

    /**
     * Filtered Getter for relation 'UmlModelElement->RepresentingPartition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("77882846-5a6d-4777-956b-ffe74c026605")
    <T extends ActivityPartition> List<T> getRepresentingPartition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->ConstraintDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("a5e9a373-ca34-44ff-a15f-321c0c14f45a")
    EList<Constraint> getConstraintDefinition();

    /**
     * Filtered Getter for relation 'UmlModelElement->ConstraintDefinition'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("41f93161-7a1d-4a95-8588-4bd71c3deafd")
    <T extends Constraint> List<T> getConstraintDefinition(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->TypingParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("adfb9b46-5517-44cb-962e-394c3e88b079")
    EList<TemplateParameter> getTypingParameter();

    /**
     * Filtered Getter for relation 'UmlModelElement->TypingParameter'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("afd05451-34ce-4934-93c2-a35130960297")
    <T extends TemplateParameter> List<T> getTypingParameter(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->Manifesting'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("3b9b99ed-aa72-4c29-8b0f-dee5c800c596")
    EList<Manifestation> getManifesting();

    /**
     * Filtered Getter for relation 'UmlModelElement->Manifesting'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bf2c22b9-7b85-48c2-b9c6-300676bf6125")
    <T extends Manifestation> List<T> getManifesting(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->RepresentingInstance'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("653b470c-e8f6-4709-b83f-1c87fd7e35e4")
    EList<BindableInstance> getRepresentingInstance();

    /**
     * Filtered Getter for relation 'UmlModelElement->RepresentingInstance'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("04a7b3df-ed12-48ba-b19d-b71127db9302")
    <T extends BindableInstance> List<T> getRepresentingInstance(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->ReceivedInfo'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("80aee9bc-904c-48ef-8bce-c7b19f671d44")
    EList<InformationFlow> getReceivedInfo();

    /**
     * Filtered Getter for relation 'UmlModelElement->ReceivedInfo'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("52e9777f-ca68-42ef-a408-2a37e77f237a")
    <T extends InformationFlow> List<T> getReceivedInfo(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->SentInfo'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("4c627e4b-6b82-4ff6-ba21-91635ebe9a00")
    EList<InformationFlow> getSentInfo();

    /**
     * Filtered Getter for relation 'UmlModelElement->SentInfo'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("bbf8f13e-810e-40f7-8671-5636c00a6103")
    <T extends InformationFlow> List<T> getSentInfo(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'UmlModelElement->RepresentingConnector'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("9cf6e629-7b13-4c86-96ef-20a4dd3b864a")
    EList<NaryConnector> getRepresentingConnector();

    /**
     * Filtered Getter for relation 'UmlModelElement->RepresentingConnector'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b83040f9-97ff-4319-9ee2-5041abcba718")
    <T extends NaryConnector> List<T> getRepresentingConnector(java.lang.Class<T> filterClass);

}
