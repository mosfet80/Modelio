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
 * Feature v0.0.9054
 *
 *
 * In the metamodel, a Feature declares a behavioral or structural characteristic of an Instance of a Classifier or of the Classifier itself. Properties of a Class can be handled in an abstract way.
 *
 * In Modelio, an AssociationEnd is also a Feature. The name of a Feature corresponds to the name of the role of the opposite related Class.
 *
 * In Modelio, a Feature belongs to its Classifier.
 *
 */
@objid ("000b00cc-c4bf-1fd8-97fe-001ec947cd2a")
public interface Feature extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("4dbb041f-e9b4-4b8a-8543-df61bcee2338")
    public static final String MNAME = "Feature";

    /**
     * The metaclass qualified name.
     */
    @objid ("4c00f18b-ec83-45b4-a94d-0b6c22a007ab")
    public static final String MQNAME = "Standard.Feature";

    /**
     * Getter for attribute 'Feature.Visibility'
     *
     * Metamodel description:
     * <i>Member visibility (public, protected, private, or package).</i>
     */
    @objid ("248555fe-8109-4ff1-a149-ecc3c637e8fe")
    VisibilityMode getVisibility();

    /**
     * Setter for attribute 'Feature.Visibility'
     *
     * Metamodel description:
     * <i>Member visibility (public, protected, private, or package).</i>
     */
    @objid ("33b7edfe-0c0e-4f1e-842c-fa3b49bf655f")
    void setVisibility(VisibilityMode value);

    /**
     * Getter for attribute 'Feature.IsClass'
     *
     * Metamodel description:
     * <i>Specifies a Class member that is shared by all instances of the Class.</i>
     */
    @objid ("69d5d09d-82de-45e0-8925-b5fefc7ee873")
    boolean isIsClass();

    /**
     * Setter for attribute 'Feature.IsClass'
     *
     * Metamodel description:
     * <i>Specifies a Class member that is shared by all instances of the Class.</i>
     */
    @objid ("fb8f0677-1302-471d-95c1-4d5288a1977f")
    void setIsClass(boolean value);

    /**
     * Getter for attribute 'Feature.IsAbstract'
     *
     * Metamodel description:
     * <i>Determines abstract features, that is to say, those not implemented at this level.</i>
     */
    @objid ("4eea4f0c-5549-464e-86ab-ed99a5f25b8a")
    boolean isIsAbstract();

    /**
     * Setter for attribute 'Feature.IsAbstract'
     *
     * Metamodel description:
     * <i>Determines abstract features, that is to say, those not implemented at this level.</i>
     */
    @objid ("13feb4a1-5c33-4402-b624-fc4d89d6929c")
    void setIsAbstract(boolean value);

}
