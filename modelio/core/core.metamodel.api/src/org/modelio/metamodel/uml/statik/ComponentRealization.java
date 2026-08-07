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
 * ComponentRealization v0.0.9054
 *
 *
 * <p>A Component may be realized (or implemented) by a number of Classifiers. In that case, a Component owns a set of ComponentRealizations to these Classifiers.</p>
 *
 *
 */
@objid ("62efa8ac-4b66-4ce6-bc08-86fd413905ce")
public interface ComponentRealization extends UmlModelElement {
    /**
     * The metaclass simple name.
     */
    @objid ("2a1e1044-304b-4abf-a70d-d8252eae7f85")
    public static final String MNAME = "ComponentRealization";

    /**
     * The metaclass qualified name.
     */
    @objid ("ef613961-4794-4cfb-984e-cd096459b61d")
    public static final String MQNAME = "Standard.ComponentRealization";

    /**
     * Getter for relation 'ComponentRealization->RealizingClassifier'
     *
     * Metamodel description:
     * <i>The Classifiers that are involved in the implementation of the Component that owns this Realization.</i>
     */
    @objid ("85fc4f3d-c765-42bd-a48c-e9292426f326")
    Classifier getRealizingClassifier();

    /**
     * Setter for relation 'ComponentRealization->RealizingClassifier'
     *
     * Metamodel description:
     * <i>The Classifiers that are involved in the implementation of the Component that owns this Realization.</i>
     */
    @objid ("4e265714-7e50-4bf5-a704-f00e3ac7ff48")
    void setRealizingClassifier(Classifier value);

    /**
     * Getter for relation 'ComponentRealization->Abstraction'
     *
     * Metamodel description:
     * <i>The Component that owns this ComponentRealization and which is implemented by its realizing Classifiers.
     * </i>
     */
    @objid ("3b99d121-e1a0-488b-8e1a-6a23f557ae4d")
    Component getAbstraction();

    /**
     * Setter for relation 'ComponentRealization->Abstraction'
     *
     * Metamodel description:
     * <i>The Component that owns this ComponentRealization and which is implemented by its realizing Classifiers.
     * </i>
     */
    @objid ("c8da9327-a88b-4103-8b92-da4954eb460b")
    void setAbstraction(Component value);

}
