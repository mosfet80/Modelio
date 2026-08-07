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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007984ac-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnFlowElementData extends BpmnBaseElementData {
    @objid ("cf49c443-ff2d-41b7-845a-07f44741f438")
    Object mTriggeredByEvent = false;

    @objid ("f3511b33-ef52-406c-9724-7c9e7d325911")
    List<SmObjectImpl> mGroups = null;

    @objid ("67c0e7c2-af1d-4450-9060-eeff2f0bdc43")
    SmObjectImpl mSubProcess;

    @objid ("7a1e26cc-b458-41e0-8bd2-3d5371378dc2")
    List<SmObjectImpl> mLane = null;

    @objid ("6930d3b0-4725-47c4-8958-df3695f065e7")
    SmObjectImpl mContainer;

    @objid ("9c0af26b-cb0b-4dcc-80ac-14a61d2d2833")
    public BpmnFlowElementData(BpmnFlowElementSmClass smClass) {
        super(smClass);
    }

}
