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
 * Generalization v0.0.9054
 *
 *
 * Each instance of the specific Classifier is also an instance of the general Classifier. Thus, the specific Classifier indirectly has Features of the more general Classifier. Generalization corresponds to the usual Inheritance concept.
 *
 * In Modelio, a Generalization belongs to its SpecializationNameSpace.
 *
 */
@objid ("000c7bb4-c4bf-1fd8-97fe-001ec947cd2a")
public interface Generalization extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("6ae27fa2-5de7-4718-964d-6d49b0f9b1d0")
    public static final String MNAME = "Generalization";

    /**
     * The metaclass qualified name.
     */
    @objid ("8836db6f-39cb-405d-9164-99e1e656901b")
    public static final String MQNAME = "Standard.Generalization";

    /**
     * Getter for attribute 'Generalization.Discriminator'
     *
     * Metamodel description:
     * <i>Designates a family of sub-classes with the same parent Class. The name appears graphically, by linking the Generalizations belonging to this family.</i>
     */
    @objid ("9229d400-8a9f-4967-90fd-903e77c0e468")
    String getDiscriminator();

    /**
     * Setter for attribute 'Generalization.Discriminator'
     *
     * Metamodel description:
     * <i>Designates a family of sub-classes with the same parent Class. The name appears graphically, by linking the Generalizations belonging to this family.</i>
     */
    @objid ("9914d1f0-65d6-4fde-ac98-d7f21d5b6844")
    void setDiscriminator(String value);

    /**
     * Getter for relation 'Generalization->SuperType'
     *
     * Metamodel description:
     * <i>Defines the parent element.</i>
     */
    @objid ("428c06e1-7318-477a-b7a5-ffc155aea297")
    NameSpace getSuperType();

    /**
     * Setter for relation 'Generalization->SuperType'
     *
     * Metamodel description:
     * <i>Defines the parent element.</i>
     */
    @objid ("fbfe44e5-cfcb-49f5-919c-285b27a5bdd5")
    void setSuperType(NameSpace value);

    /**
     * Getter for relation 'Generalization->SubType'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("0f584fbc-de63-41d2-9f20-41c592c3b1bc")
    NameSpace getSubType();

    /**
     * Setter for relation 'Generalization->SubType'
     *
     * Metamodel description:
     * <i>null</i>
     */
    @objid ("7bb22dde-6ba1-4a63-a7ee-c25897503bc1")
    void setSubType(NameSpace value);

}
