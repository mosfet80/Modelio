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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.statik.ParameterImpl;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.statik.Parameter;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00413f3e-c4bf-1fd8-97fe-001ec947cd2a")
public class BehaviorParameterImpl extends ParameterImpl implements BehaviorParameter {
    @objid ("b0413c8f-6638-4e67-b8d1-cc632b18d7aa")
    @Override
    public EList<ObjectNode> getRepresentingObjectNode() {
        return new SmList<>(this, ((BehaviorParameterSmClass)getClassOf()).getRepresentingObjectNodeDep());
    }

    @objid ("66864f6f-d591-4f32-89c7-8d9ae9018971")
    @Override
    public <T extends ObjectNode> List<T> getRepresentingObjectNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ObjectNode element : getRepresentingObjectNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f5e8b105-d279-4bc4-803d-bef37c41bc33")
    @Override
    public Behavior getOwner() {
        Object obj = getDepVal(((BehaviorParameterSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Behavior)? (Behavior)obj : null;
    }

    @objid ("65f6e7ec-c269-4a74-b6cd-ce54780851ed")
    @Override
    public void setOwner(Behavior value) {
        appendDepVal(((BehaviorParameterSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("c8b7c75f-2d9e-47b6-b463-b11abb02f9a9")
    @Override
    public Parameter getMapped() {
        Object obj = getDepVal(((BehaviorParameterSmClass)getClassOf()).getMappedDep());
        return (obj instanceof Parameter)? (Parameter)obj : null;
    }

    @objid ("d6c4c483-2479-4927-9474-f7b42e12e1c8")
    @Override
    public void setMapped(Parameter value) {
        appendDepVal(((BehaviorParameterSmClass)getClassOf()).getMappedDep(), (SmObjectImpl)value);
    }

    @objid ("ae4e0ecf-8292-4769-a737-4a15e28c59fe")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((BehaviorParameterSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("92b5cfa4-658d-406c-be76-e4343f525b50")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((BehaviorParameterSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("6ba52718-9b4d-4b81-90f8-3e5d0c90d9d3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBehaviorParameter(this);
    }

}
