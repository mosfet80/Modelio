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
package org.modelio.metamodel.impl.bpmn.gateways;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.gateways.BpmnGatewayDirection;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeData;

@objid ("00015806-c4c0-1fd8-97fe-001ec947cd2a")
public abstract class BpmnGatewayData extends BpmnFlowNodeData {
    @objid ("1590f085-865b-4507-85c0-748397882b55")
    Object mGatewayDirection = BpmnGatewayDirection.UNSPECIFIEDDIRECTION;

    @objid ("dd824217-5b79-4485-8423-cdf3091b8ba1")
    public BpmnGatewayData(BpmnGatewaySmClass smClass) {
        super(smClass);
    }

}
