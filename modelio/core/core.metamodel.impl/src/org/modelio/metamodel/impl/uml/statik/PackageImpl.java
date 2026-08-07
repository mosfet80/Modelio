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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.uml.statik.PackageImport;
import org.modelio.metamodel.uml.statik.PackageMerge;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00157246-c4bf-1fd8-97fe-001ec947cd2a")
public class PackageImpl extends NameSpaceImpl implements Package {
    @objid ("5ca5f3fe-5f11-42f7-a448-6d862ab28268")
    @Override
    public boolean isIsInstantiable() {
        return (Boolean) getAttVal(((PackageSmClass)getClassOf()).getIsInstantiableAtt());
    }

    @objid ("57b62b95-9f6b-42e8-8961-09784a8450d6")
    @Override
    public void setIsInstantiable(boolean value) {
        setAttVal(((PackageSmClass)getClassOf()).getIsInstantiableAtt(), value);
    }

    @objid ("add13a13-e95d-4aaa-adc5-5f75aabb8ff1")
    @Override
    public EList<PackageMerge> getReceivingMerge() {
        return new SmList<>(this, ((PackageSmClass)getClassOf()).getReceivingMergeDep());
    }

    @objid ("779dc611-bb40-4272-85c0-88f5cefd505f")
    @Override
    public <T extends PackageMerge> List<T> getReceivingMerge(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final PackageMerge element : getReceivingMerge()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1ab75a12-b3ab-4586-8294-77e4fb687784")
    @Override
    public Project getRepresented() {
        Object obj = getDepVal(((PackageSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof Project)? (Project)obj : null;
    }

    @objid ("e1b1e7fe-f993-4191-93de-2a31f2c659d2")
    @Override
    public void setRepresented(Project value) {
        appendDepVal(((PackageSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("f5763a44-3cd1-4ae3-a026-840f1dc08758")
    @Override
    public EList<PackageMerge> getMerge() {
        return new SmList<>(this, ((PackageSmClass)getClassOf()).getMergeDep());
    }

    @objid ("5241e738-e7cb-4c31-afa9-709565a3146b")
    @Override
    public <T extends PackageMerge> List<T> getMerge(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final PackageMerge element : getMerge()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5552e654-63fb-43e5-97ce-b669a2fb4ef9")
    @Override
    public EList<PackageImport> getPackageImporting() {
        return new SmList<>(this, ((PackageSmClass)getClassOf()).getPackageImportingDep());
    }

    @objid ("2cfdf1eb-9f3f-473e-b531-72530ea9d196")
    @Override
    public <T extends PackageImport> List<T> getPackageImporting(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final PackageImport element : getPackageImporting()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6497f604-f9fe-4380-b260-b0f73c29e20b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Represented
        obj = (SmObjectImpl)this.getDepVal(((PackageSmClass)getClassOf()).getRepresentedDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("2971616f-a199-424d-86c5-f336d832893e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Represented
        dep = ((PackageSmClass)getClassOf()).getRepresentedDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("a36be404-b90b-409b-8bfa-1ba5e9ad2403")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPackage(this);
    }

}
