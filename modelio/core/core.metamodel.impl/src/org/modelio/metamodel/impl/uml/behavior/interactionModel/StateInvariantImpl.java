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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.StateInvariant;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004bb34c-c4bf-1fd8-97fe-001ec947cd2a")
public class StateInvariantImpl extends OccurrenceSpecificationImpl implements StateInvariant {
    @objid ("a1592c01-b7a2-4c90-850d-a2278b711d29")
    @Override
    public String getBody() {
        return (String) getAttVal(((StateInvariantSmClass)getClassOf()).getBodyAtt());
    }

    @objid ("d210fa5e-a47f-4587-8245-d91d7a2e992e")
    @Override
    public void setBody(String value) {
        setAttVal(((StateInvariantSmClass)getClassOf()).getBodyAtt(), value);
    }

    @objid ("07b71f6c-19ba-4dfb-b60e-79f05aa83579")
    @Override
    public int getEndLineNumber() {
        return (Integer) getAttVal(((StateInvariantSmClass)getClassOf()).getEndLineNumberAtt());
    }

    @objid ("451898a5-0938-4fff-81de-a3e7f69cf4f1")
    @Override
    public void setEndLineNumber(int value) {
        setAttVal(((StateInvariantSmClass)getClassOf()).getEndLineNumberAtt(), value);
    }

    @objid ("57b9b90e-7ec2-413d-872b-5a41cf4a3086")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("f3f6d6c4-fe62-4b8a-b33b-b1058b023648")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("dd015690-d198-4f71-9991-53df07f1dc91")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitStateInvariant(this);
    }

}
