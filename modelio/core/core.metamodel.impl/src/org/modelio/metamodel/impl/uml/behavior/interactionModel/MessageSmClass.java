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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageKind;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("8c7c5c80-1e3c-40f4-96bd-887108a36523")
public class MessageSmClass extends UmlModelElementSmClass {
    @objid ("fd70bf85-10b9-44da-ba77-07b21893d55e")
    private SmAttribute argumentAtt;

    @objid ("c518b8a5-30af-450f-8a5a-c31e83c4cc17")
    private SmAttribute kindOfMessageAtt;

    @objid ("e695cf1c-95ea-48be-b19a-d9b2621052f6")
    private SmAttribute sortOfMessageAtt;

    @objid ("0cb2867b-bfdd-4ac6-a45c-295670edddd9")
    private SmAttribute sequenceAtt;

    @objid ("1f177d2f-e519-4dfc-8e4e-0e989cca846d")
    private SmDependency signalSignatureDep;

    @objid ("5a6120ef-6500-4f69-9ec2-10e81f4bd73a")
    private SmDependency receiveEventDep;

    @objid ("e619dd12-6a8c-48d0-8412-3908da89d648")
    private SmDependency sendEventDep;

    @objid ("aa8d0aae-fc03-48b4-ad69-6291efb75c8b")
    private SmDependency invokedDep;

    @objid ("15c26bd1-8b23-4c26-9a64-bd4a714536d2")
    private SmDependency realizedInformationFlowDep;

    @objid ("65b52930-5ada-4fe8-a3d3-943ef073570c")
    public MessageSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("296a2a49-0a9c-4a81-ab6f-f1ba07e7e0df")
    @Override
    public String getName() {
        return "Message";

    }

    @objid ("10faab5c-4ea5-47eb-aa74-957b354029d2")
    @Override
    public Version getVersion() {
        return new Version("2.2.01");
    }

