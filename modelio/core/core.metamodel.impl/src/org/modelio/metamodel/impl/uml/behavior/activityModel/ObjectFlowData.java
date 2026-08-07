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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectFlowEffectKind;

@objid ("0038ffd6-c4bf-1fd8-97fe-001ec947cd2a")
public class ObjectFlowData extends ActivityEdgeData {
    @objid ("2e771145-dc03-4e06-bc21-76cb01f9432e")
    Object mTransformationBehavior = "";

    @objid ("f880c5b4-686e-4858-8e85-9882f2ff2d60")
    Object mSelectionBehavior = "";

    @objid ("9208bff9-aa54-41bb-8654-654b450280db")
    Object mIsMultiCast = false;

    @objid ("2fc95ce5-280c-430a-b07c-2793601df3a4")
    Object mIsMultiReceive = false;

    @objid ("094fdf19-b412-40bf-a31c-0fbd3ebff025")
    Object mEffect = ObjectFlowEffectKind.READFLOW;

    @objid ("e07066e3-5719-4965-8325-f38694fc39e7")
    public ObjectFlowData(ObjectFlowSmClass smClass) {
        super(smClass);
    }

}
