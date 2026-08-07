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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.CallBehaviorAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0040c504-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BehaviorImpl extends UmlModelElementImpl implements Behavior {
    @objid ("264a3bcb-1cad-4936-ab57-7fad415290fd")
    @Override
    public boolean isIsReentrant() {
        return (Boolean) getAttVal(((BehaviorSmClass)getClassOf()).getIsReentrantAtt());
    }

    @objid ("cd79fd39-f0a2-437a-8780-eb4fa3f68b82")
    @Override
    public void setIsReentrant(boolean value) {
        setAttVal(((BehaviorSmClass)getClassOf()).getIsReentrantAtt(), value);
    }

    @objid ("94e78da4-33c3-4d78-8d22-c2c5f05fac16")
    @Override
    public NameSpace getOwner() {
        Object obj = getDepVal(((BehaviorSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("42938ce5-f13a-49a9-a734-c98896b97e61")
    @Override
    public void setOwner(NameSpace value) {
        appendDepVal(((BehaviorSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("8e9b24f6-880b-4fa7-8b04-75b4c01b8411")
    @Override
    public EList<BehaviorParameter> getParameter() {
        return new SmList<>(this, ((BehaviorSmClass)getClassOf()).getParameterDep());
    }

    @objid ("734ad345-d09e-4d44-8530-64339ef3ded0")
    @Override
    public <T extends BehaviorParameter> List<T> getParameter(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BehaviorParameter element : getParameter()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("11d08ab5-cba2-41e1-9ba8-7f167d0c1092")
    @Override
    public Operation getOwnerOperation() {
        Object obj = getDepVal(((BehaviorSmClass)getClassOf()).getOwnerOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("3c0e5392-fdca-418f-a528-2fd54823c380")
    @Override
    public void setOwnerOperation(Operation value) {
        appendDepVal(((BehaviorSmClass)getClassOf()).getOwnerOperationDep(), (SmObjectImpl)value);
    }

    @objid ("e872eceb-9e69-49e1-b3c4-9f795f397f14")
    @Override
    public EList<Collaboration> getOwnedCollaboration() {
        return new SmList<>(this, ((BehaviorSmClass)getClassOf()).getOwnedCollaborationDep());
    }

    @objid ("e03482e2-4e46-45ed-b1b4-52ab89150a8c")
    @Override
    public <T extends Collaboration> List<T> getOwnedCollaboration(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Collaboration element : getOwnedCollaboration()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("31fbea05-0a7d-4b7a-8595-20cfae3da897")
    @Override
    public EList<CallBehaviorAction> getCaller() {
        return new SmList<>(this, ((BehaviorSmClass)getClassOf()).getCallerDep());
    }

    @objid ("1c7ed5f9-d3dd-4d93-b9fa-1665d211e435")
    @Override
    public <T extends CallBehaviorAction> List<T> getCaller(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CallBehaviorAction element : getCaller()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("66a6595e-5532-4415-86ef-76100e400d69")
    @Override
    public EList<Event> getEComponent() {
        return new SmList<>(this, ((BehaviorSmClass)getClassOf()).getEComponentDep());
    }

    @objid ("12976a68-4ce9-46a5-b891-b2a6a28b9576")
    @Override
    public <T extends Event> List<T> getEComponent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Event element : getEComponent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f85caea7-7069-4005-a63e-d57d1ad2c706")
    @Override
    public EList<Transition> getEffectOf() {
        return new SmList<>(this, ((BehaviorSmClass)getClassOf()).getEffectOfDep());
    }

    @objid ("11b8b7c3-ef34-45ee-ae85-29f680bf5675")
    @Override
    public <T extends Transition> List<T> getEffectOf(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getEffectOf()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0447bce6-4e03-49ef-80fb-0a28097af1f8")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((BehaviorSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        // OwnerOperation
        obj = (SmObjectImpl)this.getDepVal(((BehaviorSmClass)getClassOf()).getOwnerOperationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("e23d4ad6-91b4-4d3f-bc07-391b2c823f3e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((BehaviorSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerOperation
        dep = ((BehaviorSmClass)getClassOf()).getOwnerOperationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("118b28d0-6c3e-4cfe-9c86-d4e7b8b1ccdd")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBehavior(this);
    }

}
