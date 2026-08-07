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

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00169568-c4bf-1fd8-97fe-001ec947cd2a")
public class PackageImportData extends UmlModelElementData {
    @objid ("80c959a7-f145-420d-af34-8ae2574bef5c")
    Object mVisibility = VisibilityMode.PRIVATE;

    @objid ("81ffefb4-1450-4300-82be-53601b214cf0")
    SmObjectImpl mImportingOperation;

    @objid ("df471efa-0e2c-4c82-ac21-116086403381")
    SmObjectImpl mImportingNameSpace;

    @objid ("58bbe286-2fd8-4163-976e-9382a1437c4f")
    SmObjectImpl mImportedPackage;

    @objid ("60bd9b8b-8a1f-4967-8254-fd06c1782dd1")
    public PackageImportData(PackageImportSmClass smClass) {
        super(smClass);
    }

}
