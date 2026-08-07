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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcessType;
import org.modelio.metamodel.bpmn.processCollaboration.OptionalBoolean;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00768e50-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnProcessData extends BehaviorData {
    @objid ("89898129-c743-4d19-adbf-7180802feec0")
    Object mProcessType = BpmnProcessType.NONEPROCESS;

    @objid ("adb45b50-d2f7-4258-b0a5-55bd3a8524bb")
    Object mIsClosed = false;

    @objid ("150d8878-6677-4ea0-b829-d25fc86fb705")
    Object mIsExecutable = OptionalBoolean.OUNDEFINED;

    @objid ("59297cdc-13f3-41a1-8494-3a66d218770b")
    List<SmObjectImpl> mSupports = null;

    @objid ("114ca73b-956c-4b8e-9e56-6670c16668a9")
    List<SmObjectImpl> mArtifact = null;

    @objid ("a15302a6-ba6a-419c-9806-92bec62ec51f")
    SmObjectImpl mLaneSet;

    @objid ("c2e3de07-6eb0-4bf0-acb0-d85851c5bd7b")
    List<SmObjectImpl> mSupported = null;

    @objid ("573c5f27-4ddc-4608-a565-c467ce0de42b")
    List<SmObjectImpl> mParticipant = null;

    @objid ("dd3e9fb4-2f24-4db8-a74b-dfc7d4f0ed34")
    List<SmObjectImpl> mFlowElement = null;

    @objid ("77757a23-59e1-4b06-932d-cab04375a861")
    List<SmObjectImpl> mResource = null;

    @objid ("6c2bbde9-c392-43f3-86e0-d3816271019c")
    SmObjectImpl mDefinitionalCollaboration;

    @objid ("df000134-52ed-4ea3-8715-1343d242808e")
    public BpmnProcessData(BpmnProcessSmClass smClass) {
        super(smClass);
    }

}
