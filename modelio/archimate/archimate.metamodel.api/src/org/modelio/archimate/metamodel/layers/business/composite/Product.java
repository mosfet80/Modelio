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
package org.modelio.archimate.metamodel.layers.business.composite;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.composite.CompositeElement;

/**
 * Product vnull
 *
 *
 * <p>This definition covers both intangible, services-based, or information products that are common&nbsp;in information-intensive organizations, and tangible, physical products.</p><p>A financial or&nbsp;information product consists of a collection of services, and a contract that specifies the&nbsp;characteristics, rights, and requirements associated with the product. &quot;Buying&quot; a product gives&nbsp;the customer the right to use the associated services.</p><p>Generally, the product element is used to specify a product <em>type</em>. The number of product types in&nbsp;an organization is typically relatively stable compared to, for example, the processes that realize&nbsp;or support the products. &quot;Buying&quot; is usually one of the services associated with a product, which&nbsp;results in a new instance of that product (belonging to a specific customer). Similarly, there may&nbsp;be services to modify or destroy a product.</p><p>A product may aggregate or compose business services, application services, and technology&nbsp;services, business objects, data objects, and technology objects, as well as a contract. Hence a&nbsp;product may aggregate or compose elements from other layers than the Business Layer.</p><p>A value may be associated with a product. The name of a product is usually the name which is&nbsp;used in the communication with customers, or possibly a more generic noun (e.g., &quot;travel&nbsp;insurance&quot;).</p>
 *
 *
 */
@objid ("be7be839-ff6d-47a8-bfa0-6f00572eb5ae")
public interface Product extends CompositeElement {
    /**
     * The metaclass simple name.
     */
    @objid ("9f8997f6-0dc0-4cdc-8ddb-e782cdd92383")
    public static final String MNAME = "Product";

    /**
     * The metaclass qualified name.
     */
    @objid ("1b261b8a-b375-4ec8-822b-c619c878b534")
    public static final String MQNAME = "Archimate.Product";

}
