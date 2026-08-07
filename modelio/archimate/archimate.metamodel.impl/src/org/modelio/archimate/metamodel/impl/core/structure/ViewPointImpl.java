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
import org.modelio.archimate.metamodel.core.structure.ArchimateProject;
import org.modelio.archimate.metamodel.core.structure.Model;
import org.modelio.archimate.metamodel.core.structure.ViewPoint;
import org.modelio.archimate.metamodel.impl.core.ArchimateAbstractElementImpl;
import org.modelio.archimate.metamodel.visitors.IArchimateVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("dc72f932-bf70-4b95-b309-b04269e568b8")
public class ViewPointImpl extends ArchimateAbstractElementImpl implements ViewPoint {
    @objid ("279c6469-c98f-4d04-b336-d8ccb197d7c6")
    @Override
    public EList<ViewPoint> getChild() {
        return new SmList<>(this, ((ViewPointSmClass)getClassOf()).getChildDep());
    }

    @objid ("264d8c45-e726-4d44-81d0-8d1611324202")
    @Override
    public <T extends ViewPoint> List<T> getChild(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ViewPoint element : getChild()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("9f8e7877-7f6c-492e-84e0-9a3453b941c8")
    @Override
    public ArchimateProject getProject() {
        Object obj = getDepVal(((ViewPointSmClass)getClassOf()).getProjectDep());
        return (obj instanceof ArchimateProject)? (ArchimateProject)obj : null;
    }

    @objid ("870c29b9-7387-47cd-8719-e0b67991319c")
    @Override
    public void setProject(ArchimateProject value) {
        appendDepVal(((ViewPointSmClass)getClassOf()).getProjectDep(), (SmObjectImpl)value);
    }

    @objid ("3c08754a-6bf3-4da4-828b-64589fb34f4b")
    @Override
    public ViewPoint getParent() {
        Object obj = getDepVal(((ViewPointSmClass)getClassOf()).getParentDep());
        return (obj instanceof ViewPoint)? (ViewPoint)obj : null;
    }

    @objid ("c1e3ff39-cbd9-4699-8e16-8ef809552fd3")
    @Override
    public void setParent(ViewPoint value) {
        appendDepVal(((ViewPointSmClass)getClassOf()).getParentDep(), (SmObjectImpl)value);
    }

    @objid ("c27f2c89-2585-482f-9a86-02ed7860b196")
    @Override
    public Model getContext() {
        Object obj = getDepVal(((ViewPointSmClass)getClassOf()).getContextDep());
        return (obj instanceof Model)? (Model)obj : null;
    }

    @objid ("4142ca9e-bbcd-48ef-aa1a-f981e22e8deb")
    @Override
    public void setContext(Model value) {
        appendDepVal(((ViewPointSmClass)getClassOf()).getContextDep(), (SmObjectImpl)value);
    }

    @objid ("5d5ade90-b5a4-49b3-a2df-99aa973ea583")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // project
        obj = (SmObjectImpl)this.getDepVal(((ViewPointSmClass)getClassOf()).getProjectDep());
        if (obj != null)
          return obj;
        // parent
        obj = (SmObjectImpl)this.getDepVal(((ViewPointSmClass)getClassOf()).getParentDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("17f998d1-c179-4781-8421-0768cea11f45")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // project
        dep = ((ViewPointSmClass)getClassOf()).getProjectDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // parent
        dep = ((ViewPointSmClass)getClassOf()).getParentDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("d0cde311-cfb0-47a4-b75e-bfacc399d220")
    @Override
    public Object accept(IArchimateVisitor v) {
        return v.visitViewPoint(this);
    }

}
