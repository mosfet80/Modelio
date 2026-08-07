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
package org.modelio.archimate.metamodel.layers.business.structure.passive;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Contract vnull
 *
 *
 * <p>The contract element may be used to model a contract in the legal sense, but also a more&nbsp;informal agreement associated with a product. It may also be or include a Service-Level&nbsp;Agreement (SLA), describing an agreement about the functionality and quality of the services&nbsp;that are part of a product. A contract is a specialization of a business object.</p><p>The relationships that apply to a business object also apply to a contract. In addition, a contract&nbsp;may have an aggregation relationship with a product. The name of a contract is preferably a&nbsp;noun.</p>
 *
 *
 */
@objid ("f769d886-b455-4712-b2d2-8e6794efa48d")
public interface Contract extends BusinessObject {
    /**
     * The metaclass simple name.
     */
    @objid ("a04aa9f5-94fa-4bf2-8461-5dfe3f1a96f2")
    public static final String MNAME = "Contract";

    /**
     * The metaclass qualified name.
     */
    @objid ("54295024-a431-49cf-b827-9656546a933e")
    public static final String MQNAME = "Archimate.Contract";

}
