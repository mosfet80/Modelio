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
 * Assignment vnull
 *
 *
 * <p>The assignment relationship links active structure elements with units of behavior that are&nbsp;performed by them, business actors with business roles that are fulfilled by them, locations with&nbsp;structure elements, and artifacts with nodes. It can, for example, relate an internal active&nbsp;structure element with an internal behavior element, an interface with a service, or a location&nbsp;with an active or passive structure element. The full set of permitted relationships is listed in&nbsp;Appendix B.</p><p>Note that although this notation is not directional, the assignment relationship does have a&nbsp;direction at the metamodel level. In the ArchiMate framework described in Section 3.4, it always&nbsp;points from a location to an active structure element, from active structure to behavior, and from&nbsp;active structure to passive structure. This directionality may optionally be expressed in the&nbsp;notation by omitting the black dot at the source end of the relationship, only showing it at the&nbsp;destination end.</p><p>As with all structural relationships, an assignment relationship can also be expressed by nesting&nbsp;the model elements. The direction mentioned above is also the direction of nesting; for example,&nbsp;a business actor can be drawn inside the location where it resides, a business role inside the&nbsp;business actor performing that role, an application function inside an application component&nbsp;executing that function, or an artifact inside a node that stores it.</p><p>&nbsp;</p><p>The usual interpretation of an assignment relationship is that whole or part of the source element&nbsp;is assigned the whole of the target element. This means that if, for example, two active structure&nbsp;elements are assigned to the same behavior element, either of them can perform the complete&nbsp;behavior. If both active structure elements are needed to perform the behavior, the grouping&nbsp;element or a junction (see Section 5.4.3) can be used, and if the combination of these elements&nbsp;has a more substantive and independent character, a collaboration would be the right way to&nbsp;express this.</p>
 *
 *
 */
@objid ("88f94d90-a22f-46fd-8008-c78a37f159a3")
public interface Assignment extends StructuralRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("c69b5f45-1a92-4189-b68a-ef97903f9159")
    public static final String MNAME = "Assignment";

    /**
     * The metaclass qualified name.
     */
    @objid ("b957e35f-138c-4fe5-b253-63edded912ae")
    public static final String MQNAME = "Archimate.Assignment";

}
