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
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.Operation;
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

@objid ("001d5f2e-c4bf-1fd8-97fe-001ec947cd2a")
public class TemplateParameterImpl extends GeneralClassImpl implements TemplateParameter {
    @objid ("e4404a9f-0a48-4af5-acd0-513911af54e4")
    @Override
    public String getDefaultValue() {
        return (String) getAttVal(((TemplateParameterSmClass)getClassOf()).getDefaultValueAtt());
    }

    @objid ("7e7c1578-0b04-44e9-ada5-d1c924f3f940")
    @Override
    public void setDefaultValue(String value) {
        setAttVal(((TemplateParameterSmClass)getClassOf()).getDefaultValueAtt(), value);
    }

    @objid ("96f464df-a234-4cab-8555-0b843cee9328")
    @Override
    public boolean isIsValueParameter() {
        return (Boolean) getAttVal(((TemplateParameterSmClass)getClassOf()).getIsValueParameterAtt());
    }

    @objid ("2f8be707-63cd-42a8-8184-7d0e1979de42")
    @Override
    public void setIsValueParameter(boolean value) {
        setAttVal(((TemplateParameterSmClass)getClassOf()).getIsValueParameterAtt(), value);
    }

    @objid ("6ac178a0-9e5d-495f-a186-8c3f8778ddea")
    @Override
    public EList<TemplateParameterSubstitution> getParameterSubstitution() {
        return new SmList<>(this, ((TemplateParameterSmClass)getClassOf()).getParameterSubstitutionDep());
    }

    @objid ("642a7648-2b8c-44f2-88a2-ab7f7e7694e4")
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

    @objid ("00ae5354-ad19-47a1-b764-1829cd0ca345")
    @Override
    public UmlModelElement getType() {
        Object obj = getDepVal(((TemplateParameterSmClass)getClassOf()).getTypeDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("41c401f9-f20d-4821-84b8-1a4192f6c574")
    @Override
    public void setType(UmlModelElement value) {
        appendDepVal(((TemplateParameterSmClass)getClassOf()).getTypeDep(), (SmObjectImpl)value);
    }

    @objid ("7e7dda9f-7b55-4742-9f85-bc5248a84598")
    @Override
    public NameSpace getParameterized() {
        Object obj = getDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("dbd225ad-ae8e-4302-95c0-ec70784f3a21")
    @Override
    public void setParameterized(NameSpace value) {
        appendDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedDep(), (SmObjectImpl)value);
    }

    @objid ("89f3085a-202e-42cf-84cc-99d92604876b")
    @Override
    public UmlModelElement getOwnedParameterElement() {
        Object obj = getDepVal(((TemplateParameterSmClass)getClassOf()).getOwnedParameterElementDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("8f0a7625-e528-454a-8c61-d25d8f747576")
    @Override
    public void setOwnedParameterElement(UmlModelElement value) {
        appendDepVal(((TemplateParameterSmClass)getClassOf()).getOwnedParameterElementDep(), (SmObjectImpl)value);
    }

    @objid ("32eef7fe-860a-4aba-bd6a-55f784e92195")
    @Override
    public UmlModelElement getDefaultType() {
        Object obj = getDepVal(((TemplateParameterSmClass)getClassOf()).getDefaultTypeDep());
        return (obj instanceof UmlModelElement)? (UmlModelElement)obj : null;
    }

    @objid ("354cbc9d-2d3b-40dc-a30f-cbecd4c9be4e")
    @Override
    public void setDefaultType(UmlModelElement value) {
        appendDepVal(((TemplateParameterSmClass)getClassOf()).getDefaultTypeDep(), (SmObjectImpl)value);
    }

    @objid ("2b6e0478-6860-4e52-a62d-b43c048841da")
    @Override
    public Operation getParameterizedOperation() {
        Object obj = getDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedOperationDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("f136f1ba-cfe6-4167-92b1-a333ac7a56be")
    @Override
    public void setParameterizedOperation(Operation value) {
        appendDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedOperationDep(), (SmObjectImpl)value);
    }

    @objid ("994d3678-4721-44bc-8c6e-6a1fa539ddb6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Parameterized
        obj = (SmObjectImpl)this.getDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedDep());
        if (obj != null)
          return obj;
        // ParameterizedOperation
        obj = (SmObjectImpl)this.getDepVal(((TemplateParameterSmClass)getClassOf()).getParameterizedOperationDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("3ca7738a-3bd0-4a5d-b02a-3c247ee5037a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Parameterized
        dep = ((TemplateParameterSmClass)getClassOf()).getParameterizedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // ParameterizedOperation
        dep = ((TemplateParameterSmClass)getClassOf()).getParameterizedOperationDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("f501de42-5091-487f-bc68-a3c47419c644")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitTemplateParameter(this);
    }

}
