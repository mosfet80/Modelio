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
package org.modelio.metamodel.impl.bpmn.rootElements;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0078e650-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnArtifactData extends BpmnBaseElementData {
    @objid ("fd8d9b7f-fe3b-4ab8-9f13-0fc909a1d705")
    SmObjectImpl mSubProcess;

    @objid ("2f9a299b-d915-48a2-a1cb-23f03a278240")
    SmObjectImpl mCollaboration;

    @objid ("b385323b-dde5-4dea-ac8f-4a290ea76383")
    SmObjectImpl mProcess;

    @objid ("00e4010e-5c38-40a9-8e8e-d42ae685ce30")
    public BpmnArtifactData(BpmnArtifactSmClass smClass) {
        super(smClass);
    }

}
