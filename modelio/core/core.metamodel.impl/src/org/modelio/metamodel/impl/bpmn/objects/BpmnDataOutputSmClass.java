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
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.metamodel.impl.bpmn.activities.BpmnActivitySmClass;
import org.modelio.metamodel.impl.bpmn.activities.BpmnMultiInstanceLoopCharacteristicsSmClass;
import org.modelio.metamodel.impl.bpmn.events.BpmnCatchEventSmClass;
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

@objid ("27dfd40d-8eb0-4c4b-9f14-bb8971a44059")
public class BpmnDataOutputSmClass extends BpmnItemAwareElementSmClass {
    @objid ("056d9a52-d495-4e2f-a69f-117abf1ed6f1")
    private SmAttribute isCollectionAtt;

    @objid ("e2db9a6b-d4a8-4f5e-b1ae-acd56250fd9b")
    private SmDependency ownerActivityDep;

    @objid ("d28b7c35-cf95-4e0f-bb42-3faf7db0b9ee")
    private SmDependency catchedDep;

    @objid ("5b291f85-2d77-4d51-91a1-444cd68532d9")
    private SmDependency ownerLoopCharacteristicsDep;

    @objid ("0e50e923-33c8-47fe-8948-026f27bed0b1")
    public BpmnDataOutputSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("7019b0e5-100d-4732-9701-9144d504dafe")
    @Override
    public String getName() {
        return "BpmnDataOutput";

    }

