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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00041fdc-c4bf-1fd8-97fe-001ec947cd2a")
public class CollaborationImpl extends NameSpaceImpl implements Collaboration {
    @objid ("d7520d8d-fecb-4eea-880c-0b4f4dba6c01")
    @Override
    public boolean isIsConcurrent() {
        return (Boolean) getAttVal(((CollaborationSmClass)getClassOf()).getIsConcurrentAtt());
    }

    @objid ("6e983f7c-8e87-4e92-aeed-bf52307faa95")
    @Override
    public void setIsConcurrent(boolean value) {
        setAttVal(((CollaborationSmClass)getClassOf()).getIsConcurrentAtt(), value);
    }

    @objid ("511b0570-5422-416c-84cd-1c69004a9677")
    @Override
    public Operation getORepresented() {
        Object obj = getDepVal(((CollaborationSmClass)getClassOf()).getORepresentedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("adf5dcd9-f212-42b5-9d67-82b3ddab5136")
    @Override
    public void setORepresented(Operation value) {
        appendDepVal(((CollaborationSmClass)getClassOf()).getORepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("1173fb79-f8f1-43fb-871a-8cfb0258d9a9")
    @Override
    public Behavior getBRepresented() {
        Object obj = getDepVal(((CollaborationSmClass)getClassOf()).getBRepresentedDep());
        return (obj instanceof Behavior)? (Behavior)obj : null;
    }

    @objid ("6ebb97ce-cae3-483b-bbe0-a6b8b1a51410")
    @Override
    public void setBRepresented(Behavior value) {
        appendDepVal(((CollaborationSmClass)getClassOf()).getBRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("f308a32b-e842-40d8-aa92-d4dabf730830")
    @Override
    public EList<CollaborationUse> getOccurrence() {
        return new SmList<>(this, ((CollaborationSmClass)getClassOf()).getOccurrenceDep());
    }

    @objid ("c41a92c0-1192-4cf7-8332-fea503121771")
    @Override
    public <T extends CollaborationUse> List<T> getOccurrence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CollaborationUse element : getOccurrence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("aefa7df7-27ce-4e75-a4a8-d90f63ff8f2d")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ORepresented
        obj = (SmObjectImpl)this.getDepVal(((CollaborationSmClass)getClassOf()).getORepresentedDep());
        if (obj != null)
          return obj;
        // BRepresented
        obj = (SmObjectImpl)this.getDepVal(((CollaborationSmClass)getClassOf()).getBRepresentedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("6de39f57-1809-41ab-aaef-56f8d0cbd9ad")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ORepresented
        dep = ((CollaborationSmClass)getClassOf()).getORepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // BRepresented
        dep = ((CollaborationSmClass)getClassOf()).getBRepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("cff75f7d-bf85-4c7b-ab50-8d3507e18450")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCollaboration(this);
    }

}
