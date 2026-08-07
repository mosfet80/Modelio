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
import org.modelio.archimate.metamodel.core.structure.folder.BusinessFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("2c5b6a6d-b09d-4f1c-91ae-1c11c306c248")
public class BusinessFolderImpl extends FolderImpl implements BusinessFolder {
    @objid ("793bc429-9ce9-498a-a464-1d265a03e414")
    @Override
    public BusinessFolder getOwnerFolder() {
        Object obj = getDepVal(((BusinessFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof BusinessFolder)? (BusinessFolder)obj : null;
    }

    @objid ("589183a6-5795-4b00-b992-e3f40785879d")
    @Override
    public void setOwnerFolder(BusinessFolder value) {
        appendDepVal(((BusinessFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("0601dda3-bb8b-482b-8d4c-e804f8944714")
    @Override
    public EList<BusinessFolder> getFolder() {
        return new SmList<>(this, ((BusinessFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("3ee0fc2d-98a2-40d8-99cc-10c8d41c8aa6")
    @Override
    public <T extends BusinessFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final BusinessFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("1cd250bc-5cca-46f5-868a-b8dd426e3234")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((BusinessFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("e8d543bb-58d5-44a0-9ac8-eeb35858f8eb")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((BusinessFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("1705f989-64e0-478d-9322-ac0104e30454")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitBusinessFolder(this);
    }

}
