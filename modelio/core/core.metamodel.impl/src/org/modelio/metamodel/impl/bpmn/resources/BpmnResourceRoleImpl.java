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
package org.modelio.metamodel.impl.bpmn.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowNode;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000ab8a6-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceRoleImpl extends BpmnBaseElementImpl implements BpmnResourceRole {
    @objid ("1e07d147-6f15-4bdb-a257-be49819f6db7")
    @Override
    public BpmnResource getResourceRef() {
        Object obj = getDepVal(((BpmnResourceRoleSmClass)getClassOf()).getResourceRefDep());
        return (obj instanceof BpmnResource)? (BpmnResource)obj : null;
    }

    @objid ("3e68e7d0-4e50-43ec-a929-17302c19cd6c")
    @Override
    public void setResourceRef(BpmnResource value) {
        appendDepVal(((BpmnResourceRoleSmClass)getClassOf()).getResourceRefDep(), (SmObjectImpl)value);
    }

    @objid ("e0dfdd60-d536-4485-8bbf-261a768587c8")
    @Override
    public BpmnFlowNode getAnnotated() {
        Object obj = getDepVal(((BpmnResourceRoleSmClass)getClassOf()).getAnnotatedDep());
        return (obj instanceof BpmnFlowNode)? (BpmnFlowNode)obj : null;
    }

    @objid ("63166a78-e0ea-4f4c-a28e-73e11787538d")
    @Override
    public void setAnnotated(BpmnFlowNode value) {
        appendDepVal(((BpmnResourceRoleSmClass)getClassOf()).getAnnotatedDep(), (SmObjectImpl)value);
    }

    @objid ("4e86c681-5d33-4cf6-b716-52c16b8b9e67")
    @Override
    public EList<BpmnResourceParameterBinding> getResourceParameterBinding() {
        return new SmList<>(this, ((BpmnResourceRoleSmClass)getClassOf()).getResourceParameterBindingDep());
    }

    @objid ("7e0290c7-aaca-4636-809d-6a07e6ddfb62")
    @Override
    public <T extends BpmnResourceParameterBinding> List<T> getResourceParameterBinding(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceParameterBinding element : getResourceParameterBinding()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cbee201f-7464-4e2d-b797-00f353febc15")
    @Override
    public BpmnProcess getProcess() {
        Object obj = getDepVal(((BpmnResourceRoleSmClass)getClassOf()).getProcessDep());
        return (obj instanceof BpmnProcess)? (BpmnProcess)obj : null;
    }

    @objid ("8bdf41e8-e940-48ac-95bc-88d20fcae87f")
    @Override
    public void setProcess(BpmnProcess value) {
        appendDepVal(((BpmnResourceRoleSmClass)getClassOf()).getProcessDep(), (SmObjectImpl)value);
    }

    @objid ("aa20843b-b20f-4cb1-be4c-6a4ed6f713aa")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Annotated
        obj = (SmObjectImpl)this.getDepVal(((BpmnResourceRoleSmClass)getClassOf()).getAnnotatedDep());
        if (obj != null)
          return obj;
        // Process
        obj = (SmObjectImpl)this.getDepVal(((BpmnResourceRoleSmClass)getClassOf()).getProcessDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c4d559f8-a284-4268-ad4c-cb96824c2b5c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Annotated
        dep = ((BpmnResourceRoleSmClass)getClassOf()).getAnnotatedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // Process
        dep = ((BpmnResourceRoleSmClass)getClassOf()).getProcessDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("4033f3bc-364d-4f90-9716-e2b87b4c3b7f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnResourceRole(this);
    }

}
