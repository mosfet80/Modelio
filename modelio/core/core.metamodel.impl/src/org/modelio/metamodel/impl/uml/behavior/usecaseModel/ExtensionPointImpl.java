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
import org.modelio.metamodel.uml.statik.VisibilityMode;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0059a6a0-c4bf-1fd8-97fe-001ec947cd2a")
public class ExtensionPointImpl extends UmlModelElementImpl implements ExtensionPoint {
    @objid ("9a20cad1-7ea7-400f-bf95-85e695c98450")
    @Override
    public VisibilityMode getVisibility() {
        return (VisibilityMode) getAttVal(((ExtensionPointSmClass)getClassOf()).getVisibilityAtt());
    }

    @objid ("55cbbe11-4539-47e6-aa23-ca61bb50933f")
    @Override
    public void setVisibility(VisibilityMode value) {
        setAttVal(((ExtensionPointSmClass)getClassOf()).getVisibilityAtt(), value);
    }

    @objid ("71950ea7-375d-43fd-b62a-27eaebbb59e9")
    @Override
    public EList<UseCaseDependency> getExtended() {
        return new SmList<>(this, ((ExtensionPointSmClass)getClassOf()).getExtendedDep());
    }

    @objid ("4cee6b4f-206b-405d-99ba-ace6588e111d")
    @Override
    public <T extends UseCaseDependency> List<T> getExtended(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UseCaseDependency element : getExtended()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2a96b69b-528c-480e-8cc7-11c09b9adacd")
    @Override
    public UseCase getOwner() {
        Object obj = getDepVal(((ExtensionPointSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof UseCase)? (UseCase)obj : null;
    }

    @objid ("eb25de07-6d9f-41df-9d22-558bf70d7340")
    @Override
    public void setOwner(UseCase value) {
        appendDepVal(((ExtensionPointSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("9759825a-b86f-40ba-987d-c7d056090688")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((ExtensionPointSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("54c61768-3287-4bee-8c57-5012f05182e6")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((ExtensionPointSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("0e6b57a2-95a9-43df-8be3-807721a49926")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitExtensionPoint(this);
    }

}
