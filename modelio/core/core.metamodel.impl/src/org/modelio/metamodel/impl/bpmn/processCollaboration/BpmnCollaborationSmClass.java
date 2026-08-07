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
package org.modelio.metamodel.impl.bpmn.processCollaboration;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageFlowSmClass;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnArtifactSmClass;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
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

@objid ("35abebd8-3162-4403-be18-3ed37e7f8391")
public class BpmnCollaborationSmClass extends BehaviorSmClass {
    @objid ("315d8330-9cfb-4528-97d5-d89bbf9199b0")
    private SmAttribute isClosedAtt;

    @objid ("e774b281-2bfe-4c40-97d4-af2abb01d101")
    private SmDependency artifactDep;

    @objid ("0eeb8bc6-0810-4783-ab27-5384240b5fe5")
    private SmDependency messageFlowDep;

    @objid ("f02b8ef1-caa9-4347-9bf4-5e0677fb8110")
    private SmDependency participantsDep;

    @objid ("7fe90a2a-3c45-4e74-acec-0a614c90417d")
    private SmDependency messagesDep;

    @objid ("b547e45d-39a4-4b5e-b9e7-648e9fb1b07e")
    private SmDependency definedProcessDep;

    @objid ("44432ff8-8402-48f8-9c64-8a9530ef472a")
    public BpmnCollaborationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8163b22b-7939-4659-b16d-232c29832927")
    @Override
    public String getName() {
        return "BpmnCollaboration";

    }

    @objid ("bf024a40-e4b8-4eae-828c-e16de7d939b2")
    @Override
    public Version getVersion() {
        return new Version("2.2.00");
    }

    @objid ("1e3bf4f2-0ac1-4d1e-93c3-887d2a2b615f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCollaboration.class;

    }

    @objid ("951b5e2e-0206-4ba4-9df9-9cebb53e015d")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("2b339815-7a35-45f9-8c66-010ae97b878c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0b1b7ca2-48f3-483d-87fa-bf8dfff01aa7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new BpmnCollaborationObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isClosedAtt = new IsClosedSmAttribute();
        this.isClosedAtt.init("IsClosed", this, Boolean.class );
        registerAttribute(this.isClosedAtt);


        // Initialize and register the SmDependency
        this.artifactDep = new ArtifactSmDependency();
        this.artifactDep.init("Artifact", this, metamodel.getMClass(BpmnArtifact.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.artifactDep);

        this.messageFlowDep = new MessageFlowSmDependency();
        this.messageFlowDep.init("MessageFlow", this, metamodel.getMClass(BpmnMessageFlow.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.messageFlowDep);

        this.participantsDep = new ParticipantsSmDependency();
        this.participantsDep.init("Participants", this, metamodel.getMClass(BpmnParticipant.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.participantsDep);

        this.messagesDep = new MessagesSmDependency();
        this.messagesDep.init("Messages", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.messagesDep);

        this.definedProcessDep = new DefinedProcessSmDependency();
        this.definedProcessDep.init("DefinedProcess", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, 1 );
        registerDependency(this.definedProcessDep);

    }

    @objid ("5b5f4e23-4e5c-46b5-92bc-1fc875243a06")
    public SmAttribute getIsClosedAtt() {
        if (this.isClosedAtt == null) {
        	this.isClosedAtt = this.getAttributeDef("IsClosed");
        }
        return this.isClosedAtt;
    }

    @objid ("c91ecc76-59d4-4dd2-94c7-71a7c8533c4b")
    public SmDependency getArtifactDep() {
        if (this.artifactDep == null) {
        	this.artifactDep = this.getDependencyDef("Artifact");
        }
        return this.artifactDep;
    }

    @objid ("988854e2-e837-40fa-a71f-a081d0008c54")
    public SmDependency getMessageFlowDep() {
        if (this.messageFlowDep == null) {
        	this.messageFlowDep = this.getDependencyDef("MessageFlow");
        }
        return this.messageFlowDep;
    }

    @objid ("631838b8-baee-4363-a048-ba09cd6608fc")
    public SmDependency getParticipantsDep() {
        if (this.participantsDep == null) {
        	this.participantsDep = this.getDependencyDef("Participants");
        }
        return this.participantsDep;
    }

    @objid ("5f5ee325-abb1-457d-8508-7ee3572fca75")
    public SmDependency getMessagesDep() {
        if (this.messagesDep == null) {
        	this.messagesDep = this.getDependencyDef("Messages");
        }
        return this.messagesDep;
    }

    @objid ("534db366-63e4-4b24-b04b-ae72c9f36504")
    public SmDependency getDefinedProcessDep() {
        if (this.definedProcessDep == null) {
        	this.definedProcessDep = this.getDependencyDef("DefinedProcess");
        }
        return this.definedProcessDep;
    }

    @objid ("218e65fa-7f2e-40b1-817d-38b85b6fe210")
    private static class BpmnCollaborationObjectFactory implements ISmObjectFactory {
        @objid ("390cd8db-c411-4d4f-ace9-bc184e563ed3")
        private BpmnCollaborationSmClass smClass;

        @objid ("934e7c06-b105-4ad1-a09a-4083c1214a0e")
        public BpmnCollaborationObjectFactory(BpmnCollaborationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("dd03ba17-e212-4e18-a8bf-ed5d744425f8")
        @Override
        public ISmObjectData createData() {
            return new BpmnCollaborationData(this.smClass);
        }

        @objid ("60a4590d-2ef0-4ca9-9d88-3b010e554656")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnCollaborationImpl();
        }

    }

    @objid ("1a7e9c6c-6cfe-4d80-898c-621dbea777c4")
    public static class IsClosedSmAttribute extends SmAttribute {
        @objid ("67f25ce9-8f99-4c44-b532-8401876f8272")
        public Object getValue(ISmObjectData data) {
            return ((BpmnCollaborationData) data).mIsClosed;
        }

        @objid ("d49d875c-32ee-492c-b6c9-4d92dcd32b6f")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnCollaborationData) data).mIsClosed = value;
        }

    }

