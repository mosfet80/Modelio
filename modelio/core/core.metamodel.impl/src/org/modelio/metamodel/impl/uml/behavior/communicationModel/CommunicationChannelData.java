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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("67558b34-b4c9-476e-939c-3da1dcc447df")
public class CommunicationChannelData extends UmlModelElementData {
    @objid ("47878f6d-5003-42af-88ca-0b061cbc06f1")
    List<SmObjectImpl> mStartToEndMessage = null;

    @objid ("efee1e7b-2808-4b14-bc69-64e923038cee")
    SmObjectImpl mChannel;

    @objid ("7659331a-9d75-465a-abbb-16fd6babb27e")
    SmObjectImpl mStart;

    @objid ("0ba85940-4bb7-4215-bd3b-46d255707ada")
    SmObjectImpl mNaryChannel;

    @objid ("f4c2eac7-4c84-43ed-8e82-76d2bc82df54")
    List<SmObjectImpl> mEndToStartMessage = null;

    @objid ("db941ef3-d3e1-48f9-92c2-9542443b0aab")
    SmObjectImpl mEnd;

    @objid ("85f84047-60d8-4bfb-b339-bea0b5eba9ac")
    public CommunicationChannelData(CommunicationChannelSmClass smClass) {
        super(smClass);
    }

}
