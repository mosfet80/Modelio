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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0074d240-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLaneData extends BpmnBaseElementData {
    @objid ("5b4e383f-9194-45ea-8de1-576c17f15ba6")
    SmObjectImpl mChildLaneSet;

    @objid ("3933f2d2-024a-40a6-aae3-ccd50990ce69")
    List<SmObjectImpl> mFlowElementRef = null;

    @objid ("f5ed2e7f-7e33-4f08-a046-7a8aabbb04da")
    SmObjectImpl mLaneSet;

    @objid ("201c4fa2-193b-4142-87c6-c7a5e416772e")
    SmObjectImpl mBpmnPartitionElementRef;

    @objid ("5f2881fb-9392-4969-8c27-d9eaccfb7039")
    public BpmnLaneData(BpmnLaneSmClass smClass) {
        super(smClass);
    }

}
