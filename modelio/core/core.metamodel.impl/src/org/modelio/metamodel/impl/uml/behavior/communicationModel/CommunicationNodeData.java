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

@objid ("005adeee-c4bf-1fd8-97fe-001ec947cd2a")
public class CommunicationNodeData extends UmlModelElementData {
    @objid ("059c0808-f6b1-4cf9-98af-56029de83ed3")
    Object mSelector = "";

    @objid ("12a8d4d2-3c57-472f-a162-2a237abd480a")
    SmObjectImpl mOwner;

    @objid ("5ec2da56-f40d-48ef-8d60-f745b42f4ae0")
    SmObjectImpl mRepresented;

    @objid ("114f0ce3-03a5-44be-a400-3336a80836f6")
    List<SmObjectImpl> mStarted = null;

    @objid ("bc4ad98f-8a92-4767-84f1-bcd5e8d5a13b")
    List<SmObjectImpl> mEnded = null;

    @objid ("665e8842-2435-496d-99da-ad02e0188d37")
    public CommunicationNodeData(CommunicationNodeSmClass smClass) {
        super(smClass);
    }

}
