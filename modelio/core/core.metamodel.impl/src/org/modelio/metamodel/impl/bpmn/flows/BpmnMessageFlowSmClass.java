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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.bpmn.flows.BpmnMessageFlow;
import org.modelio.metamodel.bpmn.processCollaboration.BpmnCollaboration;
import org.modelio.metamodel.bpmn.rootElements.BpmnBaseElement;
import org.modelio.metamodel.impl.bpmn.processCollaboration.BpmnCollaborationSmClass;
import org.modelio.metamodel.impl.bpmn.rootElements.BpmnBaseElementSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("3eea7bbe-61b6-445e-80b8-5f370b8b7e4b")
public class BpmnMessageFlowSmClass extends BpmnBaseElementSmClass {
    @objid ("3e78c53a-d205-441e-af3a-eb9e3c23f2aa")
    private SmDependency messageRefDep;

    @objid ("0dd0ed09-710c-4e38-b8ee-5dfcfd9724eb")
    private SmDependency sourceRefDep;

    @objid ("d4dbde3b-670d-44e7-856c-322cf07db6c2")
    private SmDependency targetRefDep;

    @objid ("20873f3b-8f67-4b7e-8588-256f9c813c4c")
    private SmDependency collaborationDep;

    @objid ("1bf43931-6c11-4c50-851c-a91bd7b3d92f")
    public BpmnMessageFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9fce60c7-7952-4ad8-8648-c6764111d942")
    @Override
    public String getName() {
        return "BpmnMessageFlow";

    }

    @objid ("1b9a0929-c369-433c-a586-830b7b09edf0")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("1350b079-dbe7-4a02-896c-ce944a0d6006")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnMessageFlow.class;

    }

    @objid ("a897149c-2ab0-4365-b2da-efb644a79520")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7bee689d-9746-40f0-a4f4-56e751b84d3a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("19b4eff4-e4f6-425d-9236-9371fd0f77b7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnBaseElement.MQNAME);
        this.registerFactory(new BpmnMessageFlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.messageRefDep = new MessageRefSmDependency();
        this.messageRefDep.init("MessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.messageRefDep);

        this.sourceRefDep = new SourceRefSmDependency();
        this.sourceRefDep.init("SourceRef", this, metamodel.getMClass(BpmnBaseElement.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE, SmDirective.SMCDPARTOF);
        registerDependency(this.sourceRefDep);

        this.targetRefDep = new TargetRefSmDependency();
        this.targetRefDep.init("TargetRef", this, metamodel.getMClass(BpmnBaseElement.MQNAME), 1, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetRefDep);

        this.collaborationDep = new CollaborationSmDependency();
        this.collaborationDep.init("Collaboration", this, metamodel.getMClass(BpmnCollaboration.MQNAME), 1, 1 );
        registerDependency(this.collaborationDep);

    }

    @objid ("84e7848e-a855-4a21-9f80-183fbdbba357")
    public SmDependency getMessageRefDep() {
        if (this.messageRefDep == null) {
        	this.messageRefDep = this.getDependencyDef("MessageRef");
        }
        return this.messageRefDep;
    }

    @objid ("bce3ad4c-34a7-4dd6-a76c-26ca48f55db0")
    public SmDependency getSourceRefDep() {
        if (this.sourceRefDep == null) {
        	this.sourceRefDep = this.getDependencyDef("SourceRef");
        }
        return this.sourceRefDep;
    }

    @objid ("bdb59efa-3921-4f54-818a-dc791490980f")
    public SmDependency getTargetRefDep() {
        if (this.targetRefDep == null) {
        	this.targetRefDep = this.getDependencyDef("TargetRef");
        }
        return this.targetRefDep;
    }

    @objid ("039a43b3-16d3-4f4f-bee3-b708eebeb59a")
    public SmDependency getCollaborationDep() {
        if (this.collaborationDep == null) {
        	this.collaborationDep = this.getDependencyDef("Collaboration");
        }
        return this.collaborationDep;
    }

    @objid ("5f643568-44a5-4879-8975-f862b492f98f")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("414d75db-cf8b-42ed-9657-949369e0a56d")
    private static class BpmnMessageFlowObjectFactory implements ISmObjectFactory {
        @objid ("244c81f2-f89f-4867-8d75-cfd7493872af")
        private BpmnMessageFlowSmClass smClass;

        @objid ("bfc08af9-1a5d-4f04-b929-de783caee317")
        public BpmnMessageFlowObjectFactory(BpmnMessageFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bb553ca6-d280-4cf5-bf35-8fe7015654b9")
        @Override
        public ISmObjectData createData() {
            return new BpmnMessageFlowData(this.smClass);
        }

        @objid ("fbe96601-0a49-4212-a2da-d6122aa4bd9e")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnMessageFlowImpl();
        }

    }

    @objid ("900390f2-a6e9-44fe-b6eb-838b12b7c937")
    public static class MessageRefSmDependency extends SmSingleDependency {
        @objid ("3f307027-d75d-49ea-948c-882fc6bbdd20")
        private SmDependency symetricDep;

        @objid ("54cac3f5-26cf-4b81-9c69-d9321dbe8c2d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageFlowData) data).mMessageRef;
        }

        @objid ("1a4b8d3f-2c9b-4501-a711-11f3890911fd")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageFlowData) data).mMessageRef = value;
        }

        @objid ("dae5dfe8-c124-4e9d-80ad-8fcd34f9a221")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getMessageFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("93b0e5c8-6e14-463a-968e-0fe7248b0e0a")
    public static class SourceRefSmDependency extends SmSingleDependency {
        @objid ("9c1b86c3-19bf-4690-81cc-266b6b3ef0a4")
        private SmDependency symetricDep;

        @objid ("341ef073-bdfa-4090-9768-eda34abb24e6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageFlowData) data).mSourceRef;
        }

        @objid ("bd623a77-e0c0-4144-aa04-d1ac5c8d178e")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageFlowData) data).mSourceRef = value;
        }

        @objid ("337e0686-98bf-49ca-b2da-afc35675cd6f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBaseElementSmClass)this.getTarget()).getOutgoingFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5857f741-4236-464f-9934-c041ac239a11")
    public static class TargetRefSmDependency extends SmSingleDependency {
        @objid ("8df38b8e-7c8f-4cce-87a9-3771b0b618c4")
        private SmDependency symetricDep;

        @objid ("675ae189-0e35-4d81-89d6-c740633efc9e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageFlowData) data).mTargetRef;
        }

        @objid ("1cd71f5a-e993-4ffa-823f-a366f6ef084a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageFlowData) data).mTargetRef = value;
        }

        @objid ("1a1feb8c-4c08-4cb6-81b8-a035d31ac90f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnBaseElementSmClass)this.getTarget()).getIncomingFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0ae70ba2-93c1-4f8c-bf30-d2b7259107af")
    public static class CollaborationSmDependency extends SmSingleDependency {
        @objid ("0a856d92-5f9d-4bf6-9ad4-3cac025a3cb2")
        private SmDependency symetricDep;

        @objid ("030fe25d-bbe3-4f24-863d-ec6f7e33a9a4")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageFlowData) data).mCollaboration;
        }

        @objid ("42ca8456-09e1-43a7-b60a-c947fe4ce90b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageFlowData) data).mCollaboration = value;
        }

        @objid ("d8376255-84a4-4683-94e6-0c8704acac30")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCollaborationSmClass)this.getTarget()).getMessageFlowDep();
            }
            return this.symetricDep;

        }

    }

}
