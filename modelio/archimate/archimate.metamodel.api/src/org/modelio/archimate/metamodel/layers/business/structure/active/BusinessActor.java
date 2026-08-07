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
package org.modelio.archimate.metamodel.layers.business.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalActiveStructureElement;

/**
 * BusinessActor vnull
 *
 *
 * <p>A business actor is a business entity as opposed to a technical entity; i.e., it belongs to the&nbsp;Business Layer. Actors may, however, include entities outside the actual enterprise; e.g.,&nbsp;customers and partners. A business actor can represent such business entities at different levels&nbsp;of detail, and may correspond to both an actor and an organizational unit in the TOGAF&nbsp;framework [4]. Examples of business actors are humans, departments, and business units.</p><p>A business actor may be assigned to one or more business roles. It can then perform the behavior&nbsp;assigned to (one or more) business roles. The name of a business actor should preferably be a&nbsp;noun. Business actors may be specific individuals or organizations; e.g., &quot;John Smith&quot; or &quot;ABC&nbsp;Corporation&quot;, or they may be generic; e.g., &quot;Customer&quot; or &quot;Supplier&quot;.</p>
 *
 *
 */
@objid ("674a3321-e477-452c-b0e5-f4f824ca8b09")
public interface BusinessActor extends BusinessInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("87d74400-2e5c-4566-928b-f03b1e757925")
    public static final String MNAME = "BusinessActor";

    /**
     * The metaclass qualified name.
     */
    @objid ("adc02a7f-39d3-4f4d-a057-9d753670b56f")
    public static final String MQNAME = "Archimate.BusinessActor";

}
