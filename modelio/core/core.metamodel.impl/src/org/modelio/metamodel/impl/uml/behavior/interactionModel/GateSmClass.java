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
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.CombinedFragment;
import org.modelio.metamodel.uml.behavior.interactionModel.Gate;
import org.modelio.metamodel.uml.behavior.interactionModel.Interaction;
import org.modelio.metamodel.uml.behavior.interactionModel.InteractionUse;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
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

@objid ("13e4b29b-d374-4a42-88de-bb3e167df301")
public class GateSmClass extends MessageEndSmClass {
    @objid ("686e23bd-d2d7-493e-befd-a6714ed0ce3e")
    private SmDependency ownerUseDep;

    @objid ("07074d1a-7d7c-49a1-a0cf-6b0a33c8655c")
    private SmDependency actualDep;

    @objid ("3d45b8f2-68d3-4ddd-8265-e1211019e04c")
    private SmDependency ownerInteractionDep;

    @objid ("08cbedf3-2929-4f38-8203-abaa9bccf064")
    private SmDependency ownerFragmentDep;

    @objid ("be0758db-7012-431d-a1fe-e10d00466a57")
    private SmDependency formalDep;

    @objid ("5b766cb1-73fd-4084-9ccf-90dcad13e902")
    public GateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("269ef46a-c0ba-40b2-a29b-de2b9051fdeb")
    @Override
    public String getName() {
        return "Gate";

    }

