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
import org.modelio.metamodel.impl.uml.behavior.commonBehaviors.BehaviorSmClass;
import org.modelio.metamodel.uml.behavior.commonBehaviors.Behavior;
import org.modelio.metamodel.uml.behavior.stateMachineModel.EntryPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.ExitPointPseudoState;
import org.modelio.metamodel.uml.behavior.stateMachineModel.KindOfStateMachine;
import org.modelio.metamodel.uml.behavior.stateMachineModel.Region;
import org.modelio.metamodel.uml.behavior.stateMachineModel.State;
import org.modelio.metamodel.uml.behavior.stateMachineModel.StateMachine;
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

@objid ("8b9c51b8-449b-4b09-a6f6-60d9ca787f80")
public class StateMachineSmClass extends BehaviorSmClass {
    @objid ("b0b99323-d495-4ff3-9580-8efd06949fad")
    private SmAttribute kindAtt;

    @objid ("07823e0e-8635-4041-b6c7-f91e15cce17e")
    private SmDependency topDep;

    @objid ("7ca769dd-9b3b-47c7-8be4-88c31b43811e")
    private SmDependency submachineStateDep;

    @objid ("8aad080a-7732-4651-be34-77a03fd7f4f0")
    private SmDependency entryPointDep;

    @objid ("15218e0c-395f-437b-951a-892b071ddd7a")
    private SmDependency exitPointDep;

    @objid ("1ee75f73-b877-4d9a-a31a-499dccbc673e")
    public StateMachineSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("9c2cf879-6042-473d-a570-da2934eb04c8")
    @Override
    public String getName() {
        return "StateMachine";

    }

