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
import org.modelio.metamodel.uml.statik.Attribute;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00003354-c4bf-1fd8-97fe-001ec947cd2a")
public class AttributeLinkImpl extends UmlModelElementImpl implements AttributeLink {
    @objid ("ab8a9504-2d1a-4719-a4d8-1d1fcd63ce2b")
    @Override
    public String getValue() {
        return (String) getAttVal(((AttributeLinkSmClass)getClassOf()).getValueAtt());
    }

    @objid ("de577e8c-fe6e-4df2-9a22-4e1fb8ffe88f")
    @Override
    public void setValue(String value) {
        setAttVal(((AttributeLinkSmClass)getClassOf()).getValueAtt(), value);
    }

    @objid ("6dc42b40-98d4-4a29-9f5b-e0c19869d50a")
    @Override
    public Instance getAttributed() {
        Object obj = getDepVal(((AttributeLinkSmClass)getClassOf()).getAttributedDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("62e8880f-de42-49ca-9534-bc5a7e0556e6")
    @Override
    public void setAttributed(Instance value) {
        appendDepVal(((AttributeLinkSmClass)getClassOf()).getAttributedDep(), (SmObjectImpl)value);
    }

    @objid ("9ccd1104-1336-415b-aae6-31c91e05cda4")
    @Override
    public Attribute getBase() {
        Object obj = getDepVal(((AttributeLinkSmClass)getClassOf()).getBaseDep());
        return (obj instanceof Attribute)? (Attribute)obj : null;
    }

    @objid ("580d9810-e724-4f13-b7ec-445926f8179e")
    @Override
    public void setBase(Attribute value) {
        appendDepVal(((AttributeLinkSmClass)getClassOf()).getBaseDep(), (SmObjectImpl)value);
    }

    @objid ("73b587ec-9578-47b1-be2f-2dac358de891")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Attributed
        obj = (SmObjectImpl)this.getDepVal(((AttributeLinkSmClass)getClassOf()).getAttributedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("d03ba52f-d03c-41df-ba25-87b697855a2a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Attributed
        dep = ((AttributeLinkSmClass)getClassOf()).getAttributedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("f116fcd7-f70a-42a0-9228-029c196ad40a")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAttributeLink(this);
    }

}