    @objid ("2ee0c281-409f-4726-9455-9b9695ffe2ea")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("7ec29677-8b3a-4331-84e7-af67580510a5")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return Gate.class;

    }

    @objid ("3b88c767-c113-4b3f-a80d-086fc28466ef")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("02118309-734c-4a43-8169-4f7b68775fbf")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("37f35f14-1ac4-4e7c-9132-a4b826f370b2")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MessageEnd.MQNAME);
        this.registerFactory(new GateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.ownerUseDep = new OwnerUseSmDependency();
        this.ownerUseDep.init("OwnerUse", this, metamodel.getMClass(InteractionUse.MQNAME), 0, 1 );
        registerDependency(this.ownerUseDep);

        this.actualDep = new ActualSmDependency();
        this.actualDep.init("Actual", this, metamodel.getMClass(Gate.MQNAME), 0, -1 );
        registerDependency(this.actualDep);

        this.ownerInteractionDep = new OwnerInteractionSmDependency();
        this.ownerInteractionDep.init("OwnerInteraction", this, metamodel.getMClass(Interaction.MQNAME), 0, 1 );
        registerDependency(this.ownerInteractionDep);

        this.ownerFragmentDep = new OwnerFragmentSmDependency();
        this.ownerFragmentDep.init("OwnerFragment", this, metamodel.getMClass(CombinedFragment.MQNAME), 0, 1 );
        registerDependency(this.ownerFragmentDep);

        this.formalDep = new FormalSmDependency();
        this.formalDep.init("Formal", this, metamodel.getMClass(Gate.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.formalDep);

    }

    @objid ("3766a5cc-43b1-43d4-aa7b-9f3a7a8713f6")
    public SmDependency getOwnerUseDep() {
        if (this.ownerUseDep == null) {
        	this.ownerUseDep = this.getDependencyDef("OwnerUse");
        }
        return this.ownerUseDep;
    }

    @objid ("d17b7b42-d2bf-4963-80fc-98cc6ae04efd")
    public SmDependency getActualDep() {
        if (this.actualDep == null) {
        	this.actualDep = this.getDependencyDef("Actual");
        }
        return this.actualDep;
    }

    @objid ("f65eb359-1aa1-45e3-9625-c6e91d6665dc")
    public SmDependency getOwnerInteractionDep() {
        if (this.ownerInteractionDep == null) {
        	this.ownerInteractionDep = this.getDependencyDef("OwnerInteraction");
        }
        return this.ownerInteractionDep;
    }

    @objid ("9f386a2c-63dd-4b97-b196-6dd0315879bc")
    public SmDependency getOwnerFragmentDep() {
        if (this.ownerFragmentDep == null) {
        	this.ownerFragmentDep = this.getDependencyDef("OwnerFragment");
        }
        return this.ownerFragmentDep;
    }

    @objid ("daceca4f-d09f-46be-963b-bb3fd9fbf888")
    public SmDependency getFormalDep() {
        if (this.formalDep == null) {
        	this.formalDep = this.getDependencyDef("Formal");
        }
        return this.formalDep;
    }

    @objid ("d9e21d60-fb7e-4e68-9d36-e3924396ca58")
    private static class GateObjectFactory implements ISmObjectFactory {
        @objid ("22ffcdea-1f31-4a6f-a5b6-65dbcb666807")
        private GateSmClass smClass;

        @objid ("7bc70b70-a25c-4671-9d9e-1936d3663d70")
        public GateObjectFactory(GateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("bc486867-9c25-48ef-9f09-473967373265")
        @Override
        public ISmObjectData createData() {
            return new GateData(this.smClass);
        }

        @objid ("57c71074-0851-40e0-8664-3d9ead528b3b")
        @Override
        public SmObjectImpl createImpl() {
            return new GateImpl();
        }

    }

    @objid ("f8c1c3f7-092c-48cf-a5a7-b7b9d6dda132")
    public static class OwnerUseSmDependency extends SmSingleDependency {
        @objid ("5aa984b6-28ac-49ca-9b91-9d33d8c6da01")
        private SmDependency symetricDep;

        @objid ("e53ba13c-b1cb-4b55-b6eb-8a25c9b55583")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GateData) data).mOwnerUse;
        }

        @objid ("4a243cd9-0b30-4e8f-b5f3-d3fd8ee842ae")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GateData) data).mOwnerUse = value;
        }

        @objid ("72c6a5a9-53d0-4a26-8e72-028ef0c33598")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionUseSmClass)this.getTarget()).getActualGateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("8522dba8-9b2a-4144-a6c3-af2e6af2dc0e")
    public static class ActualSmDependency extends SmMultipleDependency {
        @objid ("7b1a3d9e-ac58-4563-8dde-54f2cad53f1c")
        private SmDependency symetricDep;

        @objid ("bfd062b9-d7eb-448c-b9c6-770fb6d6ea8e")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((GateData)data).mActual != null)? ((GateData)data).mActual:SmMultipleDependency.EMPTY;
        }

        @objid ("645c2263-f107-4a1f-83d2-60ff3f731a1a")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((GateData) data).mActual = values;

        }

        @objid ("bd0f6fcf-05df-46d1-a63c-4e6578e840f8")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GateSmClass)this.getTarget()).getFormalDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b6ae6581-1e1d-4c74-b3c3-bf8f7bad18de")
    public static class OwnerInteractionSmDependency extends SmSingleDependency {
        @objid ("3d24e028-c224-4310-a4a4-b0c5fe5b7028")
        private SmDependency symetricDep;

        @objid ("d29d3622-347c-4e78-a13b-055c22c63131")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GateData) data).mOwnerInteraction;
        }

        @objid ("0835bb2a-eac3-4fdc-aacd-45806a255ac5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GateData) data).mOwnerInteraction = value;
        }

        @objid ("4dbdf288-4f99-467f-a890-6c43b699cd39")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((InteractionSmClass)this.getTarget()).getFormalGateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("31a12d96-28a4-4c12-a101-67ecf0441025")
    public static class OwnerFragmentSmDependency extends SmSingleDependency {
        @objid ("00fdb651-e431-49be-8f8a-6edcb56467dc")
        private SmDependency symetricDep;

        @objid ("3fb2715c-fd3c-4297-b743-5d6ef8d1b49a")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GateData) data).mOwnerFragment;
        }

        @objid ("0fb3a373-6994-450c-806b-201356f7ea14")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GateData) data).mOwnerFragment = value;
        }

        @objid ("34e118d3-d23f-4463-af44-80b8fe21533a")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((CombinedFragmentSmClass)this.getTarget()).getFragmentGateDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("b25e318b-7977-417a-adf5-695b1496a47a")
    public static class FormalSmDependency extends SmSingleDependency {
        @objid ("2b600a75-3aa6-49a1-ae92-bfd973f3f9b4")
        private SmDependency symetricDep;

        @objid ("e0157607-cc03-40d7-b4bb-d95b823c7060")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((GateData) data).mFormal;
        }

        @objid ("8e0a20d1-d106-47e6-a236-b361a5529ffd")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((GateData) data).mFormal = value;
        }

        @objid ("bfb12262-229b-46eb-9a47-ad4c8200ca2b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((GateSmClass)this.getTarget()).getActualDep();
            }
            return this.symetricDep;

        }

    }

}
