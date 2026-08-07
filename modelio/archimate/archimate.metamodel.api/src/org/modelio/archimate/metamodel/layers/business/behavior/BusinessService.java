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
import org.modelio.archimate.metamodel.core.generic.ExternalBehaviorElement;

/**
 * BusinessService vnull
 *
 *
 * <p>A business service exposes the functionality of business roles or collaborations to their&nbsp;environment. This functionality is accessed through one or more business interfaces. A business&nbsp;service is realized by one or more business processes, business functions, or business&nbsp;interactions that are performed by the business roles or business collaborations, respectively. It&nbsp;may access business objects.</p><p>A business service should provide a unit of behavior that is meaningful from the point of view of&nbsp;the environment. It has a purpose, which states this utility. The environment includes the&nbsp;(behavior of) users from outside as well as inside the organization. Business services can be&nbsp;external, customer-facing services (e.g., a travel insurance service) or internal support services&nbsp;(e.g., a resource management service).</p><p>A business service is associated with a value. A business service may serve a business process,&nbsp;business function, or business interaction. A business process, business function, or business&nbsp;interaction may realize a business service. A business interface may be assigned to a business&nbsp;service. A business service may access business objects.</p><p>The name of a business service should&nbsp;preferably be a verb ending with &#8220;ing&#8221;; e.g., transaction processing. Also, a name explicitly&nbsp;containing the word &#8220;service&#8221; may be used.</p>
 *
 *
 */
@objid ("ec8b7993-6253-4332-be9b-676827c4251b")
public interface BusinessService extends ExternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("e9c9fb09-95b8-4b4d-8b3e-4445f1f4acc9")
    public static final String MNAME = "BusinessService";

    /**
     * The metaclass qualified name.
     */
    @objid ("d320325b-3e47-4cac-95e7-3c1d208001c7")
    public static final String MQNAME = "Archimate.BusinessService";

}
