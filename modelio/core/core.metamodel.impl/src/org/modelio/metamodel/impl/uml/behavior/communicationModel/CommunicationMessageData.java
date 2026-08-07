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
package org.modelio.metamodel.impl.uml.behavior.communicationModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("005b5928-c4bf-1fd8-97fe-001ec947cd2a")
public class CommunicationMessageData extends UmlModelElementData {
    @objid ("9ecaa27d-bca9-41c7-82c0-8fd120d2f298")
    Object mArgument = "";

    @objid ("8a48333d-9e63-46a2-abe7-269a855b2cc1")
    Object mSequence = "";

    @objid ("492a509e-578f-4cd3-a7dc-f882aeae9590")
    Object mSortOfMessage = MessageSort.SYNCCALL;

    @objid ("f3c88132-bf20-4852-8cad-22dacd59d493")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("3e6127c7-b0ee-4c8c-abd1-d7ef43cde928")
    SmObjectImpl mChannel;

    @objid ("38fc75d6-8f83-41c2-a687-d9bc9f56e50f")
    SmObjectImpl mInvertedChannel;

    @objid ("693975a1-3709-486e-b625-d3db0ffa85fc")
    SmObjectImpl mInvoked;

    @objid ("5542c2fb-3dbd-45fd-8f5d-4c1161112ff7")
    SmObjectImpl mSignalSignature;

    @objid ("7c21e8ad-6c75-4a2e-aacd-9f181ec69ccb")
    public CommunicationMessageData(CommunicationMessageSmClass smClass) {
        super(smClass);
    }

}
