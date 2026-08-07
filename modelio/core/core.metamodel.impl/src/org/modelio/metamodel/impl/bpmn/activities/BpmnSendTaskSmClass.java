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
package org.modelio.metamodel.impl.bpmn.activities;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnSendTask;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.bpmn.flows.BpmnMessage;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnOperationSmClass;
import org.modelio.metamodel.impl.bpmn.flows.BpmnMessageSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("036bd8e7-e725-4cb4-89a6-00823472c340")
public class BpmnSendTaskSmClass extends BpmnTaskSmClass {
    @objid ("7596084a-e7a3-4bb5-864a-9d8b2b712acc")
    private SmAttribute implementationAtt;

    @objid ("7244ff24-b8e7-4edb-a96c-2e861f448fdb")
    private SmDependency messageRefDep;

    @objid ("65b969f5-061e-4c50-9caa-838176144a56")
    private SmDependency operationRefDep;

    @objid ("34c35af9-0ec8-4918-8cbc-629d972b73c7")
    public BpmnSendTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("15e906b8-ccef-43de-9e35-3394572607b4")
    @Override
    public String getName() {
        return "BpmnSendTask";

    }

    @objid ("779ea00b-3e5c-4ff8-92e4-540a613e902c")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("3296586b-792d-4ad6-a89d-9dca66058d9d")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnSendTask.class;

    }

    @objid ("794c5d79-220f-4189-9c17-fb415a2b4e78")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("84d20338-91ab-4f4b-90aa-607bcfd17cb6")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("a2bec235-e050-4227-b848-e24cf6e91bc0")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnSendTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.implementationAtt = new ImplementationSmAttribute();
        this.implementationAtt.init("Implementation", this, String.class );
        registerAttribute(this.implementationAtt);


        // Initialize and register the SmDependency
        this.messageRefDep = new MessageRefSmDependency();
        this.messageRefDep.init("MessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.messageRefDep);

        this.operationRefDep = new OperationRefSmDependency();
        this.operationRefDep.init("OperationRef", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.operationRefDep);

    }

    @objid ("ce146a3a-6cca-40d4-a8fc-3a129d895dc9")
    public SmAttribute getImplementationAtt() {
        if (this.implementationAtt == null) {
        	this.implementationAtt = this.getAttributeDef("Implementation");
        }
        return this.implementationAtt;
    }

    @objid ("d323fbb4-38dc-4fe3-9bcc-834e4cbb4ead")
    public SmDependency getMessageRefDep() {
        if (this.messageRefDep == null) {
        	this.messageRefDep = this.getDependencyDef("MessageRef");
        }
        return this.messageRefDep;
    }

    @objid ("0177aa8d-900f-425e-830c-fd83120721b8")
    public SmDependency getOperationRefDep() {
        if (this.operationRefDep == null) {
        	this.operationRefDep = this.getDependencyDef("OperationRef");
        }
        return this.operationRefDep;
    }

    @objid ("78776911-fb62-491d-ae29-9b7221eac4b4")
    private static class BpmnSendTaskObjectFactory implements ISmObjectFactory {
        @objid ("4980bbd5-e61b-48c4-a92e-2c590a9e5b35")
        private BpmnSendTaskSmClass smClass;

        @objid ("9ae0efb8-551b-4c4e-affe-e232feb1cbad")
        public BpmnSendTaskObjectFactory(BpmnSendTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("108a6b52-6fcb-45e2-9cf3-3873ade1b586")
        @Override
        public ISmObjectData createData() {
            return new BpmnSendTaskData(this.smClass);
        }

        @objid ("b883ae1c-40d6-4d77-8341-5383376b398d")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnSendTaskImpl();
        }

    }

    @objid ("92743483-76d3-4879-a517-dd87a1d1e5e9")
    public static class ImplementationSmAttribute extends SmAttribute {
        @objid ("d9fce420-00da-4b2b-8fd2-e7e45325bb8b")
        public Object getValue(ISmObjectData data) {
            return ((BpmnSendTaskData) data).mImplementation;
        }

        @objid ("c3cba158-5368-4ed3-82df-3453b203b8d7")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnSendTaskData) data).mImplementation = value;
        }

    }

    @objid ("c0dfdc44-915a-4127-b15a-c097a8e19837")
    public static class MessageRefSmDependency extends SmSingleDependency {
        @objid ("e4a2cd0c-c0e1-4342-a433-a47405520759")
        private SmDependency symetricDep;

        @objid ("ce1c43c2-8585-4c66-8ffe-315bca5f6cce")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSendTaskData) data).mMessageRef;
        }

        @objid ("6b9e3022-1716-41ef-a585-6203d8cc5920")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSendTaskData) data).mMessageRef = value;
        }

        @objid ("5ba43cbf-c64c-454f-bcb6-ef26602337e5")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getSenderDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("63fc90d8-d1d3-4f27-b69f-2496aa90d7fb")
    public static class OperationRefSmDependency extends SmSingleDependency {
        @objid ("5014f530-6ae6-4dc2-b87a-5017cb92bb58")
        private SmDependency symetricDep;

        @objid ("c4eee26c-8f31-47ca-99c5-2794a7be57ed")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnSendTaskData) data).mOperationRef;
        }

        @objid ("a2f6e907-112b-4510-abae-87028cc4cb2f")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnSendTaskData) data).mOperationRef = value;
        }

        @objid ("45f92104-9ce2-4573-a877-2a022bf51ee7")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getSenderDep();
            }
            return this.symetricDep;

        }

    }

}
