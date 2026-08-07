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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorImpl;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.KindOfStateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
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

@objid ("00543116-c4bf-1fd8-97fe-001ec947cd2a")
public class StateMachineImpl extends BehaviorImpl implements StateMachine {
    @objid ("4044d9f7-2387-4aea-8f06-51a8cd47fe8d")
    @Override
    public KindOfStateMachine getKind() {
        return (KindOfStateMachine) getAttVal(((StateMachineSmClass)getClassOf()).getKindAtt());
    }

    @objid ("6526b043-c5a9-416a-bd26-d15c46826065")
    @Override
    public void setKind(KindOfStateMachine value) {
        setAttVal(((StateMachineSmClass)getClassOf()).getKindAtt(), value);
    }

    @objid ("a50b92d7-b144-449d-9264-9a58d5823281")
    @Override
    public Region getTop() {
        Object obj = getDepVal(((StateMachineSmClass)getClassOf()).getTopDep());
        return (obj instanceof Region)? (Region)obj : null;
    }

    @objid ("e5d5bc1f-2ad6-4504-b542-128f8bb79485")
    @Override
    public void setTop(Region value) {
        appendDepVal(((StateMachineSmClass)getClassOf()).getTopDep(), (SmObjectImpl)value);
    }

    @objid ("198921dc-05b6-41b8-8b0c-7de100534e2c")
    @Override
    public EList<State> getSubmachineState() {
        return new SmList<>(this, ((StateMachineSmClass)getClassOf()).getSubmachineStateDep());
    }

    @objid ("9f7477e9-0c24-4f14-ace3-75133ba7e0b5")
    @Override
    public <T extends State> List<T> getSubmachineState(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final State element : getSubmachineState()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a6e61dae-dc93-4b19-8261-28eefcdfc5ec")
    @Override
    public EList<EntryPointPseudoState> getEntryPoint() {
        return new SmList<>(this, ((StateMachineSmClass)getClassOf()).getEntryPointDep());
    }

    @objid ("bebd7209-9651-44d4-a748-c1212f4dc1de")
    @Override
    public <T extends EntryPointPseudoState> List<T> getEntryPoint(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final EntryPointPseudoState element : getEntryPoint()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("0dcae5c4-b984-42cd-9a5b-156f8a48455e")
    @Override
    public EList<ExitPointPseudoState> getExitPoint() {
        return new SmList<>(this, ((StateMachineSmClass)getClassOf()).getExitPointDep());
    }

    @objid ("f891743b-3d60-499f-97ce-a4ff919f9438")
    @Override
    public <T extends ExitPointPseudoState> List<T> getExitPoint(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExitPointPseudoState element : getExitPoint()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("67560eee-677e-4fd0-ac2a-00cbdfd95e27")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("a74e7932-2d96-46bc-8c36-136cb93bc788")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c4a3728b-38ad-4da4-8336-a458f683221d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitStateMachine(this);
    }

}
