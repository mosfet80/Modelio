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

@objid ("001da934-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateParameterData extends GeneralClassData {
    @objid ("1389c5ed-5098-4bb2-bc99-28f2425a36b6")
    Object mDefaultValue = "";

    @objid ("e4ba6584-77b6-4c69-844c-307d7ef61bcd")
    Object mIsValueParameter = false;

    @objid ("c1dc5a79-9cac-4548-bf04-c3fa59192b52")
    List<SmObjectImpl> mParameterSubstitution = null;

    @objid ("c6b23e74-8719-4d8e-8bcd-e469932a778b")
    SmObjectImpl mType;

    @objid ("38896bcb-3f07-468f-8ae1-4cd1a9a2c36a")
    SmObjectImpl mParameterized;

    @objid ("8e32f076-1055-4f30-81b4-3587ee737f98")
    SmObjectImpl mOwnedParameterElement;

    @objid ("0978d73b-88bb-4eee-aa08-44e9c7bb74bc")
    SmObjectImpl mDefaultType;

    @objid ("24d43de7-cab6-44b4-b1b5-9e6da5222ba5")
    SmObjectImpl mParameterizedOperation;

    @objid ("ac5ac9ba-2f99-4f54-8f9f-d3b1d2d95d2f")
    public TemplateParameterData(TemplateParameterSmClass smClass) {
        super(smClass);
    }

}
