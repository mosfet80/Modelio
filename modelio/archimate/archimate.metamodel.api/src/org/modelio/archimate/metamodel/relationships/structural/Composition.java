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
package org.modelio.archimate.metamodel.relationships.structural;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Composition vnull
 *
 *
 * <p>The composition relationship has been inspired by the composition relationship in UML class&nbsp;diagrams. In contrast to the aggregation relationship, the composed concept can be part of only&nbsp;one composition.</p><p><strong>A composition relationship is always allowed between two instances of the same element.</strong></p><p>In addition to this, the metamodel explicitly defines other source and target elements that may be&nbsp;connected by a composition relationship.</p>
 *
 *
 */
@objid ("b5d3e633-59c8-4e8c-8ee7-a99a5ad9bd21")
public interface Composition extends StructuralRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("6e62a3f7-aa12-4d56-afaf-0cefe0977c3c")
    public static final String MNAME = "Composition";

    /**
     * The metaclass qualified name.
     */
    @objid ("a25623d6-85c2-4dd3-ba27-ce0571da759d")
    public static final String MQNAME = "Archimate.Composition";

}
