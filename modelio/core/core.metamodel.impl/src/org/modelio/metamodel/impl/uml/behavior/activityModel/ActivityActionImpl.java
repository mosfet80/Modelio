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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.behavior.activityModel.OutputPin;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0026b060-c4bf-1fd8-97fe-001ec947cd2a")
public abstract class ActivityActionImpl extends ActivityNodeImpl implements ActivityAction {
    @objid ("6e1286ac-9dce-4cf5-9741-4cadfacb51de")
    @Override
    public boolean isIsMultipleInstance() {
        return (Boolean) getAttVal(((ActivityActionSmClass)getClassOf()).getIsMultipleInstanceAtt());
    }

    @objid ("53012549-3108-4384-90de-545b56d2485e")
    @Override
    public void setIsMultipleInstance(boolean value) {
        setAttVal(((ActivityActionSmClass)getClassOf()).getIsMultipleInstanceAtt(), value);
    }

    @objid ("e6a55971-dc38-425c-b2ec-9dfedd9b80f8")
    @Override
    public boolean isIsCompensation() {
        return (Boolean) getAttVal(((ActivityActionSmClass)getClassOf()).getIsCompensationAtt());
    }

    @objid ("d88544ab-f942-4341-8cf3-df39bd996cb2")
    @Override
    public void setIsCompensation(boolean value) {
        setAttVal(((ActivityActionSmClass)getClassOf()).getIsCompensationAtt(), value);
    }

    @objid ("885e482c-b483-4d20-bb1d-cf9bb5d4d12c")
    @Override
    public EList<OutputPin> getOutput() {
        return new SmList<>(this, ((ActivityActionSmClass)getClassOf()).getOutputDep());
    }

    @objid ("d9be0d6e-c447-4a87-b705-8c019c3dd12b")
    @Override
    public <T extends OutputPin> List<T> getOutput(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final OutputPin element : getOutput()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("089d74f0-0a1c-4f6d-8a4c-05cf1c2905f2")
    @Override
    public EList<InputPin> getInput() {
        return new SmList<>(this, ((ActivityActionSmClass)getClassOf()).getInputDep());
    }

    @objid ("ec6ed5ed-ca80-46f4-8587-306e4188579c")
    @Override
    public <T extends InputPin> List<T> getInput(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InputPin element : getInput()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ea0308ff-e9b9-4bb8-aa97-9932556e761c")
    @Override
    public EList<ExceptionHandler> getHandler() {
        return new SmList<>(this, ((ActivityActionSmClass)getClassOf()).getHandlerDep());
    }

    @objid ("2a040f12-7f10-4a02-b41b-d91188f3ddbc")
    @Override
    public <T extends ExceptionHandler> List<T> getHandler(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExceptionHandler element : getHandler()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("34d6ad3d-5941-4038-99e3-9d26882cc6cf")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2b9d52c1-beed-4f6d-a59d-3781d312bc49")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("bff8c07e-1562-4c08-b3b3-42750a67318f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitActivityAction(this);
    }

}
