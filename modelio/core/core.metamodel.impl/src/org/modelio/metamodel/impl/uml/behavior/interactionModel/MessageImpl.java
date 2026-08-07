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
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementImpl;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageKind;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.visitors.IModelVisitor;
import org.modelio.vcore.smkernel.SmConstrainedList;
import org.modelio.vcore.smkernel.SmDepVal;
import org.modelio.vcore.smkernel.SmList;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.meta.SmClass;
import org.modelio.vcore.smkernel.meta.SmDependency;

@objid ("00496c04-c4bf-1fd8-97fe-001ec947cd2a")
public class MessageImpl extends UmlModelElementImpl implements Message {
    @objid ("d86ff97c-c53a-40da-9e2b-1758570c70bb")
    @Override
    public String getArgument() {
        return (String) getAttVal(((MessageSmClass)getClassOf()).getArgumentAtt());
    }

    @objid ("df8b4423-18f5-40a2-8fe5-dae31172ce65")
    @Override
    public void setArgument(String value) {
        setAttVal(((MessageSmClass)getClassOf()).getArgumentAtt(), value);
    }

    @objid ("19ed74b4-fe38-4733-b2cd-793cd29f13f2")
    @Override
    public MessageKind getKindOfMessage() {
        return (MessageKind) getAttVal(((MessageSmClass)getClassOf()).getKindOfMessageAtt());
    }

    @objid ("741d9fd0-3a0a-47a6-a38a-3c308d3b643b")
    @Override
    public void setKindOfMessage(MessageKind value) {
        setAttVal(((MessageSmClass)getClassOf()).getKindOfMessageAtt(), value);
    }

    @objid ("00fac550-59d3-4ddd-89f2-24f7251f2f73")
    @Override
    public MessageSort getSortOfMessage() {
        return (MessageSort) getAttVal(((MessageSmClass)getClassOf()).getSortOfMessageAtt());
    }

    @objid ("d2654518-dfcc-4df1-96fe-a77c0a6249e1")
    @Override
    public void setSortOfMessage(MessageSort value) {
        setAttVal(((MessageSmClass)getClassOf()).getSortOfMessageAtt(), value);
    }

    @objid ("10ad417a-b4dc-4e0f-9758-d52d6ac9c8df")
    @Override
    public String getSequence() {
        return (String) getAttVal(((MessageSmClass)getClassOf()).getSequenceAtt());
    }

    @objid ("c909d2bd-e9a0-417e-af72-221c6d8d893e")
    @Override
    public void setSequence(String value) {
        setAttVal(((MessageSmClass)getClassOf()).getSequenceAtt(), value);
    }

    @objid ("f32985f9-3e89-4746-a0bc-51284d2a1fbd")
    @Override
    public Signal getSignalSignature() {
        Object obj = getDepVal(((MessageSmClass)getClassOf()).getSignalSignatureDep());
        return (obj instanceof Signal)? (Signal)obj : null;
    }

    @objid ("420e85b4-4c2c-443c-bff9-071e39a520c2")
    @Override
    public void setSignalSignature(Signal value) {
        appendDepVal(((MessageSmClass)getClassOf()).getSignalSignatureDep(), (SmObjectImpl)value);
    }

    @objid ("43559162-d946-4da5-95af-67e5ca2ce49d")
    @Override
    public MessageEnd getReceiveEvent() {
        Object obj = getDepVal(((MessageSmClass)getClassOf()).getReceiveEventDep());
        return (obj instanceof MessageEnd)? (MessageEnd)obj : null;
    }

    @objid ("049eb514-baa8-489a-a979-8ae7b24be3d9")
    @Override
    public void setReceiveEvent(MessageEnd value) {
        appendDepVal(((MessageSmClass)getClassOf()).getReceiveEventDep(), (SmObjectImpl)value);
    }

    @objid ("61b0e566-76db-4982-ba0d-d5694f2e08f0")
    @Override
    public MessageEnd getSendEvent() {
        Object obj = getDepVal(((MessageSmClass)getClassOf()).getSendEventDep());
        return (obj instanceof MessageEnd)? (MessageEnd)obj : null;
    }

    @objid ("6bcc235d-4294-4fd9-bec6-4d17093f28f3")
    @Override
    public void setSendEvent(MessageEnd value) {
        appendDepVal(((MessageSmClass)getClassOf()).getSendEventDep(), (SmObjectImpl)value);
    }

    @objid ("68f47d7c-64e5-4141-b5e1-556f48054faa")
    @Override
    public Operation getInvoked() {
        Object obj = getDepVal(((MessageSmClass)getClassOf()).getInvokedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("23e93b1c-b008-473a-b90f-ce1c82638cbf")
    @Override
    public void setInvoked(Operation value) {
        appendDepVal(((MessageSmClass)getClassOf()).getInvokedDep(), (SmObjectImpl)value);
    }

    @objid ("60bc75ac-33e1-4ebc-aea3-03b17cabd3da")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((MessageSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("37126875-dc75-4724-8880-370041a529ef")
    @Override
    public <T extends InformationFlow> List<T> getRealizedInformationFlow(java.lang.Class<T> filterClass) {
        if (filterClass == null) {
          throw new IllegalArgumentException();
        }
        final List<T> results = new ArrayList<>();
        for (final InformationFlow element : getRealizedInformationFlow()) {
        	if (filterClass.isInstance(element)) {
        		results.add(filterClass.cast(element));
        	}
        }
        return Collections.unmodifiableList(results);

    }

    @objid ("77df0631-7d02-49ec-8c86-a30e8824c282")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // SendEvent
        obj = (SmObjectImpl)this.getDepVal(((MessageSmClass)getClassOf()).getSendEventDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("a45006de-238f-4d26-af34-1e0073ea11b3")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // SendEvent
        dep = ((MessageSmClass)getClassOf()).getSendEventDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b1a744f3-281f-4eb2-94e0-c63e63cc4345")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitMessage(this);
    }

}
