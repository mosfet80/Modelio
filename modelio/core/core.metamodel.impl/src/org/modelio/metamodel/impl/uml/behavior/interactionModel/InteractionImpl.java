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
package org.modelio.metamodel.impl.uml.behavior.interactionModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorImpl;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("0046b70c-c4bf-1fd8-97fe-001ec947cd2a")
public class InteractionImpl extends BehaviorImpl implements Interaction {
    @objid ("38ff7e42-45a2-41ce-9795-55b479848209")
    @Override
    public EList<Gate> getFormalGate() {
        return new SmList<>(this, ((InteractionSmClass)getClassOf()).getFormalGateDep());
    }

    @objid ("0a309379-0446-47c8-ad4f-14b973b6b897")
    @Override
    public <T extends Gate> List<T> getFormalGate(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Gate element : getFormalGate()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("09efa66d-7dec-45a3-8d39-37fd69cf1579")
    @Override
    public EList<InteractionFragment> getFragment() {
        return new SmList<>(this, ((InteractionSmClass)getClassOf()).getFragmentDep());
    }

    @objid ("23e09d66-1349-47f7-9940-0f252f0aa458")
    @Override
    public <T extends InteractionFragment> List<T> getFragment(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InteractionFragment element : getFragment()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("27f5d847-09c9-480b-bd11-37c06d40e2b0")
    @Override
    public EList<Lifeline> getOwnedLine() {
        return new SmList<>(this, ((InteractionSmClass)getClassOf()).getOwnedLineDep());
    }

    @objid ("b4893c16-7b7a-4849-8d48-dec308348c3d")
    @Override
    public <T extends Lifeline> List<T> getOwnedLine(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Lifeline element : getOwnedLine()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7d3ff4a7-c472-4137-b2be-a841d77bcd6e")
    @Override
    public EList<InteractionUse> getReferedUse() {
        return new SmList<>(this, ((InteractionSmClass)getClassOf()).getReferedUseDep());
    }

    @objid ("9432d125-ab44-44b0-8a45-47e25406b7df")
    @Override
    public <T extends InteractionUse> List<T> getReferedUse(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InteractionUse element : getReferedUse()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6ff730d9-6af1-4a8f-976b-4b774065d31d")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        return super.getCompositionOwner();
    }

    @objid ("e4ec333e-b0d5-4133-afeb-ba2a436eed84")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        return super.getCompositionRelation();
    }

    @objid ("c140c80e-79e0-4533-b796-fd2853b5da1f")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInteraction(this);
    }

}
