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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnSubProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00845b16-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnSubProcessImpl extends BpmnActivityImpl implements BpmnSubProcess {
    @objid ("86cc49c2-95fd-4fda-a1e3-f156f503fc8d")
    @Override
    public EList<BpmnArtifact> getArtifact() {
        return new SmList<>(this, ((BpmnSubProcessSmClass)getClassOf()).getArtifactDep());
    }

    @objid ("4ad5cdeb-c09f-4485-80b4-629960382b76")
    @Override
    public <T extends BpmnArtifact> List<T> getArtifact(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnArtifact element : getArtifact()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2fa27c79-cd72-435b-8f83-75db362fef27")
    @Override
    public EList<BpmnFlowElement> getFlowElement() {
        return new SmList<>(this, ((BpmnSubProcessSmClass)getClassOf()).getFlowElementDep());
    }

    @objid ("6914fc59-cf17-41fd-9df2-54572d8daf1a")
    @Override
    public <T extends BpmnFlowElement> List<T> getFlowElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnFlowElement element : getFlowElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6410988a-7e0b-45b4-b7ec-630684651b1e")
    @Override
    public BpmnLaneSet getLaneSet() {
        Object obj = getDepVal(((BpmnSubProcessSmClass)getClassOf()).getLaneSetDep());
        return (obj instanceof BpmnLaneSet)? (BpmnLaneSet)obj : null;
    }

    @objid ("79569eb4-42e5-4c82-93eb-db330c12bdeb")
    @Override
    public void setLaneSet(BpmnLaneSet value) {
        appendDepVal(((BpmnSubProcessSmClass)getClassOf()).getLaneSetDep(), (SmObjectImpl)value);
    }

    @objid ("4bf2994e-fa13-4cb6-ab30-a469169f3403")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("6e7a2a29-78b0-40b2-8a6a-d8cb018df879")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("6ee3cbdc-41b8-44d4-8392-eb49c5d692f5")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnSubProcess(this);
    }

}
