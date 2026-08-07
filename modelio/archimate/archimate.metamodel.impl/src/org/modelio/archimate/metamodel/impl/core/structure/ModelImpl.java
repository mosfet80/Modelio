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
     Metamodel: Archimate, version 1.0.4, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Feb 9, 2023
*/
package org.modelio.archimate.metamodel.impl.core.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.ArchimateView;
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("077e81e9-ba86-40f1-b719-8d74cea946f2")
public class ModelImpl extends FolderImpl implements Model {
    @objid ("6dac834e-c02e-448d-a512-98f8ba00c907")
    @Override
    public Folder getOwnerFolder() {
        return null;
    }

    @objid ("34b06749-8d83-4522-b739-acfb78a000b5")
    @Override
    public ArchimateProject getProject() {
        Object obj = getDepVal(((ModelSmClass)getClassOf()).getProjectDep());
        return (obj instanceof ArchimateProject)? (ArchimateProject)obj : null;
    }

    @objid ("561ce34d-eb19-474b-87b6-c022dfd7bcaf")
    @Override
    public void setProject(ArchimateProject value) {
        appendDepVal(((ModelSmClass)getClassOf()).getProjectDep(), (SmObjectImpl)value);
    }

    @objid ("8a837ed6-636f-4203-a155-f5d826796803")
    @Override
    public EList<ViewPoint> getReferencedBy() {
        return new SmList<>(this, ((ModelSmClass)getClassOf()).getReferencedByDep());
    }

    @objid ("f4112736-2452-4757-ae36-f078bbcdedcc")
    @Override
    public <T extends ViewPoint> List<T> getReferencedBy(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ViewPoint element : getReferencedBy()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("784a3109-3700-4900-999a-790e15ab60f3")
    @Override
    public EList<ArchimateView> getReferencedByView() {
        return new SmList<>(this, ((ModelSmClass)getClassOf()).getReferencedByViewDep());
    }

    @objid ("2d98ffc2-1415-414c-a082-452eec33f734")
    @Override
    public <T extends ArchimateView> List<T> getReferencedByView(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ArchimateView element : getReferencedByView()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("da052411-3661-44e9-8ddf-7a7bd80e44aa")
    @Override
    public EList<Folder> getFolder() {
        return new SmList<>(this, ((ModelSmClass)getClassOf()).getFolderDep());
    }

    @objid ("1e5addb9-b87a-4b44-a8ee-8a8ce4ecdb28")
    @Override
    public <T extends Folder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Folder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("d756d0ee-a859-418e-a6d9-ce57b82aa776")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // project
        obj = (SmObjectImpl)this.getDepVal(((ModelSmClass)getClassOf()).getProjectDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("5c81c1ee-5cc7-4dfa-9c9e-3b9828b5298f")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // project
        dep = ((ModelSmClass)getClassOf()).getProjectDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("47e2ccb6-13e9-41f9-8744-a02fbc30f34b")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitModel(this);
    }

}
