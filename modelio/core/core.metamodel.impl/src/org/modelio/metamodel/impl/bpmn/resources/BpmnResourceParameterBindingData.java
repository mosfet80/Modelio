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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000b8d44-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceParameterBindingData extends BpmnBaseElementData {
    @objid ("cf5ccdce-3b0d-4e8f-9165-ee2fcd8445c5")
    Object mExpression = "";

    @objid ("9781399a-a89c-4088-85af-d9ee306e1db7")
    SmObjectImpl mResourceRole;

    @objid ("bd204133-da20-49c2-962f-e810d473230c")
    SmObjectImpl mParameterRef;

    @objid ("de3c9a30-ee9d-486f-ab64-5b90a4eb4783")
    public BpmnResourceParameterBindingData(BpmnResourceParameterBindingSmClass smClass) {
        super(smClass);
    }

}
