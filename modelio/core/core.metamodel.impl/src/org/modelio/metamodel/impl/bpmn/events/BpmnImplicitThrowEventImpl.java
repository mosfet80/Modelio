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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import java.util.Collections;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnComplexBehaviorDefinition;
import org.modelio.metamodel.bpmn.events.BpmnImplicitThrowEvent;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("008e2808-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnImplicitThrowEventImpl extends BpmnThrowEventImpl implements BpmnImplicitThrowEvent {
    @objid ("7ca13a62-d857-451f-9cf8-b3545e5ae727")
    @Override
    public BpmnComplexBehaviorDefinition getOwner() {
        Object obj = getDepVal(((BpmnImplicitThrowEventSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof BpmnComplexBehaviorDefinition)? (BpmnComplexBehaviorDefinition)obj : null;
    }

    @objid ("1d2da5c8-a21d-40b0-a13a-413838981432")
    @Override
    public void setOwner(BpmnComplexBehaviorDefinition value) {
        appendDepVal(((BpmnImplicitThrowEventSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("9203c8ab-e57b-4457-a871-43f989418007")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((BpmnImplicitThrowEventSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("2bec7d18-b8b2-42a6-a0a7-9e1bf971d89d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((BpmnImplicitThrowEventSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("f4738efc-b055-49a5-8031-6a82f55d90f8")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnImplicitThrowEvent(this);
    }

}
