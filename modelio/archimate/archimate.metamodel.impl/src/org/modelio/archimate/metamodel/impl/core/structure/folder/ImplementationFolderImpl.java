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
package org.modelio.archimate.metamodel.impl.core.structure.folder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.structure.folder.ImplementationFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("a4eeff39-ff6c-46f6-bc9b-e988a6214e96")
public class ImplementationFolderImpl extends FolderImpl implements ImplementationFolder {
    @objid ("c9c56d31-f5ef-444c-876a-db9a8354afe2")
    @Override
    public EList<ImplementationFolder> getFolder() {
        return new SmList<>(this, ((ImplementationFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("3668ce9e-5564-4208-a2ae-eb3c2bc219a4")
    @Override
    public <T extends ImplementationFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ImplementationFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ae209096-74c4-43d9-bd25-6f53815e9854")
    @Override
    public ImplementationFolder getOwnerFolder() {
        Object obj = getDepVal(((ImplementationFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof ImplementationFolder)? (ImplementationFolder)obj : null;
    }

    @objid ("6a34b96f-603c-469a-849a-0609e9fc02f1")
    @Override
    public void setOwnerFolder(ImplementationFolder value) {
        appendDepVal(((ImplementationFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("4e10d0ef-f47f-4362-95ac-cd4327b33cd2")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((ImplementationFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("ef6cbff9-af69-4eb5-98f3-35d79e17b311")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((ImplementationFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("09546b1b-591e-4f95-bbbd-ec26eafaa38b")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitImplementationFolder(this);
    }

}
