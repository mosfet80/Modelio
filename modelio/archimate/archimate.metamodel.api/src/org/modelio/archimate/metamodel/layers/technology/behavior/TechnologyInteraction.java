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
package org.modelio.archimate.metamodel.layers.technology.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * TechnologyInteraction vnull
 *
 *
 * <p>A technology interaction describes the collective behavior that is performed by the nodes that&nbsp;participate in a technology collaboration. This may, for example, include the communication&nbsp;pattern between these components.</p><p>A technology interaction can also specify the externally&nbsp;visible behavior needed to realize a technology service.</p><p>The details of the interaction between&nbsp;the nodes involved in a technology interaction can be expressed during the detailed design using,&nbsp;for example, a UML interaction diagram.</p><p>A technology collaboration may be assigned to a technology interaction.</p><p>A technology&nbsp;interaction may realize a technology service.</p><p>Technology services may serve a technology&nbsp;interaction.</p><p>A technology interaction may access artifacts.</p><p>The name of a technology interaction&nbsp;should clearly identify a series of technology behaviors; e.g., &quot;Client profile creation&quot; or&nbsp;&quot;Update customer records&quot;.</p>
 *
 *
 */
@objid ("7a1361f8-a006-411e-b144-b0cc71958d5f")
public interface TechnologyInteraction extends TechnologyInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("de1a08a3-9a5b-4214-9ae0-acff39e94bc8")
    public static final String MNAME = "TechnologyInteraction";

    /**
     * The metaclass qualified name.
     */
    @objid ("ebecdd91-2ec7-43a0-a733-7b87087ca502")
    public static final String MQNAME = "Archimate.TechnologyInteraction";

}
