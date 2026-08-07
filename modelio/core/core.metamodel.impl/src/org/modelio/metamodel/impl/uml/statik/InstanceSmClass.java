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
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.impl.uml.behavior.communicationModel.CommunicationNodeSmClass;
import org.modelio.metamodel.impl.uml.behavior.interactionModel.LifelineSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.communicationModel.CommunicationNode;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.AttributeLink;
import org.modelio.metamodel.uml.statik.BindableInstance;
import org.modelio.metamodel.uml.statik.Instance;
import org.modelio.metamodel.uml.statik.LinkEnd;
import org.modelio.metamodel.uml.statik.NameSpace;
import org.modelio.metamodel.uml.statik.NaryLinkEnd;
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

@objid ("d02f7ac8-f93a-44a1-acfd-0f9ced01cb4c")
public class InstanceSmClass extends UmlModelElementSmClass {
    @objid ("d8fbf061-8437-4e63-9a45-dcd920a322ba")
    private SmAttribute isConstantAtt;

    @objid ("d46bee3f-ec62-4def-9f48-963e89251e58")
    private SmAttribute multiplicityMinAtt;

    @objid ("5b7f324b-e51e-4fcd-a37f-619a62c30452")
    private SmAttribute multiplicityMaxAtt;

    @objid ("d7036e18-66ee-4d56-a93b-1cf44849720d")
    private SmAttribute valueAtt;

    @objid ("049b57ab-9d7e-44df-8df0-9075b8289871")
    private SmDependency representedCommunicationNodeDep;

    @objid ("6b3e4a54-bbdb-4469-b02a-ebc50281276f")
    private SmDependency ownedEndDep;

    @objid ("91de1132-2778-486d-b97b-52d1cc1b87c5")
    private SmDependency baseDep;

    @objid ("943650ed-a178-428a-89ac-41bae9631b9c")
    private SmDependency representingObjectNodeDep;

    @objid ("ab173104-61f7-4e84-a0de-cf71b747fe3c")
    private SmDependency ownerDep;

    @objid ("dcc25058-c8b5-4a53-963f-499d5ce9298c")
    private SmDependency ownedNaryEndDep;

    @objid ("309915e2-9466-45fe-8810-56c832dccb9e")
    private SmDependency representedLifeLineDep;

    @objid ("83972085-0af1-4073-a64e-08bcc7078f46")
    private SmDependency slotDep;

    @objid ("598d4f07-8c33-47fd-8acd-326f28d869b1")
    private SmDependency partDep;

    @objid ("6e147df8-97b0-4ea4-a255-21b7cb192716")
    private SmDependency targetingEndDep;

    @objid ("4a591e16-5a98-4916-b423-96feb201fd3c")
    public InstanceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("077be5a0-f390-4245-91be-f5a8a0eeddc1")
    @Override
    public String getName() {
        return "Instance";

    }

