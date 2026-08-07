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
package org.modelio.archimate.metamodel.layers.motivation;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.core.generic.motivation.MotivationElement;

/**
 * Driver vnull
 *
 *
 * <p>Drivers may be internal, in which case they are usually associated with a stakeholder, and are&nbsp;often called &quot;concerns&quot;.</p><p>Stakeholder concerns are defined in the TOGAF framework&nbsp;as<em> &quot;the&nbsp;key interests that are crucially important to the stakeholders in a system, and determine the&nbsp;acceptability of the system. Concerns may pertain to any aspect of the function, development, or&nbsp;operation of the system, including considerations such as performance, reliability, security,&nbsp;distribution, and evolvability.&quot;</em>&nbsp;.</p><p>Examples of internal drivers are Customer satisfaction and&nbsp;Profitability. Drivers of change may also be external; e.g., economic changes or changing&nbsp;legislation.</p><p>The name of a driver should preferably be a noun.</p>
 *
 *
 */
@objid ("27529127-07eb-4fd5-a187-e70662fbd761")
public interface Driver extends MotivationElement {
    /**
     * The metaclass simple name.
     */
    @objid ("aa5c5c39-e3d9-4902-a145-810be3b117ac")
    public static final String MNAME = "Driver";

    /**
     * The metaclass qualified name.
     */
    @objid ("c65783fb-dee9-49a2-ba29-46b06eeff6d5")
    public static final String MQNAME = "Archimate.Driver";

}
