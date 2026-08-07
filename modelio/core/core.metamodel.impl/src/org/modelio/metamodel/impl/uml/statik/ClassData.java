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
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("00027d80-c4bf-1fd8-97fe-001ec947cd2a")
public class ClassData extends GeneralClassData {
    @objid ("d7de398d-7b43-4021-b32e-af9769e5d35e")
    Object mIsActive = false;

    @objid ("cc36eb21-dbae-490c-9921-eb61245bc985")
    Object mIsMain = false;

    @objid ("1711ee32-b72b-44cc-afde-62a8f6d3a669")
    SmObjectImpl mLinkToAssociation;

    @objid ("3a9642b3-ac19-48f6-be2f-14919e03943f")
    public ClassData(ClassSmClass smClass) {
        super(smClass);
    }

}
