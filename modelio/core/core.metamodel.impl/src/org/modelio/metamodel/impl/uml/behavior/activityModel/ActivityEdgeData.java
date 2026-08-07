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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00275f10-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityEdgeData extends UmlModelElementData {
    @objid ("98ad06ce-ddf2-4067-8d5f-cc4d5354598a")
    Object mGuard = "";

    @objid ("7af62a89-40ac-4d87-b8e9-2db86fee3b9c")
    Object mWeight = "1";

    @objid ("a0550591-3cf6-41b8-a337-5321bfd54442")
    SmObjectImpl mTarget;

    @objid ("7b03d29b-3279-4b0e-8616-ae8341bf5a74")
    SmObjectImpl mSource;

    @objid ("8a5e7e2b-fc2f-4cd4-b4a2-d6a93d07b1db")
    SmObjectImpl mInterrupts;

    @objid ("a3ac68aa-87d0-446a-b63b-91c38ae9e666")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("026b3fdd-4d0e-4977-9398-4df9a700e7f2")
    public ActivityEdgeData(ActivityEdgeSmClass smClass) {
        super(smClass);
    }

}
