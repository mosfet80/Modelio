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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementData;
import org.modelio.metamodel.uml.behavior.commonBehaviors.ParameterEffectKind;
import org.modelio.metamodel.uml.statik.PassingMode;
import org.modelio.vcore.smkernel.SmObjectImpl;

@objid ("0018552e-c4bf-1fd8-97fe-001ec947cd2a")
public class ParameterData extends UmlModelElementData {
    @objid ("ff2a9803-0bec-4ed2-bfe0-3d4f8b0fa19f")
    Object mParameterPassing = PassingMode.IN;

    @objid ("245ba33e-b742-4476-8dd5-c5f65b7a63e4")
    Object mMultiplicityMin = "1";

    @objid ("69805389-1cfa-41a4-9304-e800643225ca")
    Object mMultiplicityMax = "1";

    @objid ("6e2c775f-5e9a-4cc6-ac39-0f30f925fa40")
    Object mTypeConstraint = "";

    @objid ("1e1c4853-55ab-4d81-a949-21df4695e36f")
    Object mDefaultValue = "";

    @objid ("07b59f91-a854-4a11-bd30-ae1aeefc7dfb")
    Object mIsOrdered = false;

    @objid ("e24fec69-2463-4cb8-905c-136ed994d477")
    Object mIsUnique = false;

    @objid ("ec3d9c4b-1c9d-444d-94ed-b9603a24be33")
    Object mIsException = false;

    @objid ("4f035785-e470-411e-b404-c7499e15c2f0")
    Object mIsStream = false;

    @objid ("5700fb39-267c-40da-b260-abf26ab5ee69")
    Object mEffect = ParameterEffectKind.READEFFECT;

    @objid ("5f25c642-db3f-40e4-a394-2241a5121ee3")
    SmObjectImpl mType;

    @objid ("a9c232a9-1e48-4b28-a7ec-c721c3f3a27d")
    SmObjectImpl mComposed;

    @objid ("21491096-13e7-48d1-99ca-465689162b62")
    List<SmObjectImpl> mMatching = null;

    @objid ("0c370979-2ad4-4fba-89f2-5e4147ee0e68")
    List<SmObjectImpl> mSRepresentation = null;

    @objid ("be385cb8-6b41-4e40-b6c8-c57587052d1f")
    SmObjectImpl mReturned;

    @objid ("115321de-e691-4964-8cf4-81764e32f1a8")
    List<SmObjectImpl> mBehaviorParam = null;

    @objid ("ca1d6e34-04ad-4fcc-82fb-533c9bea29c0")
    public ParameterData(ParameterSmClass smClass) {
        super(smClass);
    }

}
