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

/**
 * Artifact vnull
 *
 *
 * <p>An <em>artifact</em> represents a tangible element in the IT world.</p><p>Artifact is a specialization of&nbsp;technology object.</p><p>It is typically used to model (software) products such as source files,&nbsp;executables, scripts, database tables, messages, documents, specifications, and model files.</p><p>An&nbsp;instance (copy) of an artifact can be deployed on a <em>node</em>. An artifact could be used to represent a&nbsp;physical data component that realizes a data object.</p><p>The artifact element has been taken from UML.</p><p>An application component or system software may be realized by one or more artifacts.</p><p>A data&nbsp;object may be realized by one or more artifacts.</p><p>A node may be assigned to an artifact (i.e., the&nbsp;artifact is deployed on the node). Thus, the two typical ways to use the artifact element are as an&nbsp;<em>execution component</em> or as a <em>data file</em>. In fact, these could be defined as specializations of the&nbsp;artifact element.</p><p>The name of an artifact should preferably be the name of the file it represents; e.g., &quot;order.jar&quot;.</p><p>An artifact may consist of sub-artifacts.</p>
 *
 *
 */
@objid ("04a0cbc7-df2b-4e0b-94fd-afadd3489ed5")
public interface Artifact extends TechnologyObject {
    /**
     * The metaclass simple name.
     */
    @objid ("50e7b5c5-bb71-4248-baf5-348b298418d5")
    public static final String MNAME = "Artifact";

    /**
     * The metaclass qualified name.
     */
    @objid ("d67cff21-8117-4d1e-8ea3-e229f10f89d7")
    public static final String MQNAME = "Archimate.Artifact";

}
