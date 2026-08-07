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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;

/**
 * SendSignalAction v0.0.9054
 *
 *
 * SendSignalAction is an action that creates a signal instance from its inputs, and transmits it to the target object, where it may cause the firing of a state machine transition or the execution of an activity. The argument values are available to the execution of associated behaviors. The requestor continues execution immediately.
 *
 */
@objid ("003d3af6-c4bf-1fd8-97fe-001ec947cd2a")
public interface SendSignalAction extends ActivityAction {
    /**
     * The metaclass simple name.
     */
    @objid ("337d9ad7-374b-4cbe-97c2-fb4ea2bde4e4")
    public static final String MNAME = "SendSignalAction";

    /**
     * The metaclass qualified name.
     */
    @objid ("4a97a9c7-c6e7-4084-86b1-1eb0dd7b9e01")
    public static final String MQNAME = "Standard.SendSignalAction";

    /**
     * Getter for relation 'SendSignalAction->Sent'
     *
     * Metamodel description:
     * <i>The type of signal transmitted.</i>
     */
    @objid ("0230d044-3176-4818-8452-42bc6566cbc1")
    Signal getSent();

    /**
     * Setter for relation 'SendSignalAction->Sent'
     *
     * Metamodel description:
     * <i>The type of signal transmitted.</i>
     */
    @objid ("723aea06-e4f0-418a-848b-86990379a9f5")
    void setSent(Signal value);

}
