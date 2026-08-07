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
package org.modelio.metamodel.impl.bpmn.objects;

import java.util.ArrayList;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.metamodel.bpmn.activities.BpmnActivity;
import org.modelio.metamodel.bpmn.activities.BpmnMultiInstanceLoopCharacteristics;
import org.modelio.metamodel.bpmn.events.BpmnThrowEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataInput;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.metamodel.impl.bpmn.activities.BpmnMultiInstanceLoopCharacteristicsSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnThrowEventSmClass;
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

@objid ("3fc273f8-4522-4900-b978-5df64f292140")
public class BpmnDataInputSmClass extends BpmnItemAwareElementSmClass {
    @objid ("a190188d-0ccc-432e-9161-9c66f243968f")
    private SmAttribute isCollectionAtt;

    @objid ("0bd01c9f-9d7b-4776-9efa-82feecd39f60")
    private SmDependency ownerLoopCharacteristicsDep;

    @objid ("4c3c810a-90a7-4a45-bea6-81f52a964028")
    private SmDependency ownerActivityDep;

    @objid ("370106ea-862f-49d1-8652-3caea4c8c2a7")
    private SmDependency ownerThrowEventDep;

    @objid ("e8b617bb-5f51-4a18-a876-859dde1a57ca")
    public BpmnDataInputSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("235eb62a-6da6-44fe-8a52-62210107d474")
    @Override
    public String getName() {
        return "BpmnDataInput";

    }

    @objid ("bad67645-1093-4fcb-8f75-157acb868a51")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("47a7f544-503a-426f-a43c-809ae837c209")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataInput.class;

    }

    @objid ("cd47f554-df27-4efb-85c3-aa2344a35c9c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("18cb7c16-1b09-428b-8397-9ab1e6dee75c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("e56aeb47-e898-4ca6-9931-3a48f303801b")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnItemAwareElement.MQNAME);
        this.registerFactory(new BpmnDataInputObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isCollectionAtt = new IsCollectionSmAttribute();
        this.isCollectionAtt.init("IsCollection", this, Boolean.class );
        registerAttribute(this.isCollectionAtt);


        // Initialize and register the SmDependency
        this.ownerLoopCharacteristicsDep = new OwnerLoopCharacteristicsSmDependency();
        this.ownerLoopCharacteristicsDep.init("OwnerLoopCharacteristics", this, metamodel.getMClass(BpmnMultiInstanceLoopCharacteristics.MQNAME), 0, 1 );
        registerDependency(this.ownerLoopCharacteristicsDep);

        this.ownerActivityDep = new OwnerActivitySmDependency();
        this.ownerActivityDep.init("OwnerActivity", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 );
        registerDependency(this.ownerActivityDep);

        this.ownerThrowEventDep = new OwnerThrowEventSmDependency();
        this.ownerThrowEventDep.init("OwnerThrowEvent", this, metamodel.getMClass(BpmnThrowEvent.MQNAME), 0, 1 );
        registerDependency(this.ownerThrowEventDep);

    }

    @objid ("85d0b28b-7b1b-43a7-8dea-eb6fb83af7c8")
    public SmAttribute getIsCollectionAtt() {
        if (this.isCollectionAtt == null) {
        	this.isCollectionAtt = this.getAttributeDef("IsCollection");
        }
        return this.isCollectionAtt;
    }

    @objid ("c44d0ff2-fd3d-4a27-bdfe-9fe2999ef5da")
    public SmDependency getOwnerLoopCharacteristicsDep() {
        if (this.ownerLoopCharacteristicsDep == null) {
        	this.ownerLoopCharacteristicsDep = this.getDependencyDef("OwnerLoopCharacteristics");
        }
        return this.ownerLoopCharacteristicsDep;
    }

    @objid ("92cd5734-f473-410d-8fa8-4d2411946897")
    public SmDependency getOwnerActivityDep() {
        if (this.ownerActivityDep == null) {
        	this.ownerActivityDep = this.getDependencyDef("OwnerActivity");
        }
        return this.ownerActivityDep;
    }

    @objid ("4389df15-3207-43f3-a62c-d68406f9ca20")
    public SmDependency getOwnerThrowEventDep() {
        if (this.ownerThrowEventDep == null) {
        	this.ownerThrowEventDep = this.getDependencyDef("OwnerThrowEvent");
        }
        return this.ownerThrowEventDep;
    }

    @objid ("c0e5f33c-73da-4395-802f-f6de599f924d")
    private static class BpmnDataInputObjectFactory implements ISmObjectFactory {
        @objid ("2993c9d7-24d5-483d-b110-33ee2bbdf02c")
        private BpmnDataInputSmClass smClass;

        @objid ("12ae9259-88d8-451d-be59-7d77cfefa141")
        public BpmnDataInputObjectFactory(BpmnDataInputSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("9767e311-e593-41ad-8bff-f35bd2b6abb3")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataInputData(this.smClass);
        }

        @objid ("d38eae8f-e122-4350-9f0a-cf820ffdab1d")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataInputImpl();
        }

    }

    @objid ("0a95aa92-c9be-428d-8be5-4588c8d6ea5d")
    public static class IsCollectionSmAttribute extends SmAttribute {
        @objid ("41399abb-3d1c-48c5-8390-956829a01d4a")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataInputData) data).mIsCollection;
        }

        @objid ("cd861e6f-a8c4-44e8-94cf-a399c0d4ae4a")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataInputData) data).mIsCollection = value;
        }

    }

    @objid ("41115a8a-c3eb-44fa-a2aa-4d25f82fa4cf")
    public static class OwnerLoopCharacteristicsSmDependency extends SmSingleDependency {
        @objid ("969089c8-0652-42c7-a94d-ad338d855b84")
        private SmDependency symetricDep;

        @objid ("803ecfdf-7432-4f25-ab79-dd84dd1db0ff")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataInputData) data).mOwnerLoopCharacteristics;
        }

        @objid ("6bcc1ca3-688b-49d4-8477-f86c61d7d631")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataInputData) data).mOwnerLoopCharacteristics = value;
        }

        @objid ("3423b260-9893-4173-a877-c3341325f114")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMultiInstanceLoopCharacteristicsSmClass)this.getTarget()).getLoopDataInputDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("762a0eea-6c73-4b98-9290-cd8ecb53edc7")
    public static class OwnerActivitySmDependency extends SmSingleDependency {
        @objid ("ff8c5d9e-b828-4d6c-b444-69ce5ea85269")
        private SmDependency symetricDep;

        @objid ("a6eb4824-06f5-4937-930e-28426bb10126")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataInputData) data).mOwnerActivity;
        }

        @objid ("25905d32-d33d-44cf-9080-9d35a9b16ec3")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataInputData) data).mOwnerActivity = value;
        }

        @objid ("ea2a162e-6ab9-496d-a7e4-44b1fe9bf3a3")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getInputSpecificationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("29c3ac51-5f70-4d37-b6f2-0f1e06050c7e")
    public static class OwnerThrowEventSmDependency extends SmSingleDependency {
        @objid ("2c11d6e6-7768-432c-9520-f808e7e36eb3")
        private SmDependency symetricDep;

        @objid ("4803006c-a975-497b-a3e5-514b2ed60bb8")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataInputData) data).mOwnerThrowEvent;
        }

        @objid ("145aa260-35e0-49a5-8cb2-266c60ce4ac8")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataInputData) data).mOwnerThrowEvent = value;
        }

        @objid ("de7952d5-26b8-4038-a905-31f3ea651e75")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnThrowEventSmClass)this.getTarget()).getDataInputDep();
            }
            return this.symetricDep;

        }

    }

}
