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
package org.modelio.metamodel.impl.bpmn.events;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnLinkEventDefinition;
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

@objid ("7350b35c-294e-4083-ad55-23949813f2c1")
public class BpmnLinkEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("289376e1-4173-4b48-963b-10cfa1baa795")
    private SmDependency sourceDep;

    @objid ("c828f43b-5c58-4378-b9db-4a77ec3d7f1f")
    private SmDependency targetDep;

    @objid ("f6e082c8-ec21-4fd2-bbff-94c0a7796d7b")
    public BpmnLinkEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("f71370e6-d74f-499b-a290-fadae1434436")
    @Override
    public String getName() {
        return "BpmnLinkEventDefinition";

    }

    @objid ("7cc236ee-c6dd-48e1-b787-5078db9e24d8")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("ff6679a3-ea24-4f3b-8d48-e195b8c965ba")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnLinkEventDefinition.class;

    }

    @objid ("06ecc183-fecf-4ab2-bad1-709676a3c95e")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("10ebe3e4-d649-4122-b33e-31f2a5fe3c17")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("ad527643-7fd9-4914-8e9a-9cf79154592b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnLinkEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.sourceDep = new SourceSmDependency();
        this.sourceDep.init("Source", this, metamodel.getMClass(BpmnLinkEventDefinition.MQNAME), 1, -1 );
        registerDependency(this.sourceDep);

        this.targetDep = new TargetSmDependency();
        this.targetDep.init("Target", this, metamodel.getMClass(BpmnLinkEventDefinition.MQNAME), 1, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.targetDep);

    }

    @objid ("b122d082-f2ca-48b7-948f-9e08bf8581a5")
    public SmDependency getSourceDep() {
        if (this.sourceDep == null) {
        	this.sourceDep = this.getDependencyDef("Source");
        }
        return this.sourceDep;
    }

    @objid ("656e5f6c-9bab-4c4f-b152-710a84c7b5f0")
    public SmDependency getTargetDep() {
        if (this.targetDep == null) {
        	this.targetDep = this.getDependencyDef("Target");
        }
        return this.targetDep;
    }

    @objid ("49174d0a-8f63-4321-b375-236b28d981ca")
    private static class BpmnLinkEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("c93e085f-8fa7-4f22-b192-2d37c0531565")
        private BpmnLinkEventDefinitionSmClass smClass;

        @objid ("13d4cae0-ec37-4136-9e10-5cbfb17e7ad9")
        public BpmnLinkEventDefinitionObjectFactory(BpmnLinkEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("772874d7-aff7-4b3a-ac78-8458a32b6598")
        @Override
        public ISmObjectData createData() {
            return new BpmnLinkEventDefinitionData(this.smClass);
        }

        @objid ("f89041c2-7c8f-481e-be81-01131ee64244")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnLinkEventDefinitionImpl();
        }

    }

    @objid ("31d8c948-8f67-4b2a-b2b3-e3cc74e8ce06")
    public static class SourceSmDependency extends SmMultipleDependency {
        @objid ("73cbd9ea-50aa-4efc-adcd-8745874d2d85")
        private SmDependency symetricDep;

        @objid ("73db0dab-0cf0-4760-9b7e-20ced8f90ed9")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnLinkEventDefinitionData)data).mSource != null)? ((BpmnLinkEventDefinitionData)data).mSource:SmMultipleDependency.EMPTY;
        }

        @objid ("5cb2f559-5426-4d17-8645-135264ee5483")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnLinkEventDefinitionData) data).mSource = values;

        }

        @objid ("0e88c4c7-8fb9-48c8-9845-75887b3abd8b")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLinkEventDefinitionSmClass)this.getTarget()).getTargetDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e4e89453-8523-42ec-8d67-487c49fe01f0")
    public static class TargetSmDependency extends SmSingleDependency {
        @objid ("4389946c-774f-4ea2-ad50-a7a56149701e")
        private SmDependency symetricDep;

        @objid ("48dab826-8dae-4af9-81a7-bf3fbfa5aeb2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnLinkEventDefinitionData) data).mTarget;
        }

        @objid ("c9d9e163-0b19-4863-a81a-348a7500cc9d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnLinkEventDefinitionData) data).mTarget = value;
        }

        @objid ("6a0e89de-6ce3-4579-99c2-39642a8b244d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnLinkEventDefinitionSmClass)this.getTarget()).getSourceDep();
            }
            return this.symetricDep;

        }

    }

}
