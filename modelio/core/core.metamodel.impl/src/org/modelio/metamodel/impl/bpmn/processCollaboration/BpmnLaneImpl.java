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
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLane;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00749e92-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnLaneImpl extends BpmnBaseElementImpl implements BpmnLane {
    @objid ("0546577c-43f0-466c-9f6c-56970960afc7")
    @Override
    public BpmnLaneSet getChildLaneSet() {
        Object obj = getDepVal(((BpmnLaneSmClass)getClassOf()).getChildLaneSetDep());
        return (obj instanceof BpmnLaneSet)? (BpmnLaneSet)obj : null;
    }

    @objid ("31215bca-a7e3-4fb3-9fb3-c14a7e2719e0")
    @Override
    public void setChildLaneSet(BpmnLaneSet value) {
        appendDepVal(((BpmnLaneSmClass)getClassOf()).getChildLaneSetDep(), (SmObjectImpl)value);
    }

    @objid ("b670c695-2928-471e-9258-123c9a491140")
    @Override
    public EList<BpmnFlowElement> getFlowElementRef() {
        return new SmList<>(this, ((BpmnLaneSmClass)getClassOf()).getFlowElementRefDep());
    }

    @objid ("c4fe7f38-2481-4ed5-8253-c65d6cc76596")
    @Override
    public <T extends BpmnFlowElement> List<T> getFlowElementRef(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnFlowElement element : getFlowElementRef()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f9273bc8-c952-496a-8246-e61636b30cd8")
    @Override
    public BpmnLaneSet getLaneSet() {
        Object obj = getDepVal(((BpmnLaneSmClass)getClassOf()).getLaneSetDep());
        return (obj instanceof BpmnLaneSet)? (BpmnLaneSet)obj : null;
    }

    @objid ("1f15debb-7d13-4aac-81c9-42d8ffe9465d")
    @Override
    public void setLaneSet(BpmnLaneSet value) {
        appendDepVal(((BpmnLaneSmClass)getClassOf()).getLaneSetDep(), (SmObjectImpl)value);
    }

    @objid ("c0f13361-1109-4736-889d-14a2759e399a")
    @Override
    public BpmnBaseElement getBpmnPartitionElementRef() {
        Object obj = getDepVal(((BpmnLaneSmClass)getClassOf()).getBpmnPartitionElementRefDep());
        return (obj instanceof BpmnBaseElement)? (BpmnBaseElement)obj : null;
    }

    @objid ("d5a1219f-a1ad-481e-b9f7-76fe8cf6fe7b")
    @Override
    public void setBpmnPartitionElementRef(BpmnBaseElement value) {
        appendDepVal(((BpmnLaneSmClass)getClassOf()).getBpmnPartitionElementRefDep(), (SmObjectImpl)value);
    }

    @objid ("2ed7ac2d-f1a8-4644-8b2b-e44a2cc52176")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // LaneSet
        obj = (SmObjectImpl)this.getDepVal(((BpmnLaneSmClass)getClassOf()).getLaneSetDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("0afe979e-d965-429d-8476-1d31485a5a97")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // LaneSet
        dep = ((BpmnLaneSmClass)getClassOf()).getLaneSetDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("419c614f-ffe3-4a85-a3c6-1bf0dc5b279b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnLane(this);
    }

}
