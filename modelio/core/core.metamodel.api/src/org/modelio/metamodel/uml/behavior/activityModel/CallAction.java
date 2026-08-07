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
 * CallAction v0.0.9054
 *
 *
 *
 *
 */
@objid ("002a65de-c4bf-1fd8-97fe-001ec947cd2a")
public interface CallAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("12028868-1262-4f74-b4b0-086ebb667f6a")
    public static final String MNAME = "CallAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("98938a00-064f-4690-a6bc-ccd2dbeb6a0a")
    public static final String MQNAME = "Standard.CallAction";

    /**
     * Getter for attribute 'CallAction.IsSynchronous'
     *
     * Metamodel description:
     * <i>If true, the call is synchronous and the caller waits for completion of the invoked behavior. If false, the call is asynchronous and the caller proceeds immediately and does not expect a return value.</i>
     */
    @objid ("e67979a3-ce50-461c-bcce-db445ddbb2bf")
    boolean isIsSynchronous();

    /**
     * Setter for attribute 'CallAction.IsSynchronous'
     *
     * Metamodel description:
     * <i>If true, the call is synchronous and the caller waits for completion of the invoked behavior. If false, the call is asynchronous and the caller proceeds immediately and does not expect a return value.</i>
     */
    @objid ("c2c5c428-a4e6-42ba-acbe-65201fc1550d")
    void setIsSynchronous(boolean value);

}
