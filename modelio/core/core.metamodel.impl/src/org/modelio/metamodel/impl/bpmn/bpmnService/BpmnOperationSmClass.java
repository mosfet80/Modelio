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
package org.modelio.metamodel.impl.bpmn.bpmnService;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnInterface;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnReceiveTaskSmClass;
import org.modelio.metamodel.impl.bpmn.activities.BpmnSendTaskSmClass;
import org.modelio.metamodel.impl.bpmn.activities.BpmnServiceTaskSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnMessageEventDefinitionSmClass;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
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

@objid ("0fe74703-9e94-4efe-a402-d2b779a10567")
public class BpmnOperationSmClass extends BpmnBaseElementSmClass {
    @objid ("c771bbe7-e297-4b25-b314-bf8d0f8f15dd")
    private SmDependency senderDep;

    @objid ("13386923-ebbd-4999-a505-45aa6df8a503")
    private SmDependency inMessageRefDep;

    @objid ("c0acfe33-2632-41a1-91bb-276946d3af48")
    private SmDependency callerDep;

    @objid ("32b9d450-c896-432e-8d54-630b5286b177")
    private SmDependency outMessageRefDep;

    @objid ("b3fa9625-d886-4e43-923b-65e8452f4327")
    private SmDependency eventDefinitionDep;

    @objid ("4085a86f-447b-44b4-8270-96ea83d2bf38")
    private SmDependency bpmnInterfaceRefDep;

    @objid ("4974f812-40c6-4029-b7fd-d44d33d5b4cb")
    private SmDependency receiverDep;

    @objid ("6ef9d31e-8933-4945-b49e-d3fd71f30016")
    public BpmnOperationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("75ea755c-2b26-452c-9299-5a39a16689fc")
    @Override
    public String getName() {
        return "BpmnOperation";

    }

    @objid ("3d6f9b92-8779-406c-8628-c8f08227a7c0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("29a803bd-8a7b-4c1d-8158-3a5e617d72df")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnOperation.class;

    }

    @objid ("6fa080bd-c403-4c6b-bf48-1a15f2d9c377")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0bfaf4d9-35b7-4898-93cb-8ac5615d54dc")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("82c2c681-3291-4adf-8e6d-71e00a4b5733")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnOperationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.senderDep = new SenderSmDependency();
        this.senderDep.init("Sender", this, metamodel.getMClass(BpmnSendTask.MQNAME), 0, -1 );
        registerDependency(this.senderDep);

