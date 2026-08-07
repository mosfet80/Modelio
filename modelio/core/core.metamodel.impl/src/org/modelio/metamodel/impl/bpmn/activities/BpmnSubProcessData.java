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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("008489ba-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSubProcessData extends BpmnActivityData {
    @objid ("78216539-010f-4f95-ba2e-f373aa9d85a0")
    List<SmObjectImpl> mArtifact = null;

    @objid ("8b08d3be-00c6-4aac-a22b-ff5ce0ac2e8f")
    List<SmObjectImpl> mFlowElement = null;

    @objid ("1cb3ba63-2722-48e8-b1c6-4b1ae267137b")
    SmObjectImpl mLaneSet;

    @objid ("68afb8a8-73a2-467e-aae8-baac434fd42a")
    public BpmnSubProcessData(BpmnSubProcessSmClass smClass) {
        super(smClass);
    }

}
