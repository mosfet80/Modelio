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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("004a25fe-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class MessageEndData extends OccurrenceSpecificationData {
    @objid ("e83f71cb-5cbf-4cef-959f-735f5a64c493")
    SmObjectImpl mReceivedMessage;

    @objid ("1c3b743c-d7b3-4d37-bf43-7dcfe4e79502")
    SmObjectImpl mSentMessage;

    @objid ("97652282-202c-4ee8-b477-b79dd6a5468e")
    public MessageEndData(MessageEndSmClass smClass) {
        super(smClass);
    }

}
