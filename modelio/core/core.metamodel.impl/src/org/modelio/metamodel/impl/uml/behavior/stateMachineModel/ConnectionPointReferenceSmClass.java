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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ConnectionPointReference;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateVertex;
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

@objid ("954c673f-50e5-43b4-9c35-0fb3cdbcfd12")
public class ConnectionPointReferenceSmClass extends StateVertexSmClass {
    @objid ("650e287d-7ca1-4a58-aa5c-c40063758b56")
    private SmDependency exitDep;

    @objid ("8ef4af76-750e-4400-91bc-5006f9da43ab")
    private SmDependency entryDep;

    @objid ("3b6e0dfe-1670-4b4e-b802-79ef9479b730")
    private SmDependency ownerStateDep;

    @objid ("cc9cc54f-9c19-47d4-89f6-d57ee92e9e6e")
    public ConnectionPointReferenceSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("129c9bfd-417b-4962-9b34-737dc4ba6d92")
    @Override
    public String getName() {
        return "ConnectionPointReference";

    }

    @objid ("de3fbd34-d0a0-4d9d-90e9-587b05e1b753")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("13db0a0a-3fa0-4e2e-838a-da3f8cd783ee")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ConnectionPointReference.class;

    }

    @objid ("cd1e6179-e306-49d1-af7a-fa01251bca0f")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("aa8ca6d6-acdb-465c-8706-4825ec971e3d")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("db64b89f-979e-4771-9677-78ecd6f0fa9b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(StateVertex.MQNAME);
        this.registerFactory(new ConnectionPointReferenceObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.exitDep = new ExitSmDependency();
        this.exitDep.init("Exit", this, metamodel.getMClass(ExitPointPseudoState.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.exitDep);

        this.entryDep = new EntrySmDependency();
        this.entryDep.init("Entry", this, metamodel.getMClass(EntryPointPseudoState.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.entryDep);

        this.ownerStateDep = new OwnerStateSmDependency();
        this.ownerStateDep.init("OwnerState", this, metamodel.getMClass(State.MQNAME), 0, 1 );
        registerDependency(this.ownerStateDep);

    }

    @objid ("9552bb81-ed46-4ce2-beaa-4b1c3d7059d5")
    public SmDependency getExitDep() {
        if (this.exitDep == null) {
        	this.exitDep = this.getDependencyDef("Exit");
        }
        return this.exitDep;
    }

    @objid ("55d997fc-7660-40f4-b773-dabc31370ddf")
    public SmDependency getEntryDep() {
        if (this.entryDep == null) {
        	this.entryDep = this.getDependencyDef("Entry");
        }
        return this.entryDep;
    }

    @objid ("d71dd1f7-9142-4bdc-b75a-d9bcfbd60566")
    public SmDependency getOwnerStateDep() {
        if (this.ownerStateDep == null) {
        	this.ownerStateDep = this.getDependencyDef("OwnerState");
        }
        return this.ownerStateDep;
    }

    @objid ("e184f120-7fea-488a-92bb-586b34e05e69")
    private static class ConnectionPointReferenceObjectFactory implements ISmObjectFactory {
        @objid ("3bef789e-a5be-4caf-b23d-bcb21d241a48")
        private ConnectionPointReferenceSmClass smClass;

        @objid ("018bc0cb-07db-4496-99ab-67d2743ec1a2")
        public ConnectionPointReferenceObjectFactory(ConnectionPointReferenceSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("46e63fc4-ad26-4096-990c-2ea527504082")
        @Override
        public ISmObjectData createData() {
            return new ConnectionPointReferenceData(this.smClass);
        }

        @objid ("b1080dfb-758c-4e96-8541-34a757a357b7")
        @Override
        public SmObjectImpl createImpl() {
            return new ConnectionPointReferenceImpl();
        }

    }

    @objid ("fcb7430b-15ed-49f3-ab2f-d73e6ce96c83")
    public static class ExitSmDependency extends SmSingleDependency {
        @objid ("b7f495d4-442a-4c63-b704-84c64f72b93b")
        private SmDependency symetricDep;

        @objid ("cef15413-e0bb-466a-8c37-72e5d59d7335")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ConnectionPointReferenceData) data).mExit;
        }

        @objid ("3513138e-a46c-4424-9438-c93a778d736a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ConnectionPointReferenceData) data).mExit = value;
        }

        @objid ("27675704-0edd-4bc7-a2da-129815679bf0")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExitPointPseudoStateSmClass)this.getTarget()).getConnectionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1ee19205-11cf-4ae4-a58e-972106fa3c46")
    public static class EntrySmDependency extends SmSingleDependency {
        @objid ("fde075bb-8d4a-4ca2-ba89-9b77572cc575")
        private SmDependency symetricDep;

        @objid ("2d75f36e-5108-4d53-bb6d-3fb4b53a69f9")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ConnectionPointReferenceData) data).mEntry;
        }

        @objid ("58798e9c-2628-41c0-adad-4e865cb9dfad")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ConnectionPointReferenceData) data).mEntry = value;
        }

        @objid ("aef948a8-f869-49e1-ae60-6fd3db142134")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EntryPointPseudoStateSmClass)this.getTarget()).getConnectionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1440f33f-c555-402b-98ed-95eba2ac9cdb")
    public static class OwnerStateSmDependency extends SmSingleDependency {
        @objid ("042fe893-695f-420f-a27d-51049b3d9e4c")
        private SmDependency symetricDep;

        @objid ("2da937eb-e63e-4c0b-a27f-ffab95388a17")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ConnectionPointReferenceData) data).mOwnerState;
        }

        @objid ("4372e89b-9783-4908-a6c9-3fccb24cda82")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ConnectionPointReferenceData) data).mOwnerState = value;
        }

        @objid ("a0cb7c4a-ad56-46f3-aafa-6194567a073b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getConnectionDep();
            }
            return this.symetricDep;

        }

    }

}
