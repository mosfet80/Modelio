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
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.InternalTransition;
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

@objid ("0053a458-c4bf-1fd8-97fe-001ec947cd2a")
public class StateImpl extends StateVertexImpl implements State {
    @objid ("dcab65d0-bacf-47c9-9222-ff8ffdfcbf2e")
    @Override
    public EList<ExitPointPseudoState> getExitPoint() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getExitPointDep());
    }

    @objid ("352cf341-9fb5-40f1-b6e8-14c8ac21754f")
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

    @objid ("7f992f78-21b9-465c-8eab-d491cbe96e09")
    @Override
    public EList<Event> getDeffered() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getDefferedDep());
    }

    @objid ("8e8904eb-5054-426e-b8ff-b12172c60c6f")
    @Override
    public <T extends Event> List<T> getDeffered(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Event element : getDeffered()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("437324fb-4f18-4f2c-a530-e5a66377c0b2")
    @Override
    public EList<InternalTransition> getInternal() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getInternalDep());
    }

    @objid ("980e86e2-2005-41da-82d5-d09ff5bd463a")
    @Override
    public <T extends InternalTransition> List<T> getInternal(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InternalTransition element : getInternal()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f115da47-8c0f-4612-998d-31680bd83e43")
    @Override
    public EList<EntryPointPseudoState> getEntryPoint() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getEntryPointDep());
    }

    @objid ("1bfea3d1-406e-4a8c-bea1-79f16ce89af9")
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

    @objid ("75d67db0-42f7-4aff-b9f2-9565f67252a3")
    @Override
    public EList<Region> getOwnedRegion() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getOwnedRegionDep());
    }

    @objid ("74f97018-aacb-4666-a3b3-64c1d0f71f85")
    @Override
    public <T extends Region> List<T> getOwnedRegion(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Region element : getOwnedRegion()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f29b689a-e823-4928-89af-458aa003130a")
    @Override
    public EList<ObjectNode> getRequiredStateOf() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getRequiredStateOfDep());
    }

    @objid ("6657fe07-d206-4909-80c4-737a69ca31d8")
    @Override
    public <T extends ObjectNode> List<T> getRequiredStateOf(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ObjectNode element : getRequiredStateOf()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("132890c3-b464-4761-bc47-8c635da3149a")
    @Override
    public EList<ConnectionPointReference> getConnection() {
        return new SmList<>(this, ((StateSmClass)getClassOf()).getConnectionDep());
    }

    @objid ("5301755c-1acb-401a-b8cd-273e50525e6e")
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

    @objid ("a3f9988f-ccb2-439b-a655-5a92baf15af4")
    @Override
    public StateMachine getSubMachine() {
        Object obj = getDepVal(((StateSmClass)getClassOf()).getSubMachineDep());
        return (obj instanceof StateMachine)? (StateMachine)obj : null;
    }

    @objid ("96ccfea0-529f-499a-b46a-d447968f0275")
    @Override
    public void setSubMachine(StateMachine value) {
        appendDepVal(((StateSmClass)getClassOf()).getSubMachineDep(), (SmObjectImpl)value);
    }

    @objid ("1844dc8a-7e89-4f3e-a526-ad40f4e6029a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("0fc38013-67da-4d7f-b3e6-dafe5a5f9499")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("ed652c8f-1b91-4967-a86c-1c9bd08f92e7")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitState(this);
    }

}
