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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.ParameterData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00416784-c4bf-1fd8-97fe-001ec947cd2a")
public class BehaviorParameterData extends ParameterData {
    @objid ("33b1628f-2ba2-49be-bba3-1e166c9db97f")
    List<SmObjectImpl> mRepresentingObjectNode = null;

    @objid ("506403a1-983b-4243-af6a-b479dade7992")
    SmObjectImpl mOwner;

    @objid ("797dc466-1bf3-40e9-9428-2f075b161a34")
    SmObjectImpl mMapped;

    @objid ("d5a43cee-c658-4e37-a416-80826710d6e4")
    public BehaviorParameterData(BehaviorParameterSmClass smClass) {
        super(smClass);
    }

}
