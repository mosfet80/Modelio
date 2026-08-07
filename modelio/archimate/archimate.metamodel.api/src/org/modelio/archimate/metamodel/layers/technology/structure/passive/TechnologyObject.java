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
package org.modelio.archimate.metamodel.layers.technology.structure.passive;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.PassiveStructureElement;

/**
 * TechnologyObject vnull
 *
 *
 * <p>Technology objects represent the &quot;physical&quot; objects manipulated by the infrastructure of an&nbsp;enterprise. Technology objects are abstract elements; i.e., they are not instantiated in models but&nbsp;serve as the generic type of the things manipulated by the Technology Layer. This may include&nbsp;both artifacts (e.g., files) and physical material.</p><p>Technology objects may be accessed by technology behavior (functions, processes, interactions,&nbsp;events, and services). A technology object may have association, specialization, aggregation, or&nbsp;composition relationships with other technology objects. A technology object may realize a data&nbsp;object or business object. It may be realized by an artifact or material (from the physical&nbsp;elements). The name of a technology object should preferably be a noun.</p>
 *
 *
 */
@objid ("81943db0-811f-4884-969d-4a994319723f")
public interface TechnologyObject extends PassiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f495a626-271e-4002-92d9-53ed86b7892a")
    public static final String MNAME = "TechnologyObject";

    /**
     * The metaclass qualified name.
     */
    @objid ("7b79a1e8-f2ee-4dbc-8bca-4e8002025c7b")
    public static final String MQNAME = "Archimate.TechnologyObject";

}
