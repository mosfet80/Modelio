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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000daf70-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnOperationData extends BpmnBaseElementData {
    @objid ("46e8e97f-32d6-44b8-b3b1-6f5d82766f5d")
    List<SmObjectImpl> mSender = null;

    @objid ("abf32d33-3ae6-4b24-9a1e-07912a5f0358")
    SmObjectImpl mInMessageRef;

    @objid ("5ca26c04-4218-47e3-819d-bc947da4916a")
    List<SmObjectImpl> mCaller = null;

    @objid ("c2af1a1a-7c18-4b12-b806-dbc1794ce6bc")
    SmObjectImpl mOutMessageRef;

    @objid ("a9abda65-8ceb-4185-8ceb-95791fc7a431")
    List<SmObjectImpl> mEventDefinition = null;

    @objid ("41d3b9f5-7e81-4488-bb0c-3051f83a510e")
    SmObjectImpl mBpmnInterfaceRef;

    @objid ("58f5ea3f-25de-4b2b-8ecd-d1d09131b2d7")
    List<SmObjectImpl> mReceiver = null;

    @objid ("94fd0e2d-8dce-4fe8-8ec9-b22c996ab9ff")
    public BpmnOperationData(BpmnOperationSmClass smClass) {
        super(smClass);
    }

}
