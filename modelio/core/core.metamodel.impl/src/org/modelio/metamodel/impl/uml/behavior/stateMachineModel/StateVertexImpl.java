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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0054c0ea-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class StateVertexImpl extends UmlModelElementImpl implements StateVertex {
    @objid ("c2b11910-f5ea-4012-8e2c-c0eb2b0657ba")
    @Override
    public EList<Transition> getOutGoing() {
        return new SmList<>(this, ((StateVertexSmClass)getClassOf()).getOutGoingDep());
    }

    @objid ("f6b73abe-3957-44c1-826e-a38a21cfd305")
    @Override
    public <T extends Transition> List<T> getOutGoing(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getOutGoing()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("222c04a0-d80f-4897-b2c4-86ff4baf9d17")
    @Override
    public EList<Transition> getIncoming() {
        return new SmList<>(this, ((StateVertexSmClass)getClassOf()).getIncomingDep());
    }

    @objid ("d825bfb2-3e60-4b7b-864f-163f95362bdc")
    @Override
    public <T extends Transition> List<T> getIncoming(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Transition element : getIncoming()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("57b2f301-47b9-4b8b-9369-b834f7c0bd06")
    @Override
    public Region getParent() {
        Object obj = getDepVal(((StateVertexSmClass)getClassOf()).getParentDep());
        return (obj instanceof Region)? (Region)obj : null;
    }

    @objid ("b61870b5-3c91-4f0c-8fe3-b1c0ad95ab4b")
    @Override
    public void setParent(Region value) {
        appendDepVal(((StateVertexSmClass)getClassOf()).getParentDep(), (SmObjectImpl)value);
    }

    @objid ("558eac15-5799-437c-b7dc-8e5ec3ed973e")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Parent
        obj = (SmObjectImpl)this.getDepVal(((StateVertexSmClass)getClassOf()).getParentDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("f351705b-d5c6-46ee-acc1-a84657036fce")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Parent
        dep = ((StateVertexSmClass)getClassOf()).getParentDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("129d5746-43aa-4a69-b24e-9daf9aba061c")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitStateVertex(this);
    }

}
