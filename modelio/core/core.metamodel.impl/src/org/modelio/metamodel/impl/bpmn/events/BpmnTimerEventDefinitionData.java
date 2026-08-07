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
package org.modelio.metamodel.impl.bpmn.events;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("0096dd72-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTimerEventDefinitionData extends BpmnEventDefinitionData {
    @objid ("2a5148ef-650d-451d-bba1-bfee06fd6bdb")
    Object mTimeCycle = "";

    @objid ("33db589f-4553-4589-96d2-d6878ccb5902")
    Object mTimeDate = "";

    @objid ("2ff47ab4-bc5b-4638-8436-cabfe524ce33")
    Object mTimeDuration = "";

    @objid ("9797b14a-8712-4a8d-92e0-84f4d176f9e0")
    public BpmnTimerEventDefinitionData(BpmnTimerEventDefinitionSmClass smClass) {
        super(smClass);
    }

}
