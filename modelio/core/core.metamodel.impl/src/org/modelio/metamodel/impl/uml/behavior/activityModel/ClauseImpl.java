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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.ConditionalNode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("002cec14-c4bf-1fd8-97fe-001ec947cd2a")
public class ClauseImpl extends UmlModelElementImpl implements Clause {
    @objid ("9440858c-6213-4b5b-957a-aeeac1defdbc")
    @Override
    public String getTest() {
        return (String) getAttVal(((ClauseSmClass)getClassOf()).getTestAtt());
    }

    @objid ("ac6d2ea6-d6c3-496d-9e9b-5ffdb5ec0309")
    @Override
    public void setTest(String value) {
        setAttVal(((ClauseSmClass)getClassOf()).getTestAtt(), value);
    }

    @objid ("4df3c07c-2a59-4071-9249-13862723321c")
    @Override
    public EList<ActivityNode> getBody() {
        return new SmList<>(this, ((ClauseSmClass)getClassOf()).getBodyDep());
    }

    @objid ("fe482d83-cd71-4f7b-b2b5-d8e4c6727691")
    @Override
    public <T extends ActivityNode> List<T> getBody(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityNode element : getBody()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("d5e5db66-8633-41f1-9aaa-504e40d758de")
    @Override
    public ConditionalNode getOwner() {
        Object obj = getDepVal(((ClauseSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof ConditionalNode)? (ConditionalNode)obj : null;
    }

    @objid ("9cff4835-2755-4697-a501-2dce032b4c73")
    @Override
    public void setOwner(ConditionalNode value) {
        appendDepVal(((ClauseSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("af5da8a5-1a0a-47a6-ac2b-9bb41345a708")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((ClauseSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("58316846-8561-451d-ba37-571e0aba69bc")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((ClauseSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("a850e3b5-04e9-46ce-93c6-0083a165d00b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitClause(this);
    }

}
