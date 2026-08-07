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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0046e4ac-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionData extends BehaviorData {
    @objid ("55f4e263-5fc5-469d-a570-d3f3a37b4cbb")
    List<SmObjectImpl> mFormalGate = null;

    @objid ("7d759ded-0efa-4a3d-87e4-77a4fb496502")
    List<SmObjectImpl> mFragment = null;

    @objid ("fc3e3871-9dfc-423d-9132-494d020ad4f9")
    List<SmObjectImpl> mOwnedLine = null;

    @objid ("fa14b293-e259-459e-87a9-c811858dc45d")
    List<SmObjectImpl> mReferedUse = null;

    @objid ("811cda57-603b-43a3-bbbc-16aab871de6b")
    public InteractionData(InteractionSmClass smClass) {
        super(smClass);
    }

}
