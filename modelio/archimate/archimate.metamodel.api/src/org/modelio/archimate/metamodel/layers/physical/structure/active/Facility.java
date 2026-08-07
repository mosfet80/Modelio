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
package org.modelio.archimate.metamodel.layers.physical.structure.active;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.archimate.metamodel.layers.technology.structure.active.Node;

/**
 * Facility vnull
 *
 *
 * <p>Facilities can be interconnected by distribution networks. Material can be accessed (e.g., created,&nbsp;used, stored, moved, or transformed) by equipment. A facility can serve other facilities, and also&nbsp;other active structure elements such as business roles and actors, and locations can be assigned&nbsp;to facilities. A facility can be composed of other facilities.</p><p>The name of a facility should preferably be a noun.</p>
 *
 *
 */
@objid ("8f1f372d-e829-41fb-9aad-e64fb3c008ce")
public interface Facility extends Node {
    /**
     * The metaclass simple name.
     */
    @objid ("f33d2629-d013-4340-8a94-3555d254209a")
    public static final String MNAME = "Facility";

    /**
     * The metaclass qualified name.
     */
    @objid ("e24f884b-1c8d-4884-8073-76604415a25f")
    public static final String MQNAME = "Archimate.Facility";

}
