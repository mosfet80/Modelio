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
 * SystemSoftware vnull
 *
 *
 * <p>System software is a specialization of a node that is used to model the software environment in&nbsp;which artifacts run. This can be, for example, an operating system, a JEE application server, a&nbsp;database system, or a workflow engine. Also, system software can be used to represent, for&nbsp;example, communication middleware. Usually, system software is combined with a device&nbsp;representing the hardware environment to form a general node.</p><p>System software can be assigned to a device and to other system software; e.g., to model&nbsp;different layers of software running on top of each other. Artifacts can be assigned to (i.e.,&nbsp;deployed on) system software, and realize system software. A node can contain system software.</p><p>The name of system software should preferably be a noun referring to the type of execution&nbsp;environment; e.g., &quot;J2EE server&quot;. System software may contain other system software; e.g., an&nbsp;operating system containing a database.</p>
 *
 *
 */
@objid ("48003186-432d-4fa7-a9e8-e66c107a6056")
public interface SystemSoftware extends Node {
    /**
     * The metaclass simple name.
     */
    @objid ("3c2f9b67-6c40-4260-9608-9236859aed57")
    public static final String MNAME = "SystemSoftware";

    /**
     * The metaclass qualified name.
     */
    @objid ("66eb62e6-50fc-4c04-ae7e-795d077e7ece")
    public static final String MQNAME = "Archimate.SystemSoftware";

}
