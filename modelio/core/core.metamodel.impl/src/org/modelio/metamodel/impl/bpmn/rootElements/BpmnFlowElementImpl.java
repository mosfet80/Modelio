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
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnGroup;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0079514e-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnFlowElementImpl extends BpmnBaseElementImpl implements BpmnFlowElement {
    @objid ("d8ee8bb4-10d5-4295-bc29-07b76bf43b96")
    @Override
    public boolean isTriggeredByEvent() {
        return (Boolean) getAttVal(((BpmnFlowElementSmClass)getClassOf()).getTriggeredByEventAtt());
    }

    @objid ("daafaa9c-43c3-409a-83d5-fa98a41f64a8")
    @Override
    public void setTriggeredByEvent(boolean value) {
        setAttVal(((BpmnFlowElementSmClass)getClassOf()).getTriggeredByEventAtt(), value);
    }

    @objid ("563a508a-9e1e-4b8e-ad1c-def2a3706b86")
    @Override
    public EList<BpmnGroup> getGroups() {
        return new SmList<>(this, ((BpmnFlowElementSmClass)getClassOf()).getGroupsDep());
    }

    @objid ("332d68e6-064a-45dc-bf00-9e37c6f9eb21")
    @Override
    public <T extends BpmnGroup> List<T> getGroups(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnGroup element : getGroups()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ffabbdf2-f38c-4ff4-a370-c058b106414a")
    @Override
    public BpmnSubProcess getSubProcess() {
        Object obj = getDepVal(((BpmnFlowElementSmClass)getClassOf()).getSubProcessDep());
        return (obj instanceof BpmnSubProcess)? (BpmnSubProcess)obj : null;
    }

    @objid ("6be721af-2756-4c67-839f-58714302ea41")
    @Override
    public void setSubProcess(BpmnSubProcess value) {
        appendDepVal(((BpmnFlowElementSmClass)getClassOf()).getSubProcessDep(), (SmObjectImpl)value);
    }

    @objid ("7828337d-b292-4cc5-b9cf-7474a81616c6")
    @Override
    public EList<BpmnLane> getLane() {
        return new SmList<>(this, ((BpmnFlowElementSmClass)getClassOf()).getLaneDep());
    }

    @objid ("3b847fda-40be-43d2-9e88-942f832b7c8c")
    @Override
    public <T extends BpmnLane> List<T> getLane(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnLane element : getLane()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("27a6ac4a-df54-4b0d-a4ee-b03325dda716")
    @Override
    public BpmnProcess getContainer() {
        Object obj = getDepVal(((BpmnFlowElementSmClass)getClassOf()).getContainerDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("29a80a3d-1677-4bda-ad7b-0cd409bc178e")
    @Override
    public void setContainer(BpmnProcess value) {
        appendDepVal(((BpmnFlowElementSmClass)getClassOf()).getContainerDep(), (SmObjectImpl)value);
    }

    @objid ("5c73f4f5-1cb2-4c02-8f22-fdb872ab1d93")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SubProcess
        obj = (SmObjectImpl)this.getDepVal(((BpmnFlowElementSmClass)getClassOf()).getSubProcessDep());
        if (obj != null)
          return obj;
        // Container
        obj = (SmObjectImpl)this.getDepVal(((BpmnFlowElementSmClass)getClassOf()).getContainerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("2ac464da-1102-46f8-9942-e5c9ab250cf7")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SubProcess
        dep = ((BpmnFlowElementSmClass)getClassOf()).getSubProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Container
        dep = ((BpmnFlowElementSmClass)getClassOf()).getContainerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("91b142e8-51b3-46bd-aba0-85cdfebede7f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnFlowElement(this);
    }

}
