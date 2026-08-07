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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNodeOrderingKind;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0039b58e-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ObjectNodeData extends ActivityNodeData {
    @objid ("cf08912e-1d58-4b91-a27d-81febd4e6935")
    Object mIsControlType = false;

    @objid ("6a1bc58b-322d-4fe3-b9be-243ce686474b")
    Object mOrdering = ObjectNodeOrderingKind.FIFO;

    @objid ("1606d09a-4096-410a-8d70-ad24840448cb")
    Object mSelectionBehavior = "";

    @objid ("554bca0f-6510-4770-bb6c-c02cd0071437")
    Object mUpperBound = "1";

    @objid ("95664cb6-2c18-4c06-b076-01bec2d159a1")
    SmObjectImpl mRepresented;

    @objid ("55438015-109b-4267-9466-97aa73679ef6")
    SmObjectImpl mRepresentedRealParameter;

    @objid ("f2f9d67e-5867-4054-a3ca-2341e999ba96")
    SmObjectImpl mType;

    @objid ("da8f8998-0ba3-41ad-8539-edf9cac7ad10")
    SmObjectImpl mRepresentedRole;

    @objid ("da786d84-e913-4c45-98fe-aa4ae3aa9d60")
    SmObjectImpl mRepresentedAttribute;

    @objid ("19f91990-08a3-4490-9ede-75d4aedb492d")
    SmObjectImpl mInState;

    @objid ("3f56ea75-a5a1-4eb2-a273-3276df7f2f36")
    public ObjectNodeData(ObjectNodeSmClass smClass) {
        super(smClass);
    }

}
