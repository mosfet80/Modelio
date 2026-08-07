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
package org.modelio.metamodel.impl.uml.statik;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.informationFlow.InformationFlowSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.informationFlow.InformationFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.AssociationEnd;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.Link;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.ProvidedInterface;
import org.modelio.metamodel.uml.statik.RequiredInterface;
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

@objid ("707721c4-21c9-43f3-b94b-301e87a7913f")
public class LinkEndSmClass extends UmlModelElementSmClass {
    @objid ("13c275d9-4052-406b-b5c2-5629977c7301")
    private SmAttribute isOrderedAtt;

    @objid ("33cad5d2-5088-4b1e-9c79-280a8f386c48")
    private SmAttribute isUniqueAtt;

    @objid ("9be649e7-8f53-4479-b025-7ee9a7251315")
    private SmAttribute multiplicityMaxAtt;

    @objid ("15e89115-7328-41bb-ad42-240bbc5da709")
    private SmAttribute multiplicityMinAtt;

    @objid ("867d7a55-5454-426a-a5ad-f2ff07211892")
    private SmDependency linkDep;

    @objid ("f11221d3-6a91-4eb1-94fe-8e2485982df1")
    private SmDependency targetDep;

    @objid ("e560bb14-0ea9-48ef-a6ee-25b2cabba415")
    private SmDependency oppositeOwnerDep;

    @objid ("aa9c29a7-ca72-4b3b-8f38-2dbd7560d89c")
    private SmDependency realizedInformationFlowDep;

    @objid ("37a753c6-5dfe-4a47-bfea-7d3765106b40")
    private SmDependency modelDep;

    @objid ("c45b3526-0600-4175-8e33-e929d506c821")
    private SmDependency consumerDep;

    @objid ("e53d7071-252a-42da-842a-8c0d0192d0c3")
    private SmDependency oppositeDep;

    @objid ("d79863cf-7809-4348-b130-2b0480b25d7e")
    private SmDependency sourceDep;

    @objid ("e8ad874a-9e94-49f9-a8fa-bf88d58aaf9c")
    private SmDependency providerDep;

    @objid ("e0729e1a-1bb6-4a6b-b177-69c1e0241ea3")
    public LinkEndSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("8685baff-1d58-48c1-8e23-975c5ee9a294")
    @Override
    public String getName() {
        return "LinkEnd";

    }

    @objid ("205eb714-e48b-4074-b987-266277d24242")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("57e5752c-8e56-4413-8dea-797efdc5858d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return LinkEnd.class;

    }

    @objid ("46d4d9bb-23b8-4598-b5b7-9f4273946145")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("46a41dcc-fa50-4755-ac2b-5a4586f3bb1c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("f8952083-7c77-476e-a532-c502650779da")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new LinkEndObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isOrderedAtt = new IsOrderedSmAttribute();
        this.isOrderedAtt.init("IsOrdered", this, Boolean.class );
        registerAttribute(this.isOrderedAtt);

        this.isUniqueAtt = new IsUniqueSmAttribute();
        this.isUniqueAtt.init("IsUnique", this, Boolean.class );
        registerAttribute(this.isUniqueAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, String.class );
        registerAttribute(this.multiplicityMaxAtt);

        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, String.class );
        registerAttribute(this.multiplicityMinAtt);


