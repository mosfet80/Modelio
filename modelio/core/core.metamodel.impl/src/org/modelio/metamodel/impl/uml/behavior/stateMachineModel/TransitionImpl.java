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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
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

@objid ("0055e47a-c4bf-1fd8-97fe-001ec947cd2a")
public class TransitionImpl extends UmlModelElementImpl implements Transition {
    @objid ("1777728a-c145-4384-b5f4-06d522bc5088")
    @Override
    public String getEffect() {
        return (String) getAttVal(((TransitionSmClass)getClassOf()).getEffectAtt());
    }

    @objid ("8ba18277-69ed-49f9-84ee-febf023bebea")
    @Override
    public void setEffect(String value) {
        setAttVal(((TransitionSmClass)getClassOf()).getEffectAtt(), value);
    }

    @objid ("2f66ab08-4766-4cd0-a16c-f1b2be436cd8")
    @Override
    public String getReceivedEvents() {
        return (String) getAttVal(((TransitionSmClass)getClassOf()).getReceivedEventsAtt());
    }

    @objid ("bd3ad6c7-6a23-4ee2-a3d0-65bf79b78e84")
    @Override
    public void setReceivedEvents(String value) {
        setAttVal(((TransitionSmClass)getClassOf()).getReceivedEventsAtt(), value);
    }

    @objid ("190bada4-06d8-4074-87e6-ce42de7dde55")
    @Override
    public String getSentEvents() {
        return (String) getAttVal(((TransitionSmClass)getClassOf()).getSentEventsAtt());
    }

    @objid ("4c7a9fe6-65be-45ea-aac4-321598856642")
    @Override
    public void setSentEvents(String value) {
        setAttVal(((TransitionSmClass)getClassOf()).getSentEventsAtt(), value);
    }

    @objid ("ba4c6cac-8ba0-48e1-82bb-8556680a3002")
    @Override
    public String getGuard() {
        return (String) getAttVal(((TransitionSmClass)getClassOf()).getGuardAtt());
    }

    @objid ("c615ad52-4320-440f-8c33-fd6782874c80")
    @Override
    public void setGuard(String value) {
        setAttVal(((TransitionSmClass)getClassOf()).getGuardAtt(), value);
    }

    @objid ("b1f99682-13f6-4f41-bf99-1f309a2c9884")
    @Override
    public String getPostCondition() {
        return (String) getAttVal(((TransitionSmClass)getClassOf()).getPostConditionAtt());
    }

    @objid ("a76bfd74-0bde-4d6e-8691-d30f6e781ff4")
    @Override
    public void setPostCondition(String value) {
        setAttVal(((TransitionSmClass)getClassOf()).getPostConditionAtt(), value);
    }

    @objid ("7f79e65f-8ae5-4c41-b470-46eb1e84b6e3")
    @Override
    public Operation getProcessed() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getProcessedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("21612d46-7911-4bc8-a7b5-557770b619e1")
    @Override
    public void setProcessed(Operation value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getProcessedDep(), (SmObjectImpl)value);
    }

    @objid ("84b1e949-121b-4694-a870-885b9cb5c60e")
    @Override
    public Event getTrigger() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getTriggerDep());
        return (obj instanceof Event)? (Event)obj : null;
    }

    @objid ("3c089cdd-2618-4afc-935f-507bf79c16b9")
    @Override
    public void setTrigger(Event value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getTriggerDep(), (SmObjectImpl)value);
    }

    @objid ("11afc293-2650-4c68-827c-75687da24e02")
    @Override
    public Behavior getBehaviorEffect() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getBehaviorEffectDep());
        return (obj instanceof Behavior)? (Behavior)obj : null;
    }

    @objid ("041fabf5-7274-44d6-9da0-07edcffce586")
    @Override
    public void setBehaviorEffect(Behavior value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getBehaviorEffectDep(), (SmObjectImpl)value);
    }

    @objid ("95cae1b5-0be9-4eec-9afb-d739f2b1fbf8")
    @Override
    public StateVertex getTarget() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getTargetDep());
        return (obj instanceof StateVertex)? (StateVertex)obj : null;
    }

    @objid ("153cb142-6d14-480d-8f26-f9adbf988642")
    @Override
    public void setTarget(StateVertex value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("d082b89d-26aa-49ed-a03d-4b145d23bfd7")
    @Override
    public StateVertex getSource() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getSourceDep());
        return (obj instanceof StateVertex)? (StateVertex)obj : null;
    }

    @objid ("ed070248-fd1f-4e19-b2e3-266d80e22cf3")
    @Override
    public void setSource(StateVertex value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getSourceDep(), (SmObjectImpl)value);
    }

    @objid ("943665d8-2a7a-49d8-9a2d-b6dded12555c")
    @Override
    public Signal getEffects() {
        Object obj = getDepVal(((TransitionSmClass)getClassOf()).getEffectsDep());
        return (obj instanceof Signal)? (Signal)obj : null;
    }

    @objid ("0a609be2-1a78-441f-bac1-f42837a73f30")
    @Override
    public void setEffects(Signal value) {
        appendDepVal(((TransitionSmClass)getClassOf()).getEffectsDep(), (SmObjectImpl)value);
    }

    @objid ("95bf0c1a-ca1d-4aa8-a2c6-43116ffb3b99")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Source
        obj = (SmObjectImpl)this.getDepVal(((TransitionSmClass)getClassOf()).getSourceDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("9300189a-1135-4e62-b0e2-eab62e247a1e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Source
        dep = ((TransitionSmClass)getClassOf()).getSourceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("9aaae72b-6ff4-4a6a-8092-22f16221c657")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitTransition(this);
    }

}
