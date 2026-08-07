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
 * CommunicationNetwork vnull
 *
 *
 * <p>A communication network represents the physical communication infrastructure. It represents<em> &quot;a&nbsp;set of products, concepts, and services that enable the connection of computer systems or devices&nbsp;for the purpose of transmitting data and other forms (e.g., voice and video) between the&nbsp;systems&quot;</em>, as defined by the TOGAF framework.</p><p>A communication network connects two or more devices. The most basic communication&nbsp;network is a single link between two devices, but it may comprise multiple links and associated&nbsp;network equipment. A network has properties such as bandwidth and latency. A communication&nbsp;network realizes one or more paths. It embodies the physical realization of the logical path&nbsp;between nodes.</p><p>A communication network can consist of sub-networks. It can aggregate devices and system&nbsp;software, for example, to model the routers, switches, and firewalls that are part of the network&nbsp;infrastructure.</p><p><strong>Note:</strong>&nbsp;Formerly, this element was called &#39;<em>network&#39;</em>. This usage is still permitted but&nbsp;deprecated, and will be removed from a future version of the standard.</p>
 *
 *
 */
@objid ("a1b65486-9d85-4f5c-972d-dcb8fa0e0b27")
public interface CommunicationNetwork extends TechnologyActiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("49dbcca2-cc71-47dc-a0c8-ea082d335b82")
    public static final String MNAME = "CommunicationNetwork";

    /**
     * The metaclass qualified name.
     */
    @objid ("99d6737e-6120-4c69-bb68-95dfb9f20669")
    public static final String MQNAME = "Archimate.CommunicationNetwork";

}
