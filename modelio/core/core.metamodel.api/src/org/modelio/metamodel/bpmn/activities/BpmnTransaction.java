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
package org.modelio.metamodel.bpmn.activities;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

/**
 * BpmnTransaction v0.0.9054
 *
 *
 * A Transaction is a specialized type of Sub-Process which will have a special behavior that is controlled through a transaction protocol (such as WS-Transaction). The boundary of the Sub-Process will be double-lined to indicate that it is a Transaction
 *
 */
@objid ("00855ebc-c4bf-1fd8-97fe-001ec947cd2a")
public interface BpmnTransaction extends BpmnSubProcess {
    /**
     * The metaclass simple name.
     */
    @objid ("eda41954-94fd-43d0-b747-226645eac2c1")
    public static final String MNAME = "BpmnTransaction";

    /**
     * The metaclass qualified name.
     */
    @objid ("9534ed8f-a457-4e69-9c65-623f12ab11fe")
    public static final String MQNAME = "Standard.BpmnTransaction";

    /**
     * Getter for attribute 'BpmnTransaction.Method'
     *
     * Metamodel description:
     * <i>TransactionMethod is an attribute that defines the technique that will be used to undo a Transaction that has been cancelled.
     * The default is compensate, but the attribute MAY be set to store or image.</i>
     */
    @objid ("dbd985a5-a7dc-474b-a363-9dbf8fae6e4f")
    TransactionMethod getMethod();

    /**
     * Setter for attribute 'BpmnTransaction.Method'
     *
     * Metamodel description:
     * <i>TransactionMethod is an attribute that defines the technique that will be used to undo a Transaction that has been cancelled.
     * The default is compensate, but the attribute MAY be set to store or image.</i>
     */
    @objid ("6604b88e-74dc-4830-8a15-810de61fc560")
    void setMethod(TransactionMethod value);

}
