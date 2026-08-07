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
 * BusinessRole vnull
 *
 *
 * <p>Business processes or business functions are assigned to business roles with certain&nbsp;responsibilities or skills.</p><p>A business actor that is assigned to a business role is responsible that&nbsp;the corresponding behavior is carried out, either by performing it or by delegating and managing&nbsp;its performance.</p><p>In addition to the relation of a business role with behavior, a business role is&nbsp;also useful in a (structural) organizational sense; for instance, in the division of labor within an&nbsp;organization.</p><p>A business role may be assigned to one or more business processes or business functions, while&nbsp;a business actor may be assigned to one or more business roles.</p><p>A business interface or an&nbsp;application interface may serve a business role, while a business interface may be part of a&nbsp;business role (through a composition relationship, which is not shown explicitly in the interface&nbsp;notation).</p><p>The name of a business role should preferably be a noun.</p>
 *
 *
 */
@objid ("87ec6495-1e32-459a-b50e-49dae46cfbb0")
public interface BusinessRole extends BusinessInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("ffdd6a80-8072-4ec5-a3b8-fc9591845237")
    public static final String MNAME = "BusinessRole";

    /**
     * The metaclass qualified name.
     */
    @objid ("7c4e9050-8364-4133-a8a6-52ec1a06d9d9")
    public static final String MQNAME = "Archimate.BusinessRole";

}
