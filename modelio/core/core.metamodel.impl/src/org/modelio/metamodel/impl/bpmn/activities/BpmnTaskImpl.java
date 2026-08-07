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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.bpmn.activities.BpmnCallActivity;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0084e734-c4bf-1fd8-97fe-001ec947cd2a")
public class BpmnTaskImpl extends BpmnActivityImpl implements BpmnTask {
    @objid ("d0dfe16f-0248-462d-b2a1-20851d5d1972")
    @Override
    public boolean isIsGlobal() {
        return (Boolean) getAttVal(((BpmnTaskSmClass)getClassOf()).getIsGlobalAtt());
    }

    @objid ("bb856bb6-c3ac-4914-a763-5ee8fb75ff9c")
    @Override
    public void setIsGlobal(boolean value) {
        setAttVal(((BpmnTaskSmClass)getClassOf()).getIsGlobalAtt(), value);
    }

    @objid ("d3e06a72-a7f7-4b5c-912a-31bbfab9ce02")
    @Override
    public EList<BpmnCallActivity> getCaller() {
        return new SmList<>(this, ((BpmnTaskSmClass)getClassOf()).getCallerDep());
    }

    @objid ("d39472d3-f3ae-4be4-b6a5-6d7ab1bced22")
    @Override
    public <T extends BpmnCallActivity> List<T> getCaller(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BpmnCallActivity element : getCaller()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cf2de258-6897-4d57-a4ad-6b0305f6cf67")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("0641e911-e676-4278-9d37-a61d08ca79c8")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("21fe5160-48a2-4cca-b80e-f0dbe3361a39")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitBpmnTask(this);
    }

}
