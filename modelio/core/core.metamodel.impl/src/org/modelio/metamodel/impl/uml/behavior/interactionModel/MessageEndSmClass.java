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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
import org.modelio.metamodel.uml.behavior.interactionModel.OccurrenceSpecification;
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

@objid ("aa51d4fc-b7d0-45a9-94c0-0bca595a6371")
public class MessageEndSmClass extends OccurrenceSpecificationSmClass {
    @objid ("a87d1a72-281c-44a0-b02f-25aef929a296")
    private SmDependency receivedMessageDep;

    @objid ("9e53de0f-38d2-4fd8-9465-a72b65fac648")
    private SmDependency sentMessageDep;

    @objid ("1075005a-6c08-40ac-8314-dc8b70a4356d")
    public MessageEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9c5ad0f3-fa98-495f-a908-a194c47dafae")
    @Override
    public String getName() {
        return "MessageEnd";

    }

    @objid ("51bcf90a-2c68-475f-8edb-0b0c019f30c9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d0f579b2-20d1-4074-a3da-7ff6e29b5e15")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return MessageEnd.class;

    }

    @objid ("aded89c8-a1ca-4c87-b543-1bfc3a4d3596")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("2b7a82f5-2c85-49e3-b673-21669d01a283")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("aa0307d5-853c-4a6c-a34a-7ac923716f57")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(OccurrenceSpecification.MQNAME);
        this.registerFactory(new MessageEndObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.receivedMessageDep = new ReceivedMessageSmDependency();
        this.receivedMessageDep.init("ReceivedMessage", this, metamodel.getMClass(Message.MQNAME), 0, 1 , SmDirective.SMCDTODELETE);
        registerDependency(this.receivedMessageDep);

        this.sentMessageDep = new SentMessageSmDependency();
        this.sentMessageDep.init("SentMessage", this, metamodel.getMClass(Message.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT, SmDirective.SMCDTODELETE);
        registerDependency(this.sentMessageDep);

    }

    @objid ("73013483-d3fe-4abf-8be3-af49a221c181")
    public SmDependency getReceivedMessageDep() {
        if (this.receivedMessageDep == null) {
        	this.receivedMessageDep = this.getDependencyDef("ReceivedMessage");
        }
        return this.receivedMessageDep;
    }

    @objid ("f4085e94-c808-4799-95ac-bf168ee3004b")
    public SmDependency getSentMessageDep() {
        if (this.sentMessageDep == null) {
        	this.sentMessageDep = this.getDependencyDef("SentMessage");
        }
        return this.sentMessageDep;
    }

    @objid ("6223b571-1ce9-40dd-a299-6dbe87484ea4")
    private static class MessageEndObjectFactory implements ISmObjectFactory {
        @objid ("482dee5a-6b7d-4d9e-8cbd-1002aad94f27")
        private MessageEndSmClass smClass;

        @objid ("fb1c5299-12f5-4f98-9ee0-0bdf7037035b")
        public MessageEndObjectFactory(MessageEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9dba9101-dc3e-4117-8e01-6719271a2ee1")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("acadbef3-89cd-4648-a499-45b608ea0be8")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("3c94d91a-5f2f-4e14-9002-b749bd05c5bf")
    public static class ReceivedMessageSmDependency extends SmSingleDependency {
        @objid ("fbde7dd4-f4ea-4c60-b0c4-b0db8208165d")
        private SmDependency symetricDep;

        @objid ("465f6b31-f742-43fb-8974-edc85b2473f3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageEndData) data).mReceivedMessage;
        }

        @objid ("210e6f70-6b63-4d5e-aa0b-95365e509d8c")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageEndData) data).mReceivedMessage = value;
        }

        @objid ("3d3224f5-0092-4602-a29b-24c723a15008")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageSmClass)this.getTarget()).getReceiveEventDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("4d53d6ec-d844-4a1b-a412-2db9fdaf61b3")
    public static class SentMessageSmDependency extends SmSingleDependency {
        @objid ("e5a5b020-9c02-4ea0-8175-5876b13f3d44")
        private SmDependency symetricDep;

        @objid ("9899becf-b490-4ce4-af28-4c4a24ab1b99")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageEndData) data).mSentMessage;
        }

        @objid ("465f5ad8-f35c-4c6c-b878-e3d0e865fde0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageEndData) data).mSentMessage = value;
        }

        @objid ("686ece77-ba16-42bd-9472-95a8d93eaa31")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageSmClass)this.getTarget()).getSendEventDep();
            }
            return this.symetricDep;

        }

    }

}