    @objid ("240c6d2a-b4d7-49f1-be35-013fa5bbb664")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Message.class;

    }

    @objid ("d7122f91-c6e4-4271-a9f3-50b4cd7227ea")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1eb6622a-45c8-4b30-b44d-6f8747f20931")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e94a95f8-ada0-4288-a2f0-64e6282597ff")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new MessageObjectFactory(this));


        // Initialize and register the SmAttribute
        this.argumentAtt = new ArgumentSmAttribute();
        this.argumentAtt.init("Argument", this, String.class );
        registerAttribute(this.argumentAtt);

        this.kindOfMessageAtt = new KindOfMessageSmAttribute();
        this.kindOfMessageAtt.init("KindOfMessage", this, MessageKind.class );
        registerAttribute(this.kindOfMessageAtt);

        this.sortOfMessageAtt = new SortOfMessageSmAttribute();
        this.sortOfMessageAtt.init("SortOfMessage", this, MessageSort.class );
        registerAttribute(this.sortOfMessageAtt);

        this.sequenceAtt = new SequenceSmAttribute();
        this.sequenceAtt.init("Sequence", this, String.class );
        registerAttribute(this.sequenceAtt);


        // Initialize and register the SmDependency
        this.signalSignatureDep = new SignalSignatureSmDependency();
        this.signalSignatureDep.init("SignalSignature", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.signalSignatureDep);

        this.receiveEventDep = new ReceiveEventSmDependency();
        this.receiveEventDep.init("ReceiveEvent", this, metamodel.getMClass(MessageEnd.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.receiveEventDep);

        this.sendEventDep = new SendEventSmDependency();
        this.sendEventDep.init("SendEvent", this, metamodel.getMClass(MessageEnd.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.sendEventDep);

        this.invokedDep = new InvokedSmDependency();
        this.invokedDep.init("Invoked", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.invokedDep);

        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

    }

    @objid ("04f715f6-2b74-4a89-acfc-f445b0667937")
    public SmAttribute getArgumentAtt() {
        if (this.argumentAtt == null) {
        	this.argumentAtt = this.getAttributeDef("Argument");
        }
        return this.argumentAtt;
    }

    @objid ("edb88716-bdf6-40a1-89dd-aa04d1c72c91")
    public SmAttribute getKindOfMessageAtt() {
        if (this.kindOfMessageAtt == null) {
        	this.kindOfMessageAtt = this.getAttributeDef("KindOfMessage");
        }
        return this.kindOfMessageAtt;
    }

    @objid ("9d30c5aa-8603-43e2-9299-f85cc7a009eb")
    public SmAttribute getSortOfMessageAtt() {
        if (this.sortOfMessageAtt == null) {
        	this.sortOfMessageAtt = this.getAttributeDef("SortOfMessage");
        }
        return this.sortOfMessageAtt;
    }

    @objid ("ace6f633-d82a-49e2-85e7-660a3636e278")
    public SmAttribute getSequenceAtt() {
        if (this.sequenceAtt == null) {
        	this.sequenceAtt = this.getAttributeDef("Sequence");
        }
        return this.sequenceAtt;
    }

    @objid ("8616257c-1ef5-43a2-a813-40124d8be4a5")
    public SmDependency getSignalSignatureDep() {
        if (this.signalSignatureDep == null) {
        	this.signalSignatureDep = this.getDependencyDef("SignalSignature");
        }
        return this.signalSignatureDep;
    }

    @objid ("d0aad2c6-3a2d-4c2c-be48-50e968fdcacd")
    public SmDependency getReceiveEventDep() {
        if (this.receiveEventDep == null) {
        	this.receiveEventDep = this.getDependencyDef("ReceiveEvent");
        }
        return this.receiveEventDep;
    }

    @objid ("44030434-b453-499b-8300-3cc3e398224e")
    public SmDependency getSendEventDep() {
        if (this.sendEventDep == null) {
        	this.sendEventDep = this.getDependencyDef("SendEvent");
        }
        return this.sendEventDep;
    }

    @objid ("ba5b6cd1-4a4b-4fd9-84d7-addaf1d5311d")
    public SmDependency getInvokedDep() {
        if (this.invokedDep == null) {
        	this.invokedDep = this.getDependencyDef("Invoked");
        }
        return this.invokedDep;
    }

    @objid ("c8621793-bf73-44ac-823c-0f6796470825")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("10498d79-87ae-4dd2-a42b-a0686f6f62c0")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("3696f803-b9db-470b-9da9-0a35b59ad657")
    private static class MessageObjectFactory implements ISmObjectFactory {
        @objid ("51ed5f5a-e5d0-4028-9d53-846ae7531f67")
        private MessageSmClass smClass;

        @objid ("7ba9db6e-4b12-47b6-a15a-1ec957c04536")
        public MessageObjectFactory(MessageSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("efcd892d-5bf3-4892-96cc-9247fbeabc29")
        @Override
        public ISmObjectData createData() {
            return new MessageData(this.smClass);
        }

        @objid ("5cc4ddae-40cc-4d57-994d-12a6a5f6e953")
        @Override
        public SmObjectImpl createImpl() {
            return new MessageImpl();
        }

    }

    @objid ("5052c024-ba43-4fd0-b16e-99ebc8f7dbde")
    public static class ArgumentSmAttribute extends SmAttribute {
        @objid ("ab32bb06-ca73-4d08-bfaf-531ee4e1928e")
        public Object getValue(ISmObjectData data) {
            return ((MessageData) data).mArgument;
        }

        @objid ("bbd385c8-2247-4f1d-863e-5836733dd87f")
        public void setValue(ISmObjectData data, Object value) {
            ((MessageData) data).mArgument = value;
        }

    }

    @objid ("046163f3-b249-4bab-b3aa-7c4bc68123fa")
    public static class KindOfMessageSmAttribute extends SmAttribute {
        @objid ("ff5a3e12-c53e-43d7-bbe7-10cc5bc7d7cb")
        public Object getValue(ISmObjectData data) {
            return ((MessageData) data).mKindOfMessage;
        }

        @objid ("d6a449f9-c769-4b38-9c3a-77ae04b96d1d")
        public void setValue(ISmObjectData data, Object value) {
            ((MessageData) data).mKindOfMessage = value;
        }

    }

    @objid ("245b5f09-ec95-44d3-b00f-656fd8bf4a67")
    public static class SortOfMessageSmAttribute extends SmAttribute {
        @objid ("c508b17d-a87e-4448-8e43-5a99f8b1f20c")
        public Object getValue(ISmObjectData data) {
            return ((MessageData) data).mSortOfMessage;
        }

        @objid ("26f011f3-f590-4bad-a9a3-5f10cdc5c412")
        public void setValue(ISmObjectData data, Object value) {
            ((MessageData) data).mSortOfMessage = value;
        }

    }

    @objid ("bdd47aa4-244f-43ab-b009-f3ee7ca050c1")
    public static class SignalSignatureSmDependency extends SmSingleDependency {
        @objid ("7a6cc61f-399c-4428-ba0e-0656dc015697")
        private SmDependency symetricDep;

        @objid ("f16e856d-ff73-47d5-a6ed-135a7e82ef6b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageData) data).mSignalSignature;
        }

        @objid ("2b6fc5ec-64e9-40c0-9d03-77c23633d262")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageData) data).mSignalSignature = value;
        }

        @objid ("f4f3394b-3cb2-4c8b-96c2-73f24579cd4e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getUsageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("05bcd8f7-d8e7-433e-ae8e-a2f2877378f3")
    public static class ReceiveEventSmDependency extends SmSingleDependency {
        @objid ("15f66781-084d-42cc-981a-8981ac95e182")
        private SmDependency symetricDep;

        @objid ("d1e95ff4-aa09-4167-a9fa-182879a2ddd2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageData) data).mReceiveEvent;
        }

        @objid ("cf05aaee-d560-4fb3-9267-38b45a18d02d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageData) data).mReceiveEvent = value;
        }

        @objid ("a583aecc-016a-482d-a037-aeb9cb4494f5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageEndSmClass)this.getTarget()).getReceivedMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ee32163c-de34-40a9-9455-43ed42421db9")
    public static class SendEventSmDependency extends SmSingleDependency {
        @objid ("ddeeea7f-c98f-451c-bb66-0815e06d325b")
        private SmDependency symetricDep;

        @objid ("f4d4ad41-a278-4d83-9199-4f7d6877d0d0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageData) data).mSendEvent;
        }

        @objid ("6403167c-d07e-4374-8d1f-39ea08ab238c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageData) data).mSendEvent = value;
        }

        @objid ("b8a44e95-6da7-43b9-a725-ead136b53e0a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageEndSmClass)this.getTarget()).getSentMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8e2e3b7c-0ae1-47ac-afde-a2f5e1e026b3")
    public static class InvokedSmDependency extends SmSingleDependency {
        @objid ("e4f1e1c7-25ae-4644-bd35-dfd791782290")
        private SmDependency symetricDep;

        @objid ("5c2518ab-0039-4b8a-9e0a-5b0717e4898d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageData) data).mInvoked;
        }

        @objid ("915fac68-3f0d-425b-9abc-4760aa86d508")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageData) data).mInvoked = value;
        }

        @objid ("bb544637-7dfb-43fc-bf92-1bbcbe41887f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getUsageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("65ddd40a-0925-48ca-a91b-a1533d8da046")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("8e5d77b4-d61f-4644-9777-ba70e37a5a96")
        private SmDependency symetricDep;

        @objid ("051e9b03-c0fe-4549-8963-907ca6a4be8c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((MessageData)data).mRealizedInformationFlow != null)? ((MessageData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("84288372-f1a8-4a5c-a908-d6a9ee17942b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((MessageData) data).mRealizedInformationFlow = values;

        }

        @objid ("270e2089-f8a9-4f18-a5a8-e8e0e217ff4f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingMessageDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bf6df04d-0fcd-408f-ad45-f3813a321e62")
    public static class SequenceSmAttribute extends SmAttribute {
        @objid ("f67090d2-a151-4141-a32e-d82bf79e9ec2")
        public Object getValue(ISmObjectData data) {
            return ((MessageData) data).mSequence;
        }

        @objid ("7beec009-8af3-4260-8017-159c70c19be4")
        public void setValue(ISmObjectData data, Object value) {
            ((MessageData) data).mSequence = value;
        }

    }

}
