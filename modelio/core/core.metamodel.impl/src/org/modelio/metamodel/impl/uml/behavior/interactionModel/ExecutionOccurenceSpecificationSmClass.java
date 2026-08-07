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
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionOccurenceSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.ExecutionSpecification;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageEnd;
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

@objid ("06fe4006-f9b7-4e49-920f-8f0fd75a1fdd")
public class ExecutionOccurenceSpecificationSmClass extends MessageEndSmClass {
    @objid ("940569ff-a25d-4d0d-b152-5dc223d7260b")
    private SmDependency finishedDep;

    @objid ("8e3a0ef8-cdb0-4ae3-9e25-703f023d2df8")
    private SmDependency startedDep;

    @objid ("e04eb179-6760-4b10-a64f-8526b0e45c5f")
    public ExecutionOccurenceSpecificationSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("de7ead6a-060d-4bc7-b3ca-79536f958fc1")
    @Override
    public String getName() {
        return "ExecutionOccurenceSpecification";

    }

    @objid ("d9e6dc65-6a93-44cd-b299-0c286dc68ce9")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("293727e3-af08-457f-aa7a-2fef3dce7646")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return ExecutionOccurenceSpecification.class;

    }

    @objid ("f751cbb6-36dc-4caa-928f-41f063aaa949")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("696ba339-5f81-4a74-87a4-7b683246dac1")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e1c431c6-db23-4378-b2dd-e2f1e9346415")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(MessageEnd.MQNAME);
        this.registerFactory(new ExecutionOccurenceSpecificationObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.finishedDep = new FinishedSmDependency();
        this.finishedDep.init("Finished", this, metamodel.getMClass(ExecutionSpecification.MQNAME), 0, 1 , SmDirective.SMCDTODELETE);
        registerDependency(this.finishedDep);

        this.startedDep = new StartedSmDependency();
        this.startedDep.init("Started", this, metamodel.getMClass(ExecutionSpecification.MQNAME), 0, 1 , SmDirective.SMCDPARTOF, SmDirective.SMCDTODELETE);
        registerDependency(this.startedDep);

    }

    @objid ("e970ab38-1b3e-4c0a-9a0e-67df9ec94981")
    public SmDependency getFinishedDep() {
        if (this.finishedDep == null) {
        	this.finishedDep = this.getDependencyDef("Finished");
        }
        return this.finishedDep;
    }

    @objid ("9f5a5abc-96f1-4270-afb5-45ffed9cb89d")
    public SmDependency getStartedDep() {
        if (this.startedDep == null) {
        	this.startedDep = this.getDependencyDef("Started");
        }
        return this.startedDep;
    }

    @objid ("bd19f5ca-bbfa-49cd-88b0-47e4637f0e64")
    private static class ExecutionOccurenceSpecificationObjectFactory implements ISmObjectFactory {
        @objid ("9f2c6f45-dcb5-4b7c-a06f-674f3f8895b8")
        private ExecutionOccurenceSpecificationSmClass smClass;

        @objid ("b5f8fdee-983f-4020-a998-919e06352d69")
        public ExecutionOccurenceSpecificationObjectFactory(ExecutionOccurenceSpecificationSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("b6be7f67-0b2b-4298-9484-b5997cbb254a")
        @Override
        public ISmObjectData createData() {
            return new ExecutionOccurenceSpecificationData(this.smClass);
        }

        @objid ("086185ca-abfb-438e-8b42-dd42caf63c6a")
        @Override
        public SmObjectImpl createImpl() {
            return new ExecutionOccurenceSpecificationImpl();
        }

    }

    @objid ("450a7ac6-3101-4492-a4ad-1ba8f5b1aed8")
    public static class FinishedSmDependency extends SmSingleDependency {
        @objid ("c04b85db-0cfa-4fdd-a037-2678f73aba70")
        private SmDependency symetricDep;

        @objid ("be3753c3-67f0-40e6-aa81-88960a20ade2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExecutionOccurenceSpecificationData) data).mFinished;
        }

        @objid ("9ef86747-13f4-458a-9861-443e932b038a")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExecutionOccurenceSpecificationData) data).mFinished = value;
        }

        @objid ("eb88fbb0-356d-4ea6-a0d5-783b84822061")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExecutionSpecificationSmClass)this.getTarget()).getFinishDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("7cd06869-bc74-4774-86a3-b92aa8908a95")
    public static class StartedSmDependency extends SmSingleDependency {
        @objid ("5d2b05b4-d3e9-4006-83f8-17b050b7fb33")
        private SmDependency symetricDep;

        @objid ("3e970ea6-34be-4d3e-9dea-be20f87197d6")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((ExecutionOccurenceSpecificationData) data).mStarted;
        }

        @objid ("96b22abb-951c-47a1-a92b-e5e4920d2374")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((ExecutionOccurenceSpecificationData) data).mStarted = value;
        }

        @objid ("d414a34a-9f03-4495-bf15-90c1b05da353")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((ExecutionSpecificationSmClass)this.getTarget()).getStartDep();
            }
            return this.symetricDep;

        }

    }

}
