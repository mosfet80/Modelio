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
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnLaneSet;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnParticipant;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcess;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnProcessType;
import org.modelio.metamodel.bpmn.processCollaboration.OptionalBoolean;
import org.modelio.metamodel.bpmn.resources.BpmnResourceRole;
import org.modelio.metamodel.bpmn.rootElements.BpmnArtifact;
import org.modelio.metamodel.bpmn.rootElements.BpmnFlowElement;
import org.modelio.metamodel.impl.bpmn.resources.BpmnResourceRoleSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnArtifactSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnFlowElementSmClass;
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

@objid ("4d8f32f6-a792-47da-86c4-b3a00a3a56ce")
public class BpmnProcessSmClass extends BehaviorSmClass {
    @objid ("3201f1c8-05ab-47a7-be5b-13327a21fc2b")
    private SmAttribute processTypeAtt;

    @objid ("8c6fa5a4-c1d0-4bb0-9b31-2eae4fda1acb")
    private SmAttribute isClosedAtt;

    @objid ("fd83843a-bc8f-4837-83d8-fb53e8de9832")
    private SmAttribute isExecutableAtt;

    @objid ("185b4a1e-3674-4fe6-bbde-f9f51917d229")
    private SmDependency supportsDep;

    @objid ("083a65f7-7234-4ca6-b24a-b8994759ad3e")
    private SmDependency artifactDep;

    @objid ("bb3af411-8d78-451d-8d80-e9bfae7f2234")
    private SmDependency laneSetDep;

    @objid ("21234bd1-ebd7-4cb8-b1f6-a14671ef6299")
    private SmDependency supportedDep;

    @objid ("d4460c76-1f3c-42aa-951a-542cb0e3e6fa")
    private SmDependency participantDep;

    @objid ("05790329-2416-44fa-b736-e70744ff6f4e")
    private SmDependency flowElementDep;

    @objid ("69e84821-93c9-4aad-98b5-98fa76a99ab7")
    private SmDependency resourceDep;

    @objid ("1117b748-304a-4d1c-b9d4-7f9e3e033f33")
    private SmDependency definitionalCollaborationDep;

    @objid ("f56112ce-64f6-40aa-a418-69fe1fc316d7")
    public BpmnProcessSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0e2757ad-253a-4552-86e4-f72a8f5235a9")
    @Override
    public String getName() {
        return "BpmnProcess";

    }

    @objid ("63f031b5-a718-4817-a663-fa2c891a752b")
    @Override
    public Version getVersion() {
        return new Version("2.2.0");
    }

    @objid ("66eb3f81-0e65-48c2-87b3-8e6134a0bcd5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnProcess.class;

    }

    @objid ("806d9e2d-5647-4758-86f8-9ecec72d4e75")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("42f4341b-21d6-402c-b1b6-6fd58c387e24")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f58bdef7-2395-4df8-966d-e8593d4df319")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new BpmnProcessObjectFactory(this));


        // Initialize and register the SmAttribute
        this.processTypeAtt = new ProcessTypeSmAttribute();
        this.processTypeAtt.init("ProcessType", this, BpmnProcessType.class );
        registerAttribute(this.processTypeAtt);

        this.isClosedAtt = new IsClosedSmAttribute();
        this.isClosedAtt.init("IsClosed", this, Boolean.class );
        registerAttribute(this.isClosedAtt);

        this.isExecutableAtt = new IsExecutableSmAttribute();
        this.isExecutableAtt.init("IsExecutable", this, OptionalBoolean.class );
        registerAttribute(this.isExecutableAtt);


        // Initialize and register the SmDependency
        this.supportsDep = new SupportsSmDependency();
        this.supportsDep.init("Supports", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.supportsDep);

