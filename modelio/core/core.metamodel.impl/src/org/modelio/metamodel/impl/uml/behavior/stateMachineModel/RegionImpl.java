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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0057164c-c4bf-1fd8-97fe-001ec947cd2a")
public class RegionImpl extends UmlModelElementImpl implements Region {
    @objid ("dfa6f19d-a9f8-4bad-a7c0-bd70e088b96c")
    @Override
    public State getParent() {
        Object obj = getDepVal(((RegionSmClass)getClassOf()).getParentDep());
        return (obj instanceof State)? (State)obj : null;
    }

    @objid ("407c0715-c2b1-48ab-bbe3-959dd98a4c73")
    @Override
    public void setParent(State value) {
        appendDepVal(((RegionSmClass)getClassOf()).getParentDep(), (SmObjectImpl)value);
    }

    @objid ("806af875-eafe-479f-a5f5-c49c37f3ded7")
    @Override
    public StateMachine getRepresented() {
        Object obj = getDepVal(((RegionSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof StateMachine)? (StateMachine)obj : null;
    }

    @objid ("7bf56b33-c860-49f9-9ba7-5a2b9d9d8e99")
    @Override
    public void setRepresented(StateMachine value) {
        appendDepVal(((RegionSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("22c6c8c2-8b8d-4f3f-ab30-6a0a2b01e23b")
    @Override
    public EList<StateVertex> getSub() {
        return new SmList<>(this, ((RegionSmClass)getClassOf()).getSubDep());
    }

    @objid ("d6151bc9-2f68-4b32-9362-bbd89c24cfc4")
    @Override
    public <T extends StateVertex> List<T> getSub(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final StateVertex element : getSub()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c65bbaac-464b-4257-b226-80db80f6ac61")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Parent
        obj = (SmObjectImpl)this.getDepVal(((RegionSmClass)getClassOf()).getParentDep());
        if (obj != null)
          return obj;
        // Represented
        obj = (SmObjectImpl)this.getDepVal(((RegionSmClass)getClassOf()).getRepresentedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c33f9485-2ec6-47fe-a9ec-b4caace630a5")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Parent
        dep = ((RegionSmClass)getClassOf()).getParentDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Represented
        dep = ((RegionSmClass)getClassOf()).getRepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("c5fe2b9c-0bc8-43cb-ac83-7345a82c0bd5")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitRegion(this);
    }

}
