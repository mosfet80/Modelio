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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.EventSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.OperationSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Event;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Transition;
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
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("c656dbc6-a3e5-494e-a3e2-69a0638466d7")
public class TransitionSmClass extends UmlModelElementSmClass {
    @objid ("5fdf178e-9c93-4fb2-9736-281792c8af53")
    private SmAttribute effectAtt;

    @objid ("ed3b9038-5fc6-48d2-a318-c3260e3ab96f")
    private SmAttribute receivedEventsAtt;

    @objid ("8f810dff-8ed3-4e1b-90db-bd6e673bb28b")
    private SmAttribute sentEventsAtt;

    @objid ("3d5b7e83-d199-4948-844e-78ffa6b94a66")
    private SmAttribute guardAtt;

    @objid ("9923ef6d-bb38-4960-8aad-4a91e753aed5")
    private SmAttribute postConditionAtt;

    @objid ("8c845c33-eda1-4290-abf0-6a2edda72e91")
    private SmDependency processedDep;

    @objid ("75c77db9-2a4b-47f2-84ad-1e479bd8eac3")
    private SmDependency triggerDep;

    @objid ("24116c0c-92b9-4dff-8b47-a10a51d1968b")
    private SmDependency behaviorEffectDep;

    @objid ("44c675a6-b527-45bb-9f17-4325e441f9f1")
    private SmDependency targetDep;

    @objid ("6061b60b-d7a0-4350-9910-4c55bc34a2d6")
    private SmDependency sourceDep;

    @objid ("e99d855b-d309-4711-a73a-33b3acf56633")
    private SmDependency effectsDep;

    @objid ("60cffa80-80d3-417c-ac4c-4af2a2fe267d")
    public TransitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("fd011718-6030-40bc-841a-1bb04a0a6171")
    @Override
    public String getName() {
        return "Transition";

    }

