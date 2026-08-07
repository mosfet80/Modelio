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
package org.modelio.metamodel.impl.uml.behavior.stateMachineModel;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.stateMachineModel.AbstractPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
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

@objid ("235804a1-d997-4750-84a6-c6994e26fecd")
public class EntryPointPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("ed8dbfbc-4d77-48bc-aa6b-9868034e0a7b")
    private SmDependency entryOfDep;

    @objid ("0a0db7be-1c5f-4c75-a160-66bd3bd0e94f")
    private SmDependency connectionDep;

    @objid ("15b9dfb8-1bd4-490b-aa0e-e2c92780357d")
    private SmDependency entryOfMachineDep;

    @objid ("d0b664ab-6beb-47f5-aa4d-05bf715b1c9a")
    public EntryPointPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5419d02f-404a-43ae-b193-a5f6a13fc80f")
    @Override
    public String getName() {
        return "EntryPointPseudoState";

    }

    @objid ("1b32118f-2bc8-4f75-bfb2-424dbbbe203c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("a4c76dd2-16ca-48a8-a3f0-bebd2c8cb95e")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return EntryPointPseudoState.class;

    }

    @objid ("e78ab8f7-9933-4bfc-b049-da05be0c10a9")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("5dde5fbd-06d0-45ba-965b-ab1c10d94d6e")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a87c5bd1-4e9d-4b95-98ab-2965439ab70c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new EntryPointPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.entryOfDep = new EntryOfSmDependency();
        this.entryOfDep.init("EntryOf", this, metamodel.getMClass(State.MQNAME), 0, 1 );
        registerDependency(this.entryOfDep);

        this.connectionDep = new ConnectionSmDependency();
        this.connectionDep.init("Connection", this, metamodel.getMClass(ConnectionPointReference.MQNAME), 0, -1 );
        registerDependency(this.connectionDep);

        this.entryOfMachineDep = new EntryOfMachineSmDependency();
        this.entryOfMachineDep.init("EntryOfMachine", this, metamodel.getMClass(StateMachine.MQNAME), 0, 1 );
        registerDependency(this.entryOfMachineDep);

    }

    @objid ("93809deb-2194-41f2-a357-29ef3db465a0")
    public SmDependency getEntryOfDep() {
        if (this.entryOfDep == null) {
        	this.entryOfDep = this.getDependencyDef("EntryOf");
        }
        return this.entryOfDep;
    }

    @objid ("52d7581d-87ac-40be-a31e-1855cc1b061a")
    public SmDependency getConnectionDep() {
        if (this.connectionDep == null) {
        	this.connectionDep = this.getDependencyDef("Connection");
        }
        return this.connectionDep;
    }

    @objid ("d8d53a1f-b43c-40bf-ad0a-8b72c80df7f2")
    public SmDependency getEntryOfMachineDep() {
        if (this.entryOfMachineDep == null) {
        	this.entryOfMachineDep = this.getDependencyDef("EntryOfMachine");
        }
        return this.entryOfMachineDep;
    }

    @objid ("aaa4d9f6-88f4-49b1-99e8-797b228be6ae")
    private static class EntryPointPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("b848a298-6344-43b4-a2d6-bcf47e70f06e")
        private EntryPointPseudoStateSmClass smClass;

        @objid ("1e3cd078-b87c-468f-9fa7-590063ec0781")
        public EntryPointPseudoStateObjectFactory(EntryPointPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("4e74494d-d027-4cf3-8253-8003a759f191")
        @Override
        public ISmObjectData createData() {
            return new EntryPointPseudoStateData(this.smClass);
        }

        @objid ("0eaca6b2-8c3c-4322-93c3-b34d60f67734")
        @Override
        public SmObjectImpl createImpl() {
            return new EntryPointPseudoStateImpl();
        }

    }

    @objid ("2aa915e0-20b5-4fb1-882a-9da48c19516c")
    public static class EntryOfSmDependency extends SmSingleDependency {
        @objid ("c43878ce-f773-4816-a181-f45b57b02fdd")
        private SmDependency symetricDep;

        @objid ("e0ec4e06-8edc-4075-819e-3db63a01a179")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EntryPointPseudoStateData) data).mEntryOf;
        }

        @objid ("56ed936a-f56f-4ab2-88ca-57c39d349a45")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EntryPointPseudoStateData) data).mEntryOf = value;
        }

        @objid ("8168e6be-ac7a-42ad-a226-30fc5f96b2f9")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getEntryPointDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("929d1f14-ab57-4caa-aae5-b466508ac805")
    public static class ConnectionSmDependency extends SmMultipleDependency {
        @objid ("64f04b69-c6e8-4419-9e32-f0f230e6f2f4")
        private SmDependency symetricDep;

        @objid ("013e1702-59b3-44dc-8590-e45d637cfdc9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((EntryPointPseudoStateData)data).mConnection != null)? ((EntryPointPseudoStateData)data).mConnection:SmMultipleDependency.EMPTY;
        }

        @objid ("37ff702e-a1c9-4112-b375-c4a200bd882f")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((EntryPointPseudoStateData) data).mConnection = values;

        }

        @objid ("5c03acb8-0507-4581-83fc-64c9d5e98c84")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConnectionPointReferenceSmClass)this.getTarget()).getEntryDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("fbe21536-9c9f-4964-8a78-79e544fce2ae")
    public static class EntryOfMachineSmDependency extends SmSingleDependency {
        @objid ("83f84065-f57d-4cbe-9350-687c6510aa12")
        private SmDependency symetricDep;

        @objid ("1a167a12-2912-4798-9499-031210e2680c")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((EntryPointPseudoStateData) data).mEntryOfMachine;
        }

        @objid ("4d4fb283-30a3-4c7a-a62f-87a9dff8b3b7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((EntryPointPseudoStateData) data).mEntryOfMachine = value;
        }

        @objid ("c58b7c07-1570-45e3-9649-d82dac6992b5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateMachineSmClass)this.getTarget()).getEntryPointDep();
            }
            return this.symetricDep;

        }

    }

}
