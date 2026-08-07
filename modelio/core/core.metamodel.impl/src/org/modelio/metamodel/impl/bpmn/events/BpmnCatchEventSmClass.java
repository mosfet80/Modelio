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
import org.modelio.metamodel.bpmn.events.BpmnCatchEvent;
import org.modelio.metamodel.bpmn.events.BpmnEvent;
import org.modelio.metamodel.bpmn.objects.BpmnDataAssociation;
import org.modelio.metamodel.bpmn.objects.BpmnDataOutput;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataAssociationSmClass;
import org.modelio.metamodel.impl.bpmn.objects.BpmnDataOutputSmClass;
import org.modelio.vbasic.version.Version;
import org.modelio.vcore.smkernel.ISmObjectData;
import org.modelio.vcore.smkernel.ISmObjectFactory;
import org.modelio.vcore.smkernel.SmObjectImpl;
import org.modelio.vcore.smkernel.mapi.MObject;
import org.modelio.vcore.smkernel.meta.ISmMetamodelFragment;
import org.modelio.vcore.smkernel.meta.SmAttribute;
import org.modelio.vcore.smkernel.meta.SmDependency;
import org.modelio.vcore.smkernel.meta.SmMetamodel;
import org.modelio.vcore.smkernel.meta.SmMultipleDependency;
import org.modelio.vcore.smkernel.meta.SmSingleDependency;
import org.modelio.vcore.smkernel.meta.smannotations.SmDirective;

@objid ("ceb33b5e-17bc-4df5-a2f8-26a0da3670c6")
public class BpmnCatchEventSmClass extends BpmnEventSmClass {
    @objid ("9de83458-4620-4069-b9f3-ee5b6bcf7e12")
    private SmAttribute parallelMultipleAtt;

    @objid ("85f6409a-448e-4768-a7f8-c95e430cbe6d")
    private SmDependency dataOutputAssociationDep;

    @objid ("86577b12-b1c1-4316-940c-aa579aac4bd6")
    private SmDependency dataOutputDep;

    @objid ("91f37ebd-a90e-431c-bba7-e70763a99c4c")
    public BpmnCatchEventSmClass(ISmMetamodelFragment origin) {
        super(origin);
    }

    @objid ("084982a6-ec5e-47d6-a804-7beaac51905f")
    @Override
    public String getName() {
        return "BpmnCatchEvent";

    }

    @objid ("a6a0e4e9-f9f7-4a06-9da7-d5d548e52cea")
    @Override
    public Version getVersion() {
        return new Version("0.0.9054");
    }

    @objid ("aff909dc-e87c-41ac-8983-08110d9367fc")
    @Override
    public java.lang.Class<? extends MObject> getJavaInterface() {
        return BpmnCatchEvent.class;

    }

    @objid ("808905e1-1707-42c0-8f0b-d5b5a0f2db0c")
    @Override
    public boolean isCmsNode() {
        return false;

    }

    @objid ("1715f607-331e-42fc-b7bb-12062d21095b")
    @Override
    public boolean isAbstract() {
        return true;

    }

    @objid ("efbd0ec1-0756-43c5-afbc-961f67b19a10")
    @Override
    public void load(SmMetamodel metamodel) {
        this.parentClass = metamodel.getMClass(BpmnEvent.MQNAME);
        this.registerFactory(new BpmnCatchEventObjectFactory(this));


        // Initialize and register the SmAttribute
        this.parallelMultipleAtt = new ParallelMultipleSmAttribute();
        this.parallelMultipleAtt.init("ParallelMultiple", this, Boolean.class );
        registerAttribute(this.parallelMultipleAtt);


        // Initialize and register the SmDependency
        this.dataOutputAssociationDep = new DataOutputAssociationSmDependency();
        this.dataOutputAssociationDep.init("DataOutputAssociation", this, metamodel.getMClass(BpmnDataAssociation.MQNAME), 0, -1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataOutputAssociationDep);

        this.dataOutputDep = new DataOutputSmDependency();
        this.dataOutputDep.init("DataOutput", this, metamodel.getMClass(BpmnDataOutput.MQNAME), 0, 1 , SmDirective.SMCDCOMPONENT);
        registerDependency(this.dataOutputDep);

    }

    @objid ("632e5dd7-64dd-4c2b-9751-53b7f2d80dbd")
    public SmAttribute getParallelMultipleAtt() {
        if (this.parallelMultipleAtt == null) {
        	this.parallelMultipleAtt = this.getAttributeDef("ParallelMultiple");
        }
        return this.parallelMultipleAtt;
    }