        this.artifactDep = new ArtifactSmDependency();
        this.artifactDep.init("Artifact", this, metamodel.getMClass(BpmnArtifact.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.artifactDep);

        this.laneSetDep = new LaneSetSmDependency();
        this.laneSetDep.init("LaneSet", this, metamodel.getMClass(BpmnLaneSet.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.laneSetDep);

        this.supportedDep = new SupportedSmDependency();
        this.supportedDep.init("Supported", this, metamodel.getMClass(BpmnProcess.MQNAME), 0, -1 );
        registerDependency(this.supportedDep);

        this.participantDep = new ParticipantSmDependency();
        this.participantDep.init("Participant", this, metamodel.getMClass(BpmnParticipant.MQNAME), 0, -1 );
        registerDependency(this.participantDep);

        this.flowElementDep = new FlowElementSmDependency();
        this.flowElementDep.init("FlowElement", this, metamodel.getMClass(BpmnFlowElement.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.flowElementDep);

        this.resourceDep = new ResourceSmDependency();
        this.resourceDep.init("Resource", this, metamodel.getMClass(BpmnResourceRole.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.resourceDep);

        this.definitionalCollaborationDep = new DefinitionalCollaborationSmDependency();
        this.definitionalCollaborationDep.init("DefinitionalCollaboration", this, metamodel.getMClass(BpmnCollaboration.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.definitionalCollaborationDep);

    }

    @objid ("34b12559-50ca-4018-81ba-81cc5d8a3d55")
    public SmAttribute getProcessTypeAtt() {
        if (this.processTypeAtt == null) {
        	this.processTypeAtt = this.getAttributeDef("ProcessType");
        }
        return this.processTypeAtt;
    }

    @objid ("e0143f1e-1314-40b8-acb5-cfa5b2747108")
    public SmAttribute getIsClosedAtt() {
        if (this.isClosedAtt == null) {
        	this.isClosedAtt = this.getAttributeDef("IsClosed");
        }
        return this.isClosedAtt;
    }

    @objid ("9de4c26b-5597-4d4b-abd2-7a5401860877")
    public SmAttribute getIsExecutableAtt() {
        if (this.isExecutableAtt == null) {
        	this.isExecutableAtt = this.getAttributeDef("IsExecutable");
        }
        return this.isExecutableAtt;
    }

    @objid ("97ea1669-3581-4e73-9445-a4b181be1a14")
    public SmDependency getSupportsDep() {
        if (this.supportsDep == null) {
        	this.supportsDep = this.getDependencyDef("Supports");
        }
        return this.supportsDep;
    }

    @objid ("951fb98f-c5da-4a59-9e94-377770914190")
    public SmDependency getArtifactDep() {
        if (this.artifactDep == null) {
        	this.artifactDep = this.getDependencyDef("Artifact");
        }
        return this.artifactDep;
    }

    @objid ("17829381-c01d-4ce1-a40b-f2701cb24604")
    public SmDependency getLaneSetDep() {
        if (this.laneSetDep == null) {
        	this.laneSetDep = this.getDependencyDef("LaneSet");
        }
        return this.laneSetDep;
    }

    @objid ("27bd0348-be08-4820-b06c-1436ebccf630")
    public SmDependency getSupportedDep() {
        if (this.supportedDep == null) {
        	this.supportedDep = this.getDependencyDef("Supported");
        }
        return this.supportedDep;
    }

    @objid ("ef016f20-b62d-4415-aa52-f1d129f66a32")
    public SmDependency getParticipantDep() {
        if (this.participantDep == null) {
        	this.participantDep = this.getDependencyDef("Participant");
        }
        return this.participantDep;
    }

    @objid ("bd9ebb70-6933-4eaa-98b5-2d7478bcad31")
    public SmDependency getFlowElementDep() {
        if (this.flowElementDep == null) {
        	this.flowElementDep = this.getDependencyDef("FlowElement");
        }
        return this.flowElementDep;
    }

    @objid ("15659ee6-ebee-42b8-ac11-6f47d7189eb5")
    public SmDependency getResourceDep() {
        if (this.resourceDep == null) {
        	this.resourceDep = this.getDependencyDef("Resource");
        }
        return this.resourceDep;
    }

    @objid ("ca8b7bae-b893-497a-a2ce-6f457967ef56")
    public SmDependency getDefinitionalCollaborationDep() {
        if (this.definitionalCollaborationDep == null) {
        	this.definitionalCollaborationDep = this.getDependencyDef("DefinitionalCollaboration");
        }
        return this.definitionalCollaborationDep;
    }

    @objid ("f3f347e0-16ec-4d4c-afb7-5e2e4c48709c")
    private static class BpmnProcessObjectFactory implements ISmObjectFactory {
        @objid ("a9f814d9-12e1-4ce9-817f-6cc49822d18c")
        private BpmnProcessSmClass smClass;

        @objid ("15a1b139-c560-4dee-9c4d-8cb0350f2469")
        public BpmnProcessObjectFactory(BpmnProcessSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f3c1735c-964f-4673-a514-236e89b91f9f")
        @Override
        public ISmObjectData createData() {
            return new BpmnProcessData(this.smClass);
        }

        @objid ("41c43ca6-a28c-453b-b2a9-d35f4527bb98")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnProcessImpl();
        }

    }

    @objid ("a57e3303-6b4b-431c-b2b8-92a64b45c0d7")
    public static class ProcessTypeSmAttribute extends SmAttribute {
        @objid ("21134226-aecd-4d34-bf04-d460288e1118")
        public Object getValue(ISmObjectData data) {
            return ((BpmnProcessData) data).mProcessType;
        }

        @objid ("26f080fb-11cd-45be-9e4c-f336385595f4")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnProcessData) data).mProcessType = value;
        }

    }

    @objid ("143117b3-5695-45b3-8f1f-587f7d69172e")
    public static class IsClosedSmAttribute extends SmAttribute {
        @objid ("9c34f8e0-10f7-4519-9289-88b77c58a274")
        public Object getValue(ISmObjectData data) {
            return ((BpmnProcessData) data).mIsClosed;
        }

        @objid ("f45b5195-54b9-4ab6-a15c-cc969224f7a0")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnProcessData) data).mIsClosed = value;
        }

    }

    @objid ("91507e3b-7ca8-4fbc-b093-3e9671869398")
    public static class IsExecutableSmAttribute extends SmAttribute {
        @objid ("b16dc9a9-8a59-4e89-967f-01036bccfcff")
        public Object getValue(ISmObjectData data) {
            return ((BpmnProcessData) data).mIsExecutable;
        }

        @objid ("ab51f72b-0efa-4844-acbe-266395d002f5")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnProcessData) data).mIsExecutable = value;
        }

    }

    @objid ("511b7545-1288-44cf-bae6-7e4649dfe482")
    public static class SupportsSmDependency extends SmMultipleDependency {
        @objid ("b7c11320-d770-4c6b-89d6-bcbf50732be6")
        private SmDependency symetricDep;

        @objid ("ca53bd12-675c-4b71-b59e-71ca29a90eb7")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mSupports != null)? ((BpmnProcessData)data).mSupports:SmMultipleDependency.EMPTY;
        }

        @objid ("5257b6b0-dfa1-48a2-9dfb-8a7117ab2cda")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mSupports = values;

        }

        @objid ("0419cc20-e106-4ada-9d83-32e85369bac7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getSupportedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("a0274f02-22e6-4ab4-b904-21ec3e0ce53b")
    public static class ArtifactSmDependency extends SmMultipleDependency {
        @objid ("db27abaf-c5d0-4840-aaed-fdb3b9086371")
        private SmDependency symetricDep;

        @objid ("c8d8632e-4c9d-4698-962d-fbf1dc89d1ff")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mArtifact != null)? ((BpmnProcessData)data).mArtifact:SmMultipleDependency.EMPTY;
        }

        @objid ("5ccb4f92-b971-44f9-bc00-28d0c9e8b418")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mArtifact = values;

        }

        @objid ("93027eb2-c1e6-4be2-a10e-0e43ae7b7236")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnArtifactSmClass)this.getTarget()).getProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b38536a6-9bf3-4c1a-a4ae-1dac1b8c6be1")
    public static class LaneSetSmDependency extends SmSingleDependency {
        @objid ("859656c4-138c-4251-9f4d-7e3405802924")
        private SmDependency symetricDep;

        @objid ("71f3693f-f581-49b7-b262-99d60f3cebfd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnProcessData) data).mLaneSet;
        }

        @objid ("3aac36fc-3aa7-4710-a56c-a4ed93fc00d8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnProcessData) data).mLaneSet = value;
        }

        @objid ("b3f238a2-3ed5-42c9-a0a1-9a6e26d903c6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLaneSetSmClass)this.getTarget()).getProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("343d4720-fea3-4786-b409-c9a0d3b6ac74")
    public static class SupportedSmDependency extends SmMultipleDependency {
        @objid ("fe5a7349-f83f-4303-95f2-99a76628bdf8")
        private SmDependency symetricDep;

        @objid ("791ae858-10d2-4051-8937-26cc7d99451e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mSupported != null)? ((BpmnProcessData)data).mSupported:SmMultipleDependency.EMPTY;
        }

        @objid ("faf2810a-2c86-46c4-b124-943d1f9145e0")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mSupported = values;

        }

        @objid ("e3a667f4-3466-4f7c-89d5-c9104c0c0e74")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnProcessSmClass)this.getTarget()).getSupportsDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4d9ba004-3a07-4c40-be74-246e21a33bbb")
    public static class ParticipantSmDependency extends SmMultipleDependency {
        @objid ("dd824424-6897-49f2-9372-c743657e12b3")
        private SmDependency symetricDep;

        @objid ("f1f1c19f-21d1-48c2-9ea1-bf5d727347fe")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mParticipant != null)? ((BpmnProcessData)data).mParticipant:SmMultipleDependency.EMPTY;
        }

        @objid ("e303f3a8-af22-488b-9134-f0f4437382a9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mParticipant = values;

        }

        @objid ("fb35c162-e325-477c-b596-efaa115f6c33")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnParticipantSmClass)this.getTarget()).getProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8a3d4ed6-d838-46be-978c-271a4631ec1c")
    public static class FlowElementSmDependency extends SmMultipleDependency {
        @objid ("12c596ef-3d85-4866-96cd-030ea6a8e3dc")
        private SmDependency symetricDep;

        @objid ("494302b2-00f6-4382-a492-280252d36cf2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mFlowElement != null)? ((BpmnProcessData)data).mFlowElement:SmMultipleDependency.EMPTY;
        }

        @objid ("c944f3d8-9404-46ac-b32c-b43a0846dbe8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mFlowElement = values;

        }

        @objid ("0493b658-26ff-45d8-ac4f-b615745a13d8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnFlowElementSmClass)this.getTarget()).getContainerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("871330b9-e143-42b1-bef5-f42a7f87cb5d")
    public static class ResourceSmDependency extends SmMultipleDependency {
        @objid ("c5be2892-acfa-48c6-b8ed-3dbd2d622099")
        private SmDependency symetricDep;

        @objid ("0df00d31-eb71-4d78-8a12-6989ea9f4af9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnProcessData)data).mResource != null)? ((BpmnProcessData)data).mResource:SmMultipleDependency.EMPTY;
        }

        @objid ("be251226-c864-4dac-99af-c04487c77628")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnProcessData) data).mResource = values;

        }

        @objid ("7047b2b3-c9a7-4ccf-bd34-2fdf977cc524")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnResourceRoleSmClass)this.getTarget()).getProcessDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e655a513-6f7f-41ec-9ff9-ebcab4c597bb")
    public static class DefinitionalCollaborationSmDependency extends SmSingleDependency {
        @objid ("296dcf59-f282-4142-85c3-2b6fb515ea39")
        private SmDependency symetricDep;

        @objid ("8560adc3-ac7b-42c7-a2e5-a64229d3cde2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnProcessData) data).mDefinitionalCollaboration;
        }

        @objid ("6dc1f6fc-ae80-4b26-bc3b-94bda2ff3dc9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnProcessData) data).mDefinitionalCollaboration = value;
        }

        @objid ("dbf9c2a7-c3b6-4527-869f-95e0761f9100")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCollaborationSmClass)this.getTarget()).getDefinedProcessDep();
            }
            return this.symetricDep;

        }

    }

}
