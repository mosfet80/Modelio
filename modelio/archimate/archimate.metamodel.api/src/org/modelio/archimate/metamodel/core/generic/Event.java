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
package org.modelio.archimate.metamodel.core.generic;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * Event vnull
 *
 *
 * <p>An event may have a time attribute that indicates the moment or moments at which the event&nbsp;happens. For example, this can be used to model time schedules.</p>
 *
 *
 */
@objid ("90cd41e0-ebf9-4e14-8223-b3e4d3dc196c")
public interface Event extends BehaviorElement {
    /**
     * The metaclass simple name.
     */
    @objid ("0807e5f4-18e9-4f08-9a89-a4d35fcdd2d8")
    public static final String MNAME = "Event";

    /**
     * The metaclass qualified name.
     */
    @objid ("ec4fb12b-dba2-4665-a3a3-66f12a9cf04c")
    public static final String MQNAME = "Archimate.Event";

    /**
     * Getter for attribute 'Event.time'
     *
     * Metamodel description:
     * <i>indicates the moment or moments at which the event happens. For example, this can be used to model time schedules.</i>
     */
    @objid ("ac349e07-50f9-464e-ab23-e53503c805aa")
    String getTime();

    /**
     * Setter for attribute 'Event.time'
     *
     * Metamodel description:
     * <i>indicates the moment or moments at which the event happens. For example, this can be used to model time schedules.</i>
     */
    @objid ("9a1556c5-f0a4-4133-b399-4c2bc4aa7f1c")
    void setTime(String value);

}
