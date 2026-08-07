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

@objid ("0015b9f4-c4bf-1fd8-97fe-001ec947cd2a")
public class PackageData extends NameSpaceData {
    @objid ("f9f1d7c1-47d8-476a-8402-a4c6a236a393")
    Object mIsInstantiable = false;

    @objid ("6aa72d4b-ceb1-4f14-abdd-0d4bfe05da06")
    List<SmObjectImpl> mReceivingMerge = null;

    @objid ("0764ebc2-591b-4abf-ab9b-28d21c4bd02c")
    SmObjectImpl mRepresented;

    @objid ("6bd67ca2-dc6e-408f-bf95-37f18786a11f")
    List<SmObjectImpl> mMerge = null;

    @objid ("4f827d50-27ec-4f12-9f3a-f2dcc6c10d02")
    List<SmObjectImpl> mPackageImporting = null;

    @objid ("4af386f1-65f0-434a-a824-65bd53be9d4e")
    public PackageData(PackageSmClass smClass) {
        super(smClass);
    }

}
