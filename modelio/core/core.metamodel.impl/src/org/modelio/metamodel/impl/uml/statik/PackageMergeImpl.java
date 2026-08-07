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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageMerge;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00172b86-c4bf-1fd8-97fe-001ec947cd2a")
public class PackageMergeImpl extends UmlModelElementImpl implements PackageMerge {
    @objid ("0e021749-8ba1-4b63-9ade-a59bac0b072b")
    @Override
    public Package getMergedPackage() {
        Object obj = getDepVal(((PackageMergeSmClass)getClassOf()).getMergedPackageDep());
        return (obj instanceof Package)? (Package)obj : null;
    }

    @objid ("09bb9d6d-75e8-4cec-b3ea-ef863ad82a35")
    @Override
    public void setMergedPackage(Package value) {
        appendDepVal(((PackageMergeSmClass)getClassOf()).getMergedPackageDep(), (SmObjectImpl)value);
    }

    @objid ("8699de72-ed1f-44dc-b65b-87fc7c01b613")
    @Override
    public Package getReceivingPackage() {
        Object obj = getDepVal(((PackageMergeSmClass)getClassOf()).getReceivingPackageDep());
        return (obj instanceof Package)? (Package)obj : null;
    }

    @objid ("f304984e-c8c6-4fb5-bfca-6c09d4c81c9b")
    @Override
    public void setReceivingPackage(Package value) {
        appendDepVal(((PackageMergeSmClass)getClassOf()).getReceivingPackageDep(), (SmObjectImpl)value);
    }

    @objid ("c7af1bf8-0ed5-4c17-8d9f-8246e88d32e2")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ReceivingPackage
        obj = (SmObjectImpl)this.getDepVal(((PackageMergeSmClass)getClassOf()).getReceivingPackageDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("d88f3daa-8ada-4db4-b5a3-71dad6bb74bd")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ReceivingPackage
        dep = ((PackageMergeSmClass)getClassOf()).getReceivingPackageDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("80b958ce-6627-40cc-9401-25e52893303d")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPackageMerge(this);
    }

}