    @objid ("a3ee30a5-ee6d-40c4-a5cf-0537345a9ce3")
    public static class ArtifactSmDependency extends SmMultipleDependency {
        @objid ("25262b26-7b24-4f01-80e6-e78488c0b245")
        private SmDependency symetricDep;

        @objid ("3bbf051d-84b8-49e3-8f5d-9107e4718149")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnCollaborationData)data).mArtifact != null)? ((BpmnCollaborationData)data).mArtifact:SmMultipleDependency.EMPTY;
        }

        @objid ("04f7d27a-68d1-448b-9640-2b4982f623c2")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnCollaborationData) data).mArtifact = values;

        }

        @objid ("00efdba2-5974-4578-aa62-2151d2a79ca9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnArtifactSmClass)this.getTarget()).getCollaborationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b0101681-fc58-423a-b996-bf5a613aab5f")
    public static class MessageFlowSmDependency extends SmMultipleDependency {
        @objid ("9819dd4f-5f40-42c5-abfe-3632371868ad")
        private SmDependency symetricDep;

        @objid ("48480cfa-8e4b-4342-85e8-d29fc58b8a86")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnCollaborationData)data).mMessageFlow != null)? ((BpmnCollaborationData)data).mMessageFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("e1e2f8c9-74ff-44e1-b49b-c5dc200ceb31")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnCollaborationData) data).mMessageFlow = values;

        }

        @objid ("391bd57a-4699-4371-9b40-5eecf0aba7a5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageFlowSmClass)this.getTarget()).getCollaborationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("408f34e8-65d7-4852-be8d-04ddd299da51")
    public static class ParticipantsSmDependency extends SmMultipleDependency {
        @objid ("0244a7fb-67b1-4b60-a8cd-b92d031363db")
        private SmDependency symetricDep;

        @objid ("992d1da6-5ec5-443f-bee5-bb212e33cec5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnCollaborationData)data).mParticipants != null)? ((BpmnCollaborationData)data).mParticipants:SmMultipleDependency.EMPTY;
        }

        @objid ("d4ef27ce-0a52-4686-9f4c-0953c378cdfe")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnCollaborationData) data).mParticipants = values;

        }

        @objid ("e563d49d-e750-4cd8-8669-1a13e32fb8ad")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnParticipantSmClass)this.getTarget()).getContainerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("964a747b-62e1-4d65-8a17-009d205e31a5")
    public static class MessagesSmDependency extends SmMultipleDependency {
        @objid ("e2e87d4c-4fba-4ddc-8508-b659c3988bfd")
        private SmDependency symetricDep;

        @objid ("c0d54f6f-5806-4389-b7ba-cc8c8e4310a1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnCollaborationData)data).mMessages != null)? ((BpmnCollaborationData)data).mMessages:SmMultipleDependency.EMPTY;
        }

        @objid ("61f617bc-5969-47f5-b390-8b2a15372514")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnCollaborationData) data).mMessages = values;

        }

        @objid ("e111c2a1-8743-4dd4-acca-587f251a184c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getCollaborationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("be6a8ba5-f788-4257-bcf8-b096437439cc")
    public static class DefinedProcessSmDependency extends SmSingleDependency {
        @objid ("2bb12b72-2c16-446e-a797-69d5ddd970fc")
        private SmDependency symetricDep;

        @objid ("39ef116e-4fb4-4d87-ae5e-bc7ded6bbe0a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnCollaborationData) data).mDefinedProcess;
        }

        @objid ("cc3b2390-4d38-40bb-a57c-d42e508c248f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnCollaborationData) data).mDefinedProcess = value;
        }

        @objid ("b82a1f3e-0abc-416e-8061-cfda0e6cfcad")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getDefinitionalCollaborationDep();
            }
            return this.symetricDep;

        }

    }

}
