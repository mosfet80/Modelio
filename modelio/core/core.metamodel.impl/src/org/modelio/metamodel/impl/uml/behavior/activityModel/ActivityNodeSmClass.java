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
import org.modelio.metamodel.uml.behavior.activityModel.Activity;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityNode;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.Clause;
import org.modelio.metamodel.uml.behavior.activityModel.StructuredActivityNode;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
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

@objid ("8d2f590b-0d3a-4c92-8c33-7c5fc66bec82")
public class ActivityNodeSmClass extends UmlModelElementSmClass {
    @objid ("b038044a-9e2e-40a2-a0ae-c0da0d013ca3")
    private SmDependency ownerDep;

    @objid ("0da1416d-7ba9-4e5b-a56f-95567530f973")
    private SmDependency ownerPartitionDep;

    @objid ("bc3927c3-5ed9-4b1a-8fed-78f66e327d65")
    private SmDependency incomingDep;

    @objid ("f3ec6976-b442-457a-b5d3-3bfa67cd9564")
    private SmDependency ownerClauseDep;

    @objid ("9fae4e74-d79c-454c-9486-a9a6f188ef13")
    private SmDependency ownerNodeDep;

    @objid ("b7978990-9da4-4df8-93f1-dc90a91fad3b")
    private SmDependency outgoingDep;

    @objid ("075fe47d-d4bd-4e8a-9d9f-c00d138a0a7c")
    public ActivityNodeSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("6e8e6107-28fa-4d02-b20d-dd91a1a1cdfe")
    @Override
    public String getName() {
        return "ActivityNode";

    }

