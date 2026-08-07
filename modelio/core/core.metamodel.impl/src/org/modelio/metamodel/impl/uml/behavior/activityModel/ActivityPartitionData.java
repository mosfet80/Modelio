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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("002a3320-c4bf-1fd8-97fe-001ec947cd2a")
public class ActivityPartitionData extends ActivityGroupData {
    @objid ("49137368-c2fa-4870-b9ce-5410dd31b743")
    Object mIsDimension = false;

    @objid ("1c8be7f3-3534-4463-ada2-15b77b149033")
    Object mIsExternal = false;

    @objid ("33d3df27-f9db-4f69-9b44-50042bef56e3")
    SmObjectImpl mRepresented;

    @objid ("1075b44e-018a-44eb-8575-5b5f9b272ab4")
    List<SmObjectImpl> mContainedNode = null;

    @objid ("2f01ce77-d888-410d-a10e-300ece6ba476")
    List<SmObjectImpl> mOutgoing = null;

    @objid ("dc3d9099-e64a-4cd3-822c-c5e90ec3d3bd")
    SmObjectImpl mSuperPartition;

    @objid ("25bf1c1d-059b-4e74-93f3-417050044e63")
    List<SmObjectImpl> mSubPartition = null;

    @objid ("131cfb45-29fb-4d22-8b74-c8848dac90b8")
    List<SmObjectImpl> mIncoming = null;

    @objid ("203e885c-b9a0-4473-af78-2126f5923b14")
    public ActivityPartitionData(ActivityPartitionSmClass smClass) {
        super(smClass);
    }

}
