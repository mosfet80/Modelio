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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0006c016-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataInputData extends BpmnItemAwareElementData {
    @objid ("66f04b49-ce69-424b-a34d-81e6dbf4549c")
    Object mIsCollection = false;

    @objid ("c4790f55-b339-4109-814e-a66d32db2fbe")
    SmObjectImpl mOwnerLoopCharacteristics;

    @objid ("ed1e2827-1448-4423-89a1-808fc601ab3f")
    SmObjectImpl mOwnerActivity;

    @objid ("12b097c9-bc3d-40b8-a339-b6831ec4f904")
    SmObjectImpl mOwnerThrowEvent;

    @objid ("90b5a0f7-6206-46e6-8f5e-182b7aa201c6")
    public BpmnDataInputData(BpmnDataInputSmClass smClass) {
        super(smClass);
    }

}
