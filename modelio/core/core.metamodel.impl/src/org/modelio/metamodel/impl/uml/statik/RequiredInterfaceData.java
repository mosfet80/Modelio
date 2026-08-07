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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("001be5d6-c4bf-1fd8-97fe-001ec947cd2a")
public class RequiredInterfaceData extends UmlModelElementData {
    @objid ("785abbd3-4cf5-4c2e-bc68-02552c6d4666")
    List<SmObjectImpl> mRequiredElement = null;

    @objid ("0d88ad45-f6b3-4528-aa5d-8ab57b701c59")
    List<SmObjectImpl> mProvider = null;

    @objid ("2c7f0f2a-8c1f-4652-b2fb-a6f81bedf99c")
    SmObjectImpl mRequiring;

    @objid ("6332704c-99be-4723-bb69-1298a7933778")
    List<SmObjectImpl> mNaryProvider = null;

    @objid ("38c20524-29de-487d-bee3-f70137f03908")
    public RequiredInterfaceData(RequiredInterfaceSmClass smClass) {
        super(smClass);
    }

}
