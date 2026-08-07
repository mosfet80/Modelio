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
package org.modelio.archimate.metamodel.core.generic.composite;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Location vnull
 *
 *
 * <p>The location element is used to model the places where (active and passive) structure elements&nbsp;such as business actors, application components, and devices are located. This is modeled by&nbsp;means of an aggregation relationship from a location to structure element. A location can also aggregate a behavior element, to indicate where the behavior is performed.</p><p>This element&nbsp;corresponds to the &quot;Where&quot; column of the <a href="https://en.wikipedia.org/wiki/Zachman_Framework" >Zachman framework.</a></p>
 *
 *
 */
@objid ("b0571442-0a4a-42b7-a885-604d9a376ef0")
public interface Location extends CompositeElement {
    /**
     * The metaclass simple name.
     */
    @objid ("f7942c95-7e68-43dd-bef0-8914229af176")
    public static final String MNAME = "Location";

    /**
     * The metaclass qualified name.
     */
    @objid ("663eebbe-0c6f-40eb-aeac-bb3f5694db70")
    public static final String MQNAME = "Archimate.Location";

}
