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

@objid ("009851b6-c4be-1fd8-97fe-001ec947cd2a")
public class AttributeData extends StructuralFeatureData {
    @objid ("10a3869c-9db0-46cf-ace9-2046cf70f722")
    Object mTypeConstraint = "";

    @objid ("3f3dbc75-b487-4630-a50a-b52a03e620a2")
    Object mValue = "";

    @objid ("146a0819-e3c7-4b82-99ae-fbbc980e91f9")
    Object mTargetIsClass = false;

    @objid ("0ecc64b6-2657-4f63-93e7-94a6b4d8c4b2")
    SmObjectImpl mType;

    @objid ("d2b776af-7eff-4d1c-a185-9e198e9ae9cb")
    SmObjectImpl mOwner;

    @objid ("33a06920-53d5-43f1-bd87-7327b0dca534")
    List<SmObjectImpl> mOccurence = null;

    @objid ("a39f08f1-41c0-4d1c-966c-ad0abe626c86")
    List<SmObjectImpl> mRepresentingObjectNode = null;

    @objid ("40330a83-6dad-43b5-8861-9b58fdb773b7")
    SmObjectImpl mQualified;

    @objid ("7ffe2a8e-5190-4e5b-9458-e0a6231852aa")
    public AttributeData(AttributeSmClass smClass) {
        super(smClass);
    }

}
