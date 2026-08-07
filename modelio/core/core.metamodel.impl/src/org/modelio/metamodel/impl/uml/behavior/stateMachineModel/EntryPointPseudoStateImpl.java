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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("004f6fc8-c4bf-1fd8-97fe-001ec947cd2a")
public class EntryPointPseudoStateImpl extends AbstractPseudoStateImpl implements EntryPointPseudoState {
    @objid ("d6faf7dc-47cb-4c14-b5ae-d5fc6d9cf28d")
    @Override
    public State getEntryOf() {
        Object obj = getDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfDep());
        return (obj instanceof State)? (State)obj : null;
    }

    @objid ("d6b8d497-f7d2-4607-ad0e-9073d4f2b76f")
    @Override
    public void setEntryOf(State value) {
        appendDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfDep(), (SmObjectImpl)value);
    }

    @objid ("c75262e6-3698-4ff4-94ab-36a3d95ac7d4")
    @Override
    public EList<ConnectionPointReference> getConnection() {
        return new SmList<>(this, ((EntryPointPseudoStateSmClass)getClassOf()).getConnectionDep());
    }

    @objid ("1907fc79-75bd-41af-b9e2-1afb49ddff2e")
    @Override
    public <T extends ConnectionPointReference> List<T> getConnection(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ConnectionPointReference element : getConnection()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6886d7b7-62a0-4a7c-af4e-b6b14509ef31")
    @Override
    public StateMachine getEntryOfMachine() {
        Object obj = getDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfMachineDep());
        return (obj instanceof StateMachine)? (StateMachine)obj : null;
    }

    @objid ("9eacca53-dbf8-447b-8de7-41708d9fe56b")
    @Override
    public void setEntryOfMachine(StateMachine value) {
        appendDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfMachineDep(), (SmObjectImpl)value);
    }

    @objid ("8c4f6b51-fde6-46e2-8282-228607b7a5f5")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // EntryOf
        obj = (SmObjectImpl)this.getDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfDep());
        if (obj != null)
          return obj;
        // EntryOfMachine
        obj = (SmObjectImpl)this.getDepVal(((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfMachineDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("e16d29a9-49b6-4b09-9f56-b794fccf8d77")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // EntryOf
        dep = ((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // EntryOfMachine
        dep = ((EntryPointPseudoStateSmClass)getClassOf()).getEntryOfMachineDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5f94b68b-addd-49f9-a327-4630679b5d6a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitEntryPointPseudoState(this);
    }

}
