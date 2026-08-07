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
package org.modelio.archimate.metamodel.layers.strategy.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Capability vnull
 *
 *
 * <p>In the field of business, strategic thinking and planning delivers strategies and high-level goals&nbsp;that are often not directly implementable in the architecture of an organization. These long-term&nbsp;or generic plans need to be specified and made actionable in a way that both business leaders&nbsp;and Enterprise Architects can relate to and at a relatively high abstraction level.</p><p>Capabilities help to reduce this gap by focusing on business outcomes. On the one hand, they&nbsp;provide a high-level view of the current and desired abilities of an organization, in relation to its&nbsp;strategy and its environment. On the other hand, they are realized by various elements (people,&nbsp;processes, systems, and so on) that can be described, designed, and implemented using&nbsp;Enterprise Architecture approaches. Capabilities may also have influence relationships; for&nbsp;example, to denote that one capability contributes to another.</p><p>Capabilities are expressed in general and high-level terms and are typically realized by a&nbsp;combination of organization, people, processes, information, and technology. For example,&nbsp;marketing, customer contact, or outbound telemarketing [4].</p><p>Capabilities are typically aimed at achieving some goal or delivering value by realizing an&nbsp;outcome. Capabilities are themselves realized by core elements. To denote that a set of core&nbsp;elements together realizes a capability, grouping can be used.</p><p>Capabilities are often used for capability-based planning, to describe their evolution over time.</p><p>To model such so-called capability increments, the specialization relationship can be used to&nbsp;denote that a certain capability increment is a specific version of that capability. Aggregating&nbsp;those increments and the core elements that realize them in plateaus (see Section 13.2.4) can be&nbsp;used to model the evolution of the capabilities.</p>
 *
 *
 */
@objid ("94a333df-1425-4571-8d63-9a0b872f03bb")
public interface Capability extends StrategyBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("e7f5dd34-0cd7-438c-9eef-93e981127223")
    public static final String MNAME = "Capability";

    /**
     * The metaclass qualified name.
     */
    @objid ("2b564b00-7bc3-4d48-8c69-2ec5ab30a204")
    public static final String MQNAME = "Archimate.Capability";

}
