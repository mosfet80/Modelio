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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("001b9b4e-c4bf-1fd8-97fe-001ec947cd2a")
public class RequiredInterfaceImpl extends UmlModelElementImpl implements RequiredInterface {
    @objid ("e152dd08-6072-41d4-bc99-13a5e8263b83")
    @Override
    public EList<Interface> getRequiredElement() {
        return new SmList<>(this, ((RequiredInterfaceSmClass)getClassOf()).getRequiredElementDep());
    }

    @objid ("b02774d2-25c2-4e98-876c-d3f2b0a5186d")
    @Override
    public <T extends Interface> List<T> getRequiredElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Interface element : getRequiredElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7cd4e32d-d367-4b9f-babb-06fb9a2ef9e0")
    @Override
    public EList<LinkEnd> getProvider() {
        return new SmList<>(this, ((RequiredInterfaceSmClass)getClassOf()).getProviderDep());
    }

    @objid ("90623c2a-0324-4bb1-a3fc-324a342275b9")
    @Override
    public <T extends LinkEnd> List<T> getProvider(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getProvider()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5e819cd5-3a05-4988-9ef8-a689f7694c85")
    @Override
    public Port getRequiring() {
        Object obj = getDepVal(((RequiredInterfaceSmClass)getClassOf()).getRequiringDep());
        return (obj instanceof Port)? (Port)obj : null;
    }

    @objid ("2d853ec2-6351-4509-9569-35d28258a9a7")
    @Override
    public void setRequiring(Port value) {
        appendDepVal(((RequiredInterfaceSmClass)getClassOf()).getRequiringDep(), (SmObjectImpl)value);
    }

    @objid ("c0d9911f-9128-4290-b860-35dd3b984d7b")
    @Override
    public EList<NaryLinkEnd> getNaryProvider() {
        return new SmList<>(this, ((RequiredInterfaceSmClass)getClassOf()).getNaryProviderDep());
    }

    @objid ("c0544fdb-a051-4e47-a8cd-3ab99a661a00")
    @Override
    public <T extends NaryLinkEnd> List<T> getNaryProvider(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLinkEnd element : getNaryProvider()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b5e3b994-1975-425b-af5a-6612873d5c3b")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Requiring
        obj = (SmObjectImpl)this.getDepVal(((RequiredInterfaceSmClass)getClassOf()).getRequiringDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("725dfd16-ab45-4e39-a5d2-734ffcfb016c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Requiring
        dep = ((RequiredInterfaceSmClass)getClassOf()).getRequiringDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b93da608-1d16-44cb-b370-1dfe4ce65f38")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitRequiredInterface(this);
    }

}
