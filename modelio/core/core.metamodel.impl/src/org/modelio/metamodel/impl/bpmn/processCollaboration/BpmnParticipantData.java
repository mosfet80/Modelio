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
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0075e3f6-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnParticipantData extends BpmnBaseElementData {
    @objid ("59443568-1a25-4bcb-8dca-97510015d866")
    Object mMultiplicityMin = 0;

    @objid ("0375aa67-90dc-44d4-98ae-f00c19b726d1")
    Object mMultiplicityMax = 0;

    @objid ("ea10e475-d73c-440a-8864-833f7acdc286")
    SmObjectImpl mProcess;

    @objid ("f811a76d-4310-425a-84c0-80baaf6c48ef")
    SmObjectImpl mContainer;

    @objid ("8a14e25b-ec59-44d4-abc7-a197d41ec305")
    List<SmObjectImpl> mEndPointRefs = null;

    @objid ("d7a929c5-83a3-4b51-b6c7-de852df146c7")
    List<SmObjectImpl> mInterfaceRefs = null;

    @objid ("072ec437-3d06-4923-8383-11476e3e154e")
    public BpmnParticipantData(BpmnParticipantSmClass smClass) {
        super(smClass);
    }

}
