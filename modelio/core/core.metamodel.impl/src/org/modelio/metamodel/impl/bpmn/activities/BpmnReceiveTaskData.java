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
package org.modelio.metamodel.impl.bpmn.activities;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0081d3c8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnReceiveTaskData extends BpmnTaskData {
    @objid ("2008bee2-866f-4a2a-b1ce-f835902715ba")
    Object mImplementation = "##WebService";

    @objid ("a430e489-bbf6-4c84-90dc-8097074266bd")
    Object mInstanciate = false;

    @objid ("f58235a4-da98-4799-8d13-b1a127f55624")
    SmObjectImpl mMessageRef;

    @objid ("100a5378-9e99-4011-80b8-9e3800903f81")
    SmObjectImpl mOperationRef;

    @objid ("c5ed1ce2-fb68-4dff-b739-a423ad93891c")
    public BpmnReceiveTaskData(BpmnReceiveTaskSmClass smClass) {
        super(smClass);
    }

}
