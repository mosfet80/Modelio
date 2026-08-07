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
package org.modelio.archimate.metamodel.impl.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.archimate.metamodel.core.Concept;
import org.modelio.archimate.metamodel.core.Relationship;
import org.modelio.archimate.metamodel.core.structure.Folder;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("6a00e83a-1a99-4155-a092-9c892bbf30ff")
public class ConceptImpl extends ArchimateAbstractElementImpl implements Concept {
    @objid ("fca55337-cde4-4477-8aa5-ff300f686727")
    @Override
    public EList<Relationship> getRelatedFrom() {
        return new SmList<>(this, ((ConceptSmClass)getClassOf()).getRelatedFromDep());
    }

    @objid ("a4a051e3-a42a-4f2d-88a0-ef8ca6dc3396")
    @Override
    public <T extends Relationship> List<T> getRelatedFrom(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Relationship element : getRelatedFrom()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("68f81f69-976c-4ab5-9ed6-94af0f80f97d")
    @Override
    public EList<Relationship> getRelatedTo() {
        return new SmList<>(this, ((ConceptSmClass)getClassOf()).getRelatedToDep());
    }

    @objid ("8d5485c6-2568-4fc9-8acc-4ad24e5deb79")
    @Override
    public <T extends Relationship> List<T> getRelatedTo(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Relationship element : getRelatedTo()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("406868f7-bd71-4b49-af14-040e8a07aa49")
    @Override
    public Folder getOwnerFolder() {
        Object obj = getDepVal(((ConceptSmClass)getClassOf()).getOwnerFolderDep());
        return (obj instanceof Folder)? (Folder)obj : null;
    }

    @objid ("22783945-a6f7-4010-b68d-a15ceb49c12d")
    @Override
    public void setOwnerFolder(Folder value) {
        appendDepVal(((ConceptSmClass)getClassOf()).getOwnerFolderDep(), (SmObjectImpl)value);
    }

    @objid ("cb3eb2f3-cf6b-4c30-9f44-97ebd8f55b39")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // ownerFolder
        obj = (SmObjectImpl)this.getDepVal(((ConceptSmClass)getClassOf()).getOwnerFolderDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("0f8df886-e9cb-43ac-8db7-19ab0fa2599a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // ownerFolder
        dep = ((ConceptSmClass)getClassOf()).getOwnerFolderDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("dfb0f474-3050-400d-bc1f-36c521e18385")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitConcept(this);
    }

}
