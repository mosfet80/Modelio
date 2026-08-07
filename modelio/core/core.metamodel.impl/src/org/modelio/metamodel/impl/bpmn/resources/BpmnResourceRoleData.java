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

@objid ("000aeda8-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceRoleData extends BpmnBaseElementData {
    @objid ("e3473f7b-c2ec-4057-88e1-0267396e9c7d")
    SmObjectImpl mResourceRef;

    @objid ("2509a8ef-4774-4aef-9b81-742bfdf53ae2")
    SmObjectImpl mAnnotated;

    @objid ("ac4faec0-4e8a-472f-8ff7-6968d89fc720")
    List<SmObjectImpl> mResourceParameterBinding = null;

    @objid ("945a2277-a952-42e5-87a9-c51281f0f36b")
    SmObjectImpl mProcess;

    @objid ("efd2ab47-f271-4913-8cb2-452fdce9fab1")
    public BpmnResourceRoleData(BpmnResourceRoleSmClass smClass) {
        super(smClass);
    }

}
