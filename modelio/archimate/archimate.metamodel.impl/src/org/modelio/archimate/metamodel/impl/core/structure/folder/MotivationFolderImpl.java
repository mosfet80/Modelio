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
import org.modelio.archimate.metamodel.core.structure.folder.MotivationFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("557c6c6b-a1e8-4b01-8c20-c0106bf6aead")
public class MotivationFolderImpl extends FolderImpl implements MotivationFolder {
    @objid ("13d6e57c-f236-4537-abcf-b5978d590fec")
    @Override
    public MotivationFolder getOwnerFolder() {
        Object obj = getDepVal(((MotivationFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof MotivationFolder)? (MotivationFolder)obj : null;
    }

    @objid ("c952d11b-0181-4238-8815-6d53d4d039d0")
    @Override
    public void setOwnerFolder(MotivationFolder value) {
        appendDepVal(((MotivationFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("0ae5543b-735e-4530-af8d-601c1fbe0d31")
    @Override
    public EList<MotivationFolder> getFolder() {
        return new SmList<>(this, ((MotivationFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("cffdf342-9288-496b-8e3e-604be04a6f25")
    @Override
    public <T extends MotivationFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final MotivationFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("13202758-f922-4d11-abb6-2054983bdec2")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((MotivationFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("1c5ae1f1-b84a-4abf-81d0-5d6585d7c02a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((MotivationFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("31a8e062-5ccb-4bd4-84f9-4d5717f6ab4d")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitMotivationFolder(this);
    }

}
