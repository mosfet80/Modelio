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
import org.modelio.metamodel.uml.statik.Port;
import org.modelio.metamodel.uml.statik.PortOrientation;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0018eeee-c4bf-1fd8-97fe-001ec947cd2a")
public class PortImpl extends BindableInstanceImpl implements Port {
    @objid ("cc821559-ea17-46aa-a7df-2bce3344a24b")
    @Override
    public boolean isIsBehavior() {
        return (Boolean) getAttVal(((PortSmClass)getClassOf()).getIsBehaviorAtt());
    }

    @objid ("ee45d698-9407-4493-aac5-a870464982d3")
    @Override
    public void setIsBehavior(boolean value) {
        setAttVal(((PortSmClass)getClassOf()).getIsBehaviorAtt(), value);
    }

    @objid ("04fbbef2-6d1d-4392-a113-00322a89669b")
    @Override
    public boolean isIsService() {
        return (Boolean) getAttVal(((PortSmClass)getClassOf()).getIsServiceAtt());
    }

    @objid ("044445ff-439e-4432-9d62-6475a334addc")
    @Override
    public void setIsService(boolean value) {
        setAttVal(((PortSmClass)getClassOf()).getIsServiceAtt(), value);
    }

    @objid ("39e29ccf-6f96-4dea-986f-20d692b96025")
    @Override
    public boolean isIsConjugated() {
        return (Boolean) getAttVal(((PortSmClass)getClassOf()).getIsConjugatedAtt());
    }

    @objid ("5fd5851c-80ce-487f-9ac2-b42e0796edfe")
    @Override
    public void setIsConjugated(boolean value) {
        setAttVal(((PortSmClass)getClassOf()).getIsConjugatedAtt(), value);
    }

    @objid ("ac337864-894b-4238-9879-c43f5828883b")
    @Override
    public PortOrientation getDirection() {
        return (PortOrientation) getAttVal(((PortSmClass)getClassOf()).getDirectionAtt());
    }

    @objid ("3f6e1cdb-f29c-4cc3-b3f9-55e3cd521ad8")
    @Override
    public void setDirection(PortOrientation value) {
        setAttVal(((PortSmClass)getClassOf()).getDirectionAtt(), value);
    }

    @objid ("5dc0a2cb-f228-4cff-bcdb-3d1a95b45945")
    @Override
    public EList<ProvidedInterface> getProvided() {
        return new SmList<>(this, ((PortSmClass)getClassOf()).getProvidedDep());
    }

    @objid ("e6005362-77fd-4306-877c-5f3b36746404")
    @Override
    public <T extends ProvidedInterface> List<T> getProvided(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ProvidedInterface element : getProvided()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("cf9fe88a-9678-4558-95d4-4579a9636753")
    @Override
    public EList<RequiredInterface> getRequired() {
        return new SmList<>(this, ((PortSmClass)getClassOf()).getRequiredDep());
    }

    @objid ("2019ed4d-a999-4708-b3f6-845a96626d15")
    @Override
    public <T extends RequiredInterface> List<T> getRequired(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final RequiredInterface element : getRequired()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("03ae95e0-fec3-4757-974f-70ce3e0c296c")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("58895b4b-df46-41e1-a12b-bbf70a73e93c")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("83bd60a6-3071-446e-a039-2e238b7a3552")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitPort(this);
    }

}
