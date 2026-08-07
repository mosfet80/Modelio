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
import org.modelio.metamodel.bpmn.activities.BpmnServiceTask;
import org.modelio.metamodel.bpmn.activities.BpmnTask;
import org.modelio.metamodel.bpmn.bpmnService.BpmnOperation;
import org.modelio.metamodel.impl.bpmn.bpmnService.BpmnOperationSmClass;
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

@objid ("7fd93dec-e8fc-4871-8288-ff273df77741")
public class BpmnServiceTaskSmClass extends BpmnTaskSmClass {
    @objid ("ea629b41-9ab5-474b-acfe-e4f1546b004c")
    private SmAttribute implementationAtt;

    @objid ("7af336e9-fc3b-4b13-968b-98ea81d1233e")
    private SmDependency operationRefDep;

    @objid ("a3c25d63-9edf-4d8e-a8d9-9113f44fde49")
    public BpmnServiceTaskSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("71c5ea96-e8b5-45df-abbc-fc21c58b2753")
    @Override
    public String getName() {
        return "BpmnServiceTask";

    }

    @objid ("3cf52a7f-f460-4f5f-a6e1-55ae1b3f1655")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("fd80e9fe-42f4-4376-a8e4-39bdcd9e2905")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnServiceTask.class;

    }

    @objid ("4c0266fc-7de9-4707-8797-661d57012c11")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("de72d746-31c8-4b77-a9b7-fdb7ac019efc")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("98f0bc0d-7ea7-4d2d-a092-f4cf566e2238")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnTask.MQNAME);
        this.registerFactory(new BpmnServiceTaskObjectFactory(this));


        // Initialize and register the SmAttribute
        this.implementationAtt = new ImplementationSmAttribute();
        this.implementationAtt.init("Implementation", this, String.class );
        registerAttribute(this.implementationAtt);


        // Initialize and register the SmDependency
        this.operationRefDep = new OperationRefSmDependency();
        this.operationRefDep.init("OperationRef", this, metamodel.getMClass(BpmnOperation.MQNAME), 0, 1 , SmDirective.SMCDPARTOF);
        registerDependency(this.operationRefDep);

    }

    @objid ("1e01360c-b067-4a1b-b49c-16bf65c93414")
    public SmAttribute getImplementationAtt() {
        if (this.implementationAtt == null) {
        	this.implementationAtt = this.getAttributeDef("Implementation");
        }
        return this.implementationAtt;
    }

    @objid ("6ca06256-a043-4c05-a730-48e062dce68d")
    public SmDependency getOperationRefDep() {
        if (this.operationRefDep == null) {
        	this.operationRefDep = this.getDependencyDef("OperationRef");
        }
        return this.operationRefDep;
    }

    @objid ("9cf6e30f-ddd3-4596-9eb7-9933a574cbc6")
    private static class BpmnServiceTaskObjectFactory implements ISmObjectFactory {
        @objid ("dc23e6d8-7b65-416a-aebd-316db0652e2c")
        private BpmnServiceTaskSmClass smClass;

        @objid ("bec71010-1fcd-42d5-bf7a-b799894d28f7")
        public BpmnServiceTaskObjectFactory(BpmnServiceTaskSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("f5053ad4-f5f8-43c2-8f49-2eb87908147b")
        @Override
        public ISmObjectData createData() {
            return new BpmnServiceTaskData(this.smClass);
        }

        @objid ("54a45f0f-7a57-4364-9bac-5c9a8999fbe5")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnServiceTaskImpl();
        }

    }

    @objid ("f0d6b967-ad6a-446c-8c68-f1ca5b9280aa")
    public static class ImplementationSmAttribute extends SmAttribute {
        @objid ("02862830-22ec-449a-8dd4-21040ec432ad")
        public Object getValue(ISmObjectData data) {
            return ((BpmnServiceTaskData) data).mImplementation;
        }

        @objid ("d70df090-ab59-4a0b-b3cb-b9d1c708353a")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnServiceTaskData) data).mImplementation = value;
        }

    }

    @objid ("90ece530-bcf1-4ce8-a1b4-9079e37754df")
    public static class OperationRefSmDependency extends SmSingleDependency {
        @objid ("7b49ee1b-5fac-4854-965b-9c7f76c9b2e4")
        private SmDependency symetricDep;

        @objid ("32ac2d12-aac5-4935-8e58-3be384bbeb66")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnServiceTaskData) data).mOperationRef;
        }

        @objid ("3f02e4b7-cde7-40a1-aa80-e68c82d22564")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnServiceTaskData) data).mOperationRef = value;
        }

        @objid ("e95c660a-426d-4438-98e0-3f0891c44f54")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnOperationSmClass)this.getTarget()).getCallerDep();
            }
            return this.symetricDep;

        }

    }

}
