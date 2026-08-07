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
import org.modelio.metamodel.bpmn.objects.BpmnDataStore;
import org.modelio.metamodel.bpmn.objects.BpmnItemAwareElement;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("82e03360-b636-46dc-9bf6-0bd95319cbe0")
public class BpmnDataStoreSmClass extends BpmnItemAwareElementSmClass {
    @objid ("e49b276c-6690-4a7b-88c6-6f2969886b1b")
    private SmAttribute capacityAtt;

    @objid ("26e37184-022d-497d-9b15-a948daaed51d")
    private SmAttribute isUnlimitedAtt;

    @objid ("dc3d3ff5-b42c-4c23-8065-952bc537dd7c")
    public BpmnDataStoreSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("5143f528-5fab-4fe9-952e-90a401702fd7")
    @Override
    public String getName() {
        return "BpmnDataStore";

    }

    @objid ("8d111b40-171f-4ffb-8178-1b9a314bcb41")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("204a8593-7906-4df7-95f7-372f9d58aed3")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnDataStore.class;

    }

    @objid ("58918002-d5eb-4f9f-82b0-e068b659da08")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("e620a6df-b81a-4e40-a598-05aafd331e55")
    @Override
    public boolean isAbstract() {
        return false;

    }

    @objid ("fde7a6dc-70ab-4b69-b286-0117921094df")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnItemAwareElement.MQNAME);
        this.registerFactory(new BpmnDataStoreObjectFactory(this));


        // Initialize and register the SmAttribute
        this.capacityAtt = new CapacitySmAttribute();
        this.capacityAtt.init("Capacity", this, Integer.class );
        registerAttribute(this.capacityAtt);

        this.isUnlimitedAtt = new IsUnlimitedSmAttribute();
        this.isUnlimitedAtt.init("IsUnlimited", this, Boolean.class );
        registerAttribute(this.isUnlimitedAtt);


        // Initialize and register the SmDependency

    }

    @objid ("3aea3005-c3b3-4287-9162-7c5b84d89778")
    public SmAttribute getCapacityAtt() {
        if (this.capacityAtt == null) {
        	this.capacityAtt = this.getAttributeDef("Capacity");
        }
        return this.capacityAtt;
    }

    @objid ("4033e897-6016-4680-9f80-429473517c75")
    public SmAttribute getIsUnlimitedAtt() {
        if (this.isUnlimitedAtt == null) {
        	this.isUnlimitedAtt = this.getAttributeDef("IsUnlimited");
        }
        return this.isUnlimitedAtt;
    }

    @objid ("d4b8a89e-d3e0-4f08-ac58-573fc94ee5cd")
    private static class BpmnDataStoreObjectFactory implements ISmObjectFactory {
        @objid ("49a59376-821c-4b7a-bd5f-64a225c8a97a")
        private BpmnDataStoreSmClass smClass;

        @objid ("c09a9d15-cc8a-4836-836c-733fe5639763")
        public BpmnDataStoreObjectFactory(BpmnDataStoreSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("45c5d22f-7040-4e1a-9933-47bd9845fcb3")
        @Override
        public ISmObjectData createData() {
            return new BpmnDataStoreData(this.smClass);
        }

        @objid ("3a820fe3-e3f0-4a0b-a015-13c44fd40e1a")
        @Override
        public SmObjectImpl createImpl() {
            return new BpmnDataStoreImpl();
        }

    }

    @objid ("83fbc10d-f307-4e42-8ae4-b19bcb18a860")
    public static class CapacitySmAttribute extends SmAttribute {
        @objid ("ca8296e3-ff9a-4695-b994-98aa5dd2a580")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataStoreData) data).mCapacity;
        }

        @objid ("8f2205c9-59d1-4213-8b7e-ba828f333308")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataStoreData) data).mCapacity = value;
        }

    }

    @objid ("b7b85ecf-cbf3-40f7-b641-b51570ee0a94")
    public static class IsUnlimitedSmAttribute extends SmAttribute {
        @objid ("53f770f2-1b68-4e65-8be6-a91cf221f1e6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnDataStoreData) data).mIsUnlimited;
        }

        @objid ("d9e91ec7-f89e-4381-bd1d-b9370514374b")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnDataStoreData) data).mIsUnlimited = value;
        }

    }

}
