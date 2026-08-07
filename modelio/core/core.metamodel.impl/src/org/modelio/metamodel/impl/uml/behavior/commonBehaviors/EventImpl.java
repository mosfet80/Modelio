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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.EventType;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0042b3fa-c4bf-1fd8-97fe-001ec947cd2a")
public class EventImpl extends UmlModelElementImpl implements Event {
    @objid ("5c6644ea-01e8-48ad-98e8-ba03d571e482")
    @Override
    public String getExpression() {
        return (String) getAttVal(((EventSmClass)getClassOf()).getExpressionAtt());
    }

    @objid ("e2829ffe-4cb8-43f3-933a-b0e586582442")
    @Override
    public void setExpression(String value) {
        setAttVal(((EventSmClass)getClassOf()).getExpressionAtt(), value);
    }

    @objid ("a13c2128-753d-4c9c-b245-c8a20ef63351")
    @Override
    public EventType getKind() {
        return (EventType) getAttVal(((EventSmClass)getClassOf()).getKindAtt());
    }

    @objid ("917db382-aeff-42ef-b09a-6f2a5bc342ba")
    @Override
    public void setKind(EventType value) {
        setAttVal(((EventSmClass)getClassOf()).getKindAtt(), value);
    }

    @objid ("93855107-e983-4955-a3bc-85bfdd3ee947")
    @Override
    public EList<Transition> getTriggered() {
        return new SmList<>(this, ((EventSmClass)getClassOf()).getTriggeredDep());
    }

    @objid ("2690ac12-1d17-4a80-a9c8-1bce40ca5527")
    @Override
    public <T extends Transition> List<T> getTriggered(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getTriggered()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("22691d4e-91f1-4a8f-97f9-99a3b1eaa0a9")
    @Override
    public Signal getModel() {
        Object obj = getDepVal(((EventSmClass)getClassOf()).getModelDep());
        return (obj instanceof Signal)? (Signal)obj : null;
    }

    @objid ("48eed460-329b-47a5-a12c-21e19fc45ce6")
    @Override
    public void setModel(Signal value) {
        appendDepVal(((EventSmClass)getClassOf()).getModelDep(), (SmObjectImpl)value);
    }

    @objid ("c929f655-c2f7-495e-b44f-5ee089a67c5e")
    @Override
    public EList<State> getOrigin() {
        return new SmList<>(this, ((EventSmClass)getClassOf()).getOriginDep());
    }

    @objid ("263a2624-2cb5-4eec-b285-94c1cd9c7c93")
    @Override
    public <T extends State> List<T> getOrigin(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final State element : getOrigin()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("887658c6-4249-4808-8990-e177560b5241")
    @Override
    public Operation getCalled() {
        Object obj = getDepVal(((EventSmClass)getClassOf()).getCalledDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("54ed6bfa-d363-4367-a071-fade295fec39")
    @Override
    public void setCalled(Operation value) {
        appendDepVal(((EventSmClass)getClassOf()).getCalledDep(), (SmObjectImpl)value);
    }

    @objid ("ab340ab8-769c-4156-bd0f-40764cd66b0e")
    @Override
    public Behavior getComposed() {
        Object obj = getDepVal(((EventSmClass)getClassOf()).getComposedDep());
        return (obj instanceof Behavior)? (Behavior)obj : null;
    }

    @objid ("8fd31d9f-2287-4289-91fe-efd2b300a2b8")
    @Override
    public void setComposed(Behavior value) {
        appendDepVal(((EventSmClass)getClassOf()).getComposedDep(), (SmObjectImpl)value);
    }

    @objid ("0ea6db2d-839c-40b8-a45c-b66cbd3d3bcf")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Composed
        obj = (SmObjectImpl)this.getDepVal(((EventSmClass)getClassOf()).getComposedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("3e083c37-e7a8-427f-9a07-3efef4b771b9")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Composed
        dep = ((EventSmClass)getClassOf()).getComposedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5b249113-c88a-4fd1-bab9-fec888c88b30")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitEvent(this);
    }

}
