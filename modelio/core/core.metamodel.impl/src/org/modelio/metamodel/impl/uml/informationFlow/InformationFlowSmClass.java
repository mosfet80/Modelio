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
package org.modelio.metamodel.impl.uml.informationFlow;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ActivityEdgeSmClass;
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationMessageSmClass;
import org.modelio.metamodel.impl.uml.behavior.interactionModel.MessageSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.AssociationEndSmClass;
import org.modelio.metamodel.impl.uml.statik.ClassifierSmClass;
import org.modelio.metamodel.impl.uml.statik.LinkEndSmClass;
import org.modelio.metamodel.impl.uml.statik.NameSpaceSmClass;
import org.modelio.metamodel.impl.uml.statik.NaryLinkSmClass;
import org.modelio.metamodel.impl.uml.statik.StructuralFeatureSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationMessage;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Classifier;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryLink;
import org.modelio.metamodel.uml.statik.StructuralFeature;
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

@objid ("9a08c956-ddd8-4831-b050-a8b0220aff38")
public class InformationFlowSmClass extends UmlModelElementSmClass {
    @objid ("1adbd333-77bc-4ad6-8dd7-32fa052c728b")
    private SmDependency ownerDep;

    @objid ("a784664e-9347-4b71-a8f5-53cc5559a2f5")
    private SmDependency informationSourceDep;

    @objid ("3b301676-b13f-4e7b-800f-7dcc0372102b")
    private SmDependency informationTargetDep;

    @objid ("a05a7517-c011-492b-b16b-4d4adf87e63c")
    private SmDependency realizingActivityEdgeDep;

    @objid ("4733a558-fcc8-48a3-9cc7-5b21725cbf62")
    private SmDependency realizingCommunicationMessageDep;

    @objid ("c033cb6c-bd13-455d-bdb7-fcfc350147ce")
    private SmDependency realizingFeatureDep;

    @objid ("6d72f38e-62a8-4744-973e-a0f2348beab8")
    private SmDependency realizingLinkDep;

    @objid ("5247d03c-85c5-41be-b92e-43d70c361c67")
    private SmDependency realizingMessageDep;

    @objid ("6e179ee0-7dd8-48c3-b132-fec511bf7659")
    private SmDependency realizingNaryLinkDep;

    @objid ("fbab4ad0-dcae-47c7-9d6c-6730100ee1ff")
    private SmDependency conveyedDep;

    @objid ("19d02768-a3ae-47ce-bea0-c890af042e50")
    private SmDependency channelDep;

    @objid ("f6bddfc6-0d15-48ab-b90e-0dc7997996a1")
    public InformationFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("df80fc42-f253-46c1-9c1f-cc6e224ab73b")
    @Override
    public String getName() {
        return "InformationFlow";

    }

    @objid ("dd755fdf-e4be-4493-8efb-41c76cdb0c79")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("dcd5ed2b-518d-4cad-956a-e851e3f17e2f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return InformationFlow.class;

    }

    @objid ("bfd2377e-fd63-422e-9314-2f49250e0ca3")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0608fecc-ccca-4c88-9bb9-c3d563b416fe")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e2235dbb-3952-4647-b1d3-36970de5598c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new InformationFlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.informationSourceDep = new InformationSourceSmDependency();
        this.informationSourceDep.init("InformationSource", this, metamodel.getMClass(UmlModelElement.MQNAME), 1, -1 , SmDirective.SMCDLINKSOURCE, SmDirective.SMCDPARTOF);
        registerDependency(this.informationSourceDep);

        this.informationTargetDep = new InformationTargetSmDependency();
        this.informationTargetDep.init("InformationTarget", this, metamodel.getMClass(UmlModelElement.MQNAME), 1, -1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.informationTargetDep);

