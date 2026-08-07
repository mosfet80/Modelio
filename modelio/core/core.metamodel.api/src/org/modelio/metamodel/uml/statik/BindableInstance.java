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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;

/**
 * BindableInstance v0.0.9054
 *
 *
 * A BindableInstance represents the UML 2.0 "Part" concept.  It is an Instance that can be bound to an AssociationEnd, a Parameter or an Instance.
 *
 * The RepresentedFeature is used for every case where Elements need to be represented under a different and more specific configuration. For example, a Port on a Part is bound to the same Port on the Classifier of that Part.  When Attributes are represented as Parts inside a Class and its internal structure, the Part is bound to its representing Attribute.
 *
 * In Modelio, a BindableInstance belongs to an instance, a Classifier internal structure or a Collaboration declared instance.
 *
 */
@objid ("0000aa6e-c4bf-1fd8-97fe-001ec947cd2a")
public interface BindableInstance extends Instance {
    /**
     * The metaclass simple name.
     */
    @objid ("acb4bb7e-751a-4a91-9c04-7b5012c138b7")
    public static final String MNAME = "BindableInstance";

    /**
     * The metaclass qualified name.
     */
    @objid ("f57b3f10-ec59-43c1-a63c-a31a47dd9a4a")
    public static final String MQNAME = "Standard.BindableInstance";

    /**
     * Getter for relation 'BindableInstance->Cluster'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("979dd44d-5ffb-4f47-9c52-b2b17b416338")
    Instance getCluster();

    /**
     * Setter for relation 'BindableInstance->Cluster'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("dc1bac0a-75f2-4550-8119-1e27098e33d6")
    void setCluster(Instance value);

    /**
     * Getter for relation 'BindableInstance->InternalOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0833d8a7-2f0a-47ff-b3c6-49a038474845")
    Classifier getInternalOwner();

    /**
     * Setter for relation 'BindableInstance->InternalOwner'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("85b166d7-7013-4fb4-bb38-223181b517f3")
    void setInternalOwner(Classifier value);

    /**
     * Getter for relation 'BindableInstance->Representation'
     *
     * Metamodel description:
     * <i>Binding between Parts, from a CollaborationUse.</i>
     */
    @objid ("b23bf3a4-99b2-4023-b174-9adf75a419ea")
    EList<Binding> getRepresentation();

    /**
     * Filtered Getter for relation 'BindableInstance->Representation'
     *
     * Metamodel description:
     * <i>Binding between Parts, from a CollaborationUse.</i>
     */
    @objid ("603f80c5-5429-4ab4-95ad-2ebd517311cc")
    <T extends Binding> List<T> getRepresentation(java.lang.Class<T> filterClass);

    /**
     * Getter for relation 'BindableInstance->RepresentedFeature'
     *
     * Metamodel description:
     * <i>Expresses that the Part or Port represents an element from within a more accurate context (such as within an instance or a class internal structure). </i>
     */
    @objid ("3bf5b178-6e3c-403c-b203-8349dea4cf1a")
    UmlModelElement getRepresentedFeature();

    /**
     * Setter for relation 'BindableInstance->RepresentedFeature'
     *
     * Metamodel description:
     * <i>Expresses that the Part or Port represents an element from within a more accurate context (such as within an instance or a class internal structure). </i>
     */
    @objid ("691d07e7-2924-44e9-9d62-1f05e3ffb1ac")
    void setRepresentedFeature(UmlModelElement value);

}
