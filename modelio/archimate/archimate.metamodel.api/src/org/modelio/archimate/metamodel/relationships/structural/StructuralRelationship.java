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
import org.modelio.archimate.metamodel.core.Relationship;

/**
 * StructuralRelationship vnull
 *
 *
 * <p>Structural relationships represent the &#39;static&#39; coherence within an architecture. The composing&nbsp;concept (the &#39;from&#39; side of the relationship) is always an element; the composed concept (the&nbsp;&#39;to&#39; side of the relationship) may in some cases also be another relationship.</p><p>As an alternative to the graphical notations proposed in this section, structural relationships may&nbsp;also be expressed by means of nesting of the composed concept within the composing element.</p><p>Note, however, that this can lead to ambiguous models, in case multiple structural relationships&nbsp;are allowed between these elements.</p>
 *
 *
 */
@objid ("6bf3270e-e121-4f64-8c51-62fba49b4e87")
public interface StructuralRelationship extends Relationship {
    /**
     * The metaclass simple name.
     */
    @objid ("dab3362d-f83e-41b6-ba7b-f36b44ea4360")
    public static final String MNAME = "StructuralRelationship";

    /**
     * The metaclass qualified name.
     */
    @objid ("e92ce429-c4b6-4d79-90ce-a67232e8e3de")
    public static final String MQNAME = "Archimate.StructuralRelationship";

}
