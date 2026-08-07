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
package org.modelio.metamodel.impl.bpmn.gateways;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.flows.BpmnSequenceFlow;
import org.modelio.metamodel.bpmn.gateways.BpmnGateway;
import org.modelio.metamodel.bpmn.gateways.BpmnInclusiveGateway;
import org.modelio.metamodel.impl.bpmn.flows.BpmnSequenceFlowSmClass;
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

@objid ("b6cefc17-8520-4a81-aa9d-d15c52ef0901")
public class BpmnInclusiveGatewaySmClass extends BpmnGatewaySmClass {
    @objid ("b97fd58d-24c5-426c-9cc9-ce939f9706a2")
    private SmDependency defaultFlowDep;

    @objid ("3923a432-d844-484f-96f7-2660ca1c3372")
    public BpmnInclusiveGatewaySmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("0a4fba23-05c7-40f0-b8e0-6f5aef6d8574")
    @Override
    public String getName() {
        return "BpmnInclusiveGateway";

    }

    @objid ("8d29108c-985f-4512-8219-769ece4dc286")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("c89c8375-5d8e-47ac-b81a-e5a230d052dc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnInclusiveGateway.class;

    }

    @objid ("a25db3a9-f002-42e2-806d-1ec924464e55")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("3ccdeb5f-807c-49ae-9cc0-c8461e99cef9")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6961fd31-f65f-42e6-89a9-36c654447748")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnGateway.MQNAME);
        this.registerFactory(new BpmnInclusiveGatewayObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.defaultFlowDep = new DefaultFlowSmDependency();
        this.defaultFlowDep.init("DefaultFlow", this, metamodel.getMClass(BpmnSequenceFlow.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.defaultFlowDep);

    }

    @objid ("2ec11d6f-769c-43b5-949e-5cd064a42764")
    public SmDependency getDefaultFlowDep() {
        if (this.defaultFlowDep == null) {
        	this.defaultFlowDep = this.getDependencyDef("DefaultFlow");
        }
        return this.defaultFlowDep;
    }

    @objid ("276012d4-e8de-4225-9182-6a5e36a988bf")
    private static class BpmnInclusiveGatewayObjectFactory implements ISmObjectFactory {
        @objid ("3b68b47b-d2dd-4b8e-8f11-ce317a0725a6")
        private BpmnInclusiveGatewaySmClass smClass;

        @objid ("806b0ee6-1426-4a7f-97d4-2247b95093ca")
        public BpmnInclusiveGatewayObjectFactory(BpmnInclusiveGatewaySmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2431258c-4a54-4e8c-be88-3c9f5997175d")
        @Override
        public ISmObjectData createData() {
            return new BpmnInclusiveGatewayData(this.smClass);
        }

        @objid ("0d2131df-1bbd-4c78-afa5-0139cd0f9feb")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnInclusiveGatewayImpl();
        }

    }

    @objid ("e56de04b-e042-4e43-a50a-c9216bec3754")
    public static class DefaultFlowSmDependency extends SmSingleDependency {
        @objid ("347ca145-267b-4095-81d6-e467f97694b1")
        private SmDependency symetricDep;

        @objid ("851576bb-749a-4520-a807-ee4f4ceceba2")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnInclusiveGatewayData) data).mDefaultFlow;
        }

        @objid ("554c08de-a8bf-4dc4-b464-195e88bcd88b")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnInclusiveGatewayData) data).mDefaultFlow = value;
        }

        @objid ("8a7a2a78-0692-4aec-b295-4bf3ca73368d")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnSequenceFlowSmClass)this.getTarget()).getDefaultOfInclusiveDep();
            }
            return this.symetricDep;

        }

    }

}