        this.realizingActivityEdgeDep = new RealizingActivityEdgeSmDependency();
        this.realizingActivityEdgeDep.init("RealizingActivityEdge", this, metamodel.getMClass(ActivityEdge.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingActivityEdgeDep);

        this.realizingCommunicationMessageDep = new RealizingCommunicationMessageSmDependency();
        this.realizingCommunicationMessageDep.init("RealizingCommunicationMessage", this, metamodel.getMClass(CommunicationMessage.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingCommunicationMessageDep);

        this.realizingFeatureDep = new RealizingFeatureSmDependency();
        this.realizingFeatureDep.init("RealizingFeature", this, metamodel.getMClass(StructuralFeature.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingFeatureDep);

        this.realizingLinkDep = new RealizingLinkSmDependency();
        this.realizingLinkDep.init("RealizingLink", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingLinkDep);

        this.realizingMessageDep = new RealizingMessageSmDependency();
        this.realizingMessageDep.init("RealizingMessage", this, metamodel.getMClass(Message.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingMessageDep);

        this.realizingNaryLinkDep = new RealizingNaryLinkSmDependency();
        this.realizingNaryLinkDep.init("RealizingNaryLink", this, metamodel.getMClass(NaryLink.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.realizingNaryLinkDep);

        this.conveyedDep = new ConveyedSmDependency();
        this.conveyedDep.init("Conveyed", this, metamodel.getMClass(Classifier.MQNAME), 1, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.conveyedDep);

        this.channelDep = new ChannelSmDependency();
        this.channelDep.init("Channel", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.channelDep);

    }

    @objid ("683ee59a-7ad8-4c83-bd6c-6c6d298cd37a")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("005dacc7-586e-45f2-8b02-d2daa4d7e96f")
    public SmDependency getInformationSourceDep() {
        if (this.informationSourceDep == null) {
        	this.informationSourceDep = this.getDependencyDef("InformationSource");
        }
        return this.informationSourceDep;
    }

    @objid ("cf632043-e3c1-4431-aa54-d27d30545b02")
    public SmDependency getInformationTargetDep() {
        if (this.informationTargetDep == null) {
        	this.informationTargetDep = this.getDependencyDef("InformationTarget");
        }
        return this.informationTargetDep;
    }

    @objid ("cdee2edb-cc88-47d0-b93a-4328a292b0eb")
    public SmDependency getRealizingActivityEdgeDep() {
        if (this.realizingActivityEdgeDep == null) {
        	this.realizingActivityEdgeDep = this.getDependencyDef("RealizingActivityEdge");
        }
        return this.realizingActivityEdgeDep;
    }

    @objid ("f0d3a568-e924-41ec-80d6-4b6f7736dd0a")
    public SmDependency getRealizingCommunicationMessageDep() {
        if (this.realizingCommunicationMessageDep == null) {
        	this.realizingCommunicationMessageDep = this.getDependencyDef("RealizingCommunicationMessage");
        }
        return this.realizingCommunicationMessageDep;
    }

    @objid ("50a6a7a6-23bc-4337-bde4-4c640a29c9b7")
    public SmDependency getRealizingFeatureDep() {
        if (this.realizingFeatureDep == null) {
        	this.realizingFeatureDep = this.getDependencyDef("RealizingFeature");
        }
        return this.realizingFeatureDep;
    }

    @objid ("792407a9-a4de-4195-a6de-8ee678695b79")
    public SmDependency getRealizingLinkDep() {
        if (this.realizingLinkDep == null) {
        	this.realizingLinkDep = this.getDependencyDef("RealizingLink");
        }
        return this.realizingLinkDep;
    }

    @objid ("a9300aa8-8c9d-4f16-8688-b194f0b06d20")
    public SmDependency getRealizingMessageDep() {
        if (this.realizingMessageDep == null) {
        	this.realizingMessageDep = this.getDependencyDef("RealizingMessage");
        }
        return this.realizingMessageDep;
    }

    @objid ("bc5edbf9-7b6d-4596-9a05-92b3a1f6baa4")
    public SmDependency getRealizingNaryLinkDep() {
        if (this.realizingNaryLinkDep == null) {
        	this.realizingNaryLinkDep = this.getDependencyDef("RealizingNaryLink");
        }
        return this.realizingNaryLinkDep;
    }

    @objid ("91da9dee-88ee-4fbb-9c46-20db10548114")
    public SmDependency getConveyedDep() {
        if (this.conveyedDep == null) {
        	this.conveyedDep = this.getDependencyDef("Conveyed");
        }
        return this.conveyedDep;
    }

    @objid ("167e8c36-d269-4bb5-9053-4c3350d5b0dd")
    public SmDependency getChannelDep() {
        if (this.channelDep == null) {
        	this.channelDep = this.getDependencyDef("Channel");
        }
        return this.channelDep;
    }

    @objid ("1dec07c8-e762-4869-8f7e-a04a5d9080aa")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("5657ac11-7bbc-47b5-9528-e42bb69bab91")
    private static class InformationFlowObjectFactory implements ISmObjectFactory {
        @objid ("64fdedc4-05c3-455f-b651-a0957355fc1f")
        private InformationFlowSmClass smClass;

        @objid ("161f563a-2f93-47e3-bff5-f2c4abfe59c2")
        public InformationFlowObjectFactory(InformationFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("72c1cb22-1606-4bf2-93de-f47bd1386de2")
        @Override
        public ISmObjectData createData() {
            return new InformationFlowData(this.smClass);
        }

        @objid ("46517b2e-4ebd-4d38-b2ef-0500b2b0721b")
        @Override
        public SmObjectImpl createImpl() {
            return new InformationFlowImpl();
        }

    }

    @objid ("9098f48a-7d4f-4762-beea-8ffd858b78dd")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("3a647720-403b-4ffb-be3e-9aa82a0cf83b")
        private SmDependency symetricDep;

        @objid ("3d514dc2-eebc-46f4-a6e0-8a75ecf82e1e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InformationFlowData) data).mOwner;
        }

        @objid ("a500925b-a302-4d0c-8262-0ae807a31e1d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InformationFlowData) data).mOwner = value;
        }

        @objid ("fe0c105d-a164-4304-be10-f82e5164bba3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fb9e54ec-d0b1-4cc1-8575-cc520de079e4")
    public static class InformationSourceSmDependency extends SmMultipleDependency {
        @objid ("1d5a3860-0a75-4d07-a307-1d3511fdca06")
        private SmDependency symetricDep;

        @objid ("b07826a1-3fd7-4a5e-9d1b-8b42bd573415")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mInformationSource != null)? ((InformationFlowData)data).mInformationSource:SmMultipleDependency.EMPTY;
        }

        @objid ("4d4f6210-3e4b-4748-9ae9-8cc6ec6f4156")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mInformationSource = values;

        }

        @objid ("d2b629be-031b-46b8-b414-cf93aa7040bc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getSentInfoDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("246e0257-f0cb-425a-9259-04c5bcd549b5")
    public static class InformationTargetSmDependency extends SmMultipleDependency {
        @objid ("91185ed7-abab-4a85-a425-95daf199bf69")
        private SmDependency symetricDep;

        @objid ("64f87b22-156b-4641-927a-1eeb18ce5e2e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mInformationTarget != null)? ((InformationFlowData)data).mInformationTarget:SmMultipleDependency.EMPTY;
        }

        @objid ("a9be49d0-666a-4af5-b1cc-0fc534b7551d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mInformationTarget = values;

        }

        @objid ("d5ab27bf-014b-4e37-a6a1-f13fb3bcf744")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getReceivedInfoDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("58236bd1-d64d-4e69-be5f-430d0f30e3c2")
    public static class RealizingActivityEdgeSmDependency extends SmMultipleDependency {
        @objid ("e6c4b14e-298b-40cd-b441-1deb48c1c52b")
        private SmDependency symetricDep;

        @objid ("013ce81b-460b-4c73-ab24-c61d55c2a60b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingActivityEdge != null)? ((InformationFlowData)data).mRealizingActivityEdge:SmMultipleDependency.EMPTY;
        }

        @objid ("161ce1a9-e51a-4b9b-aadd-d1f41e7e20af")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingActivityEdge = values;

        }

        @objid ("3aae6439-5924-405f-ae37-8a46af300abf")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityEdgeSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2cd10d62-df91-4024-afb0-f5094d433309")
    public static class RealizingCommunicationMessageSmDependency extends SmMultipleDependency {
        @objid ("2d6306ab-424d-45c5-ad7a-e11f38713a0c")
        private SmDependency symetricDep;

        @objid ("9a22b015-8e33-4f83-9cff-d8b6eee553c7")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingCommunicationMessage != null)? ((InformationFlowData)data).mRealizingCommunicationMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("b9083466-737c-4de5-886c-267b1e75daa9")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingCommunicationMessage = values;

        }

        @objid ("dfc53ee4-b361-4dee-8f2e-8a5b25f3d9ff")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationMessageSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("55f2a795-d517-4ac4-b485-45983cec2670")
    public static class RealizingFeatureSmDependency extends SmMultipleDependency {
        @objid ("99981fb6-d6b9-4192-8823-3b3502cbac67")
        private SmDependency symetricDep;

        @objid ("2b59b0e0-682b-4cc4-9e33-a480a2fc03e0")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingFeature != null)? ((InformationFlowData)data).mRealizingFeature:SmMultipleDependency.EMPTY;
        }

        @objid ("dacdb0e8-e64a-4517-b968-6d99e706765c")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingFeature = values;

        }

        @objid ("8367aa3b-1de9-4030-84e2-c85c828a6528")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StructuralFeatureSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("caf54015-3f2a-48bf-941f-fc292c5eb4aa")
    public static class RealizingLinkSmDependency extends SmMultipleDependency {
        @objid ("6f60ddd1-7069-4b3d-9a5f-15e468df32ea")
        private SmDependency symetricDep;

        @objid ("12c43917-961b-4231-a559-9d05960463b8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingLink != null)? ((InformationFlowData)data).mRealizingLink:SmMultipleDependency.EMPTY;
        }

        @objid ("0f5d38a0-6696-4d84-a8c8-dd8b0c20a680")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingLink = values;

        }

        @objid ("11d09eb1-b5c6-496f-96d4-9a1e742b30de")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2c2451e3-a03c-4cea-9c7f-16df43f65821")
    public static class RealizingMessageSmDependency extends SmMultipleDependency {
        @objid ("55501875-4439-4f24-88f9-667b05171a9c")
        private SmDependency symetricDep;

        @objid ("20d94ca0-d3a7-4095-9820-4764e2a21b31")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingMessage != null)? ((InformationFlowData)data).mRealizingMessage:SmMultipleDependency.EMPTY;
        }

        @objid ("df265fe9-4e1b-4067-bc0a-9684acffa6f5")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingMessage = values;

        }