    @objid ("0b43aa77-125f-499c-98e6-86ae4c7bf32d")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("079d8eb5-78ce-4198-896c-62a2ddb1f236")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return StateMachine.class;

    }

    @objid ("6da06f61-2848-4df9-945a-39a8cb00a795")
    @Override
    public boolean isCmsNode() {
        return true;

    }

    @objid ("6460bf1e-303b-4ef7-8795-7cf2ebcd4fa6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ec99114e-0198-4042-98e0-ff25f5006181")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(Behavior.MQNAME);
        this.registerFactory(new StateMachineObjectFactory(this));


        // Initialize and register the SmAttribute
        this.kindAtt = new KindSmAttribute();
        this.kindAtt.init("Kind", this, KindOfStateMachine.class );
        registerAttribute(this.kindAtt);


        // Initialize and register the SmDependency
        this.topDep = new TopSmDependency();
        this.topDep.init("Top", this, metamodel.getMClass(Region.MQNAME), 1, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.topDep);

        this.submachineStateDep = new SubmachineStateSmDependency();
        this.submachineStateDep.init("SubmachineState", this, metamodel.getMClass(State.MQNAME), 0, -1 );
        registerDependency(this.submachineStateDep);

        this.entryPointDep = new EntryPointSmDependency();
        this.entryPointDep.init("EntryPoint", this, metamodel.getMClass(EntryPointPseudoState.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.entryPointDep);

        this.exitPointDep = new ExitPointSmDependency();
        this.exitPointDep.init("ExitPoint", this, metamodel.getMClass(ExitPointPseudoState.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.exitPointDep);

    }

    @objid ("cb46554b-3bca-4cb9-8d08-95262d4f3950")
    public SmAttribute getKindAtt() {
        if (this.kindAtt == null) {
        	this.kindAtt = this.getAttributeDef("Kind");
        }
        return this.kindAtt;
    }

    @objid ("a702089f-8a93-44b3-a7ae-f1419cc7756c")
    public SmDependency getTopDep() {
        if (this.topDep == null) {
        	this.topDep = this.getDependencyDef("Top");
        }
        return this.topDep;
    }

    @objid ("4b71bf7a-33a8-400c-bffc-6e1aa1e2af09")
    public SmDependency getSubmachineStateDep() {
        if (this.submachineStateDep == null) {
        	this.submachineStateDep = this.getDependencyDef("SubmachineState");
        }
        return this.submachineStateDep;
    }

    @objid ("2ab0b729-ef5b-415d-ace8-e033403ac976")
    public SmDependency getEntryPointDep() {
        if (this.entryPointDep == null) {
        	this.entryPointDep = this.getDependencyDef("EntryPoint");
        }
        return this.entryPointDep;
    }

    @objid ("cac168e2-5200-4899-93bb-5a47b2254a04")
    public SmDependency getExitPointDep() {
        if (this.exitPointDep == null) {
        	this.exitPointDep = this.getDependencyDef("ExitPoint");
        }
        return this.exitPointDep;
    }

    @objid ("b154632e-ada2-4175-909d-0fdc0994cba5")
    private static class StateMachineObjectFactory implements ISmObjectFactory {
        @objid ("5dc58376-6cd8-4b40-9618-ff42fb52c8b5")
        private StateMachineSmClass smClass;

        @objid ("a41130e1-1f6b-4d6a-8836-e17c1ccf1f71")
        public StateMachineObjectFactory(StateMachineSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("c4c512ef-846c-4b98-a34b-725f039bd8c5")
        @Override
        public ISmObjectData createData() {
            return new StateMachineData(this.smClass);
        }

        @objid ("101e0090-9885-4f2c-98a3-cb427855a0d9")
        @Override
        public SmObjectImpl createImpl() {
            return new StateMachineImpl();
        }

    }

    @objid ("d89777ff-604f-4fb5-9028-5918cfa4d46d")
    public static class KindSmAttribute extends SmAttribute {
        @objid ("81289db6-39bc-42ba-aefc-6997ab003ba9")
        public Object getValue(ISmObjectData data) {
            return ((StateMachineData) data).mKind;
        }

        @objid ("8e4ed737-4673-4c67-88a3-52ba4109d615")
        public void setValue(ISmObjectData data, Object value) {
            ((StateMachineData) data).mKind = value;
        }

    }

    @objid ("1b9c3282-4f80-402c-8d7a-983355585fe2")
    public static class TopSmDependency extends SmSingleDependency {
        @objid ("8408dc42-7a0a-4b29-807f-bfdd4beba98e")
        private SmDependency symetricDep;

        @objid ("f924ade0-88fb-4fc1-b319-c80562d2ba03")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((StateMachineData) data).mTop;
        }

        @objid ("b4b9ac56-5520-4685-b96d-f31f6d865bcd")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((StateMachineData) data).mTop = value;
        }

        @objid ("34b96442-081c-448b-81ae-b6abe3944b00")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((RegionSmClass)this.getTarget()).getRepresentedDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("c99ee739-10a7-49b6-9cf7-89c135838890")
    public static class SubmachineStateSmDependency extends SmMultipleDependency {
        @objid ("d9e3608b-bcec-4d80-9811-dff4b1655607")
        private SmDependency symetricDep;

        @objid ("c4deb1d6-aa50-4f28-b37d-b720e1de13d8")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateMachineData)data).mSubmachineState != null)? ((StateMachineData)data).mSubmachineState:SmMultipleDependency.EMPTY;
        }

        @objid ("a907e2a0-9363-4a66-b670-9d1092fc6fed")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateMachineData) data).mSubmachineState = values;

        }

        @objid ("10486b78-9eff-4d72-a26f-a98342fa8b55")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((StateSmClass)this.getTarget()).getSubMachineDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("d6e51b6d-c7cf-4c41-8763-18b7e6295a4b")
    public static class EntryPointSmDependency extends SmMultipleDependency {
        @objid ("0e0a3781-ab4b-4475-bf55-5eac52f1ed72")
        private SmDependency symetricDep;

        @objid ("0025bf88-05f3-4e08-9b7e-7868b6ed6dba")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateMachineData)data).mEntryPoint != null)? ((StateMachineData)data).mEntryPoint:SmMultipleDependency.EMPTY;
        }

        @objid ("2a72451c-88b9-4123-9c45-22482677ecca")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateMachineData) data).mEntryPoint = values;

        }

        @objid ("7867760f-94ab-4d2e-962e-973e7ceca4ed")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((EntryPointPseudoStateSmClass)this.getTarget()).getEntryOfMachineDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("93cea68b-f00e-4fca-b143-d31e1939d5f8")
    public static class ExitPointSmDependency extends SmMultipleDependency {
        @objid ("c9f42ed8-cd1c-4646-88b0-3a70a3377606")
        private SmDependency symetricDep;

        @objid ("2895ccf9-ff45-4a38-ba5b-f74c06dea24c")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((StateMachineData)data).mExitPoint != null)? ((StateMachineData)data).mExitPoint:SmMultipleDependency.EMPTY;
        }

        @objid ("38bad536-98c9-4ca9-8277-85d59a4b752e")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((StateMachineData) data).mExitPoint = values;

        }

        @objid ("29f6b0dd-103d-444c-bce0-7e17cae9d539")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExitPointPseudoStateSmClass)this.getTarget()).getExitOfMachineDep();
            }
            return this.symetricDep;

        }

    }

}
