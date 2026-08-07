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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ValuePin;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("003f166e-c4bf-1fd8-97fe-001ec947cd2a")
public class ValuePinImpl extends InputPinImpl implements ValuePin {
    @objid ("9049ec81-cbea-4dc6-81e9-0d709141504c")
    @Override
    public String getValue() {
        return (String) getAttVal(((ValuePinSmClass)getClassOf()).getValueAtt());
    }

    @objid ("8b8ae9f2-7615-4fb8-a4c5-5f24c1dd109a")
    @Override
    public void setValue(String value) {
        setAttVal(((ValuePinSmClass)getClassOf()).getValueAtt(), value);
    }

    @objid ("c2df0076-5efc-489f-9791-4109501ea5b6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("b2d9b215-9fd8-4bc1-9838-47aacca2ddd9")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("bb036d8e-ec5d-466f-a58b-42a5fa0e5ca7")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitValuePin(this);
    }

}
