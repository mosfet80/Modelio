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
package org.modelio.metamodel.impl.bpmn.resources;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000a49ca-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceParameterData extends BpmnBaseElementData {
    @objid ("466aba13-9b76-45fa-9691-bd35e392c102")
    Object mIsRequired = false;

    @objid ("7fb10aec-4d00-44ca-8225-89cfe62a2a16")
    SmObjectImpl mResource;

    @objid ("ca87946e-debb-4ce7-91b2-5f565660f9c8")
    SmObjectImpl mType;

    @objid ("23b94f07-4a13-4fff-b23c-2fe8328122d8")
    List<SmObjectImpl> mParameterBindingRefs = null;

    @objid ("f8b62487-2f31-4319-8e95-07da520109a9")
    public BpmnResourceParameterData(BpmnResourceParameterSmClass smClass) {
        super(smClass);
    }

}
