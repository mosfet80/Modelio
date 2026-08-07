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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.LinkSmClass;
import org.modelio.metamodel.impl.uml.statik.NaryLinkSmClass;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationChannel;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.NaryLink;
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

@objid ("74a6b528-ebe4-421d-bf3f-31899335ac89")
public class CommunicationChannelSmClass extends UmlModelElementSmClass {
    @objid ("fc136675-4985-4d70-a987-3cb1f483da99")
    private SmDependency startToEndMessageDep;

    @objid ("32068d9b-cee7-481e-ada0-490d7907bfaa")
    private SmDependency channelDep;

    @objid ("631b1917-cb7c-47a2-bf81-bf55ee793b2c")
    private SmDependency startDep;

    @objid ("fb42b9b9-381d-40cb-9c9e-f662ec057f66")
    private SmDependency naryChannelDep;

    @objid ("5081a0b8-72ca-403c-a53e-3fe4be94eab8")
    private SmDependency endToStartMessageDep;

    @objid ("3aca579d-fee5-4d64-bef9-b3b5d01a06a4")
    private SmDependency endDep;

    @objid ("273c2aac-6032-4b9d-81d0-ef82ff514884")
    public CommunicationChannelSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f39921f1-35a7-472e-a601-3840f3fcd884")
    @Override
    public String getName() {
        return "CommunicationChannel";

    }

    @objid ("1793d27b-7e73-4630-a61b-989b3aa9d8b5")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("5624343d-a4b8-4ea3-8640-99a27b1cc0f5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return CommunicationChannel.class;

    }

