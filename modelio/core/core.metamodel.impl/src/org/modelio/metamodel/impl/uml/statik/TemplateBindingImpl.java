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
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("001c7c58-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateBindingImpl extends UmlModelElementImpl implements TemplateBinding {
    @objid ("60b5a931-77d8-478b-ac3c-e15ab3162de6")
    @Override
    public EList<TemplateParameterSubstitution> getParameterSubstitution() {
        return new SmList<>(this, ((TemplateBindingSmClass)getClassOf()).getParameterSubstitutionDep());
    }

    @objid ("89394f50-2014-401a-8f22-882bf39dd245")
    @Override
    public <T extends TemplateParameterSubstitution> List<T> getParameterSubstitution(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TemplateParameterSubstitution element : getParameterSubstitution()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("181df453-48b8-45c0-b78b-ef9692e8f574")
    @Override
    public Operation getBoundOperation() {
        Object obj = getDepVal(((TemplateBindingSmClass)getClassOf()).getBoundOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("89c55814-7199-436b-9062-d389b7e30aaa")
    @Override
    public void setBoundOperation(Operation value) {
        appendDepVal(((TemplateBindingSmClass)getClassOf()).getBoundOperationDep(), (SmObjectImpl)value);
    }

    @objid ("8d7369ed-37a5-4540-9a55-f53ecbfbddcf")
    @Override
    public Operation getInstanciatedTemplateOperation() {
        Object obj = getDepVal(((TemplateBindingSmClass)getClassOf()).getInstanciatedTemplateOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("cfb4ded7-34da-4462-898b-b1fdc9919a8e")
    @Override
    public void setInstanciatedTemplateOperation(Operation value) {
        appendDepVal(((TemplateBindingSmClass)getClassOf()).getInstanciatedTemplateOperationDep(), (SmObjectImpl)value);
    }

    @objid ("9b7b9dff-ec27-4c4a-b068-ffe9fb112578")
    @Override
    public NameSpace getInstanciatedTemplate() {
        Object obj = getDepVal(((TemplateBindingSmClass)getClassOf()).getInstanciatedTemplateDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("4e8870b1-3796-4911-b205-51d98bed4ff5")
    @Override
    public void setInstanciatedTemplate(NameSpace value) {
        appendDepVal(((TemplateBindingSmClass)getClassOf()).getInstanciatedTemplateDep(), (SmObjectImpl)value);
    }

    @objid ("5713f346-c169-44f0-b2f7-9d023924fe24")
    @Override
    public NameSpace getBoundElement() {
        Object obj = getDepVal(((TemplateBindingSmClass)getClassOf()).getBoundElementDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("d481aa7e-6ee0-4929-a486-2db9f18228ce")
    @Override
    public void setBoundElement(NameSpace value) {
        appendDepVal(((TemplateBindingSmClass)getClassOf()).getBoundElementDep(), (SmObjectImpl)value);
    }

    @objid ("79771873-de59-44b4-b20f-368a11c72030")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // BoundOperation
        obj = (SmObjectImpl)this.getDepVal(((TemplateBindingSmClass)getClassOf()).getBoundOperationDep());
        if (obj != null)
          return obj;
        // BoundElement
        obj = (SmObjectImpl)this.getDepVal(((TemplateBindingSmClass)getClassOf()).getBoundElementDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("9f7d5063-0e83-4604-b294-a3427388c8ab")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // BoundOperation
        dep = ((TemplateBindingSmClass)getClassOf()).getBoundOperationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // BoundElement
        dep = ((TemplateBindingSmClass)getClassOf()).getBoundElementDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("84eeff68-7b05-432b-b6e4-d9e056ede4bf")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitTemplateBinding(this);
    }

}
