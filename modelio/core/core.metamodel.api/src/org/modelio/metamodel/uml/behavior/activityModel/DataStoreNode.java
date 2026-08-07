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
 * DataStoreNode v0.0.9054
 *
 *
 * A data store keeps all tokens that enter it, copying them when they are chosen to move downstream. Incoming tokens containing a particular object replace any tokens in the object node containing that object.
 *
 *
 */
@objid ("002f1fe8-c4bf-1fd8-97fe-001ec947cd2a")
public interface DataStoreNode extends CentralBufferNode {
    /**
     * The metaclass simple name.
     */
    @objid ("fbf6bc12-f5db-460b-b85f-05aa2e77ea73")
    public static final String MNAME = "DataStoreNode";

    /**
     * The metaclass qualified name.
     */
    @objid ("cd2ff674-7f24-4fde-84fb-2cbc9b53657f")
    public static final String MQNAME = "Standard.DataStoreNode";

}
