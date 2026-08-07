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
package org.modelio.metamodel.impl.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000dc94c-c4bf-1fd8-97fe-001ec947cd2a")
public class InstanceData extends UmlModelElementData {
    @objid ("6b1302f7-e121-410f-9b14-22e54333ee82")
    Object mIsConstant = false;

    @objid ("3bde2265-e1f9-4e4c-b2d1-eead7e313e5d")
    Object mMultiplicityMin = "1";

    @objid ("1df048c3-ddd9-4418-83f2-abdafcc46fe7")
    Object mMultiplicityMax = "1";

    @objid ("9383c7d7-aa60-4c85-9729-99c6fee5f6b7")
    Object mValue = "";

    @objid ("b9eb67f2-dfbd-48cc-8300-3c7901ae616e")
    List<SmObjectImpl> mRepresentedCommunicationNode = null;

    @objid ("934b1da1-f930-49fd-b428-afca7db7bb6a")
    List<SmObjectImpl> mOwnedEnd = null;

    @objid ("825bce14-f113-4251-9fdd-5e1f410e3e45")
    SmObjectImpl mBase;

    @objid ("a7898450-c039-4f81-9d66-277faabf1b95")
    List<SmObjectImpl> mRepresentingObjectNode = null;

    @objid ("fe7c3176-6397-48b0-9507-39b1b32b1da6")
    SmObjectImpl mOwner;

    @objid ("9965d408-fb3c-4f01-b158-8209c10887a1")
    List<SmObjectImpl> mOwnedNaryEnd = null;

    @objid ("2ec93611-acef-4ea4-9b76-1ef3814c5ece")
    List<SmObjectImpl> mRepresentedLifeLine = null;

    @objid ("bd0fb697-6873-4d75-a324-f09595c995fc")
    List<SmObjectImpl> mSlot = null;

    @objid ("b6487bb3-cb80-4500-b43d-9da8fbc027ae")
    List<SmObjectImpl> mPart = null;

    @objid ("790c50ff-fa6c-4a34-b9c4-6f0a7648cafa")
    List<SmObjectImpl> mTargetingEnd = null;

    @objid ("e2d38992-811b-48fa-81df-b78a9e266ebc")
    public InstanceData(InstanceSmClass smClass) {
        super(smClass);
    }

}
