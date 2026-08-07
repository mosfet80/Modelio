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
package org.modelio.archimate.metamodel.layers.business;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.InternalBehaviorElement;

/**
 * BusinessInternalBehaviorElement vnull
 *
 *
 * <p>Based on service-orientation, a crucial design decision for the behavioral part of the ArchiMate&nbsp;metamodel is the distinction between &#8220;external&#8221; and &#8220;internal&#8221; behavior of an organization.</p><p>Several types of internal behavior elements that can realize a service are distinguished. Although&nbsp;the distinction between the two is not always sharp, it is often useful to distinguish a process&nbsp;view and a function view on behavior; two elements associated with these views, business&nbsp;process and business function, are defined.</p><p>Both elements can be used to group more detailed&nbsp;business processes/functions, but based on different grouping criteria.</p>
 *
 *
 */
@objid ("f238129c-08e7-4a9d-a85f-d708e05e76b5")
public interface BusinessInternalBehaviorElement extends InternalBehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("63e0e908-37f6-47fc-bc8f-15bed42f855c")
    public static final String MNAME = "BusinessInternalBehaviorElement";

    /**
     * The metaclass qualified name.
     */
    @objid ("7ed1c874-5ac6-42c1-929d-e47c1c455be0")
    public static final String MQNAME = "Archimate.BusinessInternalBehaviorElement";

}
