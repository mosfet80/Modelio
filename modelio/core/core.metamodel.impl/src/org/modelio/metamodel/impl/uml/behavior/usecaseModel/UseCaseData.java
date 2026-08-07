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
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.statik.GeneralClassData;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0058d388-c4bf-1fd8-97fe-001ec947cd2a")
public class UseCaseData extends GeneralClassData {
    @objid ("4b84652d-04b3-4846-9ccc-24a404a76985")
    List<SmObjectImpl> mUsed = null;

    @objid ("734fa14b-c45f-4817-86b3-20fca448bb11")
    List<SmObjectImpl> mOwnedExtension = null;

    @objid ("ca49155f-93bc-43ae-aee6-8073671c6c8a")
    List<SmObjectImpl> mUser = null;

    @objid ("76c05b07-2e35-4e37-9ae0-f389b77b41d1")
    public UseCaseData(UseCaseSmClass smClass) {
        super(smClass);
    }

}
