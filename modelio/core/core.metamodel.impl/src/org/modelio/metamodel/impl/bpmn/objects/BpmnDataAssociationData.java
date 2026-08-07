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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0004de90-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataAssociationData extends BpmnBaseElementData {
    @objid ("b308d2d4-5100-4cd8-b612-d1d9e21502a8")
    Object mAssignment = "";

    @objid ("04c1df60-fd37-4af9-9c6d-a9b582271fe8")
    Object mTransfomation = "";

    @objid ("fddee698-f383-4be1-b180-468e7f8b685f")
    Object mLanguage = "";

    @objid ("79589570-d8d1-434e-b944-c53752e87fd9")
    List<SmObjectImpl> mSourceRef = null;

    @objid ("8f85c482-c981-4b9c-92d5-a3186c8c55a9")
    SmObjectImpl mTargetRef;

    @objid ("bc311868-a6e4-4280-a01e-ae20abfb285b")
    SmObjectImpl mEndingActivity;

    @objid ("55a3dce4-70f6-48ac-a851-7d77e92e3a8f")
    SmObjectImpl mStartingActivity;

    @objid ("23750d85-fe4c-4830-b0fd-ab7e61134ed8")
    SmObjectImpl mStartingEvent;

    @objid ("5bf3ed70-9b37-472e-b5b1-6553f2a8f3a7")
    List<SmObjectImpl> mVisualShortCut = null;

    @objid ("8f2a43c0-0cc7-4132-8d52-72ebc3972c9f")
    SmObjectImpl mEndingEvent;

    @objid ("d10b6614-19f0-49b6-abeb-50d8f790327f")
    public BpmnDataAssociationData(BpmnDataAssociationSmClass smClass) {
        super(smClass);
    }

}
