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
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;

/**
 * Equipment vnull
 *
 *
 * <p>Equipment comprises all active processing elements that carry out physical processes in which&nbsp;materials (which are a special kind of technology object) are used or transformed. Equipment is&nbsp;a specialization of the node element from the Technology Layer. Therefore, it is possible to&nbsp;model nodes that are formed by a combination of IT infrastructure (devices, system software)&nbsp;and physical infrastructure (equipment); e.g., an MRI scanner at a hospital, a production plant&nbsp;with its control systems, etc.</p><p>Material can be accessed (e.g., created, used, stored, moved, or transformed) by equipment.</p><p>Equipment can serve other equipment, and also other active structure elements such as business&nbsp;roles and actors, and locations and facilities can be assigned to equipment. A piece of equipment&nbsp;can be composed of other pieces of equipment.</p><p>The name of a piece of equipment should preferably be a noun.</p>
 *
 *
 */
@objid ("9734acbb-d416-4878-999d-206ca621d7da")
public interface Equipment extends Node {
    /**
     * The metaclass simple name.
     */
    @objid ("47951872-ebda-42f4-8487-a5387581e544")
    public static final String MNAME = "Equipment";

    /**
     * The metaclass qualified name.
     */
    @objid ("52b35326-33f5-4c81-8702-1d4a51035f71")
    public static final String MQNAME = "Archimate.Equipment";

}
