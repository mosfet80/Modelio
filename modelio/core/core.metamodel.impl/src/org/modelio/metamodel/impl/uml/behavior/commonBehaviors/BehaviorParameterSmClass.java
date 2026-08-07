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
package org.modelio.metamodel.impl.uml.behavior.commonBehaviors;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.impl.uml.behavior.activityModel.ObjectNodeSmClass;
import org.modelio.metamodel.impl.uml.statik.ParameterSmClass;
import org.modelio.metamodel.uml.behavior.activityModel.ObjectNode;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.commonBehaviors.BehaviorParameter;
import org.modelio.metamodel.uml.statik.Parameter;
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

@objid ("46048f4c-2fa7-4169-baf7-3fc00502e63d")
public class BehaviorParameterSmClass extends ParameterSmClass {
    @objid ("145d1719-c677-40de-9a86-28ce992dd856")
    private SmDependency representingObjectNodeDep;

    @objid ("6fb977e9-c065-459a-abbe-3f09552f74a6")
    private SmDependency ownerDep;

    @objid ("ab68c81c-c246-4f05-8775-bf69a1f46292")
    private SmDependency mappedDep;

    @objid ("4d1dd48d-bdf5-45c4-a686-71d15362513b")
    public BehaviorParameterSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9d303c85-c7f2-41df-a485-c1b497896baa")
    @Override
    public String getName() {
        return "BehaviorParameter";

    }

    @objid ("ccf24bbd-9407-4270-8be9-b3462b659c88")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("0e2adcad-9242-4b1b-8de3-ae80abd73415")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BehaviorParameter.class;

    }

    @objid ("3666d138-17c2-4ae5-85ba-aa7132e2d15d")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3941d68e-7d70-4ce4-a6c0-dc43003c6871")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("56a9dd21-cc03-4896-9193-62d8b0943b2c")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Parameter.MQNAME);
        this.registerFactory(new BehaviorParameterObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.representingObjectNodeDep = new RepresentingObjectNodeSmDependency();
        this.representingObjectNodeDep.init("RepresentingObjectNode", this, metamodel.getMClass(ObjectNode.MQNAME), 0, -1 );
        registerDependency(this.representingObjectNodeDep);

        this.ownerDep = new OwnerSmDependency();
        this.ownerDep.init("Owner", this, metamodel.getMClass(Behavior.MQNAME), 0, 1 );
        registerDependency(this.ownerDep);

        this.mappedDep = new MappedSmDependency();
        this.mappedDep.init("Mapped", this, metamodel.getMClass(Parameter.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.mappedDep);

    }

    @objid ("754d888e-9fb5-4d62-a97d-a1a8d31cba41")
    public SmDependency getRepresentingObjectNodeDep() {
        if (this.representingObjectNodeDep == null) {
        	this.representingObjectNodeDep = this.getDependencyDef("RepresentingObjectNode");
        }
        return this.representingObjectNodeDep;
    }

    @objid ("9b9a4cfa-6d4c-44e6-a1c6-88ad14da55cc")
    public SmDependency getOwnerDep() {
        if (this.ownerDep == null) {
        	this.ownerDep = this.getDependencyDef("Owner");
        }
        return this.ownerDep;
    }

    @objid ("10a9b861-1d6a-4195-b753-48210386cc3b")
    public SmDependency getMappedDep() {
        if (this.mappedDep == null) {
        	this.mappedDep = this.getDependencyDef("Mapped");
        }
        return this.mappedDep;
    }

    @objid ("1804ef67-b056-4d0f-96bf-2c120d61cfe4")
    private static class BehaviorParameterObjectFactory implements ISmObjectFactory {
        @objid ("097321e7-54dc-4e31-b9d7-a3cb647981b5")
        private BehaviorParameterSmClass smClass;

        @objid ("732976fa-1414-41e5-ae25-0f7b220fdbba")
        public BehaviorParameterObjectFactory(BehaviorParameterSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("09131df1-7123-4084-9736-a44e0b5d8d18")
        @Override
        public ISmObjectData createData() {
            return new BehaviorParameterData(this.smClass);
        }

        @objid ("1e1651d7-3904-4650-841d-a7fc3efd80b9")
        @Override
        public SmObjectImpl createImpl() {
            return new BehaviorParameterImpl();
        }

    }

    @objid ("78275c04-c102-4238-82dd-8e4e39ce2ca2")
    public static class RepresentingObjectNodeSmDependency extends SmMultipleDependency {
        @objid ("9c1fb4fb-b388-47bb-8d37-42bc6f70adab")
        private SmDependency symetricDep;

        @objid ("a021c32a-6821-4fac-9f7a-c64798f258b2")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BehaviorParameterData)data).mRepresentingObjectNode != null)? ((BehaviorParameterData)data).mRepresentingObjectNode:SmMultipleDependency.EMPTY;
        }

        @objid ("e7459a49-15bf-4643-b3b2-e962b338b869")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BehaviorParameterData) data).mRepresentingObjectNode = values;

        }

        @objid ("b3541d70-3fad-4e89-a17f-93fb94a35e4c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ObjectNodeSmClass)this.getTarget()).getRepresentedRealParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("1f588389-2af8-4e78-994c-5eabc0034ce4")
    public static class OwnerSmDependency extends SmSingleDependency {
        @objid ("2447dab2-5394-4819-a062-28971c5cc91a")
        private SmDependency symetricDep;

        @objid ("4a64843c-5eb4-4e3e-9611-ba51b6c2bed2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BehaviorParameterData) data).mOwner;
        }

        @objid ("b5b5e3f8-040b-45c2-ad4f-b2f242f0b3a7")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BehaviorParameterData) data).mOwner = value;
        }

        @objid ("1baa74ef-78ae-4326-a008-db86eccd9dcc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BehaviorSmClass)this.getTarget()).getParameterDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("777fed32-b770-4eb7-b412-963a8b663b2b")
    public static class MappedSmDependency extends SmSingleDependency {
        @objid ("9b972cf6-e5f9-45c7-849b-073414640901")
        private SmDependency symetricDep;

        @objid ("28659bd2-1adf-4050-8d6b-7db557f0f87d")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BehaviorParameterData) data).mMapped;
        }

        @objid ("01d10445-7d07-41cc-823e-7687be6f58a5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BehaviorParameterData) data).mMapped = value;
        }

        @objid ("f2a4750b-ec5d-44da-8f6b-cda4410405b2")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ParameterSmClass)this.getTarget()).getBehaviorParamDep();
            }
            return this.symetricDep;

        }

    }

}
