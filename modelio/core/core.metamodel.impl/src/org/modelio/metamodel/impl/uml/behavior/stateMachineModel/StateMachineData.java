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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorData;
import org.modelio.metamodel.uml.behavior.stateMachineModel.KindOfStateMachine;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00546122-c4bf-1fd8-97fe-001ec947cd2a")
public class StateMachineData extends BehaviorData {
    @objid ("582be1af-b4e7-4bae-bc7a-ad0129652bd3")
    Object mKind = KindOfStateMachine.DYNAMIC;

    @objid ("9cf77fcf-ff79-44ec-a3a4-e5dcbe7a6d02")
    SmObjectImpl mTop;

    @objid ("12948ad6-ed74-4f4b-bf84-e78ff1fb91a4")
    List<SmObjectImpl> mSubmachineState = null;

    @objid ("360084e1-4741-412e-a3b9-d54292cb6125")
    List<SmObjectImpl> mEntryPoint = null;

    @objid ("c9bccfe5-943d-40d3-ad23-a04f56a863ea")
    List<SmObjectImpl> mExitPoint = null;

    @objid ("6bd9a1f6-3929-4c3e-9da2-a96e08c8fb00")
    public StateMachineData(StateMachineSmClass smClass) {
        super(smClass);
    }

}
