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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00742fca-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnCollaborationData extends BehaviorData {
    @objid ("c0e5aafe-2d96-47c2-99b9-990f3c959b56")
    Object mIsClosed = false;

    @objid ("69e3512a-2d0b-4d5f-82e5-6e28a76b5d2d")
    List<SmObjectImpl> mArtifact = null;

    @objid ("22c65f28-1db3-4387-97a6-5ddf542e6729")
    List<SmObjectImpl> mMessageFlow = null;

    @objid ("6c923ac2-3c05-46b5-920a-76d5ab0b3f96")
    List<SmObjectImpl> mParticipants = null;

    @objid ("f7105a74-acbb-4203-9178-3f7aa58c27a8")
    List<SmObjectImpl> mMessages = null;

    @objid ("e78fe530-bdb4-45f0-98ed-62d444eb8270")
    SmObjectImpl mDefinedProcess;

    @objid ("5e37f3b7-de24-4925-a35e-d2338ebf83ea")
    public BpmnCollaborationData(BpmnCollaborationSmClass smClass) {
        super(smClass);
    }

}
