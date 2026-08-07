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
import org.modelio.metamodel.bpmn.gateways.BpmnEventBasedGatewayType;

@objid ("00985c10-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnEventBasedGatewayData extends BpmnGatewayData {
    @objid ("6fc83240-d55a-4656-bf2d-119f161b919d")
    Object mInstanciate = false;

    @objid ("24ee3cd9-49fb-4e57-8348-206395be0ce9")
    Object mEventGatewayType = BpmnEventBasedGatewayType.EXCLUSIVEGATEWAY;

    @objid ("5b7ba1e3-bb1f-4e9c-908e-7f8ab987fca3")
    public BpmnEventBasedGatewayData(BpmnEventBasedGatewaySmClass smClass) {
        super(smClass);
    }

}
