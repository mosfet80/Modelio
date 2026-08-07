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
import org.modelio.archimate.metamodel.core.structure.folder.StrategyFolder;
import org.modelio.archimate.metamodel.impl.core.structure.FolderImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("bd41c573-720e-48fb-af47-046d931835d2")
public class StrategyFolderImpl extends FolderImpl implements StrategyFolder {
    @objid ("ab6285f3-a0f3-45bc-9faa-81978e48a91b")
    @Override
    public StrategyFolder getOwnerFolder() {
        Object obj = getDepVal(((StrategyFolderSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof StrategyFolder)? (StrategyFolder)obj : null;
    }

    @objid ("caa8c73b-ac6a-4a1c-ad1f-5e04a03919f0")
    @Override
    public void setOwnerFolder(StrategyFolder value) {
        appendDepVal(((StrategyFolderSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("20abe382-426f-4662-ac57-f1552878d272")
    @Override
    public EList<StrategyFolder> getFolder() {
        return new SmList<>(this, ((StrategyFolderSmClass)getClassOf()).getFolderDep());
    }

    @objid ("585a3254-a695-4779-81ec-5ed065abcac5")
    @Override
    public <T extends StrategyFolder> List<T> getFolder(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final StrategyFolder element : getFolder()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("81f5e26a-2a02-4720-8121-a849e8dc450a")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((StrategyFolderSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("4481f965-bc5f-4731-b56e-4c3c2bd2b91b")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((StrategyFolderSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("5d38723c-9b1c-4b3d-ae64-c4ff779b9d2c")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitStrategyFolder(this);
    }

}