        // Initialize and register the SmDependency
        this.linkDep = new LinkSmDependency();
        this.linkDep.init("Link", this, metamodel.getMClass(Link.MQNAME), 0, 1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.linkDep);

        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(Instance.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

        this.oppositeOwnerDep = new OppositeOwnerSmDependency();
        this.oppositeOwnerDep.init("OppositeOwner", this, metamodel.getMClass(LinkEnd.MQNAME), 1, 1 );
        registerDependency(this.oppositeOwnerDep);

        this.realizedInformationFlowDep = new RealizedInformationFlowSmDependency();
        this.realizedInformationFlowDep.init("RealizedInformationFlow", this, metamodel.getMClass(InformationFlow.MQNAME), 0, -1 );
        registerDependency(this.realizedInformationFlowDep);

        this.modelDep = new ModelSmDependency();
        this.modelDep.init("Model", this, metamodel.getMClass(AssociationEnd.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.modelDep);

        this.consumerDep = new ConsumerSmDependency();
        this.consumerDep.init("Consumer", this, metamodel.getMClass(RequiredInterface.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.consumerDep);

        this.oppositeDep = new OppositeSmDependency();
        this.oppositeDep.init("Opposite", this, metamodel.getMClass(LinkEnd.MQNAME), 1, 1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.oppositeDep);

        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(Instance.MQNAME), 1, 1 , SmDirective.SMCDLINKSOURCE, SmDirective.SMCDPARTOF);
        registerDependency(this.sourceDep);

        this.providerDep = new ProviderSmDependency();
        this.providerDep.init("Provider", this, metamodel.getMClass(ProvidedInterface.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.providerDep);

    }

    @objid ("5a0772f5-fdaf-4626-855c-cfec98dac2ee")
    public SmAttribute getIsOrderedAtt() {
        if (this.isOrderedAtt == null) {
        	this.isOrderedAtt = this.getAttributeDef("IsOrdered");
        }
        return this.isOrderedAtt;
    }

    @objid ("7ab705bd-058a-46e8-95c5-4d762d4a56d2")
    public SmAttribute getIsUniqueAtt() {
        if (this.isUniqueAtt == null) {
        	this.isUniqueAtt = this.getAttributeDef("IsUnique");
        }
        return this.isUniqueAtt;
    }

    @objid ("bb803c5c-1dbe-4024-ac49-16b03dccf41d")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("bb50402b-bbbc-47a2-9b04-aa240d2b29da")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("55fe2371-8d09-4a8b-84f6-50c4d50cecb8")
    public SmDependency getLinkDep() {
        if (this.linkDep == null) {
        	this.linkDep = this.getDependencyDef("Link");
        }
        return this.linkDep;
    }

    @objid ("2b039e6e-ed9b-473a-9385-37b0e4bdb119")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("4c218370-033c-441f-a4c6-93242319146d")
    public SmDependency getOppositeOwnerDep() {
        if (this.oppositeOwnerDep == null) {
        	this.oppositeOwnerDep = this.getDependencyDef("OppositeOwner");
        }
        return this.oppositeOwnerDep;
    }

    @objid ("0381eb93-f166-4dd3-852e-f5d4743e808d")
    public SmDependency getRealizedInformationFlowDep() {
        if (this.realizedInformationFlowDep == null) {
        	this.realizedInformationFlowDep = this.getDependencyDef("RealizedInformationFlow");
        }
        return this.realizedInformationFlowDep;
    }

    @objid ("870e4ce8-d41e-4691-877f-df60767c1e02")
    public SmDependency getModelDep() {
        if (this.modelDep == null) {
        	this.modelDep = this.getDependencyDef("Model");
        }
        return this.modelDep;
    }

    @objid ("7edc7cce-bca8-4176-b6f6-c60896cfbf94")
    public SmDependency getConsumerDep() {
        if (this.consumerDep == null) {
        	this.consumerDep = this.getDependencyDef("Consumer");
        }
        return this.consumerDep;
    }

    @objid ("ce3d7a0d-3c08-439d-90a1-e280fa159c12")
    public SmDependency getOppositeDep() {
        if (this.oppositeDep == null) {
        	this.oppositeDep = this.getDependencyDef("Opposite");
        }
        return this.oppositeDep;
    }

    @objid ("5fa7594f-867f-4d1d-8d1e-81fb58d10521")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("cbb805f2-90e1-44ff-be43-af079c847ab0")
    public SmDependency getProviderDep() {
        if (this.providerDep == null) {
        	this.providerDep = this.getDependencyDef("Provider");
        }
        return this.providerDep;
    }

    @objid ("542f6bc4-f2f4-4e8c-a0ce-4412751d6354")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("0dbf02c6-8bcd-4802-941a-112cb9771d10")
    private static class LinkEndObjectFactory implements ISmObjectFactory {
        @objid ("38f93751-ed29-4a4b-823f-c85f2c1271be")
        private LinkEndSmClass smClass;

        @objid ("1e6a5936-4e76-4caf-b12b-ab18926e3911")
        public LinkEndObjectFactory(LinkEndSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("df43b6e8-6dbc-40f4-80ad-ef718e70fc1b")
        @Override
        public ISmObjectData createData() {
            return new LinkEndData(this.smClass);
        }

        @objid ("d9210acc-7811-4fae-876c-10e948e3dac4")
        @Override
        public SmObjectImpl createImpl() {
            return new LinkEndImpl();
        }

    }

    @objid ("299fad1f-91c3-4ed1-81c0-0a7a8b70612c")
    public static class IsOrderedSmAttribute extends SmAttribute {
        @objid ("0ad3c3ee-98ca-472f-8e45-d571cbc519a0")
        public Object getValue(ISmObjectData data) {
            return ((LinkEndData) data).mIsOrdered;
        }

        @objid ("c07a7f6f-c2bf-44a7-8a73-4c97e8b7f11b")
        public void setValue(ISmObjectData data, Object value) {
            ((LinkEndData) data).mIsOrdered = value;
        }

    }

    @objid ("2742c533-1eaa-4930-901d-077f0caebec6")
    public static class IsUniqueSmAttribute extends SmAttribute {
        @objid ("592337e2-78cb-44be-8bb2-db760c729255")
        public Object getValue(ISmObjectData data) {
            return ((LinkEndData) data).mIsUnique;
        }

        @objid ("cfd92d6c-5906-4e72-aaee-bb6f48fe53c4")
        public void setValue(ISmObjectData data, Object value) {
            ((LinkEndData) data).mIsUnique = value;
        }

    }

    @objid ("a738be67-4580-4056-9574-6e1b73080a0c")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("9b033b88-8820-4b7e-bc1d-e9157b991cf7")
        public Object getValue(ISmObjectData data) {
            return ((LinkEndData) data).mMultiplicityMax;
        }

        @objid ("904bc048-d5f4-4282-864d-07516ccfc92a")
        public void setValue(ISmObjectData data, Object value) {
            ((LinkEndData) data).mMultiplicityMax = value;
        }

    }

    @objid ("22099628-d0a1-4014-a4d1-2ce52778401f")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("b1a6e2ad-10c0-4040-89a3-24ab20673f91")
        public Object getValue(ISmObjectData data) {
            return ((LinkEndData) data).mMultiplicityMin;
        }

        @objid ("d62480dd-b966-4dd3-8234-9af14d1b99cd")
        public void setValue(ISmObjectData data, Object value) {
            ((LinkEndData) data).mMultiplicityMin = value;
        }

    }

    @objid ("d17555ce-3740-4aa5-9ade-25822af830a6")
    public static class LinkSmDependency extends SmSingleDependency {
        @objid ("7fede833-8b04-460d-bedc-532931ac0538")
        private SmDependency symetricDep;

        @objid ("dcf7c0f3-e0be-408c-9d20-bdb460c7970d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mLink;
        }

        @objid ("c25d8c53-c7ed-426f-9700-305efa03528d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mLink = value;
        }

        @objid ("d8143afa-f529-449c-9313-b380e1f000ae")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkSmClass)this.getTarget()).getLinkEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7333ac88-12e1-48e8-8afa-69c18168c2e8")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("e6d5d3d4-276b-4bfc-977d-bd47ddeaadd6")
        private SmDependency symetricDep;

