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

@objid ("00754d60-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLaneSetData extends BpmnBaseElementData {
    @objid ("e0b5f862-0515-421a-8972-5ae440b83630")
    List<SmObjectImpl> mLane = null;

    @objid ("e1566ca0-1cc2-45bc-868f-2f189857e4de")
    SmObjectImpl mProcess;

    @objid ("bd201d58-19bc-440e-9fdf-51f4e29d9d66")
    SmObjectImpl mParentLane;

    @objid ("0be091a4-65cb-42cc-89dd-5c1177744a8f")
    SmObjectImpl mSubProcess;

    @objid ("59437d8c-bd02-488f-ac43-f06d0c0c8aec")
    public BpmnLaneSetData(BpmnLaneSetSmClass smClass) {
        super(smClass);
    }

}