    @objid ("878854d2-102b-42e8-9124-88fd0af7a8f1")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("180e4c29-e345-452c-ac89-bf7695a5a8dd")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ActivityNode.class;

    }

    @objid ("60d0903a-4bf4-49ce-a669-ff688e7439ff")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f181758e-d789-4d8a-b8a0-1fcfd518e99f")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("8d0f885f-34d7-44cd-a0e5-454e5bcd0984")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new ActivityNodeObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Activity.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.ownerPartitionDep = new OwnerPartitionSmDependency();
        this.ownerPartitionDep.init("OwnerPartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, 1 );
        registerDependency(this.ownerPartitionDep);

        this.incomingDep = new IncomingSmDependency();
        this.incomingDep.init("Incoming", this, metamodel.getMClass(ActivityEdge.MQNAME), 0, -1 , SmDirective.SMCDTODELETE);
        registerDependency(this.incomingDep);

        this.ownerClauseDep = new OwnerClauseSmDependency();
        this.ownerClauseDep.init("OwnerClause", this, metamodel.getMClass(Clause.MQNAME), 0, 1 );
        registerDependency(this.ownerClauseDep);

        this.ownerNodeDep = new OwnerNodeSmDependency();
        this.ownerNodeDep.init("OwnerNode", this, metamodel.getMClass(StructuredActivityNode.MQNAME), 0, 1 );
        registerDependency(this.ownerNodeDep);

        this.outgoingDep = new OutgoingSmDependency();
        this.outgoingDep.init("Outgoing", this, metamodel.getMClass(ActivityEdge.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.outgoingDep);

    }

    @objid ("514dca81-b028-4fb9-9e89-18714d37228d")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("13ecd9f5-6727-4a33-bd7e-6faa02bdee12")
    public SmDependency getOwnerPartitionDep() {
        if (this.ownerPartitionDep == null) {
        	this.ownerPartitionDep = this.getDependencyDef("OwnerPartition");
        }
        return this.ownerPartitionDep;
    }

    @objid ("2a8e5f10-1c26-4481-8603-1a815d3a0168")
    public SmDependency getIncomingDep() {
        if (this.incomingDep == null) {
        	this.incomingDep = this.getDependencyDef("Incoming");
        }
        return this.incomingDep;
    }

    @objid ("1c6d03f3-bfe5-48bb-9339-7615aeed580f")
    public SmDependency getOwnerClauseDep() {
        if (this.ownerClauseDep == null) {
        	this.ownerClauseDep = this.getDependencyDef("OwnerClause");
        }
        return this.ownerClauseDep;
    }

    @objid ("f1a259d9-f430-4e0b-b746-05f498b5b74d")
    public SmDependency getOwnerNodeDep() {
        if (this.ownerNodeDep == null) {
        	this.ownerNodeDep = this.getDependencyDef("OwnerNode");
        }
        return this.ownerNodeDep;
    }

    @objid ("2f0d0de4-64d3-4466-9de4-02a51c7c60cc")
    public SmDependency getOutgoingDep() {
        if (this.outgoingDep == null) {
        	this.outgoingDep = this.getDependencyDef("Outgoing");
        }
        return this.outgoingDep;
    }

    @objid ("c58e5b63-d0e3-4933-a580-226a5cbad281")
    private static class ActivityNodeObjectFactory implements ISmObjectFactory {
        @objid ("b8d6723d-e0e1-49de-9ce8-75b7e2312664")
        private ActivityNodeSmClass smClass;

        @objid ("05142d0a-31d6-4877-98a8-d705e05ed4ba")
        public ActivityNodeObjectFactory(ActivityNodeSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("93f88678-96ec-496d-a643-562f0536f5d5")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("1a61049a-9f9f-4895-83ba-5efaecf94a9b")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("011d4468-3ba8-484d-a415-bc611b01ab30")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("9b0deed2-4601-444f-96e9-cc0373dc9707")
        private SmDependency symetricDep;

        @objid ("d316b183-a652-4e42-af24-658bffbad57b")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityNodeData) data).mOwner;
        }

        @objid ("f535b64a-1e36-48b2-87f6-962dcb10a7d6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityNodeData) data).mOwner = value;
        }

        @objid ("91e2a434-93cc-4c34-b72b-a4851a133475")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivitySmClass)this.getTarget()).getOwnedNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("315d7b45-87b4-4f21-b415-3dc3485e85e8")
    public static class OwnerPartitionSmDependency extends SmSingleDependency {
        @objid ("219f7d6b-059d-4717-b14f-3b1826dc37bb")
        private SmDependency symetricDep;

        @objid ("1ed0b055-b981-4a6c-8376-0605cfbd867e")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityNodeData) data).mOwnerPartition;
        }

        @objid ("992ad7b9-1006-4b6e-8cb1-c1edec32609d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityNodeData) data).mOwnerPartition = value;
        }

        @objid ("d30a2025-3eab-40a3-8bd0-720623709e9f")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getContainedNodeDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("25680ebe-38c4-4407-bc50-a53bf29becdd")
    public static class IncomingSmDependency extends SmMultipleDependency {
        @objid ("edd6c1ad-68a3-493f-bbc8-59c540c66ec1")
        private SmDependency symetricDep;

        @objid ("aafbd98e-8999-45ae-ac73-3baa10185cbc")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityNodeData)data).mIncoming != null)? ((ActivityNodeData)data).mIncoming:SmMultipleDependency.EMPTY;
        }

        @objid ("258b5cf8-1d28-4720-90a9-66a2e585d5f3")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityNodeData) data).mIncoming = values;

        }

        @objid ("4fe4b53d-0239-47df-8290-ac64c32bfa42")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityEdgeSmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("ac0c2517-4ef8-4ae1-9e58-23f5bc7a38b1")
    public static class OwnerClauseSmDependency extends SmSingleDependency {
        @objid ("7166ead1-b6fa-47a0-8f1d-c4c25d97c539")
        private SmDependency symetricDep;

        @objid ("37a4bdc5-0de1-47ae-8152-0999675b79d2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityNodeData) data).mOwnerClause;
        }

        @objid ("3162153a-bf39-40e7-8a10-267ee85a2f4f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityNodeData) data).mOwnerClause = value;
        }

        @objid ("665d7d7a-a1ac-4c1f-bc0c-7382f484deb4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ClauseSmClass)this.getTarget()).getBodyDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("bd141321-fa1e-4a7d-b64b-30fde41de35e")
    public static class OwnerNodeSmDependency extends SmSingleDependency {
        @objid ("988d80b9-2c8e-4ab4-a3a9-cd76fa289102")
        private SmDependency symetricDep;

        @objid ("518dd66c-cf97-46e7-9806-f2bd9ee2ce5a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ActivityNodeData) data).mOwnerNode;
        }

        @objid ("b27f6fb1-315e-4784-9cef-3cc1f5ae0548")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ActivityNodeData) data).mOwnerNode = value;
        }

        @objid ("71617a95-880a-44f4-91b9-060a02d3e218")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StructuredActivityNodeSmClass)this.getTarget()).getBodyDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("59638af5-9a0c-485b-81f8-3c310c71c56e")
    public static class OutgoingSmDependency extends SmMultipleDependency {
        @objid ("56a0dda6-5efb-4344-9f0c-2f056e4892cb")
        private SmDependency symetricDep;

        @objid ("9c9a7b4a-0878-46b3-8349-b98798e5fb08")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ActivityNodeData)data).mOutgoing != null)? ((ActivityNodeData)data).mOutgoing:SmMultipleDependency.EMPTY;
        }

        @objid ("18473e37-7191-4ff7-80aa-786b0270eff0")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ActivityNodeData) data).mOutgoing = values;

        }

        @objid ("97035b5c-6ac6-418b-bbd7-67ee1b37c3e3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityEdgeSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

}
