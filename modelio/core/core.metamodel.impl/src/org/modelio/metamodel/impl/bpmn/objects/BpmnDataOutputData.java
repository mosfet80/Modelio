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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00061d64-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnDataOutputData extends BpmnItemAwareElementData {
    @objid ("e5586a4e-f8f9-4b71-be2c-98e46dba1b0f")
    Object mIsCollection = false;

    @objid ("4a2fdddb-8408-4564-8a7e-549cfe4cd412")
    SmObjectImpl mOwnerActivity;

    @objid ("9479bb4f-07a3-47a1-ab36-336779f9df8d")
    SmObjectImpl mCatched;

    @objid ("a4088423-1a16-4699-9798-afde18dbb649")
    SmObjectImpl mOwnerLoopCharacteristics;

    @objid ("7fb66ee0-cfd1-4ae9-b524-1acb0da9d308")
    public BpmnDataOutputData(BpmnDataOutputSmClass smClass) {
        super(smClass);
    }

}