    @objid ("8846ffc8-4818-4577-a9ce-8917463bad80")
    public SmDependency getDataOutputAssociationDep() {
        if (this.dataOutputAssociationDep == null) {
        	this.dataOutputAssociationDep = this.getDependencyDef("DataOutputAssociation");
        }
        return this.dataOutputAssociationDep;
    }

    @objid ("c21ca990-a30b-494d-9c42-458d074e4fd0")
    public SmDependency getDataOutputDep() {
        if (this.dataOutputDep == null) {
        	this.dataOutputDep = this.getDependencyDef("DataOutput");
        }
        return this.dataOutputDep;
    }

    @objid ("68606b46-bb57-4698-8791-bd4153817fa8")
    private static class BpmnCatchEventObjectFactory implements ISmObjectFactory {
        @objid ("cc57568b-e1a6-469a-aa7e-4cee33450bc1")
        private BpmnCatchEventSmClass smClass;

        @objid ("1d74ac17-3923-4161-8da3-609676fbc966")
        public BpmnCatchEventObjectFactory(BpmnCatchEventSmClass smClass) {
            this.smClass = smClass;
        }

        @objid ("2a344b61-a9b8-424a-8d25-fcb817f4a5bf")
        @Override
        public ISmObjectData createData() {
            throw new UnsupportedOperationException();
        }

        @objid ("c804ee5c-517b-41a6-b3f5-0642fc999c17")
        @Override
        public SmObjectImpl createImpl() {
            throw new UnsupportedOperationException();
        }

    }

    @objid ("72153169-5128-4378-a1e8-3fe3decb6946")
    public static class ParallelMultipleSmAttribute extends SmAttribute {
        @objid ("1e5cdc6e-703f-4fa5-8854-a6fce3b7e3f6")
        public Object getValue(ISmObjectData data) {
            return ((BpmnCatchEventData) data).mParallelMultiple;
        }

        @objid ("be234ca8-5679-48f2-8d03-74513562736f")
        public void setValue(ISmObjectData data, Object value) {
            ((BpmnCatchEventData) data).mParallelMultiple = value;
        }

    }

    @objid ("c41c6528-82cb-4c14-b048-218aa92c20f2")
    public static class DataOutputAssociationSmDependency extends SmMultipleDependency {
        @objid ("aa2bbf7c-f2e3-4d18-b492-27cbb4864207")
        private SmDependency symetricDep;

        @objid ("6e13253b-0d21-48ad-8cfa-e70256ef4806")
        @Override
        public List<SmObjectImpl> getValueList(ISmObjectData data) {
            return (((BpmnCatchEventData)data).mDataOutputAssociation != null)? ((BpmnCatchEventData)data).mDataOutputAssociation:SmMultipleDependency.EMPTY;
        }

        @objid ("89681e51-f525-4495-aacd-bed928e1a9f4")
        @Override
        protected void initValueList(ISmObjectData data, List<SmObjectImpl> values) {
            ((BpmnCatchEventData) data).mDataOutputAssociation = values;

        }

        @objid ("f22b2772-0ed6-4487-9fa4-3562142d4429")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataAssociationSmClass)this.getTarget()).getEndingEventDep();
            }
            return this.symetricDep;

        }

    }

    @objid ("24e94ebc-652a-48fa-95a7-539170e99a62")
    public static class DataOutputSmDependency extends SmSingleDependency {
        @objid ("35b7d873-6c35-43ea-ac73-b6d1124f8261")
        private SmDependency symetricDep;

        @objid ("8570b8dd-46d7-4e8a-add6-1e071926c546")
        @Override
        public SmObjectImpl getValue(ISmObjectData data) {
            return ((BpmnCatchEventData) data).mDataOutput;
        }

        @objid ("b5e13ed6-34af-4c22-bfeb-541be70c224d")
        @Override
        public void setValue(ISmObjectData data, SmObjectImpl value) {
            ((BpmnCatchEventData) data).mDataOutput = value;
        }

        @objid ("de8ba295-ac40-4891-a0a6-1e72b90b01ef")
        @Override
        public SmDependency getSymetric() {
            if (this.symetricDep == null) {
            	this.symetricDep = ((BpmnDataOutputSmClass)this.getTarget()).getCatchedDep();
            }
            return this.symetricDep;

        }

    }

}
