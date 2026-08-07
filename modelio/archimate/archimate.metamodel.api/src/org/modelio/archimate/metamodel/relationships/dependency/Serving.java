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
package org.modelio.archimate.metamodel.relationships.dependency;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Serving vnull
 *
 *
 * <p>The serving relationship describes how the services or interfaces offered by a behavior or active&nbsp;structure element serve entities in their environment. This relationship is applied for both the&nbsp;behavior aspect and the active structure aspect.</p><p>Compared to the earlier versions of this standard, the name of this relationship has been changed&nbsp;from &#39;used by&#39; to &#39;serving&#39;, to better reflect its direction with an active verb: a service serves a&nbsp;user. The meaning of the relationship has not been altered. The &#39;used by&#39; designation is still&nbsp;allowed but deprecated, and will be removed in a future version of the standard.</p><p>The usual interpretation of a serving relationship is that <em>the whole</em> of the source element serves&nbsp;(is used by) the target element. This means that if, for example, two services serve the same&nbsp;internal behavior element, both of these services are needed. If two services are alternative&nbsp;solutions and only one of them is needed by the internal behavior element, an or junction (see&nbsp;Section 5.4.3) can be used.</p>
 *
 *
 */
@objid ("cb8370e7-9424-4d39-a519-0f0ec7a201e5")
public interface Serving extends DependencyRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("fdab1fea-cfe7-4383-b74f-4c82e226c2d3")
    public static final String MNAME = "Serving";

    /**
     * The metaclass qualified name.
     */
    @objid ("17fe4e3a-c605-45d0-8d53-c0607d7e3c44")
    public static final String MQNAME = "Archimate.Serving";

}
