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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("001afd60-c4bf-1fd8-97fe-001ec947cd2a")
public class RaisedExceptionData extends UmlModelElementData {
    @objid ("83d78f2e-e2d6-4fa3-9efd-ed81719971ac")
    SmObjectImpl mThrownType;

    @objid ("284366c1-f715-4635-9a44-8cbb4d000cb8")
    SmObjectImpl mThrower;

    @objid ("2483f95d-b37d-496e-9d95-758f68bc78cf")
    public RaisedExceptionData(RaisedExceptionSmClass smClass) {
        super(smClass);
    }

}
