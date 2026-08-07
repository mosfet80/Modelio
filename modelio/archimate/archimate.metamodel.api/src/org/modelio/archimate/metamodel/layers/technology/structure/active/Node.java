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
 * Node vnull
 *
 *
 * <p>Nodes are active structure elements that perform technology behavior and execute, store, and&nbsp;process technology objects such as artifacts (or materials, as outlined in Chapter 11). For&nbsp;instance, nodes are used to model application platforms, defined by the TOGAF framework&nbsp;as: <em>&quot;a collection of technology components of hardware and software that provide the services&nbsp;used to support applications&quot;</em>.</p><p>Nodes can be interconnected by paths. Artifacts can be assigned to (i.e., deployed on) nodes.</p><p>The name of a node should preferably be a noun. A node may consist of sub-nodes.</p><p>Artifacts deployed on a node may either be drawn inside the node or connected to it with an&nbsp;assignment relationship.</p>
 *
 *
 */
@objid ("a5f64b86-e6f6-4f34-95a8-2dd250e0bfed")
public interface Node extends TechnologyInternalActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("655ffb52-9d9f-4f6e-b544-a74e8589277f")
    public static final String MNAME = "Node";

    /**
     * The metaclass qualified name.
     */
    @objid ("85a8f492-b631-48e0-94c1-6986a2773dbf")
    public static final String MQNAME = "Archimate.Node";

}
