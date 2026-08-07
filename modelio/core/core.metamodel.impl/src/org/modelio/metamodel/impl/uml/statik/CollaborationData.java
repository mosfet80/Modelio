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

@objid ("00044bf6-c4bf-1fd8-97fe-001ec947cd2a")
public class CollaborationData extends NameSpaceData {
    @objid ("52ee4d46-bab3-4628-afae-82836883c729")
    Object mIsConcurrent = false;

    @objid ("dde19e30-655a-4a6a-9217-2e7d9fa3d552")
    SmObjectImpl mORepresented;

    @objid ("3f4c13ac-cd0e-4e2f-9768-9fdc541594c9")
    SmObjectImpl mBRepresented;

    @objid ("e10ec353-15a1-4888-9d69-d1d657b3ae73")
    List<SmObjectImpl> mOccurrence = null;

    @objid ("e32b003f-150b-4817-af69-e82583fbc71e")
    public CollaborationData(CollaborationSmClass smClass) {
        super(smClass);
    }

}
