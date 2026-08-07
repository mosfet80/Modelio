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
import org.modelio.archimate.metamodel.layers.business.BusinessPassiveStructureElement;

/**
 * BusinessObject vnull
 *
 *
 * <p>The ArchiMate language in general focuses on the modeling of&nbsp;types, not instances, since this is the most relevant at the Enterprise Architecture level of&nbsp;description. Hence a business object typically models an object type (cf. a UML class) of which&nbsp;<span style="line-height:1.6">multiple instances may exist in operations. Only occasionally, business objects represent actual&nbsp;</span>instances of information produced and consumed by behavior elements such as business&nbsp;processes. This is in particular the case for singleton types; i.e., types that have only one&nbsp;instance.</p><p>A wide variety of types of business objects can be defined. Business objects are passive in the&nbsp;sense that they do not trigger or perform processes. A business object could be used to represent&nbsp;information assets that are relevant from a business point of view and can be realized by data&nbsp;objects.</p><p>Business objects may be accessed (e.g., in the case of information objects, they may be created,&nbsp;read, written) by a business process, function, business interaction, business event, or business&nbsp;service. A business object may have association, specialization, aggregation, or composition&nbsp;relationships with other business objects. A business object may be realized by a representation&nbsp;or by a data object (or both).</p><p>The name of a business object should preferably be a noun.</p>
 *
 *
 */
@objid ("df532481-a914-4cf4-9685-3f01bcb5b991")
public interface BusinessObject extends BusinessPassiveStructureElement {
    /**
     * The metaclass simple name.
     */
    @objid ("6f664bf9-9723-458c-b5db-d629452c2a33")
    public static final String MNAME = "BusinessObject";

    /**
     * The metaclass qualified name.
     */
    @objid ("479782ac-ed91-4253-98b9-8ced6b9640b6")
    public static final String MQNAME = "Archimate.BusinessObject";

}
