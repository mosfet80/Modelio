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
import org.modelio.metamodel.uml.statik.Association;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.ClassAssociation;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("fc1c8e64-9214-4368-b40c-1cd3ca98af0e")
public class AssociationImpl extends UmlModelElementImpl implements Association {
    @objid ("2b1bab62-c9cc-48df-b34c-e6427c1c26dc")
    @Override
    public SmObjectImpl getCompositionOwner() {
        for (SmObjectImpl obj : this.getDepValList(((AssociationSmClass) getClassOf()).getEndDep())) {
            return obj;
        }
        return super.getCompositionOwner();
    }

    @objid ("12b5fdbd-b680-4038-b500-0ab8b40b6b74")
    @Override
    public SmDepVal getCompositionRelation() {
        for (SmObjectImpl obj : this.getDepValList(((AssociationSmClass) getClassOf()).getEndDep())) {
            return new SmDepVal(((AssociationSmClass) getClassOf()).getEndDep(), obj);
        }
        return super.getCompositionRelation();
    }

    @objid ("f0cb0e21-4d3c-4bf6-95bb-d85528575005")
    @Override
    public EList<Link> getOccurence() {
        return new SmList<>(this, ((AssociationSmClass)getClassOf()).getOccurenceDep());
    }

    @objid ("2d6e2f46-41c6-4722-a067-d3899c906664")
    @Override
    public <T extends Link> List<T> getOccurence(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Link element : getOccurence()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("3f55eace-628c-4c48-815c-e2a46b4157e7")
    @Override
    public EList<AssociationEnd> getEnd() {
        return new SmList<>(this, ((AssociationSmClass)getClassOf()).getEndDep());
    }

    @objid ("9993f05b-b43b-4af3-b7e8-02c483723093")
    @Override
    public <T extends AssociationEnd> List<T> getEnd(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final AssociationEnd element : getEnd()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e57213ba-cdbc-4662-91fa-424dcd63db1a")
    @Override
    public ClassAssociation getLinkToClass() {
        Object obj = getDepVal(((AssociationSmClass)getClassOf()).getLinkToClassDep());
        return (obj instanceof ClassAssociation)? (ClassAssociation)obj : null;
    }

    @objid ("4be5b077-9f99-4ad8-9fc3-5b3a8a23f777")
    @Override
    public void setLinkToClass(ClassAssociation value) {
        appendDepVal(((AssociationSmClass)getClassOf()).getLinkToClassDep(), (SmObjectImpl)value);
    }

    @objid ("430df5a5-6685-41aa-b244-7fe811356dc0")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitAssociation(this);
    }

}
