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
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0079db46-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class BpmnFlowNodeImpl extends BpmnFlowElementImpl implements BpmnFlowNode {
    @objid ("77debc66-1340-4c0a-b1f9-1bb597a38df5")
    @Override
    public EList<BpmnSequenceFlow> getOutgoing() {
        return new SmList<>(this, ((BpmnFlowNodeSmClass)getClassOf()).getOutgoingDep());
    }

    @objid ("f669c5f7-ea61-440c-b81d-01ab1bd06330")
    @Override
    public <T extends BpmnSequenceFlow> List<T> getOutgoing(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnSequenceFlow element : getOutgoing()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("689d80d0-9547-49ca-8535-4d9a9fede7a9")
    @Override
    public EList<BpmnResourceRole> getResource() {
        return new SmList<>(this, ((BpmnFlowNodeSmClass)getClassOf()).getResourceDep());
    }

    @objid ("341059e2-716c-4295-81e4-e7d6dfb643fb")
    @Override
    public <T extends BpmnResourceRole> List<T> getResource(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceRole element : getResource()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c623d512-a25a-419a-a640-83bcd748d552")
    @Override
    public EList<BpmnSequenceFlow> getIncoming() {
        return new SmList<>(this, ((BpmnFlowNodeSmClass)getClassOf()).getIncomingDep());
    }

    @objid ("0fcf212e-7ebb-4009-9f59-7c741d6b660a")
    @Override
    public <T extends BpmnSequenceFlow> List<T> getIncoming(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnSequenceFlow element : getIncoming()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e32b87f8-9b18-4a4c-bc3f-991c2a25ca4f")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("ef7481f8-6737-4b30-8fa5-2b3c3c9c85ac")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("a97c8cde-c34f-449c-8e70-a0350dc1f7b1")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnFlowNode(this);
    }

}
