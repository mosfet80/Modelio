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
package org.modelio.metamodel.impl.bpmn.flows;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.objects.BpmnItemDefinition;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.rootElements.BpmnSharedElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnReceiveTaskSmClass;
import org.modelio.metamodel.impl.bpmn.activities.BpmnSendTaskSmClass;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnOperationSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnMessageEventDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnItemDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnCollaborationSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnSharedElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("67a60b2f-d45e-41b3-b55c-d10466cf2bbb")
public class BpmnMessageSmClass extends BpmnSharedElementSmClass {
    @objid ("1e7d8ac3-31f2-4a58-b251-0f2794c16ffb")
    private SmDependency outputMessageDep;

    @objid ("9a37d433-58d4-4c78-a2ac-ded90e53f76a")
    private SmDependency itemRefDep;

    @objid ("d1b1aee3-8524-4b8f-a23f-eb0ab7e59fa9")
    private SmDependency eventDefinitionDep;

    @objid ("798ac0ac-b2f8-4523-bed6-02c22c0c8683")
    private SmDependency senderDep;

    @objid ("2238f530-3214-4801-8307-4c5015b11306")
    private SmDependency inputMessageDep;

    @objid ("c86d99f2-c043-49fb-894f-1b9c2eb901e6")
    private SmDependency receiverDep;

    @objid ("8bdd1636-e6af-4390-992e-248c3469598d")
    private SmDependency messageFlowDep;

    @objid ("77db6094-3dc7-4868-8c5b-80ce1ee2619c")
    private SmDependency collaborationDep;

    @objid ("dd6d2298-b149-4e86-9555-e304e84507bb")
    public BpmnMessageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e7524814-7aa4-46c8-92a3-4dccff30e891")
    @Override
    public String getName() {
        return "BpmnMessage";

    }

