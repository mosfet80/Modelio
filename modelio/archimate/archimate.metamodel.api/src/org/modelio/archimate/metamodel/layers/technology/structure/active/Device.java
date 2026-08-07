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
 * Device vnull
 *
 *
 * <p>A device is a specialization of a node that represents a physical IT resource with processing&nbsp;capability. It is typically used to model hardware systems such as mainframes, PCs, or routers.</p><p>Usually, they are part of a node together with system software. Devices may be composite; i.e.,&nbsp;consist of sub-devices.</p><p>Devices can be interconnected by networks. Devices can be assigned to artifacts and to system&nbsp;software, to model that artifacts and system software are deployed on that device.</p><p>A node can&nbsp;contain one or more devices.</p><p>The name of a device should preferably be a noun referring to the type of hardware; e.g., &quot;IBM&nbsp;System z mainframe&quot;.</p><p>Different icons may be used to distinguish between different types of devices; e.g. mainframes&nbsp;and PCs.</p>
 *
 *
 */
@objid ("6e4837fe-6abf-4cf3-99b2-cc91d0c8eb05")
public interface Device extends Node {
    /**
     * The metaclass simple name.
     */
    @objid ("77ef6277-d4c3-4976-b7dd-e56126c6edb3")
    public static final String MNAME = "Device";

    /**
     * The metaclass qualified name.
     */
    @objid ("9d22c60a-8529-4939-b3ca-ae75d3bb7fce")
    public static final String MQNAME = "Archimate.Device";

}
