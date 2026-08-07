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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowNodeData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007dc792-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnActivityData extends BpmnFlowNodeData {
    @objid ("cc920f77-58dc-4afd-8faf-af12e48a9ffe")
    Object mIsForCompensation = false;

    @objid ("b3e8dabf-c141-447a-89d1-988ddd9acef9")
    Object mStartQuantity = 1;

    @objid ("f27eab98-3e09-4f75-8438-3c4b9ee4c1e6")
    Object mCompletionQuantity = 1;

    @objid ("175b1abe-4b7f-42af-bc31-cffd9a6bdaf9")
    List<SmObjectImpl> mCompensateEventDefinitions = null;

    @objid ("99dcf09c-9944-4447-b537-61bf28cba38f")
    List<SmObjectImpl> mInputSpecification = null;

    @objid ("8dcd5417-3078-4ed6-a8ab-c73f350206c7")
    List<SmObjectImpl> mDataInputAssociation = null;

    @objid ("7002e348-4dd7-4c83-b06c-0d905c014931")
    List<SmObjectImpl> mOutputSpecification = null;

    @objid ("28fbf4fa-7d57-487a-bf34-058d4c935b69")
    SmObjectImpl mLoopCharacteristics;

    @objid ("6c611977-309f-422c-8592-97a59607a2bc")
    List<SmObjectImpl> mBoundaryEventRef = null;

    @objid ("d94e85c4-2d0e-4391-ae8a-b7d5ce65f14e")
    List<SmObjectImpl> mDataOutputAssociation = null;

    @objid ("01661dc3-56da-4458-9b11-8987d4959920")
    SmObjectImpl mDefaultFlow;

    @objid ("6ebb21d4-4b45-4b14-9c69-c971dd2f2116")
    public BpmnActivityData(BpmnActivitySmClass smClass) {
        super(smClass);
    }

}
