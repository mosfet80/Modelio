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
import org.modelio.metamodel.uml.statik.Operation;

/**
 * AcceptCallEventAction v0.0.9054
 *
 *
 * AcceptCallAction is an accept event action representing the receipt of a synchronous call request. In addition to the normal operation parameters, the action produces an output that is needed later to supply the information to the ReplyAction necessary to return control to the caller.
 *
 * This action is for synchronous calls. If it is used to handle an asynchronous call, execution of the subsequent reply action will complete immediately with no effects.
 *
 *
 */
@objid ("00241b8e-c4bf-1fd8-97fe-001ec947cd2a")
public interface AcceptCallEventAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("deaa3cb5-023a-40d9-b1ec-569855377ad2")
    public static final String MNAME = "AcceptCallEventAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("699a517f-202e-4453-b21d-ea4b7fdd8e92")
    public static final String MQNAME = "Standard.AcceptCallEventAction";

    /**
     * Getter for relation 'AcceptCallEventAction->Called'
     *
     * Metamodel description:
     * <i>The Operation invoked by the call event.</i>
     */
    @objid ("053fe409-119a-49eb-8024-bfb4d2c2e566")
    Operation getCalled();

    /**
     * Setter for relation 'AcceptCallEventAction->Called'
     *
     * Metamodel description:
     * <i>The Operation invoked by the call event.</i>
     */
    @objid ("9f07693d-ae7d-4253-bcd4-57bc59a58a96")
    void setCalled(Operation value);

}
