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
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("008db116-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnEventDefinitionData extends BpmnBaseElementData {
    @objid ("f4b2835f-35a2-41c6-8aca-c32afdcb227a")
    SmObjectImpl mDefined;

    @objid ("32e5a4a2-40b6-45c0-8bd2-8450a8e4b198")
    List<SmObjectImpl> mLoopRef = null;

    @objid ("0bb16e4a-1a31-4d15-b641-fa0fe137cd4c")
    public BpmnEventDefinitionData(BpmnEventDefinitionSmClass smClass) {
        super(smClass);
    }

}
