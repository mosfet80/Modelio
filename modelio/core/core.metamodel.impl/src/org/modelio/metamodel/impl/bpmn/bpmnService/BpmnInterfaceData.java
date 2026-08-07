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
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000e4fac-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnInterfaceData extends BpmnSharedElementData {
    @objid ("5f24dfb9-5a2f-4da2-af7f-dc3e6ba68fad")
    List<SmObjectImpl> mOperation = null;

    @objid ("537788bb-2ef0-4d4d-a486-b1757679f130")
    List<SmObjectImpl> mParticipantRef = null;

    @objid ("82edfcce-c601-4518-935a-68465f02b2c0")
    public BpmnInterfaceData(BpmnInterfaceSmClass smClass) {
        super(smClass);
    }

}