    @objid ("0f910a98-cc4b-49ff-a1ff-86d1dd78fd1f")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("d0d77e07-3bcf-4fd7-be1d-7c4d12e7e2c7")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataOutput.class;

    }

    @objid ("5ed7a0f8-81c3-4fd4-a78a-5d59133f1615")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("dad55d2a-02ae-40b1-b31f-8c970a50a34c")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("04ef84d7-6568-4d9b-b153-76682734f82f")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnItemAwareElement.MQNAME);
        this.registerFactory(new BpmnDataOutputObjectFactory(this));


        // Initialize and register the SmAttribute
        this.isCollectionAtt = new IsCollectionSmAttribute();
        this.isCollectionAtt.init("IsCollection", this, Boolean.class );
        registerAttribute(this.isCollectionAtt);


        // Initialize and register the SmDependency
        this.ownerActivityDep = new OwnerActivitySmDependency();
        this.ownerActivityDep.init("OwnerActivity", this, metamodel.getMClass(BpmnActivity.MQNAME), 0, 1 );
        registerDependency(this.ownerActivityDep);

        this.catchedDep = new CatchedSmDependency();
        this.catchedDep.init("Catched", this, metamodel.getMClass(BpmnCatchEvent.MQNAME), 0, 1 );
        registerDependency(this.catchedDep);

        this.ownerLoopCharacteristicsDep = new OwnerLoopCharacteristicsSmDependency();
        this.ownerLoopCharacteristicsDep.init("OwnerLoopCharacteristics", this, metamodel.getMClass(BpmnMultiInstanceLoopCharacteristics.MQNAME), 0, 1 );
        registerDependency(this.ownerLoopCharacteristicsDep);

    }

    @objid ("4bc8e7f3-9c63-4a62-b862-df4f343971e4")
    public SmAttribute getIsCollectionAtt() {
        if (this.isCollectionAtt == null) {
        	this.isCollectionAtt = this.getAttributeDef("IsCollection");
        }
        return this.isCollectionAtt;
    }

    @objid ("6b243c13-5922-4fbd-b6b3-8af7c3325231")
    public SmDependency getOwnerActivityDep() {
        if (this.ownerActivityDep == null) {
        	this.ownerActivityDep = this.getDependencyDef("OwnerActivity");
        }
        return this.ownerActivityDep;
    }

    @objid ("b2b3ba1e-ff2b-4d6e-bd93-771cdbe39329")
    public SmDependency getCatchedDep() {
        if (this.catchedDep == null) {
        	this.catchedDep = this.getDependencyDef("Catched");
        }
        return this.catchedDep;
    }

    @objid ("844e2ffb-06da-4231-834d-3565f07d8ff8")
    public SmDependency getOwnerLoopCharacteristicsDep() {
        if (this.ownerLoopCharacteristicsDep == null) {
        	this.ownerLoopCharacteristicsDep = this.getDependencyDef("OwnerLoopCharacteristics");
        }
        return this.ownerLoopCharacteristicsDep;
    }

    @objid ("eb8523f4-fe3f-4fbf-9397-146e5e275157")
    private static class BpmnDataOutputObjectFactory implements ISmObjectFactory {
        @objid ("a2afbe55-da6b-4a16-a210-6ff9cca9b51e")
        private BpmnDataOutputSmClass smClass;

        @objid ("87618188-a721-4087-b6a0-5b45c490d43c")
        public BpmnDataOutputObjectFactory(BpmnDataOutputSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("3b69c3e1-19de-4726-9bff-5bde07efa93c")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataOutputData(this.smClass);
        }

        @objid ("76f79971-c7a7-4952-abf7-07cdee124b62")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataOutputImpl();
        }

    }

    @objid ("d50c9caf-f9b1-4334-8313-e94bafdfa12e")
    public static class IsCollectionSmAttribute extends SmAttribute {
        @objid ("a06c85b9-c3ef-4505-baf9-b985157ae8bf")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataOutputData) data).mIsCollection;
        }

        @objid ("131f52b9-1a4d-48a2-b5ad-6c31d25e753d")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataOutputData) data).mIsCollection = value;
        }

    }

    @objid ("3dd1d0e1-2252-4453-8d9a-ba21250532ae")
    public static class OwnerActivitySmDependency extends SmSingleDependency {
        @objid ("4b0ce389-1905-43ab-982a-66cb5a6e0664")
        private SmDependency symetricDep;

        @objid ("40a77e0c-7cae-4d3e-994c-f76ace6e22b1")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataOutputData) data).mOwnerActivity;
        }

        @objid ("97b0a201-1a9f-4f56-a715-524793c18ab5")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataOutputData) data).mOwnerActivity = value;
        }

        @objid ("a89c3f2f-5e53-46fb-a5d8-cfed9e5e4b89")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnActivitySmClass)this.getTarget()).getOutputSpecificationDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("e143bacb-1319-4a7d-927c-3e1ca6cdb503")
    public static class CatchedSmDependency extends SmSingleDependency {
        @objid ("306054cf-b36f-4cee-aa5a-530bbdfa61d7")
        private SmDependency symetricDep;

        @objid ("86c4a269-b153-417e-99f7-da873209c1ff")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataOutputData) data).mCatched;
        }

        @objid ("5a8d43f3-5582-4f53-82e3-adc08cabc90d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataOutputData) data).mCatched = value;
        }

        @objid ("defcb5df-cf56-4ac1-8096-cc8737eb5a92")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnCatchEventSmClass)this.getTarget()).getDataOutputDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("abfff458-ba4e-4364-ace5-1b0e244f7bae")
    public static class OwnerLoopCharacteristicsSmDependency extends SmSingleDependency {
        @objid ("08d1c84c-afa0-4c77-8489-dfb8f2309639")
        private SmDependency symetricDep;

        @objid ("ef48d3b0-4ec4-49c6-8930-fff3d3844042")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnDataOutputData) data).mOwnerLoopCharacteristics;
        }

        @objid ("f423d0da-7e96-4cbb-a06f-f86af6babb17")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnDataOutputData) data).mOwnerLoopCharacteristics = value;
        }

        @objid ("2e4b454e-aeb6-4800-9a64-337dca3d4a22")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnMultiInstanceLoopCharacteristicsSmClass)this.getTarget()).getLoopDataOutputRefDep();
            }
            return this.symetricDep;

        }

    }

}
