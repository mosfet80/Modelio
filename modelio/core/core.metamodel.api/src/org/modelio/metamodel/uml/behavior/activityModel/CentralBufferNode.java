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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * CentralBufferNode v0.0.9054
 *
 *
 * A central buffer node accepts tokens from upstream object nodes and passes them along to downstream object nodes.
 *
 * Central buffer nodes act as a buffer for multiple in flows and out flows from other object nodes.
 *
 */
@objid ("002c1492-c4bf-1fd8-97fe-001ec947cd2a")
public interface CentralBufferNode extends ObjectNode {
    /**
     * The metaclass simple name.
     */
    @objid ("a306b84b-7189-4096-be15-b84acd89fe0c")
    public static final String MNAME = "CentralBufferNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("c94cfec1-bad4-4238-8f2a-9f010847c3df")
    public static final String MQNAME = "Standard.CentralBufferNode";

}
