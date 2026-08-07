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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.OpaqueBehavior;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0041b806-c4bf-1fd8-97fe-001ec947cd2a")
public class OpaqueBehaviorImpl extends BehaviorImpl implements OpaqueBehavior {
    @objid ("ef2d1f8e-614a-445d-b7c6-177e2afa6296")
    @Override
    public String getBody() {
        return (String) getAttVal(((OpaqueBehaviorSmClass)getClassOf()).getBodyAtt());
    }

    @objid ("8e19c9c8-9a3d-4741-9834-85a770eca0c1")
    @Override
    public void setBody(String value) {
        setAttVal(((OpaqueBehaviorSmClass)getClassOf()).getBodyAtt(), value);
    }

    @objid ("5dbcd9fb-7e68-4710-bb68-6f080bf6f089")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("72ea2d60-2ac4-45dd-ab51-2b5caf6685fe")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("e440f4db-ac5b-4094-beb1-2e4b16e123a6")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitOpaqueBehavior(this);
    }

}
