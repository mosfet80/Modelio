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
package org.modelio.metamodel.impl.uml.infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.uml.infrastructure.Constraint;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00856a60-c4be-1fd8-97fe-001ec947cd2a")
public class ConstraintImpl extends UmlModelElementImpl implements Constraint {
    @objid ("006b6ba6-4224-10bf-bd58-001ec947cd2a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        List<SmObjectImpl> list = this.getDepValList(((ConstraintSmClass) getClassOf()).getConstrainedElementDep());
        if (list.isEmpty()) {
            return super.getCompositionOwner();
        } else {
            return list.get(0);
        }

    }

    @objid ("006b90fe-4224-10bf-bd58-001ec947cd2a")
    @Override
    public SmDepVal getCompositionRelation() {
        List<SmObjectImpl> list = this.getDepValList(((ConstraintSmClass) getClassOf()).getConstrainedElementDep());
        if (list.isEmpty()) {
            return super.getCompositionRelation();
        } else {
            return new SmDepVal(((ConstraintSmClass) getClassOf()).getConstrainedElementDep(), list.get(0));
        }

    }

    @objid ("dc0243f1-0d07-41a0-a075-8956cb67cd32")
    @Override
    public void afterEraseDepVal(SmDependency dep, SmObjectImpl value) {
        if (dep == ((ConstraintSmClass) getClassOf()).getConstrainedElementDep()) {
            // Workaround bug where the storage handle is not updated
            EList<UmlModelElement> remainingOwners = getConstrainedElement();
            if (!remainingOwners.isEmpty()) {
                // Remove and add again the first remaining owner.
                // Note : this will trigger recursively the removal & addition of all other owners.
                UmlModelElement r = remainingOwners.get(0);
                r.getConstraintDefinition().remove(this);

                r.getConstraintDefinition().add(this);
            }
        }

        super.afterEraseDepVal(dep, value);

    }

    @objid ("0c0e5698-d05c-42d4-a92f-ec95b073c037")
    @Override
    public String getBaseClass() {
        return (String) getAttVal(((ConstraintSmClass)getClassOf()).getBaseClassAtt());
    }

    @objid ("a2d141ae-e2f5-4e10-9cff-0ea9f21d689d")
    @Override
    public void setBaseClass(String value) {
        setAttVal(((ConstraintSmClass)getClassOf()).getBaseClassAtt(), value);
    }

    @objid ("c26f8752-6800-4dc3-aaf7-99959b74a2cb")
    @Override
    public String getBody() {
        return (String) getAttVal(((ConstraintSmClass)getClassOf()).getBodyAtt());
    }

    @objid ("42b24a4d-b4fd-4eca-87b2-49a73129f276")
    @Override
    public void setBody(String value) {
        setAttVal(((ConstraintSmClass)getClassOf()).getBodyAtt(), value);
    }

    @objid ("78c25a47-4369-431d-b159-acfb103c89df")
    @Override
    public String getLanguage() {
        return (String) getAttVal(((ConstraintSmClass)getClassOf()).getLanguageAtt());
    }

    @objid ("0d166057-1d02-4196-82fe-b2b720869607")
    @Override
    public void setLanguage(String value) {
        setAttVal(((ConstraintSmClass)getClassOf()).getLanguageAtt(), value);
    }

    @objid ("b5589e39-c7ea-4738-bed8-984a0e16f5c2")
    @Override
    public EList<UmlModelElement> getConstrainedElement() {
        return new SmList<>(this, ((ConstraintSmClass)getClassOf()).getConstrainedElementDep());
    }

    @objid ("2021d5d8-95a8-48d5-acd3-781f1728042f")
    @Override
    public <T extends UmlModelElement> List<T> getConstrainedElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UmlModelElement element : getConstrainedElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5ecb31eb-2c76-4da6-ad85-26dc882122c9")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitConstraint(this);
    }

}
