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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0075254c-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLaneSetImpl extends BpmnBaseElementImpl implements BpmnLaneSet {
    @objid ("e9a61647-9ddc-4b69-ba3a-e42b3d786816")
    @Override
    public EList<BpmnLane> getLane() {
        return new SmList<>(this, ((BpmnLaneSetSmClass)getClassOf()).getLaneDep());
    }

    @objid ("6bd34e79-c11c-4bc6-9a63-188b97b3028b")
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

    @objid ("e0b0d907-d1d5-4acb-b564-62dd65dda6a4")
    @Override
    public BpmnProcess getProcess() {
        Object obj = getDepVal(((BpmnLaneSetSmClass)getClassOf()).getProcessDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("b09bede8-d64b-492d-824f-8c9f4b99604d")
    @Override
    public void setProcess(BpmnProcess value) {
        appendDepVal(((BpmnLaneSetSmClass)getClassOf()).getProcessDep(), (SmObjectImpl)value);
    }

    @objid ("06bff457-a0c6-42c5-8dca-8972bdd396b0")
    @Override
    public BpmnLane getParentLane() {
        Object obj = getDepVal(((BpmnLaneSetSmClass)getClassOf()).getParentLaneDep());
        return (obj instanceof BpmnLane)? (BpmnLane)obj : null;
    }

    @objid ("7dc9266a-e878-4cec-b574-a53fdf470b85")
    @Override
    public void setParentLane(BpmnLane value) {
        appendDepVal(((BpmnLaneSetSmClass)getClassOf()).getParentLaneDep(), (SmObjectImpl)value);
    }

    @objid ("a65c99fa-c0d4-4cdd-808f-d69554bda467")
    @Override
    public BpmnSubProcess getSubProcess() {
        Object obj = getDepVal(((BpmnLaneSetSmClass)getClassOf()).getSubProcessDep());
        return (obj instanceof BpmnSubProcess)? (BpmnSubProcess)obj : null;
    }

    @objid ("21a5b73b-3517-40ee-a7be-d1b1470bf633")
    @Override
    public void setSubProcess(BpmnSubProcess value) {
        appendDepVal(((BpmnLaneSetSmClass)getClassOf()).getSubProcessDep(), (SmObjectImpl)value);
    }

    @objid ("17074937-325e-463e-83e1-be4a903fff39")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Process
        obj = (SmObjectImpl)this.getDepVal(((BpmnLaneSetSmClass)getClassOf()).getProcessDep());
        if (obj != null)
          return obj;
        // ParentLane
        obj = (SmObjectImpl)this.getDepVal(((BpmnLaneSetSmClass)getClassOf()).getParentLaneDep());
        if (obj != null)
          return obj;
        // SubProcess
        obj = (SmObjectImpl)this.getDepVal(((BpmnLaneSetSmClass)getClassOf()).getSubProcessDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("0a226c26-9824-4f45-a4de-386cc8940d80")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Process
        dep = ((BpmnLaneSetSmClass)getClassOf()).getProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ParentLane
        dep = ((BpmnLaneSetSmClass)getClassOf()).getParentLaneDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // SubProcess
        dep = ((BpmnLaneSetSmClass)getClassOf()).getSubProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("18249635-b225-4418-b3e0-002f77a63601")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnLaneSet(this);
    }

}