    @objid ("efc56571-8670-4fdb-aab6-3e2e3a2fe606")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("e85f8cb8-7ee4-4f34-80fa-37717dfe1377")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Instance.class;

    }

    @objid ("df74f2b7-c535-4e86-87fb-fb1532b00160")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("7631462d-210b-4451-8f46-63364afbd474")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6a82a2cc-f91a-4f6c-aed9-0d9228452825")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new InstanceObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isConstantAtt = new IsConstantSmAttribute();
        this.isConstantAtt.init("IsConstant", this, Boolean.class );
        registerAttribute(this.isConstantAtt);

        this.multiplicityMinAtt = new MultiplicityMinSmAttribute();
        this.multiplicityMinAtt.init("MultiplicityMin", this, String.class );
        registerAttribute(this.multiplicityMinAtt);

        this.multiplicityMaxAtt = new MultiplicityMaxSmAttribute();
        this.multiplicityMaxAtt.init("MultiplicityMax", this, String.class );
        registerAttribute(this.multiplicityMaxAtt);

        this.valueAtt = new ValueSmAttribute();
        this.valueAtt.init("Value", this, String.class );
        registerAttribute(this.valueAtt);


        // Initialize and register the SmDependency
        this.representedCommunicationNodeDep = new RepresentedCommunicationNodeSmDependency();
        this.representedCommunicationNodeDep.init("RepresentedCommunicationNode", this, metamodel.getMClass(CommunicationNode.MQNAME), 0, -1 );
        registerDependency(this.representedCommunicationNodeDep);

        this.ownedEndDep = new OwnedEndSmDependency();
        this.ownedEndDep.init("OwnedEnd", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 , SmDirective.SMCDSHAREDCOMPONENT);
        registerDependency(this.ownedEndDep);

        this.baseDep = new BaseSmDependency();
        this.baseDep.init("Base", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.baseDep);

        this.representingObjectNodeDep = new RepresentingObjectNodeSmDependency();
        this.representingObjectNodeDep.init("RepresentingObjectNode", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 );
        registerDependency(this.representingObjectNodeDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.ownedNaryEndDep = new OwnedNaryEndSmDependency();
        this.ownedNaryEndDep.init("OwnedNaryEnd", this, metamodel.getMClass(NaryLinkEnd.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.ownedNaryEndDep);

        this.representedLifeLineDep = new RepresentedLifeLineSmDependency();
        this.representedLifeLineDep.init("RepresentedLifeLine", this, metamodel.getMClass(Lifeline.MQNAME), 0, -1 );
        registerDependency(this.representedLifeLineDep);

        this.slotDep = new SlotSmDependency();
        this.slotDep.init("Slot", this, metamodel.getMClass(AttributeLink.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.slotDep);

        this.partDep = new PartSmDependency();
        this.partDep.init("Part", this, metamodel.getMClass(BindableInstance.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.partDep);

        this.targetingEndDep = new TargetingEndSmDependency();
        this.targetingEndDep.init("TargetingEnd", this, metamodel.getMClass(LinkEnd.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.targetingEndDep);

    }

    @objid ("a8212254-e053-41c1-ac85-c845d271c4df")
    public SmAttribute getIsConstantAtt() {
        if (this.isConstantAtt == null) {
        	this.isConstantAtt = this.getAttributeDef("IsConstant");
        }
        return this.isConstantAtt;
    }

    @objid ("2b4cf457-0c4c-4711-93a0-db4a14edea29")
    public SmAttribute getMultiplicityMinAtt() {
        if (this.multiplicityMinAtt == null) {
        	this.multiplicityMinAtt = this.getAttributeDef("MultiplicityMin");
        }
        return this.multiplicityMinAtt;
    }

    @objid ("a2532420-0c6c-44d5-86d9-5a7d6465860f")
    public SmAttribute getMultiplicityMaxAtt() {
        if (this.multiplicityMaxAtt == null) {
        	this.multiplicityMaxAtt = this.getAttributeDef("MultiplicityMax");
        }
        return this.multiplicityMaxAtt;
    }

    @objid ("bd8cec28-88fe-48b8-89ba-83009a8739c1")
    public SmAttribute getValueAtt() {
        if (this.valueAtt == null) {
        	this.valueAtt = this.getAttributeDef("Value");
        }
        return this.valueAtt;
    }

    @objid ("b3f6066a-3ce3-4b38-bc9d-5851fb523990")
    public SmDependency getRepresentedCommunicationNodeDep() {
        if (this.representedCommunicationNodeDep == null) {
        	this.representedCommunicationNodeDep = this.getDependencyDef("RepresentedCommunicationNode");
        }
        return this.representedCommunicationNodeDep;
    }

    @objid ("221313a1-b0af-421e-823e-9d60a08d353d")
    public SmDependency getOwnedEndDep() {
        if (this.ownedEndDep == null) {
        	this.ownedEndDep = this.getDependencyDef("OwnedEnd");
        }
        return this.ownedEndDep;
    }

    @objid ("f159d66b-744f-4dfc-8a43-615fb4c353d6")
    public SmDependency getBaseDep() {
        if (this.baseDep == null) {
        	this.baseDep = this.getDependencyDef("Base");
        }
        return this.baseDep;
    }

    @objid ("ac6de079-21b6-4222-a521-3a51c15e326b")
    public SmDependency getRepresentingObjectNodeDep() {
        if (this.representingObjectNodeDep == null) {
        	this.representingObjectNodeDep = this.getDependencyDef("RepresentingObjectNode");
        }
        return this.representingObjectNodeDep;
    }

    @objid ("99c6eace-4da1-49ea-a9a0-d9c1678b6a26")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("75c3631d-6af5-429e-aa0c-9e617ce105c9")
    public SmDependency getOwnedNaryEndDep() {
        if (this.ownedNaryEndDep == null) {
        	this.ownedNaryEndDep = this.getDependencyDef("OwnedNaryEnd");
        }
        return this.ownedNaryEndDep;
    }

    @objid ("42b37eca-e9a5-4ca8-a041-73afa4105078")
    public SmDependency getRepresentedLifeLineDep() {
        if (this.representedLifeLineDep == null) {
        	this.representedLifeLineDep = this.getDependencyDef("RepresentedLifeLine");
        }
        return this.representedLifeLineDep;
    }

    @objid ("8e2adbfd-48b6-4b05-b4c9-95513ae050ad")
    public SmDependency getSlotDep() {
        if (this.slotDep == null) {
        	this.slotDep = this.getDependencyDef("Slot");
        }
        return this.slotDep;
    }

    @objid ("0057a341-777a-4cbb-b4b4-cfa382a04ff6")
    public SmDependency getPartDep() {
        if (this.partDep == null) {
        	this.partDep = this.getDependencyDef("Part");
        }
        return this.partDep;
    }

    @objid ("47437533-5581-4586-b415-edf43a7501b0")
    public SmDependency getTargetingEndDep() {
        if (this.targetingEndDep == null) {
        	this.targetingEndDep = this.getDependencyDef("TargetingEnd");
        }
        return this.targetingEndDep;
    }

    @objid ("0b7b2259-6a68-412d-aba2-26b82397f9eb")
    private static class InstanceObjectFactory implements ISmObjectFactory {
        @objid ("84577e5b-1fe3-42da-b664-ccad1e5b7167")
        private InstanceSmClass smClass;

        @objid ("0b6b3d51-eaaa-4ace-a0d0-dc692d853755")
        public InstanceObjectFactory(InstanceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("441dcef9-240e-4530-99da-446d1612719e")
        @Override
        public ISmObjectData createData() {
            return new InstanceData(this.smClass);
        }

        @objid ("47cf35af-1379-4827-90c3-f617de646438")
        @Override
        public SmObjectImpl createImpl() {
            return new InstanceImpl();
        }

    }

    @objid ("c76732f4-e46f-433d-bca8-18dba8b627a2")
    public static class IsConstantSmAttribute extends SmAttribute {
        @objid ("42b84113-8f17-4a86-875f-371f7c19a6c2")
        public Object getValue(ISmObjectData data) {
            return ((InstanceData) data).mIsConstant;
        }

        @objid ("22b2d959-08ad-477b-8bc4-968f6c852c93")
        public void setValue(ISmObjectData data, Object value) {
            ((InstanceData) data).mIsConstant = value;
        }

    }

    @objid ("980ac8d4-0c0c-4885-ba13-7aabe3e5e774")
    public static class MultiplicityMinSmAttribute extends SmAttribute {
        @objid ("1457d1fb-891d-414e-98a8-c400fd74fcc9")
        public Object getValue(ISmObjectData data) {
            return ((InstanceData) data).mMultiplicityMin;
        }

        @objid ("f716b4ed-43f9-4c16-8938-f4cb68ed4ee1")
        public void setValue(ISmObjectData data, Object value) {
            ((InstanceData) data).mMultiplicityMin = value;
        }

    }

    @objid ("4ddbc9d6-3976-446f-b358-65982b9d280a")
    public static class MultiplicityMaxSmAttribute extends SmAttribute {
        @objid ("f6a20651-1ec0-4eb9-97f7-e37b9b71bbdf")
        public Object getValue(ISmObjectData data) {
            return ((InstanceData) data).mMultiplicityMax;
        }

        @objid ("0f776f3b-a076-436d-94f4-2f8bd00bf5f5")
        public void setValue(ISmObjectData data, Object value) {
            ((InstanceData) data).mMultiplicityMax = value;
        }

    }

    @objid ("b36af97c-baae-4d9e-8e1c-f67f0d5fe4c3")
    public static class ValueSmAttribute extends SmAttribute {
        @objid ("f0c7c571-55da-402e-b747-e7ed59b12d67")
        public Object getValue(ISmObjectData data) {
            return ((InstanceData) data).mValue;
        }

        @objid ("12dd5d58-2f9d-47b8-8b70-f54ef86db3db")
        public void setValue(ISmObjectData data, Object value) {
            ((InstanceData) data).mValue = value;
        }

    }

    @objid ("27067c97-b964-4a9e-ac0c-ded93bf0fe30")
    public static class RepresentedCommunicationNodeSmDependency extends SmMultipleDependency {
        @objid ("9daccc3e-e3f3-46f3-ac11-3850d345456f")
        private SmDependency symetricDep;

        @objid ("e62acbd8-736b-49b3-b460-3beb19bf94bb")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mRepresentedCommunicationNode != null)? ((InstanceData)data).mRepresentedCommunicationNode:SmMultipleDependency.EMPTY;
        }

        @objid ("9973c73d-d38a-4712-bf20-df26308876f1")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mRepresentedCommunicationNode = values;

        }

        @objid ("ae2dbc36-a9cc-42e7-bea5-20cce52a4c53")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CommunicationNodeSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("66c8d762-7ac3-41e7-bb5e-d1f6a60ce346")
    public static class OwnedEndSmDependency extends SmMultipleDependency {
        @objid ("02b32214-3d96-42c3-a22b-d5140b97a98f")
        private SmDependency symetricDep;

        @objid ("cd31e423-14f5-47bf-8399-530b27dd8b4e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mOwnedEnd != null)? ((InstanceData)data).mOwnedEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("3a552e23-af91-4530-9079-a9cf5d1bf11b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mOwnedEnd = values;

        }

        @objid ("0aac78b8-2db4-4d65-87b7-4e08e17f76ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f1656f3c-2481-4d00-a2d3-2846c1313062")
    public static class BaseSmDependency extends SmSingleDependency {
        @objid ("ff30bd74-1e6a-4ad9-b20f-15090dffd515")
        private SmDependency symetricDep;

        @objid ("773cd84c-1cb2-44a2-b991-9191c4e1a7b7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InstanceData) data).mBase;
        }

        @objid ("a22336dc-6b0b-4cc8-b05a-901487ed37c2")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InstanceData) data).mBase = value;
        }

        @objid ("83507264-fd7b-41c7-b40c-b0e95f261ca3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getRepresentingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b6fb8d6e-2ecd-4e25-8ddc-39c3949caaf1")
    public static class RepresentingObjectNodeSmDependency extends SmMultipleDependency {
        @objid ("ac7ae111-aa14-4b19-824f-a0dfbcd49161")
        private SmDependency symetricDep;

        @objid ("1e5ba212-e7c4-4ad1-b24a-870ead975765")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mRepresentingObjectNode != null)? ((InstanceData)data).mRepresentingObjectNode:SmMultipleDependency.EMPTY;
        }

        @objid ("93e52782-179d-4af0-a287-2bd67250b24b")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mRepresentingObjectNode = values;

        }

        @objid ("984819b2-53ba-407e-9732-afa2a38f02d7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ed9bc567-141c-4f22-818a-136818e828a8")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("6ea362ae-bef3-4012-8988-c092046c0c55")
        private SmDependency symetricDep;

        @objid ("f126378c-aab1-4c08-9dd7-30b032883827")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((InstanceData) data).mOwner;
        }

        @objid ("11fe8ea9-132c-45e7-ad12-2b1494e91e5f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((InstanceData) data).mOwner = value;
        }

        @objid ("486e7afc-dba2-4677-9e0c-5f75f35eaccf")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getDeclaredDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9085a2ab-e74f-461a-8a4d-6a32f01d3009")
    public static class OwnedNaryEndSmDependency extends SmMultipleDependency {
        @objid ("12edf5e0-0e66-4e97-a60f-2874377d2199")
        private SmDependency symetricDep;

        @objid ("1fa659cf-2e0c-42a0-8e7a-64bea9d0bf3b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mOwnedNaryEnd != null)? ((InstanceData)data).mOwnedNaryEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("4760d0a3-69cb-4784-bf27-6d5ea0e43911")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mOwnedNaryEnd = values;

        }

        @objid ("b1081a28-3ade-4b0c-8820-e087275d68c8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NaryLinkEndSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("edbee7b2-d614-4c3f-bcc8-dbc48c34a1e2")
    public static class RepresentedLifeLineSmDependency extends SmMultipleDependency {
        @objid ("65c6b0dd-d99e-46bd-b0c2-b2f95c371329")
        private SmDependency symetricDep;

        @objid ("4770b25f-d0bc-41e0-aec4-418086223f7b")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mRepresentedLifeLine != null)? ((InstanceData)data).mRepresentedLifeLine:SmMultipleDependency.EMPTY;
        }

        @objid ("b3d1b813-fb84-4b77-a23c-fb22b5fb26a8")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mRepresentedLifeLine = values;

        }

        @objid ("b71c6a5b-f639-4aaa-9d00-977ff0ca35e7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LifelineSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("9ddfd5f2-8378-4266-b2fc-329f0ddd1c2a")
    public static class SlotSmDependency extends SmMultipleDependency {
        @objid ("b93305a3-4ce3-4969-94c0-9ad6b7333293")
        private SmDependency symetricDep;

        @objid ("305859fd-f7aa-4bbf-ae86-2d95cd1910fe")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mSlot != null)? ((InstanceData)data).mSlot:SmMultipleDependency.EMPTY;
        }

        @objid ("c734f125-cb2e-45b0-96fd-459dcd8e6c19")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mSlot = values;

        }

        @objid ("f39da27c-cac9-425e-b68d-d9ed9d71244d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((AttributeLinkSmClass)this.getTarget()).getAttributedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("2e30ef5f-7b96-4696-9205-718e44ba77ad")
    public static class PartSmDependency extends SmMultipleDependency {
        @objid ("32cdb493-73b5-49fb-81c5-d60abf72ff54")
        private SmDependency symetricDep;

        @objid ("4908f526-596a-40ee-8972-9ef35c7b36a1")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mPart != null)? ((InstanceData)data).mPart:SmMultipleDependency.EMPTY;
        }

        @objid ("858bc6ab-02c0-42c6-bda5-bc4915468a27")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mPart = values;

        }

        @objid ("247b23dd-d5f0-4760-a314-ea81f7997d06")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BindableInstanceSmClass)this.getTarget()).getClusterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("74095a21-6d7b-4865-83c5-345404b9158b")
    public static class TargetingEndSmDependency extends SmMultipleDependency {
        @objid ("07fd39d3-2a3d-4af0-a809-3cfe785524e5")
        private SmDependency symetricDep;

        @objid ("24a9393f-bddf-42f6-826c-f82cd5529dd2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((InstanceData)data).mTargetingEnd != null)? ((InstanceData)data).mTargetingEnd:SmMultipleDependency.EMPTY;
        }

        @objid ("897c42a3-da6c-40bb-9b64-de8b90509b64")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((InstanceData) data).mTargetingEnd = values;

        }

        @objid ("fecc80ce-65d8-4c57-8ffb-d3fafbf78c31")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((LinkEndSmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

}
