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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
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

@objid ("004feeee-c4bf-1fd8-97fe-001ec947cd2a")
public class ExitPointPseudoStateImpl extends AbstractPseudoStateImpl implements ExitPointPseudoState {
    @objid ("e23603df-9fa9-4f72-92cd-51c893a34c00")
    @Override
    public State getExitOf() {
        Object obj = getDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfDep());
        return (obj instanceof State)? (State)obj : null;
    }

    @objid ("69dacf30-2108-47c7-9dff-1a20e3d87ed9")
    @Override
    public void setExitOf(State value) {
        appendDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfDep(), (SmObjectImpl)value);
    }

    @objid ("2591967c-e029-4663-a71b-26927b75f151")
    @Override
    public EList<ConnectionPointReference> getConnection() {
        return new SmList<>(this, ((ExitPointPseudoStateSmClass)getClassOf()).getConnectionDep());
    }

    @objid ("ea3f81aa-6cf2-43b8-81a8-1ebcfe2cd490")
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

    @objid ("e8a690a4-c9d5-47bd-81af-2c60f8de3d3e")
    @Override
    public StateMachine getExitOfMachine() {
        Object obj = getDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfMachineDep());
        return (obj instanceof StateMachine)? (StateMachine)obj : null;
    }

    @objid ("cf07af9e-5d91-419a-a69c-20a442a5e8bb")
    @Override
    public void setExitOfMachine(StateMachine value) {
        appendDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfMachineDep(), (SmObjectImpl)value);
    }

    @objid ("f30e0889-b8f9-4615-8328-959b059f7b84")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ExitOf
        obj = (SmObjectImpl)this.getDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfDep());
        if (obj != null)
          return obj;
        // ExitOfMachine
        obj = (SmObjectImpl)this.getDepVal(((ExitPointPseudoStateSmClass)getClassOf()).getExitOfMachineDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("551f75dc-ae1b-4697-b338-91b53ef6071b")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ExitOf
        dep = ((ExitPointPseudoStateSmClass)getClassOf()).getExitOfDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ExitOfMachine
        dep = ((ExitPointPseudoStateSmClass)getClassOf()).getExitOfMachineDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("2142706b-9267-4602-a6ba-0712d8c41d53")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExitPointPseudoState(this);
    }

}
