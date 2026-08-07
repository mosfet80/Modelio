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
package org.modelio.metamodel.impl.bpmn.flows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("007c0b32-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnMessageImpl extends BpmnSharedElementImpl implements BpmnMessage {
    @objid ("9368a7e6-9e4b-4cb7-918c-3dcada63b035")
    @Override
    public EList<BpmnOperation> getOutputMessage() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getOutputMessageDep());
    }

    @objid ("26b89bff-953f-4e2d-899c-e477a4139d92")
    @Override
    public <T extends BpmnOperation> List<T> getOutputMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnOperation element : getOutputMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f967f684-72df-4d43-81e5-1850faf4f80b")
    @Override
    public BpmnItemDefinition getItemRef() {
        Object obj = getDepVal(((BpmnMessageSmClass)getClassOf()).getItemRefDep());
        return (obj instanceof BpmnItemDefinition)? (BpmnItemDefinition)obj : null;
    }

    @objid ("2701e6dc-f2d2-4131-ab1c-8611be111054")
    @Override
    public void setItemRef(BpmnItemDefinition value) {
        appendDepVal(((BpmnMessageSmClass)getClassOf()).getItemRefDep(), (SmObjectImpl)value);
    }

    @objid ("b966c244-286a-4eff-86a2-457146e17c9f")
    @Override
    public EList<BpmnMessageEventDefinition> getEventDefinition() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getEventDefinitionDep());
    }

    @objid ("c571237f-6fe3-4186-9679-225a41a127b1")
    @Override
    public <T extends BpmnMessageEventDefinition> List<T> getEventDefinition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessageEventDefinition element : getEventDefinition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ea0bc099-4e78-4405-9875-80f5246d2e2e")
    @Override
    public EList<BpmnSendTask> getSender() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getSenderDep());
    }

    @objid ("4faaa942-9940-4673-ba44-6e663dc47007")
    @Override
    public <T extends BpmnSendTask> List<T> getSender(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnSendTask element : getSender()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("90fec224-a57e-49ce-8ec3-79222542d68d")
    @Override
    public EList<BpmnOperation> getInputMessage() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getInputMessageDep());
    }

    @objid ("63fc6223-6a85-4e83-b674-5a685df0cca2")
    @Override
    public <T extends BpmnOperation> List<T> getInputMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnOperation element : getInputMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7dc9551b-e3c6-4a1d-8e10-15ebf50f535d")
    @Override
    public EList<BpmnReceiveTask> getReceiver() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getReceiverDep());
    }

    @objid ("12198da2-975b-4fb6-924c-f0212b5f079e")
    @Override
    public <T extends BpmnReceiveTask> List<T> getReceiver(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnReceiveTask element : getReceiver()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1311bebc-0eec-4015-adc3-d8ee0fbd7907")
    @Override
    public EList<BpmnMessageFlow> getMessageFlow() {
        return new SmList<>(this, ((BpmnMessageSmClass)getClassOf()).getMessageFlowDep());
    }

    @objid ("c675be92-55b0-40f3-aada-38e10a2e2b27")
    @Override
    public <T extends BpmnMessageFlow> List<T> getMessageFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessageFlow element : getMessageFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("8d4a00f3-a72f-437b-ae15-b351e9c7e9f5")
    @Override
    public BpmnCollaboration getCollaboration() {
        Object obj = getDepVal(((BpmnMessageSmClass)getClassOf()).getCollaborationDep());
        return (obj instanceof BpmnCollaboration)? (BpmnCollaboration)obj : null;
    }

    @objid ("a4ce31c9-ec07-462c-ad3b-0b72bc2e7170")
    @Override
    public void setCollaboration(BpmnCollaboration value) {
        appendDepVal(((BpmnMessageSmClass)getClassOf()).getCollaborationDep(), (SmObjectImpl)value);
    }

    @objid ("3b2294da-7062-4b86-9ae0-f2474d9743fb")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Collaboration
        obj = (SmObjectImpl)this.getDepVal(((BpmnMessageSmClass)getClassOf()).getCollaborationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("58ae6061-4264-4612-a8b5-39ab9044113e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Collaboration
        dep = ((BpmnMessageSmClass)getClassOf()).getCollaborationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("eda0adad-3a93-4ba3-90e4-315ec0ab77e4")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnMessage(this);
    }

}
