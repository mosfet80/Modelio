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
 * CallOperationAction v0.0.9054
 *
 *
 * CallOperationAction is an action that transmits an operation call request to the target object, where it may cause the invocation of associated behavior. The argument values of the action are available to the execution of the invoked behavior. If the action is marked synchronous, the execution of the call operation action waits until the execution of the invoked behavior completes and a reply transmission is returned to the caller; otherwise execution of the action is complete when the invocation of the operation is established and the execution of the invoked operation proceeds
 * concurrently with the execution of the calling behavior. Any values returned as part of the reply transmission are put on the result output pins of the call operation action. Upon receipt of the reply transmission, execution of the call operation action is complete.
 *
 */
@objid ("002b8324-c4bf-1fd8-97fe-001ec947cd2a")
public interface CallOperationAction extends CallAction {
    /**
     * The metaclass simple name.
     */
    @objid ("82301be8-887e-478b-a949-be3e4007777f")
    public static final String MNAME = "CallOperationAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("92b78023-9779-4ca3-b0b3-2a5448e6fed8")
    public static final String MQNAME = "Standard.CallOperationAction";

    /**
     * Getter for relation 'CallOperationAction->Called'
     *
     * Metamodel description:
     * <i>The Operation to be invoked by the action execution.</i>
     */
    @objid ("35badc58-7898-4dc0-a4ba-c6d99ae26310")
    Operation getCalled();

    /**
     * Setter for relation 'CallOperationAction->Called'
     *
     * Metamodel description:
     * <i>The Operation to be invoked by the action execution.</i>
     */
    @objid ("ea000572-8c12-4c03-a5dc-515148e61df2")
    void setCalled(Operation value);

}
