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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00913f52-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageEventDefinitionData extends BpmnEventDefinitionData {
    @objid ("de9ca3f8-c394-46c7-8ae5-c0a74035f617")
    SmObjectImpl mMessageRef;

    @objid ("ea7f128e-5b54-433c-b59d-274695b8a1c6")
    List<SmObjectImpl> mOperationRef = null;

    @objid ("2fd3bbe2-62ee-4e90-9ed6-2f3a47d3e1c6")
    public BpmnMessageEventDefinitionData(BpmnMessageEventDefinitionSmClass smClass) {
        super(smClass);
    }

}
