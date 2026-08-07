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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007d254e-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSequenceFlowData extends BpmnFlowElementData {
    @objid ("f7e89ece-1550-4060-ae08-54979aeb0fd8")
    Object mIsImmediate = false;

    @objid ("62fa7919-f336-4f98-8d6a-bbaac90d1bdb")
    Object mConditionExpression = "";

    @objid ("55b116c9-25ec-4706-8ee1-84e24cfc54b9")
    SmObjectImpl mSourceRef;

    @objid ("5d5b0b30-12b7-4d36-9fde-d3fe8a522567")
    SmObjectImpl mTargetRef;

    @objid ("71bc4d70-c029-42a8-b83f-e6727636715e")
    SmObjectImpl mDefaultOfInclusive;

    @objid ("c8dc11bb-5440-4926-81d1-461187c46587")
    SmObjectImpl mDefaultFrom;

    @objid ("b60a8207-1853-4b88-8741-badcb136e29b")
    SmObjectImpl mDefaultOfExclusive;

    @objid ("7ea30239-a2df-46be-b6ca-5d535122685e")
    List<SmObjectImpl> mConnector = null;

    @objid ("21684b95-30e2-4901-8daf-778e252e0c98")
    SmObjectImpl mDefaultOfComplex;

    @objid ("5b2e64d6-20df-43f4-87b1-81a9ddd8ff5e")
    public BpmnSequenceFlowData(BpmnSequenceFlowSmClass smClass) {
        super(smClass);
    }

}
