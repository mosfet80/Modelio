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

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("007a84d8-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnGroupData extends BpmnArtifactData {
    @objid ("622810c4-2f3f-4baa-90a5-51316432ad09")
    Object mCategory = "";

    @objid ("35b1b756-866f-469c-9e10-dcecf07afb6d")
    List<SmObjectImpl> mCategorized = null;

    @objid ("31880720-3d88-466b-bd7e-bc68367fa1f2")
    public BpmnGroupData(BpmnGroupSmClass smClass) {
        super(smClass);
    }

}
