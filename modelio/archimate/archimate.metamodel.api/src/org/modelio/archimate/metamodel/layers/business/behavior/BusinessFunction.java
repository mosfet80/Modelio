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
 * BusinessFunction vnull
 *
 *
 * <p>Just like a business process, a business function also describes internal behavior performed by a&nbsp;business role. However, while a business process groups behavior based on a sequence or flow&nbsp;of activities that is needed to realize a product or service, a business function typically groups&nbsp;behavior based on required business resources, skills, competences, knowledge, etc.</p><p>There is a potential many-to-many relation between business processes and business functions.</p><p>Complex processes in general involve activities that offer various functions. In this sense a&nbsp;business process forms a string of business functions. In general, a business function delivers&nbsp;added value from a business point of view. Organizational units or applications may coincide&nbsp;with business functions due to their specific grouping of business activities.</p><p>A business function may be triggered by, or trigger, any other business behavior element&nbsp;(business event, business process, business function, or business interaction). A business&nbsp;function may access business objects. A business function may realize one or more business&nbsp;services and may be served by business, application, or technology services. A business role&nbsp;may be assigned to a business function. The name of a business function should clearly indicate&nbsp;a well-defined behavior. Examples are customer management, claims administration, member&nbsp;services, recycling, or payment processing.</p>
 *
 *
 */
@objid ("9db97867-bd63-4f33-b6af-d715e758da37")
public interface BusinessFunction extends BusinessInternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("70b0df55-6d8c-4020-a788-dbb94692c580")
    public static final String MNAME = "BusinessFunction";

    /**
     * The metaclass qualified name.
     */
    @objid ("4ef25176-6379-41e8-a2ac-89a2dc8f312b")
    public static final String MQNAME = "Archimate.BusinessFunction";

}