    @objid ("e517b996-bdb0-4830-a407-355fcbbeafb8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1bf75202-c15f-4021-b270-5eefb93d0d03")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Transition.class;

    }

    @objid ("ee5d3cfd-7209-44a3-acec-bf883731136e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("343d0a7c-9101-462b-a9d8-b7c10dc9cb91")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("9ae13977-4674-4eb0-b33a-2ecefbc0b740")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new TransitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.effectAtt = new EffectSmAttribute();
        this.effectAtt.init("Effect", this, String.class );
        registerAttribute(this.effectAtt);

        this.receivedEventsAtt = new ReceivedEventsSmAttribute();
        this.receivedEventsAtt.init("ReceivedEvents", this, String.class );
        registerAttribute(this.receivedEventsAtt);

        this.sentEventsAtt = new SentEventsSmAttribute();
        this.sentEventsAtt.init("SentEvents", this, String.class );
        registerAttribute(this.sentEventsAtt);

        this.guardAtt = new GuardSmAttribute();
        this.guardAtt.init("Guard", this, String.class );
        registerAttribute(this.guardAtt);

        this.postConditionAtt = new PostConditionSmAttribute();
        this.postConditionAtt.init("PostCondition", this, String.class );
        registerAttribute(this.postConditionAtt);


        // Initialize and register the SmDependency
        this.processedDep = new ProcessedSmDependency();
        this.processedDep.init("Processed", this, metamodel.getMClass(Operation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.processedDep);

        this.triggerDep = new TriggerSmDependency();
        this.triggerDep.init("Trigger", this, metamodel.getMClass(Event.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.triggerDep);

        this.behaviorEffectDep = new BehaviorEffectSmDependency();
        this.behaviorEffectDep.init("BehaviorEffect", this, metamodel.getMClass(Behavior.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.behaviorEffectDep);

        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(StateVertex.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(StateVertex.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.sourceDep);

        this.effectsDep = new EffectsSmDependency();
        this.effectsDep.init("Effects", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.effectsDep);

    }

    @objid ("7ecc039e-a011-42f7-8225-56f62e3160d7")
    public SmAttribute getEffectAtt() {
        if (this.effectAtt == null) {
        	this.effectAtt = this.getAttributeDef("Effect");
        }
        return this.effectAtt;
    }

    @objid ("f53353be-ebfc-40de-a248-b85eec103dc8")
    public SmAttribute getReceivedEventsAtt() {
        if (this.receivedEventsAtt == null) {
        	this.receivedEventsAtt = this.getAttributeDef("ReceivedEvents");
        }
        return this.receivedEventsAtt;
    }

    @objid ("c3d06670-86e4-4681-bca7-76888c1b1046")
    public SmAttribute getSentEventsAtt() {
        if (this.sentEventsAtt == null) {
        	this.sentEventsAtt = this.getAttributeDef("SentEvents");
        }
        return this.sentEventsAtt;
    }

    @objid ("e925c8cb-e2bb-4ed4-aae8-dc1ed8cc823a")
    public SmAttribute getGuardAtt() {
        if (this.guardAtt == null) {
        	this.guardAtt = this.getAttributeDef("Guard");
        }
        return this.guardAtt;
    }

    @objid ("280ff967-f65c-41e2-8ca6-298327000783")
    public SmAttribute getPostConditionAtt() {
        if (this.postConditionAtt == null) {
        	this.postConditionAtt = this.getAttributeDef("PostCondition");
        }
        return this.postConditionAtt;
    }

    @objid ("3d3ab4dc-1aaf-4e76-ae6c-637d477a34e0")
    public SmDependency getProcessedDep() {
        if (this.processedDep == null) {
        	this.processedDep = this.getDependencyDef("Processed");
        }
        return this.processedDep;
    }

    @objid ("5534a15f-0d51-4b2c-9f06-cb8bb91b2e65")
    public SmDependency getTriggerDep() {
        if (this.triggerDep == null) {
        	this.triggerDep = this.getDependencyDef("Trigger");
        }
        return this.triggerDep;
    }

    @objid ("31bfe3fa-a623-4eb7-9da2-9e1fa34d0dc2")
    public SmDependency getBehaviorEffectDep() {
        if (this.behaviorEffectDep == null) {
        	this.behaviorEffectDep = this.getDependencyDef("BehaviorEffect");
        }
        return this.behaviorEffectDep;
    }

    @objid ("69cbd712-10e0-413a-ad7d-312c6d051df4")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("c1ea5492-8a04-487a-b7be-b81aa86adbb5")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("9a4c7ce8-09ed-44ac-884c-2c7e51780edf")
    public SmDependency getEffectsDep() {
        if (this.effectsDep == null) {
        	this.effectsDep = this.getDependencyDef("Effects");
        }
        return this.effectsDep;
    }

    @objid ("88da520c-aea7-4bcc-b139-f636eb7ace8c")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("dad83e8a-7d34-4663-9de2-371993220e25")
    private static class TransitionObjectFactory implements ISmObjectFactory {
        @objid ("6a8d0de6-3181-467c-befb-c838b2eceb0b")
        private TransitionSmClass smClass;

        @objid ("42fb6ee7-3176-467c-8106-666ab8ce733b")
        public TransitionObjectFactory(TransitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7bdeb886-f428-41e1-8341-44c7bbcdaf96")
        @Override
        public ISmObjectData createData() {
            return new TransitionData(this.smClass);
        }

        @objid ("0ed02e19-9f53-4cbc-808a-f7fd046aa5de")
        @Override
        public SmObjectImpl createImpl() {
            return new TransitionImpl();
        }

    }

    @objid ("74d944b7-be71-4b13-89f6-4b6e8051d99c")
    public static class EffectSmAttribute extends SmAttribute {
        @objid ("8c2b49d9-a385-4adf-aab0-6e7ddef4d248")
        public Object getValue(ISmObjectData data) {
            return ((TransitionData) data).mEffect;
        }

        @objid ("cd23eb77-88d0-483a-bd9f-9a2f49bdfafd")
        public void setValue(ISmObjectData data, Object value) {
            ((TransitionData) data).mEffect = value;
        }

    }

    @objid ("fcda15cf-e212-4cf5-a618-c7c47ef10072")
    public static class ReceivedEventsSmAttribute extends SmAttribute {
        @objid ("85586835-f68e-40d9-b37a-d8b85b2d224a")
        public Object getValue(ISmObjectData data) {
            return ((TransitionData) data).mReceivedEvents;
        }

        @objid ("3b9dab17-308d-454c-ac5c-a54803b1c135")
        public void setValue(ISmObjectData data, Object value) {
            ((TransitionData) data).mReceivedEvents = value;
        }

    }

    @objid ("016eb7d6-021f-49c5-a614-90263fb4782f")
    public static class SentEventsSmAttribute extends SmAttribute {
        @objid ("ba62c169-b3f3-48d6-ab65-eb30769ddc2c")
        public Object getValue(ISmObjectData data) {
            return ((TransitionData) data).mSentEvents;
        }

        @objid ("ffe46a78-350f-4bac-96e8-fdcc896f3919")
        public void setValue(ISmObjectData data, Object value) {
            ((TransitionData) data).mSentEvents = value;
        }

    }

    @objid ("0d089469-cf77-4af9-8c90-5130e3418ebe")
    public static class GuardSmAttribute extends SmAttribute {
        @objid ("9956ed32-bcf5-42a7-a346-23c2a7d89056")
        public Object getValue(ISmObjectData data) {
            return ((TransitionData) data).mGuard;
        }

        @objid ("1ae74439-aef7-464e-8879-c8c4d087800d")
        public void setValue(ISmObjectData data, Object value) {
            ((TransitionData) data).mGuard = value;
        }

    }

    @objid ("717dbbb7-4391-436b-8f41-e20009c33821")
    public static class PostConditionSmAttribute extends SmAttribute {
        @objid ("5babe33b-737b-4523-a97d-378da33f8525")
        public Object getValue(ISmObjectData data) {
            return ((TransitionData) data).mPostCondition;
        }

        @objid ("40c72e20-5d5b-49ad-a7d5-8244b693585e")
        public void setValue(ISmObjectData data, Object value) {
            ((TransitionData) data).mPostCondition = value;
        }

    }

    @objid ("45626cae-eaa7-4bcc-bbc8-2aedde223c34")
    public static class ProcessedSmDependency extends SmSingleDependency {
        @objid ("db7c610d-c12c-4387-85ff-96f47917486d")
        private SmDependency symetricDep;

        @objid ("371b184b-c751-4f75-b488-2ba004c89f49")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mProcessed;
        }

        @objid ("f42c6089-7656-457a-8e26-2337ac4556e1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mProcessed = value;
        }

        @objid ("3588a5a4-5ba9-4c26-b067-2ef8035fa30b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((OperationSmClass)this.getTarget()).getInvokerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("536c33f2-aff9-4c5c-a3b4-c319cc6ac058")
    public static class TriggerSmDependency extends SmSingleDependency {
        @objid ("27e2c40c-942d-4680-bfc5-566694731ff0")
        private SmDependency symetricDep;

        @objid ("de29007e-cf42-4499-8244-c83bd6e1ce04")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mTrigger;
        }

        @objid ("82e44c3d-b202-4ec9-bcfd-4d34a4f42faa")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mTrigger = value;
        }

        @objid ("47a6460f-e49e-4288-8f17-2efd903e8571")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EventSmClass)this.getTarget()).getTriggeredDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8a8b114a-7b85-4d7c-b991-e88620616ac1")
    public static class BehaviorEffectSmDependency extends SmSingleDependency {
        @objid ("b5c1d425-d553-4a73-8556-45c822e713ea")
        private SmDependency symetricDep;

        @objid ("3981f24b-8bae-4561-8154-4f6a95399ae0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mBehaviorEffect;
        }

        @objid ("1fc147a9-4716-4a5e-866e-ca55c4133ce4")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mBehaviorEffect = value;
        }

        @objid ("80e9349f-94e4-4de4-8f6a-c0f2a8d57974")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getEffectOfDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3cbe8256-6d5c-494e-ab29-52426677408c")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("d0fe6082-5b74-421c-b305-77728de6ea9c")
        private SmDependency symetricDep;

        @objid ("76340202-8622-4b7f-9b98-e1b1b836697c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mTarget;
        }

        @objid ("c63d3a98-8d01-4111-ab6f-ed9f01ac96d5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mTarget = value;
        }

        @objid ("ecfb2ac4-d4e0-4dc1-89bd-e52cd91022a7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateVertexSmClass)this.getTarget()).getIncomingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("96508fd6-a30f-4c56-844c-bda949199949")
    public static class SourceSmDependency extends SmSingleDependency {
        @objid ("51f57eaf-d001-4d7c-ba61-d5d4237f8b87")
        private SmDependency symetricDep;

        @objid ("00668643-434b-4240-89a6-9ad5509cb1c6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mSource;
        }

        @objid ("ad7a7faf-67f9-4644-8cec-57a37912759b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mSource = value;
        }

        @objid ("505f884d-b111-43bf-a0c4-8a8850b48256")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateVertexSmClass)this.getTarget()).getOutGoingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a5aaa978-27bc-4509-963d-a9b13ec9fbf9")
    public static class EffectsSmDependency extends SmSingleDependency {
        @objid ("989905b4-8e8b-4e36-b7de-a97508c100ea")
        private SmDependency symetricDep;

        @objid ("cbd2fb42-bae0-4b2c-aafe-ce276ffb3a25")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((TransitionData) data).mEffects;
        }

        @objid ("7d79d943-ca38-4af0-891e-2b3a195bb6f7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((TransitionData) data).mEffects = value;
        }

        @objid ("9fbf6625-c5b1-4a12-8648-26e2cd6a7512")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getSendsDep();
            }
            return this.symetricDep;

        }

    }

}
