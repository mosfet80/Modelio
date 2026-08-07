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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("004e9526-c4bf-1fd8-97fe-001ec947cd2a")
public class ConnectionPointReferenceData extends StateVertexData {
    @objid ("a5de858d-93df-4d0c-82db-9a3578191ebc")
    SmObjectImpl mExit;

    @objid ("06d29fff-eb73-4e1d-8615-6a5b73a7c218")
    SmObjectImpl mEntry;

    @objid ("217cae4a-ed6f-47c3-9965-7ce54f6bc56e")
    SmObjectImpl mOwnerState;

    @objid ("053413fb-9269-47ba-b3e4-1de51fb024bc")
    public ConnectionPointReferenceData(ConnectionPointReferenceSmClass smClass) {
        super(smClass);
    }

}
