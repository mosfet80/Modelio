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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;

/**
 * CallBehaviorAction v0.0.9054
 *
 *
 * CallBehaviorAction is a call action that invokes a behavior directly rather than invoking a behavioral feature that, in turn, results in the invocation of that behavior. The argument values of the action are available to the execution of the invoked behavior. For synchronous calls the execution of the call behavior action waits until the execution of the invoked behavior completes and a result is returned on its output pin. The action completes immediately without a result, if the call is asynchronous.
 *
 */
@objid ("002af378-c4bf-1fd8-97fe-001ec947cd2a")
public interface CallBehaviorAction extends CallAction {
    /**
     * The metaclass simple name.
     */
    @objid ("f049ca20-27b0-4976-8369-3534a6f75878")
    public static final String MNAME = "CallBehaviorAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("dbd3436d-5c62-4784-9540-42270ea94dee")
    public static final String MQNAME = "Standard.CallBehaviorAction";

    /**
     * Getter for relation 'CallBehaviorAction->Called'
     *
     * Metamodel description:
     * <i>The invoked behavior. It must be capable of accepting and returning control.</i>
     */
    @objid ("d328a8ba-84a9-4d5d-89bc-0ede62525b49")
    Behavior getCalled();

    /**
     * Setter for relation 'CallBehaviorAction->Called'
     *
     * Metamodel description:
     * <i>The invoked behavior. It must be capable of accepting and returning control.</i>
     */
    @objid ("a8cd035a-559d-46cc-b815-f063a9cbfeb9")
    void setCalled(Behavior value);

}
