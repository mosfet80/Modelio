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
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00353996-c4bf-1fd8-97fe-001ec947cd2a")
public class InputPinImpl extends PinImpl implements InputPin {
    @objid ("f745897d-bc6c-4fcc-851d-f049147958c4")
    @Override
    public boolean isIsSelf() {
        return (Boolean) getAttVal(((InputPinSmClass)getClassOf()).getIsSelfAtt());
    }

    @objid ("d480ca29-fc51-4ffb-a797-d2ea34997a07")
    @Override
    public void setIsSelf(boolean value) {
        setAttVal(((InputPinSmClass)getClassOf()).getIsSelfAtt(), value);
    }

    @objid ("633f59d4-2801-483a-bb3c-cf1ed3578b87")
    @Override
    public EList<ExceptionHandler> getHandler() {
        return new SmList<>(this, ((InputPinSmClass)getClassOf()).getHandlerDep());
    }

    @objid ("d79b0d47-7f72-411b-872c-db5715acab7b")
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

    @objid ("da8d90ef-9c1b-4576-9df8-1660e9caded4")
    @Override
    public ActivityAction getInputing() {
        Object obj = getDepVal(((InputPinSmClass)getClassOf()).getInputingDep());
        return (obj instanceof ActivityAction)? (ActivityAction)obj : null;
    }

    @objid ("348dab61-30c4-4dd1-b666-8b70261bb77d")
    @Override
    public void setInputing(ActivityAction value) {
        appendDepVal(((InputPinSmClass)getClassOf()).getInputingDep(), (SmObjectImpl)value);
    }

    @objid ("83d1b6d3-5243-4bd8-a89f-2249e42e3b7c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Inputing
        obj = (SmObjectImpl)this.getDepVal(((InputPinSmClass)getClassOf()).getInputingDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("96d21df4-dfef-4024-bb52-9ec9c2d75466")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Inputing
        dep = ((InputPinSmClass)getClassOf()).getInputingDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("22bcd66b-f5a3-4b08-a62a-5f6f4a29e08b")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInputPin(this);
    }

}
