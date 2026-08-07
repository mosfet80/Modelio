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
import org.modelio.metamodel.uml.statik.KindOfAccess;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("001f7f70-c4bf-1fd8-97fe-001ec947cd2a")
public class StructuralFeatureData extends FeatureData {
    @objid ("54d7c9ed-7cbd-4e50-8c86-5059dff3581a")
    Object mChangeable = KindOfAccess.READWRITE;

    @objid ("38b4a7bb-e6ec-4846-9b8d-6e1aafeb3264")
    Object mIsDerived = false;

    @objid ("406bac30-da05-4bab-a810-fbdbab284b1c")
    Object mIsOrdered = false;

    @objid ("4bac1e3a-33df-44c5-80dc-54cbde22414f")
    Object mIsUnique = false;

    @objid ("34ac5e1c-08b1-40de-bee1-3d0663acf7d7")
    Object mMultiplicityMin = "0";

    @objid ("5f0ae130-7bab-41c1-a4fa-c9d72ee633d9")
    Object mMultiplicityMax = "1";

    @objid ("41bb7ee5-5e35-4342-a9ac-ab79cbc86ece")
    List<SmObjectImpl> mRealizedInformationFlow = null;

    @objid ("8af41f08-6f18-4db1-90dd-3b9e11bb3772")
    public StructuralFeatureData(StructuralFeatureSmClass smClass) {
        super(smClass);
    }

}
