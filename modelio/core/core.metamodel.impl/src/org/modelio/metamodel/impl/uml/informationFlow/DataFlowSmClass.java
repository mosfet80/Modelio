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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.SignalSmClass;
import org.modelio.metamodel.impl.uml.infrastructure.UmlModelElementSmClass;
import org.modelio.metamodel.impl.uml.statik.NameSpaceSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Signal;
import org.modelio.metamodel.uml.informationFlow.DataFlow;
import org.modelio.metamodel.uml.infrastructure.UmlModelElement;
import org.modelio.metamodel.uml.statik.NameSpace;
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

@objid ("5e287ca6-25cf-4a81-bd76-c3652252c3ae")
public class DataFlowSmClass extends UmlModelElementSmClass {
    @objid ("776b47d0-6c91-40df-996b-38666550a229")
    private SmDependency destinationDep;

    @objid ("b4510288-cfe6-48a0-b8fa-73367acd28d9")
    private SmDependency originDep;

    @objid ("91b185d2-ce8e-48f7-8dc4-4de7ce428143")
    private SmDependency ownerDep;

    @objid ("bf96ad80-bde3-4ade-911e-11a72e18b0ec")
    private SmDependency sModelDep;

    @objid ("0d2dd99f-ca72-44d6-9d4c-a3f7b4448cd5")
    public DataFlowSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("e63f6218-5e3d-431d-925c-bf09188f9672")
    @Override
    public String getName() {
        return "DataFlow";

    }

    @objid ("0c2790cc-74c5-4ab9-a3c7-8e7eb1a8a76c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("665dd309-cee4-4d3a-8a9b-886235b4bb4f")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return DataFlow.class;

    }

    @objid ("99aac544-fafe-4d9e-9544-e14048f2595a")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9db87fd1-1208-4a5d-a083-45f9374790b5")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("28b1f881-cac2-4268-9193-e78529c476f0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(UmlModelElement.MQNAME);
        this.registerFactory(new DataFlowObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.destinationDep = new DestinationSmDependency();
        this.destinationDep.init("Destination", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKTARGET, SmDirective.SMCDPARTOF);
        registerDependency(this.destinationDep);

        this.originDep = new OriginSmDependency();
        this.originDep.init("Origin", this, metamodel.getMClass(NameSpace.MQNAME), 0, 1 , SmDirective.SMCDLINKSOURCE);
        registerDependency(this.originDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(NameSpace.MQNAME), 1, 1 );
        registerDependency(this.ownerDep);

        this.sModelDep = new SModelSmDependency();
        this.sModelDep.init("SModel", this, metamodel.getMClass(Signal.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.sModelDep);

    }

    @objid ("07f35397-f469-4e2a-bf66-145140c454e7")
    public SmDependency getDestinationDep() {
        if (this.destinationDep == null) {
        	this.destinationDep = this.getDependencyDef("Destination");
        }
        return this.destinationDep;
    }

    @objid ("a2be4578-43ba-40b0-a776-57d71ac64cb9")
    public SmDependency getOriginDep() {
        if (this.originDep == null) {
        	this.originDep = this.getDependencyDef("Origin");
        }
        return this.originDep;
    }

    @objid ("c3847df9-24aa-413d-b412-298945284fcb")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("61fe6c85-0bcc-4989-bbd1-294459189ae4")
    public SmDependency getSModelDep() {
        if (this.sModelDep == null) {
        	this.sModelDep = this.getDependencyDef("SModel");
        }
        return this.sModelDep;
    }

    @objid ("de9b291e-7990-4aec-8e2f-f731ab3bd819")
    @Override
    public boolean isLinkMetaclass() {
        return true;

    }

    @objid ("ed334312-1f9f-4246-a411-90b790e90110")
    private static class DataFlowObjectFactory implements ISmObjectFactory {
        @objid ("055e916c-2551-4298-9b7c-d5f32015427e")
        private DataFlowSmClass smClass;

        @objid ("bb2a06e8-732c-4b48-9430-fc19d6762ee9")
        public DataFlowObjectFactory(DataFlowSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("7c679cc8-880f-4f03-bb63-3954f7070a2d")
        @Override
        public ISmObjectData createData() {
            return new DataFlowData(this.smClass);
        }

        @objid ("cd52c36e-e65b-4755-b210-84054af537cb")
        @Override
        public SmObjectImpl createImpl() {
            return new DataFlowImpl();
        }

    }

    @objid ("df7d12c1-5172-424c-9495-c4d5ac2c757e")
    public static class DestinationSmDependency extends SmSingleDependency {
        @objid ("b60d57eb-1c71-435e-b559-3948e7245c47")
        private SmDependency symetricDep;

        @objid ("a7a1ce5f-7654-4349-b9ae-b876b70d0af6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((DataFlowData) data).mDestination;
        }

        @objid ("315a78f7-f75d-4312-8053-da8ea2c5cc69")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((DataFlowData) data).mDestination = value;
        }

        @objid ("28267161-eb78-44c0-ad4e-8664daa701f4")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getReceivedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("82ada976-ba32-4c6c-92a1-f7143b1672c4")
    public static class OriginSmDependency extends SmSingleDependency {
        @objid ("ffc75ab3-cd93-4b61-a767-1e5d421475b6")
        private SmDependency symetricDep;

        @objid ("3876af85-a755-4799-8391-88d2394cf8b9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((DataFlowData) data).mOrigin;
        }

        @objid ("e60a2ab6-338b-4463-8d3e-25ceed907b5d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((DataFlowData) data).mOrigin = value;
        }

        @objid ("2f8065dc-fabe-457b-b32b-89211a2c7025")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getSentDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d725250d-a748-4e36-83b5-17efdbec0593")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("ae6c7a64-6b01-4496-9455-0459a97ed122")
        private SmDependency symetricDep;

        @objid ("56ce189d-9d32-4395-8767-78c04b64f6b7")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((DataFlowData) data).mOwner;
        }

        @objid ("40b0ac1b-3a70-4264-9fe1-b726ae86fad6")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((DataFlowData) data).mOwner = value;
        }

        @objid ("def31305-3c4d-44d9-a6a6-b96a00895649")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((NameSpaceSmClass)this.getTarget()).getOwnedDataFlowDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("28f75e18-6b56-46b3-ad15-8b5beb6fea85")
    public static class SModelSmDependency extends SmSingleDependency {
        @objid ("38ff9d08-2b5a-4909-923d-d03b8b5d06b1")
        private SmDependency symetricDep;

        @objid ("b4ccbf02-eb37-41d2-85dc-8c24991ec2d3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((DataFlowData) data).mSModel;
        }

        @objid ("5dd5110c-7b99-4fcf-8674-93d8d6529753")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((DataFlowData) data).mSModel = value;
        }

        @objid ("52021467-1690-4c0e-8f2a-a0d7dd24d299")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((SignalSmClass)this.getTarget()).getDOccurenceDep();
            }
            return this.symetricDep;

        }

    }

}
