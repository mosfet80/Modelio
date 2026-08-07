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
package org.modelio.archimate.metamodel.layers.technology.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Path vnull
 *
 *
 * <p>A path is used to model the logical communication (or distribution) relations between nodes. It is&nbsp;realized by one or more networks, which represent the physical communication (or distribution)&nbsp;links. The properties (e.g., bandwidth, latency) of a path are usually aggregated from these&nbsp;underlying networks.</p><p>A path connects two or more nodes. A path is realized by one or more networks. A path can&nbsp;aggregate nodes.</p>
 *
 *
 */
@objid ("b824078c-2781-48ff-bba6-d0b7a2129601")
public interface Path extends TechnologyActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("3b582ebd-4e40-4e37-8703-bf8fe9513234")
    public static final String MNAME = "Path";

    /**
     * The metaclass qualified name.
     */
    @objid ("a95cdf64-9407-40d2-883e-f8cc6bd437ba")
    public static final String MQNAME = "Archimate.Path";

}
