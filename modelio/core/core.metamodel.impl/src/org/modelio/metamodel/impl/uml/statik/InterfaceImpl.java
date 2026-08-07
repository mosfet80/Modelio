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
import org.modelio.metamodel.uml.statik.Interface;
import org.modelio.metamodel.uml.statik.InterfaceRealization;
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

@objid ("000e545c-c4bf-1fd8-97fe-001ec947cd2a")
public class InterfaceImpl extends GeneralClassImpl implements Interface {
    @objid ("dcabf597-e067-4e56-b300-93497517257b")
    @Override
    public EList<RequiredInterface> getRequiring() {
        return new SmList<>(this, ((InterfaceSmClass)getClassOf()).getRequiringDep());
    }

    @objid ("c88d9d7f-91ee-4867-b3b6-233735cdbcb8")
    @Override
    public <T extends RequiredInterface> List<T> getRequiring(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final RequiredInterface element : getRequiring()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c966f915-4c8c-422e-affd-c059d588fba7")
    @Override
    public EList<InterfaceRealization> getImplementedLink() {
        return new SmList<>(this, ((InterfaceSmClass)getClassOf()).getImplementedLinkDep());
    }

    @objid ("322e2b2a-df0a-4257-8065-e7cf8993fc7c")
    @Override
    public <T extends InterfaceRealization> List<T> getImplementedLink(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InterfaceRealization element : getImplementedLink()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b2f50e71-6a1c-475d-bab6-6ba790bd1071")
    @Override
    public EList<ProvidedInterface> getProviding() {
        return new SmList<>(this, ((InterfaceSmClass)getClassOf()).getProvidingDep());
    }

    @objid ("5f07824c-04ce-448d-8a26-615f54c2ead8")
    @Override
    public <T extends ProvidedInterface> List<T> getProviding(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ProvidedInterface element : getProviding()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("a79e7537-96c1-484d-a9ed-a6925aa87bc6")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("abe1a326-9872-4001-9331-0bbd4e389788")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("88062aa2-9762-43b8-9755-6b532a2427c7")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInterface(this);
    }

}
