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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.TemplateBinding;
import org.modelio.metamodel.uml.statik.TemplateParameter;
import org.modelio.metamodel.uml.statik.TemplateParameterSubstitution;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("001e4902-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateParameterSubstitutionImpl extends UmlModelElementImpl implements TemplateParameterSubstitution {
    @objid ("fbbd223b-a161-46e5-848e-556bd3ecd63c")
    @Override
    public String getValue() {
        return (String) getAttVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getValueAtt());
    }

    @objid ("2183c1b7-c0fa-4dda-9531-35362fcbe16f")
    @Override
    public void setValue(String value) {
        setAttVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getValueAtt(), value);
    }

    @objid ("686a107e-3fd0-49f5-a633-1d02646e1298")
    @Override
    public TemplateBinding getOwner() {
        Object obj = getDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof TemplateBinding)? (TemplateBinding)obj : null;
    }

    @objid ("459e2a8f-3d2e-4e3c-8c7d-93f977e43665")
    @Override
    public void setOwner(TemplateBinding value) {
        appendDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("b1d57d64-fa33-4e04-9e19-e449833a0993")
    @Override
    public UmlModelElement getActual() {
        Object obj = getDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getActualDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("3c16a9e2-b6bc-4b6f-8cc8-a06fc9f7cda4")
    @Override
    public void setActual(UmlModelElement value) {
        appendDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getActualDep(), (SmObjectImpl)value);
    }

    @objid ("8bceac78-5ae9-4f26-97ff-05c719c4a49f")
    @Override
    public TemplateParameter getFormalParameter() {
        Object obj = getDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getFormalParameterDep());
        return (obj instanceof TemplateParameter)? (TemplateParameter)obj : null;
    }

    @objid ("cf8dffc4-afef-45b5-99ec-a4eaa349f0af")
    @Override
    public void setFormalParameter(TemplateParameter value) {
        appendDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getFormalParameterDep(), (SmObjectImpl)value);
    }

    @objid ("8590fa89-a91f-4062-8899-db4dcc621a5a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((TemplateParameterSubstitutionSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("247f6d38-d7ef-4d2f-bd5c-761589132a2d")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((TemplateParameterSubstitutionSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("0b4650b1-3bdc-44be-b3ab-8df4e8430f33")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitTemplateParameterSubstitution(this);
    }

}
