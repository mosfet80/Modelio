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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("005a6928-c4bf-1fd8-97fe-001ec947cd2a")
public class CommunicationInteractionData extends BehaviorData {
    @objid ("5d2994e3-a3fa-4c52-a40e-f361b3c8c4be")
    List<SmObjectImpl> mOwned = null;

    @objid ("4cacad9b-6beb-4f04-a00c-68ac433c6ea5")
    public CommunicationInteractionData(CommunicationInteractionSmClass smClass) {
        super(smClass);
    }

}
