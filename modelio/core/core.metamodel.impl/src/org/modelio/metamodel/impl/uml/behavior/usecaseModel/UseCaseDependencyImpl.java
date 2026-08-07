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
package org.modelio.metamodel.impl.uml.behavior.usecaseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.usecaseModel.ExtensionPoint;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCase;
import org.modelio.metamodel.uml.behavior.usecaseModel.UseCaseDependency;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00592d06-c4bf-1fd8-97fe-001ec947cd2a")
public class UseCaseDependencyImpl extends UmlModelElementImpl implements UseCaseDependency {
    @objid ("eae90c40-a0f3-4706-af38-28905df810f1")
    @Override
    public UseCase getOrigin() {
        Object obj = getDepVal(((UseCaseDependencySmClass)getClassOf()).getOriginDep());
        return (obj instanceof UseCase)? (UseCase)obj : null;
    }

    @objid ("22d34cb9-d5ee-4249-a9c0-d5e7477fa4fe")
    @Override
    public void setOrigin(UseCase value) {
        appendDepVal(((UseCaseDependencySmClass)getClassOf()).getOriginDep(), (SmObjectImpl)value);
    }

    @objid ("19208243-c480-49c0-8018-91a59fb08cd9")
    @Override
    public EList<ExtensionPoint> getExtensionLocation() {
        return new SmList<>(this, ((UseCaseDependencySmClass)getClassOf()).getExtensionLocationDep());
    }

    @objid ("2710c2b9-a845-4cbc-ac86-d21c378b7865")
    @Override
    public <T extends ExtensionPoint> List<T> getExtensionLocation(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExtensionPoint element : getExtensionLocation()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("501c0077-54f2-457e-b11a-4cdc872b513a")
    @Override
    public UseCase getTarget() {
        Object obj = getDepVal(((UseCaseDependencySmClass)getClassOf()).getTargetDep());
        return (obj instanceof UseCase)? (UseCase)obj : null;
    }

    @objid ("aa162bf1-cbc7-4eca-b166-f166191e3247")
    @Override
    public void setTarget(UseCase value) {
        appendDepVal(((UseCaseDependencySmClass)getClassOf()).getTargetDep(), (SmObjectImpl)value);
    }

    @objid ("09891f94-d423-41f0-88e5-72fb9e95ff23")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Origin
        obj = (SmObjectImpl)this.getDepVal(((UseCaseDependencySmClass)getClassOf()).getOriginDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("c22f9a49-9694-40d4-b364-18a23f8fec81")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Origin
        dep = ((UseCaseDependencySmClass)getClassOf()).getOriginDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("cf45b074-b157-4347-88bc-ed5b3b30fde8")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitUseCaseDependency(this);
    }

}
