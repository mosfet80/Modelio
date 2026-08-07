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
package org.modelio.archimate.metamodel.relationships.structural;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Realization vnull
 *
 *
 * <p>The realization relationship models that an entity plays a critical role in the creation,&nbsp;achievement, sustenance, or operation of a more abstract entity.</p><p>The realization relationship indicates that more abstract entities (&quot;what&quot; or &quot;logical&quot;) are&nbsp;realized by means of more tangible entities (&quot;how&quot; or &quot;physical&quot;). The realization relationship is&nbsp;used to model run-time realization; for example, that a business process realizes a business&nbsp;service, and that a data object realizes a business object, an artifact realizes an application&nbsp;component, or a core element realizes a motivation element.</p><p>The usual interpretation of a realization relationship is that the <em>whole or part</em> of the source&nbsp;element realizes the <em>whole of</em> the target element. This means that if, for example, two internal&nbsp;behavior elements have a realization relationship to the same service, either of them can realize&nbsp;the complete service. If both internal behavior elements are needed to realize, the <em>grouping</em>&nbsp;element or a&nbsp;<em style="line-height:1.6">junction&nbsp;</em><span style="line-height:1.6">can be used. For weaker types of contribution to the&nbsp;realization of an element, the <em>influence</em> relationship should be used.</span></p>
 *
 *
 */
@objid ("a8d67d75-6ad5-468d-a7bc-532bf2e0f79c")
public interface Realization extends StructuralRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("ada6bfd0-d543-4336-ad50-cbf8032bfbc5")
    public static final String MNAME = "Realization";

    /**
     * The metaclass qualified name.
     */
    @objid ("028aad93-46c0-40a5-adce-0b294ab7b0a7")
    public static final String MQNAME = "Archimate.Realization";

}
