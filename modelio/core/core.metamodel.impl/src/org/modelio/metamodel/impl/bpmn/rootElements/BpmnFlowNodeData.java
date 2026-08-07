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

@objid ("007a05d0-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnFlowNodeData extends BpmnFlowElementData {
    @objid ("001dc166-274b-4d35-95c8-335a8684e77b")
    List<SmObjectImpl> mOutgoing = null;

    @objid ("14afb8df-c9cb-405c-8805-e25500a79bba")
    List<SmObjectImpl> mResource = null;

    @objid ("17ad1a0f-03ec-43c7-b3f9-307295b00256")
    List<SmObjectImpl> mIncoming = null;

    @objid ("267f5fe0-f038-4d1e-9bfc-edecfadfc328")
    public BpmnFlowNodeData(BpmnFlowNodeSmClass smClass) {
        super(smClass);
    }

}
