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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * Binding v0.0.9054
 *
 *
 * A Binding is used to define the mapping between the Features of the Collaboration and the Features of the Classifier or Operation in the CollaborationUse.
 *
 * This mapping indicates which connectable element of the Classifier or Operation plays which role(s) in the Collaboration. A connectable element may be bound to multiple roles in the same Collaboration occurrence (that is, it may play multiple roles).
 *
 * In Modelio, a Binding binds an occurrence to an element.  The Binding can be realized (Role->RepresentedFeature) :
 * From a BindableInstance to:
 *    - a BindableInstance
 *    - an Attribute
 *    - a Parameter
 *    - an AssociationEnd
 * From a Connector to:
 *    - an Association
 *    - a Link
 * From a ConnectorEnd to:
 *    - an AssociationEnd
 *    - a LinkEnd
 *
 * This Binding is generally independent of the Model or the Base of the occurrence (that is, it is not necessary to express the type of a role if it is bound to typed elements).
 *
 * In Modelio, a Binding belongs to a CollaborationUse.
 *
 *
 *
 */
@objid ("00015824-c4bf-1fd8-97fe-001ec947cd2a")
public interface Binding extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("8a17cc0d-b704-4033-8515-ba40df4eee27")
    public static final String MNAME = "Binding";

    /**
     * The metaclass qualified name.
     */
    @objid ("c5db5cd4-9cdd-4fa7-947d-dfefab923862")
    public static final String MQNAME = "Standard.Binding";

    /**
     * Getter for relation 'Binding->ConnectorEndRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("02891d77-e185-4a07-9d8d-836892c0aa5e")
    ConnectorEnd getConnectorEndRole();

    /**
     * Setter for relation 'Binding->ConnectorEndRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("111aebfc-44a1-4e44-89bb-bfe353d45656")
    void setConnectorEndRole(ConnectorEnd value);

    /**
     * Getter for relation 'Binding->ConnectorRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("95dce0d5-7283-4146-9357-98e5f626af30")
    NaryConnector getConnectorRole();

    /**
     * Setter for relation 'Binding->ConnectorRole'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("62d9c93b-55d3-4f60-b8ac-2170a701eea9")
    void setConnectorRole(NaryConnector value);

    /**
     * Getter for relation 'Binding->Role'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("5ac5f755-96c5-46fd-a544-85f2f0e9579c")
    BindableInstance getRole();

    /**
     * Setter for relation 'Binding->Role'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("b8e95a5a-e5c5-4797-bd3c-ad1e489f3002")
    void setRole(BindableInstance value);

    /**
     * Getter for relation 'Binding->RepresentedFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("f6ef136e-f5f5-4cfc-a6e1-0cf480b382ce")
    UmlModelElement getRepresentedFeature();

    /**
     * Setter for relation 'Binding->RepresentedFeature'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ddf85581-f044-40ff-b08f-f9b635c6d3fd")
    void setRepresentedFeature(UmlModelElement value);

    /**
     * Getter for relation 'Binding->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("87cca39f-2683-4145-9319-974f19f9e96a")
    CollaborationUse getOwner();

    /**
     * Setter for relation 'Binding->Owner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("ffdfa62a-93bf-4dcc-a195-212ada1f46d0")
    void setOwner(CollaborationUse value);

}
