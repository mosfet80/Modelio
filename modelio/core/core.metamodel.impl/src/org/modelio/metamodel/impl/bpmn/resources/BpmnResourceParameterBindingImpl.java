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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameter;
import org.modelio.metamodel.bpmn.resources.BpmnResourceParameterBinding;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementImpl;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("000b59e6-c4c0-1fd8-97fe-001ec947cd2a")
public class BpmnResourceParameterBindingImpl extends BpmnBaseElementImpl implements BpmnResourceParameterBinding {
    @objid ("57fdc0f0-6f9f-4da9-83d2-5d62fab0251d")
    @Override
    public String getExpression() {
        return (String) getAttVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getExpressionAtt());
    }

    @objid ("e0eea638-97b0-4abd-8d4e-116810b49f3b")
    @Override
    public void setExpression(String value) {
        setAttVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getExpressionAtt(), value);
    }

    @objid ("0a9816f4-8b71-4aec-8d7d-3d4a83c8c061")
    @Override
    public BpmnResourceRole getResourceRole() {
        Object obj = getDepVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getResourceRoleDep());
        return (obj instanceof BpmnResourceRole)? (BpmnResourceRole)obj : null;
    }

    @objid ("48df51a4-5228-4f75-a33d-4a3dd8d0a3b4")
    @Override
    public void setResourceRole(BpmnResourceRole value) {
        appendDepVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getResourceRoleDep(), (SmObjectImpl)value);
    }

    @objid ("1e0ad7d5-8dca-4dd5-99c0-294d56370d20")
    @Override
    public BpmnResourceParameter getParameterRef() {
        Object obj = getDepVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getParameterRefDep());
        return (obj instanceof BpmnResourceParameter)? (BpmnResourceParameter)obj : null;
    }

    @objid ("b43198b6-437c-456d-a8b0-726a5a050064")
    @Override
    public void setParameterRef(BpmnResourceParameter value) {
        appendDepVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getParameterRefDep(), (SmObjectImpl)value);
    }

    @objid ("0c6bec98-a2b8-443e-8b8e-54e5c6ac8b1e")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ResourceRole
        obj = (SmObjectImpl)this.getDepVal(((BpmnResourceParameterBindingSmClass)getClassOf()).getResourceRoleDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("1f8eb552-e9b6-4ce2-80d5-7bf91a60ca0e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ResourceRole
        dep = ((BpmnResourceParameterBindingSmClass)getClassOf()).getResourceRoleDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("8ca347e2-697a-4687-89c9-faa1b547facf")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnResourceParameterBinding(this);
    }

}
