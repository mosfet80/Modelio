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
package org.modelio.metamodel.impl.bpmn.rootElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.rootElements.BpmnAssociation;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.uml.infrastructure.ModelElementImpl;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0078058c-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnBaseElementImpl extends ModelElementImpl implements BpmnBaseElement {
    @objid ("f969d2b2-246a-4536-87b8-064fceb116e0")
    @Override
    public MObject getBpmnContext() {
        return getBpmnContext(getCompositionOwner());
    }

    @objid ("7549749f-2033-4952-a907-1e2e90107994")
    private MObject getBpmnContext(final MObject elt) {
        if (elt == null) {
            return null;
        } else if (elt instanceof NameSpace || elt instanceof Operation) {
            return elt;
        } else {
            return getBpmnContext(elt.getCompositionOwner());
        }

    }

    @objid ("ecba23fb-7faf-41c5-93ab-4a70162df8d9")
    @Override
    public EList<BpmnAssociation> getOutgoingAssoc() {
        return new SmList<>(this, ((BpmnBaseElementSmClass)getClassOf()).getOutgoingAssocDep());
    }

    @objid ("5de213de-fc78-42e7-a422-c0d8dea78b9a")
    @Override
    public <T extends BpmnAssociation> List<T> getOutgoingAssoc(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnAssociation element : getOutgoingAssoc()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bcdcd718-08e1-42f7-ab5d-cf08c526f86a")
    @Override
    public EList<BpmnAssociation> getIncomingAssoc() {
        return new SmList<>(this, ((BpmnBaseElementSmClass)getClassOf()).getIncomingAssocDep());
    }

    @objid ("0bd3b3a9-4c7a-4419-adcc-acb25f5fb800")
    @Override
    public <T extends BpmnAssociation> List<T> getIncomingAssoc(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnAssociation element : getIncomingAssoc()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("bb23713d-f30c-43da-9950-ceeff8d8584c")
    @Override
    public EList<BpmnMessageFlow> getIncomingFlow() {
        return new SmList<>(this, ((BpmnBaseElementSmClass)getClassOf()).getIncomingFlowDep());
    }

    @objid ("294b4bb1-fef4-4927-84b4-90d3a5dfecbc")
    @Override
    public <T extends BpmnMessageFlow> List<T> getIncomingFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessageFlow element : getIncomingFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7e9f8244-f091-4317-a2dd-a5f103b0e92f")
    @Override
    public EList<BpmnMessageFlow> getOutgoingFlow() {
        return new SmList<>(this, ((BpmnBaseElementSmClass)getClassOf()).getOutgoingFlowDep());
    }

    @objid ("3feb3a88-f707-49af-8a11-69dbfca708c5")
    @Override
    public <T extends BpmnMessageFlow> List<T> getOutgoingFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnMessageFlow element : getOutgoingFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("142d2113-c91e-426f-8e0f-5587d4ade0ec")
    @Override
    public EList<BpmnLane> getPartitionedLaneRefs() {
        return new SmList<>(this, ((BpmnBaseElementSmClass)getClassOf()).getPartitionedLaneRefsDep());
    }

    @objid ("c9f47a2a-404c-4459-868b-96daf7bbfe0c")
    @Override
    public <T extends BpmnLane> List<T> getPartitionedLaneRefs(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnLane element : getPartitionedLaneRefs()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2b89ff10-f2d3-486d-b26f-2c44ecb8ee32")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("3e1f3ac7-49de-4104-a515-1a0cda6505d7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("3036a842-03b9-4316-9d07-8051571e36d2")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IModelVisitor)
          return accept((IModelVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("d6ad5b0f-fd2d-4b99-a594-938a9099307e")
    public Object accept(IModelVisitor v) {
        return v.visitBpmnBaseElement(this);
    }

}
