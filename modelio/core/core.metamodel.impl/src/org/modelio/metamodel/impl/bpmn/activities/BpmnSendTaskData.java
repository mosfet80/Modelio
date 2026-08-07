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

@objid ("0082e34e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSendTaskData extends BpmnTaskData {
    @objid ("d319b741-5e7b-460c-a34a-3925e44bd7e4")
    Object mImplementation = "##WebService";

    @objid ("8958df56-a13f-4a50-9b19-229ffb46de09")
    SmObjectImpl mMessageRef;

    @objid ("f0ca35a7-939c-43b5-abf3-310737158319")
    SmObjectImpl mOperationRef;

    @objid ("a27a21c8-58ea-4f1c-8b89-c1d97981c7de")
    public BpmnSendTaskData(BpmnSendTaskSmClass smClass) {
        super(smClass);
    }

}
