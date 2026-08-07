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
package org.modelio.metamodel.impl.uml.behavior.communicationModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationInteraction;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("005ab766-c4bf-1fd8-97fe-001ec947cd2a")
public class CommunicationNodeImpl extends UmlModelElementImpl implements CommunicationNode {
    @objid ("bd81e6a3-a8f1-49a7-9dd7-0a74ad8fc12b")
    @Override
    public String getSelector() {
        return (String) getAttVal(((CommunicationNodeSmClass)getClassOf()).getSelectorAtt());
    }

    @objid ("b9ff3c7d-b8e2-4f2a-b9cc-128fa55b6c39")
    @Override
    public void setSelector(String value) {
        setAttVal(((CommunicationNodeSmClass)getClassOf()).getSelectorAtt(), value);
    }

    @objid ("163439b4-19f2-414f-87df-3d941a330f8d")
    @Override
    public CommunicationInteraction getOwner() {
        Object obj = getDepVal(((CommunicationNodeSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof CommunicationInteraction)? (CommunicationInteraction)obj : null;
    }

    @objid ("9bf16ebb-88fc-4b5f-a995-c7edd8a75991")
    @Override
    public void setOwner(CommunicationInteraction value) {
        appendDepVal(((CommunicationNodeSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("32396d1b-751f-4ddf-8dc2-d37eab7e16a5")
    @Override
    public Instance getRepresented() {
        Object obj = getDepVal(((CommunicationNodeSmClass)getClassOf()).getRepresentedDep());
        return (obj instanceof Instance)? (Instance)obj : null;
    }

    @objid ("2b15a97d-5fc8-4dc5-aec4-01952c217db7")
    @Override
    public void setRepresented(Instance value) {
        appendDepVal(((CommunicationNodeSmClass)getClassOf()).getRepresentedDep(), (SmObjectImpl)value);
    }

    @objid ("836b0d1b-801f-473f-a04d-4c482223ec62")
    @Override
    public EList<CommunicationChannel> getStarted() {
        return new SmList<>(this, ((CommunicationNodeSmClass)getClassOf()).getStartedDep());
    }

    @objid ("be314801-0f80-4bb2-875f-8319807a7b94")
    @Override
    public <T extends CommunicationChannel> List<T> getStarted(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationChannel element : getStarted()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("ee631aff-91bb-44d6-8d54-57f141e1fd9b")
    @Override
    public EList<CommunicationChannel> getEnded() {
        return new SmList<>(this, ((CommunicationNodeSmClass)getClassOf()).getEndedDep());
    }

    @objid ("ba72a24f-bd19-4a0d-ae7b-24442cf95915")
    @Override
    public <T extends CommunicationChannel> List<T> getEnded(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationChannel element : getEnded()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c6cb776b-1cb7-4948-aadc-d0a99c56fc51")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((CommunicationNodeSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("3f4a51eb-3b03-47fe-b7d7-2eaeaa86747a")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((CommunicationNodeSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("3abcb14e-3310-4dc4-96c3-4324a97b9b9e")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCommunicationNode(this);
    }

}
