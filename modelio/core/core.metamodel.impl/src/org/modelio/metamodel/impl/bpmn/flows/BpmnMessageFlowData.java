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
package org.modelio.metamodel.impl.bpmn.flows;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007cb096-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageFlowData extends BpmnBaseElementData {
    @objid ("e44b7d41-eee2-43b5-b7d8-3cc063efde65")
    SmObjectImpl mMessageRef;

    @objid ("f557f48b-922d-4342-9750-aab6c4294c81")
    SmObjectImpl mSourceRef;

    @objid ("e44905ea-b293-43d3-b4a1-64e50e499e23")
    SmObjectImpl mTargetRef;

    @objid ("ce294194-9dc3-4d73-8b02-cd272967af0c")
    SmObjectImpl mCollaboration;

    @objid ("17b15d89-ac14-4478-8d23-84ed735b2e55")
    public BpmnMessageFlowData(BpmnMessageFlowSmClass smClass) {
        super(smClass);
    }

}
