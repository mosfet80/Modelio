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
package org.modelio.metamodel.impl.uml.behavior.activityModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityGroup;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.MessageFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("4a14a4a5-a6b6-4222-990c-bf3308b3811e")
public class ActivityPartitionSmClass extends ActivityGroupSmClass {
    @objid ("9bef9e12-225e-4296-a966-713476f7ca76")
    private SmAttribute isDimensionAtt;

    @objid ("fea91bb3-dd4a-4904-8fb7-23242814e068")
    private SmAttribute isExternalAtt;

    @objid ("248ae054-86de-4bfe-b9e6-f8b117b971e6")
    private SmDependency representedDep;

    @objid ("402436dd-8ddd-4a7c-9ba7-db2d6751dde3")
    private SmDependency containedNodeDep;

    @objid ("a7cf5172-c162-4cd7-9827-1fc6381b4b86")
    private SmDependency outgoingDep;

    @objid ("de18a92c-0803-4d31-95f9-0129a7e2b439")
    private SmDependency superPartitionDep;

    @objid ("cebabc43-6794-49cf-ac9e-b962f072bb11")
    private SmDependency subPartitionDep;

    @objid ("5628e5fa-73cd-4f1c-9d92-9e90b7ac60bb")
    private SmDependency incomingDep;

    @objid ("5963e35f-52a6-4de0-b37a-cf01111fe3ba")
    public ActivityPartitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("c673d018-61de-4495-80e9-6ab62c1cc845")
    @Override
    public String getName() {
        return "ActivityPartition";

    }

