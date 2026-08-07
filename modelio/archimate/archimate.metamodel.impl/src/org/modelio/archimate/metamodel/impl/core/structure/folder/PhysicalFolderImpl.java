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
import org.modelio.archimate.metamodel.core.structure.folder.PhysicalFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("86ce2480-990c-4590-ae4a-ad55ce63f765")
public class PhysicalFolderImpl extends FolderImpl implements PhysicalFolder {
    @objid ("e41d9786-e5a5-45aa-bfe2-07a37a6ce870")
    @Override
    public EList<PhysicalFolder> getFolder() {
        return new SmList<>(this, ((PhysicalFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("dfb92058-5a3f-4797-809a-6bf12400c589")
    @Override
    public <T extends PhysicalFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final PhysicalFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("93df7c49-4d73-4ed7-a566-a74a99c21545")
    @Override
    public PhysicalFolder getOwnerFolder() {
        Object obj = getDepVal(((PhysicalFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof PhysicalFolder)? (PhysicalFolder)obj : null;
    }

    @objid ("66f908bb-1c23-4356-9096-f51e80e2af63")
    @Override
    public void setOwnerFolder(PhysicalFolder value) {
        appendDepVal(((PhysicalFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("d20450a0-d7ad-4ba3-a94c-c4ece94acad8")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((PhysicalFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("e50c4bae-a087-4291-ac57-fa8d0a561da4")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((PhysicalFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("060503c2-008b-4827-997d-4c41ca0e7c82")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitPhysicalFolder(this);
    }

}