    @objid ("96552eba-d9c4-4696-8fdc-74774779e84b")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3c3a6e81-adc0-44e7-98f5-d41147a80f05")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("3abc80e9-aa26-4f0b-acd8-e706f176c2f3")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new CommunicationChannelObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.startToEndMessageDep = new StartToEndMessageSmDependency();
        this.startToEndMessageDep.init("StartToEndMessage", this, metamodel.getMClass(CommunicationMessage.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.startToEndMessageDep);

        this.channelDep = new ChannelSmDependency();
        this.channelDep.init("Channel", this, metamodel.getMClass(Link.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.channelDep);

        this.startDep = new StartSmDependency();
        this.startDep.init("Start", this, metamodel.getMClass(CommunicationNode.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.startDep);

        this.naryChannelDep = new NaryChannelSmDependency();
        this.naryChannelDep.init("NaryChannel", this, metamodel.getMClass(NaryLink.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.naryChannelDep);

        this.endToStartMessageDep = new EndToStartMessageSmDependency();
        this.endToStartMessageDep.init("EndToStartMessage", this, metamodel.getMClass(CommunicationMessage.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.endToStartMessageDep);

        this.endDep = new EndSmDependency();
        this.endDep.init("End", this, metamodel.getMClass(CommunicationNode.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.endDep);

    }

    @objid ("8662f884-b421-44ed-839a-4f809fad2820")
    public SmDependency getStartToEndMessageDep() {
        if (this.startToEndMessageDep == null) {
        	this.startToEndMessageDep = this.getDependencyDef("StartToEndMessage");
        }
        return this.startToEndMessageDep;
    }

    @objid ("4b9ffd3b-6749-4e58-a97e-208c140ff0d4")
    public SmDependency getChannelDep() {
        if (this.channelDep == null) {
        	this.channelDep = this.getDependencyDef("Channel");
        }
        return this.channelDep;
    }

    @objid ("6e775f3e-33a8-4b9a-8d24-00421a12b9f1")
    public SmDependency getStartDep() {
        if (this.startDep == null) {
        	this.startDep = this.getDependencyDef("Start");
        }
        return this.startDep;
    }

    @objid ("8bfcdb01-2918-45ac-b305-e0b139921e6c")
    public SmDependency getNaryChannelDep() {
        if (this.naryChannelDep == null) {
        	this.naryChannelDep = this.getDependencyDef("NaryChannel");
        }
        return this.naryChannelDep;
    }

    @objid ("eae8301f-53ea-4765-bdd2-10ec01856a78")
    public SmDependency getEndToStartMessageDep() {
        if (this.endToStartMessageDep == null) {
        	this.endToStartMessageDep = this.getDependencyDef("EndToStartMessage");
        }
        return this.endToStartMessageDep;
    }

    @objid ("02d79e5e-a887-4d69-8a42-930d64627bbe")
    public SmDependency getEndDep() {
        if (this.endDep == null) {
        	this.endDep = this.getDependencyDef("End");
        }
        return this.endDep;
    }

    @objid ("d5f2ab6f-b505-414a-ac2a-418fe68a2624")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("4297b476-7a04-4d34-8e78-e76630688d26")
    private static class CommunicationChannelObjectFactory implements ISmObjectFactory {
        @objid ("81c9e96b-0b97-427c-92ec-f16f46141d5f")
        private CommunicationChannelSmClass smClass;

        @objid ("2ee97e01-7930-403a-99f0-792527b9448f")
        public CommunicationChannelObjectFactory(CommunicationChannelSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("a25fd662-c14c-459c-a2d3-76595f3eca0d")
        @Override
        public ISmObjectData createData() {
            return new CommunicationChannelData(this.smClass);
        }

        @objid ("fd2ff7cc-5ffe-433c-b966-646f21c7631e")
        @Override
        public SmObjectImpl createImpl() {
            return new CommunicationChannelImpl();
        }

    }

    @objid ("a9112456-f700-49de-8fa4-99ca4656bbac")
    public static class StartToEndMessageSmDependency extends SmMultipleDependency {
        @objid ("dda0e4f3-045e-4540-ac0c-c26fb83fd565")
        private SmDependency symetricDep;

        @objid ("21559801-a171-48c9-a153-b3bf775f1b3b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationChannelData)data).mStartToEndMessage != null)? ((CommunicationChannelData)data).mStartToEndMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("ddb85485-4f61-47a5-9e0c-630bf747cf40")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationChannelData) data).mStartToEndMessage = values;

        }

        @objid ("1a701fae-678a-463c-a228-98cc8f3cd1fe")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationMessageSmClass)this.getTarget()).getChannelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0fb26925-0971-4da1-8a5e-7f4d2c100b71")
    public static class ChannelSmDependency extends SmSingleDependency {
        @objid ("13f542de-9e98-413b-b532-45b9b42fd18d")
        private SmDependency symetricDep;

        @objid ("297ccb04-7b52-49d1-9e2a-441b77bc14e6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationChannelData) data).mChannel;
        }

        @objid ("244ea057-fd8a-46e7-86b1-d00826a75c9a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationChannelData) data).mChannel = value;
        }

        @objid ("13a21826-556e-4207-88bb-356528ec0a93")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkSmClass)this.getTarget()).getSentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("33fc050c-5994-4c27-8fed-923f999de375")
    public static class StartSmDependency extends SmSingleDependency {
        @objid ("8011b28c-2198-4e2a-a74f-7d9b6ad4df4a")
        private SmDependency symetricDep;

        @objid ("c7a50978-4297-426b-87fb-15ce587a26ee")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationChannelData) data).mStart;
        }

        @objid ("b0d2d51b-16d6-4960-9bf4-49419caa0415")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationChannelData) data).mStart = value;
        }

        @objid ("5c33a737-1e12-46e8-b673-bbd2ba5849f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationNodeSmClass)this.getTarget()).getStartedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5fdacd0c-1b9f-472a-9469-37fc97ae4f79")
    public static class NaryChannelSmDependency extends SmSingleDependency {
        @objid ("93a5676f-1f27-42ab-a0d3-2176c310dff0")
        private SmDependency symetricDep;

        @objid ("526c84e3-b02a-446e-8715-f1a2f7ff0ebd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationChannelData) data).mNaryChannel;
        }

        @objid ("df633a7d-dcc6-4b77-a3d9-5503f36bbcc5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationChannelData) data).mNaryChannel = value;
        }

        @objid ("9c118dee-6f8c-47fa-8f07-0522fa969e50")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkSmClass)this.getTarget()).getSentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("80567e7b-d94f-41ec-93b7-00d2ae37d7fa")
    public static class EndToStartMessageSmDependency extends SmMultipleDependency {
        @objid ("55090b15-4bbe-4881-9742-b44bde1285b4")
        private SmDependency symetricDep;

        @objid ("eb878d7d-8ca8-41e5-9653-a1de6c9e454a")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((CommunicationChannelData)data).mEndToStartMessage != null)? ((CommunicationChannelData)data).mEndToStartMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("99065204-751b-4a90-af47-9eb23767dd9b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((CommunicationChannelData) data).mEndToStartMessage = values;

        }

        @objid ("a60a5929-a260-43d9-b2d0-6fe739f3b401")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationMessageSmClass)this.getTarget()).getInvertedChannelDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2c122289-dcd3-41b3-9786-1d475b2dd299")
    public static class EndSmDependency extends SmSingleDependency {
        @objid ("de234a19-10e5-4178-90cc-70627e9427e6")
        private SmDependency symetricDep;

        @objid ("64ad1502-9144-4df3-8b9a-e51a84206290")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((CommunicationChannelData) data).mEnd;
        }

        @objid ("c3166b22-1665-407c-b0b6-9be3703c063e")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((CommunicationChannelData) data).mEnd = value;
        }

        @objid ("58c7ba4d-e914-4cac-b3b4-5b2bcdefced0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationNodeSmClass)this.getTarget()).getEndedDep();
            }
            return this.symetricDep;

        }

    }

}
