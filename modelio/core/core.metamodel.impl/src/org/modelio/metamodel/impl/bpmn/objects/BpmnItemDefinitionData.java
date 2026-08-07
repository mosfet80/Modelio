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
import org.modelio.metamodel.bpmn.objects.BpmnItemKind;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00080bd8-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnItemDefinitionData extends BpmnSharedElementData {
    @objid ("39985864-4db9-4103-86c7-aa1b01a13104")
    Object mItemKind = BpmnItemKind.INFORMATION;

    @objid ("ca72397f-63d0-4034-886f-e1fd9ee012ad")
    Object mIsCollection = false;

    @objid ("a589370a-e090-4934-ab0e-c8b260f844ad")
    List<SmObjectImpl> mTypedMessage = null;

    @objid ("dff2e736-4d99-4eea-96d0-e9f2e35c4fd7")
    List<SmObjectImpl> mTypedItem = null;

    @objid ("3f4ab10c-92c3-457f-9ee0-53ce99553d65")
    List<SmObjectImpl> mTypedResourceParameter = null;

    @objid ("0a1cd745-a4e3-4735-91bc-0dd0453f66ba")
    public BpmnItemDefinitionData(BpmnItemDefinitionSmClass smClass) {
        super(smClass);
    }

}
