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
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("47acb8f1-ba62-4b2b-b7c7-051e8bbe2b1b")
public abstract class FolderImpl extends ArchimateAbstractElementImpl implements Folder {
    @objid ("f4ed833b-468a-48c7-8b1e-2747a4272409")
    @Override
    public EList<Concept> getContent() {
        return new SmList<>(this, ((FolderSmClass)getClassOf()).getContentDep());
    }

    @objid ("c5bf1a78-0313-4eb1-85ab-12450bd18665")
    @Override
    public <T extends Concept> List<T> getContent(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Concept element : getContent()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e992b38f-4f9a-465d-bd0f-14ae91c3069e")
    @Override
    public Model getOwner() {
        Object obj = getDepVal(((FolderSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof Model)? (Model)obj : null;
    }

    @objid ("6c431058-400d-4227-aa60-4be708336aa5")
    @Override
    public void setOwner(Model value) {
        appendDepVal(((FolderSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("966ea469-8992-417f-9f1f-1f7b1549cd2b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // owner
        obj = (SmObjectImpl)this.getDepVal(((FolderSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("17a806b2-aefa-4eb7-825e-9af16571e03e")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // owner
        dep = ((FolderSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b5bc0169-9e48-4d00-a256-dbcf04f1eea1")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitFolder(this);
    }

}
