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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00456c76-c4bf-1fd8-97fe-001ec947cd2a")
public class GateImpl extends MessageEndImpl implements Gate {
    @objid ("252a132c-53c2-44a6-89fa-dc63ef510abf")
    @Override
    public InteractionUse getOwnerUse() {
        Object obj = getDepVal(((GateSmClass)getClassOf()).getOwnerUseDep());
        return (obj instanceof InteractionUse)? (InteractionUse)obj : null;
    }

    @objid ("f615c11a-6968-4a7b-88ec-52013f1d370b")
    @Override
    public void setOwnerUse(InteractionUse value) {
        appendDepVal(((GateSmClass)getClassOf()).getOwnerUseDep(), (SmObjectImpl)value);
    }

    @objid ("db99e4fc-771e-4ae3-93b0-4022fc45f72d")
    @Override
    public EList<Gate> getActual() {
        return new SmList<>(this, ((GateSmClass)getClassOf()).getActualDep());
    }

    @objid ("c35e34f3-3a4a-4b5a-9e57-16a336a7349a")
    @Override
    public <T extends Gate> List<T> getActual(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Gate element : getActual()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("27ad7f57-fe7c-4984-b0cf-20d1e0f9f373")
    @Override
    public Interaction getOwnerInteraction() {
        Object obj = getDepVal(((GateSmClass)getClassOf()).getOwnerInteractionDep());
        return (obj instanceof Interaction)? (Interaction)obj : null;
    }

    @objid ("fd27f62c-5389-41ce-aa3b-a730a7cf987f")
    @Override
    public void setOwnerInteraction(Interaction value) {
        appendDepVal(((GateSmClass)getClassOf()).getOwnerInteractionDep(), (SmObjectImpl)value);
    }

    @objid ("e6885011-4ca4-4cdc-94cd-dc3c70516496")
    @Override
    public CombinedFragment getOwnerFragment() {
        Object obj = getDepVal(((GateSmClass)getClassOf()).getOwnerFragmentDep());
        return (obj instanceof CombinedFragment)? (CombinedFragment)obj : null;
    }

    @objid ("13775dc4-11b2-46c9-9412-d230ba793c76")
    @Override
    public void setOwnerFragment(CombinedFragment value) {
        appendDepVal(((GateSmClass)getClassOf()).getOwnerFragmentDep(), (SmObjectImpl)value);
    }

    @objid ("be837244-ecb4-4b4d-8eb0-6659eb68e992")
    @Override
    public Gate getFormal() {
        Object obj = getDepVal(((GateSmClass)getClassOf()).getFormalDep());
        return (obj instanceof Gate)? (Gate)obj : null;
    }

    @objid ("11d832d0-1535-4841-a8e3-b3182b2135e8")
    @Override
    public void setFormal(Gate value) {
        appendDepVal(((GateSmClass)getClassOf()).getFormalDep(), (SmObjectImpl)value);
    }

    @objid ("d3f96c72-d977-4834-afd8-9fa51b246437")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // OwnerUse
        obj = (SmObjectImpl)this.getDepVal(((GateSmClass)getClassOf()).getOwnerUseDep());
        if (obj != null)
          return obj;
        // OwnerInteraction
        obj = (SmObjectImpl)this.getDepVal(((GateSmClass)getClassOf()).getOwnerInteractionDep());
        if (obj != null)
          return obj;
        // OwnerFragment
        obj = (SmObjectImpl)this.getDepVal(((GateSmClass)getClassOf()).getOwnerFragmentDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("9684e421-90fc-44c5-846e-640b80288bda")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // OwnerUse
        dep = ((GateSmClass)getClassOf()).getOwnerUseDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerInteraction
        dep = ((GateSmClass)getClassOf()).getOwnerInteractionDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // OwnerFragment
        dep = ((GateSmClass)getClassOf()).getOwnerFragmentDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("1ef32de6-6b7c-4e7e-aa88-20bf4f46a68b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitGate(this);
    }

}
