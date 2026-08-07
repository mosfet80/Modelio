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
import org.modelio.archimate.metamodel.core.structure.folder.ApplicationFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("a03262bd-5f99-4801-826c-14c4d55d1132")
public class ApplicationFolderImpl extends FolderImpl implements ApplicationFolder {
    @objid ("54a629a1-0211-4270-83be-5570bb4e241b")
    @Override
    public EList<ApplicationFolder> getFolder() {
        return new SmList<>(this, ((ApplicationFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("0f91cc1f-4a88-48c7-a4df-c854cd727676")
    @Override
    public <T extends ApplicationFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ApplicationFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("f2a29f0b-f2a0-4ac0-9e81-832f334db2c3")
    @Override
    public ApplicationFolder getOwnerFolder() {
        Object obj = getDepVal(((ApplicationFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof ApplicationFolder)? (ApplicationFolder)obj : null;
    }

    @objid ("e092b183-0c62-4c88-b845-c4100aa007ba")
    @Override
    public void setOwnerFolder(ApplicationFolder value) {
        appendDepVal(((ApplicationFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("721be7f5-3d64-4da1-bb6d-a8342caf3771")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((ApplicationFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("d34e6333-80df-42df-971a-becc0abec2a9")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((ApplicationFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("ee94a591-254b-4b9d-b9d7-e379190035b1")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitApplicationFolder(this);
    }

}
