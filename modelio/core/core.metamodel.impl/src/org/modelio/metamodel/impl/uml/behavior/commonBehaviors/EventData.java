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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.behavior.commonBehaviors.EventType;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0042dd58-c4bf-1fd8-97fe-001ec947cd2a")
public class EventData extends UmlModelElementData {
    @objid ("f76ca674-d992-438f-bb4d-f170c9d2a82a")
    Object mExpression = "";

    @objid ("60b3d4c6-a80f-49ab-986c-dc881f5932e6")
    Object mKind = EventType.SIGNALEVENT;

    @objid ("7f156055-54f0-40ca-86d0-ea9a39b364af")
    List<SmObjectImpl> mTriggered = null;

    @objid ("8840adb8-b474-48a0-9850-de47cc94c93d")
    SmObjectImpl mModel;

    @objid ("7ed5dbaa-be99-4862-afe9-2701972d4b28")
    List<SmObjectImpl> mOrigin = null;

    @objid ("b0f5a72c-d5e0-45fb-abac-b1325098dd55")
    SmObjectImpl mCalled;

    @objid ("3444bec0-c99c-4c2c-8180-5bef3c84ff1c")
    SmObjectImpl mComposed;

    @objid ("e6061904-41f4-4a4a-bca6-befde63d3fc7")
    public EventData(EventSmClass smClass) {
        super(smClass);
    }

}
