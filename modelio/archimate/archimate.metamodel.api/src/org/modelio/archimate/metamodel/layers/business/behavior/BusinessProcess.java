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
package org.modelio.archimate.metamodel.layers.business.behavior;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.business.BusinessInternalBehaviorElement;

/**
 * BusinessProcess vnull
 *
 *
 * <p>A business process describes the internal behavior performed by a business role that is required&nbsp;to produce a set of products and services. For a consumer, the products and services are relevant&nbsp;and the required behavior is merely a black box, hence the designation &quot;internal&quot;.</p><p>A complex business process may be an aggregation of other, finer-grained processes, each of&nbsp;which may be assigned to finer-grained roles that are aggregated by roles that are aggregated by&nbsp;the original role.</p><p>There is a potential many-to-many relationship between business processes and business&nbsp;functions. Informally speaking, processes describe some kind of &quot;flow&quot; of activities, whereas&nbsp;functions group activities according to required skills, knowledge, resources, etc.</p><p>A business process may be triggered by, or trigger, any other business behavior element (e.g.,&nbsp;business event, business process, business function, or business interaction). A business process&nbsp;may access business objects. A business process may realize one or more business services and&nbsp;may use (internal) business services or application services. A business role or an application&nbsp;component may be assigned to a business process to perform this process manually or&nbsp;automated, respectively. The name of a business process should clearly indicate a predefined&nbsp;sequence of actions, and may include the word &quot;process&quot;. Examples are &quot;adjudicate claim&quot;,&nbsp;&quot;employee on-boarding&quot;, &quot;approval process&quot;, or &quot;financial reporting&quot;.</p><p>In an ArchiMate model, the existence of business processes is depicted. High-level business,&nbsp;end-to-end processes, macro flows, and workflows can all be expressed with the same business&nbsp;process element in the ArchiMate language. It does not, however, list the flow of activities in</p><p>detail. This is typically done during business process modeling, where a business process can be&nbsp;expanded using a business process design language; e.g., BPMN</p><p>&nbsp;</p>
 *
 *
 */
@objid ("7ecb1573-7ab8-4555-911f-3ae8a28a2b09")
public interface BusinessProcess extends BusinessInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("debf6f68-d228-4344-96df-703a611221c4")
    public static final String MNAME = "BusinessProcess";

    /**
     * The metaclass qualified name.
     */
    @objid ("972c3b30-d5bf-4a5e-90ea-564e6a62c799")
    public static final String MQNAME = "Archimate.BusinessProcess";

}
