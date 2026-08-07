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
import org.modelio.metamodel.impl.uml.statik.GeneralClassImpl;
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

@objid ("0058abf6-c4bf-1fd8-97fe-001ec947cd2a")
public class UseCaseImpl extends GeneralClassImpl implements UseCase {
    @objid ("47f3b5ca-3b6d-4d00-a92b-de57fff777c5")
    @Override
    public EList<UseCaseDependency> getUsed() {
        return new SmList<>(this, ((UseCaseSmClass)getClassOf()).getUsedDep());
    }

    @objid ("5ede7f11-e077-4872-a164-358d08ab29e4")
    @Override
    public <T extends UseCaseDependency> List<T> getUsed(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UseCaseDependency element : getUsed()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("217cd94c-dfc8-48ea-ab38-2381db909ed6")
    @Override
    public EList<ExtensionPoint> getOwnedExtension() {
        return new SmList<>(this, ((UseCaseSmClass)getClassOf()).getOwnedExtensionDep());
    }

    @objid ("448659af-8ba5-4da1-baba-50c35cf4cd37")
    @Override
    public <T extends ExtensionPoint> List<T> getOwnedExtension(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ExtensionPoint element : getOwnedExtension()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("4ce9f7c4-743d-402f-b734-11a5b81e6dad")
    @Override
    public EList<UseCaseDependency> getUser() {
        return new SmList<>(this, ((UseCaseSmClass)getClassOf()).getUserDep());
    }

    @objid ("f98c6bdd-9559-46cd-8380-f085f31b4bf0")
    @Override
    public <T extends UseCaseDependency> List<T> getUser(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UseCaseDependency element : getUser()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6ad65f30-73cb-49eb-9368-861d248f4569")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("2e8f4291-7b64-4c83-9087-c0044bd9fc80")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c262b39c-0230-45a1-abcf-ca986efcbbe3")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitUseCase(this);
    }

}