    @objid ("230c08bb-6455-4d83-948c-9523b8b04619")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f2019ed5-2588-4fb0-a7f4-55436fac3b0f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnMessage.class;

    }

    @objid ("b45c5086-ca1b-49d7-bf12-cf03895e1ca0")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("8f22467f-9293-448c-8ef2-c9625356b46b")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("91bfa402-2c28-471a-8ca9-9f8583f0a500")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnSharedElement.MQNAME);
        this.registerFactory(new BpmnMessageObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.outputMessageDep = new OutputMessageSmDependency();
        this.outputMessageDep.init("OutputMessage", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, -1 );
        registerDependency(this.outputMessageDep);

        this.itemRefDep = new ItemRefSmDependency();
        this.itemRefDep.init("ItemRef", this, metamodel.getMClass(BpmnItemDefinition.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.itemRefDep);

        this.eventDefinitionDep = new EventDefinitionSmDependency();
        this.eventDefinitionDep.init("EventDefinition", this, metamodel.getMClass(BpmnMessageEventDefinition.MQNAME), 0, -1 );
        registerDependency(this.eventDefinitionDep);

        this.senderDep = new SenderSmDependency();
        this.senderDep.init("Sender", this, metamodel.getMClass(BpmnSendTask.MQNAME), 0, -1 );
        registerDependency(this.senderDep);

        this.inputMessageDep = new InputMessageSmDependency();
        this.inputMessageDep.init("InputMessage", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, -1 );
        registerDependency(this.inputMessageDep);

        this.receiverDep = new ReceiverSmDependency();
        this.receiverDep.init("Receiver", this, metamodel.getMClass(BpmnReceiveTask.MQNAME), 0, -1 );
        registerDependency(this.receiverDep);

        this.messageFlowDep = new MessageFlowSmDependency();
        this.messageFlowDep.init("MessageFlow", this, metamodel.getMClass(BpmnMessageFlow.MQNAME), 0, -1 );
        registerDependency(this.messageFlowDep);

        this.collaborationDep = new CollaborationSmDependency();
        this.collaborationDep.init("Collaboration", this, metamodel.getMClass(BpmnCollaboration.MQNAME), 0, 1 );
        registerDependency(this.collaborationDep);

    }

    @objid ("f7689c05-befe-4659-b5ae-fcfb1fdbb7a4")
    public SmDependency getOutputMessageDep() {
        if (this.outputMessageDep == null) {
        	this.outputMessageDep = this.getDependencyDef("OutputMessage");
        }
        return this.outputMessageDep;
    }

    @objid ("e008a989-2ad3-4f4d-92ac-76a04323f6a1")
    public SmDependency getItemRefDep() {
        if (this.itemRefDep == null) {
        	this.itemRefDep = this.getDependencyDef("ItemRef");
        }
        return this.itemRefDep;
    }

    @objid ("e3d88596-bb1a-4fc5-81a7-a4ce823df350")
    public SmDependency getEventDefinitionDep() {
        if (this.eventDefinitionDep == null) {
        	this.eventDefinitionDep = this.getDependencyDef("EventDefinition");
        }
        return this.eventDefinitionDep;
    }

    @objid ("f5f46323-1ebf-453c-a36a-e7387bbcfdea")
    public SmDependency getSenderDep() {
        if (this.senderDep == null) {
        	this.senderDep = this.getDependencyDef("Sender");
        }
        return this.senderDep;
    }

    @objid ("d27a1382-b398-4ef4-b40d-4fdd0ef4566d")
    public SmDependency getInputMessageDep() {
        if (this.inputMessageDep == null) {
        	this.inputMessageDep = this.getDependencyDef("InputMessage");
        }
        return this.inputMessageDep;
    }

    @objid ("96655fd3-3458-4803-a193-5ace11d16e41")
    public SmDependency getReceiverDep() {
        if (this.receiverDep == null) {
        	this.receiverDep = this.getDependencyDef("Receiver");
        }
        return this.receiverDep;
    }

    @objid ("977329e9-6fbc-468d-8c05-52f6d0d425ff")
    public SmDependency getMessageFlowDep() {
        if (this.messageFlowDep == null) {
        	this.messageFlowDep = this.getDependencyDef("MessageFlow");
        }
        return this.messageFlowDep;
    }

    @objid ("acc3efa8-de9c-42ca-92df-4aac00fa5b56")
    public SmDependency getCollaborationDep() {
        if (this.collaborationDep == null) {
        	this.collaborationDep = this.getDependencyDef("Collaboration");
        }
        return this.collaborationDep;
    }

    @objid ("d1808b14-b5a0-487f-b7fe-0e4e72101cc6")
    private static class BpmnMessageObjectFactory implements ISmObjectFactory {
        @objid ("a1dddbd8-bd23-4759-b8e9-5e3cef240011")
        private BpmnMessageSmClass smClass;

        @objid ("4cc0d817-5055-4748-90b9-2752207375cb")
        public BpmnMessageObjectFactory(BpmnMessageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("5890523a-027f-494f-837f-92f950b6c24e")
        @Override
        public ISmObjectData createData() {
            return new BpmnMessageData(this.smClass);
        }

        @objid ("49f3a4df-db49-42bb-99d1-567be3a46099")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnMessageImpl();
        }

    }

    @objid ("f7cb3830-44bf-4bdb-9a40-9ee190eb2cf7")
    public static class OutputMessageSmDependency extends SmMultipleDependency {
        @objid ("c332cbb8-d7b8-4d91-a2bd-4654318e55fd")
        private SmDependency symetricDep;

        @objid ("a7d7fa5b-78b8-4cd4-950f-5db92003e79a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mOutputMessage != null)? ((BpmnMessageData)data).mOutputMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("118045ef-593b-4254-a30a-ae8290b359a9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mOutputMessage = values;

        }

        @objid ("abc4e14c-7fcc-406a-b8f8-59b05c9ec5d6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getOutMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c974f496-cb5d-484c-87f8-31b67ad02d71")
    public static class ItemRefSmDependency extends SmSingleDependency {
        @objid ("64126310-4477-4583-895b-28c09cc57955")
        private SmDependency symetricDep;

        @objid ("666b6f25-95f8-4e68-9d89-05a4bc6291a3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageData) data).mItemRef;
        }

        @objid ("0a58aa77-1857-4808-a167-989b5cd3b813")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageData) data).mItemRef = value;
        }

        @objid ("e255e604-7825-414d-b93a-b840bd08b76f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnItemDefinitionSmClass)this.getTarget()).getTypedMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("14a3c48d-441a-4297-9d7e-6a9971010ae4")
    public static class EventDefinitionSmDependency extends SmMultipleDependency {
        @objid ("1c21138a-9b34-40fd-8da0-99ae75b0ff05")
        private SmDependency symetricDep;

        @objid ("e1081aa4-00d1-4090-b676-8d6a156195d8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mEventDefinition != null)? ((BpmnMessageData)data).mEventDefinition:SmMultipleDependency.EMPTY;
        }

        @objid ("ee10729c-80f9-4727-bc93-ff4bff25cb65")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mEventDefinition = values;

        }

        @objid ("06b67a47-335d-4523-9e54-f8a46fb73746")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageEventDefinitionSmClass)this.getTarget()).getMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5ba42f34-fd55-45ef-b8b7-927422618153")
    public static class SenderSmDependency extends SmMultipleDependency {
        @objid ("f5e552cf-d276-441b-a694-44c057db9633")
        private SmDependency symetricDep;

        @objid ("6c41c0d5-9985-4d81-b87a-d9786cdee593")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mSender != null)? ((BpmnMessageData)data).mSender:SmMultipleDependency.EMPTY;
        }

        @objid ("c8fdb6ac-2523-4858-92a1-f7f28d5002d5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mSender = values;

        }

        @objid ("bbcd42ec-1b9c-4979-a6fc-a777de8ab63b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSendTaskSmClass)this.getTarget()).getMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("dc181931-ce43-42e9-ac5f-bc0cc98ba435")
    public static class InputMessageSmDependency extends SmMultipleDependency {
        @objid ("77e45599-f7c1-43c4-90b0-2e7e59836d98")
        private SmDependency symetricDep;

        @objid ("8c917b12-0775-457e-98ca-f5380db4a85b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mInputMessage != null)? ((BpmnMessageData)data).mInputMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("5b21b602-7762-4e83-9dc6-3095ad674772")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mInputMessage = values;

        }

        @objid ("7ccc5da4-a9a9-415f-ba6d-1c50b080a430")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getInMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2dfeeb74-d853-4d5f-9fb9-2caa8f417c6e")
    public static class ReceiverSmDependency extends SmMultipleDependency {
        @objid ("21acf9a3-44bc-47d7-8197-cdde6b8be7cf")
        private SmDependency symetricDep;

        @objid ("8f194b2a-4e59-4ba8-b396-7fcc7e0d70ef")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mReceiver != null)? ((BpmnMessageData)data).mReceiver:SmMultipleDependency.EMPTY;
        }

        @objid ("a421b1b5-39a3-41fb-aa13-87b997c9737b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mReceiver = values;

        }

        @objid ("9e27fcd9-3707-423f-a4c5-376081af2a67")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnReceiveTaskSmClass)this.getTarget()).getMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ecef9b09-01e6-41fc-9305-dc7b6ea772b8")
    public static class MessageFlowSmDependency extends SmMultipleDependency {
        @objid ("024499f7-8052-4f3a-b190-1815f990b1e9")
        private SmDependency symetricDep;

        @objid ("b87e8440-de42-4aba-8af1-a6632671d4c0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageData)data).mMessageFlow != null)? ((BpmnMessageData)data).mMessageFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("31a75e30-a643-4163-9cab-a759383d5c71")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageData) data).mMessageFlow = values;

        }

        @objid ("dbca0000-d5e5-4498-8941-28d3a70f68af")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageFlowSmClass)this.getTarget()).getMessageRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("19a7adc8-416b-4030-80da-e7b6bbe7200b")
    public static class CollaborationSmDependency extends SmSingleDependency {
        @objid ("c8e81bd0-08c5-44ed-9532-66cca5b6d6fd")
        private SmDependency symetricDep;

        @objid ("ad2db61f-09a2-4ca8-b5fb-9c4632386b2a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageData) data).mCollaboration;
        }

        @objid ("663ac875-31fc-4139-8f2e-e874867690f3")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageData) data).mCollaboration = value;
        }

        @objid ("461b087b-7af3-4ac3-8038-5f5417ac2d49")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCollaborationSmClass)this.getTarget()).getMessagesDep();
            }
            return this.symetricDep;

        }

    }

}
