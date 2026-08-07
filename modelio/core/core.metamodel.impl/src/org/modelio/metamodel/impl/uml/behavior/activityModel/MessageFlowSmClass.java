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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityEdge;
import org.modelio.metamodel.uml.behavior.activityModel.ActivityPartition;
import org.modelio.metamodel.uml.behavior.activityModel.MessageFlow;
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

@objid ("6af4dd1b-0c08-431b-83a8-2f3b5e01d271")
public class MessageFlowSmClass extends ActivityEdgeSmClass {
    @objid ("c763582e-2f1a-4fc7-b337-2ef908086536")
    private SmDependency targetPartitionDep;

    @objid ("caade78b-9e90-44a7-9afc-d58d4b7a032f")
    private SmDependency sourcePartitionDep;

    @objid ("1278434c-f099-4314-8347-8d84d255a755")
    public MessageFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f50e3877-31a3-4ed8-b32b-da45fb53cfc0")
    @Override
    public String getName() {
        return "MessageFlow";

    }

    @objid ("66537a00-944b-4bb5-aa7c-cb8c71bc2fe6")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("65630be1-dbb2-432d-aa79-85d02b65d5a6")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return MessageFlow.class;

    }

    @objid ("b0f7c64a-a30b-4f03-af14-0fe448424569")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("0e06c8a8-7b5f-482e-87e9-c1340e56cd54")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6897c884-4566-4610-b6cf-dde1aa7e2bde")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(ActivityEdge.MQNAME);
        this.registerFactory(new MessageFlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.targetPartitionDep = new TargetPartitionSmDependency();
        this.targetPartitionDep.init("TargetPartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.targetPartitionDep);

        this.sourcePartitionDep = new SourcePartitionSmDependency();
        this.sourcePartitionDep.init("SourcePartition", this, metamodel.getMClass(ActivityPartition.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.sourcePartitionDep);

    }

    @objid ("9fca7a7e-a03b-4ee5-9773-af04480a725d")
    public SmDependency getTargetPartitionDep() {
        if (this.targetPartitionDep == null) {
        	this.targetPartitionDep = this.getDependencyDef("TargetPartition");
        }
        return this.targetPartitionDep;
    }

    @objid ("93482ede-771e-42af-96f3-ad9e56660e11")
    public SmDependency getSourcePartitionDep() {
        if (this.sourcePartitionDep == null) {
        	this.sourcePartitionDep = this.getDependencyDef("SourcePartition");
        }
        return this.sourcePartitionDep;
    }

    @objid ("3e72c7a4-9d87-4fb4-8396-93fd4196eaf9")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("f46ca5ff-f9ee-45c3-922a-a93c5744c3e8")
    private static class MessageFlowObjectFactory implements ISmObjectFactory {
        @objid ("9a433941-5aba-4ebc-b1e0-d83c7e8faefd")
        private MessageFlowSmClass smClass;

        @objid ("d7c84a02-c083-4d13-85a1-abd369725b98")
        public MessageFlowObjectFactory(MessageFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("436dcf41-90a3-4a68-ab05-cd3373d6bbe9")
        @Override
        public ISmObjectData createData() {
            return new MessageFlowData(this.smClass);
        }

        @objid ("33208b05-6daf-4a6b-a794-148dd819e5b0")
        @Override
        public SmObjectImpl createImpl() {
            return new MessageFlowImpl();
        }

    }

    @objid ("a4ce1fe3-0268-480b-9f26-e7b9184e6dd7")
    public static class TargetPartitionSmDependency extends SmSingleDependency {
        @objid ("c2404f98-4666-4916-b877-d899fcf8f49f")
        private SmDependency symetricDep;

        @objid ("beaa10bd-e64a-47cb-aa3b-d7b1c8a0d456")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageFlowData) data).mTargetPartition;
        }

        @objid ("fb100586-712d-4cc7-a5b2-4205e0383ef0")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageFlowData) data).mTargetPartition = value;
        }

        @objid ("37208a40-fdbc-47a6-a99d-1460ad8648ec")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getIncomingDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("cd246c81-be2b-459d-9279-89164f1f6d9d")
    public static class SourcePartitionSmDependency extends SmSingleDependency {
        @objid ("450d04be-a8d3-492d-bab6-cf6afe519c48")
        private SmDependency symetricDep;

        @objid ("65f9b749-9c30-4f35-94da-b6c6b2288d15")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((MessageFlowData) data).mSourcePartition;
        }

        @objid ("225c08dc-32eb-4475-b929-2ac9c73ffda9")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((MessageFlowData) data).mSourcePartition = value;
        }

        @objid ("14e4ae66-b3d2-49f1-9710-afb4969f16af")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ActivityPartitionSmClass)this.getTarget()).getOutgoingDep();
            }
            return this.symetricDep;

        }

    }

}
