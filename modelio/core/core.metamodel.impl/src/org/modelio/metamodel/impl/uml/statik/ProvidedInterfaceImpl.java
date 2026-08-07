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
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0019d6a6-c4bf-1fd8-97fe-001ec947cd2a")
public class ProvidedInterfaceImpl extends UmlModelElementImpl implements ProvidedInterface {
    @objid ("44af3e5f-2fd0-4f5f-9fed-ef41f92630a2")
    @Override
    public EList<Interface> getProvidedElement() {
        return new SmList<>(this, ((ProvidedInterfaceSmClass)getClassOf()).getProvidedElementDep());
    }

    @objid ("86824f9c-ae45-4921-abb6-9b3d5017d106")
    @Override
    public <T extends Interface> List<T> getProvidedElement(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Interface element : getProvidedElement()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5a1268cd-3f76-42bf-baf4-749822f07b78")
    @Override
    public Port getProviding() {
        Object obj = getDepVal(((ProvidedInterfaceSmClass)getClassOf()).getProvidingDep());
        return (obj instanceof Port)? (Port)obj : null;
    }

    @objid ("db419923-f611-4504-8253-aeee1d33fbb8")
    @Override
    public void setProviding(Port value) {
        appendDepVal(((ProvidedInterfaceSmClass)getClassOf()).getProvidingDep(), (SmObjectImpl)value);
    }

    @objid ("6636717b-475c-4322-8b71-2bede5fde781")
    @Override
    public EList<LinkEnd> getConsumer() {
        return new SmList<>(this, ((ProvidedInterfaceSmClass)getClassOf()).getConsumerDep());
    }

    @objid ("5db724b3-e8ff-4eb0-ad85-56010a2ccd15")
    @Override
    public <T extends LinkEnd> List<T> getConsumer(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getConsumer()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5275535c-78be-4bb3-84bc-d1f4777a8513")
    @Override
    public EList<NaryLinkEnd> getNaryConsumer() {
        return new SmList<>(this, ((ProvidedInterfaceSmClass)getClassOf()).getNaryConsumerDep());
    }

    @objid ("c5087f79-1557-4642-914b-85d430cffd9a")
    @Override
    public <T extends NaryLinkEnd> List<T> getNaryConsumer(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLinkEnd element : getNaryConsumer()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c88a219f-e429-45c6-8ab9-71b1b2a24900")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Providing
        obj = (SmObjectImpl)this.getDepVal(((ProvidedInterfaceSmClass)getClassOf()).getProvidingDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("b43928f8-5033-484b-9e0b-6f02b670a4f9")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Providing
        dep = ((ProvidedInterfaceSmClass)getClassOf()).getProvidingDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("d74238df-28a3-48de-879a-2c8175cab5ed")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitProvidedInterface(this);
    }

}
