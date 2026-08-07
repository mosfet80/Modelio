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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000d7c30-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnOperationImpl extends BpmnBaseElementImpl implements BpmnOperation {
    @objid ("4345143f-4ec4-4fe3-93fb-b87d0440d205")
    @Override
    public EList<BpmnSendTask> getSender() {
        return new SmList<>(this, ((BpmnOperationSmClass)getClassOf()).getSenderDep());
    }

    @objid ("020afc1f-c905-45f3-bbb2-c159ad93e346")
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

    @objid ("906ba132-73b0-450b-8725-4ef51cffe66a")
    @Override
    public BpmnMessage getInMessageRef() {
        Object obj = getDepVal(((BpmnOperationSmClass)getClassOf()).getInMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("d59529d0-e504-4f46-8b10-955d639ca1a3")
    @Override
    public void setInMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnOperationSmClass)getClassOf()).getInMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("4d5180c0-1171-4170-9e35-4588fe4bf867")
    @Override
    public EList<BpmnServiceTask> getCaller() {
        return new SmList<>(this, ((BpmnOperationSmClass)getClassOf()).getCallerDep());
    }

    @objid ("0cbbb855-f2a2-4296-9841-05225ba5876b")
    @Override
    public <T extends BpmnServiceTask> List<T> getCaller(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnServiceTask element : getCaller()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("3eb8b10d-ac1a-4b60-b64c-5ee292874bc7")
    @Override
    public BpmnMessage getOutMessageRef() {
        Object obj = getDepVal(((BpmnOperationSmClass)getClassOf()).getOutMessageRefDep());
        return (obj instanceof BpmnMessage)? (BpmnMessage)obj : null;
    }

    @objid ("2fd951f0-1a84-4042-bd4b-b27d33617762")
    @Override
    public void setOutMessageRef(BpmnMessage value) {
        appendDepVal(((BpmnOperationSmClass)getClassOf()).getOutMessageRefDep(), (SmObjectImpl)value);
    }

    @objid ("c19c6ca8-b699-40ff-ab8c-886c4bd3060f")
    @Override
    public EList<BpmnMessageEventDefinition> getEventDefinition() {
        return new SmList<>(this, ((BpmnOperationSmClass)getClassOf()).getEventDefinitionDep());
    }

    @objid ("82f07418-3490-43e7-a954-c2ffb3f2e29b")
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

    @objid ("a3aee7f6-ff1d-48d6-9d59-c2062033edbf")
    @Override
    public BpmnInterface getBpmnInterfaceRef() {
        Object obj = getDepVal(((BpmnOperationSmClass)getClassOf()).getBpmnInterfaceRefDep());
        return (obj instanceof BpmnInterface)? (BpmnInterface)obj : null;
    }

    @objid ("5b4622d3-0f5d-4c09-86b3-b37b7538fac9")
    @Override
    public void setBpmnInterfaceRef(BpmnInterface value) {
        appendDepVal(((BpmnOperationSmClass)getClassOf()).getBpmnInterfaceRefDep(), (SmObjectImpl)value);
    }

    @objid ("c1d099ef-cf2a-49ec-8cef-2d8631ee8e34")
    @Override
    public EList<BpmnReceiveTask> getReceiver() {
        return new SmList<>(this, ((BpmnOperationSmClass)getClassOf()).getReceiverDep());
    }

    @objid ("715fba0b-363e-4e7e-8d6c-14b83dda7154")
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

    @objid ("09c2529c-1131-4eb6-b7bf-498553dda315")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // BpmnInterfaceRef
        obj = (SmObjectImpl)this.getDepVal(((BpmnOperationSmClass)getClassOf()).getBpmnInterfaceRefDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("14da2dbf-8f96-47cd-8b02-ccdc8d6bf131")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // BpmnInterfaceRef
        dep = ((BpmnOperationSmClass)getClassOf()).getBpmnInterfaceRefDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3425e097-6bc4-450a-b90d-29c7d0e7be16")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnOperation(this);
    }

}
