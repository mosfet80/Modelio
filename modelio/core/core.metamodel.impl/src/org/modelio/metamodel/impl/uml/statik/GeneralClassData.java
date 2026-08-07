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
package org.modelio.metamodel.impl.uml.statik;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("000c3550-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class GeneralClassData extends ClassifierData {
    @objid ("fbbec561-424b-45c7-ac51-ea5d9c7d9e9f")
    Object mIsElementary = false;

    @objid ("389bf9e5-9ef6-4286-bfad-a7402415fb1e")
    List<SmObjectImpl> mOccurence = null;

    @objid ("35436346-6460-4cf2-ab75-7a8c970adde7")
    SmObjectImpl mExceptionInput;

    @objid ("cd3e3f64-9aee-4b8a-a1ae-a3e18ada13dc")
    List<SmObjectImpl> mObject = null;

    @objid ("29921b8c-874d-4840-ba79-a02fd5f26a43")
    List<SmObjectImpl> mSRepresentation = null;

    @objid ("5afa21c1-f7cd-40d2-b6fc-7e0438a51639")
    List<SmObjectImpl> mOccurenceObjectNode = null;

    @objid ("0979169b-5b00-4491-a4f7-23dc429fae11")
    public GeneralClassData(GeneralClassSmClass smClass) {
        super(smClass);
    }

}
