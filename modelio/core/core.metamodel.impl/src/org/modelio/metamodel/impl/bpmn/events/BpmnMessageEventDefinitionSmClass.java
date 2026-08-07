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
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.events.BpmnEventDefinition;
import org.modelio.metamodel.bpmn.events.BpmnMessageEventDefinition;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnOperationSmClass;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageSmClass;
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

@objid ("497c40d4-2688-4ab1-a8a2-3842dfb95504")
public class BpmnMessageEventDefinitionSmClass extends BpmnEventDefinitionSmClass {
    @objid ("2971f5ce-fe1b-4ff7-8302-2c6635968947")
    private SmDependency messageRefDep;

    @objid ("e0c0badc-940e-45ce-ba1d-d37f4d22e5ba")
    private SmDependency operationRefDep;

    @objid ("35d6e8be-ca8c-4682-8470-6fd0ef7e0d8e")
    public BpmnMessageEventDefinitionSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("7a41a209-fe30-4184-b8a5-7d00e492563d")
    @Override
    public String getName() {
        return "BpmnMessageEventDefinition";

    }

    @objid ("7dd9f95c-d8d7-49e7-b1b0-bc767e08f547")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("683d4c75-4fa0-4f10-8a1b-2428cf21f084")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnMessageEventDefinition.class;

    }

    @objid ("119d3f56-2221-4038-a3dd-9f81e0675ba3")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("f6c72b49-0589-4f65-94a4-f5f51027ef6a")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("40ad01e7-d331-4c44-9ed0-b67bc83696e0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEventDefinition.MQNAME);
        this.registerFactory(new BpmnMessageEventDefinitionObjectFactory(this));


        // Initialize and register the SmAttribute

        // Initialize and register the SmDependency
        this.messageRefDep = new MessageRefSmDependency();
        this.messageRefDep.init("MessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.messageRefDep);

        this.operationRefDep = new OperationRefSmDependency();
        this.operationRefDep.init("OperationRef", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, -1 , SmDirective.SMCDPARTOF);
        registerDependency(this.operationRefDep);

    }

    @objid ("dd6a9d28-12f3-45e1-9e87-0d33f9ba5fa1")
    public SmDependency getMessageRefDep() {
        if (this.messageRefDep == null) {
        	this.messageRefDep = this.getDependencyDef("MessageRef");
        }
        return this.messageRefDep;
    }

    @objid ("adba3489-acb4-453c-a9fd-3a569f542e4e")
    public SmDependency getOperationRefDep() {
        if (this.operationRefDep == null) {
        	this.operationRefDep = this.getDependencyDef("OperationRef");
        }
        return this.operationRefDep;
    }

    @objid ("329ea13c-8b5e-4626-90ee-09cfbf92816d")
    private static class BpmnMessageEventDefinitionObjectFactory implements ISmObjectFactory {
        @objid ("75f9f763-992f-47c1-8b34-eb753e5a3fa7")
        private BpmnMessageEventDefinitionSmClass smClass;

        @objid ("dc29c37c-8538-4689-89f7-2a3748f08544")
        public BpmnMessageEventDefinitionObjectFactory(BpmnMessageEventDefinitionSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("14d70dd8-27fe-4883-9def-b483e46ddc19")
        @Override
        public ISmObjectData createData() {
            return new BpmnMessageEventDefinitionData(this.smClass);
        }

        @objid ("aab3ecbd-80d3-47dd-8219-a00cbd7588f7")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnMessageEventDefinitionImpl();
        }

    }

    @objid ("119571a4-63b4-47b2-9d34-cbe4c0674da4")
    public static class MessageRefSmDependency extends SmSingleDependency {
        @objid ("96a9cb47-9183-42e6-af2d-313dc1797b36")
        private SmDependency symetricDep;

        @objid ("dfd2fec0-18e0-4786-8fbe-aa8ed5a219bb")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnMessageEventDefinitionData) data).mMessageRef;
        }

        @objid ("3f727b79-1667-4fae-a4bc-8289e7754277")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnMessageEventDefinitionData) data).mMessageRef = value;
        }

        @objid ("d1ced6bc-ae92-4d1c-8dad-318f549e1d43")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getEventDefinitionDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("68a88789-c095-4787-ab24-7b766b70ab31")
    public static class OperationRefSmDependency extends SmMultipleDependency {
        @objid ("2f8bcf18-6b94-412c-b93e-68eac28d8508")
        private SmDependency symetricDep;

        @objid ("16b45b56-cd52-4e5f-bdf1-9b7fed17f8e6")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnMessageEventDefinitionData)data).mOperationRef != null)? ((BpmnMessageEventDefinitionData)data).mOperationRef:SmMultipleDependency.EMPTY;
        }

        @objid ("a5c7755e-bbc3-49ca-9b9d-c3f4e1c61b6d")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnMessageEventDefinitionData) data).mOperationRef = values;

        }

        @objid ("40fac07b-20d3-4643-aa6b-075e83ed113c")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getEventDefinitionDep();
            }
            return this.symetricDep;

        }

    }

}