    @objid ("cefaf815-5a49-47de-bd2a-2cde84e95dde")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("40431b37-2888-4129-8569-6f8f3d4b294a")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityPartition.class;

    }

    @objid ("0dbfe382-ec76-4329-a57e-00a8bebafafe")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1764f75b-f264-4504-af62-63a9df2846e1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("315d5ec9-2348-46e1-a1ab-3a92dc2592a7")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityGroup.MQNAME);
        this.registerFactory(new ActivityPartitionObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isDimensionAtt = new IsDimensionSmAttribute();
        this.isDimensionAtt.init("IsDimension", this, Boolean.class );
        registerAttribute(this.isDimensionAtt);

        this.isExternalAtt = new IsExternalSmAttribute();
        this.isExternalAtt.init("IsExternal", this, Boolean.class );
        registerAttribute(this.isExternalAtt);


        // Initialize and register the SmDependency
        this.representedDep = new RepresentedSmDependency();
        this.representedDep.init("Represented", this, metamodel.getMClass(UmlModelElement.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.representedDep);

        this.containedNodeDep = new ContainedNodeSmDependency();
        this.containedNodeDep.init("ContainedNode", this, metamodel.getMClass(ActivityNode.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.containedNodeDep);

        this.outgoingDep = new OutgoingSmDependency();
        this.outgoingDep.init("Outgoing", this, metamodel.getMClass(MessageFlow.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.outgoingDep);

        this.superPartitionDep = new SuperPartitionSmDependency();
        this.superPartitionDep.init("SuperPartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, 1 );
        registerDependency(this.superPartitionDep);

        this.subPartitionDep = new SubPartitionSmDependency();
        this.subPartitionDep.init("SubPartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.subPartitionDep);

        this.incomingDep = new IncomingSmDependency();
        this.incomingDep.init("Incoming", this, metamodel.getMClass(MessageFlow.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.incomingDep);

    }

    @objid ("80562ad8-ba40-4315-8ae0-205609d9d984")
    public SmAttribute getIsDimensionAtt() {
        if (this.isDimensionAtt == null) {
        	this.isDimensionAtt = this.getAttributeDef("IsDimension");
        }
        return this.isDimensionAtt;
    }

    @objid ("98e0e8a1-5c87-40dc-9849-5187db5b020b")
    public SmAttribute getIsExternalAtt() {
        if (this.isExternalAtt == null) {
        	this.isExternalAtt = this.getAttributeDef("IsExternal");
        }
        return this.isExternalAtt;
    }

    @objid ("a61e5037-68ca-4043-8406-1a4597ecca2a")
    public SmDependency getRepresentedDep() {
        if (this.representedDep == null) {
        	this.representedDep = this.getDependencyDef("Represented");
        }
        return this.representedDep;
    }

    @objid ("47b3d369-a24c-4735-bb72-0aae1a5a0d59")
    public SmDependency getContainedNodeDep() {
        if (this.containedNodeDep == null) {
        	this.containedNodeDep = this.getDependencyDef("ContainedNode");
        }
        return this.containedNodeDep;
    }

    @objid ("c520f1fa-19cd-40fd-92e3-09d7c852513b")
    public SmDependency getOutgoingDep() {
        if (this.outgoingDep == null) {
        	this.outgoingDep = this.getDependencyDef("Outgoing");
        }
        return this.outgoingDep;
    }

    @objid ("bb792103-96d7-4b2b-a248-bb5490369442")
    public SmDependency getSuperPartitionDep() {
        if (this.superPartitionDep == null) {
        	this.superPartitionDep = this.getDependencyDef("SuperPartition");
        }
        return this.superPartitionDep;
    }

    @objid ("b381e4c5-a25e-41a2-af80-8f6c3755d659")
    public SmDependency getSubPartitionDep() {
        if (this.subPartitionDep == null) {
        	this.subPartitionDep = this.getDependencyDef("SubPartition");
        }
        return this.subPartitionDep;
    }

    @objid ("ad92cbe0-b3d0-444c-ac02-575319a8f2c1")
    public SmDependency getIncomingDep() {
        if (this.incomingDep == null) {
        	this.incomingDep = this.getDependencyDef("Incoming");
        }
        return this.incomingDep;
    }

    @objid ("fef78210-3c28-4e6e-9c85-72d28feea250")
    private static class ActivityPartitionObjectFactory implements ISmObjectFactory {
        @objid ("b074fd60-e0ab-4ec6-a6e5-efaaa1e3e1b2")
        private ActivityPartitionSmClass smClass;

        @objid ("dce5b7b3-bed4-4e9b-95ed-bb1906fd52a1")
        public ActivityPartitionObjectFactory(ActivityPartitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("e77162ab-f017-4dd7-b97f-5aacf64224d5")
        @Override
        public ISmObjectData createData() {
            return new ActivityPartitionData(this.smClass);
        }

        @objid ("76ae45fb-e92f-4fa6-a4df-1676ba2962b3")
        @Override
        public SmObjectImpl createImpl() {
            return new ActivityPartitionImpl();
        }

    }

    @objid ("58335be6-9f7e-4fed-a885-a53d0193f45b")
    public static class IsDimensionSmAttribute extends SmAttribute {
        @objid ("04bfea41-51d6-4496-ae16-f367a092db71")
        public Object getValue(ISmObjectData data) {
            return ((ActivityPartitionData) data).mIsDimension;
        }

        @objid ("b9767a94-4270-4cbf-b881-af1fb206dd55")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityPartitionData) data).mIsDimension = value;
        }

    }

    @objid ("481c0611-3e67-41fe-a303-90c0dd0349c5")
    public static class IsExternalSmAttribute extends SmAttribute {
        @objid ("35a7f9be-a9b8-4b46-8f01-409ff270df66")
        public Object getValue(ISmObjectData data) {
            return ((ActivityPartitionData) data).mIsExternal;
        }

        @objid ("2b12c7c6-f5e8-42dc-8611-43802fbe291a")
        public void setValue(ISmObjectData data, Object value) {
            ((ActivityPartitionData) data).mIsExternal = value;
        }

    }

    @objid ("d4f65f98-e800-4796-88e9-ef88146b59fe")
    public static class RepresentedSmDependency extends SmSingleDependency {
        @objid ("948915ab-2591-4922-a35e-a6d992e959c8")
        private SmDependency symetricDep;

        @objid ("82c13b69-f448-4d5e-b45e-ae4637512fa0")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityPartitionData) data).mRepresented;
        }

        @objid ("c6f38d88-0928-4219-b9c6-b2af047d3a15")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityPartitionData) data).mRepresented = value;
        }

        @objid ("0913487f-e2e6-46fe-a559-164ba1a368f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((UmlModelElementSmClass)this.getTarget()).getRepresentingPartitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7324f895-b7c3-4a93-9242-3ace9609561f")
    public static class ContainedNodeSmDependency extends SmMultipleDependency {
        @objid ("df9a67dc-fbea-4299-8232-5e082fe8b5fb")
        private SmDependency symetricDep;

        @objid ("1dea3f14-c5db-4e7a-9c51-91db345d44af")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityPartitionData)data).mContainedNode != null)? ((ActivityPartitionData)data).mContainedNode:SmMultipleDependency.EMPTY;
        }

        @objid ("a273397e-00be-4b81-b7c1-1bb6e3c75a05")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityPartitionData) data).mContainedNode = values;

        }

        @objid ("9d1ac59d-22b6-48bb-9c5c-90431bd1be78")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityNodeSmClass)this.getTarget()).getOwnerPartitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7d9166de-3743-40dc-8349-520a825d6e80")
    public static class OutgoingSmDependency extends SmMultipleDependency {
        @objid ("b999ea49-ae81-4f96-9b10-f1e4c4e58571")
        private SmDependency symetricDep;

        @objid ("7653dca6-59cb-43d9-b636-9ba3a0412ac5")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityPartitionData)data).mOutgoing != null)? ((ActivityPartitionData)data).mOutgoing:SmMultipleDependency.EMPTY;
        }

        @objid ("de355867-a512-4561-8ccf-a453bf2b5e89")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityPartitionData) data).mOutgoing = values;

        }

        @objid ("9995cb87-7b48-4ed8-9e33-02b5a69b202f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageFlowSmClass)this.getTarget()).getSourcePartitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("0f63c2e4-11a1-4541-8f1b-b419b9ddfbb4")
    public static class SuperPartitionSmDependency extends SmSingleDependency {
        @objid ("8a78fa2e-0c59-45ca-b1a6-880acb7a9b38")
        private SmDependency symetricDep;

        @objid ("e6dfa62a-e228-4cfe-a141-6a9e8f3ee0cd")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityPartitionData) data).mSuperPartition;
        }

        @objid ("7a30e49f-feed-4238-b45c-16303cc33ac3")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityPartitionData) data).mSuperPartition = value;
        }

        @objid ("016646c6-23c0-45b1-b1f9-fa943382db57")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getSubPartitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("970515b9-8e49-498e-9e52-c5eefb7e96bf")
    public static class SubPartitionSmDependency extends SmMultipleDependency {
        @objid ("d993933d-e0db-4f8c-8d11-1a4221c3e1d7")
        private SmDependency symetricDep;

        @objid ("d9eb56d8-d20b-4db7-bb4a-fe4a6f9d964f")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityPartitionData)data).mSubPartition != null)? ((ActivityPartitionData)data).mSubPartition:SmMultipleDependency.EMPTY;
        }

        @objid ("a0ee3b04-4cdb-44c6-a292-f4348d491f1e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityPartitionData) data).mSubPartition = values;

        }

        @objid ("64d5b8da-7dc4-412f-865d-ee3136fd3df8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getSuperPartitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1c5dc013-54ad-41bf-a85c-aa94d0b4cefb")
    public static class IncomingSmDependency extends SmMultipleDependency {
        @objid ("e8a2c980-6bfd-467d-bf9a-1a7ac2a6f76f")
        private SmDependency symetricDep;

        @objid ("4362245e-2023-4f2c-839b-3317e2aa3e9c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityPartitionData)data).mIncoming != null)? ((ActivityPartitionData)data).mIncoming:SmMultipleDependency.EMPTY;
        }

        @objid ("9265fc6f-1633-4c13-8b16-67508d6ffd21")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityPartitionData) data).mIncoming = values;

        }

        @objid ("6e261182-a947-4eb3-826d-18a0c9384d3e")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((MessageFlowSmClass)this.getTarget()).getTargetPartitionDep();
            }
            return this.symetricDep;

        }

    }

}
