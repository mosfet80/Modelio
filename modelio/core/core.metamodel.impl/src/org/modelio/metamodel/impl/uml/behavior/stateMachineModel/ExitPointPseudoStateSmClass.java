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
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
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

@objid ("72567f2c-7474-4d71-b8d7-a1e8576d3aa1")
public class ExitPointPseudoStateSmClass extends AbstractPseudoStateSmClass {
    @objid ("20662e09-1311-4664-8b14-36e2f4c6af01")
    private SmDependency exitOfDep;

    @objid ("22fa6208-9841-410f-ba3d-60afde1e274e")
    private SmDependency connectionDep;

    @objid ("5fec1117-d3a6-4cb1-9a80-41d9b3740943")
    private SmDependency exitOfMachineDep;

    @objid ("ceb03cde-c032-4e42-a6b0-439f0319081c")
    public ExitPointPseudoStateSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("af19ac40-eb6a-4f2b-8884-7d94060c3bec")
    @Override
    public String getName() {
        return "ExitPointPseudoState";

    }

    @objid ("cdbdbd63-8d69-4d86-938d-21871345177e")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("f0516219-16fd-4690-84fb-bd6890961e06")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExitPointPseudoState.class;

    }

    @objid ("3938b18c-d637-4b39-824a-bbdd59a5f8d5")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("9e3aa67b-5161-4246-ad4e-4a5be9c55a48")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("0f699d1f-fa7c-45f2-aaaa-827d86a6f6b4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(AbstractPseudoState.MQNAME);
        this.registerFactory(new ExitPointPseudoStateObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.exitOfDep = new ExitOfSmDependency();
        this.exitOfDep.init("ExitOf", this, metamodel.getMClass(State.MQNAME), 0, 1 );
        registerDependency(this.exitOfDep);

        this.connectionDep = new ConnectionSmDependency();
        this.connectionDep.init("Connection", this, metamodel.getMClass(ConnectionPointReference.MQNAME), 0, -1 );
        registerDependency(this.connectionDep);

        this.exitOfMachineDep = new ExitOfMachineSmDependency();
        this.exitOfMachineDep.init("ExitOfMachine", this, metamodel.getMClass(StateMachine.MQNAME), 0, 1 );
        registerDependency(this.exitOfMachineDep);

    }

    @objid ("f65a58d0-b59d-4deb-bb67-200c131003cf")
    public SmDependency getExitOfDep() {
        if (this.exitOfDep == null) {
        	this.exitOfDep = this.getDependencyDef("ExitOf");
        }
        return this.exitOfDep;
    }

    @objid ("35a5dd04-e90c-4608-bd70-9708ebb6fc9e")
    public SmDependency getConnectionDep() {
        if (this.connectionDep == null) {
        	this.connectionDep = this.getDependencyDef("Connection");
        }
        return this.connectionDep;
    }

    @objid ("4b5f0e97-bc21-49dc-987e-b20cde3db905")
    public SmDependency getExitOfMachineDep() {
        if (this.exitOfMachineDep == null) {
        	this.exitOfMachineDep = this.getDependencyDef("ExitOfMachine");
        }
        return this.exitOfMachineDep;
    }

    @objid ("4b7d4a34-cc76-4246-9479-6e9499360581")
    private static class ExitPointPseudoStateObjectFactory implements ISmObjectFactory {
        @objid ("b22e02b3-60d5-4180-8b6a-76bddb9eebfe")
        private ExitPointPseudoStateSmClass smClass;

        @objid ("0aac8684-8a02-4eeb-8be2-7e739aba7c15")
        public ExitPointPseudoStateObjectFactory(ExitPointPseudoStateSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("fcac87d0-ec30-46fc-a744-c0295cf667d5")
        @Override
        public ISmObjectData createData() {
            return new ExitPointPseudoStateData(this.smClass);
        }

        @objid ("8a6151b2-24d7-4d15-8b04-0dc9c5685097")
        @Override
        public SmObjectImpl createImpl() {
            return new ExitPointPseudoStateImpl();
        }

    }

    @objid ("e37a9cb6-0803-4ba9-bcd0-c602ded50ab2")
    public static class ExitOfSmDependency extends SmSingleDependency {
        @objid ("17e0a561-df5e-4868-adee-4ce240c04b7d")
        private SmDependency symetricDep;

        @objid ("ef60f4f6-aa72-47ed-a925-3a1c799b33ed")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExitPointPseudoStateData) data).mExitOf;
        }

        @objid ("c52a0d46-3a65-4d76-848d-15a56f02ef50")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExitPointPseudoStateData) data).mExitOf = value;
        }

        @objid ("1709543f-737c-46ab-baf1-8963176dae46")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getExitPointDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("97ecd351-1154-431b-848f-04df724da19d")
    public static class ConnectionSmDependency extends SmMultipleDependency {
        @objid ("87cd35ae-6e03-4977-b11b-51d334c8a635")
        private SmDependency symetricDep;

        @objid ("3d83e9d7-2d05-4638-9df1-25bd9855a847")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((ExitPointPseudoStateData)data).mConnection != null)? ((ExitPointPseudoStateData)data).mConnection:SmMultipleDependency.EMPTY;
        }

        @objid ("88d63d21-ad79-4cdc-9fdd-6af45929df43")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((ExitPointPseudoStateData) data).mConnection = values;

        }

        @objid ("b72e6367-768a-47c8-b5d9-ac23ba10f196")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ConnectionPointReferenceSmClass)this.getTarget()).getExitDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("59571b81-ec24-442d-b2bc-d879695633d7")
    public static class ExitOfMachineSmDependency extends SmSingleDependency {
        @objid ("2f15991e-7577-4c8d-806e-e8c790bcf4f8")
        private SmDependency symetricDep;

        @objid ("886adb40-0585-4df3-8900-46095e4896a3")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExitPointPseudoStateData) data).mExitOfMachine;
        }

        @objid ("a1f783c4-3ca1-4dd9-b12e-1412b28f0a4e")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExitPointPseudoStateData) data).mExitOfMachine = value;
        }

        @objid ("a1356084-723e-4c10-b6b4-7689d79dd6cf")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateMachineSmClass)this.getTarget()).getExitPointDep();
            }
            return this.symetricDep;

        }

    }

}
