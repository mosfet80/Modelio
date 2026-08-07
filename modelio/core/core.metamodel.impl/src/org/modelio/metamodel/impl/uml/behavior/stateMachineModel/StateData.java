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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0053d27a-c4bf-1fd8-97fe-001ec947cd2a")
public class StateData extends StateVertexData {
    @objid ("7c54d16f-0b2b-43aa-aa94-7ef911371063")
    List<SmObjectImpl> mExitPoint = null;

    @objid ("ef9fe147-ba5e-432a-90b2-2f28870a79b7")
    List<SmObjectImpl> mDeffered = null;

    @objid ("2361d9da-b4f0-414a-92f4-2ce3d3121eb0")
    List<SmObjectImpl> mInternal = null;

    @objid ("8c921e4e-eeeb-453b-9be9-ccfee3e373f8")
    List<SmObjectImpl> mEntryPoint = null;

    @objid ("85e85fa8-37ae-4ff5-a3d1-a8a02cfa5f32")
    List<SmObjectImpl> mOwnedRegion = null;

    @objid ("e778e38a-98f4-44f2-961e-a55554fdd9ac")
    List<SmObjectImpl> mRequiredStateOf = null;

    @objid ("ec4999db-519d-4215-9d61-777559d933d7")
    List<SmObjectImpl> mConnection = null;

    @objid ("e570547b-fa44-4d2b-af7e-5d67fa2dc336")
    SmObjectImpl mSubMachine;

    @objid ("9e97208c-a2bf-44d5-8014-a76997c8157e")
    public StateData(StateSmClass smClass) {
        super(smClass);
    }

}
