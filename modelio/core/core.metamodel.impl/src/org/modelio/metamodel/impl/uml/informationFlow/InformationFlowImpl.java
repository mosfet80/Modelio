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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.emf.common.util.EList;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.StructuralFeature;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("006399b2-c4bf-1fd8-97fe-001ec947cd2a")
public class InformationFlowImpl extends UmlModelElementImpl implements InformationFlow {
    @objid ("004ce57b-a392-4cb8-975d-c5c8a1ca01bb")
    @Override
    public NameSpace getOwner() {
        Object obj = getDepVal(((InformationFlowSmClass)getClassOf()).getOwnerDep());
        return (obj instanceof NameSpace)? (NameSpace)obj : null;
    }

    @objid ("7c079575-6fa2-4417-a1d5-a9e8623f2bf5")
    @Override
    public void setOwner(NameSpace value) {
        appendDepVal(((InformationFlowSmClass)getClassOf()).getOwnerDep(), (SmObjectImpl)value);
    }

    @objid ("2724de09-ba0b-4a03-83e9-61269dfd49a7")
    @Override
    public EList<UmlModelElement> getInformationSource() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getInformationSourceDep());
    }

    @objid ("e32b5f86-2fea-40a1-9882-fbe8d07a003b")
    @Override
    public <T extends UmlModelElement> List<T> getInformationSource(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UmlModelElement element : getInformationSource()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("b4250fb2-22e7-4b01-a6a0-5060df6c880a")
    @Override
    public EList<UmlModelElement> getInformationTarget() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getInformationTargetDep());
    }

    @objid ("a73a785f-4798-4c5f-a03a-0fe428150293")
    @Override
    public <T extends UmlModelElement> List<T> getInformationTarget(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final UmlModelElement element : getInformationTarget()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("921f083e-d603-4359-8195-76c7d73728de")
    @Override
    public EList<ActivityEdge> getRealizingActivityEdge() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingActivityEdgeDep());
    }

    @objid ("45fc905b-11e9-4bd1-80df-65d2525394f0")
    @Override
    public <T extends ActivityEdge> List<T> getRealizingActivityEdge(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final ActivityEdge element : getRealizingActivityEdge()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("456a22b3-b524-40f3-a19b-1f1787b1e459")
    @Override
    public EList<CommunicationMessage> getRealizingCommunicationMessage() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingCommunicationMessageDep());
    }

    @objid ("148d5298-95f0-4c81-bab8-426566689362")
    @Override
    public <T extends CommunicationMessage> List<T> getRealizingCommunicationMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final CommunicationMessage element : getRealizingCommunicationMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("5932ca2f-20ac-40d5-a031-2387320518be")
    @Override
    public EList<StructuralFeature> getRealizingFeature() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingFeatureDep());
    }

    @objid ("ceac402c-97bd-46cd-a72d-daef0ef761f1")
    @Override
    public <T extends StructuralFeature> List<T> getRealizingFeature(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final StructuralFeature element : getRealizingFeature()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7535b58e-b714-42ec-aed7-ea8685df79cf")
    @Override
    public EList<LinkEnd> getRealizingLink() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingLinkDep());
    }

    @objid ("e456fc1c-a533-4cc8-8a46-d9c0ada39b0b")
    @Override
    public <T extends LinkEnd> List<T> getRealizingLink(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final LinkEnd element : getRealizingLink()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("6490f418-c7eb-4ff9-8f6b-187ac435f9e8")
    @Override
    public EList<Message> getRealizingMessage() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingMessageDep());
    }

    @objid ("f3c3c407-6be5-4ac9-870b-3af62ed262d9")
    @Override
    public <T extends Message> List<T> getRealizingMessage(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Message element : getRealizingMessage()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("c509664d-a14f-44e1-8298-158bd3c511f2")
    @Override
    public EList<NaryLink> getRealizingNaryLink() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getRealizingNaryLinkDep());
    }

    @objid ("4c8580db-1feb-48bd-bb57-f8f925e969cc")
    @Override
    public <T extends NaryLink> List<T> getRealizingNaryLink(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final NaryLink element : getRealizingNaryLink()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("7015c673-fdd0-4a48-8939-ff670f3036d8")
    @Override
    public EList<Classifier> getConveyed() {
        return new SmList<>(this, ((InformationFlowSmClass)getClassOf()).getConveyedDep());
    }

    @objid ("644b3108-0ee4-4cfb-95e4-2a70d840ea97")
    @Override
    public <T extends Classifier> List<T> getConveyed(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final Classifier element : getConveyed()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("59d1aae6-e03b-47c2-88af-aa0791d07e52")
    @Override
    public AssociationEnd getChannel() {
        Object obj = getDepVal(((InformationFlowSmClass)getClassOf()).getChannelDep());
        return (obj instanceof AssociationEnd)? (AssociationEnd)obj : null;
    }

    @objid ("f18a4c2c-be22-4b3c-a340-531291173eb5")
    @Override
    public void setChannel(AssociationEnd value) {
        appendDepVal(((InformationFlowSmClass)getClassOf()).getChannelDep(), (SmObjectImpl)value);
    }

    @objid ("3437af32-2b08-4555-bb40-06445fa9c5c4")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Owner
        obj = (SmObjectImpl)this.getDepVal(((InformationFlowSmClass)getClassOf()).getOwnerDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("089076c3-d12a-4430-ada9-e6393b3e95ef")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Owner
        dep = ((InformationFlowSmClass)getClassOf()).getOwnerDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("15328b68-8614-478d-baec-2105467f65a2")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitInformationFlow(this);
    }

}
