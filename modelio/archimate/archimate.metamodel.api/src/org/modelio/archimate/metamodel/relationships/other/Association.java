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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.relationships.other;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.relationships.dependency.DependencyRelationship;

/**
 * Association vnull
 *
 *
 * <p>An association relationship is always allowed between two elements, or between a relationship&nbsp;and an element.</p><p>The association relationship can be used when drawing a first high-level model where&nbsp;relationships are initially denoted in a generic way, and later refined to show more specific&nbsp;relationship types. In the metamodel pictures, some specific uses of the association relationship&nbsp;are explicitly shown.</p>
 *
 *
 */
@objid ("9b59336e-97a2-4ff8-9b4d-53898fda80e7")
public interface Association extends DependencyRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("cbaf4d32-4345-4240-88e3-956e4ed979b8")
    public static final String MNAME = "Association";

    /**
     * The metaclass qualified name.
     */
    @objid ("ca5a0716-3637-44a4-a9de-ebd4b6c8600f")
    public static final String MQNAME = "Archimate.Association";

    /**
     * Getter for attribute 'Association.directed'
     *
     * Metamodel description:
     * <i>Denotes whether the relationship is directed</i>
     */
    @objid ("d675e8c5-e258-4763-a9ce-f7b290c5686d")
    boolean isDirected();

    /**
     * Setter for attribute 'Association.directed'
     *
     * Metamodel description:
     * <i>Denotes whether the relationship is directed</i>
     */
    @objid ("1bd88f87-ffb7-4306-a02c-1ec622a3c722")
    void setDirected(boolean value);

}
