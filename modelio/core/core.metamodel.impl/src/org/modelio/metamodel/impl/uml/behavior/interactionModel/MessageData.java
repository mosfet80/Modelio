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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageKind;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("004999e0-c4bf-1fd8-97fe-001ec947cd2a")
public class MessageData extends UmlModelElementData {
    @objid ("c72c22ff-7a2b-46a9-bca0-657fead41c00")
    Object mArgument = "";

    @objid ("32c92ca0-2c84-4657-97a6-7cd87d583d48")
    Object mKindOfMessage = MessageKind.UNKNOWNKIND;

    @objid ("9fcf5b24-e8c7-49ad-9d62-da25464e83cf")
    Object mSortOfMessage = MessageSort.SYNCCALL;

    @objid ("e7cceaf5-f78b-462a-873c-85c215af5863")
    Object mSequence = "";

    @objid ("e3ca808d-a40a-4b02-89ca-af2076c97c4d")
    SmObjectImpl mSignalSignature;

    @objid ("1fa04d63-0ee6-4c48-916c-66b4d14ab149")
    SmObjectImpl mReceiveEvent;

    @objid ("8ef629e9-f385-4384-a173-09746ea58bb0")
    SmObjectImpl mSendEvent;

    @objid ("7c84ed22-5636-4f93-b0a3-dcfd012c4f37")
    SmObjectImpl mInvoked;

    @objid ("7cb39a44-efff-4af2-bbb5-a2db27f329b1")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("03135fe2-436d-4bda-a073-f33bf59689e3")
    public MessageData(MessageSmClass smClass) {
        super(smClass);
    }

}