        this.inMessageRefDep = new InMessageRefSmDependency();
        this.inMessageRefDep.init("InMessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.inMessageRefDep);

        this.callerDep = new CallerSmDependency();
        this.callerDep.init("Caller", this, metamodel.getMClass(BpmnServiceTask.MQNAME), 0, -1 );
        registerDependency(this.callerDep);

        this.outMessageRefDep = new OutMessageRefSmDependency();
        this.outMessageRefDep.init("OutMessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.outMessageRefDep);

        this.eventDefinitionDep = new EventDefinitionSmDependency();
        this.eventDefinitionDep.init("EventDefinition", this, metamodel.getMClass(BpmnMessageEventDefinition.MQNAME), 0, -1 );
        registerDependency(this.eventDefinitionDep);

        this.bpmnInterfaceRefDep = new BpmnInterfaceRefSmDependency();
        this.bpmnInterfaceRefDep.init("BpmnInterfaceRef", this, metamodel.getMClass(BpmnInterface.MQNAME), 1, 1 );
        registerDependency(this.bpmnInterfaceRefDep);

        this.receiverDep = new ReceiverSmDependency();
        this.receiverDep.init("Receiver", this, metamodel.getMClass(BpmnReceiveTask.MQNAME), 0, -1 );
        registerDependency(this.receiverDep);

    }

    @objid ("11440512-545d-42ab-b1c7-9cd7f22e63ad")
    public SmDependency getSenderDep() {
        if (this.senderDep == null) {
        	this.senderDep = this.getDependencyDef("Sender");
        }
        return this.senderDep;
    }

    @objid ("6987e385-2625-495d-b9aa-b0606d5d2e2f")
    public SmDependency getInMessageRefDep() {
        if (this.inMessageRefDep == null) {
        	this.inMessageRefDep = this.getDependencyDef("InMessageRef");
        }
        return this.inMessageRefDep;
    }

    @objid ("c4be709a-60e2-476d-96e1-e2138807ca7a")
    public SmDependency getCallerDep() {
        if (this.callerDep == null) {
        	this.callerDep = this.getDependencyDef("Caller");
        }
        return this.callerDep;
    }

    @objid ("23f76d0b-4411-4308-8fd0-e9d961e4ac1c")
    public SmDependency getOutMessageRefDep() {
        if (this.outMessageRefDep == null) {
        	this.outMessageRefDep = this.getDependencyDef("OutMessageRef");
        }
        return this.outMessageRefDep;
    }

    @objid ("3f601f14-8a1d-4890-aeaa-7d305fac2013")
    public SmDependency getEventDefinitionDep() {
        if (this.eventDefinitionDep == null) {
        	this.eventDefinitionDep = this.getDependencyDef("EventDefinition");
        }
        return this.eventDefinitionDep;
    }

    @objid ("5c27c26c-aa28-480e-abab-62cdee81a9b2")
    public SmDependency getBpmnInterfaceRefDep() {
        if (this.bpmnInterfaceRefDep == null) {
        	this.bpmnInterfaceRefDep = this.getDependencyDef("BpmnInterfaceRef");
        }
        return this.bpmnInterfaceRefDep;
    }

    @objid ("a278ae48-7f34-4881-bb3d-6061a1fac34e")
    public SmDependency getReceiverDep() {
        if (this.receiverDep == null) {
        	this.receiverDep = this.getDependencyDef("Receiver");
        }
        return this.receiverDep;
    }

    @objid ("a3b08f42-4691-45d1-86b2-0b062dcbda6e")
    private static class BpmnOperationObjectFactory implements ISmObjectFactory {
        @objid ("07eda04f-9cd1-4d79-b66b-eaf88887cf47")
        private BpmnOperationSmClass smClass;

        @objid ("22b02f54-ac5a-4b24-ad74-3de66c42fea6")
        public BpmnOperationObjectFactory(BpmnOperationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("d5e4b3e2-ffdf-4b35-aba0-3c61a38c7adb")
        @Override
        public ISmObjectData createData() {
            return new BpmnOperationData(this.smClass);
        }

        @objid ("2cd3f5b8-3878-426e-9299-2e05630862ca")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnOperationImpl();
        }

    }

    @objid ("964ed99a-b6b7-49a1-85f8-8ec358a07ba9")
    public static class SenderSmDependency extends SmMultipleDependency {
        @objid ("ac004f95-111c-4d29-880b-fc19db95fd93")
        private SmDependency symetricDep;

        @objid ("3774883b-434f-461c-b77f-07946dd59b23")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnOperationData)data).mSender != null)? ((BpmnOperationData)data).mSender:SmMultipleDependency.EMPTY;
        }

        @objid ("a3f832cc-239d-48de-8a2a-d38364c34277")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnOperationData) data).mSender = values;

        }

        @objid ("5522108f-5f14-4444-b59b-1ab64c861861")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSendTaskSmClass)this.getTarget()).getOperationRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2cd47679-a8a1-4641-be66-af8e7a8196c5")
    public static class InMessageRefSmDependency extends SmSingleDependency {
        @objid ("faa3d894-6f0a-4f34-a09e-4cde8d87e233")
        private SmDependency symetricDep;

        @objid ("cf20bb56-f635-4d70-be5e-9df59ec2c014")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnOperationData) data).mInMessageRef;
        }

        @objid ("7ebb76f4-e29c-4406-9b1f-5fce8b0cfe4f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnOperationData) data).mInMessageRef = value;
        }

        @objid ("463ad26d-b4af-4b9b-913a-f1b9cdbf1a6f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getInputMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("59dafd44-783f-4ae7-a955-c3df90117ad0")
    public static class CallerSmDependency extends SmMultipleDependency {
        @objid ("31af3e40-3c1e-4d3e-9ada-c423265aca72")
        private SmDependency symetricDep;

        @objid ("3c62256a-4f6a-4fc1-9210-c4d306317b02")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnOperationData)data).mCaller != null)? ((BpmnOperationData)data).mCaller:SmMultipleDependency.EMPTY;
        }

        @objid ("11e9021f-c2d6-499f-8d9c-b00888434dd7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnOperationData) data).mCaller = values;

        }

        @objid ("c38a43d2-cd1c-423b-8a3a-bd9d58a75c9b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnServiceTaskSmClass)this.getTarget()).getOperationRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cb013d46-aef0-44b4-b15b-508ef376b9f5")
    public static class OutMessageRefSmDependency extends SmSingleDependency {
        @objid ("dedc3eab-b225-40c2-adf5-6ec58e927abf")
        private SmDependency symetricDep;

        @objid ("e3197347-0ce5-4f50-a23b-7abbd62aaa09")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnOperationData) data).mOutMessageRef;
        }

        @objid ("b7381e44-6a49-47b0-a687-a8798a4ccc9e")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnOperationData) data).mOutMessageRef = value;
        }

        @objid ("e0b9bd7c-542e-4491-bd0e-1f809318b5c3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getOutputMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bab64fcb-afca-4b31-b245-9c946cbaf4b6")
    public static class EventDefinitionSmDependency extends SmMultipleDependency {
        @objid ("cbe8dec3-f7ee-4391-8037-52f1cc2ccff7")
        private SmDependency symetricDep;

        @objid ("4578109a-48cc-44c0-9356-09f9d26a4483")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnOperationData)data).mEventDefinition != null)? ((BpmnOperationData)data).mEventDefinition:SmMultipleDependency.EMPTY;
        }

        @objid ("87e755a9-07b1-4c4a-9556-cd3f75c7a7d1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnOperationData) data).mEventDefinition = values;

        }

        @objid ("ca47f956-2468-457e-8a3a-20c290967d19")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageEventDefinitionSmClass)this.getTarget()).getOperationRefDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a07f929a-6fe6-443a-a888-a66808c08a44")
    public static class BpmnInterfaceRefSmDependency extends SmSingleDependency {
        @objid ("b308e45f-e2c2-4e81-98c3-d3a09e9e4764")
        private SmDependency symetricDep;

        @objid ("c87f3a88-e262-4fd0-a8e4-ebb9fe2b7c01")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnOperationData) data).mBpmnInterfaceRef;
        }

        @objid ("204090c3-f94d-465a-998c-93be782590ca")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnOperationData) data).mBpmnInterfaceRef = value;
        }

        @objid ("fd1c31be-d485-4ea8-857a-baf9e16ffa4e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnInterfaceSmClass)this.getTarget()).getOperationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("62fd6533-3b2e-43fc-a755-23128836df25")
    public static class ReceiverSmDependency extends SmMultipleDependency {
        @objid ("70be6e3f-958e-47ef-9ada-987d5133c3c4")
        private SmDependency symetricDep;

        @objid ("f8e31178-9b1b-4359-b494-b9263edea9ac")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnOperationData)data).mReceiver != null)? ((BpmnOperationData)data).mReceiver:SmMultipleDependency.EMPTY;
        }

        @objid ("b9fef4b3-b6c1-4c51-9577-ad7f3c4969dd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnOperationData) data).mReceiver = values;

        }

        @objid ("d4620e06-ac23-4ed6-a79b-33bcbb69139a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnReceiveTaskSmClass)this.getTarget()).getOperationRefDep();
            }
            return this.symetricDep;

        }

    }

}