        @objid ("f1dc5031-2f53-4eab-a017-e21fca259bb4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c4ef2d14-24ac-4930-9a85-0bf47097b9fb")
    public static class RealizingNaryLinkSmDependency extends SmMultipleDependency {
        @objid ("79afc950-d342-4ea0-963e-014830122bd8")
        private SmDependency symetricDep;

        @objid ("9e0d6530-ea7c-4a3d-bac8-7d26b7bc3907")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mRealizingNaryLink != null)? ((InformationFlowData)data).mRealizingNaryLink:SmMultipleDependency.EMPTY;
        }

        @objid ("450d27d5-601c-4483-bb08-aee0af6e39dd")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mRealizingNaryLink = values;

        }

        @objid ("6512aab2-91aa-425b-825a-1236d13e98d6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkSmClass)this.getTarget()).getRealizedInformationFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b4fe35ab-3302-4c44-9743-d4c3d96f314b")
    public static class ConveyedSmDependency extends SmMultipleDependency {
        @objid ("6e71ad99-0748-44fa-b2c5-90b7c97c358a")
        private SmDependency symetricDep;

        @objid ("0f64fd4a-6c4a-4c25-963a-4bd3795114a3")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InformationFlowData)data).mConveyed != null)? ((InformationFlowData)data).mConveyed:SmMultipleDependency.EMPTY;
        }

        @objid ("a5b7c4fb-9b99-4367-a29b-6cfda013e34f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InformationFlowData) data).mConveyed = values;

        }

        @objid ("a0482a8f-a750-4f1a-a825-f421bd7fd126")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClassifierSmClass)this.getTarget()).getConveyerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7c6bb86c-58fe-4909-a0d5-02a4608de8ab")
    public static class ChannelSmDependency extends SmSingleDependency {
        @objid ("1552f002-7a19-452c-be4e-cd3afbe4441a")
        private SmDependency symetricDep;

        @objid ("a4f2c0d2-e0f6-451d-8c53-a35b652d5f3b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InformationFlowData) data).mChannel;
        }

        @objid ("c8f45677-963f-46ee-85fb-346bb0fbb571")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InformationFlowData) data).mChannel = value;
        }

        @objid ("1e4734f8-a546-4d1f-9269-3f5eeda19d2b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getSentDep();
            }
            return this.symetricDep;

        }

    }

}
