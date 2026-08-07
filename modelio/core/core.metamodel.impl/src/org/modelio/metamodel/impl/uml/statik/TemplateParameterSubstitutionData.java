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

@objid ("001e961e-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateParameterSubstitutionData extends UmlModelElementData {
    @objid ("8f89bbcf-e014-4d0b-845c-2bf14c457ff6")
    Object mValue = "";

    @objid ("43944065-1bed-4957-a322-512e2668c682")
    SmObjectImpl mOwner;

    @objid ("7b14527e-8406-47db-892f-0a4195e97ccc")
    SmObjectImpl mActual;

    @objid ("12ad24a9-e3f7-4854-b65b-2f42e0d3748b")
    SmObjectImpl mFormalParameter;

    @objid ("65573732-3e6f-421b-a2c1-2ce719576bd2")
    public TemplateParameterSubstitutionData(TemplateParameterSubstitutionSmClass smClass) {
        super(smClass);
    }

}
