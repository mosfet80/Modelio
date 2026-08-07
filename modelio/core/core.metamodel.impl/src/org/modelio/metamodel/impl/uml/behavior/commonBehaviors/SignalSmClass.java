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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.AcceptSignalActionSmClass;
import org.modelio.metamodel.impl.uml.behavior.activityModel.SendSignalActionSmClass;
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationMessageSmClass;
import org.modelio.metamodel.impl.uml.behavior.interactionModel.MessageSmClass;
import org.modelio.metamodel.impl.uml.behavior.stateMachineModel.TransitionSmClass;
import org.modelio.metamodel.impl.uml.informationFlow.DataFlowSmClass;
import org.modelio.metamodel.impl.uml.statik.GeneralClassSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.impl.uml.statik.ParameterSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.AcceptSignalAction;
import org.modelio.metamodel.uml.behavior.activityModel.SendSignalAction;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.statik.GeneralClass;
import org.modelio.metamodel.uml.statik.Operation;
import org.modelio.metamodel.uml.statik.Parameter;
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

@objid ("c89cedee-1c4a-4e97-82b0-fd0e6622b708")
public class SignalSmClass extends GeneralClassSmClass {
    @objid ("00e2dd33-55a5-4456-ae65-2dc3de341bc6")
    private SmAttribute isEventAtt;

    @objid ("afa96add-7782-4f84-b30d-d8cc322df9b5")
    private SmAttribute isExceptionAtt;

    @objid ("704f673c-bac1-4c5d-a8e6-306e1f871faa")
    private SmDependency senderDep;

    @objid ("8767cc80-e722-423c-8cdb-68ba2333debe")
    private SmDependency usageDep;

    @objid ("6625f989-b59d-4ad7-8f77-7aad667db612")
    private SmDependency sendsDep;

    @objid ("58681afc-8982-47e7-9646-47e1b010a8a1")
    private SmDependency pBaseDep;

    @objid ("59ee4cb5-ace2-42c9-aaa6-f86bf3a08b66")
    private SmDependency oBaseDep;

    @objid ("1d03fadf-c40c-4a0e-be11-46b2b03d8609")
    private SmDependency communicationUsageDep;

    @objid ("1a58002d-0a3f-4d8e-a421-7736f0cad2c4")
    private SmDependency dOccurenceDep;

    @objid ("4f5b721e-d467-4986-a356-d59d4231600c")
    private SmDependency eOccurenceDep;

    @objid ("db6657f5-e068-4c96-b176-e5c3db8967d2")
    private SmDependency baseDep;

    @objid ("8d64e66f-d4fb-4c43-9225-2b81d19e2f9a")
    private SmDependency receiverDep;

    @objid ("29f59386-8caa-4f43-9ce0-889bada38d62")
    public SignalSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("af3a754a-f100-4d1d-8da9-11006459b4b8")
    @Override
    public String getName() {
        return "Signal";

    }

