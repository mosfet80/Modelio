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
package org.modelio.archimate.metamodel.layers.physical.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.TechnologyActiveStructureElement;

/**
 * DistributionNetwork vnull
 *
 *
 * <p>A distribution network represents the physical distribution or transportation infrastructure. It&nbsp;embodies the physical realization of the logical paths between nodes.</p><p>A distribution network connects two or more nodes. A distribution network may realize one or&nbsp;more paths. A distribution network can consist of sub-networks and can aggregate equipment,&nbsp;for example, to model trains that are part of a rail network.</p>
 *
 *
 */
@objid ("68afff26-3239-4ca5-b322-c14ca2eca346")
public interface DistributionNetwork extends TechnologyActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3e2c7fcf-4a70-459b-9515-2cc832562cd7")
    public static final String MNAME = "DistributionNetwork";

    /**
     * The metaclass qualified name.
     */
    @objid ("f5729bf6-89fc-485e-b00d-87ccc529a4b0")
    public static final String MQNAME = "Archimate.DistributionNetwork";

}
