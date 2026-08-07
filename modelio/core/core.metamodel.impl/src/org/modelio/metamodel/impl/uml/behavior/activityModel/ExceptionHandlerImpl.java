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
import org.modelio.metamodel.uml.behavior.activityModel.ActivityAction;
import org.modelio.metamodel.uml.behavior.activityModel.ExceptionHandler;
import org.modelio.metamodel.uml.behavior.activityModel.InputPin;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0030ab7e-c4bf-1fd8-97fe-001ec947cd2a")
public class ExceptionHandlerImpl extends UmlModelElementImpl implements ExceptionHandler {
    @objid ("c00aea4f-cd1b-47ea-9370-ab57c7160a67")
    @Override
    public String getGuard() {
        return (String) getAttVal(((ExceptionHandlerSmClass)getClassOf()).getGuardAtt());
    }

    @objid ("77019a0f-8f76-4909-8d4d-ae0ed2ca3e0f")
    @Override
    public void setGuard(String value) {
        setAttVal(((ExceptionHandlerSmClass)getClassOf()).getGuardAtt(), value);
    }

    @objid ("06f32468-ad1e-4a91-bd99-16fcb9e03a52")
    @Override
    public String getWeight() {
        return (String) getAttVal(((ExceptionHandlerSmClass)getClassOf()).getWeightAtt());
    }

    @objid ("2dc7cb7a-4f9e-4264-9a49-bc65798efd8e")
    @Override
    public void setWeight(String value) {
        setAttVal(((ExceptionHandlerSmClass)getClassOf()).getWeightAtt(), value);
    }

    @objid ("0752fb9c-f223-4cf4-a86c-7ad848c42ccc")
    @Override
    public ActivityAction getProtectedNode() {
        Object obj = getDepVal(((ExceptionHandlerSmClass)getClassOf()).getProtectedNodeDep());
        return (obj instanceof ActivityAction)? (ActivityAction)obj : null;
    }

    @objid ("66964d47-2aa4-4a27-848e-017075dbc65f")
    @Override
    public void setProtectedNode(ActivityAction value) {
        appendDepVal(((ExceptionHandlerSmClass)getClassOf()).getProtectedNodeDep(), (SmObjectImpl)value);
    }

    @objid ("2cd71dab-9a75-463b-a448-12427de1f6fc")
    @Override
    public InputPin getExceptionInput() {
        Object obj = getDepVal(((ExceptionHandlerSmClass)getClassOf()).getExceptionInputDep());
        return (obj instanceof InputPin)? (InputPin)obj : null;
    }

    @objid ("92d90212-ac10-49d1-ac14-6304be4eb289")
    @Override
    public void setExceptionInput(InputPin value) {
        appendDepVal(((ExceptionHandlerSmClass)getClassOf()).getExceptionInputDep(), (SmObjectImpl)value);
    }

    @objid ("710a9efe-0982-4742-accb-fc739f31a164")
    @Override
    public EList<GeneralClass> getExceptionType() {
        return new SmList<>(this, ((ExceptionHandlerSmClass)getClassOf()).getExceptionTypeDep());
    }

    @objid ("b3d68954-c822-49da-8559-e17efb8fdc3a")
    @Override
    public <T extends GeneralClass> List<T> getExceptionType(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final GeneralClass element : getExceptionType()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("203e7c37-bd26-4f04-a83f-501270fc3be4")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ProtectedNode
        obj = (SmObjectImpl)this.getDepVal(((ExceptionHandlerSmClass)getClassOf()).getProtectedNodeDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("8bc5d705-eb03-4125-be7e-5f5c4dc264ae")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ProtectedNode
        dep = ((ExceptionHandlerSmClass)getClassOf()).getProtectedNodeDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("87407e44-9900-4af6-8515-3878b019fd6e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExceptionHandler(this);
    }

}
