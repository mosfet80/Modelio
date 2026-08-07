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
import org.modelio.archimate.metamodel.core.structure.folder.TechnologyFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("1cae193f-239b-445d-b722-fa3dc0f38578")
public class TechnologyFolderImpl extends FolderImpl implements TechnologyFolder {
    @objid ("2af93757-4bfb-446d-af7c-d27874d2bf11")
    @Override
    public TechnologyFolder getOwnerFolder() {
        Object obj = getDepVal(((TechnologyFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof TechnologyFolder)? (TechnologyFolder)obj : null;
    }

    @objid ("c5f0434e-9171-456a-8e8d-e4341caba590")
    @Override
    public void setOwnerFolder(TechnologyFolder value) {
        appendDepVal(((TechnologyFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("0aa1445b-7899-42d0-97f7-411a4ac00678")
    @Override
    public EList<TechnologyFolder> getFolder() {
        return new SmList<>(this, ((TechnologyFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("6b398303-9d33-4f09-93bd-f1b53171cf5c")
    @Override
    public <T extends TechnologyFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final TechnologyFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("2809160b-9f10-4427-b68e-e52b8879467a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((TechnologyFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("fc6fc7e4-131a-4372-9f7d-91951a0f8801")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((TechnologyFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5021d569-3283-45dc-aa92-459eb05698dc")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitTechnologyFolder(this);
    }

}
