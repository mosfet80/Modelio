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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.MessageFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002a04ae-c4bf-1fd8-97fe-001ec947cd2a")
public class ActivityPartitionImpl extends ActivityGroupImpl implements ActivityPartition {
    @objid ("08e86a55-bd0d-4334-b787-fe910157b754")
    @Override
    public boolean isIsDimension() {
        return (Boolean) getAttVal(((ActivityPartitionSmClass)getClassOf()).getIsDimensionAtt());
    }

    @objid ("a963011e-67c3-4cb8-a33d-d6eddf741e40")
    @Override
    public void setIsDimension(boolean value) {
        setAttVal(((ActivityPartitionSmClass)getClassOf()).getIsDimensionAtt(), value);
    }

    @objid ("f15d9132-7f55-4602-b71d-62c1b2b7e3fa")
    @Override
    public boolean isIsExternal() {
        return (Boolean) getAttVal(((ActivityPartitionSmClass)getClassOf()).getIsExternalAtt());
    }

    @objid ("cfb9083c-670a-4850-9065-45200cf9610f")
    @Override
    public void setIsExternal(boolean value) {
        setAttVal(((ActivityPartitionSmClass)getClassOf()).getIsExternalAtt(), value);
    }

    @objid ("47d9117f-4d02-4524-bd5f-c4a1f16dde8e")
    @Override
    public UmlModelElement getRepresented() {
        Object obj = getDepVal(((ActivityPartitionSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("ef1de40b-8072-4b0a-93e3-a3502d8471cb")
    @Override
    public void setRepresented(UmlModelElement value) {
        appendDepVal(((ActivityPartitionSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("a4938531-f379-4525-8727-310b7690fc62")
    @Override
    public EList<ActivityNode> getContainedNode() {
        return new SmList<>(this, ((ActivityPartitionSmClass)getClassOf()).getContainedNodeDep());
    }

    @objid ("b238897d-13cc-4abb-90fd-61cdfc7a0293")
    @Override
    public <T extends ActivityNode> List<T> getContainedNode(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityNode element : getContainedNode()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e168df85-1dd3-4821-a359-fc77ff3bcf7b")
    @Override
    public EList<MessageFlow> getOutgoing() {
        return new SmList<>(this, ((ActivityPartitionSmClass)getClassOf()).getOutgoingDep());
    }

    @objid ("cf4ad9b5-7526-4098-be27-e95a6e5cc44f")
    @Override
    public <T extends MessageFlow> List<T> getOutgoing(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final MessageFlow element : getOutgoing()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cbecd268-aa82-4587-8c49-3f2b2f12c1dd")
    @Override
    public ActivityPartition getSuperPartition() {
        Object obj = getDepVal(((ActivityPartitionSmClass)getClassOf()).getSuperPartitionDep());
        return (obj instanceof ActivityPartition)? (ActivityPartition)obj : null;
    }

    @objid ("bad71dd1-ea0d-4346-bf00-ce1037df1b83")
    @Override
    public void setSuperPartition(ActivityPartition value) {
        appendDepVal(((ActivityPartitionSmClass)getClassOf()).getSuperPartitionDep(), (SmObjectImpl)value);
    }

    @objid ("37f54554-500b-440e-9af0-07f1e29cfc4e")
    @Override
    public EList<ActivityPartition> getSubPartition() {
        return new SmList<>(this, ((ActivityPartitionSmClass)getClassOf()).getSubPartitionDep());
    }

    @objid ("4b5eb543-cb06-44b6-b6ff-760d636ea66c")
    @Override
    public <T extends ActivityPartition> List<T> getSubPartition(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityPartition element : getSubPartition()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4cdd011d-ee1e-49d9-8bf8-7b7db849f394")
    @Override
    public EList<MessageFlow> getIncoming() {
        return new SmList<>(this, ((ActivityPartitionSmClass)getClassOf()).getIncomingDep());
    }

    @objid ("6aa5234c-5b37-47a5-a290-31fef68de2e7")
    @Override
    public <T extends MessageFlow> List<T> getIncoming(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final MessageFlow element : getIncoming()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5c139932-d4e2-47ad-9df6-5a6c4aef0ab3")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SuperPartition
        obj = (SmObjectImpl)this.getDepVal(((ActivityPartitionSmClass)getClassOf()).getSuperPartitionDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("1ff2d017-80bb-4579-8ab6-fa54c2ff409c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SuperPartition
        dep = ((ActivityPartitionSmClass)getClassOf()).getSuperPartitionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("939c692c-0fbb-4a62-ba8a-ac56ffa45a85")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityPartition(this);
    }

}
