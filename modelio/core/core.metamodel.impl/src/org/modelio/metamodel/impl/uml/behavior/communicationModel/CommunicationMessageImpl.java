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
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
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

@objid ("005b2ef8-c4bf-1fd8-97fe-001ec947cd2a")
public class CommunicationMessageImpl extends UmlModelElementImpl implements CommunicationMessage {
    @objid ("9b4475a7-84fb-4c4e-81a0-bba545486986")
    @Override
    public String getArgument() {
        return (String) getAttVal(((CommunicationMessageSmClass)getClassOf()).getArgumentAtt());
    }

    @objid ("10ee4aea-74a1-44c8-bff8-ea745412af03")
    @Override
    public void setArgument(String value) {
        setAttVal(((CommunicationMessageSmClass)getClassOf()).getArgumentAtt(), value);
    }

    @objid ("c5386ec2-494c-46be-8d2a-b9abc916bd14")
    @Override
    public String getSequence() {
        return (String) getAttVal(((CommunicationMessageSmClass)getClassOf()).getSequenceAtt());
    }

    @objid ("b9ba524a-5d2b-415d-b3d5-6b9ffb2db0df")
    @Override
    public void setSequence(String value) {
        setAttVal(((CommunicationMessageSmClass)getClassOf()).getSequenceAtt(), value);
    }

    @objid ("dd21b932-2999-41ab-a1dd-67bb449a9adc")
    @Override
    public MessageSort getSortOfMessage() {
        return (MessageSort) getAttVal(((CommunicationMessageSmClass)getClassOf()).getSortOfMessageAtt());
    }

    @objid ("c77f211a-1916-4e79-a5d7-20871230b62a")
    @Override
    public void setSortOfMessage(MessageSort value) {
        setAttVal(((CommunicationMessageSmClass)getClassOf()).getSortOfMessageAtt(), value);
    }

    @objid ("18195650-3c45-48ad-82c7-52e4c6ebc798")
    @Override
    public EList<InformationFlow> getRealizedInformationFlow() {
        return new SmList<>(this, ((CommunicationMessageSmClass)getClassOf()).getRealizedInformationFlowDep());
    }

    @objid ("8af5e38b-bc6f-439a-8a75-d57de21ca2aa")
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

    @objid ("5adb91d1-9398-4179-a01a-b07a508aa95c")
    @Override
    public CommunicationChannel getChannel() {
        Object obj = getDepVal(((CommunicationMessageSmClass)getClassOf()).getChannelDep());
        return (obj instanceof CommunicationChannel)? (CommunicationChannel)obj : null;
    }

    @objid ("3c6882c3-0ad4-4459-990e-b9f37d3930fd")
    @Override
    public void setChannel(CommunicationChannel value) {
        appendDepVal(((CommunicationMessageSmClass)getClassOf()).getChannelDep(), (SmObjectImpl)value);
    }

    @objid ("49f05e2d-c263-4a5e-b5f9-ff1b75a75b59")
    @Override
    public CommunicationChannel getInvertedChannel() {
        Object obj = getDepVal(((CommunicationMessageSmClass)getClassOf()).getInvertedChannelDep());
        return (obj instanceof CommunicationChannel)? (CommunicationChannel)obj : null;
    }

    @objid ("0304a756-7076-4d90-9d9c-4583f4f3c5c0")
    @Override
    public void setInvertedChannel(CommunicationChannel value) {
        appendDepVal(((CommunicationMessageSmClass)getClassOf()).getInvertedChannelDep(), (SmObjectImpl)value);
    }

    @objid ("5d504061-e5de-4cbd-8c7f-171992444382")
    @Override
    public Operation getInvoked() {
        Object obj = getDepVal(((CommunicationMessageSmClass)getClassOf()).getInvokedDep());
        return (obj instanceof Operation)? (Operation)obj : null;
    }

    @objid ("e37a824a-2104-4042-85cf-74504ccc42a6")
    @Override
    public void setInvoked(Operation value) {
        appendDepVal(((CommunicationMessageSmClass)getClassOf()).getInvokedDep(), (SmObjectImpl)value);
    }

    @objid ("d0b9c830-261d-4f64-b32a-808f34aadef2")
    @Override
    public Signal getSignalSignature() {
        Object obj = getDepVal(((CommunicationMessageSmClass)getClassOf()).getSignalSignatureDep());
        return (obj instanceof Signal)? (Signal)obj : null;
    }

    @objid ("65b301d4-2390-4484-b4ce-d03fb8f73fdf")
    @Override
    public void setSignalSignature(Signal value) {
        appendDepVal(((CommunicationMessageSmClass)getClassOf()).getSignalSignatureDep(), (SmObjectImpl)value);
    }

    @objid ("81acb617-071e-4e96-9425-4c49b04eb786")
    @Override
    public SmObjectImpl getCompositionOwner() {
        // Generated implementation
        SmObjectImpl obj;
        // Channel
        obj = (SmObjectImpl)this.getDepVal(((CommunicationMessageSmClass)getClassOf()).getChannelDep());
        if (obj != null)
          return obj;
        // InvertedChannel
        obj = (SmObjectImpl)this.getDepVal(((CommunicationMessageSmClass)getClassOf()).getInvertedChannelDep());
        if (obj != null)
          return obj;
        return super.getCompositionOwner();
    }

    @objid ("b09adbe0-5cd5-4ed7-ba47-f8a9e599bbfe")
    @Override
    public SmDepVal getCompositionRelation() {
        // Generated implementation
        SmObjectImpl obj;
        SmDependency dep;

        // Channel
        dep = ((CommunicationMessageSmClass)getClassOf()).getChannelDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        // InvertedChannel
        dep = ((CommunicationMessageSmClass)getClassOf()).getInvertedChannelDep();
        obj = (SmObjectImpl)this.getDepVal(dep);
        if (obj != null) return new SmDepVal(dep, obj);

        return super.getCompositionRelation();
    }

    @objid ("b1ac2888-6770-45a0-ad4f-59cde1448733")
    @Override
    public Object accept(IModelVisitor v) {
        return v.visitCommunicationMessage(this);
    }

}
