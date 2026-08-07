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
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.resources.BpmnResource;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000a1464-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceParameterImpl extends BpmnBaseElementImpl implements BpmnResourceParameter {
    @objid ("85d1213c-70e1-4fa8-95ca-d0e7a88bada9")
    @Override
    public boolean isIsRequired() {
        return (Boolean) getAttVal(((BpmnResourceParameterSmClass)getClassOf()).getIsRequiredAtt());
    }

    @objid ("d92bd40f-a6d1-487b-b2fa-1f42fc0f0df7")
    @Override
    public void setIsRequired(boolean value) {
        setAttVal(((BpmnResourceParameterSmClass)getClassOf()).getIsRequiredAtt(), value);
    }

    @objid ("9fecd3b7-7d1a-4281-a9e6-15f2d92e7c22")
    @Override
    public BpmnResource getResource() {
        Object obj = getDepVal(((BpmnResourceParameterSmClass)getClassOf()).getResourceDep());
        return (obj instanceof BpmnResource)? (BpmnResource)obj : null;
    }

    @objid ("a6268889-d9ea-4144-aba6-3b60dc0f7344")
    @Override
    public void setResource(BpmnResource value) {
        appendDepVal(((BpmnResourceParameterSmClass)getClassOf()).getResourceDep(), (SmObjectImpl)value);
    }

    @objid ("54f4b7a9-66d0-4f94-9dad-d964fd88702c")
    @Override
    public BpmnItemDefinition getType() {
        Object obj = getDepVal(((BpmnResourceParameterSmClass)getClassOf()).getTypeDep());
        return (obj instanceof BpmnItemDefinition)? (BpmnItemDefinition)obj : null;
    }

    @objid ("91bc9711-0388-4830-8143-b01ebc1e84c6")
    @Override
    public void setType(BpmnItemDefinition value) {
        appendDepVal(((BpmnResourceParameterSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("17cee731-104b-4e06-8588-e5498a96f1e8")
    @Override
    public EList<BpmnResourceParameterBinding> getParameterBindingRefs() {
        return new SmList<>(this, ((BpmnResourceParameterSmClass)getClassOf()).getParameterBindingRefsDep());
    }

    @objid ("3ec3f2f1-4b42-4941-9cfc-7e818159d97d")
    @Override
    public <T extends BpmnResourceParameterBinding> List<T> getParameterBindingRefs(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnResourceParameterBinding element : getParameterBindingRefs()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("75ec01e6-cabe-44e2-80b3-e40938e42dc2")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Resource
        obj = (SmObjectImpl)this.getDepVal(((BpmnResourceParameterSmClass)getClassOf()).getResourceDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("4d562a45-cdba-4206-bb34-351bc640f6e4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Resource
        dep = ((BpmnResourceParameterSmClass)getClassOf()).getResourceDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("822201a8-f51c-4566-b189-43b31d4b8c2a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnResourceParameter(this);
    }

}
