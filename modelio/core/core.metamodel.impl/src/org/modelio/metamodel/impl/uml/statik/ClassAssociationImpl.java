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
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.NaryAssociation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0002efae-c4bf-1fd8-97fe-001ec947cd2a")
public class ClassAssociationImpl extends UmlModelElementImpl implements ClassAssociation {
    @objid ("41202e4e-c2a5-4afd-a254-748d9b4e4668")
    @Override
    public NaryAssociation getNaryAssociationPart() {
        Object obj = getDepVal(((ClassAssociationSmClass)getClassOf()).getNaryAssociationPartDep());
        return (obj instanceof NaryAssociation)? (NaryAssociation)obj : null;
    }

    @objid ("9c1f7037-36c7-43fc-bcb0-c4c75df5dcd4")
    @Override
    public void setNaryAssociationPart(NaryAssociation value) {
        appendDepVal(((ClassAssociationSmClass)getClassOf()).getNaryAssociationPartDep(), (SmObjectImpl)value);
    }

    @objid ("271312df-7400-4312-948b-3bccd77bf9ca")
    @Override
    public Class getClassPart() {
        Object obj = getDepVal(((ClassAssociationSmClass)getClassOf()).getClassPartDep());
        return (obj instanceof Class)? (Class)obj : null;
    }

    @objid ("fbdb576b-63c5-4eb6-b88e-2bf2801bc403")
    @Override
    public void setClassPart(Class value) {
        appendDepVal(((ClassAssociationSmClass)getClassOf()).getClassPartDep(), (SmObjectImpl)value);
    }

    @objid ("48b6d40f-2dde-44b1-bf7f-8ffd9e3375d9")
    @Override
    public Association getAssociationPart() {
        Object obj = getDepVal(((ClassAssociationSmClass)getClassOf()).getAssociationPartDep());
        return (obj instanceof Association)? (Association)obj : null;
    }

    @objid ("86fcbffd-1a7e-4903-80cf-312ca1545781")
    @Override
    public void setAssociationPart(Association value) {
        appendDepVal(((ClassAssociationSmClass)getClassOf()).getAssociationPartDep(), (SmObjectImpl)value);
    }

    @objid ("0bbc038c-875f-40d1-9341-7bedf75d80eb")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // NaryAssociationPart
        obj = (SmObjectImpl)this.getDepVal(((ClassAssociationSmClass)getClassOf()).getNaryAssociationPartDep());
        if (obj != null)
          return obj;
        // AssociationPart
        obj = (SmObjectImpl)this.getDepVal(((ClassAssociationSmClass)getClassOf()).getAssociationPartDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c027d95f-6908-4e20-9fe0-cbafac0487c5")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // NaryAssociationPart
        dep = ((ClassAssociationSmClass)getClassOf()).getNaryAssociationPartDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // AssociationPart
        dep = ((ClassAssociationSmClass)getClassOf()).getAssociationPartDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5c9edbf4-a2da-464c-9ad8-268d5b377e0d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitClassAssociation(this);
    }

}
