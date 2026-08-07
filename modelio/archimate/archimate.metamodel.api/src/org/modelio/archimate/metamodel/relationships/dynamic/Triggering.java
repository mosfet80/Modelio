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
package org.modelio.archimate.metamodel.relationships.dynamic;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Triggering vnull
 *
 *
 * <p>The triggering relationship is used to model the temporal or causal precedence of behavior&nbsp;elements in a process.</p><p>The usual interpretation of a triggering relationship is that the source&nbsp;element should be completed before the target element can start, although weaker interpretations&nbsp;are also permitted.</p><p>Note that this does not necessarily represent that one behavior element&nbsp;actively starts another; a traffic light turning green also triggers the cars to go through the&nbsp;intersection.</p>
 *
 *
 */
@objid ("7036f0ce-2351-4fed-91d5-99747d2eb51f")
public interface Triggering extends DynamicRelationship {
    /**
     * The metaclass simple name.
     */
    @objid ("cf545163-a873-41da-8361-7f631ada1a71")
    public static final String MNAME = "Triggering";

    /**
     * The metaclass qualified name.
     */
    @objid ("2c9a6641-61e5-4360-b453-4283f62257ec")
    public static final String MQNAME = "Archimate.Triggering";

}
