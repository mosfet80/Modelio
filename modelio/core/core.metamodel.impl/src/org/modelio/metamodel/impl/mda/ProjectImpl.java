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
     Metamodel: Standard, version 2.3.00, by Modeliosoft
     Generator version: 3.14.00
     Generated on: Aug 7, 2024
*/
package org.modelio.metamodel.impl.mda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.AbstractProjectImpl;
import org.modelio.metamodel.mda.Project;
import org.modelio.metamodel.uml.statik.Package;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MVisitor;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("006633d4-c4bf-1fd8-97fe-001ec947cd2a")
public class ProjectImpl extends AbstractProjectImpl implements Project {
    @objid ("a9e80f8e-a6f5-496a-8630-2ce8a268d246")
    @Override
    public String getProjectContext() {
        return (String) getAttVal(((ProjectSmClass)getClassOf()).getProjectContextAtt());
    }

    @objid ("aba3586d-5c49-4bbe-b01e-24ab43289dd0")
    @Override
    public void setProjectContext(String value) {
        setAttVal(((ProjectSmClass)getClassOf()).getProjectContextAtt(), value);
    }

    @objid ("ff046642-f57b-48f9-a7fc-4f85f9490ce4")
    @Override
    public String getProjectDescr() {
        return (String) getAttVal(((ProjectSmClass)getClassOf()).getProjectDescrAtt());
    }

    @objid ("4a043f67-9a2a-49d5-924d-6a730a6bab74")
    @Override
    public void setProjectDescr(String value) {
        setAttVal(((ProjectSmClass)getClassOf()).getProjectDescrAtt(), value);
    }

    @objid ("08af00f8-deb0-4c6a-8ced-d578fbf8f292")
    @Override
    public EList<Package> getModel() {
        return new SmList<>(this, ((ProjectSmClass)getClassOf()).getModelDep());
    }

    @objid ("065f4b38-56ea-442a-98aa-06f4fc5c7067")
    @Override
    public <T extends Package> List<T> getModel(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Package element : getModel()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("e0936828-5632-4eab-8d19-4a0ade36f305")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("757dece7-c08c-40c7-9a9c-a15de936b229")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("17d012fd-e213-445d-a04e-ab65b7811be1")
    @Override
    public Object accept(MVisitor v) {
        if (v instanceof IModelVisitor)
          return accept((IModelVisitor)v);
        else
          return super.accept(v);
    }

    @objid ("b40bba4d-9721-4fa1-b733-f33e63bc4a36")
    public Object accept(IModelVisitor v) {
        return v.visitProject(this);
    }

}
