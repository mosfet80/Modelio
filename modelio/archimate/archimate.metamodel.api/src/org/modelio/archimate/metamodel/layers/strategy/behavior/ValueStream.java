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
 * ValueStream vnull
 *
 *
 * <p>A value stream describes how an enterprise organizes its activities to create value. As described in the TOGAF Series Guide: Value Streams, a key principle of value streams is that value is always defined from the perspective of the stakeholder, the customer, end user, or recipient of the product, service, or deliverable produced by the work. The value obtained is in the eye of the beholder; it depends more on the stakeholder&#39;s perception of the worth of the product, service, outcome, or deliverable than on its intrinsic value; i.e., the cost to produce. This is modeled in the ArchiMate language using the value element. This, in turn, is associated with on the one hand the result being produced, and on the other hand may be associated with the stakeholder.</p><p>Value streams can be defined at different levels of the organization; e.g., at the enterprise level, business unit level, or department level. Value streams can be a composition or aggregation of sub-streams, usually called value (stream) stages, where each stage should have a clear value contribution of its own. These stages are typically related using flow relationships to model the flow of value between them. Resources can be assigned to value streams and capabilities can serve (i.e., enable) a value stream.</p><p>Importantly, value streams and business processes may seem alike, but they are defined at different abstraction levels and serve separate purposes. A business process describes the (time-ordered) sequence of behaviors required to create some result for an individual case, and it may describe alternative paths and decision points (modeled with junctions). In contrast, a value stream focuses on the overall value-creating behavior from the perspective of the importance, worth, or usefulness of what is produced, and is not a description of time-ordered tasks for individual cases. Value streams (and capabilities) reflect an organization&#39;s business model and value proposition, whereas business processes (and business functions) reflect its operating model. At their respective abstraction levels, value streams and business processes both represent the &quot;enterprise in motion&quot; whereas capabilities and business functions both describe the &quot;enterprise at rest&quot;.</p><p>Value streams are typically realized by business processes and possibly other core behavior elements. The stages in a value stream provide a framework for organizing and defining busines processes, but different parts of the organization may have their own implementations of business processes that realize the same value stream stage. Conversely, one business process may realize multiple stages in a value stream.</p>
 *
 *
 */
@objid ("2e1fd6a0-7893-4a2b-b3ed-1b3f87e24e8f")
public interface ValueStream extends StrategyBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("301dd769-7f41-402b-8637-d8a4087c96fd")
    public static final String MNAME = "ValueStream";

    /**
     * The metaclass qualified name.
     */
    @objid ("e41599b3-e852-466a-a5ee-6d6c95087336")
    public static final String MQNAME = "Archimate.ValueStream";

}
