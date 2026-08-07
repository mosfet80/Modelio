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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Binding;
import org.modelio.metamodel.uml.statik.Collaboration;
import org.modelio.metamodel.uml.statik.CollaborationUse;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0004a754-c4bf-1fd8-97fe-001ec947cd2a")
public class CollaborationUseImpl extends UmlModelElementImpl implements CollaborationUse {
    @objid ("a0deb8cf-2dbd-4ee8-88dd-2e2a8f5f49a1")
    @Override
    public Collaboration getType() {
        Object obj = getDepVal(((CollaborationUseSmClass)getClassOf()).getTypeDep());
        return (obj instanceof Collaboration)? (Collaboration)obj : null;
    }

    @objid ("ad91d57f-93ee-4017-9e12-a138ffe60775")
    @Override
    public void setType(Collaboration value) {
        appendDepVal(((CollaborationUseSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("1a8d0bd4-841f-4ccc-926b-667204a375e9")
    @Override
    public NameSpace getNRepresented() {
        Object obj = getDepVal(((CollaborationUseSmClass)getClassOf()).getNRepresentedDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("95102a1a-7e50-48e2-b832-171210abf627")
    @Override
    public void setNRepresented(NameSpace value) {
        appendDepVal(((CollaborationUseSmClass)getClassOf()).getNRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("cf2860ae-edc6-4c76-b387-f915b0dfda03")
    @Override
    public Operation getORepresented() {
        Object obj = getDepVal(((CollaborationUseSmClass)getClassOf()).getORepresentedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("dd62b37c-cd50-4a27-9f2e-befaaacaed8a")
    @Override
    public void setORepresented(Operation value) {
        appendDepVal(((CollaborationUseSmClass)getClassOf()).getORepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("83f9eb1a-b709-43e0-ad0c-89343d2bd009")
    @Override
    public EList<Binding> getRoleBinding() {
        return new SmList<>(this, ((CollaborationUseSmClass)getClassOf()).getRoleBindingDep());
    }

    @objid ("d8f317b6-9511-43be-8377-820bf92f70b9")
    @Override
    public <T extends Binding> List<T> getRoleBinding(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Binding element : getRoleBinding()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("168f4df9-ee14-4678-8e13-e874c0aa9ad8")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // NRepresented
        obj = (SmObjectImpl)this.getDepVal(((CollaborationUseSmClass)getClassOf()).getNRepresentedDep());
        if (obj != null)
          return obj;
        // ORepresented
        obj = (SmObjectImpl)this.getDepVal(((CollaborationUseSmClass)getClassOf()).getORepresentedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("f3feb343-5480-41f3-9f5f-52adc3ee53dd")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // NRepresented
        dep = ((CollaborationUseSmClass)getClassOf()).getNRepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ORepresented
        dep = ((CollaborationUseSmClass)getClassOf()).getORepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("39e83483-2f03-4fe0-af57-c04454b4eb37")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCollaborationUse(this);
    }

}