        @objid ("f2ba80b4-7c73-49fa-abb1-019bbc117ea0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mTarget;
        }

        @objid ("9b6f739c-71d3-4c5c-bd6b-80d49066d187")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mTarget = value;
        }

        @objid ("5fd7369e-ad8a-4c42-b4ef-43c11ee155ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getTargetingEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2e384bfc-4bd8-4196-bee7-4721ab3aba73")
    public static class OppositeOwnerSmDependency extends SmSingleDependency {
        @objid ("81bd7686-d94e-411f-94a3-838e643912d5")
        private SmDependency symetricDep;

        @objid ("499f8cb8-2d07-4ca4-af7d-9c60c50f6a0a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mOppositeOwner;
        }

        @objid ("09e28d8f-449f-42e4-87e8-8afc0385907b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mOppositeOwner = value;
        }

        @objid ("e3e2c805-bcce-4fed-a695-f33de86a0455")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getOppositeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("49d2526b-54b4-490a-b68b-ade03ac8866f")
    public static class RealizedInformationFlowSmDependency extends SmMultipleDependency {
        @objid ("ca441593-4853-465c-8dd4-99a03a2c1859")
        private SmDependency symetricDep;

        @objid ("5421bc39-fa11-45c0-91bf-1b95cc7e948f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((LinkEndData)data).mRealizedInformationFlow != null)? ((LinkEndData)data).mRealizedInformationFlow:SmMultipleDependency.EMPTY;
        }

        @objid ("73ac5c53-3ac6-409e-afdf-0a31827adaf8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((LinkEndData) data).mRealizedInformationFlow = values;

        }

        @objid ("cf054567-2087-4c59-84c4-9fbde9c6adec")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InformationFlowSmClass)this.getTarget()).getRealizingLinkDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("298fabc5-94af-4e2e-9e34-d7ddb880439d")
    public static class ModelSmDependency extends SmSingleDependency {
        @objid ("b48124f6-8d12-4450-a3ea-be655f7caa0a")
        private SmDependency symetricDep;

        @objid ("c5d5c6a9-47bc-4c3d-8cf0-8b19e0f82967")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mModel;
        }

        @objid ("8732fe74-644c-426a-9a5c-3d3eca2771f9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mModel = value;
        }

        @objid ("0cec144a-a0d2-4d7a-8b22-9fdfd9725174")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AssociationEndSmClass)this.getTarget()).getOccurenceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("781286cb-a624-44e8-8b53-af56aa499c33")
    public static class ConsumerSmDependency extends SmSingleDependency {
        @objid ("540c77e0-5b3a-4ded-ae91-ed0f9a12cf45")
        private SmDependency symetricDep;

        @objid ("c939aa0d-9c9f-4348-9d28-a5098e8676e1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mConsumer;
        }

        @objid ("1d9e00c9-d5fd-4d8c-bccf-1773ea08ac9d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mConsumer = value;
        }

        @objid ("482eb3c3-b715-4767-856f-987240e3f3cc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RequiredInterfaceSmClass)this.getTarget()).getProviderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("3cb1820a-a179-4e3b-a327-143152831488")
    public static class OppositeSmDependency extends SmSingleDependency {
        @objid ("5fe6cfae-5e02-496e-b47f-8bbe56f9651c")
        private SmDependency symetricDep;

        @objid ("b9ff4db8-618d-4bbb-8a10-53f5194311af")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mOpposite;
        }

        @objid ("b3f94a39-e7ab-4d81-ba0a-72094242e8ad")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mOpposite = value;
        }

        @objid ("14e7b6e3-6c54-4fb3-bbee-6d687cc04af3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getOppositeOwnerDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7ca8c9c3-7829-4ee8-96be-990fed573006")
    public static class SourceSmDependency extends SmSingleDependency {
        @objid ("7f97bd72-c068-4f5f-a3e5-2077a4a7e126")
        private SmDependency symetricDep;

        @objid ("3148563e-f6d5-4ced-be85-59281f5c0d84")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mSource;
        }

        @objid ("0c7a09ed-71fb-4352-9287-af6b16045879")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mSource = value;
        }

        @objid ("14fb14c5-65ad-468d-a97b-36511057513c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InstanceSmClass)this.getTarget()).getOwnedEndDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("5c6a4514-555a-4ef9-92f6-b2ad381fd54f")
    public static class ProviderSmDependency extends SmSingleDependency {
        @objid ("0815f636-f64c-4a39-ab27-92b48e6c4e45")
        private SmDependency symetricDep;

        @objid ("499fd55e-c6ad-411c-8bec-8cda8c146271")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((LinkEndData) data).mProvider;
        }

        @objid ("4d493496-e908-4ae1-b8b7-4405efafe1bf")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((LinkEndData) data).mProvider = value;
        }

        @objid ("15b5ce83-0caf-4bfb-9cd4-8514c2f13aa6")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ProvidedInterfaceSmClass)this.getTarget()).getConsumerDep();
            }
            return this.symetricDep;

        }

    }

}
