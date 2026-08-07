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
import org.modelio.metamodel.bpmn.activities.BpmnReceiveTask;
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

@objid ("93a2c0de-6f98-4374-9fa7-dc48f0ae1bd7")
public class BpmnReceiveTaskSmClass extends BpmnTaskSmClass {
    @objid ("fe4ae95f-69d9-435d-8468-ad5c75b20825")
    private SmAttribute implementationAtt;

    @objid ("7536a4b0-4b02-4496-a01c-3fa702066ffd")
    private SmAttribute instanciateAtt;

    @objid ("67c5082d-57ea-4e83-afd3-16b9679854c7")
    private SmDependency messageRefDep;

    @objid ("701a78cf-5743-4580-b16f-bb2ffe12a399")
    private SmDependency operationRefDep;

    @objid ("4b005106-7b8f-4f9e-854c-7b65c0d50d91")
    public BpmnReceiveTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("16a6eaa4-b4cf-411e-85b0-0d57e42bc04a")
    @Override
    public String getName() {
        return "BpmnReceiveTask";

    }

    @objid ("83b285bb-1c34-4e9c-8de3-9dc73f7e0845")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("9547d497-357f-490f-ba99-156ec696f0b2")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnReceiveTask.class;

    }

    @objid ("1aee664f-9a6c-46c4-ad6e-4f9620ae4b6c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("afe8e354-a029-43a3-a8e5-679078c10100")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("6f086517-62c8-492b-980f-f403846bb0e4")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnReceiveTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.implementationAtt = new ImplementationSmAttribute();
        this.implementationAtt.init("Implementation", this, String.class );
        registerAttribute(this.implementationAtt);

        this.instanciateAtt = new InstanciateSmAttribute();
        this.instanciateAtt.init("Instanciate", this, Boolean.class );
        registerAttribute(this.instanciateAtt);


        // Initialize and register the SmDependency
        this.messageRefDep = new MessageRefSmDependency();
        this.messageRefDep.init("MessageRef", this, metamodel.getMClass(BpmnMessage.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.messageRefDep);

        this.operationRefDep = new OperationRefSmDependency();
        this.operationRefDep.init("OperationRef", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.operationRefDep);

    }

    @objid ("d5005296-0fd9-4fc1-994f-eb2fae0a0c2e")
    public SmAttribute getImplementationAtt() {
        if (this.implementationAtt == null) {
        	this.implementationAtt = this.getAttributeDef("Implementation");
        }
        return this.implementationAtt;
    }

    @objid ("0ae68735-4f33-4b0e-acf6-c13eb28639ab")
    public SmAttribute getInstanciateAtt() {
        if (this.instanciateAtt == null) {
        	this.instanciateAtt = this.getAttributeDef("Instanciate");
        }
        return this.instanciateAtt;
    }

    @objid ("637788f2-49da-46ca-98c8-0397d9108fe4")
    public SmDependency getMessageRefDep() {
        if (this.messageRefDep == null) {
        	this.messageRefDep = this.getDependencyDef("MessageRef");
        }
        return this.messageRefDep;
    }

    @objid ("a4855f02-be99-46de-9eaa-0c53311ea54c")
    public SmDependency getOperationRefDep() {
        if (this.operationRefDep == null) {
        	this.operationRefDep = this.getDependencyDef("OperationRef");
        }
        return this.operationRefDep;
    }

    @objid ("26320e90-a096-4617-9376-402e1c6fa403")
    private static class BpmnReceiveTaskObjectFactory implements ISmObjectFactory {
        @objid ("b91cfc58-a227-4194-a908-b1f4fa2c987f")
        private BpmnReceiveTaskSmClass smClass;

        @objid ("2d561417-eb77-4b93-8ba7-c5bb29fdaec6")
        public BpmnReceiveTaskObjectFactory(BpmnReceiveTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("04292f0d-2d5e-4966-90cb-d3c37cb92682")
        @Override
        public ISmObjectData createData() {
            return new BpmnReceiveTaskData(this.smClass);
        }

        @objid ("1039046b-aa20-4be1-80bb-7d558d24ac84")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnReceiveTaskImpl();
        }

    }

    @objid ("09c2e8e9-e165-4fc9-aec7-4543bce875a1")
    public static class ImplementationSmAttribute extends SmAttribute {
        @objid ("5dc11175-b2ae-4443-8a5b-ab7306f8e4b7")
        public Object getValue(ISmObjectData data) {
            return ((BpmnReceiveTaskData) data).mImplementation;
        }

        @objid ("f6a4bddb-21fd-4f37-85f0-891523553eaa")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnReceiveTaskData) data).mImplementation = value;
        }

    }

    @objid ("0e2d0131-74b8-4fd0-94af-642987e8e783")
    public static class InstanciateSmAttribute extends SmAttribute {
        @objid ("fecda176-8886-4613-872d-859a192a3de5")
        public Object getValue(ISmObjectData data) {
            return ((BpmnReceiveTaskData) data).mInstanciate;
        }

        @objid ("b6e3690f-7fd6-40cb-967a-4058b9d4ceb6")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnReceiveTaskData) data).mInstanciate = value;
        }

    }

    @objid ("5540b663-2994-4b10-b061-4d402925ac53")
    public static class MessageRefSmDependency extends SmSingleDependency {
        @objid ("c9004b51-8e97-4e5f-af42-94c7842c416a")
        private SmDependency symetricDep;

        @objid ("2159acd9-1c1c-4194-a629-f6f92469d4aa")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnReceiveTaskData) data).mMessageRef;
        }

        @objid ("c21761dd-d2a9-4418-b70c-9677cdafe826")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnReceiveTaskData) data).mMessageRef = value;
        }

        @objid ("da57e8c8-f159-4122-a8e2-3d06035090fc")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMessageSmClass)this.getTarget()).getReceiverDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("f7074a04-a605-47fb-ad01-816892b50f21")
    public static class OperationRefSmDependency extends SmSingleDependency {
        @objid ("14fe8ab7-1c2f-4fca-bc00-fc432785818a")
        private SmDependency symetricDep;

        @objid ("5e9fce95-9ca3-4d54-a876-4cedfa4921e1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnReceiveTaskData) data).mOperationRef;
        }

        @objid ("7ce2a537-0f63-4395-b26e-ffd5c0e380b1")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnReceiveTaskData) data).mOperationRef = value;
        }

        @objid ("ab2a54d1-5b58-49ff-a105-4bee784adfbe")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getReceiverDep();
            }
            return this.symetricDep;

        }

    }

}
