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
 * Aggregation vnull
 *
 *
 * <p>The aggregation relationship indicates that an element groups a number of other elements.</p><p>The aggregation relationship has been inspired by the aggregation relationship in UML class&nbsp;diagrams. In contrast to the composition relationship, an object can be part of more than one&nbsp;aggregation.</p><p><strong>An aggregation relationship is always allowed between two instances of the same element.</strong></p><p>In addition to this, the metamodel explicitly defines other source and target elements that may be&nbsp;connected by an aggregation relationship.</p>
 *
 *
 */
@objid ("fd649baa-1fe5-4169-a912-d9cbdf83c291")
public interface Aggregation extends StructuralRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("cb577232-7b21-407f-86d7-d11ed028947e")
    public static final String MNAME = "Aggregation";

    /**
     * The metaclass qualified name.
     */
    @objid ("45458716-aa8a-46be-948f-12db6f2b46f2")
    public static final String MQNAME = "Archimate.Aggregation";

}