    @objid ("5fd119a7-3925-4dd9-a11f-dd09ef4fcbfc")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("cdcc46e9-be84-4cfa-b92c-380bae4eb93c")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Signal.class;

    }

    @objid ("4d44d660-4acb-4612-977c-58a340705821")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("04683068-becc-463b-badd-b96984dd331f")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e4bfb4cf-9d20-42b2-bcee-7e315dad94c2")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(GeneralClass.MQNAME);
        this.registerFactory(new SignalObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isEventAtt = new IsEventSmAttribute();
        this.isEventAtt.init("IsEvent", this, Boolean.class );
        registerAttribute(this.isEventAtt);

        this.isExceptionAtt = new IsExceptionSmAttribute();
        this.isExceptionAtt.init("IsException", this, Boolean.class );
        registerAttribute(this.isExceptionAtt);


        // Initialize and register the SmDependency
        this.senderDep = new SenderSmDependency();
        this.senderDep.init("Sender", this, metamodel.getMClass(SendSignalAction.MQNAME), 0, -1 );
        registerDependency(this.senderDep);

        this.usageDep = new UsageSmDependency();
        this.usageDep.init("Usage", this, metamodel.getMClass(Message.MQNAME), 0, -1 );
        registerDependency(this.usageDep);

        this.sendsDep = new SendsSmDependency();
        this.sendsDep.init("Sends", this, metamodel.getMClass(Transition.MQNAME), 0, -1 );
        registerDependency(this.sendsDep);

        this.pBaseDep = new PBaseSmDependency();
        this.pBaseDep.init("PBase", this, metamodel.getMClass(Parameter.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.pBaseDep);

        this.oBaseDep = new OBaseSmDependency();
        this.oBaseDep.init("OBase", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.oBaseDep);

        this.communicationUsageDep = new CommunicationUsageSmDependency();
        this.communicationUsageDep.init("CommunicationUsage", this, metamodel.getMClass(CommunicationMessage.MQNAME), 0, -1 );
        registerDependency(this.communicationUsageDep);

        this.dOccurenceDep = new DOccurenceSmDependency();
        this.dOccurenceDep.init("DOccurence", this, metamodel.getMClass(DataFlow.MQNAME), 0, -1 );
        registerDependency(this.dOccurenceDep);

        this.eOccurenceDep = new EOccurenceSmDependency();
        this.eOccurenceDep.init("EOccurence", this, metamodel.getMClass(Event.MQNAME), 0, -1 );
        registerDependency(this.eOccurenceDep);

        this.baseDep = new BaseSmDependency();
        this.baseDep.init("Base", this, metamodel.getMClass(GeneralClass.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.baseDep);

        this.receiverDep = new ReceiverSmDependency();
        this.receiverDep.init("Receiver", this, metamodel.getMClass(AcceptSignalAction.MQNAME), 0, -1 );
        registerDependency(this.receiverDep);

    }

    @objid ("70d76c3e-0486-472f-a613-2d5319d18c1e")
    public SmAttribute getIsEventAtt() {
        if (this.isEventAtt == null) {
        	this.isEventAtt = this.getAttributeDef("IsEvent");
        }
        return this.isEventAtt;
    }

    @objid ("f3ebc9be-e890-488d-b320-788837461499")
    public SmAttribute getIsExceptionAtt() {
        if (this.isExceptionAtt == null) {
        	this.isExceptionAtt = this.getAttributeDef("IsException");
        }
        return this.isExceptionAtt;
    }

    @objid ("53b0bed3-b48b-4e53-8059-f6fc7d5aee53")
    public SmDependency getSenderDep() {
        if (this.senderDep == null) {
        	this.senderDep = this.getDependencyDef("Sender");
        }
        return this.senderDep;
    }

    @objid ("50bee845-4bb8-450e-ba16-dca3fa391be7")
    public SmDependency getUsageDep() {
        if (this.usageDep == null) {
        	this.usageDep = this.getDependencyDef("Usage");
        }
        return this.usageDep;
    }

    @objid ("030e73b1-4655-48eb-bd5f-f1260d989924")
    public SmDependency getSendsDep() {
        if (this.sendsDep == null) {
        	this.sendsDep = this.getDependencyDef("Sends");
        }
        return this.sendsDep;
    }

    @objid ("477ad8e3-bb38-4478-bf9f-69340a6fb884")
    public SmDependency getPBaseDep() {
        if (this.pBaseDep == null) {
        	this.pBaseDep = this.getDependencyDef("PBase");
        }
        return this.pBaseDep;
    }

    @objid ("43aff76a-ef79-4450-b74d-a623537b744c")
    public SmDependency getOBaseDep() {
        if (this.oBaseDep == null) {
        	this.oBaseDep = this.getDependencyDef("OBase");
        }
        return this.oBaseDep;
    }

    @objid ("98f1bbf8-96e3-4060-9bc2-b8876a698155")
    public SmDependency getCommunicationUsageDep() {
        if (this.communicationUsageDep == null) {
        	this.communicationUsageDep = this.getDependencyDef("CommunicationUsage");
        }
        return this.communicationUsageDep;
    }

    @objid ("4c24fbf3-dcfc-4d6a-b84d-7f7e39b4b0a0")
    public SmDependency getDOccurenceDep() {
        if (this.dOccurenceDep == null) {
        	this.dOccurenceDep = this.getDependencyDef("DOccurence");
        }
        return this.dOccurenceDep;
    }

    @objid ("4eec8358-ebe5-416e-9973-3649f4d64bdf")
    public SmDependency getEOccurenceDep() {
        if (this.eOccurenceDep == null) {
        	this.eOccurenceDep = this.getDependencyDef("EOccurence");
        }
        return this.eOccurenceDep;
    }

    @objid ("2fd5a2e4-676d-4568-af94-29c6fd1bc683")
    public SmDependency getBaseDep() {
        if (this.baseDep == null) {
        	this.baseDep = this.getDependencyDef("Base");
        }
        return this.baseDep;
    }

    @objid ("a8a707e5-5fc6-4fde-9445-55c4ddcb605d")
    public SmDependency getReceiverDep() {
        if (this.receiverDep == null) {
        	this.receiverDep = this.getDependencyDef("Receiver");
        }
        return this.receiverDep;
    }

    @objid ("3ba2430c-09d1-4946-9777-83401ad9c533")
    private static class SignalObjectFactory implements ISmObjectFactory {
        @objid ("5b9839e0-593e-42e9-bb2a-23ba6561daf4")
        private SignalSmClass smClass;

        @objid ("dcd57494-76f1-405f-8893-fd410bc02182")
        public SignalObjectFactory(SignalSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c0139e3a-7c4a-4adc-b8c0-fe8fc3fff8e5")
        @Override
        public ISmObjectData createData() {
            return new SignalData(this.smClass);
        }

        @objid ("21936b84-73ab-4966-96ae-953e9f22ae8c")
        @Override
        public SmObjectImpl createImpl() {
            return new SignalImpl();
        }

    }

    @objid ("a56c3c15-9342-4747-b0ca-e298b7138701")
    public static class IsEventSmAttribute extends SmAttribute {
        @objid ("7d4beb8e-e9ac-4241-bf3c-e29621920afd")
        public Object getValue(ISmObjectData data) {
            return ((SignalData) data).mIsEvent;
        }

        @objid ("5218cb70-885b-4333-9ee6-18eaeeb0af9c")
        public void setValue(ISmObjectData data, Object value) {
            ((SignalData) data).mIsEvent = value;
        }

    }

    @objid ("f4ee493b-ad84-422e-9a01-48c812f6db66")
    public static class IsExceptionSmAttribute extends SmAttribute {
        @objid ("a7dd5629-ffe9-401b-ba2c-5d8babb2e505")
        public Object getValue(ISmObjectData data) {
            return ((SignalData) data).mIsException;
        }

        @objid ("d9478d0c-7dfa-4be4-a589-39cd4288cb49")
        public void setValue(ISmObjectData data, Object value) {
            ((SignalData) data).mIsException = value;
        }

    }

    @objid ("6d9d7aa0-6e68-49bd-a7a1-1fad7a56d11c")
    public static class SenderSmDependency extends SmMultipleDependency {
        @objid ("bfe78beb-ae7c-4fdf-a209-6999f578c8cc")
        private SmDependency symetricDep;

        @objid ("ec7e3508-6780-427f-b743-f38f4eccc2ca")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mSender != null)? ((SignalData)data).mSender:SmMultipleDependency.EMPTY;
        }

        @objid ("35b263ec-64a6-4bc1-b42c-076fc9ee3c7b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mSender = values;

        }

        @objid ("d50fbc48-fd1c-4d21-aa2c-8ea18cb1d45d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SendSignalActionSmClass)this.getTarget()).getSentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("57404396-1af6-4b15-8ce1-fcf10ef2e48f")
    public static class UsageSmDependency extends SmMultipleDependency {
        @objid ("433150e2-dc4e-4a60-a112-4b6ba8f61edb")
        private SmDependency symetricDep;

        @objid ("3869a696-ef10-41f1-995b-e73459e21099")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mUsage != null)? ((SignalData)data).mUsage:SmMultipleDependency.EMPTY;
        }

        @objid ("be6874f5-32c3-4e1e-ad7a-a0e306825233")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mUsage = values;

        }

        @objid ("bfa034ef-d185-4070-b7e2-ab25e4e35712")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageSmClass)this.getTarget()).getSignalSignatureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ba32e524-19b6-46b7-b166-5f67b54c7051")
    public static class SendsSmDependency extends SmMultipleDependency {
        @objid ("00b4b071-aa1f-49f2-9d02-e8a852a17909")
        private SmDependency symetricDep;

        @objid ("f149cc2a-f332-45eb-89ce-cbd62f14eaeb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mSends != null)? ((SignalData)data).mSends:SmMultipleDependency.EMPTY;
        }

        @objid ("550e064a-6b4c-4002-9b19-fee028257bcc")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mSends = values;

        }

        @objid ("c4b23640-78e2-41a8-894c-c66d5cd1876d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((TransitionSmClass)this.getTarget()).getEffectsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("77b841b6-d61e-43e2-83ac-11e9787b52d2")
    public static class PBaseSmDependency extends SmSingleDependency {
        @objid ("72136778-fab3-4e73-8910-7588ebd953a2")
        private SmDependency symetricDep;

        @objid ("355847c8-53af-46bf-94ad-ff619cf23368")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SignalData) data).mPBase;
        }

        @objid ("a08c9038-7434-48a7-8779-298c8dedc24b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SignalData) data).mPBase = value;
        }

        @objid ("159d4ad9-cbdd-485b-b12c-64b5330ed012")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getSRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f9c16009-4dc4-449c-8c18-daf7c524dd2d")
    public static class OBaseSmDependency extends SmSingleDependency {
        @objid ("4d17aacd-75c2-4229-b1de-c5acd44d748a")
        private SmDependency symetricDep;

        @objid ("a6aa2dc4-d12e-4f0c-b637-41c19433811e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SignalData) data).mOBase;
        }

        @objid ("f13b4e48-4b35-41a7-bc0f-078aafb7113a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SignalData) data).mOBase = value;
        }

        @objid ("8ea04525-d7f1-4d97-b21f-37318a5fe2ee")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getSRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c72144a3-3ab3-43e9-b468-edb35a23b062")
    public static class CommunicationUsageSmDependency extends SmMultipleDependency {
        @objid ("6c939a03-4ec7-4f5d-8a45-939f059c987c")
        private SmDependency symetricDep;

        @objid ("2a323254-e1a8-46a1-a016-c2c8379860ac")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mCommunicationUsage != null)? ((SignalData)data).mCommunicationUsage:SmMultipleDependency.EMPTY;
        }

        @objid ("a46cf6e8-8f7b-47c1-92ff-1d45b76e591f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mCommunicationUsage = values;

        }

        @objid ("21556bc1-cd25-4c4e-9dc8-7e0d30374c89")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationMessageSmClass)this.getTarget()).getSignalSignatureDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("549e91d1-cb9b-4bc1-8e09-779123cb3322")
    public static class DOccurenceSmDependency extends SmMultipleDependency {
        @objid ("c89deccf-ef67-4921-b49c-c9907b67cd8b")
        private SmDependency symetricDep;

        @objid ("ccff93b9-9c13-43de-a9eb-96161f6230b5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mDOccurence != null)? ((SignalData)data).mDOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("4219586d-0180-47b3-b628-50c71747d8f7")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mDOccurence = values;

        }

        @objid ("1a80b6d4-6b56-408b-a063-c5ccbd637504")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((DataFlowSmClass)this.getTarget()).getSModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("6a55a261-acef-47c2-a2eb-95fb6140afc3")
    public static class EOccurenceSmDependency extends SmMultipleDependency {
        @objid ("420627cd-a213-4e29-8e02-a5d127b67b29")
        private SmDependency symetricDep;

        @objid ("83c58de7-2513-4ba2-a16c-60930f694813")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mEOccurence != null)? ((SignalData)data).mEOccurence:SmMultipleDependency.EMPTY;
        }

        @objid ("708cd609-8864-45d1-93be-cc906d8b5a7a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mEOccurence = values;

        }

        @objid ("f00815c8-e278-41cd-9575-b29184c1e567")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EventSmClass)this.getTarget()).getModelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4dc26df6-6355-4b79-abfb-358ad21a5b81")
    public static class BaseSmDependency extends SmSingleDependency {
        @objid ("25e62267-c9bf-429e-8728-eff553a0df40")
        private SmDependency symetricDep;

        @objid ("04c2dcb3-1b6d-4d77-8ff1-845d4f199836")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((SignalData) data).mBase;
        }

        @objid ("6b65e178-df70-421c-9107-0177a15fd13d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((SignalData) data).mBase = value;
        }

        @objid ("fe97a467-bf7b-434f-9142-6b33da26211e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GeneralClassSmClass)this.getTarget()).getSRepresentationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4984f7b2-1a0b-4cf0-a300-ec0a49611c17")
    public static class ReceiverSmDependency extends SmMultipleDependency {
        @objid ("14f5d0ef-e6c4-49bf-a767-87d740cbaf3e")
        private SmDependency symetricDep;

        @objid ("80f83820-e2ca-4e49-bbf3-65101f975f93")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((SignalData)data).mReceiver != null)? ((SignalData)data).mReceiver:SmMultipleDependency.EMPTY;
        }

        @objid ("61461693-e89b-4b55-81cf-786011c07dc5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((SignalData) data).mReceiver = values;

        }

        @objid ("2a8bbf59-44dc-4ebb-8167-8e92ad7078f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AcceptSignalActionSmClass)this.getTarget()).getAcceptedDep();
            }
            return this.symetricDep;

        }

    }

}
