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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000765a2-c4c0-1fd8-97fe-001ec947cd2a")
public abstract class BpmnItemAwareElementData extends BpmnFlowElementData {
    @objid ("c0545fa8-f207-470d-81c9-ab1ff1f06f8c")
    List<SmObjectImpl> mTargetOfDataAssociation = null;

    @objid ("15bf9502-ea31-4394-af0a-aa52baf8b290")
    SmObjectImpl mItemSubjectRef;

    @objid ("395e5503-009d-4415-90cd-a92b79a89dd1")
    SmObjectImpl mDataState;

    @objid ("8226c666-6611-4ebc-816b-6b9426bffbd8")
    List<SmObjectImpl> mSourceOfDataAssociation = null;

    @objid ("f64e90d0-878d-4a25-a2f4-d90abd26b520")
    public BpmnItemAwareElementData(BpmnItemAwareElementSmClass smClass) {
        super(smClass);
    }

}
